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
    private final c pYn;
    private final C1173b pZn;
    private final HashMap<String, Bitmap> pZo;
    private final a pZp;
    private final float[] pZq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pYn = cVar;
        this.pZn = new C1173b();
        this.pZo = new HashMap<>();
        this.pZp = new a();
        this.pZq = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pZp.aD(canvas);
        for (a.C1172a c1172a : QD(i)) {
            a(c1172a, canvas, i);
        }
        QE(i);
    }

    private final void QE(int i) {
        SoundPool eCP;
        Integer eDb;
        for (com.opensource.svgaplayer.entities.a aVar : eCw().eCO()) {
            if (aVar.eCZ() == i && (eCP = eCw().eCP()) != null && (eDb = aVar.eDb()) != null) {
                aVar.w(Integer.valueOf(eCP.play(eDb.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eDa() <= i) {
                Integer eDc = aVar.eDc();
                if (eDc != null) {
                    int intValue = eDc.intValue();
                    SoundPool eCP2 = eCw().eCP();
                    if (eCP2 != null) {
                        eCP2.stop(intValue);
                    }
                }
                aVar.w(null);
            }
        }
    }

    private final Matrix h(Matrix matrix) {
        Matrix eCX = this.pZn.eCX();
        eCX.postScale(eCS().eDx(), eCS().eDy());
        eCX.postTranslate(eCS().eDv(), eCS().eDw());
        eCX.preConcat(matrix);
        return eCX;
    }

    private final void a(a.C1172a c1172a, Canvas canvas, int i) {
        a(c1172a, canvas);
        b(c1172a, canvas);
        b(c1172a, canvas, i);
    }

    private final void a(a.C1172a c1172a, Canvas canvas) {
        String imageKey = c1172a.getImageKey();
        if (imageKey != null && !p.l(this.pYn.eCx().get(imageKey), true)) {
            Bitmap bitmap = this.pYn.eCy().get(imageKey);
            if (bitmap == null) {
                bitmap = eCw().eCQ().get(imageKey);
            }
            if (bitmap != null) {
                Matrix h = h(c1172a.eCT().eDf());
                Paint eCU = this.pZn.eCU();
                eCU.setAntiAlias(eCw().eCK());
                eCU.setFilterBitmap(eCw().eCK());
                eCU.setAlpha((int) (c1172a.eCT().eDr() * 255));
                if (c1172a.eCT().eDt() != null) {
                    com.opensource.svgaplayer.entities.b eDt = c1172a.eCT().eDt();
                    if (eDt != null) {
                        canvas.save();
                        eCU.reset();
                        Path eCV = this.pZn.eCV();
                        eDt.a(eCV);
                        eCV.transform(h);
                        canvas.clipPath(eCV);
                        h.preScale((float) (c1172a.eCT().eDs().getWidth() / bitmap.getWidth()), (float) (c1172a.eCT().eDs().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, h, eCU);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    h.preScale((float) (c1172a.eCT().eDs().getWidth() / bitmap.getWidth()), (float) (c1172a.eCT().eDs().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, h, eCU);
                }
                a(canvas, bitmap, c1172a, h);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1172a c1172a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pYn.eCE()) {
            this.pZo.clear();
            this.pYn.BH(false);
        }
        String imageKey = c1172a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pYn.eCz().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pYn.eCA().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pZo.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pZo;
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
            StaticLayout staticLayout = this.pYn.eCB().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pZo.get(imageKey);
                if (bitmap4 == null) {
                    p.n(staticLayout, "it");
                    TextPaint paint = staticLayout.getPaint();
                    p.n(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.pZo;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint eCU = this.pZn.eCU();
                eCU.setAntiAlias(eCw().eCK());
                if (c1172a.eCT().eDt() != null) {
                    com.opensource.svgaplayer.entities.b eDt = c1172a.eCT().eDt();
                    if (eDt != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        eCU.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eCV = this.pZn.eCV();
                        eDt.a(eCV);
                        canvas.drawPath(eCV, eCU);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                eCU.setFilterBitmap(eCw().eCK());
                canvas.drawBitmap(bitmap2, matrix, eCU);
            }
        }
    }

    private final void b(a.C1172a c1172a, Canvas canvas) {
        float[] eDo;
        String eDm;
        String eDl;
        int eDj;
        Matrix h = h(c1172a.eCT().eDf());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1172a.eCT().iX()) {
            sVGAVideoShapeEntity.eDi();
            if (sVGAVideoShapeEntity.eDh() != null) {
                Paint eCU = this.pZn.eCU();
                eCU.reset();
                eCU.setAntiAlias(eCw().eCK());
                eCU.setAlpha((int) (c1172a.eCT().eDr() * 255));
                Path eCV = this.pZn.eCV();
                eCV.reset();
                eCV.addPath(this.pZp.a(sVGAVideoShapeEntity));
                Matrix eCY = this.pZn.eCY();
                eCY.reset();
                Matrix eDf = sVGAVideoShapeEntity.eDf();
                if (eDf != null) {
                    eCY.postConcat(eDf);
                }
                eCY.postConcat(h);
                eCV.transform(eCY);
                SVGAVideoShapeEntity.a eDe = sVGAVideoShapeEntity.eDe();
                if (eDe != null && (eDj = eDe.eDj()) != 0) {
                    eCU.setStyle(Paint.Style.FILL);
                    eCU.setColor(eDj);
                    eCU.setAlpha(Math.min(255, Math.max(0, (int) (c1172a.eCT().eDr() * 255))));
                    if (c1172a.eCT().eDt() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eDt = c1172a.eCT().eDt();
                    if (eDt != null) {
                        Path eCW = this.pZn.eCW();
                        eDt.a(eCW);
                        eCW.transform(h);
                        canvas.clipPath(eCW);
                    }
                    canvas.drawPath(eCV, eCU);
                    if (c1172a.eCT().eDt() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eDe2 = sVGAVideoShapeEntity.eDe();
                if (eDe2 != null && eDe2.getStrokeWidth() > 0) {
                    eCU.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eDe3 = sVGAVideoShapeEntity.eDe();
                    if (eDe3 != null) {
                        eCU.setColor(eDe3.eDk());
                        eCU.setAlpha(Math.min(255, Math.max(0, (int) (c1172a.eCT().eDr() * 255))));
                    }
                    float i = i(h);
                    SVGAVideoShapeEntity.a eDe4 = sVGAVideoShapeEntity.eDe();
                    if (eDe4 != null) {
                        eCU.setStrokeWidth(eDe4.getStrokeWidth() * i);
                    }
                    SVGAVideoShapeEntity.a eDe5 = sVGAVideoShapeEntity.eDe();
                    if (eDe5 != null && (eDl = eDe5.eDl()) != null) {
                        if (l.N(eDl, "butt", true)) {
                            eCU.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.N(eDl, "round", true)) {
                            eCU.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.N(eDl, "square", true)) {
                            eCU.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eDe6 = sVGAVideoShapeEntity.eDe();
                    if (eDe6 != null && (eDm = eDe6.eDm()) != null) {
                        if (l.N(eDm, "miter", true)) {
                            eCU.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.N(eDm, "round", true)) {
                            eCU.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.N(eDm, "bevel", true)) {
                            eCU.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eDe7 = sVGAVideoShapeEntity.eDe();
                    if (eDe7 != null) {
                        eCU.setStrokeMiter(eDe7.eDn() * i);
                    }
                    SVGAVideoShapeEntity.a eDe8 = sVGAVideoShapeEntity.eDe();
                    if (eDe8 != null && (eDo = eDe8.eDo()) != null && eDo.length == 3 && (eDo[0] > 0 || eDo[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eDo[0] < 1.0f ? 1.0f : eDo[0]) * i;
                        fArr[1] = (eDo[1] < 0.1f ? 0.1f : eDo[1]) * i;
                        eCU.setPathEffect(new DashPathEffect(fArr, eDo[2] * i));
                    }
                    if (c1172a.eCT().eDt() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eDt2 = c1172a.eCT().eDt();
                    if (eDt2 != null) {
                        Path eCW2 = this.pZn.eCW();
                        eDt2.a(eCW2);
                        eCW2.transform(h);
                        canvas.clipPath(eCW2);
                    }
                    canvas.drawPath(eCV, eCU);
                    if (c1172a.eCT().eDt() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float i(Matrix matrix) {
        matrix.getValues(this.pZq);
        if (this.pZq[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pZq[0];
        double d2 = this.pZq[3];
        double d3 = this.pZq[1];
        double d4 = this.pZq[4];
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
        return eCS().eDz() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1172a c1172a, Canvas canvas, int i) {
        String imageKey = c1172a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pYn.eCC().get(imageKey);
            if (cVar != null) {
                Matrix h = h(c1172a.eCT().eDf());
                canvas.save();
                canvas.concat(h);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pYn.eCD().get(imageKey);
            if (dVar != null) {
                Matrix h2 = h(c1172a.eCT().eDf());
                canvas.save();
                canvas.concat(h2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1172a.eCT().eDs().getWidth()), Integer.valueOf((int) c1172a.eCT().eDs().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1173b {
        private final Paint pZu = new Paint();
        private final Path pZv = new Path();
        private final Path pZw = new Path();
        private final Matrix pZx = new Matrix();
        private final Matrix pZy = new Matrix();

        public final Paint eCU() {
            this.pZu.reset();
            return this.pZu;
        }

        public final Path eCV() {
            this.pZv.reset();
            return this.pZv;
        }

        public final Path eCW() {
            this.pZw.reset();
            return this.pZw;
        }

        public final Matrix eCX() {
            this.pZx.reset();
            return this.pZx;
        }

        public final Matrix eCY() {
            this.pZy.reset();
            return this.pZy;
        }
    }

    @e
    /* loaded from: classes6.dex */
    public static final class a {
        private int pZr;
        private int pZs;
        private final HashMap<SVGAVideoShapeEntity, Path> pZt = new HashMap<>();

        public final void aD(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.pZr != canvas.getWidth() || this.pZs != canvas.getHeight()) {
                this.pZt.clear();
            }
            this.pZr = canvas.getWidth();
            this.pZs = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pZt.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eDh());
                this.pZt.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pZt.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eLm();
            }
            return path2;
        }
    }
}
