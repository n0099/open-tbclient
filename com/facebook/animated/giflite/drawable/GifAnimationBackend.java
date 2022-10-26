package com.facebook.animated.giflite.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.animated.giflite.decoder.GifMetadataDecoder;
import com.facebook.fresco.animation.backend.AnimationBackend;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class GifAnimationBackend implements AnimationBackend {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] mFrameStartTimes;
    public final GifMetadataDecoder mGifDecoder;
    public float mMidX;
    public float mMidY;
    public final Movie mMovie;

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, colorFilter) == null) {
        }
    }

    public GifAnimationBackend(GifMetadataDecoder gifMetadataDecoder, Movie movie) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gifMetadataDecoder, movie};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGifDecoder = gifMetadataDecoder;
        this.mMovie = movie;
        this.mFrameStartTimes = new int[gifMetadataDecoder.getFrameCount()];
    }

    public static void closeSilently(@Nullable Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, closeable) != null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.mGifDecoder.getFrameDurationMs(i);
        }
        return invokeI.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            scale(rect.right - rect.left, rect.bottom - rect.top, this.mMovie.width(), this.mMovie.height());
        }
    }

    public static GifAnimationBackend create(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                try {
                    bufferedInputStream2.mark(Integer.MAX_VALUE);
                    GifMetadataDecoder create = GifMetadataDecoder.create(bufferedInputStream2, null);
                    bufferedInputStream2.reset();
                    GifAnimationBackend gifAnimationBackend = new GifAnimationBackend(create, Movie.decodeStream(bufferedInputStream2));
                    closeSilently(bufferedInputStream2);
                    return gifAnimationBackend;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    closeSilently(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (GifAnimationBackend) invokeL.objValue;
        }
    }

    private int getFrameStartTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            if (i != 0) {
                int[] iArr = this.mFrameStartTimes;
                if (i < iArr.length) {
                    if (iArr[i] != 0) {
                        return iArr[i];
                    }
                    for (int i2 = 0; i2 < i; i2++) {
                        int[] iArr2 = this.mFrameStartTimes;
                        iArr2[i] = iArr2[i] + this.mGifDecoder.getFrameDurationMs(i2);
                    }
                    return this.mFrameStartTimes[i];
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private void scale(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2, i3, i4) == null) {
            float f = i3;
            float f2 = f / i4;
            float f3 = i;
            float f4 = i2;
            float f5 = f3 / f4;
            if (f5 > f2) {
                i5 = (int) (f4 * f2);
            } else if (f5 < f2) {
                i6 = (int) (f3 / f2);
                i5 = i;
                float f6 = i5 / f;
                this.mMidX = ((i - i5) / 2.0f) / f6;
                this.mMidY = ((i2 - i6) / 2.0f) / f6;
            } else {
                i5 = i;
            }
            i6 = i2;
            float f62 = i5 / f;
            this.mMidX = ((i - i5) / 2.0f) / f62;
            this.mMidY = ((i2 - i6) / 2.0f) / f62;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, canvas, i)) == null) {
            this.mMovie.setTime(getFrameStartTime(i));
            this.mMovie.draw(canvas, this.mMidX, this.mMidY);
            return true;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mGifDecoder.getFrameCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mMovie.height();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mMovie.width();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mGifDecoder.getLoopCount();
        }
        return invokeV.intValue;
    }
}
