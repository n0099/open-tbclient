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
    private final c ndr;
    private final C0838b nes;
    private final HashMap<String, Bitmap> neu;
    private final a nev;

    /* renamed from: new  reason: not valid java name */
    private final float[] f4new;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.ndr = cVar;
        this.nes = new C0838b();
        this.neu = new HashMap<>();
        this.nev = new a();
        this.f4new = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nev.af(canvas);
        for (a.C0837a c0837a : Jt(i)) {
            a(c0837a, canvas, i);
        }
        Ju(i);
    }

    private final void Ju(int i) {
        SoundPool dGS;
        Integer dHf;
        for (com.opensource.svgaplayer.entities.a aVar : dGz().dGR()) {
            if (aVar.dHd() == i && (dGS = dGz().dGS()) != null && (dHf = aVar.dHf()) != null) {
                aVar.s(Integer.valueOf(dGS.play(dHf.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dHe() <= i) {
                Integer dHg = aVar.dHg();
                if (dHg != null) {
                    int intValue = dHg.intValue();
                    SoundPool dGS2 = dGz().dGS();
                    if (dGS2 != null) {
                        dGS2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dHb = this.nes.dHb();
        dHb.postScale(dGV().dHA(), dGV().dHB());
        dHb.postTranslate(dGV().dHy(), dGV().dHz());
        dHb.preConcat(matrix);
        return dHb;
    }

    private final void a(a.C0837a c0837a, Canvas canvas, int i) {
        a(c0837a, canvas);
        b(c0837a, canvas);
        b(c0837a, canvas, i);
    }

    private final void a(a.C0837a c0837a, Canvas canvas) {
        String dGW = c0837a.dGW();
        if (dGW != null && !q.l((Object) this.ndr.dGA().get(dGW), (Object) true)) {
            Bitmap bitmap = this.ndr.dGB().get(dGW);
            if (bitmap == null) {
                bitmap = dGz().dGT().get(dGW);
            }
            if (bitmap != null) {
                Matrix c = c(c0837a.dGX().dHj());
                Paint dGY = this.nes.dGY();
                dGY.setAntiAlias(dGz().dGN());
                dGY.setFilterBitmap(dGz().dGN());
                dGY.setAlpha((int) (c0837a.dGX().dHv() * 255));
                if (c0837a.dGX().dHx() != null) {
                    com.opensource.svgaplayer.entities.b dHx = c0837a.dGX().dHx();
                    if (dHx != null) {
                        canvas.save();
                        dGY.reset();
                        Path dGZ = this.nes.dGZ();
                        dHx.a(dGZ);
                        dGZ.transform(c);
                        canvas.clipPath(dGZ);
                        c.preScale((float) (c0837a.dGX().dHw().getWidth() / bitmap.getWidth()), (float) (c0837a.dGX().dHw().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dGY);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0837a.dGX().dHw().getWidth() / bitmap.getWidth()), (float) (c0837a.dGX().dHw().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dGY);
                }
                a(canvas, bitmap, c0837a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0837a c0837a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.ndr.dGH()) {
            this.neu.clear();
            this.ndr.wJ(false);
        }
        String dGW = c0837a.dGW();
        if (dGW != null) {
            Bitmap bitmap3 = null;
            String str = this.ndr.dGC().get(dGW);
            if (str != null) {
                TextPaint textPaint = this.ndr.dGD().get(dGW);
                if (textPaint != null && (bitmap3 = this.neu.get(dGW)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.neu;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dGW, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.ndr.dGE().get(dGW);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.neu.get(dGW);
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
                    HashMap<String, Bitmap> hashMap2 = this.neu;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dGW, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dGY = this.nes.dGY();
                dGY.setAntiAlias(dGz().dGN());
                if (c0837a.dGX().dHx() != null) {
                    com.opensource.svgaplayer.entities.b dHx = c0837a.dGX().dHx();
                    if (dHx != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dGY.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dGZ = this.nes.dGZ();
                        dHx.a(dGZ);
                        canvas.drawPath(dGZ, dGY);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dGY.setFilterBitmap(dGz().dGN());
                canvas.drawBitmap(bitmap2, matrix, dGY);
            }
        }
    }

    private final void b(a.C0837a c0837a, Canvas canvas) {
        float[] dHs;
        String dHq;
        String dHp;
        int dHn;
        Matrix c = c(c0837a.dGX().dHj());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0837a.dGX().hG()) {
            sVGAVideoShapeEntity.dHm();
            if (sVGAVideoShapeEntity.dHl() != null) {
                Paint dGY = this.nes.dGY();
                dGY.reset();
                dGY.setAntiAlias(dGz().dGN());
                dGY.setAlpha((int) (c0837a.dGX().dHv() * 255));
                Path dGZ = this.nes.dGZ();
                dGZ.reset();
                dGZ.addPath(this.nev.a(sVGAVideoShapeEntity));
                Matrix dHc = this.nes.dHc();
                dHc.reset();
                Matrix dHj = sVGAVideoShapeEntity.dHj();
                if (dHj != null) {
                    dHc.postConcat(dHj);
                }
                dHc.postConcat(c);
                dGZ.transform(dHc);
                SVGAVideoShapeEntity.a dHi = sVGAVideoShapeEntity.dHi();
                if (dHi != null && (dHn = dHi.dHn()) != 0) {
                    dGY.setStyle(Paint.Style.FILL);
                    dGY.setColor(dHn);
                    dGY.setAlpha(Math.min(255, Math.max(0, (int) (c0837a.dGX().dHv() * 255))));
                    if (c0837a.dGX().dHx() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dHx = c0837a.dGX().dHx();
                    if (dHx != null) {
                        Path dHa = this.nes.dHa();
                        dHx.a(dHa);
                        dHa.transform(c);
                        canvas.clipPath(dHa);
                    }
                    canvas.drawPath(dGZ, dGY);
                    if (c0837a.dGX().dHx() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dHi2 = sVGAVideoShapeEntity.dHi();
                if (dHi2 != null && dHi2.getStrokeWidth() > 0) {
                    dGY.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dHi3 = sVGAVideoShapeEntity.dHi();
                    if (dHi3 != null) {
                        dGY.setColor(dHi3.dHo());
                        dGY.setAlpha(Math.min(255, Math.max(0, (int) (c0837a.dGX().dHv() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dHi4 = sVGAVideoShapeEntity.dHi();
                    if (dHi4 != null) {
                        dGY.setStrokeWidth(dHi4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dHi5 = sVGAVideoShapeEntity.dHi();
                    if (dHi5 != null && (dHp = dHi5.dHp()) != null) {
                        if (l.H(dHp, "butt", true)) {
                            dGY.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.H(dHp, "round", true)) {
                            dGY.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.H(dHp, "square", true)) {
                            dGY.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dHi6 = sVGAVideoShapeEntity.dHi();
                    if (dHi6 != null && (dHq = dHi6.dHq()) != null) {
                        if (l.H(dHq, "miter", true)) {
                            dGY.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.H(dHq, "round", true)) {
                            dGY.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.H(dHq, "bevel", true)) {
                            dGY.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dHi7 = sVGAVideoShapeEntity.dHi();
                    if (dHi7 != null) {
                        dGY.setStrokeMiter(dHi7.dHr() * d);
                    }
                    SVGAVideoShapeEntity.a dHi8 = sVGAVideoShapeEntity.dHi();
                    if (dHi8 != null && (dHs = dHi8.dHs()) != null && dHs.length == 3 && (dHs[0] > 0 || dHs[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dHs[0] < 1.0f ? 1.0f : dHs[0]) * d;
                        fArr[1] = (dHs[1] < 0.1f ? 0.1f : dHs[1]) * d;
                        dGY.setPathEffect(new DashPathEffect(fArr, dHs[2] * d));
                    }
                    if (c0837a.dGX().dHx() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dHx2 = c0837a.dGX().dHx();
                    if (dHx2 != null) {
                        Path dHa2 = this.nes.dHa();
                        dHx2.a(dHa2);
                        dHa2.transform(c);
                        canvas.clipPath(dHa2);
                    }
                    canvas.drawPath(dGZ, dGY);
                    if (c0837a.dGX().dHx() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.f4new);
        if (this.f4new[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.f4new[0];
        double d2 = this.f4new[3];
        double d3 = this.f4new[1];
        double d4 = this.f4new[4];
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
        return dGV().dHC() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0837a c0837a, Canvas canvas, int i) {
        String dGW = c0837a.dGW();
        if (dGW != null) {
            m<Canvas, Integer, Boolean> mVar = this.ndr.dGF().get(dGW);
            if (mVar != null) {
                Matrix c = c(c0837a.dGX().dHj());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.ndr.dGG().get(dGW);
            if (rVar != null) {
                Matrix c2 = c(c0837a.dGX().dHj());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0837a.dGX().dHw().getWidth()), Integer.valueOf((int) c0837a.dGX().dHw().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0838b {
        private final Paint neA = new Paint();
        private final Path neB = new Path();
        private final Path neC = new Path();
        private final Matrix neD = new Matrix();
        private final Matrix neE = new Matrix();

        public final Paint dGY() {
            this.neA.reset();
            return this.neA;
        }

        public final Path dGZ() {
            this.neB.reset();
            return this.neB;
        }

        public final Path dHa() {
            this.neC.reset();
            return this.neC;
        }

        public final Matrix dHb() {
            this.neD.reset();
            return this.neD;
        }

        public final Matrix dHc() {
            this.neE.reset();
            return this.neE;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nex;
        private int ney;
        private final HashMap<SVGAVideoShapeEntity, Path> nez = new HashMap<>();

        public final void af(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.nex != canvas.getWidth() || this.ney != canvas.getHeight()) {
                this.nez.clear();
            }
            this.nex = canvas.getWidth();
            this.ney = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.nez.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dHl());
                this.nez.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nez.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dLM();
            }
            return path2;
        }
    }
}
