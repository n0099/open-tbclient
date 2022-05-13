package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j68 extends uw5<h58> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public p48 j;
    public View k;
    public TextView l;
    public TextView m;
    public ImageView n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j68(TbPageContext<?> tbPageContext) {
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

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b3 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
                SkinManager.setImageResource(this.n, R.drawable.pic_pop_key);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0304, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        p48 p48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null || (p48Var = this.j) == null || view2 != this.l) {
            return;
        }
        p48Var.a();
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090574);
            this.k = view2.findViewById(R.id.obfuscated_res_0x7f0920f3);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091338);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091613);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090532);
            this.l.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: t */
    public void l(h58 h58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h58Var) == null) {
            if (h58Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            View view2 = this.k;
            if (view2 != null) {
                if (h58Var.a) {
                    view2.setVisibility(8);
                } else {
                    view2.setVisibility(0);
                }
            }
        }
    }

    public void u(p48 p48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, p48Var) == null) {
            this.j = p48Var;
        }
    }
}
