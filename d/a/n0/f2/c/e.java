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
    public c f54856a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f54857b;

    /* renamed from: c  reason: collision with root package name */
    public View f54858c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54859d;

    /* renamed from: e  reason: collision with root package name */
    public View f54860e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f54861f;

    /* renamed from: g  reason: collision with root package name */
    public View f54862g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54863h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f54864i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.f54856a = null;
        this.f54857b = null;
        this.f54858c = null;
        this.f54859d = null;
        this.f54860e = null;
        this.f54861f = null;
        this.f54862g = null;
        this.f54863h = null;
        this.f54864i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f54857b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f54858c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f54859d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f54860e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f54861f = NoDataViewFactory.a(this.f54857b.getPageContext().getContext(), this.f54858c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f54857b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f54864i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f54857b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f54864i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f54856a = cVar;
        this.f54864i.setAdapter((ListAdapter) cVar);
        this.f54864i.setOnScrollListener(this.f54856a);
        this.f54859d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54859d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f54862g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f54862g.findViewById(R.id.zan_list_head_text);
        this.f54863h = textView2;
        textView2.setText(str);
        this.f54862g.setVisibility(8);
        this.f54864i.addHeaderView(this.f54862g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f54864i.addFooterView(this.j);
        this.f54864i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.a.m0.r.c cVar, int i2) {
        if (cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f54858c);
        cVar.j(this.f54862g);
        cVar.j(this.j);
        this.f54859d.onChangeSkinType(this.f54857b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f54861f;
        if (noDataView != null) {
            noDataView.f(this.f54857b.getPageContext(), i2);
        }
    }

    public View e() {
        return this.k;
    }

    public View f() {
        return this.f54862g;
    }

    public boolean g() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void h() {
        c cVar = this.f54856a;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void j(String str, int i2) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f54860e.setVisibility(8);
        this.f54861f.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.f54861f.setTextOption(NoDataViewFactory.e.c(str));
        } else if (1 == i2) {
            this.f54861f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
        } else {
            this.f54861f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
        }
    }

    public void k(boolean z) {
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.m.setVisibility(0);
        }
    }

    public void l() {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
    }

    public void m(int i2, List<a> list, int i3, int i4) {
        String format;
        String format2;
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f54862g.setVisibility(0);
        if (i2 > 0) {
            PraiseListActivity praiseListActivity = this.f54857b;
            if (praiseListActivity.pageType != 1) {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
            } else {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
            }
            this.f54859d.setTitleText(format2);
        } else {
            this.f54859d.setTitleText("");
        }
        if (list != null && list.size() >= 1) {
            this.f54860e.setVisibility(0);
            this.f54861f.setVisibility(8);
            this.f54856a.c(list);
            this.f54856a.notifyDataSetChanged();
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
                    PraiseListActivity praiseListActivity2 = this.f54857b;
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
        j(null, this.f54857b.pageType);
    }
}
