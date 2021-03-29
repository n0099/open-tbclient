package d.b.i0.c2.o;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoContainerLayout;
import com.baidu.tieba.pb.videopb.VideoZoomBehavior;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f53187a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f53188b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeBackLayout f53189c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f53190d;

    /* renamed from: e  reason: collision with root package name */
    public View f53191e;

    /* renamed from: f  reason: collision with root package name */
    public View f53192f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup.LayoutParams f53193g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.LayoutParams f53194h;
    public View i;
    public Rect j;
    public Rect k;
    public ValueAnimator m;
    public ValueAnimator n;
    public Animator.AnimatorListener o;
    public View[] p;
    public boolean l = true;
    public boolean q = false;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.p(valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            e.this.o();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.o();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e.this.o != null) {
                e.this.o.onAnimationStart(animator);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.n(valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            e.this.m();
            if (e.this.o != null) {
                e.this.o.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.m();
            if (e.this.o != null) {
                e.this.o.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View[] viewArr;
            e.this.f53188b.removeView(e.this.f53191e);
            SkinManager.setBackgroundColor(e.this.f53190d, R.color.CAM_X0201);
            for (View view : e.this.p) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
            }
        }
    }

    public e(FragmentActivity fragmentActivity, View view) {
        this.f53187a = fragmentActivity;
        this.f53192f = view;
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.f53188b = viewGroup;
        this.i = viewGroup.findViewById(R.id.appbar_layout);
        this.f53190d = (ViewGroup) this.f53188b.findViewById(R.id.video_pb_root);
    }

    public final void j() {
        View[] viewArr = new View[3];
        this.p = viewArr;
        viewArr[0] = this.f53188b.findViewById(R.id.pb_video_view_pager);
        this.p[1] = this.f53188b.findViewById(R.id.pb_video_tab_strip);
        this.p[2] = this.f53188b.findViewById(R.id.video_pb_comment_container);
        this.f53188b.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.f53188b.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.f53188b.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.f53188b.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.f53188b.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.f53188b.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.f53188b.getChildAt(0) instanceof SwipeBackLayout) {
            SwipeBackLayout swipeBackLayout = (SwipeBackLayout) this.f53188b.getChildAt(0);
            this.f53189c = swipeBackLayout;
            swipeBackLayout.setBgTransparent();
        }
        View view = new View(this.f53187a);
        this.f53191e = view;
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        this.f53188b.addView(this.f53191e, 0, new ViewGroup.LayoutParams(-1, -1));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.m = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.m.setDuration(300L);
        this.m.addUpdateListener(new a());
        this.m.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n = ofFloat2;
        ofFloat2.setDuration(100L);
        this.n.addUpdateListener(new c());
        this.n.addListener(new d());
    }

    public boolean k() {
        return this.q;
    }

    public boolean l() {
        Rect rect;
        Rect rect2;
        return (!this.l || (rect = this.j) == null || rect.isEmpty() || (rect2 = this.k) == null || rect2.isEmpty()) ? false : true;
    }

    public final void m() {
        this.q = false;
        for (View view : this.p) {
            view.setAlpha(1.0f);
        }
    }

    public final void n(float f2) {
        for (View view : this.p) {
            view.setAlpha(f2);
        }
    }

    public final void o() {
        View view = this.f53191e;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        this.f53192f.setTranslationX(0.0f);
        this.f53192f.setTranslationY(0.0f);
        this.i.setLayoutParams(this.f53193g);
        if (this.i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.i.getLayoutParams()).getBehavior();
            if (behavior instanceof VideoZoomBehavior) {
                View view2 = this.f53192f;
                if (view2 instanceof VideoContainerLayout) {
                    ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) view2).getOriginHeight() - ((VideoContainerLayout) this.f53192f).getMaxHeight());
                }
            }
        }
        this.f53192f.setLayoutParams(this.f53194h);
        this.n.start();
    }

    public final void p(float f2) {
        float width = this.j.width() + ((this.k.width() - this.j.width()) * f2);
        float height = this.j.height() + ((this.k.height() - this.j.height()) * f2);
        Rect rect = this.j;
        int i = rect.left;
        Rect rect2 = this.k;
        int i2 = rect2.left;
        float f3 = i + ((i2 - i) * f2);
        int i3 = rect.top;
        int i4 = rect2.top;
        float f4 = i3 + ((i4 - i3) * f2);
        int i5 = (int) (f3 - i2);
        int i6 = (int) (f4 - i4);
        View view = this.f53191e;
        if (view != null) {
            view.setAlpha(f2);
        }
        this.f53192f.setTranslationX(i5);
        this.f53192f.setTranslationY(i6);
        ViewGroup.LayoutParams layoutParams = this.f53192f.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.f53192f.setLayoutParams(layoutParams);
        }
    }

    public void q(Animator.AnimatorListener animatorListener) {
        this.o = animatorListener;
    }

    public void r(Rect rect, Rect rect2) {
        this.j = rect;
        this.k = rect2;
        if (l()) {
            j();
        }
    }

    public void s() {
        this.l = false;
        this.q = true;
        for (View view : this.p) {
            view.setVisibility(8);
        }
        this.f53193g = this.i.getLayoutParams();
        this.i.setLayoutParams(new CoordinatorLayout.LayoutParams(l.k(TbadkCoreApplication.getInst()), l.i(TbadkCoreApplication.getInst())));
        this.f53194h = this.f53192f.getLayoutParams();
        View view2 = this.f53192f;
        ViewGroup.LayoutParams layoutParams = this.f53194h;
        view2.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
        View view3 = this.f53191e;
        if (view3 != null) {
            view3.setAlpha(0.0f);
        }
        this.m.start();
    }
}
