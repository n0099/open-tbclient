package d.a.p0.v.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.p0.v.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64287a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64288b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f64289c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f64290d;

    /* renamed from: e  reason: collision with root package name */
    public d f64291e;

    /* renamed from: f  reason: collision with root package name */
    public d f64292f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.v.d.c.d.c f64293g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.v.d.c.d.b f64294h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.v.d.c.d.a f64295i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64287a = tbPageContext;
        this.f64288b = tbPageContext.getPageActivity();
        this.f64289c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64290d = new ArrayList();
            this.f64291e = new d(this.f64287a, this.j, false);
            this.f64292f = new d(this.f64287a, this.j, true);
            this.f64293g = new d.a.p0.v.d.c.d.c(this.f64287a);
            this.f64294h = new d.a.p0.v.d.c.d.b(this.f64287a);
            this.f64295i = new d.a.p0.v.d.c.d.a(this.f64287a);
            this.f64290d.add(this.f64291e);
            this.f64290d.add(this.f64292f);
            this.f64290d.add(this.f64293g);
            this.f64290d.add(this.f64294h);
            this.f64290d.add(this.f64295i);
            this.f64289c.a(this.f64290d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f64289c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f64289c.setData(list);
        }
    }
}
