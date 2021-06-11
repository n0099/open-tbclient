package d.a.n0.j0.m;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public b f59859e;

    /* renamed from: f  reason: collision with root package name */
    public int f59860f = 0;

    /* renamed from: g  reason: collision with root package name */
    public c f59861g;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59862a;

        public final int b(b bVar) {
            if (bVar == null) {
                return 0;
            }
            for (d dVar : this.f59862a) {
                for (d dVar2 : bVar.f59862a) {
                    if (dVar.f59863a == dVar2.f59863a) {
                        return dVar.f59864b - dVar2.f59864b;
                    }
                }
            }
            return 0;
        }

        public b(e eVar, AbsListView absListView, int i2) {
            this.f59862a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = absListView.getChildAt(i3);
                if (childAt != null) {
                    this.f59862a.add(new d(childAt, i2 + i3));
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
        public int f59863a;

        /* renamed from: b  reason: collision with root package name */
        public int f59864b;

        public d(e eVar, View view, int i2) {
            this.f59863a = i2;
            this.f59864b = view.getTop();
            view.getBottom();
        }
    }

    public void a(c cVar) {
        this.f59861g = cVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        c cVar;
        if (absListView == null || i2 < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i2 == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i5 = this.f59860f;
            if (i5 != 0 && (cVar = this.f59861g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f59860f = 0;
            this.f59859e = null;
            return;
        }
        b bVar = new b(absListView, i2);
        b bVar2 = this.f59859e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f59859e = bVar;
            int i6 = this.f59860f + b2;
            this.f59860f = i6;
            c cVar2 = this.f59861g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f59859e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f59860f = paddingTop;
        c cVar3 = this.f59861g;
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
