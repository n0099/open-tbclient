package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect parentRect;
    public boolean textInputLayoutFocusedRectEnabled;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputEditText(@NonNull Context context) {
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

    @NonNull
    private String getAccessibilityNodeInfoText(@NonNull TextInputLayout textInputLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, textInputLayout)) == null) {
            Editable text = getText();
            CharSequence hint = textInputLayout.getHint();
            CharSequence helperText = textInputLayout.getHelperText();
            CharSequence error = textInputLayout.getError();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            String str = "";
            String charSequence = z2 ? hint.toString() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(charSequence)) ? StringUtil.ARRAY_ELEMENT_SEPARATOR : "");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb3.append((Object) helperText);
            String sb4 = sb3.toString();
            if (!z) {
                return !TextUtils.isEmpty(sb4) ? sb4 : "";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) text);
            if (!TextUtils.isEmpty(sb4)) {
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR + sb4;
            }
            sb5.append(str);
            return sb5.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            TextInputLayout textInputLayout = getTextInputLayout();
            if (textInputLayout != null) {
                return textInputLayout.getHint();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof TextInputLayout) {
                    return (TextInputLayout) parent;
                }
            }
            return null;
        }
        return (TextInputLayout) invokeV.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
            super.getFocusedRect(rect);
            TextInputLayout textInputLayout = getTextInputLayout();
            if (textInputLayout == null || !this.textInputLayoutFocusedRectEnabled || rect == null) {
                return;
            }
            textInputLayout.getFocusedRect(this.parentRect);
            rect.bottom = this.parentRect.bottom;
        }
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect, point)) == null) {
            boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
            TextInputLayout textInputLayout = getTextInputLayout();
            if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled && rect != null) {
                textInputLayout.getGlobalVisibleRect(this.parentRect, point);
                rect.bottom = this.parentRect.bottom;
            }
            return globalVisibleRect;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextInputLayout textInputLayout = getTextInputLayout();
            if (textInputLayout != null && textInputLayout.isProvidingHint()) {
                return textInputLayout.getHint();
            }
            return super.getHint();
        }
        return (CharSequence) invokeV.objValue;
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.textInputLayoutFocusedRectEnabled : invokeV.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            TextInputLayout textInputLayout = getTextInputLayout();
            if (textInputLayout != null && textInputLayout.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
                setHint("");
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, editorInfo)) == null) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (onCreateInputConnection != null && editorInfo.hintText == null) {
                editorInfo.hintText = getHintFromLayout();
            }
            return onCreateInputConnection;
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            TextInputLayout textInputLayout = getTextInputLayout();
            if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
                return;
            }
            accessibilityNodeInfo.setText(getAccessibilityNodeInfoText(textInputLayout));
        }
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rect)) == null) {
            boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
            TextInputLayout textInputLayout = getTextInputLayout();
            if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled) {
                this.parentRect.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
                textInputLayout.requestRectangleOnScreen(this.parentRect, true);
            }
            return requestRectangleOnScreen;
        }
        return invokeL.booleanValue;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.textInputLayoutFocusedRectEnabled = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, 0), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.parentRect = new Rect();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.TextInputEditText, i2, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(obtainStyledAttributes.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        obtainStyledAttributes.recycle();
    }
}
