package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xp5 extends nv5<hq5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wp5 i;
    public wp5 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xp5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new wp5(j());
        this.j = new wp5(j());
        ViewGroup viewGroup2 = (ViewGroup) k();
        View view2 = new View(getContext());
        viewGroup2.addView(this.i.m());
        viewGroup2.addView(view2, new LinearLayout.LayoutParams(j().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.j.m());
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0108 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.p(tbPageContext, i);
            this.j.p(tbPageContext, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: s */
    public void l(hq5 hq5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hq5Var) == null) || hq5Var == null) {
            return;
        }
        this.i.n(hq5Var.a);
        this.j.n(hq5Var.b);
    }

    public void t(hq5 hq5Var, int i, long j, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{hq5Var, Integer.valueOf(i), Long.valueOf(j), str}) == null) || hq5Var == null) {
            return;
        }
        this.i.o(hq5Var.a, i, j, str);
        this.j.o(hq5Var.b, i, j, str);
    }

    public void u(pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pq5Var) == null) {
            this.i.q(pq5Var);
            this.j.q(pq5Var);
        }
    }
}
