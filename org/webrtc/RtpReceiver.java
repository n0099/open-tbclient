package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class RtpReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MediaStreamTrack cachedTrack;
    public long nativeObserver;
    public long nativeRtpReceiver;

    /* loaded from: classes9.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onFirstPacketReceived(MediaStreamTrack.MediaType mediaType);
    }

    public static native String nativeGetId(long j);

    public static native RtpParameters nativeGetParameters(long j);

    public static native long nativeGetTrack(long j);

    public static native void nativeSetFrameDecryptor(long j, long j2);

    public static native long nativeSetObserver(long j, Observer observer);

    public static native boolean nativeSetParameters(long j, RtpParameters rtpParameters);

    public static native void nativeUnsetObserver(long j, long j2);

    @CalledByNative
    public RtpReceiver(long j) {
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
        this.nativeRtpReceiver = j;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j));
    }

    private void checkRtpReceiverExists() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || this.nativeRtpReceiver != 0) {
            return;
        }
        throw new IllegalStateException("RtpReceiver has been disposed.");
    }

    @CalledByNative
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            checkRtpReceiverExists();
            this.cachedTrack.dispose();
            long j = this.nativeObserver;
            if (j != 0) {
                nativeUnsetObserver(this.nativeRtpReceiver, j);
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

    @Nullable
    public MediaStreamTrack track() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.cachedTrack;
        }
        return (MediaStreamTrack) invokeV.objValue;
    }

    public void SetObserver(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            checkRtpReceiverExists();
            long j = this.nativeObserver;
            if (j != 0) {
                nativeUnsetObserver(this.nativeRtpReceiver, j);
            }
            this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, observer);
        }
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
}
