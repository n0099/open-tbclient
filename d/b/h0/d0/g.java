package d.b.h0.d0;

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
public class g extends d.b.h0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public ContinuousAnimationView f50101a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f50102b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50103c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50104d;

    /* renamed from: e  reason: collision with root package name */
    public int f50105e;

    /* renamed from: f  reason: collision with root package name */
    public final int f50106f;

    /* renamed from: g  reason: collision with root package name */
    public int f50107g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50108h;
    public boolean i;
    public ValueAnimator.AnimatorUpdateListener j;
    public final Animator.AnimatorListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.isViewAttached()) {
                TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.f50108h);
                return;
            }
            g.this.f50103c.setText(g.this.f50102b[g.this.k()]);
            TbadkCoreApplication.getInst().handler.postDelayed(g.this.f50108h, 200L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (g.this.i) {
                return;
            }
            g.this.f50101a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
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
            g.this.i = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.i = false;
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    @Override // d.b.h0.d0.a
    public void dettachView(View view) {
        ContinuousAnimationView continuousAnimationView = this.f50101a;
        if (continuousAnimationView != null) {
            continuousAnimationView.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50108h);
        super.dettachView(view);
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView = this.f50101a;
        if (continuousAnimationView == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        return this.attachedView;
    }

    public TextView j() {
        return this.f50104d;
    }

    public final int k() {
        int i = this.f50105e + 1;
        this.f50105e = i;
        if (i >= this.f50106f) {
            this.f50105e = 0;
        }
        return this.f50105e;
    }

    public void l(int i) {
        SkinManager.setViewTextColor(this.f50103c, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.f50104d, R.color.CAM_X0108, 1, i);
        SkinManager.setLottieAnimation(this.f50101a, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            r();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50108h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f50108h, 200L);
        this.f50107g = i;
    }

    public void m() {
        s();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50108h);
    }

    public void n(int i) {
        View view = this.attachedView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void o(int i) {
        TextView textView;
        if (this.f50101a == null || (textView = this.f50104d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f50101a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                this.f50101a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f50104d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i;
            this.f50104d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.f50107g == -1) {
            this.f50107g = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setViewTextColor(this.f50103c, R.color.CAM_X0108, 1, this.f50107g);
            SkinManager.setViewTextColor(this.f50104d, R.color.CAM_X0108, 1, this.f50107g);
            r();
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        if (this.f50107g == -1) {
            this.f50107g = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setLottieAnimation(this.f50101a, R.raw.lottie_full_screen_refresh);
        r();
        SkinManager.setViewTextColor(this.f50103c, R.color.CAM_X0108, 1, this.f50107g);
        SkinManager.setViewTextColor(this.f50104d, R.color.CAM_X0108, 1, this.f50107g);
        this.f50103c.setText(this.f50102b[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50108h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f50108h, 200L);
        this.attachedView.setClickable(true);
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        m();
    }

    public void p(int i) {
        this.f50107g = i;
    }

    public void q(int i) {
        ContinuousAnimationView continuousAnimationView = this.f50101a;
        if (continuousAnimationView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.f50101a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView = this.f50101a;
        if (continuousAnimationView != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView = this.f50101a;
        if (continuousAnimationView != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.f50105e = 0;
        this.f50107g = -1;
        this.f50108h = new a();
        this.j = new b();
        this.k = new c();
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f50101a = continuousAnimationView;
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.f50101a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f50101a, R.raw.lottie_full_screen_refresh);
        this.f50101a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f50101a.setRepeatMode(1);
        this.f50101a.addAnimatorUpdateListener(this.j);
        this.f50101a.addAnimatorListener(this.k);
        this.f50101a.setSpeed(1.2f);
        this.f50103c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f50104d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f50102b = stringArray;
        this.f50106f = stringArray.length;
    }
}
