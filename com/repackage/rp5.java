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
/* loaded from: classes7.dex */
public class rp5 extends uw5<hp5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qp5 i;
    public qp5 j;
    public qp5 k;
    public ViewGroup l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rp5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.i = new qp5(tbPageContext);
        this.j = new qp5(tbPageContext);
        this.k = new qp5(tbPageContext);
        this.l = (ViewGroup) k();
        new View(getContext());
        this.l.setPadding(j().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, j().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.l.addView(this.i.e());
        this.l.addView(this.j.e());
        this.l.addView(this.k.e());
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07f3 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
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
    @Override // com.repackage.uw5
    /* renamed from: s */
    public void l(hp5 hp5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hp5Var) == null) || hp5Var == null) {
            return;
        }
        this.i.f(hp5Var.a);
        this.j.f(hp5Var.b);
        this.k.f(hp5Var.c);
    }

    public void t(sp5 sp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sp5Var) == null) {
            this.i.h(sp5Var);
            this.j.h(sp5Var);
            this.k.h(sp5Var);
        }
    }
}
