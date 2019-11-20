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
    private final char[] hP;
    private final RectF hQ;
    private final Paint hR;
    private final Paint hS;
    private final Map<com.tb.airbnb.lottie.model.g, List<com.tb.airbnb.lottie.a.a.c>> hT;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> ksk;
    private final o kuh;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> kui;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> kuj;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> kuk;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.hP = new char[1];
        this.hQ = new RectF();
        this.matrix = new Matrix();
        this.hR = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.hS = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.hT = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.cLa();
        this.kuh = layer.cMg().cLl();
        this.kuh.b(this);
        a(this.kuh);
        k cMh = layer.cMh();
        if (cMh != null && cMh.ktg != null) {
            this.ksk = cMh.ktg.cLl();
            this.ksk.b(this);
            a(this.ksk);
        }
        if (cMh != null && cMh.kth != null) {
            this.kui = cMh.kth.cLl();
            this.kui.b(this);
            a(this.kui);
        }
        if (cMh != null && cMh.kti != null) {
            this.kuj = cMh.kti.cLl();
            this.kuj.b(this);
            a(this.kuj);
        }
        if (cMh != null && cMh.ktj != null) {
            this.kuk = cMh.ktj.cLl();
            this.kuk.b(this);
            a(this.kuk);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bi()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.d value = this.kuh.getValue();
        com.tb.airbnb.lottie.model.f fVar = this.composition.aY().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.ksk != null) {
            this.hR.setColor(this.ksk.getValue().intValue());
        } else {
            this.hR.setColor(value.color);
        }
        if (this.kui != null) {
            this.hS.setColor(this.kui.getValue().intValue());
        } else {
            this.hS.setColor(value.fJ);
        }
        int intValue = (this.ksA.cLi().getValue().intValue() * 255) / 100;
        this.hR.setAlpha(intValue);
        this.hS.setAlpha(intValue);
        if (this.kuj != null) {
            this.hS.setStrokeWidth(this.kuj.getValue().floatValue());
        } else {
            this.hS.setStrokeWidth(com.tb.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.composition.bb());
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
                    float f2 = dVar.fG / 10.0f;
                    canvas.translate(((this.kuk != null ? this.kuk.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
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
            l cKZ = this.lottieDrawable.cKZ();
            String J = cKZ != null ? cKZ.J(str) : str;
            this.hR.setTypeface(g);
            this.hR.setTextSize(dVar.size * this.composition.bb());
            this.hS.setTypeface(this.hR.getTypeface());
            this.hS.setTextSize(this.hR.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.hP[0] = charAt;
                float f = dVar.fG / 10.0f;
                canvas.translate(((this.kuk != null ? this.kuk.getValue().floatValue() + f : f) * c) + this.hR.measureText(this.hP, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path bw = a.get(i).bw();
            bw.computeBounds(this.hQ, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.fI)) * this.composition.bb());
            this.matrix.preScale(f, f);
            bw.transform(this.matrix);
            if (dVar.fK) {
                a(bw, this.hR, canvas);
                a(bw, this.hS, canvas);
            } else {
                a(bw, this.hS, canvas);
                a(bw, this.hR, canvas);
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
        this.hP[0] = c;
        if (dVar.fK) {
            a(this.hP, this.hR, canvas);
            a(this.hP, this.hS, canvas);
            return;
        }
        a(this.hP, this.hS, canvas);
        a(this.hP, this.hR, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.g gVar) {
        if (this.hT.containsKey(gVar)) {
            return this.hT.get(gVar);
        }
        List<j> bX = gVar.bX();
        int size = bX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, bX.get(i)));
        }
        this.hT.put(gVar, arrayList);
        return arrayList;
    }
}
