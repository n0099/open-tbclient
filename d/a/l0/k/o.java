package d.a.l0.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f51625a;

    /* renamed from: b  reason: collision with root package name */
    public int f51626b;

    /* renamed from: c  reason: collision with root package name */
    public int f51627c;

    /* renamed from: d  reason: collision with root package name */
    public String f51628d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f51629e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51631g;
    public e k;
    public d.a.l0.k.r.b l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51630f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f51632h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f51633i = 0;
    public long j = 0;

    public o(int i2, int i3, int i4, boolean z) {
        this.f51626b = -1;
        this.f51627c = -1;
        this.f51631g = true;
        this.f51625a = i2;
        this.f51626b = i3;
        this.f51627c = i4;
        this.f51631g = z;
    }

    public static o k(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f51625a, oVar.f51626b, oVar.f51627c, oVar.f51631g);
    }

    public static o l(o oVar, boolean z) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f51625a, oVar.f51626b, oVar.f51627c, z);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f51629e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f51627c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f51627c);
    }

    public int b() {
        return this.f51632h;
    }

    public int c() {
        return this.f51625a;
    }

    public d.a.l0.k.r.b d() {
        return this.l;
    }

    public long e() {
        return this.j;
    }

    public int f() {
        return this.f51633i;
    }

    public e g() {
        return this.k;
    }

    public String h(Context context) {
        String str = this.f51628d;
        if (str != null) {
            return str;
        }
        if (this.f51626b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f51626b);
    }

    public boolean i() {
        return this.f51631g;
    }

    public boolean j() {
        return this.f51630f;
    }

    public void m(int i2) {
        this.f51627c = i2;
    }

    public void n(long j) {
        this.j = j;
    }

    public void o(int i2) {
        this.f51633i = i2;
    }

    public void p(e eVar) {
        this.k = eVar;
    }

    public void q(int i2) {
        this.f51626b = i2;
    }
}
