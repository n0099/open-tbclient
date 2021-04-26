package d.a.j0.n2;

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
import d.a.i0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56977a;

    /* renamed from: b  reason: collision with root package name */
    public View f56978b;

    /* renamed from: c  reason: collision with root package name */
    public View f56979c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f56980d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.s.a f56983g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f56984h;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.o1.d f56981e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f56982f = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56985i = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f56977a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f56977a.mForumName));
            String str = (String) c.this.f56980d.getItemAtPosition(i2 + 1);
            c.this.f56977a.setEditSearchText(str);
            c.this.f56977a.startSearch(str);
            PostSearchActivity unused = c.this.f56977a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f56977a.mForumId));
        }
    }

    /* renamed from: d.a.j0.n2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1368c implements View.OnTouchListener {
        public View$OnTouchListenerC1368c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56977a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f56977a.getModel().g();
            c.this.f56980d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f56977a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f56977a = postSearchActivity;
        this.f56978b = view;
        h();
    }

    public void e() {
        this.f56979c.setVisibility(8);
    }

    public void f() {
        this.f56985i = false;
        this.f56977a.hideLoadingView(this.f56979c);
    }

    public void g() {
        NoDataView noDataView = this.f56984h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f56979c = this.f56977a.findViewById(R.id.history_frame);
        this.f56980d = (BdListView) this.f56978b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f56977a.getActivity(), this.f56980d, BdListViewHelper.HeadType.DEFAULT);
        d.a.j0.o1.d dVar = new d.a.j0.o1.d(this.f56977a.getPageContext().getPageActivity(), null);
        this.f56981e = dVar;
        dVar.b(false);
        this.f56980d.setAdapter((ListAdapter) this.f56981e);
        View inflate = LayoutInflater.from(this.f56977a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f56982f = inflate;
        this.f56980d.addFooterView(inflate);
        this.f56982f.setOnClickListener(new a());
        this.f56980d.setOnItemClickListener(new b());
        this.f56980d.setOnTouchListener(new View$OnTouchListenerC1368c());
    }

    public boolean i() {
        if (this.f56979c.getVisibility() != 0 || this.f56985i) {
            return false;
        }
        NoDataView noDataView = this.f56984h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i2) {
        d.a.i0.s0.a.a(this.f56977a.getPageContext(), this.f56982f);
        this.f56981e.notifyDataSetChanged();
        NoDataView noDataView = this.f56984h;
        if (noDataView != null) {
            noDataView.f(this.f56977a.getPageContext(), i2);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f56979c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f56980d.setVisibility(0);
            this.f56981e.a(arrayList);
            this.f56981e.notifyDataSetChanged();
            return;
        }
        this.f56980d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f56983g == null) {
            this.f56983g = new d.a.i0.r.s.a(this.f56977a.getPageContext().getPageActivity()).setMessage(this.f56977a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f56977a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f56977a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f56977a.getPageContext());
        }
        this.f56983g.show();
    }

    public void m() {
        this.f56985i = true;
        PostSearchActivity postSearchActivity = this.f56977a;
        postSearchActivity.showLoadingView(this.f56979c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i2) {
        if (this.f56984h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f56977a.getPageContext().getPageActivity(), this.f56979c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f56977a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f56984h = a2;
            a2.f(this.f56977a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f56984h.setOnTouchListener(new f());
        }
        this.f56984h.setTextOption(NoDataViewFactory.e.d(null, this.f56977a.getResources().getString(i2)));
        this.f56984h.setVisibility(0);
    }

    public void p() {
        this.f56980d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
