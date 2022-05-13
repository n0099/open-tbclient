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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.repackage.kz;
import com.repackage.vz;
import com.repackage.zx;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class pg6 extends pc6<br4, ThreadCardViewHolder<ThreadData>> implements sx5, jo6, ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ux5<ThreadData> A;
    public NEGFeedBackView.b B;
    public TbPageContext<?> t;
    public HashSet<String> u;
    public String v;
    public String w;
    public boolean x;
    public int y;
    public ho6 z;

    /* loaded from: classes6.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg6 b;

        public a(pg6 pg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if ("c13010".equals(this.b.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                if (view2 instanceof ThreadGodReplyLayout) {
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        go6.c(threadData, this.b.j.getForum().getId());
                    }
                    go6.e(threadData, 15, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091ff4) {
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        go6.c(threadData, this.b.j.getForum().getId());
                    }
                    go6.e(threadData, 5, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0b) {
                    go6.e(threadData, 14, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ea1) {
                    go6.e(threadData, 12, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() != R.id.obfuscated_res_0x7f090eb7) {
                    if (this.b.j != null && this.b.j.getForum() != null) {
                        go6.c(threadData, this.b.j.getForum().getId());
                    }
                    go6.e(threadData, 1, this.b.e, this.b.z, this.b.a0());
                } else {
                    go6.e(threadData, 13, this.b.e, this.b.z, this.b.a0());
                }
            } else {
                go6.e(threadData, 2, this.b.e, this.b.z, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3 || view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                io6.k().h(this.b.z, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090545) {
                io6.k().h(this.b.z, threadData, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
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

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(pg6 pg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, wp4 wp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, wp4Var) == null) || arrayList == null || wp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", wp4Var.c()).param("tid", wp4Var.f()).param("nid", wp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", wp4Var.l).param("weight", wp4Var.k).param("ab_tag", wp4Var.p).param("extra", wp4Var.m).param("card_type", wp4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, wp4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(wp4 wp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(wp4 wp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wp4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", wp4Var.c()).param("tid", wp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(pg6 pg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || zn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3) {
                zn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                zn4Var.objType = 4;
            } else {
                zn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ pg6 b;

        public d(pg6 pg6Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pg6Var;
            this.a = rzVar;
        }

        @Override // com.repackage.zx.a
        public void a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null || zn4Var.getThreadData() == null || zn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            fd5.b(3, this.b.a, zn4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes6.dex */
    public class e implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ pg6 b;

        public e(pg6 pg6Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pg6Var;
            this.a = rzVar;
        }

        @Override // com.repackage.zx.a
        public void a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null || zn4Var.getThreadData() == null || zn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            fd5.b(3, this.b.a, zn4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes6.dex */
    public class f implements wz {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ pg6 b;

        public f(pg6 pg6Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pg6Var;
            this.a = rzVar;
        }

        @Override // com.repackage.wz
        public void a(zn4 zn4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null || zn4Var.getThreadData() == null || zn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (zn4Var.getThreadData().originalThreadData.r != null) {
                z = zn4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            fd5.a(3, z, this.b.a, zn4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg6 a;

        public g(pg6 pg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pg6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof br4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((br4) roVar).s;
                threadData.objType = 1;
                if (this.a.A != null) {
                    this.a.A.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), this.a.y, false);
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pg6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.z = new ho6();
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
            io6.k().d(threadData, this.u);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: J0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.t.getPageActivity());
            rz rzVar = new rz(this.t.getPageActivity());
            cy cyVar = new cy(this.t.getPageActivity());
            cyVar.b(4280);
            cyVar.t(this.e);
            cyVar.s(new c(this));
            bVar.o(cyVar);
            fz fzVar = new fz(this.t);
            fzVar.n(Boolean.FALSE);
            fzVar.v("frs");
            if (this.y == 502) {
                fzVar.x(false);
            } else {
                fzVar.x(true);
            }
            bVar.l().h(mi.f(this.a, R.dimen.tbds38));
            bVar.n(fzVar);
            fz fzVar2 = new fz(this.t);
            fzVar2.n(Boolean.TRUE);
            fzVar2.v("frs");
            if (this.y == 502) {
                fzVar2.x(false);
            } else {
                fzVar2.x(true);
            }
            fzVar2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.h(fzVar2);
            fzVar2.w(new d(this, rzVar));
            rzVar.n(Boolean.TRUE);
            rzVar.w("frs");
            rzVar.x(new e(this, rzVar));
            rzVar.y(new f(this, rzVar));
            bVar.h(rzVar);
            my myVar = new my(this.t.getPageActivity());
            myVar.x(this.x);
            myVar.w("frs");
            bVar.h(myVar);
            mz mzVar = new mz(this.t.getPageActivity());
            fo4 fo4Var = new fo4();
            if (100 == a0().tabType) {
                fo4Var.b = 25;
                mzVar.x(19);
            } else {
                fo4Var.b = 2;
                mzVar.x(2);
            }
            fo4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !li.isEmpty(this.j.getForum().getId())) {
                fo4Var.j = this.j.getForum().getId();
            }
            mzVar.v(fo4Var);
            mzVar.C(3);
            mzVar.y(2);
            mzVar.b(16);
            if (UbsABTestHelper.isShowLikeAnimation()) {
                mzVar.F();
            }
            bVar.m(mzVar);
            kz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
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
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: K0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, threadCardViewHolder})) == null) {
            if (br4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.v);
            }
            threadCardViewHolder.c().q(i);
            super.S(i, view2, viewGroup, br4Var, threadCardViewHolder);
            oc6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                br4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            boolean z = (br4Var.s.getAuthor() == null || br4Var.s.getAuthor().getUserId() == null || !br4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (br4Var.s.isSmartFrsThread() && br4Var.s.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.r(true).u(this.B);
            }
            threadCardViewHolder.u();
            if (threadCardViewHolder.c().f() != null) {
                threadCardViewHolder.c().f().b(32);
            }
            threadCardViewHolder.g(br4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.A);
            if (this.z != null) {
                FrsViewData frsViewData2 = this.j;
                br4Var.s.statFloor = (br4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            io6.k().c(this.z, br4Var.s);
            I0(br4Var.s);
            br4Var.s.updateShowStatus();
            go6.n(br4Var.s, this.e, this.z, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                go6.l(br4Var.s, a0());
                go6.m(br4Var.s, this.j.getForum().getId());
            }
            ThreadData threadData = br4Var.s;
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

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.v = str;
        }
    }

    @Override // com.repackage.jo6
    public ho6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.y = i;
        }
    }

    @Override // com.repackage.pc6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    @Override // com.repackage.pc6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }
}
