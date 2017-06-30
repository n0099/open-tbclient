package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class c {
    public static boolean a(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                byte[] b = com.xiaomi.channel.commonutils.file.a.b(inputStream);
                File file = new File(str2);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String a = com.xiaomi.channel.commonutils.string.d.a(com.xiaomi.channel.commonutils.file.a.b(fileInputStream));
                        String a2 = com.xiaomi.channel.commonutils.string.d.a(b);
                        if (!TextUtils.isEmpty(a)) {
                            if (a.equals(a2)) {
                                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                                com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                                com.xiaomi.channel.commonutils.file.a.a((OutputStream) null);
                                return false;
                            }
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        inputStream2 = inputStream;
                        try {
                            e.printStackTrace();
                            com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                            com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                            com.xiaomi.channel.commonutils.file.a.a(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            com.xiaomi.channel.commonutils.file.a.a(inputStream);
                            com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                            com.xiaomi.channel.commonutils.file.a.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.xiaomi.channel.commonutils.file.a.a(inputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileOutputStream);
                        throw th;
                    }
                } else {
                    fileInputStream2 = null;
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(b);
                        fileOutputStream2.flush();
                        com.xiaomi.channel.commonutils.file.a.a(inputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileInputStream2);
                        com.xiaomi.channel.commonutils.file.a.a(fileOutputStream2);
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        inputStream2 = inputStream;
                        e.printStackTrace();
                        com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                        com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileOutputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.channel.commonutils.file.a.a(inputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = fileInputStream2;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                inputStream2 = inputStream;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            inputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            inputStream = null;
        }
    }
}
