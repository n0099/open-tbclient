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
    public SensorManager f44188a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f44189b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f44190c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f44191d;

    /* renamed from: e  reason: collision with root package name */
    public b f44192e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f44193f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f44194g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44195h = false;

    /* renamed from: d.b.g0.a.c2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0652a implements SensorEventListener {
        public C0652a() {
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
                a.this.f44193f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f44194g = (float[]) fArr2.clone();
                }
                if (a.this.f44192e == null || a.this.f44193f == null || a.this.f44194g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f44192e.a(g2);
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
        if (SensorManager.getRotationMatrix(fArr, null, this.f44193f, this.f44194g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        c.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f44189b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0652a c0652a = new C0652a();
        this.f44189b = c0652a;
        return c0652a;
    }

    public final void j() {
        c.g("SwanAppOrientationManager", "release");
        if (this.f44195h) {
            m();
        }
        this.f44188a = null;
        this.f44190c = null;
        this.f44191d = null;
        this.f44189b = null;
        this.f44193f = null;
        this.f44194g = null;
        i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f44195h) {
            c.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f44192e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.b.g0.a.w0.a.c().getSystemService("sensor");
        this.f44188a = sensorManager;
        if (sensorManager != null) {
            this.f44192e = bVar;
            this.f44190c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f44188a.getDefaultSensor(2);
            this.f44191d = defaultSensor;
            if (this.f44190c != null && defaultSensor != null) {
                this.f44188a.registerListener(i(), this.f44190c, i2);
                this.f44188a.registerListener(i(), this.f44191d, i2);
                this.f44195h = true;
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
        if (!this.f44195h) {
            c.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f44195h = false;
        SensorEventListener sensorEventListener = this.f44189b;
        if (sensorEventListener != null && (sensorManager = this.f44188a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f44189b = null;
        }
        this.f44192e = null;
        this.f44188a = null;
        this.f44190c = null;
        this.f44191d = null;
    }
}
