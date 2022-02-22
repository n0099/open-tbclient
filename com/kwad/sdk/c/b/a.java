package com.kwad.sdk.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes4.dex */
public class a {
    public static File a(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return filesDir;
    }

    public static String a(Context context, String str) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2 + File.separator + str;
    }

    public static void a(String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                q.b(zipInputStream);
                return;
            }
            String name = nextEntry.getName();
            if (!nextEntry.isDirectory()) {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                q.b(fileOutputStream);
            } else if (!name.contains("../")) {
                String substring = name.substring(0, name.length() - 1);
                new File(str2 + File.separator + substring).mkdirs();
            }
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static String b(Context context) {
        String str = a(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String b(Context context, String str) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2 + File.separator + str + ".zip";
    }

    public static String c(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        a(b2);
        return b2 + File.separator + "packageIndex.json";
    }

    public static String c(Context context, String str) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2 + File.separator + str;
    }

    public static String d(Context context, String str) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2 + File.separator + str + File.separator + "_manifest_.json";
    }
}
