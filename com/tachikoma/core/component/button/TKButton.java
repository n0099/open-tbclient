package com.tachikoma.core.component.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.StateSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.input.TextAlign;
import com.tachikoma.core.component.text.FontManager;
import com.tachikoma.core.component.text.SpanItem;
import com.tachikoma.core.utility.TKColorUtil;
import java.util.HashMap;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class TKButton extends TKBase<Button> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap disabled;
    public StateListDrawable mStateListDrawable;
    public HashMap pressed;
    public String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKButton(Context context, @Nullable List<Object> list) {
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
        getView().setAllCaps(false);
        if (Build.VERSION.SDK_INT >= 21) {
            getView().setStateListAnimator(null);
        }
    }

    private void updateDrawable(int[] iArr, HashMap hashMap) {
        ColorStateList textColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, iArr, hashMap) == null) {
            GradientDrawable createGradientDrawable = StyleHelper.createGradientDrawable(hashMap);
            if (this.mStateListDrawable == null) {
                this.mStateListDrawable = new StateListDrawable();
            }
            if (createGradientDrawable != null) {
                createGradientDrawable.setCornerRadius(this.mBorderRadius);
                this.mStateListDrawable.addState(iArr, createGradientDrawable);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(this.mBorderRadius);
                String str = this.mBackgroundColor;
                if (str != null) {
                    gradientDrawable.setColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
                }
                this.mStateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
                getView().setBackground(this.mStateListDrawable);
            }
            HashMap hashMap2 = this.style;
            if (hashMap2 == null || (textColor = StyleHelper.getTextColor(hashMap2)) == null) {
                return;
            }
            getView().setTextColor(textColor);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public Button createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Button button = new Button(context);
            button.setMinimumWidth(0);
            button.setMinimumHeight(0);
            button.setMinWidth(0);
            button.setMinHeight(0);
            return button;
        }
        return (Button) invokeL.objValue;
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            if (getView() != null) {
                getView().setOnClickListener(null);
            }
        }
    }

    public void setColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            getView().setTextColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
        }
    }

    public void setDisabled(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.disabled = hashMap;
            updateDrawable(new int[]{16842910}, hashMap);
        }
    }

    public void setFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            getView().setTypeface(FontManager.getInstance().getTypeface(str, getView().getTypeface() != null ? getView().getTypeface().getStyle() : 0, getView().getContext().getAssets(), !TextUtils.isEmpty(str) ? getRootDir().concat(str) : ""));
        }
    }

    public void setFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            getView().setTextSize(1, i2);
        }
    }

    public void setFontWeight(String str) {
        Button view;
        Typeface typeface;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.equals(str, SpanItem.STYLE_BOLD)) {
                view = getView();
                typeface = getView().getTypeface();
                i2 = 1;
            } else if (!TextUtils.equals(str, "normal")) {
                return;
            } else {
                view = getView();
                typeface = getView().getTypeface();
                i2 = 0;
            }
            view.setTypeface(typeface, i2);
        }
    }

    public void setPressed(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) {
            this.pressed = hashMap;
            updateDrawable(new int[]{16842919, 16842910}, hashMap);
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setStyle(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hashMap) == null) {
            takeControlOfPaddingSet(hashMap);
            super.setStyle(hashMap);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.text = str;
            getView().setText(this.text);
        }
    }

    public void setTextAlign(String str) {
        char c2;
        Button view;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -1364013995) {
                if (str.equals(TextAlign.CENTER)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (str.equals("left")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                view = getView();
                i2 = 17;
            } else if (c2 == 1) {
                view = getView();
                i2 = 3;
            } else if (c2 != 2) {
                return;
            } else {
                view = getView();
                i2 = 5;
            }
            view.setGravity(i2);
        }
    }

    public void setTextLineClamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            getView().setMaxLines(i2);
        }
    }

    public void setTextOverflow(String str) {
        Button view;
        TextUtils.TruncateAt valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if ("clip".equalsIgnoreCase(str)) {
                view = getView();
                valueOf = null;
            } else if (!"ellipsis".equalsIgnoreCase(str)) {
                return;
            } else {
                view = getView();
                valueOf = TextUtils.TruncateAt.valueOf("END");
            }
            view.setEllipsize(valueOf);
        }
    }
}
