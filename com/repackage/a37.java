package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
public class a37 extends ho<gy5, AutoVideoCardViewHolder<gy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public zo k;
    public j00 l;
    public zz6 m;
    public tx5<gy5> n;

    /* loaded from: classes5.dex */
    public class a extends tx5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a37 b;

        public a(a37 a37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var) == null) || view2 == null || gy5Var == null || gy5Var.getThreadData() == null) {
                return;
            }
            this.b.f0(view2, gy5Var);
            if (this.b.m == null || !(view2.getTag() instanceof String) || cy6.b(mg.g(gy5Var.getThreadData().getTid(), 0L))) {
                return;
            }
            cy6.a(mg.g(gy5Var.getThreadData().getTid(), 0L));
            this.b.m.e(mg.g(gy5Var.getThreadData().getTid(), 0L), gy5Var.D(), gy5Var.r(), gy5Var.q(), gy5Var.e(), mg.e("3", 1), "video_tab", gy5Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j00 a;
        public final /* synthetic */ a37 b;

        public b(a37 a37Var, j00 j00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a37Var, j00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a37Var;
            this.a = j00Var;
        }

        @Override // com.repackage.qy.a
        public void a(pn4 pn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pn4Var) == null) || pn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (pn4Var instanceof gy5) {
                pn4Var.objType = 5;
                i37.f((xx5) pn4Var);
                i37.c(pn4Var, this.b.a, 19, false, computeViewArea);
                return;
            }
            i37.f((xx5) pn4Var);
            i37.c(pn4Var, this.b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a37 a;

        public c(a37 a37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a37Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof gy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gy5 gy5Var = (gy5) uoVar;
                gy5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), gy5Var);
                }
                i37.c(gy5Var, view2.getContext(), 19, false, uy.a((zo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a37(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new a(this);
        this.i = tbPageContext;
    }

    public final m78 e0(gy5 gy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gy5Var)) == null) {
            if (gy5Var != null) {
                m78 m78Var = new m78();
                m78Var.a = "19";
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, gy5Var) == null) || (j00Var = this.l) == null || j00Var.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.o().getMainView().getId()) {
            i37.h(gy5Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
            i37.f(gy5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<gy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.i.getPageActivity(), false);
            wy wyVar = new wy(this.i.getPageActivity());
            wyVar.u(new b(this, wyVar));
            this.l = wyVar;
            wyVar.w(this.j);
            this.l.t("video_tab");
            this.l.x("2001");
            bVar.n(this.l);
            b00 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<gy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.j);
            k.p(this.n);
            k.r(19);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: h0 */
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, AutoVideoCardViewHolder<gy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, autoVideoCardViewHolder})) == null) {
            if (gy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.x(e0(gy5Var));
            i37.d(gy5Var);
            autoVideoCardViewHolder.g(gy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.n);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void j0(zz6 zz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zz6Var) == null) {
            this.m = zz6Var;
        }
    }

    public void k0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zoVar) == null) {
            this.k = zoVar;
        }
    }

    public void onPause() {
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (j00Var = this.l) == null) {
            return;
        }
        j00Var.r();
    }
}
