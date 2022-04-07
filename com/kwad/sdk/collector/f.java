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
/* loaded from: classes5.dex */
public class f {
    @Nullable
    public static JSONArray a(Context context) {
        List<g> c = c(context);
        c.add(b(context));
        return g.a(c);
    }

    public static g b(Context context) {
        boolean a = ah.a(context);
        com.kwad.sdk.core.d.a.a("InfoCollector", "queryAccessibilityServicePermission result: " + a);
        return new g(s.j, a ? g.b : g.c);
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
                    arrayList.add(new g(str, a == 0 ? g.b : a == -1 ? g.c : g.a));
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            com.kwad.sdk.core.d.a.a(e);
            return arrayList;
        }
    }
}
