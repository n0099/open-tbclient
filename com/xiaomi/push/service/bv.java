package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.am;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.gy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class bv {
    public static bv a = new bv();

    /* renamed from: a  reason: collision with other field name */
    public static String f953a;

    /* renamed from: a  reason: collision with other field name */
    public am.b f954a;

    /* renamed from: a  reason: collision with other field name */
    public dv.a f955a;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f956a = new ArrayList();

    /* loaded from: classes10.dex */
    public static abstract class a {
        public void a(dv.a aVar) {
        }

        public void a(dw.b bVar) {
        }
    }

    public static bv a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m804a() {
        String str;
        synchronized (bv.class) {
            if (f953a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.s.m722a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f953a = string;
                if (string == null) {
                    String a2 = com.xiaomi.push.i.a(com.xiaomi.push.s.m722a(), false);
                    f953a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f953a).commit();
                    }
                }
            }
            str = f953a;
        }
        return str;
    }

    private void b() {
        if (this.f955a == null) {
            d();
        }
    }

    private void c() {
        if (this.f954a != null) {
            return;
        }
        bw bwVar = new bw(this);
        this.f954a = bwVar;
        gy.a(bwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.s.m722a().openFileInput("XMCloudCfg"));
                try {
                    this.f955a = dv.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.m180a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f955a != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.y.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            com.xiaomi.push.y.a(bufferedInputStream);
            throw th;
        }
        com.xiaomi.push.y.a(bufferedInputStream);
        if (this.f955a != null) {
            this.f955a = new dv.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f955a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.s.m722a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f955a.a(a2);
                a2.m309a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("save config failure: " + e.getMessage());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m807a() {
        b();
        dv.a aVar = this.f955a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dv.a m808a() {
        b();
        return this.f955a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m809a() {
        this.f956a.clear();
    }

    public void a(dw.b bVar) {
        a[] aVarArr;
        if (bVar.m392d() && bVar.d() > m807a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f956a.toArray(new a[this.f956a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f956a.add(aVar);
    }
}
