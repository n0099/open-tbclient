package d.a.l0.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f47951a;

    /* renamed from: b  reason: collision with root package name */
    public int f47952b;

    /* renamed from: c  reason: collision with root package name */
    public int f47953c;

    /* renamed from: d  reason: collision with root package name */
    public String f47954d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f47955e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47957g;
    public e k;
    public d.a.l0.k.r.b l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47956f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f47958h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f47959i = 0;
    public long j = 0;

    public o(int i2, int i3, int i4, boolean z) {
        this.f47952b = -1;
        this.f47953c = -1;
        this.f47957g = true;
        this.f47951a = i2;
        this.f47952b = i3;
        this.f47953c = i4;
        this.f47957g = z;
    }

    public static o k(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f47951a, oVar.f47952b, oVar.f47953c, oVar.f47957g);
    }

    public static o l(o oVar, boolean z) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f47951a, oVar.f47952b, oVar.f47953c, z);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f47955e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f47953c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f47953c);
    }

    public int b() {
        return this.f47958h;
    }

    public int c() {
        return this.f47951a;
    }

    public d.a.l0.k.r.b d() {
        return this.l;
    }

    public long e() {
        return this.j;
    }

    public int f() {
        return this.f47959i;
    }

    public e g() {
        return this.k;
    }

    public String h(Context context) {
        String str = this.f47954d;
        if (str != null) {
            return str;
        }
        if (this.f47952b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f47952b);
    }

    public boolean i() {
        return this.f47957g;
    }

    public boolean j() {
        return this.f47956f;
    }

    public void m(int i2) {
        this.f47953c = i2;
    }

    public void n(long j) {
        this.j = j;
    }

    public void o(int i2) {
        this.f47959i = i2;
    }

    public void p(e eVar) {
        this.k = eVar;
    }

    public void q(int i2) {
        this.f47952b = i2;
    }
}
