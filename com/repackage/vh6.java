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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
/* loaded from: classes7.dex */
public class vh6 extends cd6<rq4, AutoVideoCardViewHolder<ThreadData>> implements hy5, go6, ck5, iy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public String v;
    public int w;
    public eo6 x;
    public jy5<ThreadData> y;

    /* loaded from: classes7.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 b;

        public a(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vh6Var;
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
                this.b.q.b(view2, threadData, ThreadData.TYPE_VIDEO);
            }
            if ("c13010".equals(this.b.v)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09202e && threadData.isVideoThreadType()) {
                fo6.k().h(this.b.x, threadData, 1);
                this.b.J0(threadData);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090521) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09232f || view2.getId() == R.id.obfuscated_res_0x7f09230e) {
                fo6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090ce9) {
                pp6.a(this.b.x, threadData.getRecomReason());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091649) {
                fo6.k().h(this.b.x, threadData, 4);
                this.b.J0(threadData);
            } else if (view2 instanceof ThreadGodReplyLayout) {
                this.b.J0(threadData);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091649) {
                do6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                pp6.g(threadData, this.b.j, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0923cc) {
                do6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                pp6.g(threadData, this.b.j, 1);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09232f && view2.getId() != R.id.obfuscated_res_0x7f09230e) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092042) {
                    do6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    do6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091d57) {
                    pp6.g(threadData, this.b.j, 1);
                    do6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                } else {
                    do6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                }
            } else {
                do6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ vh6 b;

        public b(vh6 vh6Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vh6Var;
            this.a = kyVar;
        }

        @Override // com.repackage.qw.a
        public void a(on4 on4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, on4Var) == null) || on4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(on4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(on4Var, this.b.a, this.b.w, false, computeViewArea);
                return;
            }
            on4Var.objType = 5;
            ThreadCardUtils.jumpToPB(on4Var, this.b.a, this.b.w, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 a;

        public c(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof rq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((rq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.a(), threadData);
                }
                ThreadCardUtils.jumpToPB((on4) threadData, view2.getContext(), this.a.w, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.b().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = new eo6();
        this.y = new a(this);
        this.t = tbPageContext;
    }

    public final s68 G0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            s68 s68Var = new s68();
            if (100 == a0().tabType) {
                s68Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                s68Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.x.e == 501) {
                s68Var.a = "frs_tab";
            }
            s68Var.d = this.x.c;
            s68Var.c = threadData.getTid();
            s68Var.f = threadData.mRecomSource;
            s68Var.g = threadData.mRecomReason;
            s68Var.h = threadData.mRecomWeight;
            s68Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                s68Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return s68Var;
        }
        return (s68) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: H0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.t.getPageActivity(), false);
            ww wwVar = new ww(this.t.getPageActivity(), true);
            wwVar.u("frs");
            wwVar.y("2003");
            wwVar.v(new b(this, wwVar));
            if (this.w == 502) {
                wwVar.w(false);
            } else {
                wwVar.w(true);
            }
            bVar.n(wwVar);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.j(this.e);
            k.p(this.y);
            k.r(this.w);
            V(new c(this));
            autoVideoCardViewHolder.o(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: I0 */
    public View S(int i, View view2, ViewGroup viewGroup, rq4 rq4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rq4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (rq4Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder.b() instanceof bk5) {
                autoVideoCardViewHolder.b().b(this.u);
            }
            super.S(i, view2, viewGroup, rq4Var, autoVideoCardViewHolder);
            bd6.i(autoVideoCardViewHolder.b().f(), this.j);
            autoVideoCardViewHolder.v(G0(rq4Var.s));
            autoVideoCardViewHolder.b().q(i);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.f(rq4Var.s);
            autoVideoCardViewHolder.b().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.y);
            if (this.x != null) {
                FrsViewData frsViewData2 = this.j;
                rq4Var.s.statFloor = (rq4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            fo6.k().c(this.x, rq4Var.s);
            fo6.k().b(rq4Var.s);
            fo6.k().e(rq4Var.s, b0());
            do6.o(rq4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                do6.m(rq4Var.s, a0());
                do6.n(rq4Var.s, this.j.getForum().getId());
            }
            if (100 == a0().tabType) {
                fo6.k().f(rq4Var.s);
            }
            rq4Var.s.updateShowStatus();
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void J0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.iy5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.v = str;
        }
    }
}
