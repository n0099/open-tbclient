package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class xt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<wm> b;
    public pn c;
    public wt6 d;
    public au6 e;
    public rt6 f;
    public tt6 g;
    public st6 h;
    public ut6 i;
    public vt6 j;

    public xt6(TbPageContext tbPageContext, pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pnVar};
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
        this.c = pnVar;
        b();
    }

    public List<jn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new zt6(this.a));
            this.b.add(new yt6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            wt6 wt6Var = new wt6(this.a);
            this.d = wt6Var;
            wt6Var.c0(this.c);
            this.b.add(this.d);
            au6 au6Var = new au6(this.a);
            this.e = au6Var;
            au6Var.c0(this.c);
            this.b.add(this.e);
            rt6 rt6Var = new rt6(this.a);
            this.f = rt6Var;
            rt6Var.c0(this.c);
            this.b.add(this.f);
            tt6 tt6Var = new tt6(this.a);
            this.g = tt6Var;
            tt6Var.c0(this.c);
            this.b.add(this.g);
            st6 st6Var = new st6(this.a);
            this.h = st6Var;
            st6Var.c0(this.c);
            this.b.add(this.h);
            ut6 ut6Var = new ut6(this.a);
            this.i = ut6Var;
            ut6Var.c0(this.c);
            this.b.add(this.i);
            vt6 vt6Var = new vt6(this.a);
            this.j = vt6Var;
            vt6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void c() {
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pnVar = this.c) == null) {
            return;
        }
        pnVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(kl4 kl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kl4Var) == null) {
            for (wm wmVar : this.b) {
                if (wmVar instanceof qt6) {
                    ((qt6) wmVar).b0(kl4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (wm wmVar : this.b) {
                wmVar.X(bdUniqueId);
            }
        }
    }
}
