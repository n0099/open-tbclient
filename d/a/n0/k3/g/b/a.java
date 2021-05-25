package d.a.n0.k3.g.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PersonalCardDetailActivity f57108a;

    /* renamed from: b  reason: collision with root package name */
    public View f57109b;

    /* renamed from: c  reason: collision with root package name */
    public View f57110c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57111d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f57112e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f57113f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57114g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f57115h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57116i;
    public TextView j;
    public HeadImageView k;
    public TextView l;
    public TbImageView m;
    public UserIconBox n;
    public View o;
    public View p;
    public d.a.n0.k3.a q;
    public View.OnClickListener r;
    public int s;
    public int t;
    public int u;
    public int v;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.f57108a = personalCardDetailActivity;
        View inflate = LayoutInflater.from(personalCardDetailActivity.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.f57109b = inflate;
        this.f57108a.setContentView(inflate);
        this.f57108a.setNetRefreshViewTopMargin(BdListViewHelper.f12948a);
        this.s = l.g(this.f57108a.getPageContext().getPageActivity(), R.dimen.ds4);
        this.t = l.g(this.f57108a.getPageContext().getPageActivity(), R.dimen.ds10);
        this.u = l.g(this.f57108a.getPageContext().getPageActivity(), R.dimen.ds16);
        this.v = l.g(this.f57108a.getPageContext().getPageActivity(), R.dimen.ds30);
        this.r = onClickListener;
        NavigationBar navigationBar = (NavigationBar) this.f57109b.findViewById(R.id.view_navigation_bar);
        this.f57111d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57111d.setTitleText(R.string.personal_card_detail);
        this.f57112e = (NoNetworkView) this.f57109b.findViewById(R.id.view_no_network);
        this.f57110c = this.f57109b.findViewById(R.id.content_view);
        this.p = this.f57109b.findViewById(R.id.top_divider_view);
        TbImageView tbImageView = (TbImageView) this.f57109b.findViewById(R.id.card_image_view);
        this.f57113f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
        this.f57113f.setDefaultResource(R.drawable.transparent_bg);
        this.l = (TextView) this.f57109b.findViewById(R.id.user_name_text_view);
        HeadImageView headImageView = (HeadImageView) this.f57109b.findViewById(R.id.user_head_view);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDrawBorder(false);
        this.n = (UserIconBox) this.f57109b.findViewById(R.id.card_user_icon_box);
        this.m = (TbImageView) this.f57109b.findViewById(R.id.user_vip_image_view);
        this.o = this.f57109b.findViewById(R.id.divider_view);
        this.f57114g = (TextView) this.f57109b.findViewById(R.id.card_name_text_view);
        this.f57116i = (TextView) this.f57109b.findViewById(R.id.card_description_text_view);
        this.j = (TextView) this.f57109b.findViewById(R.id.card_use_button);
        TbImageView tbImageView2 = (TbImageView) this.f57109b.findViewById(R.id.card_vip_image_view);
        this.f57115h = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.f57115h.setDefaultBgResource(R.drawable.transparent_bg);
        this.j.setOnClickListener(this.r);
    }

    public void a() {
        this.f57108a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f57108a.getLayoutMode().j(this.f57109b);
        NavigationBar navigationBar = this.f57111d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57108a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f57112e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57108a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public void b() {
        this.f57110c.setVisibility(0);
        this.p.setVisibility(0);
        this.f57113f.setVisibility(0);
        this.o.setVisibility(0);
        this.f57114g.setVisibility(0);
        this.f57116i.setVisibility(0);
        this.f57115h.setVisibility(0);
        this.j.setVisibility(0);
        this.f57108a.hideNetRefreshView(this.f57109b);
    }

    public View c() {
        return this.f57109b;
    }

    public View d() {
        return this.j;
    }

    public final void e() {
        d.a.n0.k3.a aVar = this.q;
        if (aVar == null) {
            return;
        }
        this.f57114g.setText(aVar.j());
        this.f57116i.setText(this.q.d());
        this.f57115h.V(this.q.i(), 10, false);
    }

    public final void f() {
        String str;
        String str2;
        int i2;
        int i3;
        if (this.q == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setPadding(this.u, 0, 0, 0);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            this.l.setText(R.string.default_user_name);
        } else {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            String str3 = null;
            if (currentAccountInfo != null) {
                String portrait = currentAccountInfo.getPortrait();
                str = currentAccountInfo.getAccountNameShow();
                String memberIconUrl = currentAccountInfo.getMemberIconUrl();
                i2 = currentAccountInfo.getMemberType();
                str2 = portrait;
                str3 = memberIconUrl;
            } else {
                str = null;
                str2 = null;
                i2 = 0;
            }
            if (i2 > 0) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1);
            }
            if (StringUtils.isNull(str3)) {
                this.m.setVisibility(8);
                this.l.setPadding(this.u, 0, 0, 0);
                this.l.setText(str);
            } else {
                this.m.setVisibility(0);
                this.m.V(str3, 10, false);
                this.l.setPadding(this.s, 0, 0, 0);
                this.l.setText(str);
            }
            this.n.setVisibility(0);
            int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
            int i4 = (size < 8 && (i3 = size - 1) < 4) ? i3 : 4;
            if (currentAccountInfo != null) {
                UserIconBox userIconBox = this.n;
                List<IconData> userIcons = currentAccountInfo.getUserIcons();
                int i5 = this.v;
                userIconBox.h(userIcons, i4, i5, i5, this.t, true);
            }
            this.k.V(str2, 12, false);
        }
        this.f57113f.V(this.q.e(), 10, false);
    }

    public void g() {
        this.f57110c.setVisibility(8);
        this.f57113f.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.f57114g.setVisibility(8);
        this.f57116i.setVisibility(8);
        this.f57115h.setVisibility(8);
        this.j.setVisibility(8);
        this.f57108a.showNetRefreshView(this.f57109b, this.f57108a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void h(int i2, d.a.n0.k3.a aVar) {
        if (aVar == null) {
            g();
        } else if (i2 != 0) {
        } else {
            this.q = aVar;
            b();
            f();
            e();
            i(aVar);
        }
    }

    public void i(d.a.n0.k3.a aVar) {
        if (aVar == null) {
            return;
        }
        this.q = aVar;
        if (aVar == null) {
            this.j.setVisibility(8);
            return;
        }
        int f2 = aVar.f();
        this.j.setVisibility(0);
        if (this.q.g() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.do_not_use);
        } else if (this.q.c() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.use_immediately);
        } else if (f2 == 0) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.use_freely);
        } else if (f2 == 100) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
            if (this.q.h() == 0) {
                this.j.setText(R.string.activity_free_use);
            } else {
                this.j.setText(R.string.use_immediately);
            }
        } else if (f2 == 101) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.become_annual_free_use);
        } else if (f2 > 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(String.format(this.f57108a.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(f2)));
        } else {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.become_member_free_use);
        }
    }
}
