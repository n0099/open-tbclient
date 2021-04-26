package d.a.j0.q3.j.h;

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
    public View f59281a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f59282b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.q3.j.h.a f59283c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.q3.j.c.b f59284d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q3.j.d.a f59285e;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.j0.q3.j.e.a aVar = (d.a.j0.q3.j.e.a) d.this.f59284d.getItem(i2);
            if (d.this.f59285e != null) {
                d.this.f59285e.h(aVar);
            }
            if (d.this.f59283c == null || d.this.f59283c.x() == null) {
                return;
            }
            d.this.f59283c.x().setFilter(aVar);
        }
    }

    public d(f fVar, d.a.j0.q3.j.h.a aVar) {
        super(fVar);
        this.f59283c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f59281a = inflate;
        inflate.getResources();
        k();
    }

    public d.a.j0.q3.j.e.a g(String str) {
        for (d.a.j0.q3.j.e.a aVar : this.f59284d.a()) {
            if (aVar != null && StringHelper.equals(aVar.f59229c, str)) {
                return aVar;
            }
        }
        return null;
    }

    public View h() {
        return this.f59281a;
    }

    public void j(View view) {
    }

    public final void k() {
        this.f59282b = (HorizontalListView) this.f59281a.findViewById(R.id.edit_filter_horizontal_list);
        this.f59284d = new d.a.j0.q3.j.c.b();
        q(d.a.j0.q3.j.d.a.c(this.f59281a.getContext()));
        this.f59282b.setOnItemClickListener(new a());
    }

    public void l() {
    }

    public void m() {
    }

    public void n(boolean z) {
    }

    public void o(d.a.j0.q3.j.e.a aVar) {
        this.f59284d.b(aVar);
    }

    public void p(d.a.j0.q3.j.d.a aVar) {
        this.f59285e = aVar;
    }

    public void q(List<d.a.j0.q3.j.e.a> list) {
        this.f59284d.c(list);
        this.f59282b.setAdapter((ListAdapter) this.f59284d);
    }
}
