package com.repackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.rw;
/* loaded from: classes7.dex */
public class oj6 extends ue6<ir4, AutoVideoCardViewHolder<ThreadData>> implements zz5, zp6, pl5, a06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public String n;
    public int o;
    public xp6 p;
    public b06<ThreadData> q;

    /* loaded from: classes7.dex */
    public class a extends b06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj6 b;

        public a(oj6 oj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, threadData, ThreadData.TYPE_VIDEO);
            }
            if ("c13010".equals(this.b.n)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09212a && threadData.isVideoThreadType()) {
                yp6.k().h(this.b.p, threadData, 1);
                this.b.d0(threadData);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09053c) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092450 || view2.getId() == R.id.obfuscated_res_0x7f092422) {
                yp6.k().h(this.b.p, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090d2e) {
                hr6.a(this.b.p, threadData.getRecomReason());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09170f) {
                yp6.k().h(this.b.p, threadData, 4);
                this.b.d0(threadData);
            } else if (view2 instanceof ThreadGodReplyLayout) {
                this.b.d0(threadData);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09170f) {
                wp6.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                hr6.g(threadData, this.b.b, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924ef) {
                wp6.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                hr6.g(threadData, this.b.b, 1);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f092450 && view2.getId() != R.id.obfuscated_res_0x7f092422) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09213e) {
                    wp6.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                    hr6.g(threadData, this.b.b, 1);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    wp6.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                    hr6.g(threadData, this.b.b, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091e43) {
                    hr6.g(threadData, this.b.b, 1);
                    wp6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                } else {
                    wp6.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                }
            } else {
                wp6.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ oj6 b;

        public b(oj6 oj6Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj6Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oj6Var;
            this.a = lyVar;
        }

        @Override // com.repackage.rw.a
        public void a(fo4 fo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fo4Var) == null) || fo4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(fo4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, this.b.o, false, computeViewArea);
                return;
            }
            fo4Var.objType = 5;
            ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, this.b.o, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj6 a;

        public c(oj6 oj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof ir4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((ir4) onVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fo4) threadData, view2.getContext(), this.a.o, false, vw.a((un) viewGroup, view2, i));
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.o = 3;
        this.p = new xp6();
        this.q = new a(this);
        this.l = tbPageContext;
    }

    @Override // com.repackage.zz5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final y88 a0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            y88 y88Var = new y88();
            if (100 == t().tabType) {
                y88Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                y88Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.p.e == 501) {
                y88Var.a = "frs_tab";
            }
            y88Var.d = this.p.c;
            y88Var.c = threadData.getTid();
            y88Var.f = threadData.mRecomSource;
            y88Var.g = threadData.mRecomReason;
            y88Var.h = threadData.mRecomWeight;
            y88Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                y88Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return y88Var;
        }
        return (y88) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: b0 */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.l.getPageActivity(), false);
            xw xwVar = new xw(this.l.getPageActivity(), true);
            xwVar.u("frs");
            xwVar.y("2003");
            xwVar.v(new b(this, xwVar));
            if (this.o == 502) {
                xwVar.w(false);
            } else {
                xwVar.w(true);
            }
            bVar.n(xwVar);
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.p(this.q);
            k.r(this.o);
            setOnAdapterItemClickListener(new c(this));
            autoVideoCardViewHolder.n(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ue6, com.repackage.bn
    /* renamed from: c0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ir4 ir4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ir4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (ir4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.a() instanceof ol5) {
                autoVideoCardViewHolder.a().b(this.m);
            }
            super.onFillViewHolder(i, view2, viewGroup, ir4Var, autoVideoCardViewHolder);
            te6.i(autoVideoCardViewHolder.a().f(), this.b);
            autoVideoCardViewHolder.u(a0(ir4Var.t));
            autoVideoCardViewHolder.a().q(i);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                ir4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.e(ir4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.q);
            if (this.p != null) {
                FrsViewData frsViewData2 = this.b;
                ir4Var.t.statFloor = (ir4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            yp6.k().c(this.p, ir4Var.t);
            yp6.k().b(ir4Var.t);
            yp6.k().e(ir4Var.t, u());
            wp6.o(ir4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                wp6.m(ir4Var.t, t());
                wp6.n(ir4Var.t, this.b.getForum().getId());
            }
            if (100 == t().tabType) {
                yp6.k().f(ir4Var.t);
            }
            ir4Var.t.updateShowStatus();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", u() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.repackage.zp6
    public xp6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (xp6) invokeV.objValue;
    }

    @Override // com.repackage.a06
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // com.repackage.zz5
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.repackage.ue6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }
}
