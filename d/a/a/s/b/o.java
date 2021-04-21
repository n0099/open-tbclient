package d.a.a.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.s.c.a;
import java.util.List;
/* loaded from: classes.dex */
public class o implements a.b, k, m {

    /* renamed from: c  reason: collision with root package name */
    public final String f41662c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f41663d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.f f41664e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.c.a<?, PointF> f41665f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.c.a<?, PointF> f41666g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41667h;
    public boolean j;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41660a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f41661b = new RectF();
    public b i = new b();

    public o(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.f fVar2) {
        this.f41662c = fVar2.c();
        this.f41663d = fVar2.f();
        this.f41664e = fVar;
        this.f41665f = fVar2.d().a();
        this.f41666g = fVar2.e().a();
        this.f41667h = fVar2.b().a();
        aVar.i(this.f41665f);
        aVar.i(this.f41666g);
        aVar.i(this.f41667h);
        this.f41665f.a(this);
        this.f41666g.a(this);
        this.f41667h.a(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        f();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.i.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        if (t == d.a.a.k.f41588h) {
            this.f41666g.m(cVar);
        } else if (t == d.a.a.k.j) {
            this.f41665f.m(cVar);
        } else if (t == d.a.a.k.i) {
            this.f41667h.m(cVar);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        d.a.a.x.g.m(dVar, i, list, dVar2, this);
    }

    public final void f() {
        this.j = false;
        this.f41664e.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41662c;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        if (this.j) {
            return this.f41660a;
        }
        this.f41660a.reset();
        if (this.f41663d) {
            this.j = true;
            return this.f41660a;
        }
        PointF h2 = this.f41666g.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        d.a.a.s.c.a<?, Float> aVar = this.f41667h;
        float o = aVar == null ? 0.0f : ((d.a.a.s.c.c) aVar).o();
        float min = Math.min(f2, f3);
        if (o > min) {
            o = min;
        }
        PointF h3 = this.f41665f.h();
        this.f41660a.moveTo(h3.x + f2, (h3.y - f3) + o);
        this.f41660a.lineTo(h3.x + f2, (h3.y + f3) - o);
        int i = (o > 0.0f ? 1 : (o == 0.0f ? 0 : -1));
        if (i > 0) {
            RectF rectF = this.f41661b;
            float f4 = h3.x;
            float f5 = o * 2.0f;
            float f6 = h3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f41660a.arcTo(this.f41661b, 0.0f, 90.0f, false);
        }
        this.f41660a.lineTo((h3.x - f2) + o, h3.y + f3);
        if (i > 0) {
            RectF rectF2 = this.f41661b;
            float f7 = h3.x;
            float f8 = h3.y;
            float f9 = o * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f41660a.arcTo(this.f41661b, 90.0f, 90.0f, false);
        }
        this.f41660a.lineTo(h3.x - f2, (h3.y - f3) + o);
        if (i > 0) {
            RectF rectF3 = this.f41661b;
            float f10 = h3.x;
            float f11 = h3.y;
            float f12 = o * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f41660a.arcTo(this.f41661b, 180.0f, 90.0f, false);
        }
        this.f41660a.lineTo((h3.x + f2) - o, h3.y - f3);
        if (i > 0) {
            RectF rectF4 = this.f41661b;
            float f13 = h3.x;
            float f14 = o * 2.0f;
            float f15 = h3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f41660a.arcTo(this.f41661b, 270.0f, 90.0f, false);
        }
        this.f41660a.close();
        this.i.b(this.f41660a);
        this.j = true;
        return this.f41660a;
    }
}
