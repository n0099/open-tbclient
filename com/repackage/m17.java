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
import com.repackage.by;
import com.repackage.my;
import com.repackage.qw;
/* loaded from: classes6.dex */
public class m17 extends an<zx5, AutoVideoCardViewHolder<zx5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public tn k;
    public jy l;
    public ly6 m;
    public mx5<zx5> n;

    /* loaded from: classes6.dex */
    public class a extends mx5<zx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m17 b;

        public a(m17 m17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zx5Var) == null) || view2 == null || zx5Var == null || zx5Var.getThreadData() == null) {
                return;
            }
            this.b.f0(view2, zx5Var);
            if (this.b.m == null || !(view2.getTag() instanceof String) || ow6.b(ng.g(zx5Var.getThreadData().getTid(), 0L))) {
                return;
            }
            ow6.a(ng.g(zx5Var.getThreadData().getTid(), 0L));
            this.b.m.e(ng.g(zx5Var.getThreadData().getTid(), 0L), zx5Var.D(), zx5Var.r(), zx5Var.n(), zx5Var.c(), ng.e("3", 1), "video_tab", zx5Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ m17 b;

        public b(m17 m17Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m17Var;
            this.a = jyVar;
        }

        @Override // com.repackage.qw.a
        public void a(ym4 ym4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ym4Var) == null) || ym4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (ym4Var instanceof zx5) {
                ym4Var.objType = 5;
                u17.f((qx5) ym4Var);
                u17.c(ym4Var, this.b.a, 19, false, computeViewArea);
                return;
            }
            u17.f((qx5) ym4Var);
            u17.c(ym4Var, this.b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m17 a;

        public c(m17 m17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m17Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof zx5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zx5 zx5Var = (zx5) nnVar;
                zx5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), zx5Var);
                }
                u17.c(zx5Var, view2.getContext(), 19, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new my.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m17(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final x58 e0(zx5 zx5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zx5Var)) == null) {
            if (zx5Var != null) {
                x58 x58Var = new x58();
                x58Var.a = "19";
                x58Var.c = zx5Var.g;
                if (zx5Var.getThreadData() != null) {
                    x58Var.d = String.valueOf(zx5Var.getThreadData().getFid());
                    x58Var.v = zx5Var.getThreadData().getNid();
                    if (zx5Var.getThreadData().getThreadVideoInfo() != null) {
                        x58Var.m = zx5Var.getThreadData().getThreadVideoInfo().video_md5;
                        x58Var.p = String.valueOf(zx5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                x58Var.k = zx5Var.h();
                x58Var.f = zx5Var.r();
                x58Var.l = zx5Var.c();
                x58Var.h = zx5Var.D();
                x58Var.e = TbadkCoreApplication.getCurrentAccount();
                x58Var.q = String.valueOf(zx5Var.n());
                if (zx5Var.getThreadData() == null || zx5Var.getThreadData().getBaijiahaoData() == null) {
                    return x58Var;
                }
                x58Var.t = zx5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                x58Var.u = zx5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return x58Var;
            }
            return null;
        }
        return (x58) invokeL.objValue;
    }

    public final void f0(View view2, zx5 zx5Var) {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, zx5Var) == null) || (jyVar = this.l) == null || jyVar.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.o().getMainView().getId()) {
            u17.h(zx5Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            u17.f(zx5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<zx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            by.b bVar = new by.b(this.i.getPageActivity(), false);
            ww wwVar = new ww(this.i.getPageActivity());
            wwVar.u(new b(this, wwVar));
            this.l = wwVar;
            wwVar.w(this.j);
            this.l.t("video_tab");
            this.l.x("2001");
            bVar.n(this.l);
            by k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.j);
            k.p(this.n);
            k.r(19);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public View S(int i, View view2, ViewGroup viewGroup, zx5 zx5Var, AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zx5Var, autoVideoCardViewHolder})) == null) {
            if (zx5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            zx5Var.I(zx5Var.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.w(e0(zx5Var));
            u17.d(zx5Var);
            autoVideoCardViewHolder.g(zx5Var);
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

    public void j0(ly6 ly6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ly6Var) == null) {
            this.m = ly6Var;
        }
    }

    public void k0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            this.k = tnVar;
        }
    }

    public void onPause() {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (jyVar = this.l) == null) {
            return;
        }
        jyVar.r();
    }
}
