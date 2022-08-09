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
public class rj6 extends ue6<ThreadData, AutoVideoCardViewHolder<ThreadData>> implements zz5, zp6 {
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
        public final /* synthetic */ rj6 b;

        public a(rj6 rj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09244f && view2.getId() != R.id.obfuscated_res_0x7f092421) {
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
            if (view2.getId() == R.id.obfuscated_res_0x7f09244f || view2.getId() == R.id.obfuscated_res_0x7f092421) {
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
                    hl8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
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
        public final /* synthetic */ rj6 a;

        public b(rj6 rj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = (ThreadData) onVar;
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
    public rj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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

    public final z88 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            z88 z88Var = new z88();
            if (100 == t().tabType) {
                z88Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                z88Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            z88Var.d = this.n.c;
            z88Var.c = threadData.getTid();
            z88Var.f = threadData.mRecomSource;
            z88Var.g = threadData.mRecomReason;
            z88Var.h = threadData.mRecomWeight;
            z88Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                z88Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return z88Var;
        }
        return (z88) invokeL.objValue;
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
            dy i = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
            autoVideoCardViewHolder.i(this.mPageId);
            i.p(this.p);
            i.r(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ue6, com.repackage.bn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.n != null) {
                FrsViewData frsViewData = this.b;
                threadData.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            yp6.k().c(this.n, threadData);
            wp6.o(threadData, this.mPageId, this.n, t());
            gr4 taskInfoData = threadData.getTaskInfoData();
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
                        hl8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + threadData.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", threadData.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (threadData != null) {
                threadData.updateShowStatus();
                if ((threadData.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.u(Q(threadData));
                }
                autoVideoCardViewHolder.a().f().c(32);
                autoVideoCardViewHolder.e(threadData);
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
