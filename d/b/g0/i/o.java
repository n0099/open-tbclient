package d.b.g0.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f48861a;

    /* renamed from: b  reason: collision with root package name */
    public int f48862b;

    /* renamed from: c  reason: collision with root package name */
    public int f48863c;

    /* renamed from: d  reason: collision with root package name */
    public String f48864d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f48865e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48867g;
    public e l;
    public d.b.g0.i.r.b m;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48866f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f48868h = 0;
    public int i = -1;
    public int j = 0;
    public long k = 0;

    public o(int i, int i2, int i3, boolean z) {
        this.f48862b = -1;
        this.f48863c = -1;
        this.f48867g = true;
        this.f48861a = i;
        this.f48862b = i2;
        this.f48863c = i3;
        this.f48867g = z;
    }

    public static o l(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f48861a, oVar.f48862b, oVar.f48863c, oVar.f48867g);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f48865e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f48863c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f48863c);
    }

    public int b() {
        return this.f48868h;
    }

    public int c() {
        return this.f48861a;
    }

    public d.b.g0.i.r.b d() {
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
        String str = this.f48864d;
        if (str != null) {
            return str;
        }
        if (this.f48862b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f48862b);
    }

    public int i() {
        int i = this.i;
        return i == -1 ? f.aiapp_menu_item_text : i;
    }

    public boolean j() {
        return this.f48867g;
    }

    public boolean k() {
        return this.f48866f;
    }

    public void m(int i) {
        this.f48863c = i;
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
        this.f48862b = i;
    }
}
