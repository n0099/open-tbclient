package d.m.b.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f67291c;

    /* renamed from: a  reason: collision with root package name */
    public Context f67292a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f67293b = new ArrayList();

    public a(Context context) {
        this.f67292a = null;
        this.f67292a = context;
    }

    public static a b(Context context) {
        if (f67291c == null) {
            synchronized (a.class) {
                if (f67291c == null) {
                    f67291c = new a(context);
                }
            }
        }
        return f67291c;
    }

    public int a() {
        Intent registerReceiver = this.f67292a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return Math.round(((registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1)) * 100.0f) * 10.0f) / 10;
    }

    public int c() {
        Intent registerReceiver = this.f67292a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra("plugged", -1);
    }

    @SuppressLint({"DefaultLocale"})
    public String d() {
        int i;
        int i2 = -1;
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
                                i = a2;
                                i2 = c2;
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
                            i2 = c2;
                            i = -1;
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
                i = -1;
            }
            try {
                break;
                throw th;
            } catch (Throwable th6) {
                th = th6;
                String str = "" + ((i2 * 10000) + i);
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
        this.f67293b.add(d2);
        try {
            int size = this.f67293b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f67293b.subList(size - 10, size));
                this.f67293b.clear();
                this.f67293b = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String f() {
        String str = "";
        int size = this.f67293b.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f67293b.get(0);
        }
        try {
            List<String> list = this.f67293b;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List<String> subList = list.subList(i, size);
            for (int i2 = 0; i2 < subList.size(); i2++) {
                str = str + subList.get(i2) + ",";
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }
}
