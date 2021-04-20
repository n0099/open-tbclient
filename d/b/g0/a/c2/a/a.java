package d.b.g0.a.c2.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import d.b.g0.a.c0.c;
import d.b.g0.a.r1.e;
/* loaded from: classes3.dex */
public class a {
    public static volatile a j;

    /* renamed from: a  reason: collision with root package name */
    public Context f44146a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f44147b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f44148c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f44149d;

    /* renamed from: e  reason: collision with root package name */
    public b f44150e;

    /* renamed from: f  reason: collision with root package name */
    public double[] f44151f = new double[3];

    /* renamed from: g  reason: collision with root package name */
    public boolean f44152g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f44153h = 0;
    public int i;

    /* renamed from: d.b.g0.a.c2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0645a implements SensorEventListener {
        public C0645a() {
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
                if (a.this.f44150e != null && System.currentTimeMillis() - a.this.f44153h > a.this.i) {
                    a.this.f44151f[0] = (-sensorEvent.values[0]) / 9.8d;
                    a.this.f44151f[1] = (-sensorEvent.values[1]) / 9.8d;
                    a.this.f44151f[2] = (-sensorEvent.values[2]) / 9.8d;
                    a.this.f44150e.a(a.this.f44151f);
                    a.this.f44153h = System.currentTimeMillis();
                }
                if (e.x) {
                    Log.d("AccelerometerManager", "current Time : " + a.this.f44153h + "current Acc x : " + a.this.f44151f[0] + "current Acc y : " + a.this.f44151f[1] + "current Acc z : " + a.this.f44151f[2]);
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
        SensorEventListener sensorEventListener = this.f44148c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0645a c0645a = new C0645a();
        this.f44148c = c0645a;
        return c0645a;
    }

    public void h(Context context, int i) {
        this.f44146a = context;
        this.i = i;
    }

    public final void i() {
        c.g("accelerometer", "release");
        if (this.f44152g) {
            m();
        }
        this.f44147b = null;
        this.f44149d = null;
        this.f44148c = null;
        this.f44151f = null;
        this.f44146a = null;
        j = null;
    }

    public void k(b bVar) {
        this.f44150e = bVar;
    }

    public void l() {
        Context context = this.f44146a;
        if (context == null) {
            c.b("accelerometer", "start error, none context");
        } else if (this.f44152g) {
            c.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f44147b = sensorManager;
            if (sensorManager != null) {
                this.f44149d = sensorManager.getDefaultSensor(1);
                this.f44147b.registerListener(f(), this.f44149d, 1);
                this.f44152g = true;
                c.g("accelerometer", "start listen");
                return;
            }
            c.b("accelerometer", "none sensorManager");
        }
    }

    public void m() {
        SensorManager sensorManager;
        if (!this.f44152g) {
            c.l("accelerometer", "has already stop");
            return;
        }
        SensorEventListener sensorEventListener = this.f44148c;
        if (sensorEventListener != null && (sensorManager = this.f44147b) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f44148c = null;
        }
        this.f44147b = null;
        this.f44149d = null;
        this.f44152g = false;
    }
}
