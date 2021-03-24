package com.bytedance.sdk.openadsdk.j;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static SensorManager f29553a;

    public static int a(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void a(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            SensorManager b2 = b(context);
            b2.registerListener(sensorEventListener, b2.getDefaultSensor(1), a(i));
        } catch (Throwable th) {
            d.a("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static SensorManager b(Context context) {
        if (f29553a == null) {
            synchronized (g.class) {
                if (f29553a == null) {
                    f29553a = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return f29553a;
    }

    public static void a(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            b(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            d.a("SensorHub", "stopListen error", th);
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(300L);
    }

    public static void b(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            SensorManager b2 = b(context);
            b2.registerListener(sensorEventListener, b2.getDefaultSensor(4), a(i));
        } catch (Throwable th) {
            d.a("SensorHub", "startListenGyroscope error", th);
        }
    }
}
