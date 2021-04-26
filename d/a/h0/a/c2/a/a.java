package d.a.h0.a.c2.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import d.a.h0.a.c0.c;
import d.a.h0.a.r1.e;
/* loaded from: classes3.dex */
public class a {
    public static volatile a j;

    /* renamed from: a  reason: collision with root package name */
    public Context f41766a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f41767b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f41768c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f41769d;

    /* renamed from: e  reason: collision with root package name */
    public b f41770e;

    /* renamed from: f  reason: collision with root package name */
    public double[] f41771f = new double[3];

    /* renamed from: g  reason: collision with root package name */
    public boolean f41772g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f41773h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f41774i;

    /* renamed from: d.a.h0.a.c2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0604a implements SensorEventListener {
        public C0604a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 1) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length == 3) {
                if (a.this.f41770e != null && System.currentTimeMillis() - a.this.f41773h > a.this.f41774i) {
                    a.this.f41771f[0] = (-sensorEvent.values[0]) / 9.8d;
                    a.this.f41771f[1] = (-sensorEvent.values[1]) / 9.8d;
                    a.this.f41771f[2] = (-sensorEvent.values[2]) / 9.8d;
                    a.this.f41770e.a(a.this.f41771f);
                    a.this.f41773h = System.currentTimeMillis();
                }
                if (e.x) {
                    Log.d("AccelerometerManager", "current Time : " + a.this.f41773h + "current Acc x : " + a.this.f41771f[0] + "current Acc y : " + a.this.f41771f[1] + "current Acc z : " + a.this.f41771f[2]);
                    return;
                }
                return;
            }
            c.l("accelerometer", "illegal accelerometer event");
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(double[] dArr);
    }

    public static a g() {
        if (j == null) {
            synchronized (a.class) {
                if (j == null) {
                    j = new a();
                }
            }
        }
        return j;
    }

    public static void j() {
        if (j == null) {
            return;
        }
        j.i();
    }

    public final SensorEventListener f() {
        c.g("accelerometer", "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.f41768c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0604a c0604a = new C0604a();
        this.f41768c = c0604a;
        return c0604a;
    }

    public void h(Context context, int i2) {
        this.f41766a = context;
        this.f41774i = i2;
    }

    public final void i() {
        c.g("accelerometer", "release");
        if (this.f41772g) {
            m();
        }
        this.f41767b = null;
        this.f41769d = null;
        this.f41768c = null;
        this.f41771f = null;
        this.f41766a = null;
        j = null;
    }

    public void k(b bVar) {
        this.f41770e = bVar;
    }

    public void l() {
        Context context = this.f41766a;
        if (context == null) {
            c.b("accelerometer", "start error, none context");
        } else if (this.f41772g) {
            c.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f41767b = sensorManager;
            if (sensorManager != null) {
                this.f41769d = sensorManager.getDefaultSensor(1);
                this.f41767b.registerListener(f(), this.f41769d, 1);
                this.f41772g = true;
                c.g("accelerometer", "start listen");
                return;
            }
            c.b("accelerometer", "none sensorManager");
        }
    }

    public void m() {
        SensorManager sensorManager;
        if (!this.f41772g) {
            c.l("accelerometer", "has already stop");
            return;
        }
        SensorEventListener sensorEventListener = this.f41768c;
        if (sensorEventListener != null && (sensorManager = this.f41767b) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f41768c = null;
        }
        this.f41767b = null;
        this.f41769d = null;
        this.f41772g = false;
    }
}
