package d.a.j0.f1.a.c;

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
    public IMBlackListActivity f54051a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f54052b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54053c;

    /* renamed from: d  reason: collision with root package name */
    public View f54054d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54055e;

    /* renamed from: f  reason: collision with root package name */
    public a f54056f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54057g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f54058h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f54051a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f54051a.getLayoutMode().k(skinType == 1);
        this.f54051a.getLayoutMode().j(this.f54054d);
        this.f54053c.onChangeSkinType(this.f54051a.getPageContext(), skinType);
        this.f54057g.f(this.f54051a.getPageContext(), skinType);
        this.f54052b.c(this.f54051a.getPageContext(), skinType);
    }

    public void e() {
        this.f54058h.setVisibility(8);
    }

    public final void f() {
        this.f54051a.setContentView(R.layout.im_black_list);
        View findViewById = this.f54051a.findViewById(R.id.root_view);
        this.f54054d = findViewById;
        this.f54052b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f54054d.findViewById(R.id.view_navigation_bar);
        this.f54053c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54053c.setTitleText(R.string.chat_black_list_title);
        this.f54055e = (BdListView) this.f54054d.findViewById(R.id.black_list);
        this.f54057g = NoDataViewFactory.a(this.f54051a.getPageContext().getContext(), this.f54054d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13704a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f54058h = (ProgressBar) this.f54054d.findViewById(R.id.progress);
        a aVar = new a(this.f54051a);
        this.f54056f = aVar;
        this.f54055e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void g() {
        this.f54058h.setVisibility(0);
    }

    public void h() {
        if (this.f54056f.getCount() <= 0) {
            this.f54055e.setVisibility(8);
            this.f54057g.setVisibility(0);
            return;
        }
        this.f54055e.setVisibility(0);
        this.f54057g.setVisibility(8);
        this.f54056f.notifyDataSetChanged();
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f54055e.setVisibility(0);
            this.f54057g.setVisibility(8);
            this.f54056f.f(arrayList);
            this.f54056f.notifyDataSetChanged();
            return;
        }
        this.f54055e.setVisibility(8);
        this.f54057g.setVisibility(0);
    }

    public void k(BlackListItemData blackListItemData) {
        this.f54056f.e(blackListItemData);
        if (this.f54056f.getCount() <= 0) {
            this.f54055e.setVisibility(8);
            this.f54057g.setVisibility(0);
            return;
        }
        this.f54055e.setVisibility(0);
        this.f54057g.setVisibility(8);
        this.f54056f.notifyDataSetChanged();
    }
}
