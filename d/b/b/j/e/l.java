package d.b.b.j.e;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public i f42419a;

    /* renamed from: b  reason: collision with root package name */
    public m f42420b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f42421c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f42422d;

    /* renamed from: e  reason: collision with root package name */
    public float f42423e;

    /* renamed from: f  reason: collision with root package name */
    public float f42424f;

    /* renamed from: g  reason: collision with root package name */
    public int f42425g;

    /* renamed from: h  reason: collision with root package name */
    public int f42426h;
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
                l.this.f42421c.stopScroll();
                l.this.f42423e = motionEvent.getX();
                l.this.f42424f = motionEvent.getY();
                l lVar = l.this;
                View x = lVar.x(lVar.f42423e, l.this.f42424f);
                l lVar2 = l.this;
                lVar2.f42425g = lVar2.f42421c.getChildAdapterPosition(x);
                if (l.this.f42422d == null) {
                    l.this.f42422d = VelocityTracker.obtain();
                }
                l.this.f42422d.addMovement(motionEvent);
                return false;
            }
            if (actionMasked != 2) {
                if (actionMasked == 3 || actionMasked == 1) {
                    l.this.f42423e = 0.0f;
                    l.this.f42424f = 0.0f;
                    l.this.f42422d.clear();
                    return false;
                }
                return false;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int i = (l.this.i == 2 ? y - l.this.f42424f : x2 - l.this.f42423e) >= 0.0f ? 2 : 1;
            if (i != l.this.f42426h) {
                l.this.f42426h = i;
                l.this.f42422d.clear();
            }
            l.this.f42422d.addMovement(motionEvent);
            l.this.f42422d.computeCurrentVelocity(50);
            l lVar3 = l.this;
            lVar3.v(lVar3.f42422d.getXVelocity(), l.this.f42422d.getYVelocity());
            l.this.f42423e = x2;
            l.this.f42424f = y;
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
        this.f42419a = new i(jVar);
        this.f42420b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f42421c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f42421c.removeOnScrollListener(this.l);
            this.f42421c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f42421c = recyclerView;
        this.i = i;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f42420b.e((BdTypeRecyclerView) recyclerView, i);
        } else {
            this.f42419a.e(recyclerView, i);
        }
        this.f42421c.addOnItemTouchListener(this.m);
        this.f42421c.addOnScrollListener(this.l);
        this.f42421c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        if (this.f42421c instanceof BdTypeRecyclerView) {
            this.f42420b.j(view);
        } else {
            this.f42419a.g(view);
        }
    }

    public final void s(View view) {
        if (this.f42421c instanceof BdTypeRecyclerView) {
            this.f42420b.k(view);
        } else {
            this.f42419a.h(view);
        }
    }

    public final void t(int i, int i2) {
        if (this.f42421c instanceof BdTypeRecyclerView) {
            this.f42420b.o(i, i2, this.f42425g);
        }
        this.f42419a.l(i, i2, this.f42425g);
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
        if (this.f42421c instanceof BdTypeRecyclerView) {
            this.f42420b.p(i);
        }
        this.f42419a.m(i);
    }

    public final void v(float f2, float f3) {
        if (this.f42421c instanceof BdTypeRecyclerView) {
            this.f42420b.s(f2, f3, this.f42425g);
        }
        this.f42419a.o(f2, f3, this.f42425g);
    }

    public void w() {
        RecyclerView recyclerView = this.f42421c;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this.m);
            this.f42421c.removeOnScrollListener(this.l);
            this.f42421c.removeOnChildAttachStateChangeListener(this.k);
        }
    }

    public View x(float f2, float f3) {
        RecyclerView recyclerView = this.f42421c;
        if (recyclerView == null) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f42421c.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }
}
