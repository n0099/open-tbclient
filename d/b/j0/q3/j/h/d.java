package d.b.j0.q3.j.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.b.c.a.f;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends d.b.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f61144a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f61145b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.q3.j.h.a f61146c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.q3.j.c.b f61147d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.q3.j.d.a f61148e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.j0.q3.j.e.a aVar = (d.b.j0.q3.j.e.a) d.this.f61147d.getItem(i);
            if (d.this.f61148e != null) {
                d.this.f61148e.h(aVar);
            }
            if (d.this.f61146c == null || d.this.f61146c.z() == null) {
                return;
            }
            d.this.f61146c.z().setFilter(aVar);
        }
    }

    public d(f fVar, d.b.j0.q3.j.h.a aVar) {
        super(fVar);
        this.f61146c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f61144a = inflate;
        inflate.getResources();
        k();
    }

    public d.b.j0.q3.j.e.a g(String str) {
        for (d.b.j0.q3.j.e.a aVar : this.f61147d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f61094c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f61144a;
    }

    public void i(View view) {
    }

    public final void k() {
        this.f61145b = (HorizontalListView) this.f61144a.findViewById(R.id.edit_filter_horizontal_list);
        this.f61147d = new d.b.j0.q3.j.c.b();
        r(d.b.j0.q3.j.d.a.c(this.f61144a.getContext()));
        this.f61145b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.b.j0.q3.j.e.a aVar) {
        this.f61147d.b(aVar);
    }

    public void q(d.b.j0.q3.j.d.a aVar) {
        this.f61148e = aVar;
    }

    public void r(List<d.b.j0.q3.j.e.a> list) {
        this.f61147d.c(list);
        this.f61145b.setAdapter((ListAdapter) this.f61147d);
    }
}
