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
    public i f43079a;

    /* renamed from: b  reason: collision with root package name */
    public m f43080b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f43081c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f43082d;

    /* renamed from: e  reason: collision with root package name */
    public float f43083e;

    /* renamed from: f  reason: collision with root package name */
    public float f43084f;

    /* renamed from: g  reason: collision with root package name */
    public int f43085g;

    /* renamed from: h  reason: collision with root package name */
    public int f43086h;

    /* renamed from: i  reason: collision with root package name */
    public int f43087i;
    public d.a.n0.m0.o.a j;
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
                l.this.f43081c.stopScroll();
                l.this.f43083e = motionEvent.getX();
                l.this.f43084f = motionEvent.getY();
                l lVar = l.this;
                View x = lVar.x(lVar.f43083e, l.this.f43084f);
                l lVar2 = l.this;
                lVar2.f43085g = lVar2.f43081c.getChildAdapterPosition(x);
                if (l.this.f43082d == null) {
                    l.this.f43082d = VelocityTracker.obtain();
                }
                l.this.f43082d.addMovement(motionEvent);
                return false;
            }
            if (actionMasked != 2) {
                if (actionMasked == 3 || actionMasked == 1) {
                    l.this.f43083e = 0.0f;
                    l.this.f43084f = 0.0f;
                    l.this.f43082d.clear();
                    return false;
                }
                return false;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int i2 = (l.this.f43087i == 2 ? y - l.this.f43084f : x2 - l.this.f43083e) >= 0.0f ? 2 : 1;
            if (i2 != l.this.f43086h) {
                l.this.f43086h = i2;
                l.this.f43082d.clear();
            }
            l.this.f43082d.addMovement(motionEvent);
            l.this.f43082d.computeCurrentVelocity(50);
            l lVar3 = l.this;
            lVar3.v(lVar3.f43082d.getXVelocity(), l.this.f43082d.getYVelocity());
            l.this.f43083e = x2;
            l.this.f43084f = y;
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
        this.f43079a = new i(jVar);
        this.f43080b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i2) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f43081c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f43081c.removeOnScrollListener(this.l);
            this.f43081c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f43081c = recyclerView;
        this.f43087i = i2;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f43080b.e((BdTypeRecyclerView) recyclerView, i2);
        } else {
            this.f43079a.e(recyclerView, i2);
        }
        this.f43081c.addOnItemTouchListener(this.m);
        this.f43081c.addOnScrollListener(this.l);
        this.f43081c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        if (this.f43081c instanceof BdTypeRecyclerView) {
            this.f43080b.j(view);
        } else {
            this.f43079a.g(view);
        }
    }

    public final void s(View view) {
        if (this.f43081c instanceof BdTypeRecyclerView) {
            this.f43080b.k(view);
        } else {
            this.f43079a.h(view);
        }
    }

    public final void t(int i2, int i3) {
        if (this.f43081c instanceof BdTypeRecyclerView) {
            this.f43080b.o(i2, i3, this.f43085g);
        }
        this.f43079a.l(i2, i3, this.f43085g);
    }

    public final void u(int i2) {
        if (i2 == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.j == null) {
                    this.j = new d.a.n0.m0.o.a("anim_switch_slide");
                }
                this.j.b();
            }
        } else if (i2 == 0 && this.j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.j.c();
        }
        if (this.f43081c instanceof BdTypeRecyclerView) {
            this.f43080b.p(i2);
        }
        this.f43079a.m(i2);
    }

    public final void v(float f2, float f3) {
        if (this.f43081c instanceof BdTypeRecyclerView) {
            this.f43080b.s(f2, f3, this.f43085g);
        }
        this.f43079a.o(f2, f3, this.f43085g);
    }

    public void w() {
        RecyclerView recyclerView = this.f43081c;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this.m);
            this.f43081c.removeOnScrollListener(this.l);
            this.f43081c.removeOnChildAttachStateChangeListener(this.k);
        }
    }

    public View x(float f2, float f3) {
        RecyclerView recyclerView = this.f43081c;
        if (recyclerView == null) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f43081c.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }
}
