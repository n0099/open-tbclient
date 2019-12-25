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
/* loaded from: classes2.dex */
public class g extends a {
    private final com.tb.airbnb.lottie.e composition;
    private final char[] jD;
    private final RectF jE;
    private final Paint jF;
    private final Paint jG;
    private final Map<com.tb.airbnb.lottie.model.g, List<com.tb.airbnb.lottie.a.a.c>> jH;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> mMY;
    private final o mOY;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> mOZ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> mPa;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> mPb;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.jD = new char[1];
        this.jE = new RectF();
        this.matrix = new Matrix();
        this.jF = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.jG = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.jH = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.dBd();
        this.mOY = layer.dCp().dBq();
        this.mOY.b(this);
        a(this.mOY);
        k dCq = layer.dCq();
        if (dCq != null && dCq.mNY != null) {
            this.mMY = dCq.mNY.dBq();
            this.mMY.b(this);
            a(this.mMY);
        }
        if (dCq != null && dCq.mNZ != null) {
            this.mOZ = dCq.mNZ.dBq();
            this.mOZ.b(this);
            a(this.mOZ);
        }
        if (dCq != null && dCq.mOa != null) {
            this.mPa = dCq.mOa.dBq();
            this.mPa.b(this);
            a(this.mPa);
        }
        if (dCq != null && dCq.mOb != null) {
            this.mPb = dCq.mOb.dBq();
            this.mPb.b(this);
            a(this.mPb);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bs()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.d value = this.mOY.getValue();
        com.tb.airbnb.lottie.model.f fVar = this.composition.bl().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.mMY != null) {
            this.jF.setColor(this.mMY.getValue().intValue());
        } else {
            this.jF.setColor(value.color);
        }
        if (this.mOZ != null) {
            this.jG.setColor(this.mOZ.getValue().intValue());
        } else {
            this.jG.setColor(value.ht);
        }
        int intValue = (this.mNo.dBn().getValue().intValue() * 255) / 100;
        this.jF.setAlpha(intValue);
        this.jG.setAlpha(intValue);
        if (this.mPa != null) {
            this.jG.setStrokeWidth(this.mPa.getValue().floatValue());
        } else {
            this.jG.setStrokeWidth(com.tb.airbnb.lottie.c.f.b(matrix) * value.strokeWidth * this.composition.dAZ());
        }
        if (this.lottieDrawable.bs()) {
            a(value, matrix, fVar, canvas);
        } else {
            a(value, fVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, com.tb.airbnb.lottie.model.f fVar, Canvas canvas) {
        float f = dVar.size / 100.0f;
        float b = com.tb.airbnb.lottie.c.f.b(matrix);
        String str = dVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.g gVar = this.composition.bk().get(com.tb.airbnb.lottie.model.g.a(str.charAt(i2), fVar.cg(), fVar.ch()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.composition.dAZ() * b;
                    float f2 = dVar.hq / 10.0f;
                    canvas.translate(((this.mPb != null ? this.mPb.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, com.tb.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.c.f.b(matrix);
        Typeface g = this.lottieDrawable.g(fVar.cg(), fVar.ch());
        if (g != null) {
            String str = dVar.text;
            l dBc = this.lottieDrawable.dBc();
            String L = dBc != null ? dBc.L(str) : str;
            this.jF.setTypeface(g);
            this.jF.setTextSize(dVar.size * this.composition.dAZ());
            this.jG.setTypeface(this.jF.getTypeface());
            this.jG.setTextSize(this.jF.getTextSize());
            for (int i = 0; i < L.length(); i++) {
                char charAt = L.charAt(i);
                a(charAt, dVar, canvas);
                this.jD[0] = charAt;
                float f = dVar.hq / 10.0f;
                canvas.translate(((this.mPb != null ? this.mPb.getValue().floatValue() + f : f) * b) + this.jF.measureText(this.jD, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path bF = a.get(i).bF();
            bF.computeBounds(this.jE, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.hs)) * this.composition.dAZ());
            this.matrix.preScale(f, f);
            bF.transform(this.matrix);
            if (dVar.hv) {
                a(bF, this.jF, canvas);
                a(bF, this.jG, canvas);
            } else {
                a(bF, this.jG, canvas);
                a(bF, this.jF, canvas);
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
        this.jD[0] = c;
        if (dVar.hv) {
            a(this.jD, this.jF, canvas);
            a(this.jD, this.jG, canvas);
            return;
        }
        a(this.jD, this.jG, canvas);
        a(this.jD, this.jF, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.g gVar) {
        if (this.jH.containsKey(gVar)) {
            return this.jH.get(gVar);
        }
        List<j> ci = gVar.ci();
        int size = ci.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, ci.get(i)));
        }
        this.jH.put(gVar, arrayList);
        return arrayList;
    }
}
