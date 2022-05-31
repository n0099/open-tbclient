package com.repackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.mw;
import com.repackage.xx;
/* loaded from: classes7.dex */
public class yf6 extends fb6<rp4, AutoVideoCardViewHolder<ThreadData>> implements lw5, pm6, ci5, mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public String v;
    public int w;
    public nm6 x;
    public nw5<ThreadData> y;

    /* loaded from: classes7.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf6 b;

        public a(yf6 yf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yf6Var;
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
                this.b.q.b(view2, threadData, ThreadData.TYPE_VIDEO);
            }
            if ("c13010".equals(this.b.v)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091f85 && threadData.isVideoThreadType()) {
                om6.k().h(this.b.x, threadData, 1);
                this.b.J0(threadData);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09053f) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092298 || view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090cf2) {
                yn6.a(this.b.x, threadData.getRecomReason());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0915d3) {
                om6.k().h(this.b.x, threadData, 4);
                this.b.J0(threadData);
            } else if (view2 instanceof ThreadGodReplyLayout) {
                this.b.J0(threadData);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0915d3) {
                mm6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                yn6.g(threadData, this.b.j, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092335) {
                mm6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                yn6.g(threadData, this.b.j, 1);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f092298 && view2.getId() != R.id.obfuscated_res_0x7f092278) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    mm6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mm6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091cb6) {
                    yn6.g(threadData, this.b.j, 1);
                    mm6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                } else {
                    mm6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                }
            } else {
                mm6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;
        public final /* synthetic */ yf6 b;

        public b(yf6 yf6Var, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf6Var, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yf6Var;
            this.a = fyVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(om4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(om4Var, this.b.a, this.b.w, false, computeViewArea);
                return;
            }
            om4Var.objType = 5;
            ThreadCardUtils.jumpToPB(om4Var, this.b.a, this.b.w, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf6 a;

        public c(yf6 yf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((rp4) jnVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((om4) threadData, view2.getContext(), this.a.w, false, qw.a((pn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.w = 3;
        this.x = new nm6();
        this.y = new a(this);
        this.t = tbPageContext;
    }

    public final t48 G0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            t48 t48Var = new t48();
            if (100 == a0().tabType) {
                t48Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                t48Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.x.e == 501) {
                t48Var.a = "frs_tab";
            }
            t48Var.d = this.x.c;
            t48Var.c = threadData.getTid();
            t48Var.f = threadData.mRecomSource;
            t48Var.g = threadData.mRecomReason;
            t48Var.h = threadData.mRecomWeight;
            t48Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                t48Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return t48Var;
        }
        return (t48) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: H0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.t.getPageActivity(), false);
            sw swVar = new sw(this.t.getPageActivity(), true);
            swVar.t("frs");
            swVar.x("2003");
            swVar.u(new b(this, swVar));
            if (this.w == 502) {
                swVar.v(false);
            } else {
                swVar.v(true);
            }
            bVar.n(swVar);
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.k(this.e);
            k.p(this.y);
            k.r(this.w);
            V(new c(this));
            autoVideoCardViewHolder.q(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: I0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (rp4Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder.c() instanceof bi5) {
                autoVideoCardViewHolder.c().b(this.u);
            }
            super.S(i, view2, viewGroup, rp4Var, autoVideoCardViewHolder);
            eb6.i(autoVideoCardViewHolder.c().f(), this.j);
            autoVideoCardViewHolder.x(G0(rp4Var.s));
            autoVideoCardViewHolder.c().q(i);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rp4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.g(rp4Var.s);
            autoVideoCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.y);
            if (this.x != null) {
                FrsViewData frsViewData2 = this.j;
                rp4Var.s.statFloor = (rp4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            om6.k().c(this.x, rp4Var.s);
            om6.k().b(rp4Var.s);
            om6.k().e(rp4Var.s, b0());
            mm6.o(rp4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                mm6.m(rp4Var.s, a0());
                mm6.n(rp4Var.s, this.j.getForum().getId());
            }
            if (100 == a0().tabType) {
                om6.k().f(rp4Var.s);
            }
            rp4Var.s.updateShowStatus();
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void J0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.mw5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.v = str;
        }
    }
}
