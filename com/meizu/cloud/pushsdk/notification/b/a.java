package com.meizu.cloud.pushsdk.notification.b;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes2.dex */
public class a {
    public static void a(String str, String str2) {
        File file;
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i = 0; i < list.length; i++) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + list[i]);
                } else {
                    file = new File(str + File.separator + list[i]);
                }
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
                    a(str + "/" + list[i], str2 + "/" + list[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static File[] b(String str, final String str2) {
        File file = new File(str);
        File[] fileArr = new File[0];
        if (file != null && file.isDirectory()) {
            return file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.notification.b.a.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    try {
                        return Long.valueOf(str2).longValue() > Long.valueOf(file2.getName().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]).longValue();
                    } catch (Exception e) {
                        com.meizu.cloud.a.a.e("FileUtil", "filters file error " + e.getMessage());
                        return true;
                    }
                }
            });
        }
        return fileArr;
    }

    public static boolean b(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    z = a(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = b(listFiles[i].getAbsolutePath());
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
}
