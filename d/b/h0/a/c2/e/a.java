package d.b.h0.a.c2.e;

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
    public Context f44500a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f44501b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f44502c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f44503d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f44504e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f44505f;
    public c j;

    /* renamed from: g  reason: collision with root package name */
    public float[] f44506g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    public float[] f44507h = new float[3];
    public int i = -100;
    public boolean k = false;
    public long l = 0;

    /* renamed from: d.b.h0.a.c2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0669a implements SensorEventListener {
        public C0669a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                a.this.f44506g = sensorEvent.values;
                a.this.i = sensorEvent.accuracy;
                d.b.h0.a.c0.c.a("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.i);
                a.this.k();
                return;
            }
            d.b.h0.a.c0.c.l("compass", "illegal accelerometer event");
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
                a.this.f44507h = sensorEvent.values;
                a.this.i = sensorEvent.accuracy;
                d.b.h0.a.c0.c.a("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.i);
                a.this.k();
                return;
            }
            d.b.h0.a.c0.c.l("compass", "illegal magnetic filed event");
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
        SensorManager.getRotationMatrix(fArr2, null, this.f44506g, this.f44507h);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    public final SensorEventListener g() {
        d.b.h0.a.c0.c.g("compass", "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.f44502c;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0669a c0669a = new C0669a();
        this.f44502c = c0669a;
        return c0669a;
    }

    public final SensorEventListener j() {
        d.b.h0.a.c0.c.g("compass", "get MagneticFiled listener");
        SensorEventListener sensorEventListener = this.f44503d;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        b bVar = new b();
        this.f44503d = bVar;
        return bVar;
    }

    public final void k() {
        if (this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.b.h0.a.c0.c.a("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        this.f44500a = context;
    }

    public final void m() {
        d.b.h0.a.c0.c.g("compass", "release");
        if (this.k) {
            q();
        }
        this.f44501b = null;
        this.f44505f = null;
        this.f44504e = null;
        this.f44502c = null;
        this.f44503d = null;
        this.j = null;
        this.f44500a = null;
        m = null;
    }

    public void o(c cVar) {
        this.j = cVar;
    }

    public void p() {
        Context context = this.f44500a;
        if (context == null) {
            d.b.h0.a.c0.c.b("compass", "start error, none context");
        } else if (this.k) {
            d.b.h0.a.c0.c.l("compass", "has already start");
        } else {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f44501b = sensorManager;
            if (sensorManager != null) {
                this.f44504e = sensorManager.getDefaultSensor(1);
                this.f44505f = this.f44501b.getDefaultSensor(2);
                this.f44501b.registerListener(g(), this.f44504e, 1);
                this.f44501b.registerListener(j(), this.f44505f, 1);
                this.k = true;
                d.b.h0.a.c0.c.g("compass", "start listen");
                return;
            }
            d.b.h0.a.c0.c.b("compass", "none sensorManager");
        }
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        if (!this.k) {
            d.b.h0.a.c0.c.l("compass", "has already stop");
            return;
        }
        d.b.h0.a.c0.c.g("compass", "stop listen");
        SensorEventListener sensorEventListener = this.f44502c;
        if (sensorEventListener != null && (sensorManager2 = this.f44501b) != null) {
            sensorManager2.unregisterListener(sensorEventListener);
            this.f44502c = null;
        }
        SensorEventListener sensorEventListener2 = this.f44503d;
        if (sensorEventListener2 != null && (sensorManager = this.f44501b) != null) {
            sensorManager.unregisterListener(sensorEventListener2);
            this.f44503d = null;
        }
        this.f44501b = null;
        this.f44505f = null;
        this.f44504e = null;
        this.k = false;
    }
}
