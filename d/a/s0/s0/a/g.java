package d.a.s0.s0.a;

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
import d.a.s0.s0.a.h;
import d.a.s0.s0.c.l;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f65228a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f65229b;

    /* renamed from: c  reason: collision with root package name */
    public h f65230c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f65231d;

    /* renamed from: e  reason: collision with root package name */
    public View f65232e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f65233f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65234g;

    /* renamed from: h  reason: collision with root package name */
    public View f65235h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.s.i.b f65236i;
    public h.d j;

    /* loaded from: classes9.dex */
    public class a implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65237a;

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
            this.f65237a = gVar;
        }

        @Override // d.a.s0.s0.a.h.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink(this.f65237a.f65228a.getPageContext(), new String[]{str});
                } else {
                    this.f65237a.i(TbadkCoreApplication.getCurrentAccountInfo());
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
        this.f65234g = false;
        this.f65228a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f65232e = inflate;
        this.f65228a.setContentView(inflate);
        this.f65235h = this.f65232e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f65232e.findViewById(R.id.view_navigation_bar);
        this.f65231d = navigationBar;
        navigationBar.setCenterTextTitle(this.f65228a.getString(R.string.bawu_manager_team));
        this.f65231d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f65231d.showBottomLine();
        this.f65233f = (NoNetworkView) this.f65232e.findViewById(R.id.view_no_network);
        this.f65229b = (BdListView) this.f65232e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f65228a.getPageContext());
        this.f65230c = hVar;
        this.f65229b.setAdapter((ListAdapter) hVar);
        a aVar = new a(this);
        this.j = aVar;
        this.f65230c.f(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65228a.hideNetRefreshView(this.f65232e);
            this.f65229b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65235h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65234g : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f65228a.getLayoutMode().k(i2 == 1);
            this.f65228a.getLayoutMode().j(this.f65232e);
            this.f65231d.onChangeSkinType(this.f65228a.getPageContext(), i2);
            this.f65233f.c(this.f65228a.getPageContext(), i2);
            this.f65230c.notifyDataSetChanged();
        }
    }

    public void g() {
        d.a.r0.s.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f65236i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f65233f.a(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.f65236i == null) {
                this.f65236i = new d.a.r0.s.i.b(this.f65228a);
            }
            this.f65236i.p();
            this.f65236i.u(accountData);
            this.f65236i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65229b.setVisibility(8);
            this.f65228a.showNetRefreshView(this.f65232e, this.f65228a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f65234g = false;
            } else {
                this.f65234g = true;
            }
            if (z && this.f65234g) {
                j();
                return;
            }
            c();
            this.f65230c.d(arrayList);
            this.f65230c.e(lVar);
            this.f65230c.notifyDataSetChanged();
        }
    }
}
