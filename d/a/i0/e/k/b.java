package d.a.i0.e.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f46363b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46364c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences f46365d = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f46366a;

    public b(Context context) {
        this.f46366a = null;
        this.f46366a = context;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f46364c) {
                String str = f46363b;
                Log.e(str, "error:" + e2.getMessage());
                return -1;
            }
            return -1;
        }
    }

    public static SharedPreferences c(Context context) {
        if (f46365d == null) {
            f46365d = context.getSharedPreferences("downgradefile", 0);
        }
        return f46365d;
    }

    public static b d(Context context) {
        return new b(context);
    }

    public static void j(Context context, int i2) {
        if (f46364c) {
            String str = f46363b;
            Log.d(str, "set last version code:" + i2);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("last_versioncode_key", i2);
        edit.apply();
    }

    public final int b(Context context) {
        int i2 = c(context).getInt("old_versioncode_key", 0);
        if (f46364c) {
            String str = f46363b;
            Log.d(str, "get old versioncode:" + i2);
        }
        return i2;
    }

    public final void e(int i2, int i3) {
    }

    public final void f(int i2) {
        d.a.i0.a.t2.a.d(0, i2);
    }

    public final void g() {
        if (f46364c) {
            String str = f46363b;
            Log.d(str, "新旧版本一样:" + b(this.f46366a));
        }
    }

    public final void h(int i2, int i3) {
        d.a.i0.a.t2.a.d(i3, i2);
        d.a.i0.w.a.c();
        d.a.i0.a.n0.k.c.f43471d.u();
    }

    public void i() {
        int a2 = a(this.f46366a);
        int b2 = b(this.f46366a);
        if (f46364c) {
            String str = f46363b;
            Log.d(str, "处理升级逻辑：newVersionCode=" + a2 + " /oldVersionCode=" + b2);
        }
        if (b2 == 0) {
            f(a2);
            k(this.f46366a, a2);
            j(this.f46366a, b2);
        } else if (a2 > b2) {
            h(a2, b2);
            k(this.f46366a, a2);
            j(this.f46366a, b2);
        } else if (a2 < b2) {
            e(a2, b2);
            k(this.f46366a, a2);
            j(this.f46366a, b2);
        } else {
            g();
        }
    }

    public final void k(Context context, int i2) {
        if (f46364c) {
            String str = f46363b;
            Log.d(str, "set new versioncode:" + i2);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("old_versioncode_key", i2);
        edit.apply();
    }
}
