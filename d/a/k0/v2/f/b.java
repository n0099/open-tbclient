package d.a.k0.v2.f;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteListActivity;
import d.a.c.a.d;
/* loaded from: classes5.dex */
public class b extends d<UserMuteListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<UserMuteListActivity> f62563a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f62564b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62565c;

    /* renamed from: d  reason: collision with root package name */
    public View f62566d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f62567e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f62568f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f62563a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f62563a.getLayoutMode().k(skinType == 1);
        this.f62563a.getLayoutMode().j(this.f62566d);
        this.f62565c.onChangeSkinType(this.f62563a.getPageContext(), skinType);
        this.f62568f.f(this.f62563a.getPageContext(), skinType);
        this.f62564b.c(this.f62563a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f62567e;
    }

    public void f() {
        this.f62567e.setVisibility(8);
        this.f62568f.setVisibility(0);
        this.f62568f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void g() {
        this.f62567e.setVisibility(8);
        this.f62568f.setVisibility(0);
        this.f62568f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f62563a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f62563a.findViewById(R.id.root_view);
        this.f62566d = findViewById;
        this.f62564b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f62566d.findViewById(R.id.view_navigation_bar);
        this.f62565c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62565c.setTitleText(R.string.user_mute_list_text);
        this.f62567e = (BdListView) this.f62566d.findViewById(R.id.mute_user_list);
        this.f62568f = NoDataViewFactory.a(this.f62563a.getPageContext().getContext(), this.f62566d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13040a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
