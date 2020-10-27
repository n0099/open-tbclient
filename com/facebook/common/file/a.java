package com.facebook.common.file;

import java.io.File;
/* loaded from: classes6.dex */
public class a {
    public static String oBI = null;

    public static void a(File file, b bVar) {
        File[] b;
        bVar.ak(file);
        try {
            b = file.listFiles();
        } catch (OutOfMemoryError e) {
            System.gc();
            b = b(file, file.list());
        }
        if (b != null) {
            for (File file2 : b) {
                if (file2.isDirectory()) {
                    a(file2, bVar);
                } else {
                    bVar.al(file2);
                    String path = file2.getPath();
                    if (path != null) {
                        if (oBI == null) {
                            oBI = path;
                        } else if (path.length() > oBI.length()) {
                            oBI = path;
                        }
                    }
                }
            }
        }
        bVar.am(file);
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                boolean as = as(listFiles[i]) & z;
                i++;
                z = as;
            }
        }
        return z;
    }

    public static boolean as(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }

    private static File[] b(File file, String[] strArr) {
        if (file == null || strArr == null || strArr.length == 0) {
            return null;
        }
        return c(file, strArr);
    }

    private static File[] c(File file, String[] strArr) {
        String path = file.getPath();
        int length = strArr.length;
        File[] fileArr = new File[length];
        for (int i = 0; i < length; i++) {
            fileArr[i] = new File(gU(path, strArr[i]));
        }
        return fileArr;
    }

    private static String gU(String str, String str2) {
        if (str.isEmpty()) {
            return str2;
        }
        return str2.isEmpty() ? str : gV(str, str2);
    }

    private static String gV(String str, String str2) {
        boolean z = true;
        int length = str.length();
        boolean z2 = length > 0 && str.charAt(length + (-1)) == File.separatorChar;
        if (z2) {
            z = z2;
        } else if (str2.length() <= 0 || str2.charAt(0) != File.separatorChar) {
            z = false;
        }
        if (z) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            sb.append(str).append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length() + 1);
        sb2.append(str).append(File.separatorChar).append(str2);
        return sb2.toString();
    }
}
