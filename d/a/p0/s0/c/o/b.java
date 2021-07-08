package d.a.p0.s0.c.o;

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
import d.a.c.k.e.n;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f62077a;

    /* renamed from: b  reason: collision with root package name */
    public View f62078b;

    /* renamed from: c  reason: collision with root package name */
    public View f62079c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62080d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62081e;

    /* renamed from: f  reason: collision with root package name */
    public g f62082f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f62083g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.s0.c.o.a f62084h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62085e;

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
            this.f62085e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62085e.f62077a.finish();
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
        this.f62077a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f62078b = this.f62077a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62077a.findViewById(R.id.view_navigation_bar);
        this.f62080d = navigationBar;
        navigationBar.setCenterTextTitle(this.f62077a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f62080d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62077a.setNetRefreshViewTopMargin(BdListViewHelper.f13196a);
        this.f62083g = (NoNetworkView) this.f62077a.findViewById(R.id.view_no_network);
        this.f62081e = (BdTypeListView) this.f62077a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f62077a.getPageContext());
        this.f62082f = gVar;
        gVar.a0(this.f62077a.getUniqueId());
        BaseActivity baseActivity2 = this.f62077a;
        if (baseActivity2 instanceof f.g) {
            this.f62082f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f62077a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f62081e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f62081e.setPullRefresh(this.f62082f);
        this.f62079c = BdListViewHelper.d(this.f62077a.getPageContext().getPageActivity(), this.f62081e, BdListViewHelper.HeadType.DEFAULT);
        d.a.p0.s0.c.o.a aVar = new d.a.p0.s0.c.o.a(this.f62077a, this.f62081e);
        this.f62084h = aVar;
        this.f62081e.a(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f62079c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62081e.A(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62081e.setVisibility(0);
            this.f62077a.hideLoadingView(this.f62078b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62081e.setVisibility(0);
            this.f62077a.hideNetRefreshView(this.f62078b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f62081e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f62084h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f62080d.onChangeSkinType(this.f62077a.getPageContext(), i2);
            this.f62083g.c(this.f62077a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f62078b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62084h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f62083g.a(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f62081e.setVisibility(8);
            this.f62077a.showLoadingView(this.f62078b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f62081e.setVisibility(8);
            this.f62077a.showNetRefreshView(this.f62078b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f62081e.F();
        }
    }
}
