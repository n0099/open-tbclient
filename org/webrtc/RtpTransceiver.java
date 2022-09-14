package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class RtpTransceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RtpReceiver cachedReceiver;
    public RtpSender cachedSender;
    public long nativeRtpTransceiver;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class RtpTransceiverDirection {
        public static final /* synthetic */ RtpTransceiverDirection[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtpTransceiverDirection INACTIVE;
        public static final RtpTransceiverDirection RECV_ONLY;
        public static final RtpTransceiverDirection SEND_ONLY;
        public static final RtpTransceiverDirection SEND_RECV;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeIndex;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(376351861, "Lorg/webrtc/RtpTransceiver$RtpTransceiverDirection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(376351861, "Lorg/webrtc/RtpTransceiver$RtpTransceiverDirection;");
                    return;
                }
            }
            SEND_RECV = new RtpTransceiverDirection("SEND_RECV", 0, 0);
            SEND_ONLY = new RtpTransceiverDirection("SEND_ONLY", 1, 1);
            RECV_ONLY = new RtpTransceiverDirection("RECV_ONLY", 2, 2);
            RtpTransceiverDirection rtpTransceiverDirection = new RtpTransceiverDirection("INACTIVE", 3, 3);
            INACTIVE = rtpTransceiverDirection;
            $VALUES = new RtpTransceiverDirection[]{SEND_RECV, SEND_ONLY, RECV_ONLY, rtpTransceiverDirection};
        }

        public RtpTransceiverDirection(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeIndex = i2;
        }

        @CalledByNative("RtpTransceiverDirection")
        public static RtpTransceiverDirection fromNativeIndex(int i) {
            InterceptResult invokeI;
            RtpTransceiverDirection[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (RtpTransceiverDirection rtpTransceiverDirection : values()) {
                    if (rtpTransceiverDirection.getNativeIndex() == i) {
                        return rtpTransceiverDirection;
                    }
                }
                throw new IllegalArgumentException("Uknown native RtpTransceiverDirection type" + i);
            }
            return (RtpTransceiverDirection) invokeI.objValue;
        }

        public static RtpTransceiverDirection valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (RtpTransceiverDirection) Enum.valueOf(RtpTransceiverDirection.class, str) : (RtpTransceiverDirection) invokeL.objValue;
        }

        public static RtpTransceiverDirection[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (RtpTransceiverDirection[]) $VALUES.clone() : (RtpTransceiverDirection[]) invokeV.objValue;
        }

        @CalledByNative("RtpTransceiverDirection")
        public int getNativeIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nativeIndex : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class RtpTransceiverInit {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RtpTransceiverDirection direction;
        public final List<String> streamIds;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RtpTransceiverInit() {
            this(RtpTransceiverDirection.SEND_RECV);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((RtpTransceiverDirection) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @CalledByNative("RtpTransceiverInit")
        public int getDirectionNativeIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.direction.getNativeIndex() : invokeV.intValue;
        }

        @CalledByNative("RtpTransceiverInit")
        public List<String> getStreamIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ArrayList(this.streamIds) : (List) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection) {
            this(rtpTransceiverDirection, Collections.emptyList());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rtpTransceiverDirection};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((RtpTransceiverDirection) objArr2[0], (List) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rtpTransceiverDirection, list};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.direction = rtpTransceiverDirection;
            this.streamIds = new ArrayList(list);
        }
    }

    @CalledByNative
    public RtpTransceiver(long j) {
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
        this.nativeRtpTransceiver = j;
        this.cachedSender = nativeGetSender(j);
        this.cachedReceiver = nativeGetReceiver(j);
    }

    private void checkRtpTransceiverExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeRtpTransceiver == 0) {
            throw new IllegalStateException("RtpTransceiver has been disposed.");
        }
    }

    public static native RtpTransceiverDirection nativeCurrentDirection(long j);

    public static native RtpTransceiverDirection nativeDirection(long j);

    public static native MediaStreamTrack.MediaType nativeGetMediaType(long j);

    public static native String nativeGetMid(long j);

    public static native RtpReceiver nativeGetReceiver(long j);

    public static native RtpSender nativeGetSender(long j);

    public static native void nativeSetDirection(long j, RtpTransceiverDirection rtpTransceiverDirection);

    public static native void nativeStop(long j);

    public static native boolean nativeStopped(long j);

    @CalledByNative
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            checkRtpTransceiverExists();
            this.cachedSender.dispose();
            this.cachedReceiver.dispose();
            JniCommon.nativeReleaseRef(this.nativeRtpTransceiver);
            this.nativeRtpTransceiver = 0L;
        }
    }

    public RtpTransceiverDirection getCurrentDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            checkRtpTransceiverExists();
            return nativeCurrentDirection(this.nativeRtpTransceiver);
        }
        return (RtpTransceiverDirection) invokeV.objValue;
    }

    public RtpTransceiverDirection getDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkRtpTransceiverExists();
            return nativeDirection(this.nativeRtpTransceiver);
        }
        return (RtpTransceiverDirection) invokeV.objValue;
    }

    public MediaStreamTrack.MediaType getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            checkRtpTransceiverExists();
            return nativeGetMediaType(this.nativeRtpTransceiver);
        }
        return (MediaStreamTrack.MediaType) invokeV.objValue;
    }

    public String getMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            checkRtpTransceiverExists();
            return nativeGetMid(this.nativeRtpTransceiver);
        }
        return (String) invokeV.objValue;
    }

    public RtpReceiver getReceiver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cachedReceiver : (RtpReceiver) invokeV.objValue;
    }

    public RtpSender getSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cachedSender : (RtpSender) invokeV.objValue;
    }

    public boolean isStopped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            checkRtpTransceiverExists();
            return nativeStopped(this.nativeRtpTransceiver);
        }
        return invokeV.booleanValue;
    }

    public void setDirection(RtpTransceiverDirection rtpTransceiverDirection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rtpTransceiverDirection) == null) {
            checkRtpTransceiverExists();
            nativeSetDirection(this.nativeRtpTransceiver, rtpTransceiverDirection);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            checkRtpTransceiverExists();
            nativeStop(this.nativeRtpTransceiver);
        }
    }
}
