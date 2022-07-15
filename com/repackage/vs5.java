package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vs5 extends an<mt5, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public mo5 j;
    public String k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vs5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.an
    /* renamed from: Z */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.i);
            alaGameFrsLiveDoubleView.t(this.k);
            return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
        }
        return (AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, mt5 mt5Var, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mt5Var, alaGameFrsLiveDoubleViewHolder})) == null) {
            alaGameFrsLiveDoubleViewHolder.a.i(mt5Var);
            alaGameFrsLiveDoubleViewHolder.a.u(this.j);
            lo5.b().a(new StatisticItem("c12115").param("obj_id", mt5Var.a.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(mt5Var.a.getThreadAlaInfo().appId) ? mt5Var.a.getThreadAlaInfo().appId : ""));
            ThreadData threadData = mt5Var.b;
            if (threadData != null) {
                lo5.b().a(new StatisticItem("c12115").param("obj_id", mt5Var.b.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(threadData.getThreadAlaInfo().appId) ? "" : mt5Var.b.getThreadAlaInfo().appId));
            }
            return alaGameFrsLiveDoubleViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(mo5 mo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mo5Var) == null) {
            this.j = mo5Var;
        }
    }
}
