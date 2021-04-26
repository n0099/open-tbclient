package d.a.h0.a.c2.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.c0.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f41810i;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f41811a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f41812b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f41813c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f41814d;

    /* renamed from: e  reason: collision with root package name */
    public b f41815e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f41816f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f41817g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41818h = false;

    /* renamed from: d.a.h0.a.c2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0611a implements SensorEventListener {
        public C0611a() {
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
                a.this.f41816f = (float[]) fArr.clone();
            } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
            } else {
                float[] fArr2 = sensorEvent.values;
                if (fArr2 != null && fArr2.length == 3) {
                    a.this.f41817g = (float[]) fArr2.clone();
                }
                if (a.this.f41815e == null || a.this.f41816f == null || a.this.f41817g == null || (g2 = a.this.g()) == null) {
                    return;
                }
                a.this.f41815e.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float[] fArr);
    }

    public static a h() {
        if (f41810i == null) {
            synchronized (a.class) {
                if (f41810i == null) {
                    f41810i = new a();
                }
            }
        }
        return f41810i;
    }

    public static void k() {
        if (f41810i == null) {
            return;
        }
        f41810i.j();
    }

    @Nullable
    public final float[] g() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.f41816f, this.f41817g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }

    public final SensorEventListener i() {
        c.g("SwanAppOrientationManager", "get System Sensor listener");
        SensorEventListener sensorEventListener = this.f41812b;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        C0611a c0611a = new C0611a();
        this.f41812b = c0611a;
        return c0611a;
    }

    public final void j() {
        c.g("SwanAppOrientationManager", "release");
        if (this.f41818h) {
            m();
        }
        this.f41811a = null;
        this.f41813c = null;
        this.f41814d = null;
        this.f41812b = null;
        this.f41816f = null;
        this.f41817g = null;
        f41810i = null;
    }

    public boolean l(int i2, @NonNull b bVar) {
        if (this.f41818h) {
            c.l("SwanAppOrientationManager", "has already start, change new listener");
            this.f41815e = bVar;
            return true;
        }
        SensorManager sensorManager = (SensorManager) d.a.h0.a.w0.a.c().getSystemService("sensor");
        this.f41811a = sensorManager;
        if (sensorManager != null) {
            this.f41815e = bVar;
            this.f41813c = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.f41811a.getDefaultSensor(2);
            this.f41814d = defaultSensor;
            if (this.f41813c != null && defaultSensor != null) {
                this.f41811a.registerListener(i(), this.f41813c, i2);
                this.f41811a.registerListener(i(), this.f41814d, i2);
                this.f41818h = true;
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
        if (!this.f41818h) {
            c.l("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.f41818h = false;
        SensorEventListener sensorEventListener = this.f41812b;
        if (sensorEventListener != null && (sensorManager = this.f41811a) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f41812b = null;
        }
        this.f41815e = null;
        this.f41811a = null;
        this.f41813c = null;
        this.f41814d = null;
    }
}
