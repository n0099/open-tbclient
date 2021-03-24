package d.b.i0.d2.c;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.b.b.a.d<PraiseListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public c f54142a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f54143b;

    /* renamed from: c  reason: collision with root package name */
    public View f54144c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54145d;

    /* renamed from: e  reason: collision with root package name */
    public View f54146e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f54147f;

    /* renamed from: g  reason: collision with root package name */
    public View f54148g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54149h;
    public BdListView i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.f54142a = null;
        this.f54143b = null;
        this.f54144c = null;
        this.f54145d = null;
        this.f54146e = null;
        this.f54147f = null;
        this.f54148g = null;
        this.f54149h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f54143b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f54144c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f54145d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f54146e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f54147f = NoDataViewFactory.a(this.f54143b.getPageContext().getContext(), this.f54144c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f54143b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f54143b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f54142a = cVar;
        this.i.setAdapter((ListAdapter) cVar);
        this.i.setOnScrollListener(this.f54142a);
        this.f54145d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54145d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f54148g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f54148g.findViewById(R.id.zan_list_head_text);
        this.f54149h = textView2;
        textView2.setText(str);
        this.f54148g.setVisibility(8);
        this.i.addHeaderView(this.f54148g);
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

    public void d(d.b.h0.r.c cVar, int i) {
        if (cVar == null) {
            return;
        }
        cVar.k(i == 1);
        cVar.j(this.f54144c);
        cVar.j(this.f54148g);
        cVar.j(this.j);
        this.f54145d.onChangeSkinType(this.f54143b.getPageContext(), i);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f54147f;
        if (noDataView != null) {
            noDataView.f(this.f54143b.getPageContext(), i);
        }
    }

    public View e() {
        return this.k;
    }

    public View f() {
        return this.f54148g;
    }

    public boolean h() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void i() {
        c cVar = this.f54142a;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void k(String str, int i) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f54146e.setVisibility(8);
        this.f54147f.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.f54147f.setTextOption(NoDataViewFactory.e.c(str));
        } else if (1 == i) {
            this.f54147f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
        } else {
            this.f54147f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
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
        this.f54148g.setVisibility(0);
        if (i > 0) {
            PraiseListActivity praiseListActivity = this.f54143b;
            if (praiseListActivity.pageType != 1) {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i));
            } else {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i));
            }
            this.f54145d.setTitleText(format2);
        } else {
            this.f54145d.setTitleText("");
        }
        if (list != null && list.size() >= 1) {
            this.f54146e.setVisibility(0);
            this.f54147f.setVisibility(8);
            this.f54142a.c(list);
            this.f54142a.notifyDataSetChanged();
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
                    PraiseListActivity praiseListActivity2 = this.f54143b;
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
        k(null, this.f54143b.pageType);
    }
}
