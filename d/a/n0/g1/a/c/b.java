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
    public IMBlackListActivity f58635a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f58636b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58637c;

    /* renamed from: d  reason: collision with root package name */
    public View f58638d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58639e;

    /* renamed from: f  reason: collision with root package name */
    public a f58640f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f58641g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f58642h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f58635a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f58635a.getLayoutMode().k(skinType == 1);
        this.f58635a.getLayoutMode().j(this.f58638d);
        this.f58637c.onChangeSkinType(this.f58635a.getPageContext(), skinType);
        this.f58641g.f(this.f58635a.getPageContext(), skinType);
        this.f58636b.c(this.f58635a.getPageContext(), skinType);
    }

    public void e() {
        this.f58642h.setVisibility(8);
    }

    public final void f() {
        this.f58635a.setContentView(R.layout.im_black_list);
        View findViewById = this.f58635a.findViewById(R.id.root_view);
        this.f58638d = findViewById;
        this.f58636b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f58638d.findViewById(R.id.view_navigation_bar);
        this.f58637c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58637c.setTitleText(R.string.chat_black_list_title);
        this.f58639e = (BdListView) this.f58638d.findViewById(R.id.black_list);
        this.f58641g = NoDataViewFactory.a(this.f58635a.getPageContext().getContext(), this.f58638d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13013a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f58642h = (ProgressBar) this.f58638d.findViewById(R.id.progress);
        a aVar = new a(this.f58635a);
        this.f58640f = aVar;
        this.f58639e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void h() {
        this.f58642h.setVisibility(0);
    }

    public void i() {
        if (this.f58640f.getCount() <= 0) {
            this.f58639e.setVisibility(8);
            this.f58641g.setVisibility(0);
            return;
        }
        this.f58639e.setVisibility(0);
        this.f58641g.setVisibility(8);
        this.f58640f.notifyDataSetChanged();
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f58639e.setVisibility(0);
            this.f58641g.setVisibility(8);
            this.f58640f.f(arrayList);
            this.f58640f.notifyDataSetChanged();
            return;
        }
        this.f58639e.setVisibility(8);
        this.f58641g.setVisibility(0);
    }

    public void l(BlackListItemData blackListItemData) {
        this.f58640f.e(blackListItemData);
        if (this.f58640f.getCount() <= 0) {
            this.f58639e.setVisibility(8);
            this.f58641g.setVisibility(0);
            return;
        }
        this.f58639e.setVisibility(0);
        this.f58641g.setVisibility(8);
        this.f58640f.notifyDataSetChanged();
    }
}
