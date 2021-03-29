package d.b.i0.i3.g.b;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PersonalCardDetailActivity f56361a;

    /* renamed from: b  reason: collision with root package name */
    public View f56362b;

    /* renamed from: c  reason: collision with root package name */
    public View f56363c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56364d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56365e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f56366f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56367g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f56368h;
    public TextView i;
    public TextView j;
    public HeadImageView k;
    public TextView l;
    public TbImageView m;
    public UserIconBox n;
    public View o;
    public View p;
    public d.b.i0.i3.a q;
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
        this.f56361a = personalCardDetailActivity;
        View inflate = LayoutInflater.from(personalCardDetailActivity.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.f56362b = inflate;
        this.f56361a.setContentView(inflate);
        this.f56361a.setNetRefreshViewTopMargin(BdListViewHelper.f14031a);
        this.s = l.g(this.f56361a.getPageContext().getPageActivity(), R.dimen.ds4);
        this.t = l.g(this.f56361a.getPageContext().getPageActivity(), R.dimen.ds10);
        this.u = l.g(this.f56361a.getPageContext().getPageActivity(), R.dimen.ds16);
        this.v = l.g(this.f56361a.getPageContext().getPageActivity(), R.dimen.ds30);
        this.r = onClickListener;
        NavigationBar navigationBar = (NavigationBar) this.f56362b.findViewById(R.id.view_navigation_bar);
        this.f56364d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56364d.setTitleText(R.string.personal_card_detail);
        this.f56365e = (NoNetworkView) this.f56362b.findViewById(R.id.view_no_network);
        this.f56363c = this.f56362b.findViewById(R.id.content_view);
        this.p = this.f56362b.findViewById(R.id.top_divider_view);
        TbImageView tbImageView = (TbImageView) this.f56362b.findViewById(R.id.card_image_view);
        this.f56366f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
        this.f56366f.setDefaultResource(R.drawable.transparent_bg);
        this.l = (TextView) this.f56362b.findViewById(R.id.user_name_text_view);
        HeadImageView headImageView = (HeadImageView) this.f56362b.findViewById(R.id.user_head_view);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDrawBorder(false);
        this.n = (UserIconBox) this.f56362b.findViewById(R.id.card_user_icon_box);
        this.m = (TbImageView) this.f56362b.findViewById(R.id.user_vip_image_view);
        this.o = this.f56362b.findViewById(R.id.divider_view);
        this.f56367g = (TextView) this.f56362b.findViewById(R.id.card_name_text_view);
        this.i = (TextView) this.f56362b.findViewById(R.id.card_description_text_view);
        this.j = (TextView) this.f56362b.findViewById(R.id.card_use_button);
        TbImageView tbImageView2 = (TbImageView) this.f56362b.findViewById(R.id.card_vip_image_view);
        this.f56368h = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.f56368h.setDefaultBgResource(R.drawable.transparent_bg);
        this.j.setOnClickListener(this.r);
    }

    public void a() {
        this.f56361a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f56361a.getLayoutMode().j(this.f56362b);
        NavigationBar navigationBar = this.f56364d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56361a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f56365e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56361a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
    }

    public void b() {
        this.f56363c.setVisibility(0);
        this.p.setVisibility(0);
        this.f56366f.setVisibility(0);
        this.o.setVisibility(0);
        this.f56367g.setVisibility(0);
        this.i.setVisibility(0);
        this.f56368h.setVisibility(0);
        this.j.setVisibility(0);
        this.f56361a.hideNetRefreshView(this.f56362b);
    }

    public View c() {
        return this.f56362b;
    }

    public View d() {
        return this.j;
    }

    public final void e() {
        d.b.i0.i3.a aVar = this.q;
        if (aVar == null) {
            return;
        }
        this.f56367g.setText(aVar.j());
        this.i.setText(this.q.d());
        this.f56368h.W(this.q.i(), 10, false);
    }

    public final void f() {
        String str;
        String str2;
        int i;
        int i2;
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
                i = currentAccountInfo.getMemberType();
                str2 = portrait;
                str3 = memberIconUrl;
            } else {
                str = null;
                str2 = null;
                i = 0;
            }
            if (i > 0) {
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
                this.m.W(str3, 10, false);
                this.l.setPadding(this.s, 0, 0, 0);
                this.l.setText(str);
            }
            this.n.setVisibility(0);
            int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
            int i3 = (size < 8 && (i2 = size - 1) < 4) ? i2 : 4;
            if (currentAccountInfo != null) {
                UserIconBox userIconBox = this.n;
                List<IconData> userIcons = currentAccountInfo.getUserIcons();
                int i4 = this.v;
                userIconBox.h(userIcons, i3, i4, i4, this.t, true);
            }
            this.k.W(str2, 12, false);
        }
        this.f56366f.W(this.q.e(), 10, false);
    }

    public void g() {
        this.f56363c.setVisibility(8);
        this.f56366f.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.f56367g.setVisibility(8);
        this.i.setVisibility(8);
        this.f56368h.setVisibility(8);
        this.j.setVisibility(8);
        this.f56361a.showNetRefreshView(this.f56362b, this.f56361a.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void h(int i, d.b.i0.i3.a aVar) {
        if (aVar == null) {
            g();
        } else if (i != 0) {
        } else {
            this.q = aVar;
            b();
            f();
            e();
            i(aVar);
        }
    }

    public void i(d.b.i0.i3.a aVar) {
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
            this.j.setText(String.format(this.f56361a.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(f2)));
        } else {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.become_member_free_use);
        }
    }
}
