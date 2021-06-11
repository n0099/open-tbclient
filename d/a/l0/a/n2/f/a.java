package d.a.l0.a.n2.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import d.a.l0.a.e0.d;
/* loaded from: classes3.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a m;

    /* renamed from: a  reason: collision with root package name */
    public Context f47472a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f47473b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f47474c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f47475d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f47476e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f47477f;
    public c j;

    /* renamed from: g  reason: collision with root package name */
    public float[] f47478g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    public float[] f47479h = new float[3];

    /* renamed from: i  reason: collision with root package name */
    public int f47480i = -100;
    public boolean k = false;
    public long l = 0;

    /* renamed from: d.a.l0.a.n2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0828a implements SensorEventListener {
        public C0828a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                a.this.f47478g = sensorEvent.values;
                a.this.f47480i = sensorEvent.accuracy;
                d.a("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.f47480i);
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
                a.this.f47479h = sensorEvent.values;
                a.this.f47480i = sensorEvent.accuracy;
                d.a("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.f47480i);
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
        SensorManager.getRotationMatrix(fArr2, null, this.f47478g, this.f47479h);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    public final SensorEventListener g() {
        d.g("compass", "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.f47474c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0828a c0828a = new C0828a();
        this.f47474c = c0828a;
        return c0828a;
    }

    public final SensorEventListener j() {
        d.g("compass", "get MagneticFiled listener");
        SensorEventListener sensorEventListener = this.f47475d;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        b bVar = new b();
        this.f47475d = bVar;
        return bVar;
    }

    public final void k() {
        if (this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.a("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.f47480i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        this.f47472a = context;
    }

    public final void m() {
        d.g("compass", "release");
        if (this.k) {
            q();
        }
        this.f47473b = null;
        this.f47477f = null;
        this.f47476e = null;
        this.f47474c = null;
        this.f47475d = null;
        this.j = null;
        this.f47472a = null;
        m = null;
    }

    public void o(c cVar) {
        this.j = cVar;
    }

    public void p() {
        Context context = this.f47472a;
        if (context == null) {
            d.b("compass", "start error, none context");
        } else if (this.k) {
            d.l("compass", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f47473b = sensorManager;
            if (sensorManager != null) {
                this.f47476e = sensorManager.getDefaultSensor(1);
                this.f47477f = this.f47473b.getDefaultSensor(2);
                this.f47473b.registerListener(g(), this.f47476e, 1);
                this.f47473b.registerListener(j(), this.f47477f, 1);
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
        SensorEventListener sensorEventListener = this.f47474c;
        if (sensorEventListener != null && (sensorManager2 = this.f47473b) != null) {
            sensorManager2.unregisterListener(sensorEventListener);
            this.f47474c = null;
        }
        SensorEventListener sensorEventListener2 = this.f47475d;
        if (sensorEventListener2 != null && (sensorManager = this.f47473b) != null) {
            sensorManager.unregisterListener(sensorEventListener2);
            this.f47475d = null;
        }
        this.f47473b = null;
        this.f47477f = null;
        this.f47476e = null;
        this.k = false;
    }
}
