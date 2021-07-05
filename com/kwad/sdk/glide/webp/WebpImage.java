package com.kwad.sdk.glide.webp;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.j;
import java.nio.ByteBuffer;
@Keep
/* loaded from: classes7.dex */
public class WebpImage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackgroundColor;
    public int mDurationMs;
    public int mFrameCount;
    public int[] mFrameDurations;
    public int mHeigth;
    public int mLoopCount;
    @Keep
    public long mNativePtr;
    public int mWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1969694966, "Lcom/kwad/sdk/glide/webp/WebpImage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1969694966, "Lcom/kwad/sdk/glide/webp/WebpImage;");
                return;
            }
        }
        try {
            System.loadLibrary("glide-webp");
        } catch (Throwable unused) {
        }
    }

    @Keep
    public WebpImage(long j, int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (j == 0) {
            throw new RuntimeException("internal error: native WebpImage is 0");
        }
        this.mWidth = i2;
        this.mHeigth = i3;
        this.mFrameCount = i4;
        this.mDurationMs = i5;
        this.mFrameDurations = iArr;
        this.mLoopCount = i6;
        fixFrameDurations(iArr);
        this.mBackgroundColor = i7;
        this.mNativePtr = j;
    }

    public static WebpImage create(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            j.a(bArr);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
            allocateDirect.put(bArr);
            allocateDirect.rewind();
            return nativeCreateFromDirectByteBuffer(allocateDirect);
        }
        return (WebpImage) invokeL.objValue;
    }

    private void fixFrameDurations(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, iArr) == null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] < 20) {
                    iArr[i2] = 100;
                }
            }
        }
    }

    public static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i2);

    private native int nativeGetSizeInBytes();

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nativeDispose();
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nativeFinalize();
        }
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBackgroundColor : invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDurationMs : invokeV.intValue;
    }

    public WebpFrame getFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? nativeGetFrame(i2) : (WebpFrame) invokeI.objValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFrameCount : invokeV.intValue;
    }

    public int[] getFrameDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFrameDurations : (int[]) invokeV.objValue;
    }

    public c getFrameInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            WebpFrame frame = getFrame(i2);
            try {
                return new c(i2, frame);
            } finally {
                frame.dispose();
            }
        }
        return (c) invokeI.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mHeigth : invokeV.intValue;
    }

    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLoopCount : invokeV.intValue;
    }

    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? nativeGetSizeInBytes() : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mWidth : invokeV.intValue;
    }
}
