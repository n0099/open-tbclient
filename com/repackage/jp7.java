package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<eo> b;
    public List<ro> c;
    public ip7 d;
    public gp7 e;
    public hp7 f;
    public yp7 g;

    public jp7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        d(context, bdTypeRecyclerView);
    }

    public void a(int i, pp7 pp7Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), pp7Var, Integer.valueOf(i2)}) == null) {
            new up7().a(i, pp7Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<ro> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.c) == null || list.size() <= 0) {
            return;
        }
        for (ro roVar : this.c) {
            if (roVar != null && (roVar instanceof qp7)) {
                qp7 qp7Var = (qp7) roVar;
                qp7Var.u(z);
                h(qp7Var);
            }
        }
        this.a.getAdapter().notifyDataSetChanged();
    }

    public List<ro> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.d = new ip7(context, sp7.c);
            this.e = new gp7(context, qp7.i);
            this.f = new hp7(context, rp7.d);
            this.b.add(this.d);
            this.b.add(this.e);
            this.b.add(this.f);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.a(this.b);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<ro> list = this.c;
            if (list != null && list.size() > 0) {
                for (ro roVar : this.c) {
                    if (roVar != null && (roVar instanceof qp7) && ((qp7) roVar).k()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<ro> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (ro roVar : this.c) {
                if (roVar != null && (roVar instanceof qp7) && !((qp7) roVar).k()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ip7 ip7Var = this.d;
            if (ip7Var != null) {
                ip7Var.H();
            }
            gp7 gp7Var = this.e;
            if (gp7Var != null) {
                gp7Var.H();
            }
            hp7 hp7Var = this.f;
            if (hp7Var != null) {
                hp7Var.H();
            }
        }
    }

    public final void h(qp7 qp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, qp7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", qp7Var.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(xp7 xp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xp7Var) == null) {
            this.f.e0(xp7Var);
        }
    }

    public void j(List<np7> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<ro> b = new up7().b(list);
        if (ListUtils.isEmpty(this.c)) {
            this.c = b;
        } else {
            this.c.addAll(b);
        }
        if (ListUtils.isEmpty(this.c)) {
            return;
        }
        this.a.setData(this.c);
        this.g.a();
    }

    public void k(yp7 yp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yp7Var) == null) {
            this.g = yp7Var;
            this.e.g0(yp7Var);
            this.f.f0(yp7Var);
        }
    }
}
