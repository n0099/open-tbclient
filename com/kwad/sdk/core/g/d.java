package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public final class d {
    public volatile boolean adk = true;
    public float ads;
    @Nullable
    public b adt;
    @Nullable
    public a adu;

    /* loaded from: classes10.dex */
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
            if (!d.this.adk || sqrt < d.this.ads || d.this.adt == null) {
                return;
            }
            d.a(d.this, false);
            d.this.adt.a(sqrt);
        }
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.ads = 5.0f;
        } else {
            this.ads = f;
        }
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.adk = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.adt = bVar;
    }

    public final synchronized void bA(Context context) {
        if (context != null) {
            if (this.adu != null) {
                ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.adu);
                this.adu = null;
            }
        }
    }

    public final void bz(Context context) {
        if (context == null) {
            com.kwad.sdk.core.e.b.d("ShakeDetector", "startDetect context is null");
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        if (defaultSensor != null) {
            if (this.adu == null) {
                this.adu = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.adu, defaultSensor, 2);
            return;
        }
        b bVar = this.adt;
        if (bVar != null) {
            bVar.bX();
        }
        com.kwad.sdk.core.e.b.d("ShakeDetector", "startDetect default linear acceleration is null");
    }

    public final void d(float f) {
        this.ads = f;
    }

    public final synchronized void vb() {
        this.adk = true;
    }
}
