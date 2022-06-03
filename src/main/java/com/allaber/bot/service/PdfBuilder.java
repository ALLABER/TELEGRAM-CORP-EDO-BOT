package com.allaber.bot.service;

import com.allaber.bot.repository.Employee;
import com.ibm.icu.text.Transliterator;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfBuilder {


    public InputFile generateDocument(Employee employee) {
        File file = new File("/home/allaber/dev/idea/TelegramCorpEdoBot/src/main/java/com/allaber/bot/blank.pdf");
        try {
            PDDocument document = PDDocument.load(file);

//            PDFont font = PDType1Font.HELVETICA;
//            PDResources res = new PDResources();
//            COSName fontName = res.add(font);

//            PDFont formFont = PDType0Font.load(doc, new FileInputStream("c:/windows/fonts/somefont.ttf"), false); // check that the font has what you need; ARIALUNI.TTF is good but huge
//            PDResources res = acroForm.getDefaultResources(); // could be null, if so, then create it with the setter
//            String fontName = res.add(formFont).getName();
//            String defaultAppearanceString = "/" + fontName + " 0 Tf 0 g"; // adjust to replace existing font name
//            textField.setDefaultAppearance(defaultAppearanceString);



            PDFont font1 = PDType0Font.load( document, new File( "/home/allaber/dev/idea/TelegramCorpEdoBot/src/main/java/com/allaber/bot/times_new_roman.ttf" ) );

            PDFont font = PDType0Font.load(document, new FileInputStream("/home/allaber/dev/idea/TelegramCorpEdoBot/src/main/java/com/allaber/bot/times_new_roman.ttf"), false);
            PDResources res = new PDResources();
            COSName fontName = res.add(font1);


            PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();
            acroForm.setDefaultResources(res);

            acroForm.setDefaultResources(res);
            String da = "/" + fontName.getName() + " 12 Tf 0 g";
            acroForm.setDefaultAppearance(da);

            if (acroForm != null)
            {
                PDField field1 = acroForm.getField( "fio" );
                String test_fio = employee.getName() + " " + employee.getLastname();

                Transliterator toLatinTrans = Transliterator.getInstance("Cyrillic-Latin");
                String result = toLatinTrans.transliterate(test_fio);

                field1.setValue("test_fio");


                PDField field2 = acroForm.getField( "id" );
                String test_id = String.valueOf(employee.getId());
                field2.setValue("test_id");
            }

            document.save(file);
            document.close();
            return new InputFile(file, "Заявление на отпуск.pdf");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
