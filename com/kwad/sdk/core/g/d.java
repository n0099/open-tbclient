package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.ba;
import java.util.Random;
/* loaded from: classes10.dex */
public final class d {
    public static float azj = 9.81f;
    public static double azk = 0.01d;
    public volatile boolean ayZ = true;
    public final ba.b azg = new ba.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.ba.b
        public final void onFailed() {
            if (d.this.azl != null) {
                d.this.azl.aV();
            }
        }
    };
    public float azi;
    @Nullable
    public b azl;
    @Nullable
    public a azm;

    /* loaded from: classes10.dex */
    public class a implements SensorEventListener {
        public Random auv;
        public boolean azp;
        public final float[] azo = {0.0f, 0.0f, 9.8f};
        public final float[] azq = {0.0f, 0.0f, 0.0f};

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a() {
            this.azp = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.azp = false;
            }
        }

        public static boolean b(float[] fArr) {
            if (Math.abs(Math.abs(Math.sqrt(((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) - d.azj) > d.azk) {
                return false;
            }
            return true;
        }

        private void Eo() {
            if (this.auv == null) {
                this.auv = new Random();
            }
            if (this.auv.nextInt(100) == 1) {
                a(this.azo);
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double abs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (b(fArr)) {
                abs = Math.abs(abs - d.azj);
            }
            if (d.this.ayZ && abs >= d.this.azi && d.this.azl != null) {
                d.a(d.this, false);
                d.this.azl.a(abs);
            }
        }

        private void c(float[] fArr) {
            float f;
            float[] fArr2 = this.azq;
            if (fArr2[0] == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) {
                f = 1.0f;
            } else {
                f = 0.6f;
            }
            float f2 = 1.0f - f;
            float[] fArr3 = this.azq;
            fArr[0] = (fArr[0] * f) + (fArr3[0] * f2);
            fArr[1] = (fArr[1] * f) + (fArr3[1] * f2);
            fArr[2] = (f * fArr[2]) + (f2 * fArr3[2]);
            System.arraycopy(fArr, 0, fArr3, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.azp) {
                Eo();
            }
        }
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.azi = 5.0f;
        } else {
            this.azi = f;
        }
    }

    public final void bi(Context context) {
        if (context == null) {
            com.kwad.sdk.core.e.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.ayZ = true;
        if (this.azm == null) {
            this.azm = new a();
        }
        ba.KZ().a(1, 2, this.azm, this.azg);
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.azm != null) {
                ba.KZ().a(this.azm);
                this.azm = null;
            }
        }
    }

    public final void e(float f) {
        this.azi = f;
    }

    public final synchronized void El() {
        this.ayZ = true;
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.ayZ = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.azl = bVar;
    }
}
