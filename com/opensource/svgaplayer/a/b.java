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
        SoundPool dzz;
        Integer dzM;
        for (com.opensource.svgaplayer.entities.a aVar : dzg().dzy()) {
            if (aVar.dzK() == i && (dzz = dzg().dzz()) != null && (dzM = aVar.dzM()) != null) {
                aVar.r(Integer.valueOf(dzz.play(dzM.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dzL() <= i) {
                Integer dzN = aVar.dzN();
                if (dzN != null) {
                    int intValue = dzN.intValue();
                    SoundPool dzz2 = dzg().dzz();
                    if (dzz2 != null) {
                        dzz2.stop(intValue);
                    }
                }
                aVar.r(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dzI = this.mKp.dzI();
        dzI.postScale(dzC().dAh(), dzC().dAi());
        dzI.postTranslate(dzC().dAf(), dzC().dAg());
        dzI.preConcat(matrix);
        return dzI;
    }

    private final void a(a.C0779a c0779a, Canvas canvas, int i) {
        a(c0779a, canvas);
        b(c0779a, canvas);
        b(c0779a, canvas, i);
    }

    private final void a(a.C0779a c0779a, Canvas canvas) {
        String dzD = c0779a.dzD();
        if (dzD != null && !q.k(this.mJo.dzh().get(dzD), true)) {
            Bitmap bitmap = this.mJo.dzi().get(dzD);
            if (bitmap == null) {
                bitmap = dzg().dzA().get(dzD);
            }
            if (bitmap != null) {
                Matrix c = c(c0779a.dzE().dzQ());
                Paint dzF = this.mKp.dzF();
                dzF.setAntiAlias(dzg().dzu());
                dzF.setFilterBitmap(dzg().dzu());
                dzF.setAlpha((int) (c0779a.dzE().dAc() * 255));
                if (c0779a.dzE().dAe() != null) {
                    com.opensource.svgaplayer.entities.b dAe = c0779a.dzE().dAe();
                    if (dAe != null) {
                        canvas.save();
                        dzF.reset();
                        Path dzG = this.mKp.dzG();
                        dAe.a(dzG);
                        dzG.transform(c);
                        canvas.clipPath(dzG);
                        c.preScale((float) (c0779a.dzE().dAd().getWidth() / bitmap.getWidth()), (float) (c0779a.dzE().dAd().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dzF);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0779a.dzE().dAd().getWidth() / bitmap.getWidth()), (float) (c0779a.dzE().dAd().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dzF);
                }
                a(canvas, bitmap, c0779a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0779a c0779a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.mJo.dzo()) {
            this.mKq.clear();
            this.mJo.wl(false);
        }
        String dzD = c0779a.dzD();
        if (dzD != null) {
            Bitmap bitmap3 = null;
            String str = this.mJo.dzj().get(dzD);
            if (str != null) {
                TextPaint textPaint = this.mJo.dzk().get(dzD);
                if (textPaint != null && (bitmap3 = this.mKq.get(dzD)) == null) {
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
                    hashMap.put(dzD, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.mJo.dzl().get(dzD);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.mKq.get(dzD);
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
                    hashMap2.put(dzD, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dzF = this.mKp.dzF();
                dzF.setAntiAlias(dzg().dzu());
                if (c0779a.dzE().dAe() != null) {
                    com.opensource.svgaplayer.entities.b dAe = c0779a.dzE().dAe();
                    if (dAe != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dzF.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dzG = this.mKp.dzG();
                        dAe.a(dzG);
                        canvas.drawPath(dzG, dzF);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dzF.setFilterBitmap(dzg().dzu());
                canvas.drawBitmap(bitmap2, matrix, dzF);
            }
        }
    }

    private final void b(a.C0779a c0779a, Canvas canvas) {
        float[] dzZ;
        String dzX;
        String dzW;
        int dzU;
        Matrix c = c(c0779a.dzE().dzQ());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0779a.dzE().hG()) {
            sVGAVideoShapeEntity.dzT();
            if (sVGAVideoShapeEntity.dzS() != null) {
                Paint dzF = this.mKp.dzF();
                dzF.reset();
                dzF.setAntiAlias(dzg().dzu());
                dzF.setAlpha((int) (c0779a.dzE().dAc() * 255));
                Path dzG = this.mKp.dzG();
                dzG.reset();
                dzG.addPath(this.mKr.a(sVGAVideoShapeEntity));
                Matrix dzJ = this.mKp.dzJ();
                dzJ.reset();
                Matrix dzQ = sVGAVideoShapeEntity.dzQ();
                if (dzQ != null) {
                    dzJ.postConcat(dzQ);
                }
                dzJ.postConcat(c);
                dzG.transform(dzJ);
                SVGAVideoShapeEntity.a dzP = sVGAVideoShapeEntity.dzP();
                if (dzP != null && (dzU = dzP.dzU()) != 0) {
                    dzF.setStyle(Paint.Style.FILL);
                    dzF.setColor(dzU);
                    dzF.setAlpha(Math.min(255, Math.max(0, (int) (c0779a.dzE().dAc() * 255))));
                    if (c0779a.dzE().dAe() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAe = c0779a.dzE().dAe();
                    if (dAe != null) {
                        Path dzH = this.mKp.dzH();
                        dAe.a(dzH);
                        dzH.transform(c);
                        canvas.clipPath(dzH);
                    }
                    canvas.drawPath(dzG, dzF);
                    if (c0779a.dzE().dAe() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dzP2 = sVGAVideoShapeEntity.dzP();
                if (dzP2 != null && dzP2.getStrokeWidth() > 0) {
                    dzF.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dzP3 = sVGAVideoShapeEntity.dzP();
                    if (dzP3 != null) {
                        dzF.setColor(dzP3.dzV());
                        dzF.setAlpha(Math.min(255, Math.max(0, (int) (c0779a.dzE().dAc() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dzP4 = sVGAVideoShapeEntity.dzP();
                    if (dzP4 != null) {
                        dzF.setStrokeWidth(dzP4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dzP5 = sVGAVideoShapeEntity.dzP();
                    if (dzP5 != null && (dzW = dzP5.dzW()) != null) {
                        if (l.F(dzW, "butt", true)) {
                            dzF.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dzW, "round", true)) {
                            dzF.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dzW, "square", true)) {
                            dzF.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dzP6 = sVGAVideoShapeEntity.dzP();
                    if (dzP6 != null && (dzX = dzP6.dzX()) != null) {
                        if (l.F(dzX, "miter", true)) {
                            dzF.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dzX, "round", true)) {
                            dzF.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dzX, "bevel", true)) {
                            dzF.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dzP7 = sVGAVideoShapeEntity.dzP();
                    if (dzP7 != null) {
                        dzF.setStrokeMiter(dzP7.dzY() * d);
                    }
                    SVGAVideoShapeEntity.a dzP8 = sVGAVideoShapeEntity.dzP();
                    if (dzP8 != null && (dzZ = dzP8.dzZ()) != null && dzZ.length == 3 && (dzZ[0] > 0 || dzZ[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dzZ[0] < 1.0f ? 1.0f : dzZ[0]) * d;
                        fArr[1] = (dzZ[1] < 0.1f ? 0.1f : dzZ[1]) * d;
                        dzF.setPathEffect(new DashPathEffect(fArr, dzZ[2] * d));
                    }
                    if (c0779a.dzE().dAe() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAe2 = c0779a.dzE().dAe();
                    if (dAe2 != null) {
                        Path dzH2 = this.mKp.dzH();
                        dAe2.a(dzH2);
                        dzH2.transform(c);
                        canvas.clipPath(dzH2);
                    }
                    canvas.drawPath(dzG, dzF);
                    if (c0779a.dzE().dAe() != null) {
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
        return dzC().dAj() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0779a c0779a, Canvas canvas, int i) {
        String dzD = c0779a.dzD();
        if (dzD != null) {
            m<Canvas, Integer, Boolean> mVar = this.mJo.dzm().get(dzD);
            if (mVar != null) {
                Matrix c = c(c0779a.dzE().dzQ());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.mJo.dzn().get(dzD);
            if (rVar != null) {
                Matrix c2 = c(c0779a.dzE().dzQ());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0779a.dzE().dAd().getWidth()), Integer.valueOf((int) c0779a.dzE().dAd().getHeight()));
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

        public final Paint dzF() {
            this.mKw.reset();
            return this.mKw;
        }

        public final Path dzG() {
            this.mKx.reset();
            return this.mKx;
        }

        public final Path dzH() {
            this.mKy.reset();
            return this.mKy;
        }

        public final Matrix dzI() {
            this.mKz.reset();
            return this.mKz;
        }

        public final Matrix dzJ() {
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
                path.set(sVGAVideoShapeEntity.dzS());
                this.mKv.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.mKv.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dDS();
            }
            return path2;
        }
    }
}
