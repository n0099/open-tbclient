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
public class z17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<eo> c;
    public f27 d;
    public a27 e;
    public d27 f;
    public e27 g;
    public c27 h;
    public b27 i;

    public z17(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<ro> a() {
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
            this.d = new f27(this.a, gy5.z0);
            this.e = new a27(this.a, hy5.U);
            this.f = new d27(this.a, gy5.I0);
            this.g = new e27(this.a, gy5.G0);
            this.h = new c27(this.a, gy5.A0);
            this.i = new b27(this.a, gy5.H0);
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
        a27 a27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (a27Var = this.e) == null) {
            return;
        }
        a27Var.onPause();
    }

    public void f(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            e27 e27Var = this.g;
            if (e27Var != null) {
                e27Var.c0(bVar);
            }
            f27 f27Var = this.d;
            if (f27Var != null) {
                f27Var.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            f27 f27Var = this.d;
            if (f27Var != null) {
                f27Var.d0(bdUniqueId);
            }
            a27 a27Var = this.e;
            if (a27Var != null) {
                a27Var.i0(bdUniqueId);
            }
            d27 d27Var = this.f;
            if (d27Var != null) {
                d27Var.c0(bdUniqueId);
            }
            e27 e27Var = this.g;
            if (e27Var != null) {
                e27Var.d0(bdUniqueId);
            }
            c27 c27Var = this.h;
            if (c27Var != null) {
                c27Var.e0(bdUniqueId);
            }
            b27 b27Var = this.i;
            if (b27Var != null) {
                b27Var.f0(bdUniqueId);
            }
        }
    }

    public void i(zy6 zy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zy6Var) == null) {
            a27 a27Var = this.e;
            if (a27Var != null) {
                a27Var.j0(zy6Var);
            }
            b27 b27Var = this.i;
            if (b27Var != null) {
                b27Var.g0(zy6Var);
            }
        }
    }
}
