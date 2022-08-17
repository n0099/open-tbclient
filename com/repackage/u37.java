package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class u37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<bn> c;
    public a47 d;
    public v37 e;
    public y37 f;
    public z37 g;
    public x37 h;
    public w37 i;

    public u37(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = bdTypeRecyclerView;
        this.c = new LinkedList<>();
        b();
    }

    public List<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new a47(this.a, n06.z0);
            this.e = new v37(this.a, o06.U);
            this.f = new y37(this.a, n06.I0);
            this.g = new z37(this.a, n06.G0);
            this.h = new x37(this.a, n06.A0);
            this.i = new w37(this.a, n06.H0);
            this.d.x(this.b);
            this.e.D(this.b);
            this.f.w(this.b);
            this.g.x(this.b);
            this.h.y(this.b);
            this.i.A(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.b.a(this.c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e() {
        v37 v37Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (v37Var = this.e) == null) {
            return;
        }
        v37Var.onPause();
    }

    public void f(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            z37 z37Var = this.g;
            if (z37Var != null) {
                z37Var.v(bVar);
            }
            a47 a47Var = this.d;
            if (a47Var != null) {
                a47Var.v(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            a47 a47Var = this.d;
            if (a47Var != null) {
                a47Var.w(bdUniqueId);
            }
            v37 v37Var = this.e;
            if (v37Var != null) {
                v37Var.B(bdUniqueId);
            }
            y37 y37Var = this.f;
            if (y37Var != null) {
                y37Var.v(bdUniqueId);
            }
            z37 z37Var = this.g;
            if (z37Var != null) {
                z37Var.w(bdUniqueId);
            }
            x37 x37Var = this.h;
            if (x37Var != null) {
                x37Var.x(bdUniqueId);
            }
            w37 w37Var = this.i;
            if (w37Var != null) {
                w37Var.y(bdUniqueId);
            }
        }
    }

    public void i(u07 u07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u07Var) == null) {
            v37 v37Var = this.e;
            if (v37Var != null) {
                v37Var.C(u07Var);
            }
            w37 w37Var = this.i;
            if (w37Var != null) {
                w37Var.z(u07Var);
            }
        }
    }
}
