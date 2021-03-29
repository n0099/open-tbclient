package d.g.d.a.a;

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
    public static final String f66163g = "c";

    /* renamed from: a  reason: collision with root package name */
    public boolean f66164a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f66165b;

    /* renamed from: c  reason: collision with root package name */
    public Looper f66166c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f66167d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<SensorEventListener> f66168e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public int f66169f;

    /* loaded from: classes6.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            synchronized (c.this.f66168e) {
                Iterator it = c.this.f66168e.iterator();
                while (it.hasNext()) {
                    ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (c.this.f66168e) {
                Iterator it = c.this.f66168e.iterator();
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
            c.this.f66165b.registerListener(c.this.f66167d, c.this.f66165b.getDefaultSensor(1), c.this.f66169f, handler);
            Sensor h2 = c.this.h();
            if (h2 == null) {
                Log.i(c.f66163g, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                h2 = c.this.f66165b.getDefaultSensor(4);
            }
            c.this.f66165b.registerListener(c.this.f66167d, h2, c.this.f66169f, handler);
        }
    }

    public c(SensorManager sensorManager, int i) {
        this.f66165b = sensorManager;
        this.f66169f = i;
    }

    @Override // d.g.d.a.a.e
    public void a() {
        if (this.f66164a) {
            return;
        }
        this.f66167d = new a();
        b bVar = new b("sensor");
        bVar.start();
        this.f66166c = bVar.getLooper();
        this.f66164a = true;
    }

    @Override // d.g.d.a.a.e
    public void a(SensorEventListener sensorEventListener) {
        synchronized (this.f66168e) {
            this.f66168e.remove(sensorEventListener);
        }
    }

    @Override // d.g.d.a.a.e
    public void b() {
        if (this.f66164a) {
            this.f66165b.unregisterListener(this.f66167d);
            this.f66167d = null;
            this.f66166c.quit();
            this.f66166c = null;
            this.f66164a = false;
        }
    }

    @Override // d.g.d.a.a.e
    public void b(SensorEventListener sensorEventListener) {
        synchronized (this.f66168e) {
            this.f66168e.add(sensorEventListener);
        }
    }

    public final Sensor h() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.f66165b.getDefaultSensor(16);
    }
}
