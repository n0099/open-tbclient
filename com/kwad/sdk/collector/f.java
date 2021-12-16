package com.kwad.sdk.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.s;
import com.kwad.sdk.utils.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static JSONArray a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            List<g> c2 = c(context);
            c2.add(b(context));
            return g.a(c2);
        }
        return (JSONArray) invokeL.objValue;
    }

    public static g b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            boolean a = ah.a(context);
            com.kwad.sdk.core.d.a.a("InfoCollector", "queryAccessibilityServicePermission result: " + a);
            return new g(s.f57426j, a ? g.f57677b : g.f57678c);
        }
        return (g) invokeL.objValue;
    }

    @NonNull
    public static List<g> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                return arrayList;
            }
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str : strArr) {
                        int a = ah.a(context, str);
                        arrayList.add(new g(str, a == 0 ? g.f57677b : a == -1 ? g.f57678c : g.a));
                    }
                }
                return arrayList;
            } catch (PackageManager.NameNotFoundException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }
}
