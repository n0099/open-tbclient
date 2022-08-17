package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.uw;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class ij6 extends ue6<ir4, ThreadCardViewHolder<ir4>> implements zz5, zp6, pl5, a06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public xp6 r;
    public int s;
    public b06<ir4> t;
    public NEGFeedBackView.b u;
    public fg<ConstrainImageLayout> v;
    public fg<TbImageView> w;

    /* loaded from: classes6.dex */
    public class a extends b06<ir4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij6 b;

        public a(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ij6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ir4 ir4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ir4Var) == null) || view2 == null || ir4Var == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, ir4Var, this.b.getType());
            }
            if ("c13010".equals(this.b.o)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", ir4Var.t.getFid()).param("tid", ir4Var.t.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092450 && view2.getId() != R.id.obfuscated_res_0x7f092422) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09213e) {
                    wp6.e(ir4Var.t, 5, this.b.mPageId, this.b.r, this.b.t());
                    hr6.g(ir4Var.t, this.b.b, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e43) {
                    wp6.e(ir4Var.t, 14, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eaa) {
                    wp6.e(ir4Var.t, 12, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec2) {
                    wp6.e(ir4Var.t, 13, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.t.a instanceof Boolean) {
                        if (((Boolean) this.b.t.a).booleanValue()) {
                            wp6.e(ir4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                        } else {
                            wp6.e(ir4Var.t, 3, this.b.mPageId, this.b.r, this.b.t());
                        }
                    }
                    hr6.g(ir4Var.t, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    wp6.e(ir4Var.t, 15, this.b.mPageId, this.b.r, this.b.t());
                    hr6.g(ir4Var.t, this.b.b, 1);
                } else {
                    wp6.e(ir4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                    hr6.g(ir4Var.t, this.b.b, 1);
                }
            } else {
                wp6.e(ir4Var.t, 2, this.b.mPageId, this.b.r, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092450 || view2.getId() == R.id.obfuscated_res_0x7f092422) {
                yp6.k().h(this.b.r, ir4Var.t, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904f3) {
                hr6.a(this.b.r, ir4Var.getRecomReason());
            } else if (view2 instanceof TbImageView) {
                if (this.b.t.a instanceof Boolean) {
                    if (((Boolean) this.b.t.a).booleanValue()) {
                        yp6.k().h(this.b.r, ir4Var.t, 1);
                    } else {
                        yp6.k().h(this.b.r, ir4Var.t, 3);
                    }
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09053c) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09212c) {
                yp6.k().h(this.b.r, ir4Var.t, 5);
            } else if (!(view2 instanceof ThreadGodReplyLayout)) {
                yp6.k().h(this.b.r, ir4Var.t, 1);
            } else {
                int i = 6;
                if (ir4Var.t.getTopAgreePost() != null && ir4Var.t.getTopAgreePost().V() != null && ir4Var.t.getTopAgreePost().V().B() != null && ir4Var.t.getTopAgreePost().V().B().size() > 0) {
                    i = ir4Var.t.getTopAgreePost().L ? 9 : 8;
                }
                yp6.k().h(this.b.r, ir4Var.t, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
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

    /* loaded from: classes6.dex */
    public class c implements gg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij6 a;

        public c(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.l.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements gg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij6 a;

        public d(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.l.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements uw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.uw.b
        public void a(fo4 fo4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, fo4Var, view2) == null) || fo4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092450) {
                fo4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092422) {
                fo4Var.objType = 4;
            } else {
                fo4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox a;
        public final /* synthetic */ ij6 b;

        public f(ij6 ij6Var, ox oxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var, oxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ij6Var;
            this.a = oxVar;
        }

        @Override // com.repackage.xm
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.x(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij6 a;

        public g(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof ir4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ir4 ir4Var = (ir4) onVar;
                ThreadData threadData = ir4Var.t;
                threadData.objType = 1;
                if (this.a.t != null) {
                    this.a.t.a(threadCardViewHolder.getView(), ir4Var);
                }
                ThreadCardUtils.jumpToPB((fo4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = false;
        this.q = true;
        this.r = new xp6();
        this.t = new a(this);
        this.u = new b(this);
        this.v = new fg<>(new c(this), 6, 0);
        this.w = new fg<>(new d(this), 12, 0);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void Y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            yp6.k().d(threadData, this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: Z */
    public ThreadCardViewHolder<ir4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.l.getPageActivity());
            uw uwVar = new uw(this.l.getPageActivity());
            uwVar.c(4280);
            uwVar.u(this.mPageId);
            uwVar.t(new e(this));
            bVar.o(uwVar);
            ox oxVar = new ox(this.l.getPageActivity());
            oxVar.u("frs");
            if (this.s == 502) {
                oxVar.w(false);
            } else {
                oxVar.w(true);
            }
            oxVar.t(this.v);
            oxVar.s(this.w);
            oxVar.v(this.q);
            bVar.n(oxVar);
            ny nyVar = new ny(this.l.getPageActivity());
            nyVar.y(this.l);
            nyVar.x(3);
            bVar.h(nyVar);
            bVar.h(new by(this.l.getPageActivity()));
            fx fxVar = new fx(this.l.getPageActivity());
            bVar.h(fxVar);
            fxVar.y(this.q);
            fxVar.x("frs");
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                oxVar.x(new f(this, oxVar));
            }
            fy fyVar = new fy(this.l.getPageActivity());
            lo4 lo4Var = new lo4();
            if (100 == t().tabType) {
                lo4Var.b = this.p ? 10 : 25;
                fyVar.y(19);
                fyVar.D(14);
            } else {
                lo4Var.b = this.p ? 10 : 2;
                fyVar.y(2);
                fyVar.D(1);
            }
            lo4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !pi.isEmpty(this.b.getForum().getId())) {
                lo4Var.j = this.b.getForum().getId();
            }
            fyVar.w(lo4Var);
            fyVar.z(3);
            fyVar.c(16);
            bVar.m(fyVar);
            bVar.l().h(qi.f(this.mContext, R.dimen.tbds28));
            dy i = bVar.i();
            i.r(3);
            ThreadCardViewHolder<ir4> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.zz5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ue6, com.repackage.bn
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ir4 ir4Var, ThreadCardViewHolder<ir4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ir4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, ir4Var, threadCardViewHolder);
            if (ir4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.n);
            te6.i(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                ir4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            boolean z = (ir4Var.t.getAuthor() == null || ir4Var.t.getAuthor().getUserId() == null || !ir4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (ir4Var.t.isSmartFrsThread() && ir4Var.t.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.o(true).u(this.u);
            }
            threadCardViewHolder.r();
            if (threadCardViewHolder.a().f() != null) {
                threadCardViewHolder.a().f().c(32);
            }
            threadCardViewHolder.e(ir4Var);
            threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.t);
            if (this.r != null) {
                FrsViewData frsViewData2 = this.b;
                ir4Var.t.statFloor = (ir4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            yp6.k().c(this.r, ir4Var.t);
            Y(ir4Var.t);
            ir4Var.t.updateShowStatus();
            wp6.o(ir4Var.t, this.mPageId, this.r, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                wp6.m(ir4Var.t, t());
                wp6.n(ir4Var.t, this.b.getForum().getId());
            }
            if (ir4Var != null) {
                ir4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : (xp6) invokeV.objValue;
    }

    @Override // com.repackage.a06
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.repackage.zz5
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.s = i;
        }
    }

    @Override // com.repackage.ue6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.repackage.ue6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }
}
