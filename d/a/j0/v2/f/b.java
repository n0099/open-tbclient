package d.a.j0.v2.f;

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
    public BaseActivity<UserMuteListActivity> f61839a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f61840b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61841c;

    /* renamed from: d  reason: collision with root package name */
    public View f61842d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61843e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f61844f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f61839a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f61839a.getLayoutMode().k(skinType == 1);
        this.f61839a.getLayoutMode().j(this.f61842d);
        this.f61841c.onChangeSkinType(this.f61839a.getPageContext(), skinType);
        this.f61844f.f(this.f61839a.getPageContext(), skinType);
        this.f61840b.c(this.f61839a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f61843e;
    }

    public void f() {
        this.f61843e.setVisibility(8);
        this.f61844f.setVisibility(0);
        this.f61844f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void g() {
        this.f61843e.setVisibility(8);
        this.f61844f.setVisibility(0);
        this.f61844f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f61839a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f61839a.findViewById(R.id.root_view);
        this.f61842d = findViewById;
        this.f61840b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f61842d.findViewById(R.id.view_navigation_bar);
        this.f61841c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61841c.setTitleText(R.string.user_mute_list_text);
        this.f61843e = (BdListView) this.f61842d.findViewById(R.id.mute_user_list);
        this.f61844f = NoDataViewFactory.a(this.f61839a.getPageContext().getContext(), this.f61842d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13704a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
