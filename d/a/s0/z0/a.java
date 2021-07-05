package d.a.s0.z0;

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
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbListView f69691a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f69692b;

    /* renamed from: c  reason: collision with root package name */
    public View f69693c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f69694d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f69695e;

    /* renamed from: f  reason: collision with root package name */
    public g f69696f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.z0.b.a f69697g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f69698h;

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
        this.f69692b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f69693c = this.f69692b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f69692b.findViewById(R.id.view_navigation_bar);
        this.f69694d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f69694d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f69698h = (NoNetworkView) this.f69692b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f69692b.getPageContext().getPageActivity());
        this.f69691a = pbListView;
        pbListView.a();
        this.f69691a.O();
        this.f69695e = (BdTypeListView) this.f69692b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f69692b.getPageContext());
        this.f69696f = gVar;
        BaseActivity baseActivity2 = this.f69692b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f69692b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f69695e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f69695e.setPullRefresh(this.f69696f);
        d.a.s0.z0.b.a aVar = new d.a.s0.z0.b.a(this.f69692b.getPageContext(), this.f69695e);
        this.f69697g = aVar;
        this.f69695e.a(aVar.a());
        this.f69695e.setNextPage(this.f69691a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69695e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f69695e.setVisibility(0);
            this.f69692b.hideLoadingView(this.f69693c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f69695e.setVisibility(0);
            this.f69692b.hideNetRefreshView(this.f69693c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f69691a.A(this.f69692b.getResources().getString(R.string.network_ungeilivable));
            this.f69691a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f69691a.A(this.f69692b.getResources().getString(R.string.list_no_more));
            this.f69691a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f69691a.O();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f69697g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f69694d.onChangeSkinType(this.f69692b.getPageContext(), i2);
            this.f69691a.o(R.color.CAM_X0204);
            this.f69691a.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f69691a.d(i2);
            this.f69698h.c(this.f69692b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f69698h.a(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f69695e.setVisibility(8);
            this.f69692b.showLoadingView(this.f69693c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f69695e.setVisibility(8);
            this.f69692b.showNetRefreshView(this.f69693c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f69695e.F();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f69695e.setData(list);
    }
}
