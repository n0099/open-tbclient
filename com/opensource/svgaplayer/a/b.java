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
/* loaded from: classes17.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c pEN;
    private final C1035b pFN;
    private final HashMap<String, Bitmap> pFO;
    private final a pFP;
    private final float[] pFQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.pEN = cVar;
        this.pFN = new C1035b();
        this.pFO = new HashMap<>();
        this.pFP = new a();
        this.pFQ = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pFP.au(canvas);
        for (a.C1034a c1034a : RA(i)) {
            a(c1034a, canvas, i);
        }
        RB(i);
    }

    private final void RB(int i) {
        SoundPool ewW;
        Integer exi;
        for (com.opensource.svgaplayer.entities.a aVar : ewD().ewV()) {
            if (aVar.exg() == i && (ewW = ewD().ewW()) != null && (exi = aVar.exi()) != null) {
                aVar.u(Integer.valueOf(ewW.play(exi.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.exh() <= i) {
                Integer exj = aVar.exj();
                if (exj != null) {
                    int intValue = exj.intValue();
                    SoundPool ewW2 = ewD().ewW();
                    if (ewW2 != null) {
                        ewW2.stop(intValue);
                    }
                }
                aVar.u(null);
            }
        }
    }

    private final Matrix e(Matrix matrix) {
        Matrix exe = this.pFN.exe();
        exe.postScale(ewZ().exD(), ewZ().exE());
        exe.postTranslate(ewZ().exB(), ewZ().exC());
        exe.preConcat(matrix);
        return exe;
    }

    private final void a(a.C1034a c1034a, Canvas canvas, int i) {
        a(c1034a, canvas);
        b(c1034a, canvas);
        b(c1034a, canvas, i);
    }

    private final void a(a.C1034a c1034a, Canvas canvas) {
        String imageKey = c1034a.getImageKey();
        if (imageKey != null && !q.l(this.pEN.ewE().get(imageKey), true)) {
            Bitmap bitmap = this.pEN.ewF().get(imageKey);
            if (bitmap == null) {
                bitmap = ewD().ewX().get(imageKey);
            }
            if (bitmap != null) {
                Matrix e = e(c1034a.exa().exm());
                Paint exb = this.pFN.exb();
                exb.setAntiAlias(ewD().ewR());
                exb.setFilterBitmap(ewD().ewR());
                exb.setAlpha((int) (c1034a.exa().exy() * 255));
                if (c1034a.exa().exA() != null) {
                    com.opensource.svgaplayer.entities.b exA = c1034a.exa().exA();
                    if (exA != null) {
                        canvas.save();
                        exb.reset();
                        Path exc = this.pFN.exc();
                        exA.a(exc);
                        exc.transform(e);
                        canvas.clipPath(exc);
                        e.preScale((float) (c1034a.exa().exz().getWidth() / bitmap.getWidth()), (float) (c1034a.exa().exz().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, e, exb);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    e.preScale((float) (c1034a.exa().exz().getWidth() / bitmap.getWidth()), (float) (c1034a.exa().exz().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, e, exb);
                }
                a(canvas, bitmap, c1034a, e);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1034a c1034a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pEN.ewL()) {
            this.pFO.clear();
            this.pEN.AU(false);
        }
        String imageKey = c1034a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pEN.ewG().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pEN.ewH().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pFO.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.m(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pFO;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(imageKey, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.pEN.ewI().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pFO.get(imageKey);
                if (bitmap4 == null) {
                    q.m(staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    q.m(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.pFO;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint exb = this.pFN.exb();
                exb.setAntiAlias(ewD().ewR());
                if (c1034a.exa().exA() != null) {
                    com.opensource.svgaplayer.entities.b exA = c1034a.exa().exA();
                    if (exA != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        exb.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path exc = this.pFN.exc();
                        exA.a(exc);
                        canvas.drawPath(exc, exb);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                exb.setFilterBitmap(ewD().ewR());
                canvas.drawBitmap(bitmap2, matrix, exb);
            }
        }
    }

    private final void b(a.C1034a c1034a, Canvas canvas) {
        float[] exv;
        String ext;
        String exs;
        int exq;
        Matrix e = e(c1034a.exa().exm());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1034a.exa().jz()) {
            sVGAVideoShapeEntity.exp();
            if (sVGAVideoShapeEntity.exo() != null) {
                Paint exb = this.pFN.exb();
                exb.reset();
                exb.setAntiAlias(ewD().ewR());
                exb.setAlpha((int) (c1034a.exa().exy() * 255));
                Path exc = this.pFN.exc();
                exc.reset();
                exc.addPath(this.pFP.a(sVGAVideoShapeEntity));
                Matrix exf = this.pFN.exf();
                exf.reset();
                Matrix exm = sVGAVideoShapeEntity.exm();
                if (exm != null) {
                    exf.postConcat(exm);
                }
                exf.postConcat(e);
                exc.transform(exf);
                SVGAVideoShapeEntity.a exl = sVGAVideoShapeEntity.exl();
                if (exl != null && (exq = exl.exq()) != 0) {
                    exb.setStyle(Paint.Style.FILL);
                    exb.setColor(exq);
                    exb.setAlpha(Math.min(255, Math.max(0, (int) (c1034a.exa().exy() * 255))));
                    if (c1034a.exa().exA() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b exA = c1034a.exa().exA();
                    if (exA != null) {
                        Path exd = this.pFN.exd();
                        exA.a(exd);
                        exd.transform(e);
                        canvas.clipPath(exd);
                    }
                    canvas.drawPath(exc, exb);
                    if (c1034a.exa().exA() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a exl2 = sVGAVideoShapeEntity.exl();
                if (exl2 != null && exl2.getStrokeWidth() > 0) {
                    exb.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a exl3 = sVGAVideoShapeEntity.exl();
                    if (exl3 != null) {
                        exb.setColor(exl3.exr());
                        exb.setAlpha(Math.min(255, Math.max(0, (int) (c1034a.exa().exy() * 255))));
                    }
                    float f = f(e);
                    SVGAVideoShapeEntity.a exl4 = sVGAVideoShapeEntity.exl();
                    if (exl4 != null) {
                        exb.setStrokeWidth(exl4.getStrokeWidth() * f);
                    }
                    SVGAVideoShapeEntity.a exl5 = sVGAVideoShapeEntity.exl();
                    if (exl5 != null && (exs = exl5.exs()) != null) {
                        if (l.K(exs, "butt", true)) {
                            exb.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.K(exs, "round", true)) {
                            exb.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.K(exs, "square", true)) {
                            exb.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a exl6 = sVGAVideoShapeEntity.exl();
                    if (exl6 != null && (ext = exl6.ext()) != null) {
                        if (l.K(ext, "miter", true)) {
                            exb.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.K(ext, "round", true)) {
                            exb.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.K(ext, "bevel", true)) {
                            exb.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a exl7 = sVGAVideoShapeEntity.exl();
                    if (exl7 != null) {
                        exb.setStrokeMiter(exl7.exu() * f);
                    }
                    SVGAVideoShapeEntity.a exl8 = sVGAVideoShapeEntity.exl();
                    if (exl8 != null && (exv = exl8.exv()) != null && exv.length == 3 && (exv[0] > 0 || exv[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (exv[0] < 1.0f ? 1.0f : exv[0]) * f;
                        fArr[1] = (exv[1] < 0.1f ? 0.1f : exv[1]) * f;
                        exb.setPathEffect(new DashPathEffect(fArr, exv[2] * f));
                    }
                    if (c1034a.exa().exA() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b exA2 = c1034a.exa().exA();
                    if (exA2 != null) {
                        Path exd2 = this.pFN.exd();
                        exA2.a(exd2);
                        exd2.transform(e);
                        canvas.clipPath(exd2);
                    }
                    canvas.drawPath(exc, exb);
                    if (c1034a.exa().exA() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float f(Matrix matrix) {
        matrix.getValues(this.pFQ);
        if (this.pFQ[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pFQ[0];
        double d2 = this.pFQ[3];
        double d3 = this.pFQ[1];
        double d4 = this.pFQ[4];
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
        return ewZ().exF() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1034a c1034a, Canvas canvas, int i) {
        String imageKey = c1034a.getImageKey();
        if (imageKey != null) {
            m<Canvas, Integer, Boolean> mVar = this.pEN.ewJ().get(imageKey);
            if (mVar != null) {
                Matrix e = e(c1034a.exa().exm());
                canvas.save();
                canvas.concat(e);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.pEN.ewK().get(imageKey);
            if (rVar != null) {
                Matrix e2 = e(c1034a.exa().exm());
                canvas.save();
                canvas.concat(e2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1034a.exa().exz().getWidth()), Integer.valueOf((int) c1034a.exa().exz().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1035b {
        private final Paint pFS = new Paint();
        private final Path pFT = new Path();
        private final Path pFU = new Path();
        private final Matrix pFV = new Matrix();
        private final Matrix pFW = new Matrix();

        public final Paint exb() {
            this.pFS.reset();
            return this.pFS;
        }

        public final Path exc() {
            this.pFT.reset();
            return this.pFT;
        }

        public final Path exd() {
            this.pFU.reset();
            return this.pFU;
        }

        public final Matrix exe() {
            this.pFV.reset();
            return this.pFV;
        }

        public final Matrix exf() {
            this.pFW.reset();
            return this.pFW;
        }
    }

    @h
    /* loaded from: classes17.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> pFR = new HashMap<>();

        public final void au(Canvas canvas) {
            q.n(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.pFR.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.n(sVGAVideoShapeEntity, "shape");
            if (!this.pFR.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.exo());
                this.pFR.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pFR.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.eBQ();
            }
            return path2;
        }
    }
}
