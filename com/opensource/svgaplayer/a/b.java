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
    private final c nAv;
    private final C0859b nBw;
    private final HashMap<String, Bitmap> nBx;
    private final a nBy;
    private final float[] nBz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nAv = cVar;
        this.nBw = new C0859b();
        this.nBx = new HashMap<>();
        this.nBy = new a();
        this.nBz = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nBy.ak(canvas);
        for (a.C0858a c0858a : KC(i)) {
            a(c0858a, canvas, i);
        }
        KD(i);
    }

    private final void KD(int i) {
        SoundPool dLQ;
        Integer dMd;
        for (com.opensource.svgaplayer.entities.a aVar : dLx().dLP()) {
            if (aVar.dMb() == i && (dLQ = dLx().dLQ()) != null && (dMd = aVar.dMd()) != null) {
                aVar.s(Integer.valueOf(dLQ.play(dMd.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dMc() <= i) {
                Integer dMe = aVar.dMe();
                if (dMe != null) {
                    int intValue = dMe.intValue();
                    SoundPool dLQ2 = dLx().dLQ();
                    if (dLQ2 != null) {
                        dLQ2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dLZ = this.nBw.dLZ();
        dLZ.postScale(dLT().dMy(), dLT().dMz());
        dLZ.postTranslate(dLT().dMw(), dLT().dMx());
        dLZ.preConcat(matrix);
        return dLZ;
    }

    private final void a(a.C0858a c0858a, Canvas canvas, int i) {
        a(c0858a, canvas);
        b(c0858a, canvas);
        b(c0858a, canvas, i);
    }

    private final void a(a.C0858a c0858a, Canvas canvas) {
        String dLU = c0858a.dLU();
        if (dLU != null && !q.l((Object) this.nAv.dLy().get(dLU), (Object) true)) {
            Bitmap bitmap = this.nAv.dLz().get(dLU);
            if (bitmap == null) {
                bitmap = dLx().dLR().get(dLU);
            }
            if (bitmap != null) {
                Matrix c = c(c0858a.dLV().dMh());
                Paint dLW = this.nBw.dLW();
                dLW.setAntiAlias(dLx().dLL());
                dLW.setFilterBitmap(dLx().dLL());
                dLW.setAlpha((int) (c0858a.dLV().dMt() * 255));
                if (c0858a.dLV().dMv() != null) {
                    com.opensource.svgaplayer.entities.b dMv = c0858a.dLV().dMv();
                    if (dMv != null) {
                        canvas.save();
                        dLW.reset();
                        Path dLX = this.nBw.dLX();
                        dMv.a(dLX);
                        dLX.transform(c);
                        canvas.clipPath(dLX);
                        c.preScale((float) (c0858a.dLV().dMu().getWidth() / bitmap.getWidth()), (float) (c0858a.dLV().dMu().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dLW);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0858a.dLV().dMu().getWidth() / bitmap.getWidth()), (float) (c0858a.dLV().dMu().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dLW);
                }
                a(canvas, bitmap, c0858a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0858a c0858a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nAv.dLF()) {
            this.nBx.clear();
            this.nAv.xg(false);
        }
        String dLU = c0858a.dLU();
        if (dLU != null) {
            Bitmap bitmap3 = null;
            String str = this.nAv.dLA().get(dLU);
            if (str != null) {
                TextPaint textPaint = this.nAv.dLB().get(dLU);
                if (textPaint != null && (bitmap3 = this.nBx.get(dLU)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nBx;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dLU, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nAv.dLC().get(dLU);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nBx.get(dLU);
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
                    HashMap<String, Bitmap> hashMap2 = this.nBx;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dLU, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dLW = this.nBw.dLW();
                dLW.setAntiAlias(dLx().dLL());
                if (c0858a.dLV().dMv() != null) {
                    com.opensource.svgaplayer.entities.b dMv = c0858a.dLV().dMv();
                    if (dMv != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dLW.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dLX = this.nBw.dLX();
                        dMv.a(dLX);
                        canvas.drawPath(dLX, dLW);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dLW.setFilterBitmap(dLx().dLL());
                canvas.drawBitmap(bitmap2, matrix, dLW);
            }
        }
    }

    private final void b(a.C0858a c0858a, Canvas canvas) {
        float[] dMq;
        String dMo;
        String dMn;
        int dMl;
        Matrix c = c(c0858a.dLV().dMh());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0858a.dLV().hW()) {
            sVGAVideoShapeEntity.dMk();
            if (sVGAVideoShapeEntity.dMj() != null) {
                Paint dLW = this.nBw.dLW();
                dLW.reset();
                dLW.setAntiAlias(dLx().dLL());
                dLW.setAlpha((int) (c0858a.dLV().dMt() * 255));
                Path dLX = this.nBw.dLX();
                dLX.reset();
                dLX.addPath(this.nBy.a(sVGAVideoShapeEntity));
                Matrix dMa = this.nBw.dMa();
                dMa.reset();
                Matrix dMh = sVGAVideoShapeEntity.dMh();
                if (dMh != null) {
                    dMa.postConcat(dMh);
                }
                dMa.postConcat(c);
                dLX.transform(dMa);
                SVGAVideoShapeEntity.a dMg = sVGAVideoShapeEntity.dMg();
                if (dMg != null && (dMl = dMg.dMl()) != 0) {
                    dLW.setStyle(Paint.Style.FILL);
                    dLW.setColor(dMl);
                    dLW.setAlpha(Math.min(255, Math.max(0, (int) (c0858a.dLV().dMt() * 255))));
                    if (c0858a.dLV().dMv() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dMv = c0858a.dLV().dMv();
                    if (dMv != null) {
                        Path dLY = this.nBw.dLY();
                        dMv.a(dLY);
                        dLY.transform(c);
                        canvas.clipPath(dLY);
                    }
                    canvas.drawPath(dLX, dLW);
                    if (c0858a.dLV().dMv() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dMg2 = sVGAVideoShapeEntity.dMg();
                if (dMg2 != null && dMg2.getStrokeWidth() > 0) {
                    dLW.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dMg3 = sVGAVideoShapeEntity.dMg();
                    if (dMg3 != null) {
                        dLW.setColor(dMg3.dMm());
                        dLW.setAlpha(Math.min(255, Math.max(0, (int) (c0858a.dLV().dMt() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dMg4 = sVGAVideoShapeEntity.dMg();
                    if (dMg4 != null) {
                        dLW.setStrokeWidth(dMg4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dMg5 = sVGAVideoShapeEntity.dMg();
                    if (dMg5 != null && (dMn = dMg5.dMn()) != null) {
                        if (l.I(dMn, "butt", true)) {
                            dLW.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.I(dMn, "round", true)) {
                            dLW.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.I(dMn, "square", true)) {
                            dLW.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dMg6 = sVGAVideoShapeEntity.dMg();
                    if (dMg6 != null && (dMo = dMg6.dMo()) != null) {
                        if (l.I(dMo, "miter", true)) {
                            dLW.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.I(dMo, "round", true)) {
                            dLW.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.I(dMo, "bevel", true)) {
                            dLW.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dMg7 = sVGAVideoShapeEntity.dMg();
                    if (dMg7 != null) {
                        dLW.setStrokeMiter(dMg7.dMp() * d);
                    }
                    SVGAVideoShapeEntity.a dMg8 = sVGAVideoShapeEntity.dMg();
                    if (dMg8 != null && (dMq = dMg8.dMq()) != null && dMq.length == 3 && (dMq[0] > 0 || dMq[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dMq[0] < 1.0f ? 1.0f : dMq[0]) * d;
                        fArr[1] = (dMq[1] < 0.1f ? 0.1f : dMq[1]) * d;
                        dLW.setPathEffect(new DashPathEffect(fArr, dMq[2] * d));
                    }
                    if (c0858a.dLV().dMv() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dMv2 = c0858a.dLV().dMv();
                    if (dMv2 != null) {
                        Path dLY2 = this.nBw.dLY();
                        dMv2.a(dLY2);
                        dLY2.transform(c);
                        canvas.clipPath(dLY2);
                    }
                    canvas.drawPath(dLX, dLW);
                    if (c0858a.dLV().dMv() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nBz);
        if (this.nBz[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nBz[0];
        double d2 = this.nBz[3];
        double d3 = this.nBz[1];
        double d4 = this.nBz[4];
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
        return dLT().dMA() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0858a c0858a, Canvas canvas, int i) {
        String dLU = c0858a.dLU();
        if (dLU != null) {
            m<Canvas, Integer, Boolean> mVar = this.nAv.dLD().get(dLU);
            if (mVar != null) {
                Matrix c = c(c0858a.dLV().dMh());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nAv.dLE().get(dLU);
            if (rVar != null) {
                Matrix c2 = c(c0858a.dLV().dMh());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0858a.dLV().dMu().getWidth()), Integer.valueOf((int) c0858a.dLV().dMu().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0859b {
        private final Paint nBD = new Paint();
        private final Path nBE = new Path();
        private final Path nBF = new Path();
        private final Matrix nBG = new Matrix();
        private final Matrix nBH = new Matrix();

        public final Paint dLW() {
            this.nBD.reset();
            return this.nBD;
        }

        public final Path dLX() {
            this.nBE.reset();
            return this.nBE;
        }

        public final Path dLY() {
            this.nBF.reset();
            return this.nBF;
        }

        public final Matrix dLZ() {
            this.nBG.reset();
            return this.nBG;
        }

        public final Matrix dMa() {
            this.nBH.reset();
            return this.nBH;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nBA;
        private int nBB;
        private final HashMap<SVGAVideoShapeEntity, Path> nBC = new HashMap<>();

        public final void ak(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.nBA != canvas.getWidth() || this.nBB != canvas.getHeight()) {
                this.nBC.clear();
            }
            this.nBA = canvas.getWidth();
            this.nBB = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.nBC.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dMj());
                this.nBC.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nBC.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dQK();
            }
            return path2;
        }
    }
}
