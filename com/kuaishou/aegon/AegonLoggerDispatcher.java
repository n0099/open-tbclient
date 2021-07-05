package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class AegonLoggerDispatcher {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<a> f34008a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f34009b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1140285225, "Lcom/kuaishou/aegon/AegonLoggerDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1140285225, "Lcom/kuaishou/aegon/AegonLoggerDispatcher;");
                return;
            }
        }
        f34008a = new ConcurrentLinkedQueue<>();
        f34009b = null;
    }

    public AegonLoggerDispatcher() {
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

    public static Executor a() {
        InterceptResult invokeV;
        Executor executor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Executor executor2 = f34009b;
            if (executor2 != null) {
                return executor2;
            }
            synchronized (AegonLoggerDispatcher.class) {
                if (f34009b == null) {
                    f34009b = Executors.newSingleThreadExecutor();
                }
                executor = f34009b;
            }
            return executor;
        }
        return (Executor) invokeV.objValue;
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            f34008a.add(aVar);
        }
    }

    public static void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, aVar) == null) {
            f34008a.remove(aVar);
        }
    }

    @Keep
    public static void onConnectionStats(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            Log.i("AegonLogger", str);
            if (f34008a.isEmpty()) {
                return;
            }
            Executor a2 = a();
            Iterator<a> it = f34008a.iterator();
            while (it.hasNext()) {
                a2.execute(b.a(it.next(), str));
            }
        }
    }

    @Keep
    public static void onRequestFinished(RequestFinishedInfo requestFinishedInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, requestFinishedInfo, str) == null) || f34008a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<a> it = f34008a.iterator();
        while (it.hasNext()) {
            a2.execute(c.a(it.next(), requestFinishedInfo, str));
        }
    }
}
