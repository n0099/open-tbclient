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
    public Canvas nxh;
    private float nxi;
    private int width;
    private Camera nxe = new Camera();
    private Matrix matrix = new Matrix();
    private final C0887a nxf = new C0887a();
    private b nxg = new h();
    private float anm = 1.0f;
    private int densityDpi = 160;
    private float nxj = 1.0f;
    private int nxk = 0;
    private boolean nxl = true;
    private int nxm = 2048;
    private int nxn = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0887a {
        private boolean isTranslucent;
        private float nxo;
        public final TextPaint nxr;
        private Paint nxs;
        private Paint nxt;
        private Paint nxu;
        private final Map<Float, Float> nxp = new HashMap(10);
        public int nxv = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nxw = 1.0f;
        public float nxx = 1.0f;
        private int nxy = 204;
        public boolean nxz = false;
        private boolean nxA = this.nxz;
        public boolean nxB = true;
        private boolean nxC = this.nxB;
        public boolean nxD = false;
        public boolean nxE = this.nxD;
        public boolean nxF = true;
        private boolean nxG = this.nxF;
        private int nxH = master.flame.danmaku.danmaku.model.c.MAX;
        private float nxI = 1.0f;
        private boolean nxJ = false;
        private int gzu = 0;
        private int nxK = 0;
        public final TextPaint nxq = new TextPaint();

        public C0887a() {
            this.nxq.setStrokeWidth(this.STROKE_WIDTH);
            this.nxr = new TextPaint(this.nxq);
            this.nxs = new Paint();
            this.nxt = new Paint();
            this.nxt.setStrokeWidth(this.nxv);
            this.nxt.setStyle(Paint.Style.STROKE);
            this.nxu = new Paint();
            this.nxu.setStyle(Paint.Style.STROKE);
            this.nxu.setStrokeWidth(4.0f);
        }

        public void aN(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nxq.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nxw != f || this.nxx != f2 || this.nxy != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nxw = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.nxx = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.nxy = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.nxJ) {
                Float f = this.nxp.get(Float.valueOf(dVar.bir));
                if (f == null || this.nxo != this.nxI) {
                    this.nxo = this.nxI;
                    f = Float.valueOf(dVar.bir * this.nxI);
                    this.nxp.put(Float.valueOf(dVar.bir), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.nxC || this.nxE) && this.STROKE_WIDTH > 0.0f && dVar.nwd != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nxu.setColor(dVar.borderColor);
            return this.nxu;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.nxt.setColor(dVar.nwe);
            return this.nxt;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nxq;
            } else {
                textPaint = this.nxr;
                textPaint.set(this.nxq);
            }
            textPaint.setTextSize(dVar.bir);
            a(dVar, textPaint);
            if (!this.nxA || this.SHADOW_RADIUS <= 0.0f || dVar.nwd == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nwd);
            }
            textPaint.setAntiAlias(this.nxG);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.nxE ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nwd & 16777215);
                    paint.setAlpha(this.nxE ? (int) (this.nxy * (this.nxH / master.flame.danmaku.danmaku.model.c.MAX)) : this.nxH);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.nxH);
                }
            } else if (z) {
                paint.setStyle(this.nxE ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nwd & 16777215);
                paint.setAlpha(this.nxE ? this.nxy : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.nxA && this.nxC) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.nxA) {
                return this.SHADOW_RADIUS;
            }
            if (this.nxC) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wY(boolean z) {
            this.nxC = this.nxB;
            this.nxA = this.nxz;
            this.nxE = this.nxD;
            this.nxG = z && this.nxF;
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
        this.nxf.aN(f);
    }

    public void aO(float f) {
        this.nxf.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nxf.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nxg) {
            this.nxg = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dMY() {
        return this.nxg;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nxf.gzu;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNA() {
        return this.nxf.nxK;
    }

    private void aj(Canvas canvas) {
        this.nxh = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nxl) {
                this.nxm = ah(canvas);
                this.nxn = ai(canvas);
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
        float dNg = dVar.dNg();
        float dNf = dVar.dNf();
        if (this.nxh != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.nvY) {
                return 0;
            } else {
                if (dVar.nwc == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.nxh, dNf, dNg);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nxf.nxs;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.nvY) {
                if (this.nxg.a(dVar, this.nxh, dNf, dNg, paint, this.nxf.nxq)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nxf.nxq.setAlpha(paint.getAlpha());
                            this.nxf.nxr.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nxf.nxq);
                        }
                        a(dVar, this.nxh, dNf, dNg, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ak(this.nxh);
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
        if (this.nxg != null) {
            this.nxg.t(dVar);
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
        this.nxe.save();
        if (this.nxi != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nxe.setLocation(0.0f, 0.0f, this.nxi);
        }
        this.nxe.rotateY(-dVar.rotationY);
        this.nxe.rotateZ(-dVar.nwc);
        this.nxe.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nxe.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nxg != null) {
            this.nxg.a(dVar, canvas, f, f2, z, this.nxf);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nxf.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nxg != null) {
            this.nxg.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nxf.nxC) {
            this.nxf.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nxf.nxC) {
            this.nxf.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nxg.b(dVar, textPaint, z);
        a(dVar, dVar.nwg, dVar.nwh);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0887a c0887a = this.nxf;
            f3 += 8;
            C0887a c0887a2 = this.nxf;
            f4 += 8;
        }
        dVar.nwg = f3 + getStrokeWidth();
        dVar.nwh = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dNw() {
        return this.nxj;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aM(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nxk = (int) max;
        if (f > 1.0f) {
            this.nxk = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNx() {
        return this.nxk;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.anm = f;
        this.densityDpi = i;
        this.nxj = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.nxi = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nxf.nxz = false;
                this.nxf.nxB = true;
                this.nxf.nxD = false;
                aO(fArr[0]);
                return;
            case 0:
                this.nxf.nxz = false;
                this.nxf.nxB = false;
                this.nxf.nxD = false;
                return;
            case 1:
                this.nxf.nxz = true;
                this.nxf.nxB = false;
                this.nxf.nxD = false;
                aN(fArr[0]);
                return;
            case 3:
                this.nxf.nxz = false;
                this.nxf.nxB = false;
                this.nxf.nxD = true;
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
    /* renamed from: dNG */
    public Canvas rS() {
        return this.nxh;
    }

    public float getStrokeWidth() {
        return this.nxf.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wX(boolean z) {
        this.nxl = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nxl;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNy() {
        return this.nxm;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dNz() {
        return this.nxn;
    }
}
