package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
/* loaded from: classes5.dex */
public final class c {
    public AdMatrixInfo.RotateInfo a;
    public volatile boolean b = true;
    public long c = 0;
    public double d = 9.999999717180685E-10d;
    public double[] e = {0.0d, 0.0d, 0.0d};
    public double[] f = {0.0d, 0.0d, 0.0d};
    @Nullable
    public com.kwad.sdk.core.f.a g;
    @Nullable
    public a h;

    /* loaded from: classes5.dex */
    public class a implements SensorEventListener {
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
            if (c.this.c != 0) {
                double d = (sensorEvent.timestamp - c.this.c) * c.this.d;
                double[] dArr = c.this.f;
                dArr[0] = dArr[0] + Math.toDegrees(f * d);
                double[] dArr2 = c.this.f;
                dArr2[1] = dArr2[1] + Math.toDegrees(f2 * d);
                double[] dArr3 = c.this.f;
                dArr3[2] = dArr3[2] + Math.toDegrees(f3 * d);
                c.this.b();
                c.this.c();
            }
            c.this.c = sensorEvent.timestamp;
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.a = rotateInfo;
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.f[i]) < d) {
            return false;
        }
        return (this.f[i] <= 0.0d || i2 != 1) && (this.f[i] >= 0.0d || i2 != 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b) {
            if (Math.abs(this.f[0]) > Math.abs(this.e[0])) {
                this.e[0] = this.f[0];
            }
            if (Math.abs(this.f[1]) > Math.abs(this.e[1])) {
                this.e[1] = this.f[1];
            }
            if (Math.abs(this.f[2]) > Math.abs(this.e[2])) {
                this.e[2] = this.f[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.b || (rotateInfo = this.a) == null || this.g == null) {
            return;
        }
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = rotateInfo.x;
        if (!a(0, rotateDegreeInfo.rotateDegree, rotateDegreeInfo.direction)) {
            AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = this.a.y;
            if (!a(1, rotateDegreeInfo2.rotateDegree, rotateDegreeInfo2.direction)) {
                AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = this.a.z;
                if (!a(2, rotateDegreeInfo3.rotateDegree, rotateDegreeInfo3.direction)) {
                    return;
                }
            }
        }
        this.b = false;
        this.g.b(d());
        this.f = new double[]{0.0d, 0.0d, 0.0d};
        this.e = new double[]{0.0d, 0.0d, 0.0d};
    }

    private String d() {
        return "{\"x\": " + this.e[0] + ",\"y\":" + this.e[1] + ",\"z\":" + this.e[2] + "}";
    }

    public final synchronized void a() {
        this.b = true;
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        if (defaultSensor != null) {
            if (this.h == null) {
                this.h = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.h, defaultSensor, 2);
            return;
        }
        com.kwad.sdk.core.f.a aVar = this.g;
        if (aVar != null) {
            aVar.n();
        }
    }

    public final void a(@Nullable com.kwad.sdk.core.f.a aVar) {
        this.g = aVar;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.a = rotateInfo;
    }

    public final synchronized void b(Context context) {
        if (context != null) {
            if (this.h != null) {
                ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.h);
                this.h = null;
            }
        }
    }
}
