package com.kwad.sdk.collector;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class f {
    @Nullable
    public static JSONArray a(Context context) {
        List<g> c = c(context);
        c.add(b(context));
        return g.a(c);
    }

    public static g b(Context context) {
        boolean a = ag.a(context);
        com.kwad.sdk.core.d.b.a("InfoCollector", "queryAccessibilityServicePermission result: " + a);
        return new g("android.permission.BIND_ACCESSIBILITY_SERVICE", a ? g.b : g.c);
    }

    @NonNull
    public static List<g> c(Context context) {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
                for (String str : strArr) {
                    int a = ag.a(context, str);
                    arrayList.add(new g(str, a == 0 ? g.b : a == -1 ? g.c : g.a));
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            com.kwad.sdk.core.d.b.a(e);
            return arrayList;
        }
    }
}
