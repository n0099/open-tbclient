package com.repackage;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ub5;
/* loaded from: classes7.dex */
public class sb5 extends qb5<y45, ub5.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> e;

    public sb5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.qb5
    /* renamed from: g */
    public void d(ViewType viewType, y45 y45Var, ub5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, y45Var, bVar) == null) {
            y45Var.m((!bVar.b || TextUtils.isEmpty(bVar.a)) ? bVar.g : bVar.a);
            y45Var.k(bVar.d);
            y45Var.i(bVar.c);
            y45Var.n(bVar.f);
            y45Var.g(bVar.e);
            y45Var.p();
            y45Var.onChangeSkinType();
            y45Var.c().setOnClickListener(bVar.h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.qb5
    /* renamed from: h */
    public y45 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new y45(this.e.getPageActivity(), null) : (y45) invokeLL.objValue;
    }
}
