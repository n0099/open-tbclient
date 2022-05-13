package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bt5 extends pc6<ii8, FrsPageAlaStageViewHolder> implements sx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public mt5 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.pc6, com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i, view2, viewGroup, (ii8) obj, (FrsPageAlaStageViewHolder) viewHolder);
        return view2;
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.t = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: l0 */
    public FrsPageAlaStageViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                return null;
            }
            mt5 mt5Var = new mt5(tbPageContext);
            this.u = mt5Var;
            mt5Var.a(this.t);
            return new FrsPageAlaStageViewHolder(this.u);
        }
        return (FrsPageAlaStageViewHolder) invokeL.objValue;
    }

    public View m0(int i, View view2, ViewGroup viewGroup, ii8 ii8Var, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ii8Var, frsPageAlaStageViewHolder})) == null) {
            super.S(i, view2, viewGroup, ii8Var, frsPageAlaStageViewHolder);
            if (ii8Var != null) {
                FrsViewData frsViewData = this.j;
                int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
                mt5 mt5Var = frsPageAlaStageViewHolder.a;
                mt5Var.x = (i + 1) - topThreadSize;
                mt5Var.a(this.t);
                frsPageAlaStageViewHolder.a.l(ii8Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }
}
