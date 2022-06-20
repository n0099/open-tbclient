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
import com.repackage.by;
import com.repackage.my;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class ah6 extends fc6<bq4, AutoVideoCardViewHolder<ThreadData>> implements kx5, sn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> t;
    public int u;
    public qn6 v;
    public boolean w;
    public mx5<ThreadData> x;

    /* loaded from: classes5.dex */
    public class a extends mx5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah6 b;

        public a(ah6 ah6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092285 && view2.getId() != R.id.obfuscated_res_0x7f092266) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    pn6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e78) {
                    pn6.e(threadData, 3, this.b.e, this.b.v, this.b.a0());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    pn6.e(threadData, 15, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cad) {
                    pn6.e(threadData, 14, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e57) {
                    pn6.e(threadData, 12, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e6e) {
                    pn6.e(threadData, 13, this.b.e, this.b.v, this.b.a0());
                } else {
                    pn6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                }
            } else {
                pn6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092285 || view2.getId() == R.id.obfuscated_res_0x7f092266) {
                rn6.k().h(this.b.v, threadData, 2);
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
                    xh8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                rn6.k().h(this.b.v, threadData, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah6 a;

        public b(ah6 ah6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof bq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((bq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((ym4) threadData, view2.getContext(), this.a.u, false);
                threadCardViewHolder.c().o(new my.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.v = new qn6();
        this.w = false;
        this.x = new a(this);
        this.t = new HashSet();
    }

    @Override // com.repackage.kx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.fc6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.t.clear();
        }
    }

    @Override // com.repackage.sn6
    public qn6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (qn6) invokeV.objValue;
    }

    @Override // com.repackage.kx5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.repackage.fc6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public final x58 w0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            x58 x58Var = new x58();
            if (100 == a0().tabType) {
                x58Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                x58Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            x58Var.d = this.v.c;
            x58Var.c = threadData.getTid();
            x58Var.f = threadData.mRecomSource;
            x58Var.g = threadData.mRecomReason;
            x58Var.h = threadData.mRecomWeight;
            x58Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                x58Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return x58Var;
        }
        return (x58) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: x0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            by.b bVar = new by.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.b(696);
            twVar.t(this.e);
            bVar.o(twVar);
            hx hxVar = new hx(this.k.getPageActivity());
            hxVar.A(this.w);
            bVar.n(hxVar);
            dx dxVar = new dx(this.k.getPageActivity());
            dxVar.x(this.w);
            dxVar.w("frs");
            bVar.h(dxVar);
            dy dyVar = new dy(this.k.getPageActivity());
            en4 en4Var = new en4();
            if (100 == a0().tabType) {
                en4Var.b = 25;
                dyVar.x(19);
                dyVar.C(14);
            } else {
                en4Var.b = 2;
                dyVar.x(2);
                dyVar.C(1);
            }
            en4Var.h = 2;
            dyVar.v(en4Var);
            dyVar.y(this.u);
            dyVar.b(16);
            bVar.m(dyVar);
            by k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
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
    @Override // com.repackage.fc6, com.repackage.an
    /* renamed from: y0 */
    public View S(int i, View view2, ViewGroup viewGroup, bq4 bq4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bq4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.v != null) {
                FrsViewData frsViewData = this.j;
                bq4Var.s.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            rn6.k().c(this.v, bq4Var.s);
            pn6.o(bq4Var.s, this.e, this.v, a0());
            zp4 taskInfoData = bq4Var.s.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.k.getOrignalPage() instanceof pd6) {
                    pd6 pd6Var = (pd6) this.k.getOrignalPage();
                    if (this.t.add(f)) {
                        String d2 = pd6Var.d();
                        String c = pd6Var.c();
                        String g = taskInfoData.g();
                        xh8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + bq4Var.s.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", bq4Var.s.getFid());
                statisticItem.param("tid", bq4Var.s.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", bq4Var.s.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (bq4Var != null) {
                bq4Var.s.updateShowStatus();
                if ((bq4Var.s.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.w(w0(bq4Var.s));
                }
                autoVideoCardViewHolder.c().f().b(32);
                autoVideoCardViewHolder.g(bq4Var.s);
                autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.c().p(this.x);
                ec6.i(autoVideoCardViewHolder.c().f(), this.j);
            }
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
