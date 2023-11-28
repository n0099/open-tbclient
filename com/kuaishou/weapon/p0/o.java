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
import com.kuaishou.weapon.p0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    public static s a(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int a;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            p b2 = b(jSONObject);
            if (b2 == null) {
                return null;
            }
            int a2 = b2.a();
            String l = b2.l();
            String j = b2.j();
            boolean z3 = true;
            if (b2.d() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (b2.h() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            int e = b2.e();
            String c = b2.c();
            String f = b2.f();
            String b3 = b2.b();
            PackageInfo packageInfo = new PackageInfo();
            try {
                packageInfo.packageName = f;
                packageInfo.versionName = l;
                ApplicationInfo applicationInfo = new ApplicationInfo();
                if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(b3) && b3.startsWith(".")) {
                    applicationInfo.name = f + b3;
                    applicationInfo.className = f + b3;
                }
                applicationInfo.theme = b2.i();
                packageInfo.applicationInfo = applicationInfo;
                List<p.a> m = b2.m();
                if (m != null && m.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < m.size(); i++) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        activityInfo.name = m.get(i).c();
                        activityInfo.theme = m.get(i).b();
                        activityInfo.labelRes = m.get(i).a();
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
            s sVar = new s(packageInfo, a2, f, l, j, c);
            sVar.v = z;
            sVar.x = e;
            if (b2.k() == null) {
                a = 0;
            } else {
                a = b2.k().a();
            }
            if (b2.k() == null) {
                b = -1;
            } else {
                b = b2.k().b();
            }
            sVar.t = a;
            sVar.u = b;
            sVar.s = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT > 29 && z2) {
                if (b2.g() != 1) {
                    z3 = false;
                }
                z2 = z3;
            }
            sVar.y = z2;
            return sVar;
        }
        return (s) invokeL.objValue;
    }

    public static p b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            try {
                p pVar = new p();
                pVar.a(jSONObject.optInt("wk"));
                pVar.a(jSONObject.optString("wan"));
                pVar.b(jSONObject.optString("wm"));
                pVar.b(jSONObject.optInt("wo"));
                pVar.c(jSONObject.optInt("wpr"));
                pVar.c(jSONObject.optString(bi.q));
                pVar.e(jSONObject.optInt("ws", 1));
                pVar.d(jSONObject.optInt("wh", 0));
                pVar.f(jSONObject.optInt("wt"));
                pVar.d(jSONObject.optString("wu"));
                pVar.e(jSONObject.optString("wv"));
                JSONArray jSONArray = jSONObject.getJSONArray("wa");
                ArrayList arrayList = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    p.a aVar = new p.a();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    aVar.a(jSONObject2.optInt("r"));
                    aVar.b(jSONObject2.optInt("t"));
                    aVar.a(jSONObject2.getString("n"));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
                pVar.a(arrayList);
                p.b bVar = new p.b();
                JSONObject jSONObject3 = jSONObject.getJSONObject("we");
                bVar.a(jSONObject3.optInt("duration"));
                bVar.b(jSONObject3.optInt("network"));
                pVar.a(bVar);
                return pVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (p) invokeL.objValue;
    }
}
