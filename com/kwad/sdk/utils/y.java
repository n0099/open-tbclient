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
    public Map<String, com.kwad.sdk.core.download.b.b> f66735a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, com.kwad.sdk.core.webview.a.c> f66736b;

    public com.kwad.sdk.core.download.b.b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f66735a.get(str) : (com.kwad.sdk.core.download.b.b) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (com.kwad.sdk.core.download.b.b bVar : this.f66735a.values()) {
                bVar.g();
            }
            this.f66735a.clear();
            this.f66736b.clear();
        }
    }

    public void a(String str, com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            this.f66735a.put(str, bVar);
        }
    }

    public void a(String str, com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            this.f66736b.put(str, cVar);
        }
    }

    public com.kwad.sdk.core.webview.a.c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f66736b.get(str) : (com.kwad.sdk.core.webview.a.c) invokeL.objValue;
    }
}
