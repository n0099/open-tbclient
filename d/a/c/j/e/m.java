package d.a.c.j.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashSet;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f40398a;

    /* renamed from: b  reason: collision with root package name */
    public j f40399b;

    /* renamed from: c  reason: collision with root package name */
    public int f40400c;

    /* renamed from: e  reason: collision with root package name */
    public int f40402e;

    /* renamed from: f  reason: collision with root package name */
    public float f40403f;

    /* renamed from: g  reason: collision with root package name */
    public float f40404g;
    public LinearLayoutManager k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40405h = false;
    public HashSet<Integer> l = new HashSet<>();
    public HashSet<Integer> m = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f40401d = new SparseIntArray();

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ValueAnimator> f40406i = new SparseArray<>();
    public SparseIntArray j = new SparseIntArray();

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f40407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40408f;

        public a(View view, int i2) {
            this.f40407e = view;
            this.f40408f = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m.this.q(this.f40407e, this.f40408f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f40410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f40411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40412g;

        public b(int i2, View view, int i3) {
            this.f40410e = i2;
            this.f40411f = view;
            this.f40412g = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            m.this.f40406i.delete(this.f40410e);
            m.this.j.delete(this.f40410e);
            m.this.q(this.f40411f, this.f40412g, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.f40406i.delete(this.f40410e);
            m.this.j.delete(this.f40410e);
            m.this.f40401d.delete(this.f40410e);
            m.this.q(this.f40411f, this.f40412g, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public m(j jVar) {
        this.f40399b = jVar;
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        this.f40398a = bdTypeRecyclerView;
        this.f40400c = i2;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        this.k = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
    }

    public final float f(int i2, int i3, boolean z) {
        if (z) {
            return i(this.f40398a.getChildAt(g(i2 + 1, i3, true)));
        }
        return i(this.f40398a.getChildAt(g(i2 - 1, i3, false)));
    }

    public final int g(int i2, int i3, boolean z) {
        int i4 = 1;
        if (!z) {
            while (i4 < i3) {
                int i5 = i3 - i4;
                if (i2 == h(i5)) {
                    return i5;
                }
                i4++;
            }
            return -1;
        }
        int count = this.f40398a.getCount() - i3;
        while (i4 < count) {
            int i6 = i3 + i4;
            if (i2 == h(i6)) {
                return i6;
            }
            i4++;
        }
        return -1;
    }

    public final int h(int i2) {
        if (i2 > 0) {
            n B = this.f40398a.B(i2 - this.f40398a.getHeaderViewsCount());
            if (B instanceof BaseCardInfo) {
                return ((BaseCardInfo) B).position;
            }
            return -1;
        }
        return -1;
    }

    public final float i(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.f40400c == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    public void j(View view) {
        int childAdapterPosition;
        int h2;
        BdTypeRecyclerView bdTypeRecyclerView;
        float f2;
        BdTypeRecyclerView bdTypeRecyclerView2;
        BdTypeRecyclerView bdTypeRecyclerView3 = this.f40398a;
        if (bdTypeRecyclerView3 == null || this.k == null || this.f40402e == 0 || (h2 = h((childAdapterPosition = bdTypeRecyclerView3.getChildAdapterPosition(view)))) < 0) {
            return;
        }
        if (childAdapterPosition <= this.k.findFirstVisibleItemPosition()) {
            float i2 = this.f40398a.getChildAt(1) != null ? i(this.f40398a.getChildAt(1)) : 0.0f;
            int h3 = h(childAdapterPosition + 1);
            if (h3 < 0) {
                return;
            }
            if (h3 == h2) {
                r(view, i2);
            } else {
                float f3 = -this.f40401d.get(h2, 0);
                if (f3 != 0.0f) {
                    this.f40403f = f3;
                } else {
                    f3 = this.f40403f;
                }
                r(view, f3 + i2);
            }
        } else {
            if (this.f40398a.getChildAt(bdTypeRecyclerView.getChildCount() - 2) != null) {
                f2 = i(this.f40398a.getChildAt(bdTypeRecyclerView2.getChildCount() - 2));
            } else {
                f2 = 0.0f;
            }
            int h4 = h(childAdapterPosition - 1);
            if (h4 < 0) {
                return;
            }
            if (h4 == h2) {
                r(view, f2);
            } else {
                float f4 = -this.f40401d.get(h2, 0);
                if (f4 != 0.0f) {
                    this.f40404g = f4;
                } else {
                    f4 = this.f40404g;
                }
                r(view, f4 + f2);
            }
        }
        m(view, childAdapterPosition);
    }

    public void k(View view) {
        if (this.f40398a == null) {
            return;
        }
        r(view, 0.0f);
        int h2 = h(this.f40398a.getChildAdapterPosition(view));
        if (h2 >= 0 && g(h2, 0, true) == -1) {
            this.f40401d.delete(h2);
            if (this.f40406i.get(h2) != null) {
                this.f40406i.get(h2).cancel();
            }
            this.f40406i.delete(h2);
            this.j.delete(h2);
        }
    }

    public final void l(View view, int i2, int i3, int i4, int i5) {
        if (view == null) {
            return;
        }
        if (i2 < 0) {
            if (i3 < i4) {
                float i6 = i(view) + (i2 * this.f40399b.l());
                if (i6 > (-this.f40401d.get(i5)) + f(i5, i3, true)) {
                    q(view, i3, i6);
                } else {
                    m(view, i3);
                }
            } else if (i3 > i4) {
                float i7 = i(view) + (i2 * this.f40399b.e());
                if (i7 > (-this.f40401d.get(i5)) + f(i5, i3, false)) {
                    q(view, i3, i7);
                } else {
                    m(view, i3);
                }
            }
        } else if (i3 > i4) {
            float i8 = i(view) + (i2 * this.f40399b.l());
            if (i8 < (-this.f40401d.get(i5)) + f(i5, i3, false)) {
                q(view, i3, i8);
            } else {
                m(view, i3);
            }
        } else if (i3 < i4) {
            float i9 = i(view) + (i2 * this.f40399b.e());
            if (i9 < (-this.f40401d.get(i5)) + f(i5, i3, true)) {
                q(view, i3, i9);
            } else {
                m(view, i3);
            }
        }
    }

    public final void m(View view, int i2) {
        int h2;
        if (view != null && (h2 = h(i2)) >= 0) {
            ValueAnimator valueAnimator = this.f40406i.get(h2);
            if (valueAnimator == null) {
                if (Math.abs(i(view)) < 0.1f) {
                    q(view, i2, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(i(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.f40399b.a());
                ofFloat.addUpdateListener(new a(view, i2));
                ofFloat.addListener(new b(h2, view, i2));
                this.f40406i.append(h2, ofFloat);
                this.j.append(h2, (int) i(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float i3 = i(view);
            if (Math.abs(i3) > Math.abs(this.j.get(h2)) + this.f40399b.b()) {
                this.j.append(h2, (int) i3);
                valueAnimator.setFloatValues(i3, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public final void n() {
        int childCount = this.f40398a.getChildCount();
        this.m.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f40398a.getChildAt(i2);
            int childAdapterPosition = this.f40398a.getChildAdapterPosition(childAt);
            int h2 = h(childAdapterPosition);
            if (h2 >= 0 && !this.m.contains(Integer.valueOf(h2))) {
                this.m.add(Integer.valueOf(h2));
                m(childAt, childAdapterPosition);
            }
        }
    }

    public void o(int i2, int i3, int i4) {
        LinearLayoutManager linearLayoutManager;
        int h2;
        int h3;
        if (this.f40398a == null || (linearLayoutManager = this.k) == null || this.f40402e != 1 || this.f40405h) {
            return;
        }
        int findFirstVisibleItemPosition = i4 - linearLayoutManager.findFirstVisibleItemPosition();
        int h4 = h(i4);
        if (h4 < 0) {
            return;
        }
        this.l.add(Integer.valueOf(h4));
        if (this.f40400c == 2) {
            i2 = i3;
        }
        int childCount = this.f40398a.getChildCount();
        for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
            View childAt = this.f40398a.getChildAt(i5);
            int childAdapterPosition = this.f40398a.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && (h3 = h(childAdapterPosition)) >= 0 && !this.l.contains(Integer.valueOf(h3))) {
                this.l.add(Integer.valueOf(h3));
                l(childAt, i2, childAdapterPosition, i4, h3);
            }
        }
        for (int i6 = findFirstVisibleItemPosition + 1; i6 <= childCount - 1; i6++) {
            View childAt2 = this.f40398a.getChildAt(i6);
            int childAdapterPosition2 = this.f40398a.getChildAdapterPosition(childAt2);
            if (childAdapterPosition2 != -1 && (h2 = h(childAdapterPosition2)) >= 0 && !this.l.contains(Integer.valueOf(h2))) {
                this.l.add(Integer.valueOf(h2));
                l(childAt2, i2, childAdapterPosition2, i4, h2);
            }
        }
    }

    public void p(int i2) {
        if (this.f40398a == null) {
            return;
        }
        this.f40402e = i2;
        if (i2 == 0) {
            this.f40401d.clear();
            n();
        } else if (i2 == 2) {
            n();
        } else if (i2 == 1) {
            this.f40401d.clear();
            n();
        }
    }

    public final void q(View view, int i2, float f2) {
        if (view == null) {
            return;
        }
        if (this.f40400c == 2) {
            CardLinkageManager.INSTANCE.translationY(this.f40398a, i2, f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public final void r(View view, float f2) {
        if (view == null) {
            return;
        }
        if (this.f40400c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void s(float f2, float f3, int i2) {
        if (this.f40398a == null) {
            return;
        }
        if (this.f40400c == 2) {
            f2 = f3;
        }
        int i3 = 1;
        if (Math.abs(f2) < this.f40399b.i()) {
            this.f40405h = true;
            n();
            return;
        }
        this.f40405h = false;
        if (Math.abs(f2) > this.f40399b.h()) {
            f2 = f2 > 0.0f ? this.f40399b.h() : -this.f40399b.h();
        }
        this.f40401d.clear();
        float f4 = this.f40399b.f() * f2;
        int h2 = h(i2);
        if (h2 < 0) {
            return;
        }
        if (f2 < 0.0f) {
            float g2 = this.f40399b.g();
            int i4 = 1;
            while (true) {
                int i5 = h2 - i4;
                float f5 = (i4 * g2) + f4;
                g2 *= 1.2f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f40399b.c()) + this.f40401d.get(i5);
                if (Math.abs(c2) > this.f40399b.d()) {
                    c2 = -this.f40399b.d();
                }
                this.f40401d.append(i5, (int) c2);
                i4++;
            }
            float g3 = this.f40399b.g();
            while (true) {
                int i6 = h2 + i3;
                float f6 = (i3 * g3) + f4;
                g3 *= 1.2f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f40399b.j()) + this.f40401d.get(i6);
                if (Math.abs(j) > this.f40399b.k()) {
                    j = -this.f40399b.k();
                }
                this.f40401d.append(i6, (int) j);
                i3++;
            }
        } else {
            float g4 = this.f40399b.g();
            int i7 = 1;
            while (true) {
                int i8 = h2 - i7;
                float f7 = f4 - (i7 * g4);
                g4 *= 1.2f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f40399b.j()) + this.f40401d.get(i8);
                if (Math.abs(j2) > this.f40399b.k()) {
                    j2 = this.f40399b.k();
                }
                this.f40401d.append(i8, (int) j2);
                i7++;
            }
            float g5 = this.f40399b.g();
            while (true) {
                int i9 = h2 + i3;
                float f8 = f4 - (i3 * g5);
                g5 *= 1.2f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f40399b.c()) + this.f40401d.get(i9);
                if (Math.abs(c3) > this.f40399b.d()) {
                    c3 = this.f40399b.d();
                }
                this.f40401d.append(i9, (int) c3);
                i3++;
            }
        }
    }
}
