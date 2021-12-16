package com.kwad.sdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes3.dex */
public class ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, com.kwad.sdk.core.download.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, com.kwad.sdk.core.webview.kwai.c> f60175b;

    public com.kwad.sdk.core.download.a.b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (com.kwad.sdk.core.download.a.b) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (com.kwad.sdk.core.download.a.b bVar : this.a.values()) {
                bVar.j();
            }
            this.a.clear();
            this.f60175b.clear();
        }
    }

    public void a(String str, com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.a.put(str, bVar);
        }
    }

    public void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            this.f60175b.put(str, cVar);
        }
    }

    public com.kwad.sdk.core.webview.kwai.c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f60175b.get(str) : (com.kwad.sdk.core.webview.kwai.c) invokeL.objValue;
    }
}
