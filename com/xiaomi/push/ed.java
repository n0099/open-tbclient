package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes5.dex */
public abstract class ed extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    protected int f8335a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f231a;

    public ed(Context context, int i) {
        this.f8335a = i;
        this.f231a = context;
    }

    public static void a(Context context, hu huVar) {
        dp m236a = dq.a().m236a();
        String a2 = m236a == null ? "" : m236a.a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(huVar.a())) {
            return;
        }
        a(context, huVar, a2);
    }

    private static void a(Context context, hu huVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        byte[] b = du.b(str, iw.a(huVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (dv.f8330a) {
            try {
                File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                y.m594a(file);
                randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
                            bufferedOutputStream.write(ac.a(b.length));
                            bufferedOutputStream.write(b);
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
    public abstract ho mo170a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract String mo170a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public boolean mo170a() {
        return du.a(this.f231a, String.valueOf(mo170a()), this.f8335a);
    }

    protected boolean b() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (mo170a()) {
            com.xiaomi.channel.commonutils.logger.b.m58a("DC run job mutual: " + mo170a());
            return;
        }
        dp m236a = dq.a().m236a();
        String a2 = m236a == null ? "" : m236a.a();
        if (TextUtils.isEmpty(a2) || !b()) {
            return;
        }
        String mo170a = mo170a();
        if (TextUtils.isEmpty(mo170a)) {
            return;
        }
        hu huVar = new hu();
        huVar.a(mo170a);
        huVar.a(System.currentTimeMillis());
        huVar.a(mo170a());
        a(this.f231a, huVar, a2);
    }
}
