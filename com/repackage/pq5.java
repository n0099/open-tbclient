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
/* loaded from: classes6.dex */
public class pq5 extends jx5<lp5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cp5 i;
    public cp5 j;
    public ViewGroup k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq5(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i, boolean z) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            this.i = new rq5(tbPageContext, i);
            this.j = new rq5(tbPageContext, i);
            s();
            return;
        }
        this.i = new qq5(tbPageContext, i);
        this.j = new qq5(tbPageContext, i);
        r();
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07fb : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.onChangeSkinType(tbPageContext, i);
            this.j.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = (ViewGroup) h();
            View view2 = new View(getContext());
            this.k.setPadding(g().getResources().getDimensionPixelSize(R.dimen.tbds44), g().getResources().getDimensionPixelSize(R.dimen.tbds12), g().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(g().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
            this.k.addView(this.j.getView());
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = (ViewGroup) h();
            View view2 = new View(getContext());
            this.k.setPadding(g().getResources().getDimensionPixelSize(R.dimen.tbds34), g().getResources().getDimensionPixelSize(R.dimen.tbds21), g().getResources().getDimensionPixelSize(R.dimen.tbds34), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(g().getResources().getDimensionPixelSize(R.dimen.tbds20), -1));
            this.k.addView(this.j.getView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: t */
    public void i(lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, lp5Var) == null) || lp5Var == null) {
            return;
        }
        this.i.a(lp5Var.a);
        this.j.a(lp5Var.b);
    }
}
