package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ko5 extends nv5<ao5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jo5 i;
    public jo5 j;
    public jo5 k;
    public ViewGroup l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.i = new jo5(tbPageContext);
        this.j = new jo5(tbPageContext);
        this.k = new jo5(tbPageContext);
        this.l = (ViewGroup) k();
        new View(getContext());
        this.l.setPadding(j().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, j().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.l.addView(this.i.e());
        this.l.addView(this.j.e());
        this.l.addView(this.k.e());
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07e6 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.i.g(tbPageContext, i);
            this.j.g(tbPageContext, i);
            this.k.g(tbPageContext, i);
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
    public void l(ao5 ao5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ao5Var) == null) || ao5Var == null) {
            return;
        }
        this.i.f(ao5Var.a);
        this.j.f(ao5Var.b);
        this.k.f(ao5Var.c);
    }

    public void t(lo5 lo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lo5Var) == null) {
            this.i.h(lo5Var);
            this.j.h(lo5Var);
            this.k.h(lo5Var);
        }
    }
}
