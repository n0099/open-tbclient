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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
/* loaded from: classes6.dex */
public class ft7 extends an<wy5, AutoVideoCardViewHolder<wy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public tn k;
    public ky l;
    public jy5<wy5> m;

    /* loaded from: classes6.dex */
    public class a extends jy5<wy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 b;

        public a(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ft7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, wy5 wy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wy5Var) == null) {
                cy5.b().d(true);
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

    /* loaded from: classes6.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ ft7 b;

        public b(ft7 ft7Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ft7Var;
            this.a = kyVar;
        }

        @Override // com.repackage.qw.a
        public void a(on4 on4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, on4Var) == null) || on4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(on4Var instanceof wy5)) {
                ThreadCardUtils.jumpToPB(on4Var, this.b.a, 0, false, computeViewArea);
                return;
            }
            on4Var.objType = 5;
            ThreadCardUtils.jumpToPB(on4Var, this.b.a, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        public c(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft7Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof wy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wy5 wy5Var = (wy5) nnVar;
                wy5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.a(), wy5Var);
                }
                ThreadCardUtils.jumpToPB((on4) wy5Var, view2.getContext(), wy5Var.C, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.b().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final s68 d0(wy5 wy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wy5Var)) == null) {
            if (wy5Var != null) {
                s68 s68Var = new s68();
                s68Var.a = "6";
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, wy5Var) == null) || (kyVar = this.l) == null || kyVar.p() == null || this.l.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.p().getMainView().getId()) {
            fy7.m(wy5Var, 4, this.j);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202e) {
            fy7.m(wy5Var, 1, this.j);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public AutoVideoCardViewHolder<wy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            bVar.l().j(true);
            ww wwVar = new ww(this.j.getPageActivity());
            wwVar.x(this.i);
            wwVar.u("pb");
            wwVar.v(new b(this, wwVar));
            this.l = wwVar;
            bVar.n(wwVar);
            ky kyVar = this.l;
            if (kyVar != null) {
                kyVar.y("2002");
            }
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.i);
            k.p(this.m);
            k.r(0);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            if (wy5Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            wy5Var.I(wy5Var.position + 1);
            autoVideoCardViewHolder.b().q(i);
            wy5Var.T = 0;
            autoVideoCardViewHolder.v(d0(wy5Var));
            autoVideoCardViewHolder.f(wy5Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.m);
            fy7.n(wy5Var, this.j);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void h0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tnVar) == null) {
            this.k = tnVar;
        }
    }
}
