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
/* loaded from: classes4.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7883a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f7884b;
    private SensorManager c;
    private final ArrayList<SensorEventListener> f = new ArrayList<>();
    private int g;
    private Looper pMl;
    private SensorEventListener pMm;

    public b(SensorManager sensorManager, int i) {
        this.c = sensorManager;
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Sensor ezI() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.c.getDefaultSensor(16);
    }

    @Override // com.google.b.a.a.d
    public void a() {
        if (this.f7884b) {
            return;
        }
        this.pMm = new SensorEventListener() { // from class: com.google.b.a.a.b.1
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
                b.this.c.registerListener(b.this.pMm, b.this.c.getDefaultSensor(1), b.this.g, handler);
                Sensor ezI = b.this.ezI();
                if (ezI == null) {
                    Log.i(b.f7883a, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                    ezI = b.this.c.getDefaultSensor(4);
                }
                b.this.c.registerListener(b.this.pMm, ezI, b.this.g, handler);
            }
        };
        handlerThread.start();
        this.pMl = handlerThread.getLooper();
        this.f7884b = true;
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
        if (this.f7884b) {
            this.c.unregisterListener(this.pMm);
            this.pMm = null;
            this.pMl.quit();
            this.pMl = null;
            this.f7884b = false;
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
