package com.kwad.sdk.core.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, WeakReference<C0418a>> f34813a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0418a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HandlerThread f34814a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f34815b;

        public C0418a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HandlerThread";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.f34814a = handlerThread;
            handlerThread.start();
            this.f34815b = new Handler(this.f34814a.getLooper());
        }

        public Handler a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34815b : (Handler) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890101077, "Lcom/kwad/sdk/core/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890101077, "Lcom/kwad/sdk/core/i/a;");
                return;
            }
        }
        f34813a = new ConcurrentHashMap();
    }

    public static synchronized Handler a() {
        InterceptResult invokeV;
        Handler a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                a2 = a("commonHandlerThread").a();
            }
            return a2;
        }
        return (Handler) invokeV.objValue;
    }

    @NonNull
    public static C0418a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return new C0418a(null);
            }
            WeakReference<C0418a> weakReference = f34813a.get(str);
            if (weakReference == null || weakReference.get() == null) {
                C0418a c0418a = new C0418a(str);
                f34813a.put(str, new WeakReference<>(c0418a));
                return c0418a;
            }
            return weakReference.get();
        }
        return (C0418a) invokeL.objValue;
    }

    public static synchronized Handler b() {
        InterceptResult invokeV;
        Handler a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a.class) {
                a2 = a("reportHandlerThread").a();
            }
            return a2;
        }
        return (Handler) invokeV.objValue;
    }
}
