package com.google.android.exoplayer2.drm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ErrorStateDrmSession implements DrmSession {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DrmSession.DrmSessionException error;

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public ExoMediaCrypto getMediaCrypto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (ExoMediaCrypto) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map queryKeyStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drmSessionException};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.error;
        }
        return (DrmSession.DrmSessionException) invokeV.objValue;
    }
}
