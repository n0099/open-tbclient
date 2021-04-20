package d.b.i0.v2.f;

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
    public BaseActivity<UserMuteListActivity> f63171a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f63172b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63173c;

    /* renamed from: d  reason: collision with root package name */
    public View f63174d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f63175e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f63176f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f63171a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f63171a.getLayoutMode().k(skinType == 1);
        this.f63171a.getLayoutMode().j(this.f63174d);
        this.f63173c.onChangeSkinType(this.f63171a.getPageContext(), skinType);
        this.f63176f.f(this.f63171a.getPageContext(), skinType);
        this.f63172b.c(this.f63171a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f63175e;
    }

    public void f() {
        this.f63175e.setVisibility(8);
        this.f63176f.setVisibility(0);
        this.f63176f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void h() {
        this.f63175e.setVisibility(8);
        this.f63176f.setVisibility(0);
        this.f63176f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f63171a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f63171a.findViewById(R.id.root_view);
        this.f63174d = findViewById;
        this.f63172b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f63174d.findViewById(R.id.view_navigation_bar);
        this.f63173c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63173c.setTitleText(R.string.user_mute_list_text);
        this.f63175e = (BdListView) this.f63174d.findViewById(R.id.mute_user_list);
        this.f63176f = NoDataViewFactory.a(this.f63171a.getPageContext().getContext(), this.f63174d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13692a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
