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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.qy;
/* loaded from: classes5.dex */
public class ci6 extends kd6<qq4, AutoVideoCardViewHolder<ThreadData>> implements rx5, ip6, qi5, sx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public String v;
    public int w;
    public gp6 x;
    public tx5<ThreadData> y;

    /* loaded from: classes5.dex */
    public class a extends tx5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci6 b;

        public a(ci6 ci6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
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
            if (view2.getId() == R.id.obfuscated_res_0x7f091f87 && threadData.isVideoThreadType()) {
                hp6.k().h(this.b.x, threadData, 1);
                this.b.J0(threadData);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090548) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09229d || view2.getId() == R.id.obfuscated_res_0x7f09227b) {
                hp6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090d40) {
                rq6.a(this.b.x, threadData.getRecomReason());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091606) {
                hp6.k().h(this.b.x, threadData, 4);
                this.b.J0(threadData);
            } else if (view2 instanceof ThreadGodReplyLayout) {
                this.b.J0(threadData);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091606) {
                fp6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                rq6.g(threadData, this.b.j, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09233f) {
                fp6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                rq6.g(threadData, this.b.j, 1);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09229d && view2.getId() != R.id.obfuscated_res_0x7f09227b) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    fp6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    rq6.g(threadData, this.b.j, 1);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    fp6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    rq6.g(threadData, this.b.j, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091cba) {
                    rq6.g(threadData, this.b.j, 1);
                    fp6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                } else {
                    fp6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                }
            } else {
                fp6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j00 a;
        public final /* synthetic */ ci6 b;

        public b(ci6 ci6Var, j00 j00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci6Var, j00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci6Var;
            this.a = j00Var;
        }

        @Override // com.repackage.qy.a
        public void a(pn4 pn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pn4Var) == null) || pn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(pn4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(pn4Var, this.b.a, this.b.w, false, computeViewArea);
                return;
            }
            pn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(pn4Var, this.b.a, this.b.w, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci6 a;

        public c(ci6 ci6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((qq4) uoVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((pn4) threadData, view2.getContext(), this.a.w, false, uy.a((zo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = new gp6();
        this.y = new a(this);
        this.t = tbPageContext;
    }

    public final m78 G0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            m78 m78Var = new m78();
            if (100 == a0().tabType) {
                m78Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                m78Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.x.e == 501) {
                m78Var.a = "frs_tab";
            }
            m78Var.d = this.x.c;
            m78Var.c = threadData.getTid();
            m78Var.f = threadData.mRecomSource;
            m78Var.g = threadData.mRecomReason;
            m78Var.h = threadData.mRecomWeight;
            m78Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                m78Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return m78Var;
        }
        return (m78) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: H0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.t.getPageActivity(), false);
            wy wyVar = new wy(this.t.getPageActivity(), true);
            wyVar.t("frs");
            wyVar.x("2003");
            wyVar.u(new b(this, wyVar));
            if (this.w == 502) {
                wyVar.v(false);
            } else {
                wyVar.v(true);
            }
            bVar.n(wyVar);
            b00 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.k(this.e);
            k.p(this.y);
            k.r(this.w);
            V(new c(this));
            autoVideoCardViewHolder.p(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kd6, com.repackage.ho
    /* renamed from: I0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (qq4Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder.c() instanceof pi5) {
                autoVideoCardViewHolder.c().b(this.u);
            }
            super.S(i, view2, viewGroup, qq4Var, autoVideoCardViewHolder);
            jd6.i(autoVideoCardViewHolder.c().f(), this.j);
            autoVideoCardViewHolder.x(G0(qq4Var.s));
            autoVideoCardViewHolder.c().q(i);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                qq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.g(qq4Var.s);
            autoVideoCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.y);
            if (this.x != null) {
                FrsViewData frsViewData2 = this.j;
                qq4Var.s.statFloor = (qq4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            hp6.k().c(this.x, qq4Var.s);
            hp6.k().b(qq4Var.s);
            hp6.k().e(qq4Var.s, b0());
            fp6.n(qq4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                fp6.l(qq4Var.s, a0());
                fp6.m(qq4Var.s, this.j.getForum().getId());
            }
            if (100 == a0().tabType) {
                hp6.k().f(qq4Var.s);
            }
            qq4Var.s.updateShowStatus();
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

    @Override // com.repackage.rx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.ip6
    public gp6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : (gp6) invokeV.objValue;
    }

    @Override // com.repackage.sx5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.rx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.kd6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.v = str;
        }
    }
}
