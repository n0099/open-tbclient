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
    public static volatile a f43841i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f43842a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f43843b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f43844c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f43845d;

    /* renamed from: e  reason: collision with root package name */
    public b f43846e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f43847f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f43848g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43849h = false;

    /* renamed from: d.a.l0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0777a implements SensorEventListener {
        public C0777a() {
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
                a.this.f43847f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f43848g = (float[]) fArr2.clone();
                }
                if (a.this.f43846e == null || a.this.f43847f == null || a.this.f43848g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f43846e.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float[] fArr);
    }

    public static a h() {
        if (f43841i == null) {
            synchronized (a.class) {
                if (f43841i == null) {
                    f43841i = new a();
                }
            }
        }
        return f43841i;
    }

    public static void k() {
        if (f43841i == null) {
            return;
        }
        f43841i.j();
    }

    @Nullable
    public final float[] g() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.f43847f, this.f43848g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        d.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f43843b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0777a c0777a = new C0777a();
        this.f43843b = c0777a;
        return c0777a;
    }

    public final void j() {
        d.g("SwanAppOrientationManager", "release");
        if (this.f43849h) {
            m();
        }
        this.f43842a = null;
        this.f43844c = null;
        this.f43845d = null;
        this.f43843b = null;
        this.f43847f = null;
        this.f43848g = null;
        f43841i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f43849h) {
            d.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f43846e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.a.l0.a.c1.a.b().getSystemService("sensor");
        this.f43842a = sensorManager;
        if (sensorManager != null) {
            this.f43846e = bVar;
            this.f43844c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f43842a.getDefaultSensor(2);
            this.f43845d = defaultSensor;
            if (this.f43844c != null && defaultSensor != null) {
                this.f43842a.registerListener(i(), this.f43844c, i2);
                this.f43842a.registerListener(i(), this.f43845d, i2);
                this.f43849h = true;
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
        if (!this.f43849h) {
            d.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f43849h = false;
        SensorEventListener sensorEventListener = this.f43843b;
        if (sensorEventListener != null && (sensorManager = this.f43842a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f43843b = null;
        }
        this.f43846e = null;
        this.f43842a = null;
        this.f43844c = null;
        this.f43845d = null;
    }
}
