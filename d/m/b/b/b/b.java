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
/* loaded from: classes7.dex */
public final class b implements SensorEventListener {

    /* renamed from: f  reason: collision with root package name */
    public static b f66499f;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f66500a;

    /* renamed from: b  reason: collision with root package name */
    public int f66501b;

    /* renamed from: c  reason: collision with root package name */
    public int f66502c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float[] f66503d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public List<String> f66504e = new ArrayList();

    public b(Context context) {
        this.f66500a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f66500a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f66499f == null) {
            synchronized (b.class) {
                if (f66499f == null) {
                    f66499f = new b(context);
                }
            }
        }
        return f66499f;
    }

    public String b() {
        String str = null;
        try {
            e();
            synchronized (this) {
                int i2 = 0;
                while (this.f66502c == 0 && i2 < 10) {
                    i2++;
                    wait(100L);
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
            str = decimalFormat.format(this.f66503d[0]) + "," + decimalFormat.format(this.f66503d[1]) + "," + decimalFormat.format(this.f66503d[2]);
        } catch (Throwable unused) {
        }
        f();
        this.f66502c = 0;
        return str;
    }

    public void c() {
        String b2 = b();
        if (b2 == null) {
            return;
        }
        this.f66504e.add(b2);
        try {
            int size = this.f66504e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f66504e.subList(size - 10, size));
                this.f66504e.clear();
                this.f66504e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        String str = "";
        int size = this.f66504e.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f66504e.get(0);
        }
        try {
            List<String> list = this.f66504e;
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
            if (this.f66500a != null) {
                if (this.f66501b == 0) {
                    if (!this.f66500a.registerListener(this, this.f66500a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f66501b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void f() {
        try {
            if (this.f66500a != null) {
                int i2 = this.f66501b - 1;
                this.f66501b = i2;
                if (i2 == 0) {
                    this.f66500a.unregisterListener(this);
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
        this.f66503d = sensorEvent.values;
        this.f66502c = 1;
    }
}
