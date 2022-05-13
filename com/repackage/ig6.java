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
import com.repackage.kz;
import com.repackage.vz;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ig6 extends pc6<ThreadData, ThreadCardViewHolder<ThreadData>> implements sx5, jo6, ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int t;
    public String u;
    public ux5<ThreadData> v;
    public NEGFeedBackView.b w;

    /* loaded from: classes6.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 b;

        public a(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ig6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                nx5.b().d(true);
                gj5.c().h("page_recommend", "show_");
                if (view2 == null || threadData == null || StringUtils.isNull(threadData.getTid())) {
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
                    io6.k().h(jo6.f0, threadData, 13);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                    if (view2 instanceof ThreadGodReplyLayout) {
                        go6.e(threadData, 15, this.b.e, jo6.f0, this.b.a0());
                        if (this.b.j == null || this.b.j.getForum() == null) {
                            return;
                        }
                        go6.c(threadData, this.b.j.getForum().getId());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091ff4) {
                        go6.e(threadData, 5, this.b.e, jo6.f0, this.b.a0());
                        if (this.b.j == null || this.b.j.getForum() == null) {
                            return;
                        }
                        go6.c(threadData, this.b.j.getForum().getId());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0b) {
                        go6.e(threadData, 14, this.b.e, jo6.f0, this.b.a0());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090ea1) {
                        go6.e(threadData, 12, this.b.e, jo6.f0, this.b.a0());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090eb7) {
                        go6.e(threadData, 13, this.b.e, jo6.f0, this.b.a0());
                        return;
                    } else {
                        go6.e(threadData, 1, this.b.e, jo6.f0, this.b.a0());
                        if (this.b.j == null || this.b.j.getForum() == null) {
                            return;
                        }
                        go6.c(threadData, this.b.j.getForum().getId());
                        return;
                    }
                }
                go6.e(threadData, 2, this.b.e, jo6.f0, this.b.a0());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
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
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 a;

        public c(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.C0(view2, roVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    public final void C0(View view2, ro roVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, roVar) == null) && (roVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) roVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new vz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: D0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.k.getPageActivity());
            cy cyVar = new cy(this.k.getPageActivity());
            cyVar.t(this.e);
            cyVar.v(this.k);
            bVar.o(cyVar);
            bVar.n(new ay(this.k.getPageActivity()));
            mz mzVar = new mz(this.k.getPageActivity());
            fo4 fo4Var = new fo4();
            if (100 == a0().tabType) {
                fo4Var.b = 25;
                mzVar.x(19);
                mzVar.C(14);
            } else {
                fo4Var.b = 2;
                mzVar.x(2);
                mzVar.C(1);
            }
            fo4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !li.isEmpty(this.j.getForum().getId())) {
                fo4Var.j = this.j.getForum().getId();
            }
            mzVar.v(fo4Var);
            mzVar.y(3);
            bVar.m(mzVar);
            kz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.e);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: E0 */
    public View S(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.S(i, view2, viewGroup, threadData, threadCardViewHolder);
            if (threadData == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            io6.k().c(jo6.f0, threadData);
            threadCardViewHolder.c().b(this.u);
            threadCardViewHolder.c().q(i);
            if (this.t == 1) {
                threadCardViewHolder.r(true).u(this.w);
            }
            threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.g(threadData);
            threadCardViewHolder.c().p(this.v);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.jo6
    public ho6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? jo6.f0 : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.t = i;
        }
    }

    @Override // com.repackage.pc6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }
}
