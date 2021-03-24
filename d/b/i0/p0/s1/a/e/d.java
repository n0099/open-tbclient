package d.b.i0.p0.s1.a.e;

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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameStrategyMainFragment f58561a;

    /* renamed from: b  reason: collision with root package name */
    public View f58562b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58563c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f58564d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollLabelTabHost f58565e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58566f;

    /* renamed from: g  reason: collision with root package name */
    public String f58567g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(d.this.f58561a.V())) {
                return;
            }
            d.this.f58561a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f58561a.getPageContext().getPageActivity(), d.this.f58561a.V(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("from_single_act".equals(d.this.f58567g)) {
                d.this.f58561a.getActivity().finish();
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, d.this.f58561a.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.f58561a = frsGameStrategyMainFragment;
        this.f58562b = view;
        if (view != null) {
            g();
        }
    }

    public void c(int i, int i2, List<n> list, List<d.b.i0.p0.s1.a.d.e> list2, boolean z, boolean z2, int i3) {
        this.f58565e.j(i, i2, list, list2, z, z2, i3);
    }

    public void d() {
        ScrollLabelTabHost scrollLabelTabHost = this.f58565e;
        if (scrollLabelTabHost != null) {
            scrollLabelTabHost.k();
        }
    }

    public NavigationBar e() {
        return this.f58563c;
    }

    public View f() {
        return this.f58562b;
    }

    public final void g() {
        this.f58563c = (NavigationBar) this.f58562b.findViewById(R.id.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f58561a.getPageContext().getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView = (ImageView) this.f58563c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.f58566f = imageView;
        imageView.setLayoutParams(layoutParams);
        this.f58566f.setOnClickListener(new a());
        this.f58563c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        this.f58564d = (NoNetworkView) this.f58562b.findViewById(R.id.view_no_network);
        ScrollLabelTabHost scrollLabelTabHost = (ScrollLabelTabHost) this.f58562b.findViewById(R.id.frs_game_tabview);
        this.f58565e = scrollLabelTabHost;
        scrollLabelTabHost.setPageId(this.f58561a.getBaseFragmentActivity().getUniqueId());
    }

    public void h(int i) {
        this.f58563c.onChangeSkinType(this.f58561a.getPageContext(), i);
        this.f58564d.c(this.f58561a.getPageContext(), i);
        this.f58565e.m(i);
        ImageView imageView = this.f58566f;
        if (imageView != null) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
    }

    public void i() {
        this.f58565e.n();
    }

    public void j(String str) {
        this.f58567g = str;
    }

    public void k(d.b.i0.p0.s1.a.d.a aVar) {
        this.f58565e.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void l(List<d.b.i0.p0.s1.a.d.e> list, boolean z) {
        this.f58565e.setTabData(list, z);
    }

    public void m(int i, int i2, String str) {
        this.f58565e.p(i, i2, str);
    }
}
