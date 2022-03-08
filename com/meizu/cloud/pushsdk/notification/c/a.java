package com.meizu.cloud.pushsdk.notification.c;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes8.dex */
public class a {
    public static void a(String str, String str2) {
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i2 = 0; i2 < list.length; i2++) {
                File file = str.endsWith(File.separator) ? new File(str + list[i2]) : new File(str + File.separator + list[i2]);
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName().toString());
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                } else if (file.isDirectory()) {
                    a(str + "/" + list[i2], str2 + "/" + list[i2]);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean b(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isFile()) {
                    z = a(listFiles[i2].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = b(listFiles[i2].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                }
            }
            if (z) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    public static File[] b(String str, final String str2) {
        File file = new File(str);
        return file.isDirectory() ? file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.notification.c.a.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                try {
                    return Long.valueOf(str2).longValue() > Long.valueOf(file2.getName().split("-")[1]).longValue();
                } catch (Exception e2) {
                    c.k.a.a.a.b("FileUtil", "filters file error " + e2.getMessage());
                    return true;
                }
            }
        }) : new File[0];
    }
}
