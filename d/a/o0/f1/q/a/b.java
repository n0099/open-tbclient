package d.a.o0.f1.q.a;

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
import d.a.c.e.p.l;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public RecommendDetailActivity f58490a;

    /* renamed from: b  reason: collision with root package name */
    public View f58491b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58492c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f58493d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f58494e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58495f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58496g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58497h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f58498i;
    public SettingTextSwitchView j;
    public NoDataView k;
    public LinearLayout l;
    public View m;

    public b(RecommendDetailActivity recommendDetailActivity) {
        this.f58490a = recommendDetailActivity;
        c();
    }

    public void a() {
        LinearLayout linearLayout = this.f58498i;
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
        RecommendDetailActivity recommendDetailActivity = this.f58490a;
        if (recommendDetailActivity == null) {
            return;
        }
        recommendDetailActivity.setContentView(R.layout.recommend_detail_activity);
        this.f58491b = this.f58490a.findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) this.f58490a.findViewById(R.id.view_navigation_bar);
        this.f58492c = navigationBar;
        navigationBar.showBottomLine();
        this.f58492c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        e(this.f58490a.getResources().getString(R.string.recommend_detail_activity_title));
        this.f58493d = (NoNetworkView) this.f58490a.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.f58490a.findViewById(R.id.content_view);
        HeadImageView headImageView = (HeadImageView) this.f58490a.findViewById(R.id.user_image);
        this.f58494e = headImageView;
        headImageView.setIsRound(true);
        this.f58495f = (TextView) this.f58490a.findViewById(R.id.user_name);
        this.f58496g = (TextView) this.f58490a.findViewById(R.id.user_type);
        this.f58497h = (TextView) this.f58490a.findViewById(R.id.intro_content);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) this.f58490a.findViewById(R.id.switch_view);
        this.j = settingTextSwitchView;
        settingTextSwitchView.setSwitchStateChangeListener(this.f58490a);
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        this.f58498i = (LinearLayout) this.f58490a.findViewById(R.id.switch_ll);
        this.m = this.f58490a.findViewById(R.id.divider_1);
    }

    public void d(int i2) {
        RecommendDetailActivity recommendDetailActivity = this.f58490a;
        if (recommendDetailActivity == null || recommendDetailActivity.getPageContext() == null || this.f58490a.getPageContext().getLayoutMode() == null) {
            return;
        }
        NavigationBar navigationBar = this.f58492c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58490a.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f58493d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58490a.getPageContext(), i2);
        }
        NoDataView noDataView = this.k;
        if (noDataView != null) {
            noDataView.f(this.f58490a.getPageContext(), i2);
        }
        SettingTextSwitchView settingTextSwitchView = this.j;
        if (settingTextSwitchView != null) {
            settingTextSwitchView.d(i2);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
        }
        this.f58490a.getPageContext().getLayoutMode().k(i2 == 1);
        this.f58490a.getPageContext().getLayoutMode().j(this.f58491b);
    }

    public void e(String str) {
        NavigationBar navigationBar = this.f58492c;
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
        LinearLayout linearLayout = this.f58498i;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void h(int i2) {
        if (this.k == null) {
            this.k = NoDataViewFactory.a(this.f58490a.getPageContext().getPageActivity(), this.f58491b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
        }
        this.k.setTextOption(NoDataViewFactory.e.a(i2));
        this.k.f(this.f58490a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.l.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void i(UserInfoBigVip userInfoBigVip, boolean z) {
        if (userInfoBigVip == null || this.f58490a == null) {
            return;
        }
        this.f58494e.U(userInfoBigVip.portraith, 12, false);
        this.f58495f.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
        this.f58496g.setText(userInfoBigVip.user_type);
        this.f58497h.setText(userInfoBigVip.user_detail);
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
