package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class RtpSender {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MediaStreamTrack cachedTrack;
    @Nullable
    public final DtmfSender dtmfSender;
    public long nativeRtpSender;
    public boolean ownsTrack;

    public static native long nativeGetDtmfSender(long j);

    public static native String nativeGetId(long j);

    public static native RtpParameters nativeGetParameters(long j);

    public static native long nativeGetTrack(long j);

    public static native void nativeSetFrameEncryptor(long j, long j2);

    public static native boolean nativeSetParameters(long j, RtpParameters rtpParameters);

    public static native boolean nativeSetTrack(long j, long j2);

    public RtpSender(long j) {
        DtmfSender dtmfSender;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ownsTrack = true;
        this.nativeRtpSender = j;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j));
        long nativeGetDtmfSender = nativeGetDtmfSender(j);
        if (nativeGetDtmfSender != 0) {
            dtmfSender = new DtmfSender(nativeGetDtmfSender);
        } else {
            dtmfSender = null;
        }
        this.dtmfSender = dtmfSender;
    }

    private void checkRtpSenderExists() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || this.nativeRtpSender != 0) {
            return;
        }
        throw new IllegalStateException("RtpSender has been disposed.");
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            checkRtpSenderExists();
            DtmfSender dtmfSender = this.dtmfSender;
            if (dtmfSender != null) {
                dtmfSender.dispose();
            }
            MediaStreamTrack mediaStreamTrack = this.cachedTrack;
            if (mediaStreamTrack != null && this.ownsTrack) {
                mediaStreamTrack.dispose();
            }
            JniCommon.nativeReleaseRef(this.nativeRtpSender);
            this.nativeRtpSender = 0L;
        }
    }

    @Nullable
    public DtmfSender dtmf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dtmfSender;
        }
        return (DtmfSender) invokeV.objValue;
    }

    public long getNativeRtpSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkRtpSenderExists();
            return this.nativeRtpSender;
        }
        return invokeV.longValue;
    }

    public RtpParameters getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            checkRtpSenderExists();
            return nativeGetParameters(this.nativeRtpSender);
        }
        return (RtpParameters) invokeV.objValue;
    }

    public String id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            checkRtpSenderExists();
            return nativeGetId(this.nativeRtpSender);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public MediaStreamTrack track() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.cachedTrack;
        }
        return (MediaStreamTrack) invokeV.objValue;
    }

    public void setFrameEncryptor(FrameEncryptor frameEncryptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, frameEncryptor) == null) {
            checkRtpSenderExists();
            nativeSetFrameEncryptor(this.nativeRtpSender, frameEncryptor.getNativeFrameEncryptor());
        }
    }

    public boolean setParameters(RtpParameters rtpParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rtpParameters)) == null) {
            checkRtpSenderExists();
            return nativeSetParameters(this.nativeRtpSender, rtpParameters);
        }
        return invokeL.booleanValue;
    }

    public boolean setTrack(@Nullable MediaStreamTrack mediaStreamTrack, boolean z) {
        InterceptResult invokeLZ;
        long nativeMediaStreamTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, mediaStreamTrack, z)) == null) {
            checkRtpSenderExists();
            long j = this.nativeRtpSender;
            if (mediaStreamTrack == null) {
                nativeMediaStreamTrack = 0;
            } else {
                nativeMediaStreamTrack = mediaStreamTrack.getNativeMediaStreamTrack();
            }
            if (!nativeSetTrack(j, nativeMediaStreamTrack)) {
                return false;
            }
            MediaStreamTrack mediaStreamTrack2 = this.cachedTrack;
            if (mediaStreamTrack2 != null && this.ownsTrack) {
                mediaStreamTrack2.dispose();
            }
            this.cachedTrack = mediaStreamTrack;
            this.ownsTrack = z;
            return true;
        }
        return invokeLZ.booleanValue;
    }
}
