package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes7.dex */
public class PasswordToggleEndIconDelegate extends EndIconDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    public final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    public final TextWatcher textWatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textInputLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TextInputLayout) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.textWatcher = new TextWatcher(this) { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PasswordToggleEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i4, i5, i6) == null) {
                    PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = this.this$0;
                    passwordToggleEndIconDelegate.endIconView.setChecked(!passwordToggleEndIconDelegate.hasPasswordTransformation());
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i4, i5, i6) == null) {
                }
            }
        };
        this.onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener(this) { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PasswordToggleEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, textInputLayout2) == null) {
                    EditText editText = textInputLayout2.getEditText();
                    textInputLayout2.setEndIconVisible(true);
                    textInputLayout2.setEndIconCheckable(true);
                    PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = this.this$0;
                    passwordToggleEndIconDelegate.endIconView.setChecked(!passwordToggleEndIconDelegate.hasPasswordTransformation());
                    editText.removeTextChangedListener(this.this$0.textWatcher);
                    editText.addTextChangedListener(this.this$0.textWatcher);
                }
            }
        };
        this.onEndIconChangedListener = new TextInputLayout.OnEndIconChangedListener(this) { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PasswordToggleEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i4) {
                EditText editText;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, textInputLayout2, i4) == null) && (editText = textInputLayout2.getEditText()) != null && i4 == 1) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText.removeTextChangedListener(this.this$0.textWatcher);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPasswordTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            EditText editText = this.textInputLayout.getEditText();
            return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
        }
        return invokeV.booleanValue;
    }

    public static boolean isInputTypePassword(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, editText)) == null) ? editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) : invokeL.booleanValue;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.design_password_eye));
            TextInputLayout textInputLayout = this.textInputLayout;
            textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
            this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PasswordToggleEndIconDelegate this$0;

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
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EditText editText;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (editText = this.this$0.textInputLayout.getEditText()) == null) {
                        return;
                    }
                    int selectionEnd = editText.getSelectionEnd();
                    if (this.this$0.hasPasswordTransformation()) {
                        editText.setTransformationMethod(null);
                    } else {
                        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    if (selectionEnd >= 0) {
                        editText.setSelection(selectionEnd);
                    }
                }
            });
            this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
            this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
            EditText editText = this.textInputLayout.getEditText();
            if (isInputTypePassword(editText)) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
