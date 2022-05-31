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
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class sf6 extends fb6<rp4, ThreadCardViewHolder<rp4>> implements lw5, pm6, ci5, mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public nw5<rp4> B;
    public NEGFeedBackView.b C;
    public ag<ConstrainImageLayout> D;
    public ag<TbImageView> E;
    public TbPageContext<?> t;
    public HashSet<String> u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public nm6 z;

    /* loaded from: classes7.dex */
    public class a extends nw5<rp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf6 b;

        public a(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, rp4 rp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rp4Var) == null) || view2 == null || rp4Var == null) {
                return;
            }
            if (this.b.q != null) {
                this.b.q.b(view2, rp4Var, this.b.getType());
            }
            if ("c13010".equals(this.b.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", rp4Var.s.getFid()).param("tid", rp4Var.s.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092298 && view2.getId() != R.id.obfuscated_res_0x7f092278) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    mm6.e(rp4Var.s, 5, this.b.e, this.b.z, this.b.a0());
                    yn6.g(rp4Var.s, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb6) {
                    mm6.e(rp4Var.s, 14, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e66) {
                    mm6.e(rp4Var.s, 12, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7c) {
                    mm6.e(rp4Var.s, 13, this.b.e, this.b.z, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.B.a instanceof Boolean) {
                        if (((Boolean) this.b.B.a).booleanValue()) {
                            mm6.e(rp4Var.s, 1, this.b.e, this.b.z, this.b.a0());
                        } else {
                            mm6.e(rp4Var.s, 3, this.b.e, this.b.z, this.b.a0());
                        }
                    }
                    yn6.g(rp4Var.s, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mm6.e(rp4Var.s, 15, this.b.e, this.b.z, this.b.a0());
                    yn6.g(rp4Var.s, this.b.j, 1);
                } else {
                    mm6.e(rp4Var.s, 1, this.b.e, this.b.z, this.b.a0());
                    yn6.g(rp4Var.s, this.b.j, 1);
                }
            } else {
                mm6.e(rp4Var.s, 2, this.b.e, this.b.z, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298 || view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om6.k().h(this.b.z, rp4Var.s, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904f6) {
                yn6.a(this.b.z, rp4Var.getRecomReason());
            } else if (view2 instanceof TbImageView) {
                if (this.b.B.a instanceof Boolean) {
                    if (((Boolean) this.b.B.a).booleanValue()) {
                        om6.k().h(this.b.z, rp4Var.s, 1);
                    } else {
                        om6.k().h(this.b.z, rp4Var.s, 3);
                    }
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09053f) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
                om6.k().h(this.b.z, rp4Var.s, 5);
            } else if (!(view2 instanceof ThreadGodReplyLayout)) {
                om6.k().h(this.b.z, rp4Var.s, 1);
            } else {
                int i = 6;
                if (rp4Var.s.getTopAgreePost() != null && rp4Var.s.getTopAgreePost().P() != null && rp4Var.s.getTopAgreePost().P().A() != null && rp4Var.s.getTopAgreePost().P().A().size() > 0) {
                    i = rp4Var.s.getTopAgreePost().L ? 9 : 8;
                }
                om6.k().h(this.b.z, rp4Var.s, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lo4Var) == null) || arrayList == null || lo4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", lo4Var.c()).param("tid", lo4Var.f()).param("nid", lo4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", lo4Var.l).param("weight", lo4Var.k).param("ab_tag", lo4Var.p).param("extra", lo4Var.m).param("card_type", lo4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, lo4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lo4 lo4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lo4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lo4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", lo4Var.c()).param("tid", lo4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements bg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf6 a;

        public c(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
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

    /* loaded from: classes7.dex */
    public class d implements bg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf6 a;

        public d(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
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

    /* loaded from: classes7.dex */
    public class e implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.pw.b
        public void a(om4 om4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) || om4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298) {
                om4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om4Var.objType = 4;
            } else {
                om4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements sm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix a;
        public final /* synthetic */ sf6 b;

        public f(sf6 sf6Var, ix ixVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var, ixVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sf6Var;
            this.a = ixVar;
        }

        @Override // com.repackage.sm
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.Y(i, i2, i3);
                if (this.b.F(1) && this.b.F(2)) {
                    this.a.w(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf6 a;

        public g(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rp4 rp4Var = (rp4) jnVar;
                ThreadData threadData = rp4Var.s;
                threadData.objType = 1;
                if (this.a.B != null) {
                    this.a.B.a(threadCardViewHolder.b(), rp4Var);
                }
                ThreadCardUtils.jumpToPB((om4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.z = new nm6();
        this.B = new a(this);
        this.C = new b(this);
        this.D = new ag<>(new c(this), 6, 0);
        this.E = new ag<>(new d(this), 12, 0);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    public final void E0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.u == null) {
                this.u = new HashSet<>();
            }
            om6.k().d(threadData, this.u);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: F0 */
    public ThreadCardViewHolder<rp4> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.t.getPageActivity());
            pw pwVar = new pw(this.t.getPageActivity());
            pwVar.b(4280);
            pwVar.t(this.e);
            pwVar.s(new e(this));
            bVar.o(pwVar);
            ix ixVar = new ix(this.t.getPageActivity());
            ixVar.t("frs");
            if (this.A == 502) {
                ixVar.v(false);
            } else {
                ixVar.v(true);
            }
            ixVar.s(this.D);
            ixVar.r(this.E);
            ixVar.u(this.y);
            bVar.n(ixVar);
            hy hyVar = new hy(this.t.getPageActivity());
            hyVar.x(this.t);
            hyVar.w(3);
            bVar.h(hyVar);
            bVar.h(new vx(this.t.getPageActivity()));
            zw zwVar = new zw(this.t.getPageActivity());
            bVar.h(zwVar);
            zwVar.x(this.y);
            zwVar.w("frs");
            if (!F(1) || !F(2)) {
                ixVar.w(new f(this, ixVar));
            }
            zx zxVar = new zx(this.t.getPageActivity());
            um4 um4Var = new um4();
            if (100 == a0().tabType) {
                um4Var.b = this.x ? 10 : 25;
                zxVar.x(19);
                zxVar.C(14);
            } else {
                um4Var.b = this.x ? 10 : 2;
                zxVar.x(2);
                zxVar.C(1);
            }
            um4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !ki.isEmpty(this.j.getForum().getId())) {
                um4Var.j = this.j.getForum().getId();
            }
            zxVar.v(um4Var);
            zxVar.y(3);
            zxVar.b(16);
            bVar.m(zxVar);
            bVar.l().h(li.f(this.a, R.dimen.tbds28));
            xx i = bVar.i();
            i.r(3);
            ThreadCardViewHolder<rp4> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.e);
            V(new g(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: G0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, ThreadCardViewHolder<rp4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, rp4Var, threadCardViewHolder);
            if (rp4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.v);
            eb6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rp4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            boolean z = (rp4Var.s.getAuthor() == null || rp4Var.s.getAuthor().getUserId() == null || !rp4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (rp4Var.s.isSmartFrsThread() && rp4Var.s.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.r(true).u(this.C);
            }
            threadCardViewHolder.u();
            if (threadCardViewHolder.c().f() != null) {
                threadCardViewHolder.c().f().b(32);
            }
            threadCardViewHolder.g(rp4Var);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.B);
            if (this.z != null) {
                FrsViewData frsViewData2 = this.j;
                rp4Var.s.statFloor = (rp4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            om6.k().c(this.z, rp4Var.s);
            E0(rp4Var.s);
            rp4Var.s.updateShowStatus();
            mm6.o(rp4Var.s, this.e, this.z, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                mm6.m(rp4Var.s, a0());
                mm6.n(rp4Var.s, this.j.getForum().getId());
            }
            if (rp4Var != null) {
                rp4Var.s.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.v = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.mw5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.x = z;
        }
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.A = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    @Override // com.repackage.fb6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.y = z;
        }
    }
}
