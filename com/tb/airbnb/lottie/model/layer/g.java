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
/* loaded from: classes7.dex */
public class g extends a {
    private final char[] Gk;
    private final RectF Gl;
    private final Paint Gm;
    private final Paint Gn;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> Go;
    private final com.tb.airbnb.lottie.d composition;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> oiA;
    private final n okp;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> okq;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> okr;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> oks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.Gk = new char[1];
        this.Gl = new RectF();
        this.matrix = new Matrix();
        this.Gm = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Gn = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Go = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.okp = layer.eeb().edo();
        this.okp.b(this);
        a(this.okp);
        k eec = layer.eec();
        if (eec != null && eec.ojs != null) {
            this.oiA = eec.ojs.edo();
            this.oiA.b(this);
            a(this.oiA);
        }
        if (eec != null && eec.ojt != null) {
            this.okq = eec.ojt.edo();
            this.okq.b(this);
            a(this.okq);
        }
        if (eec != null && eec.oju != null) {
            this.okr = eec.oju.edo();
            this.okr.b(this);
            a(this.okr);
        }
        if (eec != null && eec.ojv != null) {
            this.oks = eec.ojv.edo();
            this.oks.b(this);
            a(this.oks);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iH()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.okp.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.iA().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.oiA != null) {
            this.Gm.setColor(this.oiA.getValue().intValue());
        } else {
            this.Gm.setColor(value.color);
        }
        if (this.okq != null) {
            this.Gn.setColor(this.okq.getValue().intValue());
        } else {
            this.Gn.setColor(value.strokeColor);
        }
        int intValue = (this.oiP.edj().getValue().intValue() * 255) / 100;
        this.Gm.setAlpha(intValue);
        this.Gn.setAlpha(intValue);
        if (this.okr != null) {
            this.Gn.setStrokeWidth(this.okr.getValue().floatValue());
        } else {
            this.Gn.setStrokeWidth((float) (value.El * com.tb.airbnb.lottie.d.f.kZ() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iH()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Eh) / 100.0f;
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.d dVar = this.composition.iz().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.jv(), cVar.jw()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.kZ() * b;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.oks != null ? this.oks.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface q = this.lottieDrawable.q(cVar.jv(), cVar.jw());
        if (q != null) {
            String str = bVar.text;
            p edb = this.lottieDrawable.edb();
            String bh = edb != null ? edb.bh(str) : str;
            this.Gm.setTypeface(q);
            this.Gm.setTextSize((float) (bVar.Eh * com.tb.airbnb.lottie.d.f.kZ()));
            this.Gn.setTypeface(this.Gm.getTypeface());
            this.Gn.setTextSize(this.Gm.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Gk[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.oks != null ? this.oks.getValue().floatValue() + f : f) * b) + this.Gm.measureText(this.Gk, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path iU = a.get(i).iU();
            iU.computeBounds(this.Gl, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Ek)) * com.tb.airbnb.lottie.d.f.kZ());
            this.matrix.preScale(f, f);
            iU.transform(this.matrix);
            if (bVar.Em) {
                a(iU, this.Gm, canvas);
                a(iU, this.Gn, canvas);
            } else {
                a(iU, this.Gn, canvas);
                a(iU, this.Gm, canvas);
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
        this.Gk[0] = c;
        if (bVar.Em) {
            a(this.Gk, this.Gm, canvas);
            a(this.Gk, this.Gn, canvas);
            return;
        }
        a(this.Gk, this.Gn, canvas);
        a(this.Gk, this.Gm, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.Go.containsKey(dVar)) {
            return this.Go.get(dVar);
        }
        List<j> jx = dVar.jx();
        int size = jx.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, jx.get(i)));
        }
        this.Go.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.BE && this.oiA != null) {
            this.oiA.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BF && this.okq != null) {
            this.okq.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BO && this.okr != null) {
            this.okr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BP && this.oks != null) {
            this.oks.a(cVar);
        }
    }
}
