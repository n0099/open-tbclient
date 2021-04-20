package d.b.i0.e1.f.j;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.c.a.d<OfficialBarHistoryActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f55234a;

    /* renamed from: b  reason: collision with root package name */
    public View f55235b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f55236c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f55237d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f55238e;

    /* renamed from: f  reason: collision with root package name */
    public View f55239f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55240g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f55234a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f55240g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f55235b = View.inflate(this.f55234a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f55234a.getPageContext().getPageActivity().setContentView(this.f55235b);
        NavigationBar navigationBar = (NavigationBar) this.f55235b.findViewById(R.id.view_navigation_bar);
        this.f55237d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f55237d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55236c = (BdListView) this.f55235b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f55234a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f55238e = officialBarHistoryAdapter;
        this.f55236c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f55234a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f55239f = inflate;
        this.f55236c.addHeaderView(inflate);
        this.f55236c.addFooterView(this.f55239f);
    }

    public boolean f() {
        return this.f55238e.getCount() != 0 && this.f55236c.getLastVisiblePosition() - this.f55236c.getHeaderViewsCount() < this.f55238e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f55238e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f55236c.setOnSrollToBottomListener(pVar);
    }

    public void i(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f55240g == null) {
                this.f55240g = NoDataViewFactory.a(this.f55234a.getPageContext().getPageActivity(), this.f55235b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f55240g.f(this.f55234a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f55240g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        this.f55234a.getLayoutMode().k(i == 1);
        this.f55234a.getLayoutMode().j(this.f55235b);
        this.f55237d.onChangeSkinType(this.f55234a.getPageContext(), i);
    }
}
