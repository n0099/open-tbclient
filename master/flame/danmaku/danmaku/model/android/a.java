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
    public Canvas nce;
    private float ncf;
    private int width;
    private Camera ncb = new Camera();
    private Matrix matrix = new Matrix();
    private final C0825a ncc = new C0825a();
    private b ncd = new h();
    private float alK = 1.0f;
    private int densityDpi = 160;
    private float ncg = 1.0f;
    private int nch = 0;
    private boolean nci = true;
    private int ncj = 2048;
    private int nck = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0825a {
        private boolean isTranslucent;
        private float ncl;
        public final TextPaint nco;
        private Paint ncp;
        private Paint ncq;
        private Paint ncr;
        private final Map<Float, Float> ncm = new HashMap(10);
        public int ncs = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float nct = 1.0f;
        public float ncu = 1.0f;
        private int ncv = 204;
        public boolean ncw = false;
        private boolean ncx = this.ncw;
        public boolean ncy = true;
        private boolean ncz = this.ncy;
        public boolean ncA = false;
        public boolean ncB = this.ncA;
        public boolean ncC = true;
        private boolean ncD = this.ncC;
        private int ncE = master.flame.danmaku.danmaku.model.c.MAX;
        private float ncF = 1.0f;
        private boolean ncG = false;
        private int gkE = 0;
        private int ncH = 0;
        public final TextPaint ncn = new TextPaint();

        public C0825a() {
            this.ncn.setStrokeWidth(this.STROKE_WIDTH);
            this.nco = new TextPaint(this.ncn);
            this.ncp = new Paint();
            this.ncq = new Paint();
            this.ncq.setStrokeWidth(this.ncs);
            this.ncq.setStyle(Paint.Style.STROKE);
            this.ncr = new Paint();
            this.ncr.setStyle(Paint.Style.STROKE);
            this.ncr.setStrokeWidth(4.0f);
        }

        public void aO(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.ncn.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.nct != f || this.ncu != f2 || this.ncv != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.nct = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.ncu = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.ncv = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.ncG) {
                Float f = this.ncm.get(Float.valueOf(dVar.baR));
                if (f == null || this.ncl != this.ncF) {
                    this.ncl = this.ncF;
                    f = Float.valueOf(dVar.baR * this.ncF);
                    this.ncm.put(Float.valueOf(dVar.baR), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.ncz || this.ncB) && this.STROKE_WIDTH > 0.0f && dVar.nba != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.ncr.setColor(dVar.borderColor);
            return this.ncr;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.ncq.setColor(dVar.nbb);
            return this.ncq;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.ncn;
            } else {
                textPaint = this.nco;
                textPaint.set(this.ncn);
            }
            textPaint.setTextSize(dVar.baR);
            a(dVar, textPaint);
            if (!this.ncx || this.SHADOW_RADIUS <= 0.0f || dVar.nba == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.nba);
            }
            textPaint.setAntiAlias(this.ncD);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.ncB ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.nba & 16777215);
                    paint.setAlpha(this.ncB ? (int) (this.ncv * (this.ncE / master.flame.danmaku.danmaku.model.c.MAX)) : this.ncE);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.ncE);
                }
            } else if (z) {
                paint.setStyle(this.ncB ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.nba & 16777215);
                paint.setAlpha(this.ncB ? this.ncv : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.ncx && this.ncz) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.ncx) {
                return this.SHADOW_RADIUS;
            }
            if (this.ncz) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void wA(boolean z) {
            this.ncz = this.ncy;
            this.ncx = this.ncw;
            this.ncB = this.ncA;
            this.ncD = z && this.ncC;
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
        this.ncc.aO(f);
    }

    public void aP(float f) {
        this.ncc.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.ncc.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.ncd) {
            this.ncd = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dFe() {
        return this.ncd;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.ncc.gkE;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFG() {
        return this.ncc.ncH;
    }

    private void ah(Canvas canvas) {
        this.nce = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.nci) {
                this.ncj = af(canvas);
                this.nck = ag(canvas);
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
        return this.alK;
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
        float dFm = dVar.dFm();
        float dFl = dVar.dFl();
        if (this.nce != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.naV) {
                return 0;
            } else {
                if (dVar.naZ == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.nce, dFl, dFm);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.ncc.ncp;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.naV) {
                if (this.ncd.a(dVar, this.nce, dFl, dFm, paint, this.ncc.ncn)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.ncc.ncn.setAlpha(paint.getAlpha());
                            this.ncc.nco.setAlpha(paint.getAlpha());
                        } else {
                            c(this.ncc.ncn);
                        }
                        a(dVar, this.nce, dFl, dFm, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ai(this.nce);
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
        if (this.ncd != null) {
            this.ncd.t(dVar);
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
        this.ncb.save();
        if (this.ncf != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.ncb.setLocation(0.0f, 0.0f, this.ncf);
        }
        this.ncb.rotateY(-dVar.rotationY);
        this.ncb.rotateZ(-dVar.naZ);
        this.ncb.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.ncb.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.ncd != null) {
            this.ncd.a(dVar, canvas, f, f2, z, this.ncc);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.ncc.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.ncd != null) {
            this.ncd.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.ncc.ncz) {
            this.ncc.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.ncc.ncz) {
            this.ncc.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.ncd.b(dVar, textPaint, z);
        a(dVar, dVar.nbd, dVar.nbe);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0825a c0825a = this.ncc;
            f3 += 8;
            C0825a c0825a2 = this.ncc;
            f4 += 8;
        }
        dVar.nbd = f3 + getStrokeWidth();
        dVar.nbe = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dFC() {
        return this.ncg;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aN(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.nch = (int) max;
        if (f > 1.0f) {
            this.nch = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFD() {
        return this.nch;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.alK = f;
        this.densityDpi = i;
        this.ncg = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.ncf = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.ncc.ncw = false;
                this.ncc.ncy = true;
                this.ncc.ncA = false;
                aP(fArr[0]);
                return;
            case 0:
                this.ncc.ncw = false;
                this.ncc.ncy = false;
                this.ncc.ncA = false;
                return;
            case 1:
                this.ncc.ncw = true;
                this.ncc.ncy = false;
                this.ncc.ncA = false;
                aO(fArr[0]);
                return;
            case 3:
                this.ncc.ncw = false;
                this.ncc.ncy = false;
                this.ncc.ncA = true;
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
    /* renamed from: dFM */
    public Canvas rJ() {
        return this.nce;
    }

    public float getStrokeWidth() {
        return this.ncc.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void wz(boolean z) {
        this.nci = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.nci;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFE() {
        return this.ncj;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dFF() {
        return this.nck;
    }
}
