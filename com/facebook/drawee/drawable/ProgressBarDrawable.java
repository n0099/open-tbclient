package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ProgressBarDrawable extends Drawable implements CloneableDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackgroundColor;
    public int mBarWidth;
    public int mColor;
    public boolean mHideWhenZero;
    public boolean mIsVertical;
    public int mLevel;
    public int mPadding;
    public final Paint mPaint;
    public final Path mPath;
    public int mRadius;
    public final RectF mRect;

    public ProgressBarDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPaint = new Paint(1);
        this.mPath = new Path();
        this.mRect = new RectF();
        this.mBackgroundColor = Integer.MIN_VALUE;
        this.mColor = -2147450625;
        this.mPadding = 10;
        this.mBarWidth = 20;
        this.mLevel = 0;
        this.mRadius = 0;
        this.mHideWhenZero = false;
        this.mIsVertical = false;
    }

    private void drawBar(Canvas canvas, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, canvas, i2) == null) {
            this.mPaint.setColor(i2);
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mPath.reset();
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            this.mPath.addRoundRect(this.mRect, Math.min(this.mRadius, this.mBarWidth / 2), Math.min(this.mRadius, this.mBarWidth / 2), Path.Direction.CW);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    private void drawHorizontalBar(Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, canvas, i2, i3) == null) {
            Rect bounds = getBounds();
            int width = bounds.width();
            int i4 = this.mPadding;
            int i5 = bounds.left + i4;
            int i6 = bounds.bottom - i4;
            int i7 = this.mBarWidth;
            int i8 = i6 - i7;
            this.mRect.set(i5, i8, i5 + (((width - (i4 * 2)) * i2) / 10000), i8 + i7);
            drawBar(canvas, i3);
        }
    }

    private void drawVerticalBar(Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, this, canvas, i2, i3) == null) {
            Rect bounds = getBounds();
            int height = bounds.height();
            int i4 = this.mPadding;
            int i5 = bounds.left + i4;
            int i6 = bounds.top + i4;
            this.mRect.set(i5, i6, i5 + this.mBarWidth, i6 + (((height - (i4 * 2)) * i2) / 10000));
            drawBar(canvas, i3);
        }
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public Drawable cloneDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProgressBarDrawable progressBarDrawable = new ProgressBarDrawable();
            progressBarDrawable.mBackgroundColor = this.mBackgroundColor;
            progressBarDrawable.mColor = this.mColor;
            progressBarDrawable.mPadding = this.mPadding;
            progressBarDrawable.mBarWidth = this.mBarWidth;
            progressBarDrawable.mLevel = this.mLevel;
            progressBarDrawable.mRadius = this.mRadius;
            progressBarDrawable.mHideWhenZero = this.mHideWhenZero;
            progressBarDrawable.mIsVertical = this.mIsVertical;
            return progressBarDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (this.mHideWhenZero && this.mLevel == 0) {
                return;
            }
            if (this.mIsVertical) {
                drawVerticalBar(canvas, 10000, this.mBackgroundColor);
                drawVerticalBar(canvas, this.mLevel, this.mColor);
                return;
            }
            drawHorizontalBar(canvas, 10000, this.mBackgroundColor);
            drawHorizontalBar(canvas, this.mLevel, this.mColor);
        }
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBackgroundColor : invokeV.intValue;
    }

    public int getBarWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBarWidth : invokeV.intValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mColor : invokeV.intValue;
    }

    public boolean getHideWhenZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mHideWhenZero : invokeV.booleanValue;
    }

    public boolean getIsVertical() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsVertical : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? DrawableUtils.getOpacityFromColor(this.mPaint.getColor()) : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect)) == null) {
            int i2 = this.mPadding;
            rect.set(i2, i2, i2, i2);
            return this.mPadding != 0;
        }
        return invokeL.booleanValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRadius : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.mLevel = i2;
            invalidateSelf();
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mPaint.setAlpha(i2);
        }
    }

    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.mBackgroundColor == i2) {
            return;
        }
        this.mBackgroundColor = i2;
        invalidateSelf();
    }

    public void setBarWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.mBarWidth == i2) {
            return;
        }
        this.mBarWidth = i2;
        invalidateSelf();
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || this.mColor == i2) {
            return;
        }
        this.mColor = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    public void setHideWhenZero(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mHideWhenZero = z;
        }
    }

    public void setIsVertical(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.mIsVertical == z) {
            return;
        }
        this.mIsVertical = z;
        invalidateSelf();
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || this.mPadding == i2) {
            return;
        }
        this.mPadding = i2;
        invalidateSelf();
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.mRadius == i2) {
            return;
        }
        this.mRadius = i2;
        invalidateSelf();
    }
}
