package d.b.j0.v2.f;

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
import d.b.c.a.d;
/* loaded from: classes4.dex */
public class b extends d<UserMuteListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<UserMuteListActivity> f63592a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f63593b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63594c;

    /* renamed from: d  reason: collision with root package name */
    public View f63595d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f63596e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f63597f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f63592a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f63592a.getLayoutMode().k(skinType == 1);
        this.f63592a.getLayoutMode().j(this.f63595d);
        this.f63594c.onChangeSkinType(this.f63592a.getPageContext(), skinType);
        this.f63597f.f(this.f63592a.getPageContext(), skinType);
        this.f63593b.c(this.f63592a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f63596e;
    }

    public void f() {
        this.f63596e.setVisibility(8);
        this.f63597f.setVisibility(0);
        this.f63597f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void h() {
        this.f63596e.setVisibility(8);
        this.f63597f.setVisibility(0);
        this.f63597f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f63592a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f63592a.findViewById(R.id.root_view);
        this.f63595d = findViewById;
        this.f63593b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f63595d.findViewById(R.id.view_navigation_bar);
        this.f63594c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63594c.setTitleText(R.string.user_mute_list_text);
        this.f63596e = (BdListView) this.f63595d.findViewById(R.id.mute_user_list);
        this.f63597f = NoDataViewFactory.a(this.f63592a.getPageContext().getContext(), this.f63595d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13700a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
