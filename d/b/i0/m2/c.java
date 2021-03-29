package d.b.i0.m2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56900a;

    /* renamed from: b  reason: collision with root package name */
    public View f56901b;

    /* renamed from: c  reason: collision with root package name */
    public View f56902c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f56903d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.s.a f56906g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f56907h;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.n1.d f56904e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f56905f = null;
    public boolean i = false;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f56900a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f56900a.mForumName));
            String str = (String) c.this.f56903d.getItemAtPosition(i + 1);
            c.this.f56900a.setEditSearchText(str);
            c.this.f56900a.startSearch(str);
            PostSearchActivity unused = c.this.f56900a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f56900a.mForumId));
        }
    }

    /* renamed from: d.b.i0.m2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC1348c implements View.OnTouchListener {
        public View$OnTouchListenerC1348c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56900a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f56900a.getModel().g();
            c.this.f56903d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56900a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f56900a = postSearchActivity;
        this.f56901b = view;
        h();
    }

    public void e() {
        this.f56902c.setVisibility(8);
    }

    public void f() {
        this.i = false;
        this.f56900a.hideLoadingView(this.f56902c);
    }

    public void g() {
        NoDataView noDataView = this.f56907h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f56902c = this.f56900a.findViewById(R.id.history_frame);
        this.f56903d = (BdListView) this.f56901b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f56900a.getActivity(), this.f56903d, BdListViewHelper.HeadType.DEFAULT);
        d.b.i0.n1.d dVar = new d.b.i0.n1.d(this.f56900a.getPageContext().getPageActivity(), null);
        this.f56904e = dVar;
        dVar.b(false);
        this.f56903d.setAdapter((ListAdapter) this.f56904e);
        View inflate = LayoutInflater.from(this.f56900a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f56905f = inflate;
        this.f56903d.addFooterView(inflate);
        this.f56905f.setOnClickListener(new a());
        this.f56903d.setOnItemClickListener(new b());
        this.f56903d.setOnTouchListener(new View$OnTouchListenerC1348c());
    }

    public boolean i() {
        if (this.f56902c.getVisibility() != 0 || this.i) {
            return false;
        }
        NoDataView noDataView = this.f56907h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i) {
        d.b.h0.s0.a.a(this.f56900a.getPageContext(), this.f56905f);
        this.f56904e.notifyDataSetChanged();
        NoDataView noDataView = this.f56907h;
        if (noDataView != null) {
            noDataView.f(this.f56900a.getPageContext(), i);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f56902c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f56903d.setVisibility(0);
            this.f56904e.a(arrayList);
            this.f56904e.notifyDataSetChanged();
            return;
        }
        this.f56903d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f56906g == null) {
            this.f56906g = new d.b.h0.r.s.a(this.f56900a.getPageContext().getPageActivity()).setMessage(this.f56900a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f56900a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f56900a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f56900a.getPageContext());
        }
        this.f56906g.show();
    }

    public void m() {
        this.i = true;
        PostSearchActivity postSearchActivity = this.f56900a;
        postSearchActivity.showLoadingView(this.f56902c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i) {
        if (this.f56907h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f56900a.getPageContext().getPageActivity(), this.f56902c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f56900a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f56907h = a2;
            a2.f(this.f56900a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f56907h.setOnTouchListener(new f());
        }
        this.f56907h.setTextOption(NoDataViewFactory.e.d(null, this.f56900a.getResources().getString(i)));
        this.f56907h.setVisibility(0);
    }

    public void p() {
        this.f56903d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
