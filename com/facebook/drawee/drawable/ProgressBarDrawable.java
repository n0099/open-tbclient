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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private void drawBar(Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, canvas, i) == null) {
            this.mPaint.setColor(i);
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mPath.reset();
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            this.mPath.addRoundRect(this.mRect, Math.min(this.mRadius, this.mBarWidth / 2), Math.min(this.mRadius, this.mBarWidth / 2), Path.Direction.CW);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    private void drawHorizontalBar(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, canvas, i, i2) == null) {
            Rect bounds = getBounds();
            int width = bounds.width();
            int i3 = this.mPadding;
            int i4 = bounds.left + i3;
            int i5 = bounds.bottom - i3;
            int i6 = this.mBarWidth;
            int i7 = i5 - i6;
            this.mRect.set(i4, i7, i4 + (((width - (i3 * 2)) * i) / 10000), i7 + i6);
            drawBar(canvas, i2);
        }
    }

    private void drawVerticalBar(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, this, canvas, i, i2) == null) {
            Rect bounds = getBounds();
            int height = bounds.height();
            int i3 = this.mPadding;
            int i4 = bounds.left + i3;
            int i5 = bounds.top + i3;
            this.mRect.set(i4, i5, i4 + this.mBarWidth, i5 + (((height - (i3 * 2)) * i) / 10000));
            drawBar(canvas, i2);
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
            int i = this.mPadding;
            rect.set(i, i, i, i);
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
    public boolean onLevelChange(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.mLevel = i;
            invalidateSelf();
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mPaint.setAlpha(i);
        }
    }

    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.mBackgroundColor == i) {
            return;
        }
        this.mBackgroundColor = i;
        invalidateSelf();
    }

    public void setBarWidth(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || this.mBarWidth == i) {
            return;
        }
        this.mBarWidth = i;
        invalidateSelf();
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || this.mColor == i) {
            return;
        }
        this.mColor = i;
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

    public void setPadding(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || this.mPadding == i) {
            return;
        }
        this.mPadding = i;
        invalidateSelf();
    }

    public void setRadius(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.mRadius == i) {
            return;
        }
        this.mRadius = i;
        invalidateSelf();
    }
}
