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
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes7.dex */
public class zv6 extends wm<zw5, ThreadCardViewHolder<zw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public boolean k;
    public NEGFeedBackView.b l;
    public nw5<zw5> m;

    /* loaded from: classes7.dex */
    public class a implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(zv6 zv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.pw.b
        public void a(om4 om4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) || om4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298) {
                om4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om4Var.objType = 4;
            } else {
                om4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv6 a;

        public b(zv6 zv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            zw5 zw5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || !(jnVar instanceof zw5) || (zw5Var = (zw5) jnVar) == null || (threadData = zw5Var.a) == null || threadData.getSmartApp() == null) {
                return;
            }
            this.a.h0(zw5Var.a, view2);
            TiebaStatic.log(zw5Var.A());
            TiebaStatic.log(zw5Var.k());
            this.a.c0(zw5Var.a, zw5Var.q());
        }
    }

    /* loaded from: classes7.dex */
    public class c extends nw5<zw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv6 b;

        public c(zv6 zv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public boolean c(View view2, zw5 zw5Var, String str) {
            InterceptResult invokeLLL;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zw5Var, str)) == null) {
                if (zw5Var == null || (threadData = zw5Var.a) == null || threadData.getSmartApp() == null) {
                    return false;
                }
                this.b.h0(zw5Var.a, view2);
                TiebaStatic.log(zw5Var.A());
                TiebaStatic.log(zw5Var.k());
                this.b.c0(zw5Var.a, zw5Var.q());
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zv6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            zw5.i0 = "c13388";
            zw5.j0 = "c13389";
        }
    }

    public final void c0(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, threadData, i) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        bf8.g().c(this.i, ze8.g(threadData, "a002", "common_click", 1, i, threadData.getSmartApp().id));
    }

    public final void d0(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, threadData, i) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        String str = threadData.getSmartApp().id;
        bf8.g().d(this.i, ze8.b(threadData.getTid(), "", str, null), ze8.h(threadData, "a002", "common_exp", i, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public ThreadCardViewHolder<zw5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity());
            pw pwVar = new pw(this.j.getPageActivity());
            pwVar.t(this.i);
            pwVar.r(false);
            pwVar.w(false);
            pwVar.c(1024);
            pwVar.s(new a(this));
            bVar.o(pwVar);
            jx jxVar = new jx(this.j.getPageActivity());
            jxVar.p("index");
            jxVar.q(this.k);
            bVar.n(jxVar);
            bVar.m(new ux(this.j.getPageActivity()));
            ThreadCardViewHolder<zw5> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: f0 */
    public View S(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, ThreadCardViewHolder<zw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, threadCardViewHolder})) == null) {
            if (zw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || zw5Var.a == null) {
                return null;
            }
            zw5Var.I(zw5Var.position + 1);
            zw5Var.a.statFloor = zw5Var.q();
            threadCardViewHolder.r(false).u(this.l);
            threadCardViewHolder.g(zw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            gw5.b().a(zw5Var.B());
            ai5.c().i("page_recommend", "show_", zw5Var.B());
            d0(zw5Var.a, zw5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ci5
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
        ys4.k().x("smart_app_tid", parseLong);
        ys4.k().y("smart_app_name", str4);
        ys4.k().y("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!pk5.b(str, str2, "1191008600000000", threadData.getSmartApp().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            sk4.o(view2.getContext(), str3);
        }
        yv5.a(threadData.getTid());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", fid).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", threadData.getSmartApp().is_game.intValue()));
    }
}
