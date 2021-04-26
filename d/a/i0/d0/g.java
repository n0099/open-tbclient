package d.a.i0.d0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends d.a.i0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public ContinuousAnimationView f48406a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f48407b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f48408c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f48409d;

    /* renamed from: e  reason: collision with root package name */
    public int f48410e;

    /* renamed from: f  reason: collision with root package name */
    public final int f48411f;

    /* renamed from: g  reason: collision with root package name */
    public int f48412g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f48413h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48414i;
    public ValueAnimator.AnimatorUpdateListener j;
    public final Animator.AnimatorListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.isViewAttached()) {
                TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.f48413h);
                return;
            }
            g.this.f48408c.setText(g.this.f48407b[g.this.k()]);
            TbadkCoreApplication.getInst().handler.postDelayed(g.this.f48413h, 200L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (g.this.f48414i) {
                return;
            }
            g.this.f48406a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            g.this.f48414i = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.f48414i = false;
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    @Override // d.a.i0.d0.a
    public void dettachView(View view) {
        ContinuousAnimationView continuousAnimationView = this.f48406a;
        if (continuousAnimationView != null) {
            continuousAnimationView.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f48413h);
        super.dettachView(view);
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView = this.f48406a;
        if (continuousAnimationView == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        return this.attachedView;
    }

    public TextView j() {
        return this.f48409d;
    }

    public final int k() {
        int i2 = this.f48410e + 1;
        this.f48410e = i2;
        if (i2 >= this.f48411f) {
            this.f48410e = 0;
        }
        return this.f48410e;
    }

    public void l(int i2) {
        SkinManager.setViewTextColor(this.f48408c, R.color.CAM_X0108, 1, i2);
        SkinManager.setViewTextColor(this.f48409d, R.color.CAM_X0108, 1, i2);
        SkinManager.setLottieAnimation(this.f48406a, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            r();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f48413h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f48413h, 200L);
        this.f48412g = i2;
    }

    public void m() {
        s();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f48413h);
    }

    public void n(int i2) {
        View view = this.attachedView;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void o(int i2) {
        TextView textView;
        if (this.f48406a == null || (textView = this.f48409d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f48406a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i2;
                this.f48406a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f48409d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i2;
            this.f48409d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.f48412g == -1) {
            this.f48412g = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setViewTextColor(this.f48408c, R.color.CAM_X0108, 1, this.f48412g);
            SkinManager.setViewTextColor(this.f48409d, R.color.CAM_X0108, 1, this.f48412g);
            r();
        }
    }

    @Override // d.a.i0.d0.a
    public void onViewAttached() {
        if (this.f48412g == -1) {
            this.f48412g = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setLottieAnimation(this.f48406a, R.raw.lottie_full_screen_refresh);
        r();
        SkinManager.setViewTextColor(this.f48408c, R.color.CAM_X0108, 1, this.f48412g);
        SkinManager.setViewTextColor(this.f48409d, R.color.CAM_X0108, 1, this.f48412g);
        this.f48408c.setText(this.f48407b[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f48413h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f48413h, 200L);
        this.attachedView.setClickable(true);
    }

    @Override // d.a.i0.d0.a
    public void onViewDettached() {
        m();
    }

    public void p(int i2) {
        this.f48412g = i2;
    }

    public void q(int i2) {
        ContinuousAnimationView continuousAnimationView = this.f48406a;
        if (continuousAnimationView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f48406a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView = this.f48406a;
        if (continuousAnimationView != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView = this.f48406a;
        if (continuousAnimationView != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public g(Context context, int i2) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.f48410e = 0;
        this.f48412g = -1;
        this.f48413h = new a();
        this.j = new b();
        this.k = new c();
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f48406a = continuousAnimationView;
        if (i2 > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f48406a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f48406a, R.raw.lottie_full_screen_refresh);
        this.f48406a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f48406a.setRepeatMode(1);
        this.f48406a.addAnimatorUpdateListener(this.j);
        this.f48406a.addAnimatorListener(this.k);
        this.f48406a.setSpeed(1.2f);
        this.f48408c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f48409d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f48407b = stringArray;
        this.f48411f = stringArray.length;
    }
}
