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
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class DataChannel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeDataChannel;
    public long nativeObserver;

    /* loaded from: classes2.dex */
    public static class Buffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean binary;
        public final ByteBuffer data;

        @CalledByNative("Buffer")
        public Buffer(ByteBuffer byteBuffer, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = byteBuffer;
            this.binary = z;
        }
    }

    /* loaded from: classes2.dex */
    public static class Init {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public int maxRetransmitTimeMs;
        public int maxRetransmits;
        public boolean negotiated;
        public boolean ordered;
        public String protocol;

        public Init() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ordered = true;
            this.maxRetransmitTimeMs = -1;
            this.maxRetransmits = -1;
            this.protocol = "";
            this.id = -1;
        }

        @CalledByNative("Init")
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.intValue;
        }

        @CalledByNative("Init")
        public int getMaxRetransmitTimeMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.maxRetransmitTimeMs : invokeV.intValue;
        }

        @CalledByNative("Init")
        public int getMaxRetransmits() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.maxRetransmits : invokeV.intValue;
        }

        @CalledByNative("Init")
        public boolean getNegotiated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.negotiated : invokeV.booleanValue;
        }

        @CalledByNative("Init")
        public boolean getOrdered() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ordered : invokeV.booleanValue;
        }

        @CalledByNative("Init")
        public String getProtocol() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.protocol : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onBufferedAmountChange(long j2);

        @CalledByNative("Observer")
        void onMessage(Buffer buffer);

        @CalledByNative("Observer")
        void onStateChange();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State CLOSED;
        public static final State CLOSING;
        public static final State CONNECTING;
        public static final State OPEN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(933008800, "Lorg/webrtc/DataChannel$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(933008800, "Lorg/webrtc/DataChannel$State;");
                    return;
                }
            }
            CONNECTING = new State("CONNECTING", 0);
            OPEN = new State("OPEN", 1);
            CLOSING = new State("CLOSING", 2);
            State state = new State("CLOSED", 3);
            CLOSED = state;
            $VALUES = new State[]{CONNECTING, OPEN, CLOSING, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @CalledByNative("State")
        public static State fromNativeIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? values()[i2] : (State) invokeI.objValue;
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    @CalledByNative
    public DataChannel(long j2) {
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
        this.nativeDataChannel = j2;
    }

    private void checkDataChannelExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.nativeDataChannel == 0) {
            throw new IllegalStateException("DataChannel has been disposed.");
        }
    }

    private native long nativeBufferedAmount();

    private native void nativeClose();

    private native int nativeId();

    private native String nativeLabel();

    private native long nativeRegisterObserver(Observer observer);

    private native boolean nativeSend(byte[] bArr, boolean z);

    private native State nativeState();

    private native void nativeUnregisterObserver(long j2);

    public long bufferedAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            checkDataChannelExists();
            return nativeBufferedAmount();
        }
        return invokeV.longValue;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            checkDataChannelExists();
            nativeClose();
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            checkDataChannelExists();
            JniCommon.nativeReleaseRef(this.nativeDataChannel);
            this.nativeDataChannel = 0L;
        }
    }

    @CalledByNative
    public long getNativeDataChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nativeDataChannel : invokeV.longValue;
    }

    public int id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            checkDataChannelExists();
            return nativeId();
        }
        return invokeV.intValue;
    }

    public String label() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            checkDataChannelExists();
            return nativeLabel();
        }
        return (String) invokeV.objValue;
    }

    public void registerObserver(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, observer) == null) {
            checkDataChannelExists();
            long j2 = this.nativeObserver;
            if (j2 != 0) {
                nativeUnregisterObserver(j2);
            }
            this.nativeObserver = nativeRegisterObserver(observer);
        }
    }

    public boolean send(Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, buffer)) == null) {
            checkDataChannelExists();
            byte[] bArr = new byte[buffer.data.remaining()];
            buffer.data.get(bArr);
            return nativeSend(bArr, buffer.binary);
        }
        return invokeL.booleanValue;
    }

    public State state() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            checkDataChannelExists();
            return nativeState();
        }
        return (State) invokeV.objValue;
    }

    public void unregisterObserver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            checkDataChannelExists();
            nativeUnregisterObserver(this.nativeObserver);
        }
    }
}
