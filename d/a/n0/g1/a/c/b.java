package d.a.n0.g1.a.c;

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
    public IMBlackListActivity f54946a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f54947b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54948c;

    /* renamed from: d  reason: collision with root package name */
    public View f54949d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54950e;

    /* renamed from: f  reason: collision with root package name */
    public a f54951f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54952g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f54953h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f54946a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f54946a.getLayoutMode().k(skinType == 1);
        this.f54946a.getLayoutMode().j(this.f54949d);
        this.f54948c.onChangeSkinType(this.f54946a.getPageContext(), skinType);
        this.f54952g.f(this.f54946a.getPageContext(), skinType);
        this.f54947b.c(this.f54946a.getPageContext(), skinType);
    }

    public void e() {
        this.f54953h.setVisibility(8);
    }

    public final void f() {
        this.f54946a.setContentView(R.layout.im_black_list);
        View findViewById = this.f54946a.findViewById(R.id.root_view);
        this.f54949d = findViewById;
        this.f54947b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f54949d.findViewById(R.id.view_navigation_bar);
        this.f54948c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54948c.setTitleText(R.string.chat_black_list_title);
        this.f54950e = (BdListView) this.f54949d.findViewById(R.id.black_list);
        this.f54952g = NoDataViewFactory.a(this.f54946a.getPageContext().getContext(), this.f54949d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f12948a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f54953h = (ProgressBar) this.f54949d.findViewById(R.id.progress);
        a aVar = new a(this.f54946a);
        this.f54951f = aVar;
        this.f54950e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void g() {
        this.f54953h.setVisibility(0);
    }

    public void h() {
        if (this.f54951f.getCount() <= 0) {
            this.f54950e.setVisibility(8);
            this.f54952g.setVisibility(0);
            return;
        }
        this.f54950e.setVisibility(0);
        this.f54952g.setVisibility(8);
        this.f54951f.notifyDataSetChanged();
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f54950e.setVisibility(0);
            this.f54952g.setVisibility(8);
            this.f54951f.f(arrayList);
            this.f54951f.notifyDataSetChanged();
            return;
        }
        this.f54950e.setVisibility(8);
        this.f54952g.setVisibility(0);
    }

    public void k(BlackListItemData blackListItemData) {
        this.f54951f.e(blackListItemData);
        if (this.f54951f.getCount() <= 0) {
            this.f54950e.setVisibility(8);
            this.f54952g.setVisibility(0);
            return;
        }
        this.f54950e.setVisibility(0);
        this.f54952g.setVisibility(8);
        this.f54951f.notifyDataSetChanged();
    }
}
