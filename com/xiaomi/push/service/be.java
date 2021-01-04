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
/* loaded from: classes6.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private static be f14568a = new be();

    /* renamed from: a  reason: collision with other field name */
    private static String f962a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f963a;

    /* renamed from: a  reason: collision with other field name */
    private ej.a f964a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f965a = new ArrayList();

    /* loaded from: classes6.dex */
    public static abstract class a {
        public void a(ej.a aVar) {
        }

        public void a(ek.b bVar) {
        }
    }

    private be() {
    }

    public static be a() {
        return f14568a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m578a() {
        String str;
        synchronized (be.class) {
            if (f962a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m602a().getSharedPreferences("XMPushServiceConfig", 0);
                f962a = sharedPreferences.getString("DeviceUUID", null);
                if (f962a == null) {
                    f962a = com.xiaomi.push.i.a(com.xiaomi.push.t.m602a(), false);
                    if (f962a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f962a).commit();
                    }
                }
            }
            str = f962a;
        }
        return str;
    }

    private void b() {
        if (this.f964a == null) {
            d();
        }
    }

    private void c() {
        if (this.f963a != null) {
            return;
        }
        this.f963a = new bf(this);
        gv.a(this.f963a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m602a().openFileInput("XMCloudCfg"));
                try {
                    this.f964a = ej.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m73a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f964a != null) {
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
        if (this.f964a != null) {
            this.f964a = new ej.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f964a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m602a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f964a.a(a2);
                a2.m195a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m73a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m581a() {
        b();
        if (this.f964a != null) {
            return this.f964a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ej.a m582a() {
        b();
        return this.f964a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m583a() {
        this.f965a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ek.b bVar) {
        a[] aVarArr;
        if (bVar.m269d() && bVar.d() > m581a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f965a.toArray(new a[this.f965a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f965a.add(aVar);
    }
}
