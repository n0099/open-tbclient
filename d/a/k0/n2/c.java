package d.a.k0.n2;

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
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57684a;

    /* renamed from: b  reason: collision with root package name */
    public View f57685b;

    /* renamed from: c  reason: collision with root package name */
    public View f57686c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f57687d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.s.a f57690g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f57691h;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.o1.d f57688e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f57689f = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57692i = false;

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
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f57684a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f57684a.mForumName));
            String str = (String) c.this.f57687d.getItemAtPosition(i2 + 1);
            c.this.f57684a.setEditSearchText(str);
            c.this.f57684a.startSearch(str);
            PostSearchActivity unused = c.this.f57684a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f57684a.mForumId));
        }
    }

    /* renamed from: d.a.k0.n2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC1440c implements View.OnTouchListener {
        public View$OnTouchListenerC1440c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f57684a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f57684a.getModel().g();
            c.this.f57687d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f57684a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f57684a = postSearchActivity;
        this.f57685b = view;
        h();
    }

    public void e() {
        this.f57686c.setVisibility(8);
    }

    public void f() {
        this.f57692i = false;
        this.f57684a.hideLoadingView(this.f57686c);
    }

    public void g() {
        NoDataView noDataView = this.f57691h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f57686c = this.f57684a.findViewById(R.id.history_frame);
        this.f57687d = (BdListView) this.f57685b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f57684a.getActivity(), this.f57687d, BdListViewHelper.HeadType.DEFAULT);
        d.a.k0.o1.d dVar = new d.a.k0.o1.d(this.f57684a.getPageContext().getPageActivity(), null);
        this.f57688e = dVar;
        dVar.b(false);
        this.f57687d.setAdapter((ListAdapter) this.f57688e);
        View inflate = LayoutInflater.from(this.f57684a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f57689f = inflate;
        this.f57687d.addFooterView(inflate);
        this.f57689f.setOnClickListener(new a());
        this.f57687d.setOnItemClickListener(new b());
        this.f57687d.setOnTouchListener(new View$OnTouchListenerC1440c());
    }

    public boolean i() {
        if (this.f57686c.getVisibility() != 0 || this.f57692i) {
            return false;
        }
        NoDataView noDataView = this.f57691h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i2) {
        d.a.j0.s0.a.a(this.f57684a.getPageContext(), this.f57689f);
        this.f57688e.notifyDataSetChanged();
        NoDataView noDataView = this.f57691h;
        if (noDataView != null) {
            noDataView.f(this.f57684a.getPageContext(), i2);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f57686c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f57687d.setVisibility(0);
            this.f57688e.a(arrayList);
            this.f57688e.notifyDataSetChanged();
            return;
        }
        this.f57687d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f57690g == null) {
            this.f57690g = new d.a.j0.r.s.a(this.f57684a.getPageContext().getPageActivity()).setMessage(this.f57684a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f57684a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f57684a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f57684a.getPageContext());
        }
        this.f57690g.show();
    }

    public void m() {
        this.f57692i = true;
        PostSearchActivity postSearchActivity = this.f57684a;
        postSearchActivity.showLoadingView(this.f57686c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i2) {
        if (this.f57691h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f57684a.getPageContext().getPageActivity(), this.f57686c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f57684a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f57691h = a2;
            a2.f(this.f57684a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f57691h.setOnTouchListener(new f());
        }
        this.f57691h.setTextOption(NoDataViewFactory.e.d(null, this.f57684a.getResources().getString(i2)));
        this.f57691h.setVisibility(0);
    }

    public void p() {
        this.f57687d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
