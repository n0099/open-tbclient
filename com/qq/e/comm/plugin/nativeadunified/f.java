package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.a.i;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private h f12282a;

    /* renamed from: b  reason: collision with root package name */
    private g f12283b;
    private com.qq.e.comm.plugin.c.a.a c;
    private com.qq.e.comm.plugin.y.c d;
    private Context e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public enum a {
        DEFAULT,
        FAILED,
        SUCCESS
    }

    public f(g gVar, h hVar, com.qq.e.comm.plugin.c.a.a aVar, Context context, com.qq.e.comm.plugin.y.c cVar) {
        this(gVar, hVar, aVar, context, cVar, false);
    }

    public f(g gVar, h hVar, com.qq.e.comm.plugin.c.a.a aVar, Context context, com.qq.e.comm.plugin.y.c cVar, boolean z) {
        this.f12283b = gVar;
        this.f12282a = hVar;
        this.c = aVar;
        this.d = cVar;
        this.e = context;
        this.f = z;
    }

    private a a() {
        if (this.f12283b.i == 1 && com.qq.e.comm.plugin.util.b.a(this.f12282a.a_())) {
            String e = com.qq.e.comm.plugin.util.b.e(this.f12282a.E());
            if (az.b(e)) {
                if (!com.qq.e.comm.plugin.w.a.c.a(this.e.getApplicationContext(), this.f12282a.al(), e, this.f12282a.m(), null)) {
                    u.a(30212, 2, this.d);
                    return a.FAILED;
                }
                if (!this.f12283b.f12289b) {
                    this.f12283b.a((View) this.f12283b.f12288a);
                }
                u.a(30212, 1, this.d);
                return a.SUCCESS;
            }
        }
        u.a(30212, 3, this.d);
        return a.DEFAULT;
    }

    private void a(View view, int i) {
        a(view, i, -1);
    }

    private void a(View view, int i, int i2) {
        a(view, i, i2, false);
    }

    private void a(View view, int i, int i2, boolean z) {
        this.f12283b.a(view, i, this.f12283b.getTitle(), this.f12283b.p(), this.f12283b.o(), this.f12283b.m(), this.f12283b.isAppAd(), i2, false, z);
    }

    private void a(View view, final a aVar) {
        this.f12283b.a(2, new Object[]{""});
        if (!this.f12283b.f12289b) {
            this.f12283b.a((View) this.f12283b.f12288a);
        }
        d.a a2 = com.qq.e.comm.plugin.w.i.a(this.f12282a);
        d.e eVar = new d.e(this.f12283b.o(), com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, this.f12283b.p());
        d.b a3 = this.f12283b.a(view, 0, this.f12283b.p(), this.f12283b.m(), this.f12283b.isAppAd(), -1, false);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f12283b.f12288a);
        if (((Boolean) com.qq.e.comm.plugin.w.a.i.a(view, a2, a3, eVar, new i.a() { // from class: com.qq.e.comm.plugin.nativeadunified.f.1
            @Override // com.qq.e.comm.plugin.w.a.i.a
            public void a(String str, boolean z) {
                if (aVar == a.FAILED && z) {
                    com.qq.e.comm.plugin.w.a.a(str);
                }
            }
        }).second).booleanValue()) {
            return;
        }
        this.f12283b.c(false);
    }

    private void b(boolean z) {
        com.qq.e.comm.plugin.c.e.a(new f.a(this.f12282a, this.f12283b.f12288a).b(this.f12283b.j).a(z).a(this.f12283b.m()).a(), this.c);
        this.f12283b.a(2, new Object[]{""});
    }

    private boolean b() {
        return this.f12282a.ah();
    }

    private void c(boolean z) {
        d(z);
    }

    private void d(boolean z) {
        boolean b2 = b();
        if (!b2 || z || !this.f12283b.j) {
            if (b2 && !this.f12283b.f12289b) {
                this.f12283b.l();
            }
            a(this.f12283b.d, 0, -1, z);
        } else if (this.f12283b.f == null || this.f12283b.e == null) {
            GDTLogger.e("VideoView未初始化完成，不可点击");
        } else {
            if (this.f12283b.f.getVisibility() != 0) {
                this.f12283b.f.setVisibility(0);
            }
            boolean z2 = this.f12283b.i == 1;
            if (z2 && com.qq.e.comm.plugin.util.b.b(this.f12282a)) {
                a(this.f12283b.d, (a) null);
                return;
            }
            a a2 = a();
            if (a2 == a.SUCCESS) {
                a(this.f12283b.d, 4);
            } else if (z2 && com.qq.e.comm.plugin.util.b.c(this.f12282a)) {
                a(this.f12283b.d, a2);
            } else if (z2 && this.f12283b.isAppAd() && !this.f12282a.w()) {
                if (a2 == a.FAILED) {
                    a(this.f12283b.d, 3);
                } else {
                    a(this.f12283b.d, 1);
                }
                this.f12283b.c(false);
            } else if (a2 == a.FAILED) {
                this.f12283b.a(2, new Object[]{""});
                this.f12283b.c(true);
            } else {
                this.f12283b.a(2, new Object[]{""});
                this.f12283b.c(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (com.qq.e.comm.plugin.c.e.a(this.f12282a)) {
            b(false);
        } else {
            d(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12283b.o == null || this.f12283b.o.a()) {
            GDTLogger.d("report click event");
            if (!this.f12283b.a(this.f12283b.f12288a, view)) {
                u.a(30082, 0, this.d);
                GDTLogger.e("clicked view is not in NativeAdContainer");
                return;
            }
            this.f12283b.c.b(System.currentTimeMillis());
            if (!this.f12283b.t() || !this.f12283b.m) {
                if (com.qq.e.comm.plugin.c.e.a(this.f12282a)) {
                    b(this.f);
                } else {
                    a(view, 0, -1, this.f);
                }
                u.a(30192, 1, this.d);
            } else if ((view == this.f12283b.d || view == this.f12283b.n) && this.f12283b.k) {
                this.f12283b.s();
            } else {
                if (com.qq.e.comm.plugin.c.e.a(this.f12282a)) {
                    b(this.f);
                } else {
                    c(this.f);
                }
                u.a(30192, 2, this.d);
            }
        }
    }
}
