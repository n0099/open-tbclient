package com.qq.e.comm.plugin.a;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11621a;

    /* renamed from: b  reason: collision with root package name */
    private final t f11622b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.f11621a = context;
        this.f11622b = t.a(this.f11621a);
    }

    private void a(c cVar, int i) {
        cVar.a(i);
        this.f11622b.b(cVar);
    }

    private void a(c cVar, int i, int i2) {
        cVar.a("manualPause", i2);
        a(cVar, i);
    }

    private void a(c cVar, t tVar, int i, long j) {
        cVar.a("totalSize", j);
        cVar.a("progress", i);
        tVar.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(c cVar) {
        return this.f11622b.b(cVar);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        List<c> list;
        boolean z;
        List<c> a2;
        synchronized (this) {
            try {
                a2 = this.f11622b.a();
            } catch (Throwable th) {
                th = th;
                list = null;
            }
            try {
                for (c cVar : a2) {
                    if (cVar.o() != 8) {
                        if (com.qq.e.comm.plugin.a.d.d.c(com.qq.e.comm.plugin.a.d.b.a().a(this.f11621a, cVar.h()))) {
                            a(cVar, 8);
                        } else {
                            cVar.d(1);
                            Intent a3 = j.a(this.f11621a, cVar);
                            if (a3 != null) {
                                this.f11621a.startService(a3);
                            }
                        }
                    }
                }
                z = true;
            } catch (Throwable th2) {
                th = th2;
                list = a2;
                try {
                    String th3 = th.toString();
                    GDTLogger.e(th3);
                    com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                    dVar.a("msg", th3);
                    u.a(100262, list == null ? 0 : list.size(), null, dVar);
                    z = false;
                    return z;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        try {
            c c = this.f11622b.c(i);
            if (c == null || c.o() == 8) {
                return false;
            }
            if (com.qq.e.comm.plugin.a.d.d.c(com.qq.e.comm.plugin.a.d.b.a().a(this.f11621a, c.h()))) {
                a(c, 8);
            } else {
                com.qq.e.comm.plugin.a.d.b.a().a(c.h(), 128);
                c.a(128);
                Intent a2 = j.a(this.f11621a, c);
                if (a2 != null) {
                    this.f11621a.startService(a2);
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2) {
        try {
            c b2 = this.f11622b.b(i);
            if (b2 != null) {
                com.qq.e.comm.plugin.a.d.b.a().a(b2.h(), 32);
                a(b2, 32, i2);
                return true;
            }
            return false;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, long j) {
        try {
            c a2 = this.f11622b.a(i);
            if (a2 != null) {
                a(a2, this.f11622b, i2, j);
                return true;
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.w("updateProgress err");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, String str, int i2) {
        try {
            c a2 = this.f11622b.a(i);
            if (a2 != null) {
                com.qq.e.comm.plugin.a.d.b.a().a(a2.h(), 64);
                a(a2, 64);
                NotificationManager a3 = com.qq.e.comm.plugin.d.d.a(this.f11621a);
                if (a3 != null) {
                    a3.cancel(str, i2);
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<c> b() {
        return this.f11622b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<c> c() {
        return this.f11622b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<c> d() {
        return this.f11622b.d();
    }

    public List<c> e() {
        return this.f11622b.a();
    }
}
