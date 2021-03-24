package d.b.i0.u2.f;

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
import d.b.b.a.d;
/* loaded from: classes5.dex */
public class b extends d<UserMuteListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<UserMuteListActivity> f61432a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f61433b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61434c;

    /* renamed from: d  reason: collision with root package name */
    public View f61435d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61436e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f61437f;

    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.f61432a = baseActivity;
        initUI();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f61432a.getLayoutMode().k(skinType == 1);
        this.f61432a.getLayoutMode().j(this.f61435d);
        this.f61434c.onChangeSkinType(this.f61432a.getPageContext(), skinType);
        this.f61437f.f(this.f61432a.getPageContext(), skinType);
        this.f61433b.c(this.f61432a.getPageContext(), skinType);
    }

    public BdListView e() {
        return this.f61436e;
    }

    public void f() {
        this.f61436e.setVisibility(8);
        this.f61437f.setVisibility(0);
        this.f61437f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
    }

    public void h() {
        this.f61436e.setVisibility(8);
        this.f61437f.setVisibility(0);
        this.f61437f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
    }

    public final void initUI() {
        this.f61432a.setContentView(R.layout.user_mute_list_activity);
        View findViewById = this.f61432a.findViewById(R.id.root_view);
        this.f61435d = findViewById;
        this.f61433b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f61435d.findViewById(R.id.view_navigation_bar);
        this.f61434c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61434c.setTitleText(R.string.user_mute_list_text);
        this.f61436e = (BdListView) this.f61435d.findViewById(R.id.mute_user_list);
        this.f61437f = NoDataViewFactory.a(this.f61432a.getPageContext().getContext(), this.f61435d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f14030a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
        d();
    }
}
