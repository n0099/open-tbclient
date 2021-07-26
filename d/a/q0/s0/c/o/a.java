package d.a.q0.s0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.e;
import d.a.q0.s0.b.c;
import d.a.q0.s0.b.d;
import d.a.q0.s0.c.f;
import d.a.q0.s0.c.g;
import d.a.q0.s0.c.h;
import d.a.q0.s0.c.i;
import d.a.q0.s0.c.j;
import d.a.q0.s0.c.k;
import d.a.q0.s0.c.l;
import d.a.q0.s0.c.m;
import d.a.q0.u0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.d.k.e.a> f62687a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62688b;

    /* renamed from: c  reason: collision with root package name */
    public k f62689c;

    /* renamed from: d  reason: collision with root package name */
    public m f62690d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f62687a = arrayList;
        this.f62688b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f62668h));
        this.f62687a.add(new i(baseActivity.getPageContext(), j.f62673g));
        this.f62687a.add(new f(baseActivity.getPageContext(), n.f63946g));
        this.f62687a.add(new d.a.q0.s0.b.a(baseActivity.getPageContext(), d.a.q0.s0.b.b.f62644f));
        this.f62687a.add(new c(baseActivity.getPageContext(), d.k));
        this.f62687a.add(new d.a.q0.s0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f62677i);
        this.f62689c = kVar;
        this.f62687a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.a.q0.s0.c.n.f62683h);
        this.f62690d = mVar;
        this.f62687a.add(mVar);
    }

    public List<d.a.d.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62687a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f62688b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f62688b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62689c.onDestroy();
            this.f62690d.onDestroy();
        }
    }
}
