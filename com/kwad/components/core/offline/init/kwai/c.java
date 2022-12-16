package com.kwad.components.core.offline.init.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.IEncrypt;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class c implements IEncrypt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileMD5(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? com.kwad.sdk.utils.a.getFileMD5(file) : (String) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final byte[] getFileMD5Digest(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            try {
                return com.kwad.sdk.utils.a.getFileMD5Digest(file);
            } catch (IOException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getResponseData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? com.kwad.sdk.core.a.d.getResponseData(str) : (String) invokeL.objValue;
    }
}
