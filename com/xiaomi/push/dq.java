package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes7.dex */
public abstract class dq extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public int f40371a;

    /* renamed from: a  reason: collision with other field name */
    public Context f238a;

    public dq(Context context, int i) {
        this.f40371a = i;
        this.f238a = context;
    }

    public static void a(Context context, hn hnVar) {
        di m227a = dj.a().m227a();
        String a2 = m227a == null ? "" : m227a.a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(hnVar.a())) {
            return;
        }
        a(context, hnVar, a2);
    }

    public static void a(Context context, hn hnVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] b2 = dl.b(str, ip.a(hnVar));
        if (b2 == null || b2.length == 0) {
            return;
        }
        synchronized (dm.f40366a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    y.m624a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                            try {
                                bufferedOutputStream.write(ac.a(b2.length));
                                bufferedOutputStream.write(b2);
                                bufferedOutputStream.flush();
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused) {
                                    }
                                }
                                y.a(bufferedOutputStream);
                            } catch (IOException e2) {
                                e = e2;
                                fileLock = lock;
                                try {
                                    e.printStackTrace();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    y.a(bufferedOutputStream);
                                    y.a(randomAccessFile);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    y.a(bufferedOutputStream);
                                    y.a(randomAccessFile);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                y.a(bufferedOutputStream);
                                y.a(randomAccessFile);
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
                randomAccessFile = null;
            }
            y.a(randomAccessFile);
        }
    }

    private String c() {
        return "dc_job_result_time_" + mo165a();
    }

    private String d() {
        return "dc_job_result_" + mo165a();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract hh mo165a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public boolean mo165a() {
        return dl.a(this.f238a, String.valueOf(mo165a()), this.f40371a);
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public boolean m229b() {
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m230c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        if (mo165a()) {
            com.xiaomi.channel.commonutils.logger.b.m51a("DC run job mutual: " + mo165a());
            return;
        }
        di m227a = dj.a().m227a();
        String a2 = m227a == null ? "" : m227a.a();
        if (!TextUtils.isEmpty(a2) && m229b()) {
            if (m230c()) {
                SharedPreferences sharedPreferences = this.f238a.getSharedPreferences("mipush_extra", 0);
                if (bm.a(b2).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int a3 = com.xiaomi.push.service.aq.a(this.f238a).a(hk.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.f40371a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < a3) {
                        b2 = "same_" + j;
                    }
                }
            }
            hn hnVar = new hn();
            hnVar.a(b2);
            hnVar.a(System.currentTimeMillis());
            hnVar.a(mo165a());
            a(this.f238a, hnVar, a2);
        }
    }
}
