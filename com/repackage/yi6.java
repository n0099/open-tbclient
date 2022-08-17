package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
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
import com.repackage.dy;
import com.repackage.oy;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class yi6 extends ue6<ir4, ThreadCardViewHolder<ThreadData>> implements zz5, zp6, pl5, a06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public int p;
    public b06<ThreadData> q;
    public NEGFeedBackView.b r;

    /* loaded from: classes7.dex */
    public class a extends b06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi6 b;

        public a(yi6 yi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, threadData, this.b.getType());
            }
            if ("c13010".equals(this.b.m)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092450 && view2.getId() != R.id.obfuscated_res_0x7f092422) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09213e) {
                    wp6.e(threadData, 5, this.b.mPageId, zp6.p0, this.b.t());
                    hr6.g(threadData, this.b.b, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e43) {
                    wp6.e(threadData, 14, this.b.mPageId, zp6.p0, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eaa) {
                    wp6.e(threadData, 12, this.b.mPageId, zp6.p0, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec2) {
                    wp6.e(threadData, 13, this.b.mPageId, zp6.p0, this.b.t());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.q.a instanceof Boolean) {
                        if (((Boolean) this.b.q.a).booleanValue()) {
                            wp6.e(threadData, 1, this.b.mPageId, zp6.p0, this.b.t());
                        } else {
                            wp6.e(threadData, 3, this.b.mPageId, zp6.p0, this.b.t());
                        }
                    }
                    hr6.g(threadData, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    wp6.e(threadData, 15, this.b.mPageId, zp6.p0, this.b.t());
                    hr6.g(threadData, this.b.b, 1);
                } else {
                    wp6.e(threadData, 1, this.b.mPageId, zp6.p0, this.b.t());
                    hr6.g(threadData, this.b.b, 1);
                }
            } else {
                wp6.e(threadData, 2, this.b.mPageId, zp6.p0, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09212a && threadData.isVideoThreadType()) {
                this.b.a0(threadData);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f092450 && view2.getId() != R.id.obfuscated_res_0x7f092422) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0904f3) {
                    hr6.a(zp6.p0, threadData.getRecomReason());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.q.a instanceof Boolean) {
                        if (((Boolean) this.b.q.a).booleanValue()) {
                            yp6.k().h(zp6.p0, threadData, 1);
                        } else {
                            yp6.k().h(zp6.p0, threadData, 3);
                        }
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09053c) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09212c) {
                    yp6.k().h(zp6.p0, threadData, 5);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().V() != null && threadData.getTopAgreePost().V().B() != null && threadData.getTopAgreePost().V().B().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    yp6.k().h(zp6.p0, threadData, i);
                } else {
                    yp6.k().h(zp6.p0, threadData, 1);
                }
            } else {
                yp6.k().h(zp6.p0, threadData, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi6 a;

        public b(yi6 yi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof ir4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((ir4) onVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fo4) threadData, view2.getContext(), this.a.o, false, vw.a((un) viewGroup, view2, i));
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public c(yi6 yi6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(vw.a((un) this.a, this.b, this.c));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(yi6 yi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, cq4 cq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, cq4Var) == null) || arrayList == null || cq4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", cq4Var.c()).param("tid", cq4Var.f()).param("nid", cq4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", cq4Var.l).param("weight", cq4Var.k).param("ab_tag", cq4Var.p).param("extra", cq4Var.m).param("card_type", cq4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, cq4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(cq4 cq4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cq4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(cq4 cq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", cq4Var.c()).param("tid", cq4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yi6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.l = false;
        this.o = 3;
        this.p = 13;
        this.q = new a(this);
        this.r = new d(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: Y */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.c.getPageActivity(), false);
            fy fyVar = new fy(this.c.getPageActivity(), false);
            lo4 lo4Var = new lo4();
            if (100 == t().tabType) {
                lo4Var.b = this.l ? 10 : 25;
                fyVar.y(19);
                fyVar.D(14);
            } else {
                lo4Var.b = this.l ? 10 : 2;
                if ("a070".equals(t().locatePage)) {
                    fyVar.y(13);
                } else {
                    fyVar.y(2);
                }
                if (TbSingleton.getInstance().getFrsCurTabType() == this.p) {
                    fyVar.D(15);
                } else {
                    fyVar.D(1);
                }
            }
            lo4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !pi.isEmpty(this.b.getForum().getId())) {
                lo4Var.j = this.b.getForum().getId();
            }
            fyVar.w(lo4Var);
            fyVar.E("frs_page");
            fyVar.z(3);
            fyVar.c(48);
            fyVar.G();
            bVar.m(fyVar);
            dy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            threadCardViewHolder.n(true);
            threadCardViewHolder.g(4, bVar.l());
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ue6, com.repackage.bn
    /* renamed from: Z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ir4 ir4Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ir4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, ir4Var, threadCardViewHolder);
            if (ir4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.n);
            threadCardViewHolder.a().q(i);
            te6.i(threadCardViewHolder.a().f(), this.b);
            if (ir4Var.t.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                threadCardViewHolder.a().f().c(128);
            } else {
                threadCardViewHolder.a().f().d(128);
            }
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                ir4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.p(false, Align.ALIGN_RIGHT_BOTTOM, this.r);
            if (threadCardViewHolder.a().f() instanceof fy) {
                ((fy) threadCardViewHolder.a().f()).C(new c(this, viewGroup, view2, i));
            }
            threadCardViewHolder.e(ir4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.q);
            ir4Var.t.updateShowStatus();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.zz5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public final void a0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", u() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.repackage.zp6
    public xp6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? zp6.p0 : (xp6) invokeV.objValue;
    }

    @Override // com.repackage.a06
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    @Override // com.repackage.zz5
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.repackage.ue6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.m = str;
        }
    }
}
