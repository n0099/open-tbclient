package d.a.i0.a.n2.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import d.a.i0.a.a2.e;
import d.a.i0.a.e0.d;
/* loaded from: classes3.dex */
public class a implements SensorEventListener {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f43596i;

    /* renamed from: a  reason: collision with root package name */
    public Context f43597a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f43598b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f43599c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0757a f43600d;

    /* renamed from: e  reason: collision with root package name */
    public double[] f43601e = new double[3];

    /* renamed from: f  reason: collision with root package name */
    public boolean f43602f = false;

    /* renamed from: g  reason: collision with root package name */
    public long f43603g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f43604h;

    /* renamed from: d.a.i0.a.n2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0757a {
        void a(double[] dArr);
    }

    public static a a() {
        if (f43596i == null) {
            synchronized (a.class) {
                if (f43596i == null) {
                    f43596i = new a();
                }
            }
        }
        return f43596i;
    }

    public static synchronized void d() {
        synchronized (a.class) {
            if (f43596i == null) {
                return;
            }
            f43596i.c();
        }
    }

    public synchronized void b(Context context, int i2) {
        this.f43597a = context;
        this.f43604h = i2;
    }

    public final synchronized void c() {
        d.g("accelerometer", "release");
        if (this.f43602f) {
            g();
        }
        this.f43597a = null;
        f43596i = null;
    }

    public synchronized void e(InterfaceC0757a interfaceC0757a) {
        this.f43600d = interfaceC0757a;
    }

    public synchronized void f() {
        if (this.f43597a == null) {
            d.b("accelerometer", "start error, none context");
        } else if (this.f43602f) {
            d.l("accelerometer", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) this.f43597a.getSystemService("sensor");
            this.f43598b = sensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.f43599c = defaultSensor;
                this.f43598b.registerListener(this, defaultSensor, 1);
                this.f43602f = true;
                d.g("accelerometer", "start listen");
            } else {
                d.b("accelerometer", "none sensorManager");
            }
        }
    }

    public synchronized void g() {
        if (!this.f43602f) {
            d.l("accelerometer", "has already stop");
            return;
        }
        if (this.f43598b != null) {
            this.f43598b.unregisterListener(this);
        }
        this.f43598b = null;
        this.f43599c = null;
        this.f43602f = false;
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
                if (this.f43602f && this.f43600d != null && System.currentTimeMillis() - this.f43603g > this.f43604h) {
                    this.f43601e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.f43601e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.f43601e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.f43600d.a(this.f43601e);
                    this.f43603g = System.currentTimeMillis();
                }
                if (e.y) {
                    Log.d("AccelerometerManager", "current Time : " + this.f43603g + "current Acc x : " + this.f43601e[0] + "current Acc y : " + this.f43601e[1] + "current Acc z : " + this.f43601e[2]);
                }
            }
            return;
        }
        d.l("accelerometer", "illegal accelerometer event");
    }
}
