package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedDrawableUtil mAnimatedDrawableUtil;
    public final AnimatedImage mAnimatedImage;
    public final AnimatedImageResult mAnimatedImageResult;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final int mDurationMs;
    public final int[] mFrameDurationsMs;
    public final AnimatedDrawableFrameInfo[] mFrameInfos;
    public final int[] mFrameTimestampsMs;
    public final Rect mRenderDstRect;
    public final Rect mRenderSrcRect;
    public final Rect mRenderedBounds;
    @GuardedBy("this")
    @Nullable
    public Bitmap mTempBitmap;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedDrawableUtil, animatedImageResult, rect, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRenderSrcRect = new Rect();
        this.mRenderDstRect = new Rect();
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mAnimatedImageResult = animatedImageResult;
        AnimatedImage image = animatedImageResult.getImage();
        this.mAnimatedImage = image;
        int[] frameDurations = image.getFrameDurations();
        this.mFrameDurationsMs = frameDurations;
        this.mAnimatedDrawableUtil.fixFrameDurations(frameDurations);
        this.mDurationMs = this.mAnimatedDrawableUtil.getTotalDurationFromFrameDurations(this.mFrameDurationsMs);
        this.mFrameTimestampsMs = this.mAnimatedDrawableUtil.getFrameTimeStampsFromDurations(this.mFrameDurationsMs);
        this.mRenderedBounds = getBoundsToUse(this.mAnimatedImage, rect);
        this.mDownscaleFrameToDrawableDimensions = z;
        this.mFrameInfos = new AnimatedDrawableFrameInfo[this.mAnimatedImage.getFrameCount()];
        for (int i4 = 0; i4 < this.mAnimatedImage.getFrameCount(); i4++) {
            this.mFrameInfos[i4] = this.mAnimatedImage.getFrameInfo(i4);
        }
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

    public static Rect getBoundsToUse(AnimatedImage animatedImage, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, animatedImage, rect)) == null) {
            if (rect == null) {
                return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
            }
            return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
        }
        return (Rect) invokeLL.objValue;
    }

    private synchronized void prepareTempBitmapForThisSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i2, i3) == null) {
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

    private void renderImageDoesNotSupportScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int width;
        int height;
        int xOffset;
        int yOffset;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas, animatedImageFrame) == null) {
            if (this.mDownscaleFrameToDrawableDimensions) {
                float max = Math.max(animatedImageFrame.getWidth() / Math.min(animatedImageFrame.getWidth(), canvas.getWidth()), animatedImageFrame.getHeight() / Math.min(animatedImageFrame.getHeight(), canvas.getHeight()));
                width = (int) (animatedImageFrame.getWidth() / max);
                height = (int) (animatedImageFrame.getHeight() / max);
                xOffset = (int) (animatedImageFrame.getXOffset() / max);
                yOffset = (int) (animatedImageFrame.getYOffset() / max);
            } else {
                width = animatedImageFrame.getWidth();
                height = animatedImageFrame.getHeight();
                xOffset = animatedImageFrame.getXOffset();
                yOffset = animatedImageFrame.getYOffset();
            }
            synchronized (this) {
                prepareTempBitmapForThisSize(width, height);
                animatedImageFrame.renderFrame(width, height, this.mTempBitmap);
                canvas.save();
                canvas.translate(xOffset, yOffset);
                canvas.drawBitmap(this.mTempBitmap, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
        }
    }

    private void renderImageSupportsScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, canvas, animatedImageFrame) == null) {
            double width = this.mRenderedBounds.width() / this.mAnimatedImage.getWidth();
            double height = this.mRenderedBounds.height() / this.mAnimatedImage.getHeight();
            int round = (int) Math.round(animatedImageFrame.getWidth() * width);
            int round2 = (int) Math.round(animatedImageFrame.getHeight() * height);
            int xOffset = (int) (animatedImageFrame.getXOffset() * width);
            int yOffset = (int) (animatedImageFrame.getYOffset() * height);
            synchronized (this) {
                int width2 = this.mRenderedBounds.width();
                int height2 = this.mRenderedBounds.height();
                prepareTempBitmapForThisSize(width2, height2);
                animatedImageFrame.renderFrame(round, round2, this.mTempBitmap);
                this.mRenderSrcRect.set(0, 0, width2, height2);
                this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
                canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, (Paint) null);
            }
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                clearTempBitmap();
            }
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableBackend forNewBounds(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) ? getBoundsToUse(this.mAnimatedImage, rect).equals(this.mRenderedBounds) ? this : new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, rect, this.mDownscaleFrameToDrawableDimensions) : (AnimatedDrawableBackend) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAnimatedImageResult : (AnimatedImageResult) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDurationMs : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.mFrameDurationsMs[i2] : invokeI.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAnimatedImage.getFrameCount() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAnimatedImageResult.getFrameForPreview() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, i2) : invokeI.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.mFrameInfos[i2] : (AnimatedDrawableFrameInfo) invokeI.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAnimatedImage.getHeight() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mAnimatedImage.getLoopCount() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized int getMemoryUsage() {
        InterceptResult invokeV;
        int sizeOfBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                sizeOfBitmap = (this.mTempBitmap != null ? 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mTempBitmap) : 0) + this.mAnimatedImage.getSizeInBytes();
            }
            return sizeOfBitmap;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.mAnimatedImageResult.getDecodedFrame(i2) : (CloseableReference) invokeI.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRenderedBounds.height() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRenderedBounds.width() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Preconditions.checkElementIndex(i2, this.mFrameTimestampsMs.length);
            return this.mFrameTimestampsMs[i2];
        }
        return invokeI.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAnimatedImage.getWidth() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? this.mAnimatedImageResult.hasDecodedFrame(i2) : invokeI.booleanValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i2, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, canvas) == null) {
            AnimatedImageFrame frame = this.mAnimatedImage.getFrame(i2);
            try {
                if (this.mAnimatedImage.doesRenderSupportScaling()) {
                    renderImageSupportsScaling(canvas, frame);
                } else {
                    renderImageDoesNotSupportScaling(canvas, frame);
                }
            } finally {
                frame.dispose();
            }
        }
    }
}
