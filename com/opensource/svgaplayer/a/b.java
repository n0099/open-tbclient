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
/* loaded from: classes5.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c pOj;
    private final C1169b pPj;
    private final HashMap<String, Bitmap> pPk;
    private final a pPl;
    private final float[] pPm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pOj = cVar;
        this.pPj = new C1169b();
        this.pPk = new HashMap<>();
        this.pPl = new a();
        this.pPm = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pPl.aD(canvas);
        for (a.C1168a c1168a : Qi(i)) {
            a(c1168a, canvas, i);
        }
        Qj(i);
    }

    private final void Qj(int i) {
        SoundPool eAy;
        Integer eAK;
        for (com.opensource.svgaplayer.entities.a aVar : eAf().eAx()) {
            if (aVar.eAI() == i && (eAy = eAf().eAy()) != null && (eAK = aVar.eAK()) != null) {
                aVar.w(Integer.valueOf(eAy.play(eAK.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eAJ() <= i) {
                Integer eAL = aVar.eAL();
                if (eAL != null) {
                    int intValue = eAL.intValue();
                    SoundPool eAy2 = eAf().eAy();
                    if (eAy2 != null) {
                        eAy2.stop(intValue);
                    }
                }
                aVar.w(null);
            }
        }
    }

    private final Matrix h(Matrix matrix) {
        Matrix eAG = this.pPj.eAG();
        eAG.postScale(eAB().eBg(), eAB().eBh());
        eAG.postTranslate(eAB().eBe(), eAB().eBf());
        eAG.preConcat(matrix);
        return eAG;
    }

    private final void a(a.C1168a c1168a, Canvas canvas, int i) {
        a(c1168a, canvas);
        b(c1168a, canvas);
        b(c1168a, canvas, i);
    }

    private final void a(a.C1168a c1168a, Canvas canvas) {
        String imageKey = c1168a.getImageKey();
        if (imageKey != null && !p.l(this.pOj.eAg().get(imageKey), true)) {
            Bitmap bitmap = this.pOj.eAh().get(imageKey);
            if (bitmap == null) {
                bitmap = eAf().eAz().get(imageKey);
            }
            if (bitmap != null) {
                Matrix h = h(c1168a.eAC().eAO());
                Paint eAD = this.pPj.eAD();
                eAD.setAntiAlias(eAf().eAt());
                eAD.setFilterBitmap(eAf().eAt());
                eAD.setAlpha((int) (c1168a.eAC().eBa() * 255));
                if (c1168a.eAC().eBc() != null) {
                    com.opensource.svgaplayer.entities.b eBc = c1168a.eAC().eBc();
                    if (eBc != null) {
                        canvas.save();
                        eAD.reset();
                        Path eAE = this.pPj.eAE();
                        eBc.a(eAE);
                        eAE.transform(h);
                        canvas.clipPath(eAE);
                        h.preScale((float) (c1168a.eAC().eBb().getWidth() / bitmap.getWidth()), (float) (c1168a.eAC().eBb().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, h, eAD);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    h.preScale((float) (c1168a.eAC().eBb().getWidth() / bitmap.getWidth()), (float) (c1168a.eAC().eBb().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, h, eAD);
                }
                a(canvas, bitmap, c1168a, h);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1168a c1168a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pOj.eAn()) {
            this.pPk.clear();
            this.pOj.Bo(false);
        }
        String imageKey = c1168a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pOj.eAi().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pOj.eAj().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pPk.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pPk;
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
            StaticLayout staticLayout = this.pOj.eAk().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pPk.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.pPk;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint eAD = this.pPj.eAD();
                eAD.setAntiAlias(eAf().eAt());
                if (c1168a.eAC().eBc() != null) {
                    com.opensource.svgaplayer.entities.b eBc = c1168a.eAC().eBc();
                    if (eBc != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        eAD.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eAE = this.pPj.eAE();
                        eBc.a(eAE);
                        canvas.drawPath(eAE, eAD);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                eAD.setFilterBitmap(eAf().eAt());
                canvas.drawBitmap(bitmap2, matrix, eAD);
            }
        }
    }

    private final void b(a.C1168a c1168a, Canvas canvas) {
        float[] eAX;
        String eAV;
        String eAU;
        int eAS;
        Matrix h = h(c1168a.eAC().eAO());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1168a.eAC().iY()) {
            sVGAVideoShapeEntity.eAR();
            if (sVGAVideoShapeEntity.eAQ() != null) {
                Paint eAD = this.pPj.eAD();
                eAD.reset();
                eAD.setAntiAlias(eAf().eAt());
                eAD.setAlpha((int) (c1168a.eAC().eBa() * 255));
                Path eAE = this.pPj.eAE();
                eAE.reset();
                eAE.addPath(this.pPl.a(sVGAVideoShapeEntity));
                Matrix eAH = this.pPj.eAH();
                eAH.reset();
                Matrix eAO = sVGAVideoShapeEntity.eAO();
                if (eAO != null) {
                    eAH.postConcat(eAO);
                }
                eAH.postConcat(h);
                eAE.transform(eAH);
                SVGAVideoShapeEntity.a eAN = sVGAVideoShapeEntity.eAN();
                if (eAN != null && (eAS = eAN.eAS()) != 0) {
                    eAD.setStyle(Paint.Style.FILL);
                    eAD.setColor(eAS);
                    eAD.setAlpha(Math.min(255, Math.max(0, (int) (c1168a.eAC().eBa() * 255))));
                    if (c1168a.eAC().eBc() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eBc = c1168a.eAC().eBc();
                    if (eBc != null) {
                        Path eAF = this.pPj.eAF();
                        eBc.a(eAF);
                        eAF.transform(h);
                        canvas.clipPath(eAF);
                    }
                    canvas.drawPath(eAE, eAD);
                    if (c1168a.eAC().eBc() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eAN2 = sVGAVideoShapeEntity.eAN();
                if (eAN2 != null && eAN2.getStrokeWidth() > 0) {
                    eAD.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eAN3 = sVGAVideoShapeEntity.eAN();
                    if (eAN3 != null) {
                        eAD.setColor(eAN3.eAT());
                        eAD.setAlpha(Math.min(255, Math.max(0, (int) (c1168a.eAC().eBa() * 255))));
                    }
                    float i = i(h);
                    SVGAVideoShapeEntity.a eAN4 = sVGAVideoShapeEntity.eAN();
                    if (eAN4 != null) {
                        eAD.setStrokeWidth(eAN4.getStrokeWidth() * i);
                    }
                    SVGAVideoShapeEntity.a eAN5 = sVGAVideoShapeEntity.eAN();
                    if (eAN5 != null && (eAU = eAN5.eAU()) != null) {
                        if (l.N(eAU, "butt", true)) {
                            eAD.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.N(eAU, "round", true)) {
                            eAD.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.N(eAU, "square", true)) {
                            eAD.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eAN6 = sVGAVideoShapeEntity.eAN();
                    if (eAN6 != null && (eAV = eAN6.eAV()) != null) {
                        if (l.N(eAV, "miter", true)) {
                            eAD.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.N(eAV, "round", true)) {
                            eAD.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.N(eAV, "bevel", true)) {
                            eAD.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eAN7 = sVGAVideoShapeEntity.eAN();
                    if (eAN7 != null) {
                        eAD.setStrokeMiter(eAN7.eAW() * i);
                    }
                    SVGAVideoShapeEntity.a eAN8 = sVGAVideoShapeEntity.eAN();
                    if (eAN8 != null && (eAX = eAN8.eAX()) != null && eAX.length == 3 && (eAX[0] > 0 || eAX[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eAX[0] < 1.0f ? 1.0f : eAX[0]) * i;
                        fArr[1] = (eAX[1] < 0.1f ? 0.1f : eAX[1]) * i;
                        eAD.setPathEffect(new DashPathEffect(fArr, eAX[2] * i));
                    }
                    if (c1168a.eAC().eBc() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eBc2 = c1168a.eAC().eBc();
                    if (eBc2 != null) {
                        Path eAF2 = this.pPj.eAF();
                        eBc2.a(eAF2);
                        eAF2.transform(h);
                        canvas.clipPath(eAF2);
                    }
                    canvas.drawPath(eAE, eAD);
                    if (c1168a.eAC().eBc() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float i(Matrix matrix) {
        matrix.getValues(this.pPm);
        if (this.pPm[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pPm[0];
        double d2 = this.pPm[3];
        double d3 = this.pPm[1];
        double d4 = this.pPm[4];
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
        return eAB().eBi() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1168a c1168a, Canvas canvas, int i) {
        String imageKey = c1168a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pOj.eAl().get(imageKey);
            if (cVar != null) {
                Matrix h = h(c1168a.eAC().eAO());
                canvas.save();
                canvas.concat(h);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pOj.eAm().get(imageKey);
            if (dVar != null) {
                Matrix h2 = h(c1168a.eAC().eAO());
                canvas.save();
                canvas.concat(h2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1168a.eAC().eBb().getWidth()), Integer.valueOf((int) c1168a.eAC().eBb().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1169b {
        private final Paint pPq = new Paint();
        private final Path pPr = new Path();
        private final Path pPs = new Path();
        private final Matrix pPt = new Matrix();
        private final Matrix pPu = new Matrix();

        public final Paint eAD() {
            this.pPq.reset();
            return this.pPq;
        }

        public final Path eAE() {
            this.pPr.reset();
            return this.pPr;
        }

        public final Path eAF() {
            this.pPs.reset();
            return this.pPs;
        }

        public final Matrix eAG() {
            this.pPt.reset();
            return this.pPt;
        }

        public final Matrix eAH() {
            this.pPu.reset();
            return this.pPu;
        }
    }

    @e
    /* loaded from: classes5.dex */
    public static final class a {
        private int pPn;
        private int pPo;
        private final HashMap<SVGAVideoShapeEntity, Path> pPp = new HashMap<>();

        public final void aD(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.pPn != canvas.getWidth() || this.pPo != canvas.getHeight()) {
                this.pPp.clear();
            }
            this.pPn = canvas.getWidth();
            this.pPo = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pPp.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eAQ());
                this.pPp.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pPp.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eIW();
            }
            return path2;
        }
    }
}
