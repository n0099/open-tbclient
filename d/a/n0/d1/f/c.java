package d.a.n0.d1.f;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.DisableScrollLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.adapter.HotTopicThreadPagerAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicHeaderView;
import com.baidu.tieba.hottopic.view.HotTopicView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f56326a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f56327b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56328c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56329d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56330e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56331f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f56332g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.d1.f.e f56333h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicHeaderView f56334i;
    public CustomViewPager j;
    public HotTopicThreadPagerAdapter k;
    public DisableScrollLayout l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public ImageView q;
    public d.a.n0.d1.b.c r;
    public NoNetworkView.b s;
    public boolean v;
    public float w;
    public String y;
    public final d.a.m0.b1.j.e t = new a();
    public final d.a.m0.b1.j.e u = new b();
    public boolean x = false;
    public f z = new e();

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.b1.j.e {
        public a() {
        }

        @Override // d.a.m0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            c.this.o = i3;
            if (c.this.f56334i != null) {
                c.this.f56334i.i(i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.m0.b1.j.e {
        public b() {
        }

        @Override // d.a.m0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            c.this.n = i3;
            c.this.k.i(i3);
            c.this.l.setHeaderViewHeight(i3);
        }
    }

    /* renamed from: d.a.n0.d1.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1298c implements View.OnClickListener {
        public View$OnClickListenerC1298c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.z()) {
                ((HotTopicActivity) c.this.f56326a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(c.this.f56326a.getContext())) {
                TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) c.this.f56326a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) c.this.f56326a.getOrignalPage()).getHotTopicId()));
                ((HotTopicActivity) c.this.f56326a.getOrignalPage()).shareTopic();
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
                ((HotTopicActivity) c.this.f56326a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(c.this.f56326a.getContext())) {
                TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) c.this.f56326a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) c.this.f56326a.getOrignalPage()).getHotTopicId()));
                ((HotTopicActivity) c.this.f56326a.getOrignalPage()).shareTopic();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f {
        public e() {
            super(c.this);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            HotTopicActivity hotTopicActivity;
            HotTopicView l = c.this.k.l();
            if (l == null) {
                return;
            }
            if (absListView == l.getListView()) {
                if (c.this.f56333h != null) {
                    c.this.f56333h.m(i2);
                }
                c.this.G();
            }
            if (c.this.k != null && c.this.f56334i.getNavigationBarSwitchHeight() != c.this.o) {
                if (c.this.x) {
                    float navigationBarSwitchHeight = (-c.this.f56334i.getY()) / (c.this.f56334i.getNavigationBarSwitchHeight() - c.this.o);
                    c.this.f56328c.setAlpha(1.0f - navigationBarSwitchHeight);
                    c.this.f56329d.setAlpha(navigationBarSwitchHeight);
                    if (c.this.p != null) {
                        c.this.p.setAlpha((-c.this.f56334i.getY()) / (c.this.f56334i.getNavigationBarSwitchHeight() - c.this.o));
                    }
                } else {
                    if (c.this.p != null) {
                        c.this.p.setAlpha((-c.this.f56334i.getY()) / (c.this.f56334i.getNavigationBarSwitchHeight() - c.this.o));
                    }
                    if (Math.abs(c.this.w) == c.this.v()) {
                        c.this.f56329d.hideBottomLine();
                    } else {
                        c.this.f56329d.showBottomLine();
                    }
                }
            }
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.f56326a.getOrignalPage()) != null) {
                hotTopicActivity.onScrollToBottom();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            HotTopicView l = c.this.k.l();
            if (l != null && absListView == l.getListView() && i2 == 0) {
                c.this.v = true;
                float y = c.this.f56334i.getY();
                if (c.this.k != null) {
                    if (Math.abs(c.this.w) != c.this.v() || c.this.w == y) {
                        c.this.k.t((int) (c.this.w - y));
                        return;
                    }
                    c.this.k.u(y);
                    c.this.f56328c.hideBottomLine();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public abstract class f implements AbsListView.OnScrollListener {
        public f(c cVar) {
        }
    }

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.f56326a = tbPageContext;
        this.y = str;
        z();
    }

    public void A(List<d.a.n0.d1.c.e> list) {
        this.k.z(list);
    }

    public void B(int i2) {
        NavigationBar navigationBar = this.f56328c;
        if (navigationBar != null && this.x) {
            navigationBar.onChangeSkinType(this.f56326a, i2);
            this.f56328c.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            SkinManager.setImageResource(this.f56328c.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.f56328c.setAlpha((this.f56334i.getY() / (this.f56334i.getNavigationBarSwitchHeight() - this.o)) + 1.0f);
        }
        NavigationBar navigationBar2 = this.f56329d;
        if (navigationBar2 != null) {
            navigationBar2.onChangeSkinType(this.f56326a, i2);
            if (this.x) {
                this.f56329d.setAlpha((-this.f56334i.getY()) / (this.f56334i.getNavigationBarSwitchHeight() - this.o));
            } else {
                this.f56329d.setAlpha(1.0f);
            }
        }
        NoNetworkView noNetworkView = this.f56332g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56326a, i2);
        }
        if (this.f56331f != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56331f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.f56330e != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56330e, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        HotTopicHeaderView hotTopicHeaderView = this.f56334i;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.m();
        }
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.p(i2);
        }
        ImageView imageView = this.q;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_tabbar_chaticon_n);
            SkinManager.setImageResource(this.q, R.drawable.icon_tabbar_add_n);
        }
    }

    public void C() {
        this.k.j(false);
    }

    public void D() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.q();
        }
    }

    public void E(boolean z) {
        NoNetworkView noNetworkView = this.f56332g;
        if (noNetworkView == null) {
            return;
        }
        if (z) {
            noNetworkView.setVisibility(0);
        } else {
            noNetworkView.setVisibility(8);
        }
    }

    public void F() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.s();
        }
    }

    public final void G() {
        if (this.v) {
            this.w = this.f56334i.getY();
            this.v = false;
        }
    }

    public final void H(String str) {
        TextView textView = this.p;
        if (textView != null) {
            textView.setText(str);
            return;
        }
        NavigationBar navigationBar = this.f56329d;
        if (navigationBar != null) {
            this.p = navigationBar.setCenterTextTitle(str);
        }
    }

    public void I(int i2) {
        this.f56334i.setVisibility(i2);
        this.j.setVisibility(i2);
    }

    public void J(NoNetworkView.b bVar) {
        this.s = bVar;
        NoNetworkView noNetworkView = this.f56332g;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void K(View.OnTouchListener onTouchListener) {
        ImageView imageView;
        if (onTouchListener == null || (imageView = this.q) == null) {
            return;
        }
        imageView.setOnTouchListener(onTouchListener);
    }

    public void L(d.a.n0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        if (!this.f56334i.l()) {
            this.f56334i.setData(eVar.h());
        }
        if (eVar.h() != null) {
            boolean z = !StringUtils.isNull(eVar.h().f56266i);
            this.x = z;
            this.f56328c.setVisibility(z ? 0 : 8);
            if (!this.x) {
                this.f56329d.setAlpha(1.0f);
                this.f56329d.showBottomLine();
            }
        }
        String str = eVar.h().f56263f;
        if (StringUtils.isNull(str)) {
            this.q.setVisibility(8);
            H("");
        } else {
            H(d.a.n0.d1.e.a.a(str, 10));
        }
        this.f56334i.setHeaderBottomLineShow(true);
    }

    public void M(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.w(i2);
        }
    }

    public void N() {
        this.k.x();
    }

    public void O(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.y(i2);
        }
    }

    public void P(AbsListView absListView, int i2) {
        HotTopicView l;
        if (this.f56334i == null || this.l == null || (l = this.k.l()) == null || l.getListView() == null || absListView != l.getListView()) {
            return;
        }
        this.l.setHeaderViewHeight(this.n - i2);
        this.f56334i.setY(-i2);
        if (i2 == 0) {
            this.l.a(false);
        } else {
            this.l.a(true);
        }
    }

    public void p() {
        NoNetworkView.b bVar;
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.k();
        }
        d.a.n0.d1.f.e eVar = this.f56333h;
        if (eVar != null) {
            eVar.k();
        }
        NoNetworkView noNetworkView = this.f56332g;
        if (noNetworkView == null || (bVar = this.s) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public int q() {
        if (this.j.getCurrentItem() < 0) {
            return 0;
        }
        return this.j.getCurrentItem();
    }

    public HotTopicView r() {
        return this.k.l();
    }

    public HotTopicHeaderView s() {
        return this.f56334i;
    }

    public int t() {
        return this.n;
    }

    public View u() {
        return this.f56327b;
    }

    public int v() {
        return (this.n - this.m) - this.o;
    }

    public void w(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.m(i2);
        }
    }

    public void x() {
        this.k.n();
    }

    public void y(int i2, boolean z, long j, int i3) {
        this.f56333h.l(i2, z, j, i3);
    }

    public final void z() {
        TbPageContext<HotTopicActivity> tbPageContext = this.f56326a;
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.getOrignalPage().setContentView(R.layout.hot_topic_activity);
        this.m = l.g(this.f56326a.getPageActivity(), R.dimen.ds80);
        d.a.n0.d1.b.c cVar = new d.a.n0.d1.b.c((OvalActionButton) this.f56326a.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.f56326a);
        this.r = cVar;
        cVar.d(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) this.f56326a.getOrignalPage().findViewById(R.id.hot_topic_root_view);
        this.f56327b = relativeLayout;
        this.l = (DisableScrollLayout) relativeLayout.findViewById(R.id.disable_scroll_layout);
        NavigationBar navigationBar = (NavigationBar) this.f56326a.getOrignalPage().findViewById(R.id.view_navigation_bar);
        this.f56328c = navigationBar;
        navigationBar.hideBottomLine();
        NavigationBar navigationBar2 = (NavigationBar) this.f56326a.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
        this.f56329d = navigationBar2;
        TextView centerTextTitle = navigationBar2.setCenterTextTitle("");
        this.p = centerTextTitle;
        centerTextTitle.setAlpha(0.0f);
        this.f56329d.hideBottomLine();
        this.f56328c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        SkinManager.setImageResource(this.f56328c.getBackImageView(), R.drawable.selector_topbar_return_white);
        this.f56329d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56330e = (ImageView) this.f56328c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View$OnClickListenerC1298c());
        this.f56331f = (ImageView) this.f56329d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f56332g = (NoNetworkView) this.f56327b.findViewById(R.id.view_no_network);
        ((ObservedChangeLinearLayout) this.f56327b.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.t);
        this.f56333h = new d.a.n0.d1.f.e(this.f56326a, this.f56327b);
        HotTopicHeaderView hotTopicHeaderView = (HotTopicHeaderView) this.f56327b.findViewById(R.id.hot_topic_header);
        this.f56334i = hotTopicHeaderView;
        hotTopicHeaderView.setOnSizeChangeListener(this.u);
        this.j = (CustomViewPager) this.f56327b.findViewById(R.id.hot_topic_view_pager);
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = new HotTopicThreadPagerAdapter(this.f56326a.getPageActivity(), this.z);
        this.k = hotTopicThreadPagerAdapter;
        hotTopicThreadPagerAdapter.v(this);
        this.j.setAdapter(this.k);
        this.f56334i.setViewPager(this.j);
        this.f56334i.setHeaderBottomLineShow(false);
        ImageView imageView = (ImageView) this.f56327b.findViewById(R.id.normal_write_icon);
        this.q = imageView;
        imageView.setVisibility(8);
    }
}
