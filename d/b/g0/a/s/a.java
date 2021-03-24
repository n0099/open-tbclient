package d.b.g0.a.s;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.j2.d;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f45778a = new CopyOnWriteArrayList();

    /* renamed from: d.b.g0.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0778a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f45779e;

        public RunnableC0778a(SwanAppActivity swanAppActivity) {
            this.f45779e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f45779e.isFinishing()) {
                return;
            }
            if (a.this.f45778a != null) {
                for (AnimatorSet animatorSet : a.this.f45778a) {
                    animatorSet.cancel();
                }
            }
            this.f45779e.getFloatLayer().g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f45781e;

        public b(a aVar, SwanAppActivity swanAppActivity) {
            this.f45781e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f45781e.isFinishing()) {
                return;
            }
            this.f45781e.getLoadingView().f44987a.setVisibility(8);
            this.f45781e.getLoadingView().D();
            this.f45781e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f45781e.isFinishing()) {
                return;
            }
            this.f45781e.getLoadingView().s();
        }
    }

    public final ObjectAnimator b(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f44987a, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final AnimatorSet c(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f44990d, "translationX", -h0.e(AppRuntime.getAppContext(), 9.5f), h0.e(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f44991e, "translationX", 0.0f, -h0.e(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final AnimatorSet d(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f44990d, "translationX", 0.0f, -h0.e(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f44991e, "alpha", 0.0f, 1.0f);
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
        loadingView.f44987a.setVisibility(8);
        if (!d.b.g0.a.w0.a.N().B()) {
            List<AnimatorSet> list = this.f45778a;
            if (list != null) {
                for (AnimatorSet animatorSet : list) {
                    animatorSet.cancel();
                }
            }
            swanAppActivity.getFloatLayer().g();
            return;
        }
        k0.T(new RunnableC0778a(swanAppActivity));
    }

    public final void f(SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i = z ? 100 : 0;
        animatorSet.play(b(swanAppActivity, 150L));
        animatorSet.addListener(new b(this, swanAppActivity));
        animatorSet.setStartDelay(i);
        animatorSet.start();
        this.f45778a.add(animatorSet);
    }

    public void g(SwanAppActivity swanAppActivity, int i) {
        if (i == 1) {
            e(swanAppActivity);
        } else if (i == 2) {
            f(swanAppActivity, false);
        } else if (i != 3) {
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
        d.b.g0.a.y1.a.d().i("first_anim_start");
        this.f45778a.add(animatorSet);
    }

    public void i() {
        for (AnimatorSet animatorSet : this.f45778a) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.f45778a.clear();
    }
}
