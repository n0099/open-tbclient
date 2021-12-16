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
/* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
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

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public EncodedImage createEncodedImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp, null) : (EncodedImage) invokeV.objValue;
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
        public Builder setCaptureTimeMs(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j2);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setCaptureTimeNs(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.captureTimeNs = j2;
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

        public Builder setEncodedHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.encodedHeight = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setEncodedWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.encodedWidth = i2;
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

        public Builder setRotation(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.rotation = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class FrameType {
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

        public FrameType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeIndex = i3;
        }

        @CalledByNative("FrameType")
        public static FrameType fromNativeIndex(int i2) {
            InterceptResult invokeI;
            FrameType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (FrameType frameType : values()) {
                    if (frameType.getNative() == i2) {
                        return frameType;
                    }
                }
                throw new IllegalArgumentException("Unknown native frame type: " + i2);
            }
            return (FrameType) invokeI.objValue;
        }

        public static FrameType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FrameType) Enum.valueOf(FrameType.class, str) : (FrameType) invokeL.objValue;
        }

        public static FrameType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FrameType[]) $VALUES.clone() : (FrameType[]) invokeV.objValue;
        }

        public int getNative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nativeIndex : invokeV.intValue;
        }
    }

    public /* synthetic */ EncodedImage(ByteBuffer byteBuffer, int i2, int i3, long j2, FrameType frameType, int i4, boolean z, Integer num, AnonymousClass1 anonymousClass1) {
        this(byteBuffer, i2, i3, j2, frameType, i4, z, num);
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder(null) : (Builder) invokeV.objValue;
    }

    @CalledByNative
    public EncodedImage(ByteBuffer byteBuffer, int i2, int i3, long j2, FrameType frameType, int i4, boolean z, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), frameType, Integer.valueOf(i4), Boolean.valueOf(z), num};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = byteBuffer;
        this.encodedWidth = i2;
        this.encodedHeight = i3;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j2);
        this.captureTimeNs = j2;
        this.frameType = frameType;
        this.rotation = i4;
        this.completeFrame = z;
        this.qp = num;
    }
}
