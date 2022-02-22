package com.duxiaoman.dxmpay.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.d.a.a.a.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import com.duxiaoman.dxmpay.statistics.internal.ISyncHttpImpl;
import com.duxiaoman.dxmpay.statistics.internal.LogSender;
import com.duxiaoman.dxmpay.statistics.internal.StatService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes3.dex */
public final class StatApi {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Context f53682d;
    public transient /* synthetic */ FieldHolder $fh;
    public IStatConfig a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53683b;

    /* renamed from: c  reason: collision with root package name */
    public ISyncHttpImpl f53684c;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static StatApi a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030417283, "Lcom/duxiaoman/dxmpay/statistics/StatApi$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2030417283, "Lcom/duxiaoman/dxmpay/statistics/StatApi$a;");
                    return;
                }
            }
            a = new StatApi(null);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ StatApi(b bVar) {
        this();
    }

    public static boolean cacheAppContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f53682d == null && context != null) {
                f53682d = context.getApplicationContext();
            }
            return f53682d != null;
        }
        return invokeL.booleanValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f53682d : (Context) invokeV.objValue;
    }

    public static StatApi getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.a : (StatApi) invokeV.objValue;
    }

    public static void init(Context context, IStatConfig iStatConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, iStatConfig) == null) {
            getInstance();
            if (!cacheAppContext(context) || iStatConfig == null) {
                return;
            }
            StatApi statApi = getInstance();
            statApi.a = iStatConfig;
            try {
                if (statApi.f53683b) {
                    return;
                }
                statApi.f53683b = true;
                e.a().e();
                LogSender.getInstance().triggerSending("normal_log");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void initData(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            cacheAppContext(context);
            e.a().e();
        }
    }

    public static void onBack(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, str) == null) && getInstance().f53683b && !getInstance().a()) {
            try {
                StatService.c(str, StatService.ETag.back, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && getInstance().f53683b && !getInstance().a()) {
            onEventWithValues(str, null, null, null);
        }
    }

    public static void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, str, i2) == null) {
            onEventEndWithValue(str, i2, null, null);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65550, null, str, i2, str2) == null) {
            onEventEndWithValue(str, i2, str2, null);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65554, null, str, i2, collection) == null) {
            onEventEndWithValues(str, i2, collection, null, null);
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, str) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, str, str2) == null) {
            onEventWithValue(str, str2, null);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65565, null, str, collection) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        onEventWithValues(str, collection, null, null);
    }

    public static void onIn(String str, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65569, null, str, j2) == null) && getInstance().f53683b && !getInstance().a()) {
            try {
                if (0 < j2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.toString(j2));
                    StatService.c(str, StatService.ETag.in, arrayList);
                } else {
                    StatService.c(str, StatService.ETag.in, null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void onOut(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65570, null, str) == null) && getInstance().f53683b && !getInstance().a()) {
            try {
                StatService.c(str, StatService.ETag.out, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void onPush(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65571, null, str) == null) && getInstance().f53683b && !getInstance().a()) {
            try {
                StatService.c(str, StatService.ETag.push, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setSyncHttpImpl(ISyncHttpImpl iSyncHttpImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, iSyncHttpImpl) == null) {
            getInstance().f53684c = iSyncHttpImpl;
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !StrategyProcess.getInstance().isDataItemEnable() : invokeV.booleanValue;
    }

    public ISyncHttpImpl getHttpImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53684c : (ISyncHttpImpl) invokeV.objValue;
    }

    public IStatConfig getSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (IStatConfig) invokeV.objValue;
    }

    public StatApi() {
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

    public static void onEventEnd(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, null, str, i2, str2) == null) {
            onEventEndWithValue(str, i2, null, str2);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65551, null, str, i2, str2, str3) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.e(str, Integer.toString(i2), str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65556, null, str, i2, collection, map) == null) {
            onEventEndWithValues(str, i2, collection, map, null);
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65564, null, str, str2, str3) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.d(str, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEventEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            onEventEndWithValue(str, null);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65555, null, str, i2, collection, str2) == null) {
            onEventEndWithValues(str, i2, collection, null, str2);
        }
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && getInstance().f53683b && !getInstance().a()) {
            onEventWithValues(str, (Collection<String>) null, str2);
        }
    }

    public static void onEventEnd(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            onEventEndWithValue(str, str2);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.k(str, Integer.toString(i2), collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65567, null, str, collection, map) == null) {
            onEventWithValues(str, collection, map, null);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, null, str, collection, str2) == null) {
            onEventWithValues(str, collection, null, str2);
        }
    }

    public static void onEventEndWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            onEventEndWithValue(str, str2, (String) null);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65568, null, str, collection, map, str2) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.g(str, null, collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEventEndWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65553, null, str, str2, str3) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.j(str, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, collection) == null) {
            onEventEndWithValues(str, collection, (Map<String, Object>) null, (String) null);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, str, collection, str2) == null) {
            onEventEndWithValues(str, collection, (Map<String, Object>) null, str2);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, str, collection, map) == null) {
            onEventEndWithValues(str, collection, map, (String) null);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65561, null, str, collection, map, str2) == null) || !getInstance().f53683b || getInstance().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.h(str, collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
