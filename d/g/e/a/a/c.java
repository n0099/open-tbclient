package d.g.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c implements e {

    /* renamed from: g  reason: collision with root package name */
    public static final String f67156g = "c";

    /* renamed from: a  reason: collision with root package name */
    public boolean f67157a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f67158b;

    /* renamed from: c  reason: collision with root package name */
    public Looper f67159c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f67160d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<SensorEventListener> f67161e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public int f67162f;

    /* loaded from: classes6.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            synchronized (c.this.f67161e) {
                Iterator it = c.this.f67161e.iterator();
                while (it.hasNext()) {
                    ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (c.this.f67161e) {
                Iterator it = c.this.f67161e.iterator();
                while (it.hasNext()) {
                    ((SensorEventListener) it.next()).onSensorChanged(sensorEvent);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            Handler handler = new Handler(Looper.myLooper());
            c.this.f67158b.registerListener(c.this.f67160d, c.this.f67158b.getDefaultSensor(1), c.this.f67162f, handler);
            Sensor h2 = c.this.h();
            if (h2 == null) {
                Log.i(c.f67156g, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                h2 = c.this.f67158b.getDefaultSensor(4);
            }
            c.this.f67158b.registerListener(c.this.f67160d, h2, c.this.f67162f, handler);
        }
    }

    public c(SensorManager sensorManager, int i) {
        this.f67158b = sensorManager;
        this.f67162f = i;
    }

    @Override // d.g.e.a.a.e
    public void a() {
        if (this.f67157a) {
            return;
        }
        this.f67160d = new a();
        b bVar = new b("sensor");
        bVar.start();
        this.f67159c = bVar.getLooper();
        this.f67157a = true;
    }

    @Override // d.g.e.a.a.e
    public void a(SensorEventListener sensorEventListener) {
        synchronized (this.f67161e) {
            this.f67161e.remove(sensorEventListener);
        }
    }

    @Override // d.g.e.a.a.e
    public void b() {
        if (this.f67157a) {
            this.f67158b.unregisterListener(this.f67160d);
            this.f67160d = null;
            this.f67159c.quit();
            this.f67159c = null;
            this.f67157a = false;
        }
    }

    @Override // d.g.e.a.a.e
    public void b(SensorEventListener sensorEventListener) {
        synchronized (this.f67161e) {
            this.f67161e.add(sensorEventListener);
        }
    }

    public final Sensor h() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.f67158b.getDefaultSensor(16);
    }
}
