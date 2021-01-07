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
    private static be f14569a = new be();

    /* renamed from: a  reason: collision with other field name */
    private static String f963a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f964a;

    /* renamed from: a  reason: collision with other field name */
    private ej.a f965a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f966a = new ArrayList();

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
        return f14569a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m589a() {
        String str;
        synchronized (be.class) {
            if (f963a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m613a().getSharedPreferences("XMPushServiceConfig", 0);
                f963a = sharedPreferences.getString("DeviceUUID", null);
                if (f963a == null) {
                    f963a = com.xiaomi.push.i.a(com.xiaomi.push.t.m613a(), false);
                    if (f963a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f963a).commit();
                    }
                }
            }
            str = f963a;
        }
        return str;
    }

    private void b() {
        if (this.f965a == null) {
            d();
        }
    }

    private void c() {
        if (this.f964a != null) {
            return;
        }
        this.f964a = new bf(this);
        gv.a(this.f964a);
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
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m613a().openFileInput("XMCloudCfg"));
                try {
                    this.f965a = ej.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.push.y.a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.m84a("load config failure: " + e.getMessage());
                    com.xiaomi.push.y.a(bufferedInputStream);
                    if (this.f965a != null) {
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
        if (this.f965a != null) {
            this.f965a = new ej.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f965a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m613a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f965a.a(a2);
                a2.m206a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m84a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m592a() {
        b();
        if (this.f965a != null) {
            return this.f965a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ej.a m593a() {
        b();
        return this.f965a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m594a() {
        this.f966a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ek.b bVar) {
        a[] aVarArr;
        if (bVar.m280d() && bVar.d() > m592a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f966a.toArray(new a[this.f966a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f966a.add(aVar);
    }
}
