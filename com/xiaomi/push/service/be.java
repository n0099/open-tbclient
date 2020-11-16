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
/* loaded from: classes18.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private static be f5077a = new be();

    /* renamed from: a  reason: collision with other field name */
    private static String f886a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f887a;

    /* renamed from: a  reason: collision with other field name */
    private ej.a f888a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f889a = new ArrayList();

    /* loaded from: classes18.dex */
    public static abstract class a {
        public void a(ej.a aVar) {
        }

        public void a(ek.b bVar) {
        }
    }

    private be() {
    }

    public static be a() {
        return f5077a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m562a() {
        String str;
        synchronized (be.class) {
            if (f886a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m586a().getSharedPreferences("XMPushServiceConfig", 0);
                f886a = sharedPreferences.getString("DeviceUUID", null);
                if (f886a == null) {
                    f886a = com.xiaomi.push.i.a(com.xiaomi.push.t.m586a(), false);
                    if (f886a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f886a).commit();
                    }
                }
            }
            str = f886a;
        }
        return str;
    }

    private void b() {
        if (this.f888a == null) {
            d();
        }
    }

    private void c() {
        if (this.f887a != null) {
            return;
        }
        this.f887a = new bf(this);
        gv.a(this.f887a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m586a().openFileInput("XMCloudCfg"));
                try {
                    this.f888a = ej.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m57a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f888a != null) {
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
        if (this.f888a != null) {
            this.f888a = new ej.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f888a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m586a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f888a.a(a2);
                a2.m179a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m57a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m565a() {
        b();
        if (this.f888a != null) {
            return this.f888a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ej.a m566a() {
        b();
        return this.f888a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m567a() {
        this.f889a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ek.b bVar) {
        a[] aVarArr;
        if (bVar.m253d() && bVar.d() > m565a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f889a.toArray(new a[this.f889a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f889a.add(aVar);
    }
}
