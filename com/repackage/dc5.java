package com.repackage;

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
public class dc5 extends ac5<j55, ec5.d> {
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
    @Override // com.repackage.ac5
    /* renamed from: g */
    public void d(ViewType viewType, j55 j55Var, ec5.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, j55Var, dVar) == null) {
            j55Var.s(dVar.b);
            j55Var.k().setText(dVar.a);
            j55Var.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ac5
    /* renamed from: h */
    public j55 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new j55(this.e.getPageActivity()) : (j55) invokeLL.objValue;
    }
}
