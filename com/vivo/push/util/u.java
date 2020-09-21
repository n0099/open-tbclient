package com.vivo.push.util;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes12.dex */
final class u implements c {
    private static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".vivo/pushsdk/config";
    private static final String b = a + File.separator + "config.txt";
    private static String c = "SdcardCache";
    private File d;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(a);
            boolean mkdirs = !file.exists() ? file.mkdirs() : true;
            if (mkdirs) {
                this.d = new File(b);
                if (!this.d.exists()) {
                    try {
                        this.d.createNewFile();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            return mkdirs;
        }
        return false;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        return a().getProperty(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.vivo.push.util.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(String str, String str2) {
        FileOutputStream fileOutputStream;
        Properties a2 = a();
        String str3 = b;
        try {
            try {
                a2.setProperty(str, str2);
                fileOutputStream = new FileOutputStream(str3);
                try {
                    a2.store(fileOutputStream, (String) null);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Properties a() {
        BufferedInputStream bufferedInputStream;
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(b));
                try {
                    properties.load(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return properties;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
        return properties;
    }
}
