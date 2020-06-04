package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class hi {
    private static boolean a = false;

    /* loaded from: classes8.dex */
    static class a implements Runnable {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private hl f434a;

        public a(Context context, hl hlVar) {
            this.f434a = hlVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            hi.c(this.a, this.f434a);
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
                                i2 = 0;
                                arrayList = new ArrayList();
                                i = 0;
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
                com.xiaomi.channel.commonutils.logger.b.m51a("TinyData delete reading temp file failed");
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0105 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x0030 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, hl hlVar) {
        RandomAccessFile randomAccessFile;
        ?? r1 = 0;
        r1 = null;
        FileLock fileLock = null;
        r1 = 0;
        if (a) {
            com.xiaomi.channel.commonutils.logger.b.m51a("TinyData extractTinyData is running");
            return;
        }
        a = true;
        File file = new File(context.getFilesDir(), "tiny_data.data");
        ?? exists = file.exists();
        if (exists == 0) {
            com.xiaomi.channel.commonutils.logger.b.m51a("TinyData no ready file to get data.");
            return;
        }
        a(context);
        byte[] a2 = com.xiaomi.push.service.bj.a(context);
        try {
            try {
                File file2 = new File(context.getFilesDir(), "tiny_data.lock");
                y.m587a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    y.a(randomAccessFile);
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    y.a(randomAccessFile);
                    exists = "tiny_data.data";
                    File file3 = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                    r1 = file3.exists();
                    if (r1 != 0) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r1 != 0 && r1.isValid()) {
                    try {
                        r1.release();
                    } catch (IOException e4) {
                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                    }
                }
                y.a((Closeable) exists);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            if (r1 != 0) {
                r1.release();
            }
            y.a((Closeable) exists);
            throw th;
        }
        exists = "tiny_data.data";
        File file32 = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        r1 = file32.exists();
        if (r1 != 0) {
            com.xiaomi.channel.commonutils.logger.b.m51a("TinyData no ready file to get data.");
            return;
        }
        a(context, hlVar, file32, a2);
        hh.a(false);
        b(context);
        a = false;
    }
}
