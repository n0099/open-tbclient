package d.b.i0.i2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.i0.i2.k;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Activity f56138a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f56139b;

    /* renamed from: c  reason: collision with root package name */
    public g f56140c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f56141d;

    /* renamed from: g  reason: collision with root package name */
    public k f56144g;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56142e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56143f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56145h = false;
    public boolean i = false;
    public Handler j = new a();
    public k.a k = new b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || j.this.f56138a == null || !j.this.i || message.what != 1) {
                return;
            }
            int requestedOrientation = j.this.f56138a.getRequestedOrientation();
            int i = message.arg1;
            if (!j.this.f56145h) {
                if (i > 225 && i < 315) {
                    if (requestedOrientation == 8) {
                        j.this.f56138a.setRequestedOrientation(0);
                    }
                } else if (i <= 45 || i >= 135 || requestedOrientation != 0) {
                } else {
                    j.this.f56138a.setRequestedOrientation(8);
                }
            } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                if (!j.this.f56143f) {
                    if (i <= 55 || i >= 125) {
                        if (requestedOrientation != 0) {
                            j.this.f56138a.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        j.this.f56138a.setRequestedOrientation(8);
                    }
                }
                j.this.f56142e = false;
            } else if ((i <= 325 || i >= 360) && (i < 0 || i >= 35)) {
            } else {
                if (!j.this.f56142e && requestedOrientation != 1) {
                    j.this.f56138a.setRequestedOrientation(1);
                }
                j.this.f56143f = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k.a {
        public b() {
        }

        @Override // d.b.i0.i2.k.a
        public void a(boolean z) {
            j.this.f56145h = z;
        }
    }

    public j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f56138a = activity;
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.f56139b = sensorManager;
        this.f56141d = sensorManager.getDefaultSensor(1);
        this.f56140c = new g(this.j);
        if (!this.f56138a.getClass().getName().contains(SwanAppActivity.TAG)) {
            this.f56138a.setRequestedOrientation(1);
        }
        k kVar = new k(this.f56138a, this.j);
        this.f56144g = kVar;
        kVar.b(this.k);
        this.f56138a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.f56144g);
    }

    public void i(boolean z) {
        this.i = z;
    }

    public void j() {
        SensorManager sensorManager = this.f56139b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f56140c, this.f56141d, 2);
        }
    }

    public void k() {
        SensorManager sensorManager = this.f56139b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f56140c);
        }
        this.j.removeCallbacksAndMessages(null);
        Activity activity = this.f56138a;
        if (activity != null) {
            activity.getContentResolver().unregisterContentObserver(this.f56144g);
        }
    }

    public void l() {
        Activity activity = this.f56138a;
        if (activity == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            this.f56138a.setRequestedOrientation(0);
            this.f56142e = true;
            return;
        }
        this.f56138a.setRequestedOrientation(1);
        this.f56143f = true;
    }
}
