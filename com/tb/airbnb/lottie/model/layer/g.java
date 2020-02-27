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
/* loaded from: classes6.dex */
public class g extends a {
    private final com.tb.airbnb.lottie.d composition;
    private final char[] jG;
    private final RectF jH;
    private final Paint jI;
    private final Paint jJ;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> jK;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> npL;
    private final n nrA;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> nrB;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nrC;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nrD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.jG = new char[1];
        this.jH = new RectF();
        this.matrix = new Matrix();
        this.jI = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.jJ = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.jK = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.nrA = layer.dHA().dGN();
        this.nrA.b(this);
        a(this.nrA);
        k dHB = layer.dHB();
        if (dHB != null && dHB.nqD != null) {
            this.npL = dHB.nqD.dGN();
            this.npL.b(this);
            a(this.npL);
        }
        if (dHB != null && dHB.nqE != null) {
            this.nrB = dHB.nqE.dGN();
            this.nrB.b(this);
            a(this.nrB);
        }
        if (dHB != null && dHB.nqF != null) {
            this.nrC = dHB.nqF.dGN();
            this.nrC.b(this);
            a(this.nrC);
        }
        if (dHB != null && dHB.nqG != null) {
            this.nrD = dHB.nqG.dGN();
            this.nrD.b(this);
            a(this.nrD);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bt()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.nrA.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.bm().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.npL != null) {
            this.jI.setColor(this.npL.getValue().intValue());
        } else {
            this.jI.setColor(value.color);
        }
        if (this.nrB != null) {
            this.jJ.setColor(this.nrB.getValue().intValue());
        } else {
            this.jJ.setColor(value.hx);
        }
        int intValue = (this.nqa.dGI().getValue().intValue() * 255) / 100;
        this.jI.setAlpha(intValue);
        this.jJ.setAlpha(intValue);
        if (this.nrC != null) {
            this.jJ.setStrokeWidth(this.nrC.getValue().floatValue());
        } else {
            this.jJ.setStrokeWidth((float) (value.hy * com.tb.airbnb.lottie.d.f.dL() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.bt()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.hs) / 100.0f;
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.d dVar = this.composition.bl().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.ch(), cVar.ci()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.dL() * b;
                    float f2 = bVar.hu / 10.0f;
                    canvas.translate(((this.nrD != null ? this.nrD.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface j = this.lottieDrawable.j(cVar.ch(), cVar.ci());
        if (j != null) {
            String str = bVar.text;
            p dGA = this.lottieDrawable.dGA();
            String L = dGA != null ? dGA.L(str) : str;
            this.jI.setTypeface(j);
            this.jI.setTextSize((float) (bVar.hs * com.tb.airbnb.lottie.d.f.dL()));
            this.jJ.setTypeface(this.jI.getTypeface());
            this.jJ.setTextSize(this.jI.getTextSize());
            for (int i = 0; i < L.length(); i++) {
                char charAt = L.charAt(i);
                a(charAt, bVar, canvas);
                this.jG[0] = charAt;
                float f = bVar.hu / 10.0f;
                canvas.translate(((this.nrD != null ? this.nrD.getValue().floatValue() + f : f) * b) + this.jI.measureText(this.jG, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path bG = a.get(i).bG();
            bG.computeBounds(this.jH, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.hw)) * com.tb.airbnb.lottie.d.f.dL());
            this.matrix.preScale(f, f);
            bG.transform(this.matrix);
            if (bVar.hz) {
                a(bG, this.jI, canvas);
                a(bG, this.jJ, canvas);
            } else {
                a(bG, this.jJ, canvas);
                a(bG, this.jI, canvas);
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
        this.jG[0] = c;
        if (bVar.hz) {
            a(this.jG, this.jI, canvas);
            a(this.jG, this.jJ, canvas);
            return;
        }
        a(this.jG, this.jJ, canvas);
        a(this.jG, this.jI, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.jK.containsKey(dVar)) {
            return this.jK.get(dVar);
        }
        List<j> cj = dVar.cj();
        int size = cj.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, cj.get(i)));
        }
        this.jK.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.eN && this.npL != null) {
            this.npL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eO && this.nrB != null) {
            this.nrB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eX && this.nrC != null) {
            this.nrC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eY && this.nrD != null) {
            this.nrD.a(cVar);
        }
    }
}
