package d.a.n0.r3.j.h;

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
    public View f60167a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f60168b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r3.j.h.a f60169c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r3.j.c.b f60170d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r3.j.d.a f60171e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.n0.r3.j.e.a aVar = (d.a.n0.r3.j.e.a) d.this.f60170d.getItem(i2);
            if (d.this.f60171e != null) {
                d.this.f60171e.h(aVar);
            }
            if (d.this.f60169c == null || d.this.f60169c.x() == null) {
                return;
            }
            d.this.f60169c.x().setFilter(aVar);
        }
    }

    public d(f fVar, d.a.n0.r3.j.h.a aVar) {
        super(fVar);
        this.f60169c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f60167a = inflate;
        inflate.getResources();
        k();
    }

    public d.a.n0.r3.j.e.a g(String str) {
        for (d.a.n0.r3.j.e.a aVar : this.f60170d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f60115c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f60167a;
    }

    public void j(View view) {
    }

    public final void k() {
        this.f60168b = (HorizontalListView) this.f60167a.findViewById(R.id.edit_filter_horizontal_list);
        this.f60170d = new d.a.n0.r3.j.c.b();
        q(d.a.n0.r3.j.d.a.c(this.f60167a.getContext()));
        this.f60168b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.a.n0.r3.j.e.a aVar) {
        this.f60170d.b(aVar);
    }

    public void p(d.a.n0.r3.j.d.a aVar) {
        this.f60171e = aVar;
    }

    public void q(List<d.a.n0.r3.j.e.a> list) {
        this.f60170d.c(list);
        this.f60168b.setAdapter((ListAdapter) this.f60170d);
    }
}
