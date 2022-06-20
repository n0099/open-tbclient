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
import com.repackage.by;
import com.repackage.my;
import com.repackage.qw;
/* loaded from: classes6.dex */
public class px6 extends an<zx5, AutoVideoCardViewHolder<zx5>> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public ly6 k;
    public String l;
    public tn m;
    public jy n;
    public mx5<zx5> o;

    /* loaded from: classes6.dex */
    public class a extends mx5<zx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px6 b;

        public a(px6 px6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = px6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zx5Var) == null) {
                fx5.b().d(true);
                xi5.c().h("page_recommend", "show_");
                if (this.b.k == null || zx5Var == null || zx5Var.getThreadData() == null || StringUtils.isNull(zx5Var.getThreadData().getTid())) {
                    return;
                }
                if (zx5Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zx5Var.N(zx5Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !ow6.b(ng.g(zx5Var.getThreadData().getTid(), 0L))) {
                    ow6.a(ng.g(zx5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(ng.g(zx5Var.getThreadData().getTid(), 0L), zx5Var.D(), zx5Var.r(), zx5Var.n(), zx5Var.c(), ng.e((String) view2.getTag(), 1), "homepage", zx5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, zx5Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ px6 b;

        public b(px6 px6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = px6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.qw.a
        public void a(ym4 ym4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ym4Var) == null) || ym4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(ym4Var instanceof zx5)) {
                ThreadCardUtils.jumpToPB(ym4Var, this.b.a, 2, false, computeViewArea);
                return;
            }
            ym4Var.objType = 5;
            ThreadCardUtils.jumpToPB(ym4Var, this.b.a, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px6 a;

        public c(px6 px6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = px6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof zx5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                zx5 zx5Var = (zx5) nnVar;
                zx5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(autoVideoCardViewHolder.b(), zx5Var);
                }
                ThreadCardUtils.jumpToPB((ym4) zx5Var, view2.getContext(), 2, false, uw.a((tn) viewGroup, view2, i));
                autoVideoCardViewHolder.c().o(new my.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final x58 e0(zx5 zx5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zx5Var)) == null) {
            if (zx5Var != null) {
                x58 x58Var = new x58();
                x58Var.a = "1";
                x58Var.c = zx5Var.g;
                if (zx5Var.getThreadData() != null) {
                    x58Var.d = String.valueOf(zx5Var.getThreadData().getFid());
                    x58Var.v = zx5Var.getThreadData().getNid();
                    if (zx5Var.getThreadData().getThreadVideoInfo() != null) {
                        x58Var.m = zx5Var.getThreadData().getThreadVideoInfo().video_md5;
                        x58Var.p = String.valueOf(zx5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                x58Var.k = zx5Var.h();
                x58Var.f = zx5Var.r();
                x58Var.l = zx5Var.c();
                x58Var.h = zx5Var.D();
                x58Var.e = TbadkCoreApplication.getCurrentAccount();
                x58Var.q = String.valueOf(zx5Var.n());
                if (zx5Var.getThreadData() == null || zx5Var.getThreadData().getBaijiahaoData() == null) {
                    return x58Var;
                }
                x58Var.t = zx5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                x58Var.u = zx5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return x58Var;
            }
            return null;
        }
        return (x58) invokeL.objValue;
    }

    public final void f0(View view2, zx5 zx5Var) {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, zx5Var) == null) || (jyVar = this.n) == null || jyVar.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.o().getMainView().getId()) {
            sy6.d(zx5Var.a, this.i, zx5Var.n(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zx5Var.P()));
            sy6.c(zx5Var.a, zx5Var.r(), zx5Var.n(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zx5Var.N(zx5Var.a)));
            sy6.c(zx5Var.a, zx5Var.r(), zx5Var.n(), 1);
        }
    }

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            zx5.V = "c10708";
            zx5.W = "c10735";
            zx5.X = "c10709";
            zx5.Y = "c10734";
            zx5.Z = "c11929";
            zx5.g0 = "c11928";
            zx5.h0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<zx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            by.b bVar = new by.b(this.j.getPageActivity(), false);
            xy6 xy6Var = new xy6(this.j.getPageActivity());
            xy6Var.u(new b(this, xy6Var));
            this.n = xy6Var;
            xy6Var.w(this.i);
            this.n.t("index");
            this.n.x("2001");
            bVar.n(this.n);
            by k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
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
    public View S(int i, View view2, ViewGroup viewGroup, zx5 zx5Var, AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zx5Var, autoVideoCardViewHolder})) == null) {
            if (zx5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            zx5Var.I(zx5Var.position + 1);
            zx5Var.a.statFloor = zx5Var.n();
            autoVideoCardViewHolder.c().q(i);
            zx5Var.T = 0;
            fx5.b().a(zx5Var.B());
            autoVideoCardViewHolder.w(e0(zx5Var));
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(zx5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            sy6.h(zx5Var.a, this.i, zx5Var.n());
            sy6.g(zx5Var.a, zx5Var.r(), zx5Var.n());
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(ly6 ly6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ly6Var) == null) {
            this.k = ly6Var;
        }
    }

    public void k0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tnVar) == null) {
            this.m = tnVar;
        }
    }

    public void onPause() {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jyVar = this.n) == null) {
            return;
        }
        jyVar.r();
    }

    public void onResume() {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (jyVar = this.n) == null) {
            return;
        }
        jyVar.s();
    }
}
