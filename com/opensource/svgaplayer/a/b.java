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
/* loaded from: classes16.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c onb;
    private final C0923b ooc;
    private final HashMap<String, Bitmap> ood;
    private final a ooe;
    private final float[] oof;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.onb = cVar;
        this.ooc = new C0923b();
        this.ood = new HashMap<>();
        this.ooe = new a();
        this.oof = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.ooe.aq(canvas);
        for (a.C0922a c0922a : Of(i)) {
            a(c0922a, canvas, i);
        }
        Og(i);
    }

    private final void Og(int i) {
        SoundPool efv;
        Integer efH;
        for (com.opensource.svgaplayer.entities.a aVar : efc().efu()) {
            if (aVar.efF() == i && (efv = efc().efv()) != null && (efH = aVar.efH()) != null) {
                aVar.s(Integer.valueOf(efv.play(efH.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.efG() <= i) {
                Integer efI = aVar.efI();
                if (efI != null) {
                    int intValue = efI.intValue();
                    SoundPool efv2 = efc().efv();
                    if (efv2 != null) {
                        efv2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix efD = this.ooc.efD();
        efD.postScale(efy().egc(), efy().egd());
        efD.postTranslate(efy().ega(), efy().egb());
        efD.preConcat(matrix);
        return efD;
    }

    private final void a(a.C0922a c0922a, Canvas canvas, int i) {
        a(c0922a, canvas);
        b(c0922a, canvas);
        b(c0922a, canvas, i);
    }

    private final void a(a.C0922a c0922a, Canvas canvas) {
        String imageKey = c0922a.getImageKey();
        if (imageKey != null && !q.l((Object) this.onb.efd().get(imageKey), (Object) true)) {
            Bitmap bitmap = this.onb.efe().get(imageKey);
            if (bitmap == null) {
                bitmap = efc().efw().get(imageKey);
            }
            if (bitmap != null) {
                Matrix c = c(c0922a.efz().efL());
                Paint efA = this.ooc.efA();
                efA.setAntiAlias(efc().efq());
                efA.setFilterBitmap(efc().efq());
                efA.setAlpha((int) (c0922a.efz().efX() * 255));
                if (c0922a.efz().efZ() != null) {
                    com.opensource.svgaplayer.entities.b efZ = c0922a.efz().efZ();
                    if (efZ != null) {
                        canvas.save();
                        efA.reset();
                        Path efB = this.ooc.efB();
                        efZ.a(efB);
                        efB.transform(c);
                        canvas.clipPath(efB);
                        c.preScale((float) (c0922a.efz().efY().getWidth() / bitmap.getWidth()), (float) (c0922a.efz().efY().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, efA);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0922a.efz().efY().getWidth() / bitmap.getWidth()), (float) (c0922a.efz().efY().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, efA);
                }
                a(canvas, bitmap, c0922a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0922a c0922a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.onb.efk()) {
            this.ood.clear();
            this.onb.yN(false);
        }
        String imageKey = c0922a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.onb.eff().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.onb.efg().get(imageKey);
                if (textPaint != null && (bitmap3 = this.ood.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.ood;
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
            StaticLayout staticLayout = this.onb.efh().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.ood.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.ood;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint efA = this.ooc.efA();
                efA.setAntiAlias(efc().efq());
                if (c0922a.efz().efZ() != null) {
                    com.opensource.svgaplayer.entities.b efZ = c0922a.efz().efZ();
                    if (efZ != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        efA.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path efB = this.ooc.efB();
                        efZ.a(efB);
                        canvas.drawPath(efB, efA);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                efA.setFilterBitmap(efc().efq());
                canvas.drawBitmap(bitmap2, matrix, efA);
            }
        }
    }

    private final void b(a.C0922a c0922a, Canvas canvas) {
        float[] efU;
        String efS;
        String efR;
        int efP;
        Matrix c = c(c0922a.efz().efL());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0922a.efz().jy()) {
            sVGAVideoShapeEntity.efO();
            if (sVGAVideoShapeEntity.efN() != null) {
                Paint efA = this.ooc.efA();
                efA.reset();
                efA.setAntiAlias(efc().efq());
                efA.setAlpha((int) (c0922a.efz().efX() * 255));
                Path efB = this.ooc.efB();
                efB.reset();
                efB.addPath(this.ooe.a(sVGAVideoShapeEntity));
                Matrix efE = this.ooc.efE();
                efE.reset();
                Matrix efL = sVGAVideoShapeEntity.efL();
                if (efL != null) {
                    efE.postConcat(efL);
                }
                efE.postConcat(c);
                efB.transform(efE);
                SVGAVideoShapeEntity.a efK = sVGAVideoShapeEntity.efK();
                if (efK != null && (efP = efK.efP()) != 0) {
                    efA.setStyle(Paint.Style.FILL);
                    efA.setColor(efP);
                    efA.setAlpha(Math.min(255, Math.max(0, (int) (c0922a.efz().efX() * 255))));
                    if (c0922a.efz().efZ() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b efZ = c0922a.efz().efZ();
                    if (efZ != null) {
                        Path efC = this.ooc.efC();
                        efZ.a(efC);
                        efC.transform(c);
                        canvas.clipPath(efC);
                    }
                    canvas.drawPath(efB, efA);
                    if (c0922a.efz().efZ() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a efK2 = sVGAVideoShapeEntity.efK();
                if (efK2 != null && efK2.getStrokeWidth() > 0) {
                    efA.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a efK3 = sVGAVideoShapeEntity.efK();
                    if (efK3 != null) {
                        efA.setColor(efK3.efQ());
                        efA.setAlpha(Math.min(255, Math.max(0, (int) (c0922a.efz().efX() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a efK4 = sVGAVideoShapeEntity.efK();
                    if (efK4 != null) {
                        efA.setStrokeWidth(efK4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a efK5 = sVGAVideoShapeEntity.efK();
                    if (efK5 != null && (efR = efK5.efR()) != null) {
                        if (l.H(efR, "butt", true)) {
                            efA.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.H(efR, "round", true)) {
                            efA.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.H(efR, "square", true)) {
                            efA.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a efK6 = sVGAVideoShapeEntity.efK();
                    if (efK6 != null && (efS = efK6.efS()) != null) {
                        if (l.H(efS, "miter", true)) {
                            efA.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.H(efS, "round", true)) {
                            efA.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.H(efS, "bevel", true)) {
                            efA.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a efK7 = sVGAVideoShapeEntity.efK();
                    if (efK7 != null) {
                        efA.setStrokeMiter(efK7.efT() * d);
                    }
                    SVGAVideoShapeEntity.a efK8 = sVGAVideoShapeEntity.efK();
                    if (efK8 != null && (efU = efK8.efU()) != null && efU.length == 3 && (efU[0] > 0 || efU[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (efU[0] < 1.0f ? 1.0f : efU[0]) * d;
                        fArr[1] = (efU[1] < 0.1f ? 0.1f : efU[1]) * d;
                        efA.setPathEffect(new DashPathEffect(fArr, efU[2] * d));
                    }
                    if (c0922a.efz().efZ() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b efZ2 = c0922a.efz().efZ();
                    if (efZ2 != null) {
                        Path efC2 = this.ooc.efC();
                        efZ2.a(efC2);
                        efC2.transform(c);
                        canvas.clipPath(efC2);
                    }
                    canvas.drawPath(efB, efA);
                    if (c0922a.efz().efZ() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.oof);
        if (this.oof[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.oof[0];
        double d2 = this.oof[3];
        double d3 = this.oof[1];
        double d4 = this.oof[4];
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
        return efy().ege() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0922a c0922a, Canvas canvas, int i) {
        String imageKey = c0922a.getImageKey();
        if (imageKey != null) {
            m<Canvas, Integer, Boolean> mVar = this.onb.efi().get(imageKey);
            if (mVar != null) {
                Matrix c = c(c0922a.efz().efL());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.onb.efj().get(imageKey);
            if (rVar != null) {
                Matrix c2 = c(c0922a.efz().efL());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0922a.efz().efY().getWidth()), Integer.valueOf((int) c0922a.efz().efY().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C0923b {
        private final Paint ooh = new Paint();
        private final Path ooi = new Path();
        private final Path ooj = new Path();
        private final Matrix ook = new Matrix();
        private final Matrix ool = new Matrix();

        public final Paint efA() {
            this.ooh.reset();
            return this.ooh;
        }

        public final Path efB() {
            this.ooi.reset();
            return this.ooi;
        }

        public final Path efC() {
            this.ooj.reset();
            return this.ooj;
        }

        public final Matrix efD() {
            this.ook.reset();
            return this.ook;
        }

        public final Matrix efE() {
            this.ool.reset();
            return this.ool;
        }
    }

    @h
    /* loaded from: classes16.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> oog = new HashMap<>();

        public final void aq(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.oog.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.oog.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.efN());
                this.oog.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.oog.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.ekp();
            }
            return path2;
        }
    }
}
