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
import com.repackage.oa5;
/* loaded from: classes6.dex */
public class ma5 extends ka5<t35, oa5.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> e;

    public ma5(TbPageContext<?> tbPageContext) {
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
    @Override // com.repackage.ka5
    /* renamed from: g */
    public void d(ViewType viewType, t35 t35Var, oa5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, t35Var, bVar) == null) {
            t35Var.m((!bVar.b || TextUtils.isEmpty(bVar.a)) ? bVar.g : bVar.a);
            t35Var.k(bVar.d);
            t35Var.i(bVar.c);
            t35Var.n(bVar.f);
            t35Var.g(bVar.e);
            t35Var.p();
            t35Var.onChangeSkinType();
            t35Var.c().setOnClickListener(bVar.h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ka5
    /* renamed from: h */
    public t35 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new t35(this.e.getPageActivity(), null) : (t35) invokeLL.objValue;
    }
}
