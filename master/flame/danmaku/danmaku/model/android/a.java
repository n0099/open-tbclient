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
    public Canvas lHm;
    private float nIz;
    private int width;
    private Camera nIw = new Camera();
    private Matrix matrix = new Matrix();
    private final C0781a nIx = new C0781a();
    private b nIy = new h();
    private float density = 1.0f;
    private int densityDpi = 160;
    private float nIA = 1.0f;
    private int nIB = 0;
    private boolean nIC = true;
    private int nID = 2048;
    private int nIE = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0781a {
        private boolean isTranslucent;
        private float nIF;
        public final TextPaint nII;
        private Paint nIJ;
        private Paint nIK;
        private Paint nIL;
        private final Map<Float, Float> nIG = new HashMap(10);
        public int nIM = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nIN = 1.0f;
        public float nIO = 1.0f;
        private int nIP = 204;
        public boolean nIQ = false;
        private boolean nIR = this.nIQ;
        public boolean nIS = true;
        private boolean nIT = this.nIS;
        public boolean nIU = false;
        public boolean nIV = this.nIU;
        public boolean nIW = true;
        private boolean nIX = this.nIW;
        private int nIY = master.flame.danmaku.danmaku.model.c.MAX;
        private float nIZ = 1.0f;
        private boolean nJa = false;
        private int fFT = 0;
        private int nJb = 0;
        public final TextPaint nIH = new TextPaint();

        public C0781a() {
            this.nIH.setStrokeWidth(this.STROKE_WIDTH);
            this.nII = new TextPaint(this.nIH);
            this.nIJ = new Paint();
            this.nIK = new Paint();
            this.nIK.setStrokeWidth(this.nIM);
            this.nIK.setStyle(Paint.Style.STROKE);
            this.nIL = new Paint();
            this.nIL.setStyle(Paint.Style.STROKE);
            this.nIL.setStrokeWidth(4.0f);
        }

        public void bH(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nIH.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nIN != f || this.nIO != f2 || this.nIP != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nIN = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nIO = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nIP = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nJa) {
                Float f = this.nIG.get(Float.valueOf(dVar.aFf));
                if (f == null || this.nIF != this.nIZ) {
                    this.nIF = this.nIZ;
                    f = Float.valueOf(dVar.aFf * this.nIZ);
                    this.nIG.put(Float.valueOf(dVar.aFf), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nIT || this.nIV) && this.STROKE_WIDTH > 0.0f && dVar.nHx != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nIL.setColor(dVar.borderColor);
            return this.nIL;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nIK.setColor(dVar.nHy);
            return this.nIK;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nIH;
            } else {
                textPaint = this.nII;
                textPaint.set(this.nIH);
            }
            textPaint.setTextSize(dVar.aFf);
            a(dVar, textPaint);
            if (!this.nIR || this.SHADOW_RADIUS <= 0.0f || dVar.nHx == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nHx);
            }
            textPaint.setAntiAlias(this.nIX);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nIV ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nHx & 16777215);
                    paint.setAlpha(this.nIV ? (int) (this.nIP * (this.nIY / master.flame.danmaku.danmaku.model.c.MAX)) : this.nIY);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nIY);
                }
            } else if (z) {
                paint.setStyle(this.nIV ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nHx & 16777215);
                paint.setAlpha(this.nIV ? this.nIP : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nIR && this.nIT) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nIR) {
                return this.SHADOW_RADIUS;
            }
            if (this.nIT) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wV(boolean z) {
            this.nIT = this.nIS;
            this.nIR = this.nIQ;
            this.nIV = this.nIU;
            this.nIX = z && this.nIW;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int am(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int an(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void bH(float f) {
        this.nIx.bH(f);
    }

    public void bI(float f) {
        this.nIx.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nIx.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nIy) {
            this.nIy = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dMh() {
        return this.nIy;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nIx.fFT;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMJ() {
        return this.nIx.nJb;
    }

    private void ao(Canvas canvas) {
        this.lHm = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nIC) {
                this.nID = am(canvas);
                this.nIE = an(canvas);
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
        float dMp = dVar.dMp();
        float dMo = dVar.dMo();
        if (this.lHm != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nHs) {
                return 0;
            } else {
                if (dVar.nHw == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.lHm, dMo, dMp);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nIx.nIJ;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nHs) {
                if (this.nIy.a(dVar, this.lHm, dMo, dMp, paint, this.nIx.nIH)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nIx.nIH.setAlpha(paint.getAlpha());
                            this.nIx.nII.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nIx.nIH);
                        }
                        a(dVar, this.lHm, dMo, dMp, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ap(this.lHm);
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
        if (this.nIy != null) {
            this.nIy.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void ap(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.nIw.save();
        if (this.nIz != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nIw.setLocation(0.0f, 0.0f, this.nIz);
        }
        this.nIw.rotateY(-dVar.rotationY);
        this.nIw.rotateZ(-dVar.nHw);
        this.nIw.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nIw.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nIy != null) {
            this.nIy.a(dVar, canvas, f, f2, z, this.nIx);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nIx.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nIy != null) {
            this.nIy.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nIx.nIT) {
            this.nIx.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nIx.nIT) {
            this.nIx.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nIy.b(dVar, textPaint, z);
        a(dVar, dVar.nHA, dVar.nHB);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0781a c0781a = this.nIx;
            f3 += 8;
            C0781a c0781a2 = this.nIx;
            f4 += 8;
        }
        dVar.nHA = f3 + getStrokeWidth();
        dVar.nHB = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dMF() {
        return this.nIA;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bG(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nIB = (int) max;
        if (f > 1.0f) {
            this.nIB = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMG() {
        return this.nIB;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.density = f;
        this.densityDpi = i;
        this.nIA = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nIz = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void i(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nIx.nIQ = false;
                this.nIx.nIS = true;
                this.nIx.nIU = false;
                bI(fArr[0]);
                return;
            case 0:
                this.nIx.nIQ = false;
                this.nIx.nIS = false;
                this.nIx.nIU = false;
                return;
            case 1:
                this.nIx.nIQ = true;
                this.nIx.nIS = false;
                this.nIx.nIU = false;
                bH(fArr[0]);
                return;
            case 3:
                this.nIx.nIQ = false;
                this.nIx.nIS = false;
                this.nIx.nIU = true;
                e(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: aq */
    public void setExtraData(Canvas canvas) {
        ao(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: dMP */
    public Canvas nq() {
        return this.lHm;
    }

    public float getStrokeWidth() {
        return this.nIx.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wU(boolean z) {
        this.nIC = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nIC;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMH() {
        return this.nID;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dMI() {
        return this.nIE;
    }
}
