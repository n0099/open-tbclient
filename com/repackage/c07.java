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
public class c07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<wm> c;
    public i07 d;
    public d07 e;
    public g07 f;
    public h07 g;
    public f07 h;
    public e07 i;

    public c07(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<jn> a() {
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
            this.d = new i07(this.a, zw5.z0);
            this.e = new d07(this.a, ax5.U);
            this.f = new g07(this.a, zw5.I0);
            this.g = new h07(this.a, zw5.G0);
            this.h = new f07(this.a, zw5.A0);
            this.i = new e07(this.a, zw5.H0);
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
        d07 d07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (d07Var = this.e) == null) {
            return;
        }
        d07Var.onPause();
    }

    public void f(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            h07 h07Var = this.g;
            if (h07Var != null) {
                h07Var.c0(bVar);
            }
            i07 i07Var = this.d;
            if (i07Var != null) {
                i07Var.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            i07 i07Var = this.d;
            if (i07Var != null) {
                i07Var.d0(bdUniqueId);
            }
            d07 d07Var = this.e;
            if (d07Var != null) {
                d07Var.i0(bdUniqueId);
            }
            g07 g07Var = this.f;
            if (g07Var != null) {
                g07Var.c0(bdUniqueId);
            }
            h07 h07Var = this.g;
            if (h07Var != null) {
                h07Var.d0(bdUniqueId);
            }
            f07 f07Var = this.h;
            if (f07Var != null) {
                f07Var.e0(bdUniqueId);
            }
            e07 e07Var = this.i;
            if (e07Var != null) {
                e07Var.f0(bdUniqueId);
            }
        }
    }

    public void i(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dx6Var) == null) {
            d07 d07Var = this.e;
            if (d07Var != null) {
                d07Var.j0(dx6Var);
            }
            e07 e07Var = this.i;
            if (e07Var != null) {
                e07Var.g0(dx6Var);
            }
        }
    }
}
