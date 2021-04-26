package d.a.h0.d.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f45660b = "a";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45661c = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences f45662d = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f45663a;

    public a(Context context) {
        this.f45663a = null;
        this.f45663a = context;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f45661c) {
                String str = f45660b;
                Log.e(str, "error:" + e2.getMessage());
                return -1;
            }
            return -1;
        }
    }

    public static SharedPreferences c(Context context) {
        if (f45662d == null) {
            f45662d = context.getSharedPreferences("downgradefile", 0);
        }
        return f45662d;
    }

    public static a d(Context context) {
        return new a(context);
    }

    public static void j(Context context, int i2) {
        if (f45661c) {
            String str = f45660b;
            Log.d(str, "set last version code:" + i2);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("last_versioncode_key", i2);
        edit.apply();
    }

    public final int b(Context context) {
        int i2 = c(context).getInt("old_versioncode_key", 0);
        if (f45661c) {
            String str = f45660b;
            Log.d(str, "get old versioncode:" + i2);
        }
        return i2;
    }

    public final void e(int i2, int i3) {
    }

    public final void f(int i2) {
        d.a.h0.a.h2.a.b(0, i2);
    }

    public final void g() {
        if (f45661c) {
            String str = f45660b;
            Log.d(str, "新旧版本一样:" + b(this.f45663a));
        }
    }

    public final void h(int i2, int i3) {
        d.a.h0.a.h2.a.b(i3, i2);
        d.a.h0.t.a.d();
    }

    public void i() {
        int a2 = a(this.f45663a);
        int b2 = b(this.f45663a);
        if (f45661c) {
            String str = f45660b;
            Log.d(str, "处理升级逻辑：newVersionCode=" + a2 + " /oldVersionCode=" + b2);
        }
        if (b2 == 0) {
            f(a2);
            k(this.f45663a, a2);
            j(this.f45663a, b2);
        } else if (a2 > b2) {
            h(a2, b2);
            k(this.f45663a, a2);
            j(this.f45663a, b2);
        } else if (a2 < b2) {
            e(a2, b2);
            k(this.f45663a, a2);
            j(this.f45663a, b2);
        } else {
            g();
        }
    }

    public final void k(Context context, int i2) {
        if (f45661c) {
            String str = f45660b;
            Log.d(str, "set new versioncode:" + i2);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("old_versioncode_key", i2);
        edit.apply();
    }
}
