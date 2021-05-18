package d.a.k0.q0.s1.a.e;

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
    public Context f59509a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59510b;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f59512d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f59513e = new c();

    /* renamed from: c  reason: collision with root package name */
    public Handler f59511c = new Handler();

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f59510b == null || valueAnimator == null) {
                return;
            }
            f.this.f59510b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (f.this.f59510b != null) {
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
            if (f.this.f59510b == null || f.this.f59510b.getParent() == null || f.this.f59512d == null) {
                return;
            }
            f.this.f59512d.start();
        }
    }

    public f(Context context) {
        this.f59509a = context;
        c();
    }

    public final void c() {
        TextView textView = new TextView(this.f59509a);
        this.f59510b = textView;
        textView.setTextSize(0, this.f59509a.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        SkinManager.setBackgroundResource(this.f59510b, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f59510b, R.color.CAM_X0101);
        this.f59510b.setGravity(17);
        this.f59510b.setVisibility(0);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f59512d = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f59512d.setDuration(400L);
        this.f59512d.addUpdateListener(new a());
        this.f59512d.addListener(new b());
    }

    public void d() {
        this.f59511c.removeCallbacks(this.f59513e);
        this.f59511c.postDelayed(this.f59513e, 2000L);
    }

    public TextView e() {
        return this.f59510b;
    }

    public boolean f() {
        TextView textView = this.f59510b;
        return textView != null && textView.getVisibility() == 0;
    }

    public void g() {
        Handler handler = this.f59511c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.f59512d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.f59510b;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f59510b);
            }
            this.f59510b.setVisibility(8);
            this.f59510b = null;
        }
    }
}
