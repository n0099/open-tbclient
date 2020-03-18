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
    private final c nmB;
    private final C0735b nnC;
    private final HashMap<String, Bitmap> nnD;
    private final a nnE;
    private final float[] nnF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nmB = cVar;
        this.nnC = new C0735b();
        this.nnD = new HashMap<>();
        this.nnE = new a();
        this.nnF = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nnE.ai(canvas);
        for (a.C0734a c0734a : No(i)) {
            a(c0734a, canvas, i);
        }
        Np(i);
    }

    private final void Np(int i) {
        SoundPool dFz;
        Integer dFM;
        for (com.opensource.svgaplayer.entities.a aVar : dFh().dFy()) {
            if (aVar.dFK() == i && (dFz = dFh().dFz()) != null && (dFM = aVar.dFM()) != null) {
                aVar.s(Integer.valueOf(dFz.play(dFM.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dFL() <= i) {
                Integer dFN = aVar.dFN();
                if (dFN != null) {
                    int intValue = dFN.intValue();
                    SoundPool dFz2 = dFh().dFz();
                    if (dFz2 != null) {
                        dFz2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dFI = this.nnC.dFI();
        dFI.postScale(dFC().dGh(), dFC().dGi());
        dFI.postTranslate(dFC().dGf(), dFC().dGg());
        dFI.preConcat(matrix);
        return dFI;
    }

    private final void a(a.C0734a c0734a, Canvas canvas, int i) {
        a(c0734a, canvas);
        b(c0734a, canvas);
        b(c0734a, canvas, i);
    }

    private final void a(a.C0734a c0734a, Canvas canvas) {
        String dFD = c0734a.dFD();
        if (dFD != null && !q.h(this.nmB.dFi().get(dFD), true)) {
            Bitmap bitmap = this.nmB.dFj().get(dFD);
            if (bitmap == null) {
                bitmap = dFh().dFA().get(dFD);
            }
            if (bitmap != null) {
                Matrix c = c(c0734a.dFE().dFQ());
                Paint dFF = this.nnC.dFF();
                dFF.setAntiAlias(dFh().dFu());
                dFF.setFilterBitmap(dFh().dFu());
                dFF.setAlpha((int) (c0734a.dFE().dGc() * 255));
                if (c0734a.dFE().dGe() != null) {
                    com.opensource.svgaplayer.entities.b dGe = c0734a.dFE().dGe();
                    if (dGe != null) {
                        canvas.save();
                        dFF.reset();
                        Path dFG = this.nnC.dFG();
                        dGe.c(dFG);
                        dFG.transform(c);
                        canvas.clipPath(dFG);
                        c.preScale((float) (c0734a.dFE().dGd().getWidth() / bitmap.getWidth()), (float) (c0734a.dFE().dGd().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dFF);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0734a.dFE().dGd().getWidth() / bitmap.getWidth()), (float) (c0734a.dFE().dGd().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dFF);
                }
                a(canvas, bitmap, c0734a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0734a c0734a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nmB.dFp()) {
            this.nnD.clear();
            this.nmB.wD(false);
        }
        String dFD = c0734a.dFD();
        if (dFD != null) {
            Bitmap bitmap3 = null;
            String str = this.nmB.dFk().get(dFD);
            if (str != null) {
                TextPaint textPaint = this.nmB.dFl().get(dFD);
                if (textPaint != null && (bitmap3 = this.nnD.get(dFD)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nnD;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dFD, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nmB.dFm().get(dFD);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nnD.get(dFD);
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
                    HashMap<String, Bitmap> hashMap2 = this.nnD;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dFD, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dFF = this.nnC.dFF();
                dFF.setAntiAlias(dFh().dFu());
                if (c0734a.dFE().dGe() != null) {
                    com.opensource.svgaplayer.entities.b dGe = c0734a.dFE().dGe();
                    if (dGe != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dFF.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dFG = this.nnC.dFG();
                        dGe.c(dFG);
                        canvas.drawPath(dFG, dFF);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dFF.setFilterBitmap(dFh().dFu());
                canvas.drawBitmap(bitmap2, matrix, dFF);
            }
        }
    }

    private final void b(a.C0734a c0734a, Canvas canvas) {
        float[] dFZ;
        String dFX;
        String dFW;
        int dFU;
        Matrix c = c(c0734a.dFE().dFQ());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0734a.dFE().cj()) {
            sVGAVideoShapeEntity.dFT();
            if (sVGAVideoShapeEntity.dFS() != null) {
                Paint dFF = this.nnC.dFF();
                dFF.reset();
                dFF.setAntiAlias(dFh().dFu());
                dFF.setAlpha((int) (c0734a.dFE().dGc() * 255));
                Path dFG = this.nnC.dFG();
                dFG.reset();
                dFG.addPath(this.nnE.a(sVGAVideoShapeEntity));
                Matrix dFJ = this.nnC.dFJ();
                dFJ.reset();
                Matrix dFQ = sVGAVideoShapeEntity.dFQ();
                if (dFQ != null) {
                    dFJ.postConcat(dFQ);
                }
                dFJ.postConcat(c);
                dFG.transform(dFJ);
                SVGAVideoShapeEntity.a dFP = sVGAVideoShapeEntity.dFP();
                if (dFP != null && (dFU = dFP.dFU()) != 0) {
                    dFF.setStyle(Paint.Style.FILL);
                    dFF.setColor(dFU);
                    dFF.setAlpha(Math.min(255, Math.max(0, (int) (c0734a.dFE().dGc() * 255))));
                    if (c0734a.dFE().dGe() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dGe = c0734a.dFE().dGe();
                    if (dGe != null) {
                        Path dFH = this.nnC.dFH();
                        dGe.c(dFH);
                        dFH.transform(c);
                        canvas.clipPath(dFH);
                    }
                    canvas.drawPath(dFG, dFF);
                    if (c0734a.dFE().dGe() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dFP2 = sVGAVideoShapeEntity.dFP();
                if (dFP2 != null && dFP2.getStrokeWidth() > 0) {
                    dFF.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dFP3 = sVGAVideoShapeEntity.dFP();
                    if (dFP3 != null) {
                        dFF.setColor(dFP3.dFV());
                        dFF.setAlpha(Math.min(255, Math.max(0, (int) (c0734a.dFE().dGc() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dFP4 = sVGAVideoShapeEntity.dFP();
                    if (dFP4 != null) {
                        dFF.setStrokeWidth(dFP4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dFP5 = sVGAVideoShapeEntity.dFP();
                    if (dFP5 != null && (dFW = dFP5.dFW()) != null) {
                        if (l.F(dFW, "butt", true)) {
                            dFF.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dFW, "round", true)) {
                            dFF.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dFW, "square", true)) {
                            dFF.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dFP6 = sVGAVideoShapeEntity.dFP();
                    if (dFP6 != null && (dFX = dFP6.dFX()) != null) {
                        if (l.F(dFX, "miter", true)) {
                            dFF.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dFX, "round", true)) {
                            dFF.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dFX, "bevel", true)) {
                            dFF.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dFP7 = sVGAVideoShapeEntity.dFP();
                    if (dFP7 != null) {
                        dFF.setStrokeMiter(dFP7.dFY() * d);
                    }
                    SVGAVideoShapeEntity.a dFP8 = sVGAVideoShapeEntity.dFP();
                    if (dFP8 != null && (dFZ = dFP8.dFZ()) != null && dFZ.length == 3 && (dFZ[0] > 0 || dFZ[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dFZ[0] < 1.0f ? 1.0f : dFZ[0]) * d;
                        fArr[1] = (dFZ[1] < 0.1f ? 0.1f : dFZ[1]) * d;
                        dFF.setPathEffect(new DashPathEffect(fArr, dFZ[2] * d));
                    }
                    if (c0734a.dFE().dGe() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dGe2 = c0734a.dFE().dGe();
                    if (dGe2 != null) {
                        Path dFH2 = this.nnC.dFH();
                        dGe2.c(dFH2);
                        dFH2.transform(c);
                        canvas.clipPath(dFH2);
                    }
                    canvas.drawPath(dFG, dFF);
                    if (c0734a.dFE().dGe() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nnF);
        if (this.nnF[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nnF[0];
        double d2 = this.nnF[3];
        double d3 = this.nnF[1];
        double d4 = this.nnF[4];
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
        return dFC().dGj() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0734a c0734a, Canvas canvas, int i) {
        String dFD = c0734a.dFD();
        if (dFD != null) {
            m<Canvas, Integer, Boolean> mVar = this.nmB.dFn().get(dFD);
            if (mVar != null) {
                Matrix c = c(c0734a.dFE().dFQ());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nmB.dFo().get(dFD);
            if (rVar != null) {
                Matrix c2 = c(c0734a.dFE().dFQ());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0734a.dFE().dGd().getWidth()), Integer.valueOf((int) c0734a.dFE().dGd().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0735b {
        private final Paint nnJ = new Paint();
        private final Path nnK = new Path();
        private final Path nnL = new Path();
        private final Matrix nnM = new Matrix();
        private final Matrix nnN = new Matrix();

        public final Paint dFF() {
            this.nnJ.reset();
            return this.nnJ;
        }

        public final Path dFG() {
            this.nnK.reset();
            return this.nnK;
        }

        public final Path dFH() {
            this.nnL.reset();
            return this.nnL;
        }

        public final Matrix dFI() {
            this.nnM.reset();
            return this.nnM;
        }

        public final Matrix dFJ() {
            this.nnN.reset();
            return this.nnN;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nnG;
        private int nnH;
        private final HashMap<SVGAVideoShapeEntity, Path> nnI = new HashMap<>();

        public final void ai(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.nnG != canvas.getWidth() || this.nnH != canvas.getHeight()) {
                this.nnI.clear();
            }
            this.nnG = canvas.getWidth();
            this.nnH = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.nnI.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dFS());
                this.nnI.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nnI.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dKW();
            }
            return path2;
        }
    }
}
