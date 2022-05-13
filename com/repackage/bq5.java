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
/* loaded from: classes5.dex */
public class bq5 extends uw5<ro5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ho5 i;
    public ho5 j;
    public ViewGroup k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq5(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i, boolean z) {
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
            this.i = new dq5(tbPageContext, i);
            this.j = new dq5(tbPageContext, i);
            t();
            return;
        }
        this.i = new cq5(tbPageContext, i);
        this.j = new cq5(tbPageContext, i);
        s();
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07eb : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
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

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = (ViewGroup) k();
            View view2 = new View(getContext());
            this.k.setPadding(j().getResources().getDimensionPixelSize(R.dimen.tbds44), j().getResources().getDimensionPixelSize(R.dimen.tbds12), j().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(j().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
            this.k.addView(this.j.getView());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = (ViewGroup) k();
            View view2 = new View(getContext());
            this.k.setPadding(j().getResources().getDimensionPixelSize(R.dimen.tbds34), j().getResources().getDimensionPixelSize(R.dimen.tbds21), j().getResources().getDimensionPixelSize(R.dimen.tbds34), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(j().getResources().getDimensionPixelSize(R.dimen.tbds20), -1));
            this.k.addView(this.j.getView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: u */
    public void l(ro5 ro5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ro5Var) == null) || ro5Var == null) {
            return;
        }
        this.i.a(ro5Var.a);
        this.j.a(ro5Var.b);
    }
}
