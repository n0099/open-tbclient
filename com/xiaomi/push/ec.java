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
/* loaded from: classes8.dex */
public class ec extends ai.a {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f247a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.ag f248a;

    public ec(Context context) {
        this.a = context;
        this.f247a = context.getSharedPreferences("mipush_extra", 0);
        this.f248a = com.xiaomi.push.service.ag.a(context);
    }

    private List<ho> a(File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        fileInputStream2 = null;
        r1 = null;
        fileInputStream2 = null;
        FileLock fileLock2 = null;
        dk m226a = dl.a().m226a();
        String a = m226a == null ? "" : m226a.a();
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dq.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                y.m571a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        FileInputStream fileInputStream3 = new FileInputStream(file);
                        while (fileInputStream3.read(bArr) == 4) {
                            try {
                                int a2 = ac.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (fileInputStream3.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = dp.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    ho hoVar = new ho();
                                    iq.a(hoVar, a3);
                                    arrayList.add(hoVar);
                                }
                            } catch (Exception e) {
                                fileLock2 = fileLock;
                                randomAccessFile2 = randomAccessFile;
                                fileInputStream = fileInputStream3;
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException e2) {
                                    }
                                }
                                y.a(fileInputStream);
                                y.a(randomAccessFile2);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream2 = fileInputStream3;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e3) {
                                    }
                                }
                                y.a(fileInputStream2);
                                y.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                            }
                        }
                        y.a(fileInputStream3);
                        y.a(randomAccessFile);
                    } catch (Exception e5) {
                        randomAccessFile2 = randomAccessFile;
                        fileInputStream = null;
                        fileLock2 = fileLock;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e6) {
                    randomAccessFile2 = randomAccessFile;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                }
            } catch (Exception e7) {
                randomAccessFile2 = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                randomAccessFile = null;
            }
        }
        return arrayList;
    }

    private void a() {
        SharedPreferences.Editor edit = this.f247a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m231a() {
        if (as.d(this.a)) {
            return false;
        }
        if (!as.f(this.a) || c()) {
            return (as.g(this.a) && !b()) || as.h(this.a);
        }
        return true;
    }

    private boolean b() {
        if (this.f248a.a(hl.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f247a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f248a.a(hl.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f248a.a(hl.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f247a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f248a.a(hl.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo160a() {
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!as.c(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (m231a() || !file.exists()) {
        } else {
            List<ho> a = a(file);
            if (!ad.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                hz hzVar = new hz();
                hzVar.a(a);
                byte[] a2 = y.a(iq.a(hzVar));
                Cif cif = new Cif("-1", false);
                cif.c(hq.DataCollection.f490a);
                cif.a(a2);
                dk m226a = dl.a().m226a();
                if (m226a != null) {
                    m226a.a(cif, hg.Notification, null);
                }
                a();
            }
            file.delete();
            this.f247a.edit().remove("ltapn").commit();
        }
    }
}
