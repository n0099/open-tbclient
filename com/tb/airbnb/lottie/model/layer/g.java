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
    private final char[] Fc;
    private final RectF Fd;
    private final Paint Fe;
    private final Paint Ff;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> Fg;
    private final com.tb.airbnb.lottie.d composition;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> mOu;
    private final n mQl;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> mQm;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> mQn;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> mQo;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.Fc = new char[1];
        this.Fd = new RectF();
        this.matrix = new Matrix();
        this.Fe = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Ff = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Fg = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.mQl = layer.dCf().dBs();
        this.mQl.b(this);
        a(this.mQl);
        k dCg = layer.dCg();
        if (dCg != null && dCg.mPo != null) {
            this.mOu = dCg.mPo.dBs();
            this.mOu.b(this);
            a(this.mOu);
        }
        if (dCg != null && dCg.mPp != null) {
            this.mQm = dCg.mPp.dBs();
            this.mQm.b(this);
            a(this.mQm);
        }
        if (dCg != null && dCg.mPq != null) {
            this.mQn = dCg.mPq.dBs();
            this.mQn.b(this);
            a(this.mQn);
        }
        if (dCg != null && dCg.mPr != null) {
            this.mQo = dCg.mPr.dBs();
            this.mQo.b(this);
            a(this.mQo);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.gQ()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.mQl.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.gJ().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.mOu != null) {
            this.Fe.setColor(this.mOu.getValue().intValue());
        } else {
            this.Fe.setColor(value.color);
        }
        if (this.mQm != null) {
            this.Ff.setColor(this.mQm.getValue().intValue());
        } else {
            this.Ff.setColor(value.CZ);
        }
        int intValue = (this.mOJ.dBn().getValue().intValue() * 255) / 100;
        this.Fe.setAlpha(intValue);
        this.Ff.setAlpha(intValue);
        if (this.mQn != null) {
            this.Ff.setStrokeWidth(this.mQn.getValue().floatValue());
        } else {
            this.Ff.setStrokeWidth((float) (value.Da * com.tb.airbnb.lottie.d.f.jk() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.gQ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.CU) / 100.0f;
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.tb.airbnb.lottie.model.d dVar = this.composition.gI().get(com.tb.airbnb.lottie.model.d.a(str.charAt(i2), cVar.hE(), cVar.hF()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.tb.airbnb.lottie.d.f.jk() * b;
                    float f2 = bVar.CW / 10.0f;
                    canvas.translate(((this.mQo != null ? this.mQo.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, com.tb.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        Typeface n = this.lottieDrawable.n(cVar.hE(), cVar.hF());
        if (n != null) {
            String str = bVar.text;
            p dBf = this.lottieDrawable.dBf();
            String bb = dBf != null ? dBf.bb(str) : str;
            this.Fe.setTypeface(n);
            this.Fe.setTextSize((float) (bVar.CU * com.tb.airbnb.lottie.d.f.jk()));
            this.Ff.setTypeface(this.Fe.getTypeface());
            this.Ff.setTextSize(this.Fe.getTextSize());
            for (int i = 0; i < bb.length(); i++) {
                char charAt = bb.charAt(i);
                a(charAt, bVar, canvas);
                this.Fc[0] = charAt;
                float f = bVar.CW / 10.0f;
                canvas.translate(((this.mQo != null ? this.mQo.getValue().floatValue() + f : f) * b) + this.Fe.measureText(this.Fc, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path hd = a.get(i).hd();
            hd.computeBounds(this.Fd, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.CY)) * com.tb.airbnb.lottie.d.f.jk());
            this.matrix.preScale(f, f);
            hd.transform(this.matrix);
            if (bVar.Db) {
                a(hd, this.Fe, canvas);
                a(hd, this.Ff, canvas);
            } else {
                a(hd, this.Ff, canvas);
                a(hd, this.Fe, canvas);
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
        this.Fc[0] = c;
        if (bVar.Db) {
            a(this.Fc, this.Fe, canvas);
            a(this.Fc, this.Ff, canvas);
            return;
        }
        a(this.Fc, this.Ff, canvas);
        a(this.Fc, this.Fe, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.Fg.containsKey(dVar)) {
            return this.Fg.get(dVar);
        }
        List<j> hG = dVar.hG();
        int size = hG.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, hG.get(i)));
        }
        this.Fg.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.Av && this.mOu != null) {
            this.mOu.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Aw && this.mQm != null) {
            this.mQm.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AF && this.mQn != null) {
            this.mQn.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AG && this.mQo != null) {
            this.mQo.a(cVar);
        }
    }
}
