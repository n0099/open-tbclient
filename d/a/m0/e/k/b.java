package d.a.m0.e.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f50321b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50322c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences f50323d = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f50324a;

    public b(Context context) {
        this.f50324a = null;
        this.f50324a = context;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            if (f50322c) {
                String str = f50321b;
                Log.e(str, "error:" + e2.getMessage());
                return -1;
            }
            return -1;
        }
    }

    public static SharedPreferences c(Context context) {
        if (f50323d == null) {
            f50323d = context.getSharedPreferences("downgradefile", 0);
        }
        return f50323d;
    }

    public static b d(Context context) {
        return new b(context);
    }

    public static void j(Context context, int i2) {
        if (f50322c) {
            String str = f50321b;
            Log.d(str, "set last version code:" + i2);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("last_versioncode_key", i2);
        edit.apply();
    }

    public final int b(Context context) {
        int i2 = c(context).getInt("old_versioncode_key", 0);
        if (f50322c) {
            String str = f50321b;
            Log.d(str, "get old versioncode:" + i2);
        }
        return i2;
    }

    public final void e(int i2, int i3) {
    }

    public final void f(int i2) {
        d.a.m0.a.t2.a.d(0, i2);
    }

    public final void g() {
        if (f50322c) {
            String str = f50321b;
            Log.d(str, "新旧版本一样:" + b(this.f50324a));
        }
    }

    public final void h(int i2, int i3) {
        d.a.m0.a.t2.a.d(i3, i2);
        d.a.m0.w.a.c();
        d.a.m0.a.n0.k.c.f47429d.u();
    }

    public void i() {
        int a2 = a(this.f50324a);
        int b2 = b(this.f50324a);
        if (f50322c) {
            String str = f50321b;
            Log.d(str, "处理升级逻辑：newVersionCode=" + a2 + " /oldVersionCode=" + b2);
        }
        if (b2 == 0) {
            f(a2);
            k(this.f50324a, a2);
            j(this.f50324a, b2);
        } else if (a2 > b2) {
            h(a2, b2);
            k(this.f50324a, a2);
            j(this.f50324a, b2);
        } else if (a2 < b2) {
            e(a2, b2);
            k(this.f50324a, a2);
            j(this.f50324a, b2);
        } else {
            g();
        }
    }

    public final void k(Context context, int i2) {
        if (f50322c) {
            String str = f50321b;
            Log.d(str, "set new versioncode:" + i2);
        }
        SharedPreferences.Editor edit = c(context).edit();
        edit.putInt("old_versioncode_key", i2);
        edit.apply();
    }
}
