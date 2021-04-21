package d.a.a.s.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.a.s.c.a;
import java.util.Collections;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f41707a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f41708b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f41709c;

    /* renamed from: d  reason: collision with root package name */
    public final Matrix f41710d;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f41711e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public a<PointF, PointF> f41712f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public a<?, PointF> f41713g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public a<d.a.a.y.d, d.a.a.y.d> f41714h;
    @NonNull
    public a<Float, Float> i;
    @NonNull
    public a<Integer, Integer> j;
    @Nullable
    public c k;
    @Nullable
    public c l;
    @Nullable
    public a<?, Float> m;
    @Nullable
    public a<?, Float> n;

    public o(d.a.a.u.i.l lVar) {
        this.f41712f = lVar.c() == null ? null : lVar.c().a();
        this.f41713g = lVar.f() == null ? null : lVar.f().a();
        this.f41714h = lVar.h() == null ? null : lVar.h().a();
        this.i = lVar.g() == null ? null : lVar.g().a();
        c cVar = lVar.i() == null ? null : (c) lVar.i().a();
        this.k = cVar;
        if (cVar != null) {
            this.f41708b = new Matrix();
            this.f41709c = new Matrix();
            this.f41710d = new Matrix();
            this.f41711e = new float[9];
        } else {
            this.f41708b = null;
            this.f41709c = null;
            this.f41710d = null;
            this.f41711e = null;
        }
        this.l = lVar.j() == null ? null : (c) lVar.j().a();
        if (lVar.e() != null) {
            this.j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.m = lVar.k().a();
        } else {
            this.m = null;
        }
        if (lVar.d() != null) {
            this.n = lVar.d().a();
        } else {
            this.n = null;
        }
    }

    public void a(d.a.a.u.k.a aVar) {
        aVar.i(this.j);
        aVar.i(this.m);
        aVar.i(this.n);
        aVar.i(this.f41712f);
        aVar.i(this.f41713g);
        aVar.i(this.f41714h);
        aVar.i(this.i);
        aVar.i(this.k);
        aVar.i(this.l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f41712f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f41713g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<d.a.a.y.d, d.a.a.y.d> aVar6 = this.f41714h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public <T> boolean c(T t, @Nullable d.a.a.y.c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == d.a.a.k.f41585e) {
            a<PointF, PointF> aVar3 = this.f41712f;
            if (aVar3 == null) {
                this.f41712f = new p(cVar, new PointF());
                return true;
            }
            aVar3.m(cVar);
            return true;
        } else if (t == d.a.a.k.f41586f) {
            a<?, PointF> aVar4 = this.f41713g;
            if (aVar4 == null) {
                this.f41713g = new p(cVar, new PointF());
                return true;
            }
            aVar4.m(cVar);
            return true;
        } else if (t == d.a.a.k.k) {
            a<d.a.a.y.d, d.a.a.y.d> aVar5 = this.f41714h;
            if (aVar5 == null) {
                this.f41714h = new p(cVar, new d.a.a.y.d());
                return true;
            }
            aVar5.m(cVar);
            return true;
        } else if (t == d.a.a.k.l) {
            a<Float, Float> aVar6 = this.i;
            if (aVar6 == null) {
                this.i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.m(cVar);
            return true;
        } else if (t == d.a.a.k.f41583c) {
            a<Integer, Integer> aVar7 = this.j;
            if (aVar7 == null) {
                this.j = new p(cVar, 100);
                return true;
            }
            aVar7.m(cVar);
            return true;
        } else if (t == d.a.a.k.y && (aVar2 = this.m) != null) {
            if (aVar2 == null) {
                this.m = new p(cVar, 100);
                return true;
            }
            aVar2.m(cVar);
            return true;
        } else if (t == d.a.a.k.z && (aVar = this.n) != null) {
            if (aVar == null) {
                this.n = new p(cVar, 100);
                return true;
            }
            aVar.m(cVar);
            return true;
        } else if (t == d.a.a.k.m && (cVar3 = this.k) != null) {
            if (cVar3 == null) {
                this.k = new c(Collections.singletonList(new d.a.a.y.a(Float.valueOf(0.0f))));
            }
            this.k.m(cVar);
            return true;
        } else if (t != d.a.a.k.n || (cVar2 = this.l) == null) {
            return false;
        } else {
            if (cVar2 == null) {
                this.l = new c(Collections.singletonList(new d.a.a.y.a(Float.valueOf(0.0f))));
            }
            this.l.m(cVar);
            return true;
        }
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.f41711e[i] = 0.0f;
        }
    }

    @Nullable
    public a<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        float o;
        this.f41707a.reset();
        a<?, PointF> aVar = this.f41713g;
        if (aVar != null) {
            PointF h2 = aVar.h();
            if (h2.x != 0.0f || h2.y != 0.0f) {
                this.f41707a.preTranslate(h2.x, h2.y);
            }
        }
        a<Float, Float> aVar2 = this.i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                o = aVar2.h().floatValue();
            } else {
                o = ((c) aVar2).o();
            }
            if (o != 0.0f) {
                this.f41707a.preRotate(o);
            }
        }
        if (this.k != null) {
            c cVar = this.l;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.o()) + 90.0f));
            c cVar2 = this.l;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.o()) + 90.0f));
            d();
            float[] fArr = this.f41711e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f41708b.setValues(fArr);
            d();
            float[] fArr2 = this.f41711e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.k.o()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f41709c.setValues(fArr2);
            d();
            float[] fArr3 = this.f41711e;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f41710d.setValues(fArr3);
            this.f41709c.preConcat(this.f41708b);
            this.f41710d.preConcat(this.f41709c);
            this.f41707a.preConcat(this.f41710d);
        }
        a<d.a.a.y.d, d.a.a.y.d> aVar3 = this.f41714h;
        if (aVar3 != null) {
            d.a.a.y.d h3 = aVar3.h();
            if (h3.b() != 1.0f || h3.c() != 1.0f) {
                this.f41707a.preScale(h3.b(), h3.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f41712f;
        if (aVar4 != null) {
            PointF h4 = aVar4.h();
            if (h4.x != 0.0f || h4.y != 0.0f) {
                this.f41707a.preTranslate(-h4.x, -h4.y);
            }
        }
        return this.f41707a;
    }

    public Matrix g(float f2) {
        a<?, PointF> aVar = this.f41713g;
        PointF h2 = aVar == null ? null : aVar.h();
        a<d.a.a.y.d, d.a.a.y.d> aVar2 = this.f41714h;
        d.a.a.y.d h3 = aVar2 == null ? null : aVar2.h();
        this.f41707a.reset();
        if (h2 != null) {
            this.f41707a.preTranslate(h2.x * f2, h2.y * f2);
        }
        if (h3 != null) {
            double d2 = f2;
            this.f41707a.preScale((float) Math.pow(h3.b(), d2), (float) Math.pow(h3.c(), d2));
        }
        a<Float, Float> aVar3 = this.i;
        if (aVar3 != null) {
            float floatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f41712f;
            PointF h4 = aVar4 != null ? aVar4.h() : null;
            this.f41707a.preRotate(floatValue * f2, h4 == null ? 0.0f : h4.x, h4 != null ? h4.y : 0.0f);
        }
        return this.f41707a;
    }

    @Nullable
    public a<?, Integer> h() {
        return this.j;
    }

    @Nullable
    public a<?, Float> i() {
        return this.m;
    }

    public void j(float f2) {
        a<Integer, Integer> aVar = this.j;
        if (aVar != null) {
            aVar.l(f2);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.l(f2);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.l(f2);
        }
        a<PointF, PointF> aVar4 = this.f41712f;
        if (aVar4 != null) {
            aVar4.l(f2);
        }
        a<?, PointF> aVar5 = this.f41713g;
        if (aVar5 != null) {
            aVar5.l(f2);
        }
        a<d.a.a.y.d, d.a.a.y.d> aVar6 = this.f41714h;
        if (aVar6 != null) {
            aVar6.l(f2);
        }
        a<Float, Float> aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.l(f2);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.l(f2);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.l(f2);
        }
    }
}
