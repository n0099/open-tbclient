package d.b.i0.j2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.i0.j2.k;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Activity f57585a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f57586b;

    /* renamed from: c  reason: collision with root package name */
    public g f57587c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f57588d;

    /* renamed from: g  reason: collision with root package name */
    public k f57591g;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57589e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57590f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57592h = false;
    public boolean i = false;
    public Handler j = new a();
    public k.a k = new b();

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || j.this.f57585a == null || !j.this.i || message.what != 1) {
                return;
            }
            int requestedOrientation = j.this.f57585a.getRequestedOrientation();
            int i = message.arg1;
            if (!j.this.f57592h) {
                if (i > 225 && i < 315) {
                    if (requestedOrientation == 8) {
                        j.this.f57585a.setRequestedOrientation(0);
                    }
                } else if (i <= 45 || i >= 135 || requestedOrientation != 0) {
                } else {
                    j.this.f57585a.setRequestedOrientation(8);
                }
            } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                if (!j.this.f57590f) {
                    if (i <= 55 || i >= 125) {
                        if (requestedOrientation != 0) {
                            j.this.f57585a.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        j.this.f57585a.setRequestedOrientation(8);
                    }
                }
                j.this.f57589e = false;
            } else if ((i <= 325 || i >= 360) && (i < 0 || i >= 35)) {
            } else {
                if (!j.this.f57589e && requestedOrientation != 1) {
                    j.this.f57585a.setRequestedOrientation(1);
                }
                j.this.f57590f = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements k.a {
        public b() {
        }

        @Override // d.b.i0.j2.k.a
        public void a(boolean z) {
            j.this.f57592h = z;
        }
    }

    public j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f57585a = activity;
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.f57586b = sensorManager;
        this.f57588d = sensorManager.getDefaultSensor(1);
        this.f57587c = new g(this.j);
        if (!this.f57585a.getClass().getName().contains(SwanAppActivity.TAG)) {
            this.f57585a.setRequestedOrientation(1);
        }
        k kVar = new k(this.f57585a, this.j);
        this.f57591g = kVar;
        kVar.b(this.k);
        this.f57585a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.f57591g);
    }

    public void i(boolean z) {
        this.i = z;
    }

    public void j() {
        SensorManager sensorManager = this.f57586b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f57587c, this.f57588d, 2);
        }
    }

    public void k() {
        SensorManager sensorManager = this.f57586b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f57587c);
        }
        this.j.removeCallbacksAndMessages(null);
        Activity activity = this.f57585a;
        if (activity != null) {
            activity.getContentResolver().unregisterContentObserver(this.f57591g);
        }
    }

    public void l() {
        Activity activity = this.f57585a;
        if (activity == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            this.f57585a.setRequestedOrientation(0);
            this.f57589e = true;
            return;
        }
        this.f57585a.setRequestedOrientation(1);
        this.f57590f = true;
    }
}
