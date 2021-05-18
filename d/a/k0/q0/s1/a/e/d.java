package d.a.k0.q0.s1.a.e;

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
    public FrsGameStrategyMainFragment f59500a;

    /* renamed from: b  reason: collision with root package name */
    public View f59501b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59502c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f59503d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollLabelTabHost f59504e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59505f;

    /* renamed from: g  reason: collision with root package name */
    public String f59506g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(d.this.f59500a.F())) {
                return;
            }
            d.this.f59500a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f59500a.getPageContext().getPageActivity(), d.this.f59500a.F(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("from_single_act".equals(d.this.f59506g)) {
                d.this.f59500a.getActivity().finish();
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, d.this.f59500a.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        this.f59500a = frsGameStrategyMainFragment;
        this.f59501b = view;
        if (view != null) {
            g();
        }
    }

    public void c(int i2, int i3, List<n> list, List<d.a.k0.q0.s1.a.d.e> list2, boolean z, boolean z2, int i4) {
        this.f59504e.j(i2, i3, list, list2, z, z2, i4);
    }

    public void d() {
        ScrollLabelTabHost scrollLabelTabHost = this.f59504e;
        if (scrollLabelTabHost != null) {
            scrollLabelTabHost.k();
        }
    }

    public NavigationBar e() {
        return this.f59502c;
    }

    public View f() {
        return this.f59501b;
    }

    public final void g() {
        this.f59502c = (NavigationBar) this.f59501b.findViewById(R.id.view_navigation_bar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f59500a.getPageContext().getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView = (ImageView) this.f59502c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
        this.f59505f = imageView;
        imageView.setLayoutParams(layoutParams);
        this.f59505f.setOnClickListener(new a());
        this.f59502c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        this.f59503d = (NoNetworkView) this.f59501b.findViewById(R.id.view_no_network);
        ScrollLabelTabHost scrollLabelTabHost = (ScrollLabelTabHost) this.f59501b.findViewById(R.id.frs_game_tabview);
        this.f59504e = scrollLabelTabHost;
        scrollLabelTabHost.setPageId(this.f59500a.getBaseFragmentActivity().getUniqueId());
    }

    public void h(int i2) {
        this.f59502c.onChangeSkinType(this.f59500a.getPageContext(), i2);
        this.f59503d.c(this.f59500a.getPageContext(), i2);
        this.f59504e.m(i2);
        ImageView imageView = this.f59505f;
        if (imageView != null) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
    }

    public void i() {
        this.f59504e.n();
    }

    public void j(String str) {
        this.f59506g = str;
    }

    public void k(d.a.k0.q0.s1.a.d.a aVar) {
        this.f59504e.setDelegateFrsGameTabDataLoadListener(aVar);
    }

    public void l(List<d.a.k0.q0.s1.a.d.e> list, boolean z) {
        this.f59504e.setTabData(list, z);
    }

    public void m(int i2, int i3, String str) {
        this.f59504e.p(i2, i3, str);
    }
}
