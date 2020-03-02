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
    private final c nkD;
    private final C0734b nlE;
    private final HashMap<String, Bitmap> nlF;
    private final a nlG;
    private final float[] nlH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nkD = cVar;
        this.nlE = new C0734b();
        this.nlF = new HashMap<>();
        this.nlG = new a();
        this.nlH = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nlG.ah(canvas);
        for (a.C0733a c0733a : Ni(i)) {
            a(c0733a, canvas, i);
        }
        Nj(i);
    }

    private final void Nj(int i) {
        SoundPool dEY;
        Integer dFl;
        for (com.opensource.svgaplayer.entities.a aVar : dEG().dEX()) {
            if (aVar.dFj() == i && (dEY = dEG().dEY()) != null && (dFl = aVar.dFl()) != null) {
                aVar.s(Integer.valueOf(dEY.play(dFl.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dFk() <= i) {
                Integer dFm = aVar.dFm();
                if (dFm != null) {
                    int intValue = dFm.intValue();
                    SoundPool dEY2 = dEG().dEY();
                    if (dEY2 != null) {
                        dEY2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dFh = this.nlE.dFh();
        dFh.postScale(dFb().dFG(), dFb().dFH());
        dFh.postTranslate(dFb().dFE(), dFb().dFF());
        dFh.preConcat(matrix);
        return dFh;
    }

    private final void a(a.C0733a c0733a, Canvas canvas, int i) {
        a(c0733a, canvas);
        b(c0733a, canvas);
        b(c0733a, canvas, i);
    }

    private final void a(a.C0733a c0733a, Canvas canvas) {
        String dFc = c0733a.dFc();
        if (dFc != null && !q.h(this.nkD.dEH().get(dFc), true)) {
            Bitmap bitmap = this.nkD.dEI().get(dFc);
            if (bitmap == null) {
                bitmap = dEG().dEZ().get(dFc);
            }
            if (bitmap != null) {
                Matrix c = c(c0733a.dFd().dFp());
                Paint dFe = this.nlE.dFe();
                dFe.setAntiAlias(dEG().dET());
                dFe.setFilterBitmap(dEG().dET());
                dFe.setAlpha((int) (c0733a.dFd().dFB() * 255));
                if (c0733a.dFd().dFD() != null) {
                    com.opensource.svgaplayer.entities.b dFD = c0733a.dFd().dFD();
                    if (dFD != null) {
                        canvas.save();
                        dFe.reset();
                        Path dFf = this.nlE.dFf();
                        dFD.c(dFf);
                        dFf.transform(c);
                        canvas.clipPath(dFf);
                        c.preScale((float) (c0733a.dFd().dFC().getWidth() / bitmap.getWidth()), (float) (c0733a.dFd().dFC().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dFe);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0733a.dFd().dFC().getWidth() / bitmap.getWidth()), (float) (c0733a.dFd().dFC().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dFe);
                }
                a(canvas, bitmap, c0733a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0733a c0733a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nkD.dEO()) {
            this.nlF.clear();
            this.nkD.wv(false);
        }
        String dFc = c0733a.dFc();
        if (dFc != null) {
            Bitmap bitmap3 = null;
            String str = this.nkD.dEJ().get(dFc);
            if (str != null) {
                TextPaint textPaint = this.nkD.dEK().get(dFc);
                if (textPaint != null && (bitmap3 = this.nlF.get(dFc)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.i(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nlF;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dFc, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nkD.dEL().get(dFc);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nlF.get(dFc);
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
                    HashMap<String, Bitmap> hashMap2 = this.nlF;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dFc, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dFe = this.nlE.dFe();
                dFe.setAntiAlias(dEG().dET());
                if (c0733a.dFd().dFD() != null) {
                    com.opensource.svgaplayer.entities.b dFD = c0733a.dFd().dFD();
                    if (dFD != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dFe.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dFf = this.nlE.dFf();
                        dFD.c(dFf);
                        canvas.drawPath(dFf, dFe);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dFe.setFilterBitmap(dEG().dET());
                canvas.drawBitmap(bitmap2, matrix, dFe);
            }
        }
    }

    private final void b(a.C0733a c0733a, Canvas canvas) {
        float[] dFy;
        String dFw;
        String dFv;
        int dFt;
        Matrix c = c(c0733a.dFd().dFp());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0733a.dFd().cj()) {
            sVGAVideoShapeEntity.dFs();
            if (sVGAVideoShapeEntity.dFr() != null) {
                Paint dFe = this.nlE.dFe();
                dFe.reset();
                dFe.setAntiAlias(dEG().dET());
                dFe.setAlpha((int) (c0733a.dFd().dFB() * 255));
                Path dFf = this.nlE.dFf();
                dFf.reset();
                dFf.addPath(this.nlG.a(sVGAVideoShapeEntity));
                Matrix dFi = this.nlE.dFi();
                dFi.reset();
                Matrix dFp = sVGAVideoShapeEntity.dFp();
                if (dFp != null) {
                    dFi.postConcat(dFp);
                }
                dFi.postConcat(c);
                dFf.transform(dFi);
                SVGAVideoShapeEntity.a dFo = sVGAVideoShapeEntity.dFo();
                if (dFo != null && (dFt = dFo.dFt()) != 0) {
                    dFe.setStyle(Paint.Style.FILL);
                    dFe.setColor(dFt);
                    dFe.setAlpha(Math.min(255, Math.max(0, (int) (c0733a.dFd().dFB() * 255))));
                    if (c0733a.dFd().dFD() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dFD = c0733a.dFd().dFD();
                    if (dFD != null) {
                        Path dFg = this.nlE.dFg();
                        dFD.c(dFg);
                        dFg.transform(c);
                        canvas.clipPath(dFg);
                    }
                    canvas.drawPath(dFf, dFe);
                    if (c0733a.dFd().dFD() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dFo2 = sVGAVideoShapeEntity.dFo();
                if (dFo2 != null && dFo2.getStrokeWidth() > 0) {
                    dFe.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dFo3 = sVGAVideoShapeEntity.dFo();
                    if (dFo3 != null) {
                        dFe.setColor(dFo3.dFu());
                        dFe.setAlpha(Math.min(255, Math.max(0, (int) (c0733a.dFd().dFB() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dFo4 = sVGAVideoShapeEntity.dFo();
                    if (dFo4 != null) {
                        dFe.setStrokeWidth(dFo4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dFo5 = sVGAVideoShapeEntity.dFo();
                    if (dFo5 != null && (dFv = dFo5.dFv()) != null) {
                        if (l.F(dFv, "butt", true)) {
                            dFe.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.F(dFv, "round", true)) {
                            dFe.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.F(dFv, "square", true)) {
                            dFe.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dFo6 = sVGAVideoShapeEntity.dFo();
                    if (dFo6 != null && (dFw = dFo6.dFw()) != null) {
                        if (l.F(dFw, "miter", true)) {
                            dFe.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.F(dFw, "round", true)) {
                            dFe.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.F(dFw, "bevel", true)) {
                            dFe.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dFo7 = sVGAVideoShapeEntity.dFo();
                    if (dFo7 != null) {
                        dFe.setStrokeMiter(dFo7.dFx() * d);
                    }
                    SVGAVideoShapeEntity.a dFo8 = sVGAVideoShapeEntity.dFo();
                    if (dFo8 != null && (dFy = dFo8.dFy()) != null && dFy.length == 3 && (dFy[0] > 0 || dFy[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dFy[0] < 1.0f ? 1.0f : dFy[0]) * d;
                        fArr[1] = (dFy[1] < 0.1f ? 0.1f : dFy[1]) * d;
                        dFe.setPathEffect(new DashPathEffect(fArr, dFy[2] * d));
                    }
                    if (c0733a.dFd().dFD() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dFD2 = c0733a.dFd().dFD();
                    if (dFD2 != null) {
                        Path dFg2 = this.nlE.dFg();
                        dFD2.c(dFg2);
                        dFg2.transform(c);
                        canvas.clipPath(dFg2);
                    }
                    canvas.drawPath(dFf, dFe);
                    if (c0733a.dFd().dFD() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nlH);
        if (this.nlH[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nlH[0];
        double d2 = this.nlH[3];
        double d3 = this.nlH[1];
        double d4 = this.nlH[4];
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
        return dFb().dFI() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0733a c0733a, Canvas canvas, int i) {
        String dFc = c0733a.dFc();
        if (dFc != null) {
            m<Canvas, Integer, Boolean> mVar = this.nkD.dEM().get(dFc);
            if (mVar != null) {
                Matrix c = c(c0733a.dFd().dFp());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nkD.dEN().get(dFc);
            if (rVar != null) {
                Matrix c2 = c(c0733a.dFd().dFp());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0733a.dFd().dFC().getWidth()), Integer.valueOf((int) c0733a.dFd().dFC().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0734b {
        private final Paint nlL = new Paint();
        private final Path nlM = new Path();
        private final Path nlN = new Path();
        private final Matrix nlO = new Matrix();
        private final Matrix nlP = new Matrix();

        public final Paint dFe() {
            this.nlL.reset();
            return this.nlL;
        }

        public final Path dFf() {
            this.nlM.reset();
            return this.nlM;
        }

        public final Path dFg() {
            this.nlN.reset();
            return this.nlN;
        }

        public final Matrix dFh() {
            this.nlO.reset();
            return this.nlO;
        }

        public final Matrix dFi() {
            this.nlP.reset();
            return this.nlP;
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class a {
        private int nlI;
        private int nlJ;
        private final HashMap<SVGAVideoShapeEntity, Path> nlK = new HashMap<>();

        public final void ah(Canvas canvas) {
            q.j(canvas, "canvas");
            if (this.nlI != canvas.getWidth() || this.nlJ != canvas.getHeight()) {
                this.nlK.clear();
            }
            this.nlI = canvas.getWidth();
            this.nlJ = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.j(sVGAVideoShapeEntity, "shape");
            if (!this.nlK.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dFr());
                this.nlK.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nlK.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dKv();
            }
            return path2;
        }
    }
}
