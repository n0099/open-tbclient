package com.repackage;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class so5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9 a;
    public BdTypeListView b;
    public final List<an> c;
    public ro5 d;
    public as5 e;
    public bs5 f;

    public so5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = tbPageContext;
        this.b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bs5 bs5Var = new bs5((TbPageContext) this.a);
            this.f = bs5Var;
            bs5Var.c0(1);
            as5 as5Var = new as5((TbPageContext) this.a);
            this.e = as5Var;
            as5Var.c0(1);
            this.d = new ro5((TbPageContext) this.a, uo5.f);
            this.c.add(this.f);
            this.c.add(this.e);
            this.c.add(this.d);
            this.b.a(this.c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(ls5 ls5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ls5Var) == null) {
            this.f.e0(ls5Var);
            this.e.e0(ls5Var);
        }
    }

    public void d(List<nn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f.d0(i);
            this.e.d0(i);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.d.e0(iAlaSquareTabController);
        }
    }
}
