package d.b.g0.a.k1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import d.b.g0.a.k;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45074c = k.f45051a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f45075d;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<a> f45076a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f45077b = new HashSet();

    /* loaded from: classes2.dex */
    public interface a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static c b() {
        if (f45075d == null) {
            synchronized (d.b.g0.g.c.j.b.class) {
                if (f45075d == null) {
                    f45075d = new c();
                }
            }
        }
        return f45075d;
    }

    public final boolean a(@NonNull String[] strArr) {
        if (strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.f45077b.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            e(activity, strArr, iArr);
        }
        a aVar = this.f45076a.get(i);
        if (aVar != null) {
            if (strArr.length > 0 && iArr.length > 0) {
                aVar.onRequestPermissionsResult(i, strArr, iArr);
            }
            this.f45076a.remove(i);
        }
        if (f45074c) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            StringBuilder sb = new StringBuilder();
            sb.append("onRequestPermissionsResult grantResults: ");
            sb.append(Arrays.toString(iArr));
            Log.d("SwanAppPermission", sb.toString());
        }
    }

    @TargetApi(23)
    public void d(Activity activity, int i, @NonNull String[] strArr, a aVar) {
        if (aVar == null) {
            return;
        }
        if (a(strArr)) {
            aVar.onRequestPermissionsResult(i, strArr, new int[]{-1});
            return;
        }
        this.f45076a.put(i, aVar);
        activity.requestPermissions(strArr, i);
        if (f45074c) {
            Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i + " permissions: " + Arrays.toString(strArr));
        }
    }

    @RequiresApi(api = 23)
    public final void e(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (length = strArr.length) == iArr.length && length > 0) {
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (!TextUtils.isEmpty(str) && i2 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                    this.f45077b.add(str);
                }
            }
        }
    }
}
