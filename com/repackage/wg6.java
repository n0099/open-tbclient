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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
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
/* loaded from: classes7.dex */
public class wg6 extends cd6<ThreadData, ThreadCardViewHolder<ThreadData>> implements hy5, go6, ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int t;
    public String u;
    public jy5<ThreadData> v;
    public NEGFeedBackView.b w;

    /* loaded from: classes7.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg6 b;

        public a(wg6 wg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (view2 == null || threadData == null || StringUtils.isNull(threadData.getTid())) {
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
                    fo6.k().h(go6.f0, threadData, 13);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f09232d && view2.getId() != R.id.obfuscated_res_0x7f09230c) {
                    if (view2 instanceof ThreadGodReplyLayout) {
                        do6.e(threadData, 15, this.b.e, go6.f0, this.b.a0());
                        if (this.b.j == null || this.b.j.getForum() == null) {
                            return;
                        }
                        do6.c(threadData, this.b.j.getForum().getId());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09203e) {
                        do6.e(threadData, 5, this.b.e, go6.f0, this.b.a0());
                        if (this.b.j == null || this.b.j.getForum() == null) {
                            return;
                        }
                        do6.c(threadData, this.b.j.getForum().getId());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                        do6.e(threadData, 14, this.b.e, go6.f0, this.b.a0());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090e65) {
                        do6.e(threadData, 12, this.b.e, go6.f0, this.b.a0());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7d) {
                        do6.e(threadData, 13, this.b.e, go6.f0, this.b.a0());
                        return;
                    } else {
                        do6.e(threadData, 1, this.b.e, go6.f0, this.b.a0());
                        if (this.b.j == null || this.b.j.getForum() == null) {
                            return;
                        }
                        do6.c(threadData, this.b.j.getForum().getId());
                        return;
                    }
                }
                do6.e(threadData, 2, this.b.e, go6.f0, this.b.a0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wg6 wg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg6Var};
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

    /* loaded from: classes7.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg6 a;

        public c(wg6 wg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.C0(view2, nnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 3;
        this.v = new a(this);
        this.w = new b(this);
        this.k = tbPageContext;
    }

    public final void C0(View view2, nn nnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, nnVar) == null) && (nnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) nnVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((nn4) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new ny.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: D0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.u(this.e);
            twVar.w(this.k);
            bVar.o(twVar);
            bVar.n(new rw(this.k.getPageActivity()));
            ey eyVar = new ey(this.k.getPageActivity());
            tn4 tn4Var = new tn4();
            if (100 == a0().tabType) {
                tn4Var.b = 25;
                eyVar.y(19);
                eyVar.D(14);
            } else {
                tn4Var.b = 2;
                eyVar.y(2);
                eyVar.D(1);
            }
            tn4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !oi.isEmpty(this.j.getForum().getId())) {
                tn4Var.j = this.j.getForum().getId();
            }
            eyVar.w(tn4Var);
            eyVar.z(3);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: E0 */
    public View S(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, threadData, threadCardViewHolder);
            if (threadData == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            fo6.k().c(go6.f0, threadData);
            threadCardViewHolder.c().b(this.u);
            threadCardViewHolder.c().q(i);
            if (this.t == 1) {
                threadCardViewHolder.q(true).u(this.w);
            }
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.g(threadData);
            threadCardViewHolder.c().p(this.v);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
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
            this.u = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? go6.f0 : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.t = i;
        }
    }

    @Override // com.repackage.cd6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }
}
