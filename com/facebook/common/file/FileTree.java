package com.facebook.common.file;

import java.io.File;
/* loaded from: classes9.dex */
public class FileTree {
    public static String sMaxLengthFileName;

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                z &= deleteRecursively(file2);
            }
        }
        return z;
    }

    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }

    public static File[] filenamesToFiles(File file, String[] strArr) {
        String path = file.getPath();
        int length = strArr.length;
        File[] fileArr = new File[length];
        for (int i = 0; i < length; i++) {
            fileArr[i] = new File(getSubFilePath(path, strArr[i]));
        }
        return fileArr;
    }

    public static String getSubFilePath(String str, String str2) {
        if (str.isEmpty()) {
            return str2;
        }
        if (str2.isEmpty()) {
            return str;
        }
        return join(str, str2);
    }

    public static File[] listFiles(File file, String[] strArr) {
        if (file != null && strArr != null && strArr.length != 0) {
            return filenamesToFiles(file, strArr);
        }
        return null;
    }

    public static String join(String str, String str2) {
        boolean z;
        int length = str.length();
        boolean z2 = false;
        if (length > 0 && str.charAt(length - 1) == File.separatorChar) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (str2.length() > 0 && str2.charAt(0) == File.separatorChar) {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length() + 1);
        sb2.append(str);
        sb2.append(File.separatorChar);
        sb2.append(str2);
        return sb2.toString();
    }

    public static void walkFileTree(File file, FileTreeVisitor fileTreeVisitor) {
        File[] listFiles;
        fileTreeVisitor.preVisitDirectory(file);
        try {
            listFiles = file.listFiles();
        } catch (OutOfMemoryError unused) {
            System.gc();
            listFiles = listFiles(file, file.list());
        }
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    walkFileTree(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.visitFile(file2);
                    String path = file2.getPath();
                    if (path != null) {
                        if (sMaxLengthFileName == null) {
                            sMaxLengthFileName = path;
                        } else if (path.length() > sMaxLengthFileName.length()) {
                            sMaxLengthFileName = path;
                        }
                    }
                }
            }
        }
        fileTreeVisitor.postVisitDirectory(file);
    }
}
