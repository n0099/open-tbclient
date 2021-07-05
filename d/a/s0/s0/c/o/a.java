package d.a.s0.s0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.e;
import d.a.s0.s0.b.c;
import d.a.s0.s0.b.d;
import d.a.s0.s0.c.f;
import d.a.s0.s0.c.g;
import d.a.s0.s0.c.h;
import d.a.s0.s0.c.i;
import d.a.s0.s0.c.j;
import d.a.s0.s0.c.k;
import d.a.s0.s0.c.l;
import d.a.s0.s0.c.m;
import d.a.s0.u0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65295a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65296b;

    /* renamed from: c  reason: collision with root package name */
    public k f65297c;

    /* renamed from: d  reason: collision with root package name */
    public m f65298d;

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
        this.f65295a = arrayList;
        this.f65296b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f65276h));
        this.f65295a.add(new i(baseActivity.getPageContext(), j.f65281g));
        this.f65295a.add(new f(baseActivity.getPageContext(), n.f66522g));
        this.f65295a.add(new d.a.s0.s0.b.a(baseActivity.getPageContext(), d.a.s0.s0.b.b.f65252f));
        this.f65295a.add(new c(baseActivity.getPageContext(), d.k));
        this.f65295a.add(new d.a.s0.s0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f65285i);
        this.f65297c = kVar;
        this.f65295a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.a.s0.s0.c.n.f65291h);
        this.f65298d = mVar;
        this.f65295a.add(mVar);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65295a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f65296b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f65296b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65297c.onDestroy();
            this.f65298d.onDestroy();
        }
    }
}
