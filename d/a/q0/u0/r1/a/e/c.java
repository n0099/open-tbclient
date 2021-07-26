package d.a.q0.u0.r1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.a.f f64368a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64369b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f64370c;

    /* renamed from: d  reason: collision with root package name */
    public b f64371d;

    public c(d.a.d.a.f fVar, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64370c = new ArrayList();
        this.f64368a = fVar;
        this.f64369b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b((TbPageContext) this.f64368a, d.a.q0.u0.r1.a.a.b.f64330f);
            this.f64371d = bVar;
            this.f64370c.add(bVar);
            this.f64369b.a(this.f64370c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f64369b.getAdapter2() instanceof d.a.d.k.e.e)) {
            this.f64369b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            for (d.a.d.k.e.a aVar : this.f64370c) {
                if (aVar != null) {
                    aVar.a0(wVar);
                }
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f64369b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
