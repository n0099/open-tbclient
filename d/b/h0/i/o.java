package d.b.h0.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f49583a;

    /* renamed from: b  reason: collision with root package name */
    public int f49584b;

    /* renamed from: c  reason: collision with root package name */
    public int f49585c;

    /* renamed from: d  reason: collision with root package name */
    public String f49586d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f49587e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49589g;
    public e l;
    public d.b.h0.i.r.b m;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49588f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f49590h = 0;
    public int i = -1;
    public int j = 0;
    public long k = 0;

    public o(int i, int i2, int i3, boolean z) {
        this.f49584b = -1;
        this.f49585c = -1;
        this.f49589g = true;
        this.f49583a = i;
        this.f49584b = i2;
        this.f49585c = i3;
        this.f49589g = z;
    }

    public static o l(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f49583a, oVar.f49584b, oVar.f49585c, oVar.f49589g);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f49587e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f49585c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f49585c);
    }

    public int b() {
        return this.f49590h;
    }

    public int c() {
        return this.f49583a;
    }

    public d.b.h0.i.r.b d() {
        return this.m;
    }

    public long e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    public e g() {
        return this.l;
    }

    public String h(Context context) {
        String str = this.f49586d;
        if (str != null) {
            return str;
        }
        if (this.f49584b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f49584b);
    }

    public int i() {
        int i = this.i;
        return i == -1 ? f.aiapp_menu_item_text : i;
    }

    public boolean j() {
        return this.f49589g;
    }

    public boolean k() {
        return this.f49588f;
    }

    public void m(int i) {
        this.f49585c = i;
    }

    public void n(long j) {
        this.k = j;
    }

    public void o(int i) {
        this.j = i;
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(int i) {
        this.f49584b = i;
    }
}
