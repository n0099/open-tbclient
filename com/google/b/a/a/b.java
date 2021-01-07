package com.google.b.a.a;

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
/* loaded from: classes5.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8183a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f8184b;
    private SensorManager c;
    private Looper d;
    private final ArrayList<SensorEventListener> f = new ArrayList<>();
    private int g;
    private SensorEventListener pQM;

    public b(SensorManager sensorManager, int i) {
        this.c = sensorManager;
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Sensor eDA() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.c.getDefaultSensor(16);
    }

    @Override // com.google.b.a.a.d
    public void a() {
        if (this.f8184b) {
            return;
        }
        this.pQM = new SensorEventListener() { // from class: com.google.b.a.a.b.1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                synchronized (b.this.f) {
                    Iterator it = b.this.f.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                synchronized (b.this.f) {
                    Iterator it = b.this.f.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onSensorChanged(sensorEvent);
                    }
                }
            }
        };
        HandlerThread handlerThread = new HandlerThread("sensor") { // from class: com.google.b.a.a.b.2
            @Override // android.os.HandlerThread
            protected void onLooperPrepared() {
                Handler handler = new Handler(Looper.myLooper());
                b.this.c.registerListener(b.this.pQM, b.this.c.getDefaultSensor(1), b.this.g, handler);
                Sensor eDA = b.this.eDA();
                if (eDA == null) {
                    Log.i(b.f8183a, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                    eDA = b.this.c.getDefaultSensor(4);
                }
                b.this.c.registerListener(b.this.pQM, eDA, b.this.g, handler);
            }
        };
        handlerThread.start();
        this.d = handlerThread.getLooper();
        this.f8184b = true;
    }

    @Override // com.google.b.a.a.d
    public void a(SensorEventListener sensorEventListener) {
        ArrayList<SensorEventListener> arrayList = this.f;
        synchronized (this.f) {
            this.f.add(sensorEventListener);
        }
    }

    @Override // com.google.b.a.a.d
    public void b() {
        if (this.f8184b) {
            this.c.unregisterListener(this.pQM);
            this.pQM = null;
            this.d.quit();
            this.d = null;
            this.f8184b = false;
        }
    }

    @Override // com.google.b.a.a.d
    public void b(SensorEventListener sensorEventListener) {
        ArrayList<SensorEventListener> arrayList = this.f;
        synchronized (this.f) {
            this.f.remove(sensorEventListener);
        }
    }
}
