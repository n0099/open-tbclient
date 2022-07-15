package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.repackage.tw;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class lh6 extends cd6<qq4, ThreadCardViewHolder<ThreadData>> implements hy5, go6, ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public boolean v;
    public int w;
    public eo6 x;
    public jy5<ThreadData> y;
    public NEGFeedBackView.b z;

    /* loaded from: classes6.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh6 b;

        public a(lh6 lh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09203e) {
                    do6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                    do6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e65) {
                    do6.e(threadData, 12, this.b.e, this.b.x, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7d) {
                    do6.e(threadData, 13, this.b.e, this.b.x, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.y.a instanceof Boolean) {
                        if (((Boolean) this.b.y.a).booleanValue()) {
                            do6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                        } else {
                            do6.e(threadData, 3, this.b.e, this.b.x, this.b.a0());
                        }
                    }
                    pp6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    do6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                } else {
                    do6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                    pp6.g(threadData, this.b.j, 1);
                }
            } else {
                do6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d || view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                fo6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090521) {
                fo6.k().h(this.b.x, threadData, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(lh6 lh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh6Var};
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

    /* loaded from: classes6.dex */
    public class c implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(lh6 lh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh6Var};
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

    /* loaded from: classes6.dex */
    public class d implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh6 a;

        public d(lh6 lh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((qq4) nnVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((nn4) threadData, view2.getContext(), this.a.w, false);
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.v = true;
        this.w = 3;
        this.x = new eo6();
        this.y = new a(this);
        this.z = new b(this);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: B0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.t.getPageActivity());
            tw twVar = new tw(this.t.getPageActivity());
            twVar.u(this.e);
            twVar.c(4272);
            twVar.t(new c(this));
            bVar.o(twVar);
            bVar.n(new kx(this.t.getPageActivity()));
            ex exVar = new ex(this.t.getPageActivity());
            exVar.y(this.v);
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
            eyVar.D(this.w);
            eyVar.z(this.w);
            eyVar.c(48);
            bVar.m(eyVar);
            cy j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.r(this.w);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.k(this.e);
            V(new d(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: C0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, threadCardViewHolder})) == null) {
            if (qq4Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            super.S(i, view2, viewGroup, qq4Var, threadCardViewHolder);
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.u);
            }
            bd6.i(threadCardViewHolder.c().f(), this.j);
            boolean z = (qq4Var.s.getAuthor() == null || qq4Var.s.getAuthor().getUserId() == null || !qq4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (qq4Var.s.isSmartFrsThread() && qq4Var.s.getFeedBackReasonMap() != null && !z) {
                sx q = threadCardViewHolder.q(true);
                q.u(this.z);
                q.a(qq4Var.s.getNegFeedBackData());
            }
            threadCardViewHolder.t();
            threadCardViewHolder.g(qq4Var.s);
            threadCardViewHolder.j(this.y);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            if (this.x != null) {
                FrsViewData frsViewData = this.j;
                qq4Var.s.statFloor = (qq4Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            fo6.k().c(this.x, qq4Var.s);
            do6.o(qq4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData2 = this.j;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                do6.m(qq4Var.s, a0());
                do6.n(qq4Var.s, this.j.getForum().getId());
            }
            if (qq4Var != null) {
                qq4Var.s.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.v = z;
        }
    }
}
