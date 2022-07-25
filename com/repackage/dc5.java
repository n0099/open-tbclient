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
import com.repackage.fc5;
/* loaded from: classes5.dex */
public class dc5 extends bc5<l55, fc5.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> e;

    public dc5(TbPageContext<?> tbPageContext) {
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
    @Override // com.repackage.bc5
    /* renamed from: g */
    public void d(ViewType viewType, l55 l55Var, fc5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, l55Var, bVar) == null) {
            l55Var.m((!bVar.b || TextUtils.isEmpty(bVar.a)) ? bVar.g : bVar.a);
            l55Var.k(bVar.d);
            l55Var.i(bVar.c);
            l55Var.n(bVar.f);
            l55Var.g(bVar.e);
            l55Var.p();
            l55Var.onChangeSkinType();
            l55Var.c().setOnClickListener(bVar.h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bc5
    /* renamed from: h */
    public l55 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new l55(this.e.getPageActivity(), null) : (l55) invokeLL.objValue;
    }
}
