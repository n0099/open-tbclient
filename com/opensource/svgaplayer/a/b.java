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
    private final c neC;
    private final C0839b nfD;
    private final HashMap<String, Bitmap> nfE;
    private final a nfF;
    private final float[] nfG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.neC = cVar;
        this.nfD = new C0839b();
        this.nfE = new HashMap<>();
        this.nfF = new a();
        this.nfG = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nfF.af(canvas);
        for (a.C0838a c0838a : Jv(i)) {
            a(c0838a, canvas, i);
        }
        Jw(i);
    }

    private final void Jw(int i) {
        SoundPool dHg;
        Integer dHt;
        for (com.opensource.svgaplayer.entities.a aVar : dGN().dHf()) {
            if (aVar.dHr() == i && (dHg = dGN().dHg()) != null && (dHt = aVar.dHt()) != null) {
                aVar.s(Integer.valueOf(dHg.play(dHt.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dHs() <= i) {
                Integer dHu = aVar.dHu();
                if (dHu != null) {
                    int intValue = dHu.intValue();
                    SoundPool dHg2 = dGN().dHg();
                    if (dHg2 != null) {
                        dHg2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dHp = this.nfD.dHp();
        dHp.postScale(dHj().dHO(), dHj().dHP());
        dHp.postTranslate(dHj().dHM(), dHj().dHN());
        dHp.preConcat(matrix);
        return dHp;
    }

    private final void a(a.C0838a c0838a, Canvas canvas, int i) {
        a(c0838a, canvas);
        b(c0838a, canvas);
        b(c0838a, canvas, i);
    }

    private final void a(a.C0838a c0838a, Canvas canvas) {
        String dHk = c0838a.dHk();
        if (dHk != null && !q.l((Object) this.neC.dGO().get(dHk), (Object) true)) {
            Bitmap bitmap = this.neC.dGP().get(dHk);
            if (bitmap == null) {
                bitmap = dGN().dHh().get(dHk);
            }
            if (bitmap != null) {
                Matrix c = c(c0838a.dHl().dHx());
                Paint dHm = this.nfD.dHm();
                dHm.setAntiAlias(dGN().dHb());
                dHm.setFilterBitmap(dGN().dHb());
                dHm.setAlpha((int) (c0838a.dHl().dHJ() * 255));
                if (c0838a.dHl().dHL() != null) {
                    com.opensource.svgaplayer.entities.b dHL = c0838a.dHl().dHL();
                    if (dHL != null) {
                        canvas.save();
                        dHm.reset();
                        Path dHn = this.nfD.dHn();
                        dHL.a(dHn);
                        dHn.transform(c);
                        canvas.clipPath(dHn);
                        c.preScale((float) (c0838a.dHl().dHK().getWidth() / bitmap.getWidth()), (float) (c0838a.dHl().dHK().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dHm);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0838a.dHl().dHK().getWidth() / bitmap.getWidth()), (float) (c0838a.dHl().dHK().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dHm);
                }
                a(canvas, bitmap, c0838a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0838a c0838a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.neC.dGV()) {
            this.nfE.clear();
            this.neC.wL(false);
        }
        String dHk = c0838a.dHk();
        if (dHk != null) {
            Bitmap bitmap3 = null;
            String str = this.neC.dGQ().get(dHk);
            if (str != null) {
                TextPaint textPaint = this.neC.dGR().get(dHk);
                if (textPaint != null && (bitmap3 = this.nfE.get(dHk)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nfE;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dHk, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.neC.dGS().get(dHk);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nfE.get(dHk);
                if (bitmap4 == null) {
                    q.l((Object) staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    q.l((Object) paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.nfE;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dHk, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dHm = this.nfD.dHm();
                dHm.setAntiAlias(dGN().dHb());
                if (c0838a.dHl().dHL() != null) {
                    com.opensource.svgaplayer.entities.b dHL = c0838a.dHl().dHL();
                    if (dHL != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dHm.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dHn = this.nfD.dHn();
                        dHL.a(dHn);
                        canvas.drawPath(dHn, dHm);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dHm.setFilterBitmap(dGN().dHb());
                canvas.drawBitmap(bitmap2, matrix, dHm);
            }
        }
    }

    private final void b(a.C0838a c0838a, Canvas canvas) {
        float[] dHG;
        String dHE;
        String dHD;
        int dHB;
        Matrix c = c(c0838a.dHl().dHx());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0838a.dHl().hG()) {
            sVGAVideoShapeEntity.dHA();
            if (sVGAVideoShapeEntity.dHz() != null) {
                Paint dHm = this.nfD.dHm();
                dHm.reset();
                dHm.setAntiAlias(dGN().dHb());
                dHm.setAlpha((int) (c0838a.dHl().dHJ() * 255));
                Path dHn = this.nfD.dHn();
                dHn.reset();
                dHn.addPath(this.nfF.a(sVGAVideoShapeEntity));
                Matrix dHq = this.nfD.dHq();
                dHq.reset();
                Matrix dHx = sVGAVideoShapeEntity.dHx();
                if (dHx != null) {
                    dHq.postConcat(dHx);
                }
                dHq.postConcat(c);
                dHn.transform(dHq);
                SVGAVideoShapeEntity.a dHw = sVGAVideoShapeEntity.dHw();
                if (dHw != null && (dHB = dHw.dHB()) != 0) {
                    dHm.setStyle(Paint.Style.FILL);
                    dHm.setColor(dHB);
                    dHm.setAlpha(Math.min(255, Math.max(0, (int) (c0838a.dHl().dHJ() * 255))));
                    if (c0838a.dHl().dHL() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dHL = c0838a.dHl().dHL();
                    if (dHL != null) {
                        Path dHo = this.nfD.dHo();
                        dHL.a(dHo);
                        dHo.transform(c);
                        canvas.clipPath(dHo);
                    }
                    canvas.drawPath(dHn, dHm);
                    if (c0838a.dHl().dHL() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dHw2 = sVGAVideoShapeEntity.dHw();
                if (dHw2 != null && dHw2.getStrokeWidth() > 0) {
                    dHm.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dHw3 = sVGAVideoShapeEntity.dHw();
                    if (dHw3 != null) {
                        dHm.setColor(dHw3.dHC());
                        dHm.setAlpha(Math.min(255, Math.max(0, (int) (c0838a.dHl().dHJ() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dHw4 = sVGAVideoShapeEntity.dHw();
                    if (dHw4 != null) {
                        dHm.setStrokeWidth(dHw4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dHw5 = sVGAVideoShapeEntity.dHw();
                    if (dHw5 != null && (dHD = dHw5.dHD()) != null) {
                        if (l.H(dHD, "butt", true)) {
                            dHm.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.H(dHD, "round", true)) {
                            dHm.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.H(dHD, "square", true)) {
                            dHm.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dHw6 = sVGAVideoShapeEntity.dHw();
                    if (dHw6 != null && (dHE = dHw6.dHE()) != null) {
                        if (l.H(dHE, "miter", true)) {
                            dHm.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.H(dHE, "round", true)) {
                            dHm.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.H(dHE, "bevel", true)) {
                            dHm.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dHw7 = sVGAVideoShapeEntity.dHw();
                    if (dHw7 != null) {
                        dHm.setStrokeMiter(dHw7.dHF() * d);
                    }
                    SVGAVideoShapeEntity.a dHw8 = sVGAVideoShapeEntity.dHw();
                    if (dHw8 != null && (dHG = dHw8.dHG()) != null && dHG.length == 3 && (dHG[0] > 0 || dHG[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dHG[0] < 1.0f ? 1.0f : dHG[0]) * d;
                        fArr[1] = (dHG[1] < 0.1f ? 0.1f : dHG[1]) * d;
                        dHm.setPathEffect(new DashPathEffect(fArr, dHG[2] * d));
                    }
                    if (c0838a.dHl().dHL() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dHL2 = c0838a.dHl().dHL();
                    if (dHL2 != null) {
                        Path dHo2 = this.nfD.dHo();
                        dHL2.a(dHo2);
                        dHo2.transform(c);
                        canvas.clipPath(dHo2);
                    }
                    canvas.drawPath(dHn, dHm);
                    if (c0838a.dHl().dHL() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nfG);
        if (this.nfG[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nfG[0];
        double d2 = this.nfG[3];
        double d3 = this.nfG[1];
        double d4 = this.nfG[4];
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
        return dHj().dHQ() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0838a c0838a, Canvas canvas, int i) {
        String dHk = c0838a.dHk();
        if (dHk != null) {
            m<Canvas, Integer, Boolean> mVar = this.neC.dGT().get(dHk);
            if (mVar != null) {
                Matrix c = c(c0838a.dHl().dHx());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.neC.dGU().get(dHk);
            if (rVar != null) {
                Matrix c2 = c(c0838a.dHl().dHx());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0838a.dHl().dHK().getWidth()), Integer.valueOf((int) c0838a.dHl().dHK().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0839b {
        private final Paint nfK = new Paint();
        private final Path nfL = new Path();
        private final Path nfM = new Path();
        private final Matrix nfN = new Matrix();
        private final Matrix nfO = new Matrix();

        public final Paint dHm() {
            this.nfK.reset();
            return this.nfK;
        }

        public final Path dHn() {
            this.nfL.reset();
            return this.nfL;
        }

        public final Path dHo() {
            this.nfM.reset();
            return this.nfM;
        }

        public final Matrix dHp() {
            this.nfN.reset();
            return this.nfN;
        }

        public final Matrix dHq() {
            this.nfO.reset();
            return this.nfO;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nfH;
        private int nfI;
        private final HashMap<SVGAVideoShapeEntity, Path> nfJ = new HashMap<>();

        public final void af(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.nfH != canvas.getWidth() || this.nfI != canvas.getHeight()) {
                this.nfJ.clear();
            }
            this.nfH = canvas.getWidth();
            this.nfI = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.nfJ.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dHz());
                this.nfJ.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nfJ.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dMa();
            }
            return path2;
        }
    }
}
