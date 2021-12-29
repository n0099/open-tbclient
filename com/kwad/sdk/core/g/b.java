package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class b {
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f58037b = true;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.g.a f58038c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f58039d;

    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            double sqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
            if (!b.this.f58037b || sqrt < b.this.a || b.this.f58038c == null) {
                return;
            }
            b.this.f58037b = false;
            b.this.f58038c.a(sqrt);
        }
    }

    public b(float f2) {
        this.a = f2 <= 0.0f ? 5.0f : f2;
    }

    public synchronized void a() {
        this.f58037b = true;
    }

    public void a(float f2) {
        this.a = f2;
    }

    public void a(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.a.a("ShakeDetector", "startDetect context is null");
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        if (defaultSensor == null) {
            com.kwad.sdk.core.d.a.a("ShakeDetector", "startDetect default linear acceleration is null");
            return;
        }
        if (this.f58039d == null) {
            this.f58039d = new a();
        }
        sensorManager.registerListener(this.f58039d, defaultSensor, 2);
    }

    public void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.f58038c = aVar;
    }

    public void b(Context context) {
        if (context == null || this.f58039d == null) {
            return;
        }
        ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.f58039d);
    }
}
