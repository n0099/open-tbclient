package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fq5 extends wm<hq5, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public pq5 j;
    public boolean k;
    public nq5 l;
    public int m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq5(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), hq5.c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.i = tbPageContext;
    }

    public final void Z(hq5 hq5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hq5Var) == null) || hq5Var == null) {
            return;
        }
        int i = this.n;
        if (i == 1) {
            if (hq5Var.a != null) {
                zo5 c = zo5.c();
                zo5 c2 = zo5.c();
                int i2 = this.m;
                pm5 pm5Var = hq5Var.a;
                c.a(c2.e(i2, "c12117", pm5Var.a, pm5Var.b, pm5Var.getThreadData()));
            }
            if (hq5Var.b != null) {
                zo5 c3 = zo5.c();
                zo5 c4 = zo5.c();
                int i3 = this.m;
                pm5 pm5Var2 = hq5Var.b;
                c3.a(c4.e(i3, "c12117", pm5Var2.a, pm5Var2.b, pm5Var2.getThreadData()));
            }
        } else if (i == 2) {
            pm5 pm5Var3 = hq5Var.a;
            if (pm5Var3 != null && pm5Var3.getThreadData() != null && hq5Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = hq5Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", hq5Var.a.b));
            }
            pm5 pm5Var4 = hq5Var.b;
            if (pm5Var4 == null || pm5Var4.getThreadData() == null || hq5Var.b.getThreadData().getThreadAlaInfo() == null) {
                return;
            }
            ThreadData threadData2 = hq5Var.b.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", hq5Var.b.b));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public AlaSubListLiveDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.l = new nq5(this.i, this.k);
            return new AlaSubListLiveDoubleViewHolder(this.l);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, hq5 hq5Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hq5Var, alaSubListLiveDoubleViewHolder})) == null) {
            Z(hq5Var);
            alaSubListLiveDoubleViewHolder.a.l(hq5Var);
            alaSubListLiveDoubleViewHolder.a.t(this.j);
            return alaSubListLiveDoubleViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.n = i;
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m = i;
        }
    }

    public void e0(pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pq5Var) == null) {
            this.j = pq5Var;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }
}
