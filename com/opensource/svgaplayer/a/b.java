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
import kotlin.jvm.a.m;
import kotlin.jvm.a.r;
import kotlin.jvm.internal.q;
import kotlin.text.l;
/* loaded from: classes.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c njV;
    private final C0726b nkW;
    private final HashMap<String, Bitmap> nkX;
    private final a nkY;
    private final float[] nkZ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.njV = cVar;
        this.nkW = new C0726b();
        this.nkX = new HashMap<>();
        this.nkY = new a();
        this.nkZ = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nkY.ah(canvas);
        for (a.C0725a c0725a : Nf(i)) {
            a(c0725a, canvas, i);
        }
        Ng(i);
    }

    private final void Ng(int i) {
        SoundPool dDN;
        Integer dEa;
        for (com.opensource.svgaplayer.entities.a aVar : dDv().dDM()) {
            if (aVar.dDY() == i && (dDN = dDv().dDN()) != null && (dEa = aVar.dEa()) != null) {
                aVar.s(Integer.valueOf(dDN.play(dEa.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dDZ() <= i) {
                Integer dEb = aVar.dEb();
                if (dEb != null) {
                    int intValue = dEb.intValue();
                    SoundPool dDN2 = dDv().dDN();
                    if (dDN2 != null) {
                        dDN2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dDW = this.nkW.dDW();
        dDW.postScale(dDQ().dEv(), dDQ().dEw());
        dDW.postTranslate(dDQ().dEt(), dDQ().dEu());
        dDW.preConcat(matrix);
        return dDW;
    }

    private final void a(a.C0725a c0725a, Canvas canvas, int i) {
        a(c0725a, canvas);
        b(c0725a, canvas);
        b(c0725a, canvas, i);
    }

    private final void a(a.C0725a c0725a, Canvas canvas) {
        String dDR = c0725a.dDR();
        if (dDR != null && !q.h(this.njV.dDw().get(dDR), true)) {
            Bitmap bitmap = this.njV.dDx().get(dDR);
            if (bitmap == null) {
                bitmap = dDv().dDO().get(dDR);
            }
            if (bitmap != null) {
                Matrix c = c(c0725a.dDS().dEe());
                Paint dDT = this.nkW.dDT();
                dDT.setAntiAlias(dDv().dDI());
                dDT.setFilterBitmap(dDv().dDI());
                dDT.setAlpha((int) (c0725a.dDS().dEq() * 255));
                if (c0725a.dDS().dEs() != null) {
                    com.opensource.svgaplayer.entities.b dEs = c0725a.dDS().dEs();
                    if (dEs != null) {
                        canvas.save();
                        dDT.reset();
                        Path dDU = this.nkW.dDU();
                        dEs.c(dDU);
                        dDU.transform(c);
                        canvas.clipPath(dDU);
                        c.preScale((float) (c0725a.dDS().dEr().getWidth() / bitmap.getWidth()), (float) (c0725a.dDS().dEr().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dDT);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0725a.dDS().dEr().getWidth() / bitmap.getWidth()), (float) (c0725a.dDS().dEr().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dDT);
                }
                a(canvas, bitmap, c0725a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0725a c0725a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.njV.dDD()) {
            this.nkX.clear();
            this.njV.wr(false);
        }
        String dDR = c0725a.dDR();
        if (dDR != null) {
            Bitmap bitmap3 = null;
            String str = this.njV.dDy().get(dDR);
            if (str != null) {
                TextPaint textPaint = this.njV.dDz().get(dDR);
                if (textPaint != null && (bitmap3 = this.nkX.get(dDR)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nkX;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dDR, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.njV.dDA().get(dDR);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nkX.get(dDR);
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
                    HashMap<String, Bitmap> hashMap2 = this.nkX;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dDR, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dDT = this.nkW.dDT();
                dDT.setAntiAlias(dDv().dDI());
                if (c0725a.dDS().dEs() != null) {
                    com.opensource.svgaplayer.entities.b dEs = c0725a.dDS().dEs();
                    if (dEs != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dDT.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dDU = this.nkW.dDU();
                        dEs.c(dDU);
                        canvas.drawPath(dDU, dDT);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dDT.setFilterBitmap(dDv().dDI());
                canvas.drawBitmap(bitmap2, matrix, dDT);
            }
        }
    }

    private final void b(a.C0725a c0725a, Canvas canvas) {
        float[] dEn;
        String dEl;
        String dEk;
        int dEi;
        Matrix c = c(c0725a.dDS().dEe());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0725a.dDS().ci()) {
            sVGAVideoShapeEntity.dEh();
            if (sVGAVideoShapeEntity.dEg() != null) {
                Paint dDT = this.nkW.dDT();
                dDT.reset();
                dDT.setAntiAlias(dDv().dDI());
                dDT.setAlpha((int) (c0725a.dDS().dEq() * 255));
                Path dDU = this.nkW.dDU();
                dDU.reset();
                dDU.addPath(this.nkY.a(sVGAVideoShapeEntity));
                Matrix dDX = this.nkW.dDX();
                dDX.reset();
                Matrix dEe = sVGAVideoShapeEntity.dEe();
                if (dEe != null) {
                    dDX.postConcat(dEe);
                }
                dDX.postConcat(c);
                dDU.transform(dDX);
                SVGAVideoShapeEntity.a dEd = sVGAVideoShapeEntity.dEd();
                if (dEd != null && (dEi = dEd.dEi()) != 0) {
                    dDT.setStyle(Paint.Style.FILL);
                    dDT.setColor(dEi);
                    dDT.setAlpha(Math.min(255, Math.max(0, (int) (c0725a.dDS().dEq() * 255))));
                    if (c0725a.dDS().dEs() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dEs = c0725a.dDS().dEs();
                    if (dEs != null) {
                        Path dDV = this.nkW.dDV();
                        dEs.c(dDV);
                        dDV.transform(c);
                        canvas.clipPath(dDV);
                    }
                    canvas.drawPath(dDU, dDT);
                    if (c0725a.dDS().dEs() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dEd2 = sVGAVideoShapeEntity.dEd();
                if (dEd2 != null && dEd2.getStrokeWidth() > 0) {
                    dDT.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dEd3 = sVGAVideoShapeEntity.dEd();
                    if (dEd3 != null) {
                        dDT.setColor(dEd3.dEj());
                        dDT.setAlpha(Math.min(255, Math.max(0, (int) (c0725a.dDS().dEq() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dEd4 = sVGAVideoShapeEntity.dEd();
                    if (dEd4 != null) {
                        dDT.setStrokeWidth(dEd4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dEd5 = sVGAVideoShapeEntity.dEd();
                    if (dEd5 != null && (dEk = dEd5.dEk()) != null) {
                        if (l.E(dEk, "butt", true)) {
                            dDT.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.E(dEk, "round", true)) {
                            dDT.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.E(dEk, "square", true)) {
                            dDT.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dEd6 = sVGAVideoShapeEntity.dEd();
                    if (dEd6 != null && (dEl = dEd6.dEl()) != null) {
                        if (l.E(dEl, "miter", true)) {
                            dDT.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.E(dEl, "round", true)) {
                            dDT.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.E(dEl, "bevel", true)) {
                            dDT.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dEd7 = sVGAVideoShapeEntity.dEd();
                    if (dEd7 != null) {
                        dDT.setStrokeMiter(dEd7.dEm() * d);
                    }
                    SVGAVideoShapeEntity.a dEd8 = sVGAVideoShapeEntity.dEd();
                    if (dEd8 != null && (dEn = dEd8.dEn()) != null && dEn.length == 3 && (dEn[0] > 0 || dEn[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dEn[0] < 1.0f ? 1.0f : dEn[0]) * d;
                        fArr[1] = (dEn[1] < 0.1f ? 0.1f : dEn[1]) * d;
                        dDT.setPathEffect(new DashPathEffect(fArr, dEn[2] * d));
                    }
                    if (c0725a.dDS().dEs() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dEs2 = c0725a.dDS().dEs();
                    if (dEs2 != null) {
                        Path dDV2 = this.nkW.dDV();
                        dEs2.c(dDV2);
                        dDV2.transform(c);
                        canvas.clipPath(dDV2);
                    }
                    canvas.drawPath(dDU, dDT);
                    if (c0725a.dDS().dEs() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nkZ);
        if (this.nkZ[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nkZ[0];
        double d2 = this.nkZ[3];
        double d3 = this.nkZ[1];
        double d4 = this.nkZ[4];
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
        return dDQ().dEx() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0725a c0725a, Canvas canvas, int i) {
        String dDR = c0725a.dDR();
        if (dDR != null) {
            m<Canvas, Integer, Boolean> mVar = this.njV.dDB().get(dDR);
            if (mVar != null) {
                Matrix c = c(c0725a.dDS().dEe());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.njV.dDC().get(dDR);
            if (rVar != null) {
                Matrix c2 = c(c0725a.dDS().dEe());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0725a.dDS().dEr().getWidth()), Integer.valueOf((int) c0725a.dDS().dEr().getHeight()));
                canvas.restore();
            }
        }
    }

    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0726b {
        private final Paint nld = new Paint();
        private final Path nle = new Path();
        private final Path nlf = new Path();
        private final Matrix nlg = new Matrix();
        private final Matrix nlh = new Matrix();

        public final Paint dDT() {
            this.nld.reset();
            return this.nld;
        }

        public final Path dDU() {
            this.nle.reset();
            return this.nle;
        }

        public final Path dDV() {
            this.nlf.reset();
            return this.nlf;
        }

        public final Matrix dDW() {
            this.nlg.reset();
            return this.nlg;
        }

        public final Matrix dDX() {
            this.nlh.reset();
            return this.nlh;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private int nla;
        private int nlb;
        private final HashMap<SVGAVideoShapeEntity, Path> nlc = new HashMap<>();

        public final void ah(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.nla != canvas.getWidth() || this.nlb != canvas.getHeight()) {
                this.nlc.clear();
            }
            this.nla = canvas.getWidth();
            this.nlb = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.nlc.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dEg());
                this.nlc.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nlc.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dJk();
            }
            return path2;
        }
    }
}
