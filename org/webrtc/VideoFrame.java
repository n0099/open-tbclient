package org.webrtc;

import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class VideoFrame implements RefCounted {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public final int rotation;
    public final long timestampNs;

    /* loaded from: classes3.dex */
    public interface Buffer extends RefCounted {
        @CalledByNative("Buffer")
        Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7);

        @CalledByNative("Buffer")
        int getHeight();

        @CalledByNative("Buffer")
        int getWidth();

        @Override // org.webrtc.RefCounted
        @CalledByNative("Buffer")
        void release();

        @Override // org.webrtc.RefCounted
        @CalledByNative("Buffer")
        void retain();

        @CalledByNative("Buffer")
        I420Buffer toI420();
    }

    /* loaded from: classes3.dex */
    public interface I420Buffer extends Buffer {
        @CalledByNative("I420Buffer")
        ByteBuffer getDataU();

        @CalledByNative("I420Buffer")
        ByteBuffer getDataV();

        @CalledByNative("I420Buffer")
        ByteBuffer getDataY();

        @CalledByNative("I420Buffer")
        int getStrideU();

        @CalledByNative("I420Buffer")
        int getStrideV();

        @CalledByNative("I420Buffer")
        int getStrideY();
    }

    /* loaded from: classes3.dex */
    public interface TextureBuffer extends Buffer {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes3.dex */
        public static final class Type {
            public static final /* synthetic */ Type[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final Type OES;
            public static final Type RGB;
            public transient /* synthetic */ FieldHolder $fh;
            public final int glTarget;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-748265583, "Lorg/webrtc/VideoFrame$TextureBuffer$Type;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-748265583, "Lorg/webrtc/VideoFrame$TextureBuffer$Type;");
                        return;
                    }
                }
                OES = new Type("OES", 0, 36197);
                Type type = new Type("RGB", 1, 3553);
                RGB = type;
                $VALUES = new Type[]{OES, type};
            }

            public Type(String str, int i2, int i3) {
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
                this.glTarget = i3;
            }

            public static Type valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
            }

            public static Type[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
            }

            public int getGlTarget() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.glTarget : invokeV.intValue;
            }
        }

        int getTextureId();

        Matrix getTransformMatrix();

        Type getType();
    }

    @CalledByNative
    public VideoFrame(Buffer buffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer, Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (buffer != null) {
            if (i2 % 90 == 0) {
                this.buffer = buffer;
                this.rotation = i2;
                this.timestampNs = j;
                return;
            }
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        throw new IllegalArgumentException("buffer not allowed to be null");
    }

    @CalledByNative
    public Buffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.buffer : (Buffer) invokeV.objValue;
    }

    public int getRotatedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.rotation % 180 == 0) {
                return this.buffer.getHeight();
            }
            return this.buffer.getWidth();
        }
        return invokeV.intValue;
    }

    public int getRotatedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.rotation % 180 == 0) {
                return this.buffer.getWidth();
            }
            return this.buffer.getHeight();
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public int getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rotation : invokeV.intValue;
    }

    @CalledByNative
    public long getTimestampNs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.timestampNs : invokeV.longValue;
    }

    @Override // org.webrtc.RefCounted
    @CalledByNative
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.buffer.release();
        }
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.buffer.retain();
        }
    }
}
