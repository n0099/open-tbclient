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
    private final c pSI;
    private final C1186b pTI;
    private final HashMap<String, Bitmap> pTJ;
    private final a pTK;
    private final float[] pTL;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pSI = cVar;
        this.pTI = new C1186b();
        this.pTJ = new HashMap<>();
        this.pTK = new a();
        this.pTL = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pTK.aD(canvas);
        for (a.C1185a c1185a : RP(i)) {
            a(c1185a, canvas, i);
        }
        RQ(i);
    }

    private final void RQ(int i) {
        SoundPool eEq;
        Integer eEC;
        for (com.opensource.svgaplayer.entities.a aVar : eDX().eEp()) {
            if (aVar.eEA() == i && (eEq = eDX().eEq()) != null && (eEC = aVar.eEC()) != null) {
                aVar.w(Integer.valueOf(eEq.play(eEC.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eEB() <= i) {
                Integer eED = aVar.eED();
                if (eED != null) {
                    int intValue = eED.intValue();
                    SoundPool eEq2 = eDX().eEq();
                    if (eEq2 != null) {
                        eEq2.stop(intValue);
                    }
                }
                aVar.w(null);
            }
        }
    }

    private final Matrix h(Matrix matrix) {
        Matrix eEy = this.pTI.eEy();
        eEy.postScale(eEt().eEX(), eEt().eEY());
        eEy.postTranslate(eEt().eEV(), eEt().eEW());
        eEy.preConcat(matrix);
        return eEy;
    }

    private final void a(a.C1185a c1185a, Canvas canvas, int i) {
        a(c1185a, canvas);
        b(c1185a, canvas);
        b(c1185a, canvas, i);
    }

    private final void a(a.C1185a c1185a, Canvas canvas) {
        String imageKey = c1185a.getImageKey();
        if (imageKey != null && !p.l(this.pSI.eDY().get(imageKey), true)) {
            Bitmap bitmap = this.pSI.eDZ().get(imageKey);
            if (bitmap == null) {
                bitmap = eDX().eEr().get(imageKey);
            }
            if (bitmap != null) {
                Matrix h = h(c1185a.eEu().eEG());
                Paint eEv = this.pTI.eEv();
                eEv.setAntiAlias(eDX().eEl());
                eEv.setFilterBitmap(eDX().eEl());
                eEv.setAlpha((int) (c1185a.eEu().eES() * 255));
                if (c1185a.eEu().eEU() != null) {
                    com.opensource.svgaplayer.entities.b eEU = c1185a.eEu().eEU();
                    if (eEU != null) {
                        canvas.save();
                        eEv.reset();
                        Path eEw = this.pTI.eEw();
                        eEU.a(eEw);
                        eEw.transform(h);
                        canvas.clipPath(eEw);
                        h.preScale((float) (c1185a.eEu().eET().getWidth() / bitmap.getWidth()), (float) (c1185a.eEu().eET().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, h, eEv);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    h.preScale((float) (c1185a.eEu().eET().getWidth() / bitmap.getWidth()), (float) (c1185a.eEu().eET().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, h, eEv);
                }
                a(canvas, bitmap, c1185a, h);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1185a c1185a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pSI.eEf()) {
            this.pTJ.clear();
            this.pSI.Bs(false);
        }
        String imageKey = c1185a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pSI.eEa().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pSI.eEb().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pTJ.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pTJ;
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
            StaticLayout staticLayout = this.pSI.eEc().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pTJ.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.pTJ;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint eEv = this.pTI.eEv();
                eEv.setAntiAlias(eDX().eEl());
                if (c1185a.eEu().eEU() != null) {
                    com.opensource.svgaplayer.entities.b eEU = c1185a.eEu().eEU();
                    if (eEU != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        eEv.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eEw = this.pTI.eEw();
                        eEU.a(eEw);
                        canvas.drawPath(eEw, eEv);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                eEv.setFilterBitmap(eDX().eEl());
                canvas.drawBitmap(bitmap2, matrix, eEv);
            }
        }
    }

    private final void b(a.C1185a c1185a, Canvas canvas) {
        float[] eEP;
        String eEN;
        String eEM;
        int eEK;
        Matrix h = h(c1185a.eEu().eEG());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1185a.eEu().iY()) {
            sVGAVideoShapeEntity.eEJ();
            if (sVGAVideoShapeEntity.eEI() != null) {
                Paint eEv = this.pTI.eEv();
                eEv.reset();
                eEv.setAntiAlias(eDX().eEl());
                eEv.setAlpha((int) (c1185a.eEu().eES() * 255));
                Path eEw = this.pTI.eEw();
                eEw.reset();
                eEw.addPath(this.pTK.a(sVGAVideoShapeEntity));
                Matrix eEz = this.pTI.eEz();
                eEz.reset();
                Matrix eEG = sVGAVideoShapeEntity.eEG();
                if (eEG != null) {
                    eEz.postConcat(eEG);
                }
                eEz.postConcat(h);
                eEw.transform(eEz);
                SVGAVideoShapeEntity.a eEF = sVGAVideoShapeEntity.eEF();
                if (eEF != null && (eEK = eEF.eEK()) != 0) {
                    eEv.setStyle(Paint.Style.FILL);
                    eEv.setColor(eEK);
                    eEv.setAlpha(Math.min(255, Math.max(0, (int) (c1185a.eEu().eES() * 255))));
                    if (c1185a.eEu().eEU() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eEU = c1185a.eEu().eEU();
                    if (eEU != null) {
                        Path eEx = this.pTI.eEx();
                        eEU.a(eEx);
                        eEx.transform(h);
                        canvas.clipPath(eEx);
                    }
                    canvas.drawPath(eEw, eEv);
                    if (c1185a.eEu().eEU() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eEF2 = sVGAVideoShapeEntity.eEF();
                if (eEF2 != null && eEF2.getStrokeWidth() > 0) {
                    eEv.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eEF3 = sVGAVideoShapeEntity.eEF();
                    if (eEF3 != null) {
                        eEv.setColor(eEF3.eEL());
                        eEv.setAlpha(Math.min(255, Math.max(0, (int) (c1185a.eEu().eES() * 255))));
                    }
                    float i = i(h);
                    SVGAVideoShapeEntity.a eEF4 = sVGAVideoShapeEntity.eEF();
                    if (eEF4 != null) {
                        eEv.setStrokeWidth(eEF4.getStrokeWidth() * i);
                    }
                    SVGAVideoShapeEntity.a eEF5 = sVGAVideoShapeEntity.eEF();
                    if (eEF5 != null && (eEM = eEF5.eEM()) != null) {
                        if (l.N(eEM, "butt", true)) {
                            eEv.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.N(eEM, "round", true)) {
                            eEv.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.N(eEM, "square", true)) {
                            eEv.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eEF6 = sVGAVideoShapeEntity.eEF();
                    if (eEF6 != null && (eEN = eEF6.eEN()) != null) {
                        if (l.N(eEN, "miter", true)) {
                            eEv.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.N(eEN, "round", true)) {
                            eEv.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.N(eEN, "bevel", true)) {
                            eEv.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eEF7 = sVGAVideoShapeEntity.eEF();
                    if (eEF7 != null) {
                        eEv.setStrokeMiter(eEF7.eEO() * i);
                    }
                    SVGAVideoShapeEntity.a eEF8 = sVGAVideoShapeEntity.eEF();
                    if (eEF8 != null && (eEP = eEF8.eEP()) != null && eEP.length == 3 && (eEP[0] > 0 || eEP[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eEP[0] < 1.0f ? 1.0f : eEP[0]) * i;
                        fArr[1] = (eEP[1] < 0.1f ? 0.1f : eEP[1]) * i;
                        eEv.setPathEffect(new DashPathEffect(fArr, eEP[2] * i));
                    }
                    if (c1185a.eEu().eEU() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eEU2 = c1185a.eEu().eEU();
                    if (eEU2 != null) {
                        Path eEx2 = this.pTI.eEx();
                        eEU2.a(eEx2);
                        eEx2.transform(h);
                        canvas.clipPath(eEx2);
                    }
                    canvas.drawPath(eEw, eEv);
                    if (c1185a.eEu().eEU() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float i(Matrix matrix) {
        matrix.getValues(this.pTL);
        if (this.pTL[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pTL[0];
        double d2 = this.pTL[3];
        double d3 = this.pTL[1];
        double d4 = this.pTL[4];
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
        return eEt().eEZ() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1185a c1185a, Canvas canvas, int i) {
        String imageKey = c1185a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pSI.eEd().get(imageKey);
            if (cVar != null) {
                Matrix h = h(c1185a.eEu().eEG());
                canvas.save();
                canvas.concat(h);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pSI.eEe().get(imageKey);
            if (dVar != null) {
                Matrix h2 = h(c1185a.eEu().eEG());
                canvas.save();
                canvas.concat(h2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1185a.eEu().eET().getWidth()), Integer.valueOf((int) c1185a.eEu().eET().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1186b {
        private final Paint pTP = new Paint();
        private final Path pTQ = new Path();
        private final Path pTR = new Path();
        private final Matrix pTS = new Matrix();
        private final Matrix pTT = new Matrix();

        public final Paint eEv() {
            this.pTP.reset();
            return this.pTP;
        }

        public final Path eEw() {
            this.pTQ.reset();
            return this.pTQ;
        }

        public final Path eEx() {
            this.pTR.reset();
            return this.pTR;
        }

        public final Matrix eEy() {
            this.pTS.reset();
            return this.pTS;
        }

        public final Matrix eEz() {
            this.pTT.reset();
            return this.pTT;
        }
    }

    @e
    /* loaded from: classes6.dex */
    public static final class a {
        private int pTM;
        private int pTN;
        private final HashMap<SVGAVideoShapeEntity, Path> pTO = new HashMap<>();

        public final void aD(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.pTM != canvas.getWidth() || this.pTN != canvas.getHeight()) {
                this.pTO.clear();
            }
            this.pTM = canvas.getWidth();
            this.pTN = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pTO.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eEI());
                this.pTO.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pTO.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eMM();
            }
            return path2;
        }
    }
}
