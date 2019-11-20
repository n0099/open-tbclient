package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.al;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.gp;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ba {
    private static ba a = new ba();

    /* renamed from: a  reason: collision with other field name */
    private static String f884a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f885a;

    /* renamed from: a  reason: collision with other field name */
    private ed.a f886a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f887a = new ArrayList();

    /* loaded from: classes3.dex */
    public static abstract class a {
        public void a(ed.a aVar) {
        }

        public void a(ee.b bVar) {
        }
    }

    private ba() {
    }

    public static ba a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m509a() {
        String str;
        synchronized (ba.class) {
            if (f884a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m544a().getSharedPreferences("XMPushServiceConfig", 0);
                f884a = sharedPreferences.getString("DeviceUUID", null);
                if (f884a == null) {
                    f884a = com.xiaomi.push.i.a(com.xiaomi.push.t.m544a(), false);
                    if (f884a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f884a).commit();
                    }
                }
            }
            str = f884a;
        }
        return str;
    }

    private void b() {
        if (this.f886a == null) {
            d();
        }
    }

    private void c() {
        if (this.f885a != null) {
            return;
        }
        this.f885a = new bb(this);
        gp.a(this.f885a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m544a().openFileInput("XMCloudCfg"));
                try {
                    this.f886a = ed.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m30a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f886a != null) {
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
        if (this.f886a != null) {
            this.f886a = new ed.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f886a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m544a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f886a.a(a2);
                a2.m154a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m30a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m512a() {
        b();
        if (this.f886a != null) {
            return this.f886a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ed.a m513a() {
        b();
        return this.f886a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m514a() {
        this.f887a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ee.b bVar) {
        a[] aVarArr;
        if (bVar.m224d() && bVar.d() > m512a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f887a.toArray(new a[this.f887a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f887a.add(aVar);
    }
}
