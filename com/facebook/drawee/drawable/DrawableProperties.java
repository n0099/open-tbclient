package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class DrawableProperties {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    public ColorFilter mColorFilter;
    public int mDither;
    public int mFilterBitmap;
    public boolean mIsSetColorFilter;

    public DrawableProperties() {
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
        this.mAlpha = -1;
        this.mIsSetColorFilter = false;
        this.mColorFilter = null;
        this.mDither = -1;
        this.mFilterBitmap = -1;
    }

    @SuppressLint({"Range"})
    public void applyTo(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) || drawable == null) {
            return;
        }
        int i2 = this.mAlpha;
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        if (this.mIsSetColorFilter) {
            drawable.setColorFilter(this.mColorFilter);
        }
        int i3 = this.mDither;
        if (i3 != -1) {
            drawable.setDither(i3 != 0);
        }
        int i4 = this.mFilterBitmap;
        if (i4 != -1) {
            drawable.setFilterBitmap(i4 != 0);
        }
    }

    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mAlpha = i2;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, colorFilter) == null) {
            this.mColorFilter = colorFilter;
            this.mIsSetColorFilter = true;
        }
    }

    public void setDither(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mDither = z ? 1 : 0;
        }
    }

    public void setFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mFilterBitmap = z ? 1 : 0;
        }
    }
}
