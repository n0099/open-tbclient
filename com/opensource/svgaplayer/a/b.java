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
/* loaded from: classes8.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c nJf;
    private final C0868b nKg;
    private final HashMap<String, Bitmap> nKh;
    private final a nKi;
    private final float[] nKj;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nJf = cVar;
        this.nKg = new C0868b();
        this.nKh = new HashMap<>();
        this.nKi = new a();
        this.nKj = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nKi.ak(canvas);
        for (a.C0867a c0867a : KW(i)) {
            a(c0867a, canvas, i);
        }
        KX(i);
    }

    private final void KX(int i) {
        SoundPool dPm;
        Integer dPz;
        for (com.opensource.svgaplayer.entities.a aVar : dOT().dPl()) {
            if (aVar.dPx() == i && (dPm = dOT().dPm()) != null && (dPz = aVar.dPz()) != null) {
                aVar.r(Integer.valueOf(dPm.play(dPz.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dPy() <= i) {
                Integer dPA = aVar.dPA();
                if (dPA != null) {
                    int intValue = dPA.intValue();
                    SoundPool dPm2 = dOT().dPm();
                    if (dPm2 != null) {
                        dPm2.stop(intValue);
                    }
                }
                aVar.r(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dPv = this.nKg.dPv();
        dPv.postScale(dPp().dPU(), dPp().dPV());
        dPv.postTranslate(dPp().dPS(), dPp().dPT());
        dPv.preConcat(matrix);
        return dPv;
    }

    private final void a(a.C0867a c0867a, Canvas canvas, int i) {
        a(c0867a, canvas);
        b(c0867a, canvas);
        b(c0867a, canvas, i);
    }

    private final void a(a.C0867a c0867a, Canvas canvas) {
        String dPq = c0867a.dPq();
        if (dPq != null && !q.l((Object) this.nJf.dOU().get(dPq), (Object) true)) {
            Bitmap bitmap = this.nJf.dOV().get(dPq);
            if (bitmap == null) {
                bitmap = dOT().dPn().get(dPq);
            }
            if (bitmap != null) {
                Matrix c = c(c0867a.dPr().dPD());
                Paint dPs = this.nKg.dPs();
                dPs.setAntiAlias(dOT().dPh());
                dPs.setFilterBitmap(dOT().dPh());
                dPs.setAlpha((int) (c0867a.dPr().dPP() * 255));
                if (c0867a.dPr().dPR() != null) {
                    com.opensource.svgaplayer.entities.b dPR = c0867a.dPr().dPR();
                    if (dPR != null) {
                        canvas.save();
                        dPs.reset();
                        Path dPt = this.nKg.dPt();
                        dPR.a(dPt);
                        dPt.transform(c);
                        canvas.clipPath(dPt);
                        c.preScale((float) (c0867a.dPr().dPQ().getWidth() / bitmap.getWidth()), (float) (c0867a.dPr().dPQ().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dPs);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0867a.dPr().dPQ().getWidth() / bitmap.getWidth()), (float) (c0867a.dPr().dPQ().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dPs);
                }
                a(canvas, bitmap, c0867a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0867a c0867a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nJf.dPb()) {
            this.nKh.clear();
            this.nJf.xL(false);
        }
        String dPq = c0867a.dPq();
        if (dPq != null) {
            Bitmap bitmap3 = null;
            String str = this.nJf.dOW().get(dPq);
            if (str != null) {
                TextPaint textPaint = this.nJf.dOX().get(dPq);
                if (textPaint != null && (bitmap3 = this.nKh.get(dPq)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nKh;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dPq, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nJf.dOY().get(dPq);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nKh.get(dPq);
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
                    HashMap<String, Bitmap> hashMap2 = this.nKh;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dPq, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dPs = this.nKg.dPs();
                dPs.setAntiAlias(dOT().dPh());
                if (c0867a.dPr().dPR() != null) {
                    com.opensource.svgaplayer.entities.b dPR = c0867a.dPr().dPR();
                    if (dPR != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dPs.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dPt = this.nKg.dPt();
                        dPR.a(dPt);
                        canvas.drawPath(dPt, dPs);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dPs.setFilterBitmap(dOT().dPh());
                canvas.drawBitmap(bitmap2, matrix, dPs);
            }
        }
    }

    private final void b(a.C0867a c0867a, Canvas canvas) {
        float[] dPM;
        String dPK;
        String dPJ;
        int dPH;
        Matrix c = c(c0867a.dPr().dPD());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0867a.dPr().hW()) {
            sVGAVideoShapeEntity.dPG();
            if (sVGAVideoShapeEntity.dPF() != null) {
                Paint dPs = this.nKg.dPs();
                dPs.reset();
                dPs.setAntiAlias(dOT().dPh());
                dPs.setAlpha((int) (c0867a.dPr().dPP() * 255));
                Path dPt = this.nKg.dPt();
                dPt.reset();
                dPt.addPath(this.nKi.a(sVGAVideoShapeEntity));
                Matrix dPw = this.nKg.dPw();
                dPw.reset();
                Matrix dPD = sVGAVideoShapeEntity.dPD();
                if (dPD != null) {
                    dPw.postConcat(dPD);
                }
                dPw.postConcat(c);
                dPt.transform(dPw);
                SVGAVideoShapeEntity.a dPC = sVGAVideoShapeEntity.dPC();
                if (dPC != null && (dPH = dPC.dPH()) != 0) {
                    dPs.setStyle(Paint.Style.FILL);
                    dPs.setColor(dPH);
                    dPs.setAlpha(Math.min(255, Math.max(0, (int) (c0867a.dPr().dPP() * 255))));
                    if (c0867a.dPr().dPR() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dPR = c0867a.dPr().dPR();
                    if (dPR != null) {
                        Path dPu = this.nKg.dPu();
                        dPR.a(dPu);
                        dPu.transform(c);
                        canvas.clipPath(dPu);
                    }
                    canvas.drawPath(dPt, dPs);
                    if (c0867a.dPr().dPR() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dPC2 = sVGAVideoShapeEntity.dPC();
                if (dPC2 != null && dPC2.getStrokeWidth() > 0) {
                    dPs.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dPC3 = sVGAVideoShapeEntity.dPC();
                    if (dPC3 != null) {
                        dPs.setColor(dPC3.dPI());
                        dPs.setAlpha(Math.min(255, Math.max(0, (int) (c0867a.dPr().dPP() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dPC4 = sVGAVideoShapeEntity.dPC();
                    if (dPC4 != null) {
                        dPs.setStrokeWidth(dPC4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dPC5 = sVGAVideoShapeEntity.dPC();
                    if (dPC5 != null && (dPJ = dPC5.dPJ()) != null) {
                        if (l.I(dPJ, "butt", true)) {
                            dPs.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.I(dPJ, "round", true)) {
                            dPs.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.I(dPJ, "square", true)) {
                            dPs.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dPC6 = sVGAVideoShapeEntity.dPC();
                    if (dPC6 != null && (dPK = dPC6.dPK()) != null) {
                        if (l.I(dPK, "miter", true)) {
                            dPs.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.I(dPK, "round", true)) {
                            dPs.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.I(dPK, "bevel", true)) {
                            dPs.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dPC7 = sVGAVideoShapeEntity.dPC();
                    if (dPC7 != null) {
                        dPs.setStrokeMiter(dPC7.dPL() * d);
                    }
                    SVGAVideoShapeEntity.a dPC8 = sVGAVideoShapeEntity.dPC();
                    if (dPC8 != null && (dPM = dPC8.dPM()) != null && dPM.length == 3 && (dPM[0] > 0 || dPM[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dPM[0] < 1.0f ? 1.0f : dPM[0]) * d;
                        fArr[1] = (dPM[1] < 0.1f ? 0.1f : dPM[1]) * d;
                        dPs.setPathEffect(new DashPathEffect(fArr, dPM[2] * d));
                    }
                    if (c0867a.dPr().dPR() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dPR2 = c0867a.dPr().dPR();
                    if (dPR2 != null) {
                        Path dPu2 = this.nKg.dPu();
                        dPR2.a(dPu2);
                        dPu2.transform(c);
                        canvas.clipPath(dPu2);
                    }
                    canvas.drawPath(dPt, dPs);
                    if (c0867a.dPr().dPR() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nKj);
        if (this.nKj[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nKj[0];
        double d2 = this.nKj[3];
        double d3 = this.nKj[1];
        double d4 = this.nKj[4];
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
        return dPp().dPW() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0867a c0867a, Canvas canvas, int i) {
        String dPq = c0867a.dPq();
        if (dPq != null) {
            m<Canvas, Integer, Boolean> mVar = this.nJf.dOZ().get(dPq);
            if (mVar != null) {
                Matrix c = c(c0867a.dPr().dPD());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nJf.dPa().get(dPq);
            if (rVar != null) {
                Matrix c2 = c(c0867a.dPr().dPD());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0867a.dPr().dPQ().getWidth()), Integer.valueOf((int) c0867a.dPr().dPQ().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0868b {
        private final Paint nKn = new Paint();
        private final Path nKo = new Path();
        private final Path nKp = new Path();
        private final Matrix nKq = new Matrix();
        private final Matrix nKr = new Matrix();

        public final Paint dPs() {
            this.nKn.reset();
            return this.nKn;
        }

        public final Path dPt() {
            this.nKo.reset();
            return this.nKo;
        }

        public final Path dPu() {
            this.nKp.reset();
            return this.nKp;
        }

        public final Matrix dPv() {
            this.nKq.reset();
            return this.nKq;
        }

        public final Matrix dPw() {
            this.nKr.reset();
            return this.nKr;
        }
    }

    @h
    /* loaded from: classes8.dex */
    public static final class a {
        private int nKk;
        private int nKl;
        private final HashMap<SVGAVideoShapeEntity, Path> nKm = new HashMap<>();

        public final void ak(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.nKk != canvas.getWidth() || this.nKl != canvas.getHeight()) {
                this.nKm.clear();
            }
            this.nKk = canvas.getWidth();
            this.nKl = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.nKm.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dPF());
                this.nKm.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nKm.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dUh();
            }
            return path2;
        }
    }
}
