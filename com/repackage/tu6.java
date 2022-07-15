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
public class tu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<an> c;
    public yu6 d;
    public vu6 e;
    public wu6 f;
    public xu6 g;

    public tu6(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.d = new yu6(this.a, vy5.z0);
            this.e = new vu6(this.a, wy5.U);
            this.f = new wu6(this.a, vy5.I0);
            this.g = new xu6(this.a, vy5.G0);
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
        vu6 vu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (vu6Var = this.e) == null) {
            return;
        }
        vu6Var.onPause();
    }

    public void f(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            yu6 yu6Var = this.d;
            if (yu6Var != null) {
                yu6Var.d0(i);
            }
            vu6 vu6Var = this.e;
            if (vu6Var != null) {
                vu6Var.f0(i);
            }
            wu6 wu6Var = this.f;
            if (wu6Var != null) {
                wu6Var.c0(i);
            }
            xu6 xu6Var = this.g;
            if (xu6Var != null) {
                xu6Var.e0(i);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        xu6 xu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (xu6Var = this.g) == null) {
            return;
        }
        xu6Var.d0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            yu6 yu6Var = this.d;
            if (yu6Var != null) {
                yu6Var.e0(bdUniqueId);
            }
            vu6 vu6Var = this.e;
            if (vu6Var != null) {
                vu6Var.g0(bdUniqueId);
            }
            wu6 wu6Var = this.f;
            if (wu6Var != null) {
                wu6Var.d0(bdUniqueId);
            }
            xu6 xu6Var = this.g;
            if (xu6Var != null) {
                xu6Var.f0(bdUniqueId);
            }
        }
    }
}
