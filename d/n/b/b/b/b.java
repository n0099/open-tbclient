package d.n.b.b.b;

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
    public static b f67441f;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f67442a;

    /* renamed from: b  reason: collision with root package name */
    public int f67443b;

    /* renamed from: c  reason: collision with root package name */
    public int f67444c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float[] f67445d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public List<String> f67446e = new ArrayList();

    public b(Context context) {
        this.f67442a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f67442a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f67441f == null) {
            synchronized (b.class) {
                if (f67441f == null) {
                    f67441f = new b(context);
                }
            }
        }
        return f67441f;
    }

    public String b() {
        String str = null;
        try {
            e();
            synchronized (this) {
                int i = 0;
                while (this.f67444c == 0 && i < 10) {
                    i++;
                    wait(100L);
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
            str = decimalFormat.format(this.f67445d[0]) + "," + decimalFormat.format(this.f67445d[1]) + "," + decimalFormat.format(this.f67445d[2]);
        } catch (Throwable unused) {
        }
        f();
        this.f67444c = 0;
        return str;
    }

    public void c() {
        String b2 = b();
        if (b2 == null) {
            return;
        }
        this.f67446e.add(b2);
        try {
            int size = this.f67446e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f67446e.subList(size - 10, size));
                this.f67446e.clear();
                this.f67446e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        String str = "";
        int size = this.f67446e.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f67446e.get(0);
        }
        try {
            List<String> list = this.f67446e;
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
            if (this.f67442a != null) {
                if (this.f67443b == 0) {
                    if (!this.f67442a.registerListener(this, this.f67442a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f67443b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void f() {
        try {
            if (this.f67442a != null) {
                int i = this.f67443b - 1;
                this.f67443b = i;
                if (i == 0) {
                    this.f67442a.unregisterListener(this);
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
        this.f67445d = sensorEvent.values;
        this.f67444c = 1;
    }
}
