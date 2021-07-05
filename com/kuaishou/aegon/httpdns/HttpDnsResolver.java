package com.kuaishou.aegon.httpdns;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.aegon.Aegon;
import java.util.ArrayList;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class HttpDnsResolver {
    public static /* synthetic */ Interceptable $ic;
    public static a sLogger;
    public static Handler sLoggerHandler;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo);
    }

    public HttpDnsResolver() {
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

    public static void increasePriority(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, list) == null) && Aegon.isInitialized() && list != null) {
            Aegon.getCronetEngine();
            com.kuaishou.aegon.a.a.b(com.kuaishou.aegon.httpdns.a.a(list));
        }
    }

    public static native void nativeIncreasePriority(String[] strArr);

    public static native List<ResolvedIP> nativeResolve(String str);

    public static native void nativeSetJsonConfig(String str);

    @Keep
    public static void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, resolveFinishedInfo) == null) {
            synchronized (HttpDnsResolver.class) {
                if (sLogger != null && sLoggerHandler != null) {
                    sLoggerHandler.post(d.a(resolveFinishedInfo));
                }
            }
        }
    }

    public static List<ResolvedIP> resolve(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (Aegon.isInitialized()) {
                Aegon.getCronetEngine();
                List<ResolvedIP> list = (List) com.kuaishou.aegon.a.a.a(b.a(str));
                return list == null ? new ArrayList() : list;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public static void setLogger(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            synchronized (HttpDnsResolver.class) {
                sLogger = aVar;
                sLoggerHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    public static void updateConfig(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, str) == null) && Aegon.isInitialized()) {
            Aegon.getCronetEngine();
            com.kuaishou.aegon.a.a.b(c.a(str));
        }
    }
}
