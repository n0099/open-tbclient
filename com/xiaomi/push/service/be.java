package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.al;
import com.xiaomi.push.ej;
import com.xiaomi.push.ek;
import com.xiaomi.push.gv;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class be {
    private static be a = new be();

    /* renamed from: a  reason: collision with other field name */
    private static String f883a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f884a;

    /* renamed from: a  reason: collision with other field name */
    private ej.a f885a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f886a = new ArrayList();

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void a(ej.a aVar) {
        }

        public void a(ek.b bVar) {
        }
    }

    private be() {
    }

    public static be a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m559a() {
        String str;
        synchronized (be.class) {
            if (f883a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m583a().getSharedPreferences("XMPushServiceConfig", 0);
                f883a = sharedPreferences.getString("DeviceUUID", null);
                if (f883a == null) {
                    f883a = com.xiaomi.push.i.a(com.xiaomi.push.t.m583a(), false);
                    if (f883a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f883a).commit();
                    }
                }
            }
            str = f883a;
        }
        return str;
    }

    private void b() {
        if (this.f885a == null) {
            d();
        }
    }

    private void c() {
        if (this.f884a != null) {
            return;
        }
        this.f884a = new bf(this);
        gv.a(this.f884a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m583a().openFileInput("XMCloudCfg"));
                try {
                    this.f885a = ej.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m54a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f885a != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.xiaomi.push.y.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            com.xiaomi.push.y.a(bufferedInputStream);
            throw th;
        }
        if (this.f885a != null) {
            this.f885a = new ej.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f885a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m583a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f885a.a(a2);
                a2.m176a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m562a() {
        b();
        if (this.f885a != null) {
            return this.f885a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ej.a m563a() {
        b();
        return this.f885a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m564a() {
        this.f886a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ek.b bVar) {
        a[] aVarArr;
        if (bVar.m250d() && bVar.d() > m562a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f886a.toArray(new a[this.f886a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f886a.add(aVar);
    }
}
