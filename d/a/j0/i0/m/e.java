package d.a.j0.i0.m;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public b f55279e;

    /* renamed from: f  reason: collision with root package name */
    public int f55280f = 0;

    /* renamed from: g  reason: collision with root package name */
    public c f55281g;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f55282a;

        public final int b(b bVar) {
            if (bVar == null) {
                return 0;
            }
            for (d dVar : this.f55282a) {
                for (d dVar2 : bVar.f55282a) {
                    if (dVar.f55283a == dVar2.f55283a) {
                        return dVar.f55284b - dVar2.f55284b;
                    }
                }
            }
            return 0;
        }

        public b(e eVar, AbsListView absListView, int i2) {
            this.f55282a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = absListView.getChildAt(i3);
                if (childAt != null) {
                    this.f55282a.add(new d(childAt, i2 + i3));
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
        public int f55283a;

        /* renamed from: b  reason: collision with root package name */
        public int f55284b;

        public d(e eVar, View view, int i2) {
            this.f55283a = i2;
            this.f55284b = view.getTop();
            view.getBottom();
        }
    }

    public void a(c cVar) {
        this.f55281g = cVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        c cVar;
        if (absListView == null || i2 < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i2 == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i5 = this.f55280f;
            if (i5 != 0 && (cVar = this.f55281g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f55280f = 0;
            this.f55279e = null;
            return;
        }
        b bVar = new b(absListView, i2);
        b bVar2 = this.f55279e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f55279e = bVar;
            int i6 = this.f55280f + b2;
            this.f55280f = i6;
            c cVar2 = this.f55281g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f55279e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f55280f = paddingTop;
        c cVar3 = this.f55281g;
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
