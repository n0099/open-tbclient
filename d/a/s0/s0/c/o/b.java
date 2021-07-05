package d.a.s0.s0.c.o;

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
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f65299a;

    /* renamed from: b  reason: collision with root package name */
    public View f65300b;

    /* renamed from: c  reason: collision with root package name */
    public View f65301c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f65302d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f65303e;

    /* renamed from: f  reason: collision with root package name */
    public g f65304f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f65305g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.s0.c.o.a f65306h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65307e;

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
            this.f65307e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65307e.f65299a.finish();
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
        this.f65299a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f65300b = this.f65299a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f65299a.findViewById(R.id.view_navigation_bar);
        this.f65302d = navigationBar;
        navigationBar.setCenterTextTitle(this.f65299a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f65302d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f65299a.setNetRefreshViewTopMargin(BdListViewHelper.f13179a);
        this.f65305g = (NoNetworkView) this.f65299a.findViewById(R.id.view_no_network);
        this.f65303e = (BdTypeListView) this.f65299a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f65299a.getPageContext());
        this.f65304f = gVar;
        gVar.a0(this.f65299a.getUniqueId());
        BaseActivity baseActivity2 = this.f65299a;
        if (baseActivity2 instanceof f.g) {
            this.f65304f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f65299a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f65303e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f65303e.setPullRefresh(this.f65304f);
        this.f65301c = BdListViewHelper.d(this.f65299a.getPageContext().getPageActivity(), this.f65303e, BdListViewHelper.HeadType.DEFAULT);
        d.a.s0.s0.c.o.a aVar = new d.a.s0.s0.c.o.a(this.f65299a, this.f65303e);
        this.f65306h = aVar;
        this.f65303e.a(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f65301c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f65303e.A(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65303e.setVisibility(0);
            this.f65299a.hideLoadingView(this.f65300b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f65303e.setVisibility(0);
            this.f65299a.hideNetRefreshView(this.f65300b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f65303e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f65306h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f65302d.onChangeSkinType(this.f65299a.getPageContext(), i2);
            this.f65305g.c(this.f65299a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f65300b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65306h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f65305g.a(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f65303e.setVisibility(8);
            this.f65299a.showLoadingView(this.f65300b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f65303e.setVisibility(8);
            this.f65299a.showNetRefreshView(this.f65300b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f65303e.F();
        }
    }
}
