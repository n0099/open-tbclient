package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
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
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class RoundedColorDrawable extends Drawable implements Rounded {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    public int mBorderColor;
    @VisibleForTesting
    public final Path mBorderPath;
    @VisibleForTesting
    public final float[] mBorderRadii;
    public float mBorderWidth;
    public int mColor;
    @VisibleForTesting
    @Nullable
    public float[] mInsideBorderRadii;
    public boolean mIsCircle;
    public float mPadding;
    @VisibleForTesting
    public final Paint mPaint;
    public boolean mPaintFilterBitmap;
    @VisibleForTesting
    public final Path mPath;
    public final float[] mRadii;
    public boolean mScaleDownInsideBorders;
    public final RectF mTempRect;

    public RoundedColorDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mPadding = 0.0f;
        this.mBorderColor = 0;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mColor = 0;
        this.mTempRect = new RectF();
        this.mAlpha = 255;
        setColor(i2);
    }

    @TargetApi(11)
    public static RoundedColorDrawable fromColorDrawable(ColorDrawable colorDrawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, colorDrawable)) == null) ? new RoundedColorDrawable(colorDrawable.getColor()) : (RoundedColorDrawable) invokeL.objValue;
    }

    private void updatePath() {
        float[] fArr;
        float[] fArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mPath.reset();
            this.mBorderPath.reset();
            this.mTempRect.set(getBounds());
            RectF rectF = this.mTempRect;
            float f2 = this.mBorderWidth;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            int i2 = 0;
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i3 = 0;
                while (true) {
                    fArr = this.mBorderRadii;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    fArr[i3] = (this.mRadii[i3] + this.mPadding) - (this.mBorderWidth / 2.0f);
                    i3++;
                }
                this.mBorderPath.addRoundRect(this.mTempRect, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.mTempRect;
            float f3 = this.mBorderWidth;
            rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
            float f4 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
            this.mTempRect.inset(f4, f4);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mScaleDownInsideBorders) {
                if (this.mInsideBorderRadii == null) {
                    this.mInsideBorderRadii = new float[8];
                }
                while (true) {
                    fArr2 = this.mInsideBorderRadii;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    fArr2[i2] = this.mRadii[i2] - this.mBorderWidth;
                    i2++;
                }
                this.mPath.addRoundRect(this.mTempRect, fArr2, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mTempRect, this.mRadii, Path.Direction.CW);
            }
            float f5 = -f4;
            this.mTempRect.inset(f5, f5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setFilterBitmap(getPaintFilterBitmap());
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mBorderWidth != 0.0f) {
                this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(this.mBorderWidth);
                canvas.drawPath(this.mBorderPath, this.mPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAlpha : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBorderColor : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBorderWidth : invokeV.floatValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mColor : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha)) : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPadding : invokeV.floatValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPaintFilterBitmap : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRadii : (float[]) invokeV.objValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mScaleDownInsideBorders : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIsCircle : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            super.onBoundsChange(rect);
            updatePath();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 == this.mAlpha) {
            return;
        }
        this.mAlpha = i2;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.mBorderColor != i2) {
                this.mBorderColor = i2;
                invalidateSelf();
            }
            if (this.mBorderWidth != f2) {
                this.mBorderWidth = f2;
                updatePath();
                invalidateSelf();
            }
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorderColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsCircle = z;
            updatePath();
            invalidateSelf();
        }
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.mColor == i2) {
            return;
        }
        this.mColor = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, colorFilter) == null) {
            setBorderColorFilter(colorFilter);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048594, this, f2) == null) || this.mPadding == f2) {
            return;
        }
        this.mPadding = f2;
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.mPaintFilterBitmap == z) {
            return;
        }
        this.mPaintFilterBitmap = z;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fArr) == null) {
            if (fArr == null) {
                Arrays.fill(this.mRadii, 0.0f);
            } else {
                Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
                System.arraycopy(fArr, 0, this.mRadii, 0, 8);
            }
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            Preconditions.checkArgument(f2 >= 0.0f, "radius should be non negative");
            Arrays.fill(this.mRadii, f2);
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || this.mScaleDownInsideBorders == z) {
            return;
        }
        this.mScaleDownInsideBorders = z;
        updatePath();
        invalidateSelf();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundedColorDrawable(float[] fArr, int i2) {
        this(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setRadii(fArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundedColorDrawable(float f2, int i2) {
        this(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setRadius(f2);
    }
}
