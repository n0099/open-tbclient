package d.a.m0.a.n2.i;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.e0.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f47625i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f47626a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f47627b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f47628c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f47629d;

    /* renamed from: e  reason: collision with root package name */
    public b f47630e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f47631f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f47632g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47633h = false;

    /* renamed from: d.a.m0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0836a implements SensorEventListener {
        public C0836a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
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
                a.this.f47631f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f47632g = (float[]) fArr2.clone();
                }
                if (a.this.f47630e == null || a.this.f47631f == null || a.this.f47632g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f47630e.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float[] fArr);
    }

    public static a h() {
        if (f47625i == null) {
            synchronized (a.class) {
                if (f47625i == null) {
                    f47625i = new a();
                }
            }
        }
        return f47625i;
    }

    public static void k() {
        if (f47625i == null) {
            return;
        }
        f47625i.j();
    }

    @Nullable
    public final float[] g() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.f47631f, this.f47632g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        d.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f47627b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0836a c0836a = new C0836a();
        this.f47627b = c0836a;
        return c0836a;
    }

    public final void j() {
        d.g("SwanAppOrientationManager", "release");
        if (this.f47633h) {
            m();
        }
        this.f47626a = null;
        this.f47628c = null;
        this.f47629d = null;
        this.f47627b = null;
        this.f47631f = null;
        this.f47632g = null;
        f47625i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f47633h) {
            d.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f47630e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.a.m0.a.c1.a.b().getSystemService("sensor");
        this.f47626a = sensorManager;
        if (sensorManager != null) {
            this.f47630e = bVar;
            this.f47628c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f47626a.getDefaultSensor(2);
            this.f47629d = defaultSensor;
            if (this.f47628c != null && defaultSensor != null) {
                this.f47626a.registerListener(i(), this.f47628c, i2);
                this.f47626a.registerListener(i(), this.f47629d, i2);
                this.f47633h = true;
                d.g("SwanAppOrientationManager", "start listen");
                return true;
            }
            d.b("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
            return false;
        }
        d.b("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void m() {
        SensorManager sensorManager;
        if (!this.f47633h) {
            d.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f47633h = false;
        SensorEventListener sensorEventListener = this.f47627b;
        if (sensorEventListener != null && (sensorManager = this.f47626a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f47627b = null;
        }
        this.f47630e = null;
        this.f47626a = null;
        this.f47628c = null;
        this.f47629d = null;
    }
}
