package d.a.j0.d2.o;

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
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f52858a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f52859b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeBackLayout f52860c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52861d;

    /* renamed from: e  reason: collision with root package name */
    public View f52862e;

    /* renamed from: f  reason: collision with root package name */
    public View f52863f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup.LayoutParams f52864g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.LayoutParams f52865h;

    /* renamed from: i  reason: collision with root package name */
    public View f52866i;
    public Rect j;
    public Rect k;
    public ValueAnimator m;
    public ValueAnimator n;
    public Animator.AnimatorListener o;
    public View[] p;
    public boolean l = true;
    public boolean q = false;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l.this.p(valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            l.this.o();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.o();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (l.this.o != null) {
                l.this.o.onAnimationStart(animator);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l.this.n(valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            l.this.m();
            if (l.this.o != null) {
                l.this.o.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.m();
            if (l.this.o != null) {
                l.this.o.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View[] viewArr;
            l.this.f52859b.removeView(l.this.f52862e);
            SkinManager.setBackgroundColor(l.this.f52861d, R.color.CAM_X0201);
            for (View view : l.this.p) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
            }
        }
    }

    public l(FragmentActivity fragmentActivity, View view) {
        this.f52858a = fragmentActivity;
        this.f52863f = view;
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.f52859b = viewGroup;
        this.f52866i = viewGroup.findViewById(R.id.appbar_layout);
        this.f52861d = (ViewGroup) this.f52859b.findViewById(R.id.video_pb_root);
    }

    public final void j() {
        View[] viewArr = new View[3];
        this.p = viewArr;
        viewArr[0] = this.f52859b.findViewById(R.id.pb_video_view_pager);
        this.p[1] = this.f52859b.findViewById(R.id.pb_video_tab_strip);
        this.p[2] = this.f52859b.findViewById(R.id.video_pb_comment_container);
        this.f52859b.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.f52859b.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.f52859b.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.f52859b.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.f52859b.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.f52859b.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.f52859b.getChildAt(0) instanceof SwipeBackLayout) {
            SwipeBackLayout swipeBackLayout = (SwipeBackLayout) this.f52859b.getChildAt(0);
            this.f52860c = swipeBackLayout;
            swipeBackLayout.setBgTransparent();
        }
        View view = new View(this.f52858a);
        this.f52862e = view;
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        this.f52859b.addView(this.f52862e, 0, new ViewGroup.LayoutParams(-1, -1));
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
        View view = this.f52862e;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        this.f52863f.setTranslationX(0.0f);
        this.f52863f.setTranslationY(0.0f);
        this.f52866i.setLayoutParams(this.f52864g);
        if (this.f52866i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.f52866i.getLayoutParams()).getBehavior();
            if (behavior instanceof VideoZoomBehavior) {
                View view2 = this.f52863f;
                if (view2 instanceof VideoContainerLayout) {
                    ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) view2).getOriginHeight() - ((VideoContainerLayout) this.f52863f).getMaxHeight());
                }
            }
        }
        this.f52863f.setLayoutParams(this.f52865h);
        this.n.start();
    }

    public final void p(float f2) {
        float width = this.j.width() + ((this.k.width() - this.j.width()) * f2);
        float height = this.j.height() + ((this.k.height() - this.j.height()) * f2);
        Rect rect = this.j;
        int i2 = rect.left;
        Rect rect2 = this.k;
        int i3 = rect2.left;
        float f3 = i2 + ((i3 - i2) * f2);
        int i4 = rect.top;
        int i5 = rect2.top;
        float f4 = i4 + ((i5 - i4) * f2);
        int i6 = (int) (f3 - i3);
        int i7 = (int) (f4 - i5);
        View view = this.f52862e;
        if (view != null) {
            view.setAlpha(f2);
        }
        this.f52863f.setTranslationX(i6);
        this.f52863f.setTranslationY(i7);
        ViewGroup.LayoutParams layoutParams = this.f52863f.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.f52863f.setLayoutParams(layoutParams);
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
        this.f52864g = this.f52866i.getLayoutParams();
        this.f52866i.setLayoutParams(new CoordinatorLayout.LayoutParams(d.a.c.e.p.l.k(TbadkCoreApplication.getInst()), d.a.c.e.p.l.i(TbadkCoreApplication.getInst())));
        this.f52865h = this.f52863f.getLayoutParams();
        View view2 = this.f52863f;
        ViewGroup.LayoutParams layoutParams = this.f52865h;
        view2.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
        View view3 = this.f52862e;
        if (view3 != null) {
            view3.setAlpha(0.0f);
        }
        this.m.start();
    }
}
