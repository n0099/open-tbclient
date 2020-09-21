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
    public Canvas oGL;
    private float oGM;
    private int width;
    private Camera oGI = new Camera();
    private Matrix matrix = new Matrix();
    private final C0978a oGJ = new C0978a();
    private b oGK = new h();
    private float auc = 1.0f;
    private int densityDpi = 160;
    private float oGN = 1.0f;
    private int oGO = 0;
    private boolean oGP = true;
    private int oGQ = 2048;
    private int oGR = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0978a {
        private boolean isTranslucent;
        private float oGS;
        public final TextPaint oGV;
        private Paint oGW;
        private Paint oGX;
        private Paint oGY;
        private final Map<Float, Float> oGT = new HashMap(10);
        public int oGZ = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float oHa = 1.0f;
        public float oHb = 1.0f;
        private int oHc = 204;
        public boolean oHd = false;
        private boolean oHe = this.oHd;
        public boolean oHf = true;
        private boolean oHg = this.oHf;
        public boolean oHh = false;
        public boolean oHi = this.oHh;
        public boolean oHj = true;
        private boolean oHk = this.oHj;
        private int oHl = master.flame.danmaku.danmaku.model.c.MAX;
        private float oHm = 1.0f;
        private boolean oHn = false;
        private int margin = 0;
        private int oHo = 0;
        public final TextPaint oGU = new TextPaint();

        public C0978a() {
            this.oGU.setStrokeWidth(this.STROKE_WIDTH);
            this.oGV = new TextPaint(this.oGU);
            this.oGW = new Paint();
            this.oGX = new Paint();
            this.oGX.setStrokeWidth(this.oGZ);
            this.oGX.setStyle(Paint.Style.STROKE);
            this.oGY = new Paint();
            this.oGY.setStyle(Paint.Style.STROKE);
            this.oGY.setStrokeWidth(4.0f);
        }

        public void aY(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.oGU.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.oHa != f || this.oHb != f2 || this.oHc != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.oHa = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.oHb = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.oHc = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.oHn) {
                Float f = this.oGT.get(Float.valueOf(dVar.bwX));
                if (f == null || this.oGS != this.oHm) {
                    this.oGS = this.oHm;
                    f = Float.valueOf(dVar.bwX * this.oHm);
                    this.oGT.put(Float.valueOf(dVar.bwX), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.oHg || this.oHi) && this.STROKE_WIDTH > 0.0f && dVar.oFK != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.oGY.setColor(dVar.borderColor);
            return this.oGY;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.oGX.setColor(dVar.underlineColor);
            return this.oGX;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.oGU;
            } else {
                textPaint = this.oGV;
                textPaint.set(this.oGU);
            }
            textPaint.setTextSize(dVar.bwX);
            a(dVar, textPaint);
            if (!this.oHe || this.SHADOW_RADIUS <= 0.0f || dVar.oFK == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.oFK);
            }
            textPaint.setAntiAlias(this.oHk);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.oHi ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.oFK & 16777215);
                    paint.setAlpha(this.oHi ? (int) (this.oHc * (this.oHl / master.flame.danmaku.danmaku.model.c.MAX)) : this.oHl);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.oHl);
                }
            } else if (z) {
                paint.setStyle(this.oHi ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.oFK & 16777215);
                paint.setAlpha(this.oHi ? this.oHc : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.oHe && this.oHg) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.oHe) {
                return this.SHADOW_RADIUS;
            }
            if (this.oHg) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void zc(boolean z) {
            this.oHg = this.oHf;
            this.oHe = this.oHd;
            this.oHi = this.oHh;
            this.oHk = z && this.oHj;
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
        this.oGJ.aY(f);
    }

    public void aZ(float f) {
        this.oGJ.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.oGJ.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.oGK) {
            this.oGK = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b elB() {
        return this.oGK;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.oGJ.margin;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int eme() {
        return this.oGJ.oHo;
    }

    private void au(Canvas canvas) {
        this.oGL = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.oGP) {
                this.oGQ = as(canvas);
                this.oGR = at(canvas);
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
        return this.auc;
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
        float elK = dVar.elK();
        float elJ = dVar.elJ();
        if (this.oGL != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.oFF) {
                return 0;
            } else {
                if (dVar.oFJ == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.oGL, elJ, elK);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.oGJ.oGW;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.oFF) {
                if (this.oGK.a(dVar, this.oGL, elJ, elK, paint, this.oGJ.oGU)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.oGJ.oGU.setAlpha(paint.getAlpha());
                            this.oGJ.oGV.setAlpha(paint.getAlpha());
                        } else {
                            c(this.oGJ.oGU);
                        }
                        a(dVar, this.oGL, elJ, elK, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        av(this.oGL);
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
        if (this.oGK != null) {
            this.oGK.t(dVar);
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
        this.oGI.save();
        if (this.oGM != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.oGI.setLocation(0.0f, 0.0f, this.oGM);
        }
        this.oGI.rotateY(-dVar.rotationY);
        this.oGI.rotateZ(-dVar.oFJ);
        this.oGI.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.oGI.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.oGK != null) {
            this.oGK.a(dVar, canvas, f, f2, z, this.oGJ);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.oGJ.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.oGK != null) {
            this.oGK.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.oGJ.oHg) {
            this.oGJ.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.oGJ.oHg) {
            this.oGJ.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.oGK.b(dVar, textPaint, z);
        a(dVar, dVar.oFM, dVar.oFN);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0978a c0978a = this.oGJ;
            f3 += 8;
            C0978a c0978a2 = this.oGJ;
            f4 += 8;
        }
        dVar.oFM = f3 + getStrokeWidth();
        dVar.oFN = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float ema() {
        return this.oGN;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aX(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.oGO = (int) max;
        if (f > 1.0f) {
            this.oGO = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int emb() {
        return this.oGO;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.auc = f;
        this.densityDpi = i;
        this.oGN = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.oGM = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.oGJ.oHd = false;
                this.oGJ.oHf = true;
                this.oGJ.oHh = false;
                aZ(fArr[0]);
                return;
            case 0:
                this.oGJ.oHd = false;
                this.oGJ.oHf = false;
                this.oGJ.oHh = false;
                return;
            case 1:
                this.oGJ.oHd = true;
                this.oGJ.oHf = false;
                this.oGJ.oHh = false;
                aY(fArr[0]);
                return;
            case 3:
                this.oGJ.oHd = false;
                this.oGJ.oHf = false;
                this.oGJ.oHh = true;
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
    /* renamed from: emk */
    public Canvas ud() {
        return this.oGL;
    }

    public float getStrokeWidth() {
        return this.oGJ.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void zb(boolean z) {
        this.oGP = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.oGP;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int emc() {
        return this.oGQ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int emd() {
        return this.oGR;
    }
}
