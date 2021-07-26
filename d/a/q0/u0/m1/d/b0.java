package d.a.q0.u0.m1.d;

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
import d.a.k.l0;
import d.a.k.n0;
import d.a.k.v0.a;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.z1;
import d.a.q0.u0.t0;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class b0 extends d.a.q0.u0.k<a2, AutoVideoCardViewHolder<b2>> implements d.a.q0.a0.z, d.a.q0.u0.j2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public d.a.q0.a0.b0<b2> B;
    public Set<String> x;
    public int y;
    public d.a.q0.u0.j2.b z;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b0 f63729b;

        public a(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63729b = b0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.q0.u0.j2.a.e(b2Var, 5, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                } else if (view.getId() == R.id.img_interview_live) {
                    d.a.q0.u0.j2.a.e(b2Var, 3, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.q0.u0.j2.a.e(b2Var, 15, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.q0.u0.j2.a.e(b2Var, 14, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.q0.u0.j2.a.e(b2Var, 12, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.q0.u0.j2.a.e(b2Var, 13, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                } else {
                    d.a.q0.u0.j2.a.e(b2Var, 1, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
                }
            } else {
                d.a.q0.u0.j2.a.e(b2Var, 2, this.f63729b.f42345i, this.f63729b.z, this.f63729b.f0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.q0.u0.j2.c.j().g(this.f63729b.z, b2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (b2Var.g1() == 2 && b2Var.f1() != null) {
                    String d2 = b2Var.f1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = b2Var.f1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(b2Var.R());
                    String X = b2Var.X();
                    String g2 = b2Var.f1().g();
                    d.a.q0.h3.j0.a.c("frs", "CLICK", valueOf, X, g2, "tieba.baidu.com/p/" + b2Var.f1().g(), str);
                    String f2 = b2Var.f1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", b2Var.R());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                d.a.q0.u0.j2.c.j().g(this.f63729b.z, b2Var, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b0 f63730e;

        public b(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63730e = b0Var;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f63730e.B != null) {
                    this.f63730e.B.a(threadCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), this.f63730e.y, false);
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.z = new d.a.q0.u0.j2.b();
        this.A = false;
        this.B = new a(this);
        this.x = new HashSet();
    }

    public final d.a.q0.n2.o G0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            d.a.q0.n2.o oVar = new d.a.q0.n2.o();
            oVar.f61423a = b2Var.O1() ? "3" : "2";
            oVar.f61426d = this.z.f63601c;
            oVar.f61425c = b2Var.o1();
            oVar.f61428f = b2Var.T0;
            oVar.f61429g = b2Var.X0;
            oVar.f61430h = b2Var.U0;
            oVar.l = b2Var.V0;
            if (b2Var.m1() != null) {
                oVar.m = b2Var.m1().video_md5;
            }
            return oVar;
        }
        return (d.a.q0.n2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: H0 */
    public AutoVideoCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            d.a.k.d dVar = new d.a.k.d(this.o.getPageActivity());
            dVar.b(696);
            dVar.t(this.f42345i);
            bVar.o(dVar);
            d.a.k.r rVar = new d.a.k.r(this.o.getPageActivity());
            rVar.B(this.A);
            bVar.n(rVar);
            d.a.k.n nVar = new d.a.k.n(this.o.getPageActivity());
            nVar.x(this.A);
            nVar.w("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
            fVar.f53311b = 2;
            fVar.f53317h = 2;
            n0Var.v(fVar);
            n0Var.w(2);
            n0Var.A(1);
            n0Var.x(this.y);
            n0Var.b(16);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
            autoVideoCardViewHolder.j(this.f42345i);
            i2.p(this.B);
            i2.r(this.y);
            a0(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    /* renamed from: I0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder<b2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.z != null) {
                FrsViewData frsViewData = this.n;
                a2Var.w.P1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            d.a.q0.u0.j2.c.j().c(this.z, a2Var.w);
            d.a.q0.u0.j2.a.m(a2Var.w, this.f42345i, this.z, f0());
            z1 f1 = a2Var.w.f1();
            if (f1 != null) {
                String f2 = f1.f();
                String d2 = f1.d();
                if (StringUtils.isNull(d2)) {
                    d2 = f1.f();
                }
                String str = d2;
                if (this.o.getOrignalPage() instanceof t0) {
                    t0 t0Var = (t0) this.o.getOrignalPage();
                    if (this.x.add(f2)) {
                        String h2 = t0Var.h();
                        String g2 = t0Var.g();
                        String g3 = f1.g();
                        d.a.q0.h3.j0.a.c("frs", "VIEW_TRUE", h2, g2, g3, "tieba.baidu.com/p/" + a2Var.w.o1(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", a2Var.w.R());
                statisticItem.param("tid", a2Var.w.o1());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", a2Var.w.k1());
                TiebaStatic.log(statisticItem);
            }
            if (a2Var != null) {
                a2Var.w.t4();
                if ((a2Var.w.m1() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.u(G0(a2Var.w));
                }
                autoVideoCardViewHolder.b().e().b(32);
                autoVideoCardViewHolder.f(a2Var.w);
                autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.b().p(this.B);
                d.a.q0.u0.j.g(autoVideoCardViewHolder.b().e(), this.n);
            }
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // d.a.q0.u0.k
    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.i0();
            this.x.clear();
        }
    }

    @Override // d.a.q0.u0.j2.d
    public d.a.q0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (d.a.q0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.y = i2;
        }
    }

    @Override // d.a.q0.u0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.A = z;
        }
    }
}
