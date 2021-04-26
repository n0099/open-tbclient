package d.a.j0.q0.s1.a.e;

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
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameStrategyMainFragment f58758a;

    /* renamed from: b  reason: collision with root package name */
    public View f58759b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58760c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f58761d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollLabelTabHost f58762e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58763f;

    /* renamed from: g  reason: collision with root package name */
    public String f58764g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(d.this.f58758a.F())) {
                return;
            }
            d.this.f58758a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f58758a.getPageContext().getPageActivity(), d.this.f58758a.F(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("from_single_act".equals(d.this.f58764g)) {
                d.this.f58758a.getActivity().finish();
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, d.this.f58758a.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.f58758a = frsGameStrategyMainFragment;
        this.f58759b = view;
        if (view != null) {
            g();
        }
    }

    public void c(int i2, int i3, List<n> list, List<d.a.j0.q0.s1.a.d.e> list2, boolean z, boolean z2, int i4) {
        this.f58762e.j(i2, i3, list, list2, z, z2, i4);
    }

    public void d() {
        ScrollLabelTabHost scrollLabelTabHost = this.f58762e;
        if (scrollLabelTabHost != null) {
            scrollLabelTabHost.k();
        }
    }

    public NavigationBar e() {
        return this.f58760c;
    }

    public View f() {
        return this.f58759b;
    }

    public final void g() {
        this.f58760c = (NavigationBar) this.f58759b.findViewById(R.id.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f58758a.getPageContext().getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView = (ImageView) this.f58760c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.f58763f = imageView;
        imageView.setLayoutParams(layoutParams);
        this.f58763f.setOnClickListener(new a());
        this.f58760c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        this.f58761d = (NoNetworkView) this.f58759b.findViewById(R.id.view_no_network);
        ScrollLabelTabHost scrollLabelTabHost = (ScrollLabelTabHost) this.f58759b.findViewById(R.id.frs_game_tabview);
        this.f58762e = scrollLabelTabHost;
        scrollLabelTabHost.setPageId(this.f58758a.getBaseFragmentActivity().getUniqueId());
    }

    public void h(int i2) {
        this.f58760c.onChangeSkinType(this.f58758a.getPageContext(), i2);
        this.f58761d.c(this.f58758a.getPageContext(), i2);
        this.f58762e.m(i2);
        ImageView imageView = this.f58763f;
        if (imageView != null) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
    }

    public void i() {
        this.f58762e.n();
    }

    public void j(String str) {
        this.f58764g = str;
    }

    public void k(d.a.j0.q0.s1.a.d.a aVar) {
        this.f58762e.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void l(List<d.a.j0.q0.s1.a.d.e> list, boolean z) {
        this.f58762e.setTabData(list, z);
    }

    public void m(int i2, int i3, String str) {
        this.f58762e.p(i2, i3, str);
    }
}
