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
/* loaded from: classes11.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c odq;
    private final C0926b oer;
    private final HashMap<String, Bitmap> oes;
    private final a oet;
    private final float[] oeu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.odq = cVar;
        this.oer = new C0926b();
        this.oes = new HashMap<>();
        this.oet = new a();
        this.oeu = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.oet.aq(canvas);
        for (a.C0925a c0925a : NA(i)) {
            a(c0925a, canvas, i);
        }
        NB(i);
    }

    private final void NB(int i) {
        SoundPool ebx;
        Integer ebK;
        for (com.opensource.svgaplayer.entities.a aVar : ebe().ebw()) {
            if (aVar.ebI() == i && (ebx = ebe().ebx()) != null && (ebK = aVar.ebK()) != null) {
                aVar.s(Integer.valueOf(ebx.play(ebK.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.ebJ() <= i) {
                Integer ebL = aVar.ebL();
                if (ebL != null) {
                    int intValue = ebL.intValue();
                    SoundPool ebx2 = ebe().ebx();
                    if (ebx2 != null) {
                        ebx2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix ebG = this.oer.ebG();
        ebG.postScale(ebA().ecf(), ebA().ecg());
        ebG.postTranslate(ebA().ecd(), ebA().ece());
        ebG.preConcat(matrix);
        return ebG;
    }

    private final void a(a.C0925a c0925a, Canvas canvas, int i) {
        a(c0925a, canvas);
        b(c0925a, canvas);
        b(c0925a, canvas, i);
    }

    private final void a(a.C0925a c0925a, Canvas canvas) {
        String ebB = c0925a.ebB();
        if (ebB != null && !q.l((Object) this.odq.ebf().get(ebB), (Object) true)) {
            Bitmap bitmap = this.odq.ebg().get(ebB);
            if (bitmap == null) {
                bitmap = ebe().eby().get(ebB);
            }
            if (bitmap != null) {
                Matrix c = c(c0925a.ebC().ebO());
                Paint ebD = this.oer.ebD();
                ebD.setAntiAlias(ebe().ebs());
                ebD.setFilterBitmap(ebe().ebs());
                ebD.setAlpha((int) (c0925a.ebC().eca() * 255));
                if (c0925a.ebC().ecc() != null) {
                    com.opensource.svgaplayer.entities.b ecc = c0925a.ebC().ecc();
                    if (ecc != null) {
                        canvas.save();
                        ebD.reset();
                        Path ebE = this.oer.ebE();
                        ecc.a(ebE);
                        ebE.transform(c);
                        canvas.clipPath(ebE);
                        c.preScale((float) (c0925a.ebC().ecb().getWidth() / bitmap.getWidth()), (float) (c0925a.ebC().ecb().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, ebD);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0925a.ebC().ecb().getWidth() / bitmap.getWidth()), (float) (c0925a.ebC().ecb().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, ebD);
                }
                a(canvas, bitmap, c0925a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0925a c0925a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.odq.ebm()) {
            this.oes.clear();
            this.odq.yF(false);
        }
        String ebB = c0925a.ebB();
        if (ebB != null) {
            Bitmap bitmap3 = null;
            String str = this.odq.ebh().get(ebB);
            if (str != null) {
                TextPaint textPaint = this.odq.ebi().get(ebB);
                if (textPaint != null && (bitmap3 = this.oes.get(ebB)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.oes;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(ebB, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.odq.ebj().get(ebB);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.oes.get(ebB);
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
                    HashMap<String, Bitmap> hashMap2 = this.oes;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(ebB, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint ebD = this.oer.ebD();
                ebD.setAntiAlias(ebe().ebs());
                if (c0925a.ebC().ecc() != null) {
                    com.opensource.svgaplayer.entities.b ecc = c0925a.ebC().ecc();
                    if (ecc != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        ebD.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path ebE = this.oer.ebE();
                        ecc.a(ebE);
                        canvas.drawPath(ebE, ebD);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                ebD.setFilterBitmap(ebe().ebs());
                canvas.drawBitmap(bitmap2, matrix, ebD);
            }
        }
    }

    private final void b(a.C0925a c0925a, Canvas canvas) {
        float[] ebX;
        String ebV;
        String ebU;
        int ebS;
        Matrix c = c(c0925a.ebC().ebO());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0925a.ebC().jx()) {
            sVGAVideoShapeEntity.ebR();
            if (sVGAVideoShapeEntity.ebQ() != null) {
                Paint ebD = this.oer.ebD();
                ebD.reset();
                ebD.setAntiAlias(ebe().ebs());
                ebD.setAlpha((int) (c0925a.ebC().eca() * 255));
                Path ebE = this.oer.ebE();
                ebE.reset();
                ebE.addPath(this.oet.a(sVGAVideoShapeEntity));
                Matrix ebH = this.oer.ebH();
                ebH.reset();
                Matrix ebO = sVGAVideoShapeEntity.ebO();
                if (ebO != null) {
                    ebH.postConcat(ebO);
                }
                ebH.postConcat(c);
                ebE.transform(ebH);
                SVGAVideoShapeEntity.a ebN = sVGAVideoShapeEntity.ebN();
                if (ebN != null && (ebS = ebN.ebS()) != 0) {
                    ebD.setStyle(Paint.Style.FILL);
                    ebD.setColor(ebS);
                    ebD.setAlpha(Math.min(255, Math.max(0, (int) (c0925a.ebC().eca() * 255))));
                    if (c0925a.ebC().ecc() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b ecc = c0925a.ebC().ecc();
                    if (ecc != null) {
                        Path ebF = this.oer.ebF();
                        ecc.a(ebF);
                        ebF.transform(c);
                        canvas.clipPath(ebF);
                    }
                    canvas.drawPath(ebE, ebD);
                    if (c0925a.ebC().ecc() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a ebN2 = sVGAVideoShapeEntity.ebN();
                if (ebN2 != null && ebN2.getStrokeWidth() > 0) {
                    ebD.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a ebN3 = sVGAVideoShapeEntity.ebN();
                    if (ebN3 != null) {
                        ebD.setColor(ebN3.ebT());
                        ebD.setAlpha(Math.min(255, Math.max(0, (int) (c0925a.ebC().eca() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a ebN4 = sVGAVideoShapeEntity.ebN();
                    if (ebN4 != null) {
                        ebD.setStrokeWidth(ebN4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a ebN5 = sVGAVideoShapeEntity.ebN();
                    if (ebN5 != null && (ebU = ebN5.ebU()) != null) {
                        if (l.H(ebU, "butt", true)) {
                            ebD.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.H(ebU, "round", true)) {
                            ebD.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.H(ebU, "square", true)) {
                            ebD.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a ebN6 = sVGAVideoShapeEntity.ebN();
                    if (ebN6 != null && (ebV = ebN6.ebV()) != null) {
                        if (l.H(ebV, "miter", true)) {
                            ebD.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.H(ebV, "round", true)) {
                            ebD.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.H(ebV, "bevel", true)) {
                            ebD.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a ebN7 = sVGAVideoShapeEntity.ebN();
                    if (ebN7 != null) {
                        ebD.setStrokeMiter(ebN7.ebW() * d);
                    }
                    SVGAVideoShapeEntity.a ebN8 = sVGAVideoShapeEntity.ebN();
                    if (ebN8 != null && (ebX = ebN8.ebX()) != null && ebX.length == 3 && (ebX[0] > 0 || ebX[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (ebX[0] < 1.0f ? 1.0f : ebX[0]) * d;
                        fArr[1] = (ebX[1] < 0.1f ? 0.1f : ebX[1]) * d;
                        ebD.setPathEffect(new DashPathEffect(fArr, ebX[2] * d));
                    }
                    if (c0925a.ebC().ecc() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b ecc2 = c0925a.ebC().ecc();
                    if (ecc2 != null) {
                        Path ebF2 = this.oer.ebF();
                        ecc2.a(ebF2);
                        ebF2.transform(c);
                        canvas.clipPath(ebF2);
                    }
                    canvas.drawPath(ebE, ebD);
                    if (c0925a.ebC().ecc() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.oeu);
        if (this.oeu[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.oeu[0];
        double d2 = this.oeu[3];
        double d3 = this.oeu[1];
        double d4 = this.oeu[4];
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
        return ebA().ech() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0925a c0925a, Canvas canvas, int i) {
        String ebB = c0925a.ebB();
        if (ebB != null) {
            m<Canvas, Integer, Boolean> mVar = this.odq.ebk().get(ebB);
            if (mVar != null) {
                Matrix c = c(c0925a.ebC().ebO());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.odq.ebl().get(ebB);
            if (rVar != null) {
                Matrix c2 = c(c0925a.ebC().ebO());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0925a.ebC().ecb().getWidth()), Integer.valueOf((int) c0925a.ebC().ecb().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0926b {
        private final Paint oey = new Paint();
        private final Path oez = new Path();
        private final Path oeA = new Path();
        private final Matrix oeB = new Matrix();
        private final Matrix oeC = new Matrix();

        public final Paint ebD() {
            this.oey.reset();
            return this.oey;
        }

        public final Path ebE() {
            this.oez.reset();
            return this.oez;
        }

        public final Path ebF() {
            this.oeA.reset();
            return this.oeA;
        }

        public final Matrix ebG() {
            this.oeB.reset();
            return this.oeB;
        }

        public final Matrix ebH() {
            this.oeC.reset();
            return this.oeC;
        }
    }

    @h
    /* loaded from: classes11.dex */
    public static final class a {
        private int oev;
        private int oew;
        private final HashMap<SVGAVideoShapeEntity, Path> oex = new HashMap<>();

        public final void aq(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.oev != canvas.getWidth() || this.oew != canvas.getHeight()) {
                this.oex.clear();
            }
            this.oev = canvas.getWidth();
            this.oew = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.oex.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.ebQ());
                this.oex.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.oex.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.egs();
            }
            return path2;
        }
    }
}
