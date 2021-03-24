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
    public Context f43753a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f43754b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f43755c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f43756d;

    /* renamed from: e  reason: collision with root package name */
    public b f43757e;

    /* renamed from: f  reason: collision with root package name */
    public double[] f43758f = new double[3];

    /* renamed from: g  reason: collision with root package name */
    public boolean f43759g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f43760h = 0;
    public int i;

    /* renamed from: d.b.g0.a.c2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0632a implements SensorEventListener {
        public C0632a() {
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
                if (a.this.f43757e != null && System.currentTimeMillis() - a.this.f43760h > a.this.i) {
                    double[] dArr = a.this.f43758f;
                    double d2 = -sensorEvent.values[0];
                    Double.isNaN(d2);
                    dArr[0] = d2 / 9.8d;
                    double[] dArr2 = a.this.f43758f;
                    double d3 = -sensorEvent.values[1];
                    Double.isNaN(d3);
                    dArr2[1] = d3 / 9.8d;
                    double[] dArr3 = a.this.f43758f;
                    double d4 = -sensorEvent.values[2];
                    Double.isNaN(d4);
                    dArr3[2] = d4 / 9.8d;
                    a.this.f43757e.a(a.this.f43758f);
                    a.this.f43760h = System.currentTimeMillis();
                }
                if (e.x) {
                    Log.d("AccelerometerManager", "current Time : " + a.this.f43760h + "current Acc x : " + a.this.f43758f[0] + "current Acc y : " + a.this.f43758f[1] + "current Acc z : " + a.this.f43758f[2]);
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
        SensorEventListener sensorEventListener = this.f43755c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0632a c0632a = new C0632a();
        this.f43755c = c0632a;
        return c0632a;
    }

    public void h(Context context, int i) {
        this.f43753a = context;
        this.i = i;
    }

    public final void i() {
        c.g("accelerometer", "release");
        if (this.f43759g) {
            m();
        }
        this.f43754b = null;
        this.f43756d = null;
        this.f43755c = null;
        this.f43758f = null;
        this.f43753a = null;
        j = null;
    }

    public void k(b bVar) {
        this.f43757e = bVar;
    }

    public void l() {
        Context context = this.f43753a;
        if (context == null) {
            c.b("accelerometer", "start error, none context");
        } else if (this.f43759g) {
            c.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f43754b = sensorManager;
            if (sensorManager != null) {
                this.f43756d = sensorManager.getDefaultSensor(1);
                this.f43754b.registerListener(f(), this.f43756d, 1);
                this.f43759g = true;
                c.g("accelerometer", "start listen");
                return;
            }
            c.b("accelerometer", "none sensorManager");
        }
    }

    public void m() {
        SensorManager sensorManager;
        if (!this.f43759g) {
            c.l("accelerometer", "has already stop");
            return;
        }
        SensorEventListener sensorEventListener = this.f43755c;
        if (sensorEventListener != null && (sensorManager = this.f43754b) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f43755c = null;
        }
        this.f43754b = null;
        this.f43756d = null;
        this.f43759g = false;
    }
}
