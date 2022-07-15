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
public class h18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c18 a;
    public z08 b;
    public g18 c;
    public d18 d;
    public b18 e;
    public e18 f;
    public f18 g;
    public BdTypeListView h;
    public a18 i;
    public List<an> j;

    public h18(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.j = new ArrayList();
        this.h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.a0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new c18(tbPageContext, s18.b);
            this.b = new z08(tbPageContext, n18.f);
            this.c = new g18(tbPageContext, y18.b);
            this.d = new d18(tbPageContext, p18.b);
            this.i = new a18(tbPageContext, q18.c);
            this.f = new e18(tbPageContext, u18.b);
            this.g = new f18(tbPageContext, v18.b);
            this.e = new b18(tbPageContext, r18.l);
            this.j.add(this.a);
            this.j.add(this.b);
            this.j.add(this.d);
            this.j.add(this.c);
            this.j.add(this.f);
            this.j.add(this.g);
            this.j.add(this.e);
            this.j.add(this.i);
            bdTypeListView.a(this.j);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.h) != null && (bdTypeListView.getAdapter2() instanceof en)) {
            this.h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.d0();
        }
    }
}
