package d.a.c.k.e;

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
    public RecyclerView f42952a;

    /* renamed from: b  reason: collision with root package name */
    public j f42953b;

    /* renamed from: c  reason: collision with root package name */
    public int f42954c;

    /* renamed from: e  reason: collision with root package name */
    public int f42956e;

    /* renamed from: f  reason: collision with root package name */
    public float f42957f;

    /* renamed from: g  reason: collision with root package name */
    public float f42958g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42959h = false;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f42955d = new SparseIntArray();

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ValueAnimator> f42960i = new SparseArray<>();
    public SparseIntArray j = new SparseIntArray();

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f42961e;

        public a(View view) {
            this.f42961e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.this.n(this.f42961e, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f42964f;

        public b(int i2, View view) {
            this.f42963e = i2;
            this.f42964f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.this.f42960i.delete(this.f42963e);
            i.this.j.delete(this.f42963e);
            i.this.n(this.f42964f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.f42960i.delete(this.f42963e);
            i.this.j.delete(this.f42963e);
            i.this.f42955d.delete(this.f42963e);
            i.this.n(this.f42964f, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public i(j jVar) {
        this.f42953b = jVar;
    }

    public void e(RecyclerView recyclerView, int i2) {
        this.f42952a = recyclerView;
        this.f42954c = i2;
    }

    public final float f(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.f42954c == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    public void g(View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.f42952a;
        if (recyclerView3 == null || this.f42956e == 0) {
            return;
        }
        int childAdapterPosition = recyclerView3.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = this.f42952a.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                float f2 = -this.f42955d.get(childAdapterPosition, 0);
                if (f2 != 0.0f) {
                    this.f42957f = f2;
                } else {
                    f2 = this.f42957f;
                }
                n(view, f2 + (this.f42952a.getChildAt(1) != null ? f(this.f42952a.getChildAt(1)) : 0.0f));
            } else {
                float f3 = -this.f42955d.get(childAdapterPosition, 0);
                if (f3 != 0.0f) {
                    this.f42958g = f3;
                } else {
                    f3 = this.f42958g;
                }
                if (this.f42952a.getChildAt(recyclerView.getChildCount() - 2) != null) {
                    r3 = f(this.f42952a.getChildAt(recyclerView2.getChildCount() - 2));
                }
                n(view, f3 + r3);
            }
            j(view, childAdapterPosition);
        }
    }

    public void h(View view) {
        if (this.f42952a == null) {
            return;
        }
        n(view, 0.0f);
        int childAdapterPosition = this.f42952a.getChildAdapterPosition(view);
        this.f42955d.delete(childAdapterPosition);
        if (this.f42960i.get(childAdapterPosition) != null) {
            this.f42960i.get(childAdapterPosition).cancel();
        }
        this.f42960i.delete(childAdapterPosition);
        this.j.delete(childAdapterPosition);
    }

    public final void i(View view, float f2, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        if (f2 < 0.0f) {
            if (i2 < i3) {
                float f3 = f(view) + (f2 * this.f42953b.l());
                if (f3 > (-this.f42955d.get(i2)) + f(this.f42952a.getChildAt(i4 + 1))) {
                    n(view, f3);
                } else {
                    j(view, i2);
                }
            } else if (i2 > i3) {
                float f4 = f(view) + (f2 * this.f42953b.e());
                if (f4 > (-this.f42955d.get(i2)) + f(this.f42952a.getChildAt(i4 - 1))) {
                    n(view, f4);
                } else {
                    j(view, i2);
                }
            }
        } else if (i2 > i3) {
            float f5 = f(view) + (f2 * this.f42953b.l());
            if (f5 < (-this.f42955d.get(i2)) + f(this.f42952a.getChildAt(i4 - 1))) {
                n(view, f5);
            } else {
                j(view, i2);
            }
        } else if (i2 < i3) {
            float f6 = f(view) + (f2 * this.f42953b.e());
            if (f6 < (-this.f42955d.get(i2)) + f(this.f42952a.getChildAt(i4 + 1))) {
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
        ValueAnimator valueAnimator = this.f42960i.get(i2);
        if (valueAnimator == null) {
            if (Math.abs(f(view)) < 0.1f) {
                n(view, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f42953b.a());
            ofFloat.addUpdateListener(new a(view));
            ofFloat.addListener(new b(i2, view));
            this.f42960i.append(i2, ofFloat);
            this.j.append(i2, (int) f(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float f2 = f(view);
        if (Math.abs(f2) > Math.abs(this.j.get(i2)) + this.f42953b.b()) {
            this.j.append(i2, (int) f2);
            valueAnimator.setFloatValues(f2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void k() {
        int childCount = this.f42952a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f42952a.getChildAt(i2);
            j(childAt, this.f42952a.getChildAdapterPosition(childAt));
        }
    }

    public void l(int i2, int i3, int i4) {
        if (this.f42952a == null || this.f42956e != 1 || this.f42959h) {
            return;
        }
        if (this.f42954c == 2) {
            i2 = i3;
        }
        int childCount = this.f42952a.getChildCount();
        if (this.f42952a.getLayoutManager() instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = i4 - ((LinearLayoutManager) this.f42952a.getLayoutManager()).findFirstVisibleItemPosition();
            for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                View childAt = this.f42952a.getChildAt(i5);
                int childAdapterPosition = this.f42952a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    i(childAt, i2, childAdapterPosition, i4, i5);
                }
            }
            for (int i6 = findFirstVisibleItemPosition + 1; i6 <= childCount - 1; i6++) {
                View childAt2 = this.f42952a.getChildAt(i6);
                int childAdapterPosition2 = this.f42952a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1) {
                    i(childAt2, i2, childAdapterPosition2, i4, i6);
                }
            }
        }
    }

    public void m(int i2) {
        if (this.f42952a == null) {
            return;
        }
        this.f42956e = i2;
        if (i2 == 0) {
            this.f42955d.clear();
            k();
        } else if (i2 == 2) {
            k();
        } else if (i2 == 1) {
            this.f42955d.clear();
            k();
        }
    }

    public final void n(View view, float f2) {
        if (view == null) {
            return;
        }
        if (this.f42954c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void o(float f2, float f3, int i2) {
        if (this.f42952a == null) {
            return;
        }
        if (this.f42954c == 2) {
            f2 = f3;
        }
        int i3 = 1;
        if (Math.abs(f2) < this.f42953b.i()) {
            this.f42959h = true;
            k();
            return;
        }
        this.f42959h = false;
        if (Math.abs(f2) > this.f42953b.h()) {
            f2 = f2 > 0.0f ? this.f42953b.h() : -this.f42953b.h();
        }
        this.f42955d.clear();
        float f4 = this.f42953b.f() * f2;
        if (f2 < 0.0f) {
            float g2 = this.f42953b.g();
            int i4 = 1;
            while (true) {
                int i5 = i2 - i4;
                float f5 = (i4 * g2) + f4;
                g2 *= 1.4f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f42953b.c()) + this.f42955d.get(i5);
                if (Math.abs(c2) > this.f42953b.d()) {
                    c2 = -this.f42953b.d();
                }
                this.f42955d.append(i5, (int) c2);
                i4++;
            }
            float g3 = this.f42953b.g();
            while (true) {
                int i6 = i2 + i3;
                float f6 = (i3 * g3) + f4;
                g3 *= 1.4f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f42953b.j()) + this.f42955d.get(i6);
                if (Math.abs(j) > this.f42953b.k()) {
                    j = -this.f42953b.k();
                }
                this.f42955d.append(i6, (int) j);
                i3++;
            }
        } else {
            float g4 = this.f42953b.g();
            int i7 = 1;
            while (true) {
                int i8 = i2 - i7;
                float f7 = f4 - (i7 * g4);
                g4 *= 1.4f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f42953b.j()) + this.f42955d.get(i8);
                if (Math.abs(j2) > this.f42953b.k()) {
                    j2 = this.f42953b.k();
                }
                this.f42955d.append(i8, (int) j2);
                i7++;
            }
            float g5 = this.f42953b.g();
            while (true) {
                int i9 = i2 + i3;
                float f8 = f4 - (i3 * g5);
                g5 *= 1.4f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f42953b.c()) + this.f42955d.get(i9);
                if (Math.abs(c3) > this.f42953b.d()) {
                    c3 = this.f42953b.d();
                }
                this.f42955d.append(i9, (int) c3);
                i3++;
            }
        }
    }
}
