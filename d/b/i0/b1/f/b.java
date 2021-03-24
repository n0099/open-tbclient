package d.b.i0.b1.f;

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
import d.b.b.e.p.j;
import d.b.i0.b1.c.p;
import d.b.i0.b1.f.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f52156a;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f52158c;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f52160e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.b1.f.f.a f52161f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f52162g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f52163h;
    public View i;
    public d.b.i0.b1.f.f.c j;
    public boolean k;
    public int l;
    public ImageView m;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f52157b = null;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f52159d = null;
    public NoNetworkView.b n = null;
    public View.OnClickListener o = new a();
    public final d.b.h0.b1.j.e p = new C1130b();
    public c.InterfaceC1134c q = new c();

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

    /* renamed from: d.b.i0.b1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1130b implements d.b.h0.b1.j.e {
        public C1130b() {
        }

        @Override // d.b.h0.b1.j.e
        public void a(View view, int i, int i2, int i3, int i4) {
            b.this.l = i2;
            if (b.this.f52162g != null) {
                b.this.f52162g.k(view, i, i2, i3, i4);
            }
            if (b.this.j != null) {
                b.this.j.k(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.InterfaceC1134c {
        public c() {
        }

        @Override // d.b.i0.b1.f.f.c.InterfaceC1134c
        public void a() {
            if (b.this.f52161f != null) {
                b.this.f52161f.d();
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
                b.this.f52156a.showToast(R.string.topic_share_no_network);
            } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(b.this.f52156a)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                b.this.f52156a.shareTopic();
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.f52156a = hotRanklistActivity;
        l();
    }

    public void g() {
        d.b.i0.b1.f.f.c cVar = this.j;
        if (cVar != null) {
            cVar.f(this.f52156a.getActivity());
        }
    }

    public int h() {
        return this.f52160e.getCurrentItem();
    }

    public View i() {
        return this.f52163h;
    }

    public int j(p pVar) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f52162g;
        if (scrollFragmentAdapter == null) {
            return -1;
        }
        return scrollFragmentAdapter.g(pVar);
    }

    public void k() {
        this.f52162g.i();
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity = this.f52156a;
        if (hotRanklistActivity == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.i = inflate;
        this.f52156a.setContentView(inflate);
        this.f52163h = (FrameLayout) this.f52156a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f52156a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f52157b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f52159d = (ImageView) this.f52157b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f52157b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f52158c = (NoNetworkView) this.f52156a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.i.findViewById(R.id.topic_tab_bottom_line);
        d.b.i0.b1.f.f.a aVar = new d.b.i0.b1.f.f.a(this.f52156a.getActivity(), this.f52156a.findViewById(R.id.topic_tab_container));
        this.f52161f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f52156a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f52160e = (CustomViewPager) this.f52156a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f52156a.getActivity());
        this.f52162g = scrollFragmentAdapter;
        this.f52160e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        d.b.i0.b1.f.f.c cVar = this.j;
        return cVar != null && cVar.j();
    }

    public void n(List<d.b.i0.b1.c.j> list) {
        this.f52162g.n(list);
    }

    public void o(int i) {
        this.f52157b.onChangeSkinType(this.f52156a.getPageContext(), i);
        SkinManager.setImageResource(this.f52159d, R.drawable.icon_nav_hot_share_selector);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52159d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.f52161f.g(i);
        this.f52156a.getLayoutMode().k(i == 1);
        this.f52156a.getLayoutMode().j(this.i);
        this.f52158c.c(this.f52156a.getPageContext(), i);
        this.f52162g.n(null);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f52163h, R.color.CAM_X0201);
    }

    public boolean p() {
        if (m()) {
            g();
            return true;
        }
        return false;
    }

    public void q() {
        this.f52162g.c(false);
    }

    public void r() {
        NoNetworkView.b bVar;
        NoNetworkView noNetworkView = this.f52158c;
        if (noNetworkView == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public void s(int i) {
        if (i < 0 || i >= this.f52162g.getCount()) {
            return;
        }
        this.f52160e.setCurrentItem(i, false);
    }

    public void t(int i) {
        NoNetworkView noNetworkView = this.f52158c;
        if (noNetworkView != null) {
            noNetworkView.setVisibility(i);
        }
    }

    public void u(NoNetworkView.b bVar) {
        this.n = bVar;
        NoNetworkView noNetworkView = this.f52158c;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void v(int i) {
        d.b.i0.b1.f.f.a aVar = this.f52161f;
        if (aVar != null) {
            aVar.j(i);
        }
    }

    public void w(int i) {
        this.f52160e.setVisibility(i);
    }

    public void x() {
        this.f52162g.m();
    }

    public void y() {
        d.b.i0.b1.c.j jVar;
        if (this.j == null) {
            d.b.i0.b1.f.f.c cVar = new d.b.i0.b1.f.f.c(this.f52163h);
            this.j = cVar;
            cVar.l(this.q);
        }
        this.j.m(this.l);
        if (this.j.j() || (jVar = (d.b.i0.b1.c.j) ListUtils.getItem(this.f52162g.f(), 0)) == null) {
            return;
        }
        this.j.n(this.f52156a.getActivity(), jVar.f52122b, this.f52160e.getCurrentItem());
        d.b.i0.b1.f.f.a aVar = this.f52161f;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void z() {
        this.f52161f.i(this.f52160e);
    }
}
