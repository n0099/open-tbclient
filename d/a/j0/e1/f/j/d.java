package d.a.j0.e1.f.j;

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
    public BaseActivity f53507a;

    /* renamed from: b  reason: collision with root package name */
    public View f53508b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f53509c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53510d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f53511e;

    /* renamed from: f  reason: collision with root package name */
    public View f53512f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f53513g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f53507a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f53513g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f53508b = View.inflate(this.f53507a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f53507a.getPageContext().getPageActivity().setContentView(this.f53508b);
        NavigationBar navigationBar = (NavigationBar) this.f53508b.findViewById(R.id.view_navigation_bar);
        this.f53510d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f53510d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53509c = (BdListView) this.f53508b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f53507a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f53511e = officialBarHistoryAdapter;
        this.f53509c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f53507a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f53512f = inflate;
        this.f53509c.addHeaderView(inflate);
        this.f53509c.addFooterView(this.f53512f);
    }

    public boolean f() {
        return this.f53511e.getCount() != 0 && this.f53509c.getLastVisiblePosition() - this.f53509c.getHeaderViewsCount() < this.f53511e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f53511e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f53509c.setOnSrollToBottomListener(pVar);
    }

    public void j(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f53513g == null) {
                this.f53513g = NoDataViewFactory.a(this.f53507a.getPageContext().getPageActivity(), this.f53508b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f53513g.f(this.f53507a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f53513g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f53507a.getLayoutMode().k(i2 == 1);
        this.f53507a.getLayoutMode().j(this.f53508b);
        this.f53510d.onChangeSkinType(this.f53507a.getPageContext(), i2);
    }
}
