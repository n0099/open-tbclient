package com.repackage;

import android.content.Context;
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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
/* loaded from: classes7.dex */
public class rw6 extends jw6<qq4, AutoVideoCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ky m;
    public jy5<ThreadData> n;

    /* loaded from: classes7.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw6 b;

        public a(rw6 rw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                this.b.Z(view2, threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ rw6 b;

        public b(rw6 rw6Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw6Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rw6Var;
            this.a = kyVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(nn4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(nn4Var, this.b.a, 0, false, computeViewArea);
                return;
            }
            nn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(nn4Var, this.b.a, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw6 a;

        public c(rw6 rw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rw6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ThreadData threadData = ((qq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.n != null) {
                    this.a.n.a(autoVideoCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((nn4) threadData, view2.getContext(), 0, false, uw.a((tn) viewGroup, view2, i));
                autoVideoCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rw6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), ThreadData.TYPE_VIDEO);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
    }

    public final s68 h0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                s68 s68Var = new s68();
                s68Var.a = UVEventType.PAY_WALLET_BANNER_SHOW;
                s68Var.c = threadData.tid;
                s68Var.f = threadData.mRecomSource;
                s68Var.g = threadData.mRecomAbTag;
                s68Var.h = threadData.mRecomWeight;
                s68Var.i = "14";
                s68Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    s68Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    s68Var.d = String.valueOf(threadData.getThreadData().getFid());
                    s68Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        s68Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        s68Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                s68Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() == null || threadData.getThreadData().getBaijiahaoData() == null) {
                    return s68Var;
                }
                s68Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                s68Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                return s68Var;
            }
            return null;
        }
        return (s68) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: i0 */
    public AutoVideoCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            ww wwVar = new ww(this.j.getPageActivity());
            wwVar.v(new b(this, wwVar));
            this.m = wwVar;
            wwVar.x(this.e);
            this.m.u("14");
            this.m.y("2001");
            bVar.n(this.m);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.e);
            k.p(this.n);
            k.r(0);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jw6, com.repackage.an
    /* renamed from: j0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, autoVideoCardViewHolder})) == null) {
            if (qq4Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            qq4Var.s.statFloor = B(i) + 1;
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.w(h0(qq4Var.s));
            autoVideoCardViewHolder.g(qq4Var.s);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.n);
            d0(autoVideoCardViewHolder.b(), qq4Var.s, i, i);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
