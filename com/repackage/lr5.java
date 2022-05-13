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
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lr5 extends eo<nr5, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public wr5 j;
    public boolean k;
    public rr5 l;
    public int m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr5(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), nr5.c);
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

    public final void Z(nr5 nr5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nr5Var) == null) || nr5Var == null) {
            return;
        }
        int i = this.n;
        if (i == 1) {
            if (nr5Var.a != null) {
                gq5 c = gq5.c();
                gq5 c2 = gq5.c();
                int i2 = this.m;
                wn5 wn5Var = nr5Var.a;
                c.a(c2.e(i2, "c12117", wn5Var.a, wn5Var.b, wn5Var.getThreadData()));
            }
            if (nr5Var.b != null) {
                gq5 c3 = gq5.c();
                gq5 c4 = gq5.c();
                int i3 = this.m;
                wn5 wn5Var2 = nr5Var.b;
                c3.a(c4.e(i3, "c12117", wn5Var2.a, wn5Var2.b, wn5Var2.getThreadData()));
            }
        } else if (i == 2) {
            wn5 wn5Var3 = nr5Var.a;
            if (wn5Var3 != null && wn5Var3.getThreadData() != null && nr5Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = nr5Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", nr5Var.a.b));
            }
            wn5 wn5Var4 = nr5Var.b;
            if (wn5Var4 == null || wn5Var4.getThreadData() == null || nr5Var.b.getThreadData().getThreadAlaInfo() == null) {
                return;
            }
            ThreadData threadData2 = nr5Var.b.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", nr5Var.b.b));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public AlaSubListGameDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.l = new rr5(this.i, this.k);
            return new AlaSubListGameDoubleViewHolder(this.l);
        }
        return (AlaSubListGameDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, nr5 nr5Var, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nr5Var, alaSubListGameDoubleViewHolder})) == null) {
            Z(nr5Var);
            alaSubListGameDoubleViewHolder.a.l(nr5Var);
            alaSubListGameDoubleViewHolder.a.t(this.j);
            return alaSubListGameDoubleViewHolder.b();
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

    public void e0(wr5 wr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wr5Var) == null) {
            this.j = wr5Var;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }
}
