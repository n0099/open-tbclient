package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.ba;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class c {
    @Nullable
    public com.kwad.sdk.core.g.a aze;
    @Nullable
    public a azf;
    public AdMatrixInfo.RotateInfo rotateInfo;
    public volatile boolean ayZ = true;
    public long aza = 0;
    public double azb = 9.999999717180685E-10d;
    public double[] azc = {0.0d, 0.0d, 0.0d};
    public double[] azd = {0.0d, 0.0d, 0.0d};
    public final ba.b azg = new ba.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.ba.b
        public final void onFailed() {
            if (c.this.aze != null) {
                c.this.aze.lk();
            }
        }
    };

    /* loaded from: classes10.dex */
    public class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a() {
        }

        public /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (c.this.aza != 0) {
                double d = (sensorEvent.timestamp - c.this.aza) * c.this.azb;
                double[] dArr = c.this.azd;
                dArr[0] = dArr[0] + Math.toDegrees(f * d);
                double[] dArr2 = c.this.azd;
                dArr2[1] = dArr2[1] + Math.toDegrees(f2 * d);
                double[] dArr3 = c.this.azd;
                dArr3[2] = dArr3[2] + Math.toDegrees(f3 * d);
                c.this.Ei();
                c.this.Ej();
            }
            c.this.aza = sensorEvent.timestamp;
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private void Eh() {
        Arrays.fill(this.azc, 0.0d);
        Arrays.fill(this.azd, 0.0d);
        this.aza = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ei() {
        if (!this.ayZ) {
            return;
        }
        if (Math.abs(this.azd[0]) > Math.abs(this.azc[0])) {
            this.azc[0] = this.azd[0];
        }
        if (Math.abs(this.azd[1]) > Math.abs(this.azc[1])) {
            this.azc[1] = this.azd[1];
        }
        if (Math.abs(this.azd[2]) > Math.abs(this.azc[2])) {
            this.azc[2] = this.azd[2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (this.ayZ && (rotateInfo = this.rotateInfo) != null && this.aze != null) {
            AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = rotateInfo.x;
            if (!a(0, rotateDegreeInfo.rotateDegree, rotateDegreeInfo.direction)) {
                AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = this.rotateInfo.y;
                if (!a(1, rotateDegreeInfo2.rotateDegree, rotateDegreeInfo2.direction)) {
                    AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = this.rotateInfo.z;
                    if (!a(2, rotateDegreeInfo3.rotateDegree, rotateDegreeInfo3.direction)) {
                        return;
                    }
                }
            }
            this.ayZ = false;
            this.aze.U(Ek());
        }
    }

    private String Ek() {
        return "{\"x\": " + this.azc[0] + ",\"y\":" + this.azc[1] + ",\"z\":" + this.azc[2] + "}";
    }

    public final void bi(Context context) {
        if (context == null) {
            return;
        }
        Eh();
        this.ayZ = true;
        if (this.azf == null) {
            this.azf = new a(this, (byte) 0);
        }
        ba.KZ().a(2, 2, this.azf, this.azg);
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.azf != null) {
                ba.KZ().a(this.azf);
                this.azf = null;
            }
        }
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.azd[i]) < d) {
            return false;
        }
        if ((this.azd[i] > 0.0d && i2 == 1) || (this.azd[i] < 0.0d && i2 == 2)) {
            return false;
        }
        return true;
    }

    public final void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.aze = aVar;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }
}
