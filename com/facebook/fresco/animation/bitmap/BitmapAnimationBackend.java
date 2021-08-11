package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimationInformation mAnimationInformation;
    public Bitmap.Config mBitmapConfig;
    public final BitmapFrameCache mBitmapFrameCache;
    @Nullable
    public final BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;
    @Nullable
    public final BitmapFramePreparer mBitmapFramePreparer;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public int mBitmapHeight;
    public int mBitmapWidth;
    @Nullable
    public Rect mBounds;
    @Nullable
    public FrameListener mFrameListener;
    public final Paint mPaint;
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    /* loaded from: classes9.dex */
    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i2);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i2, int i3);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface FrameType {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1585577633, "Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1585577633, "Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend;");
                return;
            }
        }
        TAG = BitmapAnimationBackend.class;
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, @Nullable BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @Nullable BitmapFramePreparer bitmapFramePreparer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {platformBitmapFactory, bitmapFrameCache, animationInformation, bitmapFrameRenderer, bitmapFramePreparationStrategy, bitmapFramePreparer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        this.mPaint = new Paint(6);
        updateBitmapDimensions();
    }

    private boolean drawBitmapAndCache(int i2, @Nullable CloseableReference<Bitmap> closeableReference, Canvas canvas, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), closeableReference, canvas, Integer.valueOf(i3)})) == null) {
            if (CloseableReference.isValid(closeableReference)) {
                if (this.mBounds == null) {
                    canvas.drawBitmap(closeableReference.get(), 0.0f, 0.0f, this.mPaint);
                } else {
                    canvas.drawBitmap(closeableReference.get(), (Rect) null, this.mBounds, this.mPaint);
                }
                if (i3 != 3) {
                    this.mBitmapFrameCache.onFrameRendered(i2, closeableReference, i3);
                }
                FrameListener frameListener = this.mFrameListener;
                if (frameListener != null) {
                    frameListener.onFrameDrawn(this, i2, i3);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean drawFrameOrFallback(Canvas canvas, int i2, int i3) {
        InterceptResult invokeLII;
        CloseableReference<Bitmap> cachedFrame;
        boolean drawBitmapAndCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, this, canvas, i2, i3)) == null) {
            int i4 = 3;
            boolean z = false;
            try {
                if (i3 == 0) {
                    cachedFrame = this.mBitmapFrameCache.getCachedFrame(i2);
                    drawBitmapAndCache = drawBitmapAndCache(i2, cachedFrame, canvas, 0);
                    i4 = 1;
                } else if (i3 == 1) {
                    cachedFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i2, this.mBitmapWidth, this.mBitmapHeight);
                    if (renderFrameInBitmap(i2, cachedFrame) && drawBitmapAndCache(i2, cachedFrame, canvas, 1)) {
                        z = true;
                    }
                    drawBitmapAndCache = z;
                    i4 = 2;
                } else if (i3 == 2) {
                    cachedFrame = this.mPlatformBitmapFactory.createBitmap(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                    if (renderFrameInBitmap(i2, cachedFrame) && drawBitmapAndCache(i2, cachedFrame, canvas, 2)) {
                        z = true;
                    }
                    drawBitmapAndCache = z;
                } else if (i3 != 3) {
                    return false;
                } else {
                    cachedFrame = this.mBitmapFrameCache.getFallbackFrame(i2);
                    drawBitmapAndCache = drawBitmapAndCache(i2, cachedFrame, canvas, 3);
                    i4 = -1;
                }
                CloseableReference.closeSafely(cachedFrame);
                return (drawBitmapAndCache || i4 == -1) ? drawBitmapAndCache : drawFrameOrFallback(canvas, i2, i4);
            } catch (RuntimeException e2) {
                FLog.w(TAG, "Failed to create frame bitmap", e2);
                return false;
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) null);
            }
        }
        return invokeLII.booleanValue;
    }

    private boolean renderFrameInBitmap(int i2, @Nullable CloseableReference<Bitmap> closeableReference) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, closeableReference)) == null) {
            if (CloseableReference.isValid(closeableReference)) {
                boolean renderFrame = this.mBitmapFrameRenderer.renderFrame(i2, closeableReference.get());
                if (!renderFrame) {
                    CloseableReference.closeSafely(closeableReference);
                }
                return renderFrame;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    private void updateBitmapDimensions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int intrinsicWidth = this.mBitmapFrameRenderer.getIntrinsicWidth();
            this.mBitmapWidth = intrinsicWidth;
            if (intrinsicWidth == -1) {
                Rect rect = this.mBounds;
                this.mBitmapWidth = rect == null ? -1 : rect.width();
            }
            int intrinsicHeight = this.mBitmapFrameRenderer.getIntrinsicHeight();
            this.mBitmapHeight = intrinsicHeight;
            if (intrinsicHeight == -1) {
                Rect rect2 = this.mBounds;
                this.mBitmapHeight = rect2 != null ? rect2.height() : -1;
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBitmapFrameCache.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i2) {
        InterceptResult invokeLLI;
        BitmapFramePreparer bitmapFramePreparer;
        FrameListener frameListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, canvas, i2)) == null) {
            FrameListener frameListener2 = this.mFrameListener;
            if (frameListener2 != null) {
                frameListener2.onDrawFrameStart(this, i2);
            }
            boolean drawFrameOrFallback = drawFrameOrFallback(canvas, i2, 0);
            if (!drawFrameOrFallback && (frameListener = this.mFrameListener) != null) {
                frameListener.onFrameDropped(this, i2);
            }
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.mBitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null && (bitmapFramePreparer = this.mBitmapFramePreparer) != null) {
                bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.mBitmapFrameCache, this, i2);
            }
            return drawFrameOrFallback;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAnimationInformation.getFrameCount() : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.mAnimationInformation.getFrameDurationMs(i2) : invokeI.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBitmapHeight : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBitmapWidth : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAnimationInformation.getLoopCount() : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBitmapFrameCache.getSizeInBytes() : invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mPaint.setAlpha(i2);
        }
    }

    public void setBitmapConfig(Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, config) == null) {
            this.mBitmapConfig = config;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            this.mBounds = rect;
            this.mBitmapFrameRenderer.setBounds(rect);
            updateBitmapDimensions();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    public void setFrameListener(@Nullable FrameListener frameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, frameListener) == null) {
            this.mFrameListener = frameListener;
        }
    }
}
