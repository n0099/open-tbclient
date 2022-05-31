package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class go5 extends nv5<qn5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fo5 i;
    public fo5 j;
    public LinearLayout k;
    public ViewGroup l;
    public View m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.i = new fo5(tbPageContext);
        this.j = new fo5(tbPageContext);
        ViewGroup viewGroup2 = (ViewGroup) k();
        this.l = viewGroup2;
        this.k = (LinearLayout) viewGroup2.findViewById(R.id.obfuscated_res_0x7f090e02);
        this.m = this.l.findViewById(R.id.obfuscated_res_0x7f090df8);
        View view2 = new View(getContext());
        this.k.setPadding(j().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, j().getResources().getDimensionPixelSize(R.dimen.tbds44), j().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.k.addView(this.i.h());
        this.k.addView(view2, new LinearLayout.LayoutParams(j().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.k.addView(this.j.h());
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07e1 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.i.k(tbPageContext, i);
            this.j.k(tbPageContext, i);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0204);
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
    public void l(qn5 qn5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, qn5Var) == null) || qn5Var == null) {
            return;
        }
        this.i.i(qn5Var.a);
        this.j.i(qn5Var.b);
        if (qn5Var.c) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void t(lo5 lo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lo5Var) == null) {
            this.i.l(lo5Var);
            this.j.l(lo5Var);
        }
    }
}
