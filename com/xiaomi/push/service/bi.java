package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.al;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.go;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public static bi f41003a = new bi();

    /* renamed from: a  reason: collision with other field name */
    public static String f926a;

    /* renamed from: a  reason: collision with other field name */
    public al.b f927a;

    /* renamed from: a  reason: collision with other field name */
    public dt.a f928a;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f929a = new ArrayList();

    /* loaded from: classes7.dex */
    public static abstract class a {
        public void a(dt.a aVar) {
        }

        public void a(du.b bVar) {
        }
    }

    public static bi a() {
        return f41003a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m593a() {
        String str;
        synchronized (bi.class) {
            if (f926a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m617a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f926a = string;
                if (string == null) {
                    String a2 = com.xiaomi.push.i.a(com.xiaomi.push.t.m617a(), false);
                    f926a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f926a).commit();
                    }
                }
            }
            str = f926a;
        }
        return str;
    }

    private void b() {
        if (this.f928a == null) {
            d();
        }
    }

    private void c() {
        if (this.f927a != null) {
            return;
        }
        bj bjVar = new bj(this);
        this.f927a = bjVar;
        go.a(bjVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e2;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m617a().openFileInput("XMCloudCfg"));
                try {
                    this.f928a = dt.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.m51a("load config failure: " + e2.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f928a != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.y.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e4) {
            bufferedInputStream = null;
            e2 = e4;
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            com.xiaomi.push.y.a(bufferedInputStream);
            throw th;
        }
        com.xiaomi.push.y.a(bufferedInputStream);
        if (this.f928a != null) {
            this.f928a = new dt.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f928a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m617a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f928a.a(a2);
                a2.m174a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("save config failure: " + e2.getMessage());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m596a() {
        b();
        dt.a aVar = this.f928a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dt.a m597a() {
        b();
        return this.f928a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m598a() {
        this.f929a.clear();
    }

    public void a(du.b bVar) {
        a[] aVarArr;
        if (bVar.m244d() && bVar.d() > m596a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f929a.toArray(new a[this.f929a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f929a.add(aVar);
    }
}
