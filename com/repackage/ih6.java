package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
/* loaded from: classes6.dex */
public class ih6 extends cd6<qq4, ThreadCardViewHolder<ThreadData>> implements hy5, go6, ck5, iy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public boolean v;
    public int w;
    public jy5<ThreadData> x;

    /* loaded from: classes6.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih6 b;

        public a(ih6 ih6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ih6Var;
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
            if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09203e) {
                    do6.e(threadData, 5, this.b.e, go6.f0, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                    do6.e(threadData, 14, this.b.e, go6.f0, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e65) {
                    do6.e(threadData, 12, this.b.e, go6.f0, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7d) {
                    do6.e(threadData, 13, this.b.e, go6.f0, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.x.a instanceof Boolean) {
                        if (((Boolean) this.b.x.a).booleanValue()) {
                            do6.e(threadData, 1, this.b.e, go6.f0, this.b.a0());
                        } else {
                            do6.e(threadData, 3, this.b.e, go6.f0, this.b.a0());
                        }
                    }
                    pp6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    do6.e(threadData, 15, this.b.e, go6.f0, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else {
                    do6.e(threadData, 1, this.b.e, go6.f0, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                }
            } else {
                do6.e(threadData, 2, this.b.e, go6.f0, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09202a && threadData.isVideoThreadType()) {
                this.b.G0(threadData);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0904d8) {
                    pp6.a(go6.f0, threadData.getRecomReason());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.x.a instanceof Boolean) {
                        if (((Boolean) this.b.x.a).booleanValue()) {
                            fo6.k().h(go6.f0, threadData, 1);
                        } else {
                            fo6.k().h(go6.f0, threadData, 3);
                        }
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090521) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09202c) {
                    fo6.k().h(go6.f0, threadData, 5);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().Q() != null && threadData.getTopAgreePost().Q().C() != null && threadData.getTopAgreePost().Q().C().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    fo6.k().h(go6.f0, threadData, i);
                } else {
                    fo6.k().h(go6.f0, threadData, 1);
                }
            } else {
                fo6.k().h(go6.f0, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex a;
        public final /* synthetic */ ih6 b;

        public b(ih6 ih6Var, ex exVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih6Var, exVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ih6Var;
            this.a = exVar;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                if ((tc6.f().i() || sc6.h().j()) && !this.a.v()) {
                    ThreadData threadData = ((qq4) nnVar).s;
                    if (threadData == null) {
                        return;
                    }
                    if (!threadData.isMarkToDel() && tc6.f().i()) {
                        if (tc6.f().a(threadData)) {
                            threadData.setMarkToDel(true);
                        }
                    } else if (!threadData.isMarkToMove() && sc6.h().j()) {
                        if (sc6.h().a(threadData)) {
                            threadData.setMarkToMove(true);
                        }
                    } else {
                        tc6.f().l(threadData);
                        threadData.setMarkToDel(false);
                        sc6.h().l(threadData);
                        threadData.setMarkToMove(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, threadData));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData2 = ((qq4) nnVar).s;
                threadData2.objType = 1;
                if (this.b.x != null) {
                    this.b.x.a(threadCardViewHolder.b(), threadData2);
                }
                ThreadCardUtils.jumpToPB((nn4) threadData2, view2.getContext(), this.b.w, false);
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.v = true;
        this.w = 3;
        this.x = new a(this);
        this.k = tbPageContext;
        this.e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: E0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity(), false);
            ex exVar = new ex(this.k.getPageActivity());
            bVar.h(exVar);
            exVar.y(this.v);
            exVar.x("frs");
            cy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(new b(this, exVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: F0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, qq4Var, threadCardViewHolder);
            if (qq4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.u);
            threadCardViewHolder.c().q(i);
            bd6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                qq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.g(qq4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.x);
            qq4Var.s.updateShowStatus();
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void G0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? go6.f0 : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.iy5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.t = str;
        }
    }

    @Override // com.repackage.cd6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.v = z;
        }
    }
}
