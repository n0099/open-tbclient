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
    public final char[] f32232e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f32233f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f32234g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f32235h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f32236i;
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
        this.f32232e = new char[1];
        this.f32233f = new RectF();
        this.f32234g = new Matrix();
        this.f32235h = new Paint(1) { // from class: com.ksad.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.f32236i = new Paint(1) { // from class: com.ksad.lottie.model.layer.g.2
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
        if (t != null && (aVar2 = t.f32085a) != null) {
            com.ksad.lottie.a.b.a<Integer, Integer> a3 = aVar2.a();
            this.n = a3;
            a3.a(this);
            a(this.n);
        }
        if (t != null && (aVar = t.f32086b) != null) {
            com.ksad.lottie.a.b.a<Integer, Integer> a4 = aVar.a();
            this.o = a4;
            a4.a(this);
            a(this.o);
        }
        if (t != null && (bVar2 = t.f32087c) != null) {
            com.ksad.lottie.a.b.a<Float, Float> a5 = bVar2.a();
            this.p = a5;
            a5.a(this);
            a(this.p);
        }
        if (t == null || (bVar = t.f32088d) == null) {
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
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.ksad.lottie.a.a.c(this.l, this, a2.get(i2)));
        }
        this.j.put(dVar, arrayList);
        return arrayList;
    }

    private void a(char c2, com.ksad.lottie.model.b bVar, Canvas canvas) {
        char[] cArr = this.f32232e;
        cArr[0] = c2;
        if (bVar.k) {
            a(cArr, this.f32235h, canvas);
            a(this.f32232e, this.f32236i, canvas);
            return;
        }
        a(cArr, this.f32236i, canvas);
        a(this.f32232e, this.f32235h, canvas);
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
        float f2 = ((float) bVar.f32099c) / 100.0f;
        float a2 = com.ksad.lottie.d.f.a(matrix);
        String str = bVar.f32097a;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.ksad.lottie.model.d dVar = this.m.h().get(com.ksad.lottie.model.d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                a(dVar, matrix, f2, bVar, canvas);
                float b2 = ((float) dVar.b()) * f2 * com.ksad.lottie.d.f.a() * a2;
                float f3 = bVar.f32101e / 10.0f;
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
        String str = bVar.f32097a;
        m o = this.l.o();
        if (o != null) {
            str = o.a(str);
        }
        this.f32235h.setTypeface(a3);
        this.f32235h.setTextSize((float) (bVar.f32099c * com.ksad.lottie.d.f.a()));
        this.f32236i.setTypeface(this.f32235h.getTypeface());
        this.f32236i.setTextSize(this.f32235h.getTextSize());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            a(charAt, bVar, canvas);
            char[] cArr = this.f32232e;
            cArr[0] = charAt;
            float measureText = this.f32235h.measureText(cArr, 0, 1);
            float f2 = bVar.f32101e / 10.0f;
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
        for (int i2 = 0; i2 < a2.size(); i2++) {
            Path d2 = a2.get(i2).d();
            d2.computeBounds(this.f32233f, false);
            this.f32234g.set(matrix);
            this.f32234g.preTranslate(0.0f, ((float) (-bVar.f32103g)) * com.ksad.lottie.d.f.a());
            this.f32234g.preScale(f2, f2);
            d2.transform(this.f32234g);
            if (bVar.k) {
                a(d2, this.f32235h, canvas);
                paint = this.f32236i;
            } else {
                a(d2, this.f32236i, canvas);
                paint = this.f32235h;
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
    public void b(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        float a2;
        canvas.save();
        if (!this.l.p()) {
            canvas.setMatrix(matrix);
        }
        com.ksad.lottie.model.b e2 = this.k.e();
        com.ksad.lottie.model.c cVar = this.m.i().get(e2.f32098b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.ksad.lottie.a.b.a<Integer, Integer> aVar = this.n;
        if (aVar != null) {
            this.f32235h.setColor(aVar.e().intValue());
        } else {
            this.f32235h.setColor(e2.f32104h);
        }
        com.ksad.lottie.a.b.a<Integer, Integer> aVar2 = this.o;
        if (aVar2 != null) {
            this.f32236i.setColor(aVar2.e().intValue());
        } else {
            this.f32236i.setColor(e2.f32105i);
        }
        int intValue = (this.f32207d.a().e().intValue() * 255) / 100;
        this.f32235h.setAlpha(intValue);
        this.f32236i.setAlpha(intValue);
        com.ksad.lottie.a.b.a<Float, Float> aVar3 = this.p;
        if (aVar3 != null) {
            paint = this.f32236i;
            a2 = aVar3.e().floatValue();
        } else {
            float a3 = com.ksad.lottie.d.f.a(matrix);
            paint = this.f32236i;
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
