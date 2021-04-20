package d.m.b.b.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements SensorEventListener {

    /* renamed from: f  reason: collision with root package name */
    public static b f67294f;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f67295a;

    /* renamed from: b  reason: collision with root package name */
    public int f67296b;

    /* renamed from: c  reason: collision with root package name */
    public int f67297c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float[] f67298d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public List<String> f67299e = new ArrayList();

    public b(Context context) {
        this.f67295a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f67295a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f67294f == null) {
            synchronized (b.class) {
                if (f67294f == null) {
                    f67294f = new b(context);
                }
            }
        }
        return f67294f;
    }

    public String b() {
        String str = null;
        try {
            e();
            synchronized (this) {
                int i = 0;
                while (this.f67297c == 0 && i < 10) {
                    i++;
                    wait(100L);
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
            str = decimalFormat.format(this.f67298d[0]) + "," + decimalFormat.format(this.f67298d[1]) + "," + decimalFormat.format(this.f67298d[2]);
        } catch (Throwable unused) {
        }
        f();
        this.f67297c = 0;
        return str;
    }

    public void c() {
        String b2 = b();
        if (b2 == null) {
            return;
        }
        this.f67299e.add(b2);
        try {
            int size = this.f67299e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f67299e.subList(size - 10, size));
                this.f67299e.clear();
                this.f67299e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        String str = "";
        int size = this.f67299e.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f67299e.get(0);
        }
        try {
            List<String> list = this.f67299e;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List<String> subList = list.subList(i, size);
            for (int i2 = 0; i2 < subList.size(); i2++) {
                str = str + subList.get(i2) + FieldBuilder.SE;
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }

    public final synchronized void e() {
        try {
            if (this.f67295a != null) {
                if (this.f67296b == 0) {
                    if (!this.f67295a.registerListener(this, this.f67295a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f67296b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void f() {
        try {
            if (this.f67295a != null) {
                int i = this.f67296b - 1;
                this.f67296b = i;
                if (i == 0) {
                    this.f67295a.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f67298d = sensorEvent.values;
        this.f67297c = 1;
    }
}
