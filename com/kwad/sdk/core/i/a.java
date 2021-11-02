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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, WeakReference<C1905a>> f64752a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1905a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HandlerThread f64753a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f64754b;

        public C1905a(String str) {
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
            this.f64753a = handlerThread;
            handlerThread.start();
            this.f64754b = new Handler(this.f64753a.getLooper());
        }

        public Handler a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64754b : (Handler) invokeV.objValue;
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
        f64752a = new ConcurrentHashMap();
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
    public static C1905a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return new C1905a(null);
            }
            WeakReference<C1905a> weakReference = f64752a.get(str);
            if (weakReference == null || weakReference.get() == null) {
                C1905a c1905a = new C1905a(str);
                f64752a.put(str, new WeakReference<>(c1905a));
                return c1905a;
            }
            return weakReference.get();
        }
        return (C1905a) invokeL.objValue;
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
