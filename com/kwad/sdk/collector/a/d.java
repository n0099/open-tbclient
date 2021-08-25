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
    public int f71125a;

    /* renamed from: b  reason: collision with root package name */
    public int f71126b;

    /* renamed from: c  reason: collision with root package name */
    public int f71127c;

    /* renamed from: d  reason: collision with root package name */
    public int f71128d;

    /* renamed from: e  reason: collision with root package name */
    public int f71129e;

    /* renamed from: f  reason: collision with root package name */
    public int f71130f;

    /* renamed from: g  reason: collision with root package name */
    public int f71131g;

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
        this.f71125a = 0;
        this.f71126b = 0;
        this.f71127c = 0;
        this.f71128d = 0;
        this.f71129e = 0;
        this.f71130f = 0;
        this.f71131g = 0;
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
            this.f71125a = g(z);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f71126b = g(z);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f71127c = g(z);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f71129e = g(z);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f71130f = g(z);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f71131g = g(z);
        }
    }
}
