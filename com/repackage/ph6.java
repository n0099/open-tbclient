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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.tw;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class ph6 extends cd6<rq4, ThreadCardViewHolder<rq4>> implements hy5, go6, ck5, iy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public jy5<rq4> B;
    public NEGFeedBackView.b C;
    public eg<ConstrainImageLayout> D;
    public eg<TbImageView> E;
    public TbPageContext<?> t;
    public HashSet<String> u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public eo6 z;

    /* loaded from: classes6.dex */
    public class a extends jy5<rq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ph6 b;

        public a(ph6 ph6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, rq4 rq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rq4Var) == null) || view2 == null || rq4Var == null) {
                return;
            }
            if (this.b.q != null) {
                this.b.q.b(view2, rq4Var, this.b.getType());
            }
            if ("c13010".equals(this.b.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", rq4Var.s.getFid()).param("tid", rq4Var.s.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09232f && view2.getId() != R.id.obfuscated_res_0x7f09230e) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092042) {
                    do6.e(rq4Var.s, 5, this.b.e, this.b.z, this.b.a0());
                    pp6.g(rq4Var.s, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d57) {
                    do6.e(rq4Var.s, 14, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e5e) {
                    do6.e(rq4Var.s, 12, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e76) {
                    do6.e(rq4Var.s, 13, this.b.e, this.b.z, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.B.a instanceof Boolean) {
                        if (((Boolean) this.b.B.a).booleanValue()) {
                            do6.e(rq4Var.s, 1, this.b.e, this.b.z, this.b.a0());
                        } else {
                            do6.e(rq4Var.s, 3, this.b.e, this.b.z, this.b.a0());
                        }
                    }
                    pp6.g(rq4Var.s, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    do6.e(rq4Var.s, 15, this.b.e, this.b.z, this.b.a0());
                    pp6.g(rq4Var.s, this.b.j, 1);
                } else {
                    do6.e(rq4Var.s, 1, this.b.e, this.b.z, this.b.a0());
                    pp6.g(rq4Var.s, this.b.j, 1);
                }
            } else {
                do6.e(rq4Var.s, 2, this.b.e, this.b.z, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232f || view2.getId() == R.id.obfuscated_res_0x7f09230e) {
                fo6.k().h(this.b.z, rq4Var.s, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904d8) {
                pp6.a(this.b.z, rq4Var.getRecomReason());
            } else if (view2 instanceof TbImageView) {
                if (this.b.B.a instanceof Boolean) {
                    if (((Boolean) this.b.B.a).booleanValue()) {
                        fo6.k().h(this.b.z, rq4Var.s, 1);
                    } else {
                        fo6.k().h(this.b.z, rq4Var.s, 3);
                    }
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090521) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092030) {
                fo6.k().h(this.b.z, rq4Var.s, 5);
            } else if (!(view2 instanceof ThreadGodReplyLayout)) {
                fo6.k().h(this.b.z, rq4Var.s, 1);
            } else {
                int i = 6;
                if (rq4Var.s.getTopAgreePost() != null && rq4Var.s.getTopAgreePost().Q() != null && rq4Var.s.getTopAgreePost().Q().C() != null && rq4Var.s.getTopAgreePost().Q().C().size() > 0) {
                    i = rq4Var.s.getTopAgreePost().L ? 9 : 8;
                }
                fo6.k().h(this.b.z, rq4Var.s, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ph6 ph6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var};
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

    /* loaded from: classes6.dex */
    public class c implements fg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ph6 a;

        public c(ph6 ph6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ph6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.t.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements fg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ph6 a;

        public d(ph6 ph6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ph6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.t.getPageActivity());
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
    public class e implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ph6 ph6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var};
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
        public void a(on4 on4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, on4Var, view2) == null) || on4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232f) {
                on4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09230e) {
                on4Var.objType = 4;
            } else {
                on4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements wm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx a;
        public final /* synthetic */ ph6 b;

        public f(ph6 ph6Var, nx nxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var, nxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ph6Var;
            this.a = nxVar;
        }

        @Override // com.repackage.wm
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.Y(i, i2, i3);
                if (this.b.E(1) && this.b.E(2)) {
                    this.a.x(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ph6 a;

        public g(ph6 ph6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ph6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof rq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rq4 rq4Var = (rq4) nnVar;
                ThreadData threadData = rq4Var.s;
                threadData.objType = 1;
                if (this.a.B != null) {
                    this.a.B.a(threadCardViewHolder.a(), rq4Var);
                }
                ThreadCardUtils.jumpToPB((on4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.b().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ph6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = false;
        this.y = true;
        this.z = new eo6();
        this.B = new a(this);
        this.C = new b(this);
        this.D = new eg<>(new c(this), 6, 0);
        this.E = new eg<>(new d(this), 12, 0);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    public final void E0(ThreadData threadData) {
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
    /* renamed from: F0 */
    public ThreadCardViewHolder<rq4> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.t.getPageActivity());
            tw twVar = new tw(this.t.getPageActivity());
            twVar.c(4280);
            twVar.u(this.e);
            twVar.t(new e(this));
            bVar.o(twVar);
            nx nxVar = new nx(this.t.getPageActivity());
            nxVar.u("frs");
            if (this.A == 502) {
                nxVar.w(false);
            } else {
                nxVar.w(true);
            }
            nxVar.t(this.D);
            nxVar.s(this.E);
            nxVar.v(this.y);
            bVar.n(nxVar);
            my myVar = new my(this.t.getPageActivity());
            myVar.y(this.t);
            myVar.x(3);
            bVar.h(myVar);
            bVar.h(new ay(this.t.getPageActivity()));
            ex exVar = new ex(this.t.getPageActivity());
            bVar.h(exVar);
            exVar.y(this.y);
            exVar.x("frs");
            if (!E(1) || !E(2)) {
                nxVar.x(new f(this, nxVar));
            }
            ey eyVar = new ey(this.t.getPageActivity());
            un4 un4Var = new un4();
            if (100 == a0().tabType) {
                un4Var.b = this.x ? 10 : 25;
                eyVar.y(19);
                eyVar.D(14);
            } else {
                un4Var.b = this.x ? 10 : 2;
                eyVar.y(2);
                eyVar.D(1);
            }
            un4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !oi.isEmpty(this.j.getForum().getId())) {
                un4Var.j = this.j.getForum().getId();
            }
            eyVar.w(un4Var);
            eyVar.z(3);
            eyVar.c(16);
            bVar.m(eyVar);
            bVar.l().h(pi.f(this.a, R.dimen.tbds28));
            cy i = bVar.i();
            i.r(3);
            ThreadCardViewHolder<rq4> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.j(this.e);
            V(new g(this));
            threadCardViewHolder.n();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: G0 */
    public View S(int i, View view2, ViewGroup viewGroup, rq4 rq4Var, ThreadCardViewHolder<rq4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rq4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, rq4Var, threadCardViewHolder);
            if (rq4Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            threadCardViewHolder.b().b(this.v);
            bd6.i(threadCardViewHolder.b().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            boolean z = (rq4Var.s.getAuthor() == null || rq4Var.s.getAuthor().getUserId() == null || !rq4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (rq4Var.s.isSmartFrsThread() && rq4Var.s.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.p(true).u(this.C);
            }
            threadCardViewHolder.s();
            if (threadCardViewHolder.b().f() != null) {
                threadCardViewHolder.b().f().c(32);
            }
            threadCardViewHolder.f(rq4Var);
            threadCardViewHolder.b().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.B);
            if (this.z != null) {
                FrsViewData frsViewData2 = this.j;
                rq4Var.s.statFloor = (rq4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            fo6.k().c(this.z, rq4Var.s);
            E0(rq4Var.s);
            rq4Var.s.updateShowStatus();
            do6.o(rq4Var.s, this.e, this.z, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                do6.m(rq4Var.s, a0());
                do6.n(rq4Var.s, this.j.getForum().getId());
            }
            if (rq4Var != null) {
                rq4Var.s.updateShowStatus();
            }
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.iy5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.x = z;
        }
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.A = i;
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
            this.y = z;
        }
    }
}
