package d.a.k0.c1.f;

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
import d.a.k0.c1.c.p;
import d.a.k0.c1.f.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f52444a;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f52446c;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f52448e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.c1.f.f.a f52449f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f52450g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f52451h;

    /* renamed from: i  reason: collision with root package name */
    public View f52452i;
    public d.a.k0.c1.f.f.c j;
    public boolean k;
    public int l;
    public ImageView m;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f52445b = null;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f52447d = null;
    public NoNetworkView.b n = null;
    public View.OnClickListener o = new a();
    public final d.a.j0.b1.j.e p = new C1224b();
    public c.InterfaceC1228c q = new c();

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

    /* renamed from: d.a.k0.c1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1224b implements d.a.j0.b1.j.e {
        public C1224b() {
        }

        @Override // d.a.j0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            b.this.l = i3;
            if (b.this.f52450g != null) {
                b.this.f52450g.h(view, i2, i3, i4, i5);
            }
            if (b.this.j != null) {
                b.this.j.k(i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.InterfaceC1228c {
        public c() {
        }

        @Override // d.a.k0.c1.f.f.c.InterfaceC1228c
        public void a() {
            if (b.this.f52449f != null) {
                b.this.f52449f.d();
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
                b.this.f52444a.showToast(R.string.topic_share_no_network);
            } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(b.this.f52444a)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                b.this.f52444a.shareTopic();
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.f52444a = hotRanklistActivity;
        l();
    }

    public void g() {
        d.a.k0.c1.f.f.c cVar = this.j;
        if (cVar != null) {
            cVar.f(this.f52444a.getActivity());
        }
    }

    public int h() {
        return this.f52448e.getCurrentItem();
    }

    public View i() {
        return this.f52451h;
    }

    public int j(p pVar) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f52450g;
        if (scrollFragmentAdapter == null) {
            return -1;
        }
        return scrollFragmentAdapter.e(pVar);
    }

    public void k() {
        this.f52450g.f();
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity = this.f52444a;
        if (hotRanklistActivity == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f52452i = inflate;
        this.f52444a.setContentView(inflate);
        this.f52451h = (FrameLayout) this.f52444a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f52444a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f52445b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f52447d = (ImageView) this.f52445b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f52445b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f52446c = (NoNetworkView) this.f52444a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.f52452i.findViewById(R.id.topic_tab_bottom_line);
        d.a.k0.c1.f.f.a aVar = new d.a.k0.c1.f.f.a(this.f52444a.getActivity(), this.f52444a.findViewById(R.id.topic_tab_container));
        this.f52449f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f52444a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f52448e = (CustomViewPager) this.f52444a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f52444a.getActivity());
        this.f52450g = scrollFragmentAdapter;
        this.f52448e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        d.a.k0.c1.f.f.c cVar = this.j;
        return cVar != null && cVar.j();
    }

    public void n(List<d.a.k0.c1.c.j> list) {
        this.f52450g.k(list);
    }

    public void o(int i2) {
        this.f52445b.onChangeSkinType(this.f52444a.getPageContext(), i2);
        SkinManager.setImageResource(this.f52447d, R.drawable.icon_nav_hot_share_selector);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52447d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.f52449f.g(i2);
        this.f52444a.getLayoutMode().k(i2 == 1);
        this.f52444a.getLayoutMode().j(this.f52452i);
        this.f52446c.c(this.f52444a.getPageContext(), i2);
        this.f52450g.k(null);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f52451h, R.color.CAM_X0201);
    }

    public boolean p() {
        if (m()) {
            g();
            return true;
        }
        return false;
    }

    public void q() {
        this.f52450g.b(false);
    }

    public void r() {
        NoNetworkView.b bVar;
        NoNetworkView noNetworkView = this.f52446c;
        if (noNetworkView == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public void s(int i2) {
        if (i2 < 0 || i2 >= this.f52450g.getCount()) {
            return;
        }
        this.f52448e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView = this.f52446c;
        if (noNetworkView != null) {
            noNetworkView.setVisibility(i2);
        }
    }

    public void u(NoNetworkView.b bVar) {
        this.n = bVar;
        NoNetworkView noNetworkView = this.f52446c;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void v(int i2) {
        d.a.k0.c1.f.f.a aVar = this.f52449f;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    public void w(int i2) {
        this.f52448e.setVisibility(i2);
    }

    public void x() {
        this.f52450g.j();
    }

    public void y() {
        d.a.k0.c1.c.j jVar;
        if (this.j == null) {
            d.a.k0.c1.f.f.c cVar = new d.a.k0.c1.f.f.c(this.f52451h);
            this.j = cVar;
            cVar.l(this.q);
        }
        this.j.m(this.l);
        if (this.j.j() || (jVar = (d.a.k0.c1.c.j) ListUtils.getItem(this.f52450g.d(), 0)) == null) {
            return;
        }
        this.j.n(this.f52444a.getActivity(), jVar.f52407b, this.f52448e.getCurrentItem());
        d.a.k0.c1.f.f.a aVar = this.f52449f;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void z() {
        this.f52449f.i(this.f52448e);
    }
}
