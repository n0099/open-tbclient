package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
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
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class gh6 extends pc6<br4, ThreadCardViewHolder<ThreadData>> implements sx5, jo6, ij5, tx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public int v;
    public ux5<ThreadData> w;

    /* loaded from: classes6.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh6 b;

        public a(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
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
            if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                if (view2 instanceof TbImageView) {
                    if (this.b.w.a instanceof Boolean) {
                        if (((Boolean) this.b.w.a).booleanValue()) {
                            go6.e(threadData, 1, this.b.e, jo6.f0, this.b.a0());
                        } else {
                            go6.e(threadData, 3, this.b.e, jo6.f0, this.b.a0());
                        }
                    }
                    sp6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    go6.e(threadData, 15, this.b.e, jo6.f0, this.b.a0());
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        go6.c(threadData, this.b.j.getForum().getId());
                    }
                } else {
                    go6.e(threadData, 1, this.b.e, jo6.f0, this.b.a0());
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        go6.c(threadData, this.b.j.getForum().getId());
                    }
                }
            } else {
                go6.e(threadData, 2, this.b.e, jo6.f0, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091fe0 && threadData.isVideoThreadType()) {
                this.b.F0(threadData);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0904fc) {
                    sp6.a(jo6.f0, threadData.getRecomReason());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.w.a instanceof Boolean) {
                        if (((Boolean) this.b.w.a).booleanValue()) {
                            io6.k().h(jo6.f0, threadData, 1);
                        } else {
                            io6.k().h(jo6.f0, threadData, 3);
                        }
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090545) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe2) {
                    io6.k().h(jo6.f0, threadData, 5);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().P() != null && threadData.getTopAgreePost().P().A() != null && threadData.getTopAgreePost().P().A().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    io6.k().h(jo6.f0, threadData, i);
                } else {
                    io6.k().h(jo6.f0, threadData, 1);
                }
            } else {
                io6.k().h(jo6.f0, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || zn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3) {
                zn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                zn4Var.objType = 4;
            } else {
                zn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh6 a;

        public c(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof br4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((br4) roVar).s;
                threadData.objType = 1;
                if (this.a.w != null) {
                    this.a.w.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), this.a.v, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: D0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.k.getPageActivity(), true);
            cy cyVar = new cy(this.k.getPageActivity());
            cyVar.b(4280);
            cyVar.t(this.e);
            cyVar.s(new b(this));
            if (this.s) {
                bVar.l().d(0);
                bVar.l().h(0);
            }
            bVar.o(cyVar);
            kz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            threadCardViewHolder.q(false);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: E0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, br4Var, threadCardViewHolder);
            if (br4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.u);
            threadCardViewHolder.c().q(i);
            oc6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                br4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.m(br4Var.s.showFollowBtn(), null);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP, null);
            if (!br4Var.s.isBjh() && !br4Var.s.isWorksInfo() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.t)) {
                threadCardViewHolder.u();
            } else {
                threadCardViewHolder.h();
            }
            threadCardViewHolder.g(br4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.w);
            br4Var.s.updateShowStatus();
            if (jo6.f0 != null) {
                FrsViewData frsViewData2 = this.j;
                br4Var.s.statFloor = (br4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            io6.k().c(jo6.f0, br4Var.s);
            br4Var.s.updateShowStatus();
            go6.n(br4Var.s, this.e, jo6.f0, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                go6.l(br4Var.s, a0());
                go6.m(br4Var.s, this.j.getForum().getId());
            }
            if (br4Var != null) {
                br4Var.s.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void F0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.jo6
    public ho6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? jo6.f0 : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.tx5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.v = i;
        }
    }

    @Override // com.repackage.pc6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.t = str;
        }
    }
}
