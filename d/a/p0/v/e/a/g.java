package d.a.p0.v.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f64660a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64661b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f64662c;

    /* renamed from: d  reason: collision with root package name */
    public f f64663d;

    /* renamed from: e  reason: collision with root package name */
    public c f64664e;

    /* renamed from: f  reason: collision with root package name */
    public a f64665f;

    /* renamed from: g  reason: collision with root package name */
    public b f64666g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64662c = new ArrayList();
        this.f64660a = fVar;
        this.f64661b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f64660a, d.a.p0.v.h.b.a.f64765g);
                this.f64664e = cVar;
                this.f64662c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f64660a, d.a.p0.v.h.b.a.f64765g);
                this.f64663d = fVar;
                this.f64662c.add(fVar);
            }
            this.f64665f = new a((TbPageContext) this.f64660a, d.a.p0.v.e.b.a.f64667e);
            this.f64666g = new b((TbPageContext) this.f64660a, d.a.p0.v.e.b.b.f64668e);
            this.f64662c.add(this.f64665f);
            this.f64662c.add(this.f64666g);
            this.f64661b.a(this.f64662c);
        }
    }

    public void b(d.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            f fVar = this.f64663d;
            if (fVar != null) {
                fVar.h0(cVar);
            }
            c cVar2 = this.f64664e;
            if (cVar2 != null) {
                cVar2.h0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f64661b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
