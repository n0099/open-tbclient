package d.b.g0.a.c2.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import d.b.g0.a.c0.c;
import d.b.g0.a.r1.e;
/* loaded from: classes2.dex */
public class a {
    public static volatile a j;

    /* renamed from: a  reason: collision with root package name */
    public Context f43754a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f43755b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f43756c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f43757d;

    /* renamed from: e  reason: collision with root package name */
    public b f43758e;

    /* renamed from: f  reason: collision with root package name */
    public double[] f43759f = new double[3];

    /* renamed from: g  reason: collision with root package name */
    public boolean f43760g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f43761h = 0;
    public int i;

    /* renamed from: d.b.g0.a.c2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0633a implements SensorEventListener {
        public C0633a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 1) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length == 3) {
                if (a.this.f43758e != null && System.currentTimeMillis() - a.this.f43761h > a.this.i) {
                    a.this.f43759f[0] = (-sensorEvent.values[0]) / 9.8d;
                    a.this.f43759f[1] = (-sensorEvent.values[1]) / 9.8d;
                    a.this.f43759f[2] = (-sensorEvent.values[2]) / 9.8d;
                    a.this.f43758e.a(a.this.f43759f);
                    a.this.f43761h = System.currentTimeMillis();
                }
                if (e.x) {
                    Log.d("AccelerometerManager", "current Time : " + a.this.f43761h + "current Acc x : " + a.this.f43759f[0] + "current Acc y : " + a.this.f43759f[1] + "current Acc z : " + a.this.f43759f[2]);
                    return;
                }
                return;
            }
            c.l("accelerometer", "illegal accelerometer event");
        }
    }

    /* loaded from: classes2.dex */
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
        SensorEventListener sensorEventListener = this.f43756c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0633a c0633a = new C0633a();
        this.f43756c = c0633a;
        return c0633a;
    }

    public void h(Context context, int i) {
        this.f43754a = context;
        this.i = i;
    }

    public final void i() {
        c.g("accelerometer", "release");
        if (this.f43760g) {
            m();
        }
        this.f43755b = null;
        this.f43757d = null;
        this.f43756c = null;
        this.f43759f = null;
        this.f43754a = null;
        j = null;
    }

    public void k(b bVar) {
        this.f43758e = bVar;
    }

    public void l() {
        Context context = this.f43754a;
        if (context == null) {
            c.b("accelerometer", "start error, none context");
        } else if (this.f43760g) {
            c.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f43755b = sensorManager;
            if (sensorManager != null) {
                this.f43757d = sensorManager.getDefaultSensor(1);
                this.f43755b.registerListener(f(), this.f43757d, 1);
                this.f43760g = true;
                c.g("accelerometer", "start listen");
                return;
            }
            c.b("accelerometer", "none sensorManager");
        }
    }

    public void m() {
        SensorManager sensorManager;
        if (!this.f43760g) {
            c.l("accelerometer", "has already stop");
            return;
        }
        SensorEventListener sensorEventListener = this.f43756c;
        if (sensorEventListener != null && (sensorManager = this.f43755b) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f43756c = null;
        }
        this.f43755b = null;
        this.f43757d = null;
        this.f43760g = false;
    }
}
