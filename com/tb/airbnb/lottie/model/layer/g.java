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
/* loaded from: classes16.dex */
public class g extends a {
    private final char[] GC;
    private final RectF GD;
    private final Paint GF;
    private final Paint GG;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> GH;
    private final com.tb.airbnb.lottie.d composition;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    private final n pAM;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> pAN;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> pAO;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> pAP;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> pyX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.GC = new char[1];
        this.GD = new RectF();
        this.matrix = new Matrix();
        this.GF = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.GG = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.GH = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.pAM = layer.evJ().euW();
        this.pAM.b(this);
        a(this.pAM);
        k evK = layer.evK();
        if (evK != null && evK.pzP != null) {
            this.pyX = evK.pzP.euW();
            this.pyX.b(this);
            a(this.pyX);
        }
        if (evK != null && evK.pzQ != null) {
            this.pAN = evK.pzQ.euW();
            this.pAN.b(this);
            a(this.pAN);
        }
        if (evK != null && evK.pzR != null) {
            this.pAO = evK.pzR.euW();
            this.pAO.b(this);
            a(this.pAO);
        }
        if (evK != null && evK.pzS != null) {
            this.pAP = evK.pzS.euW();
            this.pAP.b(this);
            a(this.pAP);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iJ()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.pAM.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.iB().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.pyX != null) {
            this.GF.setColor(this.pyX.getValue().intValue());
        } else {
            this.GF.setColor(value.color);
        }
        if (this.pAN != null) {
            this.GG.setColor(this.pAN.getValue().intValue());
        } else {
            this.GG.setColor(value.strokeColor);
        }
        int intValue = (this.pzm.euR().getValue().intValue() * 255) / 100;
        this.GF.setAlpha(intValue);
        this.GG.setAlpha(intValue);
        if (this.pAO != null) {
            this.GG.setStrokeWidth(this.pAO.getValue().floatValue());
        } else {
            this.GG.setStrokeWidth((float) (value.ED * com.tb.airbnb.lottie.d.f.lb() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iJ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Ey) / 100.0f;
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
                    canvas.translate(((this.pAP != null ? this.pAP.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
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
            p euJ = this.lottieDrawable.euJ();
            String bh = euJ != null ? euJ.bh(str) : str;
            this.GF.setTypeface(q);
            this.GF.setTextSize((float) (bVar.Ey * com.tb.airbnb.lottie.d.f.lb()));
            this.GG.setTypeface(this.GF.getTypeface());
            this.GG.setTextSize(this.GF.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.GC[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.pAP != null ? this.pAP.getValue().floatValue() + f : f) * b) + this.GF.measureText(this.GC, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iW = a2.get(i).iW();
            iW.computeBounds(this.GD, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.EB)) * com.tb.airbnb.lottie.d.f.lb());
            this.matrix.preScale(f, f);
            iW.transform(this.matrix);
            if (bVar.EE) {
                a(iW, this.GF, canvas);
                a(iW, this.GG, canvas);
            } else {
                a(iW, this.GG, canvas);
                a(iW, this.GF, canvas);
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
        this.GC[0] = c;
        if (bVar.EE) {
            a(this.GC, this.GF, canvas);
            a(this.GC, this.GG, canvas);
            return;
        }
        a(this.GC, this.GG, canvas);
        a(this.GC, this.GF, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.GH.containsKey(dVar)) {
            return this.GH.get(dVar);
        }
        List<j> jz = dVar.jz();
        int size = jz.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, jz.get(i)));
        }
        this.GH.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.BV && this.pyX != null) {
            this.pyX.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BW && this.pAN != null) {
            this.pAN.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cf && this.pAO != null) {
            this.pAO.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cg && this.pAP != null) {
            this.pAP.a(cVar);
        }
    }
}
