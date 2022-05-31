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
import com.repackage.iy;
import com.repackage.xx;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class ag6 extends fb6<rp4, AutoVideoCardViewHolder<ThreadData>> implements lw5, pm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> t;
    public int u;
    public nm6 v;
    public boolean w;
    public nw5<ThreadData> x;

    /* loaded from: classes5.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag6 b;

        public a(ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ag6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092298 && view2.getId() != R.id.obfuscated_res_0x7f092278) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    mm6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e86) {
                    mm6.e(threadData, 3, this.b.e, this.b.v, this.b.a0());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mm6.e(threadData, 15, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb6) {
                    mm6.e(threadData, 14, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e66) {
                    mm6.e(threadData, 12, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7c) {
                    mm6.e(threadData, 13, this.b.e, this.b.v, this.b.a0());
                } else {
                    mm6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                }
            } else {
                mm6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298 || view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om6.k().h(this.b.v, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    fh8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                om6.k().h(this.b.v, threadData, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag6 a;

        public b(ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((rp4) jnVar).s;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((om4) threadData, view2.getContext(), this.a.u, false);
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.v = new nm6();
        this.w = false;
        this.x = new a(this);
        this.t = new HashSet();
    }

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.fb6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.t.clear();
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public final t48 w0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            t48 t48Var = new t48();
            if (100 == a0().tabType) {
                t48Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                t48Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            t48Var.d = this.v.c;
            t48Var.c = threadData.getTid();
            t48Var.f = threadData.mRecomSource;
            t48Var.g = threadData.mRecomReason;
            t48Var.h = threadData.mRecomWeight;
            t48Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                t48Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return t48Var;
        }
        return (t48) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: x0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity());
            pw pwVar = new pw(this.k.getPageActivity());
            pwVar.b(696);
            pwVar.t(this.e);
            bVar.o(pwVar);
            dx dxVar = new dx(this.k.getPageActivity());
            dxVar.A(this.w);
            bVar.n(dxVar);
            zw zwVar = new zw(this.k.getPageActivity());
            zwVar.x(this.w);
            zwVar.w("frs");
            bVar.h(zwVar);
            zx zxVar = new zx(this.k.getPageActivity());
            um4 um4Var = new um4();
            if (100 == a0().tabType) {
                um4Var.b = 25;
                zxVar.x(19);
                zxVar.C(14);
            } else {
                um4Var.b = 2;
                zxVar.x(2);
                zxVar.C(1);
            }
            um4Var.h = 2;
            zxVar.v(um4Var);
            zxVar.y(this.u);
            zxVar.b(16);
            bVar.m(zxVar);
            xx k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
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
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: y0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.v != null) {
                FrsViewData frsViewData = this.j;
                rp4Var.s.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            om6.k().c(this.v, rp4Var.s);
            mm6.o(rp4Var.s, this.e, this.v, a0());
            pp4 taskInfoData = rp4Var.s.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.k.getOrignalPage() instanceof pc6) {
                    pc6 pc6Var = (pc6) this.k.getOrignalPage();
                    if (this.t.add(f)) {
                        String b2 = pc6Var.b();
                        String a2 = pc6Var.a();
                        String g = taskInfoData.g();
                        fh8.c("frs", "VIEW_TRUE", b2, a2, g, "tieba.baidu.com/p/" + rp4Var.s.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", rp4Var.s.getFid());
                statisticItem.param("tid", rp4Var.s.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", rp4Var.s.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (rp4Var != null) {
                rp4Var.s.updateShowStatus();
                if ((rp4Var.s.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.x(w0(rp4Var.s));
                }
                autoVideoCardViewHolder.c().f().b(32);
                autoVideoCardViewHolder.g(rp4Var.s);
                autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.c().p(this.x);
                eb6.i(autoVideoCardViewHolder.c().f(), this.j);
            }
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
