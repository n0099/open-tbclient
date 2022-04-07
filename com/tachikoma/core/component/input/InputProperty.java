package com.tachikoma.core.component.input;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.tachikoma.core.component.text.FontManager;
import java.lang.reflect.Field;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class InputProperty {
    public static /* synthetic */ Interceptable $ic;
    public static final InputFilter[] EMPTY_FILTERS;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSingleLine;
    public final View.OnFocusChangeListener mOnFocusChangeListener;
    public int mStagedInputTypeFlags;
    public final EditText mView;
    public MaxLinesTextWatcher maxLinesTextWatcher;

    /* loaded from: classes8.dex */
    public class MaxLinesTextWatcher implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int maxLines;
        public final /* synthetic */ InputProperty this$0;

        public MaxLinesTextWatcher(InputProperty inputProperty, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputProperty, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = inputProperty;
            this.maxLines = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String substring;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.this$0.mView.getLineCount() <= this.maxLines) {
                return;
            }
            String obj = editable.toString();
            int selectionStart = this.this$0.mView.getSelectionStart();
            if (selectionStart != this.this$0.mView.getSelectionEnd() || selectionStart >= obj.length() || selectionStart < 1) {
                substring = obj.substring(0, editable.length() - 1);
            } else {
                substring = obj.substring(0, selectionStart - 1) + obj.substring(selectionStart);
            }
            this.this$0.mView.setText(substring);
            this.this$0.mView.setSelection(this.this$0.mView.getText().length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public void setMaxLines(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.maxLines = i;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-670876599, "Lcom/tachikoma/core/component/input/InputProperty;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-670876599, "Lcom/tachikoma/core/component/input/InputProperty;");
                return;
            }
        }
        EMPTY_FILTERS = new InputFilter[0];
    }

    public InputProperty(EditText editText, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editText, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxLinesTextWatcher = new MaxLinesTextWatcher(this, 3);
        this.mOnFocusChangeListener = new View.OnFocusChangeListener(this) { // from class: com.tachikoma.core.component.input.InputProperty.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InputProperty this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z2) == null) {
                }
            }
        };
        this.mStagedInputTypeFlags = editText.getInputType();
        this.isSingleLine = z;
        this.mView = editText;
        editText.setPadding(0, 0, 0, 0);
        this.mView.setSingleLine(z);
        this.mView.setOnFocusChangeListener(this.mOnFocusChangeListener);
        if (this.isSingleLine) {
            return;
        }
        this.mView.addTextChangedListener(this.maxLinesTextWatcher);
    }

    private int getGravity(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("center")) {
                    c = 0;
                }
                c = 65535;
            }
            return c != 0 ? c != 1 ? this.isSingleLine ? 19 : 3 : this.isSingleLine ? 21 : 5 : this.isSingleLine ? 17 : 1;
        }
        return invokeL.intValue;
    }

    private int getImeOption(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -906336856) {
                if (str.equals("search")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode == 3304) {
                if (str.equals(ReturnKeyType.GO)) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != 3377907) {
                if (hashCode == 3526536 && str.equals(ReturnKeyType.SEND)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (str.equals("next")) {
                    c = 3;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return c != 3 ? 6 : 5;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getInputType(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 114715:
                    if (str.equals(InputType.TEL)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1216985755:
                    if (str.equals(InputType.PASSWORD)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return c != 3 ? 0 : 128;
                    }
                    return 3;
                }
                return 2;
            }
            return 32;
        }
        return invokeL.intValue;
    }

    private void setStagedInputTypeFlags(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65542, this, i, i2) == null) {
            int i3 = ((~i) & this.mStagedInputTypeFlags) | i2;
            this.mStagedInputTypeFlags = i3;
            this.mView.setInputType(i3);
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mView.getText().toString() : (String) invokeV.objValue;
    }

    public void setCursorColor(int i) {
        Class<?> type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(this.mView);
                if (i2 == 0) {
                    return;
                }
                Drawable drawable = ContextCompat.getDrawable(this.mView.getContext(), i2);
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                Drawable[] drawableArr = {drawable, drawable};
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(this.mView);
                if (Build.VERSION.SDK_INT < 16) {
                    type = TextView.class;
                } else {
                    Field declaredField3 = TextView.class.getDeclaredField("mEditor");
                    declaredField3.setAccessible(true);
                    type = declaredField3.getType();
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    Field declaredField4 = type.getDeclaredField("mDrawableForCursor");
                    declaredField4.setAccessible(true);
                    declaredField4.set(obj, drawable);
                    return;
                }
                Field declaredField5 = type.getDeclaredField("mCursorDrawable");
                declaredField5.setAccessible(true);
                declaredField5.set(obj, drawableArr);
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }

    public void setFocused(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (!z) {
                this.mView.clearFocus();
                return;
            }
            this.mView.requestFocus();
            ((InputMethodManager) this.mView.getContext().getSystemService("input_method")).toggleSoftInput(2, 2);
        }
    }

    public void setFontFamily(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.mView.setTypeface(FontManager.getInstance().getTypeface(str, this.mView.getTypeface() != null ? this.mView.getTypeface().getStyle() : 0, this.mView.getContext().getAssets(), (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : str2.concat(str)));
        }
    }

    public void setFontSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.mView.setTextSize(1, f);
        }
    }

    public void setMaxLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            InputFilter[] filters = this.mView.getFilters();
            InputFilter[] inputFilterArr = EMPTY_FILTERS;
            if (i == 0) {
                if (filters.length > 0) {
                    LinkedList linkedList = new LinkedList();
                    for (int i2 = 0; i2 < filters.length; i2++) {
                        if (!(filters[i2] instanceof InputFilter.LengthFilter)) {
                            linkedList.add(filters[i2]);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                    }
                }
            } else if (filters.length > 0) {
                boolean z = false;
                for (int i3 = 0; i3 < filters.length; i3++) {
                    if (filters[i3] instanceof InputFilter.LengthFilter) {
                        filters[i3] = new InputFilter.LengthFilter(i);
                        z = true;
                    }
                }
                if (!z) {
                    InputFilter[] inputFilterArr2 = new InputFilter[filters.length + 1];
                    System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                    filters[filters.length] = new InputFilter.LengthFilter(i);
                    filters = inputFilterArr2;
                }
                inputFilterArr = filters;
            } else {
                inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(i)};
            }
            this.mView.setFilters(inputFilterArr);
        }
    }

    public void setMaxLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.maxLinesTextWatcher.setMaxLines(i);
        }
    }

    public void setPlaceholder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mView.setHint(str);
        }
    }

    public void setPlaceholderColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mView.setHintTextColor(i);
        }
    }

    public void setPlaceholderFontSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.mView.setTextSize(1, f);
        }
    }

    public void setReturnKeyType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mView.setImeOptions(getImeOption(str));
        }
    }

    public void setSecureTextEntry(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                setStagedInputTypeFlags(Cea708Decoder.COMMAND_SPA, 128);
            } else {
                setStagedInputTypeFlags(128, Cea708Decoder.COMMAND_SPA);
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mView.setText(str);
            if (this.mView.getText().length() > 0) {
                EditText editText = this.mView;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    public void setTextAlign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mView.setGravity(getGravity(str));
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mView.setTextColor(i);
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            setStagedInputTypeFlags(0, getInputType(str));
        }
    }
}
