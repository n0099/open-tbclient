package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTUAL_IMAGE_INDEX = 2;
    public static final int BACKGROUND_IMAGE_INDEX = 0;
    public static final int FAILURE_IMAGE_INDEX = 5;
    public static final int OVERLAY_IMAGES_INDEX = 6;
    public static final int PLACEHOLDER_IMAGE_INDEX = 1;
    public static final int PROGRESS_BAR_IMAGE_INDEX = 3;
    public static final int RETRY_IMAGE_INDEX = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public final ForwardingDrawable mActualImageWrapper;
    public final Drawable mEmptyActualImageDrawable;
    public final FadeDrawable mFadeDrawable;
    public final Resources mResources;
    @Nullable
    public RoundingParams mRoundingParams;
    public final RootDrawable mTopLevelDrawable;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {genericDraweeHierarchyBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i3 = 0;
        this.mEmptyActualImageDrawable = new ColorDrawable(0);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchy()");
        }
        this.mResources = genericDraweeHierarchyBuilder.getResources();
        this.mRoundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
        this.mActualImageWrapper = new ForwardingDrawable(this.mEmptyActualImageDrawable);
        int i4 = 1;
        int size = genericDraweeHierarchyBuilder.getOverlays() != null ? genericDraweeHierarchyBuilder.getOverlays().size() : 1;
        int i5 = (size == 0 ? 1 : size) + (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i5 + 6];
        drawableArr[0] = buildBranch(genericDraweeHierarchyBuilder.getBackground(), null);
        drawableArr[1] = buildBranch(genericDraweeHierarchyBuilder.getPlaceholderImage(), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        drawableArr[2] = buildActualImageBranch(this.mActualImageWrapper, genericDraweeHierarchyBuilder.getActualImageScaleType(), genericDraweeHierarchyBuilder.getActualImageFocusPoint(), genericDraweeHierarchyBuilder.getActualImageColorFilter());
        drawableArr[3] = buildBranch(genericDraweeHierarchyBuilder.getProgressBarImage(), genericDraweeHierarchyBuilder.getProgressBarImageScaleType());
        drawableArr[4] = buildBranch(genericDraweeHierarchyBuilder.getRetryImage(), genericDraweeHierarchyBuilder.getRetryImageScaleType());
        drawableArr[5] = buildBranch(genericDraweeHierarchyBuilder.getFailureImage(), genericDraweeHierarchyBuilder.getFailureImageScaleType());
        if (i5 > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                for (Drawable drawable : genericDraweeHierarchyBuilder.getOverlays()) {
                    drawableArr[i3 + 6] = buildBranch(drawable, null);
                    i3++;
                }
                i4 = i3;
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                drawableArr[i4 + 6] = buildBranch(genericDraweeHierarchyBuilder.getPressedStateOverlay(), null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr);
        this.mFadeDrawable = fadeDrawable;
        fadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(this.mFadeDrawable, this.mRoundingParams));
        this.mTopLevelDrawable = rootDrawable;
        rootDrawable.setUseGlobalColorFilter(genericDraweeHierarchyBuilder.getUseGlobalColorFilter());
        this.mTopLevelDrawable.mutate();
        resetFade();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Nullable
    private Drawable buildActualImageBranch(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, this, drawable, scaleType, pointF, colorFilter)) == null) {
            drawable.setColorFilter(colorFilter);
            return WrappingUtils.maybeWrapWithScaleType(drawable, scaleType, pointF);
        }
        return (Drawable) invokeLLLL.objValue;
    }

    @Nullable
    private Drawable buildBranch(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, drawable, scaleType)) == null) ? WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources), scaleType) : (Drawable) invokeLL.objValue;
    }

    private void fadeInLayer(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i) == null) || i < 0) {
            return;
        }
        this.mFadeDrawable.fadeInLayer(i);
    }

    private void fadeOutBranches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            fadeOutLayer(1);
            fadeOutLayer(2);
            fadeOutLayer(3);
            fadeOutLayer(4);
            fadeOutLayer(5);
        }
    }

    private void fadeOutLayer(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, this, i) == null) || i < 0) {
            return;
        }
        this.mFadeDrawable.fadeOutLayer(i);
    }

    private DrawableParent getParentDrawableAtIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            DrawableParent drawableParentForIndex = this.mFadeDrawable.getDrawableParentForIndex(i);
            if (drawableParentForIndex.getDrawable() instanceof MatrixDrawable) {
                drawableParentForIndex = (MatrixDrawable) drawableParentForIndex.getDrawable();
            }
            return drawableParentForIndex.getDrawable() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParentForIndex.getDrawable() : drawableParentForIndex;
        }
        return (DrawableParent) invokeI.objValue;
    }

    private ScaleTypeDrawable getScaleTypeDrawableAtIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            DrawableParent parentDrawableAtIndex = getParentDrawableAtIndex(i);
            if (parentDrawableAtIndex instanceof ScaleTypeDrawable) {
                return (ScaleTypeDrawable) parentDrawableAtIndex;
            }
            return WrappingUtils.wrapChildWithScaleType(parentDrawableAtIndex, ScalingUtils.ScaleType.FIT_XY);
        }
        return (ScaleTypeDrawable) invokeI.objValue;
    }

    private boolean hasScaleTypeDrawableAtIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) ? getParentDrawableAtIndex(i) instanceof ScaleTypeDrawable : invokeI.booleanValue;
    }

    private void resetActualImages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
        }
    }

    private void resetFade() {
        FadeDrawable fadeDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (fadeDrawable = this.mFadeDrawable) == null) {
            return;
        }
        fadeDrawable.beginBatchMode();
        this.mFadeDrawable.fadeInAllLayers();
        fadeOutBranches();
        fadeInLayer(1);
        this.mFadeDrawable.finishTransitionImmediately();
        this.mFadeDrawable.endBatchMode();
    }

    private void setChildDrawableAtIndex(int i, @Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65547, this, i, drawable) == null) {
            if (drawable == null) {
                this.mFadeDrawable.setDrawable(i, null);
                return;
            }
            getParentDrawableAtIndex(i).setDrawable(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources));
        }
    }

    private void setProgress(float f) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65548, this, f) == null) || (drawable = this.mFadeDrawable.getDrawable(3)) == null) {
            return;
        }
        if (f >= 0.999f) {
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            fadeOutLayer(3);
        } else {
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
            fadeInLayer(3);
        }
        drawable.setLevel(Math.round(f * 10000.0f));
    }

    public void getActualImageBounds(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rectF) == null) {
            this.mActualImageWrapper.getTransformedBounds(rectF);
        }
    }

    @Nullable
    public PointF getActualImageFocusPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (hasScaleTypeDrawableAtIndex(2)) {
                return getScaleTypeDrawableAtIndex(2).getFocusPoint();
            }
            return null;
        }
        return (PointF) invokeV.objValue;
    }

    @Nullable
    public ScalingUtils.ScaleType getActualImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (hasScaleTypeDrawableAtIndex(2)) {
                return getScaleTypeDrawableAtIndex(2).getScaleType();
            }
            return null;
        }
        return (ScalingUtils.ScaleType) invokeV.objValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Rect getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTopLevelDrawable.getBounds() : (Rect) invokeV.objValue;
    }

    public int getFadeDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFadeDrawable.getTransitionDuration() : invokeV.intValue;
    }

    @Nullable
    public RoundingParams getRoundingParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRoundingParams : (RoundingParams) invokeV.objValue;
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable getTopLevelDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTopLevelDrawable : (Drawable) invokeV.objValue;
    }

    public boolean getUseGlobalColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTopLevelDrawable.getUseGlobalColorFilter() : invokeV.booleanValue;
    }

    @VisibleForTesting
    public boolean hasImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mActualImageWrapper.getDrawable() != this.mEmptyActualImageDrawable : invokeV.booleanValue;
    }

    public boolean hasPlaceholderImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mFadeDrawable.getDrawable(1) != null : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            resetActualImages();
            resetFade();
        }
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, colorFilter) == null) {
            this.mActualImageWrapper.setColorFilter(colorFilter);
        }
    }

    public void setActualImageFocusPoint(PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pointF) == null) {
            Preconditions.checkNotNull(pointF);
            getScaleTypeDrawableAtIndex(2).setFocusPoint(pointF);
        }
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, scaleType) == null) {
            Preconditions.checkNotNull(scaleType);
            getScaleTypeDrawableAtIndex(2).setScaleType(scaleType);
        }
    }

    public void setBackgroundImage(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawable) == null) {
            setChildDrawableAtIndex(0, drawable);
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setControllerOverlay(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) {
            this.mTopLevelDrawable.setControllerOverlay(drawable);
        }
    }

    public void setFadeDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mFadeDrawable.setTransitionDuration(i);
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setFailure(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            this.mFadeDrawable.beginBatchMode();
            fadeOutBranches();
            if (this.mFadeDrawable.getDrawable(5) != null) {
                fadeInLayer(5);
            } else {
                fadeInLayer(1);
            }
            this.mFadeDrawable.endBatchMode();
        }
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, drawable) == null) {
            setChildDrawableAtIndex(5, drawable);
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setImage(Drawable drawable, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{drawable, Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            Drawable maybeApplyLeafRounding = WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources);
            maybeApplyLeafRounding.mutate();
            this.mActualImageWrapper.setDrawable(maybeApplyLeafRounding);
            this.mFadeDrawable.beginBatchMode();
            fadeOutBranches();
            fadeInLayer(2);
            setProgress(f);
            if (z) {
                this.mFadeDrawable.finishTransitionImmediately();
            }
            this.mFadeDrawable.endBatchMode();
        }
    }

    public void setOnFadeFinishedListener(FadeDrawable.OnFadeFinishedListener onFadeFinishedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onFadeFinishedListener) == null) {
            this.mFadeDrawable.setOnFadeFinishedListener(onFadeFinishedListener);
        }
    }

    public void setOverlayImage(int i, @Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i, drawable) == null) {
            Preconditions.checkArgument(i >= 0 && i + 6 < this.mFadeDrawable.getNumberOfLayers(), "The given index does not correspond to an overlay image.");
            setChildDrawableAtIndex(i + 6, drawable);
        }
    }

    public void setPlaceholderImage(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, drawable) == null) {
            setChildDrawableAtIndex(1, drawable);
        }
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pointF) == null) {
            Preconditions.checkNotNull(pointF);
            getScaleTypeDrawableAtIndex(1).setFocusPoint(pointF);
        }
    }

    public void setProgressBarImage(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, drawable) == null) {
            setChildDrawableAtIndex(3, drawable);
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setRetry(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, th) == null) {
            this.mFadeDrawable.beginBatchMode();
            fadeOutBranches();
            if (this.mFadeDrawable.getDrawable(4) != null) {
                fadeInLayer(4);
            } else {
                fadeInLayer(1);
            }
            this.mFadeDrawable.endBatchMode();
        }
    }

    public void setRetryImage(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, drawable) == null) {
            setChildDrawableAtIndex(4, drawable);
        }
    }

    public void setRoundingParams(@Nullable RoundingParams roundingParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, roundingParams) == null) {
            this.mRoundingParams = roundingParams;
            WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, roundingParams);
            for (int i = 0; i < this.mFadeDrawable.getNumberOfLayers(); i++) {
                WrappingUtils.updateLeafRounding(getParentDrawableAtIndex(i), this.mRoundingParams, this.mResources);
            }
        }
    }

    public void setUseGlobalColorFilter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.mTopLevelDrawable.setUseGlobalColorFilter(z);
        }
    }

    public void setFailureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, drawable, scaleType) == null) {
            setChildDrawableAtIndex(5, drawable);
            getScaleTypeDrawableAtIndex(5).setScaleType(scaleType);
        }
    }

    public void setPlaceholderImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, drawable, scaleType) == null) {
            setChildDrawableAtIndex(1, drawable);
            getScaleTypeDrawableAtIndex(1).setScaleType(scaleType);
        }
    }

    public void setProgressBarImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, drawable, scaleType) == null) {
            setChildDrawableAtIndex(3, drawable);
            getScaleTypeDrawableAtIndex(3).setScaleType(scaleType);
        }
    }

    public void setRetryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, drawable, scaleType) == null) {
            setChildDrawableAtIndex(4, drawable);
            getScaleTypeDrawableAtIndex(4).setScaleType(scaleType);
        }
    }

    public void setFailureImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            setFailureImage(this.mResources.getDrawable(i));
        }
    }

    public void setPlaceholderImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            setPlaceholderImage(this.mResources.getDrawable(i));
        }
    }

    public void setProgressBarImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            setProgressBarImage(this.mResources.getDrawable(i));
        }
    }

    public void setRetryImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            setRetryImage(this.mResources.getDrawable(i));
        }
    }

    public void setFailureImage(int i, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, scaleType) == null) {
            setFailureImage(this.mResources.getDrawable(i), scaleType);
        }
    }

    public void setOverlayImage(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, drawable) == null) {
            setOverlayImage(0, drawable);
        }
    }

    public void setPlaceholderImage(int i, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, scaleType) == null) {
            setPlaceholderImage(this.mResources.getDrawable(i), scaleType);
        }
    }

    public void setProgressBarImage(int i, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i, scaleType) == null) {
            setProgressBarImage(this.mResources.getDrawable(i), scaleType);
        }
    }

    public void setRetryImage(int i, ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i, scaleType) == null) {
            setRetryImage(this.mResources.getDrawable(i), scaleType);
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setProgress(float f, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) == null) || this.mFadeDrawable.getDrawable(3) == null) {
            return;
        }
        this.mFadeDrawable.beginBatchMode();
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }
}
