package d.a.q0.s1.h;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.s1.h.d.d;
import d.a.q0.s1.h.d.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.DataRes;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f62749a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f62750b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.s1.h.d.a f62751c;

    /* renamed from: d  reason: collision with root package name */
    public d f62752d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.s1.h.d.b f62753e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.s1.h.d.c f62754f;

    /* renamed from: g  reason: collision with root package name */
    public e f62755g;

    public b(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62750b = new ArrayList();
        this.f62751c = null;
        this.f62752d = null;
        this.f62753e = null;
        this.f62754f = null;
        this.f62755g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f62751c = new d.a.q0.s1.h.d.a(context, d.a.q0.s1.h.e.a.f62766g);
            this.f62752d = new d(context, d.a.q0.s1.h.e.d.p);
            this.f62753e = new d.a.q0.s1.h.d.b(context, d.a.q0.s1.h.e.b.k);
            this.f62754f = new d.a.q0.s1.h.d.c(context, d.a.q0.s1.h.e.c.k);
            this.f62755g = new e(context, d.a.q0.s1.h.e.e.f62784i);
            this.f62750b.add(this.f62751c);
            this.f62750b.add(this.f62752d);
            this.f62750b.add(this.f62753e);
            this.f62750b.add(this.f62754f);
            this.f62750b.add(this.f62755g);
            this.f62749a = bdTypeRecyclerView;
            bdTypeRecyclerView.a(this.f62750b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.s1.h.d.a aVar = this.f62751c;
            if (aVar != null) {
                aVar.L();
            }
            d dVar = this.f62752d;
            if (dVar != null) {
                dVar.L();
            }
            d.a.q0.s1.h.d.b bVar = this.f62753e;
            if (bVar != null) {
                bVar.L();
            }
            d.a.q0.s1.h.d.c cVar = this.f62754f;
            if (cVar != null) {
                cVar.L();
            }
            e eVar = this.f62755g;
            if (eVar != null) {
                eVar.L();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.f62749a == null) {
            return;
        }
        List<n> a2 = d.a.q0.s1.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        this.f62749a.setData(a2);
    }
}
