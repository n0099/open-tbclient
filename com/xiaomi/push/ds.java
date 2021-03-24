package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ds extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f40371a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f239a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.aq f240a;

    public ds(Context context) {
        this.f40371a = context;
        this.f239a = context.getSharedPreferences("mipush_extra", 0);
        this.f240a = com.xiaomi.push.service.aq.a(context);
    }

    private List<hn> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        di m227a = dj.a().m227a();
        String a2 = m227a == null ? "" : m227a.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dm.f40365a) {
            try {
                File file2 = new File(this.f40371a.getExternalFilesDir(null), "push_cdata.lock");
                y.m624a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a3 = ac.a(bArr);
                                byte[] bArr2 = new byte[a3];
                                if (fileInputStream.read(bArr2) != a3) {
                                    break;
                                }
                                byte[] a4 = dl.a(a2, bArr2);
                                if (a4 != null && a4.length != 0) {
                                    hn hnVar = new hn();
                                    ip.a(hnVar, a4);
                                    arrayList.add(hnVar);
                                    a(hnVar);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                y.a(fileInputStream);
                                y.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                y.a(fileInputStream);
                                y.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        y.a(fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            y.a(randomAccessFile);
        }
        return arrayList;
    }

    private void a() {
        SharedPreferences.Editor edit = this.f239a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private void a(hn hnVar) {
        if (hnVar.f497a != hh.AppInstallList || hnVar.f498a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f239a.edit();
        edit.putLong("dc_job_result_time_4", hnVar.f496a);
        edit.putString("dc_job_result_4", bm.a(hnVar.f498a));
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m231a() {
        if (bg.e(this.f40371a)) {
            return false;
        }
        if ((bg.g(this.f40371a) || bg.f(this.f40371a)) && !c()) {
            return true;
        }
        return (bg.h(this.f40371a) && !b()) || bg.i(this.f40371a);
    }

    private boolean b() {
        if (this.f240a.a(hk.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f239a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f240a.a(hk.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f240a.a(hk.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f239a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f240a.a(hk.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo165a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f40371a.getExternalFilesDir(null), "push_cdata.data");
        if (!bg.d(this.f40371a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!m231a() && file.exists()) {
            List<hn> a2 = a(file);
            if (!ad.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                hy hyVar = new hy();
                hyVar.a(a2);
                byte[] a3 = y.a(ip.a(hyVar));
                ie ieVar = new ie("-1", false);
                ieVar.c(hp.DataCollection.f506a);
                ieVar.a(a3);
                di m227a = dj.a().m227a();
                if (m227a != null) {
                    m227a.a(ieVar, hf.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
