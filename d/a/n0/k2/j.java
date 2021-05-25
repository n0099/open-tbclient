package d.a.n0.k2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.n0.k2.k;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Activity f56871a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f56872b;

    /* renamed from: c  reason: collision with root package name */
    public g f56873c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f56874d;

    /* renamed from: g  reason: collision with root package name */
    public k f56877g;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56875e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56876f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56878h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56879i = false;
    public Handler j = new a();
    public k.a k = new b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || j.this.f56871a == null || !j.this.f56879i || message.what != 1) {
                return;
            }
            int requestedOrientation = j.this.f56871a.getRequestedOrientation();
            int i2 = message.arg1;
            if (!j.this.f56878h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        j.this.f56871a.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    j.this.f56871a.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!j.this.f56876f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            j.this.f56871a.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        j.this.f56871a.setRequestedOrientation(8);
                    }
                }
                j.this.f56875e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!j.this.f56875e && requestedOrientation != 1) {
                    j.this.f56871a.setRequestedOrientation(1);
                }
                j.this.f56876f = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k.a {
        public b() {
        }

        @Override // d.a.n0.k2.k.a
        public void a(boolean z) {
            j.this.f56878h = z;
        }
    }

    public j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f56871a = activity;
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.f56872b = sensorManager;
        this.f56874d = sensorManager.getDefaultSensor(1);
        this.f56873c = new g(this.j);
        if (!this.f56871a.getClass().getName().contains(SwanAppActivity.TAG)) {
            this.f56871a.setRequestedOrientation(1);
        }
        k kVar = new k(this.f56871a, this.j);
        this.f56877g = kVar;
        kVar.b(this.k);
        this.f56871a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.f56877g);
    }

    public void i(boolean z) {
        this.f56879i = z;
    }

    public void j() {
        SensorManager sensorManager = this.f56872b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f56873c, this.f56874d, 2);
        }
    }

    public void k() {
        SensorManager sensorManager = this.f56872b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f56873c);
        }
        this.j.removeCallbacksAndMessages(null);
        Activity activity = this.f56871a;
        if (activity != null) {
            activity.getContentResolver().unregisterContentObserver(this.f56877g);
        }
    }

    public void l() {
        Activity activity = this.f56871a;
        if (activity == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            this.f56871a.setRequestedOrientation(0);
            this.f56875e = true;
            return;
        }
        this.f56871a.setRequestedOrientation(1);
        this.f56876f = true;
    }
}
