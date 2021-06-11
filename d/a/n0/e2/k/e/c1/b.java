package d.a.n0.e2.k.e.c1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public h f56891a;

    /* renamed from: b  reason: collision with root package name */
    public Animator f56892b;

    /* renamed from: c  reason: collision with root package name */
    public Animator f56893c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f56894d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f56895e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatorSet f56896f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f56897g;

    /* renamed from: h  reason: collision with root package name */
    public View f56898h;

    /* renamed from: i  reason: collision with root package name */
    public View f56899i;
    public View j;
    public View k;
    public int l = UtilHelper.getLightStatusBarHeight();
    public boolean m = false;
    public boolean o = false;
    public int p = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = true;
    public final Handler.Callback v = new a();
    public final Handler w = new Handler(this.v);
    public boolean n = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if ((i2 == 1 || i2 == 2) && b.this.o()) {
                b.this.w.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            int i3 = message.what;
            if (i3 == 1) {
                b.this.D();
                return true;
            } else if (i3 == 2) {
                b.this.C();
                return true;
            } else if (i3 != 3) {
                return false;
            } else {
                b.this.B();
                return true;
            }
        }
    }

    /* renamed from: d.a.n0.e2.k.e.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1320b implements Animator.AnimatorListener {
        public C1320b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f56898h == null) {
                return;
            }
            b.this.f56898h.clearAnimation();
            if (b.this.s) {
                b.this.v(false);
            } else {
                b.this.v(true);
            }
            if (b.this.f56891a != null) {
                b.this.f56891a.a(false);
            }
            b.this.j.clearAnimation();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewGroup.LayoutParams layoutParams = b.this.k.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = b.this.l;
                b.this.k.setLayoutParams(layoutParams);
            }
            b.this.k.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ViewGroup.LayoutParams layoutParams = b.this.k.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
                b.this.k.setLayoutParams(layoutParams);
            }
            b.this.k.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || !(valueAnimator.getAnimatedValue() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = b.this.k.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = num.intValue();
                b.this.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f56898h == null) {
                return;
            }
            b.this.f56898h.clearAnimation();
            b.this.f56898h.setVisibility(0);
            b.this.v(false);
            if (b.this.f56891a != null) {
                b.this.f56891a.a(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.k.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = b.this.k.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
                b.this.k.setLayoutParams(layoutParams);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.k.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = b.this.k.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = b.this.l;
                b.this.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || !(valueAnimator.getAnimatedValue() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = b.this.k.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = num.intValue();
                b.this.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(boolean z);
    }

    public b(Context context, View view, View view2, View view3) {
        this.f56898h = view;
        this.f56899i = view2;
        this.j = view3;
        this.k = view3.findViewById(R.id.sticky_view);
        j();
        v(false);
    }

    public void A(boolean z, boolean z2) {
        View view = this.f56898h;
        if (view == null || view.getY() != 0.0f || o()) {
            return;
        }
        if (z2) {
            this.f56898h.setVisibility(8);
            if (this.s) {
                v(false);
                return;
            } else {
                v(true);
                return;
            }
        }
        this.f56898h.setVisibility(0);
        if (this.f56897g == null) {
            m();
        }
        AnimatorSet animatorSet = this.f56897g;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f56897g.setDuration(300L).start();
        }
    }

    public void B() {
        A(false, true);
    }

    public void C() {
        A(false, false);
    }

    public void D() {
        View view = this.f56898h;
        if (view == null || view.getY() >= 0.0f || o()) {
            return;
        }
        this.f56898h.setVisibility(0);
        if (this.f56896f == null) {
            n();
        }
        AnimatorSet animatorSet = this.f56896f;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f56896f.setDuration(300L).start();
        }
    }

    public boolean i(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    public final void j() {
        View view = this.f56899i;
        if (view == null) {
            return;
        }
        if (this.n && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.f56899i.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.f56899i.setLayoutParams(layoutParams);
            v(true);
            return;
        }
        v(false);
    }

    public void k() {
        this.w.removeCallbacksAndMessages(null);
    }

    public void l() {
        if (this.u) {
            if (this.o) {
                v(true);
            } else if (this.f56898h == null || this.q || this.r || !p()) {
            } else {
                Log.i("PbView", "hideFloatingView: startDragDown");
                y();
            }
        }
    }

    public final void m() {
        View view = this.f56898h;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", (-view.getMeasuredHeight()) + this.j.getMeasuredHeight());
        this.f56892b = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f56892b.addListener(new C1320b());
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.l);
        this.f56895e = ofInt;
        ofInt.setInterpolator(new LinearInterpolator());
        this.f56895e.addListener(new c());
        this.f56895e.addUpdateListener(new d());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f56897g = animatorSet;
        animatorSet.play(this.f56892b).with(this.f56895e);
    }

    public final void n() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f56898h, "translationY", 0.0f);
        this.f56893c = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f56893c.addListener(new e());
        ValueAnimator ofInt = ValueAnimator.ofInt(this.l, 0);
        this.f56894d = ofInt;
        ofInt.setInterpolator(new LinearInterpolator());
        this.f56894d.addListener(new f());
        this.f56894d.addUpdateListener(new g());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f56896f = animatorSet;
        animatorSet.play(this.f56893c).with(this.f56894d);
    }

    public boolean o() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.f56896f;
        return (animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.f56897g) != null && animatorSet.isRunning());
    }

    public boolean p() {
        return this.f56898h.getVisibility() == 0 && this.f56898h.getY() >= 0.0f;
    }

    public void q(AbsListView absListView, int i2, int i3, int i4) {
        if (!this.u || this.f56898h == null || this.q || this.r || !this.m) {
            return;
        }
        if (i2 > this.p && p()) {
            Log.i("PbView", "onScroll hideFloatingView");
            l();
        } else if (i2 < this.p && !p()) {
            Log.i("PbView", "onScroll showFloatingView");
            x();
        }
        this.p = i2;
    }

    public void r(AbsListView absListView, int i2) {
        if (i2 == 1) {
            this.m = true;
        } else if (i2 == 0) {
            this.m = false;
        }
        if (!this.u || this.q || this.r) {
            return;
        }
        if (this.o) {
            v(true);
        } else if (absListView == null || i2 != 0) {
        } else {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            int i3 = this.p;
            if (firstVisiblePosition > i3) {
                y();
                Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
            } else if (firstVisiblePosition < i3) {
                Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                z();
            } else if (firstVisiblePosition == i3) {
                if (firstVisiblePosition != 0 && this.t && !i(absListView)) {
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    y();
                    return;
                }
                Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                z();
            }
        }
    }

    public void s(boolean z) {
        this.r = z;
    }

    public void t(h hVar) {
        this.f56891a = hVar;
    }

    public void u(boolean z) {
        this.t = z;
    }

    public final void v(boolean z) {
        View view = this.f56899i;
        if (view == null) {
            return;
        }
        if (this.n && z && view.getVisibility() != 0) {
            this.f56899i.setVisibility(0);
        } else if (z || this.f56899i.getVisibility() == 8) {
        } else {
            this.f56899i.setVisibility(8);
        }
    }

    public void w(boolean z) {
        this.q = z;
    }

    public void x() {
        if (this.u) {
            if (this.o) {
                v(true);
            } else if (this.f56898h == null || p()) {
            } else {
                Log.i("PbView", "showFloatingView: startDragUp");
                z();
            }
        }
    }

    public void y() {
        this.w.removeMessages(1);
        if (this.w.hasMessages(2)) {
            return;
        }
        this.w.sendEmptyMessageDelayed(2, 110L);
    }

    public void z() {
        this.w.removeMessages(2);
        if (this.w.hasMessages(1)) {
            return;
        }
        this.w.sendEmptyMessageDelayed(1, 60L);
    }
}
