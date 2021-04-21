package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.n;
import com.ksad.lottie.m;
import com.ksad.lottie.model.a.k;
import com.ksad.lottie.model.content.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends a {

    /* renamed from: e  reason: collision with root package name */
    public final char[] f31978e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f31979f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f31980g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f31981h;
    public final Paint i;
    public final Map<com.ksad.lottie.model.d, List<com.ksad.lottie.a.a.c>> j;
    public final n k;
    public final com.ksad.lottie.f l;
    public final com.ksad.lottie.d m;
    @Nullable
    public com.ksad.lottie.a.b.a<Integer, Integer> n;
    @Nullable
    public com.ksad.lottie.a.b.a<Integer, Integer> o;
    @Nullable
    public com.ksad.lottie.a.b.a<Float, Float> p;
    @Nullable
    public com.ksad.lottie.a.b.a<Float, Float> q;

    public g(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        com.ksad.lottie.model.a.b bVar;
        com.ksad.lottie.model.a.b bVar2;
        com.ksad.lottie.model.a.a aVar;
        com.ksad.lottie.model.a.a aVar2;
        this.f31978e = new char[1];
        this.f31979f = new RectF();
        this.f31980g = new Matrix();
        this.f31981h = new Paint(1) { // from class: com.ksad.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.i = new Paint(1) { // from class: com.ksad.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.j = new HashMap();
        this.l = fVar;
        this.m = layer.a();
        n a2 = layer.s().a();
        this.k = a2;
        a2.a(this);
        a(this.k);
        k t = layer.t();
        if (t != null && (aVar2 = t.f31839a) != null) {
            com.ksad.lottie.a.b.a<Integer, Integer> a3 = aVar2.a();
            this.n = a3;
            a3.a(this);
            a(this.n);
        }
        if (t != null && (aVar = t.f31840b) != null) {
            com.ksad.lottie.a.b.a<Integer, Integer> a4 = aVar.a();
            this.o = a4;
            a4.a(this);
            a(this.o);
        }
        if (t != null && (bVar2 = t.f31841c) != null) {
            com.ksad.lottie.a.b.a<Float, Float> a5 = bVar2.a();
            this.p = a5;
            a5.a(this);
            a(this.p);
        }
        if (t == null || (bVar = t.f31842d) == null) {
            return;
        }
        com.ksad.lottie.a.b.a<Float, Float> a6 = bVar.a();
        this.q = a6;
        a6.a(this);
        a(this.q);
    }

    private List<com.ksad.lottie.a.a.c> a(com.ksad.lottie.model.d dVar) {
        if (this.j.containsKey(dVar)) {
            return this.j.get(dVar);
        }
        List<j> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.ksad.lottie.a.a.c(this.l, this, a2.get(i)));
        }
        this.j.put(dVar, arrayList);
        return arrayList;
    }

    private void a(char c2, com.ksad.lottie.model.b bVar, Canvas canvas) {
        char[] cArr = this.f31978e;
        cArr[0] = c2;
        if (bVar.k) {
            a(cArr, this.f31981h, canvas);
            a(this.f31978e, this.i, canvas);
            return;
        }
        a(cArr, this.i, canvas);
        a(this.f31978e, this.f31981h, canvas);
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(com.ksad.lottie.model.b bVar, Matrix matrix, com.ksad.lottie.model.c cVar, Canvas canvas) {
        float f2 = ((float) bVar.f31853c) / 100.0f;
        float a2 = com.ksad.lottie.d.f.a(matrix);
        String str = bVar.f31851a;
        for (int i = 0; i < str.length(); i++) {
            com.ksad.lottie.model.d dVar = this.m.h().get(com.ksad.lottie.model.d.a(str.charAt(i), cVar.a(), cVar.c()));
            if (dVar != null) {
                a(dVar, matrix, f2, bVar, canvas);
                float b2 = ((float) dVar.b()) * f2 * com.ksad.lottie.d.f.a() * a2;
                float f3 = bVar.f31855e / 10.0f;
                com.ksad.lottie.a.b.a<Float, Float> aVar = this.q;
                if (aVar != null) {
                    f3 += aVar.e().floatValue();
                }
                canvas.translate(b2 + (f3 * a2), 0.0f);
            }
        }
    }

    private void a(com.ksad.lottie.model.b bVar, com.ksad.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float a2 = com.ksad.lottie.d.f.a(matrix);
        Typeface a3 = this.l.a(cVar.a(), cVar.c());
        if (a3 == null) {
            return;
        }
        String str = bVar.f31851a;
        m o = this.l.o();
        if (o != null) {
            str = o.a(str);
        }
        this.f31981h.setTypeface(a3);
        this.f31981h.setTextSize((float) (bVar.f31853c * com.ksad.lottie.d.f.a()));
        this.i.setTypeface(this.f31981h.getTypeface());
        this.i.setTextSize(this.f31981h.getTextSize());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            a(charAt, bVar, canvas);
            char[] cArr = this.f31978e;
            cArr[0] = charAt;
            float measureText = this.f31981h.measureText(cArr, 0, 1);
            float f2 = bVar.f31855e / 10.0f;
            com.ksad.lottie.a.b.a<Float, Float> aVar = this.q;
            if (aVar != null) {
                f2 += aVar.e().floatValue();
            }
            canvas.translate(measureText + (f2 * a2), 0.0f);
        }
    }

    private void a(com.ksad.lottie.model.d dVar, Matrix matrix, float f2, com.ksad.lottie.model.b bVar, Canvas canvas) {
        Paint paint;
        List<com.ksad.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path d2 = a2.get(i).d();
            d2.computeBounds(this.f31979f, false);
            this.f31980g.set(matrix);
            this.f31980g.preTranslate(0.0f, ((float) (-bVar.f31857g)) * com.ksad.lottie.d.f.a());
            this.f31980g.preScale(f2, f2);
            d2.transform(this.f31980g);
            if (bVar.k) {
                a(d2, this.f31981h, canvas);
                paint = this.i;
            } else {
                a(d2, this.i, canvas);
                paint = this.f31981h;
            }
            a(d2, paint, canvas);
        }
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        float a2;
        canvas.save();
        if (!this.l.p()) {
            canvas.setMatrix(matrix);
        }
        com.ksad.lottie.model.b e2 = this.k.e();
        com.ksad.lottie.model.c cVar = this.m.i().get(e2.f31852b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.ksad.lottie.a.b.a<Integer, Integer> aVar = this.n;
        if (aVar != null) {
            this.f31981h.setColor(aVar.e().intValue());
        } else {
            this.f31981h.setColor(e2.f31858h);
        }
        com.ksad.lottie.a.b.a<Integer, Integer> aVar2 = this.o;
        if (aVar2 != null) {
            this.i.setColor(aVar2.e().intValue());
        } else {
            this.i.setColor(e2.i);
        }
        int intValue = (this.f31955d.a().e().intValue() * 255) / 100;
        this.f31981h.setAlpha(intValue);
        this.i.setAlpha(intValue);
        com.ksad.lottie.a.b.a<Float, Float> aVar3 = this.p;
        if (aVar3 != null) {
            paint = this.i;
            a2 = aVar3.e().floatValue();
        } else {
            float a3 = com.ksad.lottie.d.f.a(matrix);
            paint = this.i;
            a2 = (float) (e2.j * com.ksad.lottie.d.f.a() * a3);
        }
        paint.setStrokeWidth(a2);
        if (this.l.p()) {
            a(e2, matrix, cVar, canvas);
        } else {
            a(e2, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
