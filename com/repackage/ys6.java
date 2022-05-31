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
public class ys6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<wm> c;
    public dt6 d;
    public at6 e;
    public bt6 f;
    public ct6 g;

    public ys6(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.d = new dt6(this.a, zw5.z0);
            this.e = new at6(this.a, ax5.U);
            this.f = new bt6(this.a, zw5.I0);
            this.g = new ct6(this.a, zw5.G0);
            this.d.f0(this.b);
            this.e.h0(this.b);
            this.f.e0(this.b);
            this.g.g0(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
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
        at6 at6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (at6Var = this.e) == null) {
            return;
        }
        at6Var.onPause();
    }

    public void f(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            dt6 dt6Var = this.d;
            if (dt6Var != null) {
                dt6Var.d0(i);
            }
            at6 at6Var = this.e;
            if (at6Var != null) {
                at6Var.f0(i);
            }
            bt6 bt6Var = this.f;
            if (bt6Var != null) {
                bt6Var.c0(i);
            }
            ct6 ct6Var = this.g;
            if (ct6Var != null) {
                ct6Var.e0(i);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        ct6 ct6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (ct6Var = this.g) == null) {
            return;
        }
        ct6Var.d0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            dt6 dt6Var = this.d;
            if (dt6Var != null) {
                dt6Var.e0(bdUniqueId);
            }
            at6 at6Var = this.e;
            if (at6Var != null) {
                at6Var.g0(bdUniqueId);
            }
            bt6 bt6Var = this.f;
            if (bt6Var != null) {
                bt6Var.d0(bdUniqueId);
            }
            ct6 ct6Var = this.g;
            if (ct6Var != null) {
                ct6Var.f0(bdUniqueId);
            }
        }
    }
}
