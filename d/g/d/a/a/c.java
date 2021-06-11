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
    public static final String f70144g = "c";

    /* renamed from: a  reason: collision with root package name */
    public boolean f70145a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f70146b;

    /* renamed from: c  reason: collision with root package name */
    public Looper f70147c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f70148d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<SensorEventListener> f70149e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public int f70150f;

    /* loaded from: classes6.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            synchronized (c.this.f70149e) {
                Iterator it = c.this.f70149e.iterator();
                while (it.hasNext()) {
                    ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i2);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (c.this.f70149e) {
                Iterator it = c.this.f70149e.iterator();
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
            c.this.f70146b.registerListener(c.this.f70148d, c.this.f70146b.getDefaultSensor(1), c.this.f70150f, handler);
            Sensor h2 = c.this.h();
            if (h2 == null) {
                Log.i(c.f70144g, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                h2 = c.this.f70146b.getDefaultSensor(4);
            }
            c.this.f70146b.registerListener(c.this.f70148d, h2, c.this.f70150f, handler);
        }
    }

    public c(SensorManager sensorManager, int i2) {
        this.f70146b = sensorManager;
        this.f70150f = i2;
    }

    @Override // d.g.d.a.a.e
    public void a() {
        if (this.f70145a) {
            return;
        }
        this.f70148d = new a();
        b bVar = new b("sensor");
        bVar.start();
        this.f70147c = bVar.getLooper();
        this.f70145a = true;
    }

    @Override // d.g.d.a.a.e
    public void a(SensorEventListener sensorEventListener) {
        synchronized (this.f70149e) {
            this.f70149e.remove(sensorEventListener);
        }
    }

    @Override // d.g.d.a.a.e
    public void b() {
        if (this.f70145a) {
            this.f70146b.unregisterListener(this.f70148d);
            this.f70148d = null;
            this.f70147c.quit();
            this.f70147c = null;
            this.f70145a = false;
        }
    }

    @Override // d.g.d.a.a.e
    public void b(SensorEventListener sensorEventListener) {
        synchronized (this.f70149e) {
            this.f70149e.add(sensorEventListener);
        }
    }

    public final Sensor h() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.f70146b.getDefaultSensor(16);
    }
}
