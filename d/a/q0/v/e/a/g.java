package d.a.q0.v.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.a.f f65305a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65306b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f65307c;

    /* renamed from: d  reason: collision with root package name */
    public f f65308d;

    /* renamed from: e  reason: collision with root package name */
    public c f65309e;

    /* renamed from: f  reason: collision with root package name */
    public a f65310f;

    /* renamed from: g  reason: collision with root package name */
    public b f65311g;

    public g(d.a.d.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
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
        this.f65307c = new ArrayList();
        this.f65305a = fVar;
        this.f65306b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f65305a, d.a.q0.v.h.b.a.f65410g);
                this.f65309e = cVar;
                this.f65307c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f65305a, d.a.q0.v.h.b.a.f65410g);
                this.f65308d = fVar;
                this.f65307c.add(fVar);
            }
            this.f65310f = new a((TbPageContext) this.f65305a, d.a.q0.v.e.b.a.f65312e);
            this.f65311g = new b((TbPageContext) this.f65305a, d.a.q0.v.e.b.b.f65313e);
            this.f65307c.add(this.f65310f);
            this.f65307c.add(this.f65311g);
            this.f65306b.a(this.f65307c);
        }
    }

    public void b(d.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            f fVar = this.f65308d;
            if (fVar != null) {
                fVar.g0(cVar);
            }
            c cVar2 = this.f65309e;
            if (cVar2 != null) {
                cVar2.g0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f65306b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
