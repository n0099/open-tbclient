package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class qf6 extends fb6<rp4, ThreadCardViewHolder<ThreadData>> implements lw5, pm6, ci5, mw5, tn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public int u;
    public int v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.k = tbPageContext;
        this.e = bdUniqueId2;
    }

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.tn
    public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((rp4) jnVar).s;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((om4) threadData, view2.getContext(), this.u, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new iy.a(1));
            mm6.e(threadData, 1, this.e, pm6.f0, a0());
            FrsViewData frsViewData = this.j;
            if (frsViewData == null || frsViewData.getForum() == null) {
                return;
            }
            mm6.c(threadData, this.j.getForum().getId());
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.t = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? pm6.f0 : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.mw5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: l0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity(), false);
            bVar.h(new mx(this.k.getPageActivity()));
            xw xwVar = new xw(this.k.getPageActivity());
            xwVar.t();
            xwVar.v(this.v);
            bVar.h(xwVar);
            xx k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(this);
            threadCardViewHolder.q(false);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: m0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, rp4Var, threadCardViewHolder);
            if (rp4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.t);
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.g(rp4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            rp4Var.s.updateShowStatus();
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.v = i;
        }
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }
}
