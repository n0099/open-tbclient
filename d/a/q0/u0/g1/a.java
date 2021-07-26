package d.a.q0.u0.g1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.q0.u0.k;
import d.a.q0.u0.r;
import d.a.q0.u0.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f63424a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63425b;

    /* renamed from: c  reason: collision with root package name */
    public d f63426c;

    /* renamed from: d  reason: collision with root package name */
    public r f63427d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.d.k.e.a> f63428e;

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
        this.f63428e = new ArrayList();
        this.f63424a = frsADFragment;
        this.f63425b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f63426c = new d(this.f63424a.getPageContext(), c.l, this.f63424a.getUniqueId());
            this.f63427d = new r(this.f63424a.getPageContext(), s.f64447f);
            this.f63428e.add(this.f63426c);
            this.f63428e.add(this.f63427d);
            e();
            this.f63425b.a(this.f63428e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f63425b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (d.a.d.k.e.a aVar : this.f63428e) {
                if (aVar instanceof k) {
                    ((k) aVar).i0();
                }
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f63425b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f63428e) || this.f63424a == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63428e) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f63424a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f63428e) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63428e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.a0(wVar);
            }
        }
    }
}
