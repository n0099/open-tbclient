package d.b.g0.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f49254a;

    /* renamed from: b  reason: collision with root package name */
    public int f49255b;

    /* renamed from: c  reason: collision with root package name */
    public int f49256c;

    /* renamed from: d  reason: collision with root package name */
    public String f49257d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f49258e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49260g;
    public e l;
    public d.b.g0.i.r.b m;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49259f = true;

    /* renamed from: h  reason: collision with root package name */
    public int f49261h = 0;
    public int i = -1;
    public int j = 0;
    public long k = 0;

    public o(int i, int i2, int i3, boolean z) {
        this.f49255b = -1;
        this.f49256c = -1;
        this.f49260g = true;
        this.f49254a = i;
        this.f49255b = i2;
        this.f49256c = i3;
        this.f49260g = z;
    }

    public static o l(o oVar) {
        if (oVar == null) {
            return null;
        }
        return new o(oVar.f49254a, oVar.f49255b, oVar.f49256c, oVar.f49260g);
    }

    public Drawable a(Context context) {
        Drawable drawable = this.f49258e;
        if (drawable != null) {
            return drawable;
        }
        if (this.f49256c <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.f49256c);
    }

    public int b() {
        return this.f49261h;
    }

    public int c() {
        return this.f49254a;
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
        String str = this.f49257d;
        if (str != null) {
            return str;
        }
        if (this.f49255b <= 0) {
            return null;
        }
        return context.getResources().getString(this.f49255b);
    }

    public int i() {
        int i = this.i;
        return i == -1 ? f.aiapp_menu_item_text : i;
    }

    public boolean j() {
        return this.f49260g;
    }

    public boolean k() {
        return this.f49259f;
    }

    public void m(int i) {
        this.f49256c = i;
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
        this.f49255b = i;
    }
}
