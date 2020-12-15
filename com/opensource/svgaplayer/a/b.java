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
    private final c pyv;
    private final C1014b pzv;
    private final HashMap<String, Bitmap> pzw;
    private final a pzx;
    private final float[] pzy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pyv = cVar;
        this.pzv = new C1014b();
        this.pzw = new HashMap<>();
        this.pzx = new a();
        this.pzy = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pzx.at(canvas);
        for (a.C1013a c1013a : RC(i)) {
            a(c1013a, canvas, i);
        }
        RD(i);
    }

    private final void RD(int i) {
        SoundPool ezU;
        Integer eAg;
        for (com.opensource.svgaplayer.entities.a aVar : ezB().ezT()) {
            if (aVar.eAe() == i && (ezU = ezB().ezU()) != null && (eAg = aVar.eAg()) != null) {
                aVar.u(Integer.valueOf(ezU.play(eAg.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eAf() <= i) {
                Integer eAh = aVar.eAh();
                if (eAh != null) {
                    int intValue = eAh.intValue();
                    SoundPool ezU2 = ezB().ezU();
                    if (ezU2 != null) {
                        ezU2.stop(intValue);
                    }
                }
                aVar.u(null);
            }
        }
    }

    private final Matrix e(Matrix matrix) {
        Matrix eAc = this.pzv.eAc();
        eAc.postScale(ezX().eAB(), ezX().eAC());
        eAc.postTranslate(ezX().eAz(), ezX().eAA());
        eAc.preConcat(matrix);
        return eAc;
    }

    private final void a(a.C1013a c1013a, Canvas canvas, int i) {
        a(c1013a, canvas);
        b(c1013a, canvas);
        b(c1013a, canvas, i);
    }

    private final void a(a.C1013a c1013a, Canvas canvas) {
        String imageKey = c1013a.getImageKey();
        if (imageKey != null && !p.l(this.pyv.ezC().get(imageKey), true)) {
            Bitmap bitmap = this.pyv.ezD().get(imageKey);
            if (bitmap == null) {
                bitmap = ezB().ezV().get(imageKey);
            }
            if (bitmap != null) {
                Matrix e = e(c1013a.ezY().eAk());
                Paint ezZ = this.pzv.ezZ();
                ezZ.setAntiAlias(ezB().ezP());
                ezZ.setFilterBitmap(ezB().ezP());
                ezZ.setAlpha((int) (c1013a.ezY().eAw() * 255));
                if (c1013a.ezY().eAy() != null) {
                    com.opensource.svgaplayer.entities.b eAy = c1013a.ezY().eAy();
                    if (eAy != null) {
                        canvas.save();
                        ezZ.reset();
                        Path eAa = this.pzv.eAa();
                        eAy.a(eAa);
                        eAa.transform(e);
                        canvas.clipPath(eAa);
                        e.preScale((float) (c1013a.ezY().eAx().getWidth() / bitmap.getWidth()), (float) (c1013a.ezY().eAx().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, e, ezZ);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    e.preScale((float) (c1013a.ezY().eAx().getWidth() / bitmap.getWidth()), (float) (c1013a.ezY().eAx().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, e, ezZ);
                }
                a(canvas, bitmap, c1013a, e);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1013a c1013a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pyv.ezJ()) {
            this.pzw.clear();
            this.pyv.Bi(false);
        }
        String imageKey = c1013a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pyv.ezE().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pyv.ezF().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pzw.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pzw;
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
            StaticLayout staticLayout = this.pyv.ezG().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pzw.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.pzw;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint ezZ = this.pzv.ezZ();
                ezZ.setAntiAlias(ezB().ezP());
                if (c1013a.ezY().eAy() != null) {
                    com.opensource.svgaplayer.entities.b eAy = c1013a.ezY().eAy();
                    if (eAy != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        ezZ.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eAa = this.pzv.eAa();
                        eAy.a(eAa);
                        canvas.drawPath(eAa, ezZ);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                ezZ.setFilterBitmap(ezB().ezP());
                canvas.drawBitmap(bitmap2, matrix, ezZ);
            }
        }
    }

    private final void b(a.C1013a c1013a, Canvas canvas) {
        float[] eAt;
        String eAr;
        String eAq;
        int eAo;
        Matrix e = e(c1013a.ezY().eAk());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1013a.ezY().jz()) {
            sVGAVideoShapeEntity.eAn();
            if (sVGAVideoShapeEntity.eAm() != null) {
                Paint ezZ = this.pzv.ezZ();
                ezZ.reset();
                ezZ.setAntiAlias(ezB().ezP());
                ezZ.setAlpha((int) (c1013a.ezY().eAw() * 255));
                Path eAa = this.pzv.eAa();
                eAa.reset();
                eAa.addPath(this.pzx.a(sVGAVideoShapeEntity));
                Matrix eAd = this.pzv.eAd();
                eAd.reset();
                Matrix eAk = sVGAVideoShapeEntity.eAk();
                if (eAk != null) {
                    eAd.postConcat(eAk);
                }
                eAd.postConcat(e);
                eAa.transform(eAd);
                SVGAVideoShapeEntity.a eAj = sVGAVideoShapeEntity.eAj();
                if (eAj != null && (eAo = eAj.eAo()) != 0) {
                    ezZ.setStyle(Paint.Style.FILL);
                    ezZ.setColor(eAo);
                    ezZ.setAlpha(Math.min(255, Math.max(0, (int) (c1013a.ezY().eAw() * 255))));
                    if (c1013a.ezY().eAy() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eAy = c1013a.ezY().eAy();
                    if (eAy != null) {
                        Path eAb = this.pzv.eAb();
                        eAy.a(eAb);
                        eAb.transform(e);
                        canvas.clipPath(eAb);
                    }
                    canvas.drawPath(eAa, ezZ);
                    if (c1013a.ezY().eAy() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eAj2 = sVGAVideoShapeEntity.eAj();
                if (eAj2 != null && eAj2.getStrokeWidth() > 0) {
                    ezZ.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eAj3 = sVGAVideoShapeEntity.eAj();
                    if (eAj3 != null) {
                        ezZ.setColor(eAj3.eAp());
                        ezZ.setAlpha(Math.min(255, Math.max(0, (int) (c1013a.ezY().eAw() * 255))));
                    }
                    float f = f(e);
                    SVGAVideoShapeEntity.a eAj4 = sVGAVideoShapeEntity.eAj();
                    if (eAj4 != null) {
                        ezZ.setStrokeWidth(eAj4.getStrokeWidth() * f);
                    }
                    SVGAVideoShapeEntity.a eAj5 = sVGAVideoShapeEntity.eAj();
                    if (eAj5 != null && (eAq = eAj5.eAq()) != null) {
                        if (l.K(eAq, "butt", true)) {
                            ezZ.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.K(eAq, "round", true)) {
                            ezZ.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.K(eAq, "square", true)) {
                            ezZ.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eAj6 = sVGAVideoShapeEntity.eAj();
                    if (eAj6 != null && (eAr = eAj6.eAr()) != null) {
                        if (l.K(eAr, "miter", true)) {
                            ezZ.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.K(eAr, "round", true)) {
                            ezZ.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.K(eAr, "bevel", true)) {
                            ezZ.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eAj7 = sVGAVideoShapeEntity.eAj();
                    if (eAj7 != null) {
                        ezZ.setStrokeMiter(eAj7.eAs() * f);
                    }
                    SVGAVideoShapeEntity.a eAj8 = sVGAVideoShapeEntity.eAj();
                    if (eAj8 != null && (eAt = eAj8.eAt()) != null && eAt.length == 3 && (eAt[0] > 0 || eAt[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eAt[0] < 1.0f ? 1.0f : eAt[0]) * f;
                        fArr[1] = (eAt[1] < 0.1f ? 0.1f : eAt[1]) * f;
                        ezZ.setPathEffect(new DashPathEffect(fArr, eAt[2] * f));
                    }
                    if (c1013a.ezY().eAy() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eAy2 = c1013a.ezY().eAy();
                    if (eAy2 != null) {
                        Path eAb2 = this.pzv.eAb();
                        eAy2.a(eAb2);
                        eAb2.transform(e);
                        canvas.clipPath(eAb2);
                    }
                    canvas.drawPath(eAa, ezZ);
                    if (c1013a.ezY().eAy() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float f(Matrix matrix) {
        matrix.getValues(this.pzy);
        if (this.pzy[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pzy[0];
        double d2 = this.pzy[3];
        double d3 = this.pzy[1];
        double d4 = this.pzy[4];
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
        return ezX().eAD() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1013a c1013a, Canvas canvas, int i) {
        String imageKey = c1013a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pyv.ezH().get(imageKey);
            if (cVar != null) {
                Matrix e = e(c1013a.ezY().eAk());
                canvas.save();
                canvas.concat(e);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pyv.ezI().get(imageKey);
            if (dVar != null) {
                Matrix e2 = e(c1013a.ezY().eAk());
                canvas.save();
                canvas.concat(e2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1013a.ezY().eAx().getWidth()), Integer.valueOf((int) c1013a.ezY().eAx().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C1014b {
        private final Paint pzA = new Paint();
        private final Path pzB = new Path();
        private final Path pzC = new Path();
        private final Matrix pzD = new Matrix();
        private final Matrix pzE = new Matrix();

        public final Paint ezZ() {
            this.pzA.reset();
            return this.pzA;
        }

        public final Path eAa() {
            this.pzB.reset();
            return this.pzB;
        }

        public final Path eAb() {
            this.pzC.reset();
            return this.pzC;
        }

        public final Matrix eAc() {
            this.pzD.reset();
            return this.pzD;
        }

        public final Matrix eAd() {
            this.pzE.reset();
            return this.pzE;
        }
    }

    @e
    /* loaded from: classes18.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> pzz = new HashMap<>();

        public final void at(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.pzz.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pzz.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eAm());
                this.pzz.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pzz.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eEa();
            }
            return path2;
        }
    }
}
