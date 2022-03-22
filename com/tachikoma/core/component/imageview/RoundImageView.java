package com.tachikoma.core.component.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.utility.TKConverter;
/* loaded from: classes7.dex */
public class RoundImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Bitmap.Config BITMAP_CONFIG;
    public static final int COLORDRAWABLE_DIMENSION = 1;
    public static final int DEFAULT_BORDER_COLOR = 0;
    public static final int DEFAULT_BORDER_WIDTH = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBitmap;
    public int mBitmapHeight;
    public final Paint mBitmapPaint;
    public BitmapShader mBitmapShader;
    public int mBitmapWidth;
    public int mBorderColor;
    public final Paint mBorderPaint;
    public final RectF mBorderRect;
    public float mBorderWidth;
    public float mBottomLeftRoundRadius;
    public float mBottomRightRoundRadius;
    public float mCircleRadius;
    public final RectF mDrawableRect;
    public boolean mReady;
    public boolean mSetupPending;
    public final Matrix mShaderMatrix;
    public float mShadowWidth;
    public float mTopLeftRoundRadius;
    public float mTopRightRoundRadius;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(704515634, "Lcom/tachikoma/core/component/imageview/RoundImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(704515634, "Lcom/tachikoma/core/component/imageview/RoundImageView;");
                return;
            }
        }
        BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = 0;
        this.mBorderWidth = 0.0f;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(1, 1, BITMAP_CONFIG) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (Throwable th) {
                Logger.logE("RoundImageView getBitmapFromDrawable exception:", th);
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    private void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (!this.mReady) {
                this.mSetupPending = true;
            } else if (this.mBitmap == null) {
            } else {
                Bitmap bitmap = this.mBitmap;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                this.mBitmapPaint.setAntiAlias(true);
                this.mBitmapPaint.setShader(this.mBitmapShader);
                this.mBorderPaint.setStyle(Paint.Style.STROKE);
                this.mBorderPaint.setAntiAlias(true);
                this.mBorderPaint.setColor(this.mBorderColor);
                this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
                this.mBitmapHeight = this.mBitmap.getHeight();
                this.mBitmapWidth = this.mBitmap.getWidth();
                RectF rectF = this.mBorderRect;
                float f2 = this.mBorderWidth;
                float f3 = this.mShadowWidth;
                rectF.set((f2 / 2.0f) + f3, (f2 / 2.0f) + f3, (getWidth() - (this.mBorderWidth / 2.0f)) - this.mShadowWidth, (getHeight() - (this.mBorderWidth / 2.0f)) - this.mShadowWidth);
                RectF rectF2 = this.mDrawableRect;
                float f4 = this.mBorderWidth;
                float f5 = this.mShadowWidth;
                rectF2.set((f4 / 2.0f) + f5, (f4 / 2.0f) + f5, (getWidth() - (this.mBorderWidth / 2.0f)) - this.mShadowWidth, (getHeight() - (this.mBorderWidth / 2.0f)) - this.mShadowWidth);
                this.mCircleRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
                updateShaderMatrix();
                invalidate();
            }
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mShaderMatrix.set(null);
            float f2 = 0.0f;
            if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
                width = this.mDrawableRect.height() / this.mBitmapHeight;
                f2 = (this.mDrawableRect.width() - (this.mBitmapWidth * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.mDrawableRect.width() / this.mBitmapWidth;
                height = (this.mDrawableRect.height() - (this.mBitmapHeight * width)) * 0.5f;
            }
            this.mShaderMatrix.setScale(width, width);
            Matrix matrix = this.mShaderMatrix;
            float f3 = this.mBorderWidth;
            matrix.postTranslate(((int) (f2 + 0.5f)) + f3, ((int) (height + 0.5f)) + f3);
            this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        }
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBorderColor : invokeV.intValue;
    }

    public float getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBorderWidth : invokeV.floatValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || getDrawable() == null) {
            return;
        }
        Path path = new Path();
        float min = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        float min2 = Math.min(this.mTopLeftRoundRadius, min);
        float min3 = Math.min(this.mTopRightRoundRadius, min);
        float min4 = Math.min(this.mBottomRightRoundRadius, min);
        float min5 = Math.min(this.mBottomLeftRoundRadius, min);
        path.addRoundRect(this.mDrawableRect, new float[]{min2, min2, min3, min3, min4, min4, min5, min5}, Path.Direction.CW);
        canvas.drawPath(path, this.mBitmapPaint);
        if (this.mBorderWidth > 0.0f) {
            if (this.mTopLeftRoundRadius <= 0.0f && this.mTopRightRoundRadius <= 0.0f && this.mBottomRightRoundRadius <= 0.0f && this.mBottomLeftRoundRadius <= 0.0f) {
                canvas.drawRect(this.mBorderRect, this.mBorderPaint);
                return;
            }
            Path path2 = new Path();
            path2.addRoundRect(this.mBorderRect, new float[]{min2, min2, min3, min3, min4, min4, min5, min5}, Path.Direction.CW);
            canvas.drawPath(path2, this.mBorderPaint);
        }
    }

    public void onShadowSet(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || this.mShadowWidth == f2) {
            return;
        }
        this.mShadowWidth = f2;
        setup();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            setup();
        }
    }

    public void setBorderColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i;
        this.mBorderPaint.setColor(i);
        invalidate();
    }

    public void setBorderRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            float dp2px = TKConverter.dp2px(Tachikoma.sApplication, f2);
            this.mTopLeftRoundRadius = dp2px;
            this.mTopRightRoundRadius = dp2px;
            this.mBottomRightRoundRadius = dp2px;
            this.mBottomLeftRoundRadius = dp2px;
            setup();
        }
    }

    public void setBorderWidth(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || f2 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = f2;
        setup();
    }

    public void setBottomLeftRoundRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.mBottomLeftRoundRadius = f2;
        }
    }

    public void setBottomRightRoundRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.mBottomRightRoundRadius = f2;
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bitmap) == null) {
            super.setImageBitmap(bitmap);
            this.mBitmap = bitmap;
            setup();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            super.setImageDrawable(drawable);
            this.mBitmap = getBitmapFromDrawable(drawable);
            setup();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.setImageResource(i);
            this.mBitmap = getBitmapFromDrawable(getDrawable());
            setup();
        }
    }

    public void setTopLeftRoundRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.mTopLeftRoundRadius = f2;
        }
    }

    public void setTopRightRoundRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.mTopRightRoundRadius = f2;
        }
    }
}
