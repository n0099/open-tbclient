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
/* loaded from: classes5.dex */
public class au6 extends eo<hy5, AutoVideoCardViewHolder<hy5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public xo l;
    public sz m;
    public ux5<hy5> n;

    /* loaded from: classes5.dex */
    public class a extends ux5<hy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au6 b;

        public a(au6 au6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = au6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, hy5 hy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hy5Var) == null) {
                nx5.b().d(true);
                gj5.c().h("page_recommend", "show_");
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

    /* loaded from: classes5.dex */
    public class b implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ au6 b;

        public b(au6 au6Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au6Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = au6Var;
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
                ThreadCardUtils.jumpToPB(zn4Var, this.b.a, 1, false, computeViewArea);
                return;
            }
            zn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(zn4Var, this.b.a, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au6 a;

        public c(au6 au6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au6Var;
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
                ThreadCardUtils.jumpToPB((zn4) hy5Var, view2.getContext(), 1, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.j = tbPageContext;
    }

    public final m78 d0(hy5 hy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hy5Var)) == null) {
            if (hy5Var != null) {
                m78 m78Var = new m78();
                m78Var.a = "7";
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, hy5Var) == null) || (szVar = this.m) == null || szVar.o() == null || this.m.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.m.o().getMainView().getId()) {
            at6.b(view2, hy5Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
            at6.b(view2, hy5Var, 2);
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
            kz6 kz6Var = new kz6(this.j.getPageActivity());
            kz6Var.w(this.i);
            kz6Var.t("concern_tab");
            kz6Var.u(new b(this, kz6Var));
            this.m = kz6Var;
            bVar.n(kz6Var);
            sz szVar = this.m;
            if (szVar != null) {
                szVar.x("2001");
            }
            kz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            AutoVideoCardViewHolder<hy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.n);
            k.r(1);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, hy5 hy5Var, AutoVideoCardViewHolder<hy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hy5Var, autoVideoCardViewHolder})) == null) {
            if (hy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            hy5Var.I(hy5Var.position + 1);
            nx5.b().a(hy5Var.g("c12351"));
            autoVideoCardViewHolder.c().q(i);
            hy5Var.T = 0;
            autoVideoCardViewHolder.x(d0(hy5Var));
            if (autoVideoCardViewHolder.c() instanceof hj5) {
                autoVideoCardViewHolder.c().b(this.k);
            }
            autoVideoCardViewHolder.g(hy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.n);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void h0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xoVar) == null) {
            this.l = xoVar;
        }
    }
}
