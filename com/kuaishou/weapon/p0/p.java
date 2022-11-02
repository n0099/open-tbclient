package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static q a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                q qVar = new q();
                qVar.b(jSONObject.optInt("wk"));
                qVar.a(jSONObject.optString("wan"));
                qVar.b(jSONObject.optString("wm"));
                qVar.c(jSONObject.optInt("wo"));
                qVar.d(jSONObject.optInt("wpr"));
                qVar.c(jSONObject.optString(i1.q));
                qVar.e(jSONObject.optInt("ws", 1));
                qVar.a(jSONObject.optInt("wh", 0));
                qVar.f(jSONObject.optInt("wt"));
                qVar.d(jSONObject.optString("wu"));
                qVar.e(jSONObject.optString("wv"));
                JSONArray jSONArray = jSONObject.getJSONArray("wa");
                ArrayList arrayList = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    q.a aVar = new q.a();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    aVar.a(jSONObject2.optInt("r"));
                    aVar.b(jSONObject2.optInt("t"));
                    aVar.a(jSONObject2.getString("n"));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
                qVar.a(arrayList);
                q.b bVar = new q.b();
                JSONObject jSONObject3 = jSONObject.getJSONObject("we");
                bVar.a(jSONObject3.optInt("duration"));
                bVar.b(jSONObject3.optInt("network"));
                qVar.a(bVar);
                return qVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (q) invokeL.objValue;
    }

    public static t b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            q a = a(jSONObject);
            if (a == null) {
                return null;
            }
            int e = a.e();
            String m = a.m();
            String l = a.l();
            boolean z = true;
            boolean z2 = a.g() == 1;
            boolean z3 = a.j() == 1;
            int i = a.i();
            String f = a.f();
            String h = a.h();
            String b = a.b();
            PackageInfo packageInfo = new PackageInfo();
            try {
                packageInfo.packageName = h;
                packageInfo.versionName = m;
                ApplicationInfo applicationInfo = new ApplicationInfo();
                if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(b) && b.startsWith(".")) {
                    applicationInfo.name = h + b;
                    applicationInfo.className = h + b;
                }
                applicationInfo.theme = a.k();
                packageInfo.applicationInfo = applicationInfo;
                List<q.a> a2 = a.a();
                if (a2 != null && a2.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        activityInfo.name = a2.get(i2).a();
                        activityInfo.theme = a2.get(i2).c();
                        activityInfo.labelRes = a2.get(i2).b();
                        if (!TextUtils.isEmpty(activityInfo.name)) {
                            arrayList.add(activityInfo);
                        }
                    }
                    if (arrayList.size() > 0) {
                        packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                    }
                }
            } catch (Throwable unused) {
            }
            t tVar = new t(packageInfo, e, h, m, l, f);
            tVar.v = z2;
            tVar.x = i;
            int a3 = a.c() != null ? a.c().a() : 0;
            int b2 = a.c() != null ? a.c().b() : -1;
            tVar.t = a3;
            tVar.u = b2;
            tVar.s = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT <= 29 || !z3) {
                z = z3;
            } else if (a.d() != 1) {
                z = false;
            }
            tVar.y = z;
            return tVar;
        }
        return (t) invokeL.objValue;
    }
}
