package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a extends master.flame.danmaku.danmaku.model.b<Canvas, Typeface> {
    private int height;
    public Canvas nUf;
    private float nUg;
    private int width;
    private Camera nUc = new Camera();
    private Matrix matrix = new Matrix();
    private final C0908a nUd = new C0908a();
    private b nUe = new h();
    private float aoE = 1.0f;
    private int densityDpi = 160;
    private float nUh = 1.0f;
    private int nUi = 0;
    private boolean nUj = true;
    private int nUk = 2048;
    private int nUl = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0908a {
        private boolean isTranslucent;
        private float nUm;
        public final TextPaint nUp;
        private Paint nUq;
        private Paint nUr;
        private Paint nUs;
        private final Map<Float, Float> nUn = new HashMap(10);
        public int nUt = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nUu = 1.0f;
        public float nUv = 1.0f;
        private int nUw = 204;
        public boolean nUx = false;
        private boolean nUy = this.nUx;
        public boolean nUz = true;
        private boolean nUA = this.nUz;
        public boolean nUB = false;
        public boolean nUC = this.nUB;
        public boolean nUD = true;
        private boolean nUE = this.nUD;
        private int nUF = master.flame.danmaku.danmaku.model.c.MAX;
        private float nUG = 1.0f;
        private boolean nUH = false;
        private int gMr = 0;
        private int nUI = 0;
        public final TextPaint nUo = new TextPaint();

        public C0908a() {
            this.nUo.setStrokeWidth(this.STROKE_WIDTH);
            this.nUp = new TextPaint(this.nUo);
            this.nUq = new Paint();
            this.nUr = new Paint();
            this.nUr.setStrokeWidth(this.nUt);
            this.nUr.setStyle(Paint.Style.STROKE);
            this.nUs = new Paint();
            this.nUs.setStyle(Paint.Style.STROKE);
            this.nUs.setStrokeWidth(4.0f);
        }

        public void aT(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nUo.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nUu != f || this.nUv != f2 || this.nUw != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nUu = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nUv = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nUw = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nUH) {
                Float f = this.nUn.get(Float.valueOf(dVar.bnu));
                if (f == null || this.nUm != this.nUG) {
                    this.nUm = this.nUG;
                    f = Float.valueOf(dVar.bnu * this.nUG);
                    this.nUn.put(Float.valueOf(dVar.bnu), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nUA || this.nUC) && this.STROKE_WIDTH > 0.0f && dVar.nTc != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nUs.setColor(dVar.borderColor);
            return this.nUs;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nUr.setColor(dVar.nTd);
            return this.nUr;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nUo;
            } else {
                textPaint = this.nUp;
                textPaint.set(this.nUo);
            }
            textPaint.setTextSize(dVar.bnu);
            a(dVar, textPaint);
            if (!this.nUy || this.SHADOW_RADIUS <= 0.0f || dVar.nTc == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nTc);
            }
            textPaint.setAntiAlias(this.nUE);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nUC ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nTc & 16777215);
                    paint.setAlpha(this.nUC ? (int) (this.nUw * (this.nUF / master.flame.danmaku.danmaku.model.c.MAX)) : this.nUF);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nUF);
                }
            } else if (z) {
                paint.setStyle(this.nUC ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nTc & 16777215);
                paint.setAlpha(this.nUC ? this.nUw : master.flame.danmaku.danmaku.model.c.MAX);
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(dVar.textColor & 16777215);
                paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
            }
            if (dVar.getType() == 7) {
                paint.setAlpha(dVar.getAlpha());
            }
        }

        public float getStrokeWidth() {
            if (this.nUy && this.nUA) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nUy) {
                return this.SHADOW_RADIUS;
            }
            if (this.nUA) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void xv(boolean z) {
            this.nUA = this.nUz;
            this.nUy = this.nUx;
            this.nUC = this.nUB;
            this.nUE = z && this.nUD;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int am(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int an(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void aT(float f) {
        this.nUd.aT(f);
    }

    public void aU(float f) {
        this.nUd.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nUd.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nUe) {
            this.nUe = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dRW() {
        return this.nUe;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nUd.gMr;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSy() {
        return this.nUd.nUI;
    }

    private void ao(Canvas canvas) {
        this.nUf = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nUj) {
                this.nUk = am(canvas);
                this.nUl = an(canvas);
            }
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getWidth() {
        return this.width;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getHeight() {
        return this.height;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float getDensity() {
        return this.aoE;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getDensityDpi() {
        return this.densityDpi;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int n(master.flame.danmaku.danmaku.model.d dVar) {
        boolean z;
        int i;
        boolean z2;
        float dSe = dVar.dSe();
        float dSd = dVar.dSd();
        if (this.nUf != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nSX) {
                return 0;
            } else {
                if (dVar.nTb == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.nUf, dSd, dSe);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nUd.nUq;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nSX) {
                if (this.nUe.a(dVar, this.nUf, dSd, dSe, paint, this.nUd.nUo)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nUd.nUo.setAlpha(paint.getAlpha());
                            this.nUd.nUp.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nUd.nUo);
                        }
                        a(dVar, this.nUf, dSd, dSe, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ap(this.nUf);
                    } catch (Exception e2) {
                    }
                }
                return i;
            }
            return 0;
        }
        return 0;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void o(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nUe != null) {
            this.nUe.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void ap(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.nUc.save();
        if (this.nUg != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nUc.setLocation(0.0f, 0.0f, this.nUg);
        }
        this.nUc.rotateY(-dVar.rotationY);
        this.nUc.rotateZ(-dVar.nTb);
        this.nUc.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nUc.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nUe != null) {
            this.nUe.a(dVar, canvas, f, f2, z, this.nUd);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nUd.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nUe != null) {
            this.nUe.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nUd.nUA) {
            this.nUd.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nUd.nUA) {
            this.nUd.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nUe.b(dVar, textPaint, z);
        a(dVar, dVar.nTf, dVar.nTg);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0908a c0908a = this.nUd;
            f3 += 8;
            C0908a c0908a2 = this.nUd;
            f4 += 8;
        }
        dVar.nTf = f3 + getStrokeWidth();
        dVar.nTg = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dSu() {
        return this.nUh;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aS(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nUi = (int) max;
        if (f > 1.0f) {
            this.nUi = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSv() {
        return this.nUi;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.aoE = f;
        this.densityDpi = i;
        this.nUh = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nUg = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nUd.nUx = false;
                this.nUd.nUz = true;
                this.nUd.nUB = false;
                aU(fArr[0]);
                return;
            case 0:
                this.nUd.nUx = false;
                this.nUd.nUz = false;
                this.nUd.nUB = false;
                return;
            case 1:
                this.nUd.nUx = true;
                this.nUd.nUz = false;
                this.nUd.nUB = false;
                aT(fArr[0]);
                return;
            case 3:
                this.nUd.nUx = false;
                this.nUd.nUz = false;
                this.nUd.nUB = true;
                e(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: aq */
    public void setExtraData(Canvas canvas) {
        ao(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: dSE */
    public Canvas sk() {
        return this.nUf;
    }

    public float getStrokeWidth() {
        return this.nUd.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void xu(boolean z) {
        this.nUj = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nUj;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSw() {
        return this.nUk;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSx() {
        return this.nUl;
    }
}
