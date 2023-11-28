package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.ba;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class bb implements SensorEventListener {
    public final b aOl;
    public final b aOm;
    public final b aOn;
    public boolean aOo;
    public boolean aOp;
    public final ba.b aOq;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static final bb aOs = new bb((byte) 0);
    }

    /* loaded from: classes10.dex */
    public static class b {
        public SensorEvent aOt;
        public long timestamp;

        public b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public final void b(SensorEvent sensorEvent) {
            this.aOt = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        public final void N(List<com.kwad.sdk.k.a.e> list) {
            if (this.aOt == null) {
                return;
            }
            com.kwad.sdk.k.a.e eVar = new com.kwad.sdk.k.a.e();
            eVar.sensorType = this.aOt.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f : this.aOt.values) {
                eVar.aLs.add(Float.valueOf(f));
            }
            list.add(eVar);
        }
    }

    public bb() {
        this.aOl = new b((byte) 0);
        this.aOm = new b((byte) 0);
        this.aOn = new b((byte) 0);
        this.aOo = false;
        this.aOq = new ba.b() { // from class: com.kwad.sdk.utils.bb.2
            @Override // com.kwad.sdk.utils.ba.b
            public final void onFailed() {
                bb.a(bb.this, true);
            }
        };
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bb.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bb.this.Lc();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (o.JJ()) {
                    bb.this.register();
                }
            }
        });
    }

    public static bb La() {
        return a.aOs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Lc() {
        if (!this.aOp) {
            return;
        }
        ba.KZ().a(this);
        this.aOp = false;
    }

    public final synchronized List<com.kwad.sdk.k.a.e> Lb() {
        if (!o.JJ()) {
            return null;
        }
        com.kwad.sdk.core.c.b.Ct();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            register();
        }
        ArrayList arrayList = new ArrayList();
        this.aOl.N(arrayList);
        this.aOm.N(arrayList);
        this.aOn.N(arrayList);
        return arrayList;
    }

    public /* synthetic */ bb(byte b2) {
        this();
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type != 1) {
            if (type != 4) {
                if (type == 9) {
                    this.aOn.b(sensorEvent);
                    return;
                }
                return;
            }
            this.aOm.b(sensorEvent);
            return;
        }
        this.aOl.b(sensorEvent);
    }

    public static /* synthetic */ boolean a(bb bbVar, boolean z) {
        bbVar.aOo = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.aOo && !this.aOp) {
            this.aOp = true;
            ba.KZ().a(3, 3, this, this.aOq);
            ba.KZ().a(2, 3, this, this.aOq);
            ba.KZ().a(4, 3, this, this.aOq);
        }
    }
}
