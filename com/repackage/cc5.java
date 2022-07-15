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
import com.repackage.ec5;
/* loaded from: classes5.dex */
public class cc5 extends ac5<k55, ec5.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> e;

    public cc5(TbPageContext<?> tbPageContext) {
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
    @Override // com.repackage.ac5
    /* renamed from: g */
    public void d(ViewType viewType, k55 k55Var, ec5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, k55Var, bVar) == null) {
            k55Var.m((!bVar.b || TextUtils.isEmpty(bVar.a)) ? bVar.g : bVar.a);
            k55Var.k(bVar.d);
            k55Var.i(bVar.c);
            k55Var.n(bVar.f);
            k55Var.g(bVar.e);
            k55Var.p();
            k55Var.onChangeSkinType();
            k55Var.c().setOnClickListener(bVar.h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ac5
    /* renamed from: h */
    public k55 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new k55(this.e.getPageActivity(), null) : (k55) invokeLL.objValue;
    }
}
