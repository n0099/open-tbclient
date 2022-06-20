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
import com.repackage.by;
import com.repackage.my;
import com.repackage.qw;
/* loaded from: classes6.dex */
public class ht6 extends an<zx5, AutoVideoCardViewHolder<zx5>> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public tn m;
    public jy n;
    public mx5<zx5> o;

    /* loaded from: classes6.dex */
    public class a extends mx5<zx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht6 b;

        public a(ht6 ht6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ht6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zx5Var) == null) {
                fx5.b().d(true);
                xi5.c().h("page_recommend", "show_");
                if (zx5Var == null || zx5Var.getThreadData() == null || StringUtils.isNull(zx5Var.getThreadData().getTid())) {
                    return;
                }
                if (zx5Var.getThreadData().middle_page_num <= 0) {
                    this.b.e0(view2, zx5Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zx5Var.N(zx5Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ ht6 b;

        public b(ht6 ht6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ht6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.qw.a
        public void a(ym4 ym4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ym4Var) == null) || ym4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(ym4Var instanceof zx5)) {
                ThreadCardUtils.jumpToPB(ym4Var, this.b.a, 1, false, computeViewArea);
                return;
            }
            ym4Var.objType = 5;
            ThreadCardUtils.jumpToPB(ym4Var, this.b.a, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht6 a;

        public c(ht6 ht6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ht6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof zx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    zx5 zx5Var = (zx5) gnVar.c();
                    zx5Var.f = 1;
                    if (this.a.o != null) {
                        this.a.o.a(threadCardViewHolder.b(), zx5Var);
                    }
                    ThreadCardUtils.jumpToPB((ym4) zx5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new my.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    public final x58 d0(zx5 zx5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zx5Var)) == null) {
            if (zx5Var != null) {
                x58 x58Var = new x58();
                x58Var.a = "7";
                x58Var.c = zx5Var.g;
                if (zx5Var.getThreadData() != null) {
                    x58Var.d = String.valueOf(zx5Var.getThreadData().getFid());
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
                return x58Var;
            }
            return null;
        }
        return (x58) invokeL.objValue;
    }

    public final void e0(View view2, zx5 zx5Var) {
        jy jyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, view2, zx5Var) == null) || (jyVar = this.n) == null || jyVar.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.o().getMainView().getId()) {
            hs6.b(view2, zx5Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            hs6.b(view2, zx5Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public AutoVideoCardViewHolder<zx5> I(ViewGroup viewGroup, zx5 zx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, viewGroup, zx5Var)) == null) {
            by.b bVar = new by.b(this.k.getPageActivity(), false);
            xy6 xy6Var = new xy6(this.k.getPageActivity());
            xy6Var.w(this.i);
            xy6Var.t("concern_tab");
            xy6Var.u(new b(this, xy6Var));
            this.n = xy6Var;
            bVar.n(xy6Var);
            jy jyVar = this.n;
            if (jyVar != null) {
                jyVar.x("2001");
            }
            by k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(1);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<zx5> M(ViewGroup viewGroup) {
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
    public View P(int i, View view2, ViewGroup viewGroup, zx5 zx5Var, AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zx5Var, autoVideoCardViewHolder})) == null) {
            if (zx5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            zx5Var.I(zx5Var.position + 1);
            fx5.b().a(zx5Var.f("c12351"));
            autoVideoCardViewHolder.c().q(i);
            zx5Var.T = 0;
            autoVideoCardViewHolder.w(d0(zx5Var));
            if (autoVideoCardViewHolder.c() instanceof yi5) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(zx5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: i0 */
    public View S(int i, View view2, ViewGroup viewGroup, zx5 zx5Var, AutoVideoCardViewHolder<zx5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zx5Var, autoVideoCardViewHolder})) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? qx5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? qx5.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? qx5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdUniqueId bdUniqueId = this.j;
            return bdUniqueId != null ? bdUniqueId : qx5.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
