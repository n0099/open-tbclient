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
import kotlin.jvm.a.d;
import kotlin.jvm.internal.p;
import kotlin.text.l;
/* loaded from: classes4.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c mKt;
    private final C0683b mLu;
    private final HashMap<String, Bitmap> mLv;
    private final a mLw;
    private final float[] mLx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.j(fVar, "videoItem");
        p.j(cVar, "dynamicItem");
        this.mKt = cVar;
        this.mLu = new C0683b();
        this.mLv = new HashMap<>();
        this.mLw = new a();
        this.mLx = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.j(canvas, "canvas");
        p.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.mLw.ag(canvas);
        for (a.C0682a c0682a : Mv(i)) {
            a(c0682a, canvas, i);
        }
        Mw(i);
    }

    private final void Mw(int i) {
        SoundPool dzU;
        Integer dAh;
        for (com.opensource.svgaplayer.entities.a aVar : dzC().dzT()) {
            if (aVar.dAf() == i && (dzU = dzC().dzU()) != null && (dAh = aVar.dAh()) != null) {
                aVar.s(Integer.valueOf(dzU.play(dAh.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dAg() <= i) {
                Integer dAi = aVar.dAi();
                if (dAi != null) {
                    int intValue = dAi.intValue();
                    SoundPool dzU2 = dzC().dzU();
                    if (dzU2 != null) {
                        dzU2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix d(Matrix matrix) {
        Matrix dAd = this.mLu.dAd();
        dAd.postScale(dzX().dAC(), dzX().dAD());
        dAd.postTranslate(dzX().dAA(), dzX().dAB());
        dAd.preConcat(matrix);
        return dAd;
    }

    private final void a(a.C0682a c0682a, Canvas canvas, int i) {
        a(c0682a, canvas);
        b(c0682a, canvas);
        b(c0682a, canvas, i);
    }

    private final void a(a.C0682a c0682a, Canvas canvas) {
        String dzY = c0682a.dzY();
        if (dzY != null && !p.h(this.mKt.dzD().get(dzY), true)) {
            Bitmap bitmap = this.mKt.dzE().get(dzY);
            if (bitmap == null) {
                bitmap = dzC().dzV().get(dzY);
            }
            if (bitmap != null) {
                Matrix d = d(c0682a.dzZ().dAl());
                Paint dAa = this.mLu.dAa();
                dAa.setAntiAlias(dzC().dzP());
                dAa.setFilterBitmap(dzC().dzP());
                dAa.setAlpha((int) (c0682a.dzZ().dAx() * 255));
                if (c0682a.dzZ().dAz() != null) {
                    com.opensource.svgaplayer.entities.b dAz = c0682a.dzZ().dAz();
                    if (dAz != null) {
                        canvas.save();
                        dAa.reset();
                        Path dAb = this.mLu.dAb();
                        dAz.c(dAb);
                        dAb.transform(d);
                        canvas.clipPath(dAb);
                        d.preScale((float) (c0682a.dzZ().dAy().getWidth() / bitmap.getWidth()), (float) (c0682a.dzZ().dAy().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, d, dAa);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    d.preScale((float) (c0682a.dzZ().dAy().getWidth() / bitmap.getWidth()), (float) (c0682a.dzZ().dAy().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, d, dAa);
                }
                a(canvas, bitmap, c0682a, d);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0682a c0682a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.mKt.dzK()) {
            this.mLv.clear();
            this.mKt.vS(false);
        }
        String dzY = c0682a.dzY();
        if (dzY != null) {
            Bitmap bitmap3 = null;
            String str = this.mKt.dzF().get(dzY);
            if (str != null) {
                TextPaint textPaint = this.mKt.dzG().get(dzY);
                if (textPaint != null && (bitmap3 = this.mLv.get(dzY)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.mLv;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dzY, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.mKt.dzH().get(dzY);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.mLv.get(dzY);
                if (bitmap4 == null) {
                    p.i(staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    p.i(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.mLv;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dzY, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dAa = this.mLu.dAa();
                dAa.setAntiAlias(dzC().dzP());
                if (c0682a.dzZ().dAz() != null) {
                    com.opensource.svgaplayer.entities.b dAz = c0682a.dzZ().dAz();
                    if (dAz != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dAa.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dAb = this.mLu.dAb();
                        dAz.c(dAb);
                        canvas.drawPath(dAb, dAa);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dAa.setFilterBitmap(dzC().dzP());
                canvas.drawBitmap(bitmap2, matrix, dAa);
            }
        }
    }

    private final void b(a.C0682a c0682a, Canvas canvas) {
        float[] dAu;
        String dAs;
        String dAr;
        int dAp;
        Matrix d = d(c0682a.dzZ().dAl());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0682a.dzZ().ci()) {
            sVGAVideoShapeEntity.dAo();
            if (sVGAVideoShapeEntity.dAn() != null) {
                Paint dAa = this.mLu.dAa();
                dAa.reset();
                dAa.setAntiAlias(dzC().dzP());
                dAa.setAlpha((int) (c0682a.dzZ().dAx() * 255));
                Path dAb = this.mLu.dAb();
                dAb.reset();
                dAb.addPath(this.mLw.a(sVGAVideoShapeEntity));
                Matrix dAe = this.mLu.dAe();
                dAe.reset();
                Matrix dAl = sVGAVideoShapeEntity.dAl();
                if (dAl != null) {
                    dAe.postConcat(dAl);
                }
                dAe.postConcat(d);
                dAb.transform(dAe);
                SVGAVideoShapeEntity.a dAk = sVGAVideoShapeEntity.dAk();
                if (dAk != null && (dAp = dAk.dAp()) != 0) {
                    dAa.setStyle(Paint.Style.FILL);
                    dAa.setColor(dAp);
                    dAa.setAlpha(Math.min(255, Math.max(0, (int) (c0682a.dzZ().dAx() * 255))));
                    if (c0682a.dzZ().dAz() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAz = c0682a.dzZ().dAz();
                    if (dAz != null) {
                        Path dAc = this.mLu.dAc();
                        dAz.c(dAc);
                        dAc.transform(d);
                        canvas.clipPath(dAc);
                    }
                    canvas.drawPath(dAb, dAa);
                    if (c0682a.dzZ().dAz() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dAk2 = sVGAVideoShapeEntity.dAk();
                if (dAk2 != null && dAk2.getStrokeWidth() > 0) {
                    dAa.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dAk3 = sVGAVideoShapeEntity.dAk();
                    if (dAk3 != null) {
                        dAa.setColor(dAk3.dAq());
                        dAa.setAlpha(Math.min(255, Math.max(0, (int) (c0682a.dzZ().dAx() * 255))));
                    }
                    float e = e(d);
                    SVGAVideoShapeEntity.a dAk4 = sVGAVideoShapeEntity.dAk();
                    if (dAk4 != null) {
                        dAa.setStrokeWidth(dAk4.getStrokeWidth() * e);
                    }
                    SVGAVideoShapeEntity.a dAk5 = sVGAVideoShapeEntity.dAk();
                    if (dAk5 != null && (dAr = dAk5.dAr()) != null) {
                        if (l.D(dAr, "butt", true)) {
                            dAa.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.D(dAr, "round", true)) {
                            dAa.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.D(dAr, "square", true)) {
                            dAa.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dAk6 = sVGAVideoShapeEntity.dAk();
                    if (dAk6 != null && (dAs = dAk6.dAs()) != null) {
                        if (l.D(dAs, "miter", true)) {
                            dAa.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.D(dAs, "round", true)) {
                            dAa.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.D(dAs, "bevel", true)) {
                            dAa.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dAk7 = sVGAVideoShapeEntity.dAk();
                    if (dAk7 != null) {
                        dAa.setStrokeMiter(dAk7.dAt() * e);
                    }
                    SVGAVideoShapeEntity.a dAk8 = sVGAVideoShapeEntity.dAk();
                    if (dAk8 != null && (dAu = dAk8.dAu()) != null && dAu.length == 3 && (dAu[0] > 0 || dAu[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dAu[0] < 1.0f ? 1.0f : dAu[0]) * e;
                        fArr[1] = (dAu[1] < 0.1f ? 0.1f : dAu[1]) * e;
                        dAa.setPathEffect(new DashPathEffect(fArr, dAu[2] * e));
                    }
                    if (c0682a.dzZ().dAz() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dAz2 = c0682a.dzZ().dAz();
                    if (dAz2 != null) {
                        Path dAc2 = this.mLu.dAc();
                        dAz2.c(dAc2);
                        dAc2.transform(d);
                        canvas.clipPath(dAc2);
                    }
                    canvas.drawPath(dAb, dAa);
                    if (c0682a.dzZ().dAz() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float e(Matrix matrix) {
        matrix.getValues(this.mLx);
        if (this.mLx[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.mLx[0];
        double d2 = this.mLx[3];
        double d3 = this.mLx[1];
        double d4 = this.mLx[4];
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
        return dzX().dAE() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0682a c0682a, Canvas canvas, int i) {
        String dzY = c0682a.dzY();
        if (dzY != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.mKt.dzI().get(dzY);
            if (cVar != null) {
                Matrix d = d(c0682a.dzZ().dAl());
                canvas.save();
                canvas.concat(d);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.mKt.dzJ().get(dzY);
            if (dVar != null) {
                Matrix d2 = d(c0682a.dzZ().dAl());
                canvas.save();
                canvas.concat(d2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0682a.dzZ().dAy().getWidth()), Integer.valueOf((int) c0682a.dzZ().dAy().getHeight()));
                canvas.restore();
            }
        }
    }

    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0683b {
        private final Paint mLB = new Paint();
        private final Path mLC = new Path();
        private final Path mLD = new Path();
        private final Matrix mLE = new Matrix();
        private final Matrix mLF = new Matrix();

        public final Paint dAa() {
            this.mLB.reset();
            return this.mLB;
        }

        public final Path dAb() {
            this.mLC.reset();
            return this.mLC;
        }

        public final Path dAc() {
            this.mLD.reset();
            return this.mLD;
        }

        public final Matrix dAd() {
            this.mLE.reset();
            return this.mLE;
        }

        public final Matrix dAe() {
            this.mLF.reset();
            return this.mLF;
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private final HashMap<SVGAVideoShapeEntity, Path> mLA = new HashMap<>();
        private int mLy;
        private int mLz;

        public final void ag(Canvas canvas) {
            p.j(canvas, "canvas");
            if (this.mLy != canvas.getWidth() || this.mLz != canvas.getHeight()) {
                this.mLA.clear();
            }
            this.mLy = canvas.getWidth();
            this.mLz = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.j(sVGAVideoShapeEntity, "shape");
            if (!this.mLA.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dAn());
                this.mLA.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.mLA.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.dER();
            }
            return path2;
        }
    }
}
