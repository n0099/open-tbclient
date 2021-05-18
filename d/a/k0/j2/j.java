package d.a.k0.j2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.k0.j2.k;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Activity f56691a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f56692b;

    /* renamed from: c  reason: collision with root package name */
    public g f56693c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f56694d;

    /* renamed from: g  reason: collision with root package name */
    public k f56697g;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56695e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56696f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56698h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56699i = false;
    public Handler j = new a();
    public k.a k = new b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || j.this.f56691a == null || !j.this.f56699i || message.what != 1) {
                return;
            }
            int requestedOrientation = j.this.f56691a.getRequestedOrientation();
            int i2 = message.arg1;
            if (!j.this.f56698h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        j.this.f56691a.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    j.this.f56691a.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!j.this.f56696f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            j.this.f56691a.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        j.this.f56691a.setRequestedOrientation(8);
                    }
                }
                j.this.f56695e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!j.this.f56695e && requestedOrientation != 1) {
                    j.this.f56691a.setRequestedOrientation(1);
                }
                j.this.f56696f = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k.a {
        public b() {
        }

        @Override // d.a.k0.j2.k.a
        public void a(boolean z) {
            j.this.f56698h = z;
        }
    }

    public j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f56691a = activity;
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.f56692b = sensorManager;
        this.f56694d = sensorManager.getDefaultSensor(1);
        this.f56693c = new g(this.j);
        if (!this.f56691a.getClass().getName().contains(SwanAppActivity.TAG)) {
            this.f56691a.setRequestedOrientation(1);
        }
        k kVar = new k(this.f56691a, this.j);
        this.f56697g = kVar;
        kVar.b(this.k);
        this.f56691a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.f56697g);
    }

    public void i(boolean z) {
        this.f56699i = z;
    }

    public void j() {
        SensorManager sensorManager = this.f56692b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f56693c, this.f56694d, 2);
        }
    }

    public void k() {
        SensorManager sensorManager = this.f56692b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f56693c);
        }
        this.j.removeCallbacksAndMessages(null);
        Activity activity = this.f56691a;
        if (activity != null) {
            activity.getContentResolver().unregisterContentObserver(this.f56697g);
        }
    }

    public void l() {
        Activity activity = this.f56691a;
        if (activity == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            this.f56691a.setRequestedOrientation(0);
            this.f56695e = true;
            return;
        }
        this.f56691a.setRequestedOrientation(1);
        this.f56696f = true;
    }
}
