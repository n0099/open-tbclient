package d.a.n0.o2;

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
import d.a.m0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57856a;

    /* renamed from: b  reason: collision with root package name */
    public View f57857b;

    /* renamed from: c  reason: collision with root package name */
    public View f57858c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f57859d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.s.a f57862g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f57863h;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.p1.d f57860e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f57861f = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57864i = false;

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
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f57856a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f57856a.mForumName));
            String str = (String) c.this.f57859d.getItemAtPosition(i2 + 1);
            c.this.f57856a.setEditSearchText(str);
            c.this.f57856a.startSearch(str);
            PostSearchActivity unused = c.this.f57856a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f57856a.mForumId));
        }
    }

    /* renamed from: d.a.n0.o2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC1456c implements View.OnTouchListener {
        public View$OnTouchListenerC1456c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f57856a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f57856a.getModel().g();
            c.this.f57859d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f57856a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f57856a = postSearchActivity;
        this.f57857b = view;
        h();
    }

    public void e() {
        this.f57858c.setVisibility(8);
    }

    public void f() {
        this.f57864i = false;
        this.f57856a.hideLoadingView(this.f57858c);
    }

    public void g() {
        NoDataView noDataView = this.f57863h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f57858c = this.f57856a.findViewById(R.id.history_frame);
        this.f57859d = (BdListView) this.f57857b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f57856a.getActivity(), this.f57859d, BdListViewHelper.HeadType.DEFAULT);
        d.a.n0.p1.d dVar = new d.a.n0.p1.d(this.f57856a.getPageContext().getPageActivity(), null);
        this.f57860e = dVar;
        dVar.b(false);
        this.f57859d.setAdapter((ListAdapter) this.f57860e);
        View inflate = LayoutInflater.from(this.f57856a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f57861f = inflate;
        this.f57859d.addFooterView(inflate);
        this.f57861f.setOnClickListener(new a());
        this.f57859d.setOnItemClickListener(new b());
        this.f57859d.setOnTouchListener(new View$OnTouchListenerC1456c());
    }

    public boolean i() {
        if (this.f57858c.getVisibility() != 0 || this.f57864i) {
            return false;
        }
        NoDataView noDataView = this.f57863h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i2) {
        d.a.m0.s0.a.a(this.f57856a.getPageContext(), this.f57861f);
        this.f57860e.notifyDataSetChanged();
        NoDataView noDataView = this.f57863h;
        if (noDataView != null) {
            noDataView.f(this.f57856a.getPageContext(), i2);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f57858c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f57859d.setVisibility(0);
            this.f57860e.a(arrayList);
            this.f57860e.notifyDataSetChanged();
            return;
        }
        this.f57859d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f57862g == null) {
            this.f57862g = new d.a.m0.r.s.a(this.f57856a.getPageContext().getPageActivity()).setMessage(this.f57856a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f57856a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f57856a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f57856a.getPageContext());
        }
        this.f57862g.show();
    }

    public void m() {
        this.f57864i = true;
        PostSearchActivity postSearchActivity = this.f57856a;
        postSearchActivity.showLoadingView(this.f57858c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i2) {
        if (this.f57863h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f57856a.getPageContext().getPageActivity(), this.f57858c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f57856a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f57863h = a2;
            a2.f(this.f57856a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f57863h.setOnTouchListener(new f());
        }
        this.f57863h.setTextOption(NoDataViewFactory.e.d(null, this.f57856a.getResources().getString(i2)));
        this.f57863h.setVisibility(0);
    }

    public void p() {
        this.f57859d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
