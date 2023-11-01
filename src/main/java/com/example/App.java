package com.example;

import net.sf.jasperreports.engine.*;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        try {
            JasperReport jasperReport2 = JasperCompileManager.compileReport("src/main/resources/hello.jrxml");      
		    JasperPrint jasperPrint2 =  JasperFillManager.fillReport(jasperReport2, new HashMap(), new JREmptyDataSource());      
			JasperExportManager.exportReportToPdfFile(jasperPrint2, "HelloJasper.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
