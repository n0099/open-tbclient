package d.r.b.a.a.f.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class c {
    @JvmStatic
    public static final boolean a(Context context) {
        return b(context, "com.tencent.mm");
    }

    @JvmStatic
    public static final boolean b(Context context, String str) {
        PackageManager packageManager = context != null ? context.getPackageManager() : null;
        List<PackageInfo> installedPackages = packageManager != null ? packageManager.getInstalledPackages(0) : null;
        if (installedPackages != null) {
            int size = installedPackages.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (Intrinsics.areEqual(installedPackages.get(i2).packageName, str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
