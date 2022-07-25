package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
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
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class fh6 extends cd6<rq4, ThreadCardViewHolder<ThreadData>> implements hy5, go6, ck5, iy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public String u;
    public String v;
    public int w;
    public int x;
    public jy5<ThreadData> y;
    public NEGFeedBackView.b z;

    /* loaded from: classes6.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh6 b;

        public a(fh6 fh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.q != null) {
                this.b.q.b(view2, threadData, this.b.getType());
            }
            if ("c13010".equals(this.b.u)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09232f && view2.getId() != R.id.obfuscated_res_0x7f09230e) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092042) {
                    do6.e(threadData, 5, this.b.e, go6.p0, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d57) {
                    do6.e(threadData, 14, this.b.e, go6.p0, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e5e) {
                    do6.e(threadData, 12, this.b.e, go6.p0, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e76) {
                    do6.e(threadData, 13, this.b.e, go6.p0, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.y.a instanceof Boolean) {
                        if (((Boolean) this.b.y.a).booleanValue()) {
                            do6.e(threadData, 1, this.b.e, go6.p0, this.b.a0());
                        } else {
                            do6.e(threadData, 3, this.b.e, go6.p0, this.b.a0());
                        }
                    }
                    pp6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    do6.e(threadData, 15, this.b.e, go6.p0, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else {
                    do6.e(threadData, 1, this.b.e, go6.p0, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                }
            } else {
                do6.e(threadData, 2, this.b.e, go6.p0, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09202e && threadData.isVideoThreadType()) {
                this.b.G0(threadData);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09232f && view2.getId() != R.id.obfuscated_res_0x7f09230e) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0904d8) {
                    pp6.a(go6.p0, threadData.getRecomReason());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.y.a instanceof Boolean) {
                        if (((Boolean) this.b.y.a).booleanValue()) {
                            fo6.k().h(go6.p0, threadData, 1);
                        } else {
                            fo6.k().h(go6.p0, threadData, 3);
                        }
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090521) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092030) {
                    fo6.k().h(go6.p0, threadData, 5);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().Q() != null && threadData.getTopAgreePost().Q().C() != null && threadData.getTopAgreePost().Q().C().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    fo6.k().h(go6.p0, threadData, i);
                } else {
                    fo6.k().h(go6.p0, threadData, 1);
                }
            } else {
                fo6.k().h(go6.p0, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh6 a;

        public b(fh6 fh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof rq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((rq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.a(), threadData);
                }
                ThreadCardUtils.jumpToPB((on4) threadData, view2.getContext(), this.a.w, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.b().o(new ny.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public c(fh6 fh6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh6Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(fh6 fh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lp4Var) == null) || arrayList == null || lp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("nid", lp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", lp4Var.l).param("weight", lp4Var.k).param("ab_tag", lp4Var.p).param("extra", lp4Var.m).param("card_type", lp4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, lp4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lp4 lp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lp4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.t = false;
        this.w = 3;
        this.x = 13;
        this.y = new a(this);
        this.z = new d(this);
        this.k = tbPageContext;
        this.e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: E0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity(), false);
            ey eyVar = new ey(this.k.getPageActivity(), false);
            un4 un4Var = new un4();
            if (100 == a0().tabType) {
                un4Var.b = this.t ? 10 : 25;
                eyVar.y(19);
                eyVar.D(14);
            } else {
                un4Var.b = this.t ? 10 : 2;
                if ("a070".equals(a0().locatePage)) {
                    eyVar.y(13);
                } else {
                    eyVar.y(2);
                }
                if (TbSingleton.getInstance().getFrsCurTabType() == this.x) {
                    eyVar.D(15);
                } else {
                    eyVar.D(1);
                }
            }
            un4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !oi.isEmpty(this.j.getForum().getId())) {
                un4Var.j = this.j.getForum().getId();
            }
            eyVar.w(un4Var);
            eyVar.E("frs_page");
            eyVar.z(3);
            eyVar.c(48);
            eyVar.G();
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.e);
            threadCardViewHolder.o(true);
            threadCardViewHolder.h(4, bVar.l());
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: F0 */
    public View S(int i, View view2, ViewGroup viewGroup, rq4 rq4Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rq4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, rq4Var, threadCardViewHolder);
            if (rq4Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            threadCardViewHolder.b().b(this.v);
            threadCardViewHolder.b().q(i);
            bd6.i(threadCardViewHolder.b().f(), this.j);
            if (rq4Var.s.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                threadCardViewHolder.b().f().c(128);
            } else {
                threadCardViewHolder.b().f().d(128);
            }
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.q(false, Align.ALIGN_RIGHT_BOTTOM, this.z);
            if (threadCardViewHolder.b().f() instanceof ey) {
                ((ey) threadCardViewHolder.b().f()).C(new c(this, viewGroup, view2, i));
            }
            threadCardViewHolder.f(rq4Var.s);
            threadCardViewHolder.b().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.y);
            rq4Var.s.updateShowStatus();
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void G0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.v = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? go6.p0 : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.iy5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.t = z;
        }
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.u = str;
        }
    }
}
