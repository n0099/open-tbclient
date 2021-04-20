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
    public ContinuousAnimationView f50494a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f50495b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50496c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50497d;

    /* renamed from: e  reason: collision with root package name */
    public int f50498e;

    /* renamed from: f  reason: collision with root package name */
    public final int f50499f;

    /* renamed from: g  reason: collision with root package name */
    public int f50500g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50501h;
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
                TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.f50501h);
                return;
            }
            g.this.f50496c.setText(g.this.f50495b[g.this.k()]);
            TbadkCoreApplication.getInst().handler.postDelayed(g.this.f50501h, 200L);
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
            g.this.f50494a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
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
        ContinuousAnimationView continuousAnimationView = this.f50494a;
        if (continuousAnimationView != null) {
            continuousAnimationView.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50501h);
        super.dettachView(view);
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView = this.f50494a;
        if (continuousAnimationView == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        return this.attachedView;
    }

    public TextView j() {
        return this.f50497d;
    }

    public final int k() {
        int i = this.f50498e + 1;
        this.f50498e = i;
        if (i >= this.f50499f) {
            this.f50498e = 0;
        }
        return this.f50498e;
    }

    public void l(int i) {
        SkinManager.setViewTextColor(this.f50496c, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.f50497d, R.color.CAM_X0108, 1, i);
        SkinManager.setLottieAnimation(this.f50494a, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            r();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50501h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f50501h, 200L);
        this.f50500g = i;
    }

    public void m() {
        s();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50501h);
    }

    public void n(int i) {
        View view = this.attachedView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void o(int i) {
        TextView textView;
        if (this.f50494a == null || (textView = this.f50497d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f50494a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                this.f50494a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f50497d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i;
            this.f50497d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.f50500g == -1) {
            this.f50500g = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setViewTextColor(this.f50496c, R.color.CAM_X0108, 1, this.f50500g);
            SkinManager.setViewTextColor(this.f50497d, R.color.CAM_X0108, 1, this.f50500g);
            r();
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        if (this.f50500g == -1) {
            this.f50500g = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setLottieAnimation(this.f50494a, R.raw.lottie_full_screen_refresh);
        r();
        SkinManager.setViewTextColor(this.f50496c, R.color.CAM_X0108, 1, this.f50500g);
        SkinManager.setViewTextColor(this.f50497d, R.color.CAM_X0108, 1, this.f50500g);
        this.f50496c.setText(this.f50495b[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50501h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f50501h, 200L);
        this.attachedView.setClickable(true);
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        m();
    }

    public void p(int i) {
        this.f50500g = i;
    }

    public void q(int i) {
        ContinuousAnimationView continuousAnimationView = this.f50494a;
        if (continuousAnimationView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.f50494a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView = this.f50494a;
        if (continuousAnimationView != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView = this.f50494a;
        if (continuousAnimationView != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.f50498e = 0;
        this.f50500g = -1;
        this.f50501h = new a();
        this.j = new b();
        this.k = new c();
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f50494a = continuousAnimationView;
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.f50494a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f50494a, R.raw.lottie_full_screen_refresh);
        this.f50494a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f50494a.setRepeatMode(1);
        this.f50494a.addAnimatorUpdateListener(this.j);
        this.f50494a.addAnimatorListener(this.k);
        this.f50494a.setSpeed(1.2f);
        this.f50496c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f50497d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f50495b = stringArray;
        this.f50499f = stringArray.length;
    }
}
