package d.b.i0.x1.h.b;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import d.b.h0.b1.e.a;
import d.b.h0.b1.e.b;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDragSortListView f62464a;

    /* renamed from: b  reason: collision with root package name */
    public final C1665a f62465b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.h0.b1.e.a f62466c;

    /* renamed from: d.b.i0.x1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1665a extends b {
        public int J;
        public int K;
        public ListView L;

        public C1665a(d.b.h0.b1.e.a aVar, ListView listView) {
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
        this.f62464a = simpleDragSortListView;
        d.b.h0.b1.e.a aVar = new d.b.h0.b1.e.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.f62466c = aVar;
        simpleDragSortListView.setDragSortViewEventDelegate(aVar);
        C1665a c1665a = new C1665a(this.f62466c, simpleDragSortListView);
        this.f62465b = c1665a;
        c1665a.d(-1);
        this.f62466c.t0(this.f62465b);
        this.f62466c.v0(this.f62465b);
        simpleDragSortListView.setOnTouchListener(this.f62465b);
    }

    public void a(boolean z) {
        this.f62466c.p0(z);
    }

    public void b(int i, int i2) {
        this.f62465b.y(i, i2);
    }

    public void c(a.i iVar) {
        this.f62466c.u0(iVar);
    }
}
