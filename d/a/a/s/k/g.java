package d.a.a.s.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.p;
import d.a.a.q.b.n;
import d.a.a.s.i.k;
import d.a.a.s.j.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends d.a.a.s.k.a {
    public final Paint A;
    public final Map<d.a.a.s.d, List<d.a.a.q.a.c>> B;
    public final n C;
    public final d.a.a.f D;
    public final d.a.a.d E;
    @Nullable
    public d.a.a.q.b.a<Integer, Integer> F;
    @Nullable
    public d.a.a.q.b.a<Integer, Integer> G;
    @Nullable
    public d.a.a.q.b.a<Float, Float> H;
    @Nullable
    public d.a.a.q.b.a<Float, Float> I;
    public final char[] w;
    public final RectF x;
    public final Matrix y;
    public final Paint z;

    /* loaded from: classes.dex */
    public class a extends Paint {
        public a(g gVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Paint {
        public b(g gVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public g(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        d.a.a.s.i.b bVar;
        d.a.a.s.i.b bVar2;
        d.a.a.s.i.a aVar;
        d.a.a.s.i.a aVar2;
        this.w = new char[1];
        this.x = new RectF();
        this.y = new Matrix();
        this.z = new a(this, 1);
        this.A = new b(this, 1);
        this.B = new HashMap();
        this.D = fVar;
        this.E = layer.a();
        n a2 = layer.q().a();
        this.C = a2;
        a2.a(this);
        h(this.C);
        k r = layer.r();
        if (r != null && (aVar2 = r.f41352a) != null) {
            d.a.a.q.b.a<Integer, Integer> a3 = aVar2.a();
            this.F = a3;
            a3.a(this);
            h(this.F);
        }
        if (r != null && (aVar = r.f41353b) != null) {
            d.a.a.q.b.a<Integer, Integer> a4 = aVar.a();
            this.G = a4;
            a4.a(this);
            h(this.G);
        }
        if (r != null && (bVar2 = r.f41354c) != null) {
            d.a.a.q.b.a<Float, Float> a5 = bVar2.a();
            this.H = a5;
            a5.a(this);
            h(this.H);
        }
        if (r == null || (bVar = r.f41355d) == null) {
            return;
        }
        d.a.a.q.b.a<Float, Float> a6 = bVar.a();
        this.I = a6;
        a6.a(this);
        h(this.I);
    }

    public final void C(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    public final void D(d.a.a.s.d dVar, Matrix matrix, float f2, d.a.a.s.b bVar, Canvas canvas) {
        List<d.a.a.q.a.c> I = I(dVar);
        for (int i = 0; i < I.size(); i++) {
            Path path = I.get(i).getPath();
            path.computeBounds(this.x, false);
            this.y.set(matrix);
            this.y.preTranslate(0.0f, ((float) (-bVar.f41333g)) * d.a.a.v.f.e());
            this.y.preScale(f2, f2);
            path.transform(this.y);
            if (bVar.k) {
                F(path, this.z, canvas);
                F(path, this.A, canvas);
            } else {
                F(path, this.A, canvas);
                F(path, this.z, canvas);
            }
        }
    }

    public final void E(char c2, d.a.a.s.b bVar, Canvas canvas) {
        char[] cArr = this.w;
        cArr[0] = c2;
        if (bVar.k) {
            C(cArr, this.z, canvas);
            C(this.w, this.A, canvas);
            return;
        }
        C(cArr, this.A, canvas);
        C(this.w, this.z, canvas);
    }

    public final void F(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void G(d.a.a.s.b bVar, Matrix matrix, d.a.a.s.c cVar, Canvas canvas) {
        float f2 = ((float) bVar.f41329c) / 100.0f;
        float f3 = d.a.a.v.f.f(matrix);
        String str = bVar.f41327a;
        for (int i = 0; i < str.length(); i++) {
            d.a.a.s.d dVar = this.E.c().get(d.a.a.s.d.c(str.charAt(i), cVar.a(), cVar.c()));
            if (dVar != null) {
                D(dVar, matrix, f2, bVar, canvas);
                float b2 = ((float) dVar.b()) * f2 * d.a.a.v.f.e() * f3;
                float f4 = bVar.f41331e / 10.0f;
                d.a.a.q.b.a<Float, Float> aVar = this.I;
                if (aVar != null) {
                    f4 += aVar.h().floatValue();
                }
                canvas.translate(b2 + (f4 * f3), 0.0f);
            }
        }
    }

    public final void H(d.a.a.s.b bVar, d.a.a.s.c cVar, Matrix matrix, Canvas canvas) {
        float f2 = d.a.a.v.f.f(matrix);
        Typeface C = this.D.C(cVar.a(), cVar.c());
        if (C == null) {
            return;
        }
        String str = bVar.f41327a;
        p B = this.D.B();
        if (B == null) {
            this.z.setTypeface(C);
            Paint paint = this.z;
            double d2 = bVar.f41329c;
            double e2 = d.a.a.v.f.e();
            Double.isNaN(e2);
            paint.setTextSize((float) (d2 * e2));
            this.A.setTypeface(this.z.getTypeface());
            this.A.setTextSize(this.z.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                E(charAt, bVar, canvas);
                char[] cArr = this.w;
                cArr[0] = charAt;
                float measureText = this.z.measureText(cArr, 0, 1);
                float f3 = bVar.f41331e / 10.0f;
                d.a.a.q.b.a<Float, Float> aVar = this.I;
                if (aVar != null) {
                    f3 += aVar.h().floatValue();
                }
                canvas.translate(measureText + (f3 * f2), 0.0f);
            }
            return;
        }
        B.a(str);
        throw null;
    }

    public final List<d.a.a.q.a.c> I(d.a.a.s.d dVar) {
        if (this.B.containsKey(dVar)) {
            return this.B.get(dVar);
        }
        List<j> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new d.a.a.q.a.c(this.D, this, a2.get(i)));
        }
        this.B.put(dVar, arrayList);
        return arrayList;
    }

    @Override // d.a.a.s.k.a, d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        d.a.a.q.b.a<Float, Float> aVar;
        d.a.a.q.b.a<Float, Float> aVar2;
        d.a.a.q.b.a<Integer, Integer> aVar3;
        d.a.a.q.b.a<Integer, Integer> aVar4;
        super.d(t, cVar);
        if (t == d.a.a.j.f41179a && (aVar4 = this.F) != null) {
            aVar4.m(cVar);
        } else if (t == d.a.a.j.f41180b && (aVar3 = this.G) != null) {
            aVar3.m(cVar);
        } else if (t == d.a.a.j.k && (aVar2 = this.H) != null) {
            aVar2.m(cVar);
        } else if (t != d.a.a.j.l || (aVar = this.I) == null) {
        } else {
            aVar.m(cVar);
        }
    }

    @Override // d.a.a.s.k.a
    public void m(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.D.l0()) {
            canvas.setMatrix(matrix);
        }
        d.a.a.s.b h2 = this.C.h();
        d.a.a.s.c cVar = this.E.g().get(h2.f41328b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        d.a.a.q.b.a<Integer, Integer> aVar = this.F;
        if (aVar != null) {
            this.z.setColor(aVar.h().intValue());
        } else {
            this.z.setColor(h2.f41334h);
        }
        d.a.a.q.b.a<Integer, Integer> aVar2 = this.G;
        if (aVar2 != null) {
            this.A.setColor(aVar2.h().intValue());
        } else {
            this.A.setColor(h2.i);
        }
        int intValue = (this.u.g().h().intValue() * 255) / 100;
        this.z.setAlpha(intValue);
        this.A.setAlpha(intValue);
        d.a.a.q.b.a<Float, Float> aVar3 = this.H;
        if (aVar3 != null) {
            this.A.setStrokeWidth(aVar3.h().floatValue());
        } else {
            float f2 = d.a.a.v.f.f(matrix);
            Paint paint = this.A;
            double d2 = h2.j;
            double e2 = d.a.a.v.f.e();
            Double.isNaN(e2);
            double d3 = d2 * e2;
            double d4 = f2;
            Double.isNaN(d4);
            paint.setStrokeWidth((float) (d3 * d4));
        }
        if (this.D.l0()) {
            G(h2, matrix, cVar, canvas);
        } else {
            H(h2, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
