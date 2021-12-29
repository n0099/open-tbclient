package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.base.widget.textfilter.EditTextPasteFilterUtils;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CustomAutoTextView extends AutoCompleteTextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIEW_TYPE_BANKCARD = 24;
    public static final int VIEW_TYPE_PHONE = 13;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f55885e;

    /* renamed from: f  reason: collision with root package name */
    public int f55886f;

    /* renamed from: g  reason: collision with root package name */
    public int f55887g;

    /* renamed from: h  reason: collision with root package name */
    public Context f55888h;

    /* renamed from: i  reason: collision with root package name */
    public int f55889i;

    /* renamed from: j  reason: collision with root package name */
    public List<IEditTextPasteFilter> f55890j;

    /* renamed from: k  reason: collision with root package name */
    public ShowDropDownListener f55891k;

    /* loaded from: classes2.dex */
    public interface ShowDropDownListener {
        void showDisplayTranslucent();
    }

    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f55892e;

        /* renamed from: f  reason: collision with root package name */
        public int f55893f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f55894g;

        /* renamed from: h  reason: collision with root package name */
        public int f55895h;

        /* renamed from: i  reason: collision with root package name */
        public char[] f55896i;

        /* renamed from: j  reason: collision with root package name */
        public StringBuffer f55897j;

        /* renamed from: k  reason: collision with root package name */
        public int f55898k;
        public final /* synthetic */ CustomAutoTextView l;

        public a(CustomAutoTextView customAutoTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customAutoTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = customAutoTextView;
            this.f55892e = 0;
            this.f55893f = 0;
            this.f55894g = false;
            this.f55895h = 0;
            this.f55897j = new StringBuffer();
            this.f55898k = 0;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f55894g) {
                this.f55895h = this.l.getSelectionEnd();
                int i3 = this.l.f55886f == 13 ? 3 : 100;
                int i4 = 0;
                loop0: while (true) {
                    boolean z = true;
                    while (i4 < this.f55897j.length()) {
                        if (i4 == i3 && this.f55897j.charAt(i4) != ' ' && this.f55893f == this.f55892e - 1 && z) {
                            i4--;
                            this.f55897j.deleteCharAt(i4);
                            this.f55895h--;
                            z = false;
                        }
                        if (this.f55897j.charAt(i4) == ' ') {
                            break;
                        }
                        i4++;
                    }
                    this.f55897j.deleteCharAt(i4);
                    i3 = i4 + 4;
                }
                if (this.l.f55886f != 13) {
                    if (this.l.f55886f == 24) {
                        i2 = 0;
                        for (int i5 = 0; i5 < this.f55897j.length(); i5++) {
                            if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                this.f55897j.insert(i5, ' ');
                                i2++;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                    for (int i6 = 0; i6 < this.f55897j.length(); i6++) {
                        if (i6 == 3 || i6 == 8) {
                            this.f55897j.insert(i6, ' ');
                            i2++;
                        }
                    }
                }
                int i7 = this.f55898k;
                if (i2 > i7) {
                    this.f55895h += i2 - i7;
                }
                this.f55896i = new char[this.f55897j.length()];
                StringBuffer stringBuffer = this.f55897j;
                stringBuffer.getChars(0, stringBuffer.length(), this.f55896i, 0);
                String stringBuffer2 = this.f55897j.toString();
                if (stringBuffer2.length() > this.l.f55886f) {
                    stringBuffer2 = stringBuffer2.substring(0, this.l.f55886f);
                }
                if (this.f55895h > stringBuffer2.length()) {
                    this.f55895h = stringBuffer2.length();
                } else if (this.f55895h < 0) {
                    this.f55895h = 0;
                }
                this.l.setText(stringBuffer2);
                Editable text = this.l.getText();
                Selection.setSelection(text, this.f55895h);
                if (this.l.f55886f == 13 && text.length() == 13) {
                    Selection.setSelection(text, 13);
                }
                this.f55894g = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f55892e = charSequence.length();
                if (this.f55897j.length() > 0) {
                    StringBuffer stringBuffer = this.f55897j;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f55898k = 0;
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    if (charSequence.charAt(i5) == ' ') {
                        this.f55898k++;
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                this.f55893f = charSequence.length();
                this.f55897j.append(charSequence.toString());
                int i5 = this.f55893f;
                if (i5 != this.f55892e && i5 >= this.l.f55887g && !this.f55894g) {
                    this.f55894g = true;
                } else {
                    this.f55894g = false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CustomAutoTextView f55899e;

        public b(CustomAutoTextView customAutoTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customAutoTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55899e = customAutoTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                GlobalUtils.showInputMethod(this.f55899e.f55888h, view);
                int[] iArr = new int[2];
                this.f55899e.getLocationInWindow(iArr);
                int paddingLeft = this.f55899e.getPaddingLeft();
                int action = motionEvent.getAction();
                Layout layout = this.f55899e.getLayout();
                if (action == 0) {
                    this.f55899e.f55889i = layout.getOffsetForHorizontal(layout.getLineForVertical(this.f55899e.getScrollY() + ((int) motionEvent.getY())), (int) ((motionEvent.getX() - iArr[0]) - paddingLeft));
                    Selection.setSelection(this.f55899e.getEditableText(), this.f55899e.f55889i);
                } else if (action == 1 || action == 2) {
                    Selection.setSelection(this.f55899e.getEditableText(), this.f55899e.f55889i, layout.getOffsetForHorizontal(layout.getLineForVertical(this.f55899e.getScrollY() + ((int) motionEvent.getY())), (((int) motionEvent.getX()) - iArr[0]) - paddingLeft));
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAutoTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
        this.f55885e = CustomAutoTextView.class.getSimpleName();
        this.f55886f = 13;
        this.f55887g = 3;
        this.f55888h = null;
        this.f55890j = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f55890j.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iEditTextPasteFilter) == null) || iEditTextPasteFilter == null) {
            return;
        }
        this.f55890j.add(iEditTextPasteFilter);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            super.onFocusChanged(z, i2, rect);
            if (z) {
                if (getAdapter() == null) {
                    return;
                }
                performFiltering(getText(), 0);
                return;
            }
            GlobalUtils.hideInputMethod(this.f55888h, this);
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 16908322) {
                String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f55890j);
                Editable editableText = getEditableText();
                try {
                    int selectionStart = getSelectionStart();
                    int selectionEnd = getSelectionEnd();
                    if (editableText != null) {
                        String obj = editableText.toString();
                        if (!TextUtils.isEmpty(obj)) {
                            int length = obj.length();
                            String substring = obj.substring(0, selectionStart);
                            String substring2 = obj.substring(selectionEnd, length);
                            if (TextUtils.isEmpty(substring)) {
                                str = "";
                            } else {
                                str = "" + substring;
                            }
                            if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                                str = str + applyEditTextPasteFilters;
                            }
                            if (TextUtils.isEmpty(substring2)) {
                                applyEditTextPasteFilters = str;
                            } else {
                                applyEditTextPasteFilters = str + substring2;
                            }
                        }
                        if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                            applyEditTextPasteFilters = applyEditTextPasteFilters.replace(" ", "");
                        }
                        setText("");
                        setText(applyEditTextPasteFilters);
                        setSelection(getEditableText().length());
                        requestFocus();
                        return true;
                    }
                    return super.onTextContextMenuItem(i2);
                } catch (Exception e2) {
                    e2.getMessage();
                    return super.onTextContextMenuItem(i2);
                }
            }
            return super.onTextContextMenuItem(i2);
        }
        return invokeI.booleanValue;
    }

    public void setShowDropDownListener(ShowDropDownListener showDropDownListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, showDropDownListener) == null) {
            this.f55891k = showDropDownListener;
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f55886f = i2;
            this.f55887g = i2 == 13 ? 3 : 4;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getText().length() == 13 || getAdapter() == null || getAdapter().getCount() == 0) {
            return;
        }
        ShowDropDownListener showDropDownListener = this.f55891k;
        if (showDropDownListener != null) {
            showDropDownListener.showDisplayTranslucent();
        }
        super.showDropDown();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAutoTextView(Context context, AttributeSet attributeSet) {
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
        this.f55885e = CustomAutoTextView.class.getSimpleName();
        this.f55886f = 13;
        this.f55887g = 3;
        this.f55888h = null;
        this.f55890j = new ArrayList();
        this.f55888h = context;
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f55890j.addAll(parseEditTextPasteFilter);
        }
        addTextChangedListener(new a(this));
        setOnTouchListener(new b(this));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomAutoTextView(Context context) {
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
}
