package d.a.o0.a.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.r1.h;
import d.a.o0.a.v2.n0;
import d.a.o0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f47832a;

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f47833b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f47834c;

    /* renamed from: d.a.o0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0897a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47836f;

        public RunnableC0897a(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47836f = aVar;
            this.f47835e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47835e.isFinishing()) {
                return;
            }
            if (this.f47836f.f47832a != null) {
                for (AnimatorSet animatorSet : this.f47836f.f47832a) {
                    animatorSet.cancel();
                }
            }
            this.f47835e.getFloatLayer().g();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47838f;

        public b(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47838f = aVar;
            this.f47837e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47838f.f47834c != null) {
                    this.f47838f.f47834c.setVisibility(4);
                    this.f47838f.f47834c.i();
                }
                if (this.f47838f.f47833b != null) {
                    this.f47838f.f47833b.u();
                }
                this.f47838f.k(this.f47837e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f47840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f47841c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f47842d;

        public c(a aVar, SwanAppActivity swanAppActivity, Handler handler, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity, handler, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47842d = aVar;
            this.f47839a = swanAppActivity;
            this.f47840b = handler;
            this.f47841c = runnable;
        }

        @Override // d.a.o0.a.t.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47842d.f47834c != null) {
                    this.f47842d.f47834c.setVisibility(4);
                    this.f47842d.f47834c.i();
                }
                if (this.f47842d.f47833b != null) {
                    this.f47842d.f47833b.u();
                }
                this.f47842d.k(this.f47839a);
                this.f47840b.removeCallbacks(this.f47841c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47844f;

        /* renamed from: d.a.o0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0898a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f47845e;

            public C0898a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47845e = dVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f47845e.f47843e.isFinishing()) {
                    return;
                }
                this.f47845e.f47843e.getLoadingView().f48797a.setVisibility(8);
                this.f47845e.f47843e.getLoadingView().J();
                this.f47845e.f47843e.getFloatLayer().g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f47845e.f47843e.isFinishing()) {
                    return;
                }
                this.f47845e.f47843e.getLoadingView().w();
            }
        }

        public d(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47844f = aVar;
            this.f47843e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.f47844f.f(this.f47843e, 150L));
                animatorSet.addListener(new C0898a(this));
                animatorSet.start();
                this.f47844f.f47832a.add(animatorSet);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f47846e;

        public e(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47846e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f47846e.isFinishing()) {
                return;
            }
            this.f47846e.getLoadingView().f48797a.setVisibility(8);
            this.f47846e.getLoadingView().J();
            this.f47846e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f47846e.isFinishing()) {
                return;
            }
            this.f47846e.getLoadingView().w();
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47832a = new CopyOnWriteArrayList();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, swanAppActivity, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f48797a, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (ObjectAnimator) invokeLJ.objValue;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f48800d, "translationX", -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(380L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f48801e, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
            ofFloat2.setDuration(380L);
            ofFloat2.setRepeatMode(2);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public final AnimatorSet h(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f48800d, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(240L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f48801e, "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(240L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public final void i(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, swanAppActivity) == null) {
            Handler i2 = d.a.o0.a.a2.d.i();
            b bVar = new b(this, swanAppActivity);
            i2.postDelayed(bVar, d.a.o0.a.r1.l.b.c());
            SwanAppSlaveManager.m1(new c(this, swanAppActivity, i2, bVar));
        }
    }

    public final void j(SwanAppActivity swanAppActivity) {
        d.a.o0.a.w2.e loadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (d.a.o0.a.r1.l.b.d() != 1 && d.a.o0.a.r1.l.b.d() != 3) {
            loadingView.f48797a.setVisibility(8);
            if (!d.a.o0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f47832a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().g();
                return;
            }
            q0.X(new RunnableC0897a(this, swanAppActivity));
            return;
        }
        i(swanAppActivity);
    }

    public final void k(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, swanAppActivity) == null) {
            q0.X(new d(this, swanAppActivity));
        }
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppActivity) == null) {
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(d.a.o0.a.f.App_Launch_Circle_Animation_View);
            this.f47834c = swanAppLaunchCircleAnimationView;
            swanAppLaunchCircleAnimationView.h();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            d.a.o0.a.i2.a.d().i("first_anim_start");
        }
    }

    public final void m(SwanAppActivity swanAppActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, swanAppActivity, z) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            int i2 = z ? 100 : 0;
            animatorSet.play(f(swanAppActivity, 150L));
            animatorSet.addListener(new e(this, swanAppActivity));
            animatorSet.setStartDelay(i2);
            animatorSet.start();
            this.f47832a.add(animatorSet);
        }
    }

    public void n(SwanAppActivity swanAppActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppActivity, i2) == null) {
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
    }

    public void o(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, swanAppActivity) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(h(swanAppActivity)).before(g(swanAppActivity));
            animatorSet.start();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            d.a.o0.a.i2.a.d().i("first_anim_start");
            this.f47832a.add(animatorSet);
        }
    }

    public void p(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppActivity) == null) {
            BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(d.a.o0.a.f.App_Launch_Shimmer_Animation_View);
            this.f47833b = bdShimmerView;
            if (bdShimmerView == null) {
                return;
            }
            bdShimmerView.setType(1);
            this.f47833b.o();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            d.a.o0.a.i2.a.d().i("first_anim_start");
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (AnimatorSet animatorSet : this.f47832a) {
                animatorSet.removeAllListeners();
                animatorSet.cancel();
            }
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f47834c;
            if (swanAppLaunchCircleAnimationView != null) {
                swanAppLaunchCircleAnimationView.i();
            }
            BdShimmerView bdShimmerView = this.f47833b;
            if (bdShimmerView != null) {
                bdShimmerView.u();
            }
            this.f47832a.clear();
        }
    }
}
