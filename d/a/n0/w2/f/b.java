package d.a.n0.w2.f;

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
    public BaseActivity<UserMuteListActivity> f62670a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f62671b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62672c;

    /* renamed from: d  reason: collision with root package name */
    public View f62673d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f62674e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f62675f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f62670a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f62670a.getLayoutMode().k(skinType == 1);
        this.f62670a.getLayoutMode().j(this.f62673d);
        this.f62672c.onChangeSkinType(this.f62670a.getPageContext(), skinType);
        this.f62675f.f(this.f62670a.getPageContext(), skinType);
        this.f62671b.c(this.f62670a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f62674e;
    }

    public void f() {
        this.f62674e.setVisibility(8);
        this.f62675f.setVisibility(0);
        this.f62675f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void g() {
        this.f62674e.setVisibility(8);
        this.f62675f.setVisibility(0);
        this.f62675f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f62670a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f62670a.findViewById(R.id.root_view);
        this.f62673d = findViewById;
        this.f62671b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f62673d.findViewById(R.id.view_navigation_bar);
        this.f62672c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62672c.setTitleText(R.string.user_mute_list_text);
        this.f62674e = (BdListView) this.f62673d.findViewById(R.id.mute_user_list);
        this.f62675f = NoDataViewFactory.a(this.f62670a.getPageContext().getContext(), this.f62673d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f12948a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
