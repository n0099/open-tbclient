package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f58643b;

    /* renamed from: c  reason: collision with root package name */
    public String f58644c;

    /* renamed from: d  reason: collision with root package name */
    public String f58645d;

    /* renamed from: e  reason: collision with root package name */
    public String f58646e;

    /* renamed from: f  reason: collision with root package name */
    public String f58647f;

    /* renamed from: g  reason: collision with root package name */
    public String f58648g;

    /* renamed from: h  reason: collision with root package name */
    public long f58649h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a == 0 && this.f58643b == 0 && TextUtils.isEmpty(this.f58644c) : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f58645d) && TextUtils.isEmpty(this.f58646e) && TextUtils.isEmpty(this.f58648g) && TextUtils.isEmpty(this.f58647f) : invokeV.booleanValue;
    }
}
