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
public class zs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public qy7 b;
    public TbPageContext<?> c;
    public List<an> d;
    public tn e;
    public at7 f;
    public bt7 g;
    public ct7 h;
    public dt7 i;
    public et7 j;
    public ft7 k;
    public PbRecomChildTitleAdapter l;
    public su7 m;

    public zs7(qy7 qy7Var, BdUniqueId bdUniqueId, tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy7Var, bdUniqueId, tnVar};
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
        this.e = tnVar;
        this.a = bdUniqueId;
        this.b = qy7Var;
        this.c = qy7Var.getPageContext();
        c();
        g(tnVar);
        tnVar.a(this.d);
    }

    public List<an> a() {
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
            this.h = new ct7(this.c, vy5.B0);
            this.g = new bt7(this.c, vy5.C0);
            this.f = new at7(this.c, vy5.D0);
            this.i = new dt7(this.c, vy5.A0);
            this.j = new et7(this.c, vy5.G0);
            this.k = new ft7(this.c, wy5.U);
            this.l = new PbRecomChildTitleAdapter(this.b, gz5.b);
            this.m = new su7(this.b, pr7.c, this.a);
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
        tn tnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tnVar = this.e) == null || tnVar.getListAdapter() == null) {
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

    public void f(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jr7Var) == null) {
        }
    }

    public final void g(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tnVar) == null) {
            this.h.e0(tnVar);
            this.g.e0(tnVar);
            this.f.e0(tnVar);
            this.i.e0(tnVar);
            this.j.e0(tnVar);
            this.k.h0(tnVar);
        }
    }

    public void h(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.e.setData(list);
        }
    }
}
