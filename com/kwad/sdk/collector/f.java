package com.kwad.sdk.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.un.s;
import com.kwad.sdk.utils.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class f {
    @Nullable
    public static JSONArray a(Context context) {
        List<g> c2 = c(context);
        c2.add(b(context));
        return g.a(c2);
    }

    public static g b(Context context) {
        boolean a = ah.a(context);
        com.kwad.sdk.core.d.a.a("InfoCollector", "queryAccessibilityServicePermission result: " + a);
        return new g(s.f55461j, a ? g.f55703b : g.f55704c);
    }

    @NonNull
    public static List<g> c(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    int a = ah.a(context, str);
                    arrayList.add(new g(str, a == 0 ? g.f55703b : a == -1 ? g.f55704c : g.a));
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return arrayList;
        }
    }
}
