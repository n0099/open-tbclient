package d.a.k0.q3.j.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f60026a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f60027b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.q3.j.h.a f60028c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.q3.j.c.b f60029d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.q3.j.d.a f60030e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.k0.q3.j.e.a aVar = (d.a.k0.q3.j.e.a) d.this.f60029d.getItem(i2);
            if (d.this.f60030e != null) {
                d.this.f60030e.h(aVar);
            }
            if (d.this.f60028c == null || d.this.f60028c.x() == null) {
                return;
            }
            d.this.f60028c.x().setFilter(aVar);
        }
    }

    public d(f fVar, d.a.k0.q3.j.h.a aVar) {
        super(fVar);
        this.f60028c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f60026a = inflate;
        inflate.getResources();
        k();
    }

    public d.a.k0.q3.j.e.a g(String str) {
        for (d.a.k0.q3.j.e.a aVar : this.f60029d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f59974c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f60026a;
    }

    public void j(View view) {
    }

    public final void k() {
        this.f60027b = (HorizontalListView) this.f60026a.findViewById(R.id.edit_filter_horizontal_list);
        this.f60029d = new d.a.k0.q3.j.c.b();
        q(d.a.k0.q3.j.d.a.c(this.f60026a.getContext()));
        this.f60027b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.a.k0.q3.j.e.a aVar) {
        this.f60029d.b(aVar);
    }

    public void p(d.a.k0.q3.j.d.a aVar) {
        this.f60030e = aVar;
    }

    public void q(List<d.a.k0.q3.j.e.a> list) {
        this.f60029d.c(list);
        this.f60027b.setAdapter((ListAdapter) this.f60029d);
    }
}
