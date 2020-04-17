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
    public Canvas ncb;
    private float ncc;
    private int width;
    private Camera nbY = new Camera();
    private Matrix matrix = new Matrix();
    private final C0804a nbZ = new C0804a();
    private b nca = new h();
    private float alE = 1.0f;
    private int densityDpi = 160;
    private float ncd = 1.0f;
    private int nce = 0;
    private boolean ncf = true;
    private int ncg = 2048;
    private int nch = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0804a {
        private boolean isTranslucent;
        private float nci;
        public final TextPaint ncl;
        private Paint ncm;
        private Paint ncn;
        private Paint nco;
        private final Map<Float, Float> ncj = new HashMap(10);
        public int ncp = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float ncq = 1.0f;
        public float ncr = 1.0f;
        private int ncs = 204;
        public boolean nct = false;
        private boolean ncu = this.nct;
        public boolean ncv = true;
        private boolean ncw = this.ncv;
        public boolean ncx = false;
        public boolean ncy = this.ncx;
        public boolean ncz = true;
        private boolean ncA = this.ncz;
        private int ncB = master.flame.danmaku.danmaku.model.c.MAX;
        private float ncC = 1.0f;
        private boolean ncD = false;
        private int gky = 0;
        private int ncE = 0;
        public final TextPaint nck = new TextPaint();

        public C0804a() {
            this.nck.setStrokeWidth(this.STROKE_WIDTH);
            this.ncl = new TextPaint(this.nck);
            this.ncm = new Paint();
            this.ncn = new Paint();
            this.ncn.setStrokeWidth(this.ncp);
            this.ncn.setStyle(Paint.Style.STROKE);
            this.nco = new Paint();
            this.nco.setStyle(Paint.Style.STROKE);
            this.nco.setStrokeWidth(4.0f);
        }

        public void aO(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.nck.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.ncq != f || this.ncr != f2 || this.ncs != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.ncq = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.ncr = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.ncs = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.ncD) {
                Float f = this.ncj.get(Float.valueOf(dVar.baM));
                if (f == null || this.nci != this.ncC) {
                    this.nci = this.ncC;
                    f = Float.valueOf(dVar.baM * this.ncC);
                    this.ncj.put(Float.valueOf(dVar.baM), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.ncw || this.ncy) && this.STROKE_WIDTH > 0.0f && dVar.naX != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.nco.setColor(dVar.borderColor);
            return this.nco;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.ncn.setColor(dVar.naY);
            return this.ncn;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.nck;
            } else {
                textPaint = this.ncl;
                textPaint.set(this.nck);
            }
            textPaint.setTextSize(dVar.baM);
            a(dVar, textPaint);
            if (!this.ncu || this.SHADOW_RADIUS <= 0.0f || dVar.naX == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.naX);
            }
            textPaint.setAntiAlias(this.ncA);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.ncy ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.naX & 16777215);
                    paint.setAlpha(this.ncy ? (int) (this.ncs * (this.ncB / master.flame.danmaku.danmaku.model.c.MAX)) : this.ncB);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.ncB);
                }
            } else if (z) {
                paint.setStyle(this.ncy ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.naX & 16777215);
                paint.setAlpha(this.ncy ? this.ncs : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.ncu && this.ncw) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.ncu) {
                return this.SHADOW_RADIUS;
            }
            if (this.ncw) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wA(boolean z) {
            this.ncw = this.ncv;
            this.ncu = this.nct;
            this.ncy = this.ncx;
            this.ncA = z && this.ncz;
        }
    }

    @SuppressLint({"NewApi"})
    private static final int af(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapWidth() : canvas.getWidth();
    }

    @SuppressLint({"NewApi"})
    private static final int ag(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 14 ? canvas.getMaximumBitmapHeight() : canvas.getHeight();
    }

    public void aO(float f) {
        this.nbZ.aO(f);
    }

    public void aP(float f) {
        this.nbZ.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.nbZ.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.nca) {
            this.nca = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dFh() {
        return this.nca;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.nbZ.gky;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFJ() {
        return this.nbZ.ncE;
    }

    private void ah(Canvas canvas) {
        this.ncb = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.ncf) {
                this.ncg = af(canvas);
                this.nch = ag(canvas);
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
        return this.alE;
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
        float dFp = dVar.dFp();
        float dFo = dVar.dFo();
        if (this.ncb != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.naS) {
                return 0;
            } else {
                if (dVar.naW == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.ncb, dFo, dFp);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.nbZ.ncm;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.naS) {
                if (this.nca.a(dVar, this.ncb, dFo, dFp, paint, this.nbZ.nck)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.nbZ.nck.setAlpha(paint.getAlpha());
                            this.nbZ.ncl.setAlpha(paint.getAlpha());
                        } else {
                            c(this.nbZ.nck);
                        }
                        a(dVar, this.ncb, dFo, dFp, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ai(this.ncb);
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
        if (this.nca != null) {
            this.nca.t(dVar);
        }
    }

    private void c(Paint paint) {
        if (paint.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
            paint.setAlpha(master.flame.danmaku.danmaku.model.c.MAX);
        }
    }

    private void ai(Canvas canvas) {
        canvas.restore();
    }

    private int a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
        this.nbY.save();
        if (this.ncc != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.nbY.setLocation(0.0f, 0.0f, this.ncc);
        }
        this.nbY.rotateY(-dVar.rotationY);
        this.nbY.rotateZ(-dVar.naW);
        this.nbY.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.nbY.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.nca != null) {
            this.nca.a(dVar, canvas, f, f2, z, this.nbZ);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.nbZ.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nca != null) {
            this.nca.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.nbZ.ncw) {
            this.nbZ.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.nbZ.ncw) {
            this.nbZ.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.nca.b(dVar, textPaint, z);
        a(dVar, dVar.nba, dVar.nbb);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0804a c0804a = this.nbZ;
            f3 += 8;
            C0804a c0804a2 = this.nbZ;
            f4 += 8;
        }
        dVar.nba = f3 + getStrokeWidth();
        dVar.nbb = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dFF() {
        return this.ncd;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aN(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nce = (int) max;
        if (f > 1.0f) {
            this.nce = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFG() {
        return this.nce;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.alE = f;
        this.densityDpi = i;
        this.ncd = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.ncc = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.nbZ.nct = false;
                this.nbZ.ncv = true;
                this.nbZ.ncx = false;
                aP(fArr[0]);
                return;
            case 0:
                this.nbZ.nct = false;
                this.nbZ.ncv = false;
                this.nbZ.ncx = false;
                return;
            case 1:
                this.nbZ.nct = true;
                this.nbZ.ncv = false;
                this.nbZ.ncx = false;
                aO(fArr[0]);
                return;
            case 3:
                this.nbZ.nct = false;
                this.nbZ.ncv = false;
                this.nbZ.ncx = true;
                e(fArr[0], fArr[1], (int) fArr[2]);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: aj */
    public void setExtraData(Canvas canvas) {
        ah(canvas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: dFP */
    public Canvas rJ() {
        return this.ncb;
    }

    public float getStrokeWidth() {
        return this.nbZ.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wz(boolean z) {
        this.ncf = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.ncf;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFH() {
        return this.ncg;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFI() {
        return this.nch;
    }
}
