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
/* loaded from: classes6.dex */
public class l17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<an> c;
    public r17 d;
    public m17 e;
    public p17 f;
    public q17 g;
    public o17 h;
    public n17 i;

    public l17(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.d = new r17(this.a, yx5.z0);
            this.e = new m17(this.a, zx5.U);
            this.f = new p17(this.a, yx5.I0);
            this.g = new q17(this.a, yx5.G0);
            this.h = new o17(this.a, yx5.A0);
            this.i = new n17(this.a, yx5.H0);
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
        m17 m17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (m17Var = this.e) == null) {
            return;
        }
        m17Var.onPause();
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
            q17 q17Var = this.g;
            if (q17Var != null) {
                q17Var.c0(bVar);
            }
            r17 r17Var = this.d;
            if (r17Var != null) {
                r17Var.c0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            r17 r17Var = this.d;
            if (r17Var != null) {
                r17Var.d0(bdUniqueId);
            }
            m17 m17Var = this.e;
            if (m17Var != null) {
                m17Var.i0(bdUniqueId);
            }
            p17 p17Var = this.f;
            if (p17Var != null) {
                p17Var.c0(bdUniqueId);
            }
            q17 q17Var = this.g;
            if (q17Var != null) {
                q17Var.d0(bdUniqueId);
            }
            o17 o17Var = this.h;
            if (o17Var != null) {
                o17Var.e0(bdUniqueId);
            }
            n17 n17Var = this.i;
            if (n17Var != null) {
                n17Var.f0(bdUniqueId);
            }
        }
    }

    public void i(ly6 ly6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ly6Var) == null) {
            m17 m17Var = this.e;
            if (m17Var != null) {
                m17Var.j0(ly6Var);
            }
            n17 n17Var = this.i;
            if (n17Var != null) {
                n17Var.g0(ly6Var);
            }
        }
    }
}
