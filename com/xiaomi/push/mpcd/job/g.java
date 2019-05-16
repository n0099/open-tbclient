package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.xmpush.thrift.at;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes3.dex */
public abstract class g extends h.a {
    protected int c;
    protected Context d;

    public g(Context context, int i) {
        this.c = i;
        this.d = context;
    }

    public static void a(Context context, com.xiaomi.xmpush.thrift.k kVar) {
        com.xiaomi.push.mpcd.b b = com.xiaomi.push.mpcd.c.a().b();
        String a = b == null ? "" : b.a();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(kVar.c())) {
            return;
        }
        a(context, kVar, a);
    }

    private static void a(Context context, com.xiaomi.xmpush.thrift.k kVar, String str) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile2;
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        r2 = null;
        bufferedOutputStream2 = null;
        FileLock fileLock2 = null;
        byte[] b = com.xiaomi.push.mpcd.e.b(str, at.a(kVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (com.xiaomi.push.mpcd.f.a) {
            try {
                File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                com.xiaomi.channel.commonutils.file.b.c(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        try {
                            bufferedOutputStream.write(com.xiaomi.channel.commonutils.misc.b.a(b.length));
                            bufferedOutputStream.write(b);
                            bufferedOutputStream.flush();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e) {
                                }
                            }
                            com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
                            com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                        } catch (IOException e2) {
                            e = e2;
                            fileLock2 = fileLock;
                            randomAccessFile2 = randomAccessFile;
                            try {
                                e.printStackTrace();
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException e3) {
                                    }
                                }
                                com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
                                com.xiaomi.channel.commonutils.file.b.a(randomAccessFile2);
                            } catch (Throwable th) {
                                th = th;
                                randomAccessFile = randomAccessFile2;
                                fileLock = fileLock2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                    }
                                }
                                com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream2);
                                com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream2);
                            com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedOutputStream = null;
                        fileLock2 = fileLock;
                        randomAccessFile2 = randomAccessFile;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e6) {
                    e = e6;
                    bufferedOutputStream = null;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th4) {
                    th = th4;
                    fileLock = null;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedOutputStream = null;
                randomAccessFile2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileLock = null;
                randomAccessFile = null;
            }
        }
    }

    public abstract String b();

    protected boolean c() {
        return true;
    }

    public abstract com.xiaomi.xmpush.thrift.d d();

    protected boolean e() {
        return com.xiaomi.channel.commonutils.misc.f.a(this.d, String.valueOf(a()), this.c);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (e()) {
            com.xiaomi.push.mpcd.b b = com.xiaomi.push.mpcd.c.a().b();
            String a = b == null ? "" : b.a();
            if (TextUtils.isEmpty(a) || !c()) {
                return;
            }
            String b2 = b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            com.xiaomi.xmpush.thrift.k kVar = new com.xiaomi.xmpush.thrift.k();
            kVar.a(b2);
            kVar.a(System.currentTimeMillis());
            kVar.a(d());
            a(this.d, kVar, a);
        }
    }
}
