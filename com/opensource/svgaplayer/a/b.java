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
/* loaded from: classes6.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c pRa;
    private final C1145b pSa;
    private final HashMap<String, Bitmap> pSb;
    private final a pSc;
    private final float[] pSd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pRa = cVar;
        this.pSa = new C1145b();
        this.pSb = new HashMap<>();
        this.pSc = new a();
        this.pSd = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pSc.aD(canvas);
        for (a.C1144a c1144a : Rz(i)) {
            a(c1144a, canvas, i);
        }
        RA(i);
    }

    private final void RA(int i) {
        SoundPool eDM;
        Integer eDY;
        for (com.opensource.svgaplayer.entities.a aVar : eDt().eDL()) {
            if (aVar.eDW() == i && (eDM = eDt().eDM()) != null && (eDY = aVar.eDY()) != null) {
                aVar.w(Integer.valueOf(eDM.play(eDY.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eDX() <= i) {
                Integer eDZ = aVar.eDZ();
                if (eDZ != null) {
                    int intValue = eDZ.intValue();
                    SoundPool eDM2 = eDt().eDM();
                    if (eDM2 != null) {
                        eDM2.stop(intValue);
                    }
                }
                aVar.w(null);
            }
        }
    }

    private final Matrix h(Matrix matrix) {
        Matrix eDU = this.pSa.eDU();
        eDU.postScale(eDP().eEt(), eDP().eEu());
        eDU.postTranslate(eDP().eEr(), eDP().eEs());
        eDU.preConcat(matrix);
        return eDU;
    }

    private final void a(a.C1144a c1144a, Canvas canvas, int i) {
        a(c1144a, canvas);
        b(c1144a, canvas);
        b(c1144a, canvas, i);
    }

    private final void a(a.C1144a c1144a, Canvas canvas) {
        String imageKey = c1144a.getImageKey();
        if (imageKey != null && !p.l(this.pRa.eDu().get(imageKey), true)) {
            Bitmap bitmap = this.pRa.eDv().get(imageKey);
            if (bitmap == null) {
                bitmap = eDt().eDN().get(imageKey);
            }
            if (bitmap != null) {
                Matrix h = h(c1144a.eDQ().eEc());
                Paint eDR = this.pSa.eDR();
                eDR.setAntiAlias(eDt().eDH());
                eDR.setFilterBitmap(eDt().eDH());
                eDR.setAlpha((int) (c1144a.eDQ().eEo() * 255));
                if (c1144a.eDQ().eEq() != null) {
                    com.opensource.svgaplayer.entities.b eEq = c1144a.eDQ().eEq();
                    if (eEq != null) {
                        canvas.save();
                        eDR.reset();
                        Path eDS = this.pSa.eDS();
                        eEq.a(eDS);
                        eDS.transform(h);
                        canvas.clipPath(eDS);
                        h.preScale((float) (c1144a.eDQ().eEp().getWidth() / bitmap.getWidth()), (float) (c1144a.eDQ().eEp().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, h, eDR);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    h.preScale((float) (c1144a.eDQ().eEp().getWidth() / bitmap.getWidth()), (float) (c1144a.eDQ().eEp().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, h, eDR);
                }
                a(canvas, bitmap, c1144a, h);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1144a c1144a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pRa.eDB()) {
            this.pSb.clear();
            this.pRa.Bs(false);
        }
        String imageKey = c1144a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pRa.eDw().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pRa.eDx().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pSb.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pSb;
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
            StaticLayout staticLayout = this.pRa.eDy().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pSb.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.pSb;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint eDR = this.pSa.eDR();
                eDR.setAntiAlias(eDt().eDH());
                if (c1144a.eDQ().eEq() != null) {
                    com.opensource.svgaplayer.entities.b eEq = c1144a.eDQ().eEq();
                    if (eEq != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        eDR.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eDS = this.pSa.eDS();
                        eEq.a(eDS);
                        canvas.drawPath(eDS, eDR);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                eDR.setFilterBitmap(eDt().eDH());
                canvas.drawBitmap(bitmap2, matrix, eDR);
            }
        }
    }

    private final void b(a.C1144a c1144a, Canvas canvas) {
        float[] eEl;
        String eEj;
        String eEi;
        int eEg;
        Matrix h = h(c1144a.eDQ().eEc());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1144a.eDQ().iY()) {
            sVGAVideoShapeEntity.eEf();
            if (sVGAVideoShapeEntity.eEe() != null) {
                Paint eDR = this.pSa.eDR();
                eDR.reset();
                eDR.setAntiAlias(eDt().eDH());
                eDR.setAlpha((int) (c1144a.eDQ().eEo() * 255));
                Path eDS = this.pSa.eDS();
                eDS.reset();
                eDS.addPath(this.pSc.a(sVGAVideoShapeEntity));
                Matrix eDV = this.pSa.eDV();
                eDV.reset();
                Matrix eEc = sVGAVideoShapeEntity.eEc();
                if (eEc != null) {
                    eDV.postConcat(eEc);
                }
                eDV.postConcat(h);
                eDS.transform(eDV);
                SVGAVideoShapeEntity.a eEb = sVGAVideoShapeEntity.eEb();
                if (eEb != null && (eEg = eEb.eEg()) != 0) {
                    eDR.setStyle(Paint.Style.FILL);
                    eDR.setColor(eEg);
                    eDR.setAlpha(Math.min(255, Math.max(0, (int) (c1144a.eDQ().eEo() * 255))));
                    if (c1144a.eDQ().eEq() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eEq = c1144a.eDQ().eEq();
                    if (eEq != null) {
                        Path eDT = this.pSa.eDT();
                        eEq.a(eDT);
                        eDT.transform(h);
                        canvas.clipPath(eDT);
                    }
                    canvas.drawPath(eDS, eDR);
                    if (c1144a.eDQ().eEq() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eEb2 = sVGAVideoShapeEntity.eEb();
                if (eEb2 != null && eEb2.getStrokeWidth() > 0) {
                    eDR.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eEb3 = sVGAVideoShapeEntity.eEb();
                    if (eEb3 != null) {
                        eDR.setColor(eEb3.eEh());
                        eDR.setAlpha(Math.min(255, Math.max(0, (int) (c1144a.eDQ().eEo() * 255))));
                    }
                    float i = i(h);
                    SVGAVideoShapeEntity.a eEb4 = sVGAVideoShapeEntity.eEb();
                    if (eEb4 != null) {
                        eDR.setStrokeWidth(eEb4.getStrokeWidth() * i);
                    }
                    SVGAVideoShapeEntity.a eEb5 = sVGAVideoShapeEntity.eEb();
                    if (eEb5 != null && (eEi = eEb5.eEi()) != null) {
                        if (l.N(eEi, "butt", true)) {
                            eDR.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.N(eEi, "round", true)) {
                            eDR.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.N(eEi, "square", true)) {
                            eDR.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eEb6 = sVGAVideoShapeEntity.eEb();
                    if (eEb6 != null && (eEj = eEb6.eEj()) != null) {
                        if (l.N(eEj, "miter", true)) {
                            eDR.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.N(eEj, "round", true)) {
                            eDR.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.N(eEj, "bevel", true)) {
                            eDR.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eEb7 = sVGAVideoShapeEntity.eEb();
                    if (eEb7 != null) {
                        eDR.setStrokeMiter(eEb7.eEk() * i);
                    }
                    SVGAVideoShapeEntity.a eEb8 = sVGAVideoShapeEntity.eEb();
                    if (eEb8 != null && (eEl = eEb8.eEl()) != null && eEl.length == 3 && (eEl[0] > 0 || eEl[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eEl[0] < 1.0f ? 1.0f : eEl[0]) * i;
                        fArr[1] = (eEl[1] < 0.1f ? 0.1f : eEl[1]) * i;
                        eDR.setPathEffect(new DashPathEffect(fArr, eEl[2] * i));
                    }
                    if (c1144a.eDQ().eEq() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eEq2 = c1144a.eDQ().eEq();
                    if (eEq2 != null) {
                        Path eDT2 = this.pSa.eDT();
                        eEq2.a(eDT2);
                        eDT2.transform(h);
                        canvas.clipPath(eDT2);
                    }
                    canvas.drawPath(eDS, eDR);
                    if (c1144a.eDQ().eEq() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float i(Matrix matrix) {
        matrix.getValues(this.pSd);
        if (this.pSd[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pSd[0];
        double d2 = this.pSd[3];
        double d3 = this.pSd[1];
        double d4 = this.pSd[4];
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
        return eDP().eEv() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1144a c1144a, Canvas canvas, int i) {
        String imageKey = c1144a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pRa.eDz().get(imageKey);
            if (cVar != null) {
                Matrix h = h(c1144a.eDQ().eEc());
                canvas.save();
                canvas.concat(h);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pRa.eDA().get(imageKey);
            if (dVar != null) {
                Matrix h2 = h(c1144a.eDQ().eEc());
                canvas.save();
                canvas.concat(h2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1144a.eDQ().eEp().getWidth()), Integer.valueOf((int) c1144a.eDQ().eEp().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1145b {
        private final Paint pSh = new Paint();
        private final Path pSi = new Path();
        private final Path pSj = new Path();
        private final Matrix pSk = new Matrix();
        private final Matrix pSl = new Matrix();

        public final Paint eDR() {
            this.pSh.reset();
            return this.pSh;
        }

        public final Path eDS() {
            this.pSi.reset();
            return this.pSi;
        }

        public final Path eDT() {
            this.pSj.reset();
            return this.pSj;
        }

        public final Matrix eDU() {
            this.pSk.reset();
            return this.pSk;
        }

        public final Matrix eDV() {
            this.pSl.reset();
            return this.pSl;
        }
    }

    @e
    /* loaded from: classes6.dex */
    public static final class a {
        private int pSe;
        private int pSf;
        private final HashMap<SVGAVideoShapeEntity, Path> pSg = new HashMap<>();

        public final void aD(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.pSe != canvas.getWidth() || this.pSf != canvas.getHeight()) {
                this.pSg.clear();
            }
            this.pSe = canvas.getWidth();
            this.pSf = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pSg.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eEe());
                this.pSg.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pSg.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eMi();
            }
            return path2;
        }
    }
}
