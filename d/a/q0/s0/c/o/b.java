package d.a.q0.s0.c.o;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f62691a;

    /* renamed from: b  reason: collision with root package name */
    public View f62692b;

    /* renamed from: c  reason: collision with root package name */
    public View f62693c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62694d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62695e;

    /* renamed from: f  reason: collision with root package name */
    public g f62696f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f62697g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.s0.c.o.a f62698h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62699e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62699e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62699e.f62691a.finish();
            }
        }
    }

    public b(BaseActivity baseActivity) {
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
        this.f62691a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f62692b = this.f62691a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62691a.findViewById(R.id.view_navigation_bar);
        this.f62694d = navigationBar;
        navigationBar.setCenterTextTitle(this.f62691a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f62694d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62691a.setNetRefreshViewTopMargin(BdListViewHelper.f13245a);
        this.f62697g = (NoNetworkView) this.f62691a.findViewById(R.id.view_no_network);
        this.f62695e = (BdTypeListView) this.f62691a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f62691a.getPageContext());
        this.f62696f = gVar;
        gVar.a0(this.f62691a.getUniqueId());
        BaseActivity baseActivity2 = this.f62691a;
        if (baseActivity2 instanceof f.g) {
            this.f62696f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f62691a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f62695e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f62695e.setPullRefresh(this.f62696f);
        this.f62693c = BdListViewHelper.d(this.f62691a.getPageContext().getPageActivity(), this.f62695e, BdListViewHelper.HeadType.DEFAULT);
        d.a.q0.s0.c.o.a aVar = new d.a.q0.s0.c.o.a(this.f62691a, this.f62695e);
        this.f62698h = aVar;
        this.f62695e.a(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f62693c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62695e.A(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62695e.setVisibility(0);
            this.f62691a.hideLoadingView(this.f62692b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62695e.setVisibility(0);
            this.f62691a.hideNetRefreshView(this.f62692b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f62695e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f62698h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f62694d.onChangeSkinType(this.f62691a.getPageContext(), i2);
            this.f62697g.c(this.f62691a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f62692b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62698h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f62697g.a(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f62695e.setVisibility(8);
            this.f62691a.showLoadingView(this.f62692b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f62695e.setVisibility(8);
            this.f62691a.showNetRefreshView(this.f62692b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f62695e.F();
        }
    }
}
