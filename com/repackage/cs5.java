package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherRecommendTitleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cs5 extends eo<ks5, AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    public AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder(new AlaFrsLiveListGatherRecommendTitleView(this.i)) : (AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, ks5 ks5Var, AlaFrsLiveListGatherRecommendTitleView.AlaFrsLiveListGatherRecommendTitleViewHolder alaFrsLiveListGatherRecommendTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ks5Var, alaFrsLiveListGatherRecommendTitleViewHolder})) == null) ? alaFrsLiveListGatherRecommendTitleViewHolder.b() : (View) invokeCommon.objValue;
    }
}
