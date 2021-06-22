package d.a.o0.z1.h.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import d.a.n0.b1.e.a;
import d.a.n0.b1.e.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDragSortListView f67582a;

    /* renamed from: b  reason: collision with root package name */
    public final C1827a f67583b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.b1.e.a f67584c;

    /* renamed from: d.a.o0.z1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1827a extends b {
        public int J;
        public int K;
        public ListView L;

        public C1827a(d.a.n0.b1.e.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.J = 0;
            this.K = Integer.MAX_VALUE;
            r(false);
            this.L = listView;
        }

        @Override // d.a.n0.b1.e.e, d.a.n0.b1.e.a.j
        public void a(View view) {
        }

        @Override // d.a.n0.b1.e.b, d.a.n0.b1.e.a.j
        public void c(View view, Point point, Point point2) {
            int top;
            int top2;
            int firstVisiblePosition = this.L.getFirstVisiblePosition();
            int dividerHeight = this.L.getDividerHeight();
            int headerViewsCount = (this.J - firstVisiblePosition) + this.L.getHeaderViewsCount();
            int headerViewsCount2 = (this.K - firstVisiblePosition) + this.L.getHeaderViewsCount();
            int childCount = this.L.getChildCount();
            View view2 = null;
            View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.L.getChildAt(headerViewsCount);
            if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                view2 = this.L.getChildAt(headerViewsCount2);
            }
            if (childAt != null && point.y < (top2 = childAt.getTop())) {
                point.y = top2;
            }
            if (view2 == null || point.y <= (top = (view2.getTop() - dividerHeight) - view.getHeight())) {
                return;
            }
            point.y = top;
        }

        @Override // d.a.n0.b1.e.b
        public int v(MotionEvent motionEvent) {
            int n = super.n(motionEvent);
            int headerViewsCount = n - this.L.getHeaderViewsCount();
            if (headerViewsCount < this.J || headerViewsCount >= this.K) {
                return -1;
            }
            return n;
        }

        public void y(int i2, int i3) {
            this.J = i2;
            this.K = i3;
        }
    }

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.f67582a = simpleDragSortListView;
        d.a.n0.b1.e.a aVar = new d.a.n0.b1.e.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.f67584c = aVar;
        simpleDragSortListView.setDragSortViewEventDelegate(aVar);
        C1827a c1827a = new C1827a(this.f67584c, simpleDragSortListView);
        this.f67583b = c1827a;
        c1827a.d(-1);
        this.f67584c.s0(this.f67583b);
        this.f67584c.u0(this.f67583b);
        simpleDragSortListView.setOnTouchListener(this.f67583b);
    }

    public void a(boolean z) {
        this.f67584c.o0(z);
    }

    public void b(int i2, int i3) {
        this.f67583b.y(i2, i3);
    }

    public void c(a.i iVar) {
        this.f67584c.t0(iVar);
    }
}
