package d.a.l0.a.s1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48360c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f48361d;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<a> f48362a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f48363b = new HashSet();

    /* loaded from: classes3.dex */
    public interface a {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    @NonNull
    public static int[] b(@NonNull Activity activity, @Nullable String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = d.a.l0.u.d.c.a(activity, strArr[i2]) ? 0 : -1;
        }
        return iArr;
    }

    public static g c() {
        if (f48361d == null) {
            synchronized (g.class) {
                if (f48361d == null) {
                    f48361d = new g();
                }
            }
        }
        return f48361d;
    }

    @Nullable
    public static String d(@NonNull Activity activity, @NonNull String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (!d.a.l0.u.d.c.a(activity, str) && (d.a.l0.o.a.a.a.k(activity, str) || !e(str))) {
                return str;
            }
        }
        return null;
    }

    public static boolean e(String str) {
        d.a.l0.a.k2.g.b a2 = h.a();
        return a2.getBoolean("first#" + str, false);
    }

    public static void h(String str) {
        d.a.l0.a.k2.g.b a2 = h.a();
        a2.putBoolean("first#" + str, true);
    }

    public final boolean a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.f48363b.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void f(Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z = !a(strArr);
        if (Build.VERSION.SDK_INT >= 23) {
            i(activity, strArr, iArr);
        }
        a aVar = this.f48362a.get(i2);
        if (aVar != null) {
            this.f48362a.remove(i2);
            if ((aVar instanceof b) && z) {
                aVar = ((b) aVar).s();
            }
            aVar.onRequestPermissionsResult(i2, strArr, iArr);
        }
        if (f48360c) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i2 + " permissions: " + Arrays.toString(strArr));
            StringBuilder sb = new StringBuilder();
            sb.append("onRequestPermissionsResult grantResults: ");
            sb.append(Arrays.toString(iArr));
            Log.d("SwanAppPermission", sb.toString());
        }
    }

    @TargetApi(23)
    public void g(Activity activity, int i2, @NonNull String[] strArr, a aVar) {
        if (aVar == null || activity == null) {
            return;
        }
        String d2 = d(activity, strArr);
        if (d2 != null) {
            this.f48362a.put(i2, aVar);
            activity.requestPermissions(strArr, i2);
            h(d2);
        } else {
            aVar.onRequestPermissionsResult(i2, strArr, b(activity, strArr));
        }
        if (f48360c) {
            Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i2 + " permissions: " + Arrays.toString(strArr));
        }
    }

    @RequiresApi(api = 23)
    public final void i(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (length = strArr.length) == iArr.length && length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                String str = strArr[i2];
                if (!TextUtils.isEmpty(str) && i3 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                    this.f48363b.add(str);
                }
            }
        }
    }
}
