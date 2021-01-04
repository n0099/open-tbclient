package com.pgl.sys.ces.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public final class a implements SensorEventListener {
    private static a pST = null;

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f11701a;

    /* renamed from: b  reason: collision with root package name */
    private int f11702b;
    private int c = 0;
    private float[] d = new float[3];
    private DecimalFormat pSS = new DecimalFormat("0.0");

    private a(Context context) {
        this.f11701a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f11701a = (SensorManager) applicationContext.getSystemService("sensor");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3.f11701a.registerListener(r3, r3.f11701a.getDefaultSensor(1), 3) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void b() {
        try {
            if (this.f11701a != null) {
                if (this.f11702b == 0) {
                }
                this.f11702b++;
            }
        } catch (Exception e) {
        }
    }

    private synchronized void c() {
        try {
            if (this.f11701a != null) {
                this.f11702b--;
                if (this.f11702b == 0) {
                    this.f11701a.unregisterListener(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static a iu(Context context) {
        if (pST == null) {
            synchronized (a.class) {
                if (pST == null) {
                    pST = new a(context);
                }
            }
        }
        return pST;
    }

    public String a() {
        StringBuilder append;
        b();
        try {
            synchronized (this) {
                int i = 0;
                while (this.c == 0 && i < 10) {
                    i++;
                    wait(100L);
                }
            }
            return append.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return append.toString();
        } finally {
            String str = this.pSS.format(this.d[0]) + ", " + this.pSS.format(this.d[1]) + ", " + this.pSS.format(this.d[2]);
            c();
            this.c = 0;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.d = sensorEvent.values;
        this.c = 1;
    }
}
