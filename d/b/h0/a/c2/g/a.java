package d.b.h0.a.c2.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.h0.a.c0.c;
/* loaded from: classes3.dex */
public class a {
    public static volatile a i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f44517a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f44518b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f44519c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f44520d;

    /* renamed from: e  reason: collision with root package name */
    public b f44521e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f44522f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f44523g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44524h = false;

    /* renamed from: d.b.h0.a.c2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0672a implements SensorEventListener {
        public C0672a() {
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
                a.this.f44522f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f44523g = (float[]) fArr2.clone();
                }
                if (a.this.f44521e == null || a.this.f44522f == null || a.this.f44523g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f44521e.a(g2);
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
        if (SensorManager.getRotationMatrix(fArr, null, this.f44522f, this.f44523g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        c.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f44518b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0672a c0672a = new C0672a();
        this.f44518b = c0672a;
        return c0672a;
    }

    public final void j() {
        c.g("SwanAppOrientationManager", "release");
        if (this.f44524h) {
            m();
        }
        this.f44517a = null;
        this.f44519c = null;
        this.f44520d = null;
        this.f44518b = null;
        this.f44522f = null;
        this.f44523g = null;
        i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f44524h) {
            c.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f44521e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.b.h0.a.w0.a.c().getSystemService("sensor");
        this.f44517a = sensorManager;
        if (sensorManager != null) {
            this.f44521e = bVar;
            this.f44519c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f44517a.getDefaultSensor(2);
            this.f44520d = defaultSensor;
            if (this.f44519c != null && defaultSensor != null) {
                this.f44517a.registerListener(i(), this.f44519c, i2);
                this.f44517a.registerListener(i(), this.f44520d, i2);
                this.f44524h = true;
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
        if (!this.f44524h) {
            c.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f44524h = false;
        SensorEventListener sensorEventListener = this.f44518b;
        if (sensorEventListener != null && (sensorManager = this.f44517a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f44518b = null;
        }
        this.f44521e = null;
        this.f44517a = null;
        this.f44519c = null;
        this.f44520d = null;
    }
}
