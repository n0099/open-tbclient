package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ScaleTypeDrawable extends ForwardingDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public Matrix mDrawMatrix;
    @VisibleForTesting
    @Nullable
    public PointF mFocusPoint;
    @VisibleForTesting
    public ScalingUtils.ScaleType mScaleType;
    @VisibleForTesting
    public Object mScaleTypeState;
    public Matrix mTempMatrix;
    @VisibleForTesting
    public int mUnderlyingHeight;
    @VisibleForTesting
    public int mUnderlyingWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, scaleType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new Matrix();
        this.mScaleType = scaleType;
    }

    private void configureBoundsIfUnderlyingChanged() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ScalingUtils.ScaleType scaleType = this.mScaleType;
            boolean z2 = true;
            if (scaleType instanceof ScalingUtils.StatefulScaleType) {
                Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
                z = state == null || !state.equals(this.mScaleTypeState);
                this.mScaleTypeState = state;
            } else {
                z = false;
            }
            if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth() && this.mUnderlyingHeight == getCurrent().getIntrinsicHeight()) {
                z2 = false;
            }
            if (z2 || z) {
                configureBounds();
            }
        }
    }

    @VisibleForTesting
    public void configureBounds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Drawable current = getCurrent();
            Rect bounds = getBounds();
            int width = bounds.width();
            int height = bounds.height();
            int intrinsicWidth = current.getIntrinsicWidth();
            this.mUnderlyingWidth = intrinsicWidth;
            int intrinsicHeight = current.getIntrinsicHeight();
            this.mUnderlyingHeight = intrinsicHeight;
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
            } else if (intrinsicWidth == width && intrinsicHeight == height) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
            } else if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
            } else {
                current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                ScalingUtils.ScaleType scaleType = this.mScaleType;
                Matrix matrix = this.mTempMatrix;
                PointF pointF = this.mFocusPoint;
                float f2 = pointF != null ? pointF.x : 0.5f;
                PointF pointF2 = this.mFocusPoint;
                scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f2, pointF2 != null ? pointF2.y : 0.5f);
                this.mDrawMatrix = this.mTempMatrix;
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            configureBoundsIfUnderlyingChanged();
            if (this.mDrawMatrix != null) {
                int save = canvas.save();
                canvas.clipRect(getBounds());
                canvas.concat(this.mDrawMatrix);
                super.draw(canvas);
                canvas.restoreToCount(save);
                return;
            }
            super.draw(canvas);
        }
    }

    @Nullable
    public PointF getFocusPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFocusPoint : (PointF) invokeV.objValue;
    }

    public ScalingUtils.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mScaleType : (ScalingUtils.ScaleType) invokeV.objValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, matrix) == null) {
            getParentTransform(matrix);
            configureBoundsIfUnderlyingChanged();
            Matrix matrix2 = this.mDrawMatrix;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rect) == null) {
            configureBounds();
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, drawable)) == null) {
            Drawable current = super.setCurrent(drawable);
            configureBounds();
            return current;
        }
        return (Drawable) invokeL.objValue;
    }

    public void setFocusPoint(PointF pointF) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pointF) == null) || Objects.equal(this.mFocusPoint, pointF)) {
            return;
        }
        if (this.mFocusPoint == null) {
            this.mFocusPoint = new PointF();
        }
        this.mFocusPoint.set(pointF);
        configureBounds();
        invalidateSelf();
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scaleType) == null) || Objects.equal(this.mScaleType, scaleType)) {
            return;
        }
        this.mScaleType = scaleType;
        this.mScaleTypeState = null;
        configureBounds();
        invalidateSelf();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, scaleType, pointF};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new Matrix();
        this.mScaleType = scaleType;
        this.mFocusPoint = pointF;
    }
}
