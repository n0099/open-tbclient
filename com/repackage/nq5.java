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
public class nq5 extends nv5<hq5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oq5 i;
    public oq5 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nq5(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
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
        this.i = new oq5(j(), z);
        this.j = new oq5(j(), z);
        ViewGroup viewGroup = (ViewGroup) k();
        View view2 = new View(getContext());
        viewGroup.addView(this.i.g());
        viewGroup.addView(view2, new LinearLayout.LayoutParams(j().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.j.g());
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d00fe : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.i(tbPageContext, i);
            this.j.i(tbPageContext, i);
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
        this.i.h(hq5Var.a);
        this.j.h(hq5Var.b);
    }

    public void t(pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pq5Var) == null) {
            this.i.j(pq5Var);
            this.j.j(pq5Var);
        }
    }
}
