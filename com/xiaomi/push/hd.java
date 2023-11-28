package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class hd {
    public static boolean a;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public Context a;

        /* renamed from: a  reason: collision with other field name */
        public hg f463a;

        public a(Context context, hg hgVar) {
            this.f463a = hgVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            hd.c(this.a, this.f463a);
        }
    }

    public static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void a(Context context, hg hgVar) {
        aj.a(context).a(new a(context, hgVar));
    }

    public static void a(Context context, hg hgVar, File file, byte[] bArr) {
        String str;
        int a2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                loop0: while (true) {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream2.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            } else if (read == 4) {
                                a2 = ac.a(bArr2);
                                if (a2 < 1 || a2 > 10240) {
                                    break loop0;
                                }
                                byte[] bArr3 = new byte[a2];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a2) {
                                    str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                                    break loop0;
                                }
                                byte[] a3 = h.a(bArr, bArr3);
                                if (a3 != null && a3.length != 0) {
                                    hl hlVar = new hl();
                                    ir.a(hlVar, a3);
                                    hlVar.a("item_size", String.valueOf(a3.length));
                                    arrayList.add(hlVar);
                                    i++;
                                    i2 += a3.length;
                                    if (i >= 8 || i2 >= 10240) {
                                    }
                                }
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                                break loop0;
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            y.a(bufferedInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            y.a(bufferedInputStream);
                            throw th;
                        }
                    }
                    he.a(context, hgVar, arrayList);
                    arrayList.clear();
                }
                str = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a2;
                com.xiaomi.channel.commonutils.logger.b.d(str);
                he.a(context, hgVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    com.xiaomi.channel.commonutils.logger.b.m190a("TinyData delete reading temp file failed");
                }
                y.a(bufferedInputStream2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, hg hgVar) {
        RandomAccessFile randomAccessFile;
        File file;
        if (a) {
            com.xiaomi.channel.commonutils.logger.b.m190a("TinyData extractTinyData is running");
            return;
        }
        a = true;
        File file2 = new File(context.getFilesDir(), "tiny_data.data");
        if (!file2.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m190a("TinyData no ready file to get data.");
            return;
        }
        a(context);
        byte[] a2 = com.xiaomi.push.service.ca.a(context);
        FileLock fileLock = null;
        try {
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                y.m853a(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            y.a(randomAccessFile);
                            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                            if (file.exists()) {
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            y.a(randomAccessFile);
                            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                            if (file.exists()) {
                            }
                        }
                    }
                    y.a(randomAccessFile);
                    file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                    if (file.exists()) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e4) {
                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                    }
                }
                y.a(randomAccessFile);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            y.a(randomAccessFile);
            throw th;
        }
        y.a(randomAccessFile);
        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m190a("TinyData no ready file to get data.");
            return;
        }
        a(context, hgVar, file, a2);
        hc.a(false);
        b(context);
        a = false;
    }
}
