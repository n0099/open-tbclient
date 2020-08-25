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
/* loaded from: classes6.dex */
public class a extends master.flame.danmaku.danmaku.model.b<Canvas, Typeface> {
    private int height;
    public Canvas owO;
    private float owP;
    private int width;
    private Camera owL = new Camera();
    private Matrix matrix = new Matrix();
    private final C0981a owM = new C0981a();
    private b owN = new h();
    private float aty = 1.0f;
    private int densityDpi = 160;
    private float owQ = 1.0f;
    private int owR = 0;
    private boolean owS = true;
    private int owT = 2048;
    private int owU = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0981a {
        private boolean isTranslucent;
        private float owV;
        public final TextPaint owY;
        private Paint owZ;
        private Paint oxa;
        private Paint oxb;
        private final Map<Float, Float> owW = new HashMap(10);
        public int oxc = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float oxd = 1.0f;
        public float oxe = 1.0f;
        private int oxf = 204;
        public boolean oxg = false;
        private boolean oxh = this.oxg;
        public boolean oxi = true;
        private boolean oxj = this.oxi;
        public boolean oxk = false;
        public boolean oxl = this.oxk;
        public boolean oxm = true;
        private boolean oxn = this.oxm;
        private int oxo = master.flame.danmaku.danmaku.model.c.MAX;
        private float oxp = 1.0f;
        private boolean oxq = false;
        private int heQ = 0;
        private int oxr = 0;
        public final TextPaint owX = new TextPaint();

        public C0981a() {
            this.owX.setStrokeWidth(this.STROKE_WIDTH);
            this.owY = new TextPaint(this.owX);
            this.owZ = new Paint();
            this.oxa = new Paint();
            this.oxa.setStrokeWidth(this.oxc);
            this.oxa.setStyle(Paint.Style.STROKE);
            this.oxb = new Paint();
            this.oxb.setStyle(Paint.Style.STROKE);
            this.oxb.setStrokeWidth(4.0f);
        }

        public void aY(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.owX.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.oxd != f || this.oxe != f2 || this.oxf != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.oxd = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.oxe = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.oxf = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.oxq) {
                Float f = this.owW.get(Float.valueOf(dVar.btB));
                if (f == null || this.owV != this.oxp) {
                    this.owV = this.oxp;
                    f = Float.valueOf(dVar.btB * this.oxp);
                    this.owW.put(Float.valueOf(dVar.btB), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.oxj || this.oxl) && this.STROKE_WIDTH > 0.0f && dVar.ovM != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.oxb.setColor(dVar.borderColor);
            return this.oxb;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.oxa.setColor(dVar.underlineColor);
            return this.oxa;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.owX;
            } else {
                textPaint = this.owY;
                textPaint.set(this.owX);
            }
            textPaint.setTextSize(dVar.btB);
            a(dVar, textPaint);
            if (!this.oxh || this.SHADOW_RADIUS <= 0.0f || dVar.ovM == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.ovM);
            }
            textPaint.setAntiAlias(this.oxn);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.oxl ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.ovM & 16777215);
                    paint.setAlpha(this.oxl ? (int) (this.oxf * (this.oxo / master.flame.danmaku.danmaku.model.c.MAX)) : this.oxo);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.oxo);
                }
            } else if (z) {
                paint.setStyle(this.oxl ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.ovM & 16777215);
                paint.setAlpha(this.oxl ? this.oxf : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.oxh && this.oxj) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.oxh) {
                return this.SHADOW_RADIUS;
            }
            if (this.oxj) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void yS(boolean z) {
            this.oxj = this.oxi;
            this.oxh = this.oxg;
            this.oxl = this.oxk;
            this.oxn = z && this.oxm;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int as(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int at(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void aY(float f) {
        this.owM.aY(f);
    }

    public void aZ(float f) {
        this.owM.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.owM.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.owN) {
            this.owN = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b ehv() {
        return this.owN;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.owM.heQ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ehY() {
        return this.owM.oxr;
    }

    private void au(Canvas canvas) {
        this.owO = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.owS) {
                this.owT = as(canvas);
                this.owU = at(canvas);
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
        return this.aty;
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
        float ehE = dVar.ehE();
        float ehD = dVar.ehD();
        if (this.owO != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.ovH) {
                return 0;
            } else {
                if (dVar.ovL == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.owO, ehD, ehE);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.owM.owZ;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.ovH) {
                if (this.owN.a(dVar, this.owO, ehD, ehE, paint, this.owM.owX)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.owM.owX.setAlpha(paint.getAlpha());
                            this.owM.owY.setAlpha(paint.getAlpha());
                        } else {
                            c(this.owM.owX);
                        }
                        a(dVar, this.owO, ehD, ehE, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        av(this.owO);
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
        if (this.owN != null) {
            this.owN.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void av(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.owL.save();
        if (this.owP != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.owL.setLocation(0.0f, 0.0f, this.owP);
        }
        this.owL.rotateY(-dVar.rotationY);
        this.owL.rotateZ(-dVar.ovL);
        this.owL.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.owL.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.owN != null) {
            this.owN.a(dVar, canvas, f, f2, z, this.owM);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.owM.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.owN != null) {
            this.owN.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.owM.oxj) {
            this.owM.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.owM.oxj) {
            this.owM.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.owN.b(dVar, textPaint, z);
        a(dVar, dVar.ovO, dVar.ovP);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0981a c0981a = this.owM;
            f3 += 8;
            C0981a c0981a2 = this.owM;
            f4 += 8;
        }
        dVar.ovO = f3 + getStrokeWidth();
        dVar.ovP = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float ehU() {
        return this.owQ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aX(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.owR = (int) max;
        if (f > 1.0f) {
            this.owR = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ehV() {
        return this.owR;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.aty = f;
        this.densityDpi = i;
        this.owQ = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.owP = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.owM.oxg = false;
                this.owM.oxi = true;
                this.owM.oxk = false;
                aZ(fArr[0]);
                return;
            case 0:
                this.owM.oxg = false;
                this.owM.oxi = false;
                this.owM.oxk = false;
                return;
            case 1:
                this.owM.oxg = true;
                this.owM.oxi = false;
                this.owM.oxk = false;
                aY(fArr[0]);
                return;
            case 3:
                this.owM.oxg = false;
                this.owM.oxi = false;
                this.owM.oxk = true;
                f(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: aw */
    public void setExtraData(Canvas canvas) {
        au(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: eie */
    public Canvas tX() {
        return this.owO;
    }

    public float getStrokeWidth() {
        return this.owM.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void yR(boolean z) {
        this.owS = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.owS;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ehW() {
        return this.owT;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ehX() {
        return this.owU;
    }
}
