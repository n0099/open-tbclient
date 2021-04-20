package d.b.i0.e1.q.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailActivity;
import d.b.c.e.p.l;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public RecommendDetailActivity f55493a;

    /* renamed from: b  reason: collision with root package name */
    public View f55494b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f55495c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f55496d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f55497e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55498f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55499g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55500h;
    public LinearLayout i;
    public SettingTextSwitchView j;
    public NoDataView k;
    public LinearLayout l;
    public View m;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.f55493a = recommendDetailActivity;
        c();
    }

    public void a() {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void b() {
        NoDataView noDataView = this.k;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l.setVisibility(0);
    }

    public final void c() {
        RecommendDetailActivity recommendDetailActivity = this.f55493a;
        if (recommendDetailActivity == null) {
            return;
        }
        recommendDetailActivity.setContentView(R.layout.recommend_detail_activity);
        this.f55494b = this.f55493a.findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) this.f55493a.findViewById(R.id.view_navigation_bar);
        this.f55495c = navigationBar;
        navigationBar.showBottomLine();
        this.f55495c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        e(this.f55493a.getResources().getString(R.string.recommend_detail_activity_title));
        this.f55496d = (NoNetworkView) this.f55493a.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.f55493a.findViewById(R.id.content_view);
        HeadImageView headImageView = (HeadImageView) this.f55493a.findViewById(R.id.user_image);
        this.f55497e = headImageView;
        headImageView.setIsRound(true);
        this.f55498f = (TextView) this.f55493a.findViewById(R.id.user_name);
        this.f55499g = (TextView) this.f55493a.findViewById(R.id.user_type);
        this.f55500h = (TextView) this.f55493a.findViewById(R.id.intro_content);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) this.f55493a.findViewById(R.id.switch_view);
        this.j = settingTextSwitchView;
        settingTextSwitchView.setSwitchStateChangeListener(this.f55493a);
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        this.i = (LinearLayout) this.f55493a.findViewById(R.id.switch_ll);
        this.m = this.f55493a.findViewById(R.id.divider_1);
    }

    public void d(int i) {
        RecommendDetailActivity recommendDetailActivity = this.f55493a;
        if (recommendDetailActivity == null || recommendDetailActivity.getPageContext() == null || this.f55493a.getPageContext().getLayoutMode() == null) {
            return;
        }
        NavigationBar navigationBar = this.f55495c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f55493a.getPageContext(), i);
        }
        NoNetworkView noNetworkView = this.f55496d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f55493a.getPageContext(), i);
        }
        NoDataView noDataView = this.k;
        if (noDataView != null) {
            noDataView.f(this.f55493a.getPageContext(), i);
        }
        SettingTextSwitchView settingTextSwitchView = this.j;
        if (settingTextSwitchView != null) {
            settingTextSwitchView.d(i);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
        }
        this.f55493a.getPageContext().getLayoutMode().k(i == 1);
        this.f55493a.getPageContext().getLayoutMode().j(this.f55494b);
    }

    public void e(String str) {
        NavigationBar navigationBar = this.f55495c;
        if (navigationBar != null) {
            navigationBar.setCenterTextTitle(str);
        }
    }

    public void f(boolean z) {
        if (z) {
            this.j.getSwitchView().k();
        } else {
            this.j.getSwitchView().h();
        }
    }

    public void g() {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void h(int i) {
        if (this.k == null) {
            this.k = NoDataViewFactory.a(this.f55493a.getPageContext().getPageActivity(), this.f55494b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.e.a(i), null);
        }
        this.k.setTextOption(NoDataViewFactory.e.a(i));
        this.k.f(this.f55493a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.l.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void i(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip == null || this.f55493a == null) {
            return;
        }
        this.f55497e.W(userInfoBigVip.portraith, 12, false);
        this.f55498f.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
        this.f55499g.setText(userInfoBigVip.user_type);
        this.f55500h.setText(userInfoBigVip.user_detail);
        if (z) {
            if (userInfoBigVip.message_accept.intValue() == 1) {
                f(true);
                TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), true);
            } else {
                f(false);
                TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), false);
            }
        } else if (TbadkCoreApplication.getInst().isPromotedMessageOn(String.valueOf(userInfoBigVip.user_id))) {
            f(true);
        } else {
            f(false);
        }
        this.j.setVisibility(0);
    }
}
