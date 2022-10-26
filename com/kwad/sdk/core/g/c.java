package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
/* loaded from: classes7.dex */
public final class c {
    public volatile boolean adk = true;
    public long adl = 0;
    public double adm = 9.999999717180685E-10d;
    public double[] adn = {0.0d, 0.0d, 0.0d};
    public double[] ado = {0.0d, 0.0d, 0.0d};
    public com.kwad.sdk.core.g.a adp;
    public a adq;
    public AdMatrixInfo.RotateInfo rotateInfo;

    /* loaded from: classes7.dex */
    public final class a implements SensorEventListener {
        public a() {
        }

        public /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (c.this.adl != 0) {
                double d = (sensorEvent.timestamp - c.this.adl) * c.this.adm;
                double[] dArr = c.this.ado;
                dArr[0] = dArr[0] + Math.toDegrees(f * d);
                double[] dArr2 = c.this.ado;
                dArr2[1] = dArr2[1] + Math.toDegrees(f2 * d);
                double[] dArr3 = c.this.ado;
                dArr3[2] = dArr3[2] + Math.toDegrees(f3 * d);
                c.this.vc();
                c.this.vd();
            }
            c.this.adl = sensorEvent.timestamp;
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.ado[i]) < d) {
            return false;
        }
        return (this.ado[i] <= 0.0d || i2 != 1) && (this.ado[i] >= 0.0d || i2 != 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc() {
        if (this.adk) {
            if (Math.abs(this.ado[0]) > Math.abs(this.adn[0])) {
                this.adn[0] = this.ado[0];
            }
            if (Math.abs(this.ado[1]) > Math.abs(this.adn[1])) {
                this.adn[1] = this.ado[1];
            }
            if (Math.abs(this.ado[2]) > Math.abs(this.adn[2])) {
                this.adn[2] = this.ado[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vd() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.adk || (rotateInfo = this.rotateInfo) == null || this.adp == null) {
            return;
        }
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = rotateInfo.x;
        if (!a(0, rotateDegreeInfo.rotateDegree, rotateDegreeInfo.direction)) {
            AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = this.rotateInfo.y;
            if (!a(1, rotateDegreeInfo2.rotateDegree, rotateDegreeInfo2.direction)) {
                AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = this.rotateInfo.z;
                if (!a(2, rotateDegreeInfo3.rotateDegree, rotateDegreeInfo3.direction)) {
                    return;
                }
            }
        }
        this.adk = false;
        this.adp.aa(ve());
        this.ado = new double[]{0.0d, 0.0d, 0.0d};
        this.adn = new double[]{0.0d, 0.0d, 0.0d};
    }

    private String ve() {
        return "{\"x\": " + this.adn[0] + ",\"y\":" + this.adn[1] + ",\"z\":" + this.adn[2] + "}";
    }

    public final void a(com.kwad.sdk.core.g.a aVar) {
        this.adp = aVar;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final synchronized void bA(Context context) {
        if (context != null) {
            if (this.adq != null) {
                ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.adq);
                this.adq = null;
            }
        }
    }

    public final void bz(Context context) {
        if (context == null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        if (defaultSensor != null) {
            if (this.adq == null) {
                this.adq = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.adq, defaultSensor, 2);
            return;
        }
        com.kwad.sdk.core.g.a aVar = this.adp;
        if (aVar != null) {
            aVar.ko();
        }
    }

    public final synchronized void vb() {
        this.adk = true;
    }
}
