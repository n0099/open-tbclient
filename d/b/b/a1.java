package d.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.ci;
import d.b.b.g1;
import d.b.b.n1;
/* loaded from: classes6.dex */
public final class a1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final t0<Boolean> f68704a = new a();

    /* loaded from: classes6.dex */
    public static class a extends t0<Boolean> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.t0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(z0.b((Context) objArr[0], "com.huawei.hwid"));
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements n1.b<ci, Pair<String, Boolean>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: b */
        public Pair<String, Boolean> a(ci ciVar) {
            if (ciVar == null) {
                return null;
            }
            return new Pair<>(ciVar.a(), Boolean.valueOf(ciVar.b()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: c */
        public ci a(IBinder iBinder) {
            return ci.a.a(iBinder);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends g1.a {

        /* renamed from: c  reason: collision with root package name */
        public long f68705c = 0;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return f68704a.b(context).booleanValue();
    }

    public static int e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Nullable
    public static Pair<String, Boolean> f(Context context) {
        return (Pair) new n1(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new b()).a();
    }

    @Override // d.b.b.g1
    public boolean a(Context context) {
        return c(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.g1
    @Nullable
    @WorkerThread
    /* renamed from: d */
    public c b(Context context) {
        c cVar = new c();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    cVar.f68754a = string;
                    cVar.f68755b = Boolean.parseBoolean(string2);
                    cVar.f68705c = 202003021704L;
                    return cVar;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Pair<String, Boolean> f2 = f(context);
        if (f2 != null) {
            cVar.f68754a = (String) f2.first;
            cVar.f68755b = ((Boolean) f2.second).booleanValue();
            cVar.f68705c = e(context);
        }
        return cVar;
    }
}
