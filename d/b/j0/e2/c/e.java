package d.b.j0.e2.c;

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
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends d.b.c.a.d<PraiseListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public c f56086a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f56087b;

    /* renamed from: c  reason: collision with root package name */
    public View f56088c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56089d;

    /* renamed from: e  reason: collision with root package name */
    public View f56090e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f56091f;

    /* renamed from: g  reason: collision with root package name */
    public View f56092g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56093h;
    public BdListView i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.f56086a = null;
        this.f56087b = null;
        this.f56088c = null;
        this.f56089d = null;
        this.f56090e = null;
        this.f56091f = null;
        this.f56092g = null;
        this.f56093h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f56087b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f56088c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f56089d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f56090e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f56091f = NoDataViewFactory.a(this.f56087b.getPageContext().getContext(), this.f56088c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f56087b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f56087b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f56086a = cVar;
        this.i.setAdapter((ListAdapter) cVar);
        this.i.setOnScrollListener(this.f56086a);
        this.f56089d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56089d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f56092g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f56092g.findViewById(R.id.zan_list_head_text);
        this.f56093h = textView2;
        textView2.setText(str);
        this.f56092g.setVisibility(8);
        this.i.addHeaderView(this.f56092g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.i.addFooterView(this.j);
        this.i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.b.i0.r.c cVar, int i) {
        if (cVar == null) {
            return;
        }
        cVar.k(i == 1);
        cVar.j(this.f56088c);
        cVar.j(this.f56092g);
        cVar.j(this.j);
        this.f56089d.onChangeSkinType(this.f56087b.getPageContext(), i);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f56091f;
        if (noDataView != null) {
            noDataView.f(this.f56087b.getPageContext(), i);
        }
    }

    public View e() {
        return this.k;
    }

    public View f() {
        return this.f56092g;
    }

    public boolean h() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void i() {
        c cVar = this.f56086a;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void k(String str, int i) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f56090e.setVisibility(8);
        this.f56091f.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.f56091f.setTextOption(NoDataViewFactory.e.c(str));
        } else if (1 == i) {
            this.f56091f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
        } else {
            this.f56091f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
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

    public void n(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f56092g.setVisibility(0);
        if (i > 0) {
            PraiseListActivity praiseListActivity = this.f56087b;
            if (praiseListActivity.pageType != 1) {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i));
            } else {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i));
            }
            this.f56089d.setTitleText(format2);
        } else {
            this.f56089d.setTitleText("");
        }
        if (list != null && list.size() >= 1) {
            this.f56090e.setVisibility(0);
            this.f56091f.setVisibility(8);
            this.f56086a.c(list);
            this.f56086a.notifyDataSetChanged();
            switch (i2) {
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
                    PraiseListActivity praiseListActivity2 = this.f56087b;
                    if (praiseListActivity2.pageType != 1) {
                        format = String.format(praiseListActivity2.getResources().getString(R.string.praise_item_more), StringHelper.numFormatOverWan(i));
                    } else {
                        format = String.format(praiseListActivity2.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i));
                    }
                    this.l.setText(format);
                    return;
                default:
                    this.j.setVisibility(8);
                    return;
            }
        }
        k(null, this.f56087b.pageType);
    }
}
