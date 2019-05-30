package com.swj;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class main {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\test.zip");
        OutputStream os = new FileOutputStream(file);
        ZipOutputStream zos = null;
        zos = new ZipOutputStream(os);
        try {
            String path = "D:\\ps";
            File file1 = new File(path);
            
            //zipUtil.toZip(path, os, true);
            zipUtil.compress(file1, zos, file1.getName(), true);

        } catch (Exception e) {

            throw new RuntimeException("zip error from ZipUtils", e);

        } finally {

            zos.closeEntry();
            zos.close();
            os.close();

        }

    }

}
