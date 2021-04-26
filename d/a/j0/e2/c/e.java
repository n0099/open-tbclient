package d.a.j0.e2.c;

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
/* loaded from: classes3.dex */
public class e extends d.a.c.a.d<PraiseListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public c f53959a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f53960b;

    /* renamed from: c  reason: collision with root package name */
    public View f53961c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53962d;

    /* renamed from: e  reason: collision with root package name */
    public View f53963e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f53964f;

    /* renamed from: g  reason: collision with root package name */
    public View f53965g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53966h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f53967i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.f53959a = null;
        this.f53960b = null;
        this.f53961c = null;
        this.f53962d = null;
        this.f53963e = null;
        this.f53964f = null;
        this.f53965g = null;
        this.f53966h = null;
        this.f53967i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f53960b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f53961c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f53962d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f53963e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f53964f = NoDataViewFactory.a(this.f53960b.getPageContext().getContext(), this.f53961c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f53960b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f53967i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f53960b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f53967i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f53959a = cVar;
        this.f53967i.setAdapter((ListAdapter) cVar);
        this.f53967i.setOnScrollListener(this.f53959a);
        this.f53962d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53962d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f53965g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f53965g.findViewById(R.id.zan_list_head_text);
        this.f53966h = textView2;
        textView2.setText(str);
        this.f53965g.setVisibility(8);
        this.f53967i.addHeaderView(this.f53965g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f53967i.addFooterView(this.j);
        this.f53967i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.a.i0.r.c cVar, int i2) {
        if (cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f53961c);
        cVar.j(this.f53965g);
        cVar.j(this.j);
        this.f53962d.onChangeSkinType(this.f53960b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f53964f;
        if (noDataView != null) {
            noDataView.f(this.f53960b.getPageContext(), i2);
        }
    }

    public View e() {
        return this.k;
    }

    public View f() {
        return this.f53965g;
    }

    public boolean g() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void h() {
        c cVar = this.f53959a;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void j(String str, int i2) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.f53963e.setVisibility(8);
        this.f53964f.setVisibility(0);
        if (!StringUtils.isNull(str)) {
            this.f53964f.setTextOption(NoDataViewFactory.e.c(str));
        } else if (1 == i2) {
            this.f53964f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
        } else {
            this.f53964f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
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
        this.f53965g.setVisibility(0);
        if (i2 > 0) {
            PraiseListActivity praiseListActivity = this.f53960b;
            if (praiseListActivity.pageType != 1) {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
            } else {
                format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
            }
            this.f53962d.setTitleText(format2);
        } else {
            this.f53962d.setTitleText("");
        }
        if (list != null && list.size() >= 1) {
            this.f53963e.setVisibility(0);
            this.f53964f.setVisibility(8);
            this.f53959a.c(list);
            this.f53959a.notifyDataSetChanged();
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
                    PraiseListActivity praiseListActivity2 = this.f53960b;
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
        j(null, this.f53960b.pageType);
    }
}
