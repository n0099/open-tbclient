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
    public Canvas pNw;
    private float pNx;
    private int width;
    private Camera pNt = new Camera();
    private Matrix matrix = new Matrix();
    private final C1068a pNu = new C1068a();
    private b pNv = new h();
    private float auM = 1.0f;
    private int densityDpi = 160;
    private float pNy = 1.0f;
    private int pNz = 0;
    private boolean pNA = true;
    private int pNB = 2048;
    private int pNC = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1068a {
        private boolean isTranslucent;
        private float pND;
        public final TextPaint pNG;
        private Paint pNH;
        private Paint pNI;
        private Paint pNJ;
        private final Map<Float, Float> pNE = new HashMap(10);
        public int pNK = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float pNL = 1.0f;
        public float pNM = 1.0f;
        private int pNN = 204;
        public boolean pNO = false;
        private boolean pNP = this.pNO;
        public boolean pNQ = true;
        private boolean pNR = this.pNQ;
        public boolean pNS = false;
        public boolean pNT = this.pNS;
        public boolean pNU = true;
        private boolean pNV = this.pNU;
        private int pNW = master.flame.danmaku.danmaku.model.c.MAX;
        private float pNX = 1.0f;
        private boolean pNY = false;
        private int margin = 0;
        private int pNZ = 0;
        public final TextPaint pNF = new TextPaint();

        public C1068a() {
            this.pNF.setStrokeWidth(this.STROKE_WIDTH);
            this.pNG = new TextPaint(this.pNF);
            this.pNH = new Paint();
            this.pNI = new Paint();
            this.pNI.setStrokeWidth(this.pNK);
            this.pNI.setStyle(Paint.Style.STROKE);
            this.pNJ = new Paint();
            this.pNJ.setStyle(Paint.Style.STROKE);
            this.pNJ.setStrokeWidth(4.0f);
        }

        public void bv(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.pNF.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.pNL != f || this.pNM != f2 || this.pNN != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.pNL = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.pNM = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.pNN = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.pNY) {
                Float f = this.pNE.get(Float.valueOf(dVar.bGw));
                if (f == null || this.pND != this.pNX) {
                    this.pND = this.pNX;
                    f = Float.valueOf(dVar.bGw * this.pNX);
                    this.pNE.put(Float.valueOf(dVar.bGw), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.pNR || this.pNT) && this.STROKE_WIDTH > 0.0f && dVar.pMv != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.pNJ.setColor(dVar.borderColor);
            return this.pNJ;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.pNI.setColor(dVar.underlineColor);
            return this.pNI;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.pNF;
            } else {
                textPaint = this.pNG;
                textPaint.set(this.pNF);
            }
            textPaint.setTextSize(dVar.bGw);
            a(dVar, textPaint);
            if (!this.pNP || this.SHADOW_RADIUS <= 0.0f || dVar.pMv == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.pMv);
            }
            textPaint.setAntiAlias(this.pNV);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.pNT ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.pMv & 16777215);
                    paint.setAlpha(this.pNT ? (int) (this.pNN * (this.pNW / master.flame.danmaku.danmaku.model.c.MAX)) : this.pNW);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.pNW);
                }
            } else if (z) {
                paint.setStyle(this.pNT ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.pMv & 16777215);
                paint.setAlpha(this.pNT ? this.pNN : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.pNP && this.pNR) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.pNP) {
                return this.SHADOW_RADIUS;
            }
            if (this.pNR) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void AR(boolean z) {
            this.pNR = this.pNQ;
            this.pNP = this.pNO;
            this.pNT = this.pNS;
            this.pNV = z && this.pNU;
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

    public void bv(float f) {
        this.pNu.bv(f);
    }

    public void bw(float f) {
        this.pNu.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.pNu.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.pNv) {
            this.pNv = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b ezm() {
        return this.pNv;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.pNu.margin;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ezP() {
        return this.pNu.pNZ;
    }

    private void ax(Canvas canvas) {
        this.pNw = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.pNA) {
                this.pNB = av(canvas);
                this.pNC = aw(canvas);
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
        float ezv = dVar.ezv();
        float ezu = dVar.ezu();
        if (this.pNw != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.pMq) {
                return 0;
            } else {
                if (dVar.pMu == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.pNw, ezu, ezv);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.pNu.pNH;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.pMq) {
                if (this.pNv.a(dVar, this.pNw, ezu, ezv, paint, this.pNu.pNF)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.pNu.pNF.setAlpha(paint.getAlpha());
                            this.pNu.pNG.setAlpha(paint.getAlpha());
                        } else {
                            c(this.pNu.pNF);
                        }
                        a(dVar, this.pNw, ezu, ezv, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ay(this.pNw);
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
        if (this.pNv != null) {
            this.pNv.t(dVar);
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
        this.pNt.save();
        if (this.pNx != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.pNt.setLocation(0.0f, 0.0f, this.pNx);
        }
        this.pNt.rotateY(-dVar.rotationY);
        this.pNt.rotateZ(-dVar.pMu);
        this.pNt.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.pNt.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.pNv != null) {
            this.pNv.a(dVar, canvas, f, f2, z, this.pNu);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.pNu.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.pNv != null) {
            this.pNv.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.pNu.pNR) {
            this.pNu.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.pNu.pNR) {
            this.pNu.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.pNv.b(dVar, textPaint, z);
        a(dVar, dVar.pMx, dVar.pMy);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C1068a c1068a = this.pNu;
            f3 += 8;
            C1068a c1068a2 = this.pNu;
            f4 += 8;
        }
        dVar.pMx = f3 + getStrokeWidth();
        dVar.pMy = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float ezL() {
        return this.pNy;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bu(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.pNz = (int) max;
        if (f > 1.0f) {
            this.pNz = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ezM() {
        return this.pNz;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.auM = f;
        this.densityDpi = i;
        this.pNy = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.pNx = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.pNu.pNO = false;
                this.pNu.pNQ = true;
                this.pNu.pNS = false;
                bw(fArr[0]);
                return;
            case 0:
                this.pNu.pNO = false;
                this.pNu.pNQ = false;
                this.pNu.pNS = false;
                return;
            case 1:
                this.pNu.pNO = true;
                this.pNu.pNQ = false;
                this.pNu.pNS = false;
                bv(fArr[0]);
                return;
            case 3:
                this.pNu.pNO = false;
                this.pNu.pNQ = false;
                this.pNu.pNS = true;
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
    /* renamed from: ezV */
    public Canvas ud() {
        return this.pNw;
    }

    public float getStrokeWidth() {
        return this.pNu.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void AQ(boolean z) {
        this.pNA = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.pNA;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ezN() {
        return this.pNB;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int ezO() {
        return this.pNC;
    }
}
