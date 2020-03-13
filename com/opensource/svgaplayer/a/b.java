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
    private final c nkO;
    private final C0734b nlP;
    private final HashMap<String, Bitmap> nlQ;
    private final a nlR;
    private final float[] nlS;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nkO = cVar;
        this.nlP = new C0734b();
        this.nlQ = new HashMap<>();
        this.nlR = new a();
        this.nlS = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nlR.ah(canvas);
        for (a.C0733a c0733a : Ni(i)) {
            a(c0733a, canvas, i);
        }
        Nj(i);
    }

    private final void Nj(int i) {
        SoundPool dEZ;
        Integer dFm;
        for (com.opensource.svgaplayer.entities.a aVar : dEH().dEY()) {
            if (aVar.dFk() == i && (dEZ = dEH().dEZ()) != null && (dFm = aVar.dFm()) != null) {
                aVar.s(Integer.valueOf(dEZ.play(dFm.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dFl() <= i) {
                Integer dFn = aVar.dFn();
                if (dFn != null) {
                    int intValue = dFn.intValue();
                    SoundPool dEZ2 = dEH().dEZ();
                    if (dEZ2 != null) {
                        dEZ2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dFi = this.nlP.dFi();
        dFi.postScale(dFc().dFH(), dFc().dFI());
        dFi.postTranslate(dFc().dFF(), dFc().dFG());
        dFi.preConcat(matrix);
        return dFi;
    }

    private final void a(a.C0733a c0733a, Canvas canvas, int i) {
        a(c0733a, canvas);
        b(c0733a, canvas);
        b(c0733a, canvas, i);
    }

    private final void a(a.C0733a c0733a, Canvas canvas) {
        String dFd = c0733a.dFd();
        if (dFd != null && !q.h(this.nkO.dEI().get(dFd), true)) {
            Bitmap bitmap = this.nkO.dEJ().get(dFd);
            if (bitmap == null) {
                bitmap = dEH().dFa().get(dFd);
            }
            if (bitmap != null) {
                Matrix c = c(c0733a.dFe().dFq());
                Paint dFf = this.nlP.dFf();
                dFf.setAntiAlias(dEH().dEU());
                dFf.setFilterBitmap(dEH().dEU());
                dFf.setAlpha((int) (c0733a.dFe().dFC() * 255));
                if (c0733a.dFe().dFE() != null) {
                    com.opensource.svgaplayer.entities.b dFE = c0733a.dFe().dFE();
                    if (dFE != null) {
                        canvas.save();
                        dFf.reset();
                        Path dFg = this.nlP.dFg();
                        dFE.c(dFg);
                        dFg.transform(c);
                        canvas.clipPath(dFg);
                        c.preScale((float) (c0733a.dFe().dFD().getWidth() / bitmap.getWidth()), (float) (c0733a.dFe().dFD().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dFf);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0733a.dFe().dFD().getWidth() / bitmap.getWidth()), (float) (c0733a.dFe().dFD().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dFf);
                }
                a(canvas, bitmap, c0733a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0733a c0733a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nkO.dEP()) {
            this.nlQ.clear();
            this.nkO.wv(false);
        }
        String dFd = c0733a.dFd();
        if (dFd != null) {
            Bitmap bitmap3 = null;
            String str = this.nkO.dEK().get(dFd);
            if (str != null) {
                TextPaint textPaint = this.nkO.dEL().get(dFd);
                if (textPaint != null && (bitmap3 = this.nlQ.get(dFd)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nlQ;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dFd, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nkO.dEM().get(dFd);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nlQ.get(dFd);
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
                    HashMap<String, Bitmap> hashMap2 = this.nlQ;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dFd, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dFf = this.nlP.dFf();
                dFf.setAntiAlias(dEH().dEU());
                if (c0733a.dFe().dFE() != null) {
                    com.opensource.svgaplayer.entities.b dFE = c0733a.dFe().dFE();
                    if (dFE != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dFf.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dFg = this.nlP.dFg();
                        dFE.c(dFg);
                        canvas.drawPath(dFg, dFf);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dFf.setFilterBitmap(dEH().dEU());
                canvas.drawBitmap(bitmap2, matrix, dFf);
            }
        }
    }

    private final void b(a.C0733a c0733a, Canvas canvas) {
        float[] dFz;
        String dFx;
        String dFw;
        int dFu;
        Matrix c = c(c0733a.dFe().dFq());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0733a.dFe().cj()) {
            sVGAVideoShapeEntity.dFt();
            if (sVGAVideoShapeEntity.dFs() != null) {
                Paint dFf = this.nlP.dFf();
                dFf.reset();
                dFf.setAntiAlias(dEH().dEU());
                dFf.setAlpha((int) (c0733a.dFe().dFC() * 255));
                Path dFg = this.nlP.dFg();
                dFg.reset();
                dFg.addPath(this.nlR.a(sVGAVideoShapeEntity));
                Matrix dFj = this.nlP.dFj();
                dFj.reset();
                Matrix dFq = sVGAVideoShapeEntity.dFq();
                if (dFq != null) {
                    dFj.postConcat(dFq);
                }
                dFj.postConcat(c);
                dFg.transform(dFj);
                SVGAVideoShapeEntity.a dFp = sVGAVideoShapeEntity.dFp();
                if (dFp != null && (dFu = dFp.dFu()) != 0) {
                    dFf.setStyle(Paint.Style.FILL);
                    dFf.setColor(dFu);
                    dFf.setAlpha(Math.min(255, Math.max(0, (int) (c0733a.dFe().dFC() * 255))));
                    if (c0733a.dFe().dFE() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dFE = c0733a.dFe().dFE();
                    if (dFE != null) {
                        Path dFh = this.nlP.dFh();
                        dFE.c(dFh);
                        dFh.transform(c);
                        canvas.clipPath(dFh);
                    }
                    canvas.drawPath(dFg, dFf);
                    if (c0733a.dFe().dFE() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dFp2 = sVGAVideoShapeEntity.dFp();
                if (dFp2 != null && dFp2.getStrokeWidth() > 0) {
                    dFf.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dFp3 = sVGAVideoShapeEntity.dFp();
                    if (dFp3 != null) {
                        dFf.setColor(dFp3.dFv());
                        dFf.setAlpha(Math.min(255, Math.max(0, (int) (c0733a.dFe().dFC() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dFp4 = sVGAVideoShapeEntity.dFp();
                    if (dFp4 != null) {
                        dFf.setStrokeWidth(dFp4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dFp5 = sVGAVideoShapeEntity.dFp();
                    if (dFp5 != null && (dFw = dFp5.dFw()) != null) {
                        if (l.F(dFw, "butt", true)) {
                            dFf.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dFw, "round", true)) {
                            dFf.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dFw, "square", true)) {
                            dFf.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dFp6 = sVGAVideoShapeEntity.dFp();
                    if (dFp6 != null && (dFx = dFp6.dFx()) != null) {
                        if (l.F(dFx, "miter", true)) {
                            dFf.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dFx, "round", true)) {
                            dFf.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dFx, "bevel", true)) {
                            dFf.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dFp7 = sVGAVideoShapeEntity.dFp();
                    if (dFp7 != null) {
                        dFf.setStrokeMiter(dFp7.dFy() * d);
                    }
                    SVGAVideoShapeEntity.a dFp8 = sVGAVideoShapeEntity.dFp();
                    if (dFp8 != null && (dFz = dFp8.dFz()) != null && dFz.length == 3 && (dFz[0] > 0 || dFz[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dFz[0] < 1.0f ? 1.0f : dFz[0]) * d;
                        fArr[1] = (dFz[1] < 0.1f ? 0.1f : dFz[1]) * d;
                        dFf.setPathEffect(new DashPathEffect(fArr, dFz[2] * d));
                    }
                    if (c0733a.dFe().dFE() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dFE2 = c0733a.dFe().dFE();
                    if (dFE2 != null) {
                        Path dFh2 = this.nlP.dFh();
                        dFE2.c(dFh2);
                        dFh2.transform(c);
                        canvas.clipPath(dFh2);
                    }
                    canvas.drawPath(dFg, dFf);
                    if (c0733a.dFe().dFE() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nlS);
        if (this.nlS[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nlS[0];
        double d2 = this.nlS[3];
        double d3 = this.nlS[1];
        double d4 = this.nlS[4];
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
        return dFc().dFJ() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0733a c0733a, Canvas canvas, int i) {
        String dFd = c0733a.dFd();
        if (dFd != null) {
            m<Canvas, Integer, Boolean> mVar = this.nkO.dEN().get(dFd);
            if (mVar != null) {
                Matrix c = c(c0733a.dFe().dFq());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nkO.dEO().get(dFd);
            if (rVar != null) {
                Matrix c2 = c(c0733a.dFe().dFq());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0733a.dFe().dFD().getWidth()), Integer.valueOf((int) c0733a.dFe().dFD().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0734b {
        private final Paint nlW = new Paint();
        private final Path nlX = new Path();
        private final Path nlY = new Path();
        private final Matrix nlZ = new Matrix();
        private final Matrix nma = new Matrix();

        public final Paint dFf() {
            this.nlW.reset();
            return this.nlW;
        }

        public final Path dFg() {
            this.nlX.reset();
            return this.nlX;
        }

        public final Path dFh() {
            this.nlY.reset();
            return this.nlY;
        }

        public final Matrix dFi() {
            this.nlZ.reset();
            return this.nlZ;
        }

        public final Matrix dFj() {
            this.nma.reset();
            return this.nma;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nlT;
        private int nlU;
        private final HashMap<SVGAVideoShapeEntity, Path> nlV = new HashMap<>();

        public final void ah(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.nlT != canvas.getWidth() || this.nlU != canvas.getHeight()) {
                this.nlV.clear();
            }
            this.nlT = canvas.getWidth();
            this.nlU = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.nlV.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dFs());
                this.nlV.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nlV.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dKw();
            }
            return path2;
        }
    }
}
