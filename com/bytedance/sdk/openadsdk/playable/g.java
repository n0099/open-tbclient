package com.bytedance.sdk.openadsdk.playable;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static SensorManager f4952a;

    private static SensorManager b(Context context) {
        if (f4952a == null) {
            synchronized (g.class) {
                if (f4952a == null) {
                    f4952a = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return f4952a;
    }

    public static void a(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener != null && context != null) {
            try {
                SensorManager b = b(context);
                b.registerListener(sensorEventListener, b.getDefaultSensor(1), a(i));
            } catch (Throwable th) {
                d.a("SensorHub", "startListenAccelerometer error", th);
            }
        }
    }

    public static void b(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener != null && context != null) {
            try {
                SensorManager b = b(context);
                b.registerListener(sensorEventListener, b.getDefaultSensor(4), a(i));
            } catch (Throwable th) {
                d.a("SensorHub", "startListenGyroscope error", th);
            }
        }
    }

    public static void a(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener != null && context != null) {
            try {
                b(context).unregisterListener(sensorEventListener);
            } catch (Throwable th) {
                d.a("SensorHub", "stopListen error", th);
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(300L);
        }
    }

    private static int a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return i;
            default:
                return 2;
        }
    }
}
