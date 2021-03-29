package d.a.a.q.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import d.a.a.q.b.a;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f41306a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f41307b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f41308c;

    /* renamed from: d  reason: collision with root package name */
    public final a<d.a.a.w.d, d.a.a.w.d> f41309d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f41310e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f41311f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f41312g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f41313h;

    public o(d.a.a.s.i.l lVar) {
        this.f41307b = lVar.c().a();
        this.f41308c = lVar.f().a();
        this.f41309d = lVar.h().a();
        this.f41310e = lVar.g().a();
        this.f41311f = lVar.e().a();
        if (lVar.i() != null) {
            this.f41312g = lVar.i().a();
        } else {
            this.f41312g = null;
        }
        if (lVar.d() != null) {
            this.f41313h = lVar.d().a();
        } else {
            this.f41313h = null;
        }
    }

    public void a(d.a.a.s.k.a aVar) {
        aVar.h(this.f41307b);
        aVar.h(this.f41308c);
        aVar.h(this.f41309d);
        aVar.h(this.f41310e);
        aVar.h(this.f41311f);
        a<?, Float> aVar2 = this.f41312g;
        if (aVar2 != null) {
            aVar.h(aVar2);
        }
        a<?, Float> aVar3 = this.f41313h;
        if (aVar3 != null) {
            aVar.h(aVar3);
        }
    }

    public void b(a.InterfaceC0529a interfaceC0529a) {
        this.f41307b.a(interfaceC0529a);
        this.f41308c.a(interfaceC0529a);
        this.f41309d.a(interfaceC0529a);
        this.f41310e.a(interfaceC0529a);
        this.f41311f.a(interfaceC0529a);
        a<?, Float> aVar = this.f41312g;
        if (aVar != null) {
            aVar.a(interfaceC0529a);
        }
        a<?, Float> aVar2 = this.f41313h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0529a);
        }
    }

    public <T> boolean c(T t, @Nullable d.a.a.w.c<T> cVar) {
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == d.a.a.j.f41184e) {
            this.f41307b.m(cVar);
            return true;
        } else if (t == d.a.a.j.f41185f) {
            this.f41308c.m(cVar);
            return true;
        } else if (t == d.a.a.j.i) {
            this.f41309d.m(cVar);
            return true;
        } else if (t == d.a.a.j.j) {
            this.f41310e.m(cVar);
            return true;
        } else if (t == d.a.a.j.f41182c) {
            this.f41311f.m(cVar);
            return true;
        } else if (t == d.a.a.j.u && (aVar2 = this.f41312g) != null) {
            aVar2.m(cVar);
            return true;
        } else if (t != d.a.a.j.v || (aVar = this.f41313h) == null) {
            return false;
        } else {
            aVar.m(cVar);
            return true;
        }
    }

    @Nullable
    public a<?, Float> d() {
        return this.f41313h;
    }

    public Matrix e() {
        this.f41306a.reset();
        PointF h2 = this.f41308c.h();
        if (h2.x != 0.0f || h2.y != 0.0f) {
            this.f41306a.preTranslate(h2.x, h2.y);
        }
        float floatValue = this.f41310e.h().floatValue();
        if (floatValue != 0.0f) {
            this.f41306a.preRotate(floatValue);
        }
        d.a.a.w.d h3 = this.f41309d.h();
        if (h3.a() != 1.0f || h3.b() != 1.0f) {
            this.f41306a.preScale(h3.a(), h3.b());
        }
        PointF h4 = this.f41307b.h();
        if (h4.x != 0.0f || h4.y != 0.0f) {
            this.f41306a.preTranslate(-h4.x, -h4.y);
        }
        return this.f41306a;
    }

    public Matrix f(float f2) {
        PointF h2 = this.f41308c.h();
        PointF h3 = this.f41307b.h();
        d.a.a.w.d h4 = this.f41309d.h();
        float floatValue = this.f41310e.h().floatValue();
        this.f41306a.reset();
        this.f41306a.preTranslate(h2.x * f2, h2.y * f2);
        double d2 = f2;
        this.f41306a.preScale((float) Math.pow(h4.a(), d2), (float) Math.pow(h4.b(), d2));
        this.f41306a.preRotate(floatValue * f2, h3.x, h3.y);
        return this.f41306a;
    }

    public a<?, Integer> g() {
        return this.f41311f;
    }

    @Nullable
    public a<?, Float> h() {
        return this.f41312g;
    }

    public void i(float f2) {
        this.f41307b.l(f2);
        this.f41308c.l(f2);
        this.f41309d.l(f2);
        this.f41310e.l(f2);
        this.f41311f.l(f2);
        a<?, Float> aVar = this.f41312g;
        if (aVar != null) {
            aVar.l(f2);
        }
        a<?, Float> aVar2 = this.f41313h;
        if (aVar2 != null) {
            aVar2.l(f2);
        }
    }
}
