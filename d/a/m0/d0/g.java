package d.a.m0.d0;

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
public class g extends d.a.m0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public ContinuousAnimationView f49278a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f49279b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49280c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49281d;

    /* renamed from: e  reason: collision with root package name */
    public int f49282e;

    /* renamed from: f  reason: collision with root package name */
    public final int f49283f;

    /* renamed from: g  reason: collision with root package name */
    public int f49284g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f49285h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49286i;
    public ValueAnimator.AnimatorUpdateListener j;
    public final Animator.AnimatorListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.isViewAttached()) {
                TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.f49285h);
                return;
            }
            g.this.f49280c.setText(g.this.f49279b[g.this.k()]);
            TbadkCoreApplication.getInst().handler.postDelayed(g.this.f49285h, 200L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (g.this.f49286i) {
                return;
            }
            g.this.f49278a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
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
            g.this.f49286i = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.f49286i = false;
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    @Override // d.a.m0.d0.a
    public void dettachView(View view) {
        ContinuousAnimationView continuousAnimationView = this.f49278a;
        if (continuousAnimationView != null) {
            continuousAnimationView.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f49285h);
        super.dettachView(view);
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView = this.f49278a;
        if (continuousAnimationView == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        return this.attachedView;
    }

    public TextView j() {
        return this.f49281d;
    }

    public final int k() {
        int i2 = this.f49282e + 1;
        this.f49282e = i2;
        if (i2 >= this.f49283f) {
            this.f49282e = 0;
        }
        return this.f49282e;
    }

    public void l(int i2) {
        SkinManager.setViewTextColor(this.f49280c, R.color.CAM_X0108, 1, i2);
        SkinManager.setViewTextColor(this.f49281d, R.color.CAM_X0108, 1, i2);
        SkinManager.setLottieAnimation(this.f49278a, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            r();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f49285h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f49285h, 200L);
        this.f49284g = i2;
    }

    public void m() {
        s();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f49285h);
    }

    public void n(int i2) {
        View view = this.attachedView;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void o(int i2) {
        TextView textView;
        if (this.f49278a == null || (textView = this.f49281d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f49278a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i2;
                this.f49278a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f49281d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i2;
            this.f49281d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.f49284g == -1) {
            this.f49284g = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setViewTextColor(this.f49280c, R.color.CAM_X0108, 1, this.f49284g);
            SkinManager.setViewTextColor(this.f49281d, R.color.CAM_X0108, 1, this.f49284g);
            r();
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        if (this.f49284g == -1) {
            this.f49284g = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setLottieAnimation(this.f49278a, R.raw.lottie_full_screen_refresh);
        r();
        SkinManager.setViewTextColor(this.f49280c, R.color.CAM_X0108, 1, this.f49284g);
        SkinManager.setViewTextColor(this.f49281d, R.color.CAM_X0108, 1, this.f49284g);
        this.f49280c.setText(this.f49279b[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f49285h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f49285h, 200L);
        this.attachedView.setClickable(true);
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        m();
    }

    public void p(int i2) {
        this.f49284g = i2;
    }

    public void q(int i2) {
        ContinuousAnimationView continuousAnimationView = this.f49278a;
        if (continuousAnimationView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f49278a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView = this.f49278a;
        if (continuousAnimationView != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView = this.f49278a;
        if (continuousAnimationView != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public g(Context context, int i2) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.f49282e = 0;
        this.f49284g = -1;
        this.f49285h = new a();
        this.j = new b();
        this.k = new c();
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f49278a = continuousAnimationView;
        if (i2 > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f49278a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f49278a, R.raw.lottie_full_screen_refresh);
        this.f49278a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f49278a.setRepeatMode(1);
        this.f49278a.addAnimatorUpdateListener(this.j);
        this.f49278a.addAnimatorListener(this.k);
        this.f49278a.setSpeed(1.2f);
        this.f49280c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f49281d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f49279b = stringArray;
        this.f49283f = stringArray.length;
    }
}
