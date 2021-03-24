package d.b.i0.e1.a.c;

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
public class b extends d.b.b.a.d<IMBlackListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f54311a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f54312b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54313c;

    /* renamed from: d  reason: collision with root package name */
    public View f54314d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54315e;

    /* renamed from: f  reason: collision with root package name */
    public a f54316f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54317g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f54318h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f54311a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f54311a.getLayoutMode().k(skinType == 1);
        this.f54311a.getLayoutMode().j(this.f54314d);
        this.f54313c.onChangeSkinType(this.f54311a.getPageContext(), skinType);
        this.f54317g.f(this.f54311a.getPageContext(), skinType);
        this.f54312b.c(this.f54311a.getPageContext(), skinType);
    }

    public void e() {
        this.f54318h.setVisibility(8);
    }

    public final void f() {
        this.f54311a.setContentView(R.layout.im_black_list);
        View findViewById = this.f54311a.findViewById(R.id.root_view);
        this.f54314d = findViewById;
        this.f54312b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f54314d.findViewById(R.id.view_navigation_bar);
        this.f54313c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54313c.setTitleText(R.string.chat_black_list_title);
        this.f54315e = (BdListView) this.f54314d.findViewById(R.id.black_list);
        this.f54317g = NoDataViewFactory.a(this.f54311a.getPageContext().getContext(), this.f54314d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f14030a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f54318h = (ProgressBar) this.f54314d.findViewById(R.id.progress);
        a aVar = new a(this.f54311a);
        this.f54316f = aVar;
        this.f54315e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void h() {
        this.f54318h.setVisibility(0);
    }

    public void i() {
        if (this.f54316f.getCount() <= 0) {
            this.f54315e.setVisibility(8);
            this.f54317g.setVisibility(0);
            return;
        }
        this.f54315e.setVisibility(0);
        this.f54317g.setVisibility(8);
        this.f54316f.notifyDataSetChanged();
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f54315e.setVisibility(0);
            this.f54317g.setVisibility(8);
            this.f54316f.f(arrayList);
            this.f54316f.notifyDataSetChanged();
            return;
        }
        this.f54315e.setVisibility(8);
        this.f54317g.setVisibility(0);
    }

    public void l(BlackListItemData blackListItemData) {
        this.f54316f.e(blackListItemData);
        if (this.f54316f.getCount() <= 0) {
            this.f54315e.setVisibility(8);
            this.f54317g.setVisibility(0);
            return;
        }
        this.f54315e.setVisibility(0);
        this.f54317g.setVisibility(8);
        this.f54316f.notifyDataSetChanged();
    }
}
