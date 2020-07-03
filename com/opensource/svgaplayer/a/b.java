package com.opensource.svgaplayer.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.a.a;
import com.opensource.svgaplayer.c;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.f;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.a.r;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c nAs;
    private final C0858b nBt;
    private final HashMap<String, Bitmap> nBu;
    private final a nBv;
    private final float[] nBw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nAs = cVar;
        this.nBt = new C0858b();
        this.nBu = new HashMap<>();
        this.nBv = new a();
        this.nBw = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nBv.ak(canvas);
        for (a.C0857a c0857a : KC(i)) {
            a(c0857a, canvas, i);
        }
        KD(i);
    }

    private final void KD(int i) {
        SoundPool dLM;
        Integer dLZ;
        for (com.opensource.svgaplayer.entities.a aVar : dLt().dLL()) {
            if (aVar.dLX() == i && (dLM = dLt().dLM()) != null && (dLZ = aVar.dLZ()) != null) {
                aVar.s(Integer.valueOf(dLM.play(dLZ.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dLY() <= i) {
                Integer dMa = aVar.dMa();
                if (dMa != null) {
                    int intValue = dMa.intValue();
                    SoundPool dLM2 = dLt().dLM();
                    if (dLM2 != null) {
                        dLM2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dLV = this.nBt.dLV();
        dLV.postScale(dLP().dMu(), dLP().dMv());
        dLV.postTranslate(dLP().dMs(), dLP().dMt());
        dLV.preConcat(matrix);
        return dLV;
    }

    private final void a(a.C0857a c0857a, Canvas canvas, int i) {
        a(c0857a, canvas);
        b(c0857a, canvas);
        b(c0857a, canvas, i);
    }

    private final void a(a.C0857a c0857a, Canvas canvas) {
        String dLQ = c0857a.dLQ();
        if (dLQ != null && !q.l((Object) this.nAs.dLu().get(dLQ), (Object) true)) {
            Bitmap bitmap = this.nAs.dLv().get(dLQ);
            if (bitmap == null) {
                bitmap = dLt().dLN().get(dLQ);
            }
            if (bitmap != null) {
                Matrix c = c(c0857a.dLR().dMd());
                Paint dLS = this.nBt.dLS();
                dLS.setAntiAlias(dLt().dLH());
                dLS.setFilterBitmap(dLt().dLH());
                dLS.setAlpha((int) (c0857a.dLR().dMp() * 255));
                if (c0857a.dLR().dMr() != null) {
                    com.opensource.svgaplayer.entities.b dMr = c0857a.dLR().dMr();
                    if (dMr != null) {
                        canvas.save();
                        dLS.reset();
                        Path dLT = this.nBt.dLT();
                        dMr.a(dLT);
                        dLT.transform(c);
                        canvas.clipPath(dLT);
                        c.preScale((float) (c0857a.dLR().dMq().getWidth() / bitmap.getWidth()), (float) (c0857a.dLR().dMq().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dLS);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0857a.dLR().dMq().getWidth() / bitmap.getWidth()), (float) (c0857a.dLR().dMq().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dLS);
                }
                a(canvas, bitmap, c0857a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0857a c0857a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nAs.dLB()) {
            this.nBu.clear();
            this.nAs.xg(false);
        }
        String dLQ = c0857a.dLQ();
        if (dLQ != null) {
            Bitmap bitmap3 = null;
            String str = this.nAs.dLw().get(dLQ);
            if (str != null) {
                TextPaint textPaint = this.nAs.dLx().get(dLQ);
                if (textPaint != null && (bitmap3 = this.nBu.get(dLQ)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nBu;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dLQ, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nAs.dLy().get(dLQ);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nBu.get(dLQ);
                if (bitmap4 == null) {
                    q.l((Object) staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    q.l((Object) paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.nBu;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dLQ, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dLS = this.nBt.dLS();
                dLS.setAntiAlias(dLt().dLH());
                if (c0857a.dLR().dMr() != null) {
                    com.opensource.svgaplayer.entities.b dMr = c0857a.dLR().dMr();
                    if (dMr != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dLS.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dLT = this.nBt.dLT();
                        dMr.a(dLT);
                        canvas.drawPath(dLT, dLS);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dLS.setFilterBitmap(dLt().dLH());
                canvas.drawBitmap(bitmap2, matrix, dLS);
            }
        }
    }

    private final void b(a.C0857a c0857a, Canvas canvas) {
        float[] dMm;
        String dMk;
        String dMj;
        int dMh;
        Matrix c = c(c0857a.dLR().dMd());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0857a.dLR().hW()) {
            sVGAVideoShapeEntity.dMg();
            if (sVGAVideoShapeEntity.dMf() != null) {
                Paint dLS = this.nBt.dLS();
                dLS.reset();
                dLS.setAntiAlias(dLt().dLH());
                dLS.setAlpha((int) (c0857a.dLR().dMp() * 255));
                Path dLT = this.nBt.dLT();
                dLT.reset();
                dLT.addPath(this.nBv.a(sVGAVideoShapeEntity));
                Matrix dLW = this.nBt.dLW();
                dLW.reset();
                Matrix dMd = sVGAVideoShapeEntity.dMd();
                if (dMd != null) {
                    dLW.postConcat(dMd);
                }
                dLW.postConcat(c);
                dLT.transform(dLW);
                SVGAVideoShapeEntity.a dMc = sVGAVideoShapeEntity.dMc();
                if (dMc != null && (dMh = dMc.dMh()) != 0) {
                    dLS.setStyle(Paint.Style.FILL);
                    dLS.setColor(dMh);
                    dLS.setAlpha(Math.min(255, Math.max(0, (int) (c0857a.dLR().dMp() * 255))));
                    if (c0857a.dLR().dMr() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dMr = c0857a.dLR().dMr();
                    if (dMr != null) {
                        Path dLU = this.nBt.dLU();
                        dMr.a(dLU);
                        dLU.transform(c);
                        canvas.clipPath(dLU);
                    }
                    canvas.drawPath(dLT, dLS);
                    if (c0857a.dLR().dMr() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dMc2 = sVGAVideoShapeEntity.dMc();
                if (dMc2 != null && dMc2.getStrokeWidth() > 0) {
                    dLS.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dMc3 = sVGAVideoShapeEntity.dMc();
                    if (dMc3 != null) {
                        dLS.setColor(dMc3.dMi());
                        dLS.setAlpha(Math.min(255, Math.max(0, (int) (c0857a.dLR().dMp() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dMc4 = sVGAVideoShapeEntity.dMc();
                    if (dMc4 != null) {
                        dLS.setStrokeWidth(dMc4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dMc5 = sVGAVideoShapeEntity.dMc();
                    if (dMc5 != null && (dMj = dMc5.dMj()) != null) {
                        if (l.I(dMj, "butt", true)) {
                            dLS.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.I(dMj, "round", true)) {
                            dLS.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.I(dMj, "square", true)) {
                            dLS.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dMc6 = sVGAVideoShapeEntity.dMc();
                    if (dMc6 != null && (dMk = dMc6.dMk()) != null) {
                        if (l.I(dMk, "miter", true)) {
                            dLS.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.I(dMk, "round", true)) {
                            dLS.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.I(dMk, "bevel", true)) {
                            dLS.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dMc7 = sVGAVideoShapeEntity.dMc();
                    if (dMc7 != null) {
                        dLS.setStrokeMiter(dMc7.dMl() * d);
                    }
                    SVGAVideoShapeEntity.a dMc8 = sVGAVideoShapeEntity.dMc();
                    if (dMc8 != null && (dMm = dMc8.dMm()) != null && dMm.length == 3 && (dMm[0] > 0 || dMm[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dMm[0] < 1.0f ? 1.0f : dMm[0]) * d;
                        fArr[1] = (dMm[1] < 0.1f ? 0.1f : dMm[1]) * d;
                        dLS.setPathEffect(new DashPathEffect(fArr, dMm[2] * d));
                    }
                    if (c0857a.dLR().dMr() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dMr2 = c0857a.dLR().dMr();
                    if (dMr2 != null) {
                        Path dLU2 = this.nBt.dLU();
                        dMr2.a(dLU2);
                        dLU2.transform(c);
                        canvas.clipPath(dLU2);
                    }
                    canvas.drawPath(dLT, dLS);
                    if (c0857a.dLR().dMr() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nBw);
        if (this.nBw[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nBw[0];
        double d2 = this.nBw[3];
        double d3 = this.nBw[1];
        double d4 = this.nBw[4];
        if (d * d4 == d2 * d3) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d * d) + (d2 * d2));
        double d5 = d / sqrt;
        double d6 = d2 / sqrt;
        double d7 = (d5 * d3) + (d6 * d4);
        double d8 = d3 - (d5 * d7);
        double d9 = d4 - (d6 * d7);
        double sqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
        double d10 = d7 / sqrt2;
        if (d5 * (d9 / sqrt2) < d6 * (d8 / sqrt2)) {
            sqrt = -sqrt;
        }
        return dLP().dMw() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0857a c0857a, Canvas canvas, int i) {
        String dLQ = c0857a.dLQ();
        if (dLQ != null) {
            m<Canvas, Integer, Boolean> mVar = this.nAs.dLz().get(dLQ);
            if (mVar != null) {
                Matrix c = c(c0857a.dLR().dMd());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nAs.dLA().get(dLQ);
            if (rVar != null) {
                Matrix c2 = c(c0857a.dLR().dMd());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0857a.dLR().dMq().getWidth()), Integer.valueOf((int) c0857a.dLR().dMq().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0858b {
        private final Paint nBA = new Paint();
        private final Path nBB = new Path();
        private final Path nBC = new Path();
        private final Matrix nBD = new Matrix();
        private final Matrix nBE = new Matrix();

        public final Paint dLS() {
            this.nBA.reset();
            return this.nBA;
        }

        public final Path dLT() {
            this.nBB.reset();
            return this.nBB;
        }

        public final Path dLU() {
            this.nBC.reset();
            return this.nBC;
        }

        public final Matrix dLV() {
            this.nBD.reset();
            return this.nBD;
        }

        public final Matrix dLW() {
            this.nBE.reset();
            return this.nBE;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nBx;
        private int nBy;
        private final HashMap<SVGAVideoShapeEntity, Path> nBz = new HashMap<>();

        public final void ak(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.nBx != canvas.getWidth() || this.nBy != canvas.getHeight()) {
                this.nBz.clear();
            }
            this.nBx = canvas.getWidth();
            this.nBy = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.nBz.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dMf());
                this.nBz.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nBz.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dQG();
            }
            return path2;
        }
    }
}
