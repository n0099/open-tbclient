package d.b.i0.c1.f;

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
import d.b.c.e.p.j;
import d.b.i0.c1.c.p;
import d.b.i0.c1.f.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f53558a;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f53560c;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f53562e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.c1.f.f.a f53563f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f53564g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f53565h;
    public View i;
    public d.b.i0.c1.f.f.c j;
    public boolean k;
    public int l;
    public ImageView m;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f53559b = null;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f53561d = null;
    public NoNetworkView.b n = null;
    public View.OnClickListener o = new a();
    public final d.b.h0.b1.j.e p = new C1190b();
    public c.InterfaceC1194c q = new c();

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

    /* renamed from: d.b.i0.c1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1190b implements d.b.h0.b1.j.e {
        public C1190b() {
        }

        @Override // d.b.h0.b1.j.e
        public void a(View view, int i, int i2, int i3, int i4) {
            b.this.l = i2;
            if (b.this.f53564g != null) {
                b.this.f53564g.k(view, i, i2, i3, i4);
            }
            if (b.this.j != null) {
                b.this.j.k(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.InterfaceC1194c {
        public c() {
        }

        @Override // d.b.i0.c1.f.f.c.InterfaceC1194c
        public void a() {
            if (b.this.f53563f != null) {
                b.this.f53563f.d();
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
                b.this.f53558a.showToast(R.string.topic_share_no_network);
            } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(b.this.f53558a)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                b.this.f53558a.shareTopic();
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.f53558a = hotRanklistActivity;
        l();
    }

    public void g() {
        d.b.i0.c1.f.f.c cVar = this.j;
        if (cVar != null) {
            cVar.f(this.f53558a.getActivity());
        }
    }

    public int h() {
        return this.f53562e.getCurrentItem();
    }

    public View i() {
        return this.f53565h;
    }

    public int j(p pVar) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f53564g;
        if (scrollFragmentAdapter == null) {
            return -1;
        }
        return scrollFragmentAdapter.g(pVar);
    }

    public void k() {
        this.f53564g.i();
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity = this.f53558a;
        if (hotRanklistActivity == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.i = inflate;
        this.f53558a.setContentView(inflate);
        this.f53565h = (FrameLayout) this.f53558a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f53558a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f53559b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53561d = (ImageView) this.f53559b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f53559b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f53560c = (NoNetworkView) this.f53558a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.i.findViewById(R.id.topic_tab_bottom_line);
        d.b.i0.c1.f.f.a aVar = new d.b.i0.c1.f.f.a(this.f53558a.getActivity(), this.f53558a.findViewById(R.id.topic_tab_container));
        this.f53563f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f53558a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f53562e = (CustomViewPager) this.f53558a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f53558a.getActivity());
        this.f53564g = scrollFragmentAdapter;
        this.f53562e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        d.b.i0.c1.f.f.c cVar = this.j;
        return cVar != null && cVar.j();
    }

    public void n(List<d.b.i0.c1.c.j> list) {
        this.f53564g.n(list);
    }

    public void o(int i) {
        this.f53559b.onChangeSkinType(this.f53558a.getPageContext(), i);
        SkinManager.setImageResource(this.f53561d, R.drawable.icon_nav_hot_share_selector);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53561d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.f53563f.g(i);
        this.f53558a.getLayoutMode().k(i == 1);
        this.f53558a.getLayoutMode().j(this.i);
        this.f53560c.c(this.f53558a.getPageContext(), i);
        this.f53564g.n(null);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f53565h, R.color.CAM_X0201);
    }

    public boolean p() {
        if (m()) {
            g();
            return true;
        }
        return false;
    }

    public void q() {
        this.f53564g.c(false);
    }

    public void r() {
        NoNetworkView.b bVar;
        NoNetworkView noNetworkView = this.f53560c;
        if (noNetworkView == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public void s(int i) {
        if (i < 0 || i >= this.f53564g.getCount()) {
            return;
        }
        this.f53562e.setCurrentItem(i, false);
    }

    public void t(int i) {
        NoNetworkView noNetworkView = this.f53560c;
        if (noNetworkView != null) {
            noNetworkView.setVisibility(i);
        }
    }

    public void u(NoNetworkView.b bVar) {
        this.n = bVar;
        NoNetworkView noNetworkView = this.f53560c;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void v(int i) {
        d.b.i0.c1.f.f.a aVar = this.f53563f;
        if (aVar != null) {
            aVar.j(i);
        }
    }

    public void w(int i) {
        this.f53562e.setVisibility(i);
    }

    public void x() {
        this.f53564g.m();
    }

    public void y() {
        d.b.i0.c1.c.j jVar;
        if (this.j == null) {
            d.b.i0.c1.f.f.c cVar = new d.b.i0.c1.f.f.c(this.f53565h);
            this.j = cVar;
            cVar.l(this.q);
        }
        this.j.m(this.l);
        if (this.j.j() || (jVar = (d.b.i0.c1.c.j) ListUtils.getItem(this.f53564g.f(), 0)) == null) {
            return;
        }
        this.j.n(this.f53558a.getActivity(), jVar.f53524b, this.f53562e.getCurrentItem());
        d.b.i0.c1.f.f.a aVar = this.f53563f;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void z() {
        this.f53563f.i(this.f53562e);
    }
}
