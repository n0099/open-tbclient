package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
/* loaded from: classes4.dex */
public class AnimatedImageCompositor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedDrawableBackend mAnimatedDrawableBackend;
    public final Callback mCallback;
    public final Paint mTransparentFillPaint;

    /* renamed from: com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1992525305, "Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1992525305, "Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$1;");
                    return;
                }
            }
            int[] iArr = new int[FrameNeededResult.values().length];
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult = iArr;
            try {
                iArr[FrameNeededResult.REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.NOT_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.ABORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.SKIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface Callback {
        CloseableReference<Bitmap> getCachedBitmap(int i);

        void onIntermediateResult(int i, Bitmap bitmap);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class FrameNeededResult {
        public static final /* synthetic */ FrameNeededResult[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FrameNeededResult ABORT;
        public static final FrameNeededResult NOT_REQUIRED;
        public static final FrameNeededResult REQUIRED;
        public static final FrameNeededResult SKIP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(696296395, "Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$FrameNeededResult;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(696296395, "Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$FrameNeededResult;");
                    return;
                }
            }
            REQUIRED = new FrameNeededResult("REQUIRED", 0);
            NOT_REQUIRED = new FrameNeededResult("NOT_REQUIRED", 1);
            SKIP = new FrameNeededResult("SKIP", 2);
            FrameNeededResult frameNeededResult = new FrameNeededResult("ABORT", 3);
            ABORT = frameNeededResult;
            $VALUES = new FrameNeededResult[]{REQUIRED, NOT_REQUIRED, SKIP, frameNeededResult};
        }

        public FrameNeededResult(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FrameNeededResult valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FrameNeededResult) Enum.valueOf(FrameNeededResult.class, str) : (FrameNeededResult) invokeL.objValue;
        }

        public static FrameNeededResult[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FrameNeededResult[]) $VALUES.clone() : (FrameNeededResult[]) invokeV.objValue;
        }
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend animatedDrawableBackend, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedDrawableBackend, callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mCallback = callback;
        Paint paint = new Paint();
        this.mTransparentFillPaint = paint;
        paint.setColor(0);
        this.mTransparentFillPaint.setStyle(Paint.Style.FILL);
        this.mTransparentFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void disposeToBackground(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, canvas, animatedDrawableFrameInfo) == null) {
            int i = animatedDrawableFrameInfo.xOffset;
            int i2 = animatedDrawableFrameInfo.yOffset;
            canvas.drawRect(i, i2, i + animatedDrawableFrameInfo.width, i2 + animatedDrawableFrameInfo.height, this.mTransparentFillPaint);
        }
    }

    private FrameNeededResult isFrameNeededForRendering(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = frameInfo.disposalMethod;
            if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
                return FrameNeededResult.REQUIRED;
            }
            if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                if (isFullFrame(frameInfo)) {
                    return FrameNeededResult.NOT_REQUIRED;
                }
                return FrameNeededResult.REQUIRED;
            } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                return FrameNeededResult.SKIP;
            } else {
                return FrameNeededResult.ABORT;
            }
        }
        return (FrameNeededResult) invokeI.objValue;
    }

    private boolean isFullFrame(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, animatedDrawableFrameInfo)) == null) ? animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.mAnimatedDrawableBackend.getRenderedWidth() && animatedDrawableFrameInfo.height == this.mAnimatedDrawableBackend.getRenderedHeight() : invokeL.booleanValue;
    }

    private boolean isKeyFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            if (i == 0) {
                return true;
            }
            AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i);
            AnimatedDrawableFrameInfo frameInfo2 = this.mAnimatedDrawableBackend.getFrameInfo(i - 1);
            if (frameInfo.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && isFullFrame(frameInfo)) {
                return true;
            }
            return frameInfo2.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && isFullFrame(frameInfo2);
        }
        return invokeI.booleanValue;
    }

    private void maybeApplyTransformation(Bitmap bitmap) {
        AnimatedImageResult animatedImageResult;
        BitmapTransformation bitmapTransformation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, bitmap) == null) || (animatedImageResult = this.mAnimatedDrawableBackend.getAnimatedImageResult()) == null || (bitmapTransformation = animatedImageResult.getBitmapTransformation()) == null) {
            return;
        }
        bitmapTransformation.transform(bitmap);
    }

    private int prepareCanvasWithClosestCachedFrame(int i, Canvas canvas) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, this, i, canvas)) == null) {
            while (i >= 0) {
                int i2 = AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[isFrameNeededForRendering(i).ordinal()];
                if (i2 == 1) {
                    AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i);
                    CloseableReference<Bitmap> cachedBitmap = this.mCallback.getCachedBitmap(i);
                    if (cachedBitmap != null) {
                        try {
                            canvas.drawBitmap(cachedBitmap.get(), 0.0f, 0.0f, (Paint) null);
                            if (frameInfo.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                disposeToBackground(canvas, frameInfo);
                            }
                            return i + 1;
                        } finally {
                            cachedBitmap.close();
                        }
                    } else if (isKeyFrame(i)) {
                        return i;
                    }
                } else if (i2 == 2) {
                    return i + 1;
                } else {
                    if (i2 == 3) {
                        return i;
                    }
                }
                i--;
            }
            return 0;
        }
        return invokeIL.intValue;
    }

    public void renderFrame(int i, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(0, PorterDuff.Mode.SRC);
            for (int prepareCanvasWithClosestCachedFrame = !isKeyFrame(i) ? prepareCanvasWithClosestCachedFrame(i - 1, canvas) : i; prepareCanvasWithClosestCachedFrame < i; prepareCanvasWithClosestCachedFrame++) {
                AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(prepareCanvasWithClosestCachedFrame);
                AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = frameInfo.disposalMethod;
                if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                    if (frameInfo.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                        disposeToBackground(canvas, frameInfo);
                    }
                    this.mAnimatedDrawableBackend.renderFrame(prepareCanvasWithClosestCachedFrame, canvas);
                    this.mCallback.onIntermediateResult(prepareCanvasWithClosestCachedFrame, bitmap);
                    if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                        disposeToBackground(canvas, frameInfo);
                    }
                }
            }
            AnimatedDrawableFrameInfo frameInfo2 = this.mAnimatedDrawableBackend.getFrameInfo(i);
            if (frameInfo2.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                disposeToBackground(canvas, frameInfo2);
            }
            this.mAnimatedDrawableBackend.renderFrame(i, canvas);
            maybeApplyTransformation(bitmap);
        }
    }
}
