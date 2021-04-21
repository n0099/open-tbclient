package d.b.j0.f1.a.c;

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
    public IMBlackListActivity f56174a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f56175b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56176c;

    /* renamed from: d  reason: collision with root package name */
    public View f56177d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56178e;

    /* renamed from: f  reason: collision with root package name */
    public a f56179f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f56180g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f56181h;

    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.f56174a = iMBlackListActivity;
        f();
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f56174a.getLayoutMode().k(skinType == 1);
        this.f56174a.getLayoutMode().j(this.f56177d);
        this.f56176c.onChangeSkinType(this.f56174a.getPageContext(), skinType);
        this.f56180g.f(this.f56174a.getPageContext(), skinType);
        this.f56175b.c(this.f56174a.getPageContext(), skinType);
    }

    public void e() {
        this.f56181h.setVisibility(8);
    }

    public final void f() {
        this.f56174a.setContentView(R.layout.im_black_list);
        View findViewById = this.f56174a.findViewById(R.id.root_view);
        this.f56177d = findViewById;
        this.f56175b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) this.f56177d.findViewById(R.id.view_navigation_bar);
        this.f56176c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56176c.setTitleText(R.string.chat_black_list_title);
        this.f56178e = (BdListView) this.f56177d.findViewById(R.id.black_list);
        this.f56180g = NoDataViewFactory.a(this.f56174a.getPageContext().getContext(), this.f56177d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13700a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
        this.f56181h = (ProgressBar) this.f56177d.findViewById(R.id.progress);
        a aVar = new a(this.f56174a);
        this.f56179f = aVar;
        this.f56178e.setAdapter((ListAdapter) aVar);
        d();
    }

    public void h() {
        this.f56181h.setVisibility(0);
    }

    public void i() {
        if (this.f56179f.getCount() <= 0) {
            this.f56178e.setVisibility(8);
            this.f56180g.setVisibility(0);
            return;
        }
        this.f56178e.setVisibility(0);
        this.f56180g.setVisibility(8);
        this.f56179f.notifyDataSetChanged();
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f56178e.setVisibility(0);
            this.f56180g.setVisibility(8);
            this.f56179f.f(arrayList);
            this.f56179f.notifyDataSetChanged();
            return;
        }
        this.f56178e.setVisibility(8);
        this.f56180g.setVisibility(0);
    }

    public void l(BlackListItemData blackListItemData) {
        this.f56179f.e(blackListItemData);
        if (this.f56179f.getCount() <= 0) {
            this.f56178e.setVisibility(8);
            this.f56180g.setVisibility(0);
            return;
        }
        this.f56178e.setVisibility(0);
        this.f56180g.setVisibility(8);
        this.f56179f.notifyDataSetChanged();
    }
}
