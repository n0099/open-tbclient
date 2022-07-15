package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
import com.repackage.tw;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class dh6 extends cd6<qq4, ThreadCardViewHolder<ThreadData>> implements hy5, go6, ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jy5<ThreadData> A;
    public NEGFeedBackView.b B;
    public TbPageContext<?> t;
    public HashSet<String> u;
    public String v;
    public String w;
    public boolean x;
    public int y;
    public eo6 z;

    /* loaded from: classes5.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 b;

        public a(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if ("c13010".equals(this.b.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                if (view2 instanceof ThreadGodReplyLayout) {
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        do6.c(threadData, this.b.j.getForum().getId());
                    }
                    do6.e(threadData, 15, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09203e) {
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        do6.c(threadData, this.b.j.getForum().getId());
                    }
                    do6.e(threadData, 5, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                    do6.e(threadData, 14, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e65) {
                    do6.e(threadData, 12, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() != R.id.obfuscated_res_0x7f090e7d) {
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        do6.c(threadData, this.b.j.getForum().getId());
                    }
                    do6.e(threadData, 1, this.b.e, this.b.z, this.b.a0());
                } else {
                    do6.e(threadData, 13, this.b.e, this.b.z, this.b.a0());
                }
            } else {
                do6.e(threadData, 2, this.b.e, this.b.z, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d || view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                fo6.k().h(this.b.z, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090521) {
                fo6.k().h(this.b.z, threadData, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                if (view2 instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", threadData.getTid());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", threadData.getTid());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, kp4Var) == null) || arrayList == null || kp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", kp4Var.c()).param("tid", kp4Var.f()).param("nid", kp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", kp4Var.l).param("weight", kp4Var.k).param("ab_tag", kp4Var.p).param("extra", kp4Var.m).param("card_type", kp4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, kp4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(kp4 kp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", kp4Var.c()).param("tid", kp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tw.b
        public void a(nn4 nn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, nn4Var, view2) == null) || nn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d) {
                nn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                nn4Var.objType = 4;
            } else {
                nn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ dh6 b;

        public d(dh6 dh6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            pd5.b(3, this.b.a, nn4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes5.dex */
    public class e implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ dh6 b;

        public e(dh6 dh6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            pd5.b(3, this.b.a, nn4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes5.dex */
    public class f implements oy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ dh6 b;

        public f(dh6 dh6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.oy
        public void a(nn4 nn4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (nn4Var.getThreadData().originalThreadData.r != null) {
                z = nn4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            pd5.a(3, z, this.b.a, nn4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes5.dex */
    public class g implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public g(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((qq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.A != null) {
                    this.a.A.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((nn4) threadData, view2.getContext(), this.a.y, false);
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = true;
        this.y = 3;
        this.z = new eo6();
        this.A = new a(this);
        this.B = new b(this);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    public final void I0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.u == null) {
                this.u = new HashSet<>();
            }
            fo6.k().d(threadData, this.u);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: J0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.t.getPageActivity());
            jy jyVar = new jy(this.t.getPageActivity());
            tw twVar = new tw(this.t.getPageActivity());
            twVar.c(4280);
            twVar.u(this.e);
            twVar.t(new c(this));
            bVar.o(twVar);
            xx xxVar = new xx(this.t);
            xxVar.o(Boolean.FALSE);
            xxVar.w("frs");
            if (this.y == 502) {
                xxVar.y(false);
            } else {
                xxVar.y(true);
            }
            bVar.l().h(pi.f(this.a, R.dimen.tbds38));
            bVar.n(xxVar);
            xx xxVar2 = new xx(this.t);
            xxVar2.o(Boolean.TRUE);
            xxVar2.w("frs");
            if (this.y == 502) {
                xxVar2.y(false);
            } else {
                xxVar2.y(true);
            }
            xxVar2.z(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.h(xxVar2);
            xxVar2.x(new d(this, jyVar));
            jyVar.o(Boolean.TRUE);
            jyVar.x("frs");
            jyVar.y(new e(this, jyVar));
            jyVar.z(new f(this, jyVar));
            bVar.h(jyVar);
            ex exVar = new ex(this.t.getPageActivity());
            exVar.y(this.x);
            exVar.x("frs");
            bVar.h(exVar);
            ey eyVar = new ey(this.t.getPageActivity());
            tn4 tn4Var = new tn4();
            if (100 == a0().tabType) {
                tn4Var.b = 25;
                eyVar.y(19);
            } else {
                tn4Var.b = 2;
                eyVar.y(2);
            }
            tn4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !oi.isEmpty(this.j.getForum().getId())) {
                tn4Var.j = this.j.getForum().getId();
            }
            eyVar.w(tn4Var);
            eyVar.D(3);
            eyVar.z(2);
            eyVar.c(16);
            eyVar.G();
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(new g(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: K0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, threadCardViewHolder})) == null) {
            if (qq4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.v);
            }
            threadCardViewHolder.c().q(i);
            super.S(i, view2, viewGroup, qq4Var, threadCardViewHolder);
            bd6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                qq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            boolean z = (qq4Var.s.getAuthor() == null || qq4Var.s.getAuthor().getUserId() == null || !qq4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (qq4Var.s.isSmartFrsThread() && qq4Var.s.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.q(true).u(this.B);
            }
            threadCardViewHolder.t();
            if (threadCardViewHolder.c().f() != null) {
                threadCardViewHolder.c().f().c(32);
            }
            threadCardViewHolder.g(qq4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.A);
            if (this.z != null) {
                FrsViewData frsViewData2 = this.j;
                qq4Var.s.statFloor = (qq4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            fo6.k().c(this.z, qq4Var.s);
            I0(qq4Var.s);
            qq4Var.s.updateShowStatus();
            do6.o(qq4Var.s, this.e, this.z, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                do6.m(qq4Var.s, a0());
                do6.n(qq4Var.s, this.j.getForum().getId());
            }
            ThreadData threadData = qq4Var.s;
            if (threadData != null) {
                threadData.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.v = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.y = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    @Override // com.repackage.cd6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }
}
