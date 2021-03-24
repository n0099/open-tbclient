package d.b.i0.d1.f.j;

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
public class d extends d.b.b.a.d<OfficialBarHistoryActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f53711a;

    /* renamed from: b  reason: collision with root package name */
    public View f53712b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f53713c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53714d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f53715e;

    /* renamed from: f  reason: collision with root package name */
    public View f53716f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f53717g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f53711a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f53717g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f53712b = View.inflate(this.f53711a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f53711a.getPageContext().getPageActivity().setContentView(this.f53712b);
        NavigationBar navigationBar = (NavigationBar) this.f53712b.findViewById(R.id.view_navigation_bar);
        this.f53714d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f53714d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53713c = (BdListView) this.f53712b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f53711a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f53715e = officialBarHistoryAdapter;
        this.f53713c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f53711a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f53716f = inflate;
        this.f53713c.addHeaderView(inflate);
        this.f53713c.addFooterView(this.f53716f);
    }

    public boolean f() {
        return this.f53715e.getCount() != 0 && this.f53713c.getLastVisiblePosition() - this.f53713c.getHeaderViewsCount() < this.f53715e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f53715e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f53713c.setOnSrollToBottomListener(pVar);
    }

    public void i(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f53717g == null) {
                this.f53717g = NoDataViewFactory.a(this.f53711a.getPageContext().getPageActivity(), this.f53712b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f53717g.f(this.f53711a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f53717g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        this.f53711a.getLayoutMode().k(i == 1);
        this.f53711a.getLayoutMode().j(this.f53712b);
        this.f53714d.onChangeSkinType(this.f53711a.getPageContext(), i);
    }
}
