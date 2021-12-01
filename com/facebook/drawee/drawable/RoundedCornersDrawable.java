package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBorderColor;
    public final Path mBorderPath;
    @VisibleForTesting
    public final float[] mBorderRadii;
    public float mBorderWidth;
    public final RectF mBounds;
    @Nullable
    public RectF mInsideBorderBounds;
    @Nullable
    public Matrix mInsideBorderTransform;
    public boolean mIsCircle;
    public int mOverlayColor;
    public float mPadding;
    @VisibleForTesting
    public final Paint mPaint;
    public boolean mPaintFilterBitmap;
    public final Path mPath;
    public final float[] mRadii;
    public boolean mScaleDownInsideBorders;
    public final RectF mTempRectangle;
    @VisibleForTesting
    public Type mType;

    /* renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1317611306, "Lcom/facebook/drawee/drawable/RoundedCornersDrawable$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1317611306, "Lcom/facebook/drawee/drawable/RoundedCornersDrawable$1;");
                    return;
                }
            }
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = iArr;
            try {
                iArr[Type.CLIPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[Type.OVERLAY_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type CLIPPING;
        public static final Type OVERLAY_COLOR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1286580001, "Lcom/facebook/drawee/drawable/RoundedCornersDrawable$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1286580001, "Lcom/facebook/drawee/drawable/RoundedCornersDrawable$Type;");
                    return;
                }
            }
            OVERLAY_COLOR = new Type("OVERLAY_COLOR", 0);
            Type type = new Type("CLIPPING", 1);
            CLIPPING = type;
            $VALUES = new Type[]{OVERLAY_COLOR, type};
        }

        public Type(String str, int i2) {
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

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mType = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mOverlayColor = 0;
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mTempRectangle = new RectF();
    }

    private void updatePath() {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mPath.reset();
            this.mBorderPath.reset();
            this.mTempRectangle.set(getBounds());
            RectF rectF = this.mTempRectangle;
            float f2 = this.mPadding;
            rectF.inset(f2, f2);
            this.mPath.addRect(this.mTempRectangle, Path.Direction.CW);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
            }
            RectF rectF2 = this.mTempRectangle;
            float f3 = this.mPadding;
            rectF2.inset(-f3, -f3);
            RectF rectF3 = this.mTempRectangle;
            float f4 = this.mBorderWidth;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.mBorderRadii;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.mRadii[i2] + this.mPadding) - (this.mBorderWidth / 2.0f);
                    i2++;
                }
                this.mBorderPath.addRoundRect(this.mTempRectangle, fArr, Path.Direction.CW);
            }
            RectF rectF4 = this.mTempRectangle;
            float f5 = this.mBorderWidth;
            rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.mBounds.set(getBounds());
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()];
            if (i2 == 1) {
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                if (this.mScaleDownInsideBorders) {
                    RectF rectF = this.mInsideBorderBounds;
                    if (rectF == null) {
                        this.mInsideBorderBounds = new RectF(this.mBounds);
                        this.mInsideBorderTransform = new Matrix();
                    } else {
                        rectF.set(this.mBounds);
                    }
                    RectF rectF2 = this.mInsideBorderBounds;
                    float f2 = this.mBorderWidth;
                    rectF2.inset(f2, f2);
                    this.mInsideBorderTransform.setRectToRect(this.mBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.mInsideBorderTransform);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mOverlayColor);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPaint.setFilterBitmap(getPaintFilterBitmap());
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.mIsCircle) {
                    float width = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
                    float height = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
                    if (width > 0.0f) {
                        RectF rectF3 = this.mBounds;
                        float f3 = rectF3.left;
                        canvas.drawRect(f3, rectF3.top, f3 + width, rectF3.bottom, this.mPaint);
                        RectF rectF4 = this.mBounds;
                        float f4 = rectF4.right;
                        canvas.drawRect(f4 - width, rectF4.top, f4, rectF4.bottom, this.mPaint);
                    }
                    if (height > 0.0f) {
                        RectF rectF5 = this.mBounds;
                        float f5 = rectF5.left;
                        float f6 = rectF5.top;
                        canvas.drawRect(f5, f6, rectF5.right, f6 + height, this.mPaint);
                        RectF rectF6 = this.mBounds;
                        float f7 = rectF6.left;
                        float f8 = rectF6.bottom;
                        canvas.drawRect(f7, f8 - height, rectF6.right, f8, this.mPaint);
                    }
                }
            }
            if (this.mBorderColor != 0) {
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setColor(this.mBorderColor);
                this.mPaint.setStrokeWidth(this.mBorderWidth);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mBorderPath, this.mPaint);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBorderColor : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBorderWidth : invokeV.floatValue;
    }

    public int getOverlayColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOverlayColor : invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPadding : invokeV.floatValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPaintFilterBitmap : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRadii : (float[]) invokeV.objValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mScaleDownInsideBorders : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsCircle : invokeV.booleanValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            super.onBoundsChange(rect);
            updatePath();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mBorderColor = i2;
            this.mBorderWidth = f2;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorderColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mIsCircle = z;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, colorFilter) == null) {
            super.setColorFilter(colorFilter);
            setBorderColorFilter(colorFilter);
        }
    }

    public void setOverlayColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mOverlayColor = i2;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.mPadding = f2;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.mPaintFilterBitmap == z) {
            return;
        }
        this.mPaintFilterBitmap = z;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fArr) == null) {
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
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            Arrays.fill(this.mRadii, f2);
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mScaleDownInsideBorders = z;
            updatePath();
            invalidateSelf();
        }
    }

    public void setType(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, type) == null) {
            this.mType = type;
            invalidateSelf();
        }
    }
}
