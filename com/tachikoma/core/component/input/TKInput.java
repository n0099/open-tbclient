package com.tachikoma.core.component.input;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
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
import com.tachikoma.core.event.TKEventProcess;
import com.tachikoma.core.event.base.IBaseEvent;
import com.tachikoma.core.event.view.TKInputEvent;
import com.tachikoma.core.utility.TKColorUtil;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKInput extends TKBase<EditText> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean focused;
    public View.OnKeyListener mOnKeyListener;
    public final InputProperty mProperty;
    public TextWatcher mTextWatcher;
    public String placeholder;
    public String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKInput(Context context, @Nullable List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTextWatcher = new TextWatcher(this) { // from class: com.tachikoma.core.component.input.TKInput.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKInput this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                    this.this$0.dispatchEvent("input", new TKEventProcess.EventInterface(this, editable) { // from class: com.tachikoma.core.component.input.TKInput.1.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ Editable val$s;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, editable};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$s = editable;
                        }

                        @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                        public void callBackEvent(IBaseEvent iBaseEvent) {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKInputEvent)) {
                                TKInputEvent tKInputEvent = (TKInputEvent) iBaseEvent;
                                tKInputEvent.setType("input");
                                tKInputEvent.setText(this.val$s.toString());
                                tKInputEvent.setState(3);
                            }
                        }
                    });
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i3, i4, i5) == null) {
                    this.this$0.dispatchEvent("input", new TKEventProcess.EventInterface(this, charSequence) { // from class: com.tachikoma.core.component.input.TKInput.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ CharSequence val$s;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, charSequence};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$s = charSequence;
                        }

                        @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                        public void callBackEvent(IBaseEvent iBaseEvent) {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKInputEvent)) {
                                TKInputEvent tKInputEvent = (TKInputEvent) iBaseEvent;
                                tKInputEvent.setType("input");
                                tKInputEvent.setText(this.val$s.toString());
                                tKInputEvent.setState(1);
                            }
                        }
                    });
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i3, i4, i5) == null) {
                    this.this$0.dispatchEvent("input", new TKEventProcess.EventInterface(this, charSequence) { // from class: com.tachikoma.core.component.input.TKInput.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ CharSequence val$s;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, charSequence};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$s = charSequence;
                        }

                        @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                        public void callBackEvent(IBaseEvent iBaseEvent) {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKInputEvent)) {
                                TKInputEvent tKInputEvent = (TKInputEvent) iBaseEvent;
                                tKInputEvent.setType("input");
                                tKInputEvent.setText(this.val$s.toString());
                                tKInputEvent.setState(2);
                            }
                        }
                    });
                }
            }
        };
        this.mOnKeyListener = new View.OnKeyListener(this) { // from class: com.tachikoma.core.component.input.TKInput.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TKInput this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view, i3, keyEvent)) == null) {
                    if (i3 == 67 && keyEvent.getAction() == 0 && this.this$0.getView() != null && TextUtils.isEmpty(this.this$0.getView().getText())) {
                        this.this$0.dispatchEvent("input", new TKEventProcess.EventInterface(this) { // from class: com.tachikoma.core.component.input.TKInput.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr3 = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKInputEvent)) {
                                    TKInputEvent tKInputEvent = (TKInputEvent) iBaseEvent;
                                    tKInputEvent.setType("input");
                                    tKInputEvent.setText("");
                                    tKInputEvent.setState(2);
                                }
                            }
                        });
                        return false;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        };
        this.mProperty = new InputProperty(getView(), isSingleLine());
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mProperty.setText("");
        }
    }

    public void clearFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mProperty.setFocused(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public EditText createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            EditText editText = new EditText(context);
            editText.setBackground(null);
            return editText;
        }
        return (EditText) invokeL.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProperty.getText() : (String) invokeV.objValue;
    }

    public boolean isSingleLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onCreate();
            getView().addTextChangedListener(this.mTextWatcher);
            getView().setOnKeyListener(this.mOnKeyListener);
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            if (getView() != null) {
                getView().removeTextChangedListener(this.mTextWatcher);
                getView().setOnKeyListener(null);
            }
        }
    }

    public void setColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mProperty.setTextColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
        }
    }

    public void setCursorColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mProperty.setCursorColor(Color.parseColor(str));
        }
    }

    public void setFocused(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.focused = z;
            this.mProperty.setFocused(z);
        }
    }

    public void setFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mProperty.setFontFamily(str, getRootDir());
        }
    }

    public void setFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mProperty.setFontSize(i);
        }
    }

    public void setMaxLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mProperty.setMaxLength(i);
        }
    }

    public void setPlaceholder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.placeholder = str;
            this.mProperty.setPlaceholder(str);
        }
    }

    public void setPlaceholderColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mProperty.setPlaceholderColor(Color.parseColor(str));
        }
    }

    public void setPlaceholderFontSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.mProperty.setPlaceholderFontSize(f2);
        }
    }

    public void setReturnKeyType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mProperty.setReturnKeyType(str);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.text = str;
            this.mProperty.setText(str);
        }
    }

    public void setTextAlign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mProperty.setTextAlign(str);
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mProperty.setType(str);
        }
    }
}
