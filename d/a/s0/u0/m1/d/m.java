package d.a.s0.u0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
/* loaded from: classes9.dex */
public class m extends d.a.s0.u0.k<a2, ThreadCardViewHolder<b2>> implements d.a.s0.a0.z, d.a.s0.u0.j2.d, d.a.s0.o.f, d.a.s0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.s0.a0.b0<b2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a extends d.a.s0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f66345b;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66345b = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (this.f66345b.u != null) {
                this.f66345b.u.b(view, b2Var, this.f66345b.H());
            }
            if ("c13010".equals(this.f66345b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", b2Var.Q()).param("tid", b2Var.n1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.s0.u0.j2.a.c(b2Var, 5, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.s0.u0.j2.a.c(b2Var, 14, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.s0.u0.j2.a.c(b2Var, 12, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.s0.u0.j2.a.c(b2Var, 13, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                } else if (view instanceof TbImageView) {
                    if (this.f66345b.B.f57036a instanceof Boolean) {
                        if (((Boolean) this.f66345b.B.f57036a).booleanValue()) {
                            d.a.s0.u0.j2.a.c(b2Var, 1, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                        } else {
                            d.a.s0.u0.j2.a.c(b2Var, 3, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.s0.u0.j2.a.c(b2Var, 15, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                } else {
                    d.a.s0.u0.j2.a.c(b2Var, 1, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
                }
            } else {
                d.a.s0.u0.j2.a.c(b2Var, 2, this.f66345b.f44825i, d.a.s0.u0.j2.d.h0, this.f66345b.g0());
            }
            if (view.getId() == R.id.thread_card_root && b2Var.q2()) {
                this.f66345b.M0(b2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    d.a.s0.u0.n2.l.a(d.a.s0.u0.j2.d.h0, b2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f66345b.B.f57036a instanceof Boolean) {
                        if (((Boolean) this.f66345b.B.f57036a).booleanValue()) {
                            d.a.s0.u0.j2.c.j().g(d.a.s0.u0.j2.d.h0, b2Var, 1);
                        } else {
                            d.a.s0.u0.j2.c.j().g(d.a.s0.u0.j2.d.h0, b2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    d.a.s0.u0.j2.c.j().g(d.a.s0.u0.j2.d.h0, b2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (b2Var.p1() != null && b2Var.p1().K() != null && b2Var.p1().K().y() != null && b2Var.p1().K().y().size() > 0) {
                        i2 = b2Var.p1().N ? 9 : 8;
                    }
                    d.a.s0.u0.j2.c.j().g(d.a.s0.u0.j2.d.h0, b2Var, i2);
                } else {
                    d.a.s0.u0.j2.c.j().g(d.a.s0.u0.j2.d.h0, b2Var, 1);
                }
            } else {
                d.a.s0.u0.j2.c.j().g(d.a.s0.u0.j2.d.h0, b2Var, 2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j.n f66346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f66347f;

        public b(m mVar, d.a.j.n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66347f = mVar;
            this.f66346e = nVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                if ((d.a.s0.u0.b.e().g() || d.a.s0.u0.a.h().j()) && !this.f66346e.u()) {
                    b2 b2Var = ((a2) nVar).w;
                    if (b2Var == null) {
                        return;
                    }
                    if (!b2Var.Z1() && d.a.s0.u0.b.e().g()) {
                        if (d.a.s0.u0.b.e().a(b2Var)) {
                            b2Var.K3(true);
                        }
                    } else if (!b2Var.a2() && d.a.s0.u0.a.h().j()) {
                        if (d.a.s0.u0.a.h().a(b2Var)) {
                            b2Var.L3(true);
                        }
                    } else {
                        d.a.s0.u0.b.e().j(b2Var);
                        b2Var.K3(false);
                        d.a.s0.u0.a.h().l(b2Var);
                        b2Var.L3(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, b2Var));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var2 = ((a2) nVar).w;
                b2Var2.objType = 1;
                if (this.f66347f.B != null) {
                    this.f66347f.B.a(threadCardViewHolder.a(), b2Var2);
                }
                ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) b2Var2, view.getContext(), this.f66347f.A, false);
                threadCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.f44825i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: K0 */
    public ThreadCardViewHolder<b2> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            d.a.j.n nVar = new d.a.j.n(this.o.getPageActivity());
            bVar.h(nVar);
            nVar.x(this.z);
            nVar.w("frs");
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<b2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.f44825i);
            a0(new b(this, nVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    /* renamed from: L0 */
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
            d.a.s0.u0.j.g(threadCardViewHolder.b().e(), this.n);
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

    public final void M0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", b2Var.c0()).param("obj_locate", h0() ? 2 : 1).param("obj_id", b2Var.g1() == null ? -1L : b2Var.g1().live_id).param("obj_type", 1));
        }
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // d.a.s0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.s0.u0.j2.d
    public d.a.s0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.s0.u0.j2.d.h0 : (d.a.s0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.s0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // d.a.s0.u0.k, d.a.s0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }

    @Override // d.a.s0.u0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.z = z;
        }
    }
}
