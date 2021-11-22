package com.kwad.sdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes2.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.kwad.sdk.core.download.b.b> f67647a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, com.kwad.sdk.core.webview.a.c> f67648b;

    public com.kwad.sdk.core.download.b.b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f67647a.get(str) : (com.kwad.sdk.core.download.b.b) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (com.kwad.sdk.core.download.b.b bVar : this.f67647a.values()) {
                bVar.g();
            }
            this.f67647a.clear();
            this.f67648b.clear();
        }
    }

    public void a(String str, com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f67647a.put(str, bVar);
        }
    }

    public void a(String str, com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            this.f67648b.put(str, cVar);
        }
    }

    public com.kwad.sdk.core.webview.a.c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f67648b.get(str) : (com.kwad.sdk.core.webview.a.c) invokeL.objValue;
    }
}
