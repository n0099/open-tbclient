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
/* loaded from: classes5.dex */
public class ba {
    private static ba a = new ba();

    /* renamed from: a  reason: collision with other field name */
    private static String f889a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f890a;

    /* renamed from: a  reason: collision with other field name */
    private ed.a f891a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f892a = new ArrayList();

    /* loaded from: classes5.dex */
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
    public static synchronized String m512a() {
        String str;
        synchronized (ba.class) {
            if (f889a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m547a().getSharedPreferences("XMPushServiceConfig", 0);
                f889a = sharedPreferences.getString("DeviceUUID", null);
                if (f889a == null) {
                    f889a = com.xiaomi.push.i.a(com.xiaomi.push.t.m547a(), false);
                    if (f889a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f889a).commit();
                    }
                }
            }
            str = f889a;
        }
        return str;
    }

    private void b() {
        if (this.f891a == null) {
            d();
        }
    }

    private void c() {
        if (this.f890a != null) {
            return;
        }
        this.f890a = new bb(this);
        gp.a(this.f890a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m547a().openFileInput("XMCloudCfg"));
                try {
                    this.f891a = ed.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m33a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f891a != null) {
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
        if (this.f891a != null) {
            this.f891a = new ed.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f891a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m547a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f891a.a(a2);
                a2.m157a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m33a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m515a() {
        b();
        if (this.f891a != null) {
            return this.f891a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ed.a m516a() {
        b();
        return this.f891a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m517a() {
        this.f892a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ee.b bVar) {
        a[] aVarArr;
        if (bVar.m227d() && bVar.d() > m515a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f892a.toArray(new a[this.f892a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f892a.add(aVar);
    }
}
