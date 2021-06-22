package d.a.o0.o2;

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
import d.a.n0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f61670a;

    /* renamed from: b  reason: collision with root package name */
    public View f61671b;

    /* renamed from: c  reason: collision with root package name */
    public View f61672c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f61673d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.s.a f61676g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f61677h;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.p1.d f61674e = null;

    /* renamed from: f  reason: collision with root package name */
    public View f61675f = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61678i = false;

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
            TiebaStatic.log(new StatisticItem("c12403").param("fid", c.this.f61670a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", c.this.f61670a.mForumName));
            String str = (String) c.this.f61673d.getItemAtPosition(i2 + 1);
            c.this.f61670a.setEditSearchText(str);
            c.this.f61670a.startSearch(str);
            PostSearchActivity unused = c.this.f61670a;
            TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", c.this.f61670a.mForumId));
        }
    }

    /* renamed from: d.a.o0.o2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC1516c implements View.OnTouchListener {
        public View$OnTouchListenerC1516c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f61670a.hideSoftKeyPad();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d(c cVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            c.this.f61670a.getModel().g();
            c.this.f61673d.setVisibility(8);
            c.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.f61670a.hideSoftKeyPad();
            return false;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        this.f61670a = postSearchActivity;
        this.f61671b = view;
        h();
    }

    public void e() {
        this.f61672c.setVisibility(8);
    }

    public void f() {
        this.f61678i = false;
        this.f61670a.hideLoadingView(this.f61672c);
    }

    public void g() {
        NoDataView noDataView = this.f61677h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void h() {
        this.f61672c = this.f61670a.findViewById(R.id.history_frame);
        this.f61673d = (BdListView) this.f61671b.findViewById(R.id.history_list);
        BdListViewHelper.d(this.f61670a.getActivity(), this.f61673d, BdListViewHelper.HeadType.DEFAULT);
        d.a.o0.p1.d dVar = new d.a.o0.p1.d(this.f61670a.getPageContext().getPageActivity(), null);
        this.f61674e = dVar;
        dVar.b(false);
        this.f61673d.setAdapter((ListAdapter) this.f61674e);
        View inflate = LayoutInflater.from(this.f61670a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.f61675f = inflate;
        this.f61673d.addFooterView(inflate);
        this.f61675f.setOnClickListener(new a());
        this.f61673d.setOnItemClickListener(new b());
        this.f61673d.setOnTouchListener(new View$OnTouchListenerC1516c());
    }

    public boolean i() {
        if (this.f61672c.getVisibility() != 0 || this.f61678i) {
            return false;
        }
        NoDataView noDataView = this.f61677h;
        return noDataView == null || 8 == noDataView.getVisibility();
    }

    public void j(int i2) {
        d.a.n0.s0.a.a(this.f61670a.getPageContext(), this.f61675f);
        this.f61674e.notifyDataSetChanged();
        NoDataView noDataView = this.f61677h;
        if (noDataView != null) {
            noDataView.f(this.f61670a.getPageContext(), i2);
        }
    }

    public void k(ArrayList<String> arrayList) {
        this.f61672c.setVisibility(0);
        f();
        if (arrayList != null && arrayList.size() != 0) {
            g();
            this.f61673d.setVisibility(0);
            this.f61674e.a(arrayList);
            this.f61674e.notifyDataSetChanged();
            return;
        }
        this.f61673d.setVisibility(8);
        n();
    }

    public final void l() {
        if (this.f61676g == null) {
            this.f61676g = new d.a.n0.r.s.a(this.f61670a.getPageContext().getPageActivity()).setMessage(this.f61670a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f61670a.getPageContext().getString(R.string.clear_all_text), new e()).setNegativeButton(this.f61670a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f61670a.getPageContext());
        }
        this.f61676g.show();
    }

    public void m() {
        this.f61678i = true;
        PostSearchActivity postSearchActivity = this.f61670a;
        postSearchActivity.showLoadingView(this.f61672c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public final void n() {
        o(R.string.new_text_no_search_record);
    }

    public final void o(int i2) {
        if (this.f61677h == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f61670a.getPageContext().getPageActivity(), this.f61672c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f61670a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
            this.f61677h = a2;
            a2.f(this.f61670a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f61677h.setOnTouchListener(new f());
        }
        this.f61677h.setTextOption(NoDataViewFactory.e.d(null, this.f61670a.getResources().getString(i2)));
        this.f61677h.setVisibility(0);
    }

    public void p() {
        this.f61673d.setVisibility(8);
        o(R.string.new_text_no_search_result);
    }
}
