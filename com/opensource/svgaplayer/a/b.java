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
/* loaded from: classes5.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c pZB;
    private final C1192b qaB;
    private final HashMap<String, Bitmap> qaC;
    private final a qaD;
    private final float[] qaE;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.p(fVar, "videoItem");
        p.p(cVar, "dynamicItem");
        this.pZB = cVar;
        this.qaB = new C1192b();
        this.qaC = new HashMap<>();
        this.qaD = new a();
        this.qaE = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.p(canvas, "canvas");
        p.p(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.qaD.aD(canvas);
        for (a.C1191a c1191a : QI(i)) {
            a(c1191a, canvas, i);
        }
        QJ(i);
    }

    private final void QJ(int i) {
        SoundPool eDd;
        Integer eDp;
        for (com.opensource.svgaplayer.entities.a aVar : eCK().eDc()) {
            if (aVar.eDn() == i && (eDd = eCK().eDd()) != null && (eDp = aVar.eDp()) != null) {
                aVar.w(Integer.valueOf(eDd.play(eDp.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eDo() <= i) {
                Integer eDq = aVar.eDq();
                if (eDq != null) {
                    int intValue = eDq.intValue();
                    SoundPool eDd2 = eCK().eDd();
                    if (eDd2 != null) {
                        eDd2.stop(intValue);
                    }
                }
                aVar.w(null);
            }
        }
    }

    private final Matrix h(Matrix matrix) {
        Matrix eDl = this.qaB.eDl();
        eDl.postScale(eDg().eDL(), eDg().eDM());
        eDl.postTranslate(eDg().eDJ(), eDg().eDK());
        eDl.preConcat(matrix);
        return eDl;
    }

    private final void a(a.C1191a c1191a, Canvas canvas, int i) {
        a(c1191a, canvas);
        b(c1191a, canvas);
        b(c1191a, canvas, i);
    }

    private final void a(a.C1191a c1191a, Canvas canvas) {
        String imageKey = c1191a.getImageKey();
        if (imageKey != null && !p.l(this.pZB.eCL().get(imageKey), true)) {
            Bitmap bitmap = this.pZB.eCM().get(imageKey);
            if (bitmap == null) {
                bitmap = eCK().eDe().get(imageKey);
            }
            if (bitmap != null) {
                Matrix h = h(c1191a.eDh().eDt());
                Paint eDi = this.qaB.eDi();
                eDi.setAntiAlias(eCK().eCY());
                eDi.setFilterBitmap(eCK().eCY());
                eDi.setAlpha((int) (c1191a.eDh().eDF() * 255));
                if (c1191a.eDh().eDH() != null) {
                    com.opensource.svgaplayer.entities.b eDH = c1191a.eDh().eDH();
                    if (eDH != null) {
                        canvas.save();
                        eDi.reset();
                        Path eDj = this.qaB.eDj();
                        eDH.a(eDj);
                        eDj.transform(h);
                        canvas.clipPath(eDj);
                        h.preScale((float) (c1191a.eDh().eDG().getWidth() / bitmap.getWidth()), (float) (c1191a.eDh().eDG().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, h, eDi);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    h.preScale((float) (c1191a.eDh().eDG().getWidth() / bitmap.getWidth()), (float) (c1191a.eDh().eDG().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, h, eDi);
                }
                a(canvas, bitmap, c1191a, h);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1191a c1191a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pZB.eCS()) {
            this.qaC.clear();
            this.pZB.BF(false);
        }
        String imageKey = c1191a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pZB.eCN().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pZB.eCO().get(imageKey);
                if (textPaint != null && (bitmap3 = this.qaC.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.o(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.qaC;
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
            StaticLayout staticLayout = this.pZB.eCP().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.qaC.get(imageKey);
                if (bitmap4 == null) {
                    p.o(staticLayout, "it");
                    TextPaint paint = staticLayout.getPaint();
                    p.o(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.qaC;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint eDi = this.qaB.eDi();
                eDi.setAntiAlias(eCK().eCY());
                if (c1191a.eDh().eDH() != null) {
                    com.opensource.svgaplayer.entities.b eDH = c1191a.eDh().eDH();
                    if (eDH != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        eDi.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eDj = this.qaB.eDj();
                        eDH.a(eDj);
                        canvas.drawPath(eDj, eDi);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                eDi.setFilterBitmap(eCK().eCY());
                canvas.drawBitmap(bitmap2, matrix, eDi);
            }
        }
    }

    private final void b(a.C1191a c1191a, Canvas canvas) {
        float[] eDC;
        String eDA;
        String eDz;
        int eDx;
        Matrix h = h(c1191a.eDh().eDt());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1191a.eDh().iX()) {
            sVGAVideoShapeEntity.eDw();
            if (sVGAVideoShapeEntity.eDv() != null) {
                Paint eDi = this.qaB.eDi();
                eDi.reset();
                eDi.setAntiAlias(eCK().eCY());
                eDi.setAlpha((int) (c1191a.eDh().eDF() * 255));
                Path eDj = this.qaB.eDj();
                eDj.reset();
                eDj.addPath(this.qaD.a(sVGAVideoShapeEntity));
                Matrix eDm = this.qaB.eDm();
                eDm.reset();
                Matrix eDt = sVGAVideoShapeEntity.eDt();
                if (eDt != null) {
                    eDm.postConcat(eDt);
                }
                eDm.postConcat(h);
                eDj.transform(eDm);
                SVGAVideoShapeEntity.a eDs = sVGAVideoShapeEntity.eDs();
                if (eDs != null && (eDx = eDs.eDx()) != 0) {
                    eDi.setStyle(Paint.Style.FILL);
                    eDi.setColor(eDx);
                    eDi.setAlpha(Math.min(255, Math.max(0, (int) (c1191a.eDh().eDF() * 255))));
                    if (c1191a.eDh().eDH() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eDH = c1191a.eDh().eDH();
                    if (eDH != null) {
                        Path eDk = this.qaB.eDk();
                        eDH.a(eDk);
                        eDk.transform(h);
                        canvas.clipPath(eDk);
                    }
                    canvas.drawPath(eDj, eDi);
                    if (c1191a.eDh().eDH() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eDs2 = sVGAVideoShapeEntity.eDs();
                if (eDs2 != null && eDs2.getStrokeWidth() > 0) {
                    eDi.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eDs3 = sVGAVideoShapeEntity.eDs();
                    if (eDs3 != null) {
                        eDi.setColor(eDs3.eDy());
                        eDi.setAlpha(Math.min(255, Math.max(0, (int) (c1191a.eDh().eDF() * 255))));
                    }
                    float i = i(h);
                    SVGAVideoShapeEntity.a eDs4 = sVGAVideoShapeEntity.eDs();
                    if (eDs4 != null) {
                        eDi.setStrokeWidth(eDs4.getStrokeWidth() * i);
                    }
                    SVGAVideoShapeEntity.a eDs5 = sVGAVideoShapeEntity.eDs();
                    if (eDs5 != null && (eDz = eDs5.eDz()) != null) {
                        if (l.N(eDz, "butt", true)) {
                            eDi.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.N(eDz, "round", true)) {
                            eDi.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.N(eDz, "square", true)) {
                            eDi.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eDs6 = sVGAVideoShapeEntity.eDs();
                    if (eDs6 != null && (eDA = eDs6.eDA()) != null) {
                        if (l.N(eDA, "miter", true)) {
                            eDi.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.N(eDA, "round", true)) {
                            eDi.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.N(eDA, "bevel", true)) {
                            eDi.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eDs7 = sVGAVideoShapeEntity.eDs();
                    if (eDs7 != null) {
                        eDi.setStrokeMiter(eDs7.eDB() * i);
                    }
                    SVGAVideoShapeEntity.a eDs8 = sVGAVideoShapeEntity.eDs();
                    if (eDs8 != null && (eDC = eDs8.eDC()) != null && eDC.length == 3 && (eDC[0] > 0 || eDC[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eDC[0] < 1.0f ? 1.0f : eDC[0]) * i;
                        fArr[1] = (eDC[1] < 0.1f ? 0.1f : eDC[1]) * i;
                        eDi.setPathEffect(new DashPathEffect(fArr, eDC[2] * i));
                    }
                    if (c1191a.eDh().eDH() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eDH2 = c1191a.eDh().eDH();
                    if (eDH2 != null) {
                        Path eDk2 = this.qaB.eDk();
                        eDH2.a(eDk2);
                        eDk2.transform(h);
                        canvas.clipPath(eDk2);
                    }
                    canvas.drawPath(eDj, eDi);
                    if (c1191a.eDh().eDH() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float i(Matrix matrix) {
        matrix.getValues(this.qaE);
        if (this.qaE[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.qaE[0];
        double d2 = this.qaE[3];
        double d3 = this.qaE[1];
        double d4 = this.qaE[4];
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
        return eDg().eDN() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1191a c1191a, Canvas canvas, int i) {
        String imageKey = c1191a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pZB.eCQ().get(imageKey);
            if (cVar != null) {
                Matrix h = h(c1191a.eDh().eDt());
                canvas.save();
                canvas.concat(h);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pZB.eCR().get(imageKey);
            if (dVar != null) {
                Matrix h2 = h(c1191a.eDh().eDt());
                canvas.save();
                canvas.concat(h2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1191a.eDh().eDG().getWidth()), Integer.valueOf((int) c1191a.eDh().eDG().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1192b {
        private final Paint qaI = new Paint();
        private final Path qaJ = new Path();
        private final Path qaK = new Path();
        private final Matrix qaL = new Matrix();
        private final Matrix qaM = new Matrix();

        public final Paint eDi() {
            this.qaI.reset();
            return this.qaI;
        }

        public final Path eDj() {
            this.qaJ.reset();
            return this.qaJ;
        }

        public final Path eDk() {
            this.qaK.reset();
            return this.qaK;
        }

        public final Matrix eDl() {
            this.qaL.reset();
            return this.qaL;
        }

        public final Matrix eDm() {
            this.qaM.reset();
            return this.qaM;
        }
    }

    @e
    /* loaded from: classes5.dex */
    public static final class a {
        private int qaF;
        private int qaG;
        private final HashMap<SVGAVideoShapeEntity, Path> qaH = new HashMap<>();

        public final void aD(Canvas canvas) {
            p.p(canvas, "canvas");
            if (this.qaF != canvas.getWidth() || this.qaG != canvas.getHeight()) {
                this.qaH.clear();
            }
            this.qaF = canvas.getWidth();
            this.qaG = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.p(sVGAVideoShapeEntity, "shape");
            if (!this.qaH.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eDv());
                this.qaH.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.qaH.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eLc();
            }
            return path2;
        }
    }
}
