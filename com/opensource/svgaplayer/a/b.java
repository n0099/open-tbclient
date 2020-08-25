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
    private final c ocY;
    private final C0926b odZ;
    private final HashMap<String, Bitmap> oea;
    private final a oeb;
    private final float[] oec;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.ocY = cVar;
        this.odZ = new C0926b();
        this.oea = new HashMap<>();
        this.oeb = new a();
        this.oec = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.oeb.aq(canvas);
        for (a.C0925a c0925a : NA(i)) {
            a(c0925a, canvas, i);
        }
        NB(i);
    }

    private final void NB(int i) {
        SoundPool ebo;
        Integer ebB;
        for (com.opensource.svgaplayer.entities.a aVar : eaV().ebn()) {
            if (aVar.ebz() == i && (ebo = eaV().ebo()) != null && (ebB = aVar.ebB()) != null) {
                aVar.s(Integer.valueOf(ebo.play(ebB.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.ebA() <= i) {
                Integer ebC = aVar.ebC();
                if (ebC != null) {
                    int intValue = ebC.intValue();
                    SoundPool ebo2 = eaV().ebo();
                    if (ebo2 != null) {
                        ebo2.stop(intValue);
                    }
                }
                aVar.s(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix ebx = this.odZ.ebx();
        ebx.postScale(ebr().ebW(), ebr().ebX());
        ebx.postTranslate(ebr().ebU(), ebr().ebV());
        ebx.preConcat(matrix);
        return ebx;
    }

    private final void a(a.C0925a c0925a, Canvas canvas, int i) {
        a(c0925a, canvas);
        b(c0925a, canvas);
        b(c0925a, canvas, i);
    }

    private final void a(a.C0925a c0925a, Canvas canvas) {
        String ebs = c0925a.ebs();
        if (ebs != null && !q.l((Object) this.ocY.eaW().get(ebs), (Object) true)) {
            Bitmap bitmap = this.ocY.eaX().get(ebs);
            if (bitmap == null) {
                bitmap = eaV().ebp().get(ebs);
            }
            if (bitmap != null) {
                Matrix c = c(c0925a.ebt().ebF());
                Paint ebu = this.odZ.ebu();
                ebu.setAntiAlias(eaV().ebj());
                ebu.setFilterBitmap(eaV().ebj());
                ebu.setAlpha((int) (c0925a.ebt().ebR() * 255));
                if (c0925a.ebt().ebT() != null) {
                    com.opensource.svgaplayer.entities.b ebT = c0925a.ebt().ebT();
                    if (ebT != null) {
                        canvas.save();
                        ebu.reset();
                        Path ebv = this.odZ.ebv();
                        ebT.a(ebv);
                        ebv.transform(c);
                        canvas.clipPath(ebv);
                        c.preScale((float) (c0925a.ebt().ebS().getWidth() / bitmap.getWidth()), (float) (c0925a.ebt().ebS().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, ebu);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0925a.ebt().ebS().getWidth() / bitmap.getWidth()), (float) (c0925a.ebt().ebS().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, ebu);
                }
                a(canvas, bitmap, c0925a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0925a c0925a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.ocY.ebd()) {
            this.oea.clear();
            this.ocY.yD(false);
        }
        String ebs = c0925a.ebs();
        if (ebs != null) {
            Bitmap bitmap3 = null;
            String str = this.ocY.eaY().get(ebs);
            if (str != null) {
                TextPaint textPaint = this.ocY.eaZ().get(ebs);
                if (textPaint != null && (bitmap3 = this.oea.get(ebs)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.oea;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(ebs, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.ocY.eba().get(ebs);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.oea.get(ebs);
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
                    HashMap<String, Bitmap> hashMap2 = this.oea;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(ebs, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint ebu = this.odZ.ebu();
                ebu.setAntiAlias(eaV().ebj());
                if (c0925a.ebt().ebT() != null) {
                    com.opensource.svgaplayer.entities.b ebT = c0925a.ebt().ebT();
                    if (ebT != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        ebu.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path ebv = this.odZ.ebv();
                        ebT.a(ebv);
                        canvas.drawPath(ebv, ebu);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                ebu.setFilterBitmap(eaV().ebj());
                canvas.drawBitmap(bitmap2, matrix, ebu);
            }
        }
    }

    private final void b(a.C0925a c0925a, Canvas canvas) {
        float[] ebO;
        String ebM;
        String ebL;
        int ebJ;
        Matrix c = c(c0925a.ebt().ebF());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0925a.ebt().jx()) {
            sVGAVideoShapeEntity.ebI();
            if (sVGAVideoShapeEntity.ebH() != null) {
                Paint ebu = this.odZ.ebu();
                ebu.reset();
                ebu.setAntiAlias(eaV().ebj());
                ebu.setAlpha((int) (c0925a.ebt().ebR() * 255));
                Path ebv = this.odZ.ebv();
                ebv.reset();
                ebv.addPath(this.oeb.a(sVGAVideoShapeEntity));
                Matrix eby = this.odZ.eby();
                eby.reset();
                Matrix ebF = sVGAVideoShapeEntity.ebF();
                if (ebF != null) {
                    eby.postConcat(ebF);
                }
                eby.postConcat(c);
                ebv.transform(eby);
                SVGAVideoShapeEntity.a ebE = sVGAVideoShapeEntity.ebE();
                if (ebE != null && (ebJ = ebE.ebJ()) != 0) {
                    ebu.setStyle(Paint.Style.FILL);
                    ebu.setColor(ebJ);
                    ebu.setAlpha(Math.min(255, Math.max(0, (int) (c0925a.ebt().ebR() * 255))));
                    if (c0925a.ebt().ebT() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b ebT = c0925a.ebt().ebT();
                    if (ebT != null) {
                        Path ebw = this.odZ.ebw();
                        ebT.a(ebw);
                        ebw.transform(c);
                        canvas.clipPath(ebw);
                    }
                    canvas.drawPath(ebv, ebu);
                    if (c0925a.ebt().ebT() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a ebE2 = sVGAVideoShapeEntity.ebE();
                if (ebE2 != null && ebE2.getStrokeWidth() > 0) {
                    ebu.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a ebE3 = sVGAVideoShapeEntity.ebE();
                    if (ebE3 != null) {
                        ebu.setColor(ebE3.ebK());
                        ebu.setAlpha(Math.min(255, Math.max(0, (int) (c0925a.ebt().ebR() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a ebE4 = sVGAVideoShapeEntity.ebE();
                    if (ebE4 != null) {
                        ebu.setStrokeWidth(ebE4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a ebE5 = sVGAVideoShapeEntity.ebE();
                    if (ebE5 != null && (ebL = ebE5.ebL()) != null) {
                        if (l.H(ebL, "butt", true)) {
                            ebu.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.H(ebL, "round", true)) {
                            ebu.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.H(ebL, "square", true)) {
                            ebu.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a ebE6 = sVGAVideoShapeEntity.ebE();
                    if (ebE6 != null && (ebM = ebE6.ebM()) != null) {
                        if (l.H(ebM, "miter", true)) {
                            ebu.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.H(ebM, "round", true)) {
                            ebu.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.H(ebM, "bevel", true)) {
                            ebu.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a ebE7 = sVGAVideoShapeEntity.ebE();
                    if (ebE7 != null) {
                        ebu.setStrokeMiter(ebE7.ebN() * d);
                    }
                    SVGAVideoShapeEntity.a ebE8 = sVGAVideoShapeEntity.ebE();
                    if (ebE8 != null && (ebO = ebE8.ebO()) != null && ebO.length == 3 && (ebO[0] > 0 || ebO[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (ebO[0] < 1.0f ? 1.0f : ebO[0]) * d;
                        fArr[1] = (ebO[1] < 0.1f ? 0.1f : ebO[1]) * d;
                        ebu.setPathEffect(new DashPathEffect(fArr, ebO[2] * d));
                    }
                    if (c0925a.ebt().ebT() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b ebT2 = c0925a.ebt().ebT();
                    if (ebT2 != null) {
                        Path ebw2 = this.odZ.ebw();
                        ebT2.a(ebw2);
                        ebw2.transform(c);
                        canvas.clipPath(ebw2);
                    }
                    canvas.drawPath(ebv, ebu);
                    if (c0925a.ebt().ebT() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.oec);
        if (this.oec[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.oec[0];
        double d2 = this.oec[3];
        double d3 = this.oec[1];
        double d4 = this.oec[4];
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
        return ebr().ebY() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0925a c0925a, Canvas canvas, int i) {
        String ebs = c0925a.ebs();
        if (ebs != null) {
            m<Canvas, Integer, Boolean> mVar = this.ocY.ebb().get(ebs);
            if (mVar != null) {
                Matrix c = c(c0925a.ebt().ebF());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.ocY.ebc().get(ebs);
            if (rVar != null) {
                Matrix c2 = c(c0925a.ebt().ebF());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0925a.ebt().ebS().getWidth()), Integer.valueOf((int) c0925a.ebt().ebS().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0926b {
        private final Paint oeg = new Paint();
        private final Path oeh = new Path();
        private final Path oei = new Path();
        private final Matrix oej = new Matrix();
        private final Matrix oek = new Matrix();

        public final Paint ebu() {
            this.oeg.reset();
            return this.oeg;
        }

        public final Path ebv() {
            this.oeh.reset();
            return this.oeh;
        }

        public final Path ebw() {
            this.oei.reset();
            return this.oei;
        }

        public final Matrix ebx() {
            this.oej.reset();
            return this.oej;
        }

        public final Matrix eby() {
            this.oek.reset();
            return this.oek;
        }
    }

    @h
    /* loaded from: classes11.dex */
    public static final class a {
        private int oed;
        private int oee;
        private final HashMap<SVGAVideoShapeEntity, Path> oef = new HashMap<>();

        public final void aq(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.oed != canvas.getWidth() || this.oee != canvas.getHeight()) {
                this.oef.clear();
            }
            this.oed = canvas.getWidth();
            this.oee = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.oef.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.ebH());
                this.oef.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.oef.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.egj();
            }
            return path2;
        }
    }
}
