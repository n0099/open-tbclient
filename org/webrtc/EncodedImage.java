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
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class EncodedImage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;
    public final Integer qp;
    public final int rotation;

    /* renamed from: org.webrtc.EncodedImage$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer buffer;
        public long captureTimeNs;
        public boolean completeFrame;
        public int encodedHeight;
        public int encodedWidth;
        public FrameType frameType;
        public Integer qp;
        public int rotation;

        public Builder() {
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

        public EncodedImage createEncodedImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp, null);
            }
            return (EncodedImage) invokeV.objValue;
        }

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder setBuffer(ByteBuffer byteBuffer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
                this.buffer = byteBuffer;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setCaptureTimeNs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.captureTimeNs = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setCompleteFrame(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.completeFrame = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEncodedHeight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.encodedHeight = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setEncodedWidth(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.encodedWidth = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFrameType(FrameType frameType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, frameType)) == null) {
                this.frameType = frameType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setQp(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, num)) == null) {
                this.qp = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRotation(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.rotation = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class FrameType {
        public static final /* synthetic */ FrameType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FrameType EmptyFrame;
        public static final FrameType VideoFrameDelta;
        public static final FrameType VideoFrameKey;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeIndex;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1131145024, "Lorg/webrtc/EncodedImage$FrameType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1131145024, "Lorg/webrtc/EncodedImage$FrameType;");
                    return;
                }
            }
            EmptyFrame = new FrameType("EmptyFrame", 0, 0);
            VideoFrameKey = new FrameType("VideoFrameKey", 1, 3);
            FrameType frameType = new FrameType("VideoFrameDelta", 2, 4);
            VideoFrameDelta = frameType;
            $VALUES = new FrameType[]{EmptyFrame, VideoFrameKey, frameType};
        }

        public FrameType(String str, int i, int i2) {
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

        public static FrameType fromNativeIndex(int i) {
            InterceptResult invokeI;
            FrameType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (FrameType frameType : values()) {
                    if (frameType.getNative() == i) {
                        return frameType;
                    }
                }
                throw new IllegalArgumentException("Unknown native frame type: " + i);
            }
            return (FrameType) invokeI.objValue;
        }

        public static FrameType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (FrameType) Enum.valueOf(FrameType.class, str);
            }
            return (FrameType) invokeL.objValue;
        }

        public static FrameType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (FrameType[]) $VALUES.clone();
            }
            return (FrameType[]) invokeV.objValue;
        }

        public int getNative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.nativeIndex;
            }
            return invokeV.intValue;
        }
    }

    public EncodedImage(ByteBuffer byteBuffer, int i, int i2, long j, FrameType frameType, int i3, boolean z, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), frameType, Integer.valueOf(i3), Boolean.valueOf(z), num};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = byteBuffer;
        this.encodedWidth = i;
        this.encodedHeight = i2;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j);
        this.captureTimeNs = j;
        this.frameType = frameType;
        this.rotation = i3;
        this.completeFrame = z;
        this.qp = num;
    }

    public /* synthetic */ EncodedImage(ByteBuffer byteBuffer, int i, int i2, long j, FrameType frameType, int i3, boolean z, Integer num, AnonymousClass1 anonymousClass1) {
        this(byteBuffer, i, i2, j, frameType, i3, z, num);
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new Builder(null);
        }
        return (Builder) invokeV.objValue;
    }
}
