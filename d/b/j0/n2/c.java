package d.b.j0.n2;

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
import d.b.i0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f58958a;

    /* renamed from: b  reason: collision with root package name */
    public View f58959b;

    /* renamed from: c  reason: collision with root package name */
    public View f58960c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f58961d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.s.a f58964g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f58965h;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.o1.d f58962e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f58963f = null;
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
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f58958a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f58958a.mForumName));
            String str = (String) c.this.f58961d.getItemAtPosition(i + 1);
            c.this.f58958a.setEditSearchText(str);
            c.this.f58958a.startSearch(str);
            PostSearchActivity unused = c.this.f58958a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f58958a.mForumId));
        }
    }

    /* renamed from: d.b.j0.n2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1429c implements View.OnTouchListener {
        public View$OnTouchListenerC1429c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f58958a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f58958a.getModel().g();
            c.this.f58961d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f58958a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f58958a = postSearchActivity;
        this.f58959b = view;
        h();
    }

    public void e() {
        this.f58960c.setVisibility(8);
    }

    public void f() {
        this.i = false;
        this.f58958a.hideLoadingView(this.f58960c);
    }

    public void g() {
        NoDataView noDataView = this.f58965h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f58960c = this.f58958a.findViewById(R.id.history_frame);
        this.f58961d = (BdListView) this.f58959b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f58958a.getActivity(), this.f58961d, BdListViewHelper.HeadType.DEFAULT);
        d.b.j0.o1.d dVar = new d.b.j0.o1.d(this.f58958a.getPageContext().getPageActivity(), null);
        this.f58962e = dVar;
        dVar.b(false);
        this.f58961d.setAdapter((ListAdapter) this.f58962e);
        View inflate = LayoutInflater.from(this.f58958a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f58963f = inflate;
        this.f58961d.addFooterView(inflate);
        this.f58963f.setOnClickListener(new a());
        this.f58961d.setOnItemClickListener(new b());
        this.f58961d.setOnTouchListener(new View$OnTouchListenerC1429c());
    }

    public boolean i() {
        if (this.f58960c.getVisibility() != 0 || this.i) {
            return false;
        }
        NoDataView noDataView = this.f58965h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i) {
        d.b.i0.s0.a.a(this.f58958a.getPageContext(), this.f58963f);
        this.f58962e.notifyDataSetChanged();
        NoDataView noDataView = this.f58965h;
        if (noDataView != null) {
            noDataView.f(this.f58958a.getPageContext(), i);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f58960c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f58961d.setVisibility(0);
            this.f58962e.a(arrayList);
            this.f58962e.notifyDataSetChanged();
            return;
        }
        this.f58961d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f58964g == null) {
            this.f58964g = new d.b.i0.r.s.a(this.f58958a.getPageContext().getPageActivity()).setMessage(this.f58958a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f58958a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f58958a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f58958a.getPageContext());
        }
        this.f58964g.show();
    }

    public void m() {
        this.i = true;
        PostSearchActivity postSearchActivity = this.f58958a;
        postSearchActivity.showLoadingView(this.f58960c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i) {
        if (this.f58965h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f58958a.getPageContext().getPageActivity(), this.f58960c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58958a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f58965h = a2;
            a2.f(this.f58958a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f58965h.setOnTouchListener(new f());
        }
        this.f58965h.setTextOption(NoDataViewFactory.e.d(null, this.f58958a.getResources().getString(i)));
        this.f58965h.setVisibility(0);
    }

    public void p() {
        this.f58961d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
