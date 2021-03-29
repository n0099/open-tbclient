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
/* loaded from: classes3.dex */
public class b extends d.b.b.a.d<IMBlackListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f54312a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f54313b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54314c;

    /* renamed from: d  reason: collision with root package name */
    public View f54315d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54316e;

    /* renamed from: f  reason: collision with root package name */
    public a f54317f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54318g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f54319h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f54312a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f54312a.getLayoutMode().k(skinType == 1);
        this.f54312a.getLayoutMode().j(this.f54315d);
        this.f54314c.onChangeSkinType(this.f54312a.getPageContext(), skinType);
        this.f54318g.f(this.f54312a.getPageContext(), skinType);
        this.f54313b.c(this.f54312a.getPageContext(), skinType);
    }

    public void e() {
        this.f54319h.setVisibility(8);
    }

    public final void f() {
        this.f54312a.setContentView(R.layout.im_black_list);
        View findViewById = this.f54312a.findViewById(R.id.root_view);
        this.f54315d = findViewById;
        this.f54313b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f54315d.findViewById(R.id.view_navigation_bar);
        this.f54314c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54314c.setTitleText(R.string.chat_black_list_title);
        this.f54316e = (BdListView) this.f54315d.findViewById(R.id.black_list);
        this.f54318g = NoDataViewFactory.a(this.f54312a.getPageContext().getContext(), this.f54315d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f14031a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f54319h = (ProgressBar) this.f54315d.findViewById(R.id.progress);
        a aVar = new a(this.f54312a);
        this.f54317f = aVar;
        this.f54316e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void h() {
        this.f54319h.setVisibility(0);
    }

    public void i() {
        if (this.f54317f.getCount() <= 0) {
            this.f54316e.setVisibility(8);
            this.f54318g.setVisibility(0);
            return;
        }
        this.f54316e.setVisibility(0);
        this.f54318g.setVisibility(8);
        this.f54317f.notifyDataSetChanged();
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f54316e.setVisibility(0);
            this.f54318g.setVisibility(8);
            this.f54317f.f(arrayList);
            this.f54317f.notifyDataSetChanged();
            return;
        }
        this.f54316e.setVisibility(8);
        this.f54318g.setVisibility(0);
    }

    public void l(BlackListItemData blackListItemData) {
        this.f54317f.e(blackListItemData);
        if (this.f54317f.getCount() <= 0) {
            this.f54316e.setVisibility(8);
            this.f54318g.setVisibility(0);
            return;
        }
        this.f54316e.setVisibility(0);
        this.f54318g.setVisibility(8);
        this.f54317f.notifyDataSetChanged();
    }
}
