package d.m.b.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f66496c;

    /* renamed from: a  reason: collision with root package name */
    public Context f66497a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f66498b = new ArrayList();

    public a(Context context) {
        this.f66497a = null;
        this.f66497a = context;
    }

    public static a b(Context context) {
        if (f66496c == null) {
            synchronized (a.class) {
                if (f66496c == null) {
                    f66496c = new a(context);
                }
            }
        }
        return f66496c;
    }

    public int a() {
        Intent registerReceiver = this.f66497a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return Math.round(((registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1)) * 100.0f) * 10.0f) / 10;
    }

    public int c() {
        Intent registerReceiver = this.f66497a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra("plugged", -1);
    }

    @SuppressLint({"DefaultLocale"})
    public String d() {
        int i2;
        int i3 = -1;
        try {
            try {
                synchronized (this) {
                    try {
                        int c2 = c();
                        try {
                            int a2 = a();
                            try {
                                return "" + ((c2 * 10000) + a2);
                            } catch (Throwable th) {
                                th = th;
                                i2 = a2;
                                i3 = c2;
                                while (true) {
                                    try {
                                        break;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i3 = c2;
                            i2 = -1;
                            while (true) {
                                break;
                                break;
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                i2 = -1;
            }
            try {
                break;
                throw th;
            } catch (Throwable th6) {
                th = th6;
                String str = "" + ((i3 * 10000) + i2);
                throw th;
            }
        } catch (Exception unused) {
            return "-10001";
        }
    }

    public void e() {
        String d2 = d();
        if (d2 == null) {
            return;
        }
        this.f66498b.add(d2);
        try {
            int size = this.f66498b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f66498b.subList(size - 10, size));
                this.f66498b.clear();
                this.f66498b = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String f() {
        String str = "";
        int size = this.f66498b.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f66498b.get(0);
        }
        try {
            List<String> list = this.f66498b;
            int i2 = size - 10;
            if (i2 <= 0) {
                i2 = 0;
            }
            List<String> subList = list.subList(i2, size);
            for (int i3 = 0; i3 < subList.size(); i3++) {
                str = str + subList.get(i3) + ",";
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }
}
