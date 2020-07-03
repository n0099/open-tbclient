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
    private final char[] FF;
    private final RectF FG;
    private final Paint FH;
    private final Paint FI;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> FJ;
    private final com.tb.airbnb.lottie.d composition;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> nFB;
    private final n nHq;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> nHr;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nHs;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nHt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.FF = new char[1];
        this.FG = new RectF();
        this.matrix = new Matrix();
        this.FH = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.FI = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.FJ = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.nHq = layer.dOp().dNC();
        this.nHq.b(this);
        a(this.nHq);
        k dOq = layer.dOq();
        if (dOq != null && dOq.nGt != null) {
            this.nFB = dOq.nGt.dNC();
            this.nFB.b(this);
            a(this.nFB);
        }
        if (dOq != null && dOq.nGu != null) {
            this.nHr = dOq.nGu.dNC();
            this.nHr.b(this);
            a(this.nHr);
        }
        if (dOq != null && dOq.nGv != null) {
            this.nHs = dOq.nGv.dNC();
            this.nHs.b(this);
            a(this.nHs);
        }
        if (dOq != null && dOq.nGw != null) {
            this.nHt = dOq.nGw.dNC();
            this.nHt.b(this);
            a(this.nHt);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.hg()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.nHq.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.gZ().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.nFB != null) {
            this.FH.setColor(this.nFB.getValue().intValue());
        } else {
            this.FH.setColor(value.color);
        }
        if (this.nHr != null) {
            this.FI.setColor(this.nHr.getValue().intValue());
        } else {
            this.FI.setColor(value.DD);
        }
        int intValue = (this.nFQ.dNx().getValue().intValue() * 255) / 100;
        this.FH.setAlpha(intValue);
        this.FI.setAlpha(intValue);
        if (this.nHs != null) {
            this.FI.setStrokeWidth(this.nHs.getValue().floatValue());
        } else {
            this.FI.setStrokeWidth((float) (value.DE * com.tb.airbnb.lottie.d.f.jA() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.hg()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Dx) / 100.0f;
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.d dVar = this.composition.gY().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.hU(), cVar.hV()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.jA() * b;
                    float f2 = bVar.Dz / 10.0f;
                    canvas.translate(((this.nHt != null ? this.nHt.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface n = this.lottieDrawable.n(cVar.hU(), cVar.hV());
        if (n != null) {
            String str = bVar.text;
            p dNp = this.lottieDrawable.dNp();
            String bc = dNp != null ? dNp.bc(str) : str;
            this.FH.setTypeface(n);
            this.FH.setTextSize((float) (bVar.Dx * com.tb.airbnb.lottie.d.f.jA()));
            this.FI.setTypeface(this.FH.getTypeface());
            this.FI.setTextSize(this.FH.getTextSize());
            for (int i = 0; i < bc.length(); i++) {
                char charAt = bc.charAt(i);
                a(charAt, bVar, canvas);
                this.FF[0] = charAt;
                float f = bVar.Dz / 10.0f;
                canvas.translate(((this.nHt != null ? this.nHt.getValue().floatValue() + f : f) * b) + this.FH.measureText(this.FF, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path ht = a.get(i).ht();
            ht.computeBounds(this.FG, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.DC)) * com.tb.airbnb.lottie.d.f.jA());
            this.matrix.preScale(f, f);
            ht.transform(this.matrix);
            if (bVar.DG) {
                a(ht, this.FH, canvas);
                a(ht, this.FI, canvas);
            } else {
                a(ht, this.FI, canvas);
                a(ht, this.FH, canvas);
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
        this.FF[0] = c;
        if (bVar.DG) {
            a(this.FF, this.FH, canvas);
            a(this.FF, this.FI, canvas);
            return;
        }
        a(this.FF, this.FI, canvas);
        a(this.FF, this.FH, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.FJ.containsKey(dVar)) {
            return this.FJ.get(dVar);
        }
        List<j> hW = dVar.hW();
        int size = hW.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, hW.get(i)));
        }
        this.FJ.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.AY && this.nFB != null) {
            this.nFB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AZ && this.nHr != null) {
            this.nHr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bi && this.nHs != null) {
            this.nHs.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bj && this.nHt != null) {
            this.nHt.a(cVar);
        }
    }
}
