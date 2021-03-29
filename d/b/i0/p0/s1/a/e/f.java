package d.b.i0.p0.s1.a.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f58571a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58572b;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f58574d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f58575e = new c();

    /* renamed from: c  reason: collision with root package name */
    public Handler f58573c = new Handler();

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f58572b == null || valueAnimator == null) {
                return;
            }
            f.this.f58572b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f.this.f58572b != null) {
                f.this.g();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f58572b == null || f.this.f58572b.getParent() == null || f.this.f58574d == null) {
                return;
            }
            f.this.f58574d.start();
        }
    }

    public f(Context context) {
        this.f58571a = context;
        c();
    }

    public final void c() {
        TextView textView = new TextView(this.f58571a);
        this.f58572b = textView;
        textView.setTextSize(0, this.f58571a.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        SkinManager.setBackgroundResource(this.f58572b, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f58572b, R.color.CAM_X0101);
        this.f58572b.setGravity(17);
        this.f58572b.setVisibility(0);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f58574d = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f58574d.setDuration(400L);
        this.f58574d.addUpdateListener(new a());
        this.f58574d.addListener(new b());
    }

    public void d() {
        this.f58573c.removeCallbacks(this.f58575e);
        this.f58573c.postDelayed(this.f58575e, 2000L);
    }

    public TextView e() {
        return this.f58572b;
    }

    public boolean f() {
        TextView textView = this.f58572b;
        return textView != null && textView.getVisibility() == 0;
    }

    public void g() {
        Handler handler = this.f58573c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.f58574d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.f58572b;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f58572b);
            }
            this.f58572b.setVisibility(8);
            this.f58572b = null;
        }
    }
}
