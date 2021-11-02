package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;
/* loaded from: classes11.dex */
public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public final RectF mBitmapBounds;
    public int mBorderColor;
    public final Path mBorderPath;
    @VisibleForTesting
    public final float[] mBorderRadii;
    public float mBorderWidth;
    @VisibleForTesting
    public final Matrix mBoundsTransform;
    public final float[] mCornerRadii;
    public final Drawable mDelegate;
    @VisibleForTesting
    public final RectF mDrawableBounds;
    @Nullable
    @VisibleForTesting
    public RectF mInsideBorderBounds;
    @Nullable
    @VisibleForTesting
    public float[] mInsideBorderRadii;
    @Nullable
    @VisibleForTesting
    public Matrix mInsideBorderTransform;
    @VisibleForTesting
    public final Matrix mInverseParentTransform;
    public boolean mIsCircle;
    public boolean mIsPathDirty;
    public boolean mIsShaderTransformDirty;
    public float mPadding;
    public boolean mPaintFilterBitmap;
    @VisibleForTesting
    public final Matrix mParentTransform;
    public final Path mPath;
    @VisibleForTesting
    public final Matrix mPrevBoundsTransform;
    @Nullable
    @VisibleForTesting
    public Matrix mPrevInsideBorderTransform;
    @VisibleForTesting
    public final Matrix mPrevParentTransform;
    @VisibleForTesting
    public final RectF mPrevRootBounds;
    public boolean mRadiiNonZero;
    @VisibleForTesting
    public final RectF mRootBounds;
    public boolean mScaleDownInsideBorders;
    @VisibleForTesting
    public final Matrix mTransform;
    @Nullable
    public TransformCallback mTransformCallback;

    public RoundedDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsCircle = false;
        this.mRadiiNonZero = false;
        this.mBorderWidth = 0.0f;
        this.mPath = new Path();
        this.mIsShaderTransformDirty = true;
        this.mBorderColor = 0;
        this.mBorderPath = new Path();
        this.mCornerRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mRootBounds = new RectF();
        this.mPrevRootBounds = new RectF();
        this.mBitmapBounds = new RectF();
        this.mDrawableBounds = new RectF();
        this.mBoundsTransform = new Matrix();
        this.mPrevBoundsTransform = new Matrix();
        this.mParentTransform = new Matrix();
        this.mPrevParentTransform = new Matrix();
        this.mInverseParentTransform = new Matrix();
        this.mTransform = new Matrix();
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
        this.mIsPathDirty = true;
        this.mDelegate = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDelegate.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("RoundedDrawable#draw");
            }
            this.mDelegate.draw(canvas);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDelegate.getAlpha() : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBorderColor : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBorderWidth : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDelegate.getColorFilter() : (ColorFilter) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDelegate.getIntrinsicHeight() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDelegate.getIntrinsicWidth() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDelegate.getOpacity() : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPadding : invokeV.floatValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPaintFilterBitmap : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCornerRadii : (float[]) invokeV.objValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mScaleDownInsideBorders : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsCircle : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rect) == null) {
            this.mDelegate.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mDelegate.setAlpha(i2);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.mBorderColor == i2 && this.mBorderWidth == f2) {
                return;
            }
            this.mBorderColor = i2;
            this.mBorderWidth = f2;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mIsCircle = z;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, @NonNull PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, mode) == null) {
            this.mDelegate.setColorFilter(i2, mode);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048596, this, f2) == null) || this.mPadding == f2) {
            return;
        }
        this.mPadding = f2;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.mPaintFilterBitmap == z) {
            return;
        }
        this.mPaintFilterBitmap = z;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fArr) == null) {
            if (fArr == null) {
                Arrays.fill(this.mCornerRadii, 0.0f);
                this.mRadiiNonZero = false;
            } else {
                Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
                System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
                this.mRadiiNonZero = false;
                for (int i2 = 0; i2 < 8; i2++) {
                    this.mRadiiNonZero |= fArr[i2] > 0.0f;
                }
            }
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            Preconditions.checkState(i2 >= 0);
            Arrays.fill(this.mCornerRadii, f2);
            this.mRadiiNonZero = i2 != 0;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.mScaleDownInsideBorders == z) {
            return;
        }
        this.mScaleDownInsideBorders = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(@Nullable TransformCallback transformCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, transformCallback) == null) {
            this.mTransformCallback = transformCallback;
        }
    }

    @VisibleForTesting
    public boolean shouldRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0f : invokeV.booleanValue;
    }

    public void updatePath() {
        float[] fArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.mIsPathDirty) {
            this.mBorderPath.reset();
            RectF rectF = this.mRootBounds;
            float f2 = this.mBorderWidth;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.mBorderRadii;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.mCornerRadii[i2] + this.mPadding) - (this.mBorderWidth / 2.0f);
                    i2++;
                }
                this.mBorderPath.addRoundRect(this.mRootBounds, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.mRootBounds;
            float f3 = this.mBorderWidth;
            rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
            this.mPath.reset();
            float f4 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
            this.mRootBounds.inset(f4, f4);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mScaleDownInsideBorders) {
                if (this.mInsideBorderRadii == null) {
                    this.mInsideBorderRadii = new float[8];
                }
                for (int i3 = 0; i3 < this.mBorderRadii.length; i3++) {
                    this.mInsideBorderRadii[i3] = this.mCornerRadii[i3] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            float f5 = -f4;
            this.mRootBounds.inset(f5, f5);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    public void updateTransform() {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            TransformCallback transformCallback = this.mTransformCallback;
            if (transformCallback != null) {
                transformCallback.getTransform(this.mParentTransform);
                this.mTransformCallback.getRootBounds(this.mRootBounds);
            } else {
                this.mParentTransform.reset();
                this.mRootBounds.set(getBounds());
            }
            this.mBitmapBounds.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
            this.mDrawableBounds.set(this.mDelegate.getBounds());
            this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
            if (this.mScaleDownInsideBorders) {
                RectF rectF = this.mInsideBorderBounds;
                if (rectF == null) {
                    this.mInsideBorderBounds = new RectF(this.mRootBounds);
                } else {
                    rectF.set(this.mRootBounds);
                }
                RectF rectF2 = this.mInsideBorderBounds;
                float f2 = this.mBorderWidth;
                rectF2.inset(f2, f2);
                if (this.mInsideBorderTransform == null) {
                    this.mInsideBorderTransform = new Matrix();
                }
                this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
            } else {
                Matrix matrix2 = this.mInsideBorderTransform;
                if (matrix2 != null) {
                    matrix2.reset();
                }
            }
            if (!this.mParentTransform.equals(this.mPrevParentTransform) || !this.mBoundsTransform.equals(this.mPrevBoundsTransform) || ((matrix = this.mInsideBorderTransform) != null && !matrix.equals(this.mPrevInsideBorderTransform))) {
                this.mIsShaderTransformDirty = true;
                this.mParentTransform.invert(this.mInverseParentTransform);
                this.mTransform.set(this.mParentTransform);
                if (this.mScaleDownInsideBorders) {
                    this.mTransform.postConcat(this.mInsideBorderTransform);
                }
                this.mTransform.preConcat(this.mBoundsTransform);
                this.mPrevParentTransform.set(this.mParentTransform);
                this.mPrevBoundsTransform.set(this.mBoundsTransform);
                if (this.mScaleDownInsideBorders) {
                    Matrix matrix3 = this.mPrevInsideBorderTransform;
                    if (matrix3 == null) {
                        this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
                    } else {
                        matrix3.set(this.mInsideBorderTransform);
                    }
                } else {
                    Matrix matrix4 = this.mPrevInsideBorderTransform;
                    if (matrix4 != null) {
                        matrix4.reset();
                    }
                }
            }
            if (this.mRootBounds.equals(this.mPrevRootBounds)) {
                return;
            }
            this.mIsPathDirty = true;
            this.mPrevRootBounds.set(this.mRootBounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, colorFilter) == null) {
            this.mDelegate.setColorFilter(colorFilter);
        }
    }
}
