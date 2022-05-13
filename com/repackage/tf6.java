package com.repackage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uf6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class tf6 implements of6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sf6 a;
    public TbPageContext b;
    public BdTypeListView c;
    public List<ro> d;
    public final List<eo> e;
    public boolean f;
    public int g;

    public tf6(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = false;
        this.g = -1;
        this.b = tbPageContext;
        this.c = bdTypeListView;
        this.f = z;
        d();
    }

    @Override // com.repackage.of6
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.g = i;
            if (ListUtils.isEmpty(this.d) || this.c == null) {
                return;
            }
            for (ro roVar : this.d) {
                if (roVar instanceof uf6) {
                    ((uf6) roVar).s = false;
                }
            }
            if (ki.H()) {
                if (this.g < this.d.size() - 1) {
                    List<ro> list = this.d;
                    int i2 = this.g + 1;
                    this.g = i2;
                    if (list.get(i2) instanceof uf6) {
                        ((uf6) this.d.get(this.g)).s = true;
                        BdTypeListView bdTypeListView = this.c;
                        bdTypeListView.smoothScrollToPositionFromTop(i + bdTypeListView.getHeaderViewsCount() + 1, 0);
                        g();
                    }
                } else if (this.g == this.d.size() - 1 && (this.d.get(this.g) instanceof uf6)) {
                    ((uf6) this.d.get(this.g)).s = false;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.d)) {
            return;
        }
        Iterator<ro> it = this.d.iterator();
        while (it.hasNext()) {
            ((uf6) it.next()).s = false;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.intValue;
    }

    @Override // com.repackage.of6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sf6 sf6Var = new sf6(this.b, this, this.f);
            this.a = sf6Var;
            this.e.add(sf6Var);
            this.c.a(this.e);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.d0() : invokeV.booleanValue;
    }

    public void f(String str, boolean z) {
        uf6 uf6Var;
        uf6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (ro roVar : this.d) {
            if (roVar != null && (roVar instanceof uf6) && (bVar = (uf6Var = (uf6) roVar).m) != null && str.equals(bVar.a)) {
                uf6Var.m.e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void g() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeListView = this.c) == null || bdTypeListView.getAdapter2() == null || !(this.c.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.c.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            this.a.e0(configuration);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.onDestroy();
        }
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.a.h0(i) : invokeI.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.i0();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b();
            this.g = 0;
            k();
        }
    }

    public void m(List<uf6> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) || list == null) {
            return;
        }
        if (z) {
            this.d.clear();
        }
        this.d.addAll(list);
        this.c.setData(this.d);
        if (z && list.size() > 0 && this.f && ki.H()) {
            l();
            list.get(0).s = true;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.j0();
        }
    }
}
