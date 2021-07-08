package d.a.p0.z0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbListView f66494a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f66495b;

    /* renamed from: c  reason: collision with root package name */
    public View f66496c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f66497d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f66498e;

    /* renamed from: f  reason: collision with root package name */
    public g f66499f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.z0.b.a f66500g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f66501h;

    public a(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66495b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f66496c = this.f66495b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f66495b.findViewById(R.id.view_navigation_bar);
        this.f66497d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f66497d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66501h = (NoNetworkView) this.f66495b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f66495b.getPageContext().getPageActivity());
        this.f66494a = pbListView;
        pbListView.a();
        this.f66494a.O();
        this.f66498e = (BdTypeListView) this.f66495b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f66495b.getPageContext());
        this.f66499f = gVar;
        BaseActivity baseActivity2 = this.f66495b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f66495b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f66498e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f66498e.setPullRefresh(this.f66499f);
        d.a.p0.z0.b.a aVar = new d.a.p0.z0.b.a(this.f66495b.getPageContext(), this.f66498e);
        this.f66500g = aVar;
        this.f66498e.a(aVar.a());
        this.f66498e.setNextPage(this.f66494a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66498e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f66498e.setVisibility(0);
            this.f66495b.hideLoadingView(this.f66496c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66498e.setVisibility(0);
            this.f66495b.hideNetRefreshView(this.f66496c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f66494a.A(this.f66495b.getResources().getString(R.string.network_ungeilivable));
            this.f66494a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f66494a.A(this.f66495b.getResources().getString(R.string.list_no_more));
            this.f66494a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f66494a.O();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f66500g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f66497d.onChangeSkinType(this.f66495b.getPageContext(), i2);
            this.f66494a.o(R.color.CAM_X0204);
            this.f66494a.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f66494a.d(i2);
            this.f66501h.c(this.f66495b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f66501h.a(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f66498e.setVisibility(8);
            this.f66495b.showLoadingView(this.f66496c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f66498e.setVisibility(8);
            this.f66495b.showNetRefreshView(this.f66496c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f66498e.F();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f66498e.setData(list);
    }
}
