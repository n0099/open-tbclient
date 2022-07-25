package com.repackage;

import android.content.Context;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
/* loaded from: classes6.dex */
public class fy6 extends an<wy5, AutoVideoCardViewHolder<wy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public bz6 k;
    public String l;
    public tn m;
    public ky n;
    public jy5<wy5> o;

    /* loaded from: classes6.dex */
    public class a extends jy5<wy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy6 b;

        public a(fy6 fy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, wy5 wy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wy5Var) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (this.b.k == null || wy5Var == null || wy5Var.getThreadData() == null || StringUtils.isNull(wy5Var.getThreadData().getTid())) {
                    return;
                }
                if (wy5Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(wy5Var.N(wy5Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !ex6.b(ng.g(wy5Var.getThreadData().getTid(), 0L))) {
                    ex6.a(ng.g(wy5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(ng.g(wy5Var.getThreadData().getTid(), 0L), wy5Var.D(), wy5Var.o(), wy5Var.m(), wy5Var.c(), ng.e((String) view2.getTag(), 1), "homepage", wy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, wy5Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ fy6 b;

        public b(fy6 fy6Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy6Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fy6Var;
            this.a = kyVar;
        }

        @Override // com.repackage.qw.a
        public void a(on4 on4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, on4Var) == null) || on4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(on4Var instanceof wy5)) {
                ThreadCardUtils.jumpToPB(on4Var, this.b.a, 2, false, computeViewArea);
                return;
            }
            on4Var.objType = 5;
            ThreadCardUtils.jumpToPB(on4Var, this.b.a, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy6 a;

        public c(fy6 fy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fy6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof wy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                wy5 wy5Var = (wy5) nnVar;
                wy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(autoVideoCardViewHolder.a(), wy5Var);
                }
                ThreadCardUtils.jumpToPB((on4) wy5Var, view2.getContext(), 2, false, uw.a((tn) viewGroup, view2, i));
                autoVideoCardViewHolder.b().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fy6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.o = new a(this);
        this.j = tbPageContext;
        g0();
    }

    public final s68 e0(wy5 wy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wy5Var)) == null) {
            if (wy5Var != null) {
                s68 s68Var = new s68();
                s68Var.a = "1";
                s68Var.c = wy5Var.g;
                if (wy5Var.getThreadData() != null) {
                    s68Var.d = String.valueOf(wy5Var.getThreadData().getFid());
                    s68Var.v = wy5Var.getThreadData().getNid();
                    if (wy5Var.getThreadData().getThreadVideoInfo() != null) {
                        s68Var.m = wy5Var.getThreadData().getThreadVideoInfo().video_md5;
                        s68Var.p = String.valueOf(wy5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                s68Var.k = wy5Var.g();
                s68Var.f = wy5Var.o();
                s68Var.l = wy5Var.c();
                s68Var.h = wy5Var.D();
                s68Var.e = TbadkCoreApplication.getCurrentAccount();
                s68Var.q = String.valueOf(wy5Var.m());
                if (wy5Var.getThreadData() == null || wy5Var.getThreadData().getBaijiahaoData() == null) {
                    return s68Var;
                }
                s68Var.t = wy5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                s68Var.u = wy5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return s68Var;
            }
            return null;
        }
        return (s68) invokeL.objValue;
    }

    public final void f0(View view2, wy5 wy5Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, wy5Var) == null) || (kyVar = this.n) == null || kyVar.p() == null || this.n.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.p().getMainView().getId()) {
            iz6.d(wy5Var.a, this.i, wy5Var.m(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(wy5Var.P()));
            iz6.c(wy5Var.a, wy5Var.o(), wy5Var.m(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202e) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(wy5Var.N(wy5Var.a)));
            iz6.c(wy5Var.a, wy5Var.o(), wy5Var.m(), 1);
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            wy5.V = "c10708";
            wy5.W = "c10735";
            wy5.X = "c10709";
            wy5.Y = "c10734";
            wy5.Z = "c11929";
            wy5.a0 = "c11928";
            wy5.b0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<wy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            nz6 nz6Var = new nz6(this.j.getPageActivity());
            nz6Var.v(new b(this, nz6Var));
            this.n = nz6Var;
            nz6Var.x(this.i);
            this.n.u("index");
            this.n.y("2001");
            bVar.n(this.n);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.i);
            k.p(this.o);
            k.r(2);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: i0 */
    public View S(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            if (wy5Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            wy5Var.I(wy5Var.position + 1);
            wy5Var.a.statFloor = wy5Var.m();
            autoVideoCardViewHolder.b().q(i);
            wy5Var.T = 0;
            cy5.b().a(wy5Var.B());
            autoVideoCardViewHolder.v(e0(wy5Var));
            if (autoVideoCardViewHolder.b() != null) {
                autoVideoCardViewHolder.b().b(this.l);
            }
            autoVideoCardViewHolder.f(wy5Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.o);
            iz6.i(wy5Var.a, this.i, wy5Var.m());
            iz6.h(wy5Var.a, wy5Var.o(), wy5Var.m());
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bz6Var) == null) {
            this.k = bz6Var;
        }
    }

    public void k0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tnVar) == null) {
            this.m = tnVar;
        }
    }

    public void onPause() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (kyVar = this.n) == null) {
            return;
        }
        kyVar.s();
    }

    public void onResume() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (kyVar = this.n) == null) {
            return;
        }
        kyVar.t();
    }
}
