package d.a.p0.u0.g1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.p0.u0.k;
import d.a.p0.u0.r;
import d.a.p0.u0.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f62781a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62782b;

    /* renamed from: c  reason: collision with root package name */
    public d f62783c;

    /* renamed from: d  reason: collision with root package name */
    public r f62784d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62785e;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsADFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62785e = new ArrayList();
        this.f62781a = frsADFragment;
        this.f62782b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62783c = new d(this.f62781a.getPageContext(), c.l, this.f62781a.getUniqueId());
            this.f62784d = new r(this.f62781a.getPageContext(), s.f63802f);
            this.f62785e.add(this.f62783c);
            this.f62785e.add(this.f62784d);
            e();
            this.f62782b.a(this.f62785e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62782b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (d.a.c.k.e.a aVar : this.f62785e) {
                if (aVar instanceof k) {
                    ((k) aVar).i0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f62782b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f62785e) || this.f62781a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62785e) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f62781a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f62785e) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62785e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.a0(wVar);
            }
        }
    }
}
