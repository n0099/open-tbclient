package d.b.j0.q0.s1.a.e;

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
    public Context f60660a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60661b;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f60663d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f60664e = new c();

    /* renamed from: c  reason: collision with root package name */
    public Handler f60662c = new Handler();

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f60661b == null || valueAnimator == null) {
                return;
            }
            f.this.f60661b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (f.this.f60661b != null) {
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
            if (f.this.f60661b == null || f.this.f60661b.getParent() == null || f.this.f60663d == null) {
                return;
            }
            f.this.f60663d.start();
        }
    }

    public f(Context context) {
        this.f60660a = context;
        c();
    }

    public final void c() {
        TextView textView = new TextView(this.f60660a);
        this.f60661b = textView;
        textView.setTextSize(0, this.f60660a.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        SkinManager.setBackgroundResource(this.f60661b, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f60661b, R.color.CAM_X0101);
        this.f60661b.setGravity(17);
        this.f60661b.setVisibility(0);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f60663d = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f60663d.setDuration(400L);
        this.f60663d.addUpdateListener(new a());
        this.f60663d.addListener(new b());
    }

    public void d() {
        this.f60662c.removeCallbacks(this.f60664e);
        this.f60662c.postDelayed(this.f60664e, 2000L);
    }

    public TextView e() {
        return this.f60661b;
    }

    public boolean f() {
        TextView textView = this.f60661b;
        return textView != null && textView.getVisibility() == 0;
    }

    public void g() {
        Handler handler = this.f60662c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.f60663d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.f60661b;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f60661b);
            }
            this.f60661b.setVisibility(8);
            this.f60661b = null;
        }
    }
}
