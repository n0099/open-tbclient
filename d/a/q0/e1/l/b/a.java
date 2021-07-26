package d.a.q0.e1.l.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.a0.e0.k;
import d.a.q0.a0.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56385a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f56386b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.d.k.e.a> f56387c;

    /* renamed from: d  reason: collision with root package name */
    public g f56388d;

    /* renamed from: e  reason: collision with root package name */
    public b f56389e;

    /* renamed from: f  reason: collision with root package name */
    public e f56390f;

    /* renamed from: g  reason: collision with root package name */
    public f f56391g;

    /* renamed from: h  reason: collision with root package name */
    public d f56392h;

    /* renamed from: i  reason: collision with root package name */
    public c f56393i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.f56385a = tbPageContext;
        this.f56386b = bdTypeRecyclerView;
        this.f56387c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f56386b;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f56388d = new g(this.f56385a, k.C0);
            this.f56389e = new b(this.f56385a, l.X);
            this.f56390f = new e(this.f56385a, k.K0);
            this.f56391g = new f(this.f56385a, k.I0);
            this.f56392h = new d(this.f56385a, k.D0);
            this.f56393i = new c(this.f56385a, k.J0);
            this.f56388d.k0(this.f56386b);
            this.f56389e.r0(this.f56386b);
            this.f56390f.j0(this.f56386b);
            this.f56391g.k0(this.f56386b);
            this.f56392h.l0(this.f56386b);
            this.f56393i.n0(this.f56386b);
            this.f56387c.add(this.f56388d);
            this.f56387c.add(this.f56389e);
            this.f56387c.add(this.f56390f);
            this.f56387c.add(this.f56391g);
            this.f56387c.add(this.f56392h);
            this.f56387c.add(this.f56393i);
            this.f56386b.a(this.f56387c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f56386b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f56389e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f56386b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f56391g;
            if (fVar != null) {
                fVar.i0(bVar);
            }
            g gVar = this.f56388d;
            if (gVar != null) {
                gVar.i0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f56388d;
            if (gVar != null) {
                gVar.j0(bdUniqueId);
            }
            b bVar = this.f56389e;
            if (bVar != null) {
                bVar.o0(bdUniqueId);
            }
            e eVar = this.f56390f;
            if (eVar != null) {
                eVar.i0(bdUniqueId);
            }
            f fVar = this.f56391g;
            if (fVar != null) {
                fVar.j0(bdUniqueId);
            }
            d dVar = this.f56392h;
            if (dVar != null) {
                dVar.k0(bdUniqueId);
            }
            c cVar = this.f56393i;
            if (cVar != null) {
                cVar.l0(bdUniqueId);
            }
        }
    }

    public void i(d.a.q0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            b bVar = this.f56389e;
            if (bVar != null) {
                bVar.p0(eVar);
            }
            c cVar = this.f56393i;
            if (cVar != null) {
                cVar.m0(eVar);
            }
        }
    }
}
