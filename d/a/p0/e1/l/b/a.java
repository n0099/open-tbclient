package d.a.p0.e1.l.b;

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
import d.a.p0.a0.e0.k;
import d.a.p0.a0.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55841a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55842b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f55843c;

    /* renamed from: d  reason: collision with root package name */
    public g f55844d;

    /* renamed from: e  reason: collision with root package name */
    public b f55845e;

    /* renamed from: f  reason: collision with root package name */
    public e f55846f;

    /* renamed from: g  reason: collision with root package name */
    public f f55847g;

    /* renamed from: h  reason: collision with root package name */
    public d f55848h;

    /* renamed from: i  reason: collision with root package name */
    public c f55849i;

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
        this.f55841a = tbPageContext;
        this.f55842b = bdTypeRecyclerView;
        this.f55843c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f55842b;
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
            this.f55844d = new g(this.f55841a, k.C0);
            this.f55845e = new b(this.f55841a, l.X);
            this.f55846f = new e(this.f55841a, k.K0);
            this.f55847g = new f(this.f55841a, k.I0);
            this.f55848h = new d(this.f55841a, k.D0);
            this.f55849i = new c(this.f55841a, k.J0);
            this.f55844d.k0(this.f55842b);
            this.f55845e.t0(this.f55842b);
            this.f55846f.j0(this.f55842b);
            this.f55847g.k0(this.f55842b);
            this.f55848h.l0(this.f55842b);
            this.f55849i.p0(this.f55842b);
            this.f55843c.add(this.f55844d);
            this.f55843c.add(this.f55845e);
            this.f55843c.add(this.f55846f);
            this.f55843c.add(this.f55847g);
            this.f55843c.add(this.f55848h);
            this.f55843c.add(this.f55849i);
            this.f55842b.a(this.f55843c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f55842b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f55845e) == null) {
            return;
        }
        bVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f55842b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            f fVar = this.f55847g;
            if (fVar != null) {
                fVar.i0(bVar);
            }
            g gVar = this.f55844d;
            if (gVar != null) {
                gVar.i0(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            g gVar = this.f55844d;
            if (gVar != null) {
                gVar.j0(bdUniqueId);
            }
            b bVar = this.f55845e;
            if (bVar != null) {
                bVar.q0(bdUniqueId);
            }
            e eVar = this.f55846f;
            if (eVar != null) {
                eVar.i0(bdUniqueId);
            }
            f fVar = this.f55847g;
            if (fVar != null) {
                fVar.j0(bdUniqueId);
            }
            d dVar = this.f55848h;
            if (dVar != null) {
                dVar.k0(bdUniqueId);
            }
            c cVar = this.f55849i;
            if (cVar != null) {
                cVar.l0(bdUniqueId);
            }
        }
    }

    public void i(d.a.p0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            b bVar = this.f55845e;
            if (bVar != null) {
                bVar.s0(eVar);
            }
            c cVar = this.f55849i;
            if (cVar != null) {
                cVar.m0(eVar);
            }
        }
    }
}
