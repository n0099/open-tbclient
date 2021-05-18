package d.a.k0.f1.a.c;

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
public class b extends d.a.c.a.d<IMBlackListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f54758a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f54759b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54760c;

    /* renamed from: d  reason: collision with root package name */
    public View f54761d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54762e;

    /* renamed from: f  reason: collision with root package name */
    public a f54763f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54764g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f54765h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f54758a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f54758a.getLayoutMode().k(skinType == 1);
        this.f54758a.getLayoutMode().j(this.f54761d);
        this.f54760c.onChangeSkinType(this.f54758a.getPageContext(), skinType);
        this.f54764g.f(this.f54758a.getPageContext(), skinType);
        this.f54759b.c(this.f54758a.getPageContext(), skinType);
    }

    public void e() {
        this.f54765h.setVisibility(8);
    }

    public final void f() {
        this.f54758a.setContentView(R.layout.im_black_list);
        View findViewById = this.f54758a.findViewById(R.id.root_view);
        this.f54761d = findViewById;
        this.f54759b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f54761d.findViewById(R.id.view_navigation_bar);
        this.f54760c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54760c.setTitleText(R.string.chat_black_list_title);
        this.f54762e = (BdListView) this.f54761d.findViewById(R.id.black_list);
        this.f54764g = NoDataViewFactory.a(this.f54758a.getPageContext().getContext(), this.f54761d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13040a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f54765h = (ProgressBar) this.f54761d.findViewById(R.id.progress);
        a aVar = new a(this.f54758a);
        this.f54763f = aVar;
        this.f54762e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void g() {
        this.f54765h.setVisibility(0);
    }

    public void h() {
        if (this.f54763f.getCount() <= 0) {
            this.f54762e.setVisibility(8);
            this.f54764g.setVisibility(0);
            return;
        }
        this.f54762e.setVisibility(0);
        this.f54764g.setVisibility(8);
        this.f54763f.notifyDataSetChanged();
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f54762e.setVisibility(0);
            this.f54764g.setVisibility(8);
            this.f54763f.f(arrayList);
            this.f54763f.notifyDataSetChanged();
            return;
        }
        this.f54762e.setVisibility(8);
        this.f54764g.setVisibility(0);
    }

    public void k(BlackListItemData blackListItemData) {
        this.f54763f.e(blackListItemData);
        if (this.f54763f.getCount() <= 0) {
            this.f54762e.setVisibility(8);
            this.f54764g.setVisibility(0);
            return;
        }
        this.f54762e.setVisibility(0);
        this.f54764g.setVisibility(8);
        this.f54763f.notifyDataSetChanged();
    }
}
