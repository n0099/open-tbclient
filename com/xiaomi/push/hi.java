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
/* loaded from: classes6.dex */
public class hi {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14088a = false;

    /* loaded from: classes6.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f14089a;

        /* renamed from: a  reason: collision with other field name */
        private hl f514a;

        public a(Context context, hl hlVar) {
            this.f514a = hlVar;
            this.f14089a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            hi.c(this.f14089a, this.f514a);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void a(Context context, hl hlVar) {
        ai.a(context).a(new a(context, hlVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, hl hlVar, File file, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    } else if (read != 4) {
                        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer error. size:" + read);
                        break;
                    } else {
                        int a2 = ac.a(bArr2);
                        if (a2 < 1 || a2 > 10240) {
                            break;
                        }
                        byte[] bArr3 = new byte[a2];
                        int read2 = bufferedInputStream.read(bArr3);
                        if (read2 != a2) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2);
                            break;
                        }
                        byte[] a3 = h.a(bArr, bArr3);
                        if (a3 == null || a3.length == 0) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                        } else {
                            hq hqVar = new hq();
                            iw.a(hqVar, a3);
                            arrayList.add(hqVar);
                            i2++;
                            i += a3.length;
                            if (i2 >= 8 || i >= 10240) {
                                hj.a(context, hlVar, arrayList);
                                arrayList = new ArrayList();
                                i = 0;
                                i2 = 0;
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedInputStream2 = bufferedInputStream;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        y.a(bufferedInputStream2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        y.a(bufferedInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    y.a(bufferedInputStream);
                    throw th;
                }
            }
            hj.a(context, hlVar, arrayList);
            if (file != null && file.exists() && !file.delete()) {
                com.xiaomi.channel.commonutils.logger.b.m80a("TinyData delete reading temp file failed");
            }
            y.a(bufferedInputStream);
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, hl hlVar) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file;
        if (f14088a) {
            com.xiaomi.channel.commonutils.logger.b.m80a("TinyData extractTinyData is running");
            return;
        }
        f14088a = true;
        File file2 = new File(context.getFilesDir(), "tiny_data.data");
        if (!file2.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m80a("TinyData no ready file to get data.");
            return;
        }
        a(context);
        byte[] a2 = com.xiaomi.push.service.bj.a(context);
        try {
            File file3 = new File(context.getFilesDir(), "tiny_data.lock");
            y.m616a(file3);
            randomAccessFile = new RandomAccessFile(file3, "rw");
        } catch (Exception e) {
            e = e;
            fileLock = null;
            randomAccessFile = null;
        } catch (Throwable th) {
            th = th;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            fileLock = randomAccessFile.getChannel().lock();
            try {
                try {
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    y.a(randomAccessFile);
                } catch (Exception e3) {
                    e = e3;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    y.a(randomAccessFile);
                    file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                    if (file.exists()) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                    }
                }
                y.a(randomAccessFile);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileLock = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            if (fileLock != null) {
                fileLock.release();
            }
            y.a(randomAccessFile);
            throw th;
        }
        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m80a("TinyData no ready file to get data.");
            return;
        }
        a(context, hlVar, file, a2);
        hh.a(false);
        b(context);
        f14088a = false;
    }
}
