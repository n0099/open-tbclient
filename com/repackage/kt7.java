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
/* loaded from: classes6.dex */
public class kt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public cz7 b;
    public TbPageContext<?> c;
    public List<ho> d;
    public zo e;
    public lt7 f;
    public mt7 g;
    public nt7 h;
    public ot7 i;
    public pt7 j;
    public qt7 k;
    public PbRecomChildTitleAdapter l;
    public ev7 m;

    public kt7(cz7 cz7Var, BdUniqueId bdUniqueId, zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cz7Var, bdUniqueId, zoVar};
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
        this.e = zoVar;
        this.a = bdUniqueId;
        this.b = cz7Var;
        this.c = cz7Var.getPageContext();
        c();
        g(zoVar);
        zoVar.a(this.d);
    }

    public List<ho> a() {
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
            this.h = new nt7(this.c, dy5.B0);
            this.g = new mt7(this.c, dy5.C0);
            this.f = new lt7(this.c, dy5.D0);
            this.i = new ot7(this.c, dy5.A0);
            this.j = new pt7(this.c, dy5.G0);
            this.k = new qt7(this.c, ey5.U);
            this.l = new PbRecomChildTitleAdapter(this.b, ny5.b);
            this.m = new ev7(this.b, es7.c, this.a);
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
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zoVar = this.e) == null || zoVar.getListAdapter() == null) {
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

    public void f(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yr7Var) == null) {
        }
    }

    public final void g(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zoVar) == null) {
            this.h.e0(zoVar);
            this.g.e0(zoVar);
            this.f.e0(zoVar);
            this.i.e0(zoVar);
            this.j.e0(zoVar);
            this.k.h0(zoVar);
        }
    }

    public void h(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.e.setData(list);
        }
    }
}
