package d.a.o0.g1.a.c;

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
    public IMBlackListActivity f58760a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f58761b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58762c;

    /* renamed from: d  reason: collision with root package name */
    public View f58763d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58764e;

    /* renamed from: f  reason: collision with root package name */
    public a f58765f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f58766g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f58767h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f58760a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f58760a.getLayoutMode().k(skinType == 1);
        this.f58760a.getLayoutMode().j(this.f58763d);
        this.f58762c.onChangeSkinType(this.f58760a.getPageContext(), skinType);
        this.f58766g.f(this.f58760a.getPageContext(), skinType);
        this.f58761b.c(this.f58760a.getPageContext(), skinType);
    }

    public void e() {
        this.f58767h.setVisibility(8);
    }

    public final void f() {
        this.f58760a.setContentView(R.layout.im_black_list);
        View findViewById = this.f58760a.findViewById(R.id.root_view);
        this.f58763d = findViewById;
        this.f58761b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f58763d.findViewById(R.id.view_navigation_bar);
        this.f58762c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58762c.setTitleText(R.string.chat_black_list_title);
        this.f58764e = (BdListView) this.f58763d.findViewById(R.id.black_list);
        this.f58766g = NoDataViewFactory.a(this.f58760a.getPageContext().getContext(), this.f58763d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13095a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f58767h = (ProgressBar) this.f58763d.findViewById(R.id.progress);
        a aVar = new a(this.f58760a);
        this.f58765f = aVar;
        this.f58764e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void h() {
        this.f58767h.setVisibility(0);
    }

    public void i() {
        if (this.f58765f.getCount() <= 0) {
            this.f58764e.setVisibility(8);
            this.f58766g.setVisibility(0);
            return;
        }
        this.f58764e.setVisibility(0);
        this.f58766g.setVisibility(8);
        this.f58765f.notifyDataSetChanged();
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f58764e.setVisibility(0);
            this.f58766g.setVisibility(8);
            this.f58765f.f(arrayList);
            this.f58765f.notifyDataSetChanged();
            return;
        }
        this.f58764e.setVisibility(8);
        this.f58766g.setVisibility(0);
    }

    public void l(BlackListItemData blackListItemData) {
        this.f58765f.e(blackListItemData);
        if (this.f58765f.getCount() <= 0) {
            this.f58764e.setVisibility(8);
            this.f58766g.setVisibility(0);
            return;
        }
        this.f58764e.setVisibility(0);
        this.f58766g.setVisibility(8);
        this.f58765f.notifyDataSetChanged();
    }
}
