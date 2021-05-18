package d.a.i0.a.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import d.a.i0.a.r1.h;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f44526a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f44527b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f44528c;

    /* renamed from: d.a.i0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0809a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44529e;

        public RunnableC0809a(SwanAppActivity swanAppActivity) {
            this.f44529e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44529e.isFinishing()) {
                return;
            }
            if (a.this.f44526a != null) {
                for (AnimatorSet animatorSet : a.this.f44526a) {
                    animatorSet.cancel();
                }
            }
            this.f44529e.getFloatLayer().g();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44531e;

        public b(SwanAppActivity swanAppActivity) {
            this.f44531e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f44528c != null) {
                a.this.f44528c.setVisibility(4);
                a.this.f44528c.i();
            }
            if (a.this.f44527b != null) {
                a.this.f44527b.u();
            }
            a.this.k(this.f44531e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f44534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f44535c;

        public c(SwanAppActivity swanAppActivity, Handler handler, Runnable runnable) {
            this.f44533a = swanAppActivity;
            this.f44534b = handler;
            this.f44535c = runnable;
        }

        @Override // d.a.i0.a.t.a.f
        public void a() {
            if (a.this.f44528c != null) {
                a.this.f44528c.setVisibility(4);
                a.this.f44528c.i();
            }
            if (a.this.f44527b != null) {
                a.this.f44527b.u();
            }
            a.this.k(this.f44533a);
            this.f44534b.removeCallbacks(this.f44535c);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44537e;

        /* renamed from: d.a.i0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0810a implements Animator.AnimatorListener {
            public C0810a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.f44537e.isFinishing()) {
                    return;
                }
                d.this.f44537e.getLoadingView().f45491a.setVisibility(8);
                d.this.f44537e.getLoadingView().J();
                d.this.f44537e.getFloatLayer().g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.f44537e.isFinishing()) {
                    return;
                }
                d.this.f44537e.getLoadingView().w();
            }
        }

        public d(SwanAppActivity swanAppActivity) {
            this.f44537e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a.this.f(this.f44537e, 150L));
            animatorSet.addListener(new C0810a());
            animatorSet.start();
            a.this.f44526a.add(animatorSet);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44540e;

        public e(a aVar, SwanAppActivity swanAppActivity) {
            this.f44540e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f44540e.isFinishing()) {
                return;
            }
            this.f44540e.getLoadingView().f45491a.setVisibility(8);
            this.f44540e.getLoadingView().J();
            this.f44540e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f44540e.isFinishing()) {
                return;
            }
            this.f44540e.getLoadingView().w();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45491a, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45494d, "translationX", -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45495e, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final AnimatorSet h(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45494d, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45495e, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final void i(SwanAppActivity swanAppActivity) {
        Handler i2 = d.a.i0.a.a2.d.i();
        b bVar = new b(swanAppActivity);
        i2.postDelayed(bVar, d.a.i0.a.r1.l.b.c());
        SwanAppSlaveManager.m1(new c(swanAppActivity, i2, bVar));
    }

    public final void j(SwanAppActivity swanAppActivity) {
        d.a.i0.a.w2.e loadingView;
        if (swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (d.a.i0.a.r1.l.b.d() != 1 && d.a.i0.a.r1.l.b.d() != 3) {
            loadingView.f45491a.setVisibility(8);
            if (!d.a.i0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f44526a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().g();
                return;
            }
            q0.X(new RunnableC0809a(swanAppActivity));
            return;
        }
        i(swanAppActivity);
    }

    public final void k(SwanAppActivity swanAppActivity) {
        q0.X(new d(swanAppActivity));
    }

    public void l(SwanAppActivity swanAppActivity) {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(d.a.i0.a.f.App_Launch_Circle_Animation_View);
        this.f44528c = swanAppLaunchCircleAnimationView;
        swanAppLaunchCircleAnimationView.h();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.i0.a.i2.a.d().i("first_anim_start");
    }

    public final void m(SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i2 = z ? 100 : 0;
        animatorSet.play(f(swanAppActivity, 150L));
        animatorSet.addListener(new e(this, swanAppActivity));
        animatorSet.setStartDelay(i2);
        animatorSet.start();
        this.f44526a.add(animatorSet);
    }

    public void n(SwanAppActivity swanAppActivity, int i2) {
        if (i2 == 1) {
            j(swanAppActivity);
        } else if (i2 == 2) {
            m(swanAppActivity, false);
        } else if (i2 != 3) {
            j(swanAppActivity);
        } else {
            m(swanAppActivity, true);
        }
    }

    public void o(SwanAppActivity swanAppActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(h(swanAppActivity)).before(g(swanAppActivity));
        animatorSet.start();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.i0.a.i2.a.d().i("first_anim_start");
        this.f44526a.add(animatorSet);
    }

    public void p(SwanAppActivity swanAppActivity) {
        BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(d.a.i0.a.f.App_Launch_Shimmer_Animation_View);
        this.f44527b = bdShimmerView;
        if (bdShimmerView == null) {
            return;
        }
        bdShimmerView.setType(1);
        this.f44527b.o();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.i0.a.i2.a.d().i("first_anim_start");
    }

    public void q() {
        for (AnimatorSet animatorSet : this.f44526a) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f44528c;
        if (swanAppLaunchCircleAnimationView != null) {
            swanAppLaunchCircleAnimationView.i();
        }
        BdShimmerView bdShimmerView = this.f44527b;
        if (bdShimmerView != null) {
            bdShimmerView.u();
        }
        this.f44526a.clear();
    }
}
