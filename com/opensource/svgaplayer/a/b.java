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
    private final c nka;
    private final C0726b nlb;
    private final HashMap<String, Bitmap> nlc;
    private final a nld;
    private final float[] nle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nka = cVar;
        this.nlb = new C0726b();
        this.nlc = new HashMap<>();
        this.nld = new a();
        this.nle = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nld.ah(canvas);
        for (a.C0725a c0725a : Nf(i)) {
            a(c0725a, canvas, i);
        }
        Ng(i);
    }

    private final void Ng(int i) {
        SoundPool dDP;
        Integer dEc;
        for (com.opensource.svgaplayer.entities.a aVar : dDx().dDO()) {
            if (aVar.dEa() == i && (dDP = dDx().dDP()) != null && (dEc = aVar.dEc()) != null) {
                aVar.s(Integer.valueOf(dDP.play(dEc.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dEb() <= i) {
                Integer dEd = aVar.dEd();
                if (dEd != null) {
                    int intValue = dEd.intValue();
                    SoundPool dDP2 = dDx().dDP();
                    if (dDP2 != null) {
                        dDP2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dDY = this.nlb.dDY();
        dDY.postScale(dDS().dEx(), dDS().dEy());
        dDY.postTranslate(dDS().dEv(), dDS().dEw());
        dDY.preConcat(matrix);
        return dDY;
    }

    private final void a(a.C0725a c0725a, Canvas canvas, int i) {
        a(c0725a, canvas);
        b(c0725a, canvas);
        b(c0725a, canvas, i);
    }

    private final void a(a.C0725a c0725a, Canvas canvas) {
        String dDT = c0725a.dDT();
        if (dDT != null && !q.h(this.nka.dDy().get(dDT), true)) {
            Bitmap bitmap = this.nka.dDz().get(dDT);
            if (bitmap == null) {
                bitmap = dDx().dDQ().get(dDT);
            }
            if (bitmap != null) {
                Matrix c = c(c0725a.dDU().dEg());
                Paint dDV = this.nlb.dDV();
                dDV.setAntiAlias(dDx().dDK());
                dDV.setFilterBitmap(dDx().dDK());
                dDV.setAlpha((int) (c0725a.dDU().dEs() * 255));
                if (c0725a.dDU().dEu() != null) {
                    com.opensource.svgaplayer.entities.b dEu = c0725a.dDU().dEu();
                    if (dEu != null) {
                        canvas.save();
                        dDV.reset();
                        Path dDW = this.nlb.dDW();
                        dEu.c(dDW);
                        dDW.transform(c);
                        canvas.clipPath(dDW);
                        c.preScale((float) (c0725a.dDU().dEt().getWidth() / bitmap.getWidth()), (float) (c0725a.dDU().dEt().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dDV);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0725a.dDU().dEt().getWidth() / bitmap.getWidth()), (float) (c0725a.dDU().dEt().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dDV);
                }
                a(canvas, bitmap, c0725a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0725a c0725a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nka.dDF()) {
            this.nlc.clear();
            this.nka.wr(false);
        }
        String dDT = c0725a.dDT();
        if (dDT != null) {
            Bitmap bitmap3 = null;
            String str = this.nka.dDA().get(dDT);
            if (str != null) {
                TextPaint textPaint = this.nka.dDB().get(dDT);
                if (textPaint != null && (bitmap3 = this.nlc.get(dDT)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nlc;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dDT, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nka.dDC().get(dDT);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nlc.get(dDT);
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
                    HashMap<String, Bitmap> hashMap2 = this.nlc;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dDT, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dDV = this.nlb.dDV();
                dDV.setAntiAlias(dDx().dDK());
                if (c0725a.dDU().dEu() != null) {
                    com.opensource.svgaplayer.entities.b dEu = c0725a.dDU().dEu();
                    if (dEu != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dDV.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dDW = this.nlb.dDW();
                        dEu.c(dDW);
                        canvas.drawPath(dDW, dDV);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dDV.setFilterBitmap(dDx().dDK());
                canvas.drawBitmap(bitmap2, matrix, dDV);
            }
        }
    }

    private final void b(a.C0725a c0725a, Canvas canvas) {
        float[] dEp;
        String dEn;
        String dEm;
        int dEk;
        Matrix c = c(c0725a.dDU().dEg());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0725a.dDU().ci()) {
            sVGAVideoShapeEntity.dEj();
            if (sVGAVideoShapeEntity.dEi() != null) {
                Paint dDV = this.nlb.dDV();
                dDV.reset();
                dDV.setAntiAlias(dDx().dDK());
                dDV.setAlpha((int) (c0725a.dDU().dEs() * 255));
                Path dDW = this.nlb.dDW();
                dDW.reset();
                dDW.addPath(this.nld.a(sVGAVideoShapeEntity));
                Matrix dDZ = this.nlb.dDZ();
                dDZ.reset();
                Matrix dEg = sVGAVideoShapeEntity.dEg();
                if (dEg != null) {
                    dDZ.postConcat(dEg);
                }
                dDZ.postConcat(c);
                dDW.transform(dDZ);
                SVGAVideoShapeEntity.a dEf = sVGAVideoShapeEntity.dEf();
                if (dEf != null && (dEk = dEf.dEk()) != 0) {
                    dDV.setStyle(Paint.Style.FILL);
                    dDV.setColor(dEk);
                    dDV.setAlpha(Math.min(255, Math.max(0, (int) (c0725a.dDU().dEs() * 255))));
                    if (c0725a.dDU().dEu() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dEu = c0725a.dDU().dEu();
                    if (dEu != null) {
                        Path dDX = this.nlb.dDX();
                        dEu.c(dDX);
                        dDX.transform(c);
                        canvas.clipPath(dDX);
                    }
                    canvas.drawPath(dDW, dDV);
                    if (c0725a.dDU().dEu() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dEf2 = sVGAVideoShapeEntity.dEf();
                if (dEf2 != null && dEf2.getStrokeWidth() > 0) {
                    dDV.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dEf3 = sVGAVideoShapeEntity.dEf();
                    if (dEf3 != null) {
                        dDV.setColor(dEf3.dEl());
                        dDV.setAlpha(Math.min(255, Math.max(0, (int) (c0725a.dDU().dEs() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dEf4 = sVGAVideoShapeEntity.dEf();
                    if (dEf4 != null) {
                        dDV.setStrokeWidth(dEf4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dEf5 = sVGAVideoShapeEntity.dEf();
                    if (dEf5 != null && (dEm = dEf5.dEm()) != null) {
                        if (l.E(dEm, "butt", true)) {
                            dDV.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.E(dEm, "round", true)) {
                            dDV.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.E(dEm, "square", true)) {
                            dDV.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dEf6 = sVGAVideoShapeEntity.dEf();
                    if (dEf6 != null && (dEn = dEf6.dEn()) != null) {
                        if (l.E(dEn, "miter", true)) {
                            dDV.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.E(dEn, "round", true)) {
                            dDV.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.E(dEn, "bevel", true)) {
                            dDV.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dEf7 = sVGAVideoShapeEntity.dEf();
                    if (dEf7 != null) {
                        dDV.setStrokeMiter(dEf7.dEo() * d);
                    }
                    SVGAVideoShapeEntity.a dEf8 = sVGAVideoShapeEntity.dEf();
                    if (dEf8 != null && (dEp = dEf8.dEp()) != null && dEp.length == 3 && (dEp[0] > 0 || dEp[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dEp[0] < 1.0f ? 1.0f : dEp[0]) * d;
                        fArr[1] = (dEp[1] < 0.1f ? 0.1f : dEp[1]) * d;
                        dDV.setPathEffect(new DashPathEffect(fArr, dEp[2] * d));
                    }
                    if (c0725a.dDU().dEu() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dEu2 = c0725a.dDU().dEu();
                    if (dEu2 != null) {
                        Path dDX2 = this.nlb.dDX();
                        dEu2.c(dDX2);
                        dDX2.transform(c);
                        canvas.clipPath(dDX2);
                    }
                    canvas.drawPath(dDW, dDV);
                    if (c0725a.dDU().dEu() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nle);
        if (this.nle[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nle[0];
        double d2 = this.nle[3];
        double d3 = this.nle[1];
        double d4 = this.nle[4];
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
        return dDS().dEz() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0725a c0725a, Canvas canvas, int i) {
        String dDT = c0725a.dDT();
        if (dDT != null) {
            m<Canvas, Integer, Boolean> mVar = this.nka.dDD().get(dDT);
            if (mVar != null) {
                Matrix c = c(c0725a.dDU().dEg());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nka.dDE().get(dDT);
            if (rVar != null) {
                Matrix c2 = c(c0725a.dDU().dEg());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0725a.dDU().dEt().getWidth()), Integer.valueOf((int) c0725a.dDU().dEt().getHeight()));
                canvas.restore();
            }
        }
    }

    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0726b {
        private final Paint nli = new Paint();
        private final Path nlj = new Path();
        private final Path nlk = new Path();
        private final Matrix nll = new Matrix();
        private final Matrix nlm = new Matrix();

        public final Paint dDV() {
            this.nli.reset();
            return this.nli;
        }

        public final Path dDW() {
            this.nlj.reset();
            return this.nlj;
        }

        public final Path dDX() {
            this.nlk.reset();
            return this.nlk;
        }

        public final Matrix dDY() {
            this.nll.reset();
            return this.nll;
        }

        public final Matrix dDZ() {
            this.nlm.reset();
            return this.nlm;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private int nlf;
        private int nlg;
        private final HashMap<SVGAVideoShapeEntity, Path> nlh = new HashMap<>();

        public final void ah(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.nlf != canvas.getWidth() || this.nlg != canvas.getHeight()) {
                this.nlh.clear();
            }
            this.nlf = canvas.getWidth();
            this.nlg = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.nlh.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dEi());
                this.nlh.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nlh.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dJm();
            }
            return path2;
        }
    }
}
