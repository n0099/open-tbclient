package d.a.q0.u0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.l0;
import d.a.k.n0;
import d.a.k.v0.a;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends d.a.q0.u0.k<b2, ThreadCardViewHolder<b2>> implements d.a.q0.a0.z, d.a.q0.u0.j2.d, d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView.b A;
    public int x;
    public String y;
    public d.a.q0.a0.b0<b2> z;

    /* renamed from: d.a.q0.u0.m1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1688a extends d.a.q0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f63722b;

        public C1688a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63722b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                d.a.q0.a0.t.b().d(true);
                d.a.q0.o.d.c().h("page_recommend", "show_");
                if (view == null || b2Var == null || StringUtils.isNull(b2Var.o1())) {
                    return;
                }
                if (view.getId() == R.id.thread_card_root) {
                    d.a.q0.u0.j2.c.j().g(d.a.q0.u0.j2.d.h0, b2Var, 13);
                }
                if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                    if (view instanceof ThreadGodReplyLayout) {
                        d.a.q0.u0.j2.a.e(b2Var, 15, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
                        if (this.f63722b.n == null || this.f63722b.n.getForum() == null) {
                            return;
                        }
                        d.a.q0.u0.j2.a.c(b2Var, this.f63722b.n.getForum().getId());
                        return;
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        d.a.q0.u0.j2.a.e(b2Var, 5, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
                        if (this.f63722b.n == null || this.f63722b.n.getForum() == null) {
                            return;
                        }
                        d.a.q0.u0.j2.a.c(b2Var, this.f63722b.n.getForum().getId());
                        return;
                    } else if (view.getId() == R.id.share_num_container) {
                        d.a.q0.u0.j2.a.e(b2Var, 14, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
                        return;
                    } else if (view.getId() == R.id.img_agree) {
                        d.a.q0.u0.j2.a.e(b2Var, 12, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
                        return;
                    } else if (view.getId() == R.id.img_disagree) {
                        d.a.q0.u0.j2.a.e(b2Var, 13, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
                        return;
                    } else {
                        d.a.q0.u0.j2.a.e(b2Var, 1, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
                        if (this.f63722b.n == null || this.f63722b.n.getForum() == null) {
                            return;
                        }
                        d.a.q0.u0.j2.a.c(b2Var, this.f63722b.n.getForum().getId());
                        return;
                    }
                }
                d.a.q0.u0.j2.a.e(b2Var, 2, this.f63722b.f42345i, d.a.q0.u0.j2.d.h0, this.f63722b.f0());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) || arrayList == null || w0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", w0Var.c()).param("tid", w0Var.e()).param("nid", w0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", w0Var.k).param("weight", w0Var.j).param("ab_tag", w0Var.o).param("extra", w0Var.l).param("card_type", w0Var.n).param(TiebaStatic.Params.OBJ_FLOOR, w0Var.p));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", w0Var.c()).param("tid", w0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63723e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63723e = aVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f63723e.M0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = 3;
        this.z = new C1688a(this);
        this.A = new b(this);
        this.o = tbPageContext;
    }

    public final void M0(View view, d.a.d.k.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view, nVar) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            b2 b2Var = (b2) nVar;
            b2Var.objType = 1;
            ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), 3, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0620a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: N0 */
    public ThreadCardViewHolder<b2> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            d.a.k.d dVar = new d.a.k.d(this.o.getPageActivity());
            dVar.t(this.f42345i);
            dVar.v(this.o);
            bVar.o(dVar);
            bVar.n(new d.a.k.b(this.o.getPageActivity()));
            n0 n0Var = new n0(this.o.getPageActivity());
            d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
            fVar.f53311b = 2;
            fVar.f53317h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !d.a.d.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.j = this.n.getForum().getId();
            }
            n0Var.v(fVar);
            n0Var.w(2);
            n0Var.A(1);
            n0Var.x(3);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<b2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.f42345i);
            a0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    /* renamed from: O0 */
    public View X(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder<b2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            super.X(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            d.a.q0.u0.j2.c.j().c(d.a.q0.u0.j2.d.h0, b2Var);
            threadCardViewHolder.b().setPage(this.y);
            threadCardViewHolder.b().q(i2);
            if (this.x == 1) {
                threadCardViewHolder.o(true).u(this.A);
            }
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.f(b2Var);
            threadCardViewHolder.b().p(this.z);
            threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
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

    @Override // d.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.x = i2;
        }
    }

    @Override // d.a.q0.u0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }
}
