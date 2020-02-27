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
    private final c nkB;
    private final C0734b nlC;
    private final HashMap<String, Bitmap> nlD;
    private final a nlE;
    private final float[] nlF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nkB = cVar;
        this.nlC = new C0734b();
        this.nlD = new HashMap<>();
        this.nlE = new a();
        this.nlF = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nlE.ah(canvas);
        for (a.C0733a c0733a : Ni(i)) {
            a(c0733a, canvas, i);
        }
        Nj(i);
    }

    private final void Nj(int i) {
        SoundPool dEW;
        Integer dFj;
        for (com.opensource.svgaplayer.entities.a aVar : dEE().dEV()) {
            if (aVar.dFh() == i && (dEW = dEE().dEW()) != null && (dFj = aVar.dFj()) != null) {
                aVar.s(Integer.valueOf(dEW.play(dFj.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dFi() <= i) {
                Integer dFk = aVar.dFk();
                if (dFk != null) {
                    int intValue = dFk.intValue();
                    SoundPool dEW2 = dEE().dEW();
                    if (dEW2 != null) {
                        dEW2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dFf = this.nlC.dFf();
        dFf.postScale(dEZ().dFE(), dEZ().dFF());
        dFf.postTranslate(dEZ().dFC(), dEZ().dFD());
        dFf.preConcat(matrix);
        return dFf;
    }

    private final void a(a.C0733a c0733a, Canvas canvas, int i) {
        a(c0733a, canvas);
        b(c0733a, canvas);
        b(c0733a, canvas, i);
    }

    private final void a(a.C0733a c0733a, Canvas canvas) {
        String dFa = c0733a.dFa();
        if (dFa != null && !q.h(this.nkB.dEF().get(dFa), true)) {
            Bitmap bitmap = this.nkB.dEG().get(dFa);
            if (bitmap == null) {
                bitmap = dEE().dEX().get(dFa);
            }
            if (bitmap != null) {
                Matrix c = c(c0733a.dFb().dFn());
                Paint dFc = this.nlC.dFc();
                dFc.setAntiAlias(dEE().dER());
                dFc.setFilterBitmap(dEE().dER());
                dFc.setAlpha((int) (c0733a.dFb().dFz() * 255));
                if (c0733a.dFb().dFB() != null) {
                    com.opensource.svgaplayer.entities.b dFB = c0733a.dFb().dFB();
                    if (dFB != null) {
                        canvas.save();
                        dFc.reset();
                        Path dFd = this.nlC.dFd();
                        dFB.c(dFd);
                        dFd.transform(c);
                        canvas.clipPath(dFd);
                        c.preScale((float) (c0733a.dFb().dFA().getWidth() / bitmap.getWidth()), (float) (c0733a.dFb().dFA().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dFc);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0733a.dFb().dFA().getWidth() / bitmap.getWidth()), (float) (c0733a.dFb().dFA().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dFc);
                }
                a(canvas, bitmap, c0733a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0733a c0733a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nkB.dEM()) {
            this.nlD.clear();
            this.nkB.wv(false);
        }
        String dFa = c0733a.dFa();
        if (dFa != null) {
            Bitmap bitmap3 = null;
            String str = this.nkB.dEH().get(dFa);
            if (str != null) {
                TextPaint textPaint = this.nkB.dEI().get(dFa);
                if (textPaint != null && (bitmap3 = this.nlD.get(dFa)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nlD;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dFa, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nkB.dEJ().get(dFa);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nlD.get(dFa);
                if (bitmap4 == null) {
                    q.i(staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    q.i(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.nlD;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dFa, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dFc = this.nlC.dFc();
                dFc.setAntiAlias(dEE().dER());
                if (c0733a.dFb().dFB() != null) {
                    com.opensource.svgaplayer.entities.b dFB = c0733a.dFb().dFB();
                    if (dFB != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dFc.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dFd = this.nlC.dFd();
                        dFB.c(dFd);
                        canvas.drawPath(dFd, dFc);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dFc.setFilterBitmap(dEE().dER());
                canvas.drawBitmap(bitmap2, matrix, dFc);
            }
        }
    }

    private final void b(a.C0733a c0733a, Canvas canvas) {
        float[] dFw;
        String dFu;
        String dFt;
        int dFr;
        Matrix c = c(c0733a.dFb().dFn());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0733a.dFb().cj()) {
            sVGAVideoShapeEntity.dFq();
            if (sVGAVideoShapeEntity.dFp() != null) {
                Paint dFc = this.nlC.dFc();
                dFc.reset();
                dFc.setAntiAlias(dEE().dER());
                dFc.setAlpha((int) (c0733a.dFb().dFz() * 255));
                Path dFd = this.nlC.dFd();
                dFd.reset();
                dFd.addPath(this.nlE.a(sVGAVideoShapeEntity));
                Matrix dFg = this.nlC.dFg();
                dFg.reset();
                Matrix dFn = sVGAVideoShapeEntity.dFn();
                if (dFn != null) {
                    dFg.postConcat(dFn);
                }
                dFg.postConcat(c);
                dFd.transform(dFg);
                SVGAVideoShapeEntity.a dFm = sVGAVideoShapeEntity.dFm();
                if (dFm != null && (dFr = dFm.dFr()) != 0) {
                    dFc.setStyle(Paint.Style.FILL);
                    dFc.setColor(dFr);
                    dFc.setAlpha(Math.min(255, Math.max(0, (int) (c0733a.dFb().dFz() * 255))));
                    if (c0733a.dFb().dFB() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dFB = c0733a.dFb().dFB();
                    if (dFB != null) {
                        Path dFe = this.nlC.dFe();
                        dFB.c(dFe);
                        dFe.transform(c);
                        canvas.clipPath(dFe);
                    }
                    canvas.drawPath(dFd, dFc);
                    if (c0733a.dFb().dFB() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dFm2 = sVGAVideoShapeEntity.dFm();
                if (dFm2 != null && dFm2.getStrokeWidth() > 0) {
                    dFc.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dFm3 = sVGAVideoShapeEntity.dFm();
                    if (dFm3 != null) {
                        dFc.setColor(dFm3.dFs());
                        dFc.setAlpha(Math.min(255, Math.max(0, (int) (c0733a.dFb().dFz() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dFm4 = sVGAVideoShapeEntity.dFm();
                    if (dFm4 != null) {
                        dFc.setStrokeWidth(dFm4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dFm5 = sVGAVideoShapeEntity.dFm();
                    if (dFm5 != null && (dFt = dFm5.dFt()) != null) {
                        if (l.F(dFt, "butt", true)) {
                            dFc.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dFt, "round", true)) {
                            dFc.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dFt, "square", true)) {
                            dFc.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dFm6 = sVGAVideoShapeEntity.dFm();
                    if (dFm6 != null && (dFu = dFm6.dFu()) != null) {
                        if (l.F(dFu, "miter", true)) {
                            dFc.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dFu, "round", true)) {
                            dFc.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dFu, "bevel", true)) {
                            dFc.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dFm7 = sVGAVideoShapeEntity.dFm();
                    if (dFm7 != null) {
                        dFc.setStrokeMiter(dFm7.dFv() * d);
                    }
                    SVGAVideoShapeEntity.a dFm8 = sVGAVideoShapeEntity.dFm();
                    if (dFm8 != null && (dFw = dFm8.dFw()) != null && dFw.length == 3 && (dFw[0] > 0 || dFw[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dFw[0] < 1.0f ? 1.0f : dFw[0]) * d;
                        fArr[1] = (dFw[1] < 0.1f ? 0.1f : dFw[1]) * d;
                        dFc.setPathEffect(new DashPathEffect(fArr, dFw[2] * d));
                    }
                    if (c0733a.dFb().dFB() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dFB2 = c0733a.dFb().dFB();
                    if (dFB2 != null) {
                        Path dFe2 = this.nlC.dFe();
                        dFB2.c(dFe2);
                        dFe2.transform(c);
                        canvas.clipPath(dFe2);
                    }
                    canvas.drawPath(dFd, dFc);
                    if (c0733a.dFb().dFB() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nlF);
        if (this.nlF[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nlF[0];
        double d2 = this.nlF[3];
        double d3 = this.nlF[1];
        double d4 = this.nlF[4];
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
        return dEZ().dFG() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0733a c0733a, Canvas canvas, int i) {
        String dFa = c0733a.dFa();
        if (dFa != null) {
            m<Canvas, Integer, Boolean> mVar = this.nkB.dEK().get(dFa);
            if (mVar != null) {
                Matrix c = c(c0733a.dFb().dFn());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nkB.dEL().get(dFa);
            if (rVar != null) {
                Matrix c2 = c(c0733a.dFb().dFn());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0733a.dFb().dFA().getWidth()), Integer.valueOf((int) c0733a.dFb().dFA().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0734b {
        private final Paint nlJ = new Paint();
        private final Path nlK = new Path();
        private final Path nlL = new Path();
        private final Matrix nlM = new Matrix();
        private final Matrix nlN = new Matrix();

        public final Paint dFc() {
            this.nlJ.reset();
            return this.nlJ;
        }

        public final Path dFd() {
            this.nlK.reset();
            return this.nlK;
        }

        public final Path dFe() {
            this.nlL.reset();
            return this.nlL;
        }

        public final Matrix dFf() {
            this.nlM.reset();
            return this.nlM;
        }

        public final Matrix dFg() {
            this.nlN.reset();
            return this.nlN;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nlG;
        private int nlH;
        private final HashMap<SVGAVideoShapeEntity, Path> nlI = new HashMap<>();

        public final void ah(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.nlG != canvas.getWidth() || this.nlH != canvas.getHeight()) {
                this.nlI.clear();
            }
            this.nlG = canvas.getWidth();
            this.nlH = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.nlI.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dFp());
                this.nlI.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nlI.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dKt();
            }
            return path2;
        }
    }
}
