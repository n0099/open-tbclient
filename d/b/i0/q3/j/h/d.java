package d.b.i0.q3.j.h;

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
    public View f60723a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f60724b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.q3.j.h.a f60725c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q3.j.c.b f60726d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q3.j.d.a f60727e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.i0.q3.j.e.a aVar = (d.b.i0.q3.j.e.a) d.this.f60726d.getItem(i);
            if (d.this.f60727e != null) {
                d.this.f60727e.h(aVar);
            }
            if (d.this.f60725c == null || d.this.f60725c.z() == null) {
                return;
            }
            d.this.f60725c.z().setFilter(aVar);
        }
    }

    public d(f fVar, d.b.i0.q3.j.h.a aVar) {
        super(fVar);
        this.f60725c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f60723a = inflate;
        inflate.getResources();
        k();
    }

    public d.b.i0.q3.j.e.a g(String str) {
        for (d.b.i0.q3.j.e.a aVar : this.f60726d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f60673c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f60723a;
    }

    public void i(View view) {
    }

    public final void k() {
        this.f60724b = (HorizontalListView) this.f60723a.findViewById(R.id.edit_filter_horizontal_list);
        this.f60726d = new d.b.i0.q3.j.c.b();
        r(d.b.i0.q3.j.d.a.c(this.f60723a.getContext()));
        this.f60724b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.b.i0.q3.j.e.a aVar) {
        this.f60726d.b(aVar);
    }

    public void q(d.b.i0.q3.j.d.a aVar) {
        this.f60727e = aVar;
    }

    public void r(List<d.b.i0.q3.j.e.a> list) {
        this.f60726d.c(list);
        this.f60724b.setAdapter((ListAdapter) this.f60726d);
    }
}
