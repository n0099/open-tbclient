package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class FrameSequence implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean ISLOADED;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDefaultLoopCount;
    public int mFrameCount;
    public int mHeight;
    public long mNativeFrameSequence;
    public boolean mOpaque;
    public int mWidth;

    /* loaded from: classes3.dex */
    public static class State implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mNativeState;

        public State(long j2) {
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
            this.mNativeState = j2;
        }

        public void destroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j2 = this.mNativeState;
                if (j2 != 0) {
                    FrameSequence.nativeDestroyState(j2);
                    this.mNativeState = 0L;
                }
            }
        }

        public long getFrame(int i2, Bitmap bitmap, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bitmap, Integer.valueOf(i3)})) == null) {
                if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                    throw new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
                }
                long j2 = this.mNativeState;
                if (j2 != 0) {
                    return FrameSequence.nativeGetFrame(j2, i2, bitmap, i3);
                }
                throw new IllegalStateException("attempted to draw destroyed FrameSequenceState");
            }
            return invokeCommon.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1724892179, "Lcom/kwad/sdk/glide/framesequence/FrameSequence;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1724892179, "Lcom/kwad/sdk/glide/framesequence/FrameSequence;");
                return;
            }
        }
        ISLOADED = new AtomicBoolean(false);
        try {
            System.loadLibrary("framesequencev2");
            ISLOADED.set(true);
        } catch (Throwable unused) {
            ISLOADED.set(false);
        }
    }

    public FrameSequence() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public FrameSequence(long j2, int i2, int i3, boolean z, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mNativeFrameSequence = j2;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mOpaque = z;
        this.mFrameCount = i4;
        this.mDefaultLoopCount = i5;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (ISLOADED.get()) {
                return decodeByteArray(bArr, 0, bArr.length);
            }
            return null;
        }
        return (FrameSequence) invokeL.objValue;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i2, i3)) == null) {
            if (ISLOADED.get()) {
                if (bArr != null) {
                    if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
                        throw new IllegalArgumentException("invalid offset/length parameters");
                    }
                    return nativeDecodeByteArray(bArr, i2, i3);
                }
                throw new IllegalArgumentException();
            }
            return null;
        }
        return (FrameSequence) invokeLII.objValue;
    }

    @Nullable
    public static FrameSequence decodeByteBuffer(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            if (ISLOADED.get()) {
                if (byteBuffer != null) {
                    if (byteBuffer.isDirect()) {
                        return nativeDecodeByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
                    }
                    if (byteBuffer.hasArray()) {
                        return decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                    }
                    throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
                }
                throw new IllegalArgumentException();
            }
            return null;
        }
        return (FrameSequence) invokeL.objValue;
    }

    @Nullable
    public static FrameSequence decodeStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            if (ISLOADED.get()) {
                if (inputStream != null) {
                    return nativeDecodeStream(inputStream, new byte[16384]);
                }
                throw new IllegalArgumentException();
            }
            return null;
        }
        return (FrameSequence) invokeL.objValue;
    }

    public static boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? ISLOADED.get() : invokeV.booleanValue;
    }

    public static native long nativeCreateState(long j2);

    public static native FrameSequence nativeDecodeByteArray(byte[] bArr, int i2, int i3);

    public static native FrameSequence nativeDecodeByteBuffer(ByteBuffer byteBuffer, int i2, int i3);

    public static native FrameSequence nativeDecodeStream(InputStream inputStream, byte[] bArr);

    public static native void nativeDestroyFrameSequence(long j2);

    public static native void nativeDestroyState(long j2);

    public static native long nativeGetFrame(long j2, int i2, Bitmap bitmap, int i3);

    public State createState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.mNativeFrameSequence;
            if (j2 != 0) {
                long nativeCreateState = nativeCreateState(j2);
                if (nativeCreateState == 0) {
                    return null;
                }
                return new State(nativeCreateState);
            }
            throw new IllegalStateException("attempted to use incorrectly built FrameSequence");
        }
        return (State) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j2 = this.mNativeFrameSequence;
            if (j2 != 0) {
                nativeDestroyFrameSequence(j2);
            }
        }
    }

    public int getDefaultLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDefaultLoopCount : invokeV.intValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFrameCount : invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOpaque : invokeV.booleanValue;
    }
}
