package d.a.q0.u0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.d;
import d.a.k.l0;
import d.a.k.v0.a;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class y extends d.a.q0.u0.k<a2, ThreadCardViewHolder<b2>> implements d.a.q0.a0.z, d.a.q0.u0.j2.d, d.a.q0.o.f, d.a.q0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.a0.b0<b2> A;
    public String x;
    public String y;
    public int z;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f63800b;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63800b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (this.f63800b.u != null) {
                this.f63800b.u.b(view, b2Var, this.f63800b.H());
            }
            if ("c13010".equals(this.f63800b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", b2Var.R()).param("tid", b2Var.o1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof TbImageView) {
                    if (this.f63800b.A.f54324a instanceof Boolean) {
                        if (((Boolean) this.f63800b.A.f54324a).booleanValue()) {
                            d.a.q0.u0.j2.a.e(b2Var, 1, this.f63800b.f42345i, d.a.q0.u0.j2.d.h0, this.f63800b.f0());
                        } else {
                            d.a.q0.u0.j2.a.e(b2Var, 3, this.f63800b.f42345i, d.a.q0.u0.j2.d.h0, this.f63800b.f0());
                        }
                    }
                    d.a.q0.u0.n2.l.g(b2Var, this.f63800b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.q0.u0.j2.a.e(b2Var, 15, this.f63800b.f42345i, d.a.q0.u0.j2.d.h0, this.f63800b.f0());
                    if (this.f63800b.n != null && this.f63800b.n.getForum() != null) {
                        d.a.q0.u0.j2.a.c(b2Var, this.f63800b.n.getForum().getId());
                    }
                } else {
                    d.a.q0.u0.j2.a.e(b2Var, 1, this.f63800b.f42345i, d.a.q0.u0.j2.d.h0, this.f63800b.f0());
                    if (this.f63800b.n != null && this.f63800b.n.getForum() != null) {
                        d.a.q0.u0.j2.a.c(b2Var, this.f63800b.n.getForum().getId());
                    }
                }
            } else {
                d.a.q0.u0.j2.a.e(b2Var, 2, this.f63800b.f42345i, d.a.q0.u0.j2.d.h0, this.f63800b.f0());
            }
            if (view.getId() == R.id.thread_card_root && b2Var.s2()) {
                this.f63800b.P0(b2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.q0.u0.n2.l.a(d.a.q0.u0.j2.d.h0, b2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f63800b.A.f54324a instanceof Boolean) {
                        if (((Boolean) this.f63800b.A.f54324a).booleanValue()) {
                            d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, 1);
                        } else {
                            d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (b2Var.q1() != null && b2Var.q1().K() != null && b2Var.q1().K().y() != null && b2Var.q1().K().y().size() > 0) {
                        i2 = b2Var.q1().N ? 9 : 8;
                    }
                    d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, i2);
                } else {
                    d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, 1);
                }
            } else {
                d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.k.d.b
        public void a(d.a.p0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f63801e;

        public c(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63801e = yVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f63801e.A != null) {
                    this.f63801e.A.a(threadCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), this.f63801e.z, false, d.a.k.e.a((d.a.d.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = 3;
        this.A = new a(this);
        this.o = tbPageContext;
        this.f42345i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: N0 */
    public ThreadCardViewHolder<b2> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), true);
            d.a.k.d dVar = new d.a.k.d(this.o.getPageActivity());
            dVar.b(4280);
            dVar.t(this.f42345i);
            dVar.s(new b(this));
            if (this.w) {
                bVar.l().d(0);
                bVar.l().g(0);
            }
            bVar.o(dVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<b2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.f42345i);
            threadCardViewHolder.n(false);
            a0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    /* renamed from: O0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<b2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, threadCardViewHolder})) == null) {
            super.X(i2, view, viewGroup, a2Var, threadCardViewHolder);
            if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            threadCardViewHolder.b().setPage(this.y);
            threadCardViewHolder.b().q(i2);
            d.a.q0.u0.j.g(threadCardViewHolder.b().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                a2Var.w.d4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.l(a2Var.w.showFollowBtn(), null);
            threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, null);
            if (!a2Var.w.J1() && !a2Var.w.w2() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.x)) {
                threadCardViewHolder.r();
            } else {
                threadCardViewHolder.g();
            }
            threadCardViewHolder.f(a2Var.w);
            threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.A);
            a2Var.w.t4();
            if (d.a.q0.u0.j2.d.h0 != null) {
                FrsViewData frsViewData2 = this.n;
                a2Var.w.P1 = (a2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            d.a.q0.u0.j2.c.j().c(d.a.q0.u0.j2.d.h0, a2Var.w);
            a2Var.w.t4();
            d.a.q0.u0.j2.a.m(a2Var.w, this.f42345i, d.a.q0.u0.j2.d.h0, f0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                d.a.q0.u0.j2.a.l(a2Var.w, this.n.getForum().getId());
            }
            if (a2Var != null) {
                a2Var.w.t4();
            }
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void P0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", b2Var.d0()).param("obj_locate", g0() ? 2 : 1).param("obj_id", b2Var.h1() == null ? -1L : b2Var.h1().live_id).param("obj_type", 1));
        }
    }

    @Override // d.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.q0.u0.j2.d
    public d.a.q0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.q0.u0.j2.d.h0 : (d.a.q0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.q0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // d.a.q0.u0.k, d.a.q0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }
}
