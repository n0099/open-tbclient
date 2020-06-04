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
public class ei extends ai.a {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f231a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.ak f232a;

    public ei(Context context) {
        this.a = context;
        this.f231a = context.getSharedPreferences("mipush_extra", 0);
        this.f232a = com.xiaomi.push.service.ak.a(context);
    }

    private List<hu> a(File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        fileInputStream2 = null;
        r1 = null;
        fileInputStream2 = null;
        FileLock fileLock2 = null;
        dp m229a = dq.a().m229a();
        String a = m229a == null ? "" : m229a.a();
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dv.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                y.m587a(file2);
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
                                byte[] a3 = du.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    hu huVar = new hu();
                                    iw.a(huVar, a3);
                                    arrayList.add(huVar);
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
        SharedPreferences.Editor edit = this.f231a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m234a() {
        if (az.d(this.a)) {
            return false;
        }
        if (!az.f(this.a) || c()) {
            return (az.g(this.a) && !b()) || az.h(this.a);
        }
        return true;
    }

    private boolean b() {
        if (this.f232a.a(hr.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f231a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f232a.a(hr.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f232a.a(hr.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f231a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f232a.a(hr.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo163a() {
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!az.c(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (m234a() || !file.exists()) {
        } else {
            List<hu> a = a(file);
            if (!ad.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                Cif cif = new Cif();
                cif.a(a);
                byte[] a2 = y.a(iw.a(cif));
                il ilVar = new il("-1", false);
                ilVar.c(hw.DataCollection.f475a);
                ilVar.a(a2);
                dp m229a = dq.a().m229a();
                if (m229a != null) {
                    m229a.a(ilVar, hm.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
