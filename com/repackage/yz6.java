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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.rw;
/* loaded from: classes7.dex */
public class yz6 extends bn<o06, AutoVideoCardViewHolder<o06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public u07 c;
    public String d;
    public un e;
    public ly f;
    public b06<o06> g;

    /* loaded from: classes7.dex */
    public class a extends b06<o06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz6 b;

        public a(yz6 yz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, o06 o06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o06Var) == null) {
                uz5.b().d(true);
                nl5.c().h("page_recommend", "show_");
                if (this.b.c == null || o06Var == null || o06Var.getThreadData() == null || StringUtils.isNull(o06Var.getThreadData().getTid())) {
                    return;
                }
                if (o06Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(o06Var.N(o06Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !xy6.b(og.g(o06Var.getThreadData().getTid(), 0L))) {
                    xy6.a(og.g(o06Var.getThreadData().getTid(), 0L));
                    this.b.c.e(og.g(o06Var.getThreadData().getTid(), 0L), o06Var.D(), o06Var.r(), o06Var.n(), o06Var.c(), og.e((String) view2.getTag(), 1), "homepage", o06Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, o06Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ yz6 b;

        public b(yz6 yz6Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz6Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz6Var;
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
                ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            fo4Var.objType = 5;
            ThreadCardUtils.jumpToPB(fo4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz6 a;

        public c(yz6 yz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof o06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                o06 o06Var = (o06) onVar;
                o06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), o06Var);
                }
                ThreadCardUtils.jumpToPB((fo4) o06Var, view2.getContext(), 2, false, vw.a((un) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.b = tbPageContext;
        z();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: A */
    public AutoVideoCardViewHolder<o06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            g17 g17Var = new g17(this.b.getPageActivity());
            g17Var.v(new b(this, g17Var));
            this.f = g17Var;
            g17Var.x(this.a);
            this.f.u("index");
            this.f.y("2001");
            bVar.n(this.f);
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<o06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o06 o06Var, AutoVideoCardViewHolder<o06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o06Var, autoVideoCardViewHolder})) == null) {
            if (o06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            o06Var.I(o06Var.position + 1);
            o06Var.a.statFloor = o06Var.n();
            autoVideoCardViewHolder.a().q(i);
            o06Var.T = 0;
            uz5.b().a(o06Var.B());
            autoVideoCardViewHolder.u(x(o06Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(o06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            b17.i(o06Var.a, this.a, o06Var.n());
            b17.h(o06Var.a, o06Var.r(), o06Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void C(u07 u07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u07Var) == null) {
            this.c = u07Var;
        }
    }

    public void D(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, unVar) == null) {
            this.e = unVar;
        }
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public void onPause() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lyVar = this.f) == null) {
            return;
        }
        lyVar.s();
    }

    public void onResume() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (lyVar = this.f) == null) {
            return;
        }
        lyVar.t();
    }

    public final y88 x(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, o06Var)) == null) {
            if (o06Var != null) {
                y88 y88Var = new y88();
                y88Var.a = "1";
                y88Var.c = o06Var.g;
                if (o06Var.getThreadData() != null) {
                    y88Var.d = String.valueOf(o06Var.getThreadData().getFid());
                    y88Var.v = o06Var.getThreadData().getNid();
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
                if (o06Var.getThreadData() == null || o06Var.getThreadData().getBaijiahaoData() == null) {
                    return y88Var;
                }
                y88Var.t = o06Var.getThreadData().getBaijiahaoData().oriUgcNid;
                y88Var.u = o06Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return y88Var;
            }
            return null;
        }
        return (y88) invokeL.objValue;
    }

    public final void y(View view2, o06 o06Var) {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view2, o06Var) == null) || (lyVar = this.f) == null || lyVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            b17.d(o06Var.a, this.a, o06Var.n(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(o06Var.P()));
            b17.c(o06Var.a, o06Var.r(), o06Var.n(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(o06Var.N(o06Var.a)));
            b17.c(o06Var.a, o06Var.r(), o06Var.n(), 1);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            o06.V = "c10708";
            o06.W = "c10735";
            o06.X = "c10709";
            o06.Y = "c10734";
            o06.Z = "c11929";
            o06.a0 = "c11928";
            o06.b0 = "c10756";
        }
    }
}
