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
    public Canvas lFv;
    private float nGz;
    private int width;
    private Camera nGw = new Camera();
    private Matrix matrix = new Matrix();
    private final C0780a nGx = new C0780a();
    private b nGy = new h();
    private float density = 1.0f;
    private int densityDpi = 160;
    private float nGA = 1.0f;
    private int nGB = 0;
    private boolean nGC = true;
    private int nGD = 2048;
    private int nGE = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0780a {
        private boolean isTranslucent;
        private float nGF;
        public final TextPaint nGI;
        private Paint nGJ;
        private Paint nGK;
        private Paint nGL;
        private final Map<Float, Float> nGG = new HashMap(10);
        public int nGM = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nGN = 1.0f;
        public float nGO = 1.0f;
        private int nGP = 204;
        public boolean nGQ = false;
        private boolean nGR = this.nGQ;
        public boolean nGS = true;
        private boolean nGT = this.nGS;
        public boolean nGU = false;
        public boolean nGV = this.nGU;
        public boolean nGW = true;
        private boolean nGX = this.nGW;
        private int nGY = master.flame.danmaku.danmaku.model.c.MAX;
        private float nGZ = 1.0f;
        private boolean nHa = false;
        private int fEW = 0;
        private int nHb = 0;
        public final TextPaint nGH = new TextPaint();

        public C0780a() {
            this.nGH.setStrokeWidth(this.STROKE_WIDTH);
            this.nGI = new TextPaint(this.nGH);
            this.nGJ = new Paint();
            this.nGK = new Paint();
            this.nGK.setStrokeWidth(this.nGM);
            this.nGK.setStyle(Paint.Style.STROKE);
            this.nGL = new Paint();
            this.nGL.setStyle(Paint.Style.STROKE);
            this.nGL.setStrokeWidth(4.0f);
        }

        public void bH(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nGH.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nGN != f || this.nGO != f2 || this.nGP != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nGN = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nGO = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nGP = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nHa) {
                Float f = this.nGG.get(Float.valueOf(dVar.aEP));
                if (f == null || this.nGF != this.nGZ) {
                    this.nGF = this.nGZ;
                    f = Float.valueOf(dVar.aEP * this.nGZ);
                    this.nGG.put(Float.valueOf(dVar.aEP), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nGT || this.nGV) && this.STROKE_WIDTH > 0.0f && dVar.nFx != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nGL.setColor(dVar.borderColor);
            return this.nGL;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nGK.setColor(dVar.nFy);
            return this.nGK;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nGH;
            } else {
                textPaint = this.nGI;
                textPaint.set(this.nGH);
            }
            textPaint.setTextSize(dVar.aEP);
            a(dVar, textPaint);
            if (!this.nGR || this.SHADOW_RADIUS <= 0.0f || dVar.nFx == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nFx);
            }
            textPaint.setAntiAlias(this.nGX);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nGV ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nFx & 16777215);
                    paint.setAlpha(this.nGV ? (int) (this.nGP * (this.nGY / master.flame.danmaku.danmaku.model.c.MAX)) : this.nGY);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nGY);
                }
            } else if (z) {
                paint.setStyle(this.nGV ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nFx & 16777215);
                paint.setAlpha(this.nGV ? this.nGP : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nGR && this.nGT) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nGR) {
                return this.SHADOW_RADIUS;
            }
            if (this.nGT) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wN(boolean z) {
            this.nGT = this.nGS;
            this.nGR = this.nGQ;
            this.nGV = this.nGU;
            this.nGX = z && this.nGW;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int al(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int am(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void bH(float f) {
        this.nGx.bH(f);
    }

    public void bI(float f) {
        this.nGx.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nGx.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nGy) {
            this.nGy = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dLE() {
        return this.nGy;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nGx.fEW;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMg() {
        return this.nGx.nHb;
    }

    private void an(Canvas canvas) {
        this.lFv = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nGC) {
                this.nGD = al(canvas);
                this.nGE = am(canvas);
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
        return this.density;
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
        float dLM = dVar.dLM();
        float dLL = dVar.dLL();
        if (this.lFv != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nFs) {
                return 0;
            } else {
                if (dVar.nFw == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.lFv, dLL, dLM);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nGx.nGJ;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nFs) {
                if (this.nGy.a(dVar, this.lFv, dLL, dLM, paint, this.nGx.nGH)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nGx.nGH.setAlpha(paint.getAlpha());
                            this.nGx.nGI.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nGx.nGH);
                        }
                        a(dVar, this.lFv, dLL, dLM, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ao(this.lFv);
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
        if (this.nGy != null) {
            this.nGy.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void ao(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.nGw.save();
        if (this.nGz != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nGw.setLocation(0.0f, 0.0f, this.nGz);
        }
        this.nGw.rotateY(-dVar.rotationY);
        this.nGw.rotateZ(-dVar.nFw);
        this.nGw.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nGw.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nGy != null) {
            this.nGy.a(dVar, canvas, f, f2, z, this.nGx);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nGx.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nGy != null) {
            this.nGy.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nGx.nGT) {
            this.nGx.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nGx.nGT) {
            this.nGx.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nGy.b(dVar, textPaint, z);
        a(dVar, dVar.nFA, dVar.nFB);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0780a c0780a = this.nGx;
            f3 += 8;
            C0780a c0780a2 = this.nGx;
            f4 += 8;
        }
        dVar.nFA = f3 + getStrokeWidth();
        dVar.nFB = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dMc() {
        return this.nGA;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bG(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nGB = (int) max;
        if (f > 1.0f) {
            this.nGB = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMd() {
        return this.nGB;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.density = f;
        this.densityDpi = i;
        this.nGA = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nGz = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void i(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nGx.nGQ = false;
                this.nGx.nGS = true;
                this.nGx.nGU = false;
                bI(fArr[0]);
                return;
            case 0:
                this.nGx.nGQ = false;
                this.nGx.nGS = false;
                this.nGx.nGU = false;
                return;
            case 1:
                this.nGx.nGQ = true;
                this.nGx.nGS = false;
                this.nGx.nGU = false;
                bH(fArr[0]);
                return;
            case 3:
                this.nGx.nGQ = false;
                this.nGx.nGS = false;
                this.nGx.nGU = true;
                e(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: ap */
    public void setExtraData(Canvas canvas) {
        an(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: dMm */
    public Canvas nq() {
        return this.lFv;
    }

    public float getStrokeWidth() {
        return this.nGx.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wM(boolean z) {
        this.nGC = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nGC;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMe() {
        return this.nGD;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMf() {
        return this.nGE;
    }
}
