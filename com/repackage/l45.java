package com.repackage;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.pb.PbNewInputContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l45 extends s25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l45(Context context, boolean z, boolean z2, int i) {
        super(context, (String) null, 27);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.n = 3;
        PbNewInputContainer pbNewInputContainer = new PbNewInputContainer(context);
        this.m = pbNewInputContainer;
        pbNewInputContainer.setTransLink(!z);
        ((PbNewInputContainer) this.m).setmAtListRequestResponseCode(i);
        this.t = ((PbNewInputContainer) this.m).getInputView();
        ((PbNewInputContainer) this.m).setHint(context.getString(R.string.obfuscated_res_0x7f0f1092));
        ((PbNewInputContainer) this.m).L(z2);
        this.p = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void g(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, textWatcher) == null) {
            this.t.addTextChangedListener(textWatcher);
        }
    }

    public void h(int i) {
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (t25Var = this.m) == null) {
            return;
        }
        ((PbNewInputContainer) t25Var).x(i);
    }

    public EditText i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (EditText) invokeV.objValue;
    }

    public void j() {
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t25Var = this.m) == null) {
            return;
        }
        ((PbNewInputContainer) t25Var).K();
    }

    public void k(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, textWatcher) == null) {
            this.t.removeTextChangedListener(textWatcher);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.m == null || StringUtils.isNull(str)) {
            return;
        }
        ((PbNewInputContainer) this.m).setDefaultHint(str);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.m == null || StringUtils.isNull(str)) {
            return;
        }
        ((PbNewInputContainer) this.m).setHint(str);
    }

    public void n(int i) {
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (t25Var = this.m) == null) {
            return;
        }
        ((PbNewInputContainer) t25Var).setType(i);
    }
}
