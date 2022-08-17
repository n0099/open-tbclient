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
public class nq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<bn> b;
    public List<on> c;
    public mq7 d;
    public kq7 e;
    public lq7 f;
    public br7 g;

    public nq7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void a(int i, sq7 sq7Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), sq7Var, Integer.valueOf(i2)}) == null) {
            new xq7().a(i, sq7Var, i2, this.c, this.a);
        }
    }

    public void b(boolean z) {
        List<on> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.c) == null || list.size() <= 0) {
            return;
        }
        for (on onVar : this.c) {
            if (onVar != null && (onVar instanceof tq7)) {
                tq7 tq7Var = (tq7) onVar;
                tq7Var.t(z);
                h(tq7Var);
            }
        }
        this.a.getAdapter().notifyDataSetChanged();
    }

    public List<on> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void d(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bdTypeRecyclerView) == null) {
            this.d = new mq7(context, vq7.c);
            this.e = new kq7(context, tq7.i);
            this.f = new lq7(context, uq7.d);
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
            List<on> list = this.c;
            if (list != null && list.size() > 0) {
                for (on onVar : this.c) {
                    if (onVar != null && (onVar instanceof tq7) && ((tq7) onVar).k()) {
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
            List<on> list = this.c;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (on onVar : this.c) {
                if (onVar != null && (onVar instanceof tq7) && !((tq7) onVar).k()) {
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
            mq7 mq7Var = this.d;
            if (mq7Var != null) {
                mq7Var.notifyDataSetChanged();
            }
            kq7 kq7Var = this.e;
            if (kq7Var != null) {
                kq7Var.notifyDataSetChanged();
            }
            lq7 lq7Var = this.f;
            if (lq7Var != null) {
                lq7Var.notifyDataSetChanged();
            }
        }
    }

    public final void h(tq7 tq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tq7Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 3);
            statisticItem.param("fid", tq7Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(ar7 ar7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ar7Var) == null) {
            this.f.x(ar7Var);
        }
    }

    public void j(List<qq7> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || this.a == null) {
            return;
        }
        List<on> b = new xq7().b(list);
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

    public void k(br7 br7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, br7Var) == null) {
            this.g = br7Var;
            this.e.z(br7Var);
            this.f.y(br7Var);
        }
    }
}
