package d.b.j0.i0.m;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public b f57343e;

    /* renamed from: f  reason: collision with root package name */
    public int f57344f = 0;

    /* renamed from: g  reason: collision with root package name */
    public c f57345g;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f57346a;

        public final int b(b bVar) {
            if (bVar == null) {
                return 0;
            }
            for (d dVar : this.f57346a) {
                for (d dVar2 : bVar.f57346a) {
                    if (dVar.f57347a == dVar2.f57347a) {
                        return dVar.f57348b - dVar2.f57348b;
                    }
                }
            }
            return 0;
        }

        public b(e eVar, AbsListView absListView, int i) {
            this.f57346a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = absListView.getChildAt(i2);
                if (childAt != null) {
                    this.f57346a.add(new d(childAt, i + i2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(AbsListView absListView, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f57347a;

        /* renamed from: b  reason: collision with root package name */
        public int f57348b;

        public d(e eVar, View view, int i) {
            this.f57347a = i;
            this.f57348b = view.getTop();
            view.getBottom();
        }
    }

    public void a(c cVar) {
        this.f57345g = cVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        c cVar;
        if (absListView == null || i < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i4 = this.f57344f;
            if (i4 != 0 && (cVar = this.f57345g) != null) {
                cVar.a(absListView, 0, -i4);
            }
            this.f57344f = 0;
            this.f57343e = null;
            return;
        }
        b bVar = new b(absListView, i);
        b bVar2 = this.f57343e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f57343e = bVar;
            int i5 = this.f57344f + b2;
            this.f57344f = i5;
            c cVar2 = this.f57345g;
            if (cVar2 != null) {
                cVar2.a(absListView, i5, b2);
                return;
            }
            return;
        }
        this.f57343e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f57344f = paddingTop;
        c cVar3 = this.f57345g;
        if (cVar3 != null) {
            cVar3.a(absListView, paddingTop, 0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
        }
    }
}
