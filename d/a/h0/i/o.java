package d.a.h0.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f47088a;

    /* renamed from: b  reason: collision with root package name */
    public int f47089b;

    /* renamed from: c  reason: collision with root package name */
    public int f47090c;

    /* renamed from: d  reason: collision with root package name */
    public String f47091d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f47092e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47094g;
    public e l;
    public d.a.h0.i.r.b m;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47093f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f47095h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f47096i = -1;
    public int j = 0;
    public long k = 0;

    public o(int i2, int i3, int i4, boolean z) {
        this.f47089b = -1;
        this.f47090c = -1;
        this.f47094g = true;
        this.f47088a = i2;
        this.f47089b = i3;
        this.f47090c = i4;
        this.f47094g = z;
    }

    public static o l(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f47088a, oVar.f47089b, oVar.f47090c, oVar.f47094g);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f47092e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f47090c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f47090c);
    }

    public int b() {
        return this.f47095h;
    }

    public int c() {
        return this.f47088a;
    }

    public d.a.h0.i.r.b d() {
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
        String str = this.f47091d;
        if (str != null) {
            return str;
        }
        if (this.f47089b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f47089b);
    }

    public int i() {
        int i2 = this.f47096i;
        return i2 == -1 ? f.aiapp_menu_item_text : i2;
    }

    public boolean j() {
        return this.f47094g;
    }

    public boolean k() {
        return this.f47093f;
    }

    public void m(int i2) {
        this.f47090c = i2;
    }

    public void n(long j) {
        this.k = j;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(int i2) {
        this.f47089b = i2;
    }
}
