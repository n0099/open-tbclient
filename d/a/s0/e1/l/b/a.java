package d.a.s0.e1.l.b;

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
import d.a.c.k.e.n;
import d.a.s0.a0.e0.k;
import d.a.s0.a0.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59096a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59097b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f59098c;

    /* renamed from: d  reason: collision with root package name */
    public g f59099d;

    /* renamed from: e  reason: collision with root package name */
    public b f59100e;

    /* renamed from: f  reason: collision with root package name */
    public e f59101f;

    /* renamed from: g  reason: collision with root package name */
    public f f59102g;

    /* renamed from: h  reason: collision with root package name */
    public d f59103h;

    /* renamed from: i  reason: collision with root package name */
    public c f59104i;

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
        this.f59096a = tbPageContext;
        this.f59097b = bdTypeRecyclerView;
        this.f59098c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f59097b;
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
            this.f59099d = new g(this.f59096a, k.C0);
            this.f59100e = new b(this.f59096a, l.X);
            this.f59101f = new e(this.f59096a, k.K0);
            this.f59102g = new f(this.f59096a, k.I0);
            this.f59103h = new d(this.f59096a, k.D0);
            this.f59104i = new c(this.f59096a, k.J0);
            this.f59099d.k0(this.f59097b);
            this.f59100e.t0(this.f59097b);
            this.f59101f.j0(this.f59097b);
            this.f59102g.k0(this.f59097b);
            this.f59103h.l0(this.f59097b);
            this.f59104i.p0(this.f59097b);
            this.f59098c.add(this.f59099d);
            this.f59098c.add(this.f59100e);
            this.f59098c.add(this.f59101f);
            this.f59098c.add(this.f59102g);
            this.f59098c.add(this.f59103h);
            this.f59098c.add(this.f59104i);
            this.f59097b.a(this.f59098c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f59097b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f59100e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f59097b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f59102g;
            if (fVar != null) {
                fVar.i0(bVar);
            }
            g gVar = this.f59099d;
            if (gVar != null) {
                gVar.i0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f59099d;
            if (gVar != null) {
                gVar.j0(bdUniqueId);
            }
            b bVar = this.f59100e;
            if (bVar != null) {
                bVar.q0(bdUniqueId);
            }
            e eVar = this.f59101f;
            if (eVar != null) {
                eVar.i0(bdUniqueId);
            }
            f fVar = this.f59102g;
            if (fVar != null) {
                fVar.j0(bdUniqueId);
            }
            d dVar = this.f59103h;
            if (dVar != null) {
                dVar.k0(bdUniqueId);
            }
            c cVar = this.f59104i;
            if (cVar != null) {
                cVar.l0(bdUniqueId);
            }
        }
    }

    public void i(d.a.s0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            b bVar = this.f59100e;
            if (bVar != null) {
                bVar.s0(eVar);
            }
            c cVar = this.f59104i;
            if (cVar != null) {
                cVar.m0(eVar);
            }
        }
    }
}
