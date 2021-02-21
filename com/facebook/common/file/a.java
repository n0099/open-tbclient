package com.facebook.common.file;

import java.io.File;
/* loaded from: classes6.dex */
public class a {
    public static String pzl = null;

    public static void a(File file, b bVar) {
        File[] b2;
        bVar.ao(file);
        try {
            b2 = file.listFiles();
        } catch (OutOfMemoryError e) {
            System.gc();
            b2 = b(file, file.list());
        }
        if (b2 != null) {
            for (File file2 : b2) {
                if (file2.isDirectory()) {
                    a(file2, bVar);
                } else {
                    bVar.ap(file2);
                    String path = file2.getPath();
                    if (path != null) {
                        if (pzl == null) {
                            pzl = path;
                        } else if (path.length() > pzl.length()) {
                            pzl = path;
                        }
                    }
                }
            }
        }
        bVar.aq(file);
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                z &= aw(file2);
            }
        }
        return z;
    }

    public static boolean aw(File file) {
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
            fileArr[i] = new File(hs(path, strArr[i]));
        }
        return fileArr;
    }

    private static String hs(String str, String str2) {
        if (str.isEmpty()) {
            return str2;
        }
        return str2.isEmpty() ? str : ht(str, str2);
    }

    private static String ht(String str, String str2) {
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
