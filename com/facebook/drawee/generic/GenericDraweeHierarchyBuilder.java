package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class GenericDraweeHierarchyBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
    public static final int DEFAULT_FADE_DURATION = 150;
    public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public ColorFilter mActualImageColorFilter;
    public PointF mActualImageFocusPoint;
    public Matrix mActualImageMatrix;
    public ScalingUtils.ScaleType mActualImageScaleType;
    public Drawable mBackground;
    public float mDesiredAspectRatio;
    public int mFadeDuration;
    public Drawable mFailureImage;
    public ScalingUtils.ScaleType mFailureImageScaleType;
    public List<Drawable> mOverlays;
    public Drawable mPlaceholderImage;
    @Nullable
    public ScalingUtils.ScaleType mPlaceholderImageScaleType;
    public Drawable mPressedStateOverlay;
    public Drawable mProgressBarImage;
    public ScalingUtils.ScaleType mProgressBarImageScaleType;
    public Resources mResources;
    public Drawable mRetryImage;
    public ScalingUtils.ScaleType mRetryImageScaleType;
    public RoundingParams mRoundingParams;
    public boolean mUseGlobalColorFilter;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(671174126, "Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(671174126, "Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;");
                return;
            }
        }
        DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
        DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
    }

    public GenericDraweeHierarchyBuilder(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResources = resources;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mFadeDuration = 150;
            this.mUseGlobalColorFilter = true;
            this.mDesiredAspectRatio = 0.0f;
            this.mPlaceholderImage = null;
            ScalingUtils.ScaleType scaleType = DEFAULT_SCALE_TYPE;
            this.mPlaceholderImageScaleType = scaleType;
            this.mRetryImage = null;
            this.mRetryImageScaleType = scaleType;
            this.mFailureImage = null;
            this.mFailureImageScaleType = scaleType;
            this.mProgressBarImage = null;
            this.mProgressBarImageScaleType = scaleType;
            this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
            this.mActualImageMatrix = null;
            this.mActualImageFocusPoint = null;
            this.mActualImageColorFilter = null;
            this.mBackground = null;
            this.mOverlays = null;
            this.mPressedStateOverlay = null;
            this.mRoundingParams = null;
        }
    }

    public static GenericDraweeHierarchyBuilder newInstance(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, resources)) == null) ? new GenericDraweeHierarchyBuilder(resources) : (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    private void validate() {
        List<Drawable> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (list = this.mOverlays) == null) {
            return;
        }
        for (Drawable drawable : list) {
            Preconditions.checkNotNull(drawable);
        }
    }

    public GenericDraweeHierarchy build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            validate();
            return new GenericDraweeHierarchy(this);
        }
        return (GenericDraweeHierarchy) invokeV.objValue;
    }

    @Nullable
    public ColorFilter getActualImageColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mActualImageColorFilter : (ColorFilter) invokeV.objValue;
    }

    @Nullable
    public PointF getActualImageFocusPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mActualImageFocusPoint : (PointF) invokeV.objValue;
    }

    @Nullable
    public ScalingUtils.ScaleType getActualImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActualImageScaleType : (ScalingUtils.ScaleType) invokeV.objValue;
    }

    @Nullable
    public Drawable getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBackground : (Drawable) invokeV.objValue;
    }

    public float getDesiredAspectRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDesiredAspectRatio : invokeV.floatValue;
    }

    public int getFadeDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFadeDuration : invokeV.intValue;
    }

    @Nullable
    public Drawable getFailureImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mFailureImage : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ScalingUtils.ScaleType getFailureImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFailureImageScaleType : (ScalingUtils.ScaleType) invokeV.objValue;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mOverlays : (List) invokeV.objValue;
    }

    @Nullable
    public Drawable getPlaceholderImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPlaceholderImage : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ScalingUtils.ScaleType getPlaceholderImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPlaceholderImageScaleType : (ScalingUtils.ScaleType) invokeV.objValue;
    }

    @Nullable
    public Drawable getPressedStateOverlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mPressedStateOverlay : (Drawable) invokeV.objValue;
    }

    @Nullable
    public Drawable getProgressBarImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mProgressBarImage : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ScalingUtils.ScaleType getProgressBarImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mProgressBarImageScaleType : (ScalingUtils.ScaleType) invokeV.objValue;
    }

    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mResources : (Resources) invokeV.objValue;
    }

    @Nullable
    public Drawable getRetryImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mRetryImage : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ScalingUtils.ScaleType getRetryImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRetryImageScaleType : (ScalingUtils.ScaleType) invokeV.objValue;
    }

    @Nullable
    public RoundingParams getRoundingParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRoundingParams : (RoundingParams) invokeV.objValue;
    }

    public boolean getUseGlobalColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mUseGlobalColorFilter : invokeV.booleanValue;
    }

    public GenericDraweeHierarchyBuilder reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            init();
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeV.objValue;
    }

    public GenericDraweeHierarchyBuilder setActualImageColorFilter(@Nullable ColorFilter colorFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, colorFilter)) == null) {
            this.mActualImageColorFilter = colorFilter;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setActualImageFocusPoint(@Nullable PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pointF)) == null) {
            this.mActualImageFocusPoint = pointF;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setActualImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, scaleType)) == null) {
            this.mActualImageScaleType = scaleType;
            this.mActualImageMatrix = null;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setBackground(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, drawable)) == null) {
            this.mBackground = drawable;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setDesiredAspectRatio(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f)) == null) {
            this.mDesiredAspectRatio = f;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeF.objValue;
    }

    public GenericDraweeHierarchyBuilder setFadeDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            this.mFadeDuration = i;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeI.objValue;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, drawable)) == null) {
            this.mFailureImage = drawable;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setFailureImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, scaleType)) == null) {
            this.mFailureImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setOverlay(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, drawable)) == null) {
            if (drawable == null) {
                this.mOverlays = null;
            } else {
                this.mOverlays = Arrays.asList(drawable);
            }
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setOverlays(@Nullable List<Drawable> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, list)) == null) {
            this.mOverlays = list;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, drawable)) == null) {
            this.mPlaceholderImage = drawable;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, scaleType)) == null) {
            this.mPlaceholderImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setPressedStateOverlay(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, drawable)) == null) {
            if (drawable == null) {
                this.mPressedStateOverlay = null;
            } else {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, drawable);
                this.mPressedStateOverlay = stateListDrawable;
            }
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, drawable)) == null) {
            this.mProgressBarImage = drawable;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, scaleType)) == null) {
            this.mProgressBarImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, drawable)) == null) {
            this.mRetryImage = drawable;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setRetryImageScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, scaleType)) == null) {
            this.mRetryImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setRoundingParams(@Nullable RoundingParams roundingParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, roundingParams)) == null) {
            this.mRoundingParams = roundingParams;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeL.objValue;
    }

    public GenericDraweeHierarchyBuilder setUseGlobalColorFilter(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z)) == null) {
            this.mUseGlobalColorFilter = z;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeZ.objValue;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            this.mFailureImage = this.mResources.getDrawable(i);
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeI.objValue;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            this.mPlaceholderImage = this.mResources.getDrawable(i);
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeI.objValue;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
            this.mProgressBarImage = this.mResources.getDrawable(i);
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeI.objValue;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
            this.mRetryImage = this.mResources.getDrawable(i);
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeI.objValue;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, drawable, scaleType)) == null) {
            this.mFailureImage = drawable;
            this.mFailureImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeLL.objValue;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, drawable, scaleType)) == null) {
            this.mPlaceholderImage = drawable;
            this.mPlaceholderImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeLL.objValue;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, drawable, scaleType)) == null) {
            this.mProgressBarImage = drawable;
            this.mProgressBarImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeLL.objValue;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, drawable, scaleType)) == null) {
            this.mRetryImage = drawable;
            this.mRetryImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeLL.objValue;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i, scaleType)) == null) {
            this.mFailureImage = this.mResources.getDrawable(i);
            this.mFailureImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeIL.objValue;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048611, this, i, scaleType)) == null) {
            this.mPlaceholderImage = this.mResources.getDrawable(i);
            this.mPlaceholderImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeIL.objValue;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i, scaleType)) == null) {
            this.mProgressBarImage = this.mResources.getDrawable(i);
            this.mProgressBarImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeIL.objValue;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048622, this, i, scaleType)) == null) {
            this.mRetryImage = this.mResources.getDrawable(i);
            this.mRetryImageScaleType = scaleType;
            return this;
        }
        return (GenericDraweeHierarchyBuilder) invokeIL.objValue;
    }
}
