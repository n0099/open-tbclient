package com.facebook.animated.webpdrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.animated.webp.WebPFrame;
import com.facebook.animated.webp.WebPImage;
import com.facebook.fresco.animation.backend.AnimationBackend;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class WebpAnimationBackend implements AnimationBackend {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect mBounds;
    public final Rect mRenderDstRect;
    public final Rect mRenderSrcRect;
    @GuardedBy("this")
    @Nullable
    public Bitmap mTempBitmap;
    public final WebPImage mWebPImage;

    public WebpAnimationBackend(WebPImage webPImage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webPImage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRenderDstRect = new Rect();
        this.mRenderSrcRect = new Rect();
        this.mWebPImage = webPImage;
    }

    private synchronized void clearTempBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (this.mTempBitmap != null) {
                    this.mTempBitmap.recycle();
                    this.mTempBitmap = null;
                }
            }
        }
    }

    public static void closeSilently(@Nullable Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static WebpAnimationBackend create(String str) throws IOException {
        InterceptResult invokeL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedInputStream.mark(Integer.MAX_VALUE);
                byte[] bArr = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bArr);
                WebPImage createFromByteArray = WebPImage.createFromByteArray(bArr);
                bufferedInputStream.reset();
                WebpAnimationBackend webpAnimationBackend = new WebpAnimationBackend(createFromByteArray);
                closeSilently(bufferedInputStream);
                return webpAnimationBackend;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                closeSilently(bufferedInputStream2);
                throw th;
            }
        }
        return (WebpAnimationBackend) invokeL.objValue;
    }

    private synchronized void prepareTempBitmapForThisSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3) == null) {
            synchronized (this) {
                if (this.mTempBitmap != null && (this.mTempBitmap.getWidth() < i2 || this.mTempBitmap.getHeight() < i3)) {
                    clearTempBitmap();
                }
                if (this.mTempBitmap == null) {
                    this.mTempBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                }
                this.mTempBitmap.eraseColor(0);
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mWebPImage.dispose();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, canvas, i2)) == null) {
            WebPFrame frame = this.mWebPImage.getFrame(i2);
            double width = this.mBounds.width() / drawable.getIntrinsicWidth();
            double height = this.mBounds.height() / drawable.getIntrinsicHeight();
            int round = (int) Math.round(frame.getWidth() * width);
            int round2 = (int) Math.round(frame.getHeight() * height);
            int xOffset = (int) (frame.getXOffset() * width);
            int yOffset = (int) (frame.getYOffset() * height);
            synchronized (this) {
                int width2 = this.mBounds.width();
                int height2 = this.mBounds.height();
                prepareTempBitmapForThisSize(width2, height2);
                if (this.mTempBitmap == null) {
                    return false;
                }
                frame.renderFrame(round, round2, this.mTempBitmap);
                this.mRenderSrcRect.set(0, 0, width2, height2);
                this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
                canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, (Paint) null);
                return true;
            }
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mWebPImage.getFrameCount() : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.mWebPImage.getFrameDurations()[i2] : invokeI.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWebPImage.getHeight() : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWebPImage.getWidth() : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mWebPImage.getLoopCount() : invokeV.intValue;
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
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public synchronized void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            synchronized (this) {
                this.mBounds = rect;
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, colorFilter) == null) {
        }
    }
}
