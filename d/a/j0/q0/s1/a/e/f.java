package d.a.j0.q0.s1.a.e;

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
    public Context f58767a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58768b;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f58770d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f58771e = new c();

    /* renamed from: c  reason: collision with root package name */
    public Handler f58769c = new Handler();

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f58768b == null || valueAnimator == null) {
                return;
            }
            f.this.f58768b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (f.this.f58768b != null) {
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
            if (f.this.f58768b == null || f.this.f58768b.getParent() == null || f.this.f58770d == null) {
                return;
            }
            f.this.f58770d.start();
        }
    }

    public f(Context context) {
        this.f58767a = context;
        c();
    }

    public final void c() {
        TextView textView = new TextView(this.f58767a);
        this.f58768b = textView;
        textView.setTextSize(0, this.f58767a.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        SkinManager.setBackgroundResource(this.f58768b, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f58768b, R.color.CAM_X0101);
        this.f58768b.setGravity(17);
        this.f58768b.setVisibility(0);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f58770d = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f58770d.setDuration(400L);
        this.f58770d.addUpdateListener(new a());
        this.f58770d.addListener(new b());
    }

    public void d() {
        this.f58769c.removeCallbacks(this.f58771e);
        this.f58769c.postDelayed(this.f58771e, 2000L);
    }

    public TextView e() {
        return this.f58768b;
    }

    public boolean f() {
        TextView textView = this.f58768b;
        return textView != null && textView.getVisibility() == 0;
    }

    public void g() {
        Handler handler = this.f58769c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.f58770d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.f58768b;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f58768b);
            }
            this.f58768b.setVisibility(8);
            this.f58768b = null;
        }
    }
}
