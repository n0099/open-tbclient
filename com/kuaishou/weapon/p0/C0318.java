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
import com.kuaishou.weapon.p0.C0349;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0318 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0318() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0349 m225(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                C0349 c0349 = new C0349();
                c0349.m325(jSONObject.optInt("wk"));
                c0349.m322(jSONObject.optString("wan"));
                c0349.m326(jSONObject.optString("wm"));
                c0349.m328(jSONObject.optInt("wo"));
                c0349.m331(jSONObject.optInt("wpr"));
                c0349.m329(jSONObject.optString(C0453.f715));
                c0349.m334(jSONObject.optInt("ws", 1));
                c0349.m320(jSONObject.optInt("wh", 0));
                c0349.m337(jSONObject.optInt("wt"));
                c0349.m332(jSONObject.optString("wu"));
                c0349.m335(jSONObject.optString("wv"));
                JSONArray jSONArray = jSONObject.getJSONArray("wa");
                ArrayList arrayList = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    C0349.C0350 c0350 = new C0349.C0350();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    c0350.m346(jSONObject2.optInt("r"));
                    c0350.m349(jSONObject2.optInt("t"));
                    c0350.m347(jSONObject2.getString("n"));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0350);
                }
                c0349.m323(arrayList);
                C0349.C0351 c0351 = new C0349.C0351();
                JSONObject jSONObject3 = jSONObject.getJSONObject("we");
                c0351.m352(jSONObject3.optInt("duration"));
                c0351.m354(jSONObject3.optInt("network"));
                c0349.m321(c0351);
                return c0349;
            } catch (Exception unused) {
                return null;
            }
        }
        return (C0349) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static C0398 m226(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            C0349 m225 = m225(jSONObject);
            if (m225 == null) {
                return null;
            }
            int m333 = m225.m333();
            String m344 = m225.m344();
            String m343 = m225.m343();
            boolean z = true;
            boolean z2 = m225.m338() == 1;
            boolean z3 = m225.m341() == 1;
            int m340 = m225.m340();
            String m336 = m225.m336();
            String m339 = m225.m339();
            String m324 = m225.m324();
            PackageInfo packageInfo = new PackageInfo();
            try {
                packageInfo.packageName = m339;
                packageInfo.versionName = m344;
                ApplicationInfo applicationInfo = new ApplicationInfo();
                if (!TextUtils.isEmpty(m339) && !TextUtils.isEmpty(m324) && m324.startsWith(".")) {
                    applicationInfo.name = m339 + m324;
                    applicationInfo.className = m339 + m324;
                }
                applicationInfo.theme = m225.m342();
                packageInfo.applicationInfo = applicationInfo;
                List<C0349.C0350> m319 = m225.m319();
                if (m319 != null && m319.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < m319.size(); i++) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        activityInfo.name = m319.get(i).m345();
                        activityInfo.theme = m319.get(i).m350();
                        activityInfo.labelRes = m319.get(i).m348();
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
            C0398 c0398 = new C0398(packageInfo, m333, m339, m344, m343, m336);
            c0398.f398 = z2;
            c0398.f400 = m340;
            int m351 = m225.m327() != null ? m225.m327().m351() : 0;
            int m353 = m225.m327() != null ? m225.m327().m353() : -1;
            c0398.f396 = m351;
            c0398.f397 = m353;
            c0398.f395 = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT <= 29 || !z3) {
                z = z3;
            } else if (m225.m330() != 1) {
                z = false;
            }
            c0398.f401 = z;
            return c0398;
        }
        return (C0398) invokeL.objValue;
    }
}
