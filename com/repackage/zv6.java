package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zv6 extends rw<uv6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendBarLayout f;
    public int g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zv6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Byte.valueOf(b)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 3;
        this.f = new RecommendBarLayout(tbPageContext, tbPageContext.getPageActivity(), bdUniqueId, b);
    }

    @Override // com.repackage.rw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.g != i) {
                this.f.onChangeSkinType(tbPageContext, i);
                n(this.f, 3);
            }
            this.g = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hx
    /* renamed from: p */
    public void a(uv6 uv6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, uv6Var) == null) || uv6Var == null || this.h == uv6Var.hashCode()) {
            return;
        }
        this.h = uv6Var.hashCode();
        this.f.setData(uv6Var);
    }
}
