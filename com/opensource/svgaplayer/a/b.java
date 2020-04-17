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
    private final c mJl;
    private final C0759b mKm;
    private final HashMap<String, Bitmap> mKn;
    private final a mKo;
    private final float[] mKp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.mJl = cVar;
        this.mKm = new C0759b();
        this.mKn = new HashMap<>();
        this.mKo = new a();
        this.mKp = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.mKo.ad(canvas);
        for (a.C0758a c0758a : II(i)) {
            a(c0758a, canvas, i);
        }
        IJ(i);
    }

    private final void IJ(int i) {
        SoundPool dzC;
        Integer dzP;
        for (com.opensource.svgaplayer.entities.a aVar : dzj().dzB()) {
            if (aVar.dzN() == i && (dzC = dzj().dzC()) != null && (dzP = aVar.dzP()) != null) {
                aVar.r(Integer.valueOf(dzC.play(dzP.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dzO() <= i) {
                Integer dzQ = aVar.dzQ();
                if (dzQ != null) {
                    int intValue = dzQ.intValue();
                    SoundPool dzC2 = dzj().dzC();
                    if (dzC2 != null) {
                        dzC2.stop(intValue);
                    }
                }
                aVar.r(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dzL = this.mKm.dzL();
        dzL.postScale(dzF().dAk(), dzF().dAl());
        dzL.postTranslate(dzF().dAi(), dzF().dAj());
        dzL.preConcat(matrix);
        return dzL;
    }

    private final void a(a.C0758a c0758a, Canvas canvas, int i) {
        a(c0758a, canvas);
        b(c0758a, canvas);
        b(c0758a, canvas, i);
    }

    private final void a(a.C0758a c0758a, Canvas canvas) {
        String dzG = c0758a.dzG();
        if (dzG != null && !q.k(this.mJl.dzk().get(dzG), true)) {
            Bitmap bitmap = this.mJl.dzl().get(dzG);
            if (bitmap == null) {
                bitmap = dzj().dzD().get(dzG);
            }
            if (bitmap != null) {
                Matrix c = c(c0758a.dzH().dzT());
                Paint dzI = this.mKm.dzI();
                dzI.setAntiAlias(dzj().dzx());
                dzI.setFilterBitmap(dzj().dzx());
                dzI.setAlpha((int) (c0758a.dzH().dAf() * 255));
                if (c0758a.dzH().dAh() != null) {
                    com.opensource.svgaplayer.entities.b dAh = c0758a.dzH().dAh();
                    if (dAh != null) {
                        canvas.save();
                        dzI.reset();
                        Path dzJ = this.mKm.dzJ();
                        dAh.a(dzJ);
                        dzJ.transform(c);
                        canvas.clipPath(dzJ);
                        c.preScale((float) (c0758a.dzH().dAg().getWidth() / bitmap.getWidth()), (float) (c0758a.dzH().dAg().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dzI);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0758a.dzH().dAg().getWidth() / bitmap.getWidth()), (float) (c0758a.dzH().dAg().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dzI);
                }
                a(canvas, bitmap, c0758a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0758a c0758a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.mJl.dzr()) {
            this.mKn.clear();
            this.mJl.wl(false);
        }
        String dzG = c0758a.dzG();
        if (dzG != null) {
            Bitmap bitmap3 = null;
            String str = this.mJl.dzm().get(dzG);
            if (str != null) {
                TextPaint textPaint = this.mJl.dzn().get(dzG);
                if (textPaint != null && (bitmap3 = this.mKn.get(dzG)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.mKn;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dzG, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.mJl.dzo().get(dzG);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.mKn.get(dzG);
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
                    HashMap<String, Bitmap> hashMap2 = this.mKn;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dzG, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dzI = this.mKm.dzI();
                dzI.setAntiAlias(dzj().dzx());
                if (c0758a.dzH().dAh() != null) {
                    com.opensource.svgaplayer.entities.b dAh = c0758a.dzH().dAh();
                    if (dAh != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dzI.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dzJ = this.mKm.dzJ();
                        dAh.a(dzJ);
                        canvas.drawPath(dzJ, dzI);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dzI.setFilterBitmap(dzj().dzx());
                canvas.drawBitmap(bitmap2, matrix, dzI);
            }
        }
    }

    private final void b(a.C0758a c0758a, Canvas canvas) {
        float[] dAc;
        String dAa;
        String dzZ;
        int dzX;
        Matrix c = c(c0758a.dzH().dzT());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0758a.dzH().hG()) {
            sVGAVideoShapeEntity.dzW();
            if (sVGAVideoShapeEntity.dzV() != null) {
                Paint dzI = this.mKm.dzI();
                dzI.reset();
                dzI.setAntiAlias(dzj().dzx());
                dzI.setAlpha((int) (c0758a.dzH().dAf() * 255));
                Path dzJ = this.mKm.dzJ();
                dzJ.reset();
                dzJ.addPath(this.mKo.a(sVGAVideoShapeEntity));
                Matrix dzM = this.mKm.dzM();
                dzM.reset();
                Matrix dzT = sVGAVideoShapeEntity.dzT();
                if (dzT != null) {
                    dzM.postConcat(dzT);
                }
                dzM.postConcat(c);
                dzJ.transform(dzM);
                SVGAVideoShapeEntity.a dzS = sVGAVideoShapeEntity.dzS();
                if (dzS != null && (dzX = dzS.dzX()) != 0) {
                    dzI.setStyle(Paint.Style.FILL);
                    dzI.setColor(dzX);
                    dzI.setAlpha(Math.min(255, Math.max(0, (int) (c0758a.dzH().dAf() * 255))));
                    if (c0758a.dzH().dAh() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAh = c0758a.dzH().dAh();
                    if (dAh != null) {
                        Path dzK = this.mKm.dzK();
                        dAh.a(dzK);
                        dzK.transform(c);
                        canvas.clipPath(dzK);
                    }
                    canvas.drawPath(dzJ, dzI);
                    if (c0758a.dzH().dAh() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dzS2 = sVGAVideoShapeEntity.dzS();
                if (dzS2 != null && dzS2.getStrokeWidth() > 0) {
                    dzI.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dzS3 = sVGAVideoShapeEntity.dzS();
                    if (dzS3 != null) {
                        dzI.setColor(dzS3.dzY());
                        dzI.setAlpha(Math.min(255, Math.max(0, (int) (c0758a.dzH().dAf() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dzS4 = sVGAVideoShapeEntity.dzS();
                    if (dzS4 != null) {
                        dzI.setStrokeWidth(dzS4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dzS5 = sVGAVideoShapeEntity.dzS();
                    if (dzS5 != null && (dzZ = dzS5.dzZ()) != null) {
                        if (l.F(dzZ, "butt", true)) {
                            dzI.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dzZ, "round", true)) {
                            dzI.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dzZ, "square", true)) {
                            dzI.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dzS6 = sVGAVideoShapeEntity.dzS();
                    if (dzS6 != null && (dAa = dzS6.dAa()) != null) {
                        if (l.F(dAa, "miter", true)) {
                            dzI.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dAa, "round", true)) {
                            dzI.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dAa, "bevel", true)) {
                            dzI.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dzS7 = sVGAVideoShapeEntity.dzS();
                    if (dzS7 != null) {
                        dzI.setStrokeMiter(dzS7.dAb() * d);
                    }
                    SVGAVideoShapeEntity.a dzS8 = sVGAVideoShapeEntity.dzS();
                    if (dzS8 != null && (dAc = dzS8.dAc()) != null && dAc.length == 3 && (dAc[0] > 0 || dAc[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dAc[0] < 1.0f ? 1.0f : dAc[0]) * d;
                        fArr[1] = (dAc[1] < 0.1f ? 0.1f : dAc[1]) * d;
                        dzI.setPathEffect(new DashPathEffect(fArr, dAc[2] * d));
                    }
                    if (c0758a.dzH().dAh() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAh2 = c0758a.dzH().dAh();
                    if (dAh2 != null) {
                        Path dzK2 = this.mKm.dzK();
                        dAh2.a(dzK2);
                        dzK2.transform(c);
                        canvas.clipPath(dzK2);
                    }
                    canvas.drawPath(dzJ, dzI);
                    if (c0758a.dzH().dAh() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.mKp);
        if (this.mKp[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.mKp[0];
        double d2 = this.mKp[3];
        double d3 = this.mKp[1];
        double d4 = this.mKp[4];
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
        return dzF().dAm() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0758a c0758a, Canvas canvas, int i) {
        String dzG = c0758a.dzG();
        if (dzG != null) {
            m<Canvas, Integer, Boolean> mVar = this.mJl.dzp().get(dzG);
            if (mVar != null) {
                Matrix c = c(c0758a.dzH().dzT());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.mJl.dzq().get(dzG);
            if (rVar != null) {
                Matrix c2 = c(c0758a.dzH().dzT());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0758a.dzH().dAg().getWidth()), Integer.valueOf((int) c0758a.dzH().dAg().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0759b {
        private final Paint mKt = new Paint();
        private final Path mKu = new Path();
        private final Path mKv = new Path();
        private final Matrix mKw = new Matrix();
        private final Matrix mKx = new Matrix();

        public final Paint dzI() {
            this.mKt.reset();
            return this.mKt;
        }

        public final Path dzJ() {
            this.mKu.reset();
            return this.mKu;
        }

        public final Path dzK() {
            this.mKv.reset();
            return this.mKv;
        }

        public final Matrix dzL() {
            this.mKw.reset();
            return this.mKw;
        }

        public final Matrix dzM() {
            this.mKx.reset();
            return this.mKx;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int mKq;
        private int mKr;
        private final HashMap<SVGAVideoShapeEntity, Path> mKs = new HashMap<>();

        public final void ad(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.mKq != canvas.getWidth() || this.mKr != canvas.getHeight()) {
                this.mKs.clear();
            }
            this.mKq = canvas.getWidth();
            this.mKr = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.mKs.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dzV());
                this.mKs.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.mKs.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dDV();
            }
            return path2;
        }
    }
}
