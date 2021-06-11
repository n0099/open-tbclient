package d.a.n0.f2.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.praise.PraiseListActivity;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.a.c.a.d<PraiseListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public c f58545a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f58546b;

    /* renamed from: c  reason: collision with root package name */
    public View f58547c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58548d;

    /* renamed from: e  reason: collision with root package name */
    public View f58549e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f58550f;

    /* renamed from: g  reason: collision with root package name */
    public View f58551g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58552h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f58553i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.f58545a = null;
        this.f58546b = null;
        this.f58547c = null;
        this.f58548d = null;
        this.f58549e = null;
        this.f58550f = null;
        this.f58551g = null;
        this.f58552h = null;
        this.f58553i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f58546b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f58547c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f58548d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f58549e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f58550f = NoDataViewFactory.a(this.f58546b.getPageContext().getContext(), this.f58547c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58546b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f58553i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f58546b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f58553i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f58545a = cVar;
        this.f58553i.setAdapter((ListAdapter) cVar);
        this.f58553i.setOnScrollListener(this.f58545a);
        this.f58548d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58548d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f58551g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f58551g.findViewById(R.id.zan_list_head_text);
        this.f58552h = textView2;
        textView2.setText(str);
        this.f58551g.setVisibility(8);
        this.f58553i.addHeaderView(this.f58551g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f58553i.addFooterView(this.j);
        this.f58553i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.a.m0.r.c cVar, int i2) {
        if (cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f58547c);
        cVar.j(this.f58551g);
        cVar.j(this.j);
        this.f58548d.onChangeSkinType(this.f58546b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f58550f;
        if (noDataView != null) {
            noDataView.f(this.f58546b.getPageContext(), i2);
        }
    }

    public View e() {
        return this.k;
    }

    public View f() {
        return this.f58551g;
    }

    public boolean h() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void i() {
        c cVar = this.f58545a;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void k(String str, int i2) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f58549e.setVisibility(8);
        this.f58550f.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.f58550f.setTextOption(NoDataViewFactory.e.c(str));
        } else if (1 == i2) {
            this.f58550f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
        } else {
            this.f58550f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
        }
    }

    public void l(boolean z) {
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.m.setVisibility(0);
        }
    }

    public void m() {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
    }

    public void n(int i2, List<a> list, int i3, int i4) {
        String format;
        String format2;
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f58551g.setVisibility(0);
        if (i2 > 0) {
            PraiseListActivity praiseListActivity = this.f58546b;
            if (praiseListActivity.pageType != 1) {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
            } else {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
            }
            this.f58548d.setTitleText(format2);
        } else {
            this.f58548d.setTitleText("");
        }
        if (list != null && list.size() >= 1) {
            this.f58549e.setVisibility(0);
            this.f58550f.setVisibility(8);
            this.f58545a.c(list);
            this.f58545a.notifyDataSetChanged();
            switch (i3) {
                case 1001:
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.l.setVisibility(8);
                    return;
                case 1002:
                    this.j.setVisibility(8);
                    return;
                case 1003:
                    this.j.setVisibility(0);
                    SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
                    this.k.setVisibility(8);
                    this.l.setVisibility(0);
                    PraiseListActivity praiseListActivity2 = this.f58546b;
                    if (praiseListActivity2.pageType != 1) {
                        format = String.format(praiseListActivity2.getResources().getString(R.string.praise_item_more), StringHelper.numFormatOverWan(i2));
                    } else {
                        format = String.format(praiseListActivity2.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
                    }
                    this.l.setText(format);
                    return;
                default:
                    this.j.setVisibility(8);
                    return;
            }
        }
        k(null, this.f58546b.pageType);
    }
}
