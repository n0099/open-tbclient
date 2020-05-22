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
    private final char[] Ff;
    private final RectF Fg;
    private final Paint Fh;
    private final Paint Fi;
    private final Map<com.tb.airbnb.lottie.model.d, List<com.tb.airbnb.lottie.a.a.c>> Fj;
    private final com.tb.airbnb.lottie.d composition;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> niC;
    private final n nkr;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Integer, Integer> nks;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nkt;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.Ff = new char[1];
        this.Fg = new RectF();
        this.matrix = new Matrix();
        this.Fh = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Fi = new Paint(1) { // from class: com.tb.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Fj = new HashMap();
        this.lottieDrawable = fVar;
        this.composition = layer.getComposition();
        this.nkr = layer.dJv().dII();
        this.nkr.b(this);
        a(this.nkr);
        k dJw = layer.dJw();
        if (dJw != null && dJw.nju != null) {
            this.niC = dJw.nju.dII();
            this.niC.b(this);
            a(this.niC);
        }
        if (dJw != null && dJw.njv != null) {
            this.nks = dJw.njv.dII();
            this.nks.b(this);
            a(this.nks);
        }
        if (dJw != null && dJw.njw != null) {
            this.nkt = dJw.njw.dII();
            this.nkt.b(this);
            a(this.nkt);
        }
        if (dJw != null && dJw.njx != null) {
            this.nku = dJw.njx.dII();
            this.nku.b(this);
            a(this.nku);
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.gQ()) {
            canvas.setMatrix(matrix);
        }
        com.tb.airbnb.lottie.model.b value = this.nkr.getValue();
        com.tb.airbnb.lottie.model.c cVar = this.composition.gJ().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.niC != null) {
            this.Fh.setColor(this.niC.getValue().intValue());
        } else {
            this.Fh.setColor(value.color);
        }
        if (this.nks != null) {
            this.Fi.setColor(this.nks.getValue().intValue());
        } else {
            this.Fi.setColor(value.Dc);
        }
        int intValue = (this.niR.dID().getValue().intValue() * 255) / 100;
        this.Fh.setAlpha(intValue);
        this.Fi.setAlpha(intValue);
        if (this.nkt != null) {
            this.Fi.setStrokeWidth(this.nkt.getValue().floatValue());
        } else {
            this.Fi.setStrokeWidth((float) (value.Dd * com.tb.airbnb.lottie.d.f.jk() * com.tb.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.gQ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.tb.airbnb.lottie.model.b bVar, Matrix matrix, com.tb.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.CX) / 100.0f;
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
                    float f2 = bVar.CZ / 10.0f;
                    canvas.translate(((this.nku != null ? this.nku.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
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
            p dIv = this.lottieDrawable.dIv();
            String bb = dIv != null ? dIv.bb(str) : str;
            this.Fh.setTypeface(n);
            this.Fh.setTextSize((float) (bVar.CX * com.tb.airbnb.lottie.d.f.jk()));
            this.Fi.setTypeface(this.Fh.getTypeface());
            this.Fi.setTextSize(this.Fh.getTextSize());
            for (int i = 0; i < bb.length(); i++) {
                char charAt = bb.charAt(i);
                a(charAt, bVar, canvas);
                this.Ff[0] = charAt;
                float f = bVar.CZ / 10.0f;
                canvas.translate(((this.nku != null ? this.nku.getValue().floatValue() + f : f) * b) + this.Fh.measureText(this.Ff, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.tb.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.tb.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.tb.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path hd = a.get(i).hd();
            hd.computeBounds(this.Fg, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Db)) * com.tb.airbnb.lottie.d.f.jk());
            this.matrix.preScale(f, f);
            hd.transform(this.matrix);
            if (bVar.De) {
                a(hd, this.Fh, canvas);
                a(hd, this.Fi, canvas);
            } else {
                a(hd, this.Fi, canvas);
                a(hd, this.Fh, canvas);
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
        this.Ff[0] = c;
        if (bVar.De) {
            a(this.Ff, this.Fh, canvas);
            a(this.Ff, this.Fi, canvas);
            return;
        }
        a(this.Ff, this.Fi, canvas);
        a(this.Ff, this.Fh, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.tb.airbnb.lottie.a.a.c> a(com.tb.airbnb.lottie.model.d dVar) {
        if (this.Fj.containsKey(dVar)) {
            return this.Fj.get(dVar);
        }
        List<j> hG = dVar.hG();
        int size = hG.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tb.airbnb.lottie.a.a.c(this.lottieDrawable, this, hG.get(i)));
        }
        this.Fj.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.tb.airbnb.lottie.e.c<g>) cVar);
        if (t == com.tb.airbnb.lottie.j.Av && this.niC != null) {
            this.niC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Aw && this.nks != null) {
            this.nks.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AF && this.nkt != null) {
            this.nkt.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AG && this.nku != null) {
            this.nku.a(cVar);
        }
    }
}
