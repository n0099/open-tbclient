package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.kz;
/* loaded from: classes7.dex */
public class vx6 extends eo<gy5, ThreadCardViewHolder<gy5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public boolean k;
    public NEGFeedBackView.b l;
    public ux5<gy5> m;

    /* loaded from: classes7.dex */
    public class a implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(vx6 vx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || zn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3) {
                zn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                zn4Var.objType = 4;
            } else {
                zn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6 a;

        public b(vx6 vx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vx6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            gy5 gy5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || !(roVar instanceof gy5) || (gy5Var = (gy5) roVar) == null || (threadData = gy5Var.a) == null || threadData.getSmartApp() == null) {
                return;
            }
            this.a.h0(gy5Var.a, view2);
            TiebaStatic.log(gy5Var.A());
            TiebaStatic.log(gy5Var.k());
            this.a.c0(gy5Var.a, gy5Var.q());
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ux5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6 b;

        public c(vx6 vx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public boolean c(View view2, gy5 gy5Var, String str) {
            InterceptResult invokeLLL;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var, str)) == null) {
                if (gy5Var == null || (threadData = gy5Var.a) == null || threadData.getSmartApp() == null) {
                    return false;
                }
                this.b.h0(gy5Var.a, view2);
                TiebaStatic.log(gy5Var.A());
                TiebaStatic.log(gy5Var.k());
                this.b.c0(gy5Var.a, gy5Var.q());
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.k = true;
        this.l = null;
        this.m = new c(this);
        this.j = tbPageContext;
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gy5.i0 = "c13388";
            gy5.j0 = "c13389";
        }
    }

    public final void c0(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, threadData, i) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        ai8.g().c(this.i, yh8.g(threadData, "a002", "common_click", 1, i, threadData.getSmartApp().id));
    }

    public final void d0(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, threadData, i) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        String str = threadData.getSmartApp().id;
        ai8.g().d(this.i, yh8.b(threadData.getTid(), "", str, null), yh8.h(threadData, "a002", "common_exp", i, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: e0 */
    public ThreadCardViewHolder<gy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity());
            cy cyVar = new cy(this.j.getPageActivity());
            cyVar.t(this.i);
            cyVar.r(false);
            cyVar.w(false);
            cyVar.c(1024);
            cyVar.s(new a(this));
            bVar.o(cyVar);
            wy wyVar = new wy(this.j.getPageActivity());
            wyVar.p("index");
            wyVar.q(this.k);
            bVar.n(wyVar);
            bVar.m(new hz(this.j.getPageActivity()));
            ThreadCardViewHolder<gy5> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: f0 */
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, ThreadCardViewHolder<gy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, threadCardViewHolder})) == null) {
            if (gy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || gy5Var.a == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            gy5Var.a.statFloor = gy5Var.q();
            threadCardViewHolder.r(false).u(this.l);
            threadCardViewHolder.g(gy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            nx5.b().a(gy5Var.B());
            gj5.c().i("page_recommend", "show_", gy5Var.B());
            d0(gy5Var.a, gy5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public final void h0(ThreadData threadData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, threadData, view2) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        String str = threadData.getSmartApp().id;
        String str2 = threadData.getSmartApp().link;
        String str3 = threadData.getSmartApp().h5_url;
        Long l = threadData.getSmartApp().swan_app_id;
        long parseLong = Long.parseLong(threadData.getTid());
        long fid = threadData.getFid();
        String str4 = threadData.getSmartApp().name;
        iu4.k().x("smart_app_tid", parseLong);
        iu4.k().y("smart_app_name", str4);
        iu4.k().y("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!vl5.b(str, str2, "1191008600000000", threadData.getSmartApp().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            fm4.m(view2.getContext(), str3);
        }
        fx5.a(threadData.getTid());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", fid).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", threadData.getSmartApp().is_game.intValue()));
    }
}
