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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ArrayDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DrawableParent[] mDrawableParents;
    public final DrawableProperties mDrawableProperties;
    public boolean mIsMutated;
    public boolean mIsStateful;
    public boolean mIsStatefulCalculated;
    public final Drawable[] mLayers;
    public final Rect mTmpRect;
    public TransformCallback mTransformCallback;

    public ArrayDrawable(Drawable[] drawableArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawableArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDrawableProperties = new DrawableProperties();
        this.mTmpRect = new Rect();
        int i3 = 0;
        this.mIsStateful = false;
        this.mIsStatefulCalculated = false;
        this.mIsMutated = false;
        Preconditions.checkNotNull(drawableArr);
        this.mLayers = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.mLayers;
            if (i3 < drawableArr2.length) {
                DrawableUtils.setCallbacks(drawableArr2[i3], this, this);
                i3++;
            } else {
                this.mDrawableParents = new DrawableParent[drawableArr2.length];
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rect)) == null) {
            int i = 0;
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
            rect.bottom = 0;
            Rect rect2 = this.mTmpRect;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.getPadding(rect2);
                        rect.left = Math.max(rect.left, rect2.left);
                        rect.top = Math.max(rect.top, rect2.top);
                        rect.right = Math.max(rect.right, rect2.right);
                        rect.bottom = Math.max(rect.bottom, rect2.bottom);
                    }
                    i++;
                } else {
                    return true;
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    private DrawableParent createDrawableParentForIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            return new DrawableParent(this, i) { // from class: com.facebook.drawee.drawable.ArrayDrawable.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayDrawable this$0;
                public final /* synthetic */ int val$index;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$index = i;
                }

                @Override // com.facebook.drawee.drawable.DrawableParent
                public Drawable getDrawable() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.this$0.getDrawable(this.val$index);
                    }
                    return (Drawable) invokeV.objValue;
                }

                @Override // com.facebook.drawee.drawable.DrawableParent
                public Drawable setDrawable(Drawable drawable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                        return this.this$0.setDrawable(this.val$index, drawable);
                    }
                    return (Drawable) invokeL.objValue;
                }
            };
        }
        return (DrawableParent) invokeI.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Nullable
    public Drawable getDrawable(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            boolean z2 = true;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            if (i >= this.mLayers.length) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            return this.mLayers[i];
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getRootBounds(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rectF) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048585, this, matrix) == null) {
            TransformCallback transformCallback = this.mTransformCallback;
            if (transformCallback != null) {
                transformCallback.getTransform(matrix);
            } else {
                matrix.reset();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.setBounds(rect);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = 0;
            boolean z = false;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    Drawable drawable = drawableArr[i2];
                    if (drawable != null && drawable.setLevel(i)) {
                        z = true;
                    }
                    i2++;
                } else {
                    return z;
                }
            }
        } else {
            return invokeI.booleanValue;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, iArr)) == null) {
            int i = 0;
            boolean z = false;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null && drawable.setState(iArr)) {
                        z = true;
                    }
                    i++;
                } else {
                    return z;
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mDrawableProperties.setAlpha(i);
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    Drawable drawable = drawableArr[i2];
                    if (drawable != null) {
                        drawable.setAlpha(i);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, colorFilter) == null) {
            this.mDrawableProperties.setColorFilter(colorFilter);
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.setColorFilter(colorFilter);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mDrawableProperties.setDither(z);
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.setDither(z);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mDrawableProperties.setFilterBitmap(z);
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.setFilterBitmap(z);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback transformCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, transformCallback) == null) {
            this.mTransformCallback = transformCallback;
        }
    }

    public DrawableParent getDrawableParentForIndex(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            boolean z2 = true;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            if (i >= this.mDrawableParents.length) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            DrawableParent[] drawableParentArr = this.mDrawableParents;
            if (drawableParentArr[i] == null) {
                drawableParentArr[i] = createDrawableParentForIndex(i);
            }
            return this.mDrawableParents[i];
        }
        return (DrawableParent) invokeI.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = 0;
            int i2 = -1;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i];
                if (drawable != null) {
                    i2 = Math.max(i2, drawable.getIntrinsicHeight());
                }
                i++;
            }
            if (i2 <= 0) {
                return -1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = 0;
            int i2 = -1;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i];
                if (drawable != null) {
                    i2 = Math.max(i2, drawable.getIntrinsicWidth());
                }
                i++;
            }
            if (i2 <= 0) {
                return -1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getNumberOfLayers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mLayers.length;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mLayers.length == 0) {
                return -2;
            }
            int i = -1;
            int i2 = 1;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    Drawable drawable = drawableArr[i2];
                    if (drawable != null) {
                        i = Drawable.resolveOpacity(i, drawable.getOpacity());
                    }
                    i2++;
                } else {
                    return i;
                }
            }
        } else {
            return invokeV.intValue;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.mutate();
                    }
                    i++;
                } else {
                    this.mIsMutated = true;
                    return this;
                }
            }
        } else {
            return (Drawable) invokeV.objValue;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!this.mIsStatefulCalculated) {
                this.mIsStateful = false;
                int i = 0;
                while (true) {
                    Drawable[] drawableArr = this.mLayers;
                    boolean z = true;
                    if (i >= drawableArr.length) {
                        break;
                    }
                    Drawable drawable = drawableArr[i];
                    boolean z2 = this.mIsStateful;
                    if (drawable == null || !drawable.isStateful()) {
                        z = false;
                    }
                    this.mIsStateful = z2 | z;
                    i++;
                }
                this.mIsStatefulCalculated = true;
            }
            return this.mIsStateful;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) {
            scheduleSelf(runnable, j);
        }
    }

    @Nullable
    public Drawable setDrawable(int i, @Nullable Drawable drawable) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, drawable)) == null) {
            boolean z2 = true;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            if (i >= this.mLayers.length) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            Drawable drawable2 = this.mLayers[i];
            if (drawable != drawable2) {
                if (drawable != null && this.mIsMutated) {
                    drawable.mutate();
                }
                DrawableUtils.setCallbacks(this.mLayers[i], null, null);
                DrawableUtils.setCallbacks(drawable, null, null);
                DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
                DrawableUtils.copyProperties(drawable, this);
                DrawableUtils.setCallbacks(drawable, this, this);
                this.mIsStatefulCalculated = false;
                this.mLayers[i] = drawable;
                invalidateSelf();
            }
            return drawable2;
        }
        return (Drawable) invokeIL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.setHotspot(f, f2);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean visible = super.setVisible(z, z2);
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i < drawableArr.length) {
                    Drawable drawable = drawableArr[i];
                    if (drawable != null) {
                        drawable.setVisible(z, z2);
                    }
                    i++;
                } else {
                    return visible;
                }
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, drawable, runnable) == null) {
            unscheduleSelf(runnable);
        }
    }
}
