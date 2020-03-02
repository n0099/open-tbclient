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
    public Canvas lFx;
    private float nGB;
    private int width;
    private Camera nGy = new Camera();
    private Matrix matrix = new Matrix();
    private final C0780a nGz = new C0780a();
    private b nGA = new h();
    private float density = 1.0f;
    private int densityDpi = 160;
    private float nGC = 1.0f;
    private int nGD = 0;
    private boolean nGE = true;
    private int nGF = 2048;
    private int nGG = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0780a {
        private boolean isTranslucent;
        private float nGH;
        public final TextPaint nGK;
        private Paint nGL;
        private Paint nGM;
        private Paint nGN;
        private final Map<Float, Float> nGI = new HashMap(10);
        public int nGO = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nGP = 1.0f;
        public float nGQ = 1.0f;
        private int nGR = 204;
        public boolean nGS = false;
        private boolean nGT = this.nGS;
        public boolean nGU = true;
        private boolean nGV = this.nGU;
        public boolean nGW = false;
        public boolean nGX = this.nGW;
        public boolean nGY = true;
        private boolean nGZ = this.nGY;
        private int nHa = master.flame.danmaku.danmaku.model.c.MAX;
        private float nHb = 1.0f;
        private boolean nHc = false;
        private int fEY = 0;
        private int nHd = 0;
        public final TextPaint nGJ = new TextPaint();

        public C0780a() {
            this.nGJ.setStrokeWidth(this.STROKE_WIDTH);
            this.nGK = new TextPaint(this.nGJ);
            this.nGL = new Paint();
            this.nGM = new Paint();
            this.nGM.setStrokeWidth(this.nGO);
            this.nGM.setStyle(Paint.Style.STROKE);
            this.nGN = new Paint();
            this.nGN.setStyle(Paint.Style.STROKE);
            this.nGN.setStrokeWidth(4.0f);
        }

        public void bH(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nGJ.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nGP != f || this.nGQ != f2 || this.nGR != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nGP = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nGQ = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nGR = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nHc) {
                Float f = this.nGI.get(Float.valueOf(dVar.aEQ));
                if (f == null || this.nGH != this.nHb) {
                    this.nGH = this.nHb;
                    f = Float.valueOf(dVar.aEQ * this.nHb);
                    this.nGI.put(Float.valueOf(dVar.aEQ), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nGV || this.nGX) && this.STROKE_WIDTH > 0.0f && dVar.nFz != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nGN.setColor(dVar.borderColor);
            return this.nGN;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nGM.setColor(dVar.nFA);
            return this.nGM;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nGJ;
            } else {
                textPaint = this.nGK;
                textPaint.set(this.nGJ);
            }
            textPaint.setTextSize(dVar.aEQ);
            a(dVar, textPaint);
            if (!this.nGT || this.SHADOW_RADIUS <= 0.0f || dVar.nFz == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nFz);
            }
            textPaint.setAntiAlias(this.nGZ);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nGX ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nFz & 16777215);
                    paint.setAlpha(this.nGX ? (int) (this.nGR * (this.nHa / master.flame.danmaku.danmaku.model.c.MAX)) : this.nHa);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nHa);
                }
            } else if (z) {
                paint.setStyle(this.nGX ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nFz & 16777215);
                paint.setAlpha(this.nGX ? this.nGR : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nGT && this.nGV) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nGT) {
                return this.SHADOW_RADIUS;
            }
            if (this.nGV) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wN(boolean z) {
            this.nGV = this.nGU;
            this.nGT = this.nGS;
            this.nGX = this.nGW;
            this.nGZ = z && this.nGY;
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
        this.nGz.bH(f);
    }

    public void bI(float f) {
        this.nGz.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nGz.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nGA) {
            this.nGA = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dLG() {
        return this.nGA;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nGz.fEY;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMi() {
        return this.nGz.nHd;
    }

    private void an(Canvas canvas) {
        this.lFx = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nGE) {
                this.nGF = al(canvas);
                this.nGG = am(canvas);
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
        float dLO = dVar.dLO();
        float dLN = dVar.dLN();
        if (this.lFx != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nFu) {
                return 0;
            } else {
                if (dVar.nFy == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.lFx, dLN, dLO);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nGz.nGL;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nFu) {
                if (this.nGA.a(dVar, this.lFx, dLN, dLO, paint, this.nGz.nGJ)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nGz.nGJ.setAlpha(paint.getAlpha());
                            this.nGz.nGK.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nGz.nGJ);
                        }
                        a(dVar, this.lFx, dLN, dLO, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ao(this.lFx);
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
        if (this.nGA != null) {
            this.nGA.t(dVar);
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
        this.nGy.save();
        if (this.nGB != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nGy.setLocation(0.0f, 0.0f, this.nGB);
        }
        this.nGy.rotateY(-dVar.rotationY);
        this.nGy.rotateZ(-dVar.nFy);
        this.nGy.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nGy.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nGA != null) {
            this.nGA.a(dVar, canvas, f, f2, z, this.nGz);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nGz.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nGA != null) {
            this.nGA.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nGz.nGV) {
            this.nGz.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nGz.nGV) {
            this.nGz.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nGA.b(dVar, textPaint, z);
        a(dVar, dVar.nFC, dVar.nFD);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0780a c0780a = this.nGz;
            f3 += 8;
            C0780a c0780a2 = this.nGz;
            f4 += 8;
        }
        dVar.nFC = f3 + getStrokeWidth();
        dVar.nFD = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dMe() {
        return this.nGC;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bG(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nGD = (int) max;
        if (f > 1.0f) {
            this.nGD = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMf() {
        return this.nGD;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.density = f;
        this.densityDpi = i;
        this.nGC = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nGB = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void i(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nGz.nGS = false;
                this.nGz.nGU = true;
                this.nGz.nGW = false;
                bI(fArr[0]);
                return;
            case 0:
                this.nGz.nGS = false;
                this.nGz.nGU = false;
                this.nGz.nGW = false;
                return;
            case 1:
                this.nGz.nGS = true;
                this.nGz.nGU = false;
                this.nGz.nGW = false;
                bH(fArr[0]);
                return;
            case 3:
                this.nGz.nGS = false;
                this.nGz.nGU = false;
                this.nGz.nGW = true;
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
    /* renamed from: dMo */
    public Canvas nq() {
        return this.lFx;
    }

    public float getStrokeWidth() {
        return this.nGz.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wM(boolean z) {
        this.nGE = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nGE;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMg() {
        return this.nGF;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMh() {
        return this.nGG;
    }
}
