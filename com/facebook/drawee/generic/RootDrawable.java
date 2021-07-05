package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    public static /* synthetic */ Interceptable $ic;
    public static ColorFilter sGlobalColorFilter;
    public transient /* synthetic */ FieldHolder $fh;
    public ColorFilter mColorFilter;
    @VisibleForTesting
    @Nullable
    public Drawable mControllerOverlay;
    public boolean mUserGlobalColorFilter;
    @Nullable
    public VisibilityCallback mVisibilityCallback;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1647425831, "Lcom/facebook/drawee/generic/RootDrawable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1647425831, "Lcom/facebook/drawee/generic/RootDrawable;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RootDrawable(Drawable drawable) {
        super(drawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mControllerOverlay = null;
        this.mColorFilter = null;
        this.mUserGlobalColorFilter = true;
    }

    public static ColorFilter getGlobalColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sGlobalColorFilter : (ColorFilter) invokeV.objValue;
    }

    public static void setGlobalColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, colorFilter) == null) {
            sGlobalColorFilter = colorFilter;
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        ColorFilter colorFilter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && isVisible()) {
            if (this.mUserGlobalColorFilter && (colorFilter = sGlobalColorFilter) != this.mColorFilter) {
                this.mColorFilter = colorFilter;
                setColorFilter(colorFilter);
            }
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
            Drawable drawable = this.mControllerOverlay;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.mControllerOverlay.draw(canvas);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean getUseGlobalColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUserGlobalColorFilter : invokeV.booleanValue;
    }

    public void setControllerOverlay(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.mControllerOverlay = drawable;
            invalidateSelf();
        }
    }

    public void setUseGlobalColorFilter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mUserGlobalColorFilter = z;
        }
    }

    @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void setVisibilityCallback(@Nullable VisibilityCallback visibilityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, visibilityCallback) == null) {
            this.mVisibilityCallback = visibilityCallback;
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onVisibilityChange(z);
            }
            return super.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }
}
