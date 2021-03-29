package d.b.g0.a.c2.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.c0.c;
/* loaded from: classes3.dex */
public class a {
    public static volatile a i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f43796a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f43797b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f43798c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f43799d;

    /* renamed from: e  reason: collision with root package name */
    public b f43800e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f43801f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f43802g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43803h = false;

    /* renamed from: d.b.g0.a.c2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0640a implements SensorEventListener {
        public C0640a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            float[] g2;
            Sensor sensor2;
            if (sensorEvent != null && (sensor2 = sensorEvent.sensor) != null && sensor2.getType() == 1) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length != 3) {
                    return;
                }
                a.this.f43801f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f43802g = (float[]) fArr2.clone();
                }
                if (a.this.f43800e == null || a.this.f43801f == null || a.this.f43802g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f43800e.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float[] fArr);
    }

    public static a h() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    public static void k() {
        if (i == null) {
            return;
        }
        i.j();
    }

    @Nullable
    public final float[] g() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.f43801f, this.f43802g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        c.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f43797b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0640a c0640a = new C0640a();
        this.f43797b = c0640a;
        return c0640a;
    }

    public final void j() {
        c.g("SwanAppOrientationManager", "release");
        if (this.f43803h) {
            m();
        }
        this.f43796a = null;
        this.f43798c = null;
        this.f43799d = null;
        this.f43797b = null;
        this.f43801f = null;
        this.f43802g = null;
        i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f43803h) {
            c.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f43800e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.b.g0.a.w0.a.c().getSystemService("sensor");
        this.f43796a = sensorManager;
        if (sensorManager != null) {
            this.f43800e = bVar;
            this.f43798c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f43796a.getDefaultSensor(2);
            this.f43799d = defaultSensor;
            if (this.f43798c != null && defaultSensor != null) {
                this.f43796a.registerListener(i(), this.f43798c, i2);
                this.f43796a.registerListener(i(), this.f43799d, i2);
                this.f43803h = true;
                c.g("SwanAppOrientationManager", "start listen");
                return true;
            }
            c.b("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
            return false;
        }
        c.b("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void m() {
        SensorManager sensorManager;
        if (!this.f43803h) {
            c.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f43803h = false;
        SensorEventListener sensorEventListener = this.f43797b;
        if (sensorEventListener != null && (sensorManager = this.f43796a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f43797b = null;
        }
        this.f43800e = null;
        this.f43796a = null;
        this.f43798c = null;
        this.f43799d = null;
    }
}
