package d.b.j0.e1.f.j;

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
    public BaseActivity f55655a;

    /* renamed from: b  reason: collision with root package name */
    public View f55656b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f55657c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f55658d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f55659e;

    /* renamed from: f  reason: collision with root package name */
    public View f55660f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55661g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f55655a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f55661g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f55656b = View.inflate(this.f55655a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f55655a.getPageContext().getPageActivity().setContentView(this.f55656b);
        NavigationBar navigationBar = (NavigationBar) this.f55656b.findViewById(R.id.view_navigation_bar);
        this.f55658d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f55658d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55657c = (BdListView) this.f55656b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f55655a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f55659e = officialBarHistoryAdapter;
        this.f55657c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f55655a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f55660f = inflate;
        this.f55657c.addHeaderView(inflate);
        this.f55657c.addFooterView(this.f55660f);
    }

    public boolean f() {
        return this.f55659e.getCount() != 0 && this.f55657c.getLastVisiblePosition() - this.f55657c.getHeaderViewsCount() < this.f55659e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f55659e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f55657c.setOnSrollToBottomListener(pVar);
    }

    public void i(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f55661g == null) {
                this.f55661g = NoDataViewFactory.a(this.f55655a.getPageContext().getPageActivity(), this.f55656b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f55661g.f(this.f55655a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f55661g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        this.f55655a.getLayoutMode().k(i == 1);
        this.f55655a.getLayoutMode().j(this.f55656b);
        this.f55658d.onChangeSkinType(this.f55655a.getPageContext(), i);
    }
}
