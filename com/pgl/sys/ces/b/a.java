package com.pgl.sys.ces.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public final class a implements SensorEventListener {
    private static a qag = null;

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f11404a;

    /* renamed from: b  reason: collision with root package name */
    private int f11405b;
    private int c = 0;
    private float[] d = new float[3];
    private DecimalFormat qaf = new DecimalFormat("0.0");

    private a(Context context) {
        this.f11404a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f11404a = (SensorManager) applicationContext.getSystemService("sensor");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3.f11404a.registerListener(r3, r3.f11404a.getDefaultSensor(1), 3) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void b() {
        try {
            if (this.f11404a != null) {
                if (this.f11405b == 0) {
                }
                this.f11405b++;
            }
        } catch (Exception e) {
        }
    }

    private synchronized void c() {
        try {
            if (this.f11404a != null) {
                this.f11405b--;
                if (this.f11405b == 0) {
                    this.f11404a.unregisterListener(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static a iv(Context context) {
        if (qag == null) {
            synchronized (a.class) {
                if (qag == null) {
                    qag = new a(context);
                }
            }
        }
        return qag;
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
            String str = this.qaf.format(this.d[0]) + ", " + this.qaf.format(this.d[1]) + ", " + this.qaf.format(this.d[2]);
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
