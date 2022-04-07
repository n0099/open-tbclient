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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.qy;
/* loaded from: classes5.dex */
public class bz6 extends ho<ey5, AutoVideoCardViewHolder<ey5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public xz6 k;
    public String l;
    public zo m;
    public j00 n;
    public rx5<ey5> o;

    /* loaded from: classes5.dex */
    public class a extends rx5<ey5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz6 b;

        public a(bz6 bz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rx5
        /* renamed from: d */
        public void a(View view2, ey5 ey5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ey5Var) == null) {
                kx5.b().d(true);
                oi5.c().h("page_recommend", "show_");
                if (this.b.k == null || ey5Var == null || ey5Var.getThreadData() == null || StringUtils.isNull(ey5Var.getThreadData().getTid())) {
                    return;
                }
                if (ey5Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ey5Var.N(ey5Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !ay6.b(mg.g(ey5Var.getThreadData().getTid(), 0L))) {
                    ay6.a(mg.g(ey5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(mg.g(ey5Var.getThreadData().getTid(), 0L), ey5Var.D(), ey5Var.r(), ey5Var.q(), ey5Var.e(), mg.e((String) view2.getTag(), 1), "homepage", ey5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, ey5Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j00 a;
        public final /* synthetic */ bz6 b;

        public b(bz6 bz6Var, j00 j00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz6Var, j00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bz6Var;
            this.a = j00Var;
        }

        @Override // com.repackage.qy.a
        public void a(qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(qn4Var instanceof ey5)) {
                ThreadCardUtils.jumpToPB(qn4Var, this.b.a, 2, false, computeViewArea);
                return;
            }
            qn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(qn4Var, this.b.a, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz6 a;

        public c(bz6 bz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof ey5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ey5 ey5Var = (ey5) uoVar;
                ey5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(autoVideoCardViewHolder.b(), ey5Var);
                }
                ThreadCardUtils.jumpToPB((qn4) ey5Var, view2.getContext(), 2, false, uy.a((zo) viewGroup, view2, i));
                autoVideoCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final f78 e0(ey5 ey5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ey5Var)) == null) {
            if (ey5Var != null) {
                f78 f78Var = new f78();
                f78Var.a = "1";
                f78Var.c = ey5Var.g;
                if (ey5Var.getThreadData() != null) {
                    f78Var.d = String.valueOf(ey5Var.getThreadData().getFid());
                    f78Var.v = ey5Var.getThreadData().getNid();
                    if (ey5Var.getThreadData().getThreadVideoInfo() != null) {
                        f78Var.m = ey5Var.getThreadData().getThreadVideoInfo().video_md5;
                        f78Var.p = String.valueOf(ey5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                f78Var.k = ey5Var.i();
                f78Var.f = ey5Var.r();
                f78Var.l = ey5Var.e();
                f78Var.h = ey5Var.D();
                f78Var.e = TbadkCoreApplication.getCurrentAccount();
                f78Var.q = String.valueOf(ey5Var.q());
                if (ey5Var.getThreadData() == null || ey5Var.getThreadData().getBaijiahaoData() == null) {
                    return f78Var;
                }
                f78Var.t = ey5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                f78Var.u = ey5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return f78Var;
            }
            return null;
        }
        return (f78) invokeL.objValue;
    }

    public final void f0(View view2, ey5 ey5Var) {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, ey5Var) == null) || (j00Var = this.n) == null || j00Var.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.o().getMainView().getId()) {
            d07.d(ey5Var.a, this.i, ey5Var.q(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ey5Var.P()));
            d07.c(ey5Var.a, ey5Var.r(), ey5Var.q(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f86) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ey5Var.N(ey5Var.a)));
            d07.c(ey5Var.a, ey5Var.r(), ey5Var.q(), 1);
        }
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ey5.V = "c10708";
            ey5.W = "c10735";
            ey5.X = "c10709";
            ey5.Y = "c10734";
            ey5.Z = "c11929";
            ey5.g0 = "c11928";
            ey5.h0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<ey5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity(), false);
            h07 h07Var = new h07(this.j.getPageActivity());
            h07Var.u(new b(this, h07Var));
            this.n = h07Var;
            h07Var.w(this.i);
            this.n.t("index");
            this.n.x("2001");
            bVar.n(this.n);
            b00 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<ey5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(2);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: i0 */
    public View S(int i, View view2, ViewGroup viewGroup, ey5 ey5Var, AutoVideoCardViewHolder<ey5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ey5Var, autoVideoCardViewHolder})) == null) {
            if (ey5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ey5Var.I(ey5Var.position + 1);
            ey5Var.a.statFloor = ey5Var.q();
            autoVideoCardViewHolder.c().q(i);
            ey5Var.T = 0;
            kx5.b().a(ey5Var.B());
            autoVideoCardViewHolder.x(e0(ey5Var));
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(ey5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            d07.h(ey5Var.a, this.i, ey5Var.q());
            d07.g(ey5Var.a, ey5Var.r(), ey5Var.q());
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(xz6 xz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xz6Var) == null) {
            this.k = xz6Var;
        }
    }

    public void k0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zoVar) == null) {
            this.m = zoVar;
        }
    }

    public void onPause() {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (j00Var = this.n) == null) {
            return;
        }
        j00Var.r();
    }

    public void onResume() {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (j00Var = this.n) == null) {
            return;
        }
        j00Var.s();
    }
}
