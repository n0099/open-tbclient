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
/* loaded from: classes7.dex */
public class x27 extends ho<ey5, AutoVideoCardViewHolder<ey5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public zo k;
    public j00 l;
    public xz6 m;
    public rx5<ey5> n;

    /* loaded from: classes7.dex */
    public class a extends rx5<ey5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x27 b;

        public a(x27 x27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rx5
        /* renamed from: d */
        public void a(View view2, ey5 ey5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ey5Var) == null) || view2 == null || ey5Var == null || ey5Var.getThreadData() == null) {
                return;
            }
            this.b.f0(view2, ey5Var);
            if (this.b.m == null || !(view2.getTag() instanceof String) || ay6.b(mg.g(ey5Var.getThreadData().getTid(), 0L))) {
                return;
            }
            ay6.a(mg.g(ey5Var.getThreadData().getTid(), 0L));
            this.b.m.e(mg.g(ey5Var.getThreadData().getTid(), 0L), ey5Var.D(), ey5Var.r(), ey5Var.q(), ey5Var.e(), mg.e("3", 1), "video_tab", ey5Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j00 a;
        public final /* synthetic */ x27 b;

        public b(x27 x27Var, j00 j00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x27Var, j00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x27Var;
            this.a = j00Var;
        }

        @Override // com.repackage.qy.a
        public void a(qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (qn4Var instanceof ey5) {
                qn4Var.objType = 5;
                f37.f((vx5) qn4Var);
                f37.c(qn4Var, this.b.a, 19, false, computeViewArea);
                return;
            }
            f37.f((vx5) qn4Var);
            f37.c(qn4Var, this.b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x27 a;

        public c(x27 x27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x27Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof ey5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ey5 ey5Var = (ey5) uoVar;
                ey5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), ey5Var);
                }
                f37.c(ey5Var, view2.getContext(), 19, false, uy.a((zo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x27(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final f78 e0(ey5 ey5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ey5Var)) == null) {
            if (ey5Var != null) {
                f78 f78Var = new f78();
                f78Var.a = "19";
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, ey5Var) == null) || (j00Var = this.l) == null || j00Var.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.o().getMainView().getId()) {
            f37.h(ey5Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f86) {
            f37.f(ey5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<ey5> M(ViewGroup viewGroup) {
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
            AutoVideoCardViewHolder<ey5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
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
    public View S(int i, View view2, ViewGroup viewGroup, ey5 ey5Var, AutoVideoCardViewHolder<ey5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ey5Var, autoVideoCardViewHolder})) == null) {
            if (ey5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ey5Var.I(ey5Var.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.x(e0(ey5Var));
            f37.d(ey5Var);
            autoVideoCardViewHolder.g(ey5Var);
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

    public void j0(xz6 xz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xz6Var) == null) {
            this.m = xz6Var;
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
