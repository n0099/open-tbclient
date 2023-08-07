package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.aj;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class du extends aj.a {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f236a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.ba f237a;

    public du(Context context) {
        this.a = context;
        this.f236a = context.getSharedPreferences("mipush_extra", 0);
        this.f237a = com.xiaomi.push.service.ba.a(context);
    }

    private List<hp> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        dl m361a = dm.a().m361a();
        String a = m361a == null ? "" : m361a.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dp.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                y.m841a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a2 = ac.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (fileInputStream.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = Cdo.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    hp hpVar = new hp();
                                    ir.a(hpVar, a3);
                                    arrayList.add(hpVar);
                                    a(hpVar);
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
        SharedPreferences.Editor edit = this.f236a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private void a(hp hpVar) {
        if (hpVar.f499a != hj.AppInstallList || hpVar.f500a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f236a.edit();
        edit.putLong("dc_job_result_time_4", hpVar.f498a);
        edit.putString("dc_job_result_4", bo.a(hpVar.f500a));
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m366a() {
        if (bi.e(this.a)) {
            return false;
        }
        if ((bi.g(this.a) || bi.f(this.a)) && !c()) {
            return true;
        }
        return (bi.h(this.a) && !b()) || bi.i(this.a);
    }

    private boolean b() {
        if (this.f237a.a(hm.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f236a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f237a.a(hm.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f237a.a(hm.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f236a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f237a.a(hm.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo298a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!bi.d(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!m366a() && file.exists()) {
            List<hp> a = a(file);
            if (!ad.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                ia iaVar = new ia();
                iaVar.a(a);
                byte[] a2 = y.a(ir.a(iaVar));
                ig igVar = new ig("-1", false);
                igVar.c(hr.DataCollection.f508a);
                igVar.a(a2);
                dl m361a = dm.a().m361a();
                if (m361a != null) {
                    m361a.a(igVar, hh.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
