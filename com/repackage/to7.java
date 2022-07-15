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
/* loaded from: classes7.dex */
public class to7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<an> b;
    public List<nn> c;
    public so7 d;
    public qo7 e;
    public ro7 f;
    public hp7 g;

    public to7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, yo7 yo7Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), yo7Var, Integer.valueOf(i2)}) == null) {
            new dp7().a(i, yo7Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<nn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.c) == null || list.size() <= 0) {
            return;
        }
        for (nn nnVar : this.c) {
            if (nnVar != null && (nnVar instanceof zo7)) {
                zo7 zo7Var = (zo7) nnVar;
                zo7Var.t(z);
                h(zo7Var);
            }
        }
        this.a.getAdapter().notifyDataSetChanged();
    }

    public List<nn> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.d = new so7(context, bp7.c);
            this.e = new qo7(context, zo7.i);
            this.f = new ro7(context, ap7.d);
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
            List<nn> list = this.c;
            if (list != null && list.size() > 0) {
                for (nn nnVar : this.c) {
                    if (nnVar != null && (nnVar instanceof zo7) && ((zo7) nnVar).k()) {
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
            List<nn> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (nn nnVar : this.c) {
                if (nnVar != null && (nnVar instanceof zo7) && !((zo7) nnVar).k()) {
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
            so7 so7Var = this.d;
            if (so7Var != null) {
                so7Var.G();
            }
            qo7 qo7Var = this.e;
            if (qo7Var != null) {
                qo7Var.G();
            }
            ro7 ro7Var = this.f;
            if (ro7Var != null) {
                ro7Var.G();
            }
        }
    }

    public final void h(zo7 zo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zo7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", zo7Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(gp7 gp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gp7Var) == null) {
            this.f.e0(gp7Var);
        }
    }

    public void j(List<wo7> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<nn> b = new dp7().b(list);
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

    public void k(hp7 hp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hp7Var) == null) {
            this.g = hp7Var;
            this.e.g0(hp7Var);
            this.f.f0(hp7Var);
        }
    }
}
