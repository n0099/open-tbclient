package d.a.i0.a.n2.i;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.e0.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f43667i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f43668a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f43669b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f43670c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f43671d;

    /* renamed from: e  reason: collision with root package name */
    public b f43672e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f43673f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f43674g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43675h = false;

    /* renamed from: d.a.i0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0766a implements SensorEventListener {
        public C0766a() {
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
                a.this.f43673f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f43674g = (float[]) fArr2.clone();
                }
                if (a.this.f43672e == null || a.this.f43673f == null || a.this.f43674g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f43672e.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float[] fArr);
    }

    public static a h() {
        if (f43667i == null) {
            synchronized (a.class) {
                if (f43667i == null) {
                    f43667i = new a();
                }
            }
        }
        return f43667i;
    }

    public static void k() {
        if (f43667i == null) {
            return;
        }
        f43667i.j();
    }

    @Nullable
    public final float[] g() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.f43673f, this.f43674g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        d.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f43669b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0766a c0766a = new C0766a();
        this.f43669b = c0766a;
        return c0766a;
    }

    public final void j() {
        d.g("SwanAppOrientationManager", "release");
        if (this.f43675h) {
            m();
        }
        this.f43668a = null;
        this.f43670c = null;
        this.f43671d = null;
        this.f43669b = null;
        this.f43673f = null;
        this.f43674g = null;
        f43667i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f43675h) {
            d.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f43672e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.a.i0.a.c1.a.b().getSystemService("sensor");
        this.f43668a = sensorManager;
        if (sensorManager != null) {
            this.f43672e = bVar;
            this.f43670c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f43668a.getDefaultSensor(2);
            this.f43671d = defaultSensor;
            if (this.f43670c != null && defaultSensor != null) {
                this.f43668a.registerListener(i(), this.f43670c, i2);
                this.f43668a.registerListener(i(), this.f43671d, i2);
                this.f43675h = true;
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
        if (!this.f43675h) {
            d.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f43675h = false;
        SensorEventListener sensorEventListener = this.f43669b;
        if (sensorEventListener != null && (sensorManager = this.f43668a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f43669b = null;
        }
        this.f43672e = null;
        this.f43668a = null;
        this.f43670c = null;
        this.f43671d = null;
    }
}
