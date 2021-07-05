package d.a.s0.k2.g;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f62671a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62672b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f62673c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62674d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f62675e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f62676f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62677g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.k2.d.c f62678h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.z3.d f62679i;
    public View j;
    public FrameLayout k;
    public d.a.r0.d0.h l;
    public PluginErrorTipView m;
    public InterfaceC1555c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes9.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62680e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62680e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f62680e.f62675e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f62680e.f62675e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && this.f62680e.f62675e != null && i2 == 1) {
                this.f62680e.f62675e.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62681e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62681e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f62681e.d();
                if (this.f62681e.n != null) {
                    this.f62681e.n.a(view);
                }
            }
        }
    }

    /* renamed from: d.a.s0.k2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1555c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62671a = 3;
        this.o = new a(this);
        if (view == null) {
            return;
        }
        this.f62672b = tbPageContext;
        this.f62673c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f62674d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f62675e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f62676f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f62676f.addFooterView(this.j);
        this.f62676f.setOnScrollListener(this.o);
        this.f62678h = new d.a.s0.k2.d.c(this.f62676f, tbPageContext, bdUniqueId);
        this.f62679i = new d.a.s0.z3.d(1);
    }

    public void c() {
        d.a.s0.k2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f62678h) == null) {
            return;
        }
        cVar.a();
    }

    public void d() {
        d.a.r0.d0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.l) == null) {
            return;
        }
        hVar.dettachView(this.k);
        this.l = null;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62677g = this.f62674d.setCenterTextTitle(this.f62672b.getString(R.string.mine));
            this.f62679i.n(this.f62672b.getPageActivity(), this.f62674d);
            this.f62679i.k();
            this.f62679i.o(null);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.r0.d0.h hVar = this.l;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f62678h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f62671a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f62677g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62676f, R.color.CAM_X0201);
        this.f62674d.onChangeSkinType(this.f62672b, i2);
        SkinManager.setBackgroundColor(this.f62674d.getBarBgView(), R.color.CAM_X0207, i2);
        this.f62678h.c();
        this.f62673c.c(this.f62672b, i2);
        this.m.e(this.f62672b, i2);
        this.f62679i.m(i2);
        d.a.r0.d0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f62675e, R.drawable.personalize_tab_shadow);
        this.f62671a = i2;
    }

    public void i() {
        d.a.s0.k2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f62678h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(d.a.s0.k2.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f62678h.d(fVar.n());
    }

    public void k(InterfaceC1555c interfaceC1555c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1555c) == null) {
            this.n = interfaceC1555c;
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            this.f62672b.showToast(str);
        }
    }

    public void m() {
        d.a.s0.k2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f62678h) == null) {
            return;
        }
        cVar.e();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || f()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.r0.d0.h(this.f62672b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f62679i.p(i2, z);
        }
    }
}
