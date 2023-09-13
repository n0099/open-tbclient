package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.aj;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes10.dex */
public abstract class ds extends aj.a {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Context f235a;

    public ds(Context context, int i) {
        this.a = i;
        this.f235a = context;
    }

    public static void a(Context context, hp hpVar) {
        dl m364a = dm.a().m364a();
        String a = m364a == null ? "" : m364a.a();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(hpVar.a())) {
            return;
        }
        a(context, hpVar, a);
    }

    public static void a(Context context, hp hpVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        FileLock lock;
        File file;
        byte[] b = Cdo.b(str, ir.a(hpVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (dp.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file2 = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    y.m844a(file2);
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                        try {
                            file = new File(context.getExternalFilesDir(null), "push_cdata.data");
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
                        } catch (IOException e) {
                            e = e;
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                    try {
                        bufferedOutputStream.write(ac.a(b.length));
                        bufferedOutputStream.write(b);
                        bufferedOutputStream.flush();
                        file.setLastModified(0L);
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused) {
                            }
                        }
                        y.a(bufferedOutputStream);
                    } catch (IOException e3) {
                        e = e3;
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
                        } catch (Throwable th3) {
                            th = th3;
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
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock = lock;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        y.a(bufferedOutputStream);
                        y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (IOException e4) {
                e = e4;
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
        return "dc_job_result_time_" + mo301a();
    }

    private String d() {
        return "dc_job_result_" + mo301a();
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.aj.a.a()Ljava/lang/String; */
    public abstract hj a();

    /* JADX DEBUG: Possible override for method com.xiaomi.push.aj.a.a()Ljava/lang/String; */
    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a() {
        return Cdo.a(this.f235a, String.valueOf(mo301a()), this.a);
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public boolean m367b() {
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m368c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        if (m366a()) {
            com.xiaomi.channel.commonutils.logger.b.m181a("DC run job mutual: " + mo301a());
            return;
        }
        dl m364a = dm.a().m364a();
        String a = m364a == null ? "" : m364a.a();
        if (!TextUtils.isEmpty(a) && m367b()) {
            if (m368c()) {
                SharedPreferences sharedPreferences = this.f235a.getSharedPreferences("mipush_extra", 0);
                if (bo.a(b).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int a2 = com.xiaomi.push.service.ba.a(this.f235a).a(hm.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < a2) {
                        b = "same_" + j;
                    }
                }
            }
            hp hpVar = new hp();
            hpVar.a(b);
            hpVar.a(System.currentTimeMillis());
            hpVar.a(a());
            a(this.f235a, hpVar, a);
        }
    }
}
