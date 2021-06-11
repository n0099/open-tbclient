package d.a.n0.r3.i.h;

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
    public View f63856a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f63857b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r3.i.h.a f63858c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r3.i.c.b f63859d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r3.i.d.a f63860e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.n0.r3.i.e.a aVar = (d.a.n0.r3.i.e.a) d.this.f63859d.getItem(i2);
            if (d.this.f63860e != null) {
                d.this.f63860e.h(aVar);
            }
            if (d.this.f63858c == null || d.this.f63858c.x() == null) {
                return;
            }
            d.this.f63858c.x().setFilter(aVar);
        }
    }

    public d(f fVar, d.a.n0.r3.i.h.a aVar) {
        super(fVar);
        this.f63858c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f63856a = inflate;
        inflate.getResources();
        k();
    }

    public d.a.n0.r3.i.e.a g(String str) {
        for (d.a.n0.r3.i.e.a aVar : this.f63859d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f63804c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f63856a;
    }

    public void i(View view) {
    }

    public final void k() {
        this.f63857b = (HorizontalListView) this.f63856a.findViewById(R.id.edit_filter_horizontal_list);
        this.f63859d = new d.a.n0.r3.i.c.b();
        q(d.a.n0.r3.i.d.a.c(this.f63856a.getContext()));
        this.f63857b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.a.n0.r3.i.e.a aVar) {
        this.f63859d.b(aVar);
    }

    public void p(d.a.n0.r3.i.d.a aVar) {
        this.f63860e = aVar;
    }

    public void q(List<d.a.n0.r3.i.e.a> list) {
        this.f63859d.c(list);
        this.f63857b.setAdapter((ListAdapter) this.f63859d);
    }
}
