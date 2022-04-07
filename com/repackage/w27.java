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
public class w27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<ho> c;
    public c37 d;
    public x27 e;
    public a37 f;
    public b37 g;
    public z27 h;
    public y27 i;

    public w27(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<uo> a() {
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
            this.d = new c37(this.a, dy5.z0);
            this.e = new x27(this.a, ey5.U);
            this.f = new a37(this.a, dy5.I0);
            this.g = new b37(this.a, dy5.G0);
            this.h = new z27(this.a, dy5.A0);
            this.i = new y27(this.a, dy5.H0);
            this.d.e0(this.b);
            this.e.k0(this.b);
            this.f.d0(this.b);
            this.g.e0(this.b);
            this.h.f0(this.b);
            this.i.h0(this.b);
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
        x27 x27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (x27Var = this.e) == null) {
            return;
        }
        x27Var.onPause();
    }

    public void f(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            b37 b37Var = this.g;
            if (b37Var != null) {
                b37Var.c0(bVar);
            }
            c37 c37Var = this.d;
            if (c37Var != null) {
                c37Var.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            c37 c37Var = this.d;
            if (c37Var != null) {
                c37Var.d0(bdUniqueId);
            }
            x27 x27Var = this.e;
            if (x27Var != null) {
                x27Var.i0(bdUniqueId);
            }
            a37 a37Var = this.f;
            if (a37Var != null) {
                a37Var.c0(bdUniqueId);
            }
            b37 b37Var = this.g;
            if (b37Var != null) {
                b37Var.d0(bdUniqueId);
            }
            z27 z27Var = this.h;
            if (z27Var != null) {
                z27Var.e0(bdUniqueId);
            }
            y27 y27Var = this.i;
            if (y27Var != null) {
                y27Var.f0(bdUniqueId);
            }
        }
    }

    public void i(xz6 xz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xz6Var) == null) {
            x27 x27Var = this.e;
            if (x27Var != null) {
                x27Var.j0(xz6Var);
            }
            y27 y27Var = this.i;
            if (y27Var != null) {
                y27Var.g0(xz6Var);
            }
        }
    }
}
