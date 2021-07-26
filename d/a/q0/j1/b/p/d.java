package d.a.q0.j1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.d.k.e.x;
import d.a.q0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f59687a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f59688b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.a> f59689c;

    /* renamed from: d  reason: collision with root package name */
    public b f59690d;

    /* renamed from: e  reason: collision with root package name */
    public b f59691e;

    /* renamed from: f  reason: collision with root package name */
    public b f59692f;

    /* renamed from: g  reason: collision with root package name */
    public b f59693g;

    /* renamed from: h  reason: collision with root package name */
    public b f59694h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59689c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f59687a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f59687a) == null) {
            return;
        }
        bdTypeRecyclerView.D(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f59690d = new b(tbPageContext, a.x);
            this.f59691e = new b(tbPageContext, a.y);
            this.f59692f = new b(tbPageContext, a.B);
            this.f59693g = new b(tbPageContext, a.A);
            this.f59694h = new b(tbPageContext, a.z);
            this.f59689c.add(this.f59690d);
            this.f59689c.add(this.f59691e);
            this.f59689c.add(this.f59692f);
            this.f59689c.add(this.f59693g);
            this.f59689c.add(this.f59694h);
            this.f59687a.a(this.f59689c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59687a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.d.k.e.a aVar : this.f59689c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (d.a.d.k.e.a aVar : this.f59689c) {
                if (aVar != null) {
                    aVar.a0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f59687a.setData(arrayList);
            this.f59688b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (d.a.d.k.e.a aVar : this.f59689c) {
                if (aVar != null) {
                    aVar.b0(xVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f59694h.g0(b0Var);
            this.f59693g.g0(b0Var);
            this.f59692f.g0(b0Var);
        }
    }
}
