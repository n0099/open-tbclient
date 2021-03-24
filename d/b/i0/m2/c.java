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
    public PostSearchActivity f56899a;

    /* renamed from: b  reason: collision with root package name */
    public View f56900b;

    /* renamed from: c  reason: collision with root package name */
    public View f56901c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f56902d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.s.a f56905g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f56906h;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.n1.d f56903e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f56904f = null;
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
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f56899a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f56899a.mForumName));
            String str = (String) c.this.f56902d.getItemAtPosition(i + 1);
            c.this.f56899a.setEditSearchText(str);
            c.this.f56899a.startSearch(str);
            PostSearchActivity unused = c.this.f56899a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f56899a.mForumId));
        }
    }

    /* renamed from: d.b.i0.m2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC1347c implements View.OnTouchListener {
        public View$OnTouchListenerC1347c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56899a.hideSoftKeyPad();
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
            c.this.f56899a.getModel().g();
            c.this.f56902d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56899a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f56899a = postSearchActivity;
        this.f56900b = view;
        h();
    }

    public void e() {
        this.f56901c.setVisibility(8);
    }

    public void f() {
        this.i = false;
        this.f56899a.hideLoadingView(this.f56901c);
    }

    public void g() {
        NoDataView noDataView = this.f56906h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f56901c = this.f56899a.findViewById(R.id.history_frame);
        this.f56902d = (BdListView) this.f56900b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f56899a.getActivity(), this.f56902d, BdListViewHelper.HeadType.DEFAULT);
        d.b.i0.n1.d dVar = new d.b.i0.n1.d(this.f56899a.getPageContext().getPageActivity(), null);
        this.f56903e = dVar;
        dVar.b(false);
        this.f56902d.setAdapter((ListAdapter) this.f56903e);
        View inflate = LayoutInflater.from(this.f56899a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f56904f = inflate;
        this.f56902d.addFooterView(inflate);
        this.f56904f.setOnClickListener(new a());
        this.f56902d.setOnItemClickListener(new b());
        this.f56902d.setOnTouchListener(new View$OnTouchListenerC1347c());
    }

    public boolean i() {
        if (this.f56901c.getVisibility() != 0 || this.i) {
            return false;
        }
        NoDataView noDataView = this.f56906h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i) {
        d.b.h0.s0.a.a(this.f56899a.getPageContext(), this.f56904f);
        this.f56903e.notifyDataSetChanged();
        NoDataView noDataView = this.f56906h;
        if (noDataView != null) {
            noDataView.f(this.f56899a.getPageContext(), i);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f56901c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f56902d.setVisibility(0);
            this.f56903e.a(arrayList);
            this.f56903e.notifyDataSetChanged();
            return;
        }
        this.f56902d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f56905g == null) {
            this.f56905g = new d.b.h0.r.s.a(this.f56899a.getPageContext().getPageActivity()).setMessage(this.f56899a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f56899a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f56899a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f56899a.getPageContext());
        }
        this.f56905g.show();
    }

    public void m() {
        this.i = true;
        PostSearchActivity postSearchActivity = this.f56899a;
        postSearchActivity.showLoadingView(this.f56901c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i) {
        if (this.f56906h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f56899a.getPageContext().getPageActivity(), this.f56901c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f56899a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f56906h = a2;
            a2.f(this.f56899a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f56906h.setOnTouchListener(new f());
        }
        this.f56906h.setTextOption(NoDataViewFactory.e.d(null, this.f56899a.getResources().getString(i)));
        this.f56906h.setVisibility(0);
    }

    public void p() {
        this.f56902d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
