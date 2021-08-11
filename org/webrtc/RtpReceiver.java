package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class RtpReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MediaStreamTrack cachedTrack;
    public long nativeObserver;
    public long nativeRtpReceiver;

    /* loaded from: classes2.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onFirstPacketReceived(MediaStreamTrack.MediaType mediaType);
    }

    @CalledByNative
    public RtpReceiver(long j2) {
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
        this.nativeRtpReceiver = j2;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j2));
    }

    private void checkRtpReceiverExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeRtpReceiver == 0) {
            throw new IllegalStateException("RtpReceiver has been disposed.");
        }
    }

    public static native String nativeGetId(long j2);

    public static native RtpParameters nativeGetParameters(long j2);

    public static native long nativeGetTrack(long j2);

    public static native void nativeSetFrameDecryptor(long j2, long j3);

    public static native long nativeSetObserver(long j2, Observer observer);

    public static native boolean nativeSetParameters(long j2, RtpParameters rtpParameters);

    public static native void nativeUnsetObserver(long j2, long j3);

    public void SetObserver(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            checkRtpReceiverExists();
            long j2 = this.nativeObserver;
            if (j2 != 0) {
                nativeUnsetObserver(this.nativeRtpReceiver, j2);
            }
            this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, observer);
        }
    }

    @CalledByNative
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            checkRtpReceiverExists();
            this.cachedTrack.dispose();
            long j2 = this.nativeObserver;
            if (j2 != 0) {
                nativeUnsetObserver(this.nativeRtpReceiver, j2);
                this.nativeObserver = 0L;
            }
            JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
            this.nativeRtpReceiver = 0L;
        }
    }

    public RtpParameters getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkRtpReceiverExists();
            return nativeGetParameters(this.nativeRtpReceiver);
        }
        return (RtpParameters) invokeV.objValue;
    }

    public String id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            checkRtpReceiverExists();
            return nativeGetId(this.nativeRtpReceiver);
        }
        return (String) invokeV.objValue;
    }

    public void setFrameDecryptor(FrameDecryptor frameDecryptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frameDecryptor) == null) {
            checkRtpReceiverExists();
            nativeSetFrameDecryptor(this.nativeRtpReceiver, frameDecryptor.getNativeFrameDecryptor());
        }
    }

    public boolean setParameters(@Nullable RtpParameters rtpParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rtpParameters)) == null) {
            checkRtpReceiverExists();
            if (rtpParameters == null) {
                return false;
            }
            return nativeSetParameters(this.nativeRtpReceiver, rtpParameters);
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public MediaStreamTrack track() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cachedTrack : (MediaStreamTrack) invokeV.objValue;
    }
}
