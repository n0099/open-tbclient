package d.b.i0.p3.j.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import d.b.b.a.f;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends d.b.b.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f59054a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f59055b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.p3.j.h.a f59056c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p3.j.c.b f59057d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p3.j.d.a f59058e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.i0.p3.j.e.a aVar = (d.b.i0.p3.j.e.a) d.this.f59057d.getItem(i);
            if (d.this.f59058e != null) {
                d.this.f59058e.h(aVar);
            }
            if (d.this.f59056c == null || d.this.f59056c.z() == null) {
                return;
            }
            d.this.f59056c.z().setFilter(aVar);
        }
    }

    public d(f fVar, d.b.i0.p3.j.h.a aVar) {
        super(fVar);
        this.f59056c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f59054a = inflate;
        inflate.getResources();
        k();
    }

    public d.b.i0.p3.j.e.a g(String str) {
        for (d.b.i0.p3.j.e.a aVar : this.f59057d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f59004c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f59054a;
    }

    public void i(View view) {
    }

    public final void k() {
        this.f59055b = (HorizontalListView) this.f59054a.findViewById(R.id.edit_filter_horizontal_list);
        this.f59057d = new d.b.i0.p3.j.c.b();
        r(d.b.i0.p3.j.d.a.c(this.f59054a.getContext()));
        this.f59055b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.b.i0.p3.j.e.a aVar) {
        this.f59057d.b(aVar);
    }

    public void q(d.b.i0.p3.j.d.a aVar) {
        this.f59058e = aVar;
    }

    public void r(List<d.b.i0.p3.j.e.a> list) {
        this.f59057d.c(list);
        this.f59055b.setAdapter((ListAdapter) this.f59057d);
    }
}
