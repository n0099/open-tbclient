package d.a.o0.f2.c;

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
    public c f58670a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f58671b;

    /* renamed from: c  reason: collision with root package name */
    public View f58672c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58673d;

    /* renamed from: e  reason: collision with root package name */
    public View f58674e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f58675f;

    /* renamed from: g  reason: collision with root package name */
    public View f58676g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58677h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f58678i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.f58670a = null;
        this.f58671b = null;
        this.f58672c = null;
        this.f58673d = null;
        this.f58674e = null;
        this.f58675f = null;
        this.f58676g = null;
        this.f58677h = null;
        this.f58678i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f58671b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f58672c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f58673d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f58674e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f58675f = NoDataViewFactory.a(this.f58671b.getPageContext().getContext(), this.f58672c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58671b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f58678i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f58671b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f58678i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f58670a = cVar;
        this.f58678i.setAdapter((ListAdapter) cVar);
        this.f58678i.setOnScrollListener(this.f58670a);
        this.f58673d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58673d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f58676g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f58676g.findViewById(R.id.zan_list_head_text);
        this.f58677h = textView2;
        textView2.setText(str);
        this.f58676g.setVisibility(8);
        this.f58678i.addHeaderView(this.f58676g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f58678i.addFooterView(this.j);
        this.f58678i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.a.n0.r.c cVar, int i2) {
        if (cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f58672c);
        cVar.j(this.f58676g);
        cVar.j(this.j);
        this.f58673d.onChangeSkinType(this.f58671b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f58675f;
        if (noDataView != null) {
            noDataView.f(this.f58671b.getPageContext(), i2);
        }
    }

    public View e() {
        return this.k;
    }

    public View f() {
        return this.f58676g;
    }

    public boolean h() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void i() {
        c cVar = this.f58670a;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void k(String str, int i2) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f58674e.setVisibility(8);
        this.f58675f.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.f58675f.setTextOption(NoDataViewFactory.e.c(str));
        } else if (1 == i2) {
            this.f58675f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
        } else {
            this.f58675f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
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
        this.f58676g.setVisibility(0);
        if (i2 > 0) {
            PraiseListActivity praiseListActivity = this.f58671b;
            if (praiseListActivity.pageType != 1) {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
            } else {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
            }
            this.f58673d.setTitleText(format2);
        } else {
            this.f58673d.setTitleText("");
        }
        if (list != null && list.size() >= 1) {
            this.f58674e.setVisibility(0);
            this.f58675f.setVisibility(8);
            this.f58670a.c(list);
            this.f58670a.notifyDataSetChanged();
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
                    PraiseListActivity praiseListActivity2 = this.f58671b;
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
        k(null, this.f58671b.pageType);
    }
}
