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
    public ContinuousAnimationView f52952a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f52953b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52954c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52955d;

    /* renamed from: e  reason: collision with root package name */
    public int f52956e;

    /* renamed from: f  reason: collision with root package name */
    public final int f52957f;

    /* renamed from: g  reason: collision with root package name */
    public int f52958g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f52959h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52960i;
    public ValueAnimator.AnimatorUpdateListener j;
    public final Animator.AnimatorListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.isViewAttached()) {
                TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.f52959h);
                return;
            }
            g.this.f52954c.setText(g.this.f52953b[g.this.k()]);
            TbadkCoreApplication.getInst().handler.postDelayed(g.this.f52959h, 200L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (g.this.f52960i) {
                return;
            }
            g.this.f52952a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
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
            g.this.f52960i = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.f52960i = false;
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    @Override // d.a.m0.d0.a
    public void dettachView(View view) {
        ContinuousAnimationView continuousAnimationView = this.f52952a;
        if (continuousAnimationView != null) {
            continuousAnimationView.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f52959h);
        super.dettachView(view);
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView = this.f52952a;
        if (continuousAnimationView == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        return this.attachedView;
    }

    public TextView j() {
        return this.f52955d;
    }

    public final int k() {
        int i2 = this.f52956e + 1;
        this.f52956e = i2;
        if (i2 >= this.f52957f) {
            this.f52956e = 0;
        }
        return this.f52956e;
    }

    public void l(int i2) {
        SkinManager.setViewTextColor(this.f52954c, R.color.CAM_X0108, 1, i2);
        SkinManager.setViewTextColor(this.f52955d, R.color.CAM_X0108, 1, i2);
        SkinManager.setLottieAnimation(this.f52952a, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            r();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f52959h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f52959h, 200L);
        this.f52958g = i2;
    }

    public void m() {
        s();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f52959h);
    }

    public void n(int i2) {
        View view = this.attachedView;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void o(int i2) {
        TextView textView;
        if (this.f52952a == null || (textView = this.f52955d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f52952a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i2;
                this.f52952a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f52955d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i2;
            this.f52955d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.f52958g == -1) {
            this.f52958g = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setViewTextColor(this.f52954c, R.color.CAM_X0108, 1, this.f52958g);
            SkinManager.setViewTextColor(this.f52955d, R.color.CAM_X0108, 1, this.f52958g);
            r();
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        if (this.f52958g == -1) {
            this.f52958g = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setLottieAnimation(this.f52952a, R.raw.lottie_full_screen_refresh);
        r();
        SkinManager.setViewTextColor(this.f52954c, R.color.CAM_X0108, 1, this.f52958g);
        SkinManager.setViewTextColor(this.f52955d, R.color.CAM_X0108, 1, this.f52958g);
        this.f52954c.setText(this.f52953b[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f52959h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f52959h, 200L);
        this.attachedView.setClickable(true);
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        m();
    }

    public void p(int i2) {
        this.f52958g = i2;
    }

    public void q(int i2) {
        ContinuousAnimationView continuousAnimationView = this.f52952a;
        if (continuousAnimationView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f52952a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView = this.f52952a;
        if (continuousAnimationView != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView = this.f52952a;
        if (continuousAnimationView != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public g(Context context, int i2) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.f52956e = 0;
        this.f52958g = -1;
        this.f52959h = new a();
        this.j = new b();
        this.k = new c();
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f52952a = continuousAnimationView;
        if (i2 > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f52952a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f52952a, R.raw.lottie_full_screen_refresh);
        this.f52952a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f52952a.setRepeatMode(1);
        this.f52952a.addAnimatorUpdateListener(this.j);
        this.f52952a.addAnimatorListener(this.k);
        this.f52952a.setSpeed(1.2f);
        this.f52954c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f52955d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f52953b = stringArray;
        this.f52957f = stringArray.length;
    }
}
