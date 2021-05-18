package d.a.k0.i0.m;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public b f55986e;

    /* renamed from: f  reason: collision with root package name */
    public int f55987f = 0;

    /* renamed from: g  reason: collision with root package name */
    public c f55988g;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f55989a;

        public final int b(b bVar) {
            if (bVar == null) {
                return 0;
            }
            for (d dVar : this.f55989a) {
                for (d dVar2 : bVar.f55989a) {
                    if (dVar.f55990a == dVar2.f55990a) {
                        return dVar.f55991b - dVar2.f55991b;
                    }
                }
            }
            return 0;
        }

        public b(e eVar, AbsListView absListView, int i2) {
            this.f55989a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = absListView.getChildAt(i3);
                if (childAt != null) {
                    this.f55989a.add(new d(childAt, i2 + i3));
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
        public int f55990a;

        /* renamed from: b  reason: collision with root package name */
        public int f55991b;

        public d(e eVar, View view, int i2) {
            this.f55990a = i2;
            this.f55991b = view.getTop();
            view.getBottom();
        }
    }

    public void a(c cVar) {
        this.f55988g = cVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        c cVar;
        if (absListView == null || i2 < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i2 == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i5 = this.f55987f;
            if (i5 != 0 && (cVar = this.f55988g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f55987f = 0;
            this.f55986e = null;
            return;
        }
        b bVar = new b(absListView, i2);
        b bVar2 = this.f55986e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f55986e = bVar;
            int i6 = this.f55987f + b2;
            this.f55987f = i6;
            c cVar2 = this.f55988g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f55986e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f55987f = paddingTop;
        c cVar3 = this.f55988g;
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
