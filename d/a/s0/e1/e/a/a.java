package d.a.s0.e1.e.a;

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
    public TbPageContext f58502a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58503b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f58504c;

    /* renamed from: d  reason: collision with root package name */
    public f f58505d;

    /* renamed from: e  reason: collision with root package name */
    public c f58506e;

    /* renamed from: f  reason: collision with root package name */
    public d f58507f;

    /* renamed from: g  reason: collision with root package name */
    public e f58508g;

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
        this.f58502a = tbPageContext;
        this.f58503b = bdTypeRecyclerView;
        this.f58504c = new LinkedList<>();
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f58503b;
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
            this.f58505d = new f(this.f58502a, k.C0);
            this.f58506e = new c(this.f58502a, l.X);
            this.f58507f = new d(this.f58502a, k.K0);
            this.f58508g = new e(this.f58502a, k.I0);
            this.f58505d.l0(this.f58503b);
            this.f58506e.p0(this.f58503b);
            this.f58507f.k0(this.f58503b);
            this.f58508g.m0(this.f58503b);
            this.f58504c.add(this.f58505d);
            this.f58504c.add(this.f58506e);
            this.f58504c.add(this.f58507f);
            this.f58504c.add(this.f58508g);
            this.f58503b.a(this.f58504c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f58503b) == null) {
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
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f58506e) == null) {
            return;
        }
        cVar.onPause();
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f58503b.setData(list);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f fVar = this.f58505d;
            if (fVar != null) {
                fVar.j0(i2);
            }
            c cVar = this.f58506e;
            if (cVar != null) {
                cVar.l0(i2);
            }
            d dVar = this.f58507f;
            if (dVar != null) {
                dVar.i0(i2);
            }
            e eVar = this.f58508g;
            if (eVar != null) {
                eVar.k0(i2);
            }
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (eVar = this.f58508g) == null) {
            return;
        }
        eVar.j0(bVar);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            f fVar = this.f58505d;
            if (fVar != null) {
                fVar.k0(bdUniqueId);
            }
            c cVar = this.f58506e;
            if (cVar != null) {
                cVar.m0(bdUniqueId);
            }
            d dVar = this.f58507f;
            if (dVar != null) {
                dVar.j0(bdUniqueId);
            }
            e eVar = this.f58508g;
            if (eVar != null) {
                eVar.l0(bdUniqueId);
            }
        }
    }
}
