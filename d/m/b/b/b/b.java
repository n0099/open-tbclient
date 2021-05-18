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
    public static b f66456f;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f66457a;

    /* renamed from: b  reason: collision with root package name */
    public int f66458b;

    /* renamed from: c  reason: collision with root package name */
    public int f66459c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float[] f66460d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public List<String> f66461e = new ArrayList();

    public b(Context context) {
        this.f66457a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f66457a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f66456f == null) {
            synchronized (b.class) {
                if (f66456f == null) {
                    f66456f = new b(context);
                }
            }
        }
        return f66456f;
    }

    public String b() {
        String str = null;
        try {
            e();
            synchronized (this) {
                int i2 = 0;
                while (this.f66459c == 0 && i2 < 10) {
                    i2++;
                    wait(100L);
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
            str = decimalFormat.format(this.f66460d[0]) + "," + decimalFormat.format(this.f66460d[1]) + "," + decimalFormat.format(this.f66460d[2]);
        } catch (Throwable unused) {
        }
        f();
        this.f66459c = 0;
        return str;
    }

    public void c() {
        String b2 = b();
        if (b2 == null) {
            return;
        }
        this.f66461e.add(b2);
        try {
            int size = this.f66461e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f66461e.subList(size - 10, size));
                this.f66461e.clear();
                this.f66461e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        String str = "";
        int size = this.f66461e.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f66461e.get(0);
        }
        try {
            List<String> list = this.f66461e;
            int i2 = size - 10;
            if (i2 <= 0) {
                i2 = 0;
            }
            List<String> subList = list.subList(i2, size);
            for (int i3 = 0; i3 < subList.size(); i3++) {
                str = str + subList.get(i3) + FieldBuilder.SE;
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }

    public final synchronized void e() {
        try {
            if (this.f66457a != null) {
                if (this.f66458b == 0) {
                    if (!this.f66457a.registerListener(this, this.f66457a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f66458b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void f() {
        try {
            if (this.f66457a != null) {
                int i2 = this.f66458b - 1;
                this.f66458b = i2;
                if (i2 == 0) {
                    this.f66457a.unregisterListener(this);
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
        this.f66460d = sensorEvent.values;
        this.f66459c = 1;
    }
}
