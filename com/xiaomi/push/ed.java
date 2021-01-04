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
/* loaded from: classes6.dex */
public abstract class ed extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    protected int f14261a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f310a;

    public ed(Context context, int i) {
        this.f14261a = i;
        this.f310a = context;
    }

    public static void a(Context context, hu huVar) {
        dp m251a = dq.a().m251a();
        String a2 = m251a == null ? "" : m251a.a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(huVar.a())) {
            return;
        }
        a(context, huVar, a2);
    }

    private static void a(Context context, hu huVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        byte[] b2 = du.b(str, iw.a(huVar));
        if (b2 == null || b2.length == 0) {
            return;
        }
        synchronized (dv.f14254a) {
            try {
                File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                y.m609a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = null;
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                    fileLock = null;
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                    try {
                        try {
                            bufferedOutputStream.write(ac.a(b2.length));
                            bufferedOutputStream.write(b2);
                            bufferedOutputStream.flush();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                }
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e4) {
                                }
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                            }
                        }
                        y.a(bufferedOutputStream);
                        y.a(randomAccessFile);
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    y.a(bufferedOutputStream);
                    y.a(randomAccessFile);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedOutputStream = null;
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                fileLock = null;
                randomAccessFile = null;
            }
        }
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract ho mo185a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract String mo185a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public boolean mo185a() {
        return du.a(this.f310a, String.valueOf(mo185a()), this.f14261a);
    }

    protected boolean b() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (mo185a()) {
            com.xiaomi.channel.commonutils.logger.b.m73a("DC run job mutual: " + mo185a());
            return;
        }
        dp m251a = dq.a().m251a();
        String a2 = m251a == null ? "" : m251a.a();
        if (TextUtils.isEmpty(a2) || !b()) {
            return;
        }
        String mo185a = mo185a();
        if (TextUtils.isEmpty(mo185a)) {
            return;
        }
        hu huVar = new hu();
        huVar.a(mo185a);
        huVar.a(System.currentTimeMillis());
        huVar.a(mo185a());
        a(this.f310a, huVar, a2);
    }
}
