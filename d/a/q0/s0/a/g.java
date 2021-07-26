package d.a.q0.s0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.s0.a.h;
import d.a.q0.s0.c.l;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f62620a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f62621b;

    /* renamed from: c  reason: collision with root package name */
    public h f62622c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62623d;

    /* renamed from: e  reason: collision with root package name */
    public View f62624e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f62625f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62626g;

    /* renamed from: h  reason: collision with root package name */
    public View f62627h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.t.i.b f62628i;
    public h.d j;

    /* loaded from: classes8.dex */
    public class a implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f62629a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62629a = gVar;
        }

        @Override // d.a.q0.s0.a.h.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink(this.f62629a.f62620a.getPageContext(), new String[]{str});
                } else {
                    this.f62629a.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bawuTeamInfoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62626g = false;
        this.f62620a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f62624e = inflate;
        this.f62620a.setContentView(inflate);
        this.f62627h = this.f62624e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f62624e.findViewById(R.id.view_navigation_bar);
        this.f62623d = navigationBar;
        navigationBar.setCenterTextTitle(this.f62620a.getString(R.string.bawu_manager_team));
        this.f62623d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62623d.showBottomLine();
        this.f62625f = (NoNetworkView) this.f62624e.findViewById(R.id.view_no_network);
        this.f62621b = (BdListView) this.f62624e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f62620a.getPageContext());
        this.f62622c = hVar;
        this.f62621b.setAdapter((ListAdapter) hVar);
        a aVar = new a(this);
        this.j = aVar;
        this.f62622c.f(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62620a.hideNetRefreshView(this.f62624e);
            this.f62621b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62627h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62626g : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f62620a.getLayoutMode().k(i2 == 1);
            this.f62620a.getLayoutMode().j(this.f62624e);
            this.f62623d.onChangeSkinType(this.f62620a.getPageContext(), i2);
            this.f62625f.c(this.f62620a.getPageContext(), i2);
            this.f62622c.notifyDataSetChanged();
        }
    }

    public void g() {
        d.a.p0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f62628i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f62625f.a(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.f62628i == null) {
                this.f62628i = new d.a.p0.t.i.b(this.f62620a);
            }
            this.f62628i.p();
            this.f62628i.u(accountData);
            this.f62628i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62621b.setVisibility(8);
            this.f62620a.showNetRefreshView(this.f62624e, this.f62620a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f62626g = false;
            } else {
                this.f62626g = true;
            }
            if (z && this.f62626g) {
                j();
                return;
            }
            c();
            this.f62622c.d(arrayList);
            this.f62622c.e(lVar);
            this.f62622c.notifyDataSetChanged();
        }
    }
}
