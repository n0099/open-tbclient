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
/* loaded from: classes2.dex */
public class AnimatedImageCompositor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedDrawableBackend mAnimatedDrawableBackend;
    public final Callback mCallback;
    public final Paint mTransparentFillPaint;

    /* renamed from: com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor$1  reason: invalid class name */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface Callback {
        CloseableReference<Bitmap> getCachedBitmap(int i2);

        void onIntermediateResult(int i2, Bitmap bitmap);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public FrameNeededResult(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = animatedDrawableFrameInfo.xOffset;
            int i3 = animatedDrawableFrameInfo.yOffset;
            canvas.drawRect(i2, i3, i2 + animatedDrawableFrameInfo.width, i3 + animatedDrawableFrameInfo.height, this.mTransparentFillPaint);
        }
    }

    private FrameNeededResult isFrameNeededForRendering(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i2);
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

    private boolean isKeyFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            if (i2 == 0) {
                return true;
            }
            AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i2);
            AnimatedDrawableFrameInfo frameInfo2 = this.mAnimatedDrawableBackend.getFrameInfo(i2 - 1);
            if (frameInfo.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && isFullFrame(frameInfo)) {
                return true;
            }
            return frameInfo2.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && isFullFrame(frameInfo2);
        }
        return invokeI.booleanValue;
    }

    private int prepareCanvasWithClosestCachedFrame(int i2, Canvas canvas) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, this, i2, canvas)) == null) {
            while (i2 >= 0) {
                int i3 = AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[isFrameNeededForRendering(i2).ordinal()];
                if (i3 == 1) {
                    AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i2);
                    CloseableReference<Bitmap> cachedBitmap = this.mCallback.getCachedBitmap(i2);
                    if (cachedBitmap != null) {
                        try {
                            canvas.drawBitmap(cachedBitmap.get(), 0.0f, 0.0f, (Paint) null);
                            if (frameInfo.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                disposeToBackground(canvas, frameInfo);
                            }
                            return i2 + 1;
                        } finally {
                            cachedBitmap.close();
                        }
                    } else if (isKeyFrame(i2)) {
                        return i2;
                    }
                } else if (i3 == 2) {
                    return i2 + 1;
                } else {
                    if (i3 == 3) {
                        return i2;
                    }
                }
                i2--;
            }
            return 0;
        }
        return invokeIL.intValue;
    }

    public void renderFrame(int i2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bitmap) == null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(0, PorterDuff.Mode.SRC);
            for (int prepareCanvasWithClosestCachedFrame = !isKeyFrame(i2) ? prepareCanvasWithClosestCachedFrame(i2 - 1, canvas) : i2; prepareCanvasWithClosestCachedFrame < i2; prepareCanvasWithClosestCachedFrame++) {
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
            AnimatedDrawableFrameInfo frameInfo2 = this.mAnimatedDrawableBackend.getFrameInfo(i2);
            if (frameInfo2.blendOperation == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                disposeToBackground(canvas, frameInfo2);
            }
            this.mAnimatedDrawableBackend.renderFrame(i2, canvas);
        }
    }
}
