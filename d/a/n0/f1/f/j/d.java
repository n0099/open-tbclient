package d.a.n0.f1.f.j;

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
    public BaseActivity f54404a;

    /* renamed from: b  reason: collision with root package name */
    public View f54405b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f54406c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54407d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f54408e;

    /* renamed from: f  reason: collision with root package name */
    public View f54409f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f54410g;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f54404a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        if (list == null || list.size() <= 0 || (noDataView = this.f54410g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        this.f54405b = View.inflate(this.f54404a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.f54404a.getPageContext().getPageActivity().setContentView(this.f54405b);
        NavigationBar navigationBar = (NavigationBar) this.f54405b.findViewById(R.id.view_navigation_bar);
        this.f54407d = navigationBar;
        navigationBar.setTitleText(R.string.officical_bar_info_history);
        this.f54407d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54406c = (BdListView) this.f54405b.findViewById(R.id.bar_history_list);
        BaseActivity baseActivity = this.f54404a;
        OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
        this.f54408e = officialBarHistoryAdapter;
        this.f54406c.setAdapter((ListAdapter) officialBarHistoryAdapter);
        View inflate = View.inflate(this.f54404a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.f54409f = inflate;
        this.f54406c.addHeaderView(inflate);
        this.f54406c.addFooterView(this.f54409f);
    }

    public boolean f() {
        return this.f54408e.getCount() != 0 && this.f54406c.getLastVisiblePosition() - this.f54406c.getHeaderViewsCount() < this.f54408e.getCount() - 1;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        this.f54408e.c(list);
        d(list);
    }

    public void h(BdListView.p pVar) {
        this.f54406c.setOnSrollToBottomListener(pVar);
    }

    public void j(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.f54410g == null) {
                this.f54410g = NoDataViewFactory.a(this.f54404a.getPageContext().getPageActivity(), this.f54405b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
            }
            this.f54410g.f(this.f54404a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f54410g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f54404a.getLayoutMode().k(i2 == 1);
        this.f54404a.getLayoutMode().j(this.f54405b);
        this.f54407d.onChangeSkinType(this.f54404a.getPageContext(), i2);
    }
}
