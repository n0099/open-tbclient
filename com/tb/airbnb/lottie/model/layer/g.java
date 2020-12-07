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
import com.tb.airbnb.lottie.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class g extends a {
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> HA;
    private final char[] Hw;
    private final RectF Hx;
    private final Paint Hy;
    private final Paint Hz;
    private final com.tb.airbnb.lottie.e composition;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> pAY;
    private final n pCN;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> pCO;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> pCP;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> pCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.Hw = new char[1];
        this.Hx = new RectF();
        this.matrix = new Matrix();
        this.Hy = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Hz = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.HA = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.pCN = layer.eBV().eBi();
        this.pCN.b(this);
        a(this.pCN);
        k eBW = layer.eBW();
        if (eBW != null && eBW.pBQ != null) {
            this.pAY = eBW.pBQ.eBi();
            this.pAY.b(this);
            a(this.pAY);
        }
        if (eBW != null && eBW.pBR != null) {
            this.pCO = eBW.pBR.eBi();
            this.pCO.b(this);
            a(this.pCO);
        }
        if (eBW != null && eBW.pBS != null) {
            this.pCP = eBW.pBS.eBi();
            this.pCP.b(this);
            a(this.pCP);
        }
        if (eBW != null && eBW.pBT != null) {
            this.pCQ = eBW.pBT.eBi();
            this.pCQ.b(this);
            a(this.pCQ);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iJ()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.pCN.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.iB().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.pAY != null) {
            this.Hy.setColor(this.pAY.getValue().intValue());
        } else {
            this.Hy.setColor(value.color);
        }
        if (this.pCO != null) {
            this.Hz.setColor(this.pCO.getValue().intValue());
        } else {
            this.Hz.setColor(value.Ft);
        }
        int intValue = (this.pBn.eBd().getValue().intValue() * 255) / 100;
        this.Hy.setAlpha(intValue);
        this.Hz.setAlpha(intValue);
        if (this.pCP != null) {
            this.Hz.setStrokeWidth(this.pCP.getValue().floatValue());
        } else {
            this.Hz.setStrokeWidth((float) (value.Fu * com.tb.airbnb.lottie.d.f.lb() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iJ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Fp) / 100.0f;
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.d dVar = this.composition.iA().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.jx(), cVar.jy()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.lb() * b;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.pCQ != null ? this.pCQ.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface q = this.lottieDrawable.q(cVar.jx(), cVar.jy());
        if (q != null) {
            String str = bVar.text;
            r eAV = this.lottieDrawable.eAV();
            String bk = eAV != null ? eAV.bk(str) : str;
            this.Hy.setTypeface(q);
            this.Hy.setTextSize((float) (bVar.Fp * com.tb.airbnb.lottie.d.f.lb()));
            this.Hz.setTypeface(this.Hy.getTypeface());
            this.Hz.setTextSize(this.Hy.getTextSize());
            for (int i = 0; i < bk.length(); i++) {
                char charAt = bk.charAt(i);
                a(charAt, bVar, canvas);
                this.Hw[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.pCQ != null ? this.pCQ.getValue().floatValue() + f : f) * b) + this.Hy.measureText(this.Hw, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iW = a2.get(i).iW();
            iW.computeBounds(this.Hx, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Fs)) * com.tb.airbnb.lottie.d.f.lb());
            this.matrix.preScale(f, f);
            iW.transform(this.matrix);
            if (bVar.Fv) {
                a(iW, this.Hy, canvas);
                a(iW, this.Hz, canvas);
            } else {
                a(iW, this.Hz, canvas);
                a(iW, this.Hy, canvas);
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
        this.Hw[0] = c;
        if (bVar.Fv) {
            a(this.Hw, this.Hy, canvas);
            a(this.Hw, this.Hz, canvas);
            return;
        }
        a(this.Hw, this.Hz, canvas);
        a(this.Hw, this.Hy, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.HA.containsKey(dVar)) {
            return this.HA.get(dVar);
        }
        List<j> jz = dVar.jz();
        int size = jz.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, jz.get(i)));
        }
        this.HA.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.k.CN && this.pAY != null) {
            this.pAY.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.CO && this.pCO != null) {
            this.pCO.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Db && this.pCP != null) {
            this.pCP.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Dc && this.pCQ != null) {
            this.pCQ.a(cVar);
        }
    }
}
