package d.a.l0.a.v2;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class y {
    public static boolean a(@NonNull Context context, @NonNull String str) {
        String[] strArr;
        try {
            strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
