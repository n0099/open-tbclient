package d.b.i0.f1.a.c;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends d.b.c.a.d<IMBlackListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f55753a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f55754b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f55755c;

    /* renamed from: d  reason: collision with root package name */
    public View f55756d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f55757e;

    /* renamed from: f  reason: collision with root package name */
    public a f55758f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55759g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f55760h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f55753a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f55753a.getLayoutMode().k(skinType == 1);
        this.f55753a.getLayoutMode().j(this.f55756d);
        this.f55755c.onChangeSkinType(this.f55753a.getPageContext(), skinType);
        this.f55759g.f(this.f55753a.getPageContext(), skinType);
        this.f55754b.c(this.f55753a.getPageContext(), skinType);
    }

    public void e() {
        this.f55760h.setVisibility(8);
    }

    public final void f() {
        this.f55753a.setContentView(R.layout.im_black_list);
        View findViewById = this.f55753a.findViewById(R.id.root_view);
        this.f55756d = findViewById;
        this.f55754b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f55756d.findViewById(R.id.view_navigation_bar);
        this.f55755c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55755c.setTitleText(R.string.chat_black_list_title);
        this.f55757e = (BdListView) this.f55756d.findViewById(R.id.black_list);
        this.f55759g = NoDataViewFactory.a(this.f55753a.getPageContext().getContext(), this.f55756d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13692a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f55760h = (ProgressBar) this.f55756d.findViewById(R.id.progress);
        a aVar = new a(this.f55753a);
        this.f55758f = aVar;
        this.f55757e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void h() {
        this.f55760h.setVisibility(0);
    }

    public void i() {
        if (this.f55758f.getCount() <= 0) {
            this.f55757e.setVisibility(8);
            this.f55759g.setVisibility(0);
            return;
        }
        this.f55757e.setVisibility(0);
        this.f55759g.setVisibility(8);
        this.f55758f.notifyDataSetChanged();
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f55757e.setVisibility(0);
            this.f55759g.setVisibility(8);
            this.f55758f.f(arrayList);
            this.f55758f.notifyDataSetChanged();
            return;
        }
        this.f55757e.setVisibility(8);
        this.f55759g.setVisibility(0);
    }

    public void l(BlackListItemData blackListItemData) {
        this.f55758f.e(blackListItemData);
        if (this.f55758f.getCount() <= 0) {
            this.f55757e.setVisibility(8);
            this.f55759g.setVisibility(0);
            return;
        }
        this.f55757e.setVisibility(0);
        this.f55759g.setVisibility(8);
        this.f55758f.notifyDataSetChanged();
    }
}
