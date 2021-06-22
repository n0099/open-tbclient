package d.a.o0.r0.s1.a.e;

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
    public Context f63466a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63467b;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f63469d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f63470e = new c();

    /* renamed from: c  reason: collision with root package name */
    public Handler f63468c = new Handler();

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f63467b == null || valueAnimator == null) {
                return;
            }
            f.this.f63467b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (f.this.f63467b != null) {
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
            if (f.this.f63467b == null || f.this.f63467b.getParent() == null || f.this.f63469d == null) {
                return;
            }
            f.this.f63469d.start();
        }
    }

    public f(Context context) {
        this.f63466a = context;
        c();
    }

    public final void c() {
        TextView textView = new TextView(this.f63466a);
        this.f63467b = textView;
        textView.setTextSize(0, this.f63466a.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        SkinManager.setBackgroundResource(this.f63467b, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f63467b, R.color.CAM_X0101);
        this.f63467b.setGravity(17);
        this.f63467b.setVisibility(0);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f63469d = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f63469d.setDuration(400L);
        this.f63469d.addUpdateListener(new a());
        this.f63469d.addListener(new b());
    }

    public void d() {
        this.f63468c.removeCallbacks(this.f63470e);
        this.f63468c.postDelayed(this.f63470e, 2000L);
    }

    public TextView e() {
        return this.f63467b;
    }

    public boolean f() {
        TextView textView = this.f63467b;
        return textView != null && textView.getVisibility() == 0;
    }

    public void g() {
        Handler handler = this.f63468c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.f63469d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.f63467b;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f63467b);
            }
            this.f63467b.setVisibility(8);
            this.f63467b = null;
        }
    }
}
