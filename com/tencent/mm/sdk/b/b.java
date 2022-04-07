package com.tencent.mm.sdk.b;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.b.a;
/* loaded from: classes8.dex */
public final class b implements a.InterfaceC0649a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0649a
    public final int b() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i = a.level;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0649a
    public final void d(String str, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            i = a.level;
            if (i <= 2) {
                Log.i(str, str2);
            }
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0649a
    public final void e(String str, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            i = a.level;
            if (i <= 1) {
                Log.d(str, str2);
            }
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0649a
    public final void f(String str, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            i = a.level;
            if (i <= 4) {
                Log.e(str, str2);
            }
        }
    }
}
