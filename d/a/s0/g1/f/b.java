package d.a.s0.g1.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.view.indicator.ScrollFragmentAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.s0.g1.c.p;
import d.a.s0.g1.f.f.c;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f59725a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59726b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f59727c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59728d;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f59729e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.g1.f.f.a f59730f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f59731g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f59732h;

    /* renamed from: i  reason: collision with root package name */
    public View f59733i;
    public d.a.s0.g1.f.f.c j;
    public boolean k;
    public int l;
    public ImageView m;
    public NoNetworkView.b n;
    public View.OnClickListener o;
    public final d.a.r0.b1.j.e p;
    public c.InterfaceC1435c q;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59734e;

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
            this.f59734e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59734e.m()) {
                    this.f59734e.g();
                    view.setContentDescription("展开");
                    return;
                }
                this.f59734e.y();
                view.setContentDescription("折叠");
            }
        }
    }

    /* renamed from: d.a.s0.g1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1431b implements d.a.r0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59735a;

        public C1431b(b bVar) {
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
            this.f59735a = bVar;
        }

        @Override // d.a.r0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f59735a.l = i3;
                if (this.f59735a.f59731g != null) {
                    this.f59735a.f59731g.k(view, i2, i3, i4, i5);
                }
                if (this.f59735a.j != null) {
                    this.f59735a.j.k(i3);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c.InterfaceC1435c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59736a;

        public c(b bVar) {
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
            this.f59736a = bVar;
        }

        @Override // d.a.s0.g1.f.f.c.InterfaceC1435c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f59736a.f59730f != null) {
                    this.f59736a.f59730f.d();
                }
                if (this.f59736a.j != null) {
                    this.f59736a.j.l(null);
                    b bVar = this.f59736a;
                    bVar.k = true;
                    bVar.j = null;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59737e;

        public d(b bVar) {
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
            this.f59737e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f59737e.f59725a.showToast(R.string.topic_share_no_network);
                } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f59737e.f59725a)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                    this.f59737e.f59725a.shareTopic();
                }
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59726b = null;
        this.f59728d = null;
        this.n = null;
        this.o = new a(this);
        this.p = new C1431b(this);
        this.q = new c(this);
        this.f59725a = hotRanklistActivity;
        l();
    }

    public void g() {
        d.a.s0.g1.f.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.f(this.f59725a.getActivity());
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59729e.getCurrentItem() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59732h : (View) invokeV.objValue;
    }

    public int j(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pVar)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f59731g;
            if (scrollFragmentAdapter == null) {
                return -1;
            }
            return scrollFragmentAdapter.g(pVar);
        }
        return invokeL.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59731g.i();
        }
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotRanklistActivity = this.f59725a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f59733i = inflate;
        this.f59725a.setContentView(inflate);
        this.f59732h = (FrameLayout) this.f59725a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f59725a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f59726b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59728d = (ImageView) this.f59726b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d(this));
        this.f59726b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f59727c = (NoNetworkView) this.f59725a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.f59733i.findViewById(R.id.topic_tab_bottom_line);
        d.a.s0.g1.f.f.a aVar = new d.a.s0.g1.f.f.a(this.f59725a.getActivity(), this.f59725a.findViewById(R.id.topic_tab_container));
        this.f59730f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f59725a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f59729e = (CustomViewPager) this.f59725a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f59725a.getActivity());
        this.f59731g = scrollFragmentAdapter;
        this.f59729e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.s0.g1.f.f.c cVar = this.j;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public void n(List<d.a.s0.g1.c.j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f59731g.n(list);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f59726b.onChangeSkinType(this.f59725a.getPageContext(), i2);
            SkinManager.setImageResource(this.f59728d, R.drawable.icon_nav_hot_share_selector);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59728d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f59730f.g(i2);
            this.f59725a.getLayoutMode().k(i2 == 1);
            this.f59725a.getLayoutMode().j(this.f59733i);
            this.f59727c.c(this.f59725a.getPageContext(), i2);
            this.f59731g.n(null);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f59732h, R.color.CAM_X0201);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (m()) {
                g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f59731g.c(false);
        }
    }

    public void r() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noNetworkView = this.f59727c) == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0 || i2 >= this.f59731g.getCount()) {
            return;
        }
        this.f59729e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (noNetworkView = this.f59727c) == null) {
            return;
        }
        noNetworkView.setVisibility(i2);
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.n = bVar;
            NoNetworkView noNetworkView = this.f59727c;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void v(int i2) {
        d.a.s0.g1.f.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (aVar = this.f59730f) == null) {
            return;
        }
        aVar.j(i2);
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f59729e.setVisibility(i2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f59731g.m();
        }
    }

    public void y() {
        d.a.s0.g1.c.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.j == null) {
                d.a.s0.g1.f.f.c cVar = new d.a.s0.g1.f.f.c(this.f59732h);
                this.j = cVar;
                cVar.l(this.q);
            }
            this.j.m(this.l);
            if (this.j.j() || (jVar = (d.a.s0.g1.c.j) ListUtils.getItem(this.f59731g.f(), 0)) == null) {
                return;
            }
            this.j.n(this.f59725a.getActivity(), jVar.f59688b, this.f59729e.getCurrentItem());
            d.a.s0.g1.f.f.a aVar = this.f59730f;
            if (aVar != null) {
                aVar.k();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f59730f.i(this.f59729e);
        }
    }
}
