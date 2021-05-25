package d.a.n0.r0.s1.a.e;

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
    public Context f59650a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59651b;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f59653d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f59654e = new c();

    /* renamed from: c  reason: collision with root package name */
    public Handler f59652c = new Handler();

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f59651b == null || valueAnimator == null) {
                return;
            }
            f.this.f59651b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (f.this.f59651b != null) {
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
            if (f.this.f59651b == null || f.this.f59651b.getParent() == null || f.this.f59653d == null) {
                return;
            }
            f.this.f59653d.start();
        }
    }

    public f(Context context) {
        this.f59650a = context;
        c();
    }

    public final void c() {
        TextView textView = new TextView(this.f59650a);
        this.f59651b = textView;
        textView.setTextSize(0, this.f59650a.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        SkinManager.setBackgroundResource(this.f59651b, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f59651b, R.color.CAM_X0101);
        this.f59651b.setGravity(17);
        this.f59651b.setVisibility(0);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f59653d = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f59653d.setDuration(400L);
        this.f59653d.addUpdateListener(new a());
        this.f59653d.addListener(new b());
    }

    public void d() {
        this.f59652c.removeCallbacks(this.f59654e);
        this.f59652c.postDelayed(this.f59654e, 2000L);
    }

    public TextView e() {
        return this.f59651b;
    }

    public boolean f() {
        TextView textView = this.f59651b;
        return textView != null && textView.getVisibility() == 0;
    }

    public void g() {
        Handler handler = this.f59652c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.f59653d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.f59651b;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f59651b);
            }
            this.f59651b.setVisibility(8);
            this.f59651b = null;
        }
    }
}
