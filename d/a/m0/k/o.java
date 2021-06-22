package d.a.m0.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f51733a;

    /* renamed from: b  reason: collision with root package name */
    public int f51734b;

    /* renamed from: c  reason: collision with root package name */
    public int f51735c;

    /* renamed from: d  reason: collision with root package name */
    public String f51736d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f51737e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51739g;
    public e k;
    public d.a.m0.k.r.b l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51738f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f51740h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f51741i = 0;
    public long j = 0;

    public o(int i2, int i3, int i4, boolean z) {
        this.f51734b = -1;
        this.f51735c = -1;
        this.f51739g = true;
        this.f51733a = i2;
        this.f51734b = i3;
        this.f51735c = i4;
        this.f51739g = z;
    }

    public static o k(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f51733a, oVar.f51734b, oVar.f51735c, oVar.f51739g);
    }

    public static o l(o oVar, boolean z) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f51733a, oVar.f51734b, oVar.f51735c, z);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f51737e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f51735c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f51735c);
    }

    public int b() {
        return this.f51740h;
    }

    public int c() {
        return this.f51733a;
    }

    public d.a.m0.k.r.b d() {
        return this.l;
    }

    public long e() {
        return this.j;
    }

    public int f() {
        return this.f51741i;
    }

    public e g() {
        return this.k;
    }

    public String h(Context context) {
        String str = this.f51736d;
        if (str != null) {
            return str;
        }
        if (this.f51734b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f51734b);
    }

    public boolean i() {
        return this.f51739g;
    }

    public boolean j() {
        return this.f51738f;
    }

    public void m(int i2) {
        this.f51735c = i2;
    }

    public void n(long j) {
        this.j = j;
    }

    public void o(int i2) {
        this.f51741i = i2;
    }

    public void p(e eVar) {
        this.k = eVar;
    }

    public void q(int i2) {
        this.f51734b = i2;
    }
}
