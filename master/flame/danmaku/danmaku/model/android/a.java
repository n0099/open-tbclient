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
    public Canvas oxg;
    private float oxh;
    private int width;
    private Camera oxd = new Camera();
    private Matrix matrix = new Matrix();
    private final C0981a oxe = new C0981a();
    private b oxf = new h();
    private float atA = 1.0f;
    private int densityDpi = 160;
    private float oxi = 1.0f;
    private int oxj = 0;
    private boolean oxk = true;
    private int oxl = 2048;
    private int oxm = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0981a {
        private boolean isTranslucent;
        private float oxn;
        public final TextPaint oxq;
        private Paint oxr;
        private Paint oxs;
        private Paint oxt;
        private final Map<Float, Float> oxo = new HashMap(10);
        public int oxu = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float oxv = 1.0f;
        public float oxw = 1.0f;
        private int oxx = 204;
        public boolean oxy = false;
        private boolean oxz = this.oxy;
        public boolean oxA = true;
        private boolean oxB = this.oxA;
        public boolean oxC = false;
        public boolean oxD = this.oxC;
        public boolean oxE = true;
        private boolean oxF = this.oxE;
        private int oxG = master.flame.danmaku.danmaku.model.c.MAX;
        private float oxH = 1.0f;
        private boolean oxI = false;
        private int heU = 0;
        private int oxJ = 0;
        public final TextPaint oxp = new TextPaint();

        public C0981a() {
            this.oxp.setStrokeWidth(this.STROKE_WIDTH);
            this.oxq = new TextPaint(this.oxp);
            this.oxr = new Paint();
            this.oxs = new Paint();
            this.oxs.setStrokeWidth(this.oxu);
            this.oxs.setStyle(Paint.Style.STROKE);
            this.oxt = new Paint();
            this.oxt.setStyle(Paint.Style.STROKE);
            this.oxt.setStrokeWidth(4.0f);
        }

        public void aY(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.oxp.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.oxv != f || this.oxw != f2 || this.oxx != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.oxv = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.oxw = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.oxx = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.oxI) {
                Float f = this.oxo.get(Float.valueOf(dVar.btE));
                if (f == null || this.oxn != this.oxH) {
                    this.oxn = this.oxH;
                    f = Float.valueOf(dVar.btE * this.oxH);
                    this.oxo.put(Float.valueOf(dVar.btE), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.oxB || this.oxD) && this.STROKE_WIDTH > 0.0f && dVar.owe != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.oxt.setColor(dVar.borderColor);
            return this.oxt;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.oxs.setColor(dVar.underlineColor);
            return this.oxs;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.oxp;
            } else {
                textPaint = this.oxq;
                textPaint.set(this.oxp);
            }
            textPaint.setTextSize(dVar.btE);
            a(dVar, textPaint);
            if (!this.oxz || this.SHADOW_RADIUS <= 0.0f || dVar.owe == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.owe);
            }
            textPaint.setAntiAlias(this.oxF);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.oxD ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.owe & 16777215);
                    paint.setAlpha(this.oxD ? (int) (this.oxx * (this.oxG / master.flame.danmaku.danmaku.model.c.MAX)) : this.oxG);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.oxG);
                }
            } else if (z) {
                paint.setStyle(this.oxD ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.owe & 16777215);
                paint.setAlpha(this.oxD ? this.oxx : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.oxz && this.oxB) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.oxz) {
                return this.SHADOW_RADIUS;
            }
            if (this.oxB) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void yU(boolean z) {
            this.oxB = this.oxA;
            this.oxz = this.oxy;
            this.oxD = this.oxC;
            this.oxF = z && this.oxE;
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
        this.oxe.aY(f);
    }

    public void aZ(float f) {
        this.oxe.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.oxe.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.oxf) {
            this.oxf = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b ehE() {
        return this.oxf;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.oxe.heU;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eih() {
        return this.oxe.oxJ;
    }

    private void au(Canvas canvas) {
        this.oxg = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.oxk) {
                this.oxl = as(canvas);
                this.oxm = at(canvas);
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
        return this.atA;
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
        float ehN = dVar.ehN();
        float ehM = dVar.ehM();
        if (this.oxg != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.ovZ) {
                return 0;
            } else {
                if (dVar.owd == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.oxg, ehM, ehN);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.oxe.oxr;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.ovZ) {
                if (this.oxf.a(dVar, this.oxg, ehM, ehN, paint, this.oxe.oxp)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.oxe.oxp.setAlpha(paint.getAlpha());
                            this.oxe.oxq.setAlpha(paint.getAlpha());
                        } else {
                            c(this.oxe.oxp);
                        }
                        a(dVar, this.oxg, ehM, ehN, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        av(this.oxg);
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
        if (this.oxf != null) {
            this.oxf.t(dVar);
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
        this.oxd.save();
        if (this.oxh != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.oxd.setLocation(0.0f, 0.0f, this.oxh);
        }
        this.oxd.rotateY(-dVar.rotationY);
        this.oxd.rotateZ(-dVar.owd);
        this.oxd.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.oxd.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.oxf != null) {
            this.oxf.a(dVar, canvas, f, f2, z, this.oxe);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.oxe.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.oxf != null) {
            this.oxf.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.oxe.oxB) {
            this.oxe.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.oxe.oxB) {
            this.oxe.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.oxf.b(dVar, textPaint, z);
        a(dVar, dVar.owg, dVar.owh);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0981a c0981a = this.oxe;
            f3 += 8;
            C0981a c0981a2 = this.oxe;
            f4 += 8;
        }
        dVar.owg = f3 + getStrokeWidth();
        dVar.owh = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float eid() {
        return this.oxi;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aX(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.oxj = (int) max;
        if (f > 1.0f) {
            this.oxj = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eie() {
        return this.oxj;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.atA = f;
        this.densityDpi = i;
        this.oxi = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.oxh = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.oxe.oxy = false;
                this.oxe.oxA = true;
                this.oxe.oxC = false;
                aZ(fArr[0]);
                return;
            case 0:
                this.oxe.oxy = false;
                this.oxe.oxA = false;
                this.oxe.oxC = false;
                return;
            case 1:
                this.oxe.oxy = true;
                this.oxe.oxA = false;
                this.oxe.oxC = false;
                aY(fArr[0]);
                return;
            case 3:
                this.oxe.oxy = false;
                this.oxe.oxA = false;
                this.oxe.oxC = true;
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
    /* renamed from: ein */
    public Canvas tX() {
        return this.oxg;
    }

    public float getStrokeWidth() {
        return this.oxe.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void yT(boolean z) {
        this.oxk = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.oxk;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eif() {
        return this.oxl;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eig() {
        return this.oxm;
    }
}
