package com.ss.android.socialbase.downloader.downloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.c;
/* loaded from: classes2.dex */
public class v implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v() {
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

    @Override // com.ss.android.socialbase.downloader.downloader.c.a
    public o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new com.ss.android.socialbase.downloader.impls.n() : (o) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.c.a
    public m b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new com.ss.android.socialbase.downloader.impls.o() : (m) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.c.a
    public t a(c.a.InterfaceC2131a interfaceC2131a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2131a)) == null) {
            com.ss.android.socialbase.downloader.b.f fVar = new com.ss.android.socialbase.downloader.b.f();
            fVar.a(interfaceC2131a);
            return fVar;
        }
        return (t) invokeL.objValue;
    }
}
