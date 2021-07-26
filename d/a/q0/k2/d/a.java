package d.a.q0.k2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.k2.c.d;
import d.a.q0.k2.c.e;
import d.a.q0.k2.c.f;
import d.a.q0.k2.c.g;
import d.a.q0.k2.e.h;
import d.a.q0.k2.e.i;
import d.a.q0.k2.e.k;
import d.a.q0.k2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f59976a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.k2.c.a f59977b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.k2.c.b f59978c;

    /* renamed from: d  reason: collision with root package name */
    public g f59979d;

    /* renamed from: e  reason: collision with root package name */
    public d f59980e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.k2.c.c f59981f;

    /* renamed from: g  reason: collision with root package name */
    public f f59982g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f59983h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.d.k.e.a> f59984i;

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
        this.f59984i = new ArrayList();
        this.f59983h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59977b.e0();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.f59976a = new e(tbPageContext, i.f60026f);
            this.f59977b = new d.a.q0.k2.c.a(tbPageContext, d.a.q0.k2.e.d.k);
            this.f59978c = new d.a.q0.k2.c.b(tbPageContext, d.a.q0.k2.e.e.f60005e);
            this.f59979d = new g(tbPageContext, n.f60046f);
            this.f59980e = new d(tbPageContext, h.p);
            this.f59982g = new f(tbPageContext, k.f60036f);
            this.f59981f = new d.a.q0.k2.c.c(tbPageContext, d.a.q0.k2.e.g.f60015g);
            this.f59984i.add(this.f59976a);
            this.f59984i.add(this.f59977b);
            this.f59984i.add(this.f59978c);
            this.f59984i.add(this.f59979d);
            this.f59984i.add(this.f59980e);
            this.f59984i.add(this.f59981f);
            this.f59984i.add(this.f59982g);
            bdTypeListView.a(this.f59984i);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.f59983h) != null && (bdTypeListView.getAdapter2() instanceof d.a.d.k.e.e)) {
            this.f59983h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59977b.i0();
        }
    }
}
