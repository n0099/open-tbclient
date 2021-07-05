package d.a.s0.k2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.k2.c.d;
import d.a.s0.k2.c.e;
import d.a.s0.k2.c.f;
import d.a.s0.k2.c.g;
import d.a.s0.k2.e.h;
import d.a.s0.k2.e.i;
import d.a.s0.k2.e.k;
import d.a.s0.k2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f62599a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.k2.c.a f62600b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.k2.c.b f62601c;

    /* renamed from: d  reason: collision with root package name */
    public g f62602d;

    /* renamed from: e  reason: collision with root package name */
    public d f62603e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.k2.c.c f62604f;

    /* renamed from: g  reason: collision with root package name */
    public f f62605g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f62606h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62607i;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62607i = new ArrayList();
        this.f62606h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62600b.f0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f62599a = new e(tbPageContext, i.f62649f);
            this.f62600b = new d.a.s0.k2.c.a(tbPageContext, d.a.s0.k2.e.d.k);
            this.f62601c = new d.a.s0.k2.c.b(tbPageContext, d.a.s0.k2.e.e.f62628e);
            this.f62602d = new g(tbPageContext, n.f62669f);
            this.f62603e = new d(tbPageContext, h.p);
            this.f62605g = new f(tbPageContext, k.f62659f);
            this.f62604f = new d.a.s0.k2.c.c(tbPageContext, d.a.s0.k2.e.g.f62638g);
            this.f62607i.add(this.f62599a);
            this.f62607i.add(this.f62600b);
            this.f62607i.add(this.f62601c);
            this.f62607i.add(this.f62602d);
            this.f62607i.add(this.f62603e);
            this.f62607i.add(this.f62604f);
            this.f62607i.add(this.f62605g);
            bdTypeListView.a(this.f62607i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f62606h) != null && (bdTypeListView.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f62606h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62600b.i0();
        }
    }
}
