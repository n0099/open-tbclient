package d.a.n0.d1.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import d.a.c.e.p.j;
import d.a.n0.d1.c.p;
import d.a.n0.d1.f.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f56313a;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56315c;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f56317e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.d1.f.f.a f56318f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f56319g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f56320h;

    /* renamed from: i  reason: collision with root package name */
    public View f56321i;
    public d.a.n0.d1.f.f.c j;
    public boolean k;
    public int l;
    public ImageView m;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f56314b = null;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f56316d = null;
    public NoNetworkView.b n = null;
    public View.OnClickListener o = new a();
    public final d.a.m0.b1.j.e p = new C1297b();
    public c.InterfaceC1301c q = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.m()) {
                b.this.g();
                view.setContentDescription("展开");
                return;
            }
            b.this.y();
            view.setContentDescription("折叠");
        }
    }

    /* renamed from: d.a.n0.d1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1297b implements d.a.m0.b1.j.e {
        public C1297b() {
        }

        @Override // d.a.m0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            b.this.l = i3;
            if (b.this.f56319g != null) {
                b.this.f56319g.k(view, i2, i3, i4, i5);
            }
            if (b.this.j != null) {
                b.this.j.k(i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.InterfaceC1301c {
        public c() {
        }

        @Override // d.a.n0.d1.f.f.c.InterfaceC1301c
        public void a() {
            if (b.this.f56318f != null) {
                b.this.f56318f.d();
            }
            if (b.this.j != null) {
                b.this.j.l(null);
                b bVar = b.this;
                bVar.k = true;
                bVar.j = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.z()) {
                b.this.f56313a.showToast(R.string.topic_share_no_network);
            } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(b.this.f56313a)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                b.this.f56313a.shareTopic();
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.f56313a = hotRanklistActivity;
        l();
    }

    public void g() {
        d.a.n0.d1.f.f.c cVar = this.j;
        if (cVar != null) {
            cVar.f(this.f56313a.getActivity());
        }
    }

    public int h() {
        return this.f56317e.getCurrentItem();
    }

    public View i() {
        return this.f56320h;
    }

    public int j(p pVar) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f56319g;
        if (scrollFragmentAdapter == null) {
            return -1;
        }
        return scrollFragmentAdapter.g(pVar);
    }

    public void k() {
        this.f56319g.i();
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity = this.f56313a;
        if (hotRanklistActivity == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f56321i = inflate;
        this.f56313a.setContentView(inflate);
        this.f56320h = (FrameLayout) this.f56313a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f56313a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f56314b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56316d = (ImageView) this.f56314b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f56314b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f56315c = (NoNetworkView) this.f56313a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.f56321i.findViewById(R.id.topic_tab_bottom_line);
        d.a.n0.d1.f.f.a aVar = new d.a.n0.d1.f.f.a(this.f56313a.getActivity(), this.f56313a.findViewById(R.id.topic_tab_container));
        this.f56318f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f56313a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f56317e = (CustomViewPager) this.f56313a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f56313a.getActivity());
        this.f56319g = scrollFragmentAdapter;
        this.f56317e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        d.a.n0.d1.f.f.c cVar = this.j;
        return cVar != null && cVar.j();
    }

    public void n(List<d.a.n0.d1.c.j> list) {
        this.f56319g.n(list);
    }

    public void o(int i2) {
        this.f56314b.onChangeSkinType(this.f56313a.getPageContext(), i2);
        SkinManager.setImageResource(this.f56316d, R.drawable.icon_nav_hot_share_selector);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56316d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.f56318f.g(i2);
        this.f56313a.getLayoutMode().k(i2 == 1);
        this.f56313a.getLayoutMode().j(this.f56321i);
        this.f56315c.c(this.f56313a.getPageContext(), i2);
        this.f56319g.n(null);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f56320h, R.color.CAM_X0201);
    }

    public boolean p() {
        if (m()) {
            g();
            return true;
        }
        return false;
    }

    public void q() {
        this.f56319g.c(false);
    }

    public void r() {
        NoNetworkView.b bVar;
        NoNetworkView noNetworkView = this.f56315c;
        if (noNetworkView == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public void s(int i2) {
        if (i2 < 0 || i2 >= this.f56319g.getCount()) {
            return;
        }
        this.f56317e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView = this.f56315c;
        if (noNetworkView != null) {
            noNetworkView.setVisibility(i2);
        }
    }

    public void u(NoNetworkView.b bVar) {
        this.n = bVar;
        NoNetworkView noNetworkView = this.f56315c;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void v(int i2) {
        d.a.n0.d1.f.f.a aVar = this.f56318f;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    public void w(int i2) {
        this.f56317e.setVisibility(i2);
    }

    public void x() {
        this.f56319g.m();
    }

    public void y() {
        d.a.n0.d1.c.j jVar;
        if (this.j == null) {
            d.a.n0.d1.f.f.c cVar = new d.a.n0.d1.f.f.c(this.f56320h);
            this.j = cVar;
            cVar.l(this.q);
        }
        this.j.m(this.l);
        if (this.j.j() || (jVar = (d.a.n0.d1.c.j) ListUtils.getItem(this.f56319g.f(), 0)) == null) {
            return;
        }
        this.j.n(this.f56313a.getActivity(), jVar.f56276b, this.f56317e.getCurrentItem());
        d.a.n0.d1.f.f.a aVar = this.f56318f;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void z() {
        this.f56318f.i(this.f56317e);
    }
}
