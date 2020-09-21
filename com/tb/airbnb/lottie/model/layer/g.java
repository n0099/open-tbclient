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
/* loaded from: classes17.dex */
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
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> osk;
    private final n otZ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> oua;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> oub;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> ouc;

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
        this.otZ = layer.ehY().ehl();
        this.otZ.b(this);
        a(this.otZ);
        k ehZ = layer.ehZ();
        if (ehZ != null && ehZ.otc != null) {
            this.osk = ehZ.otc.ehl();
            this.osk.b(this);
            a(this.osk);
        }
        if (ehZ != null && ehZ.otd != null) {
            this.oua = ehZ.otd.ehl();
            this.oua.b(this);
            a(this.oua);
        }
        if (ehZ != null && ehZ.ote != null) {
            this.oub = ehZ.ote.ehl();
            this.oub.b(this);
            a(this.oub);
        }
        if (ehZ != null && ehZ.otf != null) {
            this.ouc = ehZ.otf.ehl();
            this.ouc.b(this);
            a(this.ouc);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iI()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.otZ.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.iA().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.osk != null) {
            this.Gm.setColor(this.osk.getValue().intValue());
        } else {
            this.Gm.setColor(value.color);
        }
        if (this.oua != null) {
            this.Gn.setColor(this.oua.getValue().intValue());
        } else {
            this.Gn.setColor(value.strokeColor);
        }
        int intValue = (this.osz.ehg().getValue().intValue() * 255) / 100;
        this.Gm.setAlpha(intValue);
        this.Gn.setAlpha(intValue);
        if (this.oub != null) {
            this.Gn.setStrokeWidth(this.oub.getValue().floatValue());
        } else {
            this.Gn.setStrokeWidth((float) (value.El * com.tb.airbnb.lottie.d.f.la() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iI()) {
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
                com.tb.airbnb.lottie.model.d dVar = this.composition.iz().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.jw(), cVar.jx()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.la() * b;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.ouc != null ? this.ouc.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface q = this.lottieDrawable.q(cVar.jw(), cVar.jx());
        if (q != null) {
            String str = bVar.text;
            p egY = this.lottieDrawable.egY();
            String bh = egY != null ? egY.bh(str) : str;
            this.Gm.setTypeface(q);
            this.Gm.setTextSize((float) (bVar.Eh * com.tb.airbnb.lottie.d.f.la()));
            this.Gn.setTypeface(this.Gm.getTypeface());
            this.Gn.setTextSize(this.Gm.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Gk[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.ouc != null ? this.ouc.getValue().floatValue() + f : f) * b) + this.Gm.measureText(this.Gk, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path iV = a.get(i).iV();
            iV.computeBounds(this.Gl, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Ek)) * com.tb.airbnb.lottie.d.f.la());
            this.matrix.preScale(f, f);
            iV.transform(this.matrix);
            if (bVar.Em) {
                a(iV, this.Gm, canvas);
                a(iV, this.Gn, canvas);
            } else {
                a(iV, this.Gn, canvas);
                a(iV, this.Gm, canvas);
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
        List<j> jy = dVar.jy();
        int size = jy.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, jy.get(i)));
        }
        this.Go.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.BE && this.osk != null) {
            this.osk.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BF && this.oua != null) {
            this.oua.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BO && this.oub != null) {
            this.oub.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BP && this.ouc != null) {
            this.ouc.a(cVar);
        }
    }
}
