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
    public Canvas ocP;
    private float ocQ;
    private int width;
    private Camera ocM = new Camera();
    private Matrix matrix = new Matrix();
    private final C0923a ocN = new C0923a();
    private b ocO = new h();
    private float aoA = 1.0f;
    private int densityDpi = 160;
    private float ocR = 1.0f;
    private int ocS = 0;
    private boolean ocT = true;
    private int ocU = 2048;
    private int ocV = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0923a {
        private boolean isTranslucent;
        private float ocW;
        public final TextPaint ocZ;
        private Paint oda;
        private Paint odb;
        private Paint odc;
        private final Map<Float, Float> ocX = new HashMap(10);
        public int odd = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float ode = 1.0f;
        public float odf = 1.0f;
        private int odg = 204;
        public boolean odh = false;
        private boolean odi = this.odh;
        public boolean odj = true;
        private boolean odk = this.odj;
        public boolean odl = false;
        public boolean odm = this.odl;
        public boolean odn = true;
        private boolean odo = this.odn;
        private int odp = master.flame.danmaku.danmaku.model.c.MAX;
        private float odq = 1.0f;
        private boolean odr = false;
        private int gRX = 0;
        private int ods = 0;
        public final TextPaint ocY = new TextPaint();

        public C0923a() {
            this.ocY.setStrokeWidth(this.STROKE_WIDTH);
            this.ocZ = new TextPaint(this.ocY);
            this.oda = new Paint();
            this.odb = new Paint();
            this.odb.setStrokeWidth(this.odd);
            this.odb.setStyle(Paint.Style.STROKE);
            this.odc = new Paint();
            this.odc.setStyle(Paint.Style.STROKE);
            this.odc.setStrokeWidth(4.0f);
        }

        public void aS(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.ocY.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.ode != f || this.odf != f2 || this.odg != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.ode = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.odf = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.odg = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.odr) {
                Float f = this.ocX.get(Float.valueOf(dVar.bnP));
                if (f == null || this.ocW != this.odq) {
                    this.ocW = this.odq;
                    f = Float.valueOf(dVar.bnP * this.odq);
                    this.ocX.put(Float.valueOf(dVar.bnP), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.odk || this.odm) && this.STROKE_WIDTH > 0.0f && dVar.obM != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.odc.setColor(dVar.borderColor);
            return this.odc;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.odb.setColor(dVar.underlineColor);
            return this.odb;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.ocY;
            } else {
                textPaint = this.ocZ;
                textPaint.set(this.ocY);
            }
            textPaint.setTextSize(dVar.bnP);
            a(dVar, textPaint);
            if (!this.odi || this.SHADOW_RADIUS <= 0.0f || dVar.obM == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.obM);
            }
            textPaint.setAntiAlias(this.odo);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.odm ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.obM & 16777215);
                    paint.setAlpha(this.odm ? (int) (this.odg * (this.odp / master.flame.danmaku.danmaku.model.c.MAX)) : this.odp);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.odp);
                }
            } else if (z) {
                paint.setStyle(this.odm ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.obM & 16777215);
                paint.setAlpha(this.odm ? this.odg : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.odi && this.odk) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.odi) {
                return this.SHADOW_RADIUS;
            }
            if (this.odk) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void ya(boolean z) {
            this.odk = this.odj;
            this.odi = this.odh;
            this.odm = this.odl;
            this.odo = z && this.odn;
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

    public void aS(float f) {
        this.ocN.aS(f);
    }

    public void aT(float f) {
        this.ocN.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.ocN.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.ocO) {
            this.ocO = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dVs() {
        return this.ocO;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.ocN.gRX;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVU() {
        return this.ocN.ods;
    }

    private void ao(Canvas canvas) {
        this.ocP = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.ocT) {
                this.ocU = am(canvas);
                this.ocV = an(canvas);
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
        return this.aoA;
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
        float dVA = dVar.dVA();
        float dVz = dVar.dVz();
        if (this.ocP != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.obH) {
                return 0;
            } else {
                if (dVar.obL == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.ocP, dVz, dVA);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.ocN.oda;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.obH) {
                if (this.ocO.a(dVar, this.ocP, dVz, dVA, paint, this.ocN.ocY)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.ocN.ocY.setAlpha(paint.getAlpha());
                            this.ocN.ocZ.setAlpha(paint.getAlpha());
                        } else {
                            c(this.ocN.ocY);
                        }
                        a(dVar, this.ocP, dVz, dVA, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ap(this.ocP);
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
        if (this.ocO != null) {
            this.ocO.t(dVar);
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
        this.ocM.save();
        if (this.ocQ != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.ocM.setLocation(0.0f, 0.0f, this.ocQ);
        }
        this.ocM.rotateY(-dVar.rotationY);
        this.ocM.rotateZ(-dVar.obL);
        this.ocM.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.ocM.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.ocO != null) {
            this.ocO.a(dVar, canvas, f, f2, z, this.ocN);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.ocN.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.ocO != null) {
            this.ocO.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.ocN.odk) {
            this.ocN.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.ocN.odk) {
            this.ocN.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.ocO.b(dVar, textPaint, z);
        a(dVar, dVar.obO, dVar.obP);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0923a c0923a = this.ocN;
            f3 += 8;
            C0923a c0923a2 = this.ocN;
            f4 += 8;
        }
        dVar.obO = f3 + getStrokeWidth();
        dVar.obP = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dVQ() {
        return this.ocR;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aR(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.ocS = (int) max;
        if (f > 1.0f) {
            this.ocS = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVR() {
        return this.ocS;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.aoA = f;
        this.densityDpi = i;
        this.ocR = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.ocQ = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.ocN.odh = false;
                this.ocN.odj = true;
                this.ocN.odl = false;
                aT(fArr[0]);
                return;
            case 0:
                this.ocN.odh = false;
                this.ocN.odj = false;
                this.ocN.odl = false;
                return;
            case 1:
                this.ocN.odh = true;
                this.ocN.odj = false;
                this.ocN.odl = false;
                aS(fArr[0]);
                return;
            case 3:
                this.ocN.odh = false;
                this.ocN.odj = false;
                this.ocN.odl = true;
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
    /* renamed from: dWa */
    public Canvas sm() {
        return this.ocP;
    }

    public float getStrokeWidth() {
        return this.ocN.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void xZ(boolean z) {
        this.ocT = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.ocT;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVS() {
        return this.ocU;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVT() {
        return this.ocV;
    }
}
