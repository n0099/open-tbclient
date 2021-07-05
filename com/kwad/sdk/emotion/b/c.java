package com.kwad.sdk.emotion.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.i;
/* loaded from: classes7.dex */
public abstract class c extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.kwai.filedownloader.i
    public void a(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, aVar, i2, i3) == null) {
        }
    }

    @Override // com.kwai.filedownloader.i
    public void a(com.kwai.filedownloader.a aVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, th) == null) {
        }
    }

    @Override // com.kwai.filedownloader.i
    public void b(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, aVar, i2, i3) == null) {
        }
    }

    @Override // com.kwai.filedownloader.i
    public void c(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, aVar, i2, i3) == null) {
        }
    }

    @Override // com.kwai.filedownloader.i
    public void d(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
        }
    }
}
