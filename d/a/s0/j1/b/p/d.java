package d.a.s0.j1.b.p;

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
import d.a.s0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f62308a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f62309b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62310c;

    /* renamed from: d  reason: collision with root package name */
    public b f62311d;

    /* renamed from: e  reason: collision with root package name */
    public b f62312e;

    /* renamed from: f  reason: collision with root package name */
    public b f62313f;

    /* renamed from: g  reason: collision with root package name */
    public b f62314g;

    /* renamed from: h  reason: collision with root package name */
    public b f62315h;

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
        this.f62310c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f62308a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f62308a) == null) {
            return;
        }
        bdTypeRecyclerView.D(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f62311d = new b(tbPageContext, a.x);
            this.f62312e = new b(tbPageContext, a.y);
            this.f62313f = new b(tbPageContext, a.B);
            this.f62314g = new b(tbPageContext, a.A);
            this.f62315h = new b(tbPageContext, a.z);
            this.f62310c.add(this.f62311d);
            this.f62310c.add(this.f62312e);
            this.f62310c.add(this.f62313f);
            this.f62310c.add(this.f62314g);
            this.f62310c.add(this.f62315h);
            this.f62308a.a(this.f62310c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62308a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.c.k.e.a aVar : this.f62310c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (d.a.c.k.e.a aVar : this.f62310c) {
                if (aVar != null) {
                    aVar.a0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f62308a.setData(arrayList);
            this.f62309b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (d.a.c.k.e.a aVar : this.f62310c) {
                if (aVar != null) {
                    aVar.b0(xVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f62315h.h0(b0Var);
            this.f62314g.h0(b0Var);
            this.f62313f.h0(b0Var);
        }
    }
}
