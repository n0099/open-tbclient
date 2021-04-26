package d.a.c.j.e;

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
    public RecyclerView f40362a;

    /* renamed from: b  reason: collision with root package name */
    public j f40363b;

    /* renamed from: c  reason: collision with root package name */
    public int f40364c;

    /* renamed from: e  reason: collision with root package name */
    public int f40366e;

    /* renamed from: f  reason: collision with root package name */
    public float f40367f;

    /* renamed from: g  reason: collision with root package name */
    public float f40368g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40369h = false;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f40365d = new SparseIntArray();

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ValueAnimator> f40370i = new SparseArray<>();
    public SparseIntArray j = new SparseIntArray();

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f40371e;

        public a(View view) {
            this.f40371e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.this.n(this.f40371e, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f40373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f40374f;

        public b(int i2, View view) {
            this.f40373e = i2;
            this.f40374f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.this.f40370i.delete(this.f40373e);
            i.this.j.delete(this.f40373e);
            i.this.n(this.f40374f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.f40370i.delete(this.f40373e);
            i.this.j.delete(this.f40373e);
            i.this.f40365d.delete(this.f40373e);
            i.this.n(this.f40374f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public i(j jVar) {
        this.f40363b = jVar;
    }

    public void e(RecyclerView recyclerView, int i2) {
        this.f40362a = recyclerView;
        this.f40364c = i2;
    }

    public final float f(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.f40364c == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    public void g(View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.f40362a;
        if (recyclerView3 == null || this.f40366e == 0) {
            return;
        }
        int childAdapterPosition = recyclerView3.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = this.f40362a.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                float f2 = -this.f40365d.get(childAdapterPosition, 0);
                if (f2 != 0.0f) {
                    this.f40367f = f2;
                } else {
                    f2 = this.f40367f;
                }
                n(view, f2 + (this.f40362a.getChildAt(1) != null ? f(this.f40362a.getChildAt(1)) : 0.0f));
            } else {
                float f3 = -this.f40365d.get(childAdapterPosition, 0);
                if (f3 != 0.0f) {
                    this.f40368g = f3;
                } else {
                    f3 = this.f40368g;
                }
                if (this.f40362a.getChildAt(recyclerView.getChildCount() - 2) != null) {
                    r3 = f(this.f40362a.getChildAt(recyclerView2.getChildCount() - 2));
                }
                n(view, f3 + r3);
            }
            j(view, childAdapterPosition);
        }
    }

    public void h(View view) {
        if (this.f40362a == null) {
            return;
        }
        n(view, 0.0f);
        int childAdapterPosition = this.f40362a.getChildAdapterPosition(view);
        this.f40365d.delete(childAdapterPosition);
        if (this.f40370i.get(childAdapterPosition) != null) {
            this.f40370i.get(childAdapterPosition).cancel();
        }
        this.f40370i.delete(childAdapterPosition);
        this.j.delete(childAdapterPosition);
    }

    public final void i(View view, float f2, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        if (f2 < 0.0f) {
            if (i2 < i3) {
                float f3 = f(view) + (f2 * this.f40363b.l());
                if (f3 > (-this.f40365d.get(i2)) + f(this.f40362a.getChildAt(i4 + 1))) {
                    n(view, f3);
                } else {
                    j(view, i2);
                }
            } else if (i2 > i3) {
                float f4 = f(view) + (f2 * this.f40363b.e());
                if (f4 > (-this.f40365d.get(i2)) + f(this.f40362a.getChildAt(i4 - 1))) {
                    n(view, f4);
                } else {
                    j(view, i2);
                }
            }
        } else if (i2 > i3) {
            float f5 = f(view) + (f2 * this.f40363b.l());
            if (f5 < (-this.f40365d.get(i2)) + f(this.f40362a.getChildAt(i4 - 1))) {
                n(view, f5);
            } else {
                j(view, i2);
            }
        } else if (i2 < i3) {
            float f6 = f(view) + (f2 * this.f40363b.e());
            if (f6 < (-this.f40365d.get(i2)) + f(this.f40362a.getChildAt(i4 + 1))) {
                n(view, f6);
            } else {
                j(view, i2);
            }
        }
    }

    public final void j(View view, int i2) {
        if (view == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f40370i.get(i2);
        if (valueAnimator == null) {
            if (Math.abs(f(view)) < 0.1f) {
                n(view, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f40363b.a());
            ofFloat.addUpdateListener(new a(view));
            ofFloat.addListener(new b(i2, view));
            this.f40370i.append(i2, ofFloat);
            this.j.append(i2, (int) f(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float f2 = f(view);
        if (Math.abs(f2) > Math.abs(this.j.get(i2)) + this.f40363b.b()) {
            this.j.append(i2, (int) f2);
            valueAnimator.setFloatValues(f2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void k() {
        int childCount = this.f40362a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f40362a.getChildAt(i2);
            j(childAt, this.f40362a.getChildAdapterPosition(childAt));
        }
    }

    public void l(int i2, int i3, int i4) {
        if (this.f40362a == null || this.f40366e != 1 || this.f40369h) {
            return;
        }
        if (this.f40364c == 2) {
            i2 = i3;
        }
        int childCount = this.f40362a.getChildCount();
        if (this.f40362a.getLayoutManager() instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = i4 - ((LinearLayoutManager) this.f40362a.getLayoutManager()).findFirstVisibleItemPosition();
            for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                View childAt = this.f40362a.getChildAt(i5);
                int childAdapterPosition = this.f40362a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    i(childAt, i2, childAdapterPosition, i4, i5);
                }
            }
            for (int i6 = findFirstVisibleItemPosition + 1; i6 <= childCount - 1; i6++) {
                View childAt2 = this.f40362a.getChildAt(i6);
                int childAdapterPosition2 = this.f40362a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1) {
                    i(childAt2, i2, childAdapterPosition2, i4, i6);
                }
            }
        }
    }

    public void m(int i2) {
        if (this.f40362a == null) {
            return;
        }
        this.f40366e = i2;
        if (i2 == 0) {
            this.f40365d.clear();
            k();
        } else if (i2 == 2) {
            k();
        } else if (i2 == 1) {
            this.f40365d.clear();
            k();
        }
    }

    public final void n(View view, float f2) {
        if (view == null) {
            return;
        }
        if (this.f40364c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void o(float f2, float f3, int i2) {
        if (this.f40362a == null) {
            return;
        }
        if (this.f40364c == 2) {
            f2 = f3;
        }
        int i3 = 1;
        if (Math.abs(f2) < this.f40363b.i()) {
            this.f40369h = true;
            k();
            return;
        }
        this.f40369h = false;
        if (Math.abs(f2) > this.f40363b.h()) {
            f2 = f2 > 0.0f ? this.f40363b.h() : -this.f40363b.h();
        }
        this.f40365d.clear();
        float f4 = this.f40363b.f() * f2;
        if (f2 < 0.0f) {
            float g2 = this.f40363b.g();
            int i4 = 1;
            while (true) {
                int i5 = i2 - i4;
                float f5 = (i4 * g2) + f4;
                g2 *= 1.4f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f40363b.c()) + this.f40365d.get(i5);
                if (Math.abs(c2) > this.f40363b.d()) {
                    c2 = -this.f40363b.d();
                }
                this.f40365d.append(i5, (int) c2);
                i4++;
            }
            float g3 = this.f40363b.g();
            while (true) {
                int i6 = i2 + i3;
                float f6 = (i3 * g3) + f4;
                g3 *= 1.4f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f40363b.j()) + this.f40365d.get(i6);
                if (Math.abs(j) > this.f40363b.k()) {
                    j = -this.f40363b.k();
                }
                this.f40365d.append(i6, (int) j);
                i3++;
            }
        } else {
            float g4 = this.f40363b.g();
            int i7 = 1;
            while (true) {
                int i8 = i2 - i7;
                float f7 = f4 - (i7 * g4);
                g4 *= 1.4f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f40363b.j()) + this.f40365d.get(i8);
                if (Math.abs(j2) > this.f40363b.k()) {
                    j2 = this.f40363b.k();
                }
                this.f40365d.append(i8, (int) j2);
                i7++;
            }
            float g5 = this.f40363b.g();
            while (true) {
                int i9 = i2 + i3;
                float f8 = f4 - (i3 * g5);
                g5 *= 1.4f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f40363b.c()) + this.f40365d.get(i9);
                if (Math.abs(c3) > this.f40363b.d()) {
                    c3 = this.f40363b.d();
                }
                this.f40365d.append(i9, (int) c3);
                i3++;
            }
        }
    }
}
