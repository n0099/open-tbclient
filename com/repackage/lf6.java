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
import com.repackage.iy;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class lf6 extends fb6<rp4, ThreadCardViewHolder<ThreadData>> implements lw5, pm6, ci5, mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public boolean v;
    public int w;
    public nw5<ThreadData> x;

    /* loaded from: classes6.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf6 b;

        public a(lf6 lf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
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
            if (view2.getId() != R.id.obfuscated_res_0x7f092298 && view2.getId() != R.id.obfuscated_res_0x7f092278) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    mm6.e(threadData, 5, this.b.e, pm6.f0, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb6) {
                    mm6.e(threadData, 14, this.b.e, pm6.f0, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e66) {
                    mm6.e(threadData, 12, this.b.e, pm6.f0, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7c) {
                    mm6.e(threadData, 13, this.b.e, pm6.f0, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.x.a instanceof Boolean) {
                        if (((Boolean) this.b.x.a).booleanValue()) {
                            mm6.e(threadData, 1, this.b.e, pm6.f0, this.b.a0());
                        } else {
                            mm6.e(threadData, 3, this.b.e, pm6.f0, this.b.a0());
                        }
                    }
                    yn6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mm6.e(threadData, 15, this.b.e, pm6.f0, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                } else {
                    mm6.e(threadData, 1, this.b.e, pm6.f0, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                }
            } else {
                mm6.e(threadData, 2, this.b.e, pm6.f0, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091f85 && threadData.isVideoThreadType()) {
                this.b.G0(threadData);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f092298 && view2.getId() != R.id.obfuscated_res_0x7f092278) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0904f6) {
                    yn6.a(pm6.f0, threadData.getRecomReason());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.x.a instanceof Boolean) {
                        if (((Boolean) this.b.x.a).booleanValue()) {
                            om6.k().h(pm6.f0, threadData, 1);
                        } else {
                            om6.k().h(pm6.f0, threadData, 3);
                        }
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09053f) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
                    om6.k().h(pm6.f0, threadData, 5);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().P() != null && threadData.getTopAgreePost().P().A() != null && threadData.getTopAgreePost().P().A().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    om6.k().h(pm6.f0, threadData, i);
                } else {
                    om6.k().h(pm6.f0, threadData, 1);
                }
            } else {
                om6.k().h(pm6.f0, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw a;
        public final /* synthetic */ lf6 b;

        public b(lf6 lf6Var, zw zwVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf6Var, zwVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lf6Var;
            this.a = zwVar;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                if ((wa6.f().i() || va6.h().j()) && !this.a.u()) {
                    ThreadData threadData = ((rp4) jnVar).s;
                    if (threadData == null) {
                        return;
                    }
                    if (!threadData.isMarkToDel() && wa6.f().i()) {
                        if (wa6.f().a(threadData)) {
                            threadData.setMarkToDel(true);
                        }
                    } else if (!threadData.isMarkToMove() && va6.h().j()) {
                        if (va6.h().a(threadData)) {
                            threadData.setMarkToMove(true);
                        }
                    } else {
                        wa6.f().l(threadData);
                        threadData.setMarkToDel(false);
                        va6.h().l(threadData);
                        threadData.setMarkToMove(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, threadData));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData2 = ((rp4) jnVar).s;
                threadData2.objType = 1;
                if (this.b.x != null) {
                    this.b.x.a(threadCardViewHolder.b(), threadData2);
                }
                ThreadCardUtils.jumpToPB((om4) threadData2, view2.getContext(), this.b.w, false);
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
    @Override // com.repackage.wm
    /* renamed from: E0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity(), false);
            zw zwVar = new zw(this.k.getPageActivity());
            bVar.h(zwVar);
            zwVar.x(this.v);
            zwVar.w("frs");
            xx k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(new b(this, zwVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: F0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, rp4Var, threadCardViewHolder);
            if (rp4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.u);
            threadCardViewHolder.c().q(i);
            eb6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rp4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.g(rp4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.x);
            rp4Var.s.updateShowStatus();
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

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? pm6.f0 : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.mw5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.t = str;
        }
    }

    @Override // com.repackage.fb6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.v = z;
        }
    }
}
