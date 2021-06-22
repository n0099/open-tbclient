package d.a.o0.k2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.o0.k2.k;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f60685a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f60686b;

    /* renamed from: c  reason: collision with root package name */
    public g f60687c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f60688d;

    /* renamed from: g  reason: collision with root package name */
    public k f60691g;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60689e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60690f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60692h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60693i = false;
    public Handler j = new a();
    public k.a k = new b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity;
            if (message == null || j.this.f60685a == null || (activity = (Activity) j.this.f60685a.get()) == null || !j.this.f60693i || message.what != 1) {
                return;
            }
            int requestedOrientation = activity.getRequestedOrientation();
            int i2 = message.arg1;
            if (!j.this.f60692h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    activity.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!j.this.f60690f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            activity.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        activity.setRequestedOrientation(8);
                    }
                }
                j.this.f60689e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!j.this.f60689e && requestedOrientation != 1) {
                    activity.setRequestedOrientation(1);
                }
                j.this.f60690f = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k.a {
        public b() {
        }

        @Override // d.a.o0.k2.k.a
        public void a(boolean z) {
            j.this.f60692h = z;
        }
    }

    public j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f60685a = new WeakReference<>(activity);
        SensorManager sensorManager = (SensorManager) activity.getApplicationContext().getSystemService("sensor");
        this.f60686b = sensorManager;
        this.f60688d = sensorManager.getDefaultSensor(1);
        this.f60687c = new g(this.j);
        if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
            activity.setRequestedOrientation(1);
        }
    }

    public void i(boolean z) {
        this.f60693i = z;
    }

    public void j() {
        Activity activity;
        SensorManager sensorManager = this.f60686b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f60687c, this.f60688d, 2);
        }
        WeakReference<Activity> weakReference = this.f60685a;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        k kVar = new k(activity.getApplicationContext(), new Handler(Looper.getMainLooper()));
        this.f60691g = kVar;
        kVar.b(this.k);
        activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f60691g);
    }

    public void k() {
        Activity activity;
        SensorManager sensorManager = this.f60686b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f60687c);
        }
        this.j.removeCallbacksAndMessages(null);
        WeakReference<Activity> weakReference = this.f60685a;
        if (weakReference == null || this.f60691g == null || (activity = weakReference.get()) == null) {
            return;
        }
        activity.getContentResolver().unregisterContentObserver(this.f60691g);
    }

    public void l() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f60685a;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            activity.setRequestedOrientation(0);
            this.f60689e = true;
            return;
        }
        activity.setRequestedOrientation(1);
        this.f60690f = true;
    }
}
