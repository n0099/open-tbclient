package d.b.j0.c1.f;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f53991a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f53992b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f53993c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53994d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53995e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f53996f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f53997g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.c1.f.e f53998h;
    public HotTopicHeaderView i;
    public CustomViewPager j;
    public HotTopicThreadPagerAdapter k;
    public DisableScrollLayout l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public ImageView q;
    public d.b.j0.c1.b.c r;
    public NoNetworkView.b s;
    public boolean v;
    public float w;
    public String y;
    public final d.b.i0.b1.j.e t = new a();
    public final d.b.i0.b1.j.e u = new b();
    public boolean x = false;
    public f z = new e();

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.b1.j.e {
        public a() {
        }

        @Override // d.b.i0.b1.j.e
        public void a(View view, int i, int i2, int i3, int i4) {
            c.this.o = i2;
            if (c.this.i != null) {
                c.this.i.i(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.b1.j.e {
        public b() {
        }

        @Override // d.b.i0.b1.j.e
        public void a(View view, int i, int i2, int i3, int i4) {
            c.this.n = i2;
            c.this.k.i(i2);
            c.this.l.setHeaderViewHeight(i2);
        }
    }

    /* renamed from: d.b.j0.c1.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1214c implements View.OnClickListener {
        public View$OnClickListenerC1214c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.z()) {
                ((HotTopicActivity) c.this.f53991a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(c.this.f53991a.getContext())) {
                TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) c.this.f53991a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) c.this.f53991a.getOrignalPage()).getHotTopicId()));
                ((HotTopicActivity) c.this.f53991a.getOrignalPage()).shareTopic();
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
                ((HotTopicActivity) c.this.f53991a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(c.this.f53991a.getContext())) {
                TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) c.this.f53991a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) c.this.f53991a.getOrignalPage()).getHotTopicId()));
                ((HotTopicActivity) c.this.f53991a.getOrignalPage()).shareTopic();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f {
        public e() {
            super(c.this);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView l = c.this.k.l();
            if (l == null) {
                return;
            }
            if (absListView == l.getListView()) {
                if (c.this.f53998h != null) {
                    c.this.f53998h.m(i);
                }
                c.this.G();
            }
            if (c.this.k != null && c.this.i.getNavigationBarSwitchHeight() != c.this.o) {
                if (c.this.x) {
                    float navigationBarSwitchHeight = (-c.this.i.getY()) / (c.this.i.getNavigationBarSwitchHeight() - c.this.o);
                    c.this.f53993c.setAlpha(1.0f - navigationBarSwitchHeight);
                    c.this.f53994d.setAlpha(navigationBarSwitchHeight);
                    if (c.this.p != null) {
                        c.this.p.setAlpha((-c.this.i.getY()) / (c.this.i.getNavigationBarSwitchHeight() - c.this.o));
                    }
                } else {
                    if (c.this.p != null) {
                        c.this.p.setAlpha((-c.this.i.getY()) / (c.this.i.getNavigationBarSwitchHeight() - c.this.o));
                    }
                    if (Math.abs(c.this.w) == c.this.v()) {
                        c.this.f53994d.hideBottomLine();
                    } else {
                        c.this.f53994d.showBottomLine();
                    }
                }
            }
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.f53991a.getOrignalPage()) != null) {
                hotTopicActivity.onScrollToBottom();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView l = c.this.k.l();
            if (l != null && absListView == l.getListView() && i == 0) {
                c.this.v = true;
                float y = c.this.i.getY();
                if (c.this.k != null) {
                    if (Math.abs(c.this.w) != c.this.v() || c.this.w == y) {
                        c.this.k.u((int) (c.this.w - y));
                        return;
                    }
                    c.this.k.v(y);
                    c.this.f53993c.hideBottomLine();
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
        this.f53991a = tbPageContext;
        this.y = str;
        z();
    }

    public void A(List<d.b.j0.c1.c.e> list) {
        this.k.A(list);
    }

    public void B(int i) {
        NavigationBar navigationBar = this.f53993c;
        if (navigationBar != null && this.x) {
            navigationBar.onChangeSkinType(this.f53991a, i);
            this.f53993c.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            SkinManager.setImageResource(this.f53993c.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.f53993c.setAlpha((this.i.getY() / (this.i.getNavigationBarSwitchHeight() - this.o)) + 1.0f);
        }
        NavigationBar navigationBar2 = this.f53994d;
        if (navigationBar2 != null) {
            navigationBar2.onChangeSkinType(this.f53991a, i);
            if (this.x) {
                this.f53994d.setAlpha((-this.i.getY()) / (this.i.getNavigationBarSwitchHeight() - this.o));
            } else {
                this.f53994d.setAlpha(1.0f);
            }
        }
        NoNetworkView noNetworkView = this.f53997g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f53991a, i);
        }
        if (this.f53996f != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53996f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.f53995e != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53995e, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        HotTopicHeaderView hotTopicHeaderView = this.i;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.m();
        }
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.p(i);
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
        NoNetworkView noNetworkView = this.f53997g;
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
            this.w = this.i.getY();
            this.v = false;
        }
    }

    public final void H(String str) {
        TextView textView = this.p;
        if (textView != null) {
            textView.setText(str);
            return;
        }
        NavigationBar navigationBar = this.f53994d;
        if (navigationBar != null) {
            this.p = navigationBar.setCenterTextTitle(str);
        }
    }

    public void I(int i) {
        this.i.setVisibility(i);
        this.j.setVisibility(i);
    }

    public void J(NoNetworkView.b bVar) {
        this.s = bVar;
        NoNetworkView noNetworkView = this.f53997g;
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

    public void L(d.b.j0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        if (!this.i.l()) {
            this.i.setData(eVar.h());
        }
        if (eVar.h() != null) {
            boolean z = !StringUtils.isNull(eVar.h().i);
            this.x = z;
            this.f53993c.setVisibility(z ? 0 : 8);
            if (!this.x) {
                this.f53994d.setAlpha(1.0f);
                this.f53994d.showBottomLine();
            }
        }
        String str = eVar.h().f53934f;
        if (StringUtils.isNull(str)) {
            this.q.setVisibility(8);
            H("");
        } else {
            H(d.b.j0.c1.e.a.a(str, 10));
        }
        this.i.setHeaderBottomLineShow(true);
    }

    public void M(int i) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.x(i);
        }
    }

    public void N() {
        this.k.y();
    }

    public void O(int i) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.z(i);
        }
    }

    public void P(AbsListView absListView, int i) {
        HotTopicView l;
        if (this.i == null || this.l == null || (l = this.k.l()) == null || l.getListView() == null || absListView != l.getListView()) {
            return;
        }
        this.l.setHeaderViewHeight(this.n - i);
        this.i.setY(-i);
        if (i == 0) {
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
        d.b.j0.c1.f.e eVar = this.f53998h;
        if (eVar != null) {
            eVar.k();
        }
        NoNetworkView noNetworkView = this.f53997g;
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
        return this.i;
    }

    public int t() {
        return this.n;
    }

    public View u() {
        return this.f53992b;
    }

    public int v() {
        return (this.n - this.m) - this.o;
    }

    public void w(int i) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
        if (hotTopicThreadPagerAdapter != null) {
            hotTopicThreadPagerAdapter.m(i);
        }
    }

    public void x() {
        this.k.n();
    }

    public void y(int i, boolean z, long j, int i2) {
        this.f53998h.l(i, z, j, i2);
    }

    public final void z() {
        TbPageContext<HotTopicActivity> tbPageContext = this.f53991a;
        if (tbPageContext == null) {
            return;
        }
        tbPageContext.getOrignalPage().setContentView(R.layout.hot_topic_activity);
        this.m = l.g(this.f53991a.getPageActivity(), R.dimen.ds80);
        d.b.j0.c1.b.c cVar = new d.b.j0.c1.b.c((OvalActionButton) this.f53991a.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.f53991a);
        this.r = cVar;
        cVar.d(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) this.f53991a.getOrignalPage().findViewById(R.id.hot_topic_root_view);
        this.f53992b = relativeLayout;
        this.l = (DisableScrollLayout) relativeLayout.findViewById(R.id.disable_scroll_layout);
        NavigationBar navigationBar = (NavigationBar) this.f53991a.getOrignalPage().findViewById(R.id.view_navigation_bar);
        this.f53993c = navigationBar;
        navigationBar.hideBottomLine();
        NavigationBar navigationBar2 = (NavigationBar) this.f53991a.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
        this.f53994d = navigationBar2;
        TextView centerTextTitle = navigationBar2.setCenterTextTitle("");
        this.p = centerTextTitle;
        centerTextTitle.setAlpha(0.0f);
        this.f53994d.hideBottomLine();
        this.f53993c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        SkinManager.setImageResource(this.f53993c.getBackImageView(), R.drawable.selector_topbar_return_white);
        this.f53994d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53995e = (ImageView) this.f53993c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View$OnClickListenerC1214c());
        this.f53996f = (ImageView) this.f53994d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d());
        this.f53997g = (NoNetworkView) this.f53992b.findViewById(R.id.view_no_network);
        ((ObservedChangeLinearLayout) this.f53992b.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.t);
        this.f53998h = new d.b.j0.c1.f.e(this.f53991a, this.f53992b);
        HotTopicHeaderView hotTopicHeaderView = (HotTopicHeaderView) this.f53992b.findViewById(R.id.hot_topic_header);
        this.i = hotTopicHeaderView;
        hotTopicHeaderView.setOnSizeChangeListener(this.u);
        this.j = (CustomViewPager) this.f53992b.findViewById(R.id.hot_topic_view_pager);
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = new HotTopicThreadPagerAdapter(this.f53991a.getPageActivity(), this.z);
        this.k = hotTopicThreadPagerAdapter;
        hotTopicThreadPagerAdapter.w(this);
        this.j.setAdapter(this.k);
        this.i.setViewPager(this.j);
        this.i.setHeaderBottomLineShow(false);
        ImageView imageView = (ImageView) this.f53992b.findViewById(R.id.normal_write_icon);
        this.q = imageView;
        imageView.setVisibility(8);
    }
}
