package com.tachikoma.core.component.view;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.tachikoma.core.utility.TKUtility;
/* loaded from: classes7.dex */
public class ViewBackgroundManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackgroundColor;
    public float mFullRadius;
    public float[] mRadius;
    public TKViewBackgroundDrawable mReactBackgroundDrawable;
    public View mView;

    public ViewBackgroundManager(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBackgroundColor = -1;
        this.mRadius = new float[8];
        this.mView = view;
    }

    private TKViewBackgroundDrawable getOrCreateReactViewBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mReactBackgroundDrawable == null) {
                TKViewBackgroundDrawable tKViewBackgroundDrawable = new TKViewBackgroundDrawable(this.mView.getContext());
                this.mReactBackgroundDrawable = tKViewBackgroundDrawable;
                setBackgroundDrawable(tKViewBackgroundDrawable);
            }
            return this.mReactBackgroundDrawable;
        }
        return (TKViewBackgroundDrawable) invokeV.objValue;
    }

    private boolean hasRoundedRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            for (float f2 : this.mRadius) {
                if (f2 > 0.0f) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, drawable) == null) {
            TKViewHelper.setBackground(this.mView, null);
            Drawable background = this.mView.getBackground();
            if (background == null) {
                TKViewHelper.setBackground(this.mView, drawable);
            } else {
                TKViewHelper.setBackground(this.mView, new LayerDrawable(new Drawable[]{drawable, background}));
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mView = null;
        }
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getOrCreateReactViewBackground().getColor() : invokeV.intValue;
    }

    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i == 0 && this.mReactBackgroundDrawable == null) {
                return;
            }
            this.mBackgroundColor = i;
            getOrCreateReactViewBackground().setColor(i);
        }
    }

    public void setBackgroundGradientColor(int i, int[] iArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, iArr, fArr) == null) {
            getOrCreateReactViewBackground().setBackgroundGradientColor(i, iArr, fArr);
        }
    }

    public void setBackgroundImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Drawable drawable = null;
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("/")) {
                    drawable = new BitmapDrawable(BitmapFactory.decodeFile(str));
                } else {
                    drawable = this.mView.getResources().getDrawable(TKUtility.getResourceId(str, ResourceManager.DRAWABLE, null));
                }
            }
            setBackgroundDrawable(drawable);
        }
    }

    public void setBorderColor(int i, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            getOrCreateReactViewBackground().setBorderColor(i, f2, f3);
        }
    }

    public void setBorderColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            getOrCreateReactViewBackground().setBorderColor(str);
        }
    }

    public void setBorderRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            getOrCreateReactViewBackground().setRadius(f2);
            this.mFullRadius = f2;
        }
    }

    public void setBorderRadius(float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            getOrCreateReactViewBackground().setRadius(f2, i);
            float[] fArr = this.mRadius;
            int i2 = (i % 4) * 2;
            fArr[i2] = f2;
            fArr[i2 + 1] = f2;
        }
    }

    public void setBorderStyle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            getOrCreateReactViewBackground().setBorderStyle(str);
        }
    }

    public void setBorderWidth(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            getOrCreateReactViewBackground().setBorderWidth(i, f2);
        }
    }

    public void setOpacity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            getOrCreateReactViewBackground().setAlpha((int) (f2 * 255.0f));
        }
    }

    public void setShadow(float f2, float f3, float f4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i)}) == null) {
            getOrCreateReactViewBackground().setShadow(f2, f3, f4, i);
        }
    }
}
