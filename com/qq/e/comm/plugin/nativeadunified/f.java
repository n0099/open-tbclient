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
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private h f12579a;

    /* renamed from: b  reason: collision with root package name */
    private g f12580b;
    private com.qq.e.comm.plugin.c.a.a c;
    private com.qq.e.comm.plugin.y.c d;
    private Context e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum a {
        DEFAULT,
        FAILED,
        SUCCESS
    }

    public f(g gVar, h hVar, com.qq.e.comm.plugin.c.a.a aVar, Context context, com.qq.e.comm.plugin.y.c cVar) {
        this(gVar, hVar, aVar, context, cVar, false);
    }

    public f(g gVar, h hVar, com.qq.e.comm.plugin.c.a.a aVar, Context context, com.qq.e.comm.plugin.y.c cVar, boolean z) {
        this.f12580b = gVar;
        this.f12579a = hVar;
        this.c = aVar;
        this.d = cVar;
        this.e = context;
        this.f = z;
    }

    private a a() {
        if (this.f12580b.i == 1 && com.qq.e.comm.plugin.util.b.a(this.f12579a.a_())) {
            String e = com.qq.e.comm.plugin.util.b.e(this.f12579a.E());
            if (az.b(e)) {
                if (!com.qq.e.comm.plugin.w.a.c.a(this.e.getApplicationContext(), this.f12579a.al(), e, this.f12579a.m(), null)) {
                    u.a(30212, 2, this.d);
                    return a.FAILED;
                }
                if (!this.f12580b.f12586b) {
                    this.f12580b.a((View) this.f12580b.f12585a);
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
        this.f12580b.a(view, i, this.f12580b.getTitle(), this.f12580b.p(), this.f12580b.o(), this.f12580b.m(), this.f12580b.isAppAd(), i2, false, z);
    }

    private void a(View view, final a aVar) {
        this.f12580b.a(2, new Object[]{""});
        if (!this.f12580b.f12586b) {
            this.f12580b.a((View) this.f12580b.f12585a);
        }
        d.a a2 = com.qq.e.comm.plugin.w.i.a(this.f12579a);
        d.e eVar = new d.e(this.f12580b.o(), com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, this.f12580b.p());
        d.b a3 = this.f12580b.a(view, 0, this.f12580b.p(), this.f12580b.m(), this.f12580b.isAppAd(), -1, false);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f12580b.f12585a);
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
        this.f12580b.c(false);
    }

    private void b(boolean z) {
        com.qq.e.comm.plugin.c.e.a(new f.a(this.f12579a, this.f12580b.f12585a).b(this.f12580b.j).a(z).a(this.f12580b.m()).a(), this.c);
        this.f12580b.a(2, new Object[]{""});
    }

    private boolean b() {
        return this.f12579a.ah();
    }

    private void c(boolean z) {
        d(z);
    }

    private void d(boolean z) {
        boolean b2 = b();
        if (!b2 || z || !this.f12580b.j) {
            if (b2 && !this.f12580b.f12586b) {
                this.f12580b.l();
            }
            a(this.f12580b.d, 0, -1, z);
        } else if (this.f12580b.f == null || this.f12580b.e == null) {
            GDTLogger.e("VideoView未初始化完成，不可点击");
        } else {
            if (this.f12580b.f.getVisibility() != 0) {
                this.f12580b.f.setVisibility(0);
            }
            boolean z2 = this.f12580b.i == 1;
            if (z2 && com.qq.e.comm.plugin.util.b.b(this.f12579a)) {
                a(this.f12580b.d, (a) null);
                return;
            }
            a a2 = a();
            if (a2 == a.SUCCESS) {
                a(this.f12580b.d, 4);
            } else if (z2 && com.qq.e.comm.plugin.util.b.c(this.f12579a)) {
                a(this.f12580b.d, a2);
            } else if (z2 && this.f12580b.isAppAd() && !this.f12579a.w()) {
                if (a2 == a.FAILED) {
                    a(this.f12580b.d, 3);
                } else {
                    a(this.f12580b.d, 1);
                }
                this.f12580b.c(false);
            } else if (a2 == a.FAILED) {
                this.f12580b.a(2, new Object[]{""});
                this.f12580b.c(true);
            } else {
                this.f12580b.a(2, new Object[]{""});
                this.f12580b.c(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (com.qq.e.comm.plugin.c.e.a(this.f12579a)) {
            b(false);
        } else {
            d(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12580b.o == null || this.f12580b.o.a()) {
            GDTLogger.d("report click event");
            if (!this.f12580b.a(this.f12580b.f12585a, view)) {
                u.a(30082, 0, this.d);
                GDTLogger.e("clicked view is not in NativeAdContainer");
                return;
            }
            this.f12580b.c.b(System.currentTimeMillis());
            if (!this.f12580b.t() || !this.f12580b.m) {
                if (com.qq.e.comm.plugin.c.e.a(this.f12579a)) {
                    b(this.f);
                } else {
                    a(view, 0, -1, this.f);
                }
                u.a(30192, 1, this.d);
            } else if ((view == this.f12580b.d || view == this.f12580b.n) && this.f12580b.k) {
                this.f12580b.s();
            } else {
                if (com.qq.e.comm.plugin.c.e.a(this.f12579a)) {
                    b(this.f);
                } else {
                    c(this.f);
                }
                u.a(30192, 2, this.d);
            }
        }
    }
}
