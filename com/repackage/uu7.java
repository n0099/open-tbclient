package com.repackage;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class uu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public s08 b;
    public TbPageContext<?> c;
    public List<bn> d;
    public un e;
    public vu7 f;
    public wu7 g;
    public xu7 h;
    public yu7 i;
    public zu7 j;
    public av7 k;
    public PbRecomChildTitleAdapter l;
    public pw7 m;

    public uu7(s08 s08Var, BdUniqueId bdUniqueId, un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s08Var, bdUniqueId, unVar};
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
        this.e = unVar;
        this.a = bdUniqueId;
        this.b = s08Var;
        this.c = s08Var.getPageContext();
        c();
        g(unVar);
        unVar.a(this.d);
    }

    public List<bn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.u() == null) {
                return null;
            }
            return this.l.u().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = new xu7(this.c, n06.B0);
            this.g = new wu7(this.c, n06.C0);
            this.f = new vu7(this.c, n06.D0);
            this.i = new yu7(this.c, n06.A0);
            this.j = new zu7(this.c, n06.G0);
            this.k = new av7(this.c, o06.U);
            this.l = new PbRecomChildTitleAdapter(this.b, y06.b);
            this.m = new pw7(this.b, kt7.c, this.a);
            this.d.add(this.h);
            this.d.add(this.g);
            this.d.add(this.f);
            this.d.add(this.i);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
        }
    }

    public void d() {
        un unVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (unVar = this.e) == null || unVar.getListAdapter() == null) {
            return;
        }
        this.e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, et7Var) == null) {
        }
    }

    public final void g(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, unVar) == null) {
            this.h.x(unVar);
            this.g.x(unVar);
            this.f.x(unVar);
            this.i.x(unVar);
            this.j.x(unVar);
            this.k.A(unVar);
        }
    }

    public void h(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.e.setData(list);
        }
    }
}
