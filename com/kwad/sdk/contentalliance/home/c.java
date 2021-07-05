package com.kwad.sdk.contentalliance.home;

import androidx.annotation.MainThread;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f35174a;

    /* renamed from: b  reason: collision with root package name */
    public static List<AdTemplate> f35175b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-113361202, "Lcom/kwad/sdk/contentalliance/home/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-113361202, "Lcom/kwad/sdk/contentalliance/home/c;");
                return;
            }
        }
        f35175b = new ArrayList();
    }

    @MainThread
    public static void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            c();
            f35174a = System.currentTimeMillis();
            f35175b.addAll(list);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (System.currentTimeMillis() - f35174a > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                c();
                return false;
            }
            return !f35175b.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @MainThread
    public static List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f35175b : (List) invokeV.objValue;
    }

    @MainThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            f35175b.clear();
        }
    }
}
