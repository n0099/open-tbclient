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
/* loaded from: classes9.dex */
public class CustomAutoTextView extends AutoCompleteTextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIEW_TYPE_BANKCARD = 24;
    public static final int VIEW_TYPE_PHONE = 13;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f69936e;

    /* renamed from: f  reason: collision with root package name */
    public int f69937f;

    /* renamed from: g  reason: collision with root package name */
    public int f69938g;

    /* renamed from: h  reason: collision with root package name */
    public Context f69939h;

    /* renamed from: i  reason: collision with root package name */
    public int f69940i;

    /* renamed from: j  reason: collision with root package name */
    public List<IEditTextPasteFilter> f69941j;
    public ShowDropDownListener k;

    /* loaded from: classes9.dex */
    public interface ShowDropDownListener {
        void showDisplayTranslucent();
    }

    /* loaded from: classes9.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f69942e;

        /* renamed from: f  reason: collision with root package name */
        public int f69943f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69944g;

        /* renamed from: h  reason: collision with root package name */
        public int f69945h;

        /* renamed from: i  reason: collision with root package name */
        public char[] f69946i;

        /* renamed from: j  reason: collision with root package name */
        public StringBuffer f69947j;
        public int k;
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
            this.f69942e = 0;
            this.f69943f = 0;
            this.f69944g = false;
            this.f69945h = 0;
            this.f69947j = new StringBuffer();
            this.k = 0;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f69944g) {
                this.f69945h = this.l.getSelectionEnd();
                int i3 = this.l.f69937f == 13 ? 3 : 100;
                int i4 = 0;
                loop0: while (true) {
                    boolean z = true;
                    while (i4 < this.f69947j.length()) {
                        if (i4 == i3 && this.f69947j.charAt(i4) != ' ' && this.f69943f == this.f69942e - 1 && z) {
                            i4--;
                            this.f69947j.deleteCharAt(i4);
                            this.f69945h--;
                            z = false;
                        }
                        if (this.f69947j.charAt(i4) == ' ') {
                            break;
                        }
                        i4++;
                    }
                    this.f69947j.deleteCharAt(i4);
                    i3 = i4 + 4;
                }
                if (this.l.f69937f != 13) {
                    if (this.l.f69937f == 24) {
                        i2 = 0;
                        for (int i5 = 0; i5 < this.f69947j.length(); i5++) {
                            if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                this.f69947j.insert(i5, ' ');
                                i2++;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                    for (int i6 = 0; i6 < this.f69947j.length(); i6++) {
                        if (i6 == 3 || i6 == 8) {
                            this.f69947j.insert(i6, ' ');
                            i2++;
                        }
                    }
                }
                int i7 = this.k;
                if (i2 > i7) {
                    this.f69945h += i2 - i7;
                }
                this.f69946i = new char[this.f69947j.length()];
                StringBuffer stringBuffer = this.f69947j;
                stringBuffer.getChars(0, stringBuffer.length(), this.f69946i, 0);
                String stringBuffer2 = this.f69947j.toString();
                if (stringBuffer2.length() > this.l.f69937f) {
                    stringBuffer2 = stringBuffer2.substring(0, this.l.f69937f);
                }
                if (this.f69945h > stringBuffer2.length()) {
                    this.f69945h = stringBuffer2.length();
                } else if (this.f69945h < 0) {
                    this.f69945h = 0;
                }
                this.l.setText(stringBuffer2);
                Editable text = this.l.getText();
                Selection.setSelection(text, this.f69945h);
                if (this.l.f69937f == 13 && text.length() == 13) {
                    Selection.setSelection(text, 13);
                }
                this.f69944g = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f69942e = charSequence.length();
                if (this.f69947j.length() > 0) {
                    StringBuffer stringBuffer = this.f69947j;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.k = 0;
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    if (charSequence.charAt(i5) == ' ') {
                        this.k++;
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                this.f69943f = charSequence.length();
                this.f69947j.append(charSequence.toString());
                int i5 = this.f69943f;
                if (i5 != this.f69942e && i5 >= this.l.f69938g && !this.f69944g) {
                    this.f69944g = true;
                } else {
                    this.f69944g = false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CustomAutoTextView f69948e;

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
            this.f69948e = customAutoTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                GlobalUtils.showInputMethod(this.f69948e.f69939h, view);
                int[] iArr = new int[2];
                this.f69948e.getLocationInWindow(iArr);
                int paddingLeft = this.f69948e.getPaddingLeft();
                int action = motionEvent.getAction();
                Layout layout = this.f69948e.getLayout();
                if (action == 0) {
                    this.f69948e.f69940i = layout.getOffsetForHorizontal(layout.getLineForVertical(this.f69948e.getScrollY() + ((int) motionEvent.getY())), (int) ((motionEvent.getX() - iArr[0]) - paddingLeft));
                    Selection.setSelection(this.f69948e.getEditableText(), this.f69948e.f69940i);
                } else if (action == 1 || action == 2) {
                    Selection.setSelection(this.f69948e.getEditableText(), this.f69948e.f69940i, layout.getOffsetForHorizontal(layout.getLineForVertical(this.f69948e.getScrollY() + ((int) motionEvent.getY())), (((int) motionEvent.getX()) - iArr[0]) - paddingLeft));
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
        this.f69936e = CustomAutoTextView.class.getSimpleName();
        this.f69937f = 13;
        this.f69938g = 3;
        this.f69939h = null;
        this.f69941j = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f69941j.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iEditTextPasteFilter) == null) || iEditTextPasteFilter == null) {
            return;
        }
        this.f69941j.add(iEditTextPasteFilter);
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
            GlobalUtils.hideInputMethod(this.f69939h, this);
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 16908322) {
                String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f69941j);
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
            this.k = showDropDownListener;
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f69937f = i2;
            this.f69938g = i2 == 13 ? 3 : 4;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getText().length() == 13 || getAdapter() == null || getAdapter().getCount() == 0) {
            return;
        }
        ShowDropDownListener showDropDownListener = this.k;
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
        this.f69936e = CustomAutoTextView.class.getSimpleName();
        this.f69937f = 13;
        this.f69938g = 3;
        this.f69939h = null;
        this.f69941j = new ArrayList();
        this.f69939h = context;
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f69941j.addAll(parseEditTextPasteFilter);
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
