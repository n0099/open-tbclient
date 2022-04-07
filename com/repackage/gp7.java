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
public class gp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<ho> b;
    public List<uo> c;
    public fp7 d;
    public dp7 e;
    public ep7 f;
    public vp7 g;

    public gp7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, mp7 mp7Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), mp7Var, Integer.valueOf(i2)}) == null) {
            new rp7().a(i, mp7Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<uo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.c) == null || list.size() <= 0) {
            return;
        }
        for (uo uoVar : this.c) {
            if (uoVar != null && (uoVar instanceof np7)) {
                np7 np7Var = (np7) uoVar;
                np7Var.u(z);
                h(np7Var);
            }
        }
        this.a.getAdapter().notifyDataSetChanged();
    }

    public List<uo> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.d = new fp7(context, pp7.c);
            this.e = new dp7(context, np7.i);
            this.f = new ep7(context, op7.d);
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
            List<uo> list = this.c;
            if (list != null && list.size() > 0) {
                for (uo uoVar : this.c) {
                    if (uoVar != null && (uoVar instanceof np7) && ((np7) uoVar).k()) {
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
            List<uo> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (uo uoVar : this.c) {
                if (uoVar != null && (uoVar instanceof np7) && !((np7) uoVar).k()) {
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
            fp7 fp7Var = this.d;
            if (fp7Var != null) {
                fp7Var.H();
            }
            dp7 dp7Var = this.e;
            if (dp7Var != null) {
                dp7Var.H();
            }
            ep7 ep7Var = this.f;
            if (ep7Var != null) {
                ep7Var.H();
            }
        }
    }

    public final void h(np7 np7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, np7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", np7Var.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(up7 up7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, up7Var) == null) {
            this.f.e0(up7Var);
        }
    }

    public void j(List<kp7> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<uo> b = new rp7().b(list);
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

    public void k(vp7 vp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vp7Var) == null) {
            this.g = vp7Var;
            this.e.g0(vp7Var);
            this.f.f0(vp7Var);
        }
    }
}
