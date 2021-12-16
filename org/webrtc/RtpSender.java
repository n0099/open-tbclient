package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class RtpSender {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MediaStreamTrack cachedTrack;
    @Nullable
    public final DtmfSender dtmfSender;
    public long nativeRtpSender;
    public boolean ownsTrack;

    @CalledByNative
    public RtpSender(long j2) {
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
        this.ownsTrack = true;
        this.nativeRtpSender = j2;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j2));
        long nativeGetDtmfSender = nativeGetDtmfSender(j2);
        this.dtmfSender = nativeGetDtmfSender != 0 ? new DtmfSender(nativeGetDtmfSender) : null;
    }

    private void checkRtpSenderExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeRtpSender == 0) {
            throw new IllegalStateException("RtpSender has been disposed.");
        }
    }

    public static native long nativeGetDtmfSender(long j2);

    public static native String nativeGetId(long j2);

    public static native RtpParameters nativeGetParameters(long j2);

    public static native long nativeGetTrack(long j2);

    public static native void nativeSetFrameEncryptor(long j2, long j3);

    public static native boolean nativeSetParameters(long j2, RtpParameters rtpParameters);

    public static native boolean nativeSetTrack(long j2, long j3);

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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dtmfSender : (DtmfSender) invokeV.objValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, mediaStreamTrack, z)) == null) {
            checkRtpSenderExists();
            if (nativeSetTrack(this.nativeRtpSender, mediaStreamTrack == null ? 0L : mediaStreamTrack.getNativeMediaStreamTrack())) {
                MediaStreamTrack mediaStreamTrack2 = this.cachedTrack;
                if (mediaStreamTrack2 != null && this.ownsTrack) {
                    mediaStreamTrack2.dispose();
                }
                this.cachedTrack = mediaStreamTrack;
                this.ownsTrack = z;
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    @Nullable
    public MediaStreamTrack track() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.cachedTrack : (MediaStreamTrack) invokeV.objValue;
    }
}
