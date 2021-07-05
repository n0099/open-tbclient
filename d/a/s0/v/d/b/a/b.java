package d.a.s0.v.d.b.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f67440a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f67441b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f67442c;

    /* renamed from: d  reason: collision with root package name */
    public a f67443d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.v.d.g.a.a f67444e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v.d.g.a.b f67445f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67442c = new ArrayList();
        this.f67440a = tbPageContext;
        this.f67441b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.s0.v.d.g.a.b bVar = new d.a.s0.v.d.g.a.b((TbPageContext) this.f67440a);
            this.f67445f = bVar;
            bVar.i0(1);
            d.a.s0.v.d.g.a.a aVar = new d.a.s0.v.d.g.a.a((TbPageContext) this.f67440a);
            this.f67444e = aVar;
            aVar.i0(1);
            this.f67443d = new a((TbPageContext) this.f67440a, d.a.s0.v.d.b.b.b.j);
            this.f67442c.add(this.f67445f);
            this.f67442c.add(this.f67444e);
            this.f67442c.add(this.f67443d);
            this.f67441b.a(this.f67442c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f67441b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f67441b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(d.a.s0.v.d.g.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f67445f.k0(fVar);
            this.f67444e.k0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f67441b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f67445f.j0(i2);
            this.f67444e.j0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f67443d.k0(iAlaSquareTabController);
        }
    }
}
