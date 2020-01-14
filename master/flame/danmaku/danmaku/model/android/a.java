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
/* loaded from: classes4.dex */
public class a extends master.flame.danmaku.danmaku.model.b<Canvas, Typeface> {
    private int height;
    public Canvas lEO;
    private float nFH;
    private int width;
    private Camera nFE = new Camera();
    private Matrix matrix = new Matrix();
    private final C0772a nFF = new C0772a();
    private b nFG = new h();
    private float density = 1.0f;
    private int nFI = 160;
    private float nFJ = 1.0f;
    private int nFK = 0;
    private boolean nFL = true;
    private int nFM = 2048;
    private int nFN = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0772a {
        private boolean isTranslucent;
        private float nFO;
        public final TextPaint nFR;
        private Paint nFS;
        private Paint nFT;
        private Paint nFU;
        private final Map<Float, Float> nFP = new HashMap(10);
        public int nFV = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nFW = 1.0f;
        public float nFX = 1.0f;
        private int nFY = 204;
        public boolean nFZ = false;
        private boolean nGa = this.nFZ;
        public boolean nGb = true;
        private boolean nGc = this.nGb;
        public boolean nGd = false;
        public boolean nGe = this.nGd;
        public boolean nGf = true;
        private boolean nGg = this.nGf;
        private int nGh = master.flame.danmaku.danmaku.model.c.MAX;
        private float nGi = 1.0f;
        private boolean nGj = false;
        private int fCz = 0;
        private int nGk = 0;
        public final TextPaint nFQ = new TextPaint();

        public C0772a() {
            this.nFQ.setStrokeWidth(this.STROKE_WIDTH);
            this.nFR = new TextPaint(this.nFQ);
            this.nFS = new Paint();
            this.nFT = new Paint();
            this.nFT.setStrokeWidth(this.nFV);
            this.nFT.setStyle(Paint.Style.STROKE);
            this.nFU = new Paint();
            this.nFU.setStyle(Paint.Style.STROKE);
            this.nFU.setStrokeWidth(4.0f);
        }

        public void bI(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nFQ.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nFW != f || this.nFX != f2 || this.nFY != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nFW = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nFX = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nFY = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nGj) {
                Float f = this.nFP.get(Float.valueOf(dVar.aAz));
                if (f == null || this.nFO != this.nGi) {
                    this.nFO = this.nGi;
                    f = Float.valueOf(dVar.aAz * this.nGi);
                    this.nFP.put(Float.valueOf(dVar.aAz), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nGc || this.nGe) && this.STROKE_WIDTH > 0.0f && dVar.nEF != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nFU.setColor(dVar.borderColor);
            return this.nFU;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nFT.setColor(dVar.nEG);
            return this.nFT;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nFQ;
            } else {
                textPaint = this.nFR;
                textPaint.set(this.nFQ);
            }
            textPaint.setTextSize(dVar.aAz);
            a(dVar, textPaint);
            if (!this.nGa || this.SHADOW_RADIUS <= 0.0f || dVar.nEF == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nEF);
            }
            textPaint.setAntiAlias(this.nGg);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nGe ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nEF & 16777215);
                    paint.setAlpha(this.nGe ? (int) (this.nFY * (this.nGh / master.flame.danmaku.danmaku.model.c.MAX)) : this.nGh);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nGh);
                }
            } else if (z) {
                paint.setStyle(this.nGe ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nEF & 16777215);
                paint.setAlpha(this.nGe ? this.nFY : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nGa && this.nGc) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nGa) {
                return this.SHADOW_RADIUS;
            }
            if (this.nGc) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wK(boolean z) {
            this.nGc = this.nGb;
            this.nGa = this.nFZ;
            this.nGe = this.nGd;
            this.nGg = z && this.nGf;
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

    public void bI(float f) {
        this.nFF.bI(f);
    }

    public void bJ(float f) {
        this.nFF.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nFF.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nFG) {
            this.nFG = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dKr() {
        return this.nFG;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nFF.fCz;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKT() {
        return this.nFF.nGk;
    }

    private void an(Canvas canvas) {
        this.lEO = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nFL) {
                this.nFM = al(canvas);
                this.nFN = am(canvas);
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
        return this.nFI;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int n(master.flame.danmaku.danmaku.model.d dVar) {
        boolean z;
        int i;
        boolean z2;
        float dKz = dVar.dKz();
        float dKy = dVar.dKy();
        if (this.lEO != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nEA) {
                return 0;
            } else {
                if (dVar.nEE == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.lEO, dKy, dKz);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nFF.nFS;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nEA) {
                if (this.nFG.a(dVar, this.lEO, dKy, dKz, paint, this.nFF.nFQ)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nFF.nFQ.setAlpha(paint.getAlpha());
                            this.nFF.nFR.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nFF.nFQ);
                        }
                        a(dVar, this.lEO, dKy, dKz, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ao(this.lEO);
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
        if (this.nFG != null) {
            this.nFG.t(dVar);
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
        this.nFE.save();
        if (this.nFH != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nFE.setLocation(0.0f, 0.0f, this.nFH);
        }
        this.nFE.rotateY(-dVar.rotationY);
        this.nFE.rotateZ(-dVar.nEE);
        this.nFE.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nFE.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nFG != null) {
            this.nFG.a(dVar, canvas, f, f2, z, this.nFF);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nFF.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nFG != null) {
            this.nFG.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nFF.nGc) {
            this.nFF.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nFF.nGc) {
            this.nFF.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nFG.b(dVar, textPaint, z);
        a(dVar, dVar.nEI, dVar.nEJ);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0772a c0772a = this.nFF;
            f3 += 8;
            C0772a c0772a2 = this.nFF;
            f4 += 8;
        }
        dVar.nEI = f3 + getStrokeWidth();
        dVar.nEJ = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dKP() {
        return this.nFJ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bH(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nFK = (int) max;
        if (f > 1.0f) {
            this.nFK = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKQ() {
        return this.nFK;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.density = f;
        this.nFI = i;
        this.nFJ = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nFH = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void i(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nFF.nFZ = false;
                this.nFF.nGb = true;
                this.nFF.nGd = false;
                bJ(fArr[0]);
                return;
            case 0:
                this.nFF.nFZ = false;
                this.nFF.nGb = false;
                this.nFF.nGd = false;
                return;
            case 1:
                this.nFF.nFZ = true;
                this.nFF.nGb = false;
                this.nFF.nGd = false;
                bI(fArr[0]);
                return;
            case 3:
                this.nFF.nFZ = false;
                this.nFF.nGb = false;
                this.nFF.nGd = true;
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
    /* renamed from: dKZ */
    public Canvas mZ() {
        return this.lEO;
    }

    public float getStrokeWidth() {
        return this.nFF.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wJ(boolean z) {
        this.nFL = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nFL;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKR() {
        return this.nFM;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKS() {
        return this.nFN;
    }
}
