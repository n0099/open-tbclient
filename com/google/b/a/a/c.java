package com.google.b.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.view.Display;
import com.google.b.a.a.a.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class c implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final Display f8185a;
    private volatile boolean j;
    private long p;
    private com.google.b.a.a.a.a pQP;
    private d pQQ;
    private a pQR;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f8186b = new float[16];
    private final float[] c = new float[16];
    private float d = -1.0f;
    private final float[] e = new float[16];
    private final float[] f = new float[16];
    private final float[] g = new float[16];
    private float h = 1.0f;
    private final Object i = new Object();
    private final Object l = new Object();
    private volatile boolean q = true;
    private float[] pQS = new float[3];
    private final g pQT = new g();
    private final g pQe = new g();
    private final g pQU = new g();
    private final com.google.b.a.a.a.d pQO = new com.google.b.a.a.a.d();

    public c(d dVar, a aVar, Display display) {
        this.pQR = aVar;
        this.pQQ = dVar;
        this.f8185a = display;
        a(true);
        Matrix.setIdentityM(this.e, 0);
    }

    public void a() {
        if (this.j) {
            return;
        }
        this.pQO.a();
        Object obj = this.l;
        synchronized (this.l) {
            if (this.pQP != null) {
                this.pQP.a();
            }
        }
        this.q = true;
        this.pQQ.a(this);
        this.pQQ.a();
        this.j = true;
    }

    public void a(boolean z) {
        Object obj = this.l;
        synchronized (this.l) {
            if (!z) {
                this.pQP = null;
            } else if (this.pQP == null) {
                this.pQP = new com.google.b.a.a.a.a();
            }
        }
    }

    public void a(float[] fArr, int i) {
        float f;
        if (i + 16 > fArr.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        }
        switch (this.f8185a.getRotation()) {
            case 0:
                f = 0.0f;
                break;
            case 1:
                f = 90.0f;
                break;
            case 2:
                f = 180.0f;
                break;
            case 3:
                f = 270.0f;
                break;
            default:
                f = 0.0f;
                break;
        }
        if (f != this.d) {
            this.d = f;
            Matrix.setRotateEulerM(this.c, 0, 0.0f, 0.0f, -f);
            Matrix.setRotateEulerM(this.f8186b, 0, -90.0f, 0.0f, f);
        }
        com.google.b.a.a.a.d dVar = this.pQO;
        synchronized (this.pQO) {
            if (this.pQO.b()) {
                double[] Q = this.pQO.Q(TimeUnit.NANOSECONDS.toSeconds(this.pQR.a() - this.p) + 0.057999998331069946d);
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    this.f[i2] = (float) Q[i2];
                }
                Matrix.multiplyMM(this.g, 0, this.c, 0, this.f, 0);
                Matrix.multiplyMM(fArr, i, this.g, 0, this.f8186b, 0);
                Matrix.setIdentityM(this.e, 0);
                Matrix.translateM(this.e, 0, 0.0f, (-this.h) * 0.075f, this.h * 0.08f);
                Matrix.multiplyMM(this.f, 0, this.e, 0, fArr, i);
                Matrix.translateM(fArr, i, this.f, 0, 0.0f, this.h * 0.075f, 0.0f);
            }
        }
    }

    public void b() {
        if (this.j) {
            this.pQQ.b(this);
            this.pQQ.b();
            this.j = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.pQU.a(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            this.pQO.b(this.pQU, sensorEvent.timestamp);
            Object obj = this.l;
            synchronized (this.l) {
                if (this.pQP != null) {
                    this.pQP.b(this.pQU, sensorEvent.timestamp);
                }
            }
        } else if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            this.p = this.pQR.a();
            if (sensorEvent.sensor.getType() == 16) {
                if (this.q && sensorEvent.values.length == 6) {
                    this.pQS[0] = sensorEvent.values[3];
                    this.pQS[1] = sensorEvent.values[4];
                    this.pQS[2] = sensorEvent.values[5];
                }
                this.pQe.a(sensorEvent.values[0] - this.pQS[0], sensorEvent.values[1] - this.pQS[1], sensorEvent.values[2] - this.pQS[2]);
            } else {
                this.pQe.a(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            }
            this.q = false;
            Object obj2 = this.l;
            synchronized (this.l) {
                if (this.pQP != null) {
                    this.pQP.a(this.pQe, sensorEvent.timestamp);
                    this.pQP.a(this.pQT);
                    g.b(this.pQe, this.pQT, this.pQe);
                }
            }
            this.pQO.a(this.pQe, sensorEvent.timestamp);
        }
    }
}
