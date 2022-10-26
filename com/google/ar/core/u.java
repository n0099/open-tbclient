package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rs9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
/* loaded from: classes7.dex */
public final class u extends com.google.a.b.a.a.a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ rs9 a;

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

    public u(rs9 rs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rs9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rs9Var;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            int i = bundle.getInt("error.code", -100);
            if (i != -5) {
                if (i != -3) {
                    if (i != 0) {
                        StringBuilder sb = new StringBuilder(33);
                        sb.append("requestInfo returned: ");
                        sb.append(i);
                        Log.e("ARCore-InstallService", sb.toString());
                        this.a.b.a(ArCoreApk.Availability.UNKNOWN_ERROR);
                        return;
                    }
                    this.a.b.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                    return;
                }
                Log.e("ARCore-InstallService", "The Google Play application must be updated.");
                this.a.b.a(ArCoreApk.Availability.UNKNOWN_ERROR);
                return;
            }
            Log.e("ARCore-InstallService", "The device is not supported.");
            this.a.b.a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
        }
    }
}
