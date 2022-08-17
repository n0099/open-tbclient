package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e38 a;
    public b38 b;
    public j38 c;
    public f38 d;
    public i38 e;
    public d38 f;
    public g38 g;
    public h38 h;
    public BdTypeListView i;
    public c38 j;
    public List<bn> k;

    public k38(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.i = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.t();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new e38(tbPageContext, w38.b);
            this.b = new b38(tbPageContext, q38.f);
            this.c = new j38(tbPageContext, c48.b);
            this.d = new f38(tbPageContext, s38.b);
            this.e = new i38(tbPageContext, t38.b);
            this.j = new c38(tbPageContext, u38.c);
            this.g = new g38(tbPageContext, y38.b);
            this.h = new h38(tbPageContext, z38.b);
            this.f = new d38(tbPageContext, v38.l);
            this.k.add(this.a);
            this.k.add(this.b);
            this.k.add(this.d);
            this.k.add(this.e);
            this.k.add(this.c);
            this.k.add(this.g);
            this.k.add(this.h);
            this.k.add(this.f);
            this.k.add(this.j);
            bdTypeListView.a(this.k);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.i) != null && (bdTypeListView.getAdapter2() instanceof fn)) {
            this.i.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        g38 g38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (g38Var = this.g) == null) {
            return;
        }
        g38Var.onScroll();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.w();
        }
    }
}
