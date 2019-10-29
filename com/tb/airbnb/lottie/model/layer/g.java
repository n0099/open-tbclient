package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
import com.tb.airbnb.lottie.l;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.content.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends a {
    private final com.tb.airbnb.lottie.e composition;
    private final char[] ir;
    private final RectF iu;
    private final Paint iw;
    private final Paint ix;
    private final Map<com.tb.airbnb.lottie.model.g, List<com.tb.airbnb.lottie.a.a.c>> iy;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> ktb;
    private final o kuY;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> kuZ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> kva;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> kvb;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.ir = new char[1];
        this.iu = new RectF();
        this.matrix = new Matrix();
        this.iw = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.ix = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.iy = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.cLc();
        this.kuY = layer.cMi().cLn();
        this.kuY.b(this);
        a(this.kuY);
        k cMj = layer.cMj();
        if (cMj != null && cMj.ktX != null) {
            this.ktb = cMj.ktX.cLn();
            this.ktb.b(this);
            a(this.ktb);
        }
        if (cMj != null && cMj.ktY != null) {
            this.kuZ = cMj.ktY.cLn();
            this.kuZ.b(this);
            a(this.kuZ);
        }
        if (cMj != null && cMj.ktZ != null) {
            this.kva = cMj.ktZ.cLn();
            this.kva.b(this);
            a(this.kva);
        }
        if (cMj != null && cMj.kua != null) {
            this.kvb = cMj.kua.cLn();
            this.kvb.b(this);
            a(this.kvb);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bi()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.d value = this.kuY.getValue();
        com.tb.airbnb.lottie.model.f fVar = this.composition.aY().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.ktb != null) {
            this.iw.setColor(this.ktb.getValue().intValue());
        } else {
            this.iw.setColor(value.color);
        }
        if (this.kuZ != null) {
            this.ix.setColor(this.kuZ.getValue().intValue());
        } else {
            this.ix.setColor(value.gi);
        }
        int intValue = (this.ktr.cLk().getValue().intValue() * 255) / 100;
        this.iw.setAlpha(intValue);
        this.ix.setAlpha(intValue);
        if (this.kva != null) {
            this.ix.setStrokeWidth(this.kva.getValue().floatValue());
        } else {
            this.ix.setStrokeWidth(com.tb.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.composition.bb());
        }
        if (this.lottieDrawable.bi()) {
            a(value, matrix, fVar, canvas);
        } else {
            a(value, fVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, com.tb.airbnb.lottie.model.f fVar, Canvas canvas) {
        float f = dVar.size / 100.0f;
        float c = com.tb.airbnb.lottie.c.f.c(matrix);
        String str = dVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.g gVar = this.composition.aX().get(com.tb.airbnb.lottie.model.g.a(str.charAt(i2), fVar.bV(), fVar.bW()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.composition.bb() * c;
                    float f2 = dVar.gf / 10.0f;
                    canvas.translate(((this.kvb != null ? this.kvb.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, com.tb.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.tb.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.lottieDrawable.g(fVar.bV(), fVar.bW());
        if (g != null) {
            String str = dVar.text;
            l cLb = this.lottieDrawable.cLb();
            String J = cLb != null ? cLb.J(str) : str;
            this.iw.setTypeface(g);
            this.iw.setTextSize(dVar.size * this.composition.bb());
            this.ix.setTypeface(this.iw.getTypeface());
            this.ix.setTextSize(this.iw.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.ir[0] = charAt;
                float f = dVar.gf / 10.0f;
                canvas.translate(((this.kvb != null ? this.kvb.getValue().floatValue() + f : f) * c) + this.iw.measureText(this.ir, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path bw = a.get(i).bw();
            bw.computeBounds(this.iu, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.gh)) * this.composition.bb());
            this.matrix.preScale(f, f);
            bw.transform(this.matrix);
            if (dVar.gj) {
                a(bw, this.iw, canvas);
                a(bw, this.ix, canvas);
            } else {
                a(bw, this.ix, canvas);
                a(bw, this.iw, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c, com.tb.airbnb.lottie.model.d dVar, Canvas canvas) {
        this.ir[0] = c;
        if (dVar.gj) {
            a(this.ir, this.iw, canvas);
            a(this.ir, this.ix, canvas);
            return;
        }
        a(this.ir, this.ix, canvas);
        a(this.ir, this.iw, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.g gVar) {
        if (this.iy.containsKey(gVar)) {
            return this.iy.get(gVar);
        }
        List<j> bX = gVar.bX();
        int size = bX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, bX.get(i)));
        }
        this.iy.put(gVar, arrayList);
        return arrayList;
    }
}
