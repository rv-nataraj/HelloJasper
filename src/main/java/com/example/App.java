package com.example;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        // try {
        //     JasperReport jasperReport2 = JasperCompileManager.compileReport("src/main/resources/hello.jrxml");      
		//     JasperPrint jasperPrint2 =  JasperFillManager.fillReport(jasperReport2, new HashMap(), new JREmptyDataSource());      
		// 	JasperExportManager.exportReportToPdfFile(jasperPrint2, "HelloJasper.pdf");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        try {
            // Create a new JasperDesign
            JasperDesign jasperDesign = new JasperDesign();

            // Set up report properties
            jasperDesign.setName("HelloWorldReport");
            jasperDesign.setPageWidth(595);
            jasperDesign.setPageHeight(842);
            jasperDesign.setColumnWidth(555);
            jasperDesign.setColumnSpacing(0);
            jasperDesign.setLeftMargin(20);
            jasperDesign.setRightMargin(20);
            jasperDesign.setTopMargin(20);
            jasperDesign.setBottomMargin(20);

            // Create title band
            JRDesignBand titleBand = new JRDesignBand();
            titleBand.setHeight(50);

            // Create static text element
            JRDesignStaticText staticText = new JRDesignStaticText();
            staticText.setX(0);
            staticText.setY(10);
            staticText.setWidth(100);
            staticText.setHeight(30);
            staticText.setText("Hello World!");
            //staticText.setHorizontalTextAlign(HorizontalAlignEnum.CENTER);

            // Add static text to title band
            titleBand.addElement(staticText);

            // Set title band to JasperDesign
            jasperDesign.setTitle(titleBand);

            // Compile the JasperDesign
            JasperReport jr=JasperCompileManager.compileReport(jasperDesign);//.compileReportToFile(jasperDesign, "HelloWorldReport.jasper");
            JasperPrint jasperPrint2 =  JasperFillManager.fillReport(jr, new HashMap(), new JREmptyDataSource());      
		    JasperExportManager.exportReportToPdfFile(jasperPrint2, "HelloJasper2.pdf");

            System.out.println("Report successfully generated!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    



    }
}
