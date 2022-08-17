package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class dj6 extends ue6<ir4, FrsCardVideoViewHolder<bk6>> implements zz5, zp6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int p = 5;
    public static int q = 10;
    public static int r = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public xp6 n;
    public b06<ThreadData> o;

    /* loaded from: classes6.dex */
    public class a extends b06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj6 b;

        public a(dj6 dj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090ab9) {
                this.b.U(threadData, "c11718");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091287) {
                this.b.U(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090e91 || view2.getId() == R.id.obfuscated_res_0x7f091887) {
                this.b.U(threadData, "c10241");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904f3) {
                hr6.a(this.b.n, threadData.getRecomReason());
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09053f && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090ab9) {
                    wp6.e(threadData, 4, this.b.mPageId, this.b.n, this.b.t());
                    if (this.b.b == null || this.b.b.getForum() == null) {
                        return;
                    }
                    wp6.c(threadData, this.b.b.getForum().getId());
                    return;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09213e) {
                    wp6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    if (this.b.b == null || this.b.b.getForum() == null) {
                        return;
                    }
                    wp6.c(threadData, this.b.b.getForum().getId());
                    return;
                } else {
                    wp6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                    if (this.b.b == null || this.b.b.getForum() == null) {
                        return;
                    }
                    wp6.c(threadData, this.b.b.getForum().getId());
                    return;
                }
            }
            wp6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755765439, "Lcom/repackage/dj6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755765439, "Lcom/repackage/dj6;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new xp6();
        this.o = new a(this);
        this.l = tbPageContext;
    }

    public final void U(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) || threadData == null) {
            return;
        }
        int insertFloor = threadData.getInsertFloor();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", V(insertFloor));
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String V(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == p ? "3" : i == q ? "10" : i == r ? "11" : "" : (String) invokeI.objValue;
    }

    public final y88 W(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                y88 y88Var = new y88();
                y88Var.a = V(threadData.getInsertFloor());
                y88Var.d = this.n.c;
                y88Var.c = threadData.getTid();
                y88Var.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    y88Var.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return y88Var;
            }
            return null;
        }
        return (y88) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: X */
    public FrsCardVideoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            bk6 bk6Var = new bk6(this.l, this.mPageId);
            bk6Var.U(this.mPageId);
            bk6Var.a(this.m);
            return new FrsCardVideoViewHolder(bk6Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ue6, com.repackage.bn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ir4 ir4Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ir4Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.a() == null) {
                return null;
            }
            frsCardVideoViewHolder.a().a0(W(ir4Var.t));
            frsCardVideoViewHolder.a().i(ir4Var.t);
            frsCardVideoViewHolder.a().n(this.o);
            wp6.o(ir4Var.t, this.mPageId, this.n, t());
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                wp6.m(ir4Var.t, t());
                wp6.n(ir4Var.t, this.b.getForum().getId());
            }
            return frsCardVideoViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.zz5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.repackage.zp6
    public xp6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (xp6) invokeV.objValue;
    }

    @Override // com.repackage.zz5
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }
}
