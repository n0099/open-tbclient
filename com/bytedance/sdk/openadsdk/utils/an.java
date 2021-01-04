package com.bytedance.sdk.openadsdk.utils;

import com.baidu.android.imsdk.retrieve.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public class an {
    public static List<File> a(String str, String str2) throws IOException {
        return a(str, str2, (String) null);
    }

    public static List<File> a(String str, String str2, String str3) throws IOException {
        return a(a(str), a(str2), str3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4] */
    public static List<File> a(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (b(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.contains(Constants.PATH_PARENT)) {
                        u.d("ZipUtils", "entryName: " + name + " is dangerous!");
                    } else if (!a(file2, arrayList, zipFile, nextElement, name)) {
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement2 = entries.nextElement();
                    String name2 = nextElement2.getName();
                    if (name2.contains(Constants.PATH_PARENT)) {
                        u.d("ZipUtils", "entryName: " + name2 + " is dangerous!");
                    } else if (name2.contains(str) && !a(file2, arrayList, zipFile, nextElement2, name2)) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } finally {
            zipFile.close();
        }
    }

    private static boolean a(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return a(file2);
        }
        if (b(file2)) {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return true;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return false;
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (a(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private static File a(String str) {
        if (b(str)) {
            return null;
        }
        return new File(str);
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
