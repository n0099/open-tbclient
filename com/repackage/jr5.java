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
/* loaded from: classes6.dex */
public class jr5 extends ho<lr5, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public tr5 j;
    public boolean k;
    public rr5 l;
    public int m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jr5(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), lr5.c);
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

    public final void Z(lr5 lr5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lr5Var) == null) || lr5Var == null) {
            return;
        }
        int i = this.n;
        if (i == 1) {
            if (lr5Var.a != null) {
                dq5 c = dq5.c();
                dq5 c2 = dq5.c();
                int i2 = this.m;
                tn5 tn5Var = lr5Var.a;
                c.a(c2.e(i2, "c12117", tn5Var.a, tn5Var.b, tn5Var.getThreadData()));
            }
            if (lr5Var.b != null) {
                dq5 c3 = dq5.c();
                dq5 c4 = dq5.c();
                int i3 = this.m;
                tn5 tn5Var2 = lr5Var.b;
                c3.a(c4.e(i3, "c12117", tn5Var2.a, tn5Var2.b, tn5Var2.getThreadData()));
            }
        } else if (i == 2) {
            tn5 tn5Var3 = lr5Var.a;
            if (tn5Var3 != null && tn5Var3.getThreadData() != null && lr5Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = lr5Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", lr5Var.a.b));
            }
            tn5 tn5Var4 = lr5Var.b;
            if (tn5Var4 == null || tn5Var4.getThreadData() == null || lr5Var.b.getThreadData().getThreadAlaInfo() == null) {
                return;
            }
            ThreadData threadData2 = lr5Var.b.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", lr5Var.b.b));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: a0 */
    public AlaSubListLiveDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.l = new rr5(this.i, this.k);
            return new AlaSubListLiveDoubleViewHolder(this.l);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, lr5 lr5Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lr5Var, alaSubListLiveDoubleViewHolder})) == null) {
            Z(lr5Var);
            alaSubListLiveDoubleViewHolder.a.l(lr5Var);
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

    public void e0(tr5 tr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tr5Var) == null) {
            this.j = tr5Var;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }
}
