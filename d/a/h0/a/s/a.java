package d.a.h0.a.s;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j1.i;
import d.a.h0.a.j2.d;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f43865a = new CopyOnWriteArrayList();

    /* renamed from: d.a.h0.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0750a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f43866e;

        public RunnableC0750a(SwanAppActivity swanAppActivity) {
            this.f43866e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f43866e.isFinishing()) {
                return;
            }
            if (a.this.f43865a != null) {
                for (AnimatorSet animatorSet : a.this.f43865a) {
                    animatorSet.cancel();
                }
            }
            this.f43866e.getFloatLayer().g();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f43868e;

        public b(a aVar, SwanAppActivity swanAppActivity) {
            this.f43868e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f43868e.isFinishing()) {
                return;
            }
            this.f43868e.getLoadingView().f43035a.setVisibility(8);
            this.f43868e.getLoadingView().D();
            this.f43868e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f43868e.isFinishing()) {
                return;
            }
            this.f43868e.getLoadingView().s();
        }
    }

    public final ObjectAnimator b(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f43035a, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final AnimatorSet c(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f43038d, "translationX", -h0.e(AppRuntime.getAppContext(), 9.5f), h0.e(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f43039e, "translationX", 0.0f, -h0.e(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final AnimatorSet d(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f43038d, "translationX", 0.0f, -h0.e(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f43039e, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final void e(SwanAppActivity swanAppActivity) {
        d loadingView;
        if (swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        loadingView.f43035a.setVisibility(8);
        if (!d.a.h0.a.w0.a.N().I()) {
            List<AnimatorSet> list = this.f43865a;
            if (list != null) {
                for (AnimatorSet animatorSet : list) {
                    animatorSet.cancel();
                }
            }
            swanAppActivity.getFloatLayer().g();
            return;
        }
        k0.T(new RunnableC0750a(swanAppActivity));
    }

    public final void f(SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i2 = z ? 100 : 0;
        animatorSet.play(b(swanAppActivity, 150L));
        animatorSet.addListener(new b(this, swanAppActivity));
        animatorSet.setStartDelay(i2);
        animatorSet.start();
        this.f43865a.add(animatorSet);
    }

    public void g(SwanAppActivity swanAppActivity, int i2) {
        if (i2 == 1) {
            e(swanAppActivity);
        } else if (i2 == 2) {
            f(swanAppActivity, false);
        } else if (i2 != 3) {
            e(swanAppActivity);
        } else {
            f(swanAppActivity, true);
        }
    }

    public void h(SwanAppActivity swanAppActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(d(swanAppActivity)).before(c(swanAppActivity));
        animatorSet.start();
        i.n().A(new UbcFlowEvent("first_anim_start"));
        d.a.h0.a.y1.a.d().i("first_anim_start");
        this.f43865a.add(animatorSet);
    }

    public void i() {
        for (AnimatorSet animatorSet : this.f43865a) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.f43865a.clear();
    }
}
