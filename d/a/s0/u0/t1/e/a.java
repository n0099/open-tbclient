package d.a.s0.u0.t1.e;

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
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67051a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.u0.t1.b.a f67052b;

    /* renamed from: c  reason: collision with root package name */
    public View f67053c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f67054d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f67055e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f67056f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f67057g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f67058h;

    /* renamed from: i  reason: collision with root package name */
    public g f67059i;
    public String j;
    public String k;

    /* renamed from: d.a.s0.u0.t1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1770a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67060e;

        public View$OnClickListenerC1770a(a aVar) {
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
            this.f67060e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f67060e.g();
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
        this.f67051a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67056f.z();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f67056f != null && j.z()) {
            this.f67056f.F();
        }
    }

    public FrameLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67054d : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67055e : (NavigationBar) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67053c : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f67051a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.f67051a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
            this.f67053c = inflate;
            this.f67057g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f67054d = (FrameLayout) this.f67053c.findViewById(R.id.game_recom_container);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f67053c.findViewById(R.id.game_recom_listview);
            this.f67056f = bdTypeListView;
            bdTypeListView.setDivider(null);
            g gVar = new g(this.f67051a);
            this.f67059i = gVar;
            gVar.a0(this.f67051a.getUniqueId());
            this.f67056f.setPullRefresh(this.f67059i);
            NavigationBar navigationBar = (NavigationBar) this.f67053c.findViewById(R.id.view_navigation_bar);
            this.f67055e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1770a(this));
            this.f67055e.showBottomLine();
            PbListView pbListView = new PbListView(this.f67051a.getPageActivity());
            this.f67058h = pbListView;
            pbListView.a();
            this.f67052b = new d.a.s0.u0.t1.b.a(this.f67051a, this.f67056f, this.j, this.k);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NoNetworkView noNetworkView = this.f67057g;
            if (noNetworkView != null) {
                noNetworkView.c(this.f67051a, i2);
            }
            NavigationBar navigationBar = this.f67055e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f67051a, i2);
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
            this.f67052b.c(list);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f67059i.a(gVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f67056f.setNextPage(null);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            this.f67056f.setOnSrollToBottomListener(pVar);
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f67058h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f67056f.setNextPage(this.f67058h);
        }
        this.f67058h.M();
        this.f67058h.O();
    }

    public final void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f67058h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f67056f.setNextPage(this.f67058h);
        }
        this.f67058h.A(this.f67051a.getPageActivity().getResources().getString(R.string.list_no_more));
        this.f67058h.f();
    }
}
