package d.a.s0.u0.r1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f66940a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f66941b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f66942c;

    /* renamed from: d  reason: collision with root package name */
    public b f66943d;

    public c(d.a.c.a.f fVar, BdTypeListView bdTypeListView) {
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
        this.f66942c = new ArrayList();
        this.f66940a = fVar;
        this.f66941b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b((TbPageContext) this.f66940a, d.a.s0.u0.r1.a.a.b.f66902f);
            this.f66943d = bVar;
            this.f66942c.add(bVar);
            this.f66941b.a(this.f66942c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f66941b.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f66941b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            for (d.a.c.k.e.a aVar : this.f66942c) {
                if (aVar != null) {
                    aVar.a0(wVar);
                }
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f66941b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
