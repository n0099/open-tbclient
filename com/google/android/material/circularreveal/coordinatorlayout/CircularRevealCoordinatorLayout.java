package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
/* loaded from: classes7.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements CircularRevealWidget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final CircularRevealHelper helper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircularRevealCoordinatorLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.Delegate
    public void actualDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.Delegate
    public boolean actualIsOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.isOpaque() : invokeV.booleanValue;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void buildCircularRevealCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.helper.buildCircularRevealCache();
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void destroyCircularRevealCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.helper.destroyCircularRevealCache();
        }
    }

    @Override // android.view.View, com.google.android.material.circularreveal.CircularRevealWidget
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            CircularRevealHelper circularRevealHelper = this.helper;
            if (circularRevealHelper != null) {
                circularRevealHelper.draw(canvas);
            } else {
                super.draw(canvas);
            }
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.helper.getCircularRevealOverlayDrawable() : (Drawable) invokeV.objValue;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.helper.getCircularRevealScrimColor() : invokeV.intValue;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.helper.getRevealInfo() : (CircularRevealWidget.RevealInfo) invokeV.objValue;
    }

    @Override // android.view.View, com.google.android.material.circularreveal.CircularRevealWidget
    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            CircularRevealHelper circularRevealHelper = this.helper;
            if (circularRevealHelper != null) {
                return circularRevealHelper.isOpaque();
            }
            return super.isOpaque();
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.helper.setCircularRevealOverlayDrawable(drawable);
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.helper.setCircularRevealScrimColor(i2);
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, revealInfo) == null) {
            this.helper.setRevealInfo(revealInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularRevealCoordinatorLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.helper = new CircularRevealHelper(this);
    }
}
