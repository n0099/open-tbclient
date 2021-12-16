package com.tachikoma.core.component.listview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.TimeFunctionConst;
import com.tachikoma.core.component.listview.TKPagerIndicatorDecoration;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class TKIndicator extends TKBase<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mActiveColor;
    public String mInActiveColor;
    public int mMarginTop;
    public int mPadding;
    public int mSize;
    public int mTextSize;
    public String mType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKIndicator(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TKPagerIndicatorDecoration.IIndicatorRender create() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.mType;
            int hashCode = str.hashCode();
            if (hashCode == -1360216880) {
                if (str.equals("circle")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != -1102672091) {
                if (hashCode == -1034364087 && str.equals("number")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(TimeFunctionConst.Timing.LINEAR)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return new TKCircleIndicator(this.mSize, this.mMarginTop, this.mPadding, Color.parseColor(this.mInActiveColor), Color.parseColor(this.mActiveColor));
                }
                TKNumberIndicator tKNumberIndicator = new TKNumberIndicator(Color.parseColor(this.mActiveColor));
                tKNumberIndicator.setTextSize(this.mTextSize);
                return tKNumberIndicator;
            }
            return new TKLineIndicator();
        }
        return (TKPagerIndicatorDecoration.IIndicatorRender) invokeV.objValue;
    }

    @Override // com.tachikoma.core.component.TKBase
    public View createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public void setActiveColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mActiveColor = str;
        }
    }

    public void setInActiveColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mInActiveColor = str;
        }
    }

    public void setMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mMarginTop = i2;
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mPadding = i2;
        }
    }

    public void setSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mSize = i2;
        }
    }

    public void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mTextSize = i2;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mType = str;
        }
    }
}
