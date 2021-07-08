package d.a.p0.u0.t1.e;

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
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63834a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.u0.t1.b.a f63835b;

    /* renamed from: c  reason: collision with root package name */
    public View f63836c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f63837d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f63838e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f63839f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f63840g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f63841h;

    /* renamed from: i  reason: collision with root package name */
    public g f63842i;
    public String j;
    public String k;

    /* renamed from: d.a.p0.u0.t1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1729a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63843e;

        public View$OnClickListenerC1729a(a aVar) {
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
            this.f63843e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63843e.g();
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
        this.f63834a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f63839f.z();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f63839f != null && j.z()) {
            this.f63839f.F();
        }
    }

    public FrameLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63837d : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63838e : (NavigationBar) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63836c : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f63834a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.f63834a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
            this.f63836c = inflate;
            this.f63840g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f63837d = (FrameLayout) this.f63836c.findViewById(R.id.game_recom_container);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f63836c.findViewById(R.id.game_recom_listview);
            this.f63839f = bdTypeListView;
            bdTypeListView.setDivider(null);
            g gVar = new g(this.f63834a);
            this.f63842i = gVar;
            gVar.a0(this.f63834a.getUniqueId());
            this.f63839f.setPullRefresh(this.f63842i);
            NavigationBar navigationBar = (NavigationBar) this.f63836c.findViewById(R.id.view_navigation_bar);
            this.f63838e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1729a(this));
            this.f63838e.showBottomLine();
            PbListView pbListView = new PbListView(this.f63834a.getPageActivity());
            this.f63841h = pbListView;
            pbListView.a();
            this.f63835b = new d.a.p0.u0.t1.b.a(this.f63834a, this.f63839f, this.j, this.k);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NoNetworkView noNetworkView = this.f63840g;
            if (noNetworkView != null) {
                noNetworkView.c(this.f63834a, i2);
            }
            NavigationBar navigationBar = this.f63838e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f63834a, i2);
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
            this.f63835b.c(list);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f63842i.a(gVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f63839f.setNextPage(null);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            this.f63839f.setOnSrollToBottomListener(pVar);
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f63841h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f63839f.setNextPage(this.f63841h);
        }
        this.f63841h.M();
        this.f63841h.O();
    }

    public final void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f63841h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f63839f.setNextPage(this.f63841h);
        }
        this.f63841h.A(this.f63834a.getPageActivity().getResources().getString(R.string.list_no_more));
        this.f63841h.f();
    }
}
