package d.a.o0.j0.m;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public b f59984e;

    /* renamed from: f  reason: collision with root package name */
    public int f59985f = 0;

    /* renamed from: g  reason: collision with root package name */
    public c f59986g;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59987a;

        public final int b(b bVar) {
            if (bVar == null) {
                return 0;
            }
            for (d dVar : this.f59987a) {
                for (d dVar2 : bVar.f59987a) {
                    if (dVar.f59988a == dVar2.f59988a) {
                        return dVar.f59989b - dVar2.f59989b;
                    }
                }
            }
            return 0;
        }

        public b(e eVar, AbsListView absListView, int i2) {
            this.f59987a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = absListView.getChildAt(i3);
                if (childAt != null) {
                    this.f59987a.add(new d(childAt, i2 + i3));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(AbsListView absListView, int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f59988a;

        /* renamed from: b  reason: collision with root package name */
        public int f59989b;

        public d(e eVar, View view, int i2) {
            this.f59988a = i2;
            this.f59989b = view.getTop();
            view.getBottom();
        }
    }

    public void a(c cVar) {
        this.f59986g = cVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        c cVar;
        if (absListView == null || i2 < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i2 == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i5 = this.f59985f;
            if (i5 != 0 && (cVar = this.f59986g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f59985f = 0;
            this.f59984e = null;
            return;
        }
        b bVar = new b(absListView, i2);
        b bVar2 = this.f59984e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f59984e = bVar;
            int i6 = this.f59985f + b2;
            this.f59985f = i6;
            c cVar2 = this.f59986g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f59984e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f59985f = paddingTop;
        c cVar3 = this.f59986g;
        if (cVar3 != null) {
            cVar3.a(absListView, paddingTop, 0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
        }
    }
}
