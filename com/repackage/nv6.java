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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.rw;
/* loaded from: classes6.dex */
public class nv6 extends bn<o06, AutoVideoCardViewHolder<o06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public un e;
    public ly f;
    public b06<o06> g;

    /* loaded from: classes6.dex */
    public class a extends b06<o06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv6 b;

        public a(nv6 nv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, o06 o06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o06Var) == null) {
                uz5.b().d(true);
                nl5.c().h("page_recommend", "show_");
                if (o06Var == null || o06Var.getThreadData() == null || StringUtils.isNull(o06Var.getThreadData().getTid())) {
                    return;
                }
                if (o06Var.getThreadData().middle_page_num <= 0) {
                    this.b.x(view2, o06Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(o06Var.N(o06Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ nv6 b;

        public b(nv6 nv6Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv6Var;
            this.a = lyVar;
        }

        @Override // com.repackage.rw.a
        public void a(fo4 fo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fo4Var) == null) || fo4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(fo4Var instanceof o06)) {
                ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            fo4Var.objType = 5;
            ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv6 a;

        public c(nv6 nv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof hn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                hn hnVar = (hn) onVar;
                if (hnVar.c() instanceof o06) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    o06 o06Var = (o06) hnVar.c();
                    o06Var.f = 1;
                    if (this.a.g != null) {
                        this.a.g.a(threadCardViewHolder.getView(), o06Var);
                    }
                    ThreadCardUtils.jumpToPB((fo4) o06Var, view2.getContext(), 1, false, vw.a((un) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new oy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nv6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.g = new a(this);
        this.c = tbPageContext;
        this.b = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: A */
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, o06 o06Var, AutoVideoCardViewHolder<o06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o06Var, autoVideoCardViewHolder})) == null) {
            if (o06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            o06Var.I(o06Var.position + 1);
            uz5.b().a(o06Var.f("c12351"));
            autoVideoCardViewHolder.a().q(i);
            o06Var.T = 0;
            autoVideoCardViewHolder.u(w(o06Var));
            if (autoVideoCardViewHolder.a() instanceof ol5) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(o06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o06 o06Var, AutoVideoCardViewHolder<o06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o06Var, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void C(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unVar) == null) {
            this.e = unVar;
        }
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.repackage.bn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f06.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.bn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f06.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.bn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f06.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.bn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            return bdUniqueId != null ? bdUniqueId : f06.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final y88 w(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, o06Var)) == null) {
            if (o06Var != null) {
                y88 y88Var = new y88();
                y88Var.a = "7";
                y88Var.c = o06Var.g;
                if (o06Var.getThreadData() != null) {
                    y88Var.d = String.valueOf(o06Var.getThreadData().getFid());
                    if (o06Var.getThreadData().getThreadVideoInfo() != null) {
                        y88Var.m = o06Var.getThreadData().getThreadVideoInfo().video_md5;
                        y88Var.p = String.valueOf(o06Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                y88Var.k = o06Var.h();
                y88Var.f = o06Var.r();
                y88Var.l = o06Var.c();
                y88Var.h = o06Var.D();
                y88Var.e = TbadkCoreApplication.getCurrentAccount();
                y88Var.q = String.valueOf(o06Var.n());
                return y88Var;
            }
            return null;
        }
        return (y88) invokeL.objValue;
    }

    public final void x(View view2, o06 o06Var) {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, o06Var) == null) || (lyVar = this.f) == null || lyVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            nu6.b(view2, o06Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
            nu6.b(view2, o06Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: y */
    public AutoVideoCardViewHolder<o06> onCreateContentViewHolder(ViewGroup viewGroup, o06 o06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, o06Var)) == null) {
            dy.b bVar = new dy.b(this.c.getPageActivity(), false);
            g17 g17Var = new g17(this.c.getPageActivity());
            g17Var.x(this.a);
            g17Var.u("concern_tab");
            g17Var.v(new b(this, g17Var));
            this.f = g17Var;
            bVar.n(g17Var);
            ly lyVar = this.f;
            if (lyVar != null) {
                lyVar.y("2001");
            }
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<o06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: z */
    public AutoVideoCardViewHolder<o06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
