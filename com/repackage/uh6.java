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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.ty;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class uh6 extends id6<rq4, ThreadCardViewHolder<rq4>> implements px5, gp6, qi5, qx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public rx5<rq4> B;
    public NEGFeedBackView.b C;
    public dg<ConstrainImageLayout> D;
    public dg<TbImageView> E;
    public TbPageContext<?> t;
    public HashSet<String> u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public ep6 z;

    /* loaded from: classes7.dex */
    public class a extends rx5<rq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh6 b;

        public a(uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rx5
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
            if (view2.getId() != R.id.obfuscated_res_0x7f09229c && view2.getId() != R.id.obfuscated_res_0x7f09227a) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f98) {
                    dp6.e(rq4Var.s, 5, this.b.e, this.b.z, this.b.a0());
                    pq6.g(rq4Var.s, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb9) {
                    dp6.e(rq4Var.s, 14, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e96) {
                    dp6.e(rq4Var.s, 12, this.b.e, this.b.z, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eac) {
                    dp6.e(rq4Var.s, 13, this.b.e, this.b.z, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.B.a instanceof Boolean) {
                        if (((Boolean) this.b.B.a).booleanValue()) {
                            dp6.e(rq4Var.s, 1, this.b.e, this.b.z, this.b.a0());
                        } else {
                            dp6.e(rq4Var.s, 3, this.b.e, this.b.z, this.b.a0());
                        }
                    }
                    pq6.g(rq4Var.s, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    dp6.e(rq4Var.s, 15, this.b.e, this.b.z, this.b.a0());
                    pq6.g(rq4Var.s, this.b.j, 1);
                } else {
                    dp6.e(rq4Var.s, 1, this.b.e, this.b.z, this.b.a0());
                    pq6.g(rq4Var.s, this.b.j, 1);
                }
            } else {
                dp6.e(rq4Var.s, 2, this.b.e, this.b.z, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229c || view2.getId() == R.id.obfuscated_res_0x7f09227a) {
                fp6.k().h(this.b.z, rq4Var.s, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904ff) {
                pq6.a(this.b.z, rq4Var.getRecomReason());
            } else if (view2 instanceof TbImageView) {
                if (this.b.B.a instanceof Boolean) {
                    if (((Boolean) this.b.B.a).booleanValue()) {
                        fp6.k().h(this.b.z, rq4Var.s, 1);
                    } else {
                        fp6.k().h(this.b.z, rq4Var.s, 3);
                    }
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090548) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f88) {
                fp6.k().h(this.b.z, rq4Var.s, 5);
            } else if (!(view2 instanceof ThreadGodReplyLayout)) {
                fp6.k().h(this.b.z, rq4Var.s, 1);
            } else {
                int i = 6;
                if (rq4Var.s.getTopAgreePost() != null && rq4Var.s.getTopAgreePost().P() != null && rq4Var.s.getTopAgreePost().P().A() != null && rq4Var.s.getTopAgreePost().P().A().size() > 0) {
                    i = rq4Var.s.getTopAgreePost().L ? 9 : 8;
                }
                fp6.k().h(this.b.z, rq4Var.s, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, mp4 mp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, mp4Var) == null) || arrayList == null || mp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", mp4Var.c()).param("tid", mp4Var.f()).param("nid", mp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", mp4Var.l).param("weight", mp4Var.k).param("ab_tag", mp4Var.p).param("extra", mp4Var.m).param("card_type", mp4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, mp4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(mp4 mp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(mp4 mp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mp4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", mp4Var.c()).param("tid", mp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements eg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh6 a;

        public c(uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
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
    public class d implements eg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh6 a;

        public d(uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
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
    public class e implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ty.b
        public void a(qn4 qn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, qn4Var, view2) == null) || qn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229c) {
                qn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09227a) {
                qn4Var.objType = 4;
            } else {
                qn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Cdo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz a;
        public final /* synthetic */ uh6 b;

        public f(uh6 uh6Var, mz mzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var, mzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uh6Var;
            this.a = mzVar;
        }

        @Override // com.repackage.Cdo
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
    public class g implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh6 a;

        public g(uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof rq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rq4 rq4Var = (rq4) uoVar;
                ThreadData threadData = rq4Var.s;
                threadData.objType = 1;
                if (this.a.B != null) {
                    this.a.B.a(threadCardViewHolder.b(), rq4Var);
                }
                ThreadCardUtils.jumpToPB((qn4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.z = new ep6();
        this.B = new a(this);
        this.C = new b(this);
        this.D = new dg<>(new c(this), 6, 0);
        this.E = new dg<>(new d(this), 12, 0);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    public final void E0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.u == null) {
                this.u = new HashSet<>();
            }
            fp6.k().d(threadData, this.u);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: F0 */
    public ThreadCardViewHolder<rq4> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.t.getPageActivity());
            ty tyVar = new ty(this.t.getPageActivity());
            tyVar.b(4280);
            tyVar.t(this.e);
            tyVar.s(new e(this));
            bVar.o(tyVar);
            mz mzVar = new mz(this.t.getPageActivity());
            mzVar.t("frs");
            if (this.A == 502) {
                mzVar.v(false);
            } else {
                mzVar.v(true);
            }
            mzVar.s(this.D);
            mzVar.r(this.E);
            mzVar.u(this.y);
            bVar.n(mzVar);
            l00 l00Var = new l00(this.t.getPageActivity());
            l00Var.x(this.t);
            l00Var.w(3);
            bVar.h(l00Var);
            bVar.h(new zz(this.t.getPageActivity()));
            dz dzVar = new dz(this.t.getPageActivity());
            bVar.h(dzVar);
            dzVar.x(this.y);
            dzVar.w("frs");
            if (!F(1) || !F(2)) {
                mzVar.w(new f(this, mzVar));
            }
            d00 d00Var = new d00(this.t.getPageActivity());
            wn4 wn4Var = new wn4();
            if (100 == a0().tabType) {
                wn4Var.b = this.x ? 10 : 25;
                d00Var.w(19);
                d00Var.A(14);
            } else {
                wn4Var.b = this.x ? 10 : 2;
                d00Var.w(2);
                d00Var.A(1);
            }
            wn4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !ni.isEmpty(this.j.getForum().getId())) {
                wn4Var.j = this.j.getForum().getId();
            }
            d00Var.v(wn4Var);
            d00Var.x(3);
            d00Var.b(16);
            bVar.m(d00Var);
            bVar.l().h(oi.f(this.a, R.dimen.tbds28));
            b00 i = bVar.i();
            i.r(3);
            ThreadCardViewHolder<rq4> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.e);
            V(new g(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.id6, com.repackage.ho
    /* renamed from: G0 */
    public View S(int i, View view2, ViewGroup viewGroup, rq4 rq4Var, ThreadCardViewHolder<rq4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rq4Var, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, rq4Var, threadCardViewHolder);
            if (rq4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().b(this.v);
            hd6.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rq4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            boolean z = (rq4Var.s.getAuthor() == null || rq4Var.s.getAuthor().getUserId() == null || !rq4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (rq4Var.s.isSmartFrsThread() && rq4Var.s.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.r(true).u(this.C);
            }
            threadCardViewHolder.u();
            if (threadCardViewHolder.c().f() != null) {
                threadCardViewHolder.c().f().b(32);
            }
            threadCardViewHolder.g(rq4Var);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.B);
            if (this.z != null) {
                FrsViewData frsViewData2 = this.j;
                rq4Var.s.statFloor = (rq4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            fp6.k().c(this.z, rq4Var.s);
            E0(rq4Var.s);
            rq4Var.s.updateShowStatus();
            dp6.n(rq4Var.s, this.e, this.z, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                dp6.l(rq4Var.s, a0());
                dp6.m(rq4Var.s, this.j.getForum().getId());
            }
            if (rq4Var != null) {
                rq4Var.s.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.px5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.v = str;
        }
    }

    @Override // com.repackage.gp6
    public ep6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (ep6) invokeV.objValue;
    }

    @Override // com.repackage.qx5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.x = z;
        }
    }

    @Override // com.repackage.px5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.A = i;
        }
    }

    @Override // com.repackage.id6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    @Override // com.repackage.id6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.y = z;
        }
    }
}
