package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes7.dex */
public class xt7 extends eo<hy5, AutoVideoCardViewHolder<hy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public xo k;
    public sz l;
    public ux5<hy5> m;

    /* loaded from: classes7.dex */
    public class a extends ux5<hy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt7 b;

        public a(xt7 xt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, hy5 hy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hy5Var) == null) {
                nx5.b().d(true);
                if (hy5Var == null || hy5Var.getThreadData() == null || StringUtils.isNull(hy5Var.getThreadData().getTid())) {
                    return;
                }
                if (hy5Var.getThreadData().middle_page_num <= 0) {
                    this.b.e0(view2, hy5Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(hy5Var.N(hy5Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ xt7 b;

        public b(xt7 xt7Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt7Var;
            this.a = szVar;
        }

        @Override // com.repackage.zx.a
        public void a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(zn4Var instanceof hy5)) {
                ThreadCardUtils.jumpToPB(zn4Var, this.b.a, 0, false, computeViewArea);
                return;
            }
            zn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(zn4Var, this.b.a, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt7 a;

        public c(xt7 xt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xt7Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof hy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                hy5 hy5Var = (hy5) roVar;
                hy5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), hy5Var);
                }
                ThreadCardUtils.jumpToPB((zn4) hy5Var, view2.getContext(), hy5Var.C, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = new a(this);
        this.j = tbPageContext;
    }

    public final m78 d0(hy5 hy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hy5Var)) == null) {
            if (hy5Var != null) {
                m78 m78Var = new m78();
                m78Var.a = "6";
                m78Var.c = hy5Var.g;
                if (hy5Var.getThreadData() != null) {
                    m78Var.d = String.valueOf(hy5Var.getThreadData().getFid());
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
                return m78Var;
            }
            return null;
        }
        return (m78) invokeL.objValue;
    }

    public final void e0(View view2, hy5 hy5Var) {
        sz szVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, hy5Var) == null) || (szVar = this.l) == null || szVar.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.o().getMainView().getId()) {
            vy7.m(hy5Var, 4, this.j);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
            vy7.m(hy5Var, 1, this.j);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: f0 */
    public AutoVideoCardViewHolder<hy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            bVar.l().j(true);
            fy fyVar = new fy(this.j.getPageActivity());
            fyVar.w(this.i);
            fyVar.t("pb");
            fyVar.u(new b(this, fyVar));
            this.l = fyVar;
            bVar.n(fyVar);
            sz szVar = this.l;
            if (szVar != null) {
                szVar.x("2002");
            }
            kz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<hy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.m);
            k.r(0);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: g0 */
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
            hy5Var.T = 0;
            autoVideoCardViewHolder.x(d0(hy5Var));
            autoVideoCardViewHolder.g(hy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.m);
            vy7.n(hy5Var, this.j);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void h0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xoVar) == null) {
            this.k = xoVar;
        }
    }
}
