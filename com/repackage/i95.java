package com.repackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.mw;
import com.repackage.xx;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
/* loaded from: classes6.dex */
public class i95 extends d95<rp4, AutoVideoCardViewHolder<rp4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fy o;
    public nw5<rp4> p;

    /* loaded from: classes6.dex */
    public class a extends nw5<rp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i95 b;

        public a(i95 i95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i95Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, rp4 rp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rp4Var) == null) {
                this.b.b0(view2, rp4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;
        public final /* synthetic */ i95 b;

        public b(i95 i95Var, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i95Var, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i95Var;
            this.a = fyVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(om4Var instanceof rp4)) {
                ThreadCardUtils.jumpToPB(om4Var, this.b.a, this.b.h0(), false, computeViewArea);
                return;
            }
            om4Var.objType = 5;
            ThreadCardUtils.jumpToPB(om4Var, this.b.a, this.b.h0(), false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i95 a;

        public c(i95 i95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i95Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                rp4 rp4Var = (rp4) jnVar;
                rp4Var.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(autoVideoCardViewHolder.b(), rp4Var);
                }
                ThreadCardUtils.jumpToPB((om4) rp4Var, view2.getContext(), this.a.h0(), false, qw.a((pn) viewGroup, view2, i));
                autoVideoCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i95(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_VIDEO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.p = new a(this);
    }

    public final t48 v0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                t48 t48Var = new t48();
                t48Var.a = UVEventType.PAY_WALLET_BANNER_SHOW;
                t48Var.c = threadData.tid;
                t48Var.f = threadData.mRecomSource;
                t48Var.g = threadData.mRecomAbTag;
                t48Var.h = threadData.mRecomWeight;
                t48Var.i = "14";
                t48Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    t48Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    t48Var.d = String.valueOf(threadData.getThreadData().getFid());
                    t48Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        t48Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        t48Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                t48Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() == null || threadData.getThreadData().getBaijiahaoData() == null) {
                    return t48Var;
                }
                t48Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                t48Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                return t48Var;
            }
            return null;
        }
        return (t48) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: w0 */
    public AutoVideoCardViewHolder<rp4> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity(), false);
            sw swVar = new sw(this.k.getPageActivity());
            swVar.u(new b(this, swVar));
            this.o = swVar;
            swVar.w(this.e);
            this.o.t(j0());
            this.o.x(k0());
            bVar.n(this.o);
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            AutoVideoCardViewHolder<rp4> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.e);
            k.p(this.p);
            k.r(h0());
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: x0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, AutoVideoCardViewHolder<rp4> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, autoVideoCardViewHolder})) == null) {
            if (rp4Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            rp4Var.s.statFloor = C(i) + 1;
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.x(v0(rp4Var.s));
            autoVideoCardViewHolder.g(rp4Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.p);
            r0(autoVideoCardViewHolder.b(), rp4Var.s, i, i);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
