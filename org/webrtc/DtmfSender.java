package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DtmfSender {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeDtmfSender;

    public DtmfSender(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nativeDtmfSender = j2;
    }

    private void checkDtmfSenderExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeDtmfSender == 0) {
            throw new IllegalStateException("DtmfSender has been disposed.");
        }
    }

    public static native boolean nativeCanInsertDtmf(long j2);

    public static native int nativeDuration(long j2);

    public static native boolean nativeInsertDtmf(long j2, String str, int i2, int i3);

    public static native int nativeInterToneGap(long j2);

    public static native String nativeTones(long j2);

    public boolean canInsertDtmf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            checkDtmfSenderExists();
            return nativeCanInsertDtmf(this.nativeDtmfSender);
        }
        return invokeV.booleanValue;
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            checkDtmfSenderExists();
            JniCommon.nativeReleaseRef(this.nativeDtmfSender);
            this.nativeDtmfSender = 0L;
        }
    }

    public int duration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkDtmfSenderExists();
            return nativeDuration(this.nativeDtmfSender);
        }
        return invokeV.intValue;
    }

    public boolean insertDtmf(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, str, i2, i3)) == null) {
            checkDtmfSenderExists();
            return nativeInsertDtmf(this.nativeDtmfSender, str, i2, i3);
        }
        return invokeLII.booleanValue;
    }

    public int interToneGap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            checkDtmfSenderExists();
            return nativeInterToneGap(this.nativeDtmfSender);
        }
        return invokeV.intValue;
    }

    public String tones() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            checkDtmfSenderExists();
            return nativeTones(this.nativeDtmfSender);
        }
        return (String) invokeV.objValue;
    }
}
