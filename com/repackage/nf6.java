package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
public class nf6 extends fb6<rp4, FrsCardVideoViewHolder<lg6>> implements lw5, pm6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 5;
    public static int y = 10;
    public static int z = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public nm6 v;
    public nw5<ThreadData> w;

    /* loaded from: classes6.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf6 b;

        public a(nf6 nf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090a8e) {
                this.b.A0(threadData, "c11718");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0911bb) {
                this.b.A0(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090e4d || view2.getId() == R.id.obfuscated_res_0x7f091738) {
                this.b.A0(threadData, "c10241");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904f6) {
                yn6.a(this.b.v, threadData.getRecomReason());
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f090542 && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090a8e) {
                    mm6.e(threadData, 4, this.b.e, this.b.v, this.b.a0());
                    if (this.b.j == null || this.b.j.getForum() == null) {
                        return;
                    }
                    mm6.c(threadData, this.b.j.getForum().getId());
                    return;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091f99) {
                    mm6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                    if (this.b.j == null || this.b.j.getForum() == null) {
                        return;
                    }
                    mm6.c(threadData, this.b.j.getForum().getId());
                    return;
                } else {
                    mm6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                    if (this.b.j == null || this.b.j.getForum() == null) {
                        return;
                    }
                    mm6.c(threadData, this.b.j.getForum().getId());
                    return;
                }
            }
            mm6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755471373, "Lcom/repackage/nf6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755471373, "Lcom/repackage/nf6;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.v = new nm6();
        this.w = new a(this);
        this.t = tbPageContext;
    }

    public final void A0(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) || threadData == null) {
            return;
        }
        int insertFloor = threadData.getInsertFloor();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", B0(insertFloor));
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String B0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == x ? "3" : i == y ? "10" : i == z ? "11" : "" : (String) invokeI.objValue;
    }

    public final t48 C0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                t48 t48Var = new t48();
                t48Var.a = B0(threadData.getInsertFloor());
                t48Var.d = this.v.c;
                t48Var.c = threadData.getTid();
                t48Var.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    t48Var.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return t48Var;
            }
            return null;
        }
        return (t48) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: D0 */
    public FrsCardVideoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            lg6 lg6Var = new lg6(this.t, this.e);
            lg6Var.U(this.e);
            lg6Var.a(this.u);
            return new FrsCardVideoViewHolder(lg6Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: E0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.c() == null) {
                return null;
            }
            frsCardVideoViewHolder.c().a0(C0(rp4Var.s));
            frsCardVideoViewHolder.c().l(rp4Var.s);
            frsCardVideoViewHolder.c().n(this.w);
            mm6.o(rp4Var.s, this.e, this.v, a0());
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null) {
                mm6.m(rp4Var.s, a0());
                mm6.n(rp4Var.s, this.j.getForum().getId());
            }
            return frsCardVideoViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }
}
