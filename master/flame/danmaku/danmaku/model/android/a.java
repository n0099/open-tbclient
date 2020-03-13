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
    public Canvas lFI;
    private float nGM;
    private int width;
    private Camera nGJ = new Camera();
    private Matrix matrix = new Matrix();
    private final C0780a nGK = new C0780a();
    private b nGL = new h();
    private float density = 1.0f;
    private int densityDpi = 160;
    private float nGN = 1.0f;
    private int nGO = 0;
    private boolean nGP = true;
    private int nGQ = 2048;
    private int nGR = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0780a {
        private boolean isTranslucent;
        private float nGS;
        public final TextPaint nGV;
        private Paint nGW;
        private Paint nGX;
        private Paint nGY;
        private final Map<Float, Float> nGT = new HashMap(10);
        public int nGZ = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nHa = 1.0f;
        public float nHb = 1.0f;
        private int nHc = 204;
        public boolean nHd = false;
        private boolean nHe = this.nHd;
        public boolean nHf = true;
        private boolean nHg = this.nHf;
        public boolean nHh = false;
        public boolean nHi = this.nHh;
        public boolean nHj = true;
        private boolean nHk = this.nHj;
        private int nHl = master.flame.danmaku.danmaku.model.c.MAX;
        private float nHm = 1.0f;
        private boolean nHn = false;
        private int fFl = 0;
        private int nHo = 0;
        public final TextPaint nGU = new TextPaint();

        public C0780a() {
            this.nGU.setStrokeWidth(this.STROKE_WIDTH);
            this.nGV = new TextPaint(this.nGU);
            this.nGW = new Paint();
            this.nGX = new Paint();
            this.nGX.setStrokeWidth(this.nGZ);
            this.nGX.setStyle(Paint.Style.STROKE);
            this.nGY = new Paint();
            this.nGY.setStyle(Paint.Style.STROKE);
            this.nGY.setStrokeWidth(4.0f);
        }

        public void bH(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nGU.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nHa != f || this.nHb != f2 || this.nHc != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nHa = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nHb = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nHc = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nHn) {
                Float f = this.nGT.get(Float.valueOf(dVar.aER));
                if (f == null || this.nGS != this.nHm) {
                    this.nGS = this.nHm;
                    f = Float.valueOf(dVar.aER * this.nHm);
                    this.nGT.put(Float.valueOf(dVar.aER), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nHg || this.nHi) && this.STROKE_WIDTH > 0.0f && dVar.nFK != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nGY.setColor(dVar.borderColor);
            return this.nGY;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nGX.setColor(dVar.nFL);
            return this.nGX;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nGU;
            } else {
                textPaint = this.nGV;
                textPaint.set(this.nGU);
            }
            textPaint.setTextSize(dVar.aER);
            a(dVar, textPaint);
            if (!this.nHe || this.SHADOW_RADIUS <= 0.0f || dVar.nFK == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nFK);
            }
            textPaint.setAntiAlias(this.nHk);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nHi ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nFK & 16777215);
                    paint.setAlpha(this.nHi ? (int) (this.nHc * (this.nHl / master.flame.danmaku.danmaku.model.c.MAX)) : this.nHl);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nHl);
                }
            } else if (z) {
                paint.setStyle(this.nHi ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nFK & 16777215);
                paint.setAlpha(this.nHi ? this.nHc : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nHe && this.nHg) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nHe) {
                return this.SHADOW_RADIUS;
            }
            if (this.nHg) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wN(boolean z) {
            this.nHg = this.nHf;
            this.nHe = this.nHd;
            this.nHi = this.nHh;
            this.nHk = z && this.nHj;
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
        this.nGK.bH(f);
    }

    public void bI(float f) {
        this.nGK.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nGK.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nGL) {
            this.nGL = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dLH() {
        return this.nGL;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nGK.fFl;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMj() {
        return this.nGK.nHo;
    }

    private void an(Canvas canvas) {
        this.lFI = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nGP) {
                this.nGQ = al(canvas);
                this.nGR = am(canvas);
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
        float dLP = dVar.dLP();
        float dLO = dVar.dLO();
        if (this.lFI != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nFF) {
                return 0;
            } else {
                if (dVar.nFJ == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.lFI, dLO, dLP);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nGK.nGW;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nFF) {
                if (this.nGL.a(dVar, this.lFI, dLO, dLP, paint, this.nGK.nGU)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nGK.nGU.setAlpha(paint.getAlpha());
                            this.nGK.nGV.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nGK.nGU);
                        }
                        a(dVar, this.lFI, dLO, dLP, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ao(this.lFI);
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
        if (this.nGL != null) {
            this.nGL.t(dVar);
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
        this.nGJ.save();
        if (this.nGM != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nGJ.setLocation(0.0f, 0.0f, this.nGM);
        }
        this.nGJ.rotateY(-dVar.rotationY);
        this.nGJ.rotateZ(-dVar.nFJ);
        this.nGJ.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nGJ.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nGL != null) {
            this.nGL.a(dVar, canvas, f, f2, z, this.nGK);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nGK.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nGL != null) {
            this.nGL.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nGK.nHg) {
            this.nGK.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nGK.nHg) {
            this.nGK.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nGL.b(dVar, textPaint, z);
        a(dVar, dVar.nFN, dVar.nFO);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0780a c0780a = this.nGK;
            f3 += 8;
            C0780a c0780a2 = this.nGK;
            f4 += 8;
        }
        dVar.nFN = f3 + getStrokeWidth();
        dVar.nFO = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dMf() {
        return this.nGN;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bG(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nGO = (int) max;
        if (f > 1.0f) {
            this.nGO = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMg() {
        return this.nGO;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.density = f;
        this.densityDpi = i;
        this.nGN = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nGM = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void i(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nGK.nHd = false;
                this.nGK.nHf = true;
                this.nGK.nHh = false;
                bI(fArr[0]);
                return;
            case 0:
                this.nGK.nHd = false;
                this.nGK.nHf = false;
                this.nGK.nHh = false;
                return;
            case 1:
                this.nGK.nHd = true;
                this.nGK.nHf = false;
                this.nGK.nHh = false;
                bH(fArr[0]);
                return;
            case 3:
                this.nGK.nHd = false;
                this.nGK.nHf = false;
                this.nGK.nHh = true;
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
    /* renamed from: dMp */
    public Canvas nq() {
        return this.lFI;
    }

    public float getStrokeWidth() {
        return this.nGK.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wM(boolean z) {
        this.nGP = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nGP;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMh() {
        return this.nGQ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMi() {
        return this.nGR;
    }
}
