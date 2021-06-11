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
    public BaseActivity<UserMuteListActivity> f66385a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f66386b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66387c;

    /* renamed from: d  reason: collision with root package name */
    public View f66388d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f66389e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f66390f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f66385a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f66385a.getLayoutMode().k(skinType == 1);
        this.f66385a.getLayoutMode().j(this.f66388d);
        this.f66387c.onChangeSkinType(this.f66385a.getPageContext(), skinType);
        this.f66390f.f(this.f66385a.getPageContext(), skinType);
        this.f66386b.c(this.f66385a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f66389e;
    }

    public void f() {
        this.f66389e.setVisibility(8);
        this.f66390f.setVisibility(0);
        this.f66390f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void h() {
        this.f66389e.setVisibility(8);
        this.f66390f.setVisibility(0);
        this.f66390f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f66385a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f66385a.findViewById(R.id.root_view);
        this.f66388d = findViewById;
        this.f66386b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f66388d.findViewById(R.id.view_navigation_bar);
        this.f66387c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66387c.setTitleText(R.string.user_mute_list_text);
        this.f66389e = (BdListView) this.f66388d.findViewById(R.id.mute_user_list);
        this.f66390f = NoDataViewFactory.a(this.f66385a.getPageContext().getContext(), this.f66388d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13013a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
