package d.b.g0.d.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f47489b = "a";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47490c = k.f45050a;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences f47491d = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f47492a;

    public a(Context context) {
        this.f47492a = null;
        this.f47492a = context;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f47490c) {
                String str = f47489b;
                Log.e(str, "error:" + e2.getMessage());
                return -1;
            }
            return -1;
        }
    }

    public static SharedPreferences c(Context context) {
        if (f47491d == null) {
            f47491d = context.getSharedPreferences("downgradefile", 0);
        }
        return f47491d;
    }

    public static a d(Context context) {
        return new a(context);
    }

    public static void j(Context context, int i) {
        if (f47490c) {
            String str = f47489b;
            Log.d(str, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }

    public final int b(Context context) {
        int i = c(context).getInt("old_versioncode_key", 0);
        if (f47490c) {
            String str = f47489b;
            Log.d(str, "get old versioncode:" + i);
        }
        return i;
    }

    public final void e(int i, int i2) {
    }

    public final void f(int i) {
        d.b.g0.a.h2.a.b(0, i);
    }

    public final void g() {
        if (f47490c) {
            String str = f47489b;
            Log.d(str, "新旧版本一样:" + b(this.f47492a));
        }
    }

    public final void h(int i, int i2) {
        d.b.g0.a.h2.a.b(i2, i);
        d.b.g0.t.a.d();
    }

    public void i() {
        int a2 = a(this.f47492a);
        int b2 = b(this.f47492a);
        if (f47490c) {
            String str = f47489b;
            Log.d(str, "处理升级逻辑：newVersionCode=" + a2 + " /oldVersionCode=" + b2);
        }
        if (b2 == 0) {
            f(a2);
            k(this.f47492a, a2);
            j(this.f47492a, b2);
        } else if (a2 > b2) {
            h(a2, b2);
            k(this.f47492a, a2);
            j(this.f47492a, b2);
        } else if (a2 < b2) {
            e(a2, b2);
            k(this.f47492a, a2);
            j(this.f47492a, b2);
        } else {
            g();
        }
    }

    public final void k(Context context, int i) {
        if (f47490c) {
            String str = f47489b;
            Log.d(str, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }
}
