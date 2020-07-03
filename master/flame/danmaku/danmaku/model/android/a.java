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
    public Canvas nUc;
    private float nUd;
    private int width;
    private Camera nTZ = new Camera();
    private Matrix matrix = new Matrix();
    private final C0907a nUa = new C0907a();
    private b nUb = new h();
    private float aoE = 1.0f;
    private int densityDpi = 160;
    private float nUe = 1.0f;
    private int nUf = 0;
    private boolean nUg = true;
    private int nUh = 2048;
    private int nUi = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0907a {
        private boolean isTranslucent;
        private float nUj;
        public final TextPaint nUm;
        private Paint nUn;
        private Paint nUo;
        private Paint nUp;
        private final Map<Float, Float> nUk = new HashMap(10);
        public int nUq = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nUr = 1.0f;
        public float nUs = 1.0f;
        private int nUt = 204;
        public boolean nUu = false;
        private boolean nUv = this.nUu;
        public boolean nUw = true;
        private boolean nUx = this.nUw;
        public boolean nUy = false;
        public boolean nUz = this.nUy;
        public boolean nUA = true;
        private boolean nUB = this.nUA;
        private int nUC = master.flame.danmaku.danmaku.model.c.MAX;
        private float nUD = 1.0f;
        private boolean nUE = false;
        private int gMr = 0;
        private int nUF = 0;
        public final TextPaint nUl = new TextPaint();

        public C0907a() {
            this.nUl.setStrokeWidth(this.STROKE_WIDTH);
            this.nUm = new TextPaint(this.nUl);
            this.nUn = new Paint();
            this.nUo = new Paint();
            this.nUo.setStrokeWidth(this.nUq);
            this.nUo.setStyle(Paint.Style.STROKE);
            this.nUp = new Paint();
            this.nUp.setStyle(Paint.Style.STROKE);
            this.nUp.setStrokeWidth(4.0f);
        }

        public void aT(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nUl.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nUr != f || this.nUs != f2 || this.nUt != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nUr = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nUs = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nUt = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nUE) {
                Float f = this.nUk.get(Float.valueOf(dVar.bnu));
                if (f == null || this.nUj != this.nUD) {
                    this.nUj = this.nUD;
                    f = Float.valueOf(dVar.bnu * this.nUD);
                    this.nUk.put(Float.valueOf(dVar.bnu), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nUx || this.nUz) && this.STROKE_WIDTH > 0.0f && dVar.nSZ != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nUp.setColor(dVar.borderColor);
            return this.nUp;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nUo.setColor(dVar.nTa);
            return this.nUo;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nUl;
            } else {
                textPaint = this.nUm;
                textPaint.set(this.nUl);
            }
            textPaint.setTextSize(dVar.bnu);
            a(dVar, textPaint);
            if (!this.nUv || this.SHADOW_RADIUS <= 0.0f || dVar.nSZ == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nSZ);
            }
            textPaint.setAntiAlias(this.nUB);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nUz ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nSZ & 16777215);
                    paint.setAlpha(this.nUz ? (int) (this.nUt * (this.nUC / master.flame.danmaku.danmaku.model.c.MAX)) : this.nUC);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nUC);
                }
            } else if (z) {
                paint.setStyle(this.nUz ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nSZ & 16777215);
                paint.setAlpha(this.nUz ? this.nUt : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nUv && this.nUx) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nUv) {
                return this.SHADOW_RADIUS;
            }
            if (this.nUx) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void xv(boolean z) {
            this.nUx = this.nUw;
            this.nUv = this.nUu;
            this.nUz = this.nUy;
            this.nUB = z && this.nUA;
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
        this.nUa.aT(f);
    }

    public void aU(float f) {
        this.nUa.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nUa.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nUb) {
            this.nUb = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dRS() {
        return this.nUb;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nUa.gMr;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSu() {
        return this.nUa.nUF;
    }

    private void ao(Canvas canvas) {
        this.nUc = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nUg) {
                this.nUh = am(canvas);
                this.nUi = an(canvas);
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
        float dSa = dVar.dSa();
        float dRZ = dVar.dRZ();
        if (this.nUc != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nSU) {
                return 0;
            } else {
                if (dVar.nSY == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.nUc, dRZ, dSa);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nUa.nUn;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nSU) {
                if (this.nUb.a(dVar, this.nUc, dRZ, dSa, paint, this.nUa.nUl)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nUa.nUl.setAlpha(paint.getAlpha());
                            this.nUa.nUm.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nUa.nUl);
                        }
                        a(dVar, this.nUc, dRZ, dSa, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ap(this.nUc);
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
        if (this.nUb != null) {
            this.nUb.t(dVar);
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
        this.nTZ.save();
        if (this.nUd != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nTZ.setLocation(0.0f, 0.0f, this.nUd);
        }
        this.nTZ.rotateY(-dVar.rotationY);
        this.nTZ.rotateZ(-dVar.nSY);
        this.nTZ.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nTZ.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nUb != null) {
            this.nUb.a(dVar, canvas, f, f2, z, this.nUa);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nUa.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nUb != null) {
            this.nUb.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nUa.nUx) {
            this.nUa.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nUa.nUx) {
            this.nUa.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nUb.b(dVar, textPaint, z);
        a(dVar, dVar.nTc, dVar.nTd);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0907a c0907a = this.nUa;
            f3 += 8;
            C0907a c0907a2 = this.nUa;
            f4 += 8;
        }
        dVar.nTc = f3 + getStrokeWidth();
        dVar.nTd = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dSq() {
        return this.nUe;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aS(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nUf = (int) max;
        if (f > 1.0f) {
            this.nUf = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSr() {
        return this.nUf;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.aoE = f;
        this.densityDpi = i;
        this.nUe = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nUd = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nUa.nUu = false;
                this.nUa.nUw = true;
                this.nUa.nUy = false;
                aU(fArr[0]);
                return;
            case 0:
                this.nUa.nUu = false;
                this.nUa.nUw = false;
                this.nUa.nUy = false;
                return;
            case 1:
                this.nUa.nUu = true;
                this.nUa.nUw = false;
                this.nUa.nUy = false;
                aT(fArr[0]);
                return;
            case 3:
                this.nUa.nUu = false;
                this.nUa.nUw = false;
                this.nUa.nUy = true;
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
    /* renamed from: dSA */
    public Canvas sk() {
        return this.nUc;
    }

    public float getStrokeWidth() {
        return this.nUa.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void xu(boolean z) {
        this.nUg = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nUg;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSs() {
        return this.nUh;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dSt() {
        return this.nUi;
    }
}
