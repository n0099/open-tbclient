package com.kwad.sdk.core.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.request.model.TaskStat;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;

    /* renamed from: b  reason: collision with root package name */
    public static SimpleDateFormat f57806b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889922331, "Lcom/kwad/sdk/core/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1889922331, "Lcom/kwad/sdk/core/c/a;");
                return;
            }
        }
        f57806b = new SimpleDateFormat("yyyy-MM-dd");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        }
        return (String) invokeL.objValue;
    }

    public static void a(String str, String str2) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static List<TaskStat> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (KsAdSDKImpl.get().getContext() == null) {
                return null;
            }
            d();
            String a2 = a("ksadsdk_local_ad_task_info_adstyle_data");
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(a2);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    TaskStat taskStat = new TaskStat();
                    taskStat.parseJson(jSONObject);
                    arrayList.add(taskStat);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static void b(AdTemplate adTemplate) {
        TaskStat taskStat;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, adTemplate) == null) {
            int w = d.w(adTemplate);
            int t = d.t(adTemplate);
            List b2 = b();
            if (b2 != null && b2.size() != 0) {
                boolean z = false;
                Iterator it = b2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TaskStat taskStat2 = (TaskStat) it.next();
                    if (taskStat2.adStyle == t && taskStat2.taskType == w) {
                        taskStat2.count++;
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    taskStat = new TaskStat(t, w, 1);
                }
                a("ksadsdk_local_ad_task_info_adstyle_data", t.b(b2).toString());
            }
            b2 = new ArrayList();
            taskStat = new TaskStat(t, w, 1);
            b2.add(taskStat);
            a("ksadsdk_local_ad_task_info_adstyle_data", t.b(b2).toString());
        }
    }

    public static void c() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().clear().apply();
    }

    public static void d() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        long j2 = context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("ksadsdk_local_ad_task_info_date", -1L);
        if (j2 > 0 && !f57806b.format(new Date(j2)).equals(f57806b.format(new Date()))) {
            c();
        }
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            d();
            b(adTemplate);
        }
    }
}
