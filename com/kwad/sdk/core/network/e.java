package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.utils.n;
import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f34861a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-13782996, "Lcom/kwad/sdk/core/network/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-13782996, "Lcom/kwad/sdk/core/network/e;");
        }
    }

    public e() {
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

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (e.class) {
                if (f34861a == null) {
                    f34861a = new e();
                }
                eVar = f34861a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    @WorkerThread
    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            try {
                n.a(new File(d()), str, Charset.forName("UTF-8"), false);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }

    @Nullable
    @WorkerThread
    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                return n.a(new File(d()), Charset.forName("UTF-8"));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            return com.kwad.sdk.e.a(KsAdSDK.getContext()).getPath() + "/cookie";
        }
        return (String) invokeV.objValue;
    }

    @WorkerThread
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String c2 = c();
            if (c2 == null || !c2.equals(str)) {
                com.kwad.sdk.core.d.a.a("CookieStrHelper", "CookieStrHelper saveCookieString newCookieString=" + str);
                b(str);
            }
        }
    }

    @Nullable
    @WorkerThread
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = c();
            com.kwad.sdk.core.d.a.a("CookieStrHelper", "CookieStrHelper getCookieString cookieString=" + c2);
            return c2;
        }
        return (String) invokeV.objValue;
    }
}
