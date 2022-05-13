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
public class rt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public gz7 b;
    public TbPageContext<?> c;
    public List<eo> d;
    public xo e;
    public st7 f;
    public tt7 g;
    public ut7 h;
    public vt7 i;
    public wt7 j;
    public xt7 k;
    public PbRecomChildTitleAdapter l;
    public kv7 m;

    public rt7(gz7 gz7Var, BdUniqueId bdUniqueId, xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gz7Var, bdUniqueId, xoVar};
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
        this.e = xoVar;
        this.a = bdUniqueId;
        this.b = gz7Var;
        this.c = gz7Var.getPageContext();
        c();
        g(xoVar);
        xoVar.a(this.d);
    }

    public List<eo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.b0() == null) {
                return null;
            }
            return this.l.b0().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = new ut7(this.c, gy5.B0);
            this.g = new tt7(this.c, gy5.C0);
            this.f = new st7(this.c, gy5.D0);
            this.i = new vt7(this.c, gy5.A0);
            this.j = new wt7(this.c, gy5.G0);
            this.k = new xt7(this.c, hy5.U);
            this.l = new PbRecomChildTitleAdapter(this.b, qy5.b);
            this.m = new kv7(this.b, hs7.c, this.a);
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
        xo xoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (xoVar = this.e) == null || xoVar.getListAdapter() == null) {
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

    public void f(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bs7Var) == null) {
        }
    }

    public final void g(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xoVar) == null) {
            this.h.e0(xoVar);
            this.g.e0(xoVar);
            this.f.e0(xoVar);
            this.i.e0(xoVar);
            this.j.e0(xoVar);
            this.k.h0(xoVar);
        }
    }

    public void h(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.e.setData(list);
        }
    }
}
