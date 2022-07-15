package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
/* loaded from: classes7.dex */
public class vt6 extends an<wy5, AutoVideoCardViewHolder<wy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public tn m;
    public ky n;
    public jy5<wy5> o;

    /* loaded from: classes7.dex */
    public class a extends jy5<wy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt6 b;

        public a(vt6 vt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, wy5 wy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wy5Var) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (wy5Var == null || wy5Var.getThreadData() == null || StringUtils.isNull(wy5Var.getThreadData().getTid())) {
                    return;
                }
                if (wy5Var.getThreadData().middle_page_num <= 0) {
                    this.b.e0(view2, wy5Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(wy5Var.N(wy5Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ vt6 b;

        public b(vt6 vt6Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt6Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vt6Var;
            this.a = kyVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(nn4Var instanceof wy5)) {
                ThreadCardUtils.jumpToPB(nn4Var, this.b.a, 1, false, computeViewArea);
                return;
            }
            nn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(nn4Var, this.b.a, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt6 a;

        public c(vt6 vt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof wy5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    wy5 wy5Var = (wy5) gnVar.c();
                    wy5Var.f = 1;
                    if (this.a.o != null) {
                        this.a.o.a(threadCardViewHolder.b(), wy5Var);
                    }
                    ThreadCardUtils.jumpToPB((nn4) wy5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new ny.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.o = new a(this);
        this.k = tbPageContext;
        this.j = bdUniqueId2;
    }

    public final s68 d0(wy5 wy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wy5Var)) == null) {
            if (wy5Var != null) {
                s68 s68Var = new s68();
                s68Var.a = "7";
                s68Var.c = wy5Var.g;
                if (wy5Var.getThreadData() != null) {
                    s68Var.d = String.valueOf(wy5Var.getThreadData().getFid());
                    if (wy5Var.getThreadData().getThreadVideoInfo() != null) {
                        s68Var.m = wy5Var.getThreadData().getThreadVideoInfo().video_md5;
                        s68Var.p = String.valueOf(wy5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                s68Var.k = wy5Var.g();
                s68Var.f = wy5Var.o();
                s68Var.l = wy5Var.c();
                s68Var.h = wy5Var.D();
                s68Var.e = TbadkCoreApplication.getCurrentAccount();
                s68Var.q = String.valueOf(wy5Var.m());
                return s68Var;
            }
            return null;
        }
        return (s68) invokeL.objValue;
    }

    public final void e0(View view2, wy5 wy5Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, view2, wy5Var) == null) || (kyVar = this.n) == null || kyVar.p() == null || this.n.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.p().getMainView().getId()) {
            vs6.b(view2, wy5Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
            vs6.b(view2, wy5Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public AutoVideoCardViewHolder<wy5> I(ViewGroup viewGroup, wy5 wy5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, viewGroup, wy5Var)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity(), false);
            nz6 nz6Var = new nz6(this.k.getPageActivity());
            nz6Var.x(this.i);
            nz6Var.u("concern_tab");
            nz6Var.v(new b(this, nz6Var));
            this.n = nz6Var;
            bVar.n(nz6Var);
            ky kyVar = this.n;
            if (kyVar != null) {
                kyVar.y("2001");
            }
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(1);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<wy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public View P(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            if (wy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            wy5Var.I(wy5Var.position + 1);
            cy5.b().a(wy5Var.d("c12351"));
            autoVideoCardViewHolder.c().q(i);
            wy5Var.T = 0;
            autoVideoCardViewHolder.w(d0(wy5Var));
            if (autoVideoCardViewHolder.c() instanceof bk5) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(wy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: i0 */
    public View S(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tnVar) == null) {
            this.m = tnVar;
        }
    }

    @Override // com.repackage.an
    public BdUniqueId u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ny5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ny5.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ny5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdUniqueId bdUniqueId = this.j;
            return bdUniqueId != null ? bdUniqueId : ny5.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
