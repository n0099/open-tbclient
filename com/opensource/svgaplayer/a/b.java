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
    private final c mJo;
    private final C0780b mKp;
    private final HashMap<String, Bitmap> mKq;
    private final a mKr;
    private final float[] mKs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.mJo = cVar;
        this.mKp = new C0780b();
        this.mKq = new HashMap<>();
        this.mKr = new a();
        this.mKs = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.mKr.ad(canvas);
        for (a.C0779a c0779a : II(i)) {
            a(c0779a, canvas, i);
        }
        IJ(i);
    }

    private final void IJ(int i) {
        SoundPool dzy;
        Integer dzL;
        for (com.opensource.svgaplayer.entities.a aVar : dzf().dzx()) {
            if (aVar.dzJ() == i && (dzy = dzf().dzy()) != null && (dzL = aVar.dzL()) != null) {
                aVar.r(Integer.valueOf(dzy.play(dzL.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dzK() <= i) {
                Integer dzM = aVar.dzM();
                if (dzM != null) {
                    int intValue = dzM.intValue();
                    SoundPool dzy2 = dzf().dzy();
                    if (dzy2 != null) {
                        dzy2.stop(intValue);
                    }
                }
                aVar.r(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dzH = this.mKp.dzH();
        dzH.postScale(dzB().dAg(), dzB().dAh());
        dzH.postTranslate(dzB().dAe(), dzB().dAf());
        dzH.preConcat(matrix);
        return dzH;
    }

    private final void a(a.C0779a c0779a, Canvas canvas, int i) {
        a(c0779a, canvas);
        b(c0779a, canvas);
        b(c0779a, canvas, i);
    }

    private final void a(a.C0779a c0779a, Canvas canvas) {
        String dzC = c0779a.dzC();
        if (dzC != null && !q.k(this.mJo.dzg().get(dzC), true)) {
            Bitmap bitmap = this.mJo.dzh().get(dzC);
            if (bitmap == null) {
                bitmap = dzf().dzz().get(dzC);
            }
            if (bitmap != null) {
                Matrix c = c(c0779a.dzD().dzP());
                Paint dzE = this.mKp.dzE();
                dzE.setAntiAlias(dzf().dzt());
                dzE.setFilterBitmap(dzf().dzt());
                dzE.setAlpha((int) (c0779a.dzD().dAb() * 255));
                if (c0779a.dzD().dAd() != null) {
                    com.opensource.svgaplayer.entities.b dAd = c0779a.dzD().dAd();
                    if (dAd != null) {
                        canvas.save();
                        dzE.reset();
                        Path dzF = this.mKp.dzF();
                        dAd.a(dzF);
                        dzF.transform(c);
                        canvas.clipPath(dzF);
                        c.preScale((float) (c0779a.dzD().dAc().getWidth() / bitmap.getWidth()), (float) (c0779a.dzD().dAc().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dzE);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0779a.dzD().dAc().getWidth() / bitmap.getWidth()), (float) (c0779a.dzD().dAc().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dzE);
                }
                a(canvas, bitmap, c0779a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0779a c0779a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.mJo.dzn()) {
            this.mKq.clear();
            this.mJo.wl(false);
        }
        String dzC = c0779a.dzC();
        if (dzC != null) {
            Bitmap bitmap3 = null;
            String str = this.mJo.dzi().get(dzC);
            if (str != null) {
                TextPaint textPaint = this.mJo.dzj().get(dzC);
                if (textPaint != null && (bitmap3 = this.mKq.get(dzC)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.mKq;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dzC, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.mJo.dzk().get(dzC);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.mKq.get(dzC);
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
                    HashMap<String, Bitmap> hashMap2 = this.mKq;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dzC, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dzE = this.mKp.dzE();
                dzE.setAntiAlias(dzf().dzt());
                if (c0779a.dzD().dAd() != null) {
                    com.opensource.svgaplayer.entities.b dAd = c0779a.dzD().dAd();
                    if (dAd != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dzE.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dzF = this.mKp.dzF();
                        dAd.a(dzF);
                        canvas.drawPath(dzF, dzE);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dzE.setFilterBitmap(dzf().dzt());
                canvas.drawBitmap(bitmap2, matrix, dzE);
            }
        }
    }

    private final void b(a.C0779a c0779a, Canvas canvas) {
        float[] dzY;
        String dzW;
        String dzV;
        int dzT;
        Matrix c = c(c0779a.dzD().dzP());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0779a.dzD().hG()) {
            sVGAVideoShapeEntity.dzS();
            if (sVGAVideoShapeEntity.dzR() != null) {
                Paint dzE = this.mKp.dzE();
                dzE.reset();
                dzE.setAntiAlias(dzf().dzt());
                dzE.setAlpha((int) (c0779a.dzD().dAb() * 255));
                Path dzF = this.mKp.dzF();
                dzF.reset();
                dzF.addPath(this.mKr.a(sVGAVideoShapeEntity));
                Matrix dzI = this.mKp.dzI();
                dzI.reset();
                Matrix dzP = sVGAVideoShapeEntity.dzP();
                if (dzP != null) {
                    dzI.postConcat(dzP);
                }
                dzI.postConcat(c);
                dzF.transform(dzI);
                SVGAVideoShapeEntity.a dzO = sVGAVideoShapeEntity.dzO();
                if (dzO != null && (dzT = dzO.dzT()) != 0) {
                    dzE.setStyle(Paint.Style.FILL);
                    dzE.setColor(dzT);
                    dzE.setAlpha(Math.min(255, Math.max(0, (int) (c0779a.dzD().dAb() * 255))));
                    if (c0779a.dzD().dAd() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAd = c0779a.dzD().dAd();
                    if (dAd != null) {
                        Path dzG = this.mKp.dzG();
                        dAd.a(dzG);
                        dzG.transform(c);
                        canvas.clipPath(dzG);
                    }
                    canvas.drawPath(dzF, dzE);
                    if (c0779a.dzD().dAd() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dzO2 = sVGAVideoShapeEntity.dzO();
                if (dzO2 != null && dzO2.getStrokeWidth() > 0) {
                    dzE.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dzO3 = sVGAVideoShapeEntity.dzO();
                    if (dzO3 != null) {
                        dzE.setColor(dzO3.dzU());
                        dzE.setAlpha(Math.min(255, Math.max(0, (int) (c0779a.dzD().dAb() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dzO4 = sVGAVideoShapeEntity.dzO();
                    if (dzO4 != null) {
                        dzE.setStrokeWidth(dzO4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dzO5 = sVGAVideoShapeEntity.dzO();
                    if (dzO5 != null && (dzV = dzO5.dzV()) != null) {
                        if (l.F(dzV, "butt", true)) {
                            dzE.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dzV, "round", true)) {
                            dzE.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dzV, "square", true)) {
                            dzE.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dzO6 = sVGAVideoShapeEntity.dzO();
                    if (dzO6 != null && (dzW = dzO6.dzW()) != null) {
                        if (l.F(dzW, "miter", true)) {
                            dzE.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dzW, "round", true)) {
                            dzE.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dzW, "bevel", true)) {
                            dzE.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dzO7 = sVGAVideoShapeEntity.dzO();
                    if (dzO7 != null) {
                        dzE.setStrokeMiter(dzO7.dzX() * d);
                    }
                    SVGAVideoShapeEntity.a dzO8 = sVGAVideoShapeEntity.dzO();
                    if (dzO8 != null && (dzY = dzO8.dzY()) != null && dzY.length == 3 && (dzY[0] > 0 || dzY[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dzY[0] < 1.0f ? 1.0f : dzY[0]) * d;
                        fArr[1] = (dzY[1] < 0.1f ? 0.1f : dzY[1]) * d;
                        dzE.setPathEffect(new DashPathEffect(fArr, dzY[2] * d));
                    }
                    if (c0779a.dzD().dAd() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAd2 = c0779a.dzD().dAd();
                    if (dAd2 != null) {
                        Path dzG2 = this.mKp.dzG();
                        dAd2.a(dzG2);
                        dzG2.transform(c);
                        canvas.clipPath(dzG2);
                    }
                    canvas.drawPath(dzF, dzE);
                    if (c0779a.dzD().dAd() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.mKs);
        if (this.mKs[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.mKs[0];
        double d2 = this.mKs[3];
        double d3 = this.mKs[1];
        double d4 = this.mKs[4];
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
        return dzB().dAi() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0779a c0779a, Canvas canvas, int i) {
        String dzC = c0779a.dzC();
        if (dzC != null) {
            m<Canvas, Integer, Boolean> mVar = this.mJo.dzl().get(dzC);
            if (mVar != null) {
                Matrix c = c(c0779a.dzD().dzP());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.mJo.dzm().get(dzC);
            if (rVar != null) {
                Matrix c2 = c(c0779a.dzD().dzP());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0779a.dzD().dAc().getWidth()), Integer.valueOf((int) c0779a.dzD().dAc().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0780b {
        private final Paint mKw = new Paint();
        private final Path mKx = new Path();
        private final Path mKy = new Path();
        private final Matrix mKz = new Matrix();
        private final Matrix mKA = new Matrix();

        public final Paint dzE() {
            this.mKw.reset();
            return this.mKw;
        }

        public final Path dzF() {
            this.mKx.reset();
            return this.mKx;
        }

        public final Path dzG() {
            this.mKy.reset();
            return this.mKy;
        }

        public final Matrix dzH() {
            this.mKz.reset();
            return this.mKz;
        }

        public final Matrix dzI() {
            this.mKA.reset();
            return this.mKA;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int mKt;
        private int mKu;
        private final HashMap<SVGAVideoShapeEntity, Path> mKv = new HashMap<>();

        public final void ad(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.mKt != canvas.getWidth() || this.mKu != canvas.getHeight()) {
                this.mKv.clear();
            }
            this.mKt = canvas.getWidth();
            this.mKu = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.mKv.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dzR());
                this.mKv.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.mKv.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dDR();
            }
            return path2;
        }
    }
}
