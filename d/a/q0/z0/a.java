package d.a.q0.z0;

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
import d.a.d.k.e.n;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbListView f67172a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f67173b;

    /* renamed from: c  reason: collision with root package name */
    public View f67174c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f67175d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f67176e;

    /* renamed from: f  reason: collision with root package name */
    public g f67177f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.z0.b.a f67178g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f67179h;

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
        this.f67173b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f67174c = this.f67173b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f67173b.findViewById(R.id.view_navigation_bar);
        this.f67175d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f67175d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f67179h = (NoNetworkView) this.f67173b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f67173b.getPageContext().getPageActivity());
        this.f67172a = pbListView;
        pbListView.a();
        this.f67172a.O();
        this.f67176e = (BdTypeListView) this.f67173b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f67173b.getPageContext());
        this.f67177f = gVar;
        BaseActivity baseActivity2 = this.f67173b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f67173b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f67176e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f67176e.setPullRefresh(this.f67177f);
        d.a.q0.z0.b.a aVar = new d.a.q0.z0.b.a(this.f67173b.getPageContext(), this.f67176e);
        this.f67178g = aVar;
        this.f67176e.a(aVar.a());
        this.f67176e.setNextPage(this.f67172a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67176e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67176e.setVisibility(0);
            this.f67173b.hideLoadingView(this.f67174c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67176e.setVisibility(0);
            this.f67173b.hideNetRefreshView(this.f67174c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f67172a.A(this.f67173b.getResources().getString(R.string.network_ungeilivable));
            this.f67172a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f67172a.A(this.f67173b.getResources().getString(R.string.list_no_more));
            this.f67172a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f67172a.O();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f67178g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f67175d.onChangeSkinType(this.f67173b.getPageContext(), i2);
            this.f67172a.o(R.color.CAM_X0204);
            this.f67172a.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f67172a.d(i2);
            this.f67179h.c(this.f67173b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f67179h.a(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f67176e.setVisibility(8);
            this.f67173b.showLoadingView(this.f67174c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f67176e.setVisibility(8);
            this.f67173b.showNetRefreshView(this.f67174c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f67176e.F();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f67176e.setData(list);
    }
}
