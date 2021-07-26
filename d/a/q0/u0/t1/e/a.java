package d.a.q0.u0.t1.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.k.e.n;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64479a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.u0.t1.b.a f64480b;

    /* renamed from: c  reason: collision with root package name */
    public View f64481c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f64482d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f64483e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f64484f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f64485g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f64486h;

    /* renamed from: i  reason: collision with root package name */
    public g f64487i;
    public String j;
    public String k;

    /* renamed from: d.a.q0.u0.t1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1732a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64488e;

        public View$OnClickListenerC1732a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64488e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64488e.g();
            }
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64479a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64484f.z();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f64484f != null && j.z()) {
            this.f64484f.F();
        }
    }

    public FrameLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64482d : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64483e : (NavigationBar) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64481c : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f64479a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.f64479a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
            this.f64481c = inflate;
            this.f64485g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f64482d = (FrameLayout) this.f64481c.findViewById(R.id.game_recom_container);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f64481c.findViewById(R.id.game_recom_listview);
            this.f64484f = bdTypeListView;
            bdTypeListView.setDivider(null);
            g gVar = new g(this.f64479a);
            this.f64487i = gVar;
            gVar.a0(this.f64479a.getUniqueId());
            this.f64484f.setPullRefresh(this.f64487i);
            NavigationBar navigationBar = (NavigationBar) this.f64481c.findViewById(R.id.view_navigation_bar);
            this.f64483e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1732a(this));
            this.f64483e.showBottomLine();
            PbListView pbListView = new PbListView(this.f64479a.getPageActivity());
            this.f64486h = pbListView;
            pbListView.a();
            this.f64480b = new d.a.q0.u0.t1.b.a(this.f64479a, this.f64484f, this.j, this.k);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NoNetworkView noNetworkView = this.f64485g;
            if (noNetworkView != null) {
                noNetworkView.c(this.f64479a, i2);
            }
            NavigationBar navigationBar = this.f64483e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64479a, i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void k(List<n> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) {
            if (z) {
                o();
            } else {
                p();
            }
            this.f64480b.c(list);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f64487i.a(gVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f64484f.setNextPage(null);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            this.f64484f.setOnSrollToBottomListener(pVar);
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f64486h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64484f.setNextPage(this.f64486h);
        }
        this.f64486h.M();
        this.f64486h.O();
    }

    public final void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f64486h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64484f.setNextPage(this.f64486h);
        }
        this.f64486h.A(this.f64479a.getPageActivity().getResources().getString(R.string.list_no_more));
        this.f64486h.f();
    }
}
