package d.a.p0.k2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.k2.c.d;
import d.a.p0.k2.c.e;
import d.a.p0.k2.c.f;
import d.a.p0.k2.c.g;
import d.a.p0.k2.e.h;
import d.a.p0.k2.e.i;
import d.a.p0.k2.e.k;
import d.a.p0.k2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f59362a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.k2.c.a f59363b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.k2.c.b f59364c;

    /* renamed from: d  reason: collision with root package name */
    public g f59365d;

    /* renamed from: e  reason: collision with root package name */
    public d f59366e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.k2.c.c f59367f;

    /* renamed from: g  reason: collision with root package name */
    public f f59368g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f59369h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59370i;

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
        this.f59370i = new ArrayList();
        this.f59369h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59363b.f0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f59362a = new e(tbPageContext, i.f59412f);
            this.f59363b = new d.a.p0.k2.c.a(tbPageContext, d.a.p0.k2.e.d.k);
            this.f59364c = new d.a.p0.k2.c.b(tbPageContext, d.a.p0.k2.e.e.f59391e);
            this.f59365d = new g(tbPageContext, n.f59432f);
            this.f59366e = new d(tbPageContext, h.p);
            this.f59368g = new f(tbPageContext, k.f59422f);
            this.f59367f = new d.a.p0.k2.c.c(tbPageContext, d.a.p0.k2.e.g.f59401g);
            this.f59370i.add(this.f59362a);
            this.f59370i.add(this.f59363b);
            this.f59370i.add(this.f59364c);
            this.f59370i.add(this.f59365d);
            this.f59370i.add(this.f59366e);
            this.f59370i.add(this.f59367f);
            this.f59370i.add(this.f59368g);
            bdTypeListView.a(this.f59370i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f59369h) != null && (bdTypeListView.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f59369h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59363b.i0();
        }
    }
}
