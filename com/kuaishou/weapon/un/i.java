package com.kuaishou.weapon.un;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.j;
import com.kuaishou.weapon.un.k;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static j a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                j jVar = new j();
                jVar.b(jSONObject.optInt("wk"));
                jVar.a(jSONObject.optString("wan"));
                jVar.b(jSONObject.optString("wm"));
                jVar.c(jSONObject.optInt("wo"));
                jVar.d(jSONObject.optInt("wpr"));
                jVar.c(jSONObject.optString(r1.m));
                jVar.e(jSONObject.optInt("ws", 1));
                jVar.a(jSONObject.optInt("wh", 0));
                jVar.f(jSONObject.optInt("wt"));
                jVar.d(jSONObject.optString("wu"));
                jVar.e(jSONObject.optString("wv"));
                JSONArray jSONArray = jSONObject.getJSONArray("wa");
                ArrayList arrayList = null;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    j.a aVar = new j.a();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    aVar.a(jSONObject2.optInt("r"));
                    aVar.b(jSONObject2.optInt("t"));
                    aVar.a(jSONObject2.getString("n"));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
                jVar.a(arrayList);
                j.b bVar = new j.b();
                JSONObject jSONObject3 = jSONObject.getJSONObject("we");
                bVar.a(jSONObject3.optInt("duration"));
                bVar.b(jSONObject3.optInt("network"));
                jVar.a(bVar);
                return jVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (j) invokeL.objValue;
    }

    public static k a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            k kVar = new k();
            try {
                JSONObject jSONObject = new JSONObject(str);
                kVar.m(jSONObject.optInt("status", 1));
                if (kVar.t() != 1) {
                    return null;
                }
                kVar.c(jSONObject.optString("pver"));
                kVar.a(jSONObject.optString("aver"));
                kVar.b(jSONObject.optString("bver"));
                kVar.d(jSONObject.optString("rver"));
                kVar.d(jSONObject.optInt("pd", 12));
                kVar.j(jSONObject.optInt("ps", 0));
                kVar.c(jSONObject.optInt("pc", 3));
                kVar.g(jSONObject.optInt("pi", 15));
                kVar.i(jSONObject.optInt("pp", 6));
                kVar.l(jSONObject.optInt("pu", 0));
                kVar.a(jSONObject.optInt(com.alipay.sdk.cons.b.k, 1));
                kVar.b(jSONObject.optInt("pb", 1));
                kVar.e(jSONObject.optInt("pg", 0));
                kVar.k(jSONObject.optInt("pt", 20));
                kVar.h(jSONObject.optInt(PushConstants.URI_PACKAGE_NAME, 0));
                kVar.f(jSONObject.optInt("ph", 0));
                k.a aVar = new k.a();
                JSONObject jSONObject2 = jSONObject.getJSONObject("a");
                aVar.a(jSONObject2.optInt("ac", 3));
                aVar.c(jSONObject2.optInt("as", 0));
                aVar.b(jSONObject2.optInt("ai", 8));
                kVar.a(aVar);
                k.b bVar = new k.b();
                JSONObject jSONObject3 = jSONObject.getJSONObject("b");
                bVar.a(jSONObject3.optInt("bc", 2));
                bVar.b(jSONObject3.optInt(NotificationStyle.BANNER_IMAGE_URL, 12));
                bVar.c(jSONObject3.optInt("bs", 1));
                JSONObject jSONObject4 = jSONObject3.getJSONObject("bcl");
                k.b.a aVar2 = new k.b.a();
                aVar2.a(jSONObject4.optInt("a", 1));
                aVar2.k(jSONObject4.optInt("r", 1));
                aVar2.c(jSONObject4.optInt("c", 1));
                aVar2.m(jSONObject4.optInt("s", 1));
                aVar2.d(jSONObject4.optInt("d", 1));
                aVar2.o(jSONObject4.optInt(x.o, 1));
                aVar2.p(jSONObject4.optInt("w", 1));
                aVar2.j(jSONObject4.optInt("n", 1));
                aVar2.f(jSONObject4.optInt("ie", 1));
                aVar2.h(jSONObject4.optInt("is", 1));
                aVar2.e(jSONObject4.optInt("ic", 1));
                aVar2.b(jSONObject4.optInt(ConstantHelper.LOG_BTM, 1));
                aVar2.i(jSONObject4.optInt("mc", 1));
                aVar2.l(jSONObject4.optInt("rp", 1));
                aVar2.n(jSONObject4.optInt("tc", 1));
                aVar2.g(jSONObject4.optInt("il", 1));
                bVar.a(aVar2);
                kVar.a(bVar);
                k.c cVar = new k.c();
                JSONObject jSONObject5 = jSONObject.getJSONObject("r");
                cVar.a(jSONObject5.optInt("rc", 4));
                cVar.c(jSONObject5.optInt("rs", 0));
                cVar.b(jSONObject5.optInt("ri", 6));
                kVar.a(cVar);
                return kVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (k) invokeL.objValue;
    }

    public static p b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            j a = a(jSONObject);
            if (a == null) {
                return null;
            }
            int e2 = a.e();
            String m = a.m();
            String l = a.l();
            boolean z = a.g() == 1;
            boolean z2 = a.j() == 1;
            int i2 = a.i();
            String f2 = a.f();
            String h2 = a.h();
            String b2 = a.b();
            PackageInfo packageInfo = new PackageInfo();
            try {
                packageInfo.packageName = h2;
                packageInfo.versionName = m;
                ApplicationInfo applicationInfo = new ApplicationInfo();
                if (!TextUtils.isEmpty(h2) && !TextUtils.isEmpty(b2) && b2.startsWith(".")) {
                    applicationInfo.name = h2 + b2;
                    applicationInfo.className = h2 + b2;
                }
                applicationInfo.theme = a.k();
                packageInfo.applicationInfo = applicationInfo;
                List<j.a> a2 = a.a();
                if (a2 != null && a2.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < a2.size(); i3++) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        activityInfo.name = a2.get(i3).a();
                        activityInfo.theme = a2.get(i3).c();
                        activityInfo.labelRes = a2.get(i3).b();
                        if (!TextUtils.isEmpty(activityInfo.name)) {
                            arrayList.add(activityInfo);
                        }
                    }
                    if (arrayList.size() > 0) {
                        packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                    }
                }
            } catch (Throwable th) {
                l1.a(th);
            }
            p pVar = new p(packageInfo, e2, h2, m, l, f2);
            pVar.w = z;
            pVar.y = i2;
            int a3 = a.c() == null ? 0 : a.c().a();
            int b3 = a.c() != null ? a.c().b() : -1;
            pVar.u = a3;
            pVar.v = b3;
            pVar.t = System.currentTimeMillis();
            pVar.z = (Build.VERSION.SDK_INT <= 29 || !z2) ? z2 : a.d() == 1;
            return pVar;
        }
        return (p) invokeL.objValue;
    }
}
