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
    public Canvas oWa;
    private float oWb;
    private int width;
    private Camera oVX = new Camera();
    private Matrix matrix = new Matrix();
    private final C0996a oVY = new C0996a();
    private b oVZ = new h();
    private float auL = 1.0f;
    private int densityDpi = 160;
    private float oWc = 1.0f;
    private int oWd = 0;
    private boolean oWe = true;
    private int oWf = 2048;
    private int oWg = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0996a {
        private boolean isTranslucent;
        private float oWh;
        public final TextPaint oWk;
        private Paint oWl;
        private Paint oWm;
        private Paint oWn;
        private final Map<Float, Float> oWi = new HashMap(10);
        public int oWo = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float oWp = 1.0f;
        public float oWq = 1.0f;
        private int oWr = 204;
        public boolean oWs = false;
        private boolean oWt = this.oWs;
        public boolean oWu = true;
        private boolean oWv = this.oWu;
        public boolean oWw = false;
        public boolean oWx = this.oWw;
        public boolean oWy = true;
        private boolean oWz = this.oWy;
        private int oWA = master.flame.danmaku.danmaku.model.c.MAX;
        private float oWB = 1.0f;
        private boolean oWC = false;
        private int margin = 0;
        private int oWD = 0;
        public final TextPaint oWj = new TextPaint();

        public C0996a() {
            this.oWj.setStrokeWidth(this.STROKE_WIDTH);
            this.oWk = new TextPaint(this.oWj);
            this.oWl = new Paint();
            this.oWm = new Paint();
            this.oWm.setStrokeWidth(this.oWo);
            this.oWm.setStyle(Paint.Style.STROKE);
            this.oWn = new Paint();
            this.oWn.setStyle(Paint.Style.STROKE);
            this.oWn.setStrokeWidth(4.0f);
        }

        public void be(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.oWj.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void f(float f, float f2, int i) {
            if (this.oWp != f || this.oWq != f2 || this.oWr != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.oWp = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.oWq = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.oWr = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.oWC) {
                Float f = this.oWi.get(Float.valueOf(dVar.bDA));
                if (f == null || this.oWh != this.oWB) {
                    this.oWh = this.oWB;
                    f = Float.valueOf(dVar.bDA * this.oWB);
                    this.oWi.put(Float.valueOf(dVar.bDA), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.oWv || this.oWx) && this.STROKE_WIDTH > 0.0f && dVar.oUZ != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.oWn.setColor(dVar.borderColor);
            return this.oWn;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.oWm.setColor(dVar.underlineColor);
            return this.oWm;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.oWj;
            } else {
                textPaint = this.oWk;
                textPaint.set(this.oWj);
            }
            textPaint.setTextSize(dVar.bDA);
            a(dVar, textPaint);
            if (!this.oWt || this.SHADOW_RADIUS <= 0.0f || dVar.oUZ == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.oUZ);
            }
            textPaint.setAntiAlias(this.oWz);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.oWx ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.oUZ & 16777215);
                    paint.setAlpha(this.oWx ? (int) (this.oWr * (this.oWA / master.flame.danmaku.danmaku.model.c.MAX)) : this.oWA);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.oWA);
                }
            } else if (z) {
                paint.setStyle(this.oWx ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.oUZ & 16777215);
                paint.setAlpha(this.oWx ? this.oWr : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.oWt && this.oWv) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.oWt) {
                return this.SHADOW_RADIUS;
            }
            if (this.oWv) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void zJ(boolean z) {
            this.oWv = this.oWu;
            this.oWt = this.oWs;
            this.oWx = this.oWw;
            this.oWz = z && this.oWy;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int at(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int au(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void be(float f) {
        this.oVY.be(f);
    }

    public void bf(float f) {
        this.oVY.setStrokeWidth(f);
    }

    public void f(float f, float f2, int i) {
        this.oVY.f(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.oVZ) {
            this.oVZ = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b epo() {
        return this.oVZ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.oVY.margin;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int epR() {
        return this.oVY.oWD;
    }

    private void av(Canvas canvas) {
        this.oWa = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.oWe) {
                this.oWf = at(canvas);
                this.oWg = au(canvas);
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
        return this.auL;
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
        float epx = dVar.epx();
        float epw = dVar.epw();
        if (this.oWa != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.oUU) {
                return 0;
            } else {
                if (dVar.oUY == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.oWa, epw, epx);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.oVY.oWl;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.oUU) {
                if (this.oVZ.a(dVar, this.oWa, epw, epx, paint, this.oVY.oWj)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.oVY.oWj.setAlpha(paint.getAlpha());
                            this.oVY.oWk.setAlpha(paint.getAlpha());
                        } else {
                            c(this.oVY.oWj);
                        }
                        a(dVar, this.oWa, epw, epx, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        aw(this.oWa);
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
        if (this.oVZ != null) {
            this.oVZ.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void aw(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.oVX.save();
        if (this.oWb != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.oVX.setLocation(0.0f, 0.0f, this.oWb);
        }
        this.oVX.rotateY(-dVar.rotationY);
        this.oVX.rotateZ(-dVar.oUY);
        this.oVX.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.oVX.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.oVZ != null) {
            this.oVZ.a(dVar, canvas, f, f2, z, this.oVY);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.oVY.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.oVZ != null) {
            this.oVZ.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.oVY.oWv) {
            this.oVY.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.oVY.oWv) {
            this.oVY.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.oVZ.b(dVar, textPaint, z);
        a(dVar, dVar.oVb, dVar.oVc);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0996a c0996a = this.oVY;
            f3 += 8;
            C0996a c0996a2 = this.oVY;
            f4 += 8;
        }
        dVar.oVb = f3 + getStrokeWidth();
        dVar.oVc = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float epN() {
        return this.oWc;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void bd(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.oWd = (int) max;
        if (f > 1.0f) {
            this.oWd = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int epO() {
        return this.oWd;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.auL = f;
        this.densityDpi = i;
        this.oWc = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.oWb = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.oVY.oWs = false;
                this.oVY.oWu = true;
                this.oVY.oWw = false;
                bf(fArr[0]);
                return;
            case 0:
                this.oVY.oWs = false;
                this.oVY.oWu = false;
                this.oVY.oWw = false;
                return;
            case 1:
                this.oVY.oWs = true;
                this.oVY.oWu = false;
                this.oVY.oWw = false;
                be(fArr[0]);
                return;
            case 3:
                this.oVY.oWs = false;
                this.oVY.oWu = false;
                this.oVY.oWw = true;
                f(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: ax */
    public void setExtraData(Canvas canvas) {
        av(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: epX */
    public Canvas ud() {
        return this.oWa;
    }

    public float getStrokeWidth() {
        return this.oVY.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void zI(boolean z) {
        this.oWe = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.oWe;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int epP() {
        return this.oWf;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int epQ() {
        return this.oWg;
    }
}
