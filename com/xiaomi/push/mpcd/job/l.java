package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.service.an;
import com.xiaomi.xmpush.thrift.ac;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.at;
import com.xiaomi.xmpush.thrift.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class l extends h.a {
    private Context a;
    private SharedPreferences b;
    private an c;

    public l(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("mipush_extra", 0);
        this.c = an.a(context);
    }

    private List<com.xiaomi.xmpush.thrift.k> a(File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        fileInputStream2 = null;
        r1 = null;
        fileInputStream2 = null;
        FileLock fileLock2 = null;
        com.xiaomi.push.mpcd.b b = com.xiaomi.push.mpcd.c.a().b();
        String a = b == null ? "" : b.a();
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (com.xiaomi.push.mpcd.f.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                com.xiaomi.channel.commonutils.file.b.c(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        FileInputStream fileInputStream3 = new FileInputStream(file);
                        while (fileInputStream3.read(bArr) == 4) {
                            try {
                                int a2 = com.xiaomi.channel.commonutils.misc.b.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (fileInputStream3.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = com.xiaomi.push.mpcd.e.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    com.xiaomi.xmpush.thrift.k kVar = new com.xiaomi.xmpush.thrift.k();
                                    at.a(kVar, a3);
                                    arrayList.add(kVar);
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
                                com.xiaomi.channel.commonutils.file.b.a(fileInputStream);
                                com.xiaomi.channel.commonutils.file.b.a(randomAccessFile2);
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
                                com.xiaomi.channel.commonutils.file.b.a(fileInputStream2);
                                com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                            }
                        }
                        com.xiaomi.channel.commonutils.file.b.a(fileInputStream3);
                        com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
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

    private boolean b() {
        if (com.xiaomi.channel.commonutils.network.d.e(this.a)) {
            return false;
        }
        if (!com.xiaomi.channel.commonutils.network.d.g(this.a) || d()) {
            return (com.xiaomi.channel.commonutils.network.d.h(this.a) && !c()) || com.xiaomi.channel.commonutils.network.d.i(this.a);
        }
        return true;
    }

    private boolean c() {
        if (this.c.a(com.xiaomi.xmpush.thrift.g.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.c.a(com.xiaomi.xmpush.thrift.g.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean d() {
        if (this.c.a(com.xiaomi.xmpush.thrift.g.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.c.a(com.xiaomi.xmpush.thrift.g.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    private void e() {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!com.xiaomi.channel.commonutils.network.d.d(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (b() || !file.exists()) {
        } else {
            List<com.xiaomi.xmpush.thrift.k> a = a(file);
            if (!com.xiaomi.channel.commonutils.misc.c.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                ac acVar = new ac();
                acVar.a(a);
                byte[] a2 = com.xiaomi.channel.commonutils.file.b.a(at.a(acVar));
                ai aiVar = new ai(LivenessStat.TYPE_STRING_DEFAULT, false);
                aiVar.c(r.DataCollection.aa);
                aiVar.a(a2);
                com.xiaomi.push.mpcd.b b = com.xiaomi.push.mpcd.c.a().b();
                if (b != null) {
                    b.a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, null);
                }
                e();
            }
            file.delete();
            this.b.edit().remove("ltapn").commit();
        }
    }
}
