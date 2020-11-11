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
/* loaded from: classes15.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c pDk;
    private final C1032b pEk;
    private final HashMap<String, Bitmap> pEl;
    private final a pEm;
    private final float[] pEn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.pDk = cVar;
        this.pEk = new C1032b();
        this.pEl = new HashMap<>();
        this.pEm = new a();
        this.pEn = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pEm.at(canvas);
        for (a.C1031a c1031a : QX(i)) {
            a(c1031a, canvas, i);
        }
        QY(i);
    }

    private final void QY(int i) {
        SoundPool ewV;
        Integer exh;
        for (com.opensource.svgaplayer.entities.a aVar : ewC().ewU()) {
            if (aVar.exf() == i && (ewV = ewC().ewV()) != null && (exh = aVar.exh()) != null) {
                aVar.u(Integer.valueOf(ewV.play(exh.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.exg() <= i) {
                Integer exi = aVar.exi();
                if (exi != null) {
                    int intValue = exi.intValue();
                    SoundPool ewV2 = ewC().ewV();
                    if (ewV2 != null) {
                        ewV2.stop(intValue);
                    }
                }
                aVar.u(null);
            }
        }
    }

    private final Matrix e(Matrix matrix) {
        Matrix exd = this.pEk.exd();
        exd.postScale(ewY().exC(), ewY().exD());
        exd.postTranslate(ewY().exA(), ewY().exB());
        exd.preConcat(matrix);
        return exd;
    }

    private final void a(a.C1031a c1031a, Canvas canvas, int i) {
        a(c1031a, canvas);
        b(c1031a, canvas);
        b(c1031a, canvas, i);
    }

    private final void a(a.C1031a c1031a, Canvas canvas) {
        String imageKey = c1031a.getImageKey();
        if (imageKey != null && !q.l(this.pDk.ewD().get(imageKey), true)) {
            Bitmap bitmap = this.pDk.ewE().get(imageKey);
            if (bitmap == null) {
                bitmap = ewC().ewW().get(imageKey);
            }
            if (bitmap != null) {
                Matrix e = e(c1031a.ewZ().exl());
                Paint exa = this.pEk.exa();
                exa.setAntiAlias(ewC().ewQ());
                exa.setFilterBitmap(ewC().ewQ());
                exa.setAlpha((int) (c1031a.ewZ().exx() * 255));
                if (c1031a.ewZ().exz() != null) {
                    com.opensource.svgaplayer.entities.b exz = c1031a.ewZ().exz();
                    if (exz != null) {
                        canvas.save();
                        exa.reset();
                        Path exb = this.pEk.exb();
                        exz.a(exb);
                        exb.transform(e);
                        canvas.clipPath(exb);
                        e.preScale((float) (c1031a.ewZ().exy().getWidth() / bitmap.getWidth()), (float) (c1031a.ewZ().exy().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, e, exa);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    e.preScale((float) (c1031a.ewZ().exy().getWidth() / bitmap.getWidth()), (float) (c1031a.ewZ().exy().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, e, exa);
                }
                a(canvas, bitmap, c1031a, e);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1031a c1031a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pDk.ewK()) {
            this.pEl.clear();
            this.pDk.AN(false);
        }
        String imageKey = c1031a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pDk.ewF().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pDk.ewG().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pEl.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.m(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pEl;
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
            StaticLayout staticLayout = this.pDk.ewH().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pEl.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.pEl;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint exa = this.pEk.exa();
                exa.setAntiAlias(ewC().ewQ());
                if (c1031a.ewZ().exz() != null) {
                    com.opensource.svgaplayer.entities.b exz = c1031a.ewZ().exz();
                    if (exz != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        exa.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path exb = this.pEk.exb();
                        exz.a(exb);
                        canvas.drawPath(exb, exa);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                exa.setFilterBitmap(ewC().ewQ());
                canvas.drawBitmap(bitmap2, matrix, exa);
            }
        }
    }

    private final void b(a.C1031a c1031a, Canvas canvas) {
        float[] exu;
        String exs;
        String exr;
        int exp;
        Matrix e = e(c1031a.ewZ().exl());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1031a.ewZ().jz()) {
            sVGAVideoShapeEntity.exo();
            if (sVGAVideoShapeEntity.exn() != null) {
                Paint exa = this.pEk.exa();
                exa.reset();
                exa.setAntiAlias(ewC().ewQ());
                exa.setAlpha((int) (c1031a.ewZ().exx() * 255));
                Path exb = this.pEk.exb();
                exb.reset();
                exb.addPath(this.pEm.a(sVGAVideoShapeEntity));
                Matrix exe = this.pEk.exe();
                exe.reset();
                Matrix exl = sVGAVideoShapeEntity.exl();
                if (exl != null) {
                    exe.postConcat(exl);
                }
                exe.postConcat(e);
                exb.transform(exe);
                SVGAVideoShapeEntity.a exk = sVGAVideoShapeEntity.exk();
                if (exk != null && (exp = exk.exp()) != 0) {
                    exa.setStyle(Paint.Style.FILL);
                    exa.setColor(exp);
                    exa.setAlpha(Math.min(255, Math.max(0, (int) (c1031a.ewZ().exx() * 255))));
                    if (c1031a.ewZ().exz() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b exz = c1031a.ewZ().exz();
                    if (exz != null) {
                        Path exc = this.pEk.exc();
                        exz.a(exc);
                        exc.transform(e);
                        canvas.clipPath(exc);
                    }
                    canvas.drawPath(exb, exa);
                    if (c1031a.ewZ().exz() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a exk2 = sVGAVideoShapeEntity.exk();
                if (exk2 != null && exk2.getStrokeWidth() > 0) {
                    exa.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a exk3 = sVGAVideoShapeEntity.exk();
                    if (exk3 != null) {
                        exa.setColor(exk3.exq());
                        exa.setAlpha(Math.min(255, Math.max(0, (int) (c1031a.ewZ().exx() * 255))));
                    }
                    float f = f(e);
                    SVGAVideoShapeEntity.a exk4 = sVGAVideoShapeEntity.exk();
                    if (exk4 != null) {
                        exa.setStrokeWidth(exk4.getStrokeWidth() * f);
                    }
                    SVGAVideoShapeEntity.a exk5 = sVGAVideoShapeEntity.exk();
                    if (exk5 != null && (exr = exk5.exr()) != null) {
                        if (l.J(exr, "butt", true)) {
                            exa.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.J(exr, "round", true)) {
                            exa.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.J(exr, "square", true)) {
                            exa.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a exk6 = sVGAVideoShapeEntity.exk();
                    if (exk6 != null && (exs = exk6.exs()) != null) {
                        if (l.J(exs, "miter", true)) {
                            exa.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.J(exs, "round", true)) {
                            exa.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.J(exs, "bevel", true)) {
                            exa.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a exk7 = sVGAVideoShapeEntity.exk();
                    if (exk7 != null) {
                        exa.setStrokeMiter(exk7.ext() * f);
                    }
                    SVGAVideoShapeEntity.a exk8 = sVGAVideoShapeEntity.exk();
                    if (exk8 != null && (exu = exk8.exu()) != null && exu.length == 3 && (exu[0] > 0 || exu[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (exu[0] < 1.0f ? 1.0f : exu[0]) * f;
                        fArr[1] = (exu[1] < 0.1f ? 0.1f : exu[1]) * f;
                        exa.setPathEffect(new DashPathEffect(fArr, exu[2] * f));
                    }
                    if (c1031a.ewZ().exz() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b exz2 = c1031a.ewZ().exz();
                    if (exz2 != null) {
                        Path exc2 = this.pEk.exc();
                        exz2.a(exc2);
                        exc2.transform(e);
                        canvas.clipPath(exc2);
                    }
                    canvas.drawPath(exb, exa);
                    if (c1031a.ewZ().exz() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float f(Matrix matrix) {
        matrix.getValues(this.pEn);
        if (this.pEn[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pEn[0];
        double d2 = this.pEn[3];
        double d3 = this.pEn[1];
        double d4 = this.pEn[4];
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
        return ewY().exE() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1031a c1031a, Canvas canvas, int i) {
        String imageKey = c1031a.getImageKey();
        if (imageKey != null) {
            m<Canvas, Integer, Boolean> mVar = this.pDk.ewI().get(imageKey);
            if (mVar != null) {
                Matrix e = e(c1031a.ewZ().exl());
                canvas.save();
                canvas.concat(e);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.pDk.ewJ().get(imageKey);
            if (rVar != null) {
                Matrix e2 = e(c1031a.ewZ().exl());
                canvas.save();
                canvas.concat(e2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1031a.ewZ().exy().getWidth()), Integer.valueOf((int) c1031a.ewZ().exy().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1032b {
        private final Paint pEp = new Paint();
        private final Path pEq = new Path();
        private final Path pEr = new Path();
        private final Matrix pEs = new Matrix();
        private final Matrix pEt = new Matrix();

        public final Paint exa() {
            this.pEp.reset();
            return this.pEp;
        }

        public final Path exb() {
            this.pEq.reset();
            return this.pEq;
        }

        public final Path exc() {
            this.pEr.reset();
            return this.pEr;
        }

        public final Matrix exd() {
            this.pEs.reset();
            return this.pEs;
        }

        public final Matrix exe() {
            this.pEt.reset();
            return this.pEt;
        }
    }

    @h
    /* loaded from: classes15.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> pEo = new HashMap<>();

        public final void at(Canvas canvas) {
            q.n(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.pEo.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.n(sVGAVideoShapeEntity, "shape");
            if (!this.pEo.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.exn());
                this.pEo.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pEo.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.eBP();
            }
            return path2;
        }
    }
}
