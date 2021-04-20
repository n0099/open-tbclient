package d.b.c.j.e;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public i f42916a;

    /* renamed from: b  reason: collision with root package name */
    public m f42917b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f42918c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f42919d;

    /* renamed from: e  reason: collision with root package name */
    public float f42920e;

    /* renamed from: f  reason: collision with root package name */
    public float f42921f;

    /* renamed from: g  reason: collision with root package name */
    public int f42922g;

    /* renamed from: h  reason: collision with root package name */
    public int f42923h;
    public int i;
    public d.b.h0.m0.o.a j;
    public RecyclerView.OnChildAttachStateChangeListener k = new a();
    public RecyclerView.OnScrollListener l = new b();
    public RecyclerView.OnItemTouchListener m = new c();

    /* loaded from: classes.dex */
    public class a implements RecyclerView.OnChildAttachStateChangeListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            l.this.r(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            l.this.s(view);
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            l.this.u(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            l.this.t(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public class c implements RecyclerView.OnItemTouchListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                l.this.f42918c.stopScroll();
                l.this.f42920e = motionEvent.getX();
                l.this.f42921f = motionEvent.getY();
                l lVar = l.this;
                View x = lVar.x(lVar.f42920e, l.this.f42921f);
                l lVar2 = l.this;
                lVar2.f42922g = lVar2.f42918c.getChildAdapterPosition(x);
                if (l.this.f42919d == null) {
                    l.this.f42919d = VelocityTracker.obtain();
                }
                l.this.f42919d.addMovement(motionEvent);
                return false;
            }
            if (actionMasked != 2) {
                if (actionMasked == 3 || actionMasked == 1) {
                    l.this.f42920e = 0.0f;
                    l.this.f42921f = 0.0f;
                    l.this.f42919d.clear();
                    return false;
                }
                return false;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int i = (l.this.i == 2 ? y - l.this.f42921f : x2 - l.this.f42920e) >= 0.0f ? 2 : 1;
            if (i != l.this.f42923h) {
                l.this.f42923h = i;
                l.this.f42919d.clear();
            }
            l.this.f42919d.addMovement(motionEvent);
            l.this.f42919d.computeCurrentVelocity(50);
            l lVar3 = l.this;
            lVar3.v(lVar3.f42919d.getXVelocity(), l.this.f42919d.getYVelocity());
            l.this.f42920e = x2;
            l.this.f42921f = y;
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public l(j jVar) {
        this.f42916a = new i(jVar);
        this.f42917b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f42918c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f42918c.removeOnScrollListener(this.l);
            this.f42918c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f42918c = recyclerView;
        this.i = i;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f42917b.e((BdTypeRecyclerView) recyclerView, i);
        } else {
            this.f42916a.e(recyclerView, i);
        }
        this.f42918c.addOnItemTouchListener(this.m);
        this.f42918c.addOnScrollListener(this.l);
        this.f42918c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        if (this.f42918c instanceof BdTypeRecyclerView) {
            this.f42917b.j(view);
        } else {
            this.f42916a.g(view);
        }
    }

    public final void s(View view) {
        if (this.f42918c instanceof BdTypeRecyclerView) {
            this.f42917b.k(view);
        } else {
            this.f42916a.h(view);
        }
    }

    public final void t(int i, int i2) {
        if (this.f42918c instanceof BdTypeRecyclerView) {
            this.f42917b.o(i, i2, this.f42922g);
        }
        this.f42916a.l(i, i2, this.f42922g);
    }

    public final void u(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.j == null) {
                    this.j = new d.b.h0.m0.o.a("anim_switch_slide");
                }
                this.j.b();
            }
        } else if (i == 0 && this.j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.j.c();
        }
        if (this.f42918c instanceof BdTypeRecyclerView) {
            this.f42917b.p(i);
        }
        this.f42916a.m(i);
    }

    public final void v(float f2, float f3) {
        if (this.f42918c instanceof BdTypeRecyclerView) {
            this.f42917b.s(f2, f3, this.f42922g);
        }
        this.f42916a.o(f2, f3, this.f42922g);
    }

    public void w() {
        RecyclerView recyclerView = this.f42918c;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this.m);
            this.f42918c.removeOnScrollListener(this.l);
            this.f42918c.removeOnChildAttachStateChangeListener(this.k);
        }
    }

    public View x(float f2, float f3) {
        RecyclerView recyclerView = this.f42918c;
        if (recyclerView == null) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f42918c.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }
}
