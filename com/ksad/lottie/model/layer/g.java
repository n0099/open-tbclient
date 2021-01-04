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
/* loaded from: classes5.dex */
public class g extends a {
    private final char[] e;
    private final RectF f;
    private final Matrix g;
    private final Paint h;
    private final Paint i;
    private final Map<com.ksad.lottie.model.d, List<com.ksad.lottie.a.a.c>> j;
    private final n k;
    private final com.ksad.lottie.f l;
    private final com.ksad.lottie.d m;
    @Nullable
    private com.ksad.lottie.a.b.a<Integer, Integer> n;
    @Nullable
    private com.ksad.lottie.a.b.a<Integer, Integer> o;
    @Nullable
    private com.ksad.lottie.a.b.a<Float, Float> p;
    @Nullable
    private com.ksad.lottie.a.b.a<Float, Float> q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.e = new char[1];
        this.f = new RectF();
        this.g = new Matrix();
        this.h = new Paint(1) { // from class: com.ksad.lottie.model.layer.g.1
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
        this.k = layer.s().a();
        this.k.a(this);
        a(this.k);
        k t = layer.t();
        if (t != null && t.f8343a != null) {
            this.n = t.f8343a.a();
            this.n.a(this);
            a(this.n);
        }
        if (t != null && t.f8344b != null) {
            this.o = t.f8344b.a();
            this.o.a(this);
            a(this.o);
        }
        if (t != null && t.c != null) {
            this.p = t.c.a();
            this.p.a(this);
            a(this.p);
        }
        if (t == null || t.d == null) {
            return;
        }
        this.q = t.d.a();
        this.q.a(this);
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

    private void a(char c, com.ksad.lottie.model.b bVar, Canvas canvas) {
        this.e[0] = c;
        if (bVar.k) {
            a(this.e, this.h, canvas);
            a(this.e, this.i, canvas);
            return;
        }
        a(this.e, this.i, canvas);
        a(this.e, this.h, canvas);
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
        float f = ((float) bVar.c) / 100.0f;
        float a2 = com.ksad.lottie.d.f.a(matrix);
        String str = bVar.f8348a;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            com.ksad.lottie.model.d dVar = this.m.h().get(com.ksad.lottie.model.d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                a(dVar, matrix, f, bVar, canvas);
                float b2 = ((float) dVar.b()) * f * com.ksad.lottie.d.f.a() * a2;
                float f2 = bVar.e / 10.0f;
                canvas.translate(((this.q != null ? this.q.e().floatValue() + f2 : f2) * a2) + b2, 0.0f);
            }
            i = i2 + 1;
        }
    }

    private void a(com.ksad.lottie.model.b bVar, com.ksad.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float a2 = com.ksad.lottie.d.f.a(matrix);
        Typeface a3 = this.l.a(cVar.a(), cVar.c());
        if (a3 == null) {
            return;
        }
        String str = bVar.f8348a;
        m o = this.l.o();
        String a4 = o != null ? o.a(str) : str;
        this.h.setTypeface(a3);
        this.h.setTextSize((float) (bVar.c * com.ksad.lottie.d.f.a()));
        this.i.setTypeface(this.h.getTypeface());
        this.i.setTextSize(this.h.getTextSize());
        for (int i = 0; i < a4.length(); i++) {
            char charAt = a4.charAt(i);
            a(charAt, bVar, canvas);
            this.e[0] = charAt;
            float f = bVar.e / 10.0f;
            canvas.translate(((this.q != null ? this.q.e().floatValue() + f : f) * a2) + this.h.measureText(this.e, 0, 1), 0.0f);
        }
    }

    private void a(com.ksad.lottie.model.d dVar, Matrix matrix, float f, com.ksad.lottie.model.b bVar, Canvas canvas) {
        List<com.ksad.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path d = a2.get(i).d();
            d.computeBounds(this.f, false);
            this.g.set(matrix);
            this.g.preTranslate(0.0f, ((float) (-bVar.g)) * com.ksad.lottie.d.f.a());
            this.g.preScale(f, f);
            d.transform(this.g);
            if (bVar.k) {
                a(d, this.h, canvas);
                a(d, this.i, canvas);
            } else {
                a(d, this.i, canvas);
                a(d, this.h, canvas);
            }
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
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.l.p()) {
            canvas.setMatrix(matrix);
        }
        com.ksad.lottie.model.b e = this.k.e();
        com.ksad.lottie.model.c cVar = this.m.i().get(e.f8349b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.n != null) {
            this.h.setColor(this.n.e().intValue());
        } else {
            this.h.setColor(e.h);
        }
        if (this.o != null) {
            this.i.setColor(this.o.e().intValue());
        } else {
            this.i.setColor(e.i);
        }
        int intValue = (this.d.a().e().intValue() * 255) / 100;
        this.h.setAlpha(intValue);
        this.i.setAlpha(intValue);
        if (this.p != null) {
            this.i.setStrokeWidth(this.p.e().floatValue());
        } else {
            this.i.setStrokeWidth((float) (e.j * com.ksad.lottie.d.f.a() * com.ksad.lottie.d.f.a(matrix)));
        }
        if (this.l.p()) {
            a(e, matrix, cVar, canvas);
        } else {
            a(e, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
