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
/* loaded from: classes8.dex */
public class be {
    private static be a = new be();

    /* renamed from: a  reason: collision with other field name */
    private static String f882a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f883a;

    /* renamed from: a  reason: collision with other field name */
    private ej.a f884a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f885a = new ArrayList();

    /* loaded from: classes8.dex */
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
    public static synchronized String m556a() {
        String str;
        synchronized (be.class) {
            if (f882a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m580a().getSharedPreferences("XMPushServiceConfig", 0);
                f882a = sharedPreferences.getString("DeviceUUID", null);
                if (f882a == null) {
                    f882a = com.xiaomi.push.i.a(com.xiaomi.push.t.m580a(), false);
                    if (f882a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f882a).commit();
                    }
                }
            }
            str = f882a;
        }
        return str;
    }

    private void b() {
        if (this.f884a == null) {
            d();
        }
    }

    private void c() {
        if (this.f883a != null) {
            return;
        }
        this.f883a = new bf(this);
        gv.a(this.f883a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m580a().openFileInput("XMCloudCfg"));
                try {
                    this.f884a = ej.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m51a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f884a != null) {
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
        if (this.f884a != null) {
            this.f884a = new ej.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f884a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m580a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f884a.a(a2);
                a2.m173a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m51a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m559a() {
        b();
        if (this.f884a != null) {
            return this.f884a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ej.a m560a() {
        b();
        return this.f884a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m561a() {
        this.f885a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ek.b bVar) {
        a[] aVarArr;
        if (bVar.m247d() && bVar.d() > m559a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f885a.toArray(new a[this.f885a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f885a.add(aVar);
    }
}
