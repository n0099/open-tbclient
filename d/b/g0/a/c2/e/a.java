package d.b.g0.a.c2.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class a {
    public static volatile a m;

    /* renamed from: a  reason: collision with root package name */
    public Context f43778a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f43779b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f43780c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f43781d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f43782e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f43783f;
    public c j;

    /* renamed from: g  reason: collision with root package name */
    public float[] f43784g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    public float[] f43785h = new float[3];
    public int i = -100;
    public boolean k = false;
    public long l = 0;

    /* renamed from: d.b.g0.a.c2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0636a implements SensorEventListener {
        public C0636a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                a.this.f43784g = sensorEvent.values;
                a.this.i = sensorEvent.accuracy;
                d.b.g0.a.c0.c.a("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.i);
                a.this.k();
                return;
            }
            d.b.g0.a.c0.c.l("compass", "illegal accelerometer event");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SensorEventListener {
        public b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 2) {
                a.this.f43785h = sensorEvent.values;
                a.this.i = sensorEvent.accuracy;
                d.b.g0.a.c0.c.a("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.i);
                a.this.k();
                return;
            }
            d.b.g0.a.c0.c.l("compass", "illegal magnetic filed event");
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(float f2, int i);
    }

    public static String h(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? "unknow" : "high" : "medium" : Config.EXCEPTION_MEMORY_LOW : "unreliable" : "no-contact";
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
        SensorManager.getRotationMatrix(fArr2, null, this.f43784g, this.f43785h);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    public final SensorEventListener g() {
        d.b.g0.a.c0.c.g("compass", "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.f43780c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0636a c0636a = new C0636a();
        this.f43780c = c0636a;
        return c0636a;
    }

    public final SensorEventListener j() {
        d.b.g0.a.c0.c.g("compass", "get MagneticFiled listener");
        SensorEventListener sensorEventListener = this.f43781d;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        b bVar = new b();
        this.f43781d = bVar;
        return bVar;
    }

    public final void k() {
        if (this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.b.g0.a.c0.c.a("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        this.f43778a = context;
    }

    public final void m() {
        d.b.g0.a.c0.c.g("compass", "release");
        if (this.k) {
            q();
        }
        this.f43779b = null;
        this.f43783f = null;
        this.f43782e = null;
        this.f43780c = null;
        this.f43781d = null;
        this.j = null;
        this.f43778a = null;
        m = null;
    }

    public void o(c cVar) {
        this.j = cVar;
    }

    public void p() {
        Context context = this.f43778a;
        if (context == null) {
            d.b.g0.a.c0.c.b("compass", "start error, none context");
        } else if (this.k) {
            d.b.g0.a.c0.c.l("compass", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f43779b = sensorManager;
            if (sensorManager != null) {
                this.f43782e = sensorManager.getDefaultSensor(1);
                this.f43783f = this.f43779b.getDefaultSensor(2);
                this.f43779b.registerListener(g(), this.f43782e, 1);
                this.f43779b.registerListener(j(), this.f43783f, 1);
                this.k = true;
                d.b.g0.a.c0.c.g("compass", "start listen");
                return;
            }
            d.b.g0.a.c0.c.b("compass", "none sensorManager");
        }
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        if (!this.k) {
            d.b.g0.a.c0.c.l("compass", "has already stop");
            return;
        }
        d.b.g0.a.c0.c.g("compass", "stop listen");
        SensorEventListener sensorEventListener = this.f43780c;
        if (sensorEventListener != null && (sensorManager2 = this.f43779b) != null) {
            sensorManager2.unregisterListener(sensorEventListener);
            this.f43780c = null;
        }
        SensorEventListener sensorEventListener2 = this.f43781d;
        if (sensorEventListener2 != null && (sensorManager = this.f43779b) != null) {
            sensorManager.unregisterListener(sensorEventListener2);
            this.f43781d = null;
        }
        this.f43779b = null;
        this.f43783f = null;
        this.f43782e = null;
        this.k = false;
    }
}
