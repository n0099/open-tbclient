package d.a.i0.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f47775a;

    /* renamed from: b  reason: collision with root package name */
    public int f47776b;

    /* renamed from: c  reason: collision with root package name */
    public int f47777c;

    /* renamed from: d  reason: collision with root package name */
    public String f47778d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f47779e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47781g;
    public e k;
    public d.a.i0.k.r.b l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47780f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f47782h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f47783i = 0;
    public long j = 0;

    public o(int i2, int i3, int i4, boolean z) {
        this.f47776b = -1;
        this.f47777c = -1;
        this.f47781g = true;
        this.f47775a = i2;
        this.f47776b = i3;
        this.f47777c = i4;
        this.f47781g = z;
    }

    public static o k(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f47775a, oVar.f47776b, oVar.f47777c, oVar.f47781g);
    }

    public static o l(o oVar, boolean z) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f47775a, oVar.f47776b, oVar.f47777c, z);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f47779e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f47777c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f47777c);
    }

    public int b() {
        return this.f47782h;
    }

    public int c() {
        return this.f47775a;
    }

    public d.a.i0.k.r.b d() {
        return this.l;
    }

    public long e() {
        return this.j;
    }

    public int f() {
        return this.f47783i;
    }

    public e g() {
        return this.k;
    }

    public String h(Context context) {
        String str = this.f47778d;
        if (str != null) {
            return str;
        }
        if (this.f47776b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f47776b);
    }

    public boolean i() {
        return this.f47781g;
    }

    public boolean j() {
        return this.f47780f;
    }

    public void m(int i2) {
        this.f47777c = i2;
    }

    public void n(long j) {
        this.j = j;
    }

    public void o(int i2) {
        this.f47783i = i2;
    }

    public void p(e eVar) {
        this.k = eVar;
    }

    public void q(int i2) {
        this.f47776b = i2;
    }
}
