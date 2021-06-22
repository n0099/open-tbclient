package d.m.b.b.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b implements SensorEventListener {

    /* renamed from: f  reason: collision with root package name */
    public static b f70389f;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f70390a;

    /* renamed from: b  reason: collision with root package name */
    public int f70391b;

    /* renamed from: c  reason: collision with root package name */
    public int f70392c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float[] f70393d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public List<String> f70394e = new ArrayList();

    public b(Context context) {
        this.f70390a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f70390a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f70389f == null) {
            synchronized (b.class) {
                if (f70389f == null) {
                    f70389f = new b(context);
                }
            }
        }
        return f70389f;
    }

    public String b() {
        String str = null;
        try {
            e();
            synchronized (this) {
                int i2 = 0;
                while (this.f70392c == 0 && i2 < 10) {
                    i2++;
                    wait(100L);
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
            str = decimalFormat.format(this.f70393d[0]) + "," + decimalFormat.format(this.f70393d[1]) + "," + decimalFormat.format(this.f70393d[2]);
        } catch (Throwable unused) {
        }
        f();
        this.f70392c = 0;
        return str;
    }

    public void c() {
        String b2 = b();
        if (b2 == null) {
            return;
        }
        this.f70394e.add(b2);
        try {
            int size = this.f70394e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f70394e.subList(size - 10, size));
                this.f70394e.clear();
                this.f70394e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        String str = "";
        int size = this.f70394e.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f70394e.get(0);
        }
        try {
            List<String> list = this.f70394e;
            int i2 = size - 10;
            if (i2 <= 0) {
                i2 = 0;
            }
            List<String> subList = list.subList(i2, size);
            for (int i3 = 0; i3 < subList.size(); i3++) {
                str = str + subList.get(i3) + "|";
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }

    public final synchronized void e() {
        try {
            if (this.f70390a != null) {
                if (this.f70391b == 0) {
                    if (!this.f70390a.registerListener(this, this.f70390a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f70391b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void f() {
        try {
            if (this.f70390a != null) {
                int i2 = this.f70391b - 1;
                this.f70391b = i2;
                if (i2 == 0) {
                    this.f70390a.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f70393d = sensorEvent.values;
        this.f70392c = 1;
    }
}
