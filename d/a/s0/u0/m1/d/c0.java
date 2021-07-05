package d.a.s0.u0.m1.d;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.l0;
import d.a.j.n0;
import d.a.j.v0.a;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.z1;
import d.a.s0.u0.t0;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class c0 extends d.a.s0.u0.k<b2, AutoVideoCardViewHolder<b2>> implements d.a.s0.a0.z, d.a.s0.u0.j2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public d.a.s0.a0.b0<b2> B;
    public Set<String> x;
    public int y;
    public d.a.s0.u0.j2.b z;

    /* loaded from: classes9.dex */
    public class a extends d.a.s0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f66310b;

        public a(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66310b = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.s0.u0.j2.a.c(b2Var, 5, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                } else if (view.getId() == R.id.img_interview_live) {
                    d.a.s0.u0.j2.a.c(b2Var, 3, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.s0.u0.j2.a.c(b2Var, 15, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.s0.u0.j2.a.c(b2Var, 14, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.s0.u0.j2.a.c(b2Var, 12, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.s0.u0.j2.a.c(b2Var, 13, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                } else {
                    d.a.s0.u0.j2.a.c(b2Var, 1, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
                }
            } else {
                d.a.s0.u0.j2.a.c(b2Var, 2, this.f66310b.f44825i, this.f66310b.z, this.f66310b.g0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.s0.u0.j2.c.j().g(this.f66310b.z, b2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (b2Var.f1() == 2 && b2Var.e1() != null) {
                    String d2 = b2Var.e1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = b2Var.e1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(b2Var.Q());
                    String W = b2Var.W();
                    String g2 = b2Var.e1().g();
                    d.a.s0.h3.j0.a.c("frs", "CLICK", valueOf, W, g2, "tieba.baidu.com/p/" + b2Var.e1().g(), str);
                    String f2 = b2Var.e1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", b2Var.Q());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                d.a.s0.u0.j2.c.j().g(this.f66310b.z, b2Var, 1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f66311e;

        public b(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66311e = c0Var;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = (b2) nVar;
                b2Var.objType = 1;
                if (this.f66311e.B != null) {
                    this.f66311e.B.a(threadCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) b2Var, view.getContext(), this.f66311e.y, false);
                threadCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = 3;
        this.z = new d.a.s0.u0.j2.b();
        this.A = false;
        this.B = new a(this);
        this.x = new HashSet();
    }

    public final d.a.s0.n2.o G0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            d.a.s0.n2.o oVar = new d.a.s0.n2.o();
            oVar.f64043a = b2Var.N1() ? "3" : "2";
            oVar.f64046d = this.z.f66177c;
            oVar.f64045c = b2Var.n1();
            oVar.f64048f = b2Var.T0;
            oVar.f64049g = b2Var.X0;
            oVar.f64050h = b2Var.U0;
            oVar.l = b2Var.V0;
            if (b2Var.l1() != null) {
                oVar.m = b2Var.l1().video_md5;
            }
            return oVar;
        }
        return (d.a.s0.n2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: H0 */
    public AutoVideoCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            d.a.j.d dVar = new d.a.j.d(this.o.getPageActivity());
            dVar.b(696);
            dVar.t(this.f44825i);
            bVar.o(dVar);
            d.a.j.r rVar = new d.a.j.r(this.o.getPageActivity());
            rVar.B(this.A);
            bVar.n(rVar);
            d.a.j.n nVar = new d.a.j.n(this.o.getPageActivity());
            nVar.x(this.A);
            nVar.w("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
            fVar.f55932b = 2;
            fVar.f55938h = 2;
            n0Var.v(fVar);
            n0Var.w(2);
            n0Var.A(1);
            n0Var.x(this.y);
            n0Var.b(16);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
            autoVideoCardViewHolder.k(this.f44825i);
            i2.p(this.B);
            i2.r(this.y);
            a0(new b(this));
            autoVideoCardViewHolder.n();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    /* renamed from: I0 */
    public View X(int i2, View view, ViewGroup viewGroup, b2 b2Var, AutoVideoCardViewHolder<b2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.z != null) {
                FrsViewData frsViewData = this.n;
                b2Var.P1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            d.a.s0.u0.j2.c.j().c(this.z, b2Var);
            d.a.s0.u0.j2.a.j(b2Var, this.f44825i, this.z, g0());
            z1 e1 = b2Var.e1();
            if (e1 != null) {
                String f2 = e1.f();
                String d2 = e1.d();
                if (StringUtils.isNull(d2)) {
                    d2 = e1.f();
                }
                String str = d2;
                if (this.o.getOrignalPage() instanceof t0) {
                    t0 t0Var = (t0) this.o.getOrignalPage();
                    if (this.x.add(f2)) {
                        String i3 = t0Var.i();
                        String h2 = t0Var.h();
                        String g2 = e1.g();
                        d.a.s0.h3.j0.a.c("frs", "VIEW_TRUE", i3, h2, g2, "tieba.baidu.com/p/" + b2Var.n1(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", b2Var.Q());
                statisticItem.param("tid", b2Var.n1());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", b2Var.j1());
                TiebaStatic.log(statisticItem);
            }
            if (b2Var != null) {
                b2Var.q4();
                if ((b2Var.l1() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.v(G0(b2Var));
                }
                autoVideoCardViewHolder.b().e().b(32);
                autoVideoCardViewHolder.f(b2Var);
                autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.b().p(this.B);
                d.a.s0.u0.j.g(autoVideoCardViewHolder.b().e(), this.n);
            }
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // d.a.s0.u0.k
    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.i0();
            this.x.clear();
        }
    }

    @Override // d.a.s0.u0.j2.d
    public d.a.s0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (d.a.s0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.y = i2;
        }
    }

    @Override // d.a.s0.u0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.A = z;
        }
    }
}
