package d.b.g0.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f48862a;

    /* renamed from: b  reason: collision with root package name */
    public int f48863b;

    /* renamed from: c  reason: collision with root package name */
    public int f48864c;

    /* renamed from: d  reason: collision with root package name */
    public String f48865d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f48866e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48868g;
    public e l;
    public d.b.g0.i.r.b m;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48867f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f48869h = 0;
    public int i = -1;
    public int j = 0;
    public long k = 0;

    public o(int i, int i2, int i3, boolean z) {
        this.f48863b = -1;
        this.f48864c = -1;
        this.f48868g = true;
        this.f48862a = i;
        this.f48863b = i2;
        this.f48864c = i3;
        this.f48868g = z;
    }

    public static o l(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f48862a, oVar.f48863b, oVar.f48864c, oVar.f48868g);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f48866e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f48864c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f48864c);
    }

    public int b() {
        return this.f48869h;
    }

    public int c() {
        return this.f48862a;
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
        String str = this.f48865d;
        if (str != null) {
            return str;
        }
        if (this.f48863b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f48863b);
    }

    public int i() {
        int i = this.i;
        return i == -1 ? f.aiapp_menu_item_text : i;
    }

    public boolean j() {
        return this.f48868g;
    }

    public boolean k() {
        return this.f48867f;
    }

    public void m(int i) {
        this.f48864c = i;
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
        this.f48863b = i;
    }
}
