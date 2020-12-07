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
import kotlin.e;
import kotlin.jvm.a.d;
import kotlin.jvm.internal.p;
import kotlin.text.l;
@e
/* loaded from: classes18.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c pyt;
    private final C1014b pzt;
    private final HashMap<String, Bitmap> pzu;
    private final a pzv;
    private final float[] pzw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pyt = cVar;
        this.pzt = new C1014b();
        this.pzu = new HashMap<>();
        this.pzv = new a();
        this.pzw = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pzv.at(canvas);
        for (a.C1013a c1013a : RC(i)) {
            a(c1013a, canvas, i);
        }
        RD(i);
    }

    private final void RD(int i) {
        SoundPool ezT;
        Integer eAf;
        for (com.opensource.svgaplayer.entities.a aVar : ezA().ezS()) {
            if (aVar.eAd() == i && (ezT = ezA().ezT()) != null && (eAf = aVar.eAf()) != null) {
                aVar.u(Integer.valueOf(ezT.play(eAf.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eAe() <= i) {
                Integer eAg = aVar.eAg();
                if (eAg != null) {
                    int intValue = eAg.intValue();
                    SoundPool ezT2 = ezA().ezT();
                    if (ezT2 != null) {
                        ezT2.stop(intValue);
                    }
                }
                aVar.u(null);
            }
        }
    }

    private final Matrix e(Matrix matrix) {
        Matrix eAb = this.pzt.eAb();
        eAb.postScale(ezW().eAA(), ezW().eAB());
        eAb.postTranslate(ezW().eAy(), ezW().eAz());
        eAb.preConcat(matrix);
        return eAb;
    }

    private final void a(a.C1013a c1013a, Canvas canvas, int i) {
        a(c1013a, canvas);
        b(c1013a, canvas);
        b(c1013a, canvas, i);
    }

    private final void a(a.C1013a c1013a, Canvas canvas) {
        String imageKey = c1013a.getImageKey();
        if (imageKey != null && !p.l(this.pyt.ezB().get(imageKey), true)) {
            Bitmap bitmap = this.pyt.ezC().get(imageKey);
            if (bitmap == null) {
                bitmap = ezA().ezU().get(imageKey);
            }
            if (bitmap != null) {
                Matrix e = e(c1013a.ezX().eAj());
                Paint ezY = this.pzt.ezY();
                ezY.setAntiAlias(ezA().ezO());
                ezY.setFilterBitmap(ezA().ezO());
                ezY.setAlpha((int) (c1013a.ezX().eAv() * 255));
                if (c1013a.ezX().eAx() != null) {
                    com.opensource.svgaplayer.entities.b eAx = c1013a.ezX().eAx();
                    if (eAx != null) {
                        canvas.save();
                        ezY.reset();
                        Path ezZ = this.pzt.ezZ();
                        eAx.a(ezZ);
                        ezZ.transform(e);
                        canvas.clipPath(ezZ);
                        e.preScale((float) (c1013a.ezX().eAw().getWidth() / bitmap.getWidth()), (float) (c1013a.ezX().eAw().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, e, ezY);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    e.preScale((float) (c1013a.ezX().eAw().getWidth() / bitmap.getWidth()), (float) (c1013a.ezX().eAw().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, e, ezY);
                }
                a(canvas, bitmap, c1013a, e);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1013a c1013a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pyt.ezI()) {
            this.pzu.clear();
            this.pyt.Bi(false);
        }
        String imageKey = c1013a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pyt.ezD().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pyt.ezE().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pzu.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pzu;
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
            StaticLayout staticLayout = this.pyt.ezF().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pzu.get(imageKey);
                if (bitmap4 == null) {
                    p.n(staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    p.n(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.pzu;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint ezY = this.pzt.ezY();
                ezY.setAntiAlias(ezA().ezO());
                if (c1013a.ezX().eAx() != null) {
                    com.opensource.svgaplayer.entities.b eAx = c1013a.ezX().eAx();
                    if (eAx != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        ezY.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path ezZ = this.pzt.ezZ();
                        eAx.a(ezZ);
                        canvas.drawPath(ezZ, ezY);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                ezY.setFilterBitmap(ezA().ezO());
                canvas.drawBitmap(bitmap2, matrix, ezY);
            }
        }
    }

    private final void b(a.C1013a c1013a, Canvas canvas) {
        float[] eAs;
        String eAq;
        String eAp;
        int eAn;
        Matrix e = e(c1013a.ezX().eAj());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1013a.ezX().jz()) {
            sVGAVideoShapeEntity.eAm();
            if (sVGAVideoShapeEntity.eAl() != null) {
                Paint ezY = this.pzt.ezY();
                ezY.reset();
                ezY.setAntiAlias(ezA().ezO());
                ezY.setAlpha((int) (c1013a.ezX().eAv() * 255));
                Path ezZ = this.pzt.ezZ();
                ezZ.reset();
                ezZ.addPath(this.pzv.a(sVGAVideoShapeEntity));
                Matrix eAc = this.pzt.eAc();
                eAc.reset();
                Matrix eAj = sVGAVideoShapeEntity.eAj();
                if (eAj != null) {
                    eAc.postConcat(eAj);
                }
                eAc.postConcat(e);
                ezZ.transform(eAc);
                SVGAVideoShapeEntity.a eAi = sVGAVideoShapeEntity.eAi();
                if (eAi != null && (eAn = eAi.eAn()) != 0) {
                    ezY.setStyle(Paint.Style.FILL);
                    ezY.setColor(eAn);
                    ezY.setAlpha(Math.min(255, Math.max(0, (int) (c1013a.ezX().eAv() * 255))));
                    if (c1013a.ezX().eAx() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eAx = c1013a.ezX().eAx();
                    if (eAx != null) {
                        Path eAa = this.pzt.eAa();
                        eAx.a(eAa);
                        eAa.transform(e);
                        canvas.clipPath(eAa);
                    }
                    canvas.drawPath(ezZ, ezY);
                    if (c1013a.ezX().eAx() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eAi2 = sVGAVideoShapeEntity.eAi();
                if (eAi2 != null && eAi2.getStrokeWidth() > 0) {
                    ezY.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eAi3 = sVGAVideoShapeEntity.eAi();
                    if (eAi3 != null) {
                        ezY.setColor(eAi3.eAo());
                        ezY.setAlpha(Math.min(255, Math.max(0, (int) (c1013a.ezX().eAv() * 255))));
                    }
                    float f = f(e);
                    SVGAVideoShapeEntity.a eAi4 = sVGAVideoShapeEntity.eAi();
                    if (eAi4 != null) {
                        ezY.setStrokeWidth(eAi4.getStrokeWidth() * f);
                    }
                    SVGAVideoShapeEntity.a eAi5 = sVGAVideoShapeEntity.eAi();
                    if (eAi5 != null && (eAp = eAi5.eAp()) != null) {
                        if (l.K(eAp, "butt", true)) {
                            ezY.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.K(eAp, "round", true)) {
                            ezY.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.K(eAp, "square", true)) {
                            ezY.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eAi6 = sVGAVideoShapeEntity.eAi();
                    if (eAi6 != null && (eAq = eAi6.eAq()) != null) {
                        if (l.K(eAq, "miter", true)) {
                            ezY.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.K(eAq, "round", true)) {
                            ezY.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.K(eAq, "bevel", true)) {
                            ezY.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eAi7 = sVGAVideoShapeEntity.eAi();
                    if (eAi7 != null) {
                        ezY.setStrokeMiter(eAi7.eAr() * f);
                    }
                    SVGAVideoShapeEntity.a eAi8 = sVGAVideoShapeEntity.eAi();
                    if (eAi8 != null && (eAs = eAi8.eAs()) != null && eAs.length == 3 && (eAs[0] > 0 || eAs[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eAs[0] < 1.0f ? 1.0f : eAs[0]) * f;
                        fArr[1] = (eAs[1] < 0.1f ? 0.1f : eAs[1]) * f;
                        ezY.setPathEffect(new DashPathEffect(fArr, eAs[2] * f));
                    }
                    if (c1013a.ezX().eAx() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eAx2 = c1013a.ezX().eAx();
                    if (eAx2 != null) {
                        Path eAa2 = this.pzt.eAa();
                        eAx2.a(eAa2);
                        eAa2.transform(e);
                        canvas.clipPath(eAa2);
                    }
                    canvas.drawPath(ezZ, ezY);
                    if (c1013a.ezX().eAx() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float f(Matrix matrix) {
        matrix.getValues(this.pzw);
        if (this.pzw[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pzw[0];
        double d2 = this.pzw[3];
        double d3 = this.pzw[1];
        double d4 = this.pzw[4];
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
        return ezW().eAC() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1013a c1013a, Canvas canvas, int i) {
        String imageKey = c1013a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pyt.ezG().get(imageKey);
            if (cVar != null) {
                Matrix e = e(c1013a.ezX().eAj());
                canvas.save();
                canvas.concat(e);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pyt.ezH().get(imageKey);
            if (dVar != null) {
                Matrix e2 = e(c1013a.ezX().eAj());
                canvas.save();
                canvas.concat(e2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1013a.ezX().eAw().getWidth()), Integer.valueOf((int) c1013a.ezX().eAw().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C1014b {
        private final Paint pzy = new Paint();
        private final Path pzz = new Path();
        private final Path pzA = new Path();
        private final Matrix pzB = new Matrix();
        private final Matrix pzC = new Matrix();

        public final Paint ezY() {
            this.pzy.reset();
            return this.pzy;
        }

        public final Path ezZ() {
            this.pzz.reset();
            return this.pzz;
        }

        public final Path eAa() {
            this.pzA.reset();
            return this.pzA;
        }

        public final Matrix eAb() {
            this.pzB.reset();
            return this.pzB;
        }

        public final Matrix eAc() {
            this.pzC.reset();
            return this.pzC;
        }
    }

    @e
    /* loaded from: classes18.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> pzx = new HashMap<>();

        public final void at(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.pzx.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pzx.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eAl());
                this.pzx.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pzx.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eDZ();
            }
            return path2;
        }
    }
}
