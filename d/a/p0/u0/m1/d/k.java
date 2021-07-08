package d.a.p0.u0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.j.l0;
import d.a.j.v0.a;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
/* loaded from: classes8.dex */
public class k extends d.a.p0.u0.k<a2, ThreadCardViewHolder<b2>> implements d.a.p0.a0.z, d.a.p0.u0.j2.d, d.a.p0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.p0.a0.b0<b2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a extends d.a.p0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f63123b;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63123b = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (this.f63123b.u != null) {
                this.f63123b.u.b(view, b2Var, this.f63123b.H());
            }
            if ("c13010".equals(this.f63123b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", b2Var.Q()).param("tid", b2Var.n1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.p0.u0.j2.a.c(b2Var, 5, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.p0.u0.j2.a.c(b2Var, 14, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
                } else if (view instanceof TbImageView) {
                    if (this.f63123b.B.f53781a instanceof Boolean) {
                        if (((Boolean) this.f63123b.B.f53781a).booleanValue()) {
                            d.a.p0.u0.j2.a.c(b2Var, 1, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
                        } else {
                            d.a.p0.u0.j2.a.c(b2Var, 3, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.p0.u0.j2.a.c(b2Var, 15, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
                } else {
                    d.a.p0.u0.j2.a.c(b2Var, 1, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
                }
            } else {
                d.a.p0.u0.j2.a.c(b2Var, 2, this.f63123b.f41841i, d.a.p0.u0.j2.d.h0, this.f63123b.g0());
            }
            if (view.getId() == R.id.thread_card_root && b2Var.q2()) {
                this.f63123b.K0(b2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.p0.u0.n2.l.a(d.a.p0.u0.j2.d.h0, b2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f63123b.B.f53781a instanceof Boolean) {
                        if (((Boolean) this.f63123b.B.f53781a).booleanValue()) {
                            d.a.p0.u0.j2.c.j().g(d.a.p0.u0.j2.d.h0, b2Var, 1);
                        } else {
                            d.a.p0.u0.j2.c.j().g(d.a.p0.u0.j2.d.h0, b2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.a.p0.u0.j2.c.j().g(d.a.p0.u0.j2.d.h0, b2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (b2Var.p1() != null && b2Var.p1().K() != null && b2Var.p1().K().y() != null && b2Var.p1().K().y().size() > 0) {
                        i2 = b2Var.p1().N ? 9 : 8;
                    }
                    d.a.p0.u0.j2.c.j().g(d.a.p0.u0.j2.d.h0, b2Var, i2);
                } else {
                    d.a.p0.u0.j2.c.j().g(d.a.p0.u0.j2.d.h0, b2Var, 1);
                }
            } else {
                d.a.p0.u0.j2.c.j().g(d.a.p0.u0.j2.d.h0, b2Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f63124e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63124e = kVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f63124e.B != null) {
                    this.f63124e.B.a(threadCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) b2Var, view.getContext(), this.f63124e.A, false);
                threadCardViewHolder.b().o(new a.C0611a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.z = true;
        this.A = 3;
        this.B = new a(this);
        this.o = tbPageContext;
        this.f41841i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: I0 */
    public ThreadCardViewHolder<b2> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            d.a.j.z zVar = new d.a.j.z(this.o.getPageActivity());
            zVar.r("frs");
            zVar.s(this.z);
            if (this.A == 502) {
                zVar.t(false);
            } else {
                zVar.t(true);
            }
            bVar.n(zVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<b2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.f41841i);
            threadCardViewHolder.n(false);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.u0.k, d.a.c.k.e.a
    /* renamed from: J0 */
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
            d.a.p0.u0.j.g(threadCardViewHolder.b().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                a2Var.w.a4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.f(a2Var.w);
            threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.B);
            a2Var.w.q4();
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void K0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", b2Var.c0()).param("obj_locate", h0() ? 2 : 1).param("obj_id", b2Var.g1() == null ? -1L : b2Var.g1().live_id).param("obj_type", 1));
        }
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.p0.u0.j2.d
    public d.a.p0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.p0.u0.j2.d.h0 : (d.a.p0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // d.a.p0.u0.k, d.a.p0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.x = str;
        }
    }

    @Override // d.a.p0.u0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.z = z;
        }
    }
}
