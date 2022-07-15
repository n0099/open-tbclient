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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
/* loaded from: classes7.dex */
public class sh6 extends cd6<qq4, ThreadCardViewHolder<ThreadData>> implements hy5, go6, ck5, iy5, xn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public int v;
    public jy5<ThreadData> w;

    /* loaded from: classes7.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh6 b;

        public a(sh6 sh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.q != null) {
                this.b.q.b(view2, threadData, this.b.getType());
            }
            if ("c13010".equals(this.b.t)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            do6.e(threadData, 1, this.b.e, go6.f0, this.b.a0());
            if (this.b.j != null && this.b.j.getForum() != null) {
                do6.c(threadData, this.b.j.getForum().getId());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09202a && threadData.isVideoThreadType()) {
                this.b.v0(threadData);
            }
            if (!(view2 instanceof ThreadSmartAppLayout) && view2.getId() != R.id.obfuscated_res_0x7f090fc4 && view2.getId() != R.id.obfuscated_res_0x7f09229d && view2.getId() != R.id.obfuscated_res_0x7f09229c) {
                fo6.k().h(go6.f0, threadData, 1);
                return;
            }
            ux5.a(threadData.getTid());
            if (threadData.getSmartApp() != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", threadData.getFid()).param("obj_source", "frs_card").param("obj_id", threadData.getSmartApp().swan_app_id.longValue()).param("obj_name", threadData.getSmartApp().name).param("tid", threadData.getTid()).param("obj_param1", threadData.getSmartApp().is_game.intValue()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.v = 3;
        this.w = new a(this);
        this.k = tbPageContext;
        this.e = bdUniqueId2;
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.xn
    public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            ThreadData threadData = ((qq4) nnVar).s;
            threadData.objType = 1;
            jy5<ThreadData> jy5Var = this.w;
            if (jy5Var != null) {
                jy5Var.a(threadCardViewHolder.b(), threadData);
            }
            ThreadCardUtils.jumpToPB((nn4) threadData, view2.getContext(), this.v, false);
            threadCardViewHolder.c().o(new ny.a(1));
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? go6.f0 : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.iy5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.v = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.t = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: t0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity(), false);
            bVar.h(new ay(this.k.getPageActivity()));
            cy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(this);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: u0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, qq4Var, threadCardViewHolder);
            if (qq4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.u);
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.g(qq4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.w);
            qq4Var.s.updateShowStatus();
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void v0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }
}
