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
import com.repackage.dy;
import com.repackage.oy;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class qj6 extends ue6<ir4, AutoVideoCardViewHolder<ThreadData>> implements zz5, zp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public xp6 n;
    public boolean o;
    public b06<ThreadData> p;

    /* loaded from: classes7.dex */
    public class a extends b06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 b;

        public a(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092450 && view2.getId() != R.id.obfuscated_res_0x7f092422) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09213e) {
                    wp6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ecc) {
                    wp6.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    wp6.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e43) {
                    wp6.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eaa) {
                    wp6.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec2) {
                    wp6.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                } else {
                    wp6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                }
            } else {
                wp6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092450 || view2.getId() == R.id.obfuscated_res_0x7f092422) {
                yp6.k().h(this.b.n, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    gl8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                yp6.k().h(this.b.n, threadData, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public b(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof ir4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((ir4) onVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fo4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.m = 3;
        this.n = new xp6();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    public final y88 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            y88 y88Var = new y88();
            if (100 == t().tabType) {
                y88Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                y88Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            y88Var.d = this.n.c;
            y88Var.c = threadData.getTid();
            y88Var.f = threadData.mRecomSource;
            y88Var.g = threadData.mRecomReason;
            y88Var.h = threadData.mRecomWeight;
            y88Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                y88Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return y88Var;
        }
        return (y88) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: R */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.c.getPageActivity());
            uw uwVar = new uw(this.c.getPageActivity());
            uwVar.c(696);
            uwVar.u(this.mPageId);
            bVar.o(uwVar);
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.B(this.o);
            bVar.n(jxVar);
            fx fxVar = new fx(this.c.getPageActivity());
            fxVar.y(this.o);
            fxVar.x("frs");
            bVar.h(fxVar);
            fy fyVar = new fy(this.c.getPageActivity());
            lo4 lo4Var = new lo4();
            if (100 == t().tabType) {
                lo4Var.b = 25;
                fyVar.y(19);
                fyVar.D(14);
            } else {
                lo4Var.b = 2;
                fyVar.y(2);
                fyVar.D(1);
            }
            lo4Var.h = 2;
            fyVar.w(lo4Var);
            fyVar.z(this.m);
            fyVar.c(16);
            bVar.m(fyVar);
            dy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.p(this.p);
            k.r(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ue6, com.repackage.bn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ir4 ir4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ir4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.n != null) {
                FrsViewData frsViewData = this.b;
                ir4Var.t.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            yp6.k().c(this.n, ir4Var.t);
            wp6.o(ir4Var.t, this.mPageId, this.n, t());
            gr4 taskInfoData = ir4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof eg6) {
                    eg6 eg6Var = (eg6) this.c.getOrignalPage();
                    if (this.l.add(f)) {
                        String d2 = eg6Var.d();
                        String c = eg6Var.c();
                        String g = taskInfoData.g();
                        gl8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + ir4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", ir4Var.t.getFid());
                statisticItem.param("tid", ir4Var.t.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", ir4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (ir4Var != null) {
                ir4Var.t.updateShowStatus();
                if ((ir4Var.t.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.u(Q(ir4Var.t));
                }
                autoVideoCardViewHolder.a().f().c(32);
                autoVideoCardViewHolder.e(ir4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().p(this.p);
                te6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.zz5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.repackage.zp6
    public xp6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (xp6) invokeV.objValue;
    }

    @Override // com.repackage.zz5
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.repackage.ue6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.repackage.ue6
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.v();
            this.l.clear();
        }
    }
}
