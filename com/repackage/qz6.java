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
import com.repackage.dy;
import com.repackage.uw;
/* loaded from: classes7.dex */
public class qz6 extends bn<n06, ThreadCardViewHolder<n06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public NEGFeedBackView.b d;
    public b06<n06> e;

    /* loaded from: classes7.dex */
    public class a implements uw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(qz6 qz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.uw.b
        public void a(fo4 fo4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, fo4Var, view2) == null) || fo4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092450) {
                fo4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092422) {
                fo4Var.objType = 4;
            } else {
                fo4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz6 a;

        public b(qz6 qz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            n06 n06Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || !(onVar instanceof n06) || (n06Var = (n06) onVar) == null || (threadData = n06Var.a) == null || threadData.getSmartApp() == null) {
                return;
            }
            this.a.A(n06Var.a, view2);
            TiebaStatic.log(n06Var.A());
            TiebaStatic.log(n06Var.j());
            this.a.v(n06Var.a, n06Var.n());
        }
    }

    /* loaded from: classes7.dex */
    public class c extends b06<n06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz6 b;

        public c(qz6 qz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public boolean c(View view2, n06 n06Var, String str) {
            InterceptResult invokeLLL;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, n06Var, str)) == null) {
                if (n06Var == null || (threadData = n06Var.a) == null || threadData.getSmartApp() == null) {
                    return false;
                }
                this.b.A(n06Var.a, view2);
                TiebaStatic.log(n06Var.A());
                TiebaStatic.log(n06Var.j());
                this.b.v(n06Var.a, n06Var.n());
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = true;
        this.d = null;
        this.e = new c(this);
        this.b = tbPageContext;
        u();
    }

    public final void A(ThreadData threadData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, threadData, view2) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        String str = threadData.getSmartApp().id;
        String str2 = threadData.getSmartApp().link;
        String str3 = threadData.getSmartApp().h5_url;
        Long l = threadData.getSmartApp().swan_app_id;
        long parseLong = Long.parseLong(threadData.getTid());
        long fid = threadData.getFid();
        String str4 = threadData.getSmartApp().name;
        ru4.k().x("smart_app_tid", parseLong);
        ru4.k().y("smart_app_name", str4);
        ru4.k().y("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!ho5.b(str, str2, "1191008600000000", threadData.getSmartApp().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            jm4.o(view2.getContext(), str3);
        }
        mz5.a(threadData.getTid());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", fid).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", threadData.getSmartApp().is_game.intValue()));
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n06.c0 = "c13388";
            n06.d0 = "c13389";
        }
    }

    public final void v(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, threadData, i) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        cj8.g().c(this.a, aj8.g(threadData, "a002", "common_click", 1, i, threadData.getSmartApp().id));
    }

    public final void w(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, threadData, i) == null) || threadData == null || threadData.getSmartApp() == null) {
            return;
        }
        String str = threadData.getSmartApp().id;
        cj8.g().d(this.a, aj8.b(threadData.getTid(), "", str, null), aj8.h(threadData, "a002", "common_exp", i, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: x */
    public ThreadCardViewHolder<n06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity());
            uw uwVar = new uw(this.b.getPageActivity());
            uwVar.u(this.a);
            uwVar.s(false);
            uwVar.x(false);
            uwVar.d(1024);
            uwVar.t(new a(this));
            bVar.o(uwVar);
            px pxVar = new px(this.b.getPageActivity());
            pxVar.q("index");
            pxVar.r(this.c);
            bVar.n(pxVar);
            bVar.m(new ay(this.b.getPageActivity()));
            ThreadCardViewHolder<n06> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n06 n06Var, ThreadCardViewHolder<n06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n06Var, threadCardViewHolder})) == null) {
            if (n06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || n06Var.a == null) {
                return null;
            }
            n06Var.I(n06Var.position + 1);
            n06Var.a.statFloor = n06Var.n();
            threadCardViewHolder.o(false).u(this.d);
            threadCardViewHolder.e(n06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.e);
            uz5.b().a(n06Var.B());
            nl5.c().i("page_recommend", "show_", n06Var.B());
            w(n06Var.a, n06Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
