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
import com.repackage.kz;
import com.repackage.vz;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class xg6 extends pc6<br4, ThreadCardViewHolder<ThreadData>> implements sx5, jo6, ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public boolean v;
    public int w;
    public ho6 x;
    public ux5<ThreadData> y;
    public NEGFeedBackView.b z;

    /* loaded from: classes7.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg6 b;

        public a(xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091ff4) {
                    go6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    sp6.g(threadData, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0b) {
                    go6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ea1) {
                    go6.e(threadData, 12, this.b.e, this.b.x, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eb7) {
                    go6.e(threadData, 13, this.b.e, this.b.x, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.y.a instanceof Boolean) {
                        if (((Boolean) this.b.y.a).booleanValue()) {
                            go6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                        } else {
                            go6.e(threadData, 3, this.b.e, this.b.x, this.b.a0());
                        }
                    }
                    sp6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    go6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    sp6.g(threadData, this.b.j, 1);
                } else {
                    go6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                    sp6.g(threadData, this.b.j, 1);
                }
            } else {
                go6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3 || view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                io6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090545) {
                io6.k().h(this.b.x, threadData, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg6Var};
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

    /* loaded from: classes7.dex */
    public class c implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg6Var};
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

    /* loaded from: classes7.dex */
    public class d implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg6 a;

        public d(xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xg6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof br4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((br4) roVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), this.a.w, false);
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = new ho6();
        this.y = new a(this);
        this.z = new b(this);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: B0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.t.getPageActivity());
            cy cyVar = new cy(this.t.getPageActivity());
            cyVar.t(this.e);
            cyVar.b(4272);
            cyVar.s(new c(this));
            bVar.o(cyVar);
            bVar.n(new sy(this.t.getPageActivity()));
            my myVar = new my(this.t.getPageActivity());
            myVar.x(this.v);
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
            mzVar.C(this.w);
            mzVar.y(this.w);
            mzVar.b(48);
            bVar.m(mzVar);
            kz j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
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
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: C0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, threadCardViewHolder})) == null) {
            if (br4Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            super.S(i, view2, viewGroup, br4Var, threadCardViewHolder);
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.u);
            }
            oc6.i(threadCardViewHolder.c().f(), this.j);
            boolean z = (br4Var.s.getAuthor() == null || br4Var.s.getAuthor().getUserId() == null || !br4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (br4Var.s.isSmartFrsThread() && br4Var.s.getFeedBackReasonMap() != null && !z) {
                az r = threadCardViewHolder.r(true);
                r.u(this.z);
                r.a(br4Var.s.getNegFeedBackData());
            }
            threadCardViewHolder.u();
            threadCardViewHolder.g(br4Var.s);
            threadCardViewHolder.j(this.y);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            if (this.x != null) {
                FrsViewData frsViewData = this.j;
                br4Var.s.statFloor = (br4Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            io6.k().c(this.x, br4Var.s);
            go6.n(br4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData2 = this.j;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                go6.l(br4Var.s, a0());
                go6.m(br4Var.s, this.j.getForum().getId());
            }
            if (br4Var != null) {
                br4Var.s.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.jo6
    public ho6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.pc6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.v = z;
        }
    }
}
