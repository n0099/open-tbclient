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
/* loaded from: classes6.dex */
public class ba {
    private static ba a = new ba();

    /* renamed from: a  reason: collision with other field name */
    private static String f888a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f889a;

    /* renamed from: a  reason: collision with other field name */
    private ed.a f890a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f891a = new ArrayList();

    /* loaded from: classes6.dex */
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
    public static synchronized String m521a() {
        String str;
        synchronized (ba.class) {
            if (f888a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m556a().getSharedPreferences("XMPushServiceConfig", 0);
                f888a = sharedPreferences.getString("DeviceUUID", null);
                if (f888a == null) {
                    f888a = com.xiaomi.push.i.a(com.xiaomi.push.t.m556a(), false);
                    if (f888a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f888a).commit();
                    }
                }
            }
            str = f888a;
        }
        return str;
    }

    private void b() {
        if (this.f890a == null) {
            d();
        }
    }

    private void c() {
        if (this.f889a != null) {
            return;
        }
        this.f889a = new bb(this);
        gp.a(this.f889a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m556a().openFileInput("XMCloudCfg"));
                try {
                    this.f890a = ed.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m42a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f890a != null) {
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
        if (this.f890a != null) {
            this.f890a = new ed.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f890a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m556a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f890a.a(a2);
                a2.m166a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m42a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m524a() {
        b();
        if (this.f890a != null) {
            return this.f890a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ed.a m525a() {
        b();
        return this.f890a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m526a() {
        this.f891a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ee.b bVar) {
        a[] aVarArr;
        if (bVar.m236d() && bVar.d() > m524a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f891a.toArray(new a[this.f891a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f891a.add(aVar);
    }
}
