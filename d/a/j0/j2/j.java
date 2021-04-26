package d.a.j0.j2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.j0.j2.k;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Activity f55984a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f55985b;

    /* renamed from: c  reason: collision with root package name */
    public g f55986c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f55987d;

    /* renamed from: g  reason: collision with root package name */
    public k f55990g;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55988e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55989f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55991h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55992i = false;
    public Handler j = new a();
    public k.a k = new b();

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || j.this.f55984a == null || !j.this.f55992i || message.what != 1) {
                return;
            }
            int requestedOrientation = j.this.f55984a.getRequestedOrientation();
            int i2 = message.arg1;
            if (!j.this.f55991h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        j.this.f55984a.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    j.this.f55984a.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!j.this.f55989f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            j.this.f55984a.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        j.this.f55984a.setRequestedOrientation(8);
                    }
                }
                j.this.f55988e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!j.this.f55988e && requestedOrientation != 1) {
                    j.this.f55984a.setRequestedOrientation(1);
                }
                j.this.f55989f = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements k.a {
        public b() {
        }

        @Override // d.a.j0.j2.k.a
        public void a(boolean z) {
            j.this.f55991h = z;
        }
    }

    public j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f55984a = activity;
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.f55985b = sensorManager;
        this.f55987d = sensorManager.getDefaultSensor(1);
        this.f55986c = new g(this.j);
        if (!this.f55984a.getClass().getName().contains(SwanAppActivity.TAG)) {
            this.f55984a.setRequestedOrientation(1);
        }
        k kVar = new k(this.f55984a, this.j);
        this.f55990g = kVar;
        kVar.b(this.k);
        this.f55984a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.f55990g);
    }

    public void i(boolean z) {
        this.f55992i = z;
    }

    public void j() {
        SensorManager sensorManager = this.f55985b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f55986c, this.f55987d, 2);
        }
    }

    public void k() {
        SensorManager sensorManager = this.f55985b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f55986c);
        }
        this.j.removeCallbacksAndMessages(null);
        Activity activity = this.f55984a;
        if (activity != null) {
            activity.getContentResolver().unregisterContentObserver(this.f55990g);
        }
    }

    public void l() {
        Activity activity = this.f55984a;
        if (activity == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            this.f55984a.setRequestedOrientation(0);
            this.f55988e = true;
            return;
        }
        this.f55984a.setRequestedOrientation(1);
        this.f55989f = true;
    }
}
