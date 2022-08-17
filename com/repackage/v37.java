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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.rw;
/* loaded from: classes7.dex */
public class v37 extends bn<o06, AutoVideoCardViewHolder<o06>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public un c;
    public ly d;
    public u07 e;
    public b06<o06> f;

    /* loaded from: classes7.dex */
    public class a extends b06<o06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v37 b;

        public a(v37 v37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, o06 o06Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o06Var) == null) || view2 == null || o06Var == null || o06Var.getThreadData() == null) {
                return;
            }
            this.b.y(view2, o06Var);
            if (this.b.e == null || !(view2.getTag() instanceof String) || xy6.b(og.g(o06Var.getThreadData().getTid(), 0L))) {
                return;
            }
            xy6.a(og.g(o06Var.getThreadData().getTid(), 0L));
            this.b.e.e(og.g(o06Var.getThreadData().getTid(), 0L), o06Var.D(), o06Var.r(), o06Var.n(), o06Var.c(), og.e("3", 1), "video_tab", o06Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ v37 b;

        public b(v37 v37Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v37Var;
            this.a = lyVar;
        }

        @Override // com.repackage.rw.a
        public void a(fo4 fo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fo4Var) == null) || fo4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (fo4Var instanceof o06) {
                fo4Var.objType = 5;
                d47.f((f06) fo4Var);
                d47.c(fo4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            d47.f((f06) fo4Var);
            d47.c(fo4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v37 a;

        public c(v37 v37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v37Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof o06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o06 o06Var = (o06) onVar;
                o06Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), o06Var);
                }
                d47.c(o06Var, view2.getContext(), 19, false, vw.a((un) viewGroup, view2, i));
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v37(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o06 o06Var, AutoVideoCardViewHolder<o06> autoVideoCardViewHolder) {
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
            autoVideoCardViewHolder.a().q(i);
            autoVideoCardViewHolder.u(x(o06Var));
            d47.d(o06Var);
            autoVideoCardViewHolder.e(o06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(u07 u07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u07Var) == null) {
            this.e = u07Var;
        }
    }

    public void D(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, unVar) == null) {
            this.c = unVar;
        }
    }

    public void onPause() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lyVar = this.d) == null) {
            return;
        }
        lyVar.s();
    }

    public final y88 x(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, o06Var)) == null) {
            if (o06Var != null) {
                y88 y88Var = new y88();
                y88Var.a = "19";
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
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, o06Var) == null) || (lyVar = this.d) == null || lyVar.p() == null || this.d.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.d.p().getMainView().getId()) {
            d47.h(o06Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
            d47.f(o06Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: z */
    public AutoVideoCardViewHolder<o06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.a.getPageActivity(), false);
            xw xwVar = new xw(this.a.getPageActivity());
            xwVar.v(new b(this, xwVar));
            this.d = xwVar;
            xwVar.x(this.b);
            this.d.u("video_tab");
            this.d.y("2001");
            bVar.n(this.d);
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<o06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.p(this.f);
            k.r(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
