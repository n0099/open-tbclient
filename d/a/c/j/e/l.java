package d.a.c.j.e;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public i f40386a;

    /* renamed from: b  reason: collision with root package name */
    public m f40387b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f40388c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f40389d;

    /* renamed from: e  reason: collision with root package name */
    public float f40390e;

    /* renamed from: f  reason: collision with root package name */
    public float f40391f;

    /* renamed from: g  reason: collision with root package name */
    public int f40392g;

    /* renamed from: h  reason: collision with root package name */
    public int f40393h;

    /* renamed from: i  reason: collision with root package name */
    public int f40394i;
    public d.a.i0.m0.o.a j;
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
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            l.this.u(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            l.this.t(i2, i3);
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
                l.this.f40388c.stopScroll();
                l.this.f40390e = motionEvent.getX();
                l.this.f40391f = motionEvent.getY();
                l lVar = l.this;
                View x = lVar.x(lVar.f40390e, l.this.f40391f);
                l lVar2 = l.this;
                lVar2.f40392g = lVar2.f40388c.getChildAdapterPosition(x);
                if (l.this.f40389d == null) {
                    l.this.f40389d = VelocityTracker.obtain();
                }
                l.this.f40389d.addMovement(motionEvent);
                return false;
            }
            if (actionMasked != 2) {
                if (actionMasked == 3 || actionMasked == 1) {
                    l.this.f40390e = 0.0f;
                    l.this.f40391f = 0.0f;
                    l.this.f40389d.clear();
                    return false;
                }
                return false;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int i2 = (l.this.f40394i == 2 ? y - l.this.f40391f : x2 - l.this.f40390e) >= 0.0f ? 2 : 1;
            if (i2 != l.this.f40393h) {
                l.this.f40393h = i2;
                l.this.f40389d.clear();
            }
            l.this.f40389d.addMovement(motionEvent);
            l.this.f40389d.computeCurrentVelocity(50);
            l lVar3 = l.this;
            lVar3.v(lVar3.f40389d.getXVelocity(), l.this.f40389d.getYVelocity());
            l.this.f40390e = x2;
            l.this.f40391f = y;
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
        this.f40386a = new i(jVar);
        this.f40387b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i2) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f40388c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f40388c.removeOnScrollListener(this.l);
            this.f40388c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f40388c = recyclerView;
        this.f40394i = i2;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f40387b.e((BdTypeRecyclerView) recyclerView, i2);
        } else {
            this.f40386a.e(recyclerView, i2);
        }
        this.f40388c.addOnItemTouchListener(this.m);
        this.f40388c.addOnScrollListener(this.l);
        this.f40388c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        if (this.f40388c instanceof BdTypeRecyclerView) {
            this.f40387b.j(view);
        } else {
            this.f40386a.g(view);
        }
    }

    public final void s(View view) {
        if (this.f40388c instanceof BdTypeRecyclerView) {
            this.f40387b.k(view);
        } else {
            this.f40386a.h(view);
        }
    }

    public final void t(int i2, int i3) {
        if (this.f40388c instanceof BdTypeRecyclerView) {
            this.f40387b.o(i2, i3, this.f40392g);
        }
        this.f40386a.l(i2, i3, this.f40392g);
    }

    public final void u(int i2) {
        if (i2 == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.j == null) {
                    this.j = new d.a.i0.m0.o.a("anim_switch_slide");
                }
                this.j.b();
            }
        } else if (i2 == 0 && this.j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.j.c();
        }
        if (this.f40388c instanceof BdTypeRecyclerView) {
            this.f40387b.p(i2);
        }
        this.f40386a.m(i2);
    }

    public final void v(float f2, float f3) {
        if (this.f40388c instanceof BdTypeRecyclerView) {
            this.f40387b.s(f2, f3, this.f40392g);
        }
        this.f40386a.o(f2, f3, this.f40392g);
    }

    public void w() {
        RecyclerView recyclerView = this.f40388c;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this.m);
            this.f40388c.removeOnScrollListener(this.l);
            this.f40388c.removeOnChildAttachStateChangeListener(this.k);
        }
    }

    public View x(float f2, float f3) {
        RecyclerView recyclerView = this.f40388c;
        if (recyclerView == null) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f40388c.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }
}
