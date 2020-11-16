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
    public Canvas pYt;
    private float pYu;
    private int width;
    private Camera pYq = new Camera();
    private Matrix matrix = new Matrix();
    private final C1091a pYr = new C1091a();
    private b pYs = new h();
    private float dcl = 1.0f;
    private int densityDpi = 160;
    private float pYv = 1.0f;
    private int pYw = 0;
    private boolean pYx = true;
    private int pYy = 2048;
    private int pYz = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1091a {
        private boolean isTranslucent;
        private float pYA;
        public final TextPaint pYD;
        private Paint pYE;
        private Paint pYF;
        private Paint pYG;
        private final Map<Float, Float> pYB = new HashMap(10);
        public int pYH = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float pYI = 1.0f;
        public float pYJ = 1.0f;
        private int pYK = 204;
        public boolean pYL = false;
        private boolean pYM = this.pYL;
        public boolean pYN = true;
        private boolean pYO = this.pYN;
        public boolean pYP = false;
        public boolean pYQ = this.pYP;
        public boolean pYR = true;
        private boolean pYS = this.pYR;
        private int pYT = master.flame.danmaku.danmaku.model.c.MAX;
        private float pYU = 1.0f;
        private boolean pYV = false;
        private int margin = 0;
        private int pYW = 0;
        public final TextPaint pYC = new TextPaint();

        public C1091a() {
            this.pYC.setStrokeWidth(this.STROKE_WIDTH);
            this.pYD = new TextPaint(this.pYC);
            this.pYE = new Paint();
            this.pYF = new Paint();
            this.pYF.setStrokeWidth(this.pYH);
            this.pYF.setStyle(Paint.Style.STROKE);
            this.pYG = new Paint();
            this.pYG.setStyle(Paint.Style.STROKE);
            this.pYG.setStrokeWidth(4.0f);
        }

        public void bF(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.pYC.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.pYI != f || this.pYJ != f2 || this.pYK != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.pYI = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.pYJ = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.pYK = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.pYV) {
                Float f = this.pYB.get(Float.valueOf(dVar.bKr));
                if (f == null || this.pYA != this.pYU) {
                    this.pYA = this.pYU;
                    f = Float.valueOf(dVar.bKr * this.pYU);
                    this.pYB.put(Float.valueOf(dVar.bKr), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.pYO || this.pYQ) && this.STROKE_WIDTH > 0.0f && dVar.pXs != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.pYG.setColor(dVar.borderColor);
            return this.pYG;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.pYF.setColor(dVar.underlineColor);
            return this.pYF;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.pYC;
            } else {
                textPaint = this.pYD;
                textPaint.set(this.pYC);
            }
            textPaint.setTextSize(dVar.bKr);
            a(dVar, textPaint);
            if (!this.pYM || this.SHADOW_RADIUS <= 0.0f || dVar.pXs == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.pXs);
            }
            textPaint.setAntiAlias(this.pYS);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.pYQ ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.pXs & 16777215);
                    paint.setAlpha(this.pYQ ? (int) (this.pYK * (this.pYT / master.flame.danmaku.danmaku.model.c.MAX)) : this.pYT);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.pYT);
                }
            } else if (z) {
                paint.setStyle(this.pYQ ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.pXs & 16777215);
                paint.setAlpha(this.pYQ ? this.pYK : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.pYM && this.pYO) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.pYM) {
                return this.SHADOW_RADIUS;
            }
            if (this.pYO) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void Bj(boolean z) {
            this.pYO = this.pYN;
            this.pYM = this.pYL;
            this.pYQ = this.pYP;
            this.pYS = z && this.pYR;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int aw(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int ax(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void bF(float f) {
        this.pYr.bF(f);
    }

    public void bG(float f) {
        this.pYr.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.pYr.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.pYs) {
            this.pYs = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b eDc() {
        return this.pYs;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.pYr.margin;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDF() {
        return this.pYr.pYW;
    }

    private void ay(Canvas canvas) {
        this.pYt = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.pYx) {
                this.pYy = aw(canvas);
                this.pYz = ax(canvas);
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
        return this.dcl;
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
        float eDl = dVar.eDl();
        float eDk = dVar.eDk();
        if (this.pYt != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.pXn) {
                return 0;
            } else {
                if (dVar.pXr == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.pYt, eDk, eDl);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.pYr.pYE;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.pXn) {
                if (this.pYs.a(dVar, this.pYt, eDk, eDl, paint, this.pYr.pYC)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.pYr.pYC.setAlpha(paint.getAlpha());
                            this.pYr.pYD.setAlpha(paint.getAlpha());
                        } else {
                            c(this.pYr.pYC);
                        }
                        a(dVar, this.pYt, eDk, eDl, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        az(this.pYt);
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
        if (this.pYs != null) {
            this.pYs.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void az(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.pYq.save();
        if (this.pYu != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.pYq.setLocation(0.0f, 0.0f, this.pYu);
        }
        this.pYq.rotateY(-dVar.rotationY);
        this.pYq.rotateZ(-dVar.pXr);
        this.pYq.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.pYq.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.pYs != null) {
            this.pYs.a(dVar, canvas, f, f2, z, this.pYr);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.pYr.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.pYs != null) {
            this.pYs.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.pYr.pYO) {
            this.pYr.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.pYr.pYO) {
            this.pYr.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.pYs.b(dVar, textPaint, z);
        a(dVar, dVar.pXu, dVar.pXv);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C1091a c1091a = this.pYr;
            f3 += 8;
            C1091a c1091a2 = this.pYr;
            f4 += 8;
        }
        dVar.pXu = f3 + getStrokeWidth();
        dVar.pXv = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float eDB() {
        return this.pYv;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bE(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.pYw = (int) max;
        if (f > 1.0f) {
            this.pYw = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDC() {
        return this.pYw;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.dcl = f;
        this.densityDpi = i;
        this.pYv = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.pYu = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.pYr.pYL = false;
                this.pYr.pYN = true;
                this.pYr.pYP = false;
                bG(fArr[0]);
                return;
            case 0:
                this.pYr.pYL = false;
                this.pYr.pYN = false;
                this.pYr.pYP = false;
                return;
            case 1:
                this.pYr.pYL = true;
                this.pYr.pYN = false;
                this.pYr.pYP = false;
                bF(fArr[0]);
                return;
            case 3:
                this.pYr.pYL = false;
                this.pYr.pYN = false;
                this.pYr.pYP = true;
                f(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: aA */
    public void setExtraData(Canvas canvas) {
        ay(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: eDL */
    public Canvas ud() {
        return this.pYt;
    }

    public float getStrokeWidth() {
        return this.pYr.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void Bi(boolean z) {
        this.pYx = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.pYx;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDD() {
        return this.pYy;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eDE() {
        return this.pYz;
    }
}
