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
/* loaded from: classes15.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c ptQ;
    private final C1013b puQ;
    private final HashMap<String, Bitmap> puR;
    private final a puS;
    private final float[] puT;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.ptQ = cVar;
        this.puQ = new C1013b();
        this.puR = new HashMap<>();
        this.puS = new a();
        this.puT = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.puS.at(canvas);
        for (a.C1012a c1012a : QC(i)) {
            a(c1012a, canvas, i);
        }
        QD(i);
    }

    private final void QD(int i) {
        SoundPool etg;
        Integer ets;
        for (com.opensource.svgaplayer.entities.a aVar : esN().etf()) {
            if (aVar.etq() == i && (etg = esN().etg()) != null && (ets = aVar.ets()) != null) {
                aVar.u(Integer.valueOf(etg.play(ets.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.etr() <= i) {
                Integer ett = aVar.ett();
                if (ett != null) {
                    int intValue = ett.intValue();
                    SoundPool etg2 = esN().etg();
                    if (etg2 != null) {
                        etg2.stop(intValue);
                    }
                }
                aVar.u(null);
            }
        }
    }

    private final Matrix e(Matrix matrix) {
        Matrix eto = this.puQ.eto();
        eto.postScale(etj().etN(), etj().etO());
        eto.postTranslate(etj().etL(), etj().etM());
        eto.preConcat(matrix);
        return eto;
    }

    private final void a(a.C1012a c1012a, Canvas canvas, int i) {
        a(c1012a, canvas);
        b(c1012a, canvas);
        b(c1012a, canvas, i);
    }

    private final void a(a.C1012a c1012a, Canvas canvas) {
        String imageKey = c1012a.getImageKey();
        if (imageKey != null && !q.l(this.ptQ.esO().get(imageKey), true)) {
            Bitmap bitmap = this.ptQ.esP().get(imageKey);
            if (bitmap == null) {
                bitmap = esN().eth().get(imageKey);
            }
            if (bitmap != null) {
                Matrix e = e(c1012a.etk().etw());
                Paint etl = this.puQ.etl();
                etl.setAntiAlias(esN().etb());
                etl.setFilterBitmap(esN().etb());
                etl.setAlpha((int) (c1012a.etk().etI() * 255));
                if (c1012a.etk().etK() != null) {
                    com.opensource.svgaplayer.entities.b etK = c1012a.etk().etK();
                    if (etK != null) {
                        canvas.save();
                        etl.reset();
                        Path etm = this.puQ.etm();
                        etK.a(etm);
                        etm.transform(e);
                        canvas.clipPath(etm);
                        e.preScale((float) (c1012a.etk().etJ().getWidth() / bitmap.getWidth()), (float) (c1012a.etk().etJ().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, e, etl);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    e.preScale((float) (c1012a.etk().etJ().getWidth() / bitmap.getWidth()), (float) (c1012a.etk().etJ().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, e, etl);
                }
                a(canvas, bitmap, c1012a, e);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C1012a c1012a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.ptQ.esV()) {
            this.puR.clear();
            this.ptQ.AC(false);
        }
        String imageKey = c1012a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.ptQ.esQ().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.ptQ.esR().get(imageKey);
                if (textPaint != null && (bitmap3 = this.puR.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.m(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.puR;
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
            StaticLayout staticLayout = this.ptQ.esS().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.puR.get(imageKey);
                if (bitmap4 == null) {
                    q.m(staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    q.m(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.puR;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint etl = this.puQ.etl();
                etl.setAntiAlias(esN().etb());
                if (c1012a.etk().etK() != null) {
                    com.opensource.svgaplayer.entities.b etK = c1012a.etk().etK();
                    if (etK != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        etl.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path etm = this.puQ.etm();
                        etK.a(etm);
                        canvas.drawPath(etm, etl);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                etl.setFilterBitmap(esN().etb());
                canvas.drawBitmap(bitmap2, matrix, etl);
            }
        }
    }

    private final void b(a.C1012a c1012a, Canvas canvas) {
        float[] etF;
        String etD;
        String etC;
        int etA;
        Matrix e = e(c1012a.etk().etw());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1012a.etk().jz()) {
            sVGAVideoShapeEntity.etz();
            if (sVGAVideoShapeEntity.ety() != null) {
                Paint etl = this.puQ.etl();
                etl.reset();
                etl.setAntiAlias(esN().etb());
                etl.setAlpha((int) (c1012a.etk().etI() * 255));
                Path etm = this.puQ.etm();
                etm.reset();
                etm.addPath(this.puS.a(sVGAVideoShapeEntity));
                Matrix etp = this.puQ.etp();
                etp.reset();
                Matrix etw = sVGAVideoShapeEntity.etw();
                if (etw != null) {
                    etp.postConcat(etw);
                }
                etp.postConcat(e);
                etm.transform(etp);
                SVGAVideoShapeEntity.a etv = sVGAVideoShapeEntity.etv();
                if (etv != null && (etA = etv.etA()) != 0) {
                    etl.setStyle(Paint.Style.FILL);
                    etl.setColor(etA);
                    etl.setAlpha(Math.min(255, Math.max(0, (int) (c1012a.etk().etI() * 255))));
                    if (c1012a.etk().etK() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b etK = c1012a.etk().etK();
                    if (etK != null) {
                        Path etn = this.puQ.etn();
                        etK.a(etn);
                        etn.transform(e);
                        canvas.clipPath(etn);
                    }
                    canvas.drawPath(etm, etl);
                    if (c1012a.etk().etK() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a etv2 = sVGAVideoShapeEntity.etv();
                if (etv2 != null && etv2.getStrokeWidth() > 0) {
                    etl.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a etv3 = sVGAVideoShapeEntity.etv();
                    if (etv3 != null) {
                        etl.setColor(etv3.etB());
                        etl.setAlpha(Math.min(255, Math.max(0, (int) (c1012a.etk().etI() * 255))));
                    }
                    float f = f(e);
                    SVGAVideoShapeEntity.a etv4 = sVGAVideoShapeEntity.etv();
                    if (etv4 != null) {
                        etl.setStrokeWidth(etv4.getStrokeWidth() * f);
                    }
                    SVGAVideoShapeEntity.a etv5 = sVGAVideoShapeEntity.etv();
                    if (etv5 != null && (etC = etv5.etC()) != null) {
                        if (l.I(etC, "butt", true)) {
                            etl.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.I(etC, "round", true)) {
                            etl.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.I(etC, "square", true)) {
                            etl.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a etv6 = sVGAVideoShapeEntity.etv();
                    if (etv6 != null && (etD = etv6.etD()) != null) {
                        if (l.I(etD, "miter", true)) {
                            etl.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.I(etD, "round", true)) {
                            etl.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.I(etD, "bevel", true)) {
                            etl.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a etv7 = sVGAVideoShapeEntity.etv();
                    if (etv7 != null) {
                        etl.setStrokeMiter(etv7.etE() * f);
                    }
                    SVGAVideoShapeEntity.a etv8 = sVGAVideoShapeEntity.etv();
                    if (etv8 != null && (etF = etv8.etF()) != null && etF.length == 3 && (etF[0] > 0 || etF[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (etF[0] < 1.0f ? 1.0f : etF[0]) * f;
                        fArr[1] = (etF[1] < 0.1f ? 0.1f : etF[1]) * f;
                        etl.setPathEffect(new DashPathEffect(fArr, etF[2] * f));
                    }
                    if (c1012a.etk().etK() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b etK2 = c1012a.etk().etK();
                    if (etK2 != null) {
                        Path etn2 = this.puQ.etn();
                        etK2.a(etn2);
                        etn2.transform(e);
                        canvas.clipPath(etn2);
                    }
                    canvas.drawPath(etm, etl);
                    if (c1012a.etk().etK() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float f(Matrix matrix) {
        matrix.getValues(this.puT);
        if (this.puT[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.puT[0];
        double d2 = this.puT[3];
        double d3 = this.puT[1];
        double d4 = this.puT[4];
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
        return etj().etP() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C1012a c1012a, Canvas canvas, int i) {
        String imageKey = c1012a.getImageKey();
        if (imageKey != null) {
            m<Canvas, Integer, Boolean> mVar = this.ptQ.esT().get(imageKey);
            if (mVar != null) {
                Matrix e = e(c1012a.etk().etw());
                canvas.save();
                canvas.concat(e);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.ptQ.esU().get(imageKey);
            if (rVar != null) {
                Matrix e2 = e(c1012a.etk().etw());
                canvas.save();
                canvas.concat(e2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c1012a.etk().etJ().getWidth()), Integer.valueOf((int) c1012a.etk().etJ().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1013b {
        private final Paint puV = new Paint();
        private final Path puW = new Path();
        private final Path puX = new Path();
        private final Matrix puY = new Matrix();
        private final Matrix puZ = new Matrix();

        public final Paint etl() {
            this.puV.reset();
            return this.puV;
        }

        public final Path etm() {
            this.puW.reset();
            return this.puW;
        }

        public final Path etn() {
            this.puX.reset();
            return this.puX;
        }

        public final Matrix eto() {
            this.puY.reset();
            return this.puY;
        }

        public final Matrix etp() {
            this.puZ.reset();
            return this.puZ;
        }
    }

    @h
    /* loaded from: classes15.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> puU = new HashMap<>();

        public final void at(Canvas canvas) {
            q.n(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.puU.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.n(sVGAVideoShapeEntity, "shape");
            if (!this.puU.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.ety());
                this.puU.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.puU.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.eya();
            }
            return path2;
        }
    }
}
