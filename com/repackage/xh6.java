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
import com.repackage.cy;
import com.repackage.ny;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class xh6 extends cd6<qq4, AutoVideoCardViewHolder<ThreadData>> implements hy5, go6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> t;
    public int u;
    public eo6 v;
    public boolean w;
    public jy5<ThreadData> x;

    /* loaded from: classes7.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xh6 b;

        public a(xh6 xh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09203e) {
                    do6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e87) {
                    do6.e(threadData, 3, this.b.e, this.b.v, this.b.a0());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    do6.e(threadData, 15, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                    do6.e(threadData, 14, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e65) {
                    do6.e(threadData, 12, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7d) {
                    do6.e(threadData, 13, this.b.e, this.b.v, this.b.a0());
                } else {
                    do6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                }
            } else {
                do6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d || view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                fo6.k().h(this.b.v, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    ti8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                fo6.k().h(this.b.v, threadData, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xh6 a;

        public b(xh6 xh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xh6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((qq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((nn4) threadData, view2.getContext(), this.a.u, false);
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.v = new eo6();
        this.w = false;
        this.x = new a(this);
        this.t = new HashSet();
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.cd6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.t.clear();
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public final s68 w0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            s68 s68Var = new s68();
            if (100 == a0().tabType) {
                s68Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                s68Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            s68Var.d = this.v.c;
            s68Var.c = threadData.getTid();
            s68Var.f = threadData.mRecomSource;
            s68Var.g = threadData.mRecomReason;
            s68Var.h = threadData.mRecomWeight;
            s68Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                s68Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return s68Var;
        }
        return (s68) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: x0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.c(696);
            twVar.u(this.e);
            bVar.o(twVar);
            ix ixVar = new ix(this.k.getPageActivity());
            ixVar.B(this.w);
            bVar.n(ixVar);
            ex exVar = new ex(this.k.getPageActivity());
            exVar.y(this.w);
            exVar.x("frs");
            bVar.h(exVar);
            ey eyVar = new ey(this.k.getPageActivity());
            tn4 tn4Var = new tn4();
            if (100 == a0().tabType) {
                tn4Var.b = 25;
                eyVar.y(19);
                eyVar.D(14);
            } else {
                tn4Var.b = 2;
                eyVar.y(2);
                eyVar.D(1);
            }
            tn4Var.h = 2;
            eyVar.w(tn4Var);
            eyVar.z(this.u);
            eyVar.c(16);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
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
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: y0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.v != null) {
                FrsViewData frsViewData = this.j;
                qq4Var.s.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            fo6.k().c(this.v, qq4Var.s);
            do6.o(qq4Var.s, this.e, this.v, a0());
            oq4 taskInfoData = qq4Var.s.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.k.getOrignalPage() instanceof me6) {
                    me6 me6Var = (me6) this.k.getOrignalPage();
                    if (this.t.add(f)) {
                        String d2 = me6Var.d();
                        String c = me6Var.c();
                        String g = taskInfoData.g();
                        ti8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + qq4Var.s.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", qq4Var.s.getFid());
                statisticItem.param("tid", qq4Var.s.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", qq4Var.s.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (qq4Var != null) {
                qq4Var.s.updateShowStatus();
                if ((qq4Var.s.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.w(w0(qq4Var.s));
                }
                autoVideoCardViewHolder.c().f().c(32);
                autoVideoCardViewHolder.g(qq4Var.s);
                autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.c().p(this.x);
                bd6.i(autoVideoCardViewHolder.c().f(), this.j);
            }
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
