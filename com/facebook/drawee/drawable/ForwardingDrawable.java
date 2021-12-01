package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
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
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {
    public static /* synthetic */ Interceptable $ic;
    public static final Matrix sTempTransform;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Drawable mCurrentDelegate;
    public final DrawableProperties mDrawableProperties;
    public TransformCallback mTransformCallback;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-169222549, "Lcom/facebook/drawee/drawable/ForwardingDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-169222549, "Lcom/facebook/drawee/drawable/ForwardingDrawable;");
                return;
            }
        }
        sTempTransform = new Matrix();
    }

    public ForwardingDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDrawableProperties = new DrawableProperties();
        this.mCurrentDelegate = drawable;
        DrawableUtils.setCallbacks(drawable, this, this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || (drawable = this.mCurrentDelegate) == null) {
            return;
        }
        drawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return super.getConstantState();
            }
            return drawable.getConstantState();
        }
        return (Drawable.ConstantState) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable getCurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentDelegate : (Drawable) invokeV.objValue;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    @Nullable
    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getCurrent() : (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return super.getIntrinsicHeight();
            }
            return drawable.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return super.getIntrinsicWidth();
            }
            return drawable.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return 0;
            }
            return drawable.getOpacity();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rect)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return super.getPadding(rect);
            }
            return drawable.getPadding(rect);
        }
        return invokeL.booleanValue;
    }

    public void getParentTransform(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, matrix) == null) {
            TransformCallback transformCallback = this.mTransformCallback;
            if (transformCallback != null) {
                transformCallback.getTransform(matrix);
            } else {
                matrix.reset();
            }
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getRootBounds(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rectF) == null) {
            TransformCallback transformCallback = this.mTransformCallback;
            if (transformCallback != null) {
                transformCallback.getRootBounds(rectF);
            } else {
                rectF.set(getBounds());
            }
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, matrix) == null) {
            getParentTransform(matrix);
        }
    }

    public void getTransformedBounds(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rectF) == null) {
            getParentTransform(sTempTransform);
            rectF.set(getBounds());
            sTempTransform.mapRect(rectF);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return false;
            }
            return drawable.isStateful();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.mutate();
            }
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, rect) == null) || (drawable = this.mCurrentDelegate) == null) {
            return;
        }
        drawable.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return super.onLevelChange(i2);
            }
            return drawable.setLevel(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, iArr)) == null) {
            Drawable drawable = this.mCurrentDelegate;
            if (drawable == null) {
                return super.onStateChange(iArr);
            }
            return drawable.setState(iArr);
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{drawable, runnable, Long.valueOf(j2)}) == null) {
            scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mDrawableProperties.setAlpha(i2);
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.setAlpha(i2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, colorFilter) == null) {
            this.mDrawableProperties.setColorFilter(colorFilter);
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Nullable
    public Drawable setCurrent(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, drawable)) == null) {
            Drawable currentWithoutInvalidate = setCurrentWithoutInvalidate(drawable);
            invalidateSelf();
            return currentWithoutInvalidate;
        }
        return (Drawable) invokeL.objValue;
    }

    @Nullable
    public Drawable setCurrentWithoutInvalidate(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, drawable)) == null) {
            Drawable drawable2 = this.mCurrentDelegate;
            DrawableUtils.setCallbacks(drawable2, null, null);
            DrawableUtils.setCallbacks(drawable, null, null);
            DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
            DrawableUtils.copyProperties(drawable, this);
            DrawableUtils.setCallbacks(drawable, this, this);
            this.mCurrentDelegate = drawable;
            return drawable2;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mDrawableProperties.setDither(z);
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable setDrawable(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, drawable)) == null) ? setCurrent(drawable) : (Drawable) invokeL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.mDrawableProperties.setFilterBitmap(z);
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (drawable = this.mCurrentDelegate) == null) {
            return;
        }
        drawable.setHotspot(f2, f3);
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback transformCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, transformCallback) == null) {
            this.mTransformCallback = transformCallback;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean visible = super.setVisible(z, z2);
            Drawable drawable = this.mCurrentDelegate;
            return drawable == null ? visible : drawable.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, drawable, runnable) == null) {
            unscheduleSelf(runnable);
        }
    }
}
