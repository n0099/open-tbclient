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
    public Canvas nyr;
    private float nys;
    private int width;
    private Camera nyo = new Camera();
    private Matrix matrix = new Matrix();
    private final C0888a nyp = new C0888a();
    private b nyq = new h();
    private float anm = 1.0f;
    private int densityDpi = 160;
    private float nyt = 1.0f;
    private int nyu = 0;
    private boolean nyv = true;
    private int nyw = 2048;
    private int nyx = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0888a {
        private boolean isTranslucent;
        public final TextPaint nyB;
        private Paint nyC;
        private Paint nyD;
        private Paint nyE;
        private float nyy;
        private final Map<Float, Float> nyz = new HashMap(10);
        public int nyF = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nyG = 1.0f;
        public float nyH = 1.0f;
        private int nyI = 204;
        public boolean nyJ = false;
        private boolean nyK = this.nyJ;
        public boolean nyL = true;
        private boolean nyM = this.nyL;
        public boolean nyN = false;
        public boolean nyO = this.nyN;
        public boolean nyP = true;
        private boolean nyQ = this.nyP;
        private int nyR = master.flame.danmaku.danmaku.model.c.MAX;
        private float nyS = 1.0f;
        private boolean nyT = false;
        private int gzF = 0;
        private int nyU = 0;
        public final TextPaint nyA = new TextPaint();

        public C0888a() {
            this.nyA.setStrokeWidth(this.STROKE_WIDTH);
            this.nyB = new TextPaint(this.nyA);
            this.nyC = new Paint();
            this.nyD = new Paint();
            this.nyD.setStrokeWidth(this.nyF);
            this.nyD.setStyle(Paint.Style.STROKE);
            this.nyE = new Paint();
            this.nyE.setStyle(Paint.Style.STROKE);
            this.nyE.setStrokeWidth(4.0f);
        }

        public void aN(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nyA.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nyG != f || this.nyH != f2 || this.nyI != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nyG = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nyH = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nyI = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nyT) {
                Float f = this.nyz.get(Float.valueOf(dVar.bir));
                if (f == null || this.nyy != this.nyS) {
                    this.nyy = this.nyS;
                    f = Float.valueOf(dVar.bir * this.nyS);
                    this.nyz.put(Float.valueOf(dVar.bir), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nyM || this.nyO) && this.STROKE_WIDTH > 0.0f && dVar.nxn != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nyE.setColor(dVar.borderColor);
            return this.nyE;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nyD.setColor(dVar.nxo);
            return this.nyD;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nyA;
            } else {
                textPaint = this.nyB;
                textPaint.set(this.nyA);
            }
            textPaint.setTextSize(dVar.bir);
            a(dVar, textPaint);
            if (!this.nyK || this.SHADOW_RADIUS <= 0.0f || dVar.nxn == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nxn);
            }
            textPaint.setAntiAlias(this.nyQ);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nyO ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nxn & 16777215);
                    paint.setAlpha(this.nyO ? (int) (this.nyI * (this.nyR / master.flame.danmaku.danmaku.model.c.MAX)) : this.nyR);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nyR);
                }
            } else if (z) {
                paint.setStyle(this.nyO ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nxn & 16777215);
                paint.setAlpha(this.nyO ? this.nyI : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nyK && this.nyM) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nyK) {
                return this.SHADOW_RADIUS;
            }
            if (this.nyM) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void xa(boolean z) {
            this.nyM = this.nyL;
            this.nyK = this.nyJ;
            this.nyO = this.nyN;
            this.nyQ = z && this.nyP;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int ah(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int ai(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void aN(float f) {
        this.nyp.aN(f);
    }

    public void aO(float f) {
        this.nyp.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nyp.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nyq) {
            this.nyq = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dNm() {
        return this.nyq;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nyp.gzF;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNO() {
        return this.nyp.nyU;
    }

    private void aj(Canvas canvas) {
        this.nyr = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nyv) {
                this.nyw = ah(canvas);
                this.nyx = ai(canvas);
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
        return this.anm;
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
        float dNu = dVar.dNu();
        float dNt = dVar.dNt();
        if (this.nyr != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nxi) {
                return 0;
            } else {
                if (dVar.nxm == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.nyr, dNt, dNu);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nyp.nyC;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nxi) {
                if (this.nyq.a(dVar, this.nyr, dNt, dNu, paint, this.nyp.nyA)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nyp.nyA.setAlpha(paint.getAlpha());
                            this.nyp.nyB.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nyp.nyA);
                        }
                        a(dVar, this.nyr, dNt, dNu, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ak(this.nyr);
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
        if (this.nyq != null) {
            this.nyq.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void ak(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.nyo.save();
        if (this.nys != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nyo.setLocation(0.0f, 0.0f, this.nys);
        }
        this.nyo.rotateY(-dVar.rotationY);
        this.nyo.rotateZ(-dVar.nxm);
        this.nyo.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nyo.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nyq != null) {
            this.nyq.a(dVar, canvas, f, f2, z, this.nyp);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nyp.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nyq != null) {
            this.nyq.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nyp.nyM) {
            this.nyp.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nyp.nyM) {
            this.nyp.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nyq.b(dVar, textPaint, z);
        a(dVar, dVar.nxq, dVar.nxr);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0888a c0888a = this.nyp;
            f3 += 8;
            C0888a c0888a2 = this.nyp;
            f4 += 8;
        }
        dVar.nxq = f3 + getStrokeWidth();
        dVar.nxr = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dNK() {
        return this.nyt;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aM(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nyu = (int) max;
        if (f > 1.0f) {
            this.nyu = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNL() {
        return this.nyu;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.anm = f;
        this.densityDpi = i;
        this.nyt = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nys = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nyp.nyJ = false;
                this.nyp.nyL = true;
                this.nyp.nyN = false;
                aO(fArr[0]);
                return;
            case 0:
                this.nyp.nyJ = false;
                this.nyp.nyL = false;
                this.nyp.nyN = false;
                return;
            case 1:
                this.nyp.nyJ = true;
                this.nyp.nyL = false;
                this.nyp.nyN = false;
                aN(fArr[0]);
                return;
            case 3:
                this.nyp.nyJ = false;
                this.nyp.nyL = false;
                this.nyp.nyN = true;
                e(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: al */
    public void setExtraData(Canvas canvas) {
        aj(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: dNU */
    public Canvas rS() {
        return this.nyr;
    }

    public float getStrokeWidth() {
        return this.nyp.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wZ(boolean z) {
        this.nyv = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nyv;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNM() {
        return this.nyw;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNN() {
        return this.nyx;
    }
}
