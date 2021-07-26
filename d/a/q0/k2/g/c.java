package d.a.q0.k2.g;

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
import d.a.d.e.p.j;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f60048a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60049b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f60050c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60051d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f60052e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f60053f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60054g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.k2.d.c f60055h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.z3.d f60056i;
    public View j;
    public FrameLayout k;
    public d.a.p0.f0.h l;
    public PluginErrorTipView m;
    public InterfaceC1516c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes8.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60057e;

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
            this.f60057e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f60057e.f60052e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f60057e.f60052e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && this.f60057e.f60052e != null && i2 == 1) {
                this.f60057e.f60052e.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60058e;

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
            this.f60058e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f60058e.d();
                if (this.f60058e.n != null) {
                    this.f60058e.n.a(view);
                }
            }
        }
    }

    /* renamed from: d.a.q0.k2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1516c {
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
        this.f60048a = 3;
        this.o = new a(this);
        if (view == null) {
            return;
        }
        this.f60049b = tbPageContext;
        this.f60050c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f60051d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f60052e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f60053f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f60053f.addFooterView(this.j);
        this.f60053f.setOnScrollListener(this.o);
        this.f60055h = new d.a.q0.k2.d.c(this.f60053f, tbPageContext, bdUniqueId);
        this.f60056i = new d.a.q0.z3.d(1);
    }

    public void c() {
        d.a.q0.k2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f60055h) == null) {
            return;
        }
        cVar.a();
    }

    public void d() {
        d.a.p0.f0.h hVar;
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
            this.f60054g = this.f60051d.setCenterTextTitle(this.f60049b.getString(R.string.mine));
            this.f60056i.n(this.f60049b.getPageActivity(), this.f60051d);
            this.f60056i.k();
            this.f60056i.o(null);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.p0.f0.h hVar = this.l;
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
            this.f60055h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f60048a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f60054g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f60053f, R.color.CAM_X0201);
        this.f60051d.onChangeSkinType(this.f60049b, i2);
        SkinManager.setBackgroundColor(this.f60051d.getBarBgView(), R.color.CAM_X0207, i2);
        this.f60055h.c();
        this.f60050c.c(this.f60049b, i2);
        this.m.e(this.f60049b, i2);
        this.f60056i.m(i2);
        d.a.p0.f0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f60052e, R.drawable.personalize_tab_shadow);
        this.f60048a = i2;
    }

    public void i() {
        d.a.q0.k2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f60055h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(d.a.q0.k2.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f60055h.d(fVar.n());
    }

    public void k(InterfaceC1516c interfaceC1516c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1516c) == null) {
            this.n = interfaceC1516c;
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            this.f60049b.showToast(str);
        }
    }

    public void m() {
        d.a.q0.k2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f60055h) == null) {
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
            this.l = new d.a.p0.f0.h(this.f60049b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f60056i.p(i2, z);
        }
    }
}
