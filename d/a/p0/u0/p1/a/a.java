package d.a.p0.u0.p1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63491a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63492b;

    /* renamed from: c  reason: collision with root package name */
    public d f63493c;

    /* renamed from: d  reason: collision with root package name */
    public c f63494d;

    /* renamed from: e  reason: collision with root package name */
    public b f63495e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63491a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.f63492b = bdTypeRecyclerView;
            this.f63493c = new d(forumRulesShowActivity, d.a.p0.u0.p1.c.b.q);
            this.f63494d = new c(forumRulesShowActivity, d.a.p0.u0.p1.c.c.f63510h);
            this.f63495e = new b(forumRulesShowActivity, d.a.p0.u0.p1.c.a.j);
            this.f63491a.add(this.f63493c);
            this.f63491a.add(this.f63494d);
            this.f63491a.add(this.f63495e);
            bdTypeRecyclerView.a(this.f63491a);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f63492b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f63494d;
            if (cVar != null) {
                cVar.j0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f63493c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f63495e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
