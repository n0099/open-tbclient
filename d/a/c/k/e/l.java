package d.a.c.k.e;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public i f42976a;

    /* renamed from: b  reason: collision with root package name */
    public m f42977b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f42978c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f42979d;

    /* renamed from: e  reason: collision with root package name */
    public float f42980e;

    /* renamed from: f  reason: collision with root package name */
    public float f42981f;

    /* renamed from: g  reason: collision with root package name */
    public int f42982g;

    /* renamed from: h  reason: collision with root package name */
    public int f42983h;

    /* renamed from: i  reason: collision with root package name */
    public int f42984i;
    public d.a.m0.m0.o.a j;
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
                l.this.f42978c.stopScroll();
                l.this.f42980e = motionEvent.getX();
                l.this.f42981f = motionEvent.getY();
                l lVar = l.this;
                View x = lVar.x(lVar.f42980e, l.this.f42981f);
                l lVar2 = l.this;
                lVar2.f42982g = lVar2.f42978c.getChildAdapterPosition(x);
                if (l.this.f42979d == null) {
                    l.this.f42979d = VelocityTracker.obtain();
                }
                l.this.f42979d.addMovement(motionEvent);
                return false;
            }
            if (actionMasked != 2) {
                if (actionMasked == 3 || actionMasked == 1) {
                    l.this.f42980e = 0.0f;
                    l.this.f42981f = 0.0f;
                    l.this.f42979d.clear();
                    return false;
                }
                return false;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int i2 = (l.this.f42984i == 2 ? y - l.this.f42981f : x2 - l.this.f42980e) >= 0.0f ? 2 : 1;
            if (i2 != l.this.f42983h) {
                l.this.f42983h = i2;
                l.this.f42979d.clear();
            }
            l.this.f42979d.addMovement(motionEvent);
            l.this.f42979d.computeCurrentVelocity(50);
            l lVar3 = l.this;
            lVar3.v(lVar3.f42979d.getXVelocity(), l.this.f42979d.getYVelocity());
            l.this.f42980e = x2;
            l.this.f42981f = y;
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
        this.f42976a = new i(jVar);
        this.f42977b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i2) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f42978c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f42978c.removeOnScrollListener(this.l);
            this.f42978c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f42978c = recyclerView;
        this.f42984i = i2;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f42977b.e((BdTypeRecyclerView) recyclerView, i2);
        } else {
            this.f42976a.e(recyclerView, i2);
        }
        this.f42978c.addOnItemTouchListener(this.m);
        this.f42978c.addOnScrollListener(this.l);
        this.f42978c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        if (this.f42978c instanceof BdTypeRecyclerView) {
            this.f42977b.j(view);
        } else {
            this.f42976a.g(view);
        }
    }

    public final void s(View view) {
        if (this.f42978c instanceof BdTypeRecyclerView) {
            this.f42977b.k(view);
        } else {
            this.f42976a.h(view);
        }
    }

    public final void t(int i2, int i3) {
        if (this.f42978c instanceof BdTypeRecyclerView) {
            this.f42977b.o(i2, i3, this.f42982g);
        }
        this.f42976a.l(i2, i3, this.f42982g);
    }

    public final void u(int i2) {
        if (i2 == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.j == null) {
                    this.j = new d.a.m0.m0.o.a("anim_switch_slide");
                }
                this.j.b();
            }
        } else if (i2 == 0 && this.j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.j.c();
        }
        if (this.f42978c instanceof BdTypeRecyclerView) {
            this.f42977b.p(i2);
        }
        this.f42976a.m(i2);
    }

    public final void v(float f2, float f3) {
        if (this.f42978c instanceof BdTypeRecyclerView) {
            this.f42977b.s(f2, f3, this.f42982g);
        }
        this.f42976a.o(f2, f3, this.f42982g);
    }

    public void w() {
        RecyclerView recyclerView = this.f42978c;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this.m);
            this.f42978c.removeOnScrollListener(this.l);
            this.f42978c.removeOnChildAttachStateChangeListener(this.k);
        }
    }

    public View x(float f2, float f3) {
        RecyclerView recyclerView = this.f42978c;
        if (recyclerView == null) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f42978c.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }
}
