package com.kwad.components.core.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f Dx;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, WeakReference<Object>> Dw;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Dw = new ConcurrentHashMap<>();
    }

    public static String J(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            long bJ = com.kwad.sdk.core.response.a.d.bJ(adTemplate);
            long ca = com.kwad.sdk.core.response.a.d.ca(adTemplate);
            return bJ + "-" + ca;
        }
        return (String) invokeL.objValue;
    }

    public static String b(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            String mc = gVar.mc();
            String mi = gVar.mi();
            return mc + "-" + mi;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static f mb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Dx == null) {
                synchronized (f.class) {
                    if (Dx == null) {
                        Dx = new f();
                    }
                }
            }
            return Dx;
        }
        return (f) invokeV.objValue;
    }

    public final void I(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            this.Dw.remove(J(adTemplate));
        }
    }

    public final boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) {
            String b = b(gVar);
            com.kwad.sdk.core.e.b.d("AdMemCachePool", "contains key: " + b);
            boolean z = false;
            if (this.Dw.containsKey(b)) {
                WeakReference<Object> weakReference = this.Dw.get(b);
                if (weakReference != null && weakReference.get() != null) {
                    z = true;
                }
                if (z) {
                    com.kwad.sdk.core.e.b.d("AdMemCachePool", "contains ad: " + weakReference.get());
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void add(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (obj instanceof com.kwad.components.core.internal.api.a)) {
            this.Dw.put(J(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }
}
