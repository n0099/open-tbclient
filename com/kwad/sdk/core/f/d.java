package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class d {
    public float a;
    public volatile boolean b = true;
    @Nullable
    public b c;
    @Nullable
    public a d;

    /* loaded from: classes5.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        public /* synthetic */ a(d dVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (!d.this.b || sqrt < d.this.a || d.this.c == null) {
                return;
            }
            d.this.b = false;
            d.this.c.a(sqrt);
        }
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.a = 5.0f;
        } else {
            this.a = f;
        }
    }

    public final synchronized void a() {
        this.b = true;
    }

    public final void a(float f) {
        this.a = f;
    }

    public final void a(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.b.a("ShakeDetector", "startDetect context is null");
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        if (defaultSensor != null) {
            if (this.d == null) {
                this.d = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.d, defaultSensor, 2);
            return;
        }
        b bVar = this.c;
        if (bVar != null) {
            bVar.d();
        }
        com.kwad.sdk.core.d.b.a("ShakeDetector", "startDetect default linear acceleration is null");
    }

    public final void a(@Nullable b bVar) {
        this.c = bVar;
    }

    public final synchronized void b(Context context) {
        if (context != null) {
            if (this.d != null) {
                ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.d);
                this.d = null;
            }
        }
    }
}
