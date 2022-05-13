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
/* loaded from: classes5.dex */
public class dp5 extends eo<hp5, LiveTabConcernRecommendLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public rp5 j;
    public sp5 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), hp5.d);
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
    @Override // com.repackage.eo
    /* renamed from: Z */
    public LiveTabConcernRecommendLineHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            rp5 rp5Var = new rp5(this.i, viewGroup);
            this.j = rp5Var;
            sp5 sp5Var = this.k;
            if (sp5Var != null) {
                rp5Var.t(sp5Var);
            }
            return new LiveTabConcernRecommendLineHolder(this.j);
        }
        return (LiveTabConcernRecommendLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, hp5 hp5Var, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        InterceptResult invokeCommon;
        rp5 rp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hp5Var, liveTabConcernRecommendLineHolder})) == null) {
            if (liveTabConcernRecommendLineHolder == null || (rp5Var = liveTabConcernRecommendLineHolder.a) == null) {
                return null;
            }
            rp5Var.l(hp5Var);
            return liveTabConcernRecommendLineHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(sp5 sp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sp5Var) == null) {
            this.k = sp5Var;
            rp5 rp5Var = this.j;
            if (rp5Var != null) {
                rp5Var.t(sp5Var);
            }
        }
    }
}
