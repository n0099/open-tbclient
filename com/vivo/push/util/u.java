package com.vivo.push.util;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes7.dex */
public final class u implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36801a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".vivo/pushsdk/config";

    /* renamed from: b  reason: collision with root package name */
    public static final String f36802b = f36801a + File.separator + "config.txt";

    /* renamed from: c  reason: collision with root package name */
    public static String f36803c = "SdcardCache";

    /* renamed from: d  reason: collision with root package name */
    public File f36804d;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(f36801a);
            boolean mkdirs = !file.exists() ? file.mkdirs() : true;
            if (mkdirs) {
                File file2 = new File(f36802b);
                this.f36804d = file2;
                if (!file2.exists()) {
                    try {
                        this.f36804d.createNewFile();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
            }
            return mkdirs;
        }
        return false;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        FileOutputStream fileOutputStream;
        Properties a2 = a();
        String str3 = f36802b;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                a2.setProperty(str, str2);
                fileOutputStream = new FileOutputStream(str3);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            a2.store(fileOutputStream, (String) null);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        return a().getProperty(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Properties a() {
        BufferedInputStream bufferedInputStream;
        Exception e2;
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(f36802b));
            try {
                try {
                    properties.load(bufferedInputStream);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            bufferedInputStream = null;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
        try {
            bufferedInputStream.close();
        } catch (IOException unused2) {
            return properties;
        }
    }
}
