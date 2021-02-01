package com.google.b.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.view.Display;
import com.google.b.a.a.a.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final Display f7887a;
    private volatile boolean j;
    private long p;
    private com.google.b.a.a.a.a pWv;
    private d pWw;
    private a pWx;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f7888b = new float[16];
    private final float[] c = new float[16];
    private float d = -1.0f;
    private final float[] e = new float[16];
    private final float[] f = new float[16];
    private final float[] g = new float[16];
    private float h = 1.0f;
    private final Object i = new Object();
    private final Object l = new Object();
    private volatile boolean q = true;
    private float[] pWy = new float[3];
    private final g pWz = new g();
    private final g pVJ = new g();
    private final g pWA = new g();
    private final com.google.b.a.a.a.d pWu = new com.google.b.a.a.a.d();

    public c(d dVar, a aVar, Display display) {
        this.pWx = aVar;
        this.pWw = dVar;
        this.f7887a = display;
        a(true);
        Matrix.setIdentityM(this.e, 0);
    }

    public void a() {
        if (this.j) {
            return;
        }
        this.pWu.a();
        Object obj = this.l;
        synchronized (this.l) {
            if (this.pWv != null) {
                this.pWv.a();
            }
        }
        this.q = true;
        this.pWw.a(this);
        this.pWw.a();
        this.j = true;
    }

    public void a(boolean z) {
        Object obj = this.l;
        synchronized (this.l) {
            if (!z) {
                this.pWv = null;
            } else if (this.pWv == null) {
                this.pWv = new com.google.b.a.a.a.a();
            }
        }
    }

    public void a(float[] fArr, int i) {
        float f;
        if (i + 16 > fArr.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        }
        switch (this.f7887a.getRotation()) {
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
            Matrix.setRotateEulerM(this.f7888b, 0, -90.0f, 0.0f, f);
        }
        com.google.b.a.a.a.d dVar = this.pWu;
        synchronized (this.pWu) {
            if (this.pWu.b()) {
                double[] K = this.pWu.K(TimeUnit.NANOSECONDS.toSeconds(this.pWx.a() - this.p) + 0.057999998331069946d);
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    this.f[i2] = (float) K[i2];
                }
                Matrix.multiplyMM(this.g, 0, this.c, 0, this.f, 0);
                Matrix.multiplyMM(fArr, i, this.g, 0, this.f7888b, 0);
                Matrix.setIdentityM(this.e, 0);
                Matrix.translateM(this.e, 0, 0.0f, (-this.h) * 0.075f, this.h * 0.08f);
                Matrix.multiplyMM(this.f, 0, this.e, 0, fArr, i);
                Matrix.translateM(fArr, i, this.f, 0, 0.0f, this.h * 0.075f, 0.0f);
            }
        }
    }

    public void b() {
        if (this.j) {
            this.pWw.b(this);
            this.pWw.b();
            this.j = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.pWA.a(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            this.pWu.b(this.pWA, sensorEvent.timestamp);
            Object obj = this.l;
            synchronized (this.l) {
                if (this.pWv != null) {
                    this.pWv.b(this.pWA, sensorEvent.timestamp);
                }
            }
        } else if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            this.p = this.pWx.a();
            if (sensorEvent.sensor.getType() == 16) {
                if (this.q && sensorEvent.values.length == 6) {
                    this.pWy[0] = sensorEvent.values[3];
                    this.pWy[1] = sensorEvent.values[4];
                    this.pWy[2] = sensorEvent.values[5];
                }
                this.pVJ.a(sensorEvent.values[0] - this.pWy[0], sensorEvent.values[1] - this.pWy[1], sensorEvent.values[2] - this.pWy[2]);
            } else {
                this.pVJ.a(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            }
            this.q = false;
            Object obj2 = this.l;
            synchronized (this.l) {
                if (this.pWv != null) {
                    this.pWv.a(this.pVJ, sensorEvent.timestamp);
                    this.pWv.a(this.pWz);
                    g.b(this.pVJ, this.pWz, this.pVJ);
                }
            }
            this.pWu.a(this.pVJ, sensorEvent.timestamp);
        }
    }
}
