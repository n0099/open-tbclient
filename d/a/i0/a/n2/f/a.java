package d.a.i0.a.n2.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import d.a.i0.a.e0.d;
/* loaded from: classes3.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a m;

    /* renamed from: a  reason: collision with root package name */
    public Context f43622a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f43623b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f43624c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f43625d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f43626e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f43627f;
    public c j;

    /* renamed from: g  reason: collision with root package name */
    public float[] f43628g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    public float[] f43629h = new float[3];

    /* renamed from: i  reason: collision with root package name */
    public int f43630i = -100;
    public boolean k = false;
    public long l = 0;

    /* renamed from: d.a.i0.a.n2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0761a implements SensorEventListener {
        public C0761a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                a.this.f43628g = sensorEvent.values;
                a.this.f43630i = sensorEvent.accuracy;
                d.a("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.f43630i);
                a.this.k();
                return;
            }
            d.l("compass", "illegal accelerometer event");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SensorEventListener {
        public b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 2) {
                a.this.f43629h = sensorEvent.values;
                a.this.f43630i = sensorEvent.accuracy;
                d.a("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.f43630i);
                a.this.k();
                return;
            }
            d.l("compass", "illegal magnetic filed event");
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(float f2, int i2);
    }

    public static String h(int i2) {
        return i2 != -1 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknow" : "high" : "medium" : Config.EXCEPTION_MEMORY_LOW : "unreliable" : "no-contact";
    }

    public static a i() {
        if (m == null) {
            synchronized (a.class) {
                if (m == null) {
                    m = new a();
                }
            }
        }
        return m;
    }

    public static void n() {
        if (m == null) {
            return;
        }
        m.m();
    }

    public final float f() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.f43628g, this.f43629h);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    public final SensorEventListener g() {
        d.g("compass", "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.f43624c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0761a c0761a = new C0761a();
        this.f43624c = c0761a;
        return c0761a;
    }

    public final SensorEventListener j() {
        d.g("compass", "get MagneticFiled listener");
        SensorEventListener sensorEventListener = this.f43625d;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        b bVar = new b();
        this.f43625d = bVar;
        return bVar;
    }

    public final void k() {
        if (this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.a("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.f43630i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        this.f43622a = context;
    }

    public final void m() {
        d.g("compass", "release");
        if (this.k) {
            q();
        }
        this.f43623b = null;
        this.f43627f = null;
        this.f43626e = null;
        this.f43624c = null;
        this.f43625d = null;
        this.j = null;
        this.f43622a = null;
        m = null;
    }

    public void o(c cVar) {
        this.j = cVar;
    }

    public void p() {
        Context context = this.f43622a;
        if (context == null) {
            d.b("compass", "start error, none context");
        } else if (this.k) {
            d.l("compass", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f43623b = sensorManager;
            if (sensorManager != null) {
                this.f43626e = sensorManager.getDefaultSensor(1);
                this.f43627f = this.f43623b.getDefaultSensor(2);
                this.f43623b.registerListener(g(), this.f43626e, 1);
                this.f43623b.registerListener(j(), this.f43627f, 1);
                this.k = true;
                d.g("compass", "start listen");
                return;
            }
            d.b("compass", "none sensorManager");
        }
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        if (!this.k) {
            d.l("compass", "has already stop");
            return;
        }
        d.g("compass", "stop listen");
        SensorEventListener sensorEventListener = this.f43624c;
        if (sensorEventListener != null && (sensorManager2 = this.f43623b) != null) {
            sensorManager2.unregisterListener(sensorEventListener);
            this.f43624c = null;
        }
        SensorEventListener sensorEventListener2 = this.f43625d;
        if (sensorEventListener2 != null && (sensorManager = this.f43623b) != null) {
            sensorManager.unregisterListener(sensorEventListener2);
            this.f43625d = null;
        }
        this.f43623b = null;
        this.f43627f = null;
        this.f43626e = null;
        this.k = false;
    }
}
