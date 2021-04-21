package d.b.c.j.e;

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
    public BdTypeRecyclerView f43167a;

    /* renamed from: b  reason: collision with root package name */
    public j f43168b;

    /* renamed from: c  reason: collision with root package name */
    public int f43169c;

    /* renamed from: e  reason: collision with root package name */
    public int f43171e;

    /* renamed from: f  reason: collision with root package name */
    public float f43172f;

    /* renamed from: g  reason: collision with root package name */
    public float f43173g;
    public LinearLayoutManager k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43174h = false;
    public HashSet<Integer> l = new HashSet<>();
    public HashSet<Integer> m = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f43170d = new SparseIntArray();
    public SparseArray<ValueAnimator> i = new SparseArray<>();
    public SparseIntArray j = new SparseIntArray();

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43175e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43176f;

        public a(View view, int i) {
            this.f43175e = view;
            this.f43176f = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m.this.q(this.f43175e, this.f43176f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43178e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f43179f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43180g;

        public b(int i, View view, int i2) {
            this.f43178e = i;
            this.f43179f = view;
            this.f43180g = i2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            m.this.i.delete(this.f43178e);
            m.this.j.delete(this.f43178e);
            m.this.q(this.f43179f, this.f43180g, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.i.delete(this.f43178e);
            m.this.j.delete(this.f43178e);
            m.this.f43170d.delete(this.f43178e);
            m.this.q(this.f43179f, this.f43180g, 0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public m(j jVar) {
        this.f43168b = jVar;
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.f43167a = bdTypeRecyclerView;
        this.f43169c = i;
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        this.k = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
    }

    public final float f(int i, int i2, boolean z) {
        if (z) {
            return i(this.f43167a.getChildAt(g(i + 1, i2, true)));
        }
        return i(this.f43167a.getChildAt(g(i - 1, i2, false)));
    }

    public final int g(int i, int i2, boolean z) {
        int i3 = 1;
        if (!z) {
            while (i3 < i2) {
                int i4 = i2 - i3;
                if (i == h(i4)) {
                    return i4;
                }
                i3++;
            }
            return -1;
        }
        int count = this.f43167a.getCount() - i2;
        while (i3 < count) {
            int i5 = i2 + i3;
            if (i == h(i5)) {
                return i5;
            }
            i3++;
        }
        return -1;
    }

    public final int h(int i) {
        if (i > 0) {
            n B = this.f43167a.B(i - this.f43167a.getHeaderViewsCount());
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
        return this.f43169c == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    public void j(View view) {
        int childAdapterPosition;
        int h2;
        BdTypeRecyclerView bdTypeRecyclerView;
        float f2;
        BdTypeRecyclerView bdTypeRecyclerView2;
        BdTypeRecyclerView bdTypeRecyclerView3 = this.f43167a;
        if (bdTypeRecyclerView3 == null || this.k == null || this.f43171e == 0 || (h2 = h((childAdapterPosition = bdTypeRecyclerView3.getChildAdapterPosition(view)))) < 0) {
            return;
        }
        if (childAdapterPosition <= this.k.findFirstVisibleItemPosition()) {
            float i = this.f43167a.getChildAt(1) != null ? i(this.f43167a.getChildAt(1)) : 0.0f;
            int h3 = h(childAdapterPosition + 1);
            if (h3 < 0) {
                return;
            }
            if (h3 == h2) {
                r(view, i);
            } else {
                float f3 = -this.f43170d.get(h2, 0);
                if (f3 != 0.0f) {
                    this.f43172f = f3;
                } else {
                    f3 = this.f43172f;
                }
                r(view, f3 + i);
            }
        } else {
            if (this.f43167a.getChildAt(bdTypeRecyclerView.getChildCount() - 2) != null) {
                f2 = i(this.f43167a.getChildAt(bdTypeRecyclerView2.getChildCount() - 2));
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
                float f4 = -this.f43170d.get(h2, 0);
                if (f4 != 0.0f) {
                    this.f43173g = f4;
                } else {
                    f4 = this.f43173g;
                }
                r(view, f4 + f2);
            }
        }
        m(view, childAdapterPosition);
    }

    public void k(View view) {
        if (this.f43167a == null) {
            return;
        }
        r(view, 0.0f);
        int h2 = h(this.f43167a.getChildAdapterPosition(view));
        if (h2 >= 0 && g(h2, 0, true) == -1) {
            this.f43170d.delete(h2);
            if (this.i.get(h2) != null) {
                this.i.get(h2).cancel();
            }
            this.i.delete(h2);
            this.j.delete(h2);
        }
    }

    public final void l(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        if (i < 0) {
            if (i2 < i3) {
                float i5 = i(view) + (i * this.f43168b.l());
                if (i5 > (-this.f43170d.get(i4)) + f(i4, i2, true)) {
                    q(view, i2, i5);
                } else {
                    m(view, i2);
                }
            } else if (i2 > i3) {
                float i6 = i(view) + (i * this.f43168b.e());
                if (i6 > (-this.f43170d.get(i4)) + f(i4, i2, false)) {
                    q(view, i2, i6);
                } else {
                    m(view, i2);
                }
            }
        } else if (i2 > i3) {
            float i7 = i(view) + (i * this.f43168b.l());
            if (i7 < (-this.f43170d.get(i4)) + f(i4, i2, false)) {
                q(view, i2, i7);
            } else {
                m(view, i2);
            }
        } else if (i2 < i3) {
            float i8 = i(view) + (i * this.f43168b.e());
            if (i8 < (-this.f43170d.get(i4)) + f(i4, i2, true)) {
                q(view, i2, i8);
            } else {
                m(view, i2);
            }
        }
    }

    public final void m(View view, int i) {
        int h2;
        if (view != null && (h2 = h(i)) >= 0) {
            ValueAnimator valueAnimator = this.i.get(h2);
            if (valueAnimator == null) {
                if (Math.abs(i(view)) < 0.1f) {
                    q(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(i(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.f43168b.a());
                ofFloat.addUpdateListener(new a(view, i));
                ofFloat.addListener(new b(h2, view, i));
                this.i.append(h2, ofFloat);
                this.j.append(h2, (int) i(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float i2 = i(view);
            if (Math.abs(i2) > Math.abs(this.j.get(h2)) + this.f43168b.b()) {
                this.j.append(h2, (int) i2);
                valueAnimator.setFloatValues(i2, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public final void n() {
        int childCount = this.f43167a.getChildCount();
        this.m.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f43167a.getChildAt(i);
            int childAdapterPosition = this.f43167a.getChildAdapterPosition(childAt);
            int h2 = h(childAdapterPosition);
            if (h2 >= 0 && !this.m.contains(Integer.valueOf(h2))) {
                this.m.add(Integer.valueOf(h2));
                m(childAt, childAdapterPosition);
            }
        }
    }

    public void o(int i, int i2, int i3) {
        LinearLayoutManager linearLayoutManager;
        int h2;
        int h3;
        if (this.f43167a == null || (linearLayoutManager = this.k) == null || this.f43171e != 1 || this.f43174h) {
            return;
        }
        int findFirstVisibleItemPosition = i3 - linearLayoutManager.findFirstVisibleItemPosition();
        int h4 = h(i3);
        if (h4 < 0) {
            return;
        }
        this.l.add(Integer.valueOf(h4));
        if (this.f43169c == 2) {
            i = i2;
        }
        int childCount = this.f43167a.getChildCount();
        for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
            View childAt = this.f43167a.getChildAt(i4);
            int childAdapterPosition = this.f43167a.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && (h3 = h(childAdapterPosition)) >= 0 && !this.l.contains(Integer.valueOf(h3))) {
                this.l.add(Integer.valueOf(h3));
                l(childAt, i, childAdapterPosition, i3, h3);
            }
        }
        for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
            View childAt2 = this.f43167a.getChildAt(i5);
            int childAdapterPosition2 = this.f43167a.getChildAdapterPosition(childAt2);
            if (childAdapterPosition2 != -1 && (h2 = h(childAdapterPosition2)) >= 0 && !this.l.contains(Integer.valueOf(h2))) {
                this.l.add(Integer.valueOf(h2));
                l(childAt2, i, childAdapterPosition2, i3, h2);
            }
        }
    }

    public void p(int i) {
        if (this.f43167a == null) {
            return;
        }
        this.f43171e = i;
        if (i == 0) {
            this.f43170d.clear();
            n();
        } else if (i == 2) {
            n();
        } else if (i == 1) {
            this.f43170d.clear();
            n();
        }
    }

    public final void q(View view, int i, float f2) {
        if (view == null) {
            return;
        }
        if (this.f43169c == 2) {
            CardLinkageManager.INSTANCE.translationY(this.f43167a, i, f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public final void r(View view, float f2) {
        if (view == null) {
            return;
        }
        if (this.f43169c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void s(float f2, float f3, int i) {
        if (this.f43167a == null) {
            return;
        }
        if (this.f43169c == 2) {
            f2 = f3;
        }
        int i2 = 1;
        if (Math.abs(f2) < this.f43168b.i()) {
            this.f43174h = true;
            n();
            return;
        }
        this.f43174h = false;
        if (Math.abs(f2) > this.f43168b.h()) {
            f2 = f2 > 0.0f ? this.f43168b.h() : -this.f43168b.h();
        }
        this.f43170d.clear();
        float f4 = this.f43168b.f() * f2;
        int h2 = h(i);
        if (h2 < 0) {
            return;
        }
        if (f2 < 0.0f) {
            float g2 = this.f43168b.g();
            int i3 = 1;
            while (true) {
                int i4 = h2 - i3;
                float f5 = (i3 * g2) + f4;
                g2 *= 1.2f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f43168b.c()) + this.f43170d.get(i4);
                if (Math.abs(c2) > this.f43168b.d()) {
                    c2 = -this.f43168b.d();
                }
                this.f43170d.append(i4, (int) c2);
                i3++;
            }
            float g3 = this.f43168b.g();
            while (true) {
                int i5 = h2 + i2;
                float f6 = (i2 * g3) + f4;
                g3 *= 1.2f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f43168b.j()) + this.f43170d.get(i5);
                if (Math.abs(j) > this.f43168b.k()) {
                    j = -this.f43168b.k();
                }
                this.f43170d.append(i5, (int) j);
                i2++;
            }
        } else {
            float g4 = this.f43168b.g();
            int i6 = 1;
            while (true) {
                int i7 = h2 - i6;
                float f7 = f4 - (i6 * g4);
                g4 *= 1.2f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f43168b.j()) + this.f43170d.get(i7);
                if (Math.abs(j2) > this.f43168b.k()) {
                    j2 = this.f43168b.k();
                }
                this.f43170d.append(i7, (int) j2);
                i6++;
            }
            float g5 = this.f43168b.g();
            while (true) {
                int i8 = h2 + i2;
                float f8 = f4 - (i2 * g5);
                g5 *= 1.2f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f43168b.c()) + this.f43170d.get(i8);
                if (Math.abs(c3) > this.f43168b.d()) {
                    c3 = this.f43168b.d();
                }
                this.f43170d.append(i8, (int) c3);
                i2++;
            }
        }
    }
}
