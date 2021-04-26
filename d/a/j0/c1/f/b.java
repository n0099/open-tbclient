package d.a.j0.c1.f;

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
import d.a.j0.c1.c.p;
import d.a.j0.c1.f.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f51745a;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f51747c;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f51749e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.c1.f.f.a f51750f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f51751g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f51752h;

    /* renamed from: i  reason: collision with root package name */
    public View f51753i;
    public d.a.j0.c1.f.f.c j;
    public boolean k;
    public int l;
    public ImageView m;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f51746b = null;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f51748d = null;
    public NoNetworkView.b n = null;
    public View.OnClickListener o = new a();
    public final d.a.i0.b1.j.e p = new C1152b();
    public c.InterfaceC1156c q = new c();

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

    /* renamed from: d.a.j0.c1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1152b implements d.a.i0.b1.j.e {
        public C1152b() {
        }

        @Override // d.a.i0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            b.this.l = i3;
            if (b.this.f51751g != null) {
                b.this.f51751g.h(view, i2, i3, i4, i5);
            }
            if (b.this.j != null) {
                b.this.j.k(i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.InterfaceC1156c {
        public c() {
        }

        @Override // d.a.j0.c1.f.f.c.InterfaceC1156c
        public void a() {
            if (b.this.f51750f != null) {
                b.this.f51750f.d();
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
                b.this.f51745a.showToast(R.string.topic_share_no_network);
            } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(b.this.f51745a)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                b.this.f51745a.shareTopic();
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.f51745a = hotRanklistActivity;
        l();
    }

    public void g() {
        d.a.j0.c1.f.f.c cVar = this.j;
        if (cVar != null) {
            cVar.f(this.f51745a.getActivity());
        }
    }

    public int h() {
        return this.f51749e.getCurrentItem();
    }

    public View i() {
        return this.f51752h;
    }

    public int j(p pVar) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f51751g;
        if (scrollFragmentAdapter == null) {
            return -1;
        }
        return scrollFragmentAdapter.e(pVar);
    }

    public void k() {
        this.f51751g.f();
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity = this.f51745a;
        if (hotRanklistActivity == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f51753i = inflate;
        this.f51745a.setContentView(inflate);
        this.f51752h = (FrameLayout) this.f51745a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f51745a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f51746b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f51748d = (ImageView) this.f51746b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f51746b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f51747c = (NoNetworkView) this.f51745a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.f51753i.findViewById(R.id.topic_tab_bottom_line);
        d.a.j0.c1.f.f.a aVar = new d.a.j0.c1.f.f.a(this.f51745a.getActivity(), this.f51745a.findViewById(R.id.topic_tab_container));
        this.f51750f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f51745a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f51749e = (CustomViewPager) this.f51745a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f51745a.getActivity());
        this.f51751g = scrollFragmentAdapter;
        this.f51749e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        d.a.j0.c1.f.f.c cVar = this.j;
        return cVar != null && cVar.j();
    }

    public void n(List<d.a.j0.c1.c.j> list) {
        this.f51751g.k(list);
    }

    public void o(int i2) {
        this.f51746b.onChangeSkinType(this.f51745a.getPageContext(), i2);
        SkinManager.setImageResource(this.f51748d, R.drawable.icon_nav_hot_share_selector);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51748d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.f51750f.g(i2);
        this.f51745a.getLayoutMode().k(i2 == 1);
        this.f51745a.getLayoutMode().j(this.f51753i);
        this.f51747c.c(this.f51745a.getPageContext(), i2);
        this.f51751g.k(null);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f51752h, R.color.CAM_X0201);
    }

    public boolean p() {
        if (m()) {
            g();
            return true;
        }
        return false;
    }

    public void q() {
        this.f51751g.b(false);
    }

    public void r() {
        NoNetworkView.b bVar;
        NoNetworkView noNetworkView = this.f51747c;
        if (noNetworkView == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public void s(int i2) {
        if (i2 < 0 || i2 >= this.f51751g.getCount()) {
            return;
        }
        this.f51749e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView = this.f51747c;
        if (noNetworkView != null) {
            noNetworkView.setVisibility(i2);
        }
    }

    public void u(NoNetworkView.b bVar) {
        this.n = bVar;
        NoNetworkView noNetworkView = this.f51747c;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void v(int i2) {
        d.a.j0.c1.f.f.a aVar = this.f51750f;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    public void w(int i2) {
        this.f51749e.setVisibility(i2);
    }

    public void x() {
        this.f51751g.j();
    }

    public void y() {
        d.a.j0.c1.c.j jVar;
        if (this.j == null) {
            d.a.j0.c1.f.f.c cVar = new d.a.j0.c1.f.f.c(this.f51752h);
            this.j = cVar;
            cVar.l(this.q);
        }
        this.j.m(this.l);
        if (this.j.j() || (jVar = (d.a.j0.c1.c.j) ListUtils.getItem(this.f51751g.d(), 0)) == null) {
            return;
        }
        this.j.n(this.f51745a.getActivity(), jVar.f51708b, this.f51749e.getCurrentItem());
        d.a.j0.c1.f.f.a aVar = this.f51750f;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void z() {
        this.f51750f.i(this.f51749e);
    }
}
