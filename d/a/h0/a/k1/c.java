package d.a.h0.a.k1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import d.a.h0.a.k;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43124c = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f43125d;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<a> f43126a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f43127b = new HashSet();

    /* loaded from: classes3.dex */
    public interface a {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static c b() {
        if (f43125d == null) {
            synchronized (d.a.h0.g.c.j.b.class) {
                if (f43125d == null) {
                    f43125d = new c();
                }
            }
        }
        return f43125d;
    }

    public final boolean a(@NonNull String[] strArr) {
        if (strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.f43127b.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            e(activity, strArr, iArr);
        }
        a aVar = this.f43126a.get(i2);
        if (aVar != null) {
            if (strArr.length > 0 && iArr.length > 0) {
                aVar.onRequestPermissionsResult(i2, strArr, iArr);
            }
            this.f43126a.remove(i2);
        }
        if (f43124c) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i2 + " permissions: " + Arrays.toString(strArr));
            StringBuilder sb = new StringBuilder();
            sb.append("onRequestPermissionsResult grantResults: ");
            sb.append(Arrays.toString(iArr));
            Log.d("SwanAppPermission", sb.toString());
        }
    }

    @TargetApi(23)
    public void d(Activity activity, int i2, @NonNull String[] strArr, a aVar) {
        if (aVar == null) {
            return;
        }
        if (a(strArr)) {
            aVar.onRequestPermissionsResult(i2, strArr, new int[]{-1});
            return;
        }
        this.f43126a.put(i2, aVar);
        activity.requestPermissions(strArr, i2);
        if (f43124c) {
            Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i2 + " permissions: " + Arrays.toString(strArr));
        }
    }

    @RequiresApi(api = 23)
    public final void e(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (length = strArr.length) == iArr.length && length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                String str = strArr[i2];
                if (!TextUtils.isEmpty(str) && i3 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                    this.f43127b.add(str);
                }
            }
        }
    }
}
