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
public class dz6 extends ho<gy5, AutoVideoCardViewHolder<gy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public zz6 k;
    public String l;
    public zo m;
    public j00 n;
    public tx5<gy5> o;

    /* loaded from: classes5.dex */
    public class a extends tx5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dz6 b;

        public a(dz6 dz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var) == null) {
                mx5.b().d(true);
                oi5.c().h("page_recommend", "show_");
                if (this.b.k == null || gy5Var == null || gy5Var.getThreadData() == null || StringUtils.isNull(gy5Var.getThreadData().getTid())) {
                    return;
                }
                if (gy5Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(gy5Var.N(gy5Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !cy6.b(mg.g(gy5Var.getThreadData().getTid(), 0L))) {
                    cy6.a(mg.g(gy5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(mg.g(gy5Var.getThreadData().getTid(), 0L), gy5Var.D(), gy5Var.r(), gy5Var.q(), gy5Var.e(), mg.e((String) view2.getTag(), 1), "homepage", gy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, gy5Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j00 a;
        public final /* synthetic */ dz6 b;

        public b(dz6 dz6Var, j00 j00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz6Var, j00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dz6Var;
            this.a = j00Var;
        }

        @Override // com.repackage.qy.a
        public void a(pn4 pn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pn4Var) == null) || pn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(pn4Var instanceof gy5)) {
                ThreadCardUtils.jumpToPB(pn4Var, this.b.a, 2, false, computeViewArea);
                return;
            }
            pn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(pn4Var, this.b.a, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dz6 a;

        public c(dz6 dz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dz6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof gy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                gy5 gy5Var = (gy5) uoVar;
                gy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(autoVideoCardViewHolder.b(), gy5Var);
                }
                ThreadCardUtils.jumpToPB((pn4) gy5Var, view2.getContext(), 2, false, uy.a((zo) viewGroup, view2, i));
                autoVideoCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final m78 e0(gy5 gy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gy5Var)) == null) {
            if (gy5Var != null) {
                m78 m78Var = new m78();
                m78Var.a = "1";
                m78Var.c = gy5Var.g;
                if (gy5Var.getThreadData() != null) {
                    m78Var.d = String.valueOf(gy5Var.getThreadData().getFid());
                    m78Var.v = gy5Var.getThreadData().getNid();
                    if (gy5Var.getThreadData().getThreadVideoInfo() != null) {
                        m78Var.m = gy5Var.getThreadData().getThreadVideoInfo().video_md5;
                        m78Var.p = String.valueOf(gy5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                m78Var.k = gy5Var.i();
                m78Var.f = gy5Var.r();
                m78Var.l = gy5Var.e();
                m78Var.h = gy5Var.D();
                m78Var.e = TbadkCoreApplication.getCurrentAccount();
                m78Var.q = String.valueOf(gy5Var.q());
                if (gy5Var.getThreadData() == null || gy5Var.getThreadData().getBaijiahaoData() == null) {
                    return m78Var;
                }
                m78Var.t = gy5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                m78Var.u = gy5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return m78Var;
            }
            return null;
        }
        return (m78) invokeL.objValue;
    }

    public final void f0(View view2, gy5 gy5Var) {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, gy5Var) == null) || (j00Var = this.n) == null || j00Var.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.o().getMainView().getId()) {
            f07.d(gy5Var.a, this.i, gy5Var.q(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(gy5Var.P()));
            f07.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(gy5Var.N(gy5Var.a)));
            f07.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 1);
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
            gy5.V = "c10708";
            gy5.W = "c10735";
            gy5.X = "c10709";
            gy5.Y = "c10734";
            gy5.Z = "c11929";
            gy5.g0 = "c11928";
            gy5.h0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<gy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity(), false);
            k07 k07Var = new k07(this.j.getPageActivity());
            k07Var.u(new b(this, k07Var));
            this.n = k07Var;
            k07Var.w(this.i);
            this.n.t("index");
            this.n.x("2001");
            bVar.n(this.n);
            b00 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<gy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
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
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, AutoVideoCardViewHolder<gy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, autoVideoCardViewHolder})) == null) {
            if (gy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            gy5Var.a.statFloor = gy5Var.q();
            autoVideoCardViewHolder.c().q(i);
            gy5Var.T = 0;
            mx5.b().a(gy5Var.B());
            autoVideoCardViewHolder.x(e0(gy5Var));
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(gy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            f07.h(gy5Var.a, this.i, gy5Var.q());
            f07.g(gy5Var.a, gy5Var.r(), gy5Var.q());
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(zz6 zz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zz6Var) == null) {
            this.k = zz6Var;
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
