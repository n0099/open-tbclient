package com.kwad.sdk.emotion.widget;

import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull TextView textView) {
        super(textView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TextView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.emotion.widget.e
    public void a(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            TextView textView = this.f37223a.get();
            if (editable == null) {
                return;
            }
            int length = editable.length();
            this.f37224b = true;
            try {
                a((CharSequence) editable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (a()) {
                a(editable, textView, 0, length);
            }
            try {
                if (textView instanceof EditText) {
                    ((EditText) textView).setSelection(textView.getSelectionStart(), textView.getSelectionEnd());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.f37224b = false;
        }
    }

    @Override // com.kwad.sdk.emotion.widget.e
    public void a(Editable editable, TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable, textView, i2, i3) == null) {
            a.a(textView, i2, i3, false);
        }
    }
}
