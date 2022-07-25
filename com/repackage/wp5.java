package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wp5 extends an<aq5, LiveTabConcernRecommendLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public kq5 j;
    public lq5 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wp5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), aq5.d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: Z */
    public LiveTabConcernRecommendLineHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kq5 kq5Var = new kq5(this.i, viewGroup);
            this.j = kq5Var;
            lq5 lq5Var = this.k;
            if (lq5Var != null) {
                kq5Var.s(lq5Var);
            }
            return new LiveTabConcernRecommendLineHolder(this.j);
        }
        return (LiveTabConcernRecommendLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, aq5 aq5Var, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        InterceptResult invokeCommon;
        kq5 kq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, aq5Var, liveTabConcernRecommendLineHolder})) == null) {
            if (liveTabConcernRecommendLineHolder == null || (kq5Var = liveTabConcernRecommendLineHolder.a) == null) {
                return null;
            }
            kq5Var.i(aq5Var);
            return liveTabConcernRecommendLineHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(lq5 lq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lq5Var) == null) {
            this.k = lq5Var;
            kq5 kq5Var = this.j;
            if (kq5Var != null) {
                kq5Var.s(lq5Var);
            }
        }
    }
}
