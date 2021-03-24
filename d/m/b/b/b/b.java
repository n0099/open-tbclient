package d.m.b.b.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements SensorEventListener {

    /* renamed from: f  reason: collision with root package name */
    public static b f66300f;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f66301a;

    /* renamed from: b  reason: collision with root package name */
    public int f66302b;

    /* renamed from: c  reason: collision with root package name */
    public int f66303c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float[] f66304d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public List<String> f66305e = new ArrayList();

    public b(Context context) {
        this.f66301a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f66301a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f66300f == null) {
            synchronized (b.class) {
                if (f66300f == null) {
                    f66300f = new b(context);
                }
            }
        }
        return f66300f;
    }

    public String b() {
        String str = null;
        try {
            e();
            synchronized (this) {
                int i = 0;
                while (this.f66303c == 0 && i < 10) {
                    i++;
                    wait(100L);
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            str = decimalFormat.format(this.f66304d[0]) + "," + decimalFormat.format(this.f66304d[1]) + "," + decimalFormat.format(this.f66304d[2]);
        } catch (Throwable unused) {
        }
        f();
        this.f66303c = 0;
        return str;
    }

    public void c() {
        String b2 = b();
        if (b2 == null) {
            return;
        }
        this.f66305e.add(b2);
        try {
            int size = this.f66305e.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f66305e.subList(size - 10, size));
                this.f66305e.clear();
                this.f66305e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        String str = "";
        int size = this.f66305e.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f66305e.get(0);
        }
        try {
            List<String> list = this.f66305e;
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
            if (this.f66301a != null) {
                if (this.f66302b == 0) {
                    if (!this.f66301a.registerListener(this, this.f66301a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f66302b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void f() {
        try {
            if (this.f66301a != null) {
                int i = this.f66302b - 1;
                this.f66302b = i;
                if (i == 0) {
                    this.f66301a.unregisterListener(this);
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
        this.f66304d = sensorEvent.values;
        this.f66303c = 1;
    }
}
