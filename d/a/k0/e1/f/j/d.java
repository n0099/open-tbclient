package d.a.k0.e1.f.j;

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
    public BaseActivity f54214a;

    /* renamed from: b  reason: collision with root package name */
    public View f54215b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f54216c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54217d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f54218e;

    /* renamed from: f  reason: collision with root package name */
    public View f54219f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54220g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f54214a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f54220g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f54215b = View.inflate(this.f54214a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f54214a.getPageContext().getPageActivity().setContentView(this.f54215b);
        NavigationBar navigationBar = (NavigationBar) this.f54215b.findViewById(R.id.view_navigation_bar);
        this.f54217d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f54217d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54216c = (BdListView) this.f54215b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f54214a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f54218e = officialBarHistoryAdapter;
        this.f54216c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f54214a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f54219f = inflate;
        this.f54216c.addHeaderView(inflate);
        this.f54216c.addFooterView(this.f54219f);
    }

    public boolean f() {
        return this.f54218e.getCount() != 0 && this.f54216c.getLastVisiblePosition() - this.f54216c.getHeaderViewsCount() < this.f54218e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f54218e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f54216c.setOnSrollToBottomListener(pVar);
    }

    public void j(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f54220g == null) {
                this.f54220g = NoDataViewFactory.a(this.f54214a.getPageContext().getPageActivity(), this.f54215b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f54220g.f(this.f54214a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f54220g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f54214a.getLayoutMode().k(i2 == 1);
        this.f54214a.getLayoutMode().j(this.f54215b);
        this.f54217d.onChangeSkinType(this.f54214a.getPageContext(), i2);
    }
}
