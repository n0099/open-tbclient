package com.google.ar.core;

import android.os.Bundle;
import c.i.c.a.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
/* loaded from: classes9.dex */
public final class u extends com.google.a.b.a.a.a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f70586a;

    public u(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70586a = oVar;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            int i2 = bundle.getInt("error.code", -100);
            if (i2 == -5) {
                this.f70586a.f34163f.a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
            } else if (i2 == -3) {
                this.f70586a.f34163f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
            } else if (i2 != 0) {
                StringBuilder sb = new StringBuilder(33);
                sb.append("requestInfo returned: ");
                sb.append(i2);
                sb.toString();
                this.f70586a.f34163f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
            } else {
                this.f70586a.f34163f.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
            }
        }
    }
}
