package d.a.l0.a.n2.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import d.a.l0.a.a2.e;
import d.a.l0.a.e0.d;
/* loaded from: classes3.dex */
public class a implements SensorEventListener {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f43770i;

    /* renamed from: a  reason: collision with root package name */
    public Context f43771a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f43772b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f43773c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0768a f43774d;

    /* renamed from: e  reason: collision with root package name */
    public double[] f43775e = new double[3];

    /* renamed from: f  reason: collision with root package name */
    public boolean f43776f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f43777g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f43778h;

    /* renamed from: d.a.l0.a.n2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0768a {
        void a(double[] dArr);
    }

    public static a a() {
        if (f43770i == null) {
            synchronized (a.class) {
                if (f43770i == null) {
                    f43770i = new a();
                }
            }
        }
        return f43770i;
    }

    public static synchronized void d() {
        synchronized (a.class) {
            if (f43770i == null) {
                return;
            }
            f43770i.c();
        }
    }

    public synchronized void b(Context context, int i2) {
        this.f43771a = context;
        this.f43778h = i2;
    }

    public final synchronized void c() {
        d.g("accelerometer", "release");
        if (this.f43776f) {
            g();
        }
        this.f43771a = null;
        f43770i = null;
    }

    public synchronized void e(InterfaceC0768a interfaceC0768a) {
        this.f43774d = interfaceC0768a;
    }

    public synchronized void f() {
        if (this.f43771a == null) {
            d.b("accelerometer", "start error, none context");
        } else if (this.f43776f) {
            d.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) this.f43771a.getSystemService("sensor");
            this.f43772b = sensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.f43773c = defaultSensor;
                this.f43772b.registerListener(this, defaultSensor, 1);
                this.f43776f = true;
                d.g("accelerometer", "start listen");
            } else {
                d.b("accelerometer", "none sensorManager");
            }
        }
    }

    public synchronized void g() {
        if (!this.f43776f) {
            d.l("accelerometer", "has already stop");
            return;
        }
        if (this.f43772b != null) {
            this.f43772b.unregisterListener(this);
        }
        this.f43772b = null;
        this.f43773c = null;
        this.f43776f = false;
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
            synchronized (this) {
                if (this.f43776f && this.f43774d != null && System.currentTimeMillis() - this.f43777g > this.f43778h) {
                    this.f43775e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f43775e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f43775e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f43774d.a(this.f43775e);
                    this.f43777g = System.currentTimeMillis();
                }
                if (e.y) {
                    Log.d("AccelerometerManager", "current Time : " + this.f43777g + "current Acc x : " + this.f43775e[0] + "current Acc y : " + this.f43775e[1] + "current Acc z : " + this.f43775e[2]);
                }
            }
            return;
        }
        d.l("accelerometer", "illegal accelerometer event");
    }
}
