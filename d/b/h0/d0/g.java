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
    public ContinuousAnimationView f50100a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f50101b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50102c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50103d;

    /* renamed from: e  reason: collision with root package name */
    public int f50104e;

    /* renamed from: f  reason: collision with root package name */
    public final int f50105f;

    /* renamed from: g  reason: collision with root package name */
    public int f50106g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50107h;
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
                TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.f50107h);
                return;
            }
            g.this.f50102c.setText(g.this.f50101b[g.this.k()]);
            TbadkCoreApplication.getInst().handler.postDelayed(g.this.f50107h, 200L);
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
            g.this.f50100a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
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
        ContinuousAnimationView continuousAnimationView = this.f50100a;
        if (continuousAnimationView != null) {
            continuousAnimationView.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50107h);
        super.dettachView(view);
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView = this.f50100a;
        if (continuousAnimationView == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        return this.attachedView;
    }

    public TextView j() {
        return this.f50103d;
    }

    public final int k() {
        int i = this.f50104e + 1;
        this.f50104e = i;
        if (i >= this.f50105f) {
            this.f50104e = 0;
        }
        return this.f50104e;
    }

    public void l(int i) {
        SkinManager.setViewTextColor(this.f50102c, R.color.CAM_X0108, 1, i);
        SkinManager.setViewTextColor(this.f50103d, R.color.CAM_X0108, 1, i);
        SkinManager.setLottieAnimation(this.f50100a, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            r();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50107h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f50107h, 200L);
        this.f50106g = i;
    }

    public void m() {
        s();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50107h);
    }

    public void n(int i) {
        View view = this.attachedView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void o(int i) {
        TextView textView;
        if (this.f50100a == null || (textView = this.f50103d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f50100a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                this.f50100a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f50103d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i;
            this.f50103d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.f50106g == -1) {
            this.f50106g = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setViewTextColor(this.f50102c, R.color.CAM_X0108, 1, this.f50106g);
            SkinManager.setViewTextColor(this.f50103d, R.color.CAM_X0108, 1, this.f50106g);
            r();
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        if (this.f50106g == -1) {
            this.f50106g = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setLottieAnimation(this.f50100a, R.raw.lottie_full_screen_refresh);
        r();
        SkinManager.setViewTextColor(this.f50102c, R.color.CAM_X0108, 1, this.f50106g);
        SkinManager.setViewTextColor(this.f50103d, R.color.CAM_X0108, 1, this.f50106g);
        this.f50102c.setText(this.f50101b[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.f50107h);
        TbadkCoreApplication.getInst().handler.postDelayed(this.f50107h, 200L);
        this.attachedView.setClickable(true);
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        m();
    }

    public void p(int i) {
        this.f50106g = i;
    }

    public void q(int i) {
        ContinuousAnimationView continuousAnimationView = this.f50100a;
        if (continuousAnimationView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.f50100a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView = this.f50100a;
        if (continuousAnimationView != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView = this.f50100a;
        if (continuousAnimationView != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.f50104e = 0;
        this.f50106g = -1;
        this.f50107h = new a();
        this.j = new b();
        this.k = new c();
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f50100a = continuousAnimationView;
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.f50100a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f50100a, R.raw.lottie_full_screen_refresh);
        this.f50100a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f50100a.setRepeatMode(1);
        this.f50100a.addAnimatorUpdateListener(this.j);
        this.f50100a.addAnimatorListener(this.k);
        this.f50100a.setSpeed(1.2f);
        this.f50102c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f50103d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f50101b = stringArray;
        this.f50105f = stringArray.length;
    }
}
