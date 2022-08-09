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
public class l38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f38 a;
    public c38 b;
    public k38 c;
    public g38 d;
    public j38 e;
    public e38 f;
    public h38 g;
    public i38 h;
    public BdTypeListView i;
    public d38 j;
    public List<bn> k;

    public l38(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new f38(tbPageContext, x38.b);
            this.b = new c38(tbPageContext, r38.f);
            this.c = new k38(tbPageContext, d48.b);
            this.d = new g38(tbPageContext, t38.b);
            this.e = new j38(tbPageContext, u38.b);
            this.j = new d38(tbPageContext, v38.c);
            this.g = new h38(tbPageContext, z38.b);
            this.h = new i38(tbPageContext, a48.b);
            this.f = new e38(tbPageContext, w38.l);
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
        h38 h38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (h38Var = this.g) == null) {
            return;
        }
        h38Var.onScroll();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.w();
        }
    }
}
