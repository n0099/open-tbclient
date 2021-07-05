package com.kwad.sdk.emotion.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EmojiTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f37208a;

    /* renamed from: b  reason: collision with root package name */
    public a f37209b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37210c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37211d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37212e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(EmojiTextView emojiTextView, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37210c = false;
        this.f37211d = false;
        this.f37212e = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiTextView(Context context, AttributeSet attributeSet) {
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
        this.f37210c = false;
        this.f37211d = false;
        this.f37212e = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiTextView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f37210c = false;
        this.f37211d = false;
        this.f37212e = false;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f37208a = new d(this);
            addTextChangedListener(new TextWatcher(this) { // from class: com.kwad.sdk.emotion.widget.EmojiTextView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EmojiTextView f37213a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37213a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        EmojiTextView emojiTextView = this.f37213a;
                        if (emojiTextView.f37208a == null) {
                            return;
                        }
                        if (emojiTextView.f37210c) {
                            if (this.f37213a.f37212e || TextUtils.isEmpty(this.f37213a.getEditableText())) {
                                if (this.f37213a.f37211d) {
                                    return;
                                }
                                EmojiTextView emojiTextView2 = this.f37213a;
                                emojiTextView2.f37208a.a(emojiTextView2.getEditableText());
                                if (this.f37213a.f37210c) {
                                    this.f37213a.f37211d = true;
                                    return;
                                }
                                return;
                            }
                            this.f37213a.f37212e = true;
                        }
                        EmojiTextView emojiTextView3 = this.f37213a;
                        emojiTextView3.f37208a.a(emojiTextView3.getEditableText());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            if (getText() == null || getText().length() <= 0) {
                return;
            }
            this.f37208a.a(getEditableText());
        }
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, charSequence, i2, i3) == null) {
            try {
                super.append(charSequence, i2, i3);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    public e getKSTextDisplayHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37208a : (e) invokeV.objValue;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            CharSequence text = super.getText();
            return text == null ? "" : text;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            try {
                super.onMeasure(i2, i3);
            } catch (IndexOutOfBoundsException unused) {
                setText(getText().toString());
                try {
                    super.onMeasure(i2, i3);
                } catch (IndexOutOfBoundsException unused2) {
                    setText("");
                    super.onMeasure(i2, i3);
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return super.performLongClick();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void postInvalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f37211d = true;
            super.postInvalidate();
        }
    }

    public void setKSTextDisplayHandler(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f37208a = eVar;
        }
    }

    public void setOnPressedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f37209b = aVar;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            boolean isPressed = isPressed();
            super.setPressed(z);
            if (!(isPressed ^ z) || (aVar = this.f37209b) == null) {
                return;
            }
            aVar.a(this, z);
        }
    }

    public void setPreventDeadCycleInvalidate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f37210c = z;
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, charSequence, bufferType) == null) {
            try {
                super.setText(charSequence, bufferType);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }
}
