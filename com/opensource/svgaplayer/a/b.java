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
    private final c pYN;
    private final C1175b pZN;
    private final HashMap<String, Bitmap> pZO;
    private final a pZP;
    private final float[] pZQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pYN = cVar;
        this.pZN = new C1175b();
        this.pZO = new HashMap<>();
        this.pZP = new a();
        this.pZQ = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.pZP.aD(canvas);
        for (a.C1174a c1174a : QE(i)) {
            a(c1174a, canvas, i);
        }
        QF(i);
    }

    private final void QF(int i) {
        SoundPool eCX;
        Integer eDj;
        for (com.opensource.svgaplayer.entities.a aVar : eCE().eCW()) {
            if (aVar.eDh() == i && (eCX = eCE().eCX()) != null && (eDj = aVar.eDj()) != null) {
                aVar.w(Integer.valueOf(eCX.play(eDj.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.eDi() <= i) {
                Integer eDk = aVar.eDk();
                if (eDk != null) {
                    int intValue = eDk.intValue();
                    SoundPool eCX2 = eCE().eCX();
                    if (eCX2 != null) {
                        eCX2.stop(intValue);
                    }
                }
                aVar.w(null);
            }
        }
    }

    private final Matrix h(Matrix matrix) {
        Matrix eDf = this.pZN.eDf();
        eDf.postScale(eDa().eDF(), eDa().eDG());
        eDf.postTranslate(eDa().eDD(), eDa().eDE());
        eDf.preConcat(matrix);
        return eDf;
    }

    private final void a(a.C1174a c1174a, Canvas canvas, int i) {
        a(c1174a, canvas);
        b(c1174a, canvas);
        b(c1174a, canvas, i);
    }

    private final void a(a.C1174a c1174a, Canvas canvas) {
        String imageKey = c1174a.getImageKey();
        if (imageKey != null && !p.l(this.pYN.eCF().get(imageKey), true)) {
            Bitmap bitmap = this.pYN.eCG().get(imageKey);
            if (bitmap == null) {
                bitmap = eCE().eCY().get(imageKey);
            }
            if (bitmap != null) {
                Matrix h = h(c1174a.eDb().eDn());
                Paint eDc = this.pZN.eDc();
                eDc.setAntiAlias(eCE().eCS());
                eDc.setFilterBitmap(eCE().eCS());
                eDc.setAlpha((int) (c1174a.eDb().eDz() * 255));
                if (c1174a.eDb().eDB() != null) {
                    com.opensource.svgaplayer.entities.b eDB = c1174a.eDb().eDB();
                    if (eDB != null) {
                        canvas.save();
                        eDc.reset();
                        Path eDd = this.pZN.eDd();
                        eDB.a(eDd);
                        eDd.transform(h);
                        canvas.clipPath(eDd);
                        h.preScale((float) (c1174a.eDb().eDA().getWidth() / bitmap.getWidth()), (float) (c1174a.eDb().eDA().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, h, eDc);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    h.preScale((float) (c1174a.eDb().eDA().getWidth() / bitmap.getWidth()), (float) (c1174a.eDb().eDA().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, h, eDc);
                }
                a(canvas, bitmap, c1174a, h);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1174a c1174a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.pYN.eCM()) {
            this.pZO.clear();
            this.pYN.BH(false);
        }
        String imageKey = c1174a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.pYN.eCH().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.pYN.eCI().get(imageKey);
                if (textPaint != null && (bitmap3 = this.pZO.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    p.n(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.pZO;
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
            StaticLayout staticLayout = this.pYN.eCJ().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.pZO.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.pZO;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint eDc = this.pZN.eDc();
                eDc.setAntiAlias(eCE().eCS());
                if (c1174a.eDb().eDB() != null) {
                    com.opensource.svgaplayer.entities.b eDB = c1174a.eDb().eDB();
                    if (eDB != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        eDc.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path eDd = this.pZN.eDd();
                        eDB.a(eDd);
                        canvas.drawPath(eDd, eDc);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                eDc.setFilterBitmap(eCE().eCS());
                canvas.drawBitmap(bitmap2, matrix, eDc);
            }
        }
    }

    private final void b(a.C1174a c1174a, Canvas canvas) {
        float[] eDw;
        String eDu;
        String eDt;
        int eDr;
        Matrix h = h(c1174a.eDb().eDn());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1174a.eDb().iX()) {
            sVGAVideoShapeEntity.eDq();
            if (sVGAVideoShapeEntity.eDp() != null) {
                Paint eDc = this.pZN.eDc();
                eDc.reset();
                eDc.setAntiAlias(eCE().eCS());
                eDc.setAlpha((int) (c1174a.eDb().eDz() * 255));
                Path eDd = this.pZN.eDd();
                eDd.reset();
                eDd.addPath(this.pZP.a(sVGAVideoShapeEntity));
                Matrix eDg = this.pZN.eDg();
                eDg.reset();
                Matrix eDn = sVGAVideoShapeEntity.eDn();
                if (eDn != null) {
                    eDg.postConcat(eDn);
                }
                eDg.postConcat(h);
                eDd.transform(eDg);
                SVGAVideoShapeEntity.a eDm = sVGAVideoShapeEntity.eDm();
                if (eDm != null && (eDr = eDm.eDr()) != 0) {
                    eDc.setStyle(Paint.Style.FILL);
                    eDc.setColor(eDr);
                    eDc.setAlpha(Math.min(255, Math.max(0, (int) (c1174a.eDb().eDz() * 255))));
                    if (c1174a.eDb().eDB() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eDB = c1174a.eDb().eDB();
                    if (eDB != null) {
                        Path eDe = this.pZN.eDe();
                        eDB.a(eDe);
                        eDe.transform(h);
                        canvas.clipPath(eDe);
                    }
                    canvas.drawPath(eDd, eDc);
                    if (c1174a.eDb().eDB() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a eDm2 = sVGAVideoShapeEntity.eDm();
                if (eDm2 != null && eDm2.getStrokeWidth() > 0) {
                    eDc.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a eDm3 = sVGAVideoShapeEntity.eDm();
                    if (eDm3 != null) {
                        eDc.setColor(eDm3.eDs());
                        eDc.setAlpha(Math.min(255, Math.max(0, (int) (c1174a.eDb().eDz() * 255))));
                    }
                    float i = i(h);
                    SVGAVideoShapeEntity.a eDm4 = sVGAVideoShapeEntity.eDm();
                    if (eDm4 != null) {
                        eDc.setStrokeWidth(eDm4.getStrokeWidth() * i);
                    }
                    SVGAVideoShapeEntity.a eDm5 = sVGAVideoShapeEntity.eDm();
                    if (eDm5 != null && (eDt = eDm5.eDt()) != null) {
                        if (l.N(eDt, "butt", true)) {
                            eDc.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.N(eDt, "round", true)) {
                            eDc.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.N(eDt, "square", true)) {
                            eDc.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a eDm6 = sVGAVideoShapeEntity.eDm();
                    if (eDm6 != null && (eDu = eDm6.eDu()) != null) {
                        if (l.N(eDu, "miter", true)) {
                            eDc.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.N(eDu, "round", true)) {
                            eDc.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.N(eDu, "bevel", true)) {
                            eDc.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a eDm7 = sVGAVideoShapeEntity.eDm();
                    if (eDm7 != null) {
                        eDc.setStrokeMiter(eDm7.eDv() * i);
                    }
                    SVGAVideoShapeEntity.a eDm8 = sVGAVideoShapeEntity.eDm();
                    if (eDm8 != null && (eDw = eDm8.eDw()) != null && eDw.length == 3 && (eDw[0] > 0 || eDw[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (eDw[0] < 1.0f ? 1.0f : eDw[0]) * i;
                        fArr[1] = (eDw[1] < 0.1f ? 0.1f : eDw[1]) * i;
                        eDc.setPathEffect(new DashPathEffect(fArr, eDw[2] * i));
                    }
                    if (c1174a.eDb().eDB() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b eDB2 = c1174a.eDb().eDB();
                    if (eDB2 != null) {
                        Path eDe2 = this.pZN.eDe();
                        eDB2.a(eDe2);
                        eDe2.transform(h);
                        canvas.clipPath(eDe2);
                    }
                    canvas.drawPath(eDd, eDc);
                    if (c1174a.eDb().eDB() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float i(Matrix matrix) {
        matrix.getValues(this.pZQ);
        if (this.pZQ[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.pZQ[0];
        double d2 = this.pZQ[3];
        double d3 = this.pZQ[1];
        double d4 = this.pZQ[4];
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
        return eDa().eDH() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1174a c1174a, Canvas canvas, int i) {
        String imageKey = c1174a.getImageKey();
        if (imageKey != null) {
            kotlin.jvm.a.c<Canvas, Integer, Boolean> cVar = this.pYN.eCK().get(imageKey);
            if (cVar != null) {
                Matrix h = h(c1174a.eDb().eDn());
                canvas.save();
                canvas.concat(h);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            d<Canvas, Integer, Integer, Integer, Boolean> dVar = this.pYN.eCL().get(imageKey);
            if (dVar != null) {
                Matrix h2 = h(c1174a.eDb().eDn());
                canvas.save();
                canvas.concat(h2);
                dVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1174a.eDb().eDA().getWidth()), Integer.valueOf((int) c1174a.eDb().eDA().getHeight()));
                canvas.restore();
            }
        }
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1175b {
        private final Paint pZU = new Paint();
        private final Path pZV = new Path();
        private final Path pZW = new Path();
        private final Matrix pZX = new Matrix();
        private final Matrix pZY = new Matrix();

        public final Paint eDc() {
            this.pZU.reset();
            return this.pZU;
        }

        public final Path eDd() {
            this.pZV.reset();
            return this.pZV;
        }

        public final Path eDe() {
            this.pZW.reset();
            return this.pZW;
        }

        public final Matrix eDf() {
            this.pZX.reset();
            return this.pZX;
        }

        public final Matrix eDg() {
            this.pZY.reset();
            return this.pZY;
        }
    }

    @e
    /* loaded from: classes6.dex */
    public static final class a {
        private int pZR;
        private int pZS;
        private final HashMap<SVGAVideoShapeEntity, Path> pZT = new HashMap<>();

        public final void aD(Canvas canvas) {
            p.o(canvas, "canvas");
            if (this.pZR != canvas.getWidth() || this.pZS != canvas.getHeight()) {
                this.pZT.clear();
            }
            this.pZR = canvas.getWidth();
            this.pZS = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            p.o(sVGAVideoShapeEntity, "shape");
            if (!this.pZT.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.eDp());
                this.pZT.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.pZT.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                p.eLu();
            }
            return path2;
        }
    }
}
