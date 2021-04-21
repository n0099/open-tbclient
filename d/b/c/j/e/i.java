package d.b.c.j.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f43134a;

    /* renamed from: b  reason: collision with root package name */
    public j f43135b;

    /* renamed from: c  reason: collision with root package name */
    public int f43136c;

    /* renamed from: e  reason: collision with root package name */
    public int f43138e;

    /* renamed from: f  reason: collision with root package name */
    public float f43139f;

    /* renamed from: g  reason: collision with root package name */
    public float f43140g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43141h = false;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f43137d = new SparseIntArray();
    public SparseArray<ValueAnimator> i = new SparseArray<>();
    public SparseIntArray j = new SparseIntArray();

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43142e;

        public a(View view) {
            this.f43142e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.this.n(this.f43142e, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f43145f;

        public b(int i, View view) {
            this.f43144e = i;
            this.f43145f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.this.i.delete(this.f43144e);
            i.this.j.delete(this.f43144e);
            i.this.n(this.f43145f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.i.delete(this.f43144e);
            i.this.j.delete(this.f43144e);
            i.this.f43137d.delete(this.f43144e);
            i.this.n(this.f43145f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public i(j jVar) {
        this.f43135b = jVar;
    }

    public void e(RecyclerView recyclerView, int i) {
        this.f43134a = recyclerView;
        this.f43136c = i;
    }

    public final float f(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.f43136c == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    public void g(View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.f43134a;
        if (recyclerView3 == null || this.f43138e == 0) {
            return;
        }
        int childAdapterPosition = recyclerView3.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = this.f43134a.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                float f2 = -this.f43137d.get(childAdapterPosition, 0);
                if (f2 != 0.0f) {
                    this.f43139f = f2;
                } else {
                    f2 = this.f43139f;
                }
                n(view, f2 + (this.f43134a.getChildAt(1) != null ? f(this.f43134a.getChildAt(1)) : 0.0f));
            } else {
                float f3 = -this.f43137d.get(childAdapterPosition, 0);
                if (f3 != 0.0f) {
                    this.f43140g = f3;
                } else {
                    f3 = this.f43140g;
                }
                if (this.f43134a.getChildAt(recyclerView.getChildCount() - 2) != null) {
                    r3 = f(this.f43134a.getChildAt(recyclerView2.getChildCount() - 2));
                }
                n(view, f3 + r3);
            }
            j(view, childAdapterPosition);
        }
    }

    public void h(View view) {
        if (this.f43134a == null) {
            return;
        }
        n(view, 0.0f);
        int childAdapterPosition = this.f43134a.getChildAdapterPosition(view);
        this.f43137d.delete(childAdapterPosition);
        if (this.i.get(childAdapterPosition) != null) {
            this.i.get(childAdapterPosition).cancel();
        }
        this.i.delete(childAdapterPosition);
        this.j.delete(childAdapterPosition);
    }

    public final void i(View view, float f2, int i, int i2, int i3) {
        if (view == null) {
            return;
        }
        if (f2 < 0.0f) {
            if (i < i2) {
                float f3 = f(view) + (f2 * this.f43135b.l());
                if (f3 > (-this.f43137d.get(i)) + f(this.f43134a.getChildAt(i3 + 1))) {
                    n(view, f3);
                } else {
                    j(view, i);
                }
            } else if (i > i2) {
                float f4 = f(view) + (f2 * this.f43135b.e());
                if (f4 > (-this.f43137d.get(i)) + f(this.f43134a.getChildAt(i3 - 1))) {
                    n(view, f4);
                } else {
                    j(view, i);
                }
            }
        } else if (i > i2) {
            float f5 = f(view) + (f2 * this.f43135b.l());
            if (f5 < (-this.f43137d.get(i)) + f(this.f43134a.getChildAt(i3 - 1))) {
                n(view, f5);
            } else {
                j(view, i);
            }
        } else if (i < i2) {
            float f6 = f(view) + (f2 * this.f43135b.e());
            if (f6 < (-this.f43137d.get(i)) + f(this.f43134a.getChildAt(i3 + 1))) {
                n(view, f6);
            } else {
                j(view, i);
            }
        }
    }

    public final void j(View view, int i) {
        if (view == null) {
            return;
        }
        ValueAnimator valueAnimator = this.i.get(i);
        if (valueAnimator == null) {
            if (Math.abs(f(view)) < 0.1f) {
                n(view, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f43135b.a());
            ofFloat.addUpdateListener(new a(view));
            ofFloat.addListener(new b(i, view));
            this.i.append(i, ofFloat);
            this.j.append(i, (int) f(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float f2 = f(view);
        if (Math.abs(f2) > Math.abs(this.j.get(i)) + this.f43135b.b()) {
            this.j.append(i, (int) f2);
            valueAnimator.setFloatValues(f2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void k() {
        int childCount = this.f43134a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f43134a.getChildAt(i);
            j(childAt, this.f43134a.getChildAdapterPosition(childAt));
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.f43134a == null || this.f43138e != 1 || this.f43141h) {
            return;
        }
        if (this.f43136c == 2) {
            i = i2;
        }
        int childCount = this.f43134a.getChildCount();
        if (this.f43134a.getLayoutManager() instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = i3 - ((LinearLayoutManager) this.f43134a.getLayoutManager()).findFirstVisibleItemPosition();
            for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
                View childAt = this.f43134a.getChildAt(i4);
                int childAdapterPosition = this.f43134a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    i(childAt, i, childAdapterPosition, i3, i4);
                }
            }
            for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
                View childAt2 = this.f43134a.getChildAt(i5);
                int childAdapterPosition2 = this.f43134a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1) {
                    i(childAt2, i, childAdapterPosition2, i3, i5);
                }
            }
        }
    }

    public void m(int i) {
        if (this.f43134a == null) {
            return;
        }
        this.f43138e = i;
        if (i == 0) {
            this.f43137d.clear();
            k();
        } else if (i == 2) {
            k();
        } else if (i == 1) {
            this.f43137d.clear();
            k();
        }
    }

    public final void n(View view, float f2) {
        if (view == null) {
            return;
        }
        if (this.f43136c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void o(float f2, float f3, int i) {
        if (this.f43134a == null) {
            return;
        }
        if (this.f43136c == 2) {
            f2 = f3;
        }
        int i2 = 1;
        if (Math.abs(f2) < this.f43135b.i()) {
            this.f43141h = true;
            k();
            return;
        }
        this.f43141h = false;
        if (Math.abs(f2) > this.f43135b.h()) {
            f2 = f2 > 0.0f ? this.f43135b.h() : -this.f43135b.h();
        }
        this.f43137d.clear();
        float f4 = this.f43135b.f() * f2;
        if (f2 < 0.0f) {
            float g2 = this.f43135b.g();
            int i3 = 1;
            while (true) {
                int i4 = i - i3;
                float f5 = (i3 * g2) + f4;
                g2 *= 1.4f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f43135b.c()) + this.f43137d.get(i4);
                if (Math.abs(c2) > this.f43135b.d()) {
                    c2 = -this.f43135b.d();
                }
                this.f43137d.append(i4, (int) c2);
                i3++;
            }
            float g3 = this.f43135b.g();
            while (true) {
                int i5 = i + i2;
                float f6 = (i2 * g3) + f4;
                g3 *= 1.4f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f43135b.j()) + this.f43137d.get(i5);
                if (Math.abs(j) > this.f43135b.k()) {
                    j = -this.f43135b.k();
                }
                this.f43137d.append(i5, (int) j);
                i2++;
            }
        } else {
            float g4 = this.f43135b.g();
            int i6 = 1;
            while (true) {
                int i7 = i - i6;
                float f7 = f4 - (i6 * g4);
                g4 *= 1.4f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f43135b.j()) + this.f43137d.get(i7);
                if (Math.abs(j2) > this.f43135b.k()) {
                    j2 = this.f43135b.k();
                }
                this.f43137d.append(i7, (int) j2);
                i6++;
            }
            float g5 = this.f43135b.g();
            while (true) {
                int i8 = i + i2;
                float f8 = f4 - (i2 * g5);
                g5 *= 1.4f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f43135b.c()) + this.f43137d.get(i8);
                if (Math.abs(c3) > this.f43135b.d()) {
                    c3 = this.f43135b.d();
                }
                this.f43137d.append(i8, (int) c3);
                i2++;
            }
        }
    }
}
