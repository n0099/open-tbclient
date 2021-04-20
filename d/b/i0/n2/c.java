package d.b.i0.n2;

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
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f58537a;

    /* renamed from: b  reason: collision with root package name */
    public View f58538b;

    /* renamed from: c  reason: collision with root package name */
    public View f58539c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f58540d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.s.a f58543g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f58544h;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.o1.d f58541e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f58542f = null;
    public boolean i = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f58537a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f58537a.mForumName));
            String str = (String) c.this.f58540d.getItemAtPosition(i + 1);
            c.this.f58537a.setEditSearchText(str);
            c.this.f58537a.startSearch(str);
            PostSearchActivity unused = c.this.f58537a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f58537a.mForumId));
        }
    }

    /* renamed from: d.b.i0.n2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1406c implements View.OnTouchListener {
        public View$OnTouchListenerC1406c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f58537a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f58537a.getModel().g();
            c.this.f58540d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f58537a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f58537a = postSearchActivity;
        this.f58538b = view;
        h();
    }

    public void e() {
        this.f58539c.setVisibility(8);
    }

    public void f() {
        this.i = false;
        this.f58537a.hideLoadingView(this.f58539c);
    }

    public void g() {
        NoDataView noDataView = this.f58544h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f58539c = this.f58537a.findViewById(R.id.history_frame);
        this.f58540d = (BdListView) this.f58538b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f58537a.getActivity(), this.f58540d, BdListViewHelper.HeadType.DEFAULT);
        d.b.i0.o1.d dVar = new d.b.i0.o1.d(this.f58537a.getPageContext().getPageActivity(), null);
        this.f58541e = dVar;
        dVar.b(false);
        this.f58540d.setAdapter((ListAdapter) this.f58541e);
        View inflate = LayoutInflater.from(this.f58537a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f58542f = inflate;
        this.f58540d.addFooterView(inflate);
        this.f58542f.setOnClickListener(new a());
        this.f58540d.setOnItemClickListener(new b());
        this.f58540d.setOnTouchListener(new View$OnTouchListenerC1406c());
    }

    public boolean i() {
        if (this.f58539c.getVisibility() != 0 || this.i) {
            return false;
        }
        NoDataView noDataView = this.f58544h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i) {
        d.b.h0.s0.a.a(this.f58537a.getPageContext(), this.f58542f);
        this.f58541e.notifyDataSetChanged();
        NoDataView noDataView = this.f58544h;
        if (noDataView != null) {
            noDataView.f(this.f58537a.getPageContext(), i);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f58539c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f58540d.setVisibility(0);
            this.f58541e.a(arrayList);
            this.f58541e.notifyDataSetChanged();
            return;
        }
        this.f58540d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f58543g == null) {
            this.f58543g = new d.b.h0.r.s.a(this.f58537a.getPageContext().getPageActivity()).setMessage(this.f58537a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f58537a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f58537a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f58537a.getPageContext());
        }
        this.f58543g.show();
    }

    public void m() {
        this.i = true;
        PostSearchActivity postSearchActivity = this.f58537a;
        postSearchActivity.showLoadingView(this.f58539c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i) {
        if (this.f58544h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f58537a.getPageContext().getPageActivity(), this.f58539c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58537a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f58544h = a2;
            a2.f(this.f58537a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f58544h.setOnTouchListener(new f());
        }
        this.f58544h.setTextOption(NoDataViewFactory.e.d(null, this.f58537a.getResources().getString(i)));
        this.f58544h.setVisibility(0);
    }

    public void p() {
        this.f58540d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
