package com.pgl.sys.ces.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements SensorEventListener {
    private static b qbu = null;

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f7484a;
    private int b;
    private int c = 0;
    private float[] d = new float[3];
    private List<String> e = new ArrayList();

    private b(Context context) {
        this.f7484a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f7484a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3.f7484a.registerListener(r3, r3.f7484a.getDefaultSensor(1), 3) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void d() {
        try {
            if (this.f7484a != null) {
                if (this.b == 0) {
                }
                this.b++;
            }
        } catch (Exception e) {
        }
    }

    private synchronized void e() {
        try {
            if (this.f7484a != null) {
                this.b--;
                if (this.b == 0) {
                    this.f7484a.unregisterListener(this);
                }
            }
        } catch (Exception e) {
        }
    }

    public static b iw(Context context) {
        if (qbu == null) {
            synchronized (b.class) {
                if (qbu == null) {
                    qbu = new b(context);
                }
            }
        }
        return qbu;
    }

    public String a() {
        String str = null;
        try {
            d();
            synchronized (this) {
                int i = 0;
                while (this.c == 0 && i < 10) {
                    i++;
                    wait(100L);
                }
            }
            try {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                str = decimalFormat.format(this.d[0]) + "," + decimalFormat.format(this.d[1]) + "," + decimalFormat.format(this.d[2]);
            } catch (Throwable th) {
            }
            e();
            this.c = 0;
        } catch (Throwable th2) {
            try {
                DecimalFormat decimalFormat2 = new DecimalFormat("0.0");
                str = decimalFormat2.format(this.d[0]) + "," + decimalFormat2.format(this.d[1]) + "," + decimalFormat2.format(this.d[2]);
            } catch (Throwable th3) {
            }
            e();
            this.c = 0;
        }
        return str;
    }

    public void b() {
        String a2 = a();
        if (a2 == null) {
            return;
        }
        this.e.add(a2);
        try {
            int size = this.e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.e.subList(size - 10, size));
                this.e.clear();
                this.e = arrayList;
            }
        } catch (Throwable th) {
        }
    }

    public synchronized String c() {
        String str;
        List<String> subList;
        synchronized (this) {
            str = "";
            int size = this.e.size();
            if (size > 0) {
                if (size == 1) {
                    str = this.e.get(0);
                } else {
                    try {
                        String str2 = "";
                        for (int i = 0; i < this.e.subList(size + (-10) > 0 ? size - 10 : 0, size).size(); i++) {
                            try {
                                str2 = str2 + subList.get(i) + "|";
                            } catch (Throwable th) {
                                str = str2;
                            }
                        }
                        str = str2.substring(0, str2.length() - 1);
                    } catch (Throwable th2) {
                    }
                }
            }
        }
        return str;
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
