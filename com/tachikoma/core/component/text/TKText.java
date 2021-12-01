package com.tachikoma.core.component.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.input.TextAlign;
import com.tachikoma.core.utility.TKColorUtil;
import com.tachikoma.core.utility.TKConverter;
import java.util.HashMap;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes2.dex */
public class TKText extends TKBase<AppCompatTextView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String formattedText;
    public int mFontSize;
    public float mMinimumScaleFactor;
    public String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKText(Context context, List<Object> list) {
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
        this.mMinimumScaleFactor = -1.0f;
    }

    public static Spanned fromHtml(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str) : (Spanned) invokeL.objValue;
    }

    public static void setLineHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i2) {
        int fontMetricsInt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, textView, i2) == null) || i2 < 0 || i2 == (fontMetricsInt = textView.getPaint().getFontMetricsInt(null))) {
            return;
        }
        textView.setLineSpacing(i2 - fontMetricsInt, 1.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public AppCompatTextView createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new AppCompatTextView(context) : (AppCompatTextView) invokeL.objValue;
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
        }
    }

    public void setColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            getView().setTextColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
        }
    }

    public void setFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getView().setTypeface(FontManager.getInstance().getTypeface(str, getView().getTypeface() != null ? getView().getTypeface().getStyle() : 0, getView().getContext().getAssets(), !TextUtils.isEmpty(str) ? getRootDir().concat(str) : ""));
        }
    }

    public void setFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mFontSize = i2;
            getView().setTextSize(1, i2);
            setMinimumScaleFactor(this.mMinimumScaleFactor);
        }
    }

    public void setFontWeight(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals(SpanItem.STYLE_BOLD)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("normal")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                getView().setTypeface(getView().getTypeface(), 1);
            } else if (c2 != 1) {
            } else {
                getView().setTypeface(getView().getTypeface(), 0);
            }
        }
    }

    public void setFormattedText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.formattedText = str;
            getView().setText(fromHtml(this.formattedText));
        }
    }

    public void setIncludeFontPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            getView().setIncludeFontPadding(z);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void setMinimumScaleFactor(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.mMinimumScaleFactor = f2;
            if (f2 < 0.0f || f2 > 1.0f || this.mFontSize == 0) {
                return;
            }
            int i2 = this.mFontSize;
            getView().setAutoSizeTextTypeUniformWithConfiguration((int) (i2 * f2), i2, 1, 1);
        }
    }

    public void setSpan(String str, V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            try {
                TKSpan tKSpan = (TKSpan) associateReference.nativeObject;
                if (tKSpan == null) {
                    return;
                }
                this.text = str;
                getDomNode().getYogaNode().dirty();
                getView().setText(tKSpan.getSpannableString(str, getView()));
            } finally {
                associateReference.close();
            }
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setStyle(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hashMap) == null) {
            takeControlOfPaddingSet(hashMap);
            super.setStyle(hashMap);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.text = str;
            getDomNode().getYogaNode().dirty();
            getView().setText(this.text);
        }
    }

    public void setTextAlign(String str) {
        char c2;
        AppCompatTextView view;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
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

    public void setTextDecoration(String str) {
        char c2;
        TextPaint paint;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1171789332) {
                if (hashCode == -1026963764 && str.equals("underline")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("line-through")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                paint = getView().getPaint();
                i2 = 8;
            } else if (c2 != 1) {
                return;
            } else {
                paint = getView().getPaint();
                i2 = 16;
            }
            paint.setFlags(i2);
        }
    }

    public void setTextLineClamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            getView().setMaxLines(i2);
        }
    }

    public void setTextLineHeight(Number number) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, number) == null) || number == null) {
            return;
        }
        setLineHeight(getView(), (int) TKConverter.dp2px(getContext(), number.floatValue()));
    }

    public void setTextLineSpace(Number number) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, number) == null) || number == null) {
            return;
        }
        getView().setLineSpacing(TKConverter.dp2px(getContext(), number.floatValue()), 1.0f);
    }

    public void setTextOverflow(String str) {
        AppCompatTextView view;
        TextUtils.TruncateAt valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
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
