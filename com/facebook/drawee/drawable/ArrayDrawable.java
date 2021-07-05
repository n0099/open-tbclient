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
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDrawableProperties = new DrawableProperties();
        this.mTmpRect = new Rect();
        int i4 = 0;
        this.mIsStateful = false;
        this.mIsStatefulCalculated = false;
        this.mIsMutated = false;
        Preconditions.checkNotNull(drawableArr);
        this.mLayers = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.mLayers;
            if (i4 < drawableArr2.length) {
                DrawableUtils.setCallbacks(drawableArr2[i4], this, this);
                i4++;
            } else {
                this.mDrawableParents = new DrawableParent[drawableArr2.length];
                return;
            }
        }
    }

    private DrawableParent createDrawableParentForIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? new DrawableParent(this, i2) { // from class: com.facebook.drawee.drawable.ArrayDrawable.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ArrayDrawable this$0;
            public final /* synthetic */ int val$index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$index = i2;
            }

            @Override // com.facebook.drawee.drawable.DrawableParent
            public Drawable getDrawable() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.getDrawable(this.val$index) : (Drawable) invokeV.objValue;
            }

            @Override // com.facebook.drawee.drawable.DrawableParent
            public Drawable setDrawable(Drawable drawable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) ? this.this$0.setDrawable(this.val$index, drawable) : (Drawable) invokeL.objValue;
            }
        } : (DrawableParent) invokeI.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, canvas) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i2++;
        }
    }

    @Nullable
    public Drawable getDrawable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            Preconditions.checkArgument(i2 >= 0);
            Preconditions.checkArgument(i2 < this.mLayers.length);
            return this.mLayers[i2];
        }
        return (Drawable) invokeI.objValue;
    }

    public DrawableParent getDrawableParentForIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Preconditions.checkArgument(i2 >= 0);
            Preconditions.checkArgument(i2 < this.mDrawableParents.length);
            DrawableParent[] drawableParentArr = this.mDrawableParents;
            if (drawableParentArr[i2] == null) {
                drawableParentArr[i2] = createDrawableParentForIndex(i2);
            }
            return this.mDrawableParents[i2];
        }
        return (DrawableParent) invokeI.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = 0;
            int i3 = -1;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    i3 = Math.max(i3, drawable.getIntrinsicHeight());
                }
                i2++;
            }
            if (i3 > 0) {
                return i3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 0;
            int i3 = -1;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    i3 = Math.max(i3, drawable.getIntrinsicWidth());
                }
                i2++;
            }
            if (i3 > 0) {
                return i3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getNumberOfLayers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLayers.length : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.intValue;
        }
        if (this.mLayers.length == 0) {
            return -2;
        }
        int i2 = -1;
        int i3 = 1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return i2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                i2 = Drawable.resolveOpacity(i2, drawable.getOpacity());
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, rect)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.mTmpRect;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
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
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!this.mIsStatefulCalculated) {
                this.mIsStateful = false;
                int i2 = 0;
                while (true) {
                    Drawable[] drawableArr = this.mLayers;
                    boolean z = true;
                    if (i2 >= drawableArr.length) {
                        break;
                    }
                    Drawable drawable = drawableArr[i2];
                    boolean z2 = this.mIsStateful;
                    if (drawable == null || !drawable.isStateful()) {
                        z = false;
                    }
                    this.mIsStateful = z2 | z;
                    i2++;
                }
                this.mIsStatefulCalculated = true;
            }
            return this.mIsStateful;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return (Drawable) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
                i2++;
            } else {
                this.mIsMutated = true;
                return this;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048589, this, rect) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048590, this, i2)) != null) {
            return invokeI.booleanValue;
        }
        int i3 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z = true;
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048591, this, iArr)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) {
            scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048593, this, i2) != null) {
            return;
        }
        this.mDrawableProperties.setAlpha(i2);
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                drawable.setAlpha(i2);
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048594, this, colorFilter) != null) {
            return;
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048595, this, z) != null) {
            return;
        }
        this.mDrawableProperties.setDither(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i2++;
        }
    }

    @Nullable
    public Drawable setDrawable(int i2, @Nullable Drawable drawable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i2, drawable)) == null) {
            Preconditions.checkArgument(i2 >= 0);
            Preconditions.checkArgument(i2 < this.mLayers.length);
            Drawable drawable2 = this.mLayers[i2];
            if (drawable != drawable2) {
                if (drawable != null && this.mIsMutated) {
                    drawable.mutate();
                }
                DrawableUtils.setCallbacks(this.mLayers[i2], null, null);
                DrawableUtils.setCallbacks(drawable, null, null);
                DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
                DrawableUtils.copyProperties(drawable, this);
                DrawableUtils.setCallbacks(drawable, this, this);
                this.mIsStatefulCalculated = false;
                this.mLayers[i2] = drawable;
                invalidateSelf();
            }
            return drawable2;
        }
        return (Drawable) invokeIL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048597, this, z) != null) {
            return;
        }
        this.mDrawableProperties.setFilterBitmap(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setHotspot(f2, f3);
            }
            i2++;
        }
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback transformCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, transformCallback) == null) {
            this.mTransformCallback = transformCallback;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return invokeCommon.booleanValue;
        }
        boolean visible = super.setVisible(z, z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i2++;
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
