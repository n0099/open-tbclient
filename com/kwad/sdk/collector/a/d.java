package com.kwad.sdk.collector.a;

import android.content.Context;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f70925a;

    /* renamed from: b  reason: collision with root package name */
    public int f70926b;

    /* renamed from: c  reason: collision with root package name */
    public int f70927c;

    /* renamed from: d  reason: collision with root package name */
    public int f70928d;

    /* renamed from: e  reason: collision with root package name */
    public int f70929e;

    /* renamed from: f  reason: collision with root package name */
    public int f70930f;

    /* renamed from: g  reason: collision with root package name */
    public int f70931g;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70925a = 0;
        this.f70926b = 0;
        this.f70927c = 0;
        this.f70928d = 0;
        this.f70929e = 0;
        this.f70930f = 0;
        this.f70931g = 0;
        if (context != null) {
            d(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) ? z ? 1 : 2 : invokeZ.intValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f70925a = g(z);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f70926b = g(z);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f70927c = g(z);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f70929e = g(z);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f70930f = g(z);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f70931g = g(z);
        }
    }
}
