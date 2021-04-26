package d.a.h0.a.c2.e;

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
    public Context f41792a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f41793b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f41794c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f41795d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f41796e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f41797f;
    public c j;

    /* renamed from: g  reason: collision with root package name */
    public float[] f41798g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    public float[] f41799h = new float[3];

    /* renamed from: i  reason: collision with root package name */
    public int f41800i = -100;
    public boolean k = false;
    public long l = 0;

    /* renamed from: d.a.h0.a.c2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0608a implements SensorEventListener {
        public C0608a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                a.this.f41798g = sensorEvent.values;
                a.this.f41800i = sensorEvent.accuracy;
                d.a.h0.a.c0.c.a("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.f41800i);
                a.this.k();
                return;
            }
            d.a.h0.a.c0.c.l("compass", "illegal accelerometer event");
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
                a.this.f41799h = sensorEvent.values;
                a.this.f41800i = sensorEvent.accuracy;
                d.a.h0.a.c0.c.a("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.f41800i);
                a.this.k();
                return;
            }
            d.a.h0.a.c0.c.l("compass", "illegal magnetic filed event");
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
        SensorManager.getRotationMatrix(fArr2, null, this.f41798g, this.f41799h);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    public final SensorEventListener g() {
        d.a.h0.a.c0.c.g("compass", "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.f41794c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0608a c0608a = new C0608a();
        this.f41794c = c0608a;
        return c0608a;
    }

    public final SensorEventListener j() {
        d.a.h0.a.c0.c.g("compass", "get MagneticFiled listener");
        SensorEventListener sensorEventListener = this.f41795d;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        b bVar = new b();
        this.f41795d = bVar;
        return bVar;
    }

    public final void k() {
        if (this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.a.h0.a.c0.c.a("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.f41800i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        this.f41792a = context;
    }

    public final void m() {
        d.a.h0.a.c0.c.g("compass", "release");
        if (this.k) {
            q();
        }
        this.f41793b = null;
        this.f41797f = null;
        this.f41796e = null;
        this.f41794c = null;
        this.f41795d = null;
        this.j = null;
        this.f41792a = null;
        m = null;
    }

    public void o(c cVar) {
        this.j = cVar;
    }

    public void p() {
        Context context = this.f41792a;
        if (context == null) {
            d.a.h0.a.c0.c.b("compass", "start error, none context");
        } else if (this.k) {
            d.a.h0.a.c0.c.l("compass", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f41793b = sensorManager;
            if (sensorManager != null) {
                this.f41796e = sensorManager.getDefaultSensor(1);
                this.f41797f = this.f41793b.getDefaultSensor(2);
                this.f41793b.registerListener(g(), this.f41796e, 1);
                this.f41793b.registerListener(j(), this.f41797f, 1);
                this.k = true;
                d.a.h0.a.c0.c.g("compass", "start listen");
                return;
            }
            d.a.h0.a.c0.c.b("compass", "none sensorManager");
        }
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        if (!this.k) {
            d.a.h0.a.c0.c.l("compass", "has already stop");
            return;
        }
        d.a.h0.a.c0.c.g("compass", "stop listen");
        SensorEventListener sensorEventListener = this.f41794c;
        if (sensorEventListener != null && (sensorManager2 = this.f41793b) != null) {
            sensorManager2.unregisterListener(sensorEventListener);
            this.f41794c = null;
        }
        SensorEventListener sensorEventListener2 = this.f41795d;
        if (sensorEventListener2 != null && (sensorManager = this.f41793b) != null) {
            sensorManager.unregisterListener(sensorEventListener2);
            this.f41795d = null;
        }
        this.f41793b = null;
        this.f41797f = null;
        this.f41796e = null;
        this.k = false;
    }
}
