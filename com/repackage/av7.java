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
/* loaded from: classes5.dex */
public class av7 extends bn<o06, AutoVideoCardViewHolder<o06>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public un c;
    public ly d;
    public b06<o06> e;

    /* loaded from: classes5.dex */
    public class a extends b06<o06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ av7 b;

        public a(av7 av7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = av7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, o06 o06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o06Var) == null) {
                uz5.b().d(true);
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

    /* loaded from: classes5.dex */
    public class b implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ av7 b;

        public b(av7 av7Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = av7Var;
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
                ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, 0, false, computeViewArea);
                return;
            }
            fo4Var.objType = 5;
            ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ av7 a;

        public c(av7 av7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = av7Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof o06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o06 o06Var = (o06) onVar;
                o06Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), o06Var);
                }
                ThreadCardUtils.jumpToPB((fo4) o06Var, view2.getContext(), o06Var.C, false, vw.a((un) viewGroup, view2, i));
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public void A(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, unVar) == null) {
            this.c = unVar;
        }
    }

    public final y88 w(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, o06Var)) == null) {
            if (o06Var != null) {
                y88 y88Var = new y88();
                y88Var.a = "6";
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
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view2, o06Var) == null) || (lyVar = this.d) == null || lyVar.p() == null || this.d.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.d.p().getMainView().getId()) {
            h08.m(o06Var, 4, this.b);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
            h08.m(o06Var, 1, this.b);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: y */
    public AutoVideoCardViewHolder<o06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            bVar.l().j(true);
            xw xwVar = new xw(this.b.getPageActivity());
            xwVar.x(this.a);
            xwVar.u("pb");
            xwVar.v(new b(this, xwVar));
            this.d = xwVar;
            bVar.n(xwVar);
            ly lyVar = this.d;
            if (lyVar != null) {
                lyVar.y("2002");
            }
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<o06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.e);
            k.r(0);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o06 o06Var, AutoVideoCardViewHolder<o06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o06Var, autoVideoCardViewHolder})) == null) {
            if (o06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            o06Var.I(o06Var.position + 1);
            autoVideoCardViewHolder.a().q(i);
            o06Var.T = 0;
            autoVideoCardViewHolder.u(w(o06Var));
            autoVideoCardViewHolder.e(o06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.e);
            h08.n(o06Var, this.b);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
