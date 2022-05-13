package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;
/* loaded from: classes4.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialComponentsViewInflater() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @NonNull
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, attributeSet)) == null) ? new MaterialAutoCompleteTextView(context, attributeSet) : (AppCompatAutoCompleteTextView) invokeLL.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @NonNull
    public AppCompatButton createButton(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) ? new MaterialButton(context, attributeSet) : (AppCompatButton) invokeLL.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @NonNull
    public AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet)) == null) ? new MaterialCheckBox(context, attributeSet) : (AppCompatCheckBox) invokeLL.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @NonNull
    public AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, attributeSet)) == null) ? new MaterialRadioButton(context, attributeSet) : (AppCompatRadioButton) invokeLL.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @NonNull
    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, attributeSet)) == null) ? new MaterialTextView(context, attributeSet) : (AppCompatTextView) invokeLL.objValue;
    }
}
