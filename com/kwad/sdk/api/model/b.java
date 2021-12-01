package com.kwad.sdk.api.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f57036b;

    /* renamed from: c  reason: collision with root package name */
    public String f57037c;

    /* renamed from: d  reason: collision with root package name */
    public String f57038d;

    /* renamed from: e  reason: collision with root package name */
    public String f57039e;

    /* renamed from: f  reason: collision with root package name */
    public String f57040f;

    /* renamed from: g  reason: collision with root package name */
    public String f57041g;

    /* renamed from: h  reason: collision with root package name */
    public long f57042h;

    @Override // com.kwad.sdk.api.model.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57036b : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57037c : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57038d : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57039e : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57040f : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f57041g : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.model.a
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57042h : invokeV.longValue;
    }
}
