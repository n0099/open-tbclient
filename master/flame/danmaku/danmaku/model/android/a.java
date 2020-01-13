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
    public Canvas lEJ;
    private float nFC;
    private int width;
    private Camera nFz = new Camera();
    private Matrix matrix = new Matrix();
    private final C0772a nFA = new C0772a();
    private b nFB = new h();
    private float density = 1.0f;
    private int nFD = 160;
    private float nFE = 1.0f;
    private int nFF = 0;
    private boolean nFG = true;
    private int nFH = 2048;
    private int nFI = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0772a {
        private boolean isTranslucent;
        private float nFJ;
        public final TextPaint nFM;
        private Paint nFN;
        private Paint nFO;
        private Paint nFP;
        private final Map<Float, Float> nFK = new HashMap(10);
        public int nFQ = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nFR = 1.0f;
        public float nFS = 1.0f;
        private int nFT = 204;
        public boolean nFU = false;
        private boolean nFV = this.nFU;
        public boolean nFW = true;
        private boolean nFX = this.nFW;
        public boolean nFY = false;
        public boolean nFZ = this.nFY;
        public boolean nGa = true;
        private boolean nGb = this.nGa;
        private int nGc = master.flame.danmaku.danmaku.model.c.MAX;
        private float nGd = 1.0f;
        private boolean nGe = false;
        private int fCz = 0;
        private int nGf = 0;
        public final TextPaint nFL = new TextPaint();

        public C0772a() {
            this.nFL.setStrokeWidth(this.STROKE_WIDTH);
            this.nFM = new TextPaint(this.nFL);
            this.nFN = new Paint();
            this.nFO = new Paint();
            this.nFO.setStrokeWidth(this.nFQ);
            this.nFO.setStyle(Paint.Style.STROKE);
            this.nFP = new Paint();
            this.nFP.setStyle(Paint.Style.STROKE);
            this.nFP.setStrokeWidth(4.0f);
        }

        public void bI(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nFL.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nFR != f || this.nFS != f2 || this.nFT != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nFR = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nFS = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nFT = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nGe) {
                Float f = this.nFK.get(Float.valueOf(dVar.aAz));
                if (f == null || this.nFJ != this.nGd) {
                    this.nFJ = this.nGd;
                    f = Float.valueOf(dVar.aAz * this.nGd);
                    this.nFK.put(Float.valueOf(dVar.aAz), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nFX || this.nFZ) && this.STROKE_WIDTH > 0.0f && dVar.nEA != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nFP.setColor(dVar.borderColor);
            return this.nFP;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nFO.setColor(dVar.nEB);
            return this.nFO;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nFL;
            } else {
                textPaint = this.nFM;
                textPaint.set(this.nFL);
            }
            textPaint.setTextSize(dVar.aAz);
            a(dVar, textPaint);
            if (!this.nFV || this.SHADOW_RADIUS <= 0.0f || dVar.nEA == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nEA);
            }
            textPaint.setAntiAlias(this.nGb);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nFZ ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nEA & 16777215);
                    paint.setAlpha(this.nFZ ? (int) (this.nFT * (this.nGc / master.flame.danmaku.danmaku.model.c.MAX)) : this.nGc);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nGc);
                }
            } else if (z) {
                paint.setStyle(this.nFZ ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nEA & 16777215);
                paint.setAlpha(this.nFZ ? this.nFT : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nFV && this.nFX) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nFV) {
                return this.SHADOW_RADIUS;
            }
            if (this.nFX) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wK(boolean z) {
            this.nFX = this.nFW;
            this.nFV = this.nFU;
            this.nFZ = this.nFY;
            this.nGb = z && this.nGa;
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
        this.nFA.bI(f);
    }

    public void bJ(float f) {
        this.nFA.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nFA.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nFB) {
            this.nFB = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dKp() {
        return this.nFB;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nFA.fCz;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKR() {
        return this.nFA.nGf;
    }

    private void an(Canvas canvas) {
        this.lEJ = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nFG) {
                this.nFH = al(canvas);
                this.nFI = am(canvas);
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
        return this.nFD;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int n(master.flame.danmaku.danmaku.model.d dVar) {
        boolean z;
        int i;
        boolean z2;
        float dKx = dVar.dKx();
        float dKw = dVar.dKw();
        if (this.lEJ != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nEv) {
                return 0;
            } else {
                if (dVar.nEz == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.lEJ, dKw, dKx);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nFA.nFN;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nEv) {
                if (this.nFB.a(dVar, this.lEJ, dKw, dKx, paint, this.nFA.nFL)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nFA.nFL.setAlpha(paint.getAlpha());
                            this.nFA.nFM.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nFA.nFL);
                        }
                        a(dVar, this.lEJ, dKw, dKx, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ao(this.lEJ);
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
        if (this.nFB != null) {
            this.nFB.t(dVar);
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
        this.nFz.save();
        if (this.nFC != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nFz.setLocation(0.0f, 0.0f, this.nFC);
        }
        this.nFz.rotateY(-dVar.rotationY);
        this.nFz.rotateZ(-dVar.nEz);
        this.nFz.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nFz.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nFB != null) {
            this.nFB.a(dVar, canvas, f, f2, z, this.nFA);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nFA.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nFB != null) {
            this.nFB.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nFA.nFX) {
            this.nFA.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nFA.nFX) {
            this.nFA.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nFB.b(dVar, textPaint, z);
        a(dVar, dVar.nED, dVar.nEE);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0772a c0772a = this.nFA;
            f3 += 8;
            C0772a c0772a2 = this.nFA;
            f4 += 8;
        }
        dVar.nED = f3 + getStrokeWidth();
        dVar.nEE = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dKN() {
        return this.nFE;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bH(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nFF = (int) max;
        if (f > 1.0f) {
            this.nFF = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKO() {
        return this.nFF;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.density = f;
        this.nFD = i;
        this.nFE = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nFC = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void i(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nFA.nFU = false;
                this.nFA.nFW = true;
                this.nFA.nFY = false;
                bJ(fArr[0]);
                return;
            case 0:
                this.nFA.nFU = false;
                this.nFA.nFW = false;
                this.nFA.nFY = false;
                return;
            case 1:
                this.nFA.nFU = true;
                this.nFA.nFW = false;
                this.nFA.nFY = false;
                bI(fArr[0]);
                return;
            case 3:
                this.nFA.nFU = false;
                this.nFA.nFW = false;
                this.nFA.nFY = true;
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
    /* renamed from: dKX */
    public Canvas mZ() {
        return this.lEJ;
    }

    public float getStrokeWidth() {
        return this.nFA.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wJ(boolean z) {
        this.nFG = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nFG;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKP() {
        return this.nFH;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dKQ() {
        return this.nFI;
    }
}
