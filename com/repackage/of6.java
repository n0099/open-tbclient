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
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class of6 extends fb6<rp4, ThreadCardViewHolder<ThreadData>> implements lw5, pm6, ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public boolean v;
    public int w;
    public nm6 x;
    public nw5<ThreadData> y;
    public NEGFeedBackView.b z;

    /* loaded from: classes6.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of6 b;

        public a(of6 of6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = of6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092298 && view2.getId() != R.id.obfuscated_res_0x7f092278) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    mm6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb6) {
                    mm6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e66) {
                    mm6.e(threadData, 12, this.b.e, this.b.x, this.b.a0());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e7c) {
                    mm6.e(threadData, 13, this.b.e, this.b.x, this.b.a0());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.y.a instanceof Boolean) {
                        if (((Boolean) this.b.y.a).booleanValue()) {
                            mm6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                        } else {
                            mm6.e(threadData, 3, this.b.e, this.b.x, this.b.a0());
                        }
                    }
                    yn6.g(threadData, this.b.j, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mm6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                } else {
                    mm6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                    yn6.g(threadData, this.b.j, 1);
                }
            } else {
                mm6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298 || view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09053f) {
                om6.k().h(this.b.x, threadData, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(of6 of6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of6Var};
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

    /* loaded from: classes6.dex */
    public class c implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(of6 of6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of6Var};
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

    /* loaded from: classes6.dex */
    public class d implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of6 a;

        public d(of6 of6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof rp4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((rp4) jnVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((om4) threadData, view2.getContext(), this.a.w, false);
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public of6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = new nm6();
        this.y = new a(this);
        this.z = new b(this);
        this.t = tbPageContext;
        this.e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: B0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.t.getPageActivity());
            pw pwVar = new pw(this.t.getPageActivity());
            pwVar.t(this.e);
            pwVar.b(4272);
            pwVar.s(new c(this));
            bVar.o(pwVar);
            bVar.n(new fx(this.t.getPageActivity()));
            zw zwVar = new zw(this.t.getPageActivity());
            zwVar.x(this.v);
            zwVar.w("frs");
            bVar.h(zwVar);
            zx zxVar = new zx(this.t.getPageActivity());
            um4 um4Var = new um4();
            if (100 == a0().tabType) {
                um4Var.b = 25;
                zxVar.x(19);
            } else {
                um4Var.b = 2;
                zxVar.x(2);
            }
            um4Var.h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !ki.isEmpty(this.j.getForum().getId())) {
                um4Var.j = this.j.getForum().getId();
            }
            zxVar.v(um4Var);
            zxVar.C(this.w);
            zxVar.y(this.w);
            zxVar.b(48);
            bVar.m(zxVar);
            xx j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
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
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: C0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, threadCardViewHolder})) == null) {
            if (rp4Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            super.S(i, view2, viewGroup, rp4Var, threadCardViewHolder);
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.u);
            }
            eb6.i(threadCardViewHolder.c().f(), this.j);
            boolean z = (rp4Var.s.getAuthor() == null || rp4Var.s.getAuthor().getUserId() == null || !rp4Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (rp4Var.s.isSmartFrsThread() && rp4Var.s.getFeedBackReasonMap() != null && !z) {
                nx r = threadCardViewHolder.r(true);
                r.u(this.z);
                r.a(rp4Var.s.getNegFeedBackData());
            }
            threadCardViewHolder.u();
            threadCardViewHolder.g(rp4Var.s);
            threadCardViewHolder.j(this.y);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            if (this.x != null) {
                FrsViewData frsViewData = this.j;
                rp4Var.s.statFloor = (rp4Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            om6.k().c(this.x, rp4Var.s);
            mm6.o(rp4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData2 = this.j;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
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
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.v = z;
        }
    }
}
