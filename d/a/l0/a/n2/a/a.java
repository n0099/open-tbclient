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
    public static volatile a f47446i;

    /* renamed from: a  reason: collision with root package name */
    public Context f47447a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f47448b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f47449c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0824a f47450d;

    /* renamed from: e  reason: collision with root package name */
    public double[] f47451e = new double[3];

    /* renamed from: f  reason: collision with root package name */
    public boolean f47452f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f47453g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f47454h;

    /* renamed from: d.a.l0.a.n2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0824a {
        void a(double[] dArr);
    }

    public static a a() {
        if (f47446i == null) {
            synchronized (a.class) {
                if (f47446i == null) {
                    f47446i = new a();
                }
            }
        }
        return f47446i;
    }

    public static synchronized void d() {
        synchronized (a.class) {
            if (f47446i == null) {
                return;
            }
            f47446i.c();
        }
    }

    public synchronized void b(Context context, int i2) {
        this.f47447a = context;
        this.f47454h = i2;
    }

    public final synchronized void c() {
        d.g("accelerometer", "release");
        if (this.f47452f) {
            g();
        }
        this.f47447a = null;
        f47446i = null;
    }

    public synchronized void e(InterfaceC0824a interfaceC0824a) {
        this.f47450d = interfaceC0824a;
    }

    public synchronized void f() {
        if (this.f47447a == null) {
            d.b("accelerometer", "start error, none context");
        } else if (this.f47452f) {
            d.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) this.f47447a.getSystemService("sensor");
            this.f47448b = sensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.f47449c = defaultSensor;
                this.f47448b.registerListener(this, defaultSensor, 1);
                this.f47452f = true;
                d.g("accelerometer", "start listen");
            } else {
                d.b("accelerometer", "none sensorManager");
            }
        }
    }

    public synchronized void g() {
        if (!this.f47452f) {
            d.l("accelerometer", "has already stop");
            return;
        }
        if (this.f47448b != null) {
            this.f47448b.unregisterListener(this);
        }
        this.f47448b = null;
        this.f47449c = null;
        this.f47452f = false;
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
                if (this.f47452f && this.f47450d != null && System.currentTimeMillis() - this.f47453g > this.f47454h) {
                    this.f47451e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f47451e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f47451e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f47450d.a(this.f47451e);
                    this.f47453g = System.currentTimeMillis();
                }
                if (e.y) {
                    Log.d("AccelerometerManager", "current Time : " + this.f47453g + "current Acc x : " + this.f47451e[0] + "current Acc y : " + this.f47451e[1] + "current Acc z : " + this.f47451e[2]);
                }
            }
            return;
        }
        d.l("accelerometer", "illegal accelerometer event");
    }
}
