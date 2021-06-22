package d.a.o0.f1.f.j;

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
public class d extends d.a.c.a.d<OfficialBarHistoryActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58218a;

    /* renamed from: b  reason: collision with root package name */
    public View f58219b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f58220c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58221d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f58222e;

    /* renamed from: f  reason: collision with root package name */
    public View f58223f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f58224g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f58218a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f58224g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f58219b = View.inflate(this.f58218a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f58218a.getPageContext().getPageActivity().setContentView(this.f58219b);
        NavigationBar navigationBar = (NavigationBar) this.f58219b.findViewById(R.id.view_navigation_bar);
        this.f58221d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f58221d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58220c = (BdListView) this.f58219b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f58218a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f58222e = officialBarHistoryAdapter;
        this.f58220c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f58218a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f58223f = inflate;
        this.f58220c.addHeaderView(inflate);
        this.f58220c.addFooterView(this.f58223f);
    }

    public boolean f() {
        return this.f58222e.getCount() != 0 && this.f58220c.getLastVisiblePosition() - this.f58220c.getHeaderViewsCount() < this.f58222e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f58222e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f58220c.setOnSrollToBottomListener(pVar);
    }

    public void i(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f58224g == null) {
                this.f58224g = NoDataViewFactory.a(this.f58218a.getPageContext().getPageActivity(), this.f58219b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f58224g.f(this.f58218a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f58224g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f58218a.getLayoutMode().k(i2 == 1);
        this.f58218a.getLayoutMode().j(this.f58219b);
        this.f58221d.onChangeSkinType(this.f58218a.getPageContext(), i2);
    }
}
