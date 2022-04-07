package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {
    public float a;
    public volatile boolean b = true;
    @Nullable
    public com.kwad.sdk.core.g.a c;
    @Nullable
    public a d;

    /* loaded from: classes5.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (!b.this.b || sqrt < b.this.a || b.this.c == null) {
                return;
            }
            b.this.b = false;
            b.this.c.a(sqrt);
        }
    }

    public b(float f) {
        this.a = f <= 0.0f ? 5.0f : f;
    }

    public synchronized void a() {
        this.b = true;
    }

    public void a(float f) {
        this.a = f;
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
        if (this.d == null) {
            this.d = new a();
        }
        sensorManager.registerListener(this.d, defaultSensor, 2);
    }

    public void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.c = aVar;
    }

    public void b(Context context) {
        if (context == null || this.d == null) {
            return;
        }
        ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.d);
    }
}
