package d.b.i0.x1.h.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import d.b.h0.b1.e.a;
import d.b.h0.b1.e.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDragSortListView f62465a;

    /* renamed from: b  reason: collision with root package name */
    public final C1666a f62466b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.h0.b1.e.a f62467c;

    /* renamed from: d.b.i0.x1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1666a extends b {
        public int J;
        public int K;
        public ListView L;

        public C1666a(d.b.h0.b1.e.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.J = 0;
            this.K = Integer.MAX_VALUE;
            r(false);
            this.L = listView;
        }

        @Override // d.b.h0.b1.e.e, d.b.h0.b1.e.a.j
        public void a(View view) {
        }

        @Override // d.b.h0.b1.e.b, d.b.h0.b1.e.a.j
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

        @Override // d.b.h0.b1.e.b
        public int v(MotionEvent motionEvent) {
            int n = super.n(motionEvent);
            int headerViewsCount = n - this.L.getHeaderViewsCount();
            if (headerViewsCount < this.J || headerViewsCount >= this.K) {
                return -1;
            }
            return n;
        }

        public void y(int i, int i2) {
            this.J = i;
            this.K = i2;
        }
    }

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.f62465a = simpleDragSortListView;
        d.b.h0.b1.e.a aVar = new d.b.h0.b1.e.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.f62467c = aVar;
        simpleDragSortListView.setDragSortViewEventDelegate(aVar);
        C1666a c1666a = new C1666a(this.f62467c, simpleDragSortListView);
        this.f62466b = c1666a;
        c1666a.d(-1);
        this.f62467c.t0(this.f62466b);
        this.f62467c.v0(this.f62466b);
        simpleDragSortListView.setOnTouchListener(this.f62466b);
    }

    public void a(boolean z) {
        this.f62467c.p0(z);
    }

    public void b(int i, int i2) {
        this.f62466b.y(i, i2);
    }

    public void c(a.i iVar) {
        this.f62467c.u0(iVar);
    }
}
