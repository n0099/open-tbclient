package d.a.p0.j1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.c.k.e.x;
import d.a.p0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f59073a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f59074b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59075c;

    /* renamed from: d  reason: collision with root package name */
    public b f59076d;

    /* renamed from: e  reason: collision with root package name */
    public b f59077e;

    /* renamed from: f  reason: collision with root package name */
    public b f59078f;

    /* renamed from: g  reason: collision with root package name */
    public b f59079g;

    /* renamed from: h  reason: collision with root package name */
    public b f59080h;

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
        this.f59075c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f59073a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f59073a) == null) {
            return;
        }
        bdTypeRecyclerView.D(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f59076d = new b(tbPageContext, a.x);
            this.f59077e = new b(tbPageContext, a.y);
            this.f59078f = new b(tbPageContext, a.B);
            this.f59079g = new b(tbPageContext, a.A);
            this.f59080h = new b(tbPageContext, a.z);
            this.f59075c.add(this.f59076d);
            this.f59075c.add(this.f59077e);
            this.f59075c.add(this.f59078f);
            this.f59075c.add(this.f59079g);
            this.f59075c.add(this.f59080h);
            this.f59073a.a(this.f59075c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59073a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.c.k.e.a aVar : this.f59075c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (d.a.c.k.e.a aVar : this.f59075c) {
                if (aVar != null) {
                    aVar.a0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f59073a.setData(arrayList);
            this.f59074b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (d.a.c.k.e.a aVar : this.f59075c) {
                if (aVar != null) {
                    aVar.b0(xVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f59080h.h0(b0Var);
            this.f59079g.h0(b0Var);
            this.f59078f.h0(b0Var);
        }
    }
}
