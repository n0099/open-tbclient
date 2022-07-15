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
/* loaded from: classes5.dex */
public class b27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<an> c;
    public h27 d;
    public c27 e;
    public f27 f;
    public g27 g;
    public e27 h;
    public d27 i;

    public b27(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<nn> a() {
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
            this.d = new h27(this.a, vy5.z0);
            this.e = new c27(this.a, wy5.U);
            this.f = new f27(this.a, vy5.I0);
            this.g = new g27(this.a, vy5.G0);
            this.h = new e27(this.a, vy5.A0);
            this.i = new d27(this.a, vy5.H0);
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
        c27 c27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (c27Var = this.e) == null) {
            return;
        }
        c27Var.onPause();
    }

    public void f(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            g27 g27Var = this.g;
            if (g27Var != null) {
                g27Var.c0(bVar);
            }
            h27 h27Var = this.d;
            if (h27Var != null) {
                h27Var.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            h27 h27Var = this.d;
            if (h27Var != null) {
                h27Var.d0(bdUniqueId);
            }
            c27 c27Var = this.e;
            if (c27Var != null) {
                c27Var.i0(bdUniqueId);
            }
            f27 f27Var = this.f;
            if (f27Var != null) {
                f27Var.c0(bdUniqueId);
            }
            g27 g27Var = this.g;
            if (g27Var != null) {
                g27Var.d0(bdUniqueId);
            }
            e27 e27Var = this.h;
            if (e27Var != null) {
                e27Var.e0(bdUniqueId);
            }
            d27 d27Var = this.i;
            if (d27Var != null) {
                d27Var.f0(bdUniqueId);
            }
        }
    }

    public void i(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bz6Var) == null) {
            c27 c27Var = this.e;
            if (c27Var != null) {
                c27Var.j0(bz6Var);
            }
            d27 d27Var = this.i;
            if (d27Var != null) {
                d27Var.g0(bz6Var);
            }
        }
    }
}
