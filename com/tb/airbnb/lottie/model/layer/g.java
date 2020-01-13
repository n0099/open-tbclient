package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.n;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.content.j;
import com.tb.airbnb.lottie.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class g extends a {
    private final com.tb.airbnb.lottie.d composition;
    private final char[] jC;
    private final RectF jD;
    private final Paint jE;
    private final Paint jF;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> jG;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> npe;
    private final n nqT;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> nqU;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nqV;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.jC = new char[1];
        this.jD = new RectF();
        this.matrix = new Matrix();
        this.jE = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.jF = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.jG = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.nqT = layer.dGr().dFE();
        this.nqT.b(this);
        a(this.nqT);
        k dGs = layer.dGs();
        if (dGs != null && dGs.npW != null) {
            this.npe = dGs.npW.dFE();
            this.npe.b(this);
            a(this.npe);
        }
        if (dGs != null && dGs.npX != null) {
            this.nqU = dGs.npX.dFE();
            this.nqU.b(this);
            a(this.nqU);
        }
        if (dGs != null && dGs.npY != null) {
            this.nqV = dGs.npY.dFE();
            this.nqV.b(this);
            a(this.nqV);
        }
        if (dGs != null && dGs.npZ != null) {
            this.nqW = dGs.npZ.dFE();
            this.nqW.b(this);
            a(this.nqW);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bs()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.nqT.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.bl().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.npe != null) {
            this.jE.setColor(this.npe.getValue().intValue());
        } else {
            this.jE.setColor(value.color);
        }
        if (this.nqU != null) {
            this.jF.setColor(this.nqU.getValue().intValue());
        } else {
            this.jF.setColor(value.ht);
        }
        int intValue = (this.npt.dFz().getValue().intValue() * 255) / 100;
        this.jE.setAlpha(intValue);
        this.jF.setAlpha(intValue);
        if (this.nqV != null) {
            this.jF.setStrokeWidth(this.nqV.getValue().floatValue());
        } else {
            this.jF.setStrokeWidth((float) (value.hu * com.tb.airbnb.lottie.d.f.dK() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.bs()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.ho) / 100.0f;
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.d dVar = this.composition.bk().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.cg(), cVar.ch()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.dK() * b;
                    float f2 = bVar.hq / 10.0f;
                    canvas.translate(((this.nqW != null ? this.nqW.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface g = this.lottieDrawable.g(cVar.cg(), cVar.ch());
        if (g != null) {
            String str = bVar.text;
            p dFr = this.lottieDrawable.dFr();
            String L = dFr != null ? dFr.L(str) : str;
            this.jE.setTypeface(g);
            this.jE.setTextSize((float) (bVar.ho * com.tb.airbnb.lottie.d.f.dK()));
            this.jF.setTypeface(this.jE.getTypeface());
            this.jF.setTextSize(this.jE.getTextSize());
            for (int i = 0; i < L.length(); i++) {
                char charAt = L.charAt(i);
                a(charAt, bVar, canvas);
                this.jC[0] = charAt;
                float f = bVar.hq / 10.0f;
                canvas.translate(((this.nqW != null ? this.nqW.getValue().floatValue() + f : f) * b) + this.jE.measureText(this.jC, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path bF = a.get(i).bF();
            bF.computeBounds(this.jD, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.hs)) * com.tb.airbnb.lottie.d.f.dK());
            this.matrix.preScale(f, f);
            bF.transform(this.matrix);
            if (bVar.hv) {
                a(bF, this.jE, canvas);
                a(bF, this.jF, canvas);
            } else {
                a(bF, this.jF, canvas);
                a(bF, this.jE, canvas);
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

    private void a(char c, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        this.jC[0] = c;
        if (bVar.hv) {
            a(this.jC, this.jE, canvas);
            a(this.jC, this.jF, canvas);
            return;
        }
        a(this.jC, this.jF, canvas);
        a(this.jC, this.jE, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.jG.containsKey(dVar)) {
            return this.jG.get(dVar);
        }
        List<j> ci = dVar.ci();
        int size = ci.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, ci.get(i)));
        }
        this.jG.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.eK && this.npe != null) {
            this.npe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eL && this.nqU != null) {
            this.nqU.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eU && this.nqV != null) {
            this.nqV.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eV && this.nqW != null) {
            this.nqW.a(cVar);
        }
    }
}
