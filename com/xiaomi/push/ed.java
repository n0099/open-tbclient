package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes18.dex */
public abstract class ed extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    protected int f4642a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f232a;

    public ed(Context context, int i) {
        this.f4642a = i;
        this.f232a = context;
    }

    public static void a(Context context, hu huVar) {
        dp m225a = dq.a().m225a();
        String a2 = m225a == null ? "" : m225a.a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(huVar.a())) {
            return;
        }
        a(context, huVar, a2);
    }

    private static void a(Context context, hu huVar, String str) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile2;
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        r2 = null;
        bufferedOutputStream2 = null;
        FileLock fileLock2 = null;
        byte[] b = du.b(str, iw.a(huVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (dv.f4637a) {
            try {
                File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                y.m583a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        try {
                            bufferedOutputStream.write(ac.a(b.length));
                            bufferedOutputStream.write(b);
                            bufferedOutputStream.flush();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e) {
                                }
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
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
                                y.a(bufferedOutputStream);
                                y.a(randomAccessFile2);
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
                                y.a(bufferedOutputStream2);
                                y.a(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            y.a(bufferedOutputStream2);
                            y.a(randomAccessFile);
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

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract ho mo159a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract String mo159a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public boolean mo159a() {
        return du.a(this.f232a, String.valueOf(mo159a()), this.f4642a);
    }

    protected boolean b() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (mo159a()) {
            com.xiaomi.channel.commonutils.logger.b.m47a("DC run job mutual: " + mo159a());
            return;
        }
        dp m225a = dq.a().m225a();
        String a2 = m225a == null ? "" : m225a.a();
        if (TextUtils.isEmpty(a2) || !b()) {
            return;
        }
        String mo159a = mo159a();
        if (TextUtils.isEmpty(mo159a)) {
            return;
        }
        hu huVar = new hu();
        huVar.a(mo159a);
        huVar.a(System.currentTimeMillis());
        huVar.a(mo159a());
        a(this.f232a, huVar, a2);
    }
}
