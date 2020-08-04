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
    public Canvas ocR;
    private float ocS;
    private int width;
    private Camera ocO = new Camera();
    private Matrix matrix = new Matrix();
    private final C0923a ocP = new C0923a();
    private b ocQ = new h();
    private float aoA = 1.0f;
    private int densityDpi = 160;
    private float ocT = 1.0f;
    private int ocU = 0;
    private boolean ocV = true;
    private int ocW = 2048;
    private int ocX = 2048;

    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0923a {
        private boolean isTranslucent;
        private float ocY;
        public final TextPaint odb;
        private Paint odc;
        private Paint odd;
        private Paint ode;
        private final Map<Float, Float> ocZ = new HashMap(10);
        public int odf = 4;
        private float SHADOW_RADIUS = 4.0f;
        private float STROKE_WIDTH = 3.5f;
        public float odg = 1.0f;
        public float odh = 1.0f;
        private int odi = 204;
        public boolean odj = false;
        private boolean odk = this.odj;
        public boolean odl = true;
        private boolean odm = this.odl;
        public boolean odn = false;
        public boolean odo = this.odn;
        public boolean odp = true;
        private boolean odq = this.odp;
        private int odr = master.flame.danmaku.danmaku.model.c.MAX;
        private float ods = 1.0f;
        private boolean odt = false;
        private int gRX = 0;
        private int odu = 0;
        public final TextPaint oda = new TextPaint();

        public C0923a() {
            this.oda.setStrokeWidth(this.STROKE_WIDTH);
            this.odb = new TextPaint(this.oda);
            this.odc = new Paint();
            this.odd = new Paint();
            this.odd.setStrokeWidth(this.odf);
            this.odd.setStyle(Paint.Style.STROKE);
            this.ode = new Paint();
            this.ode.setStyle(Paint.Style.STROKE);
            this.ode.setStrokeWidth(4.0f);
        }

        public void aS(float f) {
            this.SHADOW_RADIUS = f;
        }

        public void setStrokeWidth(float f) {
            this.oda.setStrokeWidth(f);
            this.STROKE_WIDTH = f;
        }

        public void e(float f, float f2, int i) {
            if (this.odg != f || this.odh != f2 || this.odi != i) {
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                this.odg = f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                this.odh = f2;
                if (i < 0) {
                    i = 0;
                } else if (i > 255) {
                    i = 255;
                }
                this.odi = i;
            }
        }

        private void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.odt) {
                Float f = this.ocZ.get(Float.valueOf(dVar.bnP));
                if (f == null || this.ocY != this.ods) {
                    this.ocY = this.ods;
                    f = Float.valueOf(dVar.bnP * this.ods);
                    this.ocZ.put(Float.valueOf(dVar.bnP), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        public boolean p(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.odm || this.odo) && this.STROKE_WIDTH > 0.0f && dVar.obO != 0;
        }

        public Paint q(master.flame.danmaku.danmaku.model.d dVar) {
            this.ode.setColor(dVar.borderColor);
            return this.ode;
        }

        public Paint r(master.flame.danmaku.danmaku.model.d dVar) {
            this.odd.setColor(dVar.underlineColor);
            return this.odd;
        }

        public TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
            TextPaint textPaint;
            if (z) {
                textPaint = this.oda;
            } else {
                textPaint = this.odb;
                textPaint.set(this.oda);
            }
            textPaint.setTextSize(dVar.bnP);
            a(dVar, textPaint);
            if (!this.odk || this.SHADOW_RADIUS <= 0.0f || dVar.obO == 0) {
                textPaint.clearShadowLayer();
            } else {
                textPaint.setShadowLayer(this.SHADOW_RADIUS, 1.0f, 1.0f, dVar.obO);
            }
            textPaint.setAntiAlias(this.odq);
            return textPaint;
        }

        public void a(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z) {
            if (this.isTranslucent) {
                if (z) {
                    paint.setStyle(this.odo ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.obO & 16777215);
                    paint.setAlpha(this.odo ? (int) (this.odi * (this.odr / master.flame.danmaku.danmaku.model.c.MAX)) : this.odr);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.textColor & 16777215);
                    paint.setAlpha(this.odr);
                }
            } else if (z) {
                paint.setStyle(this.odo ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.obO & 16777215);
                paint.setAlpha(this.odo ? this.odi : master.flame.danmaku.danmaku.model.c.MAX);
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
            if (this.odk && this.odm) {
                return Math.max(this.SHADOW_RADIUS, this.STROKE_WIDTH);
            }
            if (this.odk) {
                return this.SHADOW_RADIUS;
            }
            if (this.odm) {
                return this.STROKE_WIDTH;
            }
            return 0.0f;
        }

        public void ya(boolean z) {
            this.odm = this.odl;
            this.odk = this.odj;
            this.odo = this.odn;
            this.odq = z && this.odp;
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
        this.ocP.aS(f);
    }

    public void aT(float f) {
        this.ocP.setStrokeWidth(f);
    }

    public void e(float f, float f2, int i) {
        this.ocP.e(f, f2, i);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void a(b bVar) {
        if (bVar != this.ocQ) {
            this.ocQ = bVar;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b dVt() {
        return this.ocQ;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int getMargin() {
        return this.ocP.gRX;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVV() {
        return this.ocP.odu;
    }

    private void ao(Canvas canvas) {
        this.ocR = canvas;
        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            if (this.ocV) {
                this.ocW = am(canvas);
                this.ocX = an(canvas);
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
        float dVB = dVar.dVB();
        float dVA = dVar.dVA();
        if (this.ocR != null) {
            Paint paint = null;
            if (dVar.getType() != 7) {
                z = false;
            } else if (dVar.getAlpha() == master.flame.danmaku.danmaku.model.c.obJ) {
                return 0;
            } else {
                if (dVar.obN == 0.0f && dVar.rotationY == 0.0f) {
                    z2 = false;
                } else {
                    a(dVar, this.ocR, dVA, dVB);
                    z2 = true;
                }
                if (dVar.getAlpha() != master.flame.danmaku.danmaku.model.c.MAX) {
                    paint = this.ocP.odc;
                    paint.setAlpha(dVar.getAlpha());
                }
                z = z2;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.obJ) {
                if (this.ocQ.a(dVar, this.ocR, dVA, dVB, paint, this.ocP.oda)) {
                    i = 1;
                } else {
                    try {
                        if (paint != null) {
                            this.ocP.oda.setAlpha(paint.getAlpha());
                            this.ocP.odb.setAlpha(paint.getAlpha());
                        } else {
                            c(this.ocP.oda);
                        }
                        a(dVar, this.ocR, dVA, dVB, false);
                        i = 2;
                    } catch (Exception e) {
                        i = 1;
                    }
                }
                if (z) {
                    try {
                        ap(this.ocR);
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
        if (this.ocQ != null) {
            this.ocQ.t(dVar);
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
        this.ocO.save();
        if (this.ocS != 0.0f && Build.VERSION.SDK_INT >= 12) {
            this.ocO.setLocation(0.0f, 0.0f, this.ocS);
        }
        this.ocO.rotateY(-dVar.rotationY);
        this.ocO.rotateZ(-dVar.obN);
        this.ocO.getMatrix(this.matrix);
        this.matrix.postTranslate(f, f2);
        this.ocO.restore();
        int save = canvas.save();
        canvas.concat(this.matrix);
        return save;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.b
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z) {
        if (this.ocQ != null) {
            this.ocQ.a(dVar, canvas, f, f2, z, this.ocP);
        }
    }

    private synchronized TextPaint d(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        return this.ocP.d(dVar, z);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.ocQ != null) {
            this.ocQ.b(dVar, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        TextPaint d = d(dVar, z);
        if (this.ocP.odm) {
            this.ocP.a(dVar, d, true);
        }
        a(dVar, d, z);
        if (this.ocP.odm) {
            this.ocP.a(dVar, d, false);
        }
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        this.ocQ.b(dVar, textPaint, z);
        a(dVar, dVar.obQ, dVar.obR);
    }

    private void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2) {
        float f3 = f + (dVar.padding * 2);
        float f4 = (dVar.padding * 2) + f2;
        if (dVar.borderColor != 0) {
            C0923a c0923a = this.ocP;
            f3 += 8;
            C0923a c0923a2 = this.ocP;
            f4 += 8;
        }
        dVar.obQ = f3 + getStrokeWidth();
        dVar.obR = f4;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public float dVR() {
        return this.ocT;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void aR(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.ocU = (int) max;
        if (f > 1.0f) {
            this.ocU = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVS() {
        return this.ocU;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(float f, int i, float f2) {
        this.aoA = f;
        this.densityDpi = i;
        this.ocT = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.ocS = (float) ((i / 2.0f) / Math.tan(0.4799655442984406d));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(int i, float[] fArr) {
        switch (i) {
            case -1:
            case 2:
                this.ocP.odj = false;
                this.ocP.odl = true;
                this.ocP.odn = false;
                aT(fArr[0]);
                return;
            case 0:
                this.ocP.odj = false;
                this.ocP.odl = false;
                this.ocP.odn = false;
                return;
            case 1:
                this.ocP.odj = true;
                this.ocP.odl = false;
                this.ocP.odn = false;
                aS(fArr[0]);
                return;
            case 3:
                this.ocP.odj = false;
                this.ocP.odl = false;
                this.ocP.odn = true;
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
    /* renamed from: dWb */
    public Canvas sm() {
        return this.ocR;
    }

    public float getStrokeWidth() {
        return this.ocP.getStrokeWidth();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void xZ(boolean z) {
        this.ocV = z;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.m
    public boolean isHardwareAccelerated() {
        return this.ocV;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVT() {
        return this.ocW;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int dVU() {
        return this.ocX;
    }
}
