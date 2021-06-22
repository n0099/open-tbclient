package d.a.m0.a.n2.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import d.a.m0.a.a2.e;
import d.a.m0.a.e0.d;
/* loaded from: classes3.dex */
public class a implements SensorEventListener {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f47554i;

    /* renamed from: a  reason: collision with root package name */
    public Context f47555a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f47556b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f47557c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0827a f47558d;

    /* renamed from: e  reason: collision with root package name */
    public double[] f47559e = new double[3];

    /* renamed from: f  reason: collision with root package name */
    public boolean f47560f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f47561g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f47562h;

    /* renamed from: d.a.m0.a.n2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0827a {
        void a(double[] dArr);
    }

    public static a a() {
        if (f47554i == null) {
            synchronized (a.class) {
                if (f47554i == null) {
                    f47554i = new a();
                }
            }
        }
        return f47554i;
    }

    public static synchronized void d() {
        synchronized (a.class) {
            if (f47554i == null) {
                return;
            }
            f47554i.c();
        }
    }

    public synchronized void b(Context context, int i2) {
        this.f47555a = context;
        this.f47562h = i2;
    }

    public final synchronized void c() {
        d.g("accelerometer", "release");
        if (this.f47560f) {
            g();
        }
        this.f47555a = null;
        f47554i = null;
    }

    public synchronized void e(InterfaceC0827a interfaceC0827a) {
        this.f47558d = interfaceC0827a;
    }

    public synchronized void f() {
        if (this.f47555a == null) {
            d.b("accelerometer", "start error, none context");
        } else if (this.f47560f) {
            d.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) this.f47555a.getSystemService("sensor");
            this.f47556b = sensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.f47557c = defaultSensor;
                this.f47556b.registerListener(this, defaultSensor, 1);
                this.f47560f = true;
                d.g("accelerometer", "start listen");
            } else {
                d.b("accelerometer", "none sensorManager");
            }
        }
    }

    public synchronized void g() {
        if (!this.f47560f) {
            d.l("accelerometer", "has already stop");
            return;
        }
        if (this.f47556b != null) {
            this.f47556b.unregisterListener(this);
        }
        this.f47556b = null;
        this.f47557c = null;
        this.f47560f = false;
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
                if (this.f47560f && this.f47558d != null && System.currentTimeMillis() - this.f47561g > this.f47562h) {
                    this.f47559e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f47559e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f47559e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f47558d.a(this.f47559e);
                    this.f47561g = System.currentTimeMillis();
                }
                if (e.y) {
                    Log.d("AccelerometerManager", "current Time : " + this.f47561g + "current Acc x : " + this.f47559e[0] + "current Acc y : " + this.f47559e[1] + "current Acc z : " + this.f47559e[2]);
                }
            }
            return;
        }
        d.l("accelerometer", "illegal accelerometer event");
    }
}
