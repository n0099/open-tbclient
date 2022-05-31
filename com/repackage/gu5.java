package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gu5 extends nv5<ws5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public String k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s(k());
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0103 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.common_color_10106);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (!TextUtils.isEmpty(this.k)) {
                UtilHelper.copyToClipBoard(this.k);
            }
            BdToast c = BdToast.c(getContext(), getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0234));
            c.j(17);
            c.n();
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090213);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090212);
            this.j = textView;
            textView.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: t */
    public void l(ws5 ws5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ws5Var) == null) {
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
            TextView textView = this.i;
            if (textView != null) {
                textView.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0236) + str);
            }
        }
    }
}
