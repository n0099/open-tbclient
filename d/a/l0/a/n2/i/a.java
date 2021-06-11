package d.a.l0.a.n2.i;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.e0.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f47517i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f47518a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f47519b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f47520c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f47521d;

    /* renamed from: e  reason: collision with root package name */
    public b f47522e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f47523f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f47524g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47525h = false;

    /* renamed from: d.a.l0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0833a implements SensorEventListener {
        public C0833a() {
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
                a.this.f47523f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f47524g = (float[]) fArr2.clone();
                }
                if (a.this.f47522e == null || a.this.f47523f == null || a.this.f47524g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f47522e.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float[] fArr);
    }

    public static a h() {
        if (f47517i == null) {
            synchronized (a.class) {
                if (f47517i == null) {
                    f47517i = new a();
                }
            }
        }
        return f47517i;
    }

    public static void k() {
        if (f47517i == null) {
            return;
        }
        f47517i.j();
    }

    @Nullable
    public final float[] g() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.f47523f, this.f47524g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        d.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f47519b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0833a c0833a = new C0833a();
        this.f47519b = c0833a;
        return c0833a;
    }

    public final void j() {
        d.g("SwanAppOrientationManager", "release");
        if (this.f47525h) {
            m();
        }
        this.f47518a = null;
        this.f47520c = null;
        this.f47521d = null;
        this.f47519b = null;
        this.f47523f = null;
        this.f47524g = null;
        f47517i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f47525h) {
            d.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f47522e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.a.l0.a.c1.a.b().getSystemService("sensor");
        this.f47518a = sensorManager;
        if (sensorManager != null) {
            this.f47522e = bVar;
            this.f47520c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f47518a.getDefaultSensor(2);
            this.f47521d = defaultSensor;
            if (this.f47520c != null && defaultSensor != null) {
                this.f47518a.registerListener(i(), this.f47520c, i2);
                this.f47518a.registerListener(i(), this.f47521d, i2);
                this.f47525h = true;
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
        if (!this.f47525h) {
            d.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f47525h = false;
        SensorEventListener sensorEventListener = this.f47519b;
        if (sensorEventListener != null && (sensorManager = this.f47518a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f47519b = null;
        }
        this.f47522e = null;
        this.f47518a = null;
        this.f47520c = null;
        this.f47521d = null;
    }
}
