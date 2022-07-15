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
public class kh6 extends cd6<qq4, FrsCardVideoViewHolder<ii6>> implements hy5, go6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 5;
    public static int y = 10;
    public static int z = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public eo6 v;
    public jy5<ThreadData> w;

    /* loaded from: classes6.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh6 b;

        public a(kh6 kh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090a85) {
                this.b.A0(threadData, "c11718");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091251) {
                this.b.A0(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090e4c || view2.getId() == R.id.obfuscated_res_0x7f0917de) {
                this.b.A0(threadData, "c10241");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904d8) {
                pp6.a(this.b.v, threadData.getRecomReason());
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f090524 && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090a85) {
                    do6.e(threadData, 4, this.b.e, this.b.v, this.b.a0());
                    if (this.b.j == null || this.b.j.getForum() == null) {
                        return;
                    }
                    do6.c(threadData, this.b.j.getForum().getId());
                    return;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09203e) {
                    do6.e(threadData, 5, this.b.e, this.b.v, this.b.a0());
                    if (this.b.j == null || this.b.j.getForum() == null) {
                        return;
                    }
                    do6.c(threadData, this.b.j.getForum().getId());
                    return;
                } else {
                    do6.e(threadData, 1, this.b.e, this.b.v, this.b.a0());
                    if (this.b.j == null || this.b.j.getForum() == null) {
                        return;
                    }
                    do6.c(threadData, this.b.j.getForum().getId());
                    return;
                }
            }
            do6.e(threadData, 2, this.b.e, this.b.v, this.b.a0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755558824, "Lcom/repackage/kh6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755558824, "Lcom/repackage/kh6;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.v = new eo6();
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

    public final s68 C0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                s68 s68Var = new s68();
                s68Var.a = B0(threadData.getInsertFloor());
                s68Var.d = this.v.c;
                s68Var.c = threadData.getTid();
                s68Var.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    s68Var.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return s68Var;
            }
            return null;
        }
        return (s68) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: D0 */
    public FrsCardVideoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ii6 ii6Var = new ii6(this.t, this.e);
            ii6Var.U(this.e);
            ii6Var.a(this.u);
            return new FrsCardVideoViewHolder(ii6Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: E0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.c() == null) {
                return null;
            }
            frsCardVideoViewHolder.c().a0(C0(qq4Var.s));
            frsCardVideoViewHolder.c().i(qq4Var.s);
            frsCardVideoViewHolder.c().n(this.w);
            do6.o(qq4Var.s, this.e, this.v, a0());
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null) {
                do6.m(qq4Var.s, a0());
                do6.n(qq4Var.s, this.j.getForum().getId());
            }
            return frsCardVideoViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (eo6) invokeV.objValue;
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }
}
