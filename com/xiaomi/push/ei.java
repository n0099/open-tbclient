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
/* loaded from: classes6.dex */
public class ei extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14267a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f311a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.ak f312a;

    public ei(Context context) {
        this.f14267a = context;
        this.f311a = context.getSharedPreferences("mipush_extra", 0);
        this.f312a = com.xiaomi.push.service.ak.a(context);
    }

    private List<hu> a(File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        FileLock fileLock2;
        dp m251a = dq.a().m251a();
        String a2 = m251a == null ? "" : m251a.a();
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dv.f14254a) {
            try {
                File file2 = new File(this.f14267a.getExternalFilesDir(null), "push_cdata.lock");
                y.m609a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a3 = ac.a(bArr);
                                byte[] bArr2 = new byte[a3];
                                if (fileInputStream.read(bArr2) != a3) {
                                    break;
                                }
                                byte[] a4 = du.a(a2, bArr2);
                                if (a4 != null && a4.length != 0) {
                                    hu huVar = new hu();
                                    iw.a(huVar, a4);
                                    arrayList.add(huVar);
                                }
                            } catch (Exception e) {
                                fileLock2 = fileLock;
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException e2) {
                                    }
                                }
                                y.a(fileInputStream);
                                y.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e3) {
                                    }
                                }
                                y.a(fileInputStream);
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
                        y.a(fileInputStream);
                        y.a(randomAccessFile);
                    } catch (Exception e5) {
                        fileLock2 = fileLock;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception e6) {
                    fileLock2 = null;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                    fileInputStream = null;
                }
            } catch (Exception e7) {
                fileLock2 = null;
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                randomAccessFile = null;
                fileInputStream = null;
            }
        }
        return arrayList;
    }

    private void a() {
        SharedPreferences.Editor edit = this.f311a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m256a() {
        if (az.d(this.f14267a)) {
            return false;
        }
        if (!az.f(this.f14267a) || c()) {
            return (az.g(this.f14267a) && !b()) || az.h(this.f14267a);
        }
        return true;
    }

    private boolean b() {
        if (this.f312a.a(hr.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f311a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f312a.a(hr.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f312a.a(hr.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f311a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f312a.a(hr.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo185a() {
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f14267a.getExternalFilesDir(null), "push_cdata.data");
        if (!az.c(this.f14267a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (m256a() || !file.exists()) {
        } else {
            List<hu> a2 = a(file);
            if (!ad.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                Cif cif = new Cif();
                cif.a(a2);
                byte[] a3 = y.a(iw.a(cif));
                il ilVar = new il("-1", false);
                ilVar.c(hw.DataCollection.f555a);
                ilVar.a(a3);
                dp m251a = dq.a().m251a();
                if (m251a != null) {
                    m251a.a(ilVar, hm.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
