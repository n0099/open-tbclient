package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class s {
    private static volatile s a;
    private static final Object b = new Object();
    private Context c;

    private s(Context context) {
        this.c = context;
    }

    public static s a(Context context) {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s(context);
                }
            }
        }
        return a;
    }

    private File a(String str) {
        File file = new File(this.c.getFilesDir() + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile() && listFiles[i].getName().startsWith(str)) {
                return listFiles[i];
            }
        }
        return null;
    }

    public String a(File file) {
        if (file == null) {
            return "";
        }
        String[] split = file.getName().split(":");
        return split.length != 2 ? "" : split[0];
    }

    public ArrayList<File> a() {
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(this.c.getFilesDir() + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            String[] split = listFiles[i].getName().split(":");
            if (split.length >= 2 && Integer.parseInt(split[1]) >= 1 && listFiles[i].isFile()) {
                arrayList.add(listFiles[i]);
            }
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        FileOutputStream fileOutputStream;
        String[] split;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (b) {
            File a2 = a(str2);
            if (a2 != null) {
                if (a2.getName().split(":").length < 2) {
                    return;
                }
                a2.renameTo(new File(this.c.getFilesDir() + "/crash/" + str2 + ":" + String.valueOf(Integer.parseInt(split[1]) + 1)));
            } else {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(new File(this.c.getFilesDir() + "/crash/" + str2 + ":1"));
                    try {
                        try {
                            fileOutputStream.write(str.getBytes());
                            fileOutputStream.flush();
                            com.xiaomi.channel.commonutils.file.b.a(fileOutputStream);
                        } catch (Exception e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            com.xiaomi.channel.commonutils.file.b.a(fileOutputStream);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        com.xiaomi.channel.commonutils.file.b.a(fileOutputStream2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.file.b.a(fileOutputStream2);
                    throw th;
                }
            }
        }
    }
}
