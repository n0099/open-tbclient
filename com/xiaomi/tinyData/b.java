package com.xiaomi.tinyData;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.service.bk;
import com.xiaomi.xmpush.thrift.at;
import com.xiaomi.xmpush.thrift.f;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    private static boolean a = false;

    /* loaded from: classes3.dex */
    static class a implements Runnable {
        private Context a;
        private e b;

        public a(Context context, e eVar) {
            this.b = eVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c(this.a, this.b);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void a(Context context, e eVar) {
        h.a(context).a(new a(context, eVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, e eVar, File file, byte[] bArr) {
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
                        int a2 = com.xiaomi.channel.commonutils.misc.b.a(bArr2);
                        if (a2 < 1 || a2 > 10240) {
                            break;
                        }
                        byte[] bArr3 = new byte[a2];
                        int read2 = bufferedInputStream.read(bArr3);
                        if (read2 != a2) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2);
                            break;
                        }
                        byte[] a3 = com.xiaomi.channel.commonutils.android.c.a(bArr, bArr3);
                        if (a3 == null || a3.length == 0) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                        } else {
                            f fVar = new f();
                            at.a(fVar, a3);
                            arrayList.add(fVar);
                            i2++;
                            i += a3.length;
                            if (i2 >= 8 || i >= 10240) {
                                com.xiaomi.channel.commonutils.logger.b.a("TinyData readTinyDataFromFile upload tiny data by part. items:" + arrayList.size() + " ts:" + System.currentTimeMillis());
                                c.a(context, eVar, arrayList);
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
                        com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
                    throw th;
                }
            }
            c.a(context, eVar, arrayList);
            com.xiaomi.channel.commonutils.logger.b.a("TinyData readTinyDataFromFile upload tiny data at last. items:" + arrayList.size() + " ts:" + System.currentTimeMillis());
            if (file != null && file.exists() && !file.delete()) {
                com.xiaomi.channel.commonutils.logger.b.a("TinyData delete reading temp file failed");
            }
            com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0102 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0030 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, e eVar) {
        RandomAccessFile randomAccessFile;
        ?? r1 = 0;
        r1 = null;
        FileLock fileLock = null;
        r1 = 0;
        if (a) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData extractTinyData is running");
            return;
        }
        a = true;
        File file = new File(context.getFilesDir(), "tiny_data.data");
        ?? exists = file.exists();
        if (exists == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData no ready file to get data.");
            return;
        }
        a(context);
        byte[] a2 = bk.a(context);
        try {
            try {
                File file2 = new File(context.getFilesDir(), "tiny_data.lock");
                com.xiaomi.channel.commonutils.file.b.c(file2);
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
                    com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
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
                com.xiaomi.channel.commonutils.file.b.a((Closeable) exists);
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
            com.xiaomi.channel.commonutils.file.b.a((Closeable) exists);
            throw th;
        }
        com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
        exists = "tiny_data.data";
        File file32 = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        r1 = file32.exists();
        if (r1 != 0) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData no ready file to get data.");
            return;
        }
        a(context, eVar, file32, a2);
        com.xiaomi.tinyData.a.a(false);
        b(context);
        a = false;
    }
}
