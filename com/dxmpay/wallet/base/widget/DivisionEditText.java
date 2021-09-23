package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class DivisionEditText extends SafeKeyBoardEditText {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIEW_TYPE_BANKCARD = 25;
    public static final int VIEW_TYPE_ID = 20;
    public static final int VIEW_TYPE_PHONE = 13;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f69928e;

        /* renamed from: f  reason: collision with root package name */
        public int f69929f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69930g;

        /* renamed from: h  reason: collision with root package name */
        public int f69931h;

        /* renamed from: i  reason: collision with root package name */
        public char[] f69932i;

        /* renamed from: j  reason: collision with root package name */
        public StringBuffer f69933j;
        public int k;
        public final /* synthetic */ DivisionEditText l;

        public a(DivisionEditText divisionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {divisionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = divisionEditText;
            this.f69928e = 0;
            this.f69929f = 0;
            this.f69930g = false;
            this.f69931h = 0;
            this.f69933j = new StringBuffer();
            this.k = 0;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.f69930g && this.l.isFormatEnabled()) {
                this.f69931h = this.l.getSelectionEnd();
                int i3 = 0;
                while (i3 < this.f69933j.length()) {
                    if (this.f69933j.charAt(i3) == ' ') {
                        this.f69933j.deleteCharAt(i3);
                    } else {
                        i3++;
                    }
                }
                if (this.l.A != 13) {
                    if (this.l.A != 25) {
                        if (this.l.A == 20) {
                            i2 = 0;
                            for (int i4 = 0; i4 < this.f69933j.length(); i4++) {
                                if (i4 == 6 || i4 == 15) {
                                    this.f69933j.insert(i4, ' ');
                                    i2++;
                                }
                            }
                        } else {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                        for (int i5 = 0; i5 < this.f69933j.length(); i5++) {
                            if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                this.f69933j.insert(i5, ' ');
                                i2++;
                            }
                        }
                    }
                } else {
                    i2 = 0;
                    for (int i6 = 0; i6 < this.f69933j.length(); i6++) {
                        if (i6 == 3 || i6 == 8) {
                            this.f69933j.insert(i6, ' ');
                            i2++;
                        }
                    }
                }
                int i7 = this.k;
                if (i2 > i7) {
                    if (i2 - i7 > 1) {
                        this.f69931h += i2 - i7;
                    } else {
                        int i8 = this.f69931h;
                        if (i8 - 1 >= 0 && this.f69933j.charAt(i8 - 1) == ' ') {
                            this.f69931h += i2 - this.k;
                        }
                    }
                }
                this.f69932i = new char[this.f69933j.length()];
                StringBuffer stringBuffer = this.f69933j;
                stringBuffer.getChars(0, stringBuffer.length(), this.f69932i, 0);
                String stringBuffer2 = this.f69933j.toString();
                if (stringBuffer2.length() > this.l.A) {
                    stringBuffer2 = stringBuffer2.substring(0, this.l.A);
                }
                this.l.setText(stringBuffer2);
                Editable text = this.l.getText();
                if (this.f69931h > text.length()) {
                    this.f69931h = text.length();
                } else if (this.f69931h < 0) {
                    this.f69931h = 0;
                }
                Selection.setSelection(text, this.f69931h);
                if (this.l.A == 13 && this.f69928e < editable.length()) {
                    if (!this.l.isFormatEnabled() && text.length() == 11) {
                        Selection.setSelection(text, 11);
                    } else if (text.length() == 13) {
                        Selection.setSelection(text, 13);
                    }
                }
                this.f69930g = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f69928e = charSequence.length();
                if (this.f69933j.length() > 0) {
                    StringBuffer stringBuffer = this.f69933j;
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
                this.f69929f = charSequence.length();
                if (this.l.A == 13 && this.f69929f >= 11 && !this.l.isFormatEnabled()) {
                    this.l.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.f69933j.append(charSequence.toString());
                int i5 = this.f69929f;
                if (i5 != this.f69928e && i5 >= this.l.B && !this.f69930g) {
                    this.f69930g = true;
                } else {
                    this.f69930g = false;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionEditText(Context context, AttributeSet attributeSet, int i2) {
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
        this.z = true;
        this.A = 0;
        this.B = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getText().toString().replace(" ", "").trim() : (String) invokeV.objValue;
    }

    public boolean isFormatEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public void setFormatEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.z = z;
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.A = i2;
            if (i2 == 13) {
                this.B = 3;
            } else if (i2 == 25) {
                this.B = 4;
            } else if (i2 == 20) {
                this.B = 6;
                if (isFormatEnabled()) {
                    setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
                    return;
                } else {
                    setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2 - 2)});
                    return;
                }
            }
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionEditText(Context context, AttributeSet attributeSet) {
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
        this.z = true;
        this.A = 0;
        this.B = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new a(this));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivisionEditText(Context context) {
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
