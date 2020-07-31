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
    private static String f885a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f886a;

    /* renamed from: a  reason: collision with other field name */
    private ej.a f887a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f888a = new ArrayList();

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
    public static synchronized String m554a() {
        String str;
        synchronized (be.class) {
            if (f885a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m578a().getSharedPreferences("XMPushServiceConfig", 0);
                f885a = sharedPreferences.getString("DeviceUUID", null);
                if (f885a == null) {
                    f885a = com.xiaomi.push.i.a(com.xiaomi.push.t.m578a(), false);
                    if (f885a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f885a).commit();
                    }
                }
            }
            str = f885a;
        }
        return str;
    }

    private void b() {
        if (this.f887a == null) {
            d();
        }
    }

    private void c() {
        if (this.f886a != null) {
            return;
        }
        this.f886a = new bf(this);
        gv.a(this.f886a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m578a().openFileInput("XMCloudCfg"));
                try {
                    this.f887a = ej.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m49a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f887a != null) {
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
        if (this.f887a != null) {
            this.f887a = new ej.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f887a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m578a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f887a.a(a2);
                a2.m171a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m49a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m557a() {
        b();
        if (this.f887a != null) {
            return this.f887a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ej.a m558a() {
        b();
        return this.f887a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m559a() {
        this.f888a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ek.b bVar) {
        a[] aVarArr;
        if (bVar.m245d() && bVar.d() > m557a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f888a.toArray(new a[this.f888a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f888a.add(aVar);
    }
}
