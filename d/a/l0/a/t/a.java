package d.a.l0.a.t;

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
import d.a.l0.a.r1.h;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f44702a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f44703b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f44704c;

    /* renamed from: d.a.l0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0820a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44705e;

        public RunnableC0820a(SwanAppActivity swanAppActivity) {
            this.f44705e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44705e.isFinishing()) {
                return;
            }
            if (a.this.f44702a != null) {
                for (AnimatorSet animatorSet : a.this.f44702a) {
                    animatorSet.cancel();
                }
            }
            this.f44705e.getFloatLayer().g();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44707e;

        public b(SwanAppActivity swanAppActivity) {
            this.f44707e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f44704c != null) {
                a.this.f44704c.setVisibility(4);
                a.this.f44704c.i();
            }
            if (a.this.f44703b != null) {
                a.this.f44703b.u();
            }
            a.this.k(this.f44707e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44709a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f44710b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f44711c;

        public c(SwanAppActivity swanAppActivity, Handler handler, Runnable runnable) {
            this.f44709a = swanAppActivity;
            this.f44710b = handler;
            this.f44711c = runnable;
        }

        @Override // d.a.l0.a.t.a.f
        public void a() {
            if (a.this.f44704c != null) {
                a.this.f44704c.setVisibility(4);
                a.this.f44704c.i();
            }
            if (a.this.f44703b != null) {
                a.this.f44703b.u();
            }
            a.this.k(this.f44709a);
            this.f44710b.removeCallbacks(this.f44711c);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44713e;

        /* renamed from: d.a.l0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0821a implements Animator.AnimatorListener {
            public C0821a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.f44713e.isFinishing()) {
                    return;
                }
                d.this.f44713e.getLoadingView().f45667a.setVisibility(8);
                d.this.f44713e.getLoadingView().J();
                d.this.f44713e.getFloatLayer().g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.f44713e.isFinishing()) {
                    return;
                }
                d.this.f44713e.getLoadingView().w();
            }
        }

        public d(SwanAppActivity swanAppActivity) {
            this.f44713e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a.this.f(this.f44713e, 150L));
            animatorSet.addListener(new C0821a());
            animatorSet.start();
            a.this.f44702a.add(animatorSet);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44716e;

        public e(a aVar, SwanAppActivity swanAppActivity) {
            this.f44716e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f44716e.isFinishing()) {
                return;
            }
            this.f44716e.getLoadingView().f45667a.setVisibility(8);
            this.f44716e.getLoadingView().J();
            this.f44716e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f44716e.isFinishing()) {
                return;
            }
            this.f44716e.getLoadingView().w();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45667a, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45670d, "translationX", -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45671e, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final AnimatorSet h(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45670d, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f45671e, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public final void i(SwanAppActivity swanAppActivity) {
        Handler i2 = d.a.l0.a.a2.d.i();
        b bVar = new b(swanAppActivity);
        i2.postDelayed(bVar, d.a.l0.a.r1.l.b.c());
        SwanAppSlaveManager.m1(new c(swanAppActivity, i2, bVar));
    }

    public final void j(SwanAppActivity swanAppActivity) {
        d.a.l0.a.w2.e loadingView;
        if (swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (d.a.l0.a.r1.l.b.d() != 1 && d.a.l0.a.r1.l.b.d() != 3) {
            loadingView.f45667a.setVisibility(8);
            if (!d.a.l0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f44702a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().g();
                return;
            }
            q0.X(new RunnableC0820a(swanAppActivity));
            return;
        }
        i(swanAppActivity);
    }

    public final void k(SwanAppActivity swanAppActivity) {
        q0.X(new d(swanAppActivity));
    }

    public void l(SwanAppActivity swanAppActivity) {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(d.a.l0.a.f.App_Launch_Circle_Animation_View);
        this.f44704c = swanAppLaunchCircleAnimationView;
        swanAppLaunchCircleAnimationView.h();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.l0.a.i2.a.d().i("first_anim_start");
    }

    public final void m(SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i2 = z ? 100 : 0;
        animatorSet.play(f(swanAppActivity, 150L));
        animatorSet.addListener(new e(this, swanAppActivity));
        animatorSet.setStartDelay(i2);
        animatorSet.start();
        this.f44702a.add(animatorSet);
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
        d.a.l0.a.i2.a.d().i("first_anim_start");
        this.f44702a.add(animatorSet);
    }

    public void p(SwanAppActivity swanAppActivity) {
        BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(d.a.l0.a.f.App_Launch_Shimmer_Animation_View);
        this.f44703b = bdShimmerView;
        if (bdShimmerView == null) {
            return;
        }
        bdShimmerView.setType(1);
        this.f44703b.o();
        h.o().C(new UbcFlowEvent("first_anim_start"));
        d.a.l0.a.i2.a.d().i("first_anim_start");
    }

    public void q() {
        for (AnimatorSet animatorSet : this.f44702a) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f44704c;
        if (swanAppLaunchCircleAnimationView != null) {
            swanAppLaunchCircleAnimationView.i();
        }
        BdShimmerView bdShimmerView = this.f44703b;
        if (bdShimmerView != null) {
            bdShimmerView.u();
        }
        this.f44702a.clear();
    }
}
