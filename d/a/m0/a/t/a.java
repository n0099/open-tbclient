package d.a.m0.a.t;

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
import d.a.m0.a.r1.h;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f48484a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f48485b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f48486c;

    /* renamed from: d.a.m0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0879a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48487e;

        public RunnableC0879a(SwanAppActivity swanAppActivity) {
            this.f48487e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f48487e.isFinishing()) {
                return;
            }
            if (a.this.f48484a != null) {
                for (AnimatorSet animatorSet : a.this.f48484a) {
                    animatorSet.cancel();
                }
            }
            this.f48487e.getFloatLayer().g();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48489e;

        public b(SwanAppActivity swanAppActivity) {
            this.f48489e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48486c != null) {
                a.this.f48486c.setVisibility(4);
                a.this.f48486c.i();
            }
            if (a.this.f48485b != null) {
                a.this.f48485b.u();
            }
            a.this.k(this.f48489e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f48492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f48493c;

        public c(SwanAppActivity swanAppActivity, Handler handler, Runnable runnable) {
            this.f48491a = swanAppActivity;
            this.f48492b = handler;
            this.f48493c = runnable;
        }

        @Override // d.a.m0.a.t.a.f
        public void a() {
            if (a.this.f48486c != null) {
                a.this.f48486c.setVisibility(4);
                a.this.f48486c.i();
            }
            if (a.this.f48485b != null) {
                a.this.f48485b.u();
            }
            a.this.k(this.f48491a);
            this.f48492b.removeCallbacks(this.f48493c);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48495e;

        /* renamed from: d.a.m0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0880a implements Animator.AnimatorListener {
            public C0880a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.f48495e.isFinishing()) {
                    return;
                }
                d.this.f48495e.getLoadingView().f49449a.setVisibility(8);
                d.this.f48495e.getLoadingView().J();
                d.this.f48495e.getFloatLayer().g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.f48495e.isFinishing()) {
                    return;
                }
                d.this.f48495e.getLoadingView().w();
            }
        }

        public d(SwanAppActivity swanAppActivity) {
            this.f48495e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a.this.f(this.f48495e, 150L));
            animatorSet.addListener(new C0880a());
            animatorSet.start();
            a.this.f48484a.add(animatorSet);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48498e;

        public e(a aVar, SwanAppActivity swanAppActivity) {
            this.f48498e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f48498e.isFinishing()) {
                return;
            }
            this.f48498e.getLoadingView().f49449a.setVisibility(8);
            this.f48498e.getLoadingView().J();
            this.f48498e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f48498e.isFinishing()) {
                return;
            }
            this.f48498e.getLoadingView().w();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f49449a, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f49452d, "translationX", -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f49453e, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final AnimatorSet h(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f49452d, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f49453e, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final void i(SwanAppActivity swanAppActivity) {
        Handler i2 = d.a.m0.a.a2.d.i();
        b bVar = new b(swanAppActivity);
        i2.postDelayed(bVar, d.a.m0.a.r1.l.b.c());
        SwanAppSlaveManager.m1(new c(swanAppActivity, i2, bVar));
    }

    public final void j(SwanAppActivity swanAppActivity) {
        d.a.m0.a.w2.e loadingView;
        if (swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (d.a.m0.a.r1.l.b.d() != 1 && d.a.m0.a.r1.l.b.d() != 3) {
            loadingView.f49449a.setVisibility(8);
            if (!d.a.m0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f48484a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().g();
                return;
            }
            q0.X(new RunnableC0879a(swanAppActivity));
            return;
        }
        i(swanAppActivity);
    }

    public final void k(SwanAppActivity swanAppActivity) {
        q0.X(new d(swanAppActivity));
    }

    public void l(SwanAppActivity swanAppActivity) {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(d.a.m0.a.f.App_Launch_Circle_Animation_View);
        this.f48486c = swanAppLaunchCircleAnimationView;
        swanAppLaunchCircleAnimationView.h();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.m0.a.i2.a.d().i("first_anim_start");
    }

    public final void m(SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i2 = z ? 100 : 0;
        animatorSet.play(f(swanAppActivity, 150L));
        animatorSet.addListener(new e(this, swanAppActivity));
        animatorSet.setStartDelay(i2);
        animatorSet.start();
        this.f48484a.add(animatorSet);
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
        d.a.m0.a.i2.a.d().i("first_anim_start");
        this.f48484a.add(animatorSet);
    }

    public void p(SwanAppActivity swanAppActivity) {
        BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(d.a.m0.a.f.App_Launch_Shimmer_Animation_View);
        this.f48485b = bdShimmerView;
        if (bdShimmerView == null) {
            return;
        }
        bdShimmerView.setType(1);
        this.f48485b.o();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.m0.a.i2.a.d().i("first_anim_start");
    }

    public void q() {
        for (AnimatorSet animatorSet : this.f48484a) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f48486c;
        if (swanAppLaunchCircleAnimationView != null) {
            swanAppLaunchCircleAnimationView.i();
        }
        BdShimmerView bdShimmerView = this.f48485b;
        if (bdShimmerView != null) {
            bdShimmerView.u();
        }
        this.f48484a.clear();
    }
}
