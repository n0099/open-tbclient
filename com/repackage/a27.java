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
import com.repackage.kz;
import com.repackage.vz;
import com.repackage.zx;
/* loaded from: classes5.dex */
public class a27 extends eo<hy5, AutoVideoCardViewHolder<hy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public xo k;
    public sz l;
    public zy6 m;
    public ux5<hy5> n;

    /* loaded from: classes5.dex */
    public class a extends ux5<hy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a27 b;

        public a(a27 a27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, hy5 hy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hy5Var) == null) || view2 == null || hy5Var == null || hy5Var.getThreadData() == null) {
                return;
            }
            this.b.f0(view2, hy5Var);
            if (this.b.m == null || !(view2.getTag() instanceof String) || cx6.b(kg.g(hy5Var.getThreadData().getTid(), 0L))) {
                return;
            }
            cx6.a(kg.g(hy5Var.getThreadData().getTid(), 0L));
            this.b.m.e(kg.g(hy5Var.getThreadData().getTid(), 0L), hy5Var.D(), hy5Var.r(), hy5Var.q(), hy5Var.e(), kg.e("3", 1), "video_tab", hy5Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ a27 b;

        public b(a27 a27Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a27Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a27Var;
            this.a = szVar;
        }

        @Override // com.repackage.zx.a
        public void a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (zn4Var instanceof hy5) {
                zn4Var.objType = 5;
                i27.f((yx5) zn4Var);
                i27.c(zn4Var, this.b.a, 19, false, computeViewArea);
                return;
            }
            i27.f((yx5) zn4Var);
            i27.c(zn4Var, this.b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a27 a;

        public c(a27 a27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a27Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof hy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                hy5 hy5Var = (hy5) roVar;
                hy5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), hy5Var);
                }
                i27.c(hy5Var, view2.getContext(), 19, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a27(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final m78 e0(hy5 hy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hy5Var)) == null) {
            if (hy5Var != null) {
                m78 m78Var = new m78();
                m78Var.a = "19";
                m78Var.c = hy5Var.g;
                if (hy5Var.getThreadData() != null) {
                    m78Var.d = String.valueOf(hy5Var.getThreadData().getFid());
                    m78Var.v = hy5Var.getThreadData().getNid();
                    if (hy5Var.getThreadData().getThreadVideoInfo() != null) {
                        m78Var.m = hy5Var.getThreadData().getThreadVideoInfo().video_md5;
                        m78Var.p = String.valueOf(hy5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                m78Var.k = hy5Var.i();
                m78Var.f = hy5Var.r();
                m78Var.l = hy5Var.e();
                m78Var.h = hy5Var.D();
                m78Var.e = TbadkCoreApplication.getCurrentAccount();
                m78Var.q = String.valueOf(hy5Var.q());
                if (hy5Var.getThreadData() == null || hy5Var.getThreadData().getBaijiahaoData() == null) {
                    return m78Var;
                }
                m78Var.t = hy5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                m78Var.u = hy5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return m78Var;
            }
            return null;
        }
        return (m78) invokeL.objValue;
    }

    public final void f0(View view2, hy5 hy5Var) {
        sz szVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, hy5Var) == null) || (szVar = this.l) == null || szVar.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.o().getMainView().getId()) {
            i27.h(hy5Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
            i27.f(hy5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<hy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.i.getPageActivity(), false);
            fy fyVar = new fy(this.i.getPageActivity());
            fyVar.u(new b(this, fyVar));
            this.l = fyVar;
            fyVar.w(this.j);
            this.l.t("video_tab");
            this.l.x("2001");
            bVar.n(this.l);
            kz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<hy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.j);
            k.p(this.n);
            k.r(19);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: h0 */
    public View S(int i, View view2, ViewGroup viewGroup, hy5 hy5Var, AutoVideoCardViewHolder<hy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hy5Var, autoVideoCardViewHolder})) == null) {
            if (hy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            hy5Var.I(hy5Var.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.x(e0(hy5Var));
            i27.d(hy5Var);
            autoVideoCardViewHolder.g(hy5Var);
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

    public void j0(zy6 zy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zy6Var) == null) {
            this.m = zy6Var;
        }
    }

    public void k0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xoVar) == null) {
            this.k = xoVar;
        }
    }

    public void onPause() {
        sz szVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (szVar = this.l) == null) {
            return;
        }
        szVar.r();
    }
}
