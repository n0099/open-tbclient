package d.a.l0.a.s1;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import d.a.l0.a.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44685a = k.f43199a;

    public static boolean a(Context context, @NonNull f fVar) {
        if (context instanceof SwanAppBaseActivity) {
            return true;
        }
        fVar.b(2, "method should be called after setActivityRef");
        if (f44685a) {
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
        return false;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull f fVar) {
        if (d.a.l0.u.d.c.a(context, str)) {
            fVar.a("permission has already granted");
            return true;
        }
        return false;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull f fVar) {
        if (arrayList == null || arrayList.isEmpty()) {
            fVar.a("permission has already granted");
            return true;
        }
        return false;
    }

    @NonNull
    public static ArrayList<String> d(@NonNull Context context, @NonNull String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            if (!d.a.l0.u.d.c.a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i2, @NonNull Context context, @NonNull f fVar) {
        if (a(context, fVar) && !b(context, str, fVar)) {
            f(context, strArr, i2, fVar);
        }
    }

    public static void f(@NonNull Context context, @NonNull String[] strArr, int i2, @NonNull f fVar) {
        if (a(context, fVar)) {
            ArrayList<String> d2 = d(context, strArr);
            if (c(d2, fVar)) {
                return;
            }
            ((SwanAppBaseActivity) context).requestPermissionsExt(i2, (String[]) d2.toArray(new String[0]), new b(context, i2, fVar));
        }
    }

    public static void g(@NonNull String[] strArr, int i2, @NonNull Context context, @NonNull f fVar) {
        if (a(context, fVar)) {
            ArrayList<String> d2 = d(context, strArr);
            if (c(d2, fVar)) {
                return;
            }
            f(context, (String[]) d2.toArray(new String[0]), i2, fVar);
        }
    }
}
