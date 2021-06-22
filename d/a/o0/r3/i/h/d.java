package d.a.o0.r3.i.h;

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
    public View f63981a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f63982b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.r3.i.h.a f63983c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.r3.i.c.b f63984d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r3.i.d.a f63985e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.o0.r3.i.e.a aVar = (d.a.o0.r3.i.e.a) d.this.f63984d.getItem(i2);
            if (d.this.f63985e != null) {
                d.this.f63985e.h(aVar);
            }
            if (d.this.f63983c == null || d.this.f63983c.x() == null) {
                return;
            }
            d.this.f63983c.x().setFilter(aVar);
        }
    }

    public d(f fVar, d.a.o0.r3.i.h.a aVar) {
        super(fVar);
        this.f63983c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f63981a = inflate;
        inflate.getResources();
        k();
    }

    public d.a.o0.r3.i.e.a g(String str) {
        for (d.a.o0.r3.i.e.a aVar : this.f63984d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f63929c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f63981a;
    }

    public void i(View view) {
    }

    public final void k() {
        this.f63982b = (HorizontalListView) this.f63981a.findViewById(R.id.edit_filter_horizontal_list);
        this.f63984d = new d.a.o0.r3.i.c.b();
        q(d.a.o0.r3.i.d.a.c(this.f63981a.getContext()));
        this.f63982b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.a.o0.r3.i.e.a aVar) {
        this.f63984d.b(aVar);
    }

    public void p(d.a.o0.r3.i.d.a aVar) {
        this.f63985e = aVar;
    }

    public void q(List<d.a.o0.r3.i.e.a> list) {
        this.f63984d.c(list);
        this.f63982b.setAdapter((ListAdapter) this.f63984d);
    }
}
