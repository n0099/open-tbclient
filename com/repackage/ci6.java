package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b00;
import com.repackage.m00;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class ci6 extends id6<rq4, AutoVideoCardViewHolder<ThreadData>> implements px5, gp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> t;
    public int u;
    public ep6 v;
    public boolean w;
    public rx5<ThreadData> x;

    /* loaded from: classes5.dex */
    public class a extends rx5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci6 b;

        public a(ci6 ci6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rx5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09229c && view2.getId() != R.id.obfuscated_res_0x7f09227a) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f98) {
                    dp6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eb4) {
                    dp6.e(threadData, 3, this.b.e, this.b.v, this.b.a0());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    dp6.e(threadData, 15, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb9) {
                    dp6.e(threadData, 14, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e96) {
                    dp6.e(threadData, 12, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eac) {
                    dp6.e(threadData, 13, this.b.e, this.b.v, this.b.a0());
                } else {
                    dp6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                }
            } else {
                dp6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229c || view2.getId() == R.id.obfuscated_res_0x7f09227a) {
                fp6.k().h(this.b.v, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f86) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    al8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                fp6.k().h(this.b.v, threadData, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci6 a;

        public b(ci6 ci6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof rq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((rq4) uoVar).s;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((qn4) threadData, view2.getContext(), this.a.u, false);
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.v = new ep6();
        this.w = false;
        this.x = new a(this);
        this.t = new HashSet();
    }

    @Override // com.repackage.px5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.id6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.t.clear();
        }
    }

    @Override // com.repackage.gp6
    public ep6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (ep6) invokeV.objValue;
    }

    @Override // com.repackage.px5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.repackage.id6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public final f78 w0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            f78 f78Var = new f78();
            if (100 == a0().tabType) {
                f78Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                f78Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            f78Var.d = this.v.c;
            f78Var.c = threadData.getTid();
            f78Var.f = threadData.mRecomSource;
            f78Var.g = threadData.mRecomReason;
            f78Var.h = threadData.mRecomWeight;
            f78Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                f78Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return f78Var;
        }
        return (f78) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: x0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.k.getPageActivity());
            ty tyVar = new ty(this.k.getPageActivity());
            tyVar.b(696);
            tyVar.t(this.e);
            bVar.o(tyVar);
            hz hzVar = new hz(this.k.getPageActivity());
            hzVar.A(this.w);
            bVar.n(hzVar);
            dz dzVar = new dz(this.k.getPageActivity());
            dzVar.x(this.w);
            dzVar.w("frs");
            bVar.h(dzVar);
            d00 d00Var = new d00(this.k.getPageActivity());
            wn4 wn4Var = new wn4();
            if (100 == a0().tabType) {
                wn4Var.b = 25;
                d00Var.w(19);
                d00Var.A(14);
            } else {
                wn4Var.b = 2;
                d00Var.w(2);
                d00Var.A(1);
            }
            wn4Var.h = 2;
            d00Var.v(wn4Var);
            d00Var.x(this.u);
            d00Var.b(16);
            bVar.m(d00Var);
            b00 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.k(this.e);
            k.p(this.x);
            k.r(this.u);
            V(new b(this));
            autoVideoCardViewHolder.o();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.id6, com.repackage.ho
    /* renamed from: y0 */
    public View S(int i, View view2, ViewGroup viewGroup, rq4 rq4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rq4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.v != null) {
                FrsViewData frsViewData = this.j;
                rq4Var.s.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            fp6.k().c(this.v, rq4Var.s);
            dp6.n(rq4Var.s, this.e, this.v, a0());
            qq4 taskInfoData = rq4Var.s.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.k.getOrignalPage() instanceof se6) {
                    se6 se6Var = (se6) this.k.getOrignalPage();
                    if (this.t.add(f)) {
                        String b2 = se6Var.b();
                        String a2 = se6Var.a();
                        String g = taskInfoData.g();
                        al8.c("frs", "VIEW_TRUE", b2, a2, g, "tieba.baidu.com/p/" + rq4Var.s.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", rq4Var.s.getFid());
                statisticItem.param("tid", rq4Var.s.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", rq4Var.s.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (rq4Var != null) {
                rq4Var.s.updateShowStatus();
                if ((rq4Var.s.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.x(w0(rq4Var.s));
                }
                autoVideoCardViewHolder.c().f().b(32);
                autoVideoCardViewHolder.g(rq4Var.s);
                autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.c().p(this.x);
                hd6.i(autoVideoCardViewHolder.c().f(), this.j);
            }
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
