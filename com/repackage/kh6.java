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
import com.repackage.kz;
import com.repackage.vz;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class kh6 extends pc6<ThreadData, AutoVideoCardViewHolder<ThreadData>> implements sx5, jo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> t;
    public int u;
    public ho6 v;
    public boolean w;
    public ux5<ThreadData> x;

    /* loaded from: classes6.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh6 b;

        public a(kh6 kh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091ff4) {
                    go6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec1) {
                    go6.e(threadData, 3, this.b.e, this.b.v, this.b.a0());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    go6.e(threadData, 15, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0b) {
                    go6.e(threadData, 14, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ea1) {
                    go6.e(threadData, 12, this.b.e, this.b.v, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eb7) {
                    go6.e(threadData, 13, this.b.e, this.b.v, this.b.a0());
                } else {
                    go6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                }
            } else {
                go6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3 || view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                io6.k().h(this.b.v, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    ek8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                io6.k().h(this.b.v, threadData, 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh6 a;

        public b(kh6 kh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = (ThreadData) roVar;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), this.a.u, false);
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.v = new ho6();
        this.w = false;
        this.x = new a(this);
        this.t = new HashSet();
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.pc6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.t.clear();
        }
    }

    @Override // com.repackage.jo6
    public ho6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.repackage.pc6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public final m78 w0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            m78 m78Var = new m78();
            if (100 == a0().tabType) {
                m78Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                m78Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            m78Var.d = this.v.c;
            m78Var.c = threadData.getTid();
            m78Var.f = threadData.mRecomSource;
            m78Var.g = threadData.mRecomReason;
            m78Var.h = threadData.mRecomWeight;
            m78Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                m78Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return m78Var;
        }
        return (m78) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: x0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.k.getPageActivity());
            cy cyVar = new cy(this.k.getPageActivity());
            cyVar.b(696);
            cyVar.t(this.e);
            bVar.o(cyVar);
            qy qyVar = new qy(this.k.getPageActivity());
            qyVar.A(this.w);
            bVar.n(qyVar);
            my myVar = new my(this.k.getPageActivity());
            myVar.x(this.w);
            myVar.w("frs");
            bVar.h(myVar);
            mz mzVar = new mz(this.k.getPageActivity());
            fo4 fo4Var = new fo4();
            if (100 == a0().tabType) {
                fo4Var.b = 25;
                mzVar.x(19);
                mzVar.C(14);
            } else {
                fo4Var.b = 2;
                mzVar.x(2);
                mzVar.C(1);
            }
            fo4Var.h = 2;
            mzVar.v(fo4Var);
            mzVar.y(this.u);
            mzVar.b(16);
            bVar.m(mzVar);
            kz i = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
            autoVideoCardViewHolder.k(this.e);
            i.p(this.x);
            i.r(this.u);
            V(new b(this));
            autoVideoCardViewHolder.o();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: y0 */
    public View S(int i, View view2, ViewGroup viewGroup, ThreadData threadData, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.v != null) {
                FrsViewData frsViewData = this.j;
                threadData.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            io6.k().c(this.v, threadData);
            go6.n(threadData, this.e, this.v, a0());
            ar4 taskInfoData = threadData.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.k.getOrignalPage() instanceof zd6) {
                    zd6 zd6Var = (zd6) this.k.getOrignalPage();
                    if (this.t.add(f)) {
                        String b2 = zd6Var.b();
                        String a2 = zd6Var.a();
                        String g = taskInfoData.g();
                        ek8.c("frs", "VIEW_TRUE", b2, a2, g, "tieba.baidu.com/p/" + threadData.getTid(), str);
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
                    autoVideoCardViewHolder.x(w0(threadData));
                }
                autoVideoCardViewHolder.c().f().b(32);
                autoVideoCardViewHolder.g(threadData);
                autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.c().p(this.x);
                oc6.i(autoVideoCardViewHolder.c().f(), this.j);
            }
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
