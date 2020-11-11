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
    public Canvas pWQ;
    private float pWR;
    private int width;
    private Camera pWN = new Camera();
    private Matrix matrix = new Matrix();
    private final C1088a pWO = new C1088a();
    private b pWP = new h();
    private float auM = 1.0f;
    private int densityDpi = 160;
    private float pWS = 1.0f;
    private int pWT = 0;
    private boolean pWU = true;
    private int pWV = 2048;
    private int pWW = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1088a {
        private boolean isTranslucent;
        private float pWX;
        public final TextPaint pXa;
        private Paint pXb;
        private Paint pXc;
        private Paint pXd;
        private final Map<Float, Float> pWY = new HashMap(10);
        public int pXe = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float pXf = 1.0f;
        public float pXg = 1.0f;
        private int pXh = 204;
        public boolean pXi = false;
        private boolean pXj = this.pXi;
        public boolean pXk = true;
        private boolean pXl = this.pXk;
        public boolean pXm = false;
        public boolean pXn = this.pXm;
        public boolean pXo = true;
        private boolean pXp = this.pXo;
        private int pXq = master.flame.danmaku.danmaku.model.c.MAX;
        private float pXr = 1.0f;
        private boolean pXs = false;
        private int margin = 0;
        private int pXt = 0;
        public final TextPaint pWZ = new TextPaint();

        public C1088a() {
            this.pWZ.setStrokeWidth(this.STROKE_WIDTH);
            this.pXa = new TextPaint(this.pWZ);
            this.pXb = new Paint();
            this.pXc = new Paint();
            this.pXc.setStrokeWidth(this.pXe);
            this.pXc.setStyle(Paint.Style.STROKE);
            this.pXd = new Paint();
            this.pXd.setStyle(Paint.Style.STROKE);
            this.pXd.setStrokeWidth(4.0f);
        }

        public void bx(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.pWZ.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.pXf != f || this.pXg != f2 || this.pXh != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.pXf = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.pXg = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.pXh = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.pXs) {
                Float f = this.pWY.get(Float.valueOf(dVar.bMb));
                if (f == null || this.pWX != this.pXr) {
                    this.pWX = this.pXr;
                    f = Float.valueOf(dVar.bMb * this.pXr);
                    this.pWY.put(Float.valueOf(dVar.bMb), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.pXl || this.pXn) && this.STROKE_WIDTH > 0.0f && dVar.pVP != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.pXd.setColor(dVar.borderColor);
            return this.pXd;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.pXc.setColor(dVar.underlineColor);
            return this.pXc;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.pWZ;
            } else {
                textPaint = this.pXa;
                textPaint.set(this.pWZ);
            }
            textPaint.setTextSize(dVar.bMb);
            a(dVar, textPaint);
            if (!this.pXj || this.SHADOW_RADIUS <= 0.0f || dVar.pVP == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.pVP);
            }
            textPaint.setAntiAlias(this.pXp);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.pXn ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.pVP & 16777215);
                    paint.setAlpha(this.pXn ? (int) (this.pXh * (this.pXq / master.flame.danmaku.danmaku.model.c.MAX)) : this.pXq);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.pXq);
                }
            } else if (z) {
                paint.setStyle(this.pXn ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.pVP & 16777215);
                paint.setAlpha(this.pXn ? this.pXh : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.pXj && this.pXl) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.pXj) {
                return this.SHADOW_RADIUS;
            }
            if (this.pXl) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void Bc(boolean z) {
            this.pXl = this.pXk;
            this.pXj = this.pXi;
            this.pXn = this.pXm;
            this.pXp = z && this.pXo;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int av(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int aw(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void bx(float f) {
        this.pWO.bx(f);
    }

    public void by(float f) {
        this.pWO.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.pWO.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.pWP) {
            this.pWP = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b eDb() {
        return this.pWP;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.pWO.margin;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDE() {
        return this.pWO.pXt;
    }

    private void ax(Canvas canvas) {
        this.pWQ = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.pWU) {
                this.pWV = av(canvas);
                this.pWW = aw(canvas);
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
        return this.auM;
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
        float eDk = dVar.eDk();
        float eDj = dVar.eDj();
        if (this.pWQ != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.pVK) {
                return 0;
            } else {
                if (dVar.pVO == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.pWQ, eDj, eDk);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.pWO.pXb;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.pVK) {
                if (this.pWP.a(dVar, this.pWQ, eDj, eDk, paint, this.pWO.pWZ)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.pWO.pWZ.setAlpha(paint.getAlpha());
                            this.pWO.pXa.setAlpha(paint.getAlpha());
                        } else {
                            c(this.pWO.pWZ);
                        }
                        a(dVar, this.pWQ, eDj, eDk, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ay(this.pWQ);
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
        if (this.pWP != null) {
            this.pWP.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void ay(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.pWN.save();
        if (this.pWR != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.pWN.setLocation(0.0f, 0.0f, this.pWR);
        }
        this.pWN.rotateY(-dVar.rotationY);
        this.pWN.rotateZ(-dVar.pVO);
        this.pWN.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.pWN.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.pWP != null) {
            this.pWP.a(dVar, canvas, f, f2, z, this.pWO);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.pWO.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.pWP != null) {
            this.pWP.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.pWO.pXl) {
            this.pWO.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.pWO.pXl) {
            this.pWO.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.pWP.b(dVar, textPaint, z);
        a(dVar, dVar.pVR, dVar.pVS);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C1088a c1088a = this.pWO;
            f3 += 8;
            C1088a c1088a2 = this.pWO;
            f4 += 8;
        }
        dVar.pVR = f3 + getStrokeWidth();
        dVar.pVS = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float eDA() {
        return this.pWS;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bw(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.pWT = (int) max;
        if (f > 1.0f) {
            this.pWT = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDB() {
        return this.pWT;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.auM = f;
        this.densityDpi = i;
        this.pWS = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.pWR = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.pWO.pXi = false;
                this.pWO.pXk = true;
                this.pWO.pXm = false;
                by(fArr[0]);
                return;
            case 0:
                this.pWO.pXi = false;
                this.pWO.pXk = false;
                this.pWO.pXm = false;
                return;
            case 1:
                this.pWO.pXi = true;
                this.pWO.pXk = false;
                this.pWO.pXm = false;
                bx(fArr[0]);
                return;
            case 3:
                this.pWO.pXi = false;
                this.pWO.pXk = false;
                this.pWO.pXm = true;
                f(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: az */
    public void setExtraData(Canvas canvas) {
        ax(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: eDK */
    public Canvas ud() {
        return this.pWQ;
    }

    public float getStrokeWidth() {
        return this.pWO.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void Bb(boolean z) {
        this.pWU = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.pWU;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDC() {
        return this.pWV;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDD() {
        return this.pWW;
    }
}
