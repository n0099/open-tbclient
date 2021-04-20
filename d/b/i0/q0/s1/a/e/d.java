package d.b.i0.q0.s1.a.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameStrategyMainFragment f60230a;

    /* renamed from: b  reason: collision with root package name */
    public View f60231b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60232c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f60233d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollLabelTabHost f60234e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60235f;

    /* renamed from: g  reason: collision with root package name */
    public String f60236g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(d.this.f60230a.V())) {
                return;
            }
            d.this.f60230a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f60230a.getPageContext().getPageActivity(), d.this.f60230a.V(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("from_single_act".equals(d.this.f60236g)) {
                d.this.f60230a.getActivity().finish();
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, d.this.f60230a.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.f60230a = frsGameStrategyMainFragment;
        this.f60231b = view;
        if (view != null) {
            g();
        }
    }

    public void c(int i, int i2, List<n> list, List<d.b.i0.q0.s1.a.d.e> list2, boolean z, boolean z2, int i3) {
        this.f60234e.j(i, i2, list, list2, z, z2, i3);
    }

    public void d() {
        ScrollLabelTabHost scrollLabelTabHost = this.f60234e;
        if (scrollLabelTabHost != null) {
            scrollLabelTabHost.k();
        }
    }

    public NavigationBar e() {
        return this.f60232c;
    }

    public View f() {
        return this.f60231b;
    }

    public final void g() {
        this.f60232c = (NavigationBar) this.f60231b.findViewById(R.id.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f60230a.getPageContext().getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView = (ImageView) this.f60232c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.f60235f = imageView;
        imageView.setLayoutParams(layoutParams);
        this.f60235f.setOnClickListener(new a());
        this.f60232c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        this.f60233d = (NoNetworkView) this.f60231b.findViewById(R.id.view_no_network);
        ScrollLabelTabHost scrollLabelTabHost = (ScrollLabelTabHost) this.f60231b.findViewById(R.id.frs_game_tabview);
        this.f60234e = scrollLabelTabHost;
        scrollLabelTabHost.setPageId(this.f60230a.getBaseFragmentActivity().getUniqueId());
    }

    public void h(int i) {
        this.f60232c.onChangeSkinType(this.f60230a.getPageContext(), i);
        this.f60233d.c(this.f60230a.getPageContext(), i);
        this.f60234e.m(i);
        ImageView imageView = this.f60235f;
        if (imageView != null) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
    }

    public void i() {
        this.f60234e.n();
    }

    public void j(String str) {
        this.f60236g = str;
    }

    public void k(d.b.i0.q0.s1.a.d.a aVar) {
        this.f60234e.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void l(List<d.b.i0.q0.s1.a.d.e> list, boolean z) {
        this.f60234e.setTabData(list, z);
    }

    public void m(int i, int i2, String str) {
        this.f60234e.p(i, i2, str);
    }
}
