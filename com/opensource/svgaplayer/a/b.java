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
    private final c oCu;
    private final C0941b oDu;
    private final HashMap<String, Bitmap> oDv;
    private final a oDw;
    private final float[] oDx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.oCu = cVar;
        this.oDu = new C0941b();
        this.oDv = new HashMap<>();
        this.oDw = new a();
        this.oDx = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.oDw.ar(canvas);
        for (a.C0940a c0940a : OL(i)) {
            a(c0940a, canvas, i);
        }
        OM(i);
    }

    private final void OM(int i) {
        SoundPool ejg;
        Integer ejs;
        for (com.opensource.svgaplayer.entities.a aVar : eiN().ejf()) {
            if (aVar.ejq() == i && (ejg = eiN().ejg()) != null && (ejs = aVar.ejs()) != null) {
                aVar.u(Integer.valueOf(ejg.play(ejs.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.ejr() <= i) {
                Integer ejt = aVar.ejt();
                if (ejt != null) {
                    int intValue = ejt.intValue();
                    SoundPool ejg2 = eiN().ejg();
                    if (ejg2 != null) {
                        ejg2.stop(intValue);
                    }
                }
                aVar.u(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix ejo = this.oDu.ejo();
        ejo.postScale(ejj().ejN(), ejj().ejO());
        ejo.postTranslate(ejj().ejL(), ejj().ejM());
        ejo.preConcat(matrix);
        return ejo;
    }

    private final void a(a.C0940a c0940a, Canvas canvas, int i) {
        a(c0940a, canvas);
        b(c0940a, canvas);
        b(c0940a, canvas, i);
    }

    private final void a(a.C0940a c0940a, Canvas canvas) {
        String imageKey = c0940a.getImageKey();
        if (imageKey != null && !q.l(this.oCu.eiO().get(imageKey), true)) {
            Bitmap bitmap = this.oCu.eiP().get(imageKey);
            if (bitmap == null) {
                bitmap = eiN().ejh().get(imageKey);
            }
            if (bitmap != null) {
                Matrix c = c(c0940a.ejk().ejw());
                Paint ejl = this.oDu.ejl();
                ejl.setAntiAlias(eiN().ejb());
                ejl.setFilterBitmap(eiN().ejb());
                ejl.setAlpha((int) (c0940a.ejk().ejI() * 255));
                if (c0940a.ejk().ejK() != null) {
                    com.opensource.svgaplayer.entities.b ejK = c0940a.ejk().ejK();
                    if (ejK != null) {
                        canvas.save();
                        ejl.reset();
                        Path ejm = this.oDu.ejm();
                        ejK.a(ejm);
                        ejm.transform(c);
                        canvas.clipPath(ejm);
                        c.preScale((float) (c0940a.ejk().ejJ().getWidth() / bitmap.getWidth()), (float) (c0940a.ejk().ejJ().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, ejl);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0940a.ejk().ejJ().getWidth() / bitmap.getWidth()), (float) (c0940a.ejk().ejJ().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, ejl);
                }
                a(canvas, bitmap, c0940a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0940a c0940a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.oCu.eiV()) {
            this.oDv.clear();
            this.oCu.zu(false);
        }
        String imageKey = c0940a.getImageKey();
        if (imageKey != null) {
            Bitmap bitmap3 = null;
            String str = this.oCu.eiQ().get(imageKey);
            if (str != null) {
                TextPaint textPaint = this.oCu.eiR().get(imageKey);
                if (textPaint != null && (bitmap3 = this.oDv.get(imageKey)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.m(textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.oDv;
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
            StaticLayout staticLayout = this.oCu.eiS().get(imageKey);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.oDv.get(imageKey);
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
                    HashMap<String, Bitmap> hashMap2 = this.oDv;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(imageKey, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint ejl = this.oDu.ejl();
                ejl.setAntiAlias(eiN().ejb());
                if (c0940a.ejk().ejK() != null) {
                    com.opensource.svgaplayer.entities.b ejK = c0940a.ejk().ejK();
                    if (ejK != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        ejl.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path ejm = this.oDu.ejm();
                        ejK.a(ejm);
                        canvas.drawPath(ejm, ejl);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                ejl.setFilterBitmap(eiN().ejb());
                canvas.drawBitmap(bitmap2, matrix, ejl);
            }
        }
    }

    private final void b(a.C0940a c0940a, Canvas canvas) {
        float[] ejF;
        String ejD;
        String ejC;
        int ejA;
        Matrix c = c(c0940a.ejk().ejw());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0940a.ejk().jz()) {
            sVGAVideoShapeEntity.ejz();
            if (sVGAVideoShapeEntity.ejy() != null) {
                Paint ejl = this.oDu.ejl();
                ejl.reset();
                ejl.setAntiAlias(eiN().ejb());
                ejl.setAlpha((int) (c0940a.ejk().ejI() * 255));
                Path ejm = this.oDu.ejm();
                ejm.reset();
                ejm.addPath(this.oDw.a(sVGAVideoShapeEntity));
                Matrix ejp = this.oDu.ejp();
                ejp.reset();
                Matrix ejw = sVGAVideoShapeEntity.ejw();
                if (ejw != null) {
                    ejp.postConcat(ejw);
                }
                ejp.postConcat(c);
                ejm.transform(ejp);
                SVGAVideoShapeEntity.a ejv = sVGAVideoShapeEntity.ejv();
                if (ejv != null && (ejA = ejv.ejA()) != 0) {
                    ejl.setStyle(Paint.Style.FILL);
                    ejl.setColor(ejA);
                    ejl.setAlpha(Math.min(255, Math.max(0, (int) (c0940a.ejk().ejI() * 255))));
                    if (c0940a.ejk().ejK() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b ejK = c0940a.ejk().ejK();
                    if (ejK != null) {
                        Path ejn = this.oDu.ejn();
                        ejK.a(ejn);
                        ejn.transform(c);
                        canvas.clipPath(ejn);
                    }
                    canvas.drawPath(ejm, ejl);
                    if (c0940a.ejk().ejK() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a ejv2 = sVGAVideoShapeEntity.ejv();
                if (ejv2 != null && ejv2.getStrokeWidth() > 0) {
                    ejl.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a ejv3 = sVGAVideoShapeEntity.ejv();
                    if (ejv3 != null) {
                        ejl.setColor(ejv3.ejB());
                        ejl.setAlpha(Math.min(255, Math.max(0, (int) (c0940a.ejk().ejI() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a ejv4 = sVGAVideoShapeEntity.ejv();
                    if (ejv4 != null) {
                        ejl.setStrokeWidth(ejv4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a ejv5 = sVGAVideoShapeEntity.ejv();
                    if (ejv5 != null && (ejC = ejv5.ejC()) != null) {
                        if (l.H(ejC, "butt", true)) {
                            ejl.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.H(ejC, "round", true)) {
                            ejl.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.H(ejC, "square", true)) {
                            ejl.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a ejv6 = sVGAVideoShapeEntity.ejv();
                    if (ejv6 != null && (ejD = ejv6.ejD()) != null) {
                        if (l.H(ejD, "miter", true)) {
                            ejl.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.H(ejD, "round", true)) {
                            ejl.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.H(ejD, "bevel", true)) {
                            ejl.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a ejv7 = sVGAVideoShapeEntity.ejv();
                    if (ejv7 != null) {
                        ejl.setStrokeMiter(ejv7.ejE() * d);
                    }
                    SVGAVideoShapeEntity.a ejv8 = sVGAVideoShapeEntity.ejv();
                    if (ejv8 != null && (ejF = ejv8.ejF()) != null && ejF.length == 3 && (ejF[0] > 0 || ejF[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (ejF[0] < 1.0f ? 1.0f : ejF[0]) * d;
                        fArr[1] = (ejF[1] < 0.1f ? 0.1f : ejF[1]) * d;
                        ejl.setPathEffect(new DashPathEffect(fArr, ejF[2] * d));
                    }
                    if (c0940a.ejk().ejK() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b ejK2 = c0940a.ejk().ejK();
                    if (ejK2 != null) {
                        Path ejn2 = this.oDu.ejn();
                        ejK2.a(ejn2);
                        ejn2.transform(c);
                        canvas.clipPath(ejn2);
                    }
                    canvas.drawPath(ejm, ejl);
                    if (c0940a.ejk().ejK() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.oDx);
        if (this.oDx[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.oDx[0];
        double d2 = this.oDx[3];
        double d3 = this.oDx[1];
        double d4 = this.oDx[4];
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
        return ejj().ejP() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0940a c0940a, Canvas canvas, int i) {
        String imageKey = c0940a.getImageKey();
        if (imageKey != null) {
            m<Canvas, Integer, Boolean> mVar = this.oCu.eiT().get(imageKey);
            if (mVar != null) {
                Matrix c = c(c0940a.ejk().ejw());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.oCu.eiU().get(imageKey);
            if (rVar != null) {
                Matrix c2 = c(c0940a.ejk().ejw());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0940a.ejk().ejJ().getWidth()), Integer.valueOf((int) c0940a.ejk().ejJ().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C0941b {
        private final Paint oDz = new Paint();
        private final Path oDA = new Path();
        private final Path oDB = new Path();
        private final Matrix oDC = new Matrix();
        private final Matrix oDD = new Matrix();

        public final Paint ejl() {
            this.oDz.reset();
            return this.oDz;
        }

        public final Path ejm() {
            this.oDA.reset();
            return this.oDA;
        }

        public final Path ejn() {
            this.oDB.reset();
            return this.oDB;
        }

        public final Matrix ejo() {
            this.oDC.reset();
            return this.oDC;
        }

        public final Matrix ejp() {
            this.oDD.reset();
            return this.oDD;
        }
    }

    @h
    /* loaded from: classes15.dex */
    public static final class a {
        private int canvasHeight;
        private int canvasWidth;
        private final HashMap<SVGAVideoShapeEntity, Path> oDy = new HashMap<>();

        public final void ar(Canvas canvas) {
            q.n(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.oDy.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.n(sVGAVideoShapeEntity, "shape");
            if (!this.oDy.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.ejy());
                this.oDy.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.oDy.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.eob();
            }
            return path2;
        }
    }
}
